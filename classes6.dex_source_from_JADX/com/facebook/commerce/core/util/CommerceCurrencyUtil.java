package com.facebook.commerce.core.util;

import android.content.Context;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.ProductItemPriceFieldsModel;
import com.facebook.common.util.FinanceUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.app.module.LocaleMethodAutoProvider;
import com.facebook.payments.currency.CurrencyConfig;
import com.facebook.payments.currency.DefaultCurrencyConfig;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: predefined_option */
public class CommerceCurrencyUtil {
    private static final String f7553a = CommerceCurrencyUtil.class.getSimpleName();
    private final Locale f7554b;
    private final Context f7555c;

    public static CommerceCurrencyUtil m10671b(InjectorLike injectorLike) {
        return new CommerceCurrencyUtil(LocaleMethodAutoProvider.b(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public CommerceCurrencyUtil(Locale locale, Context context) {
        this.f7554b = locale;
        this.f7555c = context;
    }

    public static CommerceCurrencyUtil m10667a(InjectorLike injectorLike) {
        return m10671b(injectorLike);
    }

    public final ImmutableList<String> m10675a() {
        String b = m10672b();
        ImmutableList<String> a = CurrencyConfig.m19187a(this.f7555c);
        if (b == null) {
            return a;
        }
        Builder builder = ImmutableList.builder();
        builder.c(b);
        int size = a.size();
        for (int i = 0; i < size; i++) {
            String str = (String) a.get(i);
            if (!b.equals(str)) {
                builder.c(str);
            }
        }
        return builder.b();
    }

    @Nullable
    public static String m10668a(ProductItemPriceFieldsModel productItemPriceFieldsModel) {
        if (productItemPriceFieldsModel == null) {
            return null;
        }
        return m10669a(productItemPriceFieldsModel.m10619b(), productItemPriceFieldsModel.m10615a());
    }

    @Nullable
    public final String m10676a(String str) {
        try {
            return CurrencyConfig.m19188a(this.f7555c, str);
        } catch (Throwable e) {
            BLog.a(f7553a, "currency not supported", e);
            return null;
        }
    }

    @Nullable
    private String m10672b() {
        try {
            return Currency.getInstance(this.f7554b).getCurrencyCode();
        } catch (Throwable e) {
            BLog.a(f7553a, "locale not supported ", e);
            return null;
        }
    }

    @Nullable
    public static Currency m10673b(String str) {
        try {
            return Currency.getInstance(str);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @Nullable
    public final ProductItemPriceFieldsModel m10674a(Currency currency, String str) {
        ImmutableMap immutableMap = (ImmutableMap) DefaultCurrencyConfig.m19190b().get(currency.getCurrencyCode());
        if (immutableMap == null) {
            return null;
        }
        BigDecimal a = m10670a(currency, str, immutableMap);
        if (a == null) {
            return null;
        }
        try {
            long longValue = a.multiply(new BigDecimal(100)).setScale(0).longValue();
            if (longValue >= 2147483647L) {
                BLog.b(CommerceCurrencyUtil.class, "Price causes integer overflow: %d", new Object[]{Long.valueOf(longValue)});
                return null;
            }
            return new ProductItemPriceFieldsModel.Builder().m10610a(currency.getCurrencyCode()).m10609a((int) longValue).m10611a();
        } catch (Throwable e) {
            BLog.b(CommerceCurrencyUtil.class, "Can't convert from BigDecimal to Integer", e);
            return null;
        }
    }

    @Nullable
    private BigDecimal m10670a(Currency currency, String str, ImmutableMap<String, String> immutableMap) {
        if (StringUtil.a(str)) {
            return null;
        }
        String str2;
        int a = m10666a((ImmutableMap) immutableMap);
        String replace = str.toUpperCase(Locale.US).replace(currency.getCurrencyCode(), "");
        Object symbol = currency.getSymbol(this.f7554b);
        if (StringUtil.a(symbol)) {
            str2 = replace;
        } else {
            str2 = replace.replace(symbol.toUpperCase(Locale.US), "");
        }
        replace = (String) immutableMap.get("symbol");
        if (!StringUtil.a(replace)) {
            str2 = str2.replace(replace.toUpperCase(Locale.US), "");
        }
        replace = str2.replaceAll("\\s", "");
        NumberFormat numberInstance = NumberFormat.getNumberInstance(this.f7554b);
        numberInstance.setCurrency(currency);
        try {
            return new BigDecimal(numberInstance.parse(replace).doubleValue()).setScale(a, RoundingMode.HALF_UP);
        } catch (Throwable e) {
            BLog.b(f7553a, e, "Could not parse input: %s", new Object[]{str});
            return null;
        }
    }

    private static int m10666a(ImmutableMap<String, String> immutableMap) {
        Preconditions.checkArgument(immutableMap.containsKey("offset"));
        return m10665a(Integer.parseInt((String) immutableMap.get("offset")));
    }

    private static int m10665a(int i) {
        switch (i) {
            case 1:
                return 0;
            case 100:
                return 2;
            case 1000:
                return 3;
            case 10000:
                return 4;
            default:
                throw new IllegalArgumentException("Invalid offset value: " + i + ". Supported are [1,100,1000,10000]");
        }
    }

    @Nullable
    public static String m10669a(String str, int i) {
        ImmutableMap immutableMap = (ImmutableMap) DefaultCurrencyConfig.f12289b.get(str.toUpperCase(Locale.US));
        return FinanceUtils.a(str, (long) i, immutableMap != null ? m10666a(immutableMap) : 2);
    }
}
