package com.facebook.negativefeedback.video;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.api.feed.service.GraphPostService;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.base.fragment.FragmentManagerHost.Util;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.HideEvents$StoryVisibilityEvent;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.StoryAddReportReasonInputData;
import com.facebook.graphql.calls.StoryReportInputData;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLNegativeFeedbackAction.Builder;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.infer.annotation.Assertions;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.negativefeedback.logging.NegativeFeedbackAnalyticsLogger.ParamsBuilder;
import com.facebook.negativefeedback.ui.NegativeFeedbackDialogFragment;
import com.facebook.negativefeedback.video.gatekeepers.RapidReportingGatekeepers;
import com.facebook.negativefeedback.video.logging.RapidReportingAnalyticsLogger;
import com.facebook.negativefeedback.video.protocol.RapidReportingMutation.RapidReportingMutationString;
import com.facebook.negativefeedback.video.protocol.RapidReportingWithReasonMutation.RapidReportingWithReasonMutationString;
import com.facebook.negativefeedback.video.ui.ReportLiveVideoDialogFragment;
import com.facebook.negativefeedback.video.ui.ReportLiveVideoDialogFragment.DialogType;
import com.facebook.ui.futures.TasksManager;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: network_info_req_bw_egress_size */
public class RapidReportingController {
    public static final String f12519a = RapidReportingController.class.getSimpleName();
    public final TasksManager f12520b;
    public final AbstractFbErrorReporter f12521c;
    public final SecureContextHelper f12522d;
    public final ViewerContextManager f12523e;
    public final GraphQLQueryExecutor f12524f;
    public final RapidReportingAnalyticsLogger f12525g;
    private final RapidReportingGatekeepers f12526h;
    public final Provider<GraphPostService> f12527i;
    public final FeedEventBus f12528j;
    public FeedProps<? extends NegativeFeedbackActionsUnit> f12529k;
    public String f12530l;
    public int f12531m;
    public String f12532n;
    public String f12533o;
    public List<String> f12534p;
    public FragmentManager f12535q;
    public ReportLiveVideoDialogFragment f12536r;
    public ReportLiveVideoDialogFragment f12537s;
    public ReportLiveVideoDialogFragment f12538t;
    public final OnClickListener f12539u = new C05191(this);
    public final OnClickListener f12540v = new C05202(this);
    public final OnClickListener f12541w = new C05213(this);

    /* compiled from: network_info_req_bw_egress_size */
    class C05191 implements OnClickListener {
        final /* synthetic */ RapidReportingController f12544a;

        C05191(RapidReportingController rapidReportingController) {
            this.f12544a = rapidReportingController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            switch (i) {
                case -2:
                    if (TextUtils.isEmpty(this.f12544a.f12533o) && this.f12544a.f12534p.isEmpty()) {
                        this.f12544a.f12536r.m210a();
                        RapidReportingController.m18611f(this.f12544a);
                        return;
                    }
                    this.f12544a.f12536r.f91f.hide();
                    this.f12544a.f12537s.m213a(this.f12544a.f12535q, RapidReportingController.f12519a);
                    return;
                case -1:
                    this.f12544a.f12536r.m210a();
                    this.f12544a.f12525g.m18616a(this.f12544a.f12532n, this.f12544a.f12534p, this.f12544a.f12533o);
                    this.f12544a.f12520b.m14561c(RapidReportingController.f12519a);
                    RapidReportingController rapidReportingController = this.f12544a;
                    List list = this.f12544a.f12534p;
                    String str = this.f12544a.f12533o;
                    TypedGraphQLMutationString rapidReportingWithReasonMutationString = new RapidReportingWithReasonMutationString();
                    StoryAddReportReasonInputData storyAddReportReasonInputData = new StoryAddReportReasonInputData();
                    storyAddReportReasonInputData.m11397a("report_reason", str);
                    GraphQlCallInput graphQlCallInput = storyAddReportReasonInputData;
                    graphQlCallInput.m11398a("tag_ids", list);
                    graphQlCallInput = graphQlCallInput;
                    graphQlCallInput.m11397a("story_id", rapidReportingController.f12532n);
                    rapidReportingWithReasonMutationString.m11310a("input", graphQlCallInput);
                    rapidReportingController.f12524f.m10448a(GraphQLRequest.m11588a(rapidReportingWithReasonMutationString));
                    this.f12544a.f12538t.m213a(this.f12544a.f12535q, RapidReportingController.f12519a);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: network_info_req_bw_egress_size */
    class C05202 implements OnClickListener {
        final /* synthetic */ RapidReportingController f12545a;

        C05202(RapidReportingController rapidReportingController) {
            this.f12545a = rapidReportingController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f12545a.f12537s.m210a();
            switch (i) {
                case -2:
                    this.f12545a.f12536r.f91f.show();
                    return;
                case -1:
                    this.f12545a.f12536r.m210a();
                    RapidReportingController.m18611f(this.f12545a);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: network_info_req_bw_egress_size */
    class C05213 implements OnClickListener {
        final /* synthetic */ RapidReportingController f12546a;

        C05213(RapidReportingController rapidReportingController) {
            this.f12546a = rapidReportingController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f12546a.f12525g.m18617b(this.f12546a.f12532n);
            this.f12546a.f12538t.m210a();
            RapidReportingController rapidReportingController = this.f12546a;
            if (rapidReportingController.f12531m > 0) {
                Builder builder = new Builder();
                builder.j = GraphQLNegativeFeedbackActionType.HIDE;
                ((GraphPostService) rapidReportingController.f12527i.get()).m18478a(rapidReportingController.f12529k, builder.a(), rapidReportingController.f12530l, "");
                rapidReportingController.f12528j.mo651a(new HideEvents$StoryVisibilityEvent(((NegativeFeedbackActionsUnit) rapidReportingController.f12529k.f13444a).mo2507g(), null, null, StoryVisibility.HIDDEN, rapidReportingController.f12531m));
            }
            RapidReportingController.m18611f(rapidReportingController);
        }
    }

    public static RapidReportingController m18610b(InjectorLike injectorLike) {
        return new RapidReportingController(TasksManager.m14550b(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), DefaultSecureContextHelper.m4636a(injectorLike), ViewerContextManagerProvider.m2496b(injectorLike), GraphQLQueryExecutor.m10435a(injectorLike), new RapidReportingAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike)), new RapidReportingGatekeepers(GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike)), IdBasedProvider.m1811a(injectorLike, 216), FeedEventBus.m4573a(injectorLike));
    }

    public static RapidReportingController m18608a(InjectorLike injectorLike) {
        return m18610b(injectorLike);
    }

    @Inject
    public RapidReportingController(TasksManager tasksManager, FbErrorReporter fbErrorReporter, SecureContextHelper secureContextHelper, ViewerContextManager viewerContextManager, GraphQLQueryExecutor graphQLQueryExecutor, RapidReportingAnalyticsLogger rapidReportingAnalyticsLogger, RapidReportingGatekeepers rapidReportingGatekeepers, Provider<GraphPostService> provider, FeedEventBus feedEventBus) {
        this.f12520b = tasksManager;
        this.f12521c = fbErrorReporter;
        this.f12525g = rapidReportingAnalyticsLogger;
        this.f12522d = secureContextHelper;
        this.f12523e = viewerContextManager;
        this.f12524f = graphQLQueryExecutor;
        this.f12526h = rapidReportingGatekeepers;
        this.f12527i = provider;
        this.f12528j = feedEventBus;
    }

    public final void m18612a(Context context, FeedProps<? extends NegativeFeedbackActionsUnit> feedProps, String str, int i) {
        this.f12529k = feedProps;
        this.f12530l = str;
        this.f12531m = i;
        NegativeFeedbackActionsUnit negativeFeedbackActionsUnit = (NegativeFeedbackActionsUnit) this.f12529k.f13444a;
        if (m18609a(negativeFeedbackActionsUnit)) {
            TypedGraphQLMutationString rapidReportingMutationString = new RapidReportingMutationString();
            StoryReportInputData storyReportInputData = new StoryReportInputData();
            storyReportInputData.m11397a("story_id", negativeFeedbackActionsUnit.mo2892r());
            rapidReportingMutationString.m11310a("input", (GraphQlCallInput) storyReportInputData);
            this.f12524f.m10448a(GraphQLRequest.m11588a(rapidReportingMutationString));
            if (this.f12526h.f12543a.m2189a(1068, false)) {
                String r = negativeFeedbackActionsUnit.mo2892r();
                Assertions.m5471b(r);
                this.f12532n = r;
                this.f12534p = new ArrayList();
                this.f12536r = ReportLiveVideoDialogFragment.a(DialogType.FEEDBACK, r);
                this.f12536r.a(this, this.f12539u);
                this.f12537s = ReportLiveVideoDialogFragment.a(DialogType.CANCEL_CONFIRM, r);
                this.f12537s.a(this, this.f12540v);
                this.f12538t = ReportLiveVideoDialogFragment.a(DialogType.THANK_YOU, r);
                this.f12538t.a(this, this.f12541w);
                this.f12535q = Util.a(context).kO_();
                this.f12536r.m213a(this.f12535q, f12519a);
                return;
            }
        }
        NegativeFeedbackDialogFragment.a(negativeFeedbackActionsUnit.mo2892r(), str, new ParamsBuilder().a(TrackableFeedProps.m27452b(feedProps).toString()).b).m213a(Util.a(context).kO_(), f12519a);
    }

    public static boolean m18609a(NegativeFeedbackActionsUnit negativeFeedbackActionsUnit) {
        if (negativeFeedbackActionsUnit instanceof GraphQLStory) {
            GraphQLStoryAttachment o = StoryAttachmentHelper.m28042o((GraphQLStory) negativeFeedbackActionsUnit);
            if (!(o == null || o.m23979r() == null)) {
                return o.m23979r().al();
            }
        }
        return false;
    }

    public static void m18611f(RapidReportingController rapidReportingController) {
        rapidReportingController.f12529k = null;
        rapidReportingController.f12530l = null;
        rapidReportingController.f12531m = 0;
        rapidReportingController.f12532n = null;
        rapidReportingController.f12533o = null;
        rapidReportingController.f12534p = null;
        rapidReportingController.f12535q = null;
        rapidReportingController.f12536r = null;
        rapidReportingController.f12537s = null;
        rapidReportingController.f12538t = null;
    }
}
