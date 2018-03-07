package com.facebook.crowdsourcing.feather.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Preconditions;
import com.facebook.crowdsourcing.feather.view.FeatherStackView;
import com.facebook.crowdsourcing.logging.CrowdEndpoint;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.crowdsourcing.logging.CrowdsourcingContext;
import com.facebook.crowdsourcing.logging.SuggestEditsAnalyticsLogger;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingFeatherMutations.CrowdsourcingFeatherOverlayShownMutationString;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.calls.FeatherOverlayShownInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.offlinemode.common.OfflineQueryBehavior;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.futures.TasksManager;
import java.util.List;
import javax.inject.Inject;

/* compiled from: com.facebook.zero.ZERO_SHOW_INTERSTITIAL */
public class FeatherFragment extends FbFragment {
    @Inject
    AbstractFbErrorReporter f17401a;
    @Inject
    public GraphQLQueryExecutor f17402b;
    @Inject
    public SuggestEditsAnalyticsLogger f17403c;
    @Inject
    public TasksManager f17404d;
    @Inject
    public FunnelLoggerImpl f17405e;

    /* compiled from: com.facebook.zero.ZERO_SHOW_INTERSTITIAL */
    class C14281 implements OnClickListener {
        final /* synthetic */ FeatherFragment f17399a;

        C14281(FeatherFragment featherFragment) {
            this.f17399a = featherFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1042960044);
            this.f17399a.f17405e.b(FunnelRegistry.S, "feather_overlay_dismiss");
            this.f17399a.f17405e.b(FunnelRegistry.S);
            this.f17399a.ao().onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 132763719, a);
        }
    }

    /* compiled from: com.facebook.zero.ZERO_SHOW_INTERSTITIAL */
    public class C14292 extends AbstractDisposableFutureCallback {
        final /* synthetic */ FeatherFragment f17400a;

        public C14292(FeatherFragment featherFragment) {
            this.f17400a = featherFragment;
        }

        protected final void m21286a(Object obj) {
        }

        protected final void m21287a(Throwable th) {
            this.f17400a.f17401a.a("crowdsourcing_feather", "Failed to submit PAV claim mutation");
        }
    }

    public static void m21289a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FeatherFragment) obj).m21288a((AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), GraphQLQueryExecutor.a(fbInjector), SuggestEditsAnalyticsLogger.a(fbInjector), TasksManager.b(fbInjector), FunnelLoggerImpl.a(fbInjector));
    }

    public final View m21290a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1892707394);
        super.a(layoutInflater, viewGroup, bundle);
        Class cls = FeatherFragment.class;
        m21289a((Object) this, getContext());
        View inflate = layoutInflater.inflate(2130904282, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1035755600, a);
        return inflate;
    }

    public final void m21291a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f17405e.b(FunnelRegistry.S, "feather_overlay_start");
        Intent intent = ao().getIntent();
        String str = (String) Preconditions.a(intent.getStringExtra("extra_place"));
        String str2 = (String) Preconditions.a(intent.getStringExtra("extra_place_name"));
        CrowdEntryPoint crowdEntryPoint = (CrowdEntryPoint) Preconditions.a(CrowdEntryPoint.fromFullName((String) Preconditions.a(intent.getStringExtra("extra_entry_point"))));
        ImmutableList a = ImmutableList.a((List) Preconditions.a(FlatBufferModelHelper.b(intent, "extra_questions")));
        this.f17405e.b(FunnelRegistry.S, "feather_overlay_extras_extracted");
        e(2131561863).setOnClickListener(new C14281(this));
        ((FbTextView) e(2131561864)).setText(str2);
        ((FeatherStackView) e(2131561865)).m21307a(str, a);
        int size = a.size();
        this.f17405e.b(FunnelRegistry.S, "feather_overlay_end");
        this.f17403c.a(new CrowdsourcingContext(crowdEntryPoint, CrowdEndpoint.FEATHER), str);
        GraphQlQueryString crowdsourcingFeatherOverlayShownMutationString = new CrowdsourcingFeatherOverlayShownMutationString();
        FeatherOverlayShownInputData featherOverlayShownInputData = new FeatherOverlayShownInputData();
        featherOverlayShownInputData.a("endpoint", CrowdEndpoint.FEATHER.getFullName());
        featherOverlayShownInputData.a("entry_point", crowdEntryPoint.getFullName());
        featherOverlayShownInputData.a("page_id", str);
        featherOverlayShownInputData.a("num_questions", Integer.valueOf(size));
        crowdsourcingFeatherOverlayShownMutationString.a("input", featherOverlayShownInputData);
        this.f17404d.a("task_overlay_shown" + str + size, this.f17402b.a(GraphQLRequest.a(crowdsourcingFeatherOverlayShownMutationString), OfflineQueryBehavior.b), new C14292(this));
    }

    private void m21288a(AbstractFbErrorReporter abstractFbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, SuggestEditsAnalyticsLogger suggestEditsAnalyticsLogger, TasksManager tasksManager, FunnelLoggerImpl funnelLoggerImpl) {
        this.f17401a = abstractFbErrorReporter;
        this.f17402b = graphQLQueryExecutor;
        this.f17403c = suggestEditsAnalyticsLogger;
        this.f17404d = tasksManager;
        this.f17405e = funnelLoggerImpl;
    }
}
