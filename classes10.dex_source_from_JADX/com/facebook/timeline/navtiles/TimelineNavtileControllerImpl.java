package com.facebook.timeline.navtiles;

import android.content.Context;
import android.os.Bundle;
import com.facebook.analytics.NavigationLogger;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.friendlist.constants.FriendListSource;
import com.facebook.friendlist.constants.FriendListType;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.inject.Assisted;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.profile.api.RelationshipType;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.logging.TimelineAnalyticsLogger;
import com.facebook.timeline.taggedmediaset.TimelineTaggedMediaSetData;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: fetch (sync);  */
public class TimelineNavtileControllerImpl implements TimelineNavtileController {
    private final Provider<FbUriIntentHandler> f12072a;
    private final Provider<NavigationLogger> f12073b;
    private final Context f12074c;
    private final TimelineAnalyticsLogger f12075d;
    public final TimelineContext f12076e;
    public final TimelineHeaderUserData f12077f;
    public final TimelineTaggedMediaSetData f12078g;

    /* compiled from: fetch (sync);  */
    /* synthetic */ class C17321 {
        static final /* synthetic */ int[] f12071a = new int[GraphQLTimelineAppSectionType.values().length];

        static {
            try {
                f12071a[GraphQLTimelineAppSectionType.ABOUT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f12071a[GraphQLTimelineAppSectionType.PHOTOS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f12071a[GraphQLTimelineAppSectionType.FRIENDS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f12071a[GraphQLTimelineAppSectionType.SUBSCRIBERS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f12071a[GraphQLTimelineAppSectionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    @Inject
    public TimelineNavtileControllerImpl(@Assisted Context context, @Assisted TimelineAnalyticsLogger timelineAnalyticsLogger, @Assisted TimelineContext timelineContext, @Assisted TimelineTaggedMediaSetData timelineTaggedMediaSetData, @Assisted TimelineHeaderUserData timelineHeaderUserData, Provider<FbUriIntentHandler> provider, Provider<NavigationLogger> provider2) {
        this.f12074c = context;
        this.f12075d = timelineAnalyticsLogger;
        this.f12076e = timelineContext;
        this.f12077f = timelineHeaderUserData;
        this.f12078g = timelineTaggedMediaSetData;
        this.f12073b = provider2;
        this.f12072a = provider;
    }

    public final void mo554a(GraphQLTimelineAppSectionType graphQLTimelineAppSectionType) {
        this.f12075d.a(this.f12076e.b, RelationshipType.getRelationshipType(this.f12076e.i(), this.f12077f.B(), this.f12077f.C()), graphQLTimelineAppSectionType);
        ((NavigationLogger) this.f12073b.get()).a("tap_timeline_nav_item");
        Bundle bundle = new Bundle();
        if (this.f12077f != null) {
            bundle.putString("friendship_status", this.f12077f.B().toString());
            bundle.putString("subscribe_status", this.f12077f.C().toString());
            bundle.putString("profile_name", this.f12077f.N());
            bundle.putString("first_name", this.f12077f.y());
            if (this.f12076e != null) {
                bundle.putString("session_id", this.f12076e.c);
            }
            if (graphQLTimelineAppSectionType == GraphQLTimelineAppSectionType.PHOTOS) {
                bundle.putString("fullscreen_gallery_source", FullscreenGallerySource.TIMELINE_PHOTOS_OF_USER.name());
                if (this.f12076e != null) {
                    bundle.putLong("viewer_id", this.f12076e.a);
                    bundle.putString("session_id", this.f12076e.d.toString());
                }
            }
        }
        TimelinePhotosTabParamsUtil.m12084a(this.f12078g, bundle);
        ((FbUriIntentHandler) this.f12072a.get()).a(this.f12074c, m12081c(graphQLTimelineAppSectionType), bundle, null);
    }

    private String m12081c(GraphQLTimelineAppSectionType graphQLTimelineAppSectionType) {
        switch (C17321.f12071a[graphQLTimelineAppSectionType.ordinal()]) {
            case 1:
                return StringFormatUtil.formatStrLocaleSafe(FBLinks.aY, Long.valueOf(this.f12076e.b));
            case 2:
                if (this.f12076e.i()) {
                    return FBLinks.bm;
                }
                return StringFormatUtil.formatStrLocaleSafe(FBLinks.bn, Long.valueOf(this.f12076e.b));
            case 3:
                return StringFormatUtil.formatStrLocaleSafe(FBLinks.bf, Long.valueOf(this.f12076e.b), this.f12076e.i() ? FriendListType.ALL_FRIENDS.name() : FriendListType.SUGGESTIONS.name(), FriendListSource.TIMELINE_FRIENDS_NAVTILE.name());
            case 4:
                return StringFormatUtil.formatStrLocaleSafe("https://m.facebook.com/profile.php?v=followers&id=%s", Long.valueOf(this.f12076e.b));
            case 5:
                return StringFormatUtil.formatStrLocaleSafe(FBLinks.bc, Long.valueOf(this.f12076e.b));
            default:
                throw new IllegalArgumentException("Unsupported item type = " + graphQLTimelineAppSectionType);
        }
    }
}
