package me.kevsal.minecraft.cnvaulttaxes.commands;

import me.kevsal.minecraft.cnvaulttaxes.TaxUtilities;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetTaxRate implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Must be player");
        } else {
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aYou are currently taxed at &c"
                    + TaxUtilities.getTaxRate((OfflinePlayer) commandSender)*100 + "%&a." ));
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&aTaxes are applied to the new balance on (most) incoming transactions."));
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&cUsing multiple accounts to bypass taxes will result in punishment. Report this behavior to staff."));
        }
        return true;
    }
}
