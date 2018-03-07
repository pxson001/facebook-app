package com.facebook.events.dateformatter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.annotations.VisibleForTesting;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: camera already initialized */
public class EventsCardViewTimeFormatUtil {
    private static volatile EventsCardViewTimeFormatUtil f17883l;
    private DateFormat f17884a;
    private DateFormat f17885b;
    private TimeZone f17886c;
    private DateFormat f17887d;
    private DateFormat f17888e;
    private String f17889f;
    private String f17890g;
    private String f17891h;
    private String f17892i;
    private String f17893j;
    private int f17894k;

    /* compiled from: camera already initialized */
    public class C15101 extends BroadcastReceiver {
        final /* synthetic */ EventsCardViewTimeFormatUtil f17882a;

        public C15101(EventsCardViewTimeFormatUtil eventsCardViewTimeFormatUtil) {
            this.f17882a = eventsCardViewTimeFormatUtil;
        }

        public void onReceive(Context context, Intent intent) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1984374766);
            EventsCardViewTimeFormatUtil.m21742b(this.f17882a, context);
            LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1184110856, a);
        }
    }

    public static com.facebook.events.dateformatter.EventsCardViewTimeFormatUtil m21739a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17883l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.events.dateformatter.EventsCardViewTimeFormatUtil.class;
        monitor-enter(r1);
        r0 = f17883l;	 Catch:{ all -> 0x003a }
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
        r0 = m21741b(r0);	 Catch:{ all -> 0x0035 }
        f17883l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17883l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.dateformatter.EventsCardViewTimeFormatUtil.a(com.facebook.inject.InjectorLike):com.facebook.events.dateformatter.EventsCardViewTimeFormatUtil");
    }

    private static EventsCardViewTimeFormatUtil m21741b(InjectorLike injectorLike) {
        return new EventsCardViewTimeFormatUtil(IdBasedProvider.a(injectorLike, 4483), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public EventsCardViewTimeFormatUtil(Provider<Locale> provider, Context context) {
        this((Locale) provider.get(), TimeZone.getDefault(), EventsDateFormatBuilder.b, EventsDateFormatBuilder.a, EventsDateFormatBuilder.c, context);
    }

    @VisibleForTesting
    private EventsCardViewTimeFormatUtil(Locale locale, TimeZone timeZone, String str, String str2, String str3, Context context) {
        EventsDateFormatBuilder.a(str, str2, str3);
        m21740a(locale, timeZone, context);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        context.registerReceiver(new C15101(this), intentFilter);
    }

    public static void m21742b(EventsCardViewTimeFormatUtil eventsCardViewTimeFormatUtil, Context context) {
        eventsCardViewTimeFormatUtil.m21740a(Locale.getDefault(), TimeZone.getDefault(), context);
    }

    private void m21740a(Locale locale, TimeZone timeZone, Context context) {
        this.f17886c = timeZone;
        this.f17889f = context.getString(2131239072);
        this.f17890g = context.getString(2131239073);
        this.f17891h = context.getString(2131233728);
        this.f17892i = context.getString(2131239076);
        this.f17893j = context.getString(2131239077);
        DateFormat simpleDateFormat = new SimpleDateFormat(EventsDateFormatBuilder.b, locale);
        simpleDateFormat.setTimeZone(timeZone);
        this.f17887d = simpleDateFormat;
        this.f17888e = EventsDateFormatBuilder.a(locale, timeZone);
        if (android.text.format.DateFormat.is24HourFormat(context)) {
            simpleDateFormat = new SimpleDateFormat("HH:mm", locale);
        } else {
            simpleDateFormat = new SimpleDateFormat("h:mm a", locale);
        }
        simpleDateFormat.setTimeZone(timeZone);
        this.f17884a = simpleDateFormat;
        if (android.text.format.DateFormat.is24HourFormat(context)) {
            simpleDateFormat = new SimpleDateFormat("HH:mm", locale);
        } else {
            simpleDateFormat = new SimpleDateFormat("h a", locale);
        }
        simpleDateFormat.setTimeZone(timeZone);
        this.f17885b = simpleDateFormat;
        if (Locale.US.equals(locale)) {
            this.f17894k = 1;
        } else {
            this.f17894k = Calendar.getInstance().getFirstDayOfWeek() - 1;
        }
    }
}
