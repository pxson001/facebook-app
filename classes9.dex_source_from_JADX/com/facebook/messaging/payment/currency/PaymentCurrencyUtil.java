package com.facebook.messaging.payment.currency;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.currency.DefaultCurrencyConfig;
import com.facebook.payments.model.CurrencyAmount;
import com.google.common.annotations.VisibleForTesting;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: instant_video */
public class PaymentCurrencyUtil {
    private static volatile PaymentCurrencyUtil f12840e;
    private final AbstractFbErrorReporter f12841a;
    private Locale f12842b = Locale.US;
    private Currency f12843c = Currency.getInstance(this.f12842b);
    private NumberFormat f12844d = NumberFormat.getCurrencyInstance(this.f12842b);

    public static com.facebook.messaging.payment.currency.PaymentCurrencyUtil m13192a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f12840e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.payment.currency.PaymentCurrencyUtil.class;
        monitor-enter(r1);
        r0 = f12840e;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m13195b(r0);	 Catch:{ all -> 0x0035 }
        f12840e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12840e;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.currency.PaymentCurrencyUtil.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.currency.PaymentCurrencyUtil");
    }

    private static PaymentCurrencyUtil m13195b(InjectorLike injectorLike) {
        return new PaymentCurrencyUtil((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public PaymentCurrencyUtil(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f12841a = abstractFbErrorReporter;
    }

    public final CurrencyAmount m13197a(int i, String str) {
        return new CurrencyAmount(str, m13200a(m13199a(CurrencyFormatType.CURRENCY_SYMBOL_AND_EMPTY_DECIMALS, i, str)));
    }

    public final String m13198a(CurrencyFormatType currencyFormatType, int i) {
        return m13193a(currencyFormatType, i, this.f12843c);
    }

    public final String m13199a(CurrencyFormatType currencyFormatType, int i, String str) {
        return m13193a(currencyFormatType, i, Currency.getInstance(str));
    }

    public final BigDecimal m13200a(String str) {
        return m13202a(str, this.f12843c);
    }

    public final BigDecimal m13201a(String str, String str2) {
        return m13202a(str, Currency.getInstance(str2));
    }

    public final BigDecimal m13202a(String str, Currency currency) {
        if (StringUtil.a(str) || str.equals(".")) {
            return BigDecimal.ZERO;
        }
        if (!str.contains(DefaultCurrencyConfig.a(currency.getCurrencyCode()))) {
            return new BigDecimal(m13196c(str));
        }
        this.f12844d.setCurrency(currency);
        try {
            return new BigDecimal(this.f12844d.parse(str).toString());
        } catch (Throwable e) {
            this.f12841a.a("PaymentStringParsingError", "Error when parsing numeric payment amount to double", e);
            throw new NumberFormatException("Unparseable number: \"" + str + "\"");
        }
    }

    public final int m13203b(String str) {
        return m13191a(m13202a(str, this.f12843c), this.f12843c);
    }

    public final int m13204b(String str, String str2) {
        return m13191a(m13202a(str, Currency.getInstance(str2)), Currency.getInstance(str2));
    }

    @VisibleForTesting
    private String m13193a(CurrencyFormatType currencyFormatType, int i, Currency currency) {
        Object obj;
        int i2 = 100;
        int i3 = i % i2 == 0 ? 1 : 0;
        this.f12844d.setCurrency(currency);
        if (i3 == 0 || !(currencyFormatType == CurrencyFormatType.NO_EMPTY_DECIMALS || currencyFormatType == CurrencyFormatType.NO_CURRENCY_SYMBOL_OR_EMPTY_DECIMALS)) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            m13194a(this.f12844d, 0);
        } else {
            m13194a(this.f12844d, currency.getDefaultFractionDigits());
        }
        String format = this.f12844d.format(((double) i) / ((double) i2));
        if (currencyFormatType == CurrencyFormatType.NO_CURRENCY_SYMBOL || currencyFormatType == CurrencyFormatType.NO_CURRENCY_SYMBOL_OR_EMPTY_DECIMALS) {
            obj = 1;
        } else {
            obj = null;
        }
        return obj != null ? format.replace(currency.getSymbol(), "").replace(" ", "").trim() : format;
    }

    private int m13191a(BigDecimal bigDecimal, Currency currency) {
        return new BigDecimal(100).multiply(bigDecimal).intValue();
    }

    private static void m13194a(NumberFormat numberFormat, int i) {
        numberFormat.setMinimumFractionDigits(i);
        numberFormat.setMaximumFractionDigits(i);
    }

    private static String m13196c(String str) {
        return str.replaceFirst(",", "");
    }
}
