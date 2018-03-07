package com.facebook.facecastdisplay;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.SimpleReactionsFeedbackFieldsModel.ReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsFeedbackFieldsModel.SupportedReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ImportantReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ImportantReactorsModel.NodesModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ViewerActsAsPersonModel;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQuery.LiveBlingBarFeedbackQueryString;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveBlingBarFeedbackQueryModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveBlingbarFeedbackModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveBlingbarFeedbackModel.CommentsModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveBlingbarFeedbackModel.LikersModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveBlingbarFeedbackModel.ResharesModel;
import com.facebook.facecastdisplay.protocol.LiveBlingbarFeedbackConverter;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.reactions.ui.PillsBlingBarPartDefinitionHelper;
import com.facebook.feedback.reactions.ui.PillsBlingBarView;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLActorUtil;
import com.facebook.graphql.model.GraphQLCommentsConnection;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLFeedback.Builder;
import com.facebook.graphql.model.GraphQLFeedbackReaction;
import com.facebook.graphql.model.GraphQLImportantReactorsConnection;
import com.facebook.graphql.model.GraphQLLikersOfContentConnection;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLReactorsOfContentConnection;
import com.facebook.graphql.model.GraphQLResharesOfContentConnection;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLUser;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StoryTextHelper;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.videohome.abtest.ExperimentsForVideoHomeAbTestModule;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: audio/mpeg-L1 */
public class LiveVideoContextView extends CustomLinearLayout {
    public static final String f18953g = LiveVideoContextView.class.getName();
    @Inject
    QeAccessor f18954a;
    @Inject
    FacecastUtil f18955b;
    @Inject
    PillsBlingBarPartDefinitionHelper f18956c;
    @Inject
    GraphQLQueryExecutor f18957d;
    @Inject
    @ForUiThread
    ExecutorService f18958e;
    @Inject
    AbstractFbErrorReporter f18959f;
    private final LiveMetadataView f18960h;
    private final BetterTextView f18961i;
    public final PillsBlingBarView f18962j;
    @Nullable
    public LiveVideoContextViewListener f18963k;
    @Nullable
    public String f18964l;
    @Nullable
    public ListenableFuture f18965m;

    /* compiled from: audio/mpeg-L1 */
    class C16461 implements FutureCallback<GraphQLResult<LiveBlingBarFeedbackQueryModel>> {
        final /* synthetic */ LiveVideoContextView f18952a;

        C16461(LiveVideoContextView liveVideoContextView) {
            this.f18952a = liveVideoContextView;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (this.f18952a.f18965m != null && !this.f18952a.f18965m.isCancelled() && graphQLResult != null && graphQLResult.e != null) {
                LiveBlingBarFeedbackQueryModel liveBlingBarFeedbackQueryModel = (LiveBlingBarFeedbackQueryModel) graphQLResult.e;
                if (liveBlingBarFeedbackQueryModel.m3768a() != null) {
                    GraphQLFeedback graphQLFeedback;
                    LiveBlingbarFeedbackModel a = liveBlingBarFeedbackQueryModel.m3768a();
                    if (a == null) {
                        graphQLFeedback = null;
                    } else {
                        GraphQLCommentsConnection graphQLCommentsConnection;
                        GraphQLImportantReactorsConnection graphQLImportantReactorsConnection;
                        GraphQLLikersOfContentConnection graphQLLikersOfContentConnection;
                        GraphQLReactorsOfContentConnection graphQLReactorsOfContentConnection;
                        GraphQLResharesOfContentConnection graphQLResharesOfContentConnection;
                        GraphQLUser graphQLUser;
                        Builder builder = new Builder();
                        builder.j = a.m3806a();
                        CommentsModel b = a.m3807b();
                        if (b == null) {
                            graphQLCommentsConnection = null;
                        } else {
                            GraphQLCommentsConnection.Builder builder2 = new GraphQLCommentsConnection.Builder();
                            builder2.a(b.m3772a());
                            graphQLCommentsConnection = builder2.a();
                        }
                        builder.l = graphQLCommentsConnection;
                        builder.p = a.m3808c();
                        ImportantReactorsModel d = a.m3809d();
                        if (d == null) {
                            graphQLImportantReactorsConnection = null;
                        } else {
                            GraphQLImportantReactorsConnection.Builder builder3 = new GraphQLImportantReactorsConnection.Builder();
                            if (d.a() != null) {
                                ImmutableList.Builder builder4 = ImmutableList.builder();
                                for (int i = 0; i < d.a().size(); i++) {
                                    GraphQLActor graphQLActor;
                                    NodesModel nodesModel = (NodesModel) d.a().get(i);
                                    if (nodesModel == null) {
                                        graphQLActor = null;
                                    } else {
                                        GraphQLActor.Builder builder5 = new GraphQLActor.Builder();
                                        builder5.aH = nodesModel.a();
                                        builder5.V = nodesModel.b();
                                        graphQLActor = builder5.a();
                                    }
                                    builder4.c(graphQLActor);
                                }
                                builder3.d = builder4.b();
                            }
                            graphQLImportantReactorsConnection = builder3.a();
                        }
                        builder.w = graphQLImportantReactorsConnection;
                        LikersModel fj_ = a.fj_();
                        if (fj_ == null) {
                            graphQLLikersOfContentConnection = null;
                        } else {
                            GraphQLLikersOfContentConnection.Builder builder6 = new GraphQLLikersOfContentConnection.Builder();
                            builder6.a(fj_.m3780a());
                            graphQLLikersOfContentConnection = builder6.a();
                        }
                        builder.C = graphQLLikersOfContentConnection;
                        ReactorsModel g = a.m3810g();
                        if (g == null) {
                            graphQLReactorsOfContentConnection = null;
                        } else {
                            GraphQLReactorsOfContentConnection.Builder builder7 = new GraphQLReactorsOfContentConnection.Builder();
                            builder7.a(g.a());
                            graphQLReactorsOfContentConnection = builder7.a();
                        }
                        builder.E = graphQLReactorsOfContentConnection;
                        ResharesModel fi_ = a.fi_();
                        if (fi_ == null) {
                            graphQLResharesOfContentConnection = null;
                        } else {
                            GraphQLResharesOfContentConnection.Builder builder8 = new GraphQLResharesOfContentConnection.Builder();
                            builder8.a(fi_.m3787a());
                            graphQLResharesOfContentConnection = builder8.a();
                        }
                        builder.H = graphQLResharesOfContentConnection;
                        if (a.fh_() != null) {
                            ImmutableList.Builder builder9 = ImmutableList.builder();
                            for (int i2 = 0; i2 < a.fh_().size(); i2++) {
                                GraphQLFeedbackReaction graphQLFeedbackReaction;
                                SupportedReactionsModel supportedReactionsModel = (SupportedReactionsModel) a.fh_().get(i2);
                                if (supportedReactionsModel == null) {
                                    graphQLFeedbackReaction = null;
                                } else {
                                    GraphQLFeedbackReaction.Builder builder10 = new GraphQLFeedbackReaction.Builder();
                                    builder10.d = supportedReactionsModel.a();
                                    graphQLFeedbackReaction = builder10.a();
                                }
                                builder9.c(graphQLFeedbackReaction);
                            }
                            builder.K = builder9.b();
                        }
                        builder.M = LiveBlingbarFeedbackConverter.m4041a(a.m3811j());
                        ViewerActsAsPersonModel k = a.m3812k();
                        if (k == null) {
                            graphQLUser = null;
                        } else {
                            GraphQLUser.Builder builder11 = new GraphQLUser.Builder();
                            builder11.ar = k.a();
                            graphQLUser = builder11.a();
                        }
                        builder.Q = graphQLUser;
                        builder.a(a.m3813l());
                        graphQLFeedback = builder.a();
                    }
                    GraphQLFeedback graphQLFeedback2 = graphQLFeedback;
                    PillsBlingBarPartDefinitionHelper pillsBlingBarPartDefinitionHelper = this.f18952a.f18956c;
                    PillsBlingBarPartDefinitionHelper.a(graphQLFeedback2, Integer.valueOf(0), this.f18952a.f18962j);
                }
            }
        }

        public void onFailure(Throwable th) {
            this.f18952a.f18959f.a(LiveVideoContextView.f18953g + "_graphFailure", "Failed to fetch video feedback for blingbar with video id - " + this.f18952a.f18964l, th);
        }
    }

    private static <T extends View> void m22546a(Class<T> cls, T t) {
        m22547a((Object) t, t.getContext());
    }

    private static void m22547a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((LiveVideoContextView) obj).m22545a((QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), FacecastUtil.m3107b(fbInjector), PillsBlingBarPartDefinitionHelper.a(fbInjector), GraphQLQueryExecutor.a(fbInjector), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector));
    }

    private void m22545a(QeAccessor qeAccessor, FacecastUtil facecastUtil, PillsBlingBarPartDefinitionHelper pillsBlingBarPartDefinitionHelper, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f18954a = qeAccessor;
        this.f18955b = facecastUtil;
        this.f18956c = pillsBlingBarPartDefinitionHelper;
        this.f18957d = graphQLQueryExecutor;
        this.f18958e = executorService;
        this.f18959f = abstractFbErrorReporter;
    }

    public LiveVideoContextView(Context context) {
        this(context, null);
    }

    public LiveVideoContextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveVideoContextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22546a(LiveVideoContextView.class, (View) this);
        setContentView(2130905097);
        this.f18960h = (LiveMetadataView) a(2131563514);
        this.f18960h.setTextColor(getResources().getColor(2131362106));
        this.f18961i = (BetterTextView) a(2131563515);
        this.f18962j = (PillsBlingBarView) a(2131563516);
    }

    public void setListener(LiveVideoContextViewListener liveVideoContextViewListener) {
        this.f18963k = liveVideoContextViewListener;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -2144322922);
        if (this.f18963k != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.f18963k.e();
                    break;
                case 1:
                case 3:
                    this.f18963k.f();
                    break;
            }
        }
        LogUtils.a(1066564541, a);
        return true;
    }

    public void setMetadata(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        GraphQLActor b = StoryActorHelper.b(graphQLStory);
        this.f18960h.setStoryProps(feedProps);
        LiveMetadataView liveMetadataView = this.f18960h;
        String c = (b == null || !GraphQLActorUtil.b(b)) ? null : GraphQLActorUtil.c(b);
        liveMetadataView.setProfilePicture(c);
        this.f18961i.setText(StoryTextHelper.a(graphQLStory));
        this.f18962j.setVisibility(8);
        this.f18960h.m22515f();
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
        if (o != null) {
            GraphQLMedia r = o.r();
            if (r != null) {
                this.f18964l = r.b();
                if (this.f18954a.a(ExperimentsForVideoHomeAbTestModule.p, false)) {
                    setFollowVideosButton(r);
                }
                if (this.f18955b.m3115k() && this.f18964l != null) {
                    this.f18962j.setVisibility(0);
                }
            }
        }
    }

    public final void m22552a() {
        this.f18960h.m22513a();
        if (this.f18955b.m3115k()) {
            m22551c();
        }
    }

    private void setFollowVideosButton(GraphQLMedia graphQLMedia) {
        GraphQLActor aF = graphQLMedia.aF();
        if (aF != null && aF.ay()) {
            boolean z = aF.aJ() && !aF.aI() && graphQLMedia.bs();
            this.f18960h.m22514a(aF, z);
            this.f18960h.m22516g();
        }
    }

    private void m22551c() {
        if (this.f18964l != null) {
            if (this.f18965m == null || this.f18965m.isDone()) {
                TypedGraphQlQueryString liveBlingBarFeedbackQueryString = new LiveBlingBarFeedbackQueryString();
                this.f18965m = this.f18957d.a(GraphQLRequest.a(liveBlingBarFeedbackQueryString));
                liveBlingBarFeedbackQueryString.a("targetID", this.f18964l);
                Futures.a(this.f18965m, new C16461(this), this.f18958e);
            }
        }
    }
}
