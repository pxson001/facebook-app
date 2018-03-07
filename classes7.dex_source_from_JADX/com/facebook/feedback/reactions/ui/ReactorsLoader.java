package com.facebook.feedback.reactions.ui;

import android.view.View;
import com.facebook.api.feed.data.AppendOnlyGraphQLObjectCollection;
import com.facebook.api.feed.data.AppendOnlyGraphQLObjectCollectionConverter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.Tuple;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.feedback.reactions.ui.TabbedReactorsListFragment.ReactionTypeRetryTrigger;
import com.facebook.feedback.reactions.ui.TabbedReactorsListFragment.TabbedReactorsLoaderConfiguration;
import com.facebook.feedback.reactions.ui.TabbedReactorsListFragment.TabbedReactorsLoaderListener;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.model.GraphQLReactorsOfContentConnection;
import com.facebook.graphql.model.GraphQLReactorsOfContentEdge;
import com.facebook.inject.InjectorLike;
import com.facebook.ufiservices.data.FeedbackLoader;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: settingValue */
public class ReactorsLoader {
    private static final Function<ActorReactionPair, String> f3915a = new C03381();
    public final TasksManager f3916b;
    private final FeedbackLoader f3917c;
    public final FeedbackReactionsController f3918d;
    public final ImmutableList<FeedbackReaction> f3919e;
    public AppendOnlyGraphQLObjectCollection<ActorReactionPair>[] f3920f;
    public boolean[] f3921g;
    public int[] f3922h;
    public TabbedReactorsLoaderListener f3923i = null;
    public TabbedReactorsLoaderConfiguration f3924j = null;

    /* compiled from: settingValue */
    final class C03381 implements Function<ActorReactionPair, String> {
        C03381() {
        }

        public final Object apply(Object obj) {
            return ((ActorReactionPair) obj).f3861a.H();
        }
    }

    public static ReactorsLoader m4555b(InjectorLike injectorLike) {
        return new ReactorsLoader(TasksManager.b(injectorLike), FeedbackLoader.a(injectorLike), FeedbackReactionsController.a(injectorLike));
    }

    @Inject
    public ReactorsLoader(TasksManager tasksManager, FeedbackLoader feedbackLoader, FeedbackReactionsController feedbackReactionsController) {
        this.f3916b = tasksManager;
        this.f3917c = feedbackLoader;
        this.f3918d = feedbackReactionsController;
        this.f3919e = this.f3918d.b();
    }

    private void m4557d() {
        if (this.f3923i != null) {
            TabbedReactorsLoaderListener tabbedReactorsLoaderListener = this.f3923i;
        }
    }

    public static void m4551a(ReactorsLoader reactorsLoader, FeedbackReaction feedbackReaction, Throwable th) {
        if (reactorsLoader.f3923i != null) {
            TabbedReactorsListFragment tabbedReactorsListFragment = reactorsLoader.f3923i.f3955a;
            String a = tabbedReactorsListFragment.f3872e.a(ServiceException.a(th), true, true);
            if (tabbedReactorsListFragment.am != null) {
                View findViewWithTag = tabbedReactorsListFragment.am.findViewWithTag(feedbackReaction);
                if (findViewWithTag != null) {
                    ((LoadingIndicatorView) FindViewUtil.b(findViewWithTag, 2131562221)).a(a, new ReactionTypeRetryTrigger(tabbedReactorsListFragment, feedbackReaction));
                }
            }
            tabbedReactorsListFragment.al.b(8519681, (short) 3);
        }
    }

    private String m4559e() {
        return this.f3924j.f3954a.ar;
    }

    private void m4549a(int i, AppendOnlyGraphQLObjectCollection<ActorReactionPair> appendOnlyGraphQLObjectCollection) {
        if (m4553a(i)) {
            this.f3920f[i] = appendOnlyGraphQLObjectCollection;
        }
    }

    protected final AppendOnlyGraphQLObjectCollection<ActorReactionPair> m4560a(FeedbackReaction feedbackReaction) {
        int e = m4558e(this, feedbackReaction);
        if (m4553a(e)) {
            return this.f3920f[e];
        }
        return null;
    }

    public final int m4563b(FeedbackReaction feedbackReaction) {
        int e = m4558e(this, feedbackReaction);
        if (m4553a(e)) {
            return this.f3922h[e];
        }
        return 0;
    }

    private boolean m4553a(int i) {
        return i >= 0 && i < this.f3920f.length;
    }

    private static DataFreshnessParam m4547a(boolean z) {
        return z ? DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA : DataFreshnessParam.STALE_DATA_OKAY;
    }

    public final void m4562a(FeedbackReaction feedbackReaction, int i, boolean z) {
        if (!this.f3921g[m4558e(this, feedbackReaction)] && m4559e() != null) {
            Preconditions.checkArgument(i > 0);
            this.f3921g[m4558e(this, feedbackReaction)] = true;
            Object obj = null;
            for (AppendOnlyGraphQLObjectCollection appendOnlyGraphQLObjectCollection : this.f3920f) {
                if (appendOnlyGraphQLObjectCollection != null && appendOnlyGraphQLObjectCollection.c() != 0) {
                    break;
                }
            }
            obj = 1;
            if (obj != null) {
                m4557d();
            }
            DataFreshnessParam a = m4547a(z);
            String a2 = this.f3920f[m4558e(this, feedbackReaction)].a();
            this.f3916b.a(m4548a(feedbackReaction, a2), this.f3917c.a(m4559e(), feedbackReaction, a2, i, a, this.f3924j.m4585b()), m4554b(feedbackReaction, i, z));
        }
    }

    private AbstractDisposableFutureCallback<GraphQLFeedback> m4554b(final FeedbackReaction feedbackReaction, final int i, final boolean z) {
        return new AbstractDisposableFutureCallback<GraphQLFeedback>(this) {
            final /* synthetic */ ReactorsLoader f3914d;

            public final void m4544a(Object obj) {
                GraphQLFeedback graphQLFeedback = (GraphQLFeedback) obj;
                if (graphQLFeedback == null) {
                    ReactorsLoader.m4551a(this.f3914d, feedbackReaction, new NullPointerException("Null feedback received"));
                    return;
                }
                ReactorsLoader.m4552a(this.f3914d, graphQLFeedback, feedbackReaction);
                this.f3914d.f3921g[ReactorsLoader.m4558e(this.f3914d, feedbackReaction)] = false;
                ReactorsLoader reactorsLoader = this.f3914d;
                FeedbackReaction feedbackReaction = feedbackReaction;
                if (reactorsLoader.f3923i != null) {
                    reactorsLoader.f3923i.f3955a.m4519c(feedbackReaction);
                }
            }

            public final void m4545a(Throwable th) {
                this.f3914d.f3921g[ReactorsLoader.m4558e(this.f3914d, feedbackReaction)] = false;
                if (z) {
                    this.f3914d.m4562a(feedbackReaction, i, false);
                }
                ReactorsLoader.m4551a(this.f3914d, feedbackReaction, th);
            }
        };
    }

    public static void m4552a(ReactorsLoader reactorsLoader, GraphQLFeedback graphQLFeedback, FeedbackReaction feedbackReaction) {
        GraphQLReactorsOfContentConnection graphQLReactorsOfContentConnection;
        if (graphQLFeedback == null || GraphQLHelper.r(graphQLFeedback) == null || GraphQLHelper.r(graphQLFeedback).j().isEmpty()) {
            graphQLReactorsOfContentConnection = null;
        } else {
            graphQLReactorsOfContentConnection = GraphQLHelper.r(graphQLFeedback);
        }
        reactorsLoader.m4550a(feedbackReaction, graphQLReactorsOfContentConnection);
    }

    private Tuple<List<ActorReactionPair>, GraphQLPageInfo> m4546a(GraphQLReactorsOfContentConnection graphQLReactorsOfContentConnection) {
        if (graphQLReactorsOfContentConnection == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ImmutableList j = graphQLReactorsOfContentConnection.j();
        int size = j.size();
        for (int i = 0; i < size; i++) {
            Object obj;
            GraphQLReactorsOfContentEdge graphQLReactorsOfContentEdge = (GraphQLReactorsOfContentEdge) j.get(i);
            FeedbackReaction a = this.f3918d.a(graphQLReactorsOfContentEdge.a().m());
            if (a == null || !this.f3919e.contains(a)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                arrayList.add(new ActorReactionPair(graphQLReactorsOfContentEdge.j(), Integer.valueOf(graphQLReactorsOfContentEdge.a().m())));
            }
        }
        ArrayList arrayList2 = arrayList;
        GraphQLPageInfo k = graphQLReactorsOfContentConnection.k();
        if (k == null) {
            k = new GraphQLPageInfo();
        }
        return new Tuple(arrayList2, k);
    }

    private void m4550a(FeedbackReaction feedbackReaction, GraphQLReactorsOfContentConnection graphQLReactorsOfContentConnection) {
        Tuple a = m4546a(graphQLReactorsOfContentConnection);
        if (a != null) {
            this.f3922h[m4558e(this, feedbackReaction)] = graphQLReactorsOfContentConnection.a();
            this.f3920f[m4558e(this, feedbackReaction)].a((Iterable) a.a, AppendOnlyGraphQLObjectCollectionConverter.a((GraphQLPageInfo) a.b));
        }
    }

    private static Object m4548a(FeedbackReaction feedbackReaction, String str) {
        if (m4556c(feedbackReaction)) {
            return str;
        }
        return feedbackReaction.e + str;
    }

    public static int m4558e(ReactorsLoader reactorsLoader, FeedbackReaction feedbackReaction) {
        return reactorsLoader.f3919e.indexOf(feedbackReaction);
    }

    public final void m4561a() {
        int size = this.f3919e.size();
        this.f3921g = new boolean[size];
        this.f3920f = new AppendOnlyGraphQLObjectCollection[size];
        this.f3922h = new int[size];
        for (size = 0; size < this.f3920f.length; size++) {
            m4549a(size, new AppendOnlyGraphQLObjectCollection(f3915a));
        }
    }

    public static final boolean m4556c(FeedbackReaction feedbackReaction) {
        return feedbackReaction == FeedbackReaction.c;
    }
}
