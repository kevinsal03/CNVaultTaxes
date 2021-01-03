package me.kevsal.minecraft.cnvaulttaxes;

import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class TaxUtilities {

    private static Economy economy;

    public static double collectTax(OfflinePlayer player, double amount) {
        Player onlinePlayer = Bukkit.getPlayer(player.getUniqueId());
        double taxRate = getTaxRate(player, amount);
        if (onlinePlayer != null) {
            if (taxRate != 0 ) {
                onlinePlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aYou were taxed at &c" + taxRate*100 + "%&a on a transaction of &c" + amount+ "&a."));
            }
        }
        return amount - (amount * taxRate);
    }

    @Deprecated
    public static double collectTax(String playerName, double amount) {
        OfflinePlayer player = Bukkit.getOfflinePlayer(playerName);
        return collectTax(player, amount);
    }

    public static double getTaxRate(OfflinePlayer player, double amountToAdd) {
        setEcon();
        double balance = economy.getBalance(player) + amountToAdd;
        double taxRate = (((balance - 4500) / 500)) / 100;
        taxRate = Double.parseDouble(formatDouble(taxRate));
        if (taxRate > 0.9) {
            // Max tax rate = 90%
            return 0.9;
        } else if (taxRate < 0) {
            // Do not allow negative taxes
            return 0;
        } else {
            return taxRate;
        }
    }

    public static double getTaxRate(OfflinePlayer player) {
        return getTaxRate(player, 0.0);
    }

    private static void setEcon() {
        if (economy == null) {
            if (VaultTaxes.getEconomy().isPresent()) {
                economy = VaultTaxes.getEconomy().get();
            } else {
                throw new RuntimeException("Unable to get Economy!");
            }
        }
    }

    private static String formatDouble(double d) {
        DecimalFormat decimalFormatter = new DecimalFormat("#.##");
        decimalFormatter.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormatter.format(d);
    }

}
