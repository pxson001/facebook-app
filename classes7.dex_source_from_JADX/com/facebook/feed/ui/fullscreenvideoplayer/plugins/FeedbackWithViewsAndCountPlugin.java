package com.facebook.feed.ui.fullscreenvideoplayer.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewStub;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.content.event.FbEvent;
import com.facebook.feed.protocol.FetchVideoBroadcastPlayAndFeedbackCountGraphQL.FetchVideoBroadcastPlayAndFeedbackCountQueryString;
import com.facebook.feed.protocol.FetchVideoBroadcastPlayAndFeedbackCountGraphQLModels.FetchVideoBroadcastPlayAndFeedbackCountQueryModel;
import com.facebook.feed.protocol.FetchVideoBroadcastPlayAndFeedbackCountGraphQLModels.FetchVideoBroadcastPlayAndFeedbackCountQueryModel.FeedbackModel;
import com.facebook.feed.protocol.FetchVideoBroadcastPlayAndFeedbackCountGraphQLModels.FetchVideoBroadcastPlayAndFeedbackCountQueryModel.FeedbackModel.CommentsModel;
import com.facebook.feed.protocol.FetchVideoBroadcastPlayAndFeedbackCountGraphQLModels.FetchVideoBroadcastPlayAndFeedbackCountQueryModel.FeedbackModel.LikersModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.Feedbackable;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLFeedback.Builder;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTopLevelCommentsConnection;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.mutator.GraphQLLikersOfContentConnectionMutator;
import com.facebook.graphql.model.mutator.GraphQLTopLevelCommentsConnectionMutator;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import com.facebook.resources.utils.ResourceUtils;
import com.facebook.ui.futures.TasksManager;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: TimelineFragmentCreate */
public class FeedbackWithViewsAndCountPlugin extends FeedbackWithCountPlugin {
    public static final String f22055u = FeedbackWithViewsAndCountPlugin.class.getName();
    @Inject
    public GraphQLQueryExecutor f22056r;
    @Inject
    public AbstractFbErrorReporter f22057s;
    @Inject
    public TasksManager f22058t;
    @Nullable
    public FbTextView f22059v;
    @Nullable
    public String f22060w;

    /* compiled from: TimelineFragmentCreate */
    public class C18801 extends AbstractDisposableFutureCallback<GraphQLResult<FetchVideoBroadcastPlayAndFeedbackCountQueryModel>> {
        final /* synthetic */ String f22052a;
        final /* synthetic */ FeedbackWithViewsAndCountPlugin f22053b;

        public C18801(FeedbackWithViewsAndCountPlugin feedbackWithViewsAndCountPlugin, String str) {
            this.f22053b = feedbackWithViewsAndCountPlugin;
            this.f22052a = str;
        }

        protected final void m24650a(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null) {
                FetchVideoBroadcastPlayAndFeedbackCountQueryModel fetchVideoBroadcastPlayAndFeedbackCountQueryModel = (FetchVideoBroadcastPlayAndFeedbackCountQueryModel) graphQLResult.e;
                String str;
                if (fetchVideoBroadcastPlayAndFeedbackCountQueryModel == null) {
                    str = FeedbackWithViewsAndCountPlugin.f22055u;
                    return;
                }
                str = FeedbackWithViewsAndCountPlugin.f22055u;
                Integer.valueOf(fetchVideoBroadcastPlayAndFeedbackCountQueryModel.j());
                int j = fetchVideoBroadcastPlayAndFeedbackCountQueryModel.j();
                if (j > 0) {
                    CharSequence a = ResourceUtils.a(this.f22053b.getResources(), 2131232775, 2131232776, j, new Object[]{this.f22053b.f22038m.a(j, 1)});
                    if (this.f22053b.f22059v == null) {
                        this.f22053b.f22059v = (FbTextView) this.f22053b.f22034b.inflate();
                    }
                    this.f22053b.f22059v.setText(a);
                    this.f22053b.f22059v.setVisibility(0);
                }
                FeedbackModel a2 = fetchVideoBroadcastPlayAndFeedbackCountQueryModel.a();
                if (a2 != null) {
                    GraphQLFeedback l = ((GraphQLStory) this.f22053b.f22033a.a).l();
                    if (l != null) {
                        Builder a3 = Builder.a(l);
                        LikersModel j2 = a2.j();
                        if (j2 != null) {
                            a3.C = GraphQLLikersOfContentConnectionMutator.a(GraphQLHelper.o(l)).a(j2.a()).a;
                        }
                        CommentsModel a4 = a2.a();
                        if (a4 != null) {
                            GraphQLTopLevelCommentsConnection n = GraphQLHelper.n(l);
                            Preconditions.checkNotNull(n);
                            GraphQLTopLevelCommentsConnectionMutator graphQLTopLevelCommentsConnectionMutator = new GraphQLTopLevelCommentsConnectionMutator(n);
                            graphQLTopLevelCommentsConnectionMutator.a.a(a4.a());
                            graphQLTopLevelCommentsConnectionMutator = graphQLTopLevelCommentsConnectionMutator;
                            graphQLTopLevelCommentsConnectionMutator.a.a(a4.a());
                            a3.L = graphQLTopLevelCommentsConnectionMutator.a;
                        }
                        GraphQLStory.Builder a5 = GraphQLStory.Builder.a((GraphQLStory) this.f22053b.f22033a.a);
                        a5.D = a3.a();
                        GraphQLStory a6 = a5.a();
                        this.f22053b.a = this.f22053b.f22033a.b(a6);
                        this.f22053b.m24646a((Feedbackable) this.f22053b.f22033a.a);
                    }
                }
            }
        }

        protected final void m24651a(Throwable th) {
            this.f22053b.f22057s.a(FeedbackWithViewsAndCountPlugin.f22055u, "video broadcast request failed for " + this.f22052a, th);
        }
    }

    /* compiled from: TimelineFragmentCreate */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ FeedbackWithViewsAndCountPlugin f22054a;

        public PlayerStateChangedEventSubscriber(FeedbackWithViewsAndCountPlugin feedbackWithViewsAndCountPlugin) {
            this.f22054a = feedbackWithViewsAndCountPlugin;
        }

        public final void m24653b(FbEvent fbEvent) {
            RVPPlayerStateChangedEvent rVPPlayerStateChangedEvent = (RVPPlayerStateChangedEvent) fbEvent;
            if (this.f22054a.f22060w != null && this.f22054a.f22060w.equals(rVPPlayerStateChangedEvent.a) && rVPPlayerStateChangedEvent.b == State.PLAYBACK_COMPLETE) {
                this.f22054a.m24646a((Feedbackable) this.f22054a.f22033a.a);
                FeedbackWithViewsAndCountPlugin feedbackWithViewsAndCountPlugin = this.f22054a;
                if (feedbackWithViewsAndCountPlugin.f22060w != null) {
                    GraphQlQueryString fetchVideoBroadcastPlayAndFeedbackCountQueryString = new FetchVideoBroadcastPlayAndFeedbackCountQueryString();
                    fetchVideoBroadcastPlayAndFeedbackCountQueryString.a("video_id", feedbackWithViewsAndCountPlugin.f22060w);
                    feedbackWithViewsAndCountPlugin.f22058t.a("fetchVideoBroadcastPlayCount", feedbackWithViewsAndCountPlugin.f22056r.a(GraphQLRequest.a(fetchVideoBroadcastPlayAndFeedbackCountQueryString)), new C18801(feedbackWithViewsAndCountPlugin, feedbackWithViewsAndCountPlugin.f22060w));
                }
            }
        }

        public final Class<RVPPlayerStateChangedEvent> m24652a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    public static void m24654a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        FeedbackWithViewsAndCountPlugin feedbackWithViewsAndCountPlugin = (FeedbackWithViewsAndCountPlugin) obj;
        GraphQLQueryExecutor a = GraphQLQueryExecutor.a(fbInjector);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        TasksManager b = TasksManager.b(fbInjector);
        feedbackWithViewsAndCountPlugin.f22056r = a;
        feedbackWithViewsAndCountPlugin.f22057s = abstractFbErrorReporter;
        feedbackWithViewsAndCountPlugin.f22058t = b;
    }

    @DoNotStrip
    public FeedbackWithViewsAndCountPlugin(Context context) {
        this(context, null);
    }

    private FeedbackWithViewsAndCountPlugin(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Class cls = FeedbackWithViewsAndCountPlugin.class;
        m24654a((Object) this, getContext());
        this.b = (ViewStub) a(2131562070);
        this.f.add(new PlayerStateChangedEventSubscriber(this));
    }

    protected final void mo1540a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        super.mo1540a(richVideoPlayerParams, z);
        mo1542d();
        GraphQLStoryAttachment o = StoryAttachmentHelper.o((GraphQLStory) this.f22033a.a);
        if (o != null && o.r() != null) {
            this.f22060w = o.r().b();
        }
    }

    protected final void mo1541c() {
        this.f22058t.c("fetchVideoBroadcastPlayCount");
        super.mo1541c();
    }

    protected final void mo1542d() {
        super.mo1542d();
        this.f22034b.setVisibility(8);
    }
}
