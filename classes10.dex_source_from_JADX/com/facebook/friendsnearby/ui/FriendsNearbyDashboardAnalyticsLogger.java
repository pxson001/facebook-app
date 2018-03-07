package com.facebook.friendsnearby.ui;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: You can only show the progress bar for the me user */
public class FriendsNearbyDashboardAnalyticsLogger {
    private static volatile FriendsNearbyDashboardAnalyticsLogger f20815g;
    private final AnalyticsLogger f20816a;
    public final AwakeTimeSinceBootClock f20817b;
    public long f20818c;
    public ImpressionType f20819d = ImpressionType.UNKNOWN;
    public boolean f20820e;
    public boolean f20821f;

    /* compiled from: You can only show the progress bar for the me user */
    public enum ImpressionType {
        INVITE("invite"),
        LOCATION_DISABLED("location_instruction"),
        LOCATION_REQUIRED_NOT_WORKING("location_required_not_working"),
        FRIENDSLIST("friendslist"),
        UPSELL("upsell"),
        ERROR("error"),
        UNKNOWN("unknown");
        
        public final String name;

        private ImpressionType(String str) {
            this.name = str;
        }
    }

    public static com.facebook.friendsnearby.ui.FriendsNearbyDashboardAnalyticsLogger m21698a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20815g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.friendsnearby.ui.FriendsNearbyDashboardAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f20815g;	 Catch:{ all -> 0x003a }
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
        r0 = m21699b(r0);	 Catch:{ all -> 0x0035 }
        f20815g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20815g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.friendsnearby.ui.FriendsNearbyDashboardAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.friendsnearby.ui.FriendsNearbyDashboardAnalyticsLogger");
    }

    private static FriendsNearbyDashboardAnalyticsLogger m21699b(InjectorLike injectorLike) {
        return new FriendsNearbyDashboardAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FriendsNearbyDashboardAnalyticsLogger(AnalyticsLogger analyticsLogger, AwakeTimeSinceBootClock awakeTimeSinceBootClock) {
        this.f20816a = analyticsLogger;
        this.f20817b = awakeTimeSinceBootClock;
    }

    public final void m21704a(String str, boolean z) {
        HoneyClientEvent f = m21700f("friends_nearby_dashboard_timeline");
        f.b("targetID", str);
        f.a("useEntityCard", z);
        this.f20816a.a(f);
    }

    public final void m21706c() {
        this.f20816a.a(m21700f("friends_nearby_dashboard_selfview_feedback"));
    }

    public final void m21708d() {
        this.f20816a.a(m21700f("friends_nearby_dashboard_selfview_report_location"));
    }

    public final void m21710e() {
        this.f20816a.a(m21700f("friends_nearby_dashboard_selfview_report_name"));
    }

    public final void m21703a(String str) {
        HoneyClientEvent f = m21700f("friends_nearby_dashboard_ping");
        f.b("targetID", str);
        this.f20816a.a(f);
    }

    public final void m21712f() {
        this.f20816a.a(m21700f("friends_nearby_dashboard_settings"));
    }

    public final void m21701a(ImpressionType impressionType) {
        if (this.f20819d != impressionType) {
            this.f20819d = impressionType;
            HoneyClientEvent f = m21700f("friends_nearby_dashboard_impression");
            f.b("view", impressionType.name);
            this.f20816a.a(f);
        }
    }

    public final void m21713g() {
        if (this.f20819d != ImpressionType.UPSELL) {
            this.f20819d = ImpressionType.UPSELL;
            HoneyClientEvent f = m21700f("friends_nearby_dashboard_impression");
            f.b("view", ImpressionType.UPSELL.name);
            this.f20816a.a(f);
        }
    }

    public final void m21714h() {
        this.f20816a.a(m21700f("friends_nearby_dashboard_invite_empty"));
    }

    public final void m21715i() {
        this.f20816a.a(m21700f("friends_nearby_search_section_onetap_invite"));
    }

    public final void m21716j() {
        this.f20816a.a(m21700f("friends_nearby_search_section_onetap_undo"));
    }

    public final void m21705b(String str) {
        HoneyClientEvent f = m21700f("friends_nearby_dashboard_open");
        f.b("source", str);
        this.f20816a.a(f);
    }

    public final void m21717k() {
        this.f20816a.a(m21700f("friends_nearby_dashboard_inviteall"));
    }

    public final void m21718l() {
        this.f20816a.a(m21700f("friends_nearby_dashboard_search_open"));
    }

    public final void m21719m() {
        if (!this.f20820e) {
            this.f20816a.a(m21700f("friends_nearby_dashboard_search_type_during_session"));
            this.f20820e = true;
        }
    }

    public final void m21707c(String str) {
        HoneyClientEvent f = m21700f("friends_nearby_dashboard_section_expand");
        f.b("section_id", str);
        this.f20816a.a(f);
    }

    public final void m21720n() {
        if (!this.f20821f) {
            this.f20816a.a(m21700f("friends_nearby_dashboard_scroll_forward_during_session"));
            this.f20821f = true;
        }
    }

    public final void m21721o() {
        this.f20816a.a(m21700f("friends_nearby_dashboard_pull_to_refresh"));
    }

    public final void m21722p() {
        this.f20816a.a(m21700f("friends_nearby_dashboard_refresh_button"));
    }

    public final void m21723q() {
        this.f20816a.a(m21700f("friends_nearby_dashboard_upsell_turn_on"));
    }

    public final void m21702a(ImmutableSet<String> immutableSet) {
        HoneyClientEvent f = m21700f("friends_nearby_dashboard_map_impression");
        f.a("sender_ids", immutableSet);
        this.f20816a.a(f);
    }

    public final void m21709d(String str) {
        HoneyClientEvent f = m21700f("friends_nearby_dashboard_map_interaction");
        f.b("type", str);
        this.f20816a.a(f);
    }

    public final void m21711e(String str) {
        HoneyClientEvent f = m21700f("friends_nearby_ping_open_in_app");
        f.b("app", str);
        this.f20816a.a(f);
    }

    public final void m21724r() {
        this.f20816a.a(m21700f("friends_nearby_dashboard_map_expand"));
    }

    public final void m21725s() {
        this.f20816a.a(m21700f("friends_nearby_dashboard_map_contract"));
    }

    private HoneyClientEvent m21700f(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "background_location";
        return honeyClientEvent.a("session_id", this.f20818c);
    }
}
