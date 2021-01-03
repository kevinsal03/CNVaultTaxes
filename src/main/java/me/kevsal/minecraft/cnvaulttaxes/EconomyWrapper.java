package me.kevsal.minecraft.cnvaulttaxes;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.OfflinePlayer;

import java.util.List;

public class EconomyWrapper implements Economy {

    private final Economy wrappedEco;

    public EconomyWrapper(Economy original) {
        super();
        wrappedEco = original;
    }

    @Override
    public boolean isEnabled() {
        return wrappedEco.isEnabled();
    }

    @Override
    public String getName() {
        return wrappedEco.getName();
    }

    @Override
    public boolean hasBankSupport() {
        return wrappedEco.hasBankSupport();
    }

    @Override
    public int fractionalDigits() {
        return wrappedEco.fractionalDigits();
    }

    @Override
    public String format(double v) {
        return wrappedEco.format(v);
    }

    @Override
    public String currencyNamePlural() {
        return wrappedEco.currencyNamePlural();
    }

    @Override
    public String currencyNameSingular() {
        return wrappedEco.currencyNameSingular();
    }

    @Override
    @Deprecated
    public boolean hasAccount(String s) {
        return wrappedEco.hasAccount(s);
    }

    @Override
    public boolean hasAccount(OfflinePlayer offlinePlayer) {
        return wrappedEco.hasAccount(offlinePlayer);
    }

    @Override
    @Deprecated
    public boolean hasAccount(String s, String s1) {
        return wrappedEco.hasAccount(s, s1);
    }

    @Override
    public boolean hasAccount(OfflinePlayer offlinePlayer, String s) {
        return wrappedEco.hasAccount(offlinePlayer, s);
    }

    @Override
    @Deprecated
    public double getBalance(String s) {
        return wrappedEco.getBalance(s);
    }

    @Override
    public double getBalance(OfflinePlayer offlinePlayer) {
        return wrappedEco.getBalance(offlinePlayer);
    }

    @Override
    @Deprecated
    public double getBalance(String s, String s1) {
        return wrappedEco.getBalance(s, s1);
    }

    @Override
    public double getBalance(OfflinePlayer offlinePlayer, String s) {
        return wrappedEco.getBalance(offlinePlayer, s);
    }

    @Override
    @Deprecated
    public boolean has(String s, double v) {
        return wrappedEco.has(s, v);
    }

    @Override
    public boolean has(OfflinePlayer offlinePlayer, double v) {
        return wrappedEco.has(offlinePlayer, v);
    }

    @Override
    @Deprecated
    public boolean has(String s, String s1, double v) {
        return wrappedEco.has(s, s1, v);
    }

    @Override
    public boolean has(OfflinePlayer offlinePlayer, String s, double v) {
        return wrappedEco.has(offlinePlayer, s, v);
    }

    @Override
    @Deprecated
    public EconomyResponse withdrawPlayer(String s, double v) {
        return wrappedEco.withdrawPlayer(s, v);
    }

    @Override
    public EconomyResponse withdrawPlayer(OfflinePlayer offlinePlayer, double v) {
        return wrappedEco.withdrawPlayer(offlinePlayer, v);
    }

    @Override
    @Deprecated
    public EconomyResponse withdrawPlayer(String s, String s1, double v) {
        return wrappedEco.withdrawPlayer(s, s1, v);
    }

    @Override
    public EconomyResponse withdrawPlayer(OfflinePlayer offlinePlayer, String s, double v) {
        return wrappedEco.withdrawPlayer(offlinePlayer, s, v);
    }

    @Override
    @Deprecated
    public EconomyResponse depositPlayer(String s, double v) {
        return wrappedEco.depositPlayer(s, TaxUtilities.collectTax(s, v));
    }

    @Override
    public EconomyResponse depositPlayer(OfflinePlayer offlinePlayer, double v) {
        return wrappedEco.depositPlayer(offlinePlayer, TaxUtilities.collectTax(offlinePlayer, v));
    }

    @Override
    @Deprecated
    public EconomyResponse depositPlayer(String s, String s1, double v) {
        return wrappedEco.depositPlayer(s, s1, TaxUtilities.collectTax(s, v));
    }

    @Override
    public EconomyResponse depositPlayer(OfflinePlayer offlinePlayer, String s, double v) {
        return wrappedEco.depositPlayer(offlinePlayer, s, TaxUtilities.collectTax(offlinePlayer, v));
    }

    @Override
    @Deprecated
    public EconomyResponse createBank(String s, String s1) {
        return wrappedEco.createBank(s, s1);
    }

    @Override
    public EconomyResponse createBank(String s, OfflinePlayer offlinePlayer) {
        return wrappedEco.createBank(s, offlinePlayer);
    }

    @Override
    public EconomyResponse deleteBank(String s) {
        return wrappedEco.deleteBank(s);
    }

    @Override
    public EconomyResponse bankBalance(String s) {
        return wrappedEco.bankBalance(s);
    }

    @Override
    public EconomyResponse bankHas(String s, double v) {
        return wrappedEco.bankHas(s, v);
    }

    @Override
    public EconomyResponse bankWithdraw(String s, double v) {
        return wrappedEco.bankWithdraw(s, v);
    }

    @Override
    public EconomyResponse bankDeposit(String s, double v) {
        return wrappedEco.bankDeposit(s, v);
    }

    @Override
    @Deprecated
    public EconomyResponse isBankOwner(String s, String s1) {
        return wrappedEco.isBankOwner(s, s1);
    }

    @Override
    public EconomyResponse isBankOwner(String s, OfflinePlayer offlinePlayer) {
        return wrappedEco.isBankOwner(s, offlinePlayer);
    }

    @Override
    @Deprecated
    public EconomyResponse isBankMember(String s, String s1) {
        return wrappedEco.isBankMember(s, s1);
    }

    @Override
    public EconomyResponse isBankMember(String s, OfflinePlayer offlinePlayer) {
        return wrappedEco.isBankMember(s, offlinePlayer);
    }

    @Override
    public List<String> getBanks() {
        return wrappedEco.getBanks();
    }

    @Override
    @Deprecated
    public boolean createPlayerAccount(String s) {
        return wrappedEco.createPlayerAccount(s);
    }

    @Override
    public boolean createPlayerAccount(OfflinePlayer offlinePlayer) {
        return wrappedEco.createPlayerAccount(offlinePlayer);
    }

    @Override
    @Deprecated
    public boolean createPlayerAccount(String s, String s1) {
        return wrappedEco.createPlayerAccount(s, s1);
    }

    @Override
    public boolean createPlayerAccount(OfflinePlayer offlinePlayer, String s) {
        return wrappedEco.createPlayerAccount(offlinePlayer, s);
    }
}
