package com.facebook.events.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: change_passcode_from_login_flow */
public class BirthdayReminderLogger {
    private static volatile BirthdayReminderLogger f17771b;
    private final AnalyticsLogger f17772a;

    /* compiled from: change_passcode_from_login_flow */
    enum Event {
        BIRTHDAYS_EVENTS_DASHBOARD_ENTRY("birthday_events_dashboard_entry"),
        BIRTHDAYS_ENTRY("birthday_view_entry"),
        BIRTHDAYS_CLICK_COMPOSER_BUTTON("birthday_click_compose_button"),
        BIRTHDAYS_CLICK_SELFIE_CAM_BUTTON("birthday_click_selfie_cam_button"),
        BIRTHDAYS_CLICK_ROW("birthday_click_row"),
        BIRTHDAYS_FETCH_MORE_BIRTHDAYS("birthday_fetch_more_birthdays"),
        BIRTHDAYS_CLICK_SUGGESTED_PHOTO_BUTTON("birthday_click_suggested_photo_button");
        
        private final String name;

        private Event(String str) {
            this.name = str;
        }

        public final String getName() {
            return this.name;
        }
    }

    public static com.facebook.events.logging.BirthdayReminderLogger m18107a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17771b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.events.logging.BirthdayReminderLogger.class;
        monitor-enter(r1);
        r0 = f17771b;	 Catch:{ all -> 0x003a }
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
        r0 = m18110b(r0);	 Catch:{ all -> 0x0035 }
        f17771b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17771b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.logging.BirthdayReminderLogger.a(com.facebook.inject.InjectorLike):com.facebook.events.logging.BirthdayReminderLogger");
    }

    private static BirthdayReminderLogger m18110b(InjectorLike injectorLike) {
        return new BirthdayReminderLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BirthdayReminderLogger(AnalyticsLogger analyticsLogger) {
        this.f17772a = analyticsLogger;
    }

    public final String m18113a(boolean z, String str) {
        String uuid = SafeUUIDGenerator.a().toString();
        m18109a(new HoneyClientEvent(Event.BIRTHDAYS_CLICK_COMPOSER_BUTTON.getName()).b("extra_composer_internal_session_id", uuid).a("is_birthday_today", z), str);
        return uuid;
    }

    public final String m18112a(String str, boolean z) {
        return m18108a(Event.BIRTHDAYS_ENTRY, str, Boolean.valueOf(z));
    }

    public final String m18111a(String str) {
        return m18108a(Event.BIRTHDAYS_EVENTS_DASHBOARD_ENTRY, str, Boolean.valueOf(false));
    }

    public final void m18115b(boolean z, String str) {
        m18109a(new HoneyClientEvent(Event.BIRTHDAYS_CLICK_ROW.getName()).a("is_birthday_today", z), str);
    }

    public final void m18114b(String str) {
        m18109a(new HoneyClientEvent(Event.BIRTHDAYS_FETCH_MORE_BIRTHDAYS.getName()), str);
    }

    private String m18108a(Event event, String str, Boolean bool) {
        String uuid = SafeUUIDGenerator.a().toString();
        m18109a(new HoneyClientEvent(event.getName()).b("referrer", str).a("is_fetching_old_birthdays", bool), uuid);
        return uuid;
    }

    private void m18109a(HoneyClientEvent honeyClientEvent, String str) {
        honeyClientEvent.f = str;
        this.f17772a.a(honeyClientEvent);
    }
}
