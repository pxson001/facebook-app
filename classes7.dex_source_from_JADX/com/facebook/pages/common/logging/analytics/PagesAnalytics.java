package com.facebook.pages.common.logging.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.graphql.enums.GraphQLPageCallToActionRef;
import com.facebook.graphql.enums.GraphQLPageCallToActionType;
import com.facebook.graphql.enums.GraphQLPagePresenceTabType;
import com.facebook.graphql.enums.GraphQLPagesInsightsPageProfileTab;
import com.facebook.graphql.enums.GraphQLReactionStoryActionStyle;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.pages.PageProfileType;
import com.facebook.ipc.pages.PageViewReferrer;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: media_item_set */
public class PagesAnalytics {
    private static volatile PagesAnalytics f9110c;
    public final AnalyticsLogger f9111a;
    private final CommonEventsBuilder f9112b;

    public static com.facebook.pages.common.logging.analytics.PagesAnalytics m10916a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9110c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.pages.common.logging.analytics.PagesAnalytics.class;
        monitor-enter(r1);
        r0 = f9110c;	 Catch:{ all -> 0x003a }
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
        r0 = m10917b(r0);	 Catch:{ all -> 0x0035 }
        f9110c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9110c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.logging.analytics.PagesAnalytics.a(com.facebook.inject.InjectorLike):com.facebook.pages.common.logging.analytics.PagesAnalytics");
    }

    private static PagesAnalytics m10917b(InjectorLike injectorLike) {
        return new PagesAnalytics(AnalyticsLoggerMethodAutoProvider.a(injectorLike), CommonEventsBuilder.b(injectorLike));
    }

    @Inject
    public PagesAnalytics(AnalyticsLogger analyticsLogger, CommonEventsBuilder commonEventsBuilder) {
        this.f9111a = analyticsLogger;
        this.f9112b = commonEventsBuilder;
    }

    private static HoneyClientEvent m10915a(PageAnalyticsEvent pageAnalyticsEvent, String str, long j) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(pageAnalyticsEvent.getName());
        honeyClientEvent.c = str;
        return honeyClientEvent.a("page_id", j).b("event_type", pageAnalyticsEvent.getType().name());
    }

    private HoneyClientEvent m10918c(PageAnalyticsEvent pageAnalyticsEvent, long j) {
        return m10915a(pageAnalyticsEvent, "pages_public_view", j);
    }

    private HoneyClientEvent m10920d(PageAnalyticsEvent pageAnalyticsEvent, long j) {
        return m10915a(pageAnalyticsEvent, "pages_admin_panel", j);
    }

    public final void m10922a(long j, long j2) {
        this.f9111a.c(m10918c(RedirectionEvent.EVENT_GLOBAL_PAGE_REDIRECTION, j2).a("original_page_id", j));
    }

    public final void m10939a(boolean z, long j, boolean z2) {
        this.f9111a.c(m10918c((PageAnalyticsEvent) z ? NetworkSuccessEvent.EVENT_PAGE_RECOMMENDATION_SUCCESS : NetworkFailureEvent.EVENT_PAGE_RECOMMENDATION_ERROR, j).a("has_photo", z2));
    }

    public final void m10938a(String str, PageAnalyticsEvent pageAnalyticsEvent, long j, String str2) {
        this.f9111a.c(m10915a(pageAnalyticsEvent, str, j).b("story_id", str2));
    }

    public final void m10937a(String str, PageAnalyticsEvent pageAnalyticsEvent, long j) {
        this.f9111a.c(m10915a(pageAnalyticsEvent, str, j));
    }

    public final void m10936a(PageAnalyticsEvent pageAnalyticsEvent, long j) {
        m10937a("pages_public_view", pageAnalyticsEvent, j);
    }

    public final void m10927a(long j, String str) {
        this.f9111a.c(m10918c(TapEvent.EVENT_TAPPED_VIDEO_HUB_CARD_HEADER, j).b("navigation_source", str));
    }

    public final void m10926a(long j, PageViewReferrer pageViewReferrer) {
        this.f9111a.c(m10918c(NetworkEvent.EVENT_PAGE_DETAILS_PARALLEL_FETCH_STARTED, j).b("ref", pageViewReferrer.loggingName));
    }

    public final void m10943b(long j, PageViewReferrer pageViewReferrer) {
        this.f9111a.c(m10918c(NetworkSuccessEvent.EVENT_NETWORK_LOADED_BEFORE_CACHE, j).b("ref", pageViewReferrer.loggingName));
    }

    public final void m10948c(long j, @Nullable PageViewReferrer pageViewReferrer) {
        HoneyClientEvent c = m10918c(NetworkSuccessEvent.EVENT_PAGE_VISIT, j);
        if (pageViewReferrer != null) {
            c.b("ref", pageViewReferrer.loggingName);
        } else {
            c.b("ref", PageViewReferrer.UNKNOWN.loggingName);
        }
        this.f9111a.c(c);
    }

    public final void m10925a(long j, @Nullable PageProfileType pageProfileType, @Nullable PageViewReferrer pageViewReferrer) {
        HoneyClientEvent a = m10918c(NetworkSuccessEvent.EVENT_PAGE_DETAILS_LOADED, j).a("insight_profile_tab", GraphQLPagesInsightsPageProfileTab.HOME);
        if (pageProfileType != null) {
            a.b("page_profile_type", pageProfileType.toString());
        }
        if (pageViewReferrer != null) {
            a.b("ref", pageViewReferrer.loggingName);
        } else {
            a.b("ref", PageViewReferrer.UNKNOWN.loggingName);
        }
        this.f9111a.c(a);
    }

    private void m10919c(long j, GraphQLPagePresenceTabType graphQLPagePresenceTabType) {
        this.f9111a.c(m10918c(NetworkSuccessEvent.EVENT_PAGE_DETAILS_LOADED, j).b("ref", PageViewReferrer.PAGE_INTERNAL.loggingName).a("insight_profile_tab", graphQLPagePresenceTabType));
    }

    public final void m10923a(long j, GraphQLPagePresenceTabType graphQLPagePresenceTabType) {
        m10919c(j, graphQLPagePresenceTabType);
    }

    public final void m10942b(long j, GraphQLPagePresenceTabType graphQLPagePresenceTabType) {
        m10919c(j, graphQLPagePresenceTabType);
        this.f9111a.c(m10918c(TabSwitchEvent.EVENT_PRESENCE_TAB_SWITCH, j));
    }

    public final void m10924a(long j, GraphQLPagePresenceTabType graphQLPagePresenceTabType, GraphQLReactionStoryActionStyle graphQLReactionStoryActionStyle) {
        m10919c(j, graphQLPagePresenceTabType);
        this.f9111a.c(m10918c(TabSwitchEvent.EVENT_PRESENCE_TAB_SWITCH, j).b("source_card_style", graphQLReactionStoryActionStyle.toString()));
    }

    public final void m10947b(PageAnalyticsEvent pageAnalyticsEvent, long j) {
        m10937a("pages_admin_panel", pageAnalyticsEvent, j);
    }

    public final void m10941b(long j, long j2) {
        this.f9111a.c(m10918c(TapEvent.EVENT_TAPPED_CHILD_LOCATION, j).a("location_page_id", j2));
    }

    public final void m10944b(long j, String str) {
        this.f9111a.c(m10918c(TapEvent.EVENT_TAPPED_PROFILE_PHOTO, j).b("photo_id", str));
    }

    public final void m10949c(long j, String str) {
        this.f9111a.c(m10918c(TapEvent.EVENT_TAPPED_COVER_PHOTO, j).b("photo_id", str));
    }

    public final void m10928a(long j, @Nullable String str, @Nullable GraphQLPageCallToActionType graphQLPageCallToActionType) {
        this.f9111a.c(m10918c(TapEvent.EVENT_TAPPED_CALL_TO_ACTION, j).b("ccta_id", str).a("ccta_type", graphQLPageCallToActionType).a("ccta_ref", GraphQLPageCallToActionRef.MOBILE_PAGE_PRESENCE_CALL_TO_ACTION));
    }

    public final void m10951d(long j, String str) {
        this.f9111a.c(m10918c(TapEvent.EVENT_TAPPED_ALL_PHOTOS_AT_PAGE, j).b("expand_event", str));
    }

    public final void m10952e(long j, String str) {
        this.f9111a.c(m10918c(ViewEvents.EVENT_VIEWED_PHOTO, j).b("photo_id", str));
    }

    public final void m10953f(long j, String str) {
        this.f9111a.c(m10918c(ViewEvents.EVENT_VIEWED_FB_EVENT, j).b("event_id", str));
    }

    public final void m10954g(long j, String str) {
        this.f9111a.c(m10918c(TapEvent.EVENT_TAPPED_FB_EVENT, j).b("event_id", str));
    }

    public final void m10955h(long j, String str) {
        this.f9111a.c(m10918c(ViewEvents.EVENT_SHOWN_UNIT, j).b("unit_name", str));
    }

    public final void m10932a(long j, String str, String str2, boolean z) {
        this.f9111a.c(m10918c((PageAnalyticsEvent) z ? NetworkSuccessEvent.EVENT_FB_EVENT_STATUS_SUCCESS : NetworkFailureEvent.EVENT_FB_EVENT_STATUS_FAILURE, j).b("event_id", str).b("event_guest_status", str2));
    }

    public final void m10929a(long j, String str, String str2) {
        this.f9111a.c(m10920d(AdminEvent.EVENT_ADMIN_CLICK_PROMOTE, j).b("label", str).b("ref", str2));
    }

    public final void m10921a(long j) {
        this.f9111a.c(m10920d(AdminActivityTabEvent.EVENT_ADMIN_ACTIVITY_CLICK_EDIT_UNI_STATUS, j));
    }

    public final void m10945b(long j, String str, String str2) {
        this.f9111a.c(m10918c(TapEvent.EVENT_TAPPED_VIDEO_HUB_PLAYLIST_HEADER, j).b("playlist_id", str).b("navigation_source", str2));
    }

    public final void m10940b(long j) {
        this.f9111a.c(m10918c(ViewEvents.PAGE_EVENT_VIEW_SERVICES_CARD, j));
    }

    public final void m10934a(long j, boolean z) {
        m10936a(z ? TapEvent.EVENT_TAPPED_SERVICES_CARD_SEE_ALL : TapEvent.EVENT_TAPPED_SERVICES_CARD_ITEM, j);
    }

    public final void m10946b(long j, boolean z) {
        this.f9111a.a(m10918c(AdminContactInboxEvent.EVENT_ADMIN_CONTACT_INBOX_TAPPED_ENTRY_POINT, j).a("from_activity_tab", z));
    }

    public final void m10935a(long j, boolean z, boolean z2, int i, String str) {
        this.f9111a.a(m10918c(AdminContactInboxEvent.EVENT_ADMIN_CONTACT_INBOX_TAPPED_ONE_REQUEST, j).a("first_time_opened", z).a("is_responded", z2).a("days_to_expire", i).b("leadgen_id", str));
    }

    public final void m10956i(long j, String str) {
        this.f9111a.a(m10918c(AdminContactInboxEvent.EVENT_ADMIN_CONTACT_INBOX_TAPPED_BAN_USER, j).b("banned_user_id", str));
    }

    public final void m10950c(long j, boolean z) {
        this.f9111a.a(m10918c(AdminContactInboxEvent.EVENT_ADMIN_CONTACT_INBOX_TOGGLE_RESPONDED, j).a("result_in_responded", z));
    }

    public final void m10957j(long j, String str) {
        this.f9111a.a(m10918c(TapEvent.EVENT_TAPPED_CREATE_ALBUM, j).b("location", str));
    }

    public final void m10930a(long j, String str, String str2, int i, String str3, boolean z) {
        this.f9111a.a(m10918c(TapEvent.EVENT_TAPPED_ALBUM, j).b("location", str3).b("album_id", str).b("album_name", str2).a("album_position", i).a("is_video_album", z));
    }

    public final void m10931a(long j, String str, String str2, String str3) {
        this.f9111a.a(m10918c(TapEvent.EVENT_TAPPED_ADD_PHOTOS, j).b("location", str).b("album_id", str2).b("album_name", str3));
    }

    public final void m10933a(long j, String str, boolean z) {
        this.f9111a.a(m10918c(TapEvent.EVENT_TAPPED_PHOTO, j).b("location", str).a("is_video", z));
    }
}
