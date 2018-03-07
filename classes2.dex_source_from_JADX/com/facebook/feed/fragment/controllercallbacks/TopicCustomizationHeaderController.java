package com.facebook.feed.fragment.controllercallbacks;

import android.content.Intent;
import com.facebook.api.feed.FetchFeedParams.FetchFeedCause;
import com.facebook.api.feed.data.LegacyFeedUnitUpdater;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.api.feedcache.db.FeedDbMutationService;
import com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbDeleteStoryRequest;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.api.Holder;
import com.facebook.controllercallbacks.fragment.ActivityResultCallback;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.fragment.NewsFeedFragment;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.feed.rows.controllercallbacks.AdapterCreatedCallback;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLTopicCustomizationStory;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.listview.ScrollingViewProxy;
import javax.inject.Inject;

/* compiled from: phone_e164 */
public class TopicCustomizationHeaderController extends BaseController implements ActivityResultCallback, AdapterCreatedCallback {
    @Inject
    public FeedDbMutationService f10159a;
    public NewsFeedFragment f10160b;
    private HasInvalidate f10161c;
    public Holder<LegacyFeedUnitUpdater> f10162d;
    public Holder<ListItemCollection<FeedEdge>> f10163e;

    public static TopicCustomizationHeaderController m15259a(InjectorLike injectorLike) {
        TopicCustomizationHeaderController topicCustomizationHeaderController = new TopicCustomizationHeaderController();
        topicCustomizationHeaderController.f10159a = FeedDbMutationService.m9091a(injectorLike);
        return topicCustomizationHeaderController;
    }

    public final void mo1941a(int i, int i2, Intent intent) {
        if (i == 2056 && i2 == -1) {
            for (int i3 = 0; i3 < ((ListItemCollection) this.f10163e.f10429a).mo1374a(); i3++) {
                GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) ((ListItemCollection) this.f10163e.f10429a).mo1375a(i3);
                if (graphQLFeedUnitEdge.mo2540c() instanceof GraphQLTopicCustomizationStory) {
                    this.f10159a.m9112a(new FeedDbDeleteStoryRequest(graphQLFeedUnitEdge.m19080b()));
                    ((LegacyFeedUnitUpdater) this.f10162d.f10429a).mo1380a(graphQLFeedUnitEdge);
                    this.f10161c.mo2437a(FeedProps.m19802c(graphQLFeedUnitEdge.mo2540c()));
                }
            }
            this.f10160b.m13866a(FetchFeedCause.PULL_TO_REFRESH);
        }
    }

    public final void mo1889a(HasMultiRow hasMultiRow, ScrollingViewProxy scrollingViewProxy, FeedEnvironment feedEnvironment) {
        this.f10161c = feedEnvironment;
    }

    public final void kF_() {
        this.f10161c = null;
    }
}
