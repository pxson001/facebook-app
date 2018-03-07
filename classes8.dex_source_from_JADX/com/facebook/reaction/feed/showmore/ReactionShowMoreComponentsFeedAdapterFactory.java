package com.facebook.reaction.feed.showmore;

import android.content.Context;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.feed.environment.DefaultReactionFeedEnvironment;
import com.facebook.reaction.feed.environment.DefaultReactionFeedEnvironmentProvider;
import com.facebook.reaction.feed.environment.ReactionFeedActionHandlerProvider;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionVerticalListUnitComponentGroupPartDefinition;
import javax.inject.Inject;

/* compiled from: android.settings.AIRPLANE_MODE_SETTINGS */
public class ReactionShowMoreComponentsFeedAdapterFactory {
    private final ReactionFeedActionHandlerProvider f19498a;
    private final MultiRowAdapterBuilder f19499b;
    private final Lazy<ReactionVerticalListUnitComponentGroupPartDefinition<DefaultReactionFeedEnvironment>> f19500c;
    private final DefaultReactionFeedEnvironmentProvider f19501d;

    public static ReactionShowMoreComponentsFeedAdapterFactory m23444b(InjectorLike injectorLike) {
        return new ReactionShowMoreComponentsFeedAdapterFactory((ReactionFeedActionHandlerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionFeedActionHandlerProvider.class), MultiRowAdapterBuilder.b(injectorLike), IdBasedLazy.a(injectorLike, 10026), (DefaultReactionFeedEnvironmentProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DefaultReactionFeedEnvironmentProvider.class));
    }

    @Inject
    public ReactionShowMoreComponentsFeedAdapterFactory(ReactionFeedActionHandlerProvider reactionFeedActionHandlerProvider, MultiRowAdapterBuilder multiRowAdapterBuilder, Lazy<ReactionVerticalListUnitComponentGroupPartDefinition> lazy, DefaultReactionFeedEnvironmentProvider defaultReactionFeedEnvironmentProvider) {
        this.f19498a = reactionFeedActionHandlerProvider;
        this.f19499b = multiRowAdapterBuilder;
        this.f19500c = lazy;
        this.f19501d = defaultReactionFeedEnvironmentProvider;
    }

    public final MultiRowAdapter m23445a(Context context, FeedListType feedListType, BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, ReactionShowMoreComponentsItemCollection reactionShowMoreComponentsItemCollection, Runnable runnable, ReactionCardContainer reactionCardContainer, ReactionSession reactionSession, Delegate delegate) {
        DefaultReactionFeedEnvironmentProvider defaultReactionFeedEnvironmentProvider = this.f19501d;
        return this.f19499b.a(this.f19500c, reactionShowMoreComponentsItemCollection).a(defaultReactionFeedEnvironmentProvider.m23149a(context, feedListType, baseFeedStoryMenuHelper, runnable, new ReactionAnalyticsParams("unknown", "unknown", "unknown", "unknown", null), this.f19498a.m23162a(context, reactionCardContainer), reactionCardContainer.getInteractionTracker(), reactionSession, delegate)).e();
    }
}
