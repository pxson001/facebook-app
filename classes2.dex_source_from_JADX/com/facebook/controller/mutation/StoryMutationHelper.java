package com.facebook.controller.mutation;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.api.ufiservices.common.GraphQLActorCacheImpl;
import com.facebook.api.ufiservices.common.SetNotifyMeParams;
import com.facebook.api.ufiservices.common.TogglePageLikeParams;
import com.facebook.api.ufiservices.common.TogglePostLikeParams;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.controller.mutation.util.FeedbackGraphQLGenerator;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feedplugins.graphqlstory.page.actionablepage.PageLikeActionLinkResolver;
import com.facebook.feedplugins.graphqlstory.page.actionablepage.PrimaryActionLinkResolver;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

/* compiled from: play_audio_interstitial */
public class StoryMutationHelper {
    public static final String f9541a = StoryMutationHelper.class.getSimpleName();
    public final FeedStoryMutator f9542b;
    public final GraphQLActorCacheImpl f9543c;
    public final AnalyticsLogger f9544d;
    public final CommonEventsBuilder f9545e;
    private final TasksManager f9546f;
    public final FeedbackGraphQLGenerator f9547g;
    private final PageLikeActionLinkResolver f9548h;
    public final AbstractFbErrorReporter f9549i;

    public static StoryMutationHelper m14528b(InjectorLike injectorLike) {
        return new StoryMutationHelper(FeedStoryMutator.m10586b(injectorLike), GraphQLActorCacheImpl.m14532a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), CommonEventsBuilder.m14539b(injectorLike), TasksManager.m14550b(injectorLike), FeedbackGraphQLGenerator.m14563a(injectorLike), PageLikeActionLinkResolver.m14608a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike));
    }

    public static StoryMutationHelper m14526a(InjectorLike injectorLike) {
        return m14528b(injectorLike);
    }

    @Inject
    public StoryMutationHelper(FeedStoryMutator feedStoryMutator, GraphQLActorCacheImpl graphQLActorCacheImpl, AnalyticsLogger analyticsLogger, CommonEventsBuilder commonEventsBuilder, TasksManager tasksManager, FeedbackGraphQLGenerator feedbackGraphQLGenerator, PageLikeActionLinkResolver pageLikeActionLinkResolver, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f9542b = feedStoryMutator;
        this.f9543c = graphQLActorCacheImpl;
        this.f9544d = analyticsLogger;
        this.f9545e = commonEventsBuilder;
        this.f9546f = tasksManager;
        this.f9547g = feedbackGraphQLGenerator;
        this.f9548h = pageLikeActionLinkResolver;
        this.f9549i = abstractFbErrorReporter;
    }

    public final void m14531a(String str, FeedProps<GraphQLStory> feedProps, String str2, String str3, String str4, String str5, boolean z, MutationCallback<FeedUnit> mutationCallback) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.m19804a();
        GraphQLStoryActionLink a = m14527a(graphQLStory, str, z);
        if (a == null && !z) {
            if (graphQLStory.m22326L() != null) {
                Flattenable L = graphQLStory.m22326L();
                a = m14527a(L, str, z);
                FeedProps a2 = feedProps.m19803a(L);
            } else {
                return;
            }
        }
        if (a != null) {
            FeedProps a3 = this.f9542b.m10598a(a2, a);
            GraphQLStory graphQLStory2 = (GraphQLStory) a3.m19804a();
            FeedUnit f = StoryProps.m27459f(a3);
            if (mutationCallback != null) {
                mutationCallback.mo2181a(f);
            }
            GraphQLPage ab = z ? PrimaryActionLinkResolver.m31292a(graphQLStory2).ab() : PageLikeActionLinkResolver.m14609a(graphQLStory2).ab();
            TogglePageLikeParams a4 = TogglePageLikeParams.a().a(ab.ae()).a(ab.m23463O()).a(new FeedbackLoggingParams(TrackableFeedProps.m27451a(a3), str4, str3)).b(str5).a();
            if (str2 != null) {
                this.f9544d.mo526a(CommonEventsBuilder.m14537a(str2, ab.ae(), String.valueOf(ab.m23463O()), str3));
            }
            this.f9546f.m14556a("task_key_toggle_page_like" + ab.ae(), new 1(this, a4, a3), new 2(this, mutationCallback, graphQLStory, str2, ab, str3));
        }
    }

    private GraphQLStoryActionLink m14527a(GraphQLStory graphQLStory, String str, boolean z) {
        GraphQLStoryActionLink a;
        if (z) {
            a = PrimaryActionLinkResolver.m31292a(graphQLStory);
            if (a == null || a.m22901a() == null || -581184810 != a.m22901a().m22301g()) {
                return null;
            }
        }
        a = PageLikeActionLinkResolver.m14609a(graphQLStory);
        if (a == null || a.ab() == null || a.ab().ae() == null || !a.ab().ae().equals(str)) {
            return null;
        }
        return a;
    }

    public final void m14529a(FeedProps<GraphQLStory> feedProps, boolean z, long j, String str, String str2, MutationCallback<FeedUnit> mutationCallback) {
        if (feedProps != null) {
            GraphQLStory graphQLStory = (GraphQLStory) feedProps.m19804a();
            if (graphQLStory != null && graphQLStory.m22369z()) {
                FeedProps a = this.f9542b.m10595a((FeedProps) feedProps, this.f9543c.m14534a(), z);
                graphQLStory = (GraphQLStory) a.m19804a();
                FeedProps b = feedProps.m19805b(graphQLStory);
                FeedUnit f = StoryProps.m27459f(a);
                if (f == null) {
                    this.f9549i.m2350b(f9541a, "Feedbackable should either be a FeedUnit or it's root should be a FeedUnit");
                } else if (mutationCallback != null) {
                    mutationCallback.mo2181a(f);
                }
                GraphQLFeedback l = graphQLStory.mo2890l();
                this.f9546f.m14556a("task_key_set_like_" + l.mo2933j() + "_" + j, new 3(this, TogglePostLikeParams.a().a(graphQLStory.m22316B()).a(this.f9543c.m14534a()).a(l).a(new FeedbackLoggingParams(TrackableFeedProps.m27451a(feedProps), str2, str)).a()), new 4(this, mutationCallback, f, b, z));
            }
        }
    }

    public final void m14530a(FeedProps<GraphQLStory> feedProps, boolean z, String str, String str2, MutationCallback<FeedUnit> mutationCallback) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.m19804a();
        String j = graphQLStory.mo2890l() != null ? graphQLStory.mo2890l().mo2933j() : null;
        FeedUnit f = StoryProps.m27459f(this.f9542b.m10602a((FeedProps) feedProps, z));
        mutationCallback.mo2181a(f);
        if (!(str == null || str2 == null)) {
            this.f9544d.mo526a(CommonEventsBuilder.m14540b(str, j, String.valueOf(z), str2));
        }
        this.f9546f.m14553a("set_notify_me_" + graphQLStory.m22350c(), this.f9547g.m14576a(SetNotifyMeParams.f().d(graphQLStory.m22350c()).c(graphQLStory.ai()).b(j).a(z).e(f9541a).g()), new 5(this, mutationCallback, f, feedProps, str, str2, j, z));
    }
}
