package com.facebook.timeline.logging;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.analytics.InteractionLogger;
import com.facebook.analytics.InteractionLogger.ContentFlags;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.impression.ImpressionManager;
import com.facebook.analytics.logger.AnalyticsConfig;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.enums.GraphQLProfileTileSectionType;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.graphql.enums.GraphQLTimelineContextListItemType;
import com.facebook.graphql.enums.GraphQLTimelineContextListTargetType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.katana.orca.FbAnalyticsConfig;
import com.facebook.profile.api.RelationshipType;
import com.facebook.timeline.data.PhotoLoadState;
import com.facebook.timeline.data.TimelineHeaderRenderState;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineContextListItemFieldsModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineContextListItemFieldsModel.NodeModel;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap.Builder;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nullable;
import javax.inject.Provider;

@ContextScoped
/* compiled from: fav_photos_select_from_fb_click */
public class TimelineAnalyticsLogger {
    private static TimelineAnalyticsLogger f14624j;
    private static final Object f14625k = new Object();
    @Inject
    volatile Provider<InteractionLogger> f14626a = UltralightRuntime.a;
    @Inject
    private AnalyticsLogger f14627b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<NavigationLogger> f14628c = UltralightRuntime.b;
    @Inject
    private Context f14629d;
    @Inject
    private ImpressionManager f14630e;
    @Inject
    private BaseAnalyticsConfig f14631f;
    @Inject
    private FbNetworkManager f14632g;
    @Inject
    private TimelineHeaderRenderState f14633h;
    private boolean f14634i;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: fav_photos_select_from_fb_click */
    public @interface NotificationType {
    }

    private static TimelineAnalyticsLogger m18538b(InjectorLike injectorLike) {
        TimelineAnalyticsLogger timelineAnalyticsLogger = new TimelineAnalyticsLogger();
        timelineAnalyticsLogger.m18537a(IdBasedSingletonScopeProvider.a(injectorLike, 134), AnalyticsLoggerMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 137), (Context) injectorLike.getInstance(Context.class), ImpressionManager.a(injectorLike), (BaseAnalyticsConfig) FbAnalyticsConfig.a(injectorLike), FbNetworkManager.a(injectorLike), TimelineHeaderRenderState.m18470a(injectorLike));
        return timelineAnalyticsLogger;
    }

    public static TimelineAnalyticsLogger m18531a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineAnalyticsLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f14625k) {
                TimelineAnalyticsLogger timelineAnalyticsLogger;
                if (a2 != null) {
                    timelineAnalyticsLogger = (TimelineAnalyticsLogger) a2.a(f14625k);
                } else {
                    timelineAnalyticsLogger = f14624j;
                }
                if (timelineAnalyticsLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m18538b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f14625k, b3);
                        } else {
                            f14624j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineAnalyticsLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private void m18537a(Provider<InteractionLogger> provider, AnalyticsLogger analyticsLogger, com.facebook.inject.Lazy<NavigationLogger> lazy, Context context, ImpressionManager impressionManager, AnalyticsConfig analyticsConfig, FbNetworkManager fbNetworkManager, TimelineHeaderRenderState timelineHeaderRenderState) {
        this.f14626a = provider;
        this.f14627b = analyticsLogger;
        this.f14628c = lazy;
        this.f14629d = context;
        this.f14630e = impressionManager;
        this.f14631f = analyticsConfig;
        this.f14632g = fbNetworkManager;
        this.f14633h = timelineHeaderRenderState;
    }

    public final void m18544a(long j, RelationshipType relationshipType) {
        if (!this.f14634i) {
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("view");
            honeyClientEvent.c = "timeline";
            honeyClientEvent = honeyClientEvent;
            m18535a(honeyClientEvent, j, relationshipType);
            this.f14627b.c(honeyClientEvent);
            this.f14634i = true;
        }
    }

    public final void m18554a(DataFreshnessResult dataFreshnessResult, long j) {
        if (dataFreshnessResult == DataFreshnessResult.FROM_SERVER) {
            m18533a(ContentFlags.LOCAL_DATA, j);
            m18532a(ContentFlags.NETWORK_DATA);
        } else if (dataFreshnessResult == DataFreshnessResult.FROM_CACHE_UP_TO_DATE || dataFreshnessResult == DataFreshnessResult.FROM_CACHE_STALE) {
            m18532a(ContentFlags.NO_DATA);
        }
    }

    public final void m18553a(long j, String str, RelationshipType relationshipType, TimelineContextListItemFieldsModel timelineContextListItemFieldsModel) {
        Preconditions.checkNotNull(timelineContextListItemFieldsModel);
        HoneyClientEvent a = m18530a("profile_context_item_vpv", j, null, relationshipType);
        a.b("session_id", str);
        m18536a(a, timelineContextListItemFieldsModel);
        this.f14627b.a(a);
    }

    public final void m18548a(long j, RelationshipType relationshipType, TimelineContextListItemFieldsModel timelineContextListItemFieldsModel) {
        Preconditions.checkNotNull(timelineContextListItemFieldsModel);
        ((NavigationLogger) this.f14628c.get()).a("timeline_context_item");
        HoneyClientEvent a = m18530a("profile_context_item_click", j, timelineContextListItemFieldsModel.c() != null ? timelineContextListItemFieldsModel.c().d() : null, relationshipType);
        m18536a(a, timelineContextListItemFieldsModel);
        this.f14627b.a(a);
    }

    private static void m18536a(HoneyClientEvent honeyClientEvent, TimelineContextListItemFieldsModel timelineContextListItemFieldsModel) {
        NodeModel c = timelineContextListItemFieldsModel.c();
        if (!(c == null || c.d() == null)) {
            honeyClientEvent.e = c.d();
        }
        GraphQLTimelineContextListItemType dr_ = timelineContextListItemFieldsModel.dr_();
        if (!(dr_ == null || dr_ == GraphQLTimelineContextListItemType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE)) {
            honeyClientEvent.a("context_item_type", dr_);
        }
        GraphQLTimelineContextListTargetType d = timelineContextListItemFieldsModel.d();
        if (d != null && d != GraphQLTimelineContextListTargetType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            honeyClientEvent.a("context_item_target_type", d);
        }
    }

    public final void m18547a(long j, RelationshipType relationshipType, GraphQLTimelineAppSectionType graphQLTimelineAppSectionType) {
        String str;
        String graphQLTimelineAppSectionType2 = graphQLTimelineAppSectionType.toString();
        if (graphQLTimelineAppSectionType == GraphQLTimelineAppSectionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            str = "ACTIVITY_LOG";
        } else {
            str = graphQLTimelineAppSectionType2;
        }
        HoneyClientEvent a = m18530a("profile_nav_tile_click", j, null, relationshipType);
        a.b("nav_tile_type", str);
        this.f14627b.a(a);
    }

    public final void m18550a(long j, String str, RelationshipType relationshipType) {
        HoneyClientEvent a = m18530a("profile_publish_bar_click", j, null, relationshipType);
        a.b("publisher_bar_target_type", str);
        this.f14627b.a(a);
    }

    public final void m18561b(long j, String str, RelationshipType relationshipType) {
        HoneyClientEvent a = m18530a("profile_action_bar_item_click", j, null, relationshipType);
        a.b("action_bar_target_type", str);
        this.f14627b.a(a);
    }

    public final void m18567c(long j, String str, RelationshipType relationshipType) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("profile_timeline_scroll");
        honeyClientEvent.c = "timeline";
        honeyClientEvent = honeyClientEvent;
        m18535a(honeyClientEvent, j, relationshipType);
        honeyClientEvent.d = str;
        this.f14627b.a(honeyClientEvent);
    }

    public final void m18552a(long j, String str, RelationshipType relationshipType, ImageResolutionQuality imageResolutionQuality, PhotoLoadState photoLoadState, long j2) {
        if (this.f14631f.a("profile_picture_vpv")) {
            HoneyClientEvent a = m18530a("profile_picture_vpv", j, null, relationshipType);
            a.b("session_id", str);
            a.a("image_resolution_quality", imageResolutionQuality.ordinal());
            a.a("image_loading_state", photoLoadState.ordinal());
            a.a("vpvd_time_delta", j2);
            a.b("network_type", this.f14632g.m());
            a.a("is_profile_cached", this.f14633h.m18472e());
            this.f14627b.a(a);
        }
    }

    public final void m18549a(long j, String str) {
        this.f14627b.a(m18530a("profile_picture_popover_menu_item_click", j, str, null));
    }

    public final void m18562b(long j, String str, RelationshipType relationshipType, ImageResolutionQuality imageResolutionQuality, PhotoLoadState photoLoadState, long j2) {
        if (this.f14631f.a("profile_cover_photo_vpv")) {
            HoneyClientEvent a = m18530a("profile_cover_photo_vpv", j, null, relationshipType);
            a.b("session_id", str);
            a.a("image_resolution_quality", imageResolutionQuality.ordinal());
            a.a("image_loading_state", photoLoadState.ordinal());
            a.a("vpvd_time_delta", j2);
            a.b("network_type", this.f14632g.m());
            a.a("is_profile_cached", this.f14633h.m18472e());
            this.f14627b.a(a);
        }
    }

    public final void m18557b(long j, RelationshipType relationshipType) {
        this.f14627b.a(m18530a("profile_scroll_to_end", j, null, relationshipType));
    }

    public final void m18545a(long j, RelationshipType relationshipType, GraphQLProfileTileSectionType graphQLProfileTileSectionType) {
        if (this.f14631f.a("protile_header_click")) {
            HoneyClientEvent a = m18530a("protile_header_click", j, null, relationshipType);
            a.a("protile_type", graphQLProfileTileSectionType);
            this.f14627b.a(a);
        }
    }

    public final void m18558b(long j, RelationshipType relationshipType, GraphQLProfileTileSectionType graphQLProfileTileSectionType) {
        if (this.f14631f.a("protile_footer_click")) {
            HoneyClientEvent a = m18530a("protile_footer_click", j, null, relationshipType);
            a.a("protile_type", graphQLProfileTileSectionType);
            this.f14627b.a(a);
        }
    }

    public final void m18551a(long j, String str, RelationshipType relationshipType, GraphQLProfileTileSectionType graphQLProfileTileSectionType, int i) {
        if (this.f14631f.a("protile_item_click")) {
            HoneyClientEvent a = m18530a("protile_item_click", j, str, relationshipType);
            a.a("protile_type", graphQLProfileTileSectionType);
            if (graphQLProfileTileSectionType == GraphQLProfileTileSectionType.FRIENDS) {
                a.a("item_badge_count", i);
            }
            this.f14627b.a(a);
        }
    }

    public final void m18546a(long j, RelationshipType relationshipType, GraphQLProfileTileSectionType graphQLProfileTileSectionType, int i, int i2, long j2, int i3) {
        if (this.f14631f.a("protiles_vpv_duration")) {
            HoneyClientEvent a = m18530a("protiles_vpv_duration", j, null, relationshipType);
            a.a("protile_type", graphQLProfileTileSectionType);
            a.a("vpvd_time_delta", j2);
            a.a("image_loading_state", i3);
            a.a("is_profile_cached", this.f14633h.m18472e());
            if (graphQLProfileTileSectionType == GraphQLProfileTileSectionType.FRIENDS) {
                a.a("protile_mutual_friend_counts", i);
            } else if (graphQLProfileTileSectionType == GraphQLProfileTileSectionType.PHOTOS) {
                a.a("protile_photo_counts", i2);
            }
            this.f14627b.a(a);
        }
    }

    public final void m18560b(long j, String str) {
        HoneyClientEvent a = m18529a(j, str, RelationshipType.SELF, "nux_impression");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18566c(long j, String str) {
        HoneyClientEvent a = m18529a(j, str, RelationshipType.SELF, "nux_dismiss");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18555a(boolean z, long j, String str, RelationshipType relationshipType) {
        HoneyClientEvent a = m18529a(j, str, relationshipType, "intro_card_impression");
        if (a != null) {
            a.a("event_metadata", new Builder().b("has_content", Boolean.valueOf(z)).b());
            this.f14627b.a(a);
        }
    }

    public final void m18569d(long j, String str) {
        HoneyClientEvent a = m18529a(j, str, RelationshipType.UNKNOWN_RELATIONSHIP, "non_self_add_intro_upsell_click");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18572e(long j, String str) {
        HoneyClientEvent a = m18529a(j, str, RelationshipType.UNKNOWN_RELATIONSHIP, "non_self_add_intro_upsell_impression");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18570d(long j, String str, RelationshipType relationshipType) {
        HoneyClientEvent a = m18529a(j, str, relationshipType, "bio_impression");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18575f(long j, String str) {
        HoneyClientEvent a = m18529a(j, str, RelationshipType.SELF, "bio_add_prompt_impression");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18578g(long j, String str) {
        HoneyClientEvent a = m18529a(j, str, RelationshipType.SELF, "bio_add_prompt_suggested_impression");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18540a(long j) {
        HoneyClientEvent a = m18529a(j, null, RelationshipType.SELF, "bio_add_click");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18556b(long j) {
        HoneyClientEvent a = m18529a(j, null, RelationshipType.SELF, "bio_add_prompt_suggested_click");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18564c(long j) {
        HoneyClientEvent a = m18529a(j, null, RelationshipType.SELF, "bio_edit_click");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18580h(long j, String str) {
        HoneyClientEvent a = m18529a(j, str, RelationshipType.SELF, "context_item_add_prompt_impression");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18563b(long j, String str, RelationshipType relationshipType, TimelineContextListItemFieldsModel timelineContextListItemFieldsModel) {
        HoneyClientEvent a = m18529a(j, str, relationshipType, "context_item_impression");
        if (a != null) {
            m18536a(a, timelineContextListItemFieldsModel);
            this.f14627b.a(a);
        }
    }

    public final void m18568d(long j) {
        HoneyClientEvent a = m18529a(j, null, RelationshipType.SELF, "context_item_add_click");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18571e(long j) {
        HoneyClientEvent a = m18529a(j, null, RelationshipType.SELF, "context_item_edit_click");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18559b(long j, RelationshipType relationshipType, TimelineContextListItemFieldsModel timelineContextListItemFieldsModel) {
        Preconditions.checkNotNull(timelineContextListItemFieldsModel);
        ((NavigationLogger) this.f14628c.get()).a("timeline_context_item");
        HoneyClientEvent a = m18529a(j, null, relationshipType, "context_item_view_click");
        if (a != null) {
            m18536a(a, timelineContextListItemFieldsModel);
            this.f14627b.a(a);
        }
    }

    public final void m18565c(long j, RelationshipType relationshipType) {
        HoneyClientEvent a = m18529a(j, null, relationshipType, "intro_card_expansion");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18573e(long j, String str, RelationshipType relationshipType) {
        HoneyClientEvent a = m18529a(j, str, relationshipType, "fav_photos_impression");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18543a(long j, int i, String str, RelationshipType relationshipType) {
        HoneyClientEvent a = m18529a(j, str, relationshipType, "fav_photos_add_prompt_suggested_impression");
        if (a != null) {
            m18534a(a, i);
            this.f14627b.a(a);
        }
    }

    public final void m18582i(long j, String str) {
        HoneyClientEvent a = m18529a(j, str, RelationshipType.SELF, "fav_photos_add_prompt_impression");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18574f(long j) {
        HoneyClientEvent a = m18529a(j, null, RelationshipType.SELF, "fav_photos_add_click");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18577g(long j) {
        HoneyClientEvent a = m18529a(j, null, RelationshipType.SELF, "fav_photos_edit_click");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18541a(long j, int i) {
        HoneyClientEvent a = m18529a(j, null, RelationshipType.SELF, "fav_photos_add_prompt_suggested_click");
        if (a != null) {
            m18534a(a, i);
            this.f14627b.a(a);
        }
    }

    private static void m18534a(HoneyClientEvent honeyClientEvent, int i) {
        honeyClientEvent.a("event_metadata", new Builder().b("photos_number", Integer.valueOf(i)).b());
    }

    public final void m18579h(long j) {
        HoneyClientEvent a = m18529a(j, null, RelationshipType.SELF, "fav_photos_add_in_editing_view");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18581i(long j) {
        HoneyClientEvent a = m18529a(j, null, RelationshipType.SELF, "fav_photos_add_in_editing_view_tile");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18583j(long j) {
        HoneyClientEvent a = m18529a(j, null, RelationshipType.SELF, "fav_photos_replace_in_editing_view_tile");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18585k(long j) {
        HoneyClientEvent a = m18529a(j, null, RelationshipType.SELF, "fav_photos_select_from_fb_click");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18587l(long j) {
        HoneyClientEvent a = m18529a(j, null, RelationshipType.SELF, "fav_photos_upload_click");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18588m(long j) {
        HoneyClientEvent a = m18529a(j, null, RelationshipType.SELF, "fav_photos_edit_save_click");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18589n(long j) {
        HoneyClientEvent a = m18529a(j, null, RelationshipType.SELF, "fav_photos_edit_cancel_click");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18590o(long j) {
        HoneyClientEvent a = m18529a(j, null, RelationshipType.SELF, "fav_photos_edit_view_large_click");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18591p(long j) {
        HoneyClientEvent a = m18529a(j, null, RelationshipType.SELF, "links_edit_click");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18592q(long j) {
        HoneyClientEvent a = m18529a(j, null, RelationshipType.SELF, "links_add_click");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18593r(long j) {
        HoneyClientEvent a = m18529a(j, null, RelationshipType.SELF, "links_add_prompt_impression");
        if (a != null) {
            this.f14627b.a(a);
        }
    }

    public final void m18542a(long j, int i, int i2) {
        HoneyClientEvent a = m18529a(j, null, RelationshipType.SELF, "links_impression");
        if (a != null) {
            a.b("links_count", StringFormatUtil.formatStrLocaleSafe("websites: %1$d, accounts: %2$d", Integer.valueOf(i), Integer.valueOf(i2)));
            this.f14627b.a(a);
        }
    }

    @Nullable
    private HoneyClientEvent m18529a(long j, String str, RelationshipType relationshipType, String str2) {
        if (!this.f14631f.a("profile_intro_card_event")) {
            return null;
        }
        HoneyClientEvent a = m18530a("profile_intro_card_event", j, null, relationshipType);
        a.b("event_type", str2);
        a.b("session_id", str);
        return a;
    }

    public final void m18584j(long j, String str) {
        if (this.f14631f.a("profile_get_notified_event")) {
            HoneyClientEvent a = m18530a("profile_get_notified_event", j, null, null);
            a.b("event_type", "get_notified_impression");
            if (str != null) {
                a.b("session_id", str);
            }
            this.f14627b.a(a);
        }
    }

    public final void m18586k(long j, @Nullable String str) {
        if (this.f14631f.a("profile_get_notified_event")) {
            HoneyClientEvent a = m18530a("profile_get_notified_event", j, null, null);
            a.b("event_type", "get_notified_click");
            if (str != null) {
                a.b("session_id", str);
            }
            this.f14627b.a(a);
        }
    }

    public final void m18576f(long j, @Nullable String str, RelationshipType relationshipType) {
        if (this.f14631f.a("profile_get_notified_event")) {
            HoneyClientEvent a = m18530a("profile_get_notified_event", j, null, relationshipType);
            a.b("event_type", "get_notified_profile_load");
            if (str != null) {
                a.b("session_id", str);
            }
            this.f14627b.a(a);
        }
    }

    public final void m18539a(int i, long j) {
        if (this.f14631f.a("profile_get_notified_event")) {
            String str;
            HoneyClientEvent a = m18530a("profile_get_notified_event", j, null, null);
            switch (i) {
                case 0:
                    str = "get_notified_notif_success";
                    break;
                case 1:
                    str = "get_notified_notif_failure";
                    break;
                default:
                    str = "get_notified_notif_interrupetd";
                    break;
            }
            a.b("event_type", str);
            this.f14627b.a(a);
        }
    }

    private void m18535a(HoneyClientEvent honeyClientEvent, long j, RelationshipType relationshipType) {
        honeyClientEvent.a("profile_id", j);
        if (!(relationshipType == null || relationshipType == RelationshipType.UNDEFINED)) {
            honeyClientEvent.a("relationship_type", relationshipType.getValue());
        }
        honeyClientEvent.f = this.f14630e.b(this.f14629d);
    }

    private void m18533a(ContentFlags contentFlags, long j) {
        this.f14626a.get();
        this.f14627b.a(InteractionLogger.a(contentFlags, "timeline", this.f14630e.b(this.f14629d), j));
    }

    private void m18532a(ContentFlags contentFlags) {
        m18533a(contentFlags, -1);
    }

    private HoneyClientEvent m18530a(String str, long j, @Nullable String str2, @Nullable RelationshipType relationshipType) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "timeline";
        honeyClientEvent = honeyClientEvent.a("profile_id", j);
        honeyClientEvent.f = this.f14630e.b(this.f14629d);
        honeyClientEvent = honeyClientEvent;
        if (str2 != null) {
            honeyClientEvent.e = str2;
        }
        if (!(relationshipType == null || relationshipType == RelationshipType.UNDEFINED)) {
            honeyClientEvent.a("relationship_type", relationshipType.getValue());
        }
        return honeyClientEvent;
    }
}
