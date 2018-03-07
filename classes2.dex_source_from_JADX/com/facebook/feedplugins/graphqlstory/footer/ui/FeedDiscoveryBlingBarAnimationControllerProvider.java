package com.facebook.feedplugins.graphqlstory.footer.ui;

import com.facebook.feedback.abtest.FeedDiscoveryExperimentUtil;
import com.facebook.feedplugins.graphqlstory.footer.FeedDiscoveryBlingBarPartDefinition.FeedDiscoveryViewStateChangeListener;
import com.facebook.feedplugins.graphqlstory.footer.ui.FeedDiscoveryBlingBarAnimationController.FeedDiscoveryViewState;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.AbstractAssistedProvider;
import java.util.List;

/* compiled from: hashtag/%s?name=%s&id=%s */
public class FeedDiscoveryBlingBarAnimationControllerProvider extends AbstractAssistedProvider<FeedDiscoveryBlingBarAnimationController> {
    public final FeedDiscoveryBlingBarAnimationController m28942a(FeedDiscoveryViewState feedDiscoveryViewState, FeedDiscoveryViewStateChangeListener feedDiscoveryViewStateChangeListener, List<String> list, GraphQLTextWithEntities graphQLTextWithEntities) {
        return new FeedDiscoveryBlingBarAnimationController(FeedDiscoveryBlingBarAnimationUtil.a(this), FeedDiscoveryExperimentUtil.m10422a(this), feedDiscoveryViewState, feedDiscoveryViewStateChangeListener, list, graphQLTextWithEntities);
    }
}
