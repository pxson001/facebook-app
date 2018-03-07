package com.facebook.adspayments.model;

import com.facebook.adspayments.utils.AdsPaymentsPreconditions;
import com.google.common.base.Predicates;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* compiled from: UTF-8 not supported? */
public enum BrazilianTaxIdType {
    CNPJ,
    CPF;
    
    private static final Pattern REGEX = null;

    static {
        REGEX = Pattern.compile("[0-9]+");
    }

    public static BrazilianTaxIdType ofTaxId(String str) {
        return (BrazilianTaxIdType) AdsPaymentsPreconditions.m25753a(ofTaxIdOrNull(str), Predicates.notNull(), "Brazilian Tax Id can only have 11 or 14 digits, with '-', '.', and '/'", new Object[0]);
    }

    @Nullable
    public static BrazilianTaxIdType ofTaxIdOrNull(String str) {
        Object replaceAll = str.replaceAll("[\\-\\./]", "");
        if (!REGEX.matcher(replaceAll).matches()) {
            return null;
        }
        switch (replaceAll.length()) {
            case 11:
                return CPF;
            case 14:
                return CNPJ;
            default:
                return null;
        }
    }
}
