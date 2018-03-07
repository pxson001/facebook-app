package com.facebook.notifications.multirow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import com.facebook.analytics.NavigationLogger;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.graphql.enums.GraphQLNotifHighlightState;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Assisted;
import com.facebook.notifications.logging.NotificationsLogger;
import com.facebook.notifications.logging.NotificationsLogger.NotificationLogObject;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.notifications.util.NotificationsMutator;
import com.facebook.notifications.util.NotificationsUtils;
import com.facebook.notifications.util.NotificationsUtils.3;
import com.facebook.notifications.util.NotificationsUtils.4;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.common.ReactionUnitComponentUtil;
import com.facebook.reaction.feed.environment.CanAddReactionComponentsImplProvider;
import com.facebook.reaction.feed.environment.CanHandleHScrollPageChangedEventsImpl;
import com.facebook.reaction.feed.environment.DefaultReactionFeedEnvironment;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParamsImplProvider;
import com.facebook.reaction.feed.environment.HasReactionCardBackgroundImplProvider;
import com.facebook.reaction.feed.environment.ReactionFeedActionHandler;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.today.common.HasNotifications;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: custom_flow */
public class NotificationsFeedEnvironment extends DefaultReactionFeedEnvironment implements HasNotifications {
    private final Context f16059m;
    private final NavigationLogger f16060n;
    private final GraphQLNotificationsContentProviderHelper f16061o;
    private final NotificationsFeedCollection f16062p;
    private final NotificationsLogger f16063q;
    private final NotificationsUtils f16064r;
    private final DefaultAndroidThreadUtil f16065s;
    private final ViewerContextManager f16066t;

    public final Drawable mo697b(ReactionUnitComponentNode reactionUnitComponentNode) {
        NotificationsEdgeFields a = mo971a(reactionUnitComponentNode.f18863c);
        Object obj = (a == null || a.k() == null || a.k().au() != GraphQLStorySeenState.SEEN_AND_READ) ? null : 1;
        return obj != null ? new ColorDrawable(ContextCompat.b(this.f16059m, 2131361920)) : new ColorDrawable(ContextCompat.b(this.f16059m, 2131362820));
    }

    @Inject
    public NotificationsFeedEnvironment(@Assisted Context context, @Assisted FeedListType feedListType, @Nullable @Assisted BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, @Assisted Runnable runnable, @Nullable @Assisted ReactionAnalyticsParams reactionAnalyticsParams, @Assisted ReactionFeedActionHandler reactionFeedActionHandler, @Assisted ReactionInteractionTracker reactionInteractionTracker, @Assisted ReactionSession reactionSession, @Assisted Delegate delegate, @Assisted NotificationsFeedCollection notificationsFeedCollection, CanAddReactionComponentsImplProvider canAddReactionComponentsImplProvider, CanHandleHScrollPageChangedEventsImpl canHandleHScrollPageChangedEventsImpl, HasReactionAnalyticsParamsImplProvider hasReactionAnalyticsParamsImplProvider, HasReactionCardBackgroundImplProvider hasReactionCardBackgroundImplProvider, GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper, NavigationLogger navigationLogger, NotificationsLogger notificationsLogger, NotificationsUtils notificationsUtils, DefaultAndroidThreadUtil defaultAndroidThreadUtil, ViewerContextManager viewerContextManager) {
        super(context, feedListType, baseFeedStoryMenuHelper, runnable, reactionAnalyticsParams, reactionFeedActionHandler, reactionInteractionTracker, reactionSession, delegate, canAddReactionComponentsImplProvider, canHandleHScrollPageChangedEventsImpl, hasReactionAnalyticsParamsImplProvider, hasReactionCardBackgroundImplProvider);
        this.f16059m = context;
        this.f16060n = navigationLogger;
        this.f16061o = graphQLNotificationsContentProviderHelper;
        this.f16062p = notificationsFeedCollection;
        this.f16063q = notificationsLogger;
        this.f16064r = notificationsUtils;
        this.f16065s = defaultAndroidThreadUtil;
        this.f16066t = viewerContextManager;
    }

    @Nullable
    public final NotificationsEdgeFields mo971a(String str) {
        return this.f16062p.m18845b(str);
    }

    public final void mo974a(NotificationsEdgeFields notificationsEdgeFields) {
        this.f16064r.a(ImmutableList.of(notificationsEdgeFields.k().c()), GraphQLStorySeenState.SEEN_AND_READ, this.f16066t.d());
        if (this.f16062p.m18844a(notificationsEdgeFields)) {
            this.f16061o.a(notificationsEdgeFields.k().g(), GraphQLStorySeenState.SEEN_AND_READ);
        } else {
            this.f16061o.b(notificationsEdgeFields.k().g(), GraphQLStorySeenState.SEEN_AND_READ);
        }
        this.f16062p.m18842a(notificationsEdgeFields, NotificationsMutator.a(notificationsEdgeFields));
    }

    public final boolean mo977a(String str, boolean z) {
        NotificationsEdgeFields a = mo971a(str);
        if (a == null) {
            return false;
        }
        return mo976a(a, z);
    }

    public final boolean mo976a(NotificationsEdgeFields notificationsEdgeFields, boolean z) {
        NotificationsUtils notificationsUtils = this.f16064r;
        String c = notificationsEdgeFields.k().c();
        Preconditions.checkNotNull(c);
        ExecutorDetour.a(notificationsUtils.d, new 4(notificationsUtils, c, z), -431313629);
        if (this.f16062p.m18844a(notificationsEdgeFields)) {
            this.f16061o.a(notificationsEdgeFields.k().c(), notificationsEdgeFields.k().g(), notificationsEdgeFields.k().V(), z);
        } else {
            this.f16061o.b(notificationsEdgeFields.k().c(), notificationsEdgeFields.k().g(), notificationsEdgeFields.k().V(), z);
        }
        this.f16062p.m18842a(notificationsEdgeFields, NotificationsMutator.a(notificationsEdgeFields, z));
        return true;
    }

    public final void mo975a(String str, ReactionUnitComponentFields reactionUnitComponentFields) {
        NotificationsEdgeFields a = mo971a(str);
        if (a != null) {
            ReactionUnitFragmentModel a2 = ReactionUnitComponentUtil.m22896a(a.n(), reactionUnitComponentFields, reactionUnitComponentFields.U());
            NotificationsUtils notificationsUtils = this.f16064r;
            ExecutorDetour.a(notificationsUtils.d, new 3(notificationsUtils, a.k().c(), a2), 840293687);
            GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper;
            boolean a3;
            if (this.f16062p.m18844a(a)) {
                graphQLNotificationsContentProviderHelper = this.f16061o;
                String c = a.k().c();
                graphQLNotificationsContentProviderHelper.h.b = false;
                a3 = graphQLNotificationsContentProviderHelper.h.a(c, a2);
                graphQLNotificationsContentProviderHelper.h.b = true;
            } else {
                graphQLNotificationsContentProviderHelper = this.f16061o;
                a3 = graphQLNotificationsContentProviderHelper.g.a(a.k().c(), a2);
            }
            this.f16062p.m18842a(a, NotificationsMutator.a(a, a2));
        }
    }

    public final void mo978b(String str) {
        final NotificationsEdgeFields a = mo971a(str);
        if (a != null && a.k() != null && !Strings.isNullOrEmpty(a.k().c())) {
            GraphQLStory k = a.k();
            if ((!GraphQLStorySeenState.SEEN_AND_READ.equals(a.k().au()) ? 1 : null) != null) {
                mo974a(a);
            }
            GraphQLStory c = this.f16061o.c(k.g());
            if (c != null) {
                mo973a(c, a.c());
            } else {
                this.f16065s.a(this.f16064r.a(k.c(), k.g()), new FutureCallback<GraphQLStory>(this) {
                    final /* synthetic */ NotificationsFeedEnvironment f16049b;

                    public void onSuccess(Object obj) {
                        this.f16049b.mo973a((GraphQLStory) obj, a.c());
                    }

                    public void onFailure(Throwable th) {
                    }
                });
            }
        }
    }

    public final void mo972a() {
        this.f16060n.a("tap_notification_jewel");
    }

    public final void mo973a(GraphQLStory graphQLStory, @Nullable GraphQLNotifHighlightState graphQLNotifHighlightState) {
        boolean z = !GraphQLStorySeenState.SEEN_AND_READ.equals(graphQLStory.au());
        NotificationLogObject notificationLogObject = new NotificationLogObject();
        notificationLogObject.i = graphQLStory.k();
        notificationLogObject = notificationLogObject;
        notificationLogObject.j = true;
        NotificationLogObject a = notificationLogObject.a(graphQLStory.au());
        a.k = z;
        NotificationLogObject notificationLogObject2 = a;
        notificationLogObject2.v = this.f16062p.m18839a(graphQLStory.c());
        notificationLogObject2 = notificationLogObject2;
        if (!(graphQLNotifHighlightState == null || graphQLNotifHighlightState.name() == null)) {
            notificationLogObject2.y = graphQLNotifHighlightState.name().toString();
        }
        this.f16063q.a(notificationLogObject2);
    }
}
