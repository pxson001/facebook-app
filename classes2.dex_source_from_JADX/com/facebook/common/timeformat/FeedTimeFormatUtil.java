package com.facebook.common.timeformat;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.i18n.BasicDateTimeFormat;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.time.TimeConversions;
import com.facebook.common.timeformat.DefaultTimeFormatUtil.RelativeTimePeriod;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.resources.utils.ResourceUtils;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: image_cache_state */
public class FeedTimeFormatUtil implements TimeFormatUtil {
    private static volatile FeedTimeFormatUtil f20457g;
    private final Resources f20458a;
    private final Clock f20459b;
    private final BasicDateTimeFormat f20460c;
    private final DefaultTimeFormatUtil f20461d;
    private final Provider<TimeZone> f20462e;
    private final Provider<Locale> f20463f;

    /* compiled from: image_cache_state */
    /* synthetic */ class C08741 {
        static final /* synthetic */ int[] f21913a = new int[TimeFormatStyle.values().length];
        static final /* synthetic */ int[] f21914b = new int[RelativeTimePeriod.values().length];

        static {
            try {
                f21914b[RelativeTimePeriod.LESS_THAN_MIN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f21914b[RelativeTimePeriod.LESS_THAN_5_MINS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f21914b[RelativeTimePeriod.LESS_THAN_HOUR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f21914b[RelativeTimePeriod.SAME_DAY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f21914b[RelativeTimePeriod.LESS_THAN_ONE_DAY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f21914b[RelativeTimePeriod.LESS_THAN_4_DAYS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f21914b[RelativeTimePeriod.SAME_YEAR.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f21913a[TimeFormatStyle.STREAM_RELATIVE_STYLE.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    public static com.facebook.common.timeformat.FeedTimeFormatUtil m28196a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20457g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.timeformat.FeedTimeFormatUtil.class;
        monitor-enter(r1);
        r0 = f20457g;	 Catch:{ all -> 0x003a }
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
        r0 = m28198b(r0);	 Catch:{ all -> 0x0035 }
        f20457g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20457g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.timeformat.FeedTimeFormatUtil.a(com.facebook.inject.InjectorLike):com.facebook.common.timeformat.FeedTimeFormatUtil");
    }

    private static FeedTimeFormatUtil m28198b(InjectorLike injectorLike) {
        return new FeedTimeFormatUtil((Context) injectorLike.getInstance(Context.class), SystemClockMethodAutoProvider.m1498a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4486), IdBasedProvider.m1811a(injectorLike, 4483), DefaultTimeFormatUtil.m11785a(injectorLike), BasicDateTimeFormat.m11815a(injectorLike));
    }

    @Inject
    public FeedTimeFormatUtil(Context context, Clock clock, Provider<TimeZone> provider, Provider<Locale> provider2, DefaultTimeFormatUtil defaultTimeFormatUtil, BasicDateTimeFormat basicDateTimeFormat) {
        this.f20461d = defaultTimeFormatUtil;
        this.f20458a = context.getResources();
        this.f20463f = provider2;
        this.f20459b = clock;
        this.f20462e = provider;
        this.f20460c = basicDateTimeFormat;
    }

    public final String mo1649a(TimeFormatStyle timeFormatStyle, long j) {
        switch (C08741.f21913a[timeFormatStyle.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return m28197a(j);
            default:
                return this.f20461d.mo1649a(timeFormatStyle, j);
        }
    }

    private String m28197a(long j) {
        long a = this.f20459b.mo211a() - j;
        switch (C08741.f21914b[this.f20461d.m11810b(j).ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return this.f20458a.getString(2131233743);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
                return ResourceUtils.m29971a(this.f20458a, 2131233737, 2131233738, (int) TimeConversions.m11970d(a));
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return ResourceUtils.m29971a(this.f20458a, 2131233732, 2131233734, (int) TimeConversions.m11967a(a));
            case 5:
                return m28199b(j);
            case 6:
                return m28199b(j);
            case 7:
                return m28199b(j);
            default:
                return this.f20458a.getString(2131233726, new Object[]{this.f20460c.m11825h().format(Long.valueOf(j)), m28200c(j)});
        }
    }

    private String m28199b(long j) {
        return this.f20458a.getString(2131233726, new Object[]{this.f20460c.m11824g().format(Long.valueOf(j)), m28200c(j)});
    }

    private String m28200c(long j) {
        DateFormat a = this.f20460c.m11818a();
        a.setTimeZone((TimeZone) this.f20462e.get());
        return a.format(Long.valueOf(j)).toLowerCase((Locale) this.f20463f.get()).replaceAll(" ", "");
    }
}
