package com.facebook.common.numbers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.collect.ImmutableSet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: send_page_like_invite */
public class NumberTruncationUtil {
    private static volatile NumberTruncationUtil f5613k;
    private final Context f5614a;
    private final Set<Locale> f5615b = ImmutableSet.of(new Locale("zh"), new Locale("ja"), new Locale("ko"));
    private final Set<Locale> f5616c = ImmutableSet.of(new Locale("en"));
    private final Set<Locale> f5617d = ImmutableSet.of(new Locale("pt", "PT"));
    private final Set<Locale> f5618e = ImmutableSet.of(new Locale("es", "ES"), new Locale("pt", "PT"));
    private int f5619f;
    private int f5620g;
    private int f5621h;
    private Locale f5622i;
    private DecimalFormat f5623j;

    /* compiled from: send_page_like_invite */
    class C02621 implements ActionReceiver {
        final /* synthetic */ NumberTruncationUtil f5624a;

        C02621(NumberTruncationUtil numberTruncationUtil) {
            this.f5624a = numberTruncationUtil;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 849001878);
            NumberTruncationUtil.m9616a(this.f5624a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -539305911, a);
        }
    }

    public static com.facebook.common.numbers.NumberTruncationUtil m9609a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f5613k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.numbers.NumberTruncationUtil.class;
        monitor-enter(r1);
        r0 = f5613k;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m9618b(r0);	 Catch:{ all -> 0x0035 }
        f5613k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5613k;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.numbers.NumberTruncationUtil.a(com.facebook.inject.InjectorLike):com.facebook.common.numbers.NumberTruncationUtil");
    }

    private static NumberTruncationUtil m9618b(InjectorLike injectorLike) {
        return new NumberTruncationUtil((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public NumberTruncationUtil(Context context) {
        this.f5614a = context;
        m9616a(this);
        this.f5614a.registerReceiver(new DynamicSecureBroadcastReceiver("android.intent.action.LOCALE_CHANGED", new C02621(this)), new IntentFilter("android.intent.action.LOCALE_CHANGED"));
    }

    public static void m9616a(NumberTruncationUtil numberTruncationUtil) {
        numberTruncationUtil.f5622i = Locale.getDefault();
        numberTruncationUtil.f5623j = new DecimalFormat();
        if (numberTruncationUtil.m9620b()) {
            numberTruncationUtil.f5619f = 10000;
            numberTruncationUtil.f5620g = 4;
            numberTruncationUtil.f5621h = 8;
            return;
        }
        numberTruncationUtil.f5619f = 1000;
        numberTruncationUtil.f5620g = 3;
        numberTruncationUtil.f5621h = 9;
    }

    public final String m9623a(int i) {
        return m9624a(i, 1);
    }

    public final String m9624a(int i, int i2) {
        return m9612a(i, Integer.valueOf(0), i2);
    }

    public final String m9622a(double d, NumberFormat numberFormat) {
        return m9610a(d, Integer.valueOf(0), numberFormat);
    }

    private String m9612a(int i, Integer num, int i2) {
        if (i >= this.f5619f) {
            int a = m9608a((double) i);
            String a2 = m9615a(m9611a(i, a, i2), num, a);
            if (a2 != null) {
                return a2;
            }
        }
        return this.f5623j.format((long) i);
    }

    private String m9610a(double d, Integer num, NumberFormat numberFormat) {
        if (d >= ((double) this.f5619f)) {
            int a = m9608a(d);
            String a2 = m9615a(numberFormat.format(d / Math.pow(10.0d, (double) a)), num, a);
            if (a2 != null) {
                return a2;
            }
        }
        return numberFormat.format(d);
    }

    private String m9615a(String str, Integer num, int i) {
        switch (num.intValue()) {
            case 0:
                return m9619b(str, i);
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return m9614a(str, i);
            default:
                return null;
        }
    }

    private int m9608a(double d) {
        int i = 0;
        int i2 = 1;
        while (this.f5620g + i <= this.f5621h) {
            i2 *= this.f5619f;
            if (((double) i2) > d) {
                break;
            }
            i += this.f5620g;
        }
        return i;
    }

    private String m9611a(int i, int i2, int i3) {
        if (i2 > i3) {
            i = (int) Math.floor(((double) i) / Math.pow(10.0d, (double) (i2 - i3)));
        } else {
            i3 = i2;
        }
        int pow = (int) (((double) i) / Math.pow(10.0d, (double) i3));
        int pow2 = (int) (((double) i) % Math.pow(10.0d, (double) i3));
        if (pow >= 10 || pow2 == 0) {
            return this.f5623j.format((long) pow);
        }
        return this.f5623j.format((long) pow) + this.f5623j.getDecimalFormatSymbols().getDecimalSeparator() + Integer.toString(pow2);
    }

    private String m9614a(String str, int i) {
        switch (i) {
            case 3:
                return m9613a(2131689636, str);
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return this.f5614a.getString(2131235903, new Object[]{str});
            case 6:
                return m9613a(2131689637, str);
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return this.f5614a.getString(2131235904, new Object[]{str});
            case 9:
                return m9613a(2131689638, str);
            default:
                throw new RuntimeException("Invalid multiplier: " + i);
        }
    }

    private String m9619b(String str, int i) {
        if (!m9621b(i)) {
            return null;
        }
        switch (i) {
            case 3:
                return this.f5614a.getString(2131235898, new Object[]{str});
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return this.f5614a.getString(2131235899, new Object[]{str});
            case 6:
                return this.f5614a.getString(2131235900, new Object[]{str});
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return this.f5614a.getString(2131235901, new Object[]{str});
            case 9:
                return this.f5614a.getString(2131235902, new Object[]{str});
            default:
                throw new RuntimeException("Invalid multiplier: " + i);
        }
    }

    private String m9613a(int i, String str) {
        int ceil = (int) Math.ceil(Double.parseDouble(str));
        return this.f5614a.getResources().getQuantityString(i, ceil, new Object[]{str});
    }

    private boolean m9621b(int i) {
        switch (i) {
            case 3:
                return m9617a(this.f5616c);
            case 6:
                if (m9617a(this.f5617d)) {
                    return false;
                }
                return true;
            case 9:
                return !m9617a(this.f5618e);
            default:
                return true;
        }
    }

    private boolean m9617a(Set<Locale> set) {
        for (Locale locale : set) {
            boolean equals;
            if (locale.getCountry().length() != 0) {
                equals = this.f5622i.getCountry().equals(locale.getCountry());
            } else {
                equals = true;
            }
            if (equals && this.f5622i.getLanguage().equals(locale.getLanguage())) {
                return true;
            }
        }
        return false;
    }

    private boolean m9620b() {
        return m9617a(this.f5615b);
    }
}
