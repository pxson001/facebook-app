package com.facebook.feed.permalink;

import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feedback.ui.Bindable;
import com.facebook.feedback.ui.RootFeedbackEventSubscriber;
import com.facebook.feedback.ui.RootFeedbackEventSubscriberProvider;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.inject.Assisted;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: admin_time */
public class PermalinkSubstoryFeedbackEventSubscriber implements Bindable<GraphQLStory> {
    public final FeedStoryMutator f19643a;
    public final Function<GraphQLStory, Void> f19644b;
    private RootFeedbackEventSubscriberProvider f19645c;
    private FeedProps<GraphQLStory> f19646d;
    private List<RootFeedbackEventSubscriber> f19647e = new ArrayList();

    @Inject
    public PermalinkSubstoryFeedbackEventSubscriber(@Assisted Function<GraphQLStory, Void> function, RootFeedbackEventSubscriberProvider rootFeedbackEventSubscriberProvider, FeedStoryMutator feedStoryMutator) {
        this.f19644b = function;
        this.f19643a = feedStoryMutator;
        this.f19645c = rootFeedbackEventSubscriberProvider;
    }

    public final void m22913a(GraphQLStory graphQLStory) {
        if (graphQLStory != null) {
            this.f19646d = FeedProps.c(graphQLStory);
            m22912a();
            if (((GraphQLStory) this.f19646d.a).aD() > 1) {
                ImmutableList j = StoryHierarchyHelper.a((GraphQLStory) this.f19646d.a).j();
                int size = j.size();
                for (int i = 0; i < size; i++) {
                    GraphQLStory graphQLStory2 = (GraphQLStory) j.get(i);
                    final FeedProps a = this.f19646d.a(graphQLStory2);
                    RootFeedbackEventSubscriber a2 = this.f19645c.m5222a(new Function<GraphQLFeedback, Void>(this) {
                        final /* synthetic */ PermalinkSubstoryFeedbackEventSubscriber f19642b;

                        public Object apply(@Nullable Object obj) {
                            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) obj;
                            if (graphQLFeedback != null) {
                                FeedUnit f = StoryProps.f(this.f19642b.f19643a.a(a, graphQLFeedback));
                                if (f instanceof GraphQLStory) {
                                    this.f19642b.f19644b.apply((GraphQLStory) f);
                                }
                            }
                            return null;
                        }
                    }, null, null, null, null);
                    this.f19647e.add(a2);
                    a2.m5220a(graphQLStory2.l());
                }
            }
        }
    }

    public final void m22912a() {
        if (this.f19647e != null) {
            for (RootFeedbackEventSubscriber a : this.f19647e) {
                a.mo234a();
            }
            this.f19647e.clear();
        }
    }
}
