package me.kevsal.minecraft.cnvaulttaxes;

import me.kevsal.minecraft.cnvaulttaxes.commands.GetTaxRate;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Optional;

public class VaultTaxes extends JavaPlugin {

    // Code heavily inspired by @Rsl1122/Vault-Events

    private static VaultTaxes instance;

    @Override
    public void onEnable() {
        wrapEconomy();
        instance = this;
        this.getCommand("taxes").setExecutor(new GetTaxRate());
    }

    @Override
    public void onDisable() {
        getLogger().info("VaultTaxes disabled, taxes will no longer be applied!");
    }


    private void onServerDoneLoad() {
        getServer().getScheduler().runTaskLater(this, this::wrapEconomy, 0);
    }

    private void wrapEconomy() {
        Optional<Economy> optionalEconomy = getEconomy();
        Economy economy;
        if(optionalEconomy.isPresent()) {
            economy = optionalEconomy.get();
        } else {
            getLogger().warning("No existing economy found!");
            this.setEnabled(false);
            return;
        }
        Economy wrappedEco = economy instanceof EconomyWrapper ? economy : new EconomyWrapper(economy);
        getServer().getServicesManager().register(Economy.class, wrappedEco, this, ServicePriority.Highest);
        getLogger().info("Economy Wrapped. Taxes enabled.");
    }

    public static Optional<Economy> getEconomy() {
        ServicesManager services = Bukkit.getServer().getServicesManager();
        RegisteredServiceProvider<Economy> economyService = services.getRegistration(Economy.class);
        if (economyService == null) return Optional.empty();
        Economy economy = economyService.getProvider();
        return Optional.ofNullable(economy);
    }

    public static VaultTaxes getInstance() {
        return instance;
    }

}
