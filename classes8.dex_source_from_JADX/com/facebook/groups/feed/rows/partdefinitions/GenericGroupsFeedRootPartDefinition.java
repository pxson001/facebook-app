package com.facebook.groups.feed.rows.partdefinitions;

import com.facebook.api.feed.data.EndOfFeedSentinel.EndOfFeedSentinelFeedUnit;
import com.facebook.api.feed.data.LoadingMoreSentinel.LoadingMoreSentinelFeedUnit;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.parts.RootPartSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.common.unknown.UnknownFeedUnitMultiRowGroupPartDefinition;
import com.facebook.feed.rows.sections.hidden.HiddenUnitGroupPartDefinition;
import com.facebook.feedplugins.egolistview.rows.GroupYouShouldJoinPartDefinition;
import com.facebook.feedplugins.gysc.partdefinitions.GroupsYouShouldCreateHScrollRowPartDefinition;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLGroupsYouShouldCreateFeedUnit;
import com.facebook.graphql.model.GraphQLGroupsYouShouldJoinFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.HideableUnit;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowGroupPartDefinition;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: facepile_image_size */
public class GenericGroupsFeedRootPartDefinition<E extends FeedEnvironment> extends BaseMultiRowGroupPartDefinition<FeedUnit, Void, E> {
    private final RootPartSelector<E> f14148a;

    public final Object m15701a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        this.f14148a.a(baseMultiRowSubParts, (FeedUnit) obj);
        return null;
    }

    @Inject
    public GenericGroupsFeedRootPartDefinition(@Assisted Lazy<? extends MultiRowGroupPartDefinition<FeedProps<GraphQLStory>, ?, ? super E>> lazy, @Nullable @Assisted Lazy<? extends MultiRowGroupPartDefinition<FeedProps<GraphQLStory>, ?, ? super E>> lazy2, @Assisted Lazy<? extends MultiRowSinglePartDefinition<FeedProps<LoadingMoreSentinelFeedUnit>, ?, ? super E, ?>> lazy3, @Assisted Lazy<? extends MultiRowSinglePartDefinition<FeedProps<EndOfFeedSentinelFeedUnit>, ?, ? super E, ?>> lazy4, Lazy<HiddenUnitGroupPartDefinition> lazy5, Lazy<GroupYouShouldJoinPartDefinition> lazy6, Lazy<GroupsYouShouldCreateHScrollRowPartDefinition> lazy7, Lazy<UnknownFeedUnitMultiRowGroupPartDefinition> lazy8) {
        this.f14148a = RootPartSelector.a().b(HideableUnit.class, lazy5);
        if (lazy2 != null) {
            this.f14148a.b(GraphQLStory.class, lazy2);
        }
        this.f14148a.b(GraphQLStory.class, lazy).b(LoadingMoreSentinelFeedUnit.class, lazy3).b(EndOfFeedSentinelFeedUnit.class, lazy4).b(GraphQLGroupsYouShouldJoinFeedUnit.class, lazy6).b(GraphQLGroupsYouShouldCreateFeedUnit.class, lazy7).a(Object.class, lazy8);
    }

    public final boolean m15702a(Object obj) {
        return true;
    }
}
