package com.facebook.reaction.feed.environment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.inject.Assisted;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionMoreSubComponentsResultModel.ReactionPaginatedComponentsModel;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: custom_cta_view_create_mobile */
public class DefaultReactionFeedEnvironment extends BaseFeedEnvironment implements FeedEnvironment, ReactionFeedEnvironment {
    private final BaseFeedStoryMenuHelper f16050m;
    private final CanAddReactionComponentsImpl f16051n;
    private final CanHandleHScrollPageChangedEventsImpl f16052o;
    private final FeedListType f16053p;
    private final HasReactionAnalyticsParamsImpl f16054q;
    private final HasReactionCardBackgroundImpl f16055r;
    private final ReactionFeedActionHandler f16056s;
    private final ReactionInteractionTracker f16057t;
    private final ReactionSession f16058u;

    @Inject
    public DefaultReactionFeedEnvironment(@Assisted Context context, @Assisted FeedListType feedListType, @Nullable @Assisted BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, @Assisted Runnable runnable, @Nullable @Assisted ReactionAnalyticsParams reactionAnalyticsParams, @Assisted ReactionFeedActionHandler reactionFeedActionHandler, @Assisted ReactionInteractionTracker reactionInteractionTracker, @Assisted ReactionSession reactionSession, @Assisted Delegate delegate, CanAddReactionComponentsImplProvider canAddReactionComponentsImplProvider, CanHandleHScrollPageChangedEventsImpl canHandleHScrollPageChangedEventsImpl, HasReactionAnalyticsParamsImplProvider hasReactionAnalyticsParamsImplProvider, HasReactionCardBackgroundImplProvider hasReactionCardBackgroundImplProvider) {
        super(context, runnable, delegate);
        this.f16056s = reactionFeedActionHandler;
        this.f16053p = feedListType;
        this.f16050m = baseFeedStoryMenuHelper;
        if (this.f16050m != null) {
            this.f16050m.D = this;
        }
        this.f16051n = CanAddReactionComponentsImplProvider.m23141a(this);
        this.f16052o = canHandleHScrollPageChangedEventsImpl;
        this.f16054q = HasReactionAnalyticsParamsImplProvider.m23151a(reactionAnalyticsParams);
        this.f16055r = HasReactionCardBackgroundImplProvider.m23153a(context);
        this.f16057t = reactionInteractionTracker;
        this.f16058u = reactionSession;
    }

    public final BaseFeedStoryMenuHelper m18856e() {
        return this.f16050m;
    }

    public final FeedListType m18855c() {
        return this.f16053p;
    }

    public final ReactionInteractionTracker kE_() {
        return this.f16057t;
    }

    public final ReactionSession mo704p() {
        return this.f16058u;
    }

    public final void mo695a(String str, String str2, @Nullable ReactionAttachmentIntent reactionAttachmentIntent) {
        this.f16056s.mo695a(str, str2, reactionAttachmentIntent);
    }

    public final void mo696a(String str, String str2, @Nullable String str3, @Nullable ReactionAttachmentIntent reactionAttachmentIntent) {
        this.f16056s.mo696a(str, str2, str3, reactionAttachmentIntent);
    }

    @Nullable
    public final ReactionCardContainer mo705q() {
        return this.f16056s.mo705q();
    }

    public final void mo694a(ReactionPaginatedComponentsModel reactionPaginatedComponentsModel, ReactionUnitComponentNode reactionUnitComponentNode) {
        this.f16051n.mo694a(reactionPaginatedComponentsModel, reactionUnitComponentNode);
    }

    @Nullable
    public final ReactionAnalyticsParams mo706r() {
        return this.f16054q.mo706r();
    }

    public final void mo689a(int i, ReactionUnitComponentFields reactionUnitComponentFields, ReactionUnitComponentNode reactionUnitComponentNode) {
        this.f16052o.mo689a(i, reactionUnitComponentFields, reactionUnitComponentNode);
    }

    public final void mo698b(int i, ReactionUnitComponentFields reactionUnitComponentFields, ReactionUnitComponentNode reactionUnitComponentNode) {
        this.f16052o.mo698b(i, reactionUnitComponentFields, reactionUnitComponentNode);
    }

    public final void mo692a(ReactionUnitComponentNode reactionUnitComponentNode) {
        this.f16052o.mo692a(reactionUnitComponentNode);
    }

    public Drawable mo697b(ReactionUnitComponentNode reactionUnitComponentNode) {
        return this.f16055r.mo697b(reactionUnitComponentNode);
    }
}
