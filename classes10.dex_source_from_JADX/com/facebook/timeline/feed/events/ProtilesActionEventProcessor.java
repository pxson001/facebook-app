package com.facebook.timeline.feed.events;

import android.content.Context;
import android.os.Bundle;
import com.facebook.analytics.NavigationLogger;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.feed.rows.core.events.Action;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.events.Subscription;
import com.facebook.friendlist.constants.FriendListSource;
import com.facebook.friendlist.constants.FriendListType;
import com.facebook.graphql.enums.GraphQLProfileTileSectionType;
import com.facebook.inject.Assisted;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.profile.api.RelationshipType;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.logging.TimelineAnalyticsLogger;
import com.facebook.timeline.navtiles.TimelinePhotosTabParamsUtil;
import com.facebook.timeline.protiles.events.ProtilesActionEvent;
import com.facebook.timeline.protiles.events.ProtilesActionEvent.Type;
import com.facebook.timeline.protiles.model.ProtileModel;
import com.facebook.timeline.protiles.util.TimelineCollapsedProtilesExperimentHelper;
import com.facebook.timeline.taggedmediaset.TimelineTaggedMediaSetData;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: friends_nearby_invite_send */
public class ProtilesActionEventProcessor {
    public final FbUriIntentHandler f11149a;
    public final EventsStream f11150b;
    public final Context f11151c;
    public final TimelineHeaderUserData f11152d;
    public final TimelineTaggedMediaSetData f11153e;
    public final TimelineContext f11154f;
    public final TimelineAnalyticsLogger f11155g;
    public final NavigationLogger f11156h;
    public final TimelineCollapsedProtilesExperimentHelper f11157i;
    public Subscription<ProtilesActionEvent, String> f11158j;

    /* compiled from: friends_nearby_invite_send */
    public class C16151 implements Action<ProtilesActionEvent> {
        public final /* synthetic */ ProtilesActionEventProcessor f11146a;

        public C16151(ProtilesActionEventProcessor protilesActionEventProcessor) {
            this.f11146a = protilesActionEventProcessor;
        }

        public final void m11299a(Object obj) {
            ProtilesActionEvent protilesActionEvent = (ProtilesActionEvent) obj;
            GraphQLProfileTileSectionType b = protilesActionEvent.f12098b.m12109b();
            if (protilesActionEvent.f12097a == Type.CLICK_HEADER || protilesActionEvent.f12097a == Type.CLICK_FOOTER) {
                String a = m11298a(protilesActionEvent.f12098b);
                if (a != null) {
                    FbUriIntentHandler fbUriIntentHandler = this.f11146a.f11149a;
                    Context context = this.f11146a.f11151c;
                    Bundle bundle = new Bundle();
                    bundle.putString("profile_name", this.f11146a.f11152d.N());
                    if (b == GraphQLProfileTileSectionType.PHOTOS) {
                        TimelinePhotosTabParamsUtil.m12084a(this.f11146a.f11153e, bundle);
                        bundle.putString("fullscreen_gallery_source", FullscreenGallerySource.TIMELINE_PHOTOS_OF_USER.name());
                        bundle.putBoolean("disable_camera_roll", true);
                    }
                    fbUriIntentHandler.a(context, a, bundle);
                }
            }
            RelationshipType relationshipType = RelationshipType.getRelationshipType(this.f11146a.f11154f.i(), this.f11146a.f11152d.B(), this.f11146a.f11152d.C());
            switch (protilesActionEvent.f12097a) {
                case CLICK_HEADER:
                    this.f11146a.f11155g.a(this.f11146a.f11154f.b, relationshipType, b);
                    return;
                case CLICK_FOOTER:
                    this.f11146a.f11155g.b(this.f11146a.f11154f.b, relationshipType, b);
                    return;
                case CLICK_ITEM:
                    String str;
                    int i;
                    if (protilesActionEvent.f12099c == null || protilesActionEvent.f12099c.m12180b() == null) {
                        str = null;
                    } else {
                        str = protilesActionEvent.f12099c.m12180b().m12151d();
                    }
                    if (protilesActionEvent.f12099c == null || protilesActionEvent.f12099c.m12180b() == null) {
                        i = 0;
                    } else {
                        i = protilesActionEvent.f12099c.m12180b().m12158o();
                    }
                    this.f11146a.f11155g.a(this.f11146a.f11154f.b, str, relationshipType, b, i);
                    if (b == GraphQLProfileTileSectionType.FRIENDS) {
                        this.f11146a.f11156h.a("tap_protile_friend_to_timeline");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        private String m11298a(ProtileModel protileModel) {
            GraphQLProfileTileSectionType b = protileModel.m12109b();
            if (this.f11146a.f11152d.E() == null) {
                return null;
            }
            switch (C16162.f11148b[b.ordinal()]) {
                case 1:
                    return StringFormatUtil.formatStrLocaleSafe(FBLinks.bn, this.f11146a.f11152d.E());
                case 2:
                    boolean a;
                    String e;
                    String str = FBLinks.bf;
                    String E = this.f11146a.f11152d.E();
                    TimelineCollapsedProtilesExperimentHelper timelineCollapsedProtilesExperimentHelper = this.f11146a.f11157i;
                    if (timelineCollapsedProtilesExperimentHelper.f12398b) {
                        a = timelineCollapsedProtilesExperimentHelper.f12397a.a(ExperimentsForTimelineAbTestModule.z, false);
                    } else {
                        a = timelineCollapsedProtilesExperimentHelper.f12397a.a(ExperimentsForTimelineAbTestModule.v, false);
                    }
                    if (a) {
                        Object obj;
                        e = protileModel.m12112e();
                        if (Strings.isNullOrEmpty(e) || !e.matches("\\d+[^()0-9]+")) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        if (obj != null) {
                            e = FriendListType.MUTUAL_FRIENDS.name();
                        } else {
                            e = FriendListType.ALL_FRIENDS.name();
                        }
                    } else {
                        e = FriendListType.ALL_FRIENDS.name();
                    }
                    return StringFormatUtil.formatStrLocaleSafe(str, E, e, FriendListSource.TIMELINE_FRIENDS_PROTILE.name());
                default:
                    return null;
            }
        }
    }

    /* compiled from: friends_nearby_invite_send */
    /* synthetic */ class C16162 {
        static final /* synthetic */ int[] f11148b = new int[GraphQLProfileTileSectionType.values().length];

        static {
            try {
                f11148b[GraphQLProfileTileSectionType.PHOTOS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f11148b[GraphQLProfileTileSectionType.FRIENDS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            f11147a = new int[Type.values().length];
            try {
                f11147a[Type.CLICK_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f11147a[Type.CLICK_FOOTER.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f11147a[Type.CLICK_ITEM.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    @Inject
    public ProtilesActionEventProcessor(@Assisted TimelineHeaderUserData timelineHeaderUserData, @Assisted TimelineTaggedMediaSetData timelineTaggedMediaSetData, @Assisted TimelineContext timelineContext, @Assisted TimelineAnalyticsLogger timelineAnalyticsLogger, NavigationLogger navigationLogger, FbUriIntentHandler fbUriIntentHandler, EventsStream eventsStream, Context context, TimelineCollapsedProtilesExperimentHelper timelineCollapsedProtilesExperimentHelper) {
        this.f11152d = (TimelineHeaderUserData) Preconditions.checkNotNull(timelineHeaderUserData);
        this.f11153e = timelineTaggedMediaSetData;
        this.f11154f = timelineContext;
        this.f11155g = timelineAnalyticsLogger;
        this.f11156h = navigationLogger;
        this.f11157i = timelineCollapsedProtilesExperimentHelper;
        this.f11149a = fbUriIntentHandler;
        this.f11150b = eventsStream;
        this.f11151c = context;
    }
}
