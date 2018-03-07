package com.facebook.ui.edithistory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryParamSet;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.edithistory.protocol.FetchEditHistoryGraphQL.FetchEditHistoryQueryString;
import com.facebook.ui.edithistory.protocol.FetchEditHistoryGraphQLModels.EditActionFragmentModel;
import com.facebook.ui.edithistory.protocol.FetchEditHistoryGraphQLModels.FetchEditHistoryQueryModel;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.listview.BetterListView;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: esds */
public abstract class EditHistoryFragment extends FbFragment {
    private String f15197a;
    public boolean f15198b = false;
    public BetterListView f15199c;
    public View f15200d;
    public View f15201e;
    public GraphQLQueryExecutor f15202f;
    private TasksManager<String> f15203g;
    public EditHistoryAdapter f15204h;
    public AbstractFbErrorReporter f15205i;

    /* compiled from: esds */
    class C11481 implements OnClickListener {
        final /* synthetic */ EditHistoryFragment f15297a;

        C11481(EditHistoryFragment editHistoryFragment) {
            this.f15297a = editHistoryFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -151419970);
            EditHistoryFragment.m19198b(this.f15297a);
            Logger.a(2, EntryType.UI_INPUT_END, -1605063278, a);
        }
    }

    /* compiled from: esds */
    class C11503 extends AbstractDisposableFutureCallback<GraphQLResult<FetchEditHistoryQueryModel>> {
        final /* synthetic */ EditHistoryFragment f15300a;

        C11503(EditHistoryFragment editHistoryFragment) {
            this.f15300a = editHistoryFragment;
        }

        public final void m19284a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((FetchEditHistoryQueryModel) graphQLResult.e).m19308a() == null) {
                m19285a(new IllegalArgumentException("Got an empty result"));
                return;
            }
            EditHistoryAdapter editHistoryAdapter = this.f15300a.f15204h;
            ImmutableList<EditActionFragmentModel> a = ((FetchEditHistoryQueryModel) graphQLResult.e).m19308a().m19302a();
            editHistoryAdapter.f15189a = Lists.a();
            for (EditActionFragmentModel editActionExpandState : a) {
                editHistoryAdapter.f15189a.add(new EditActionExpandState(editActionExpandState));
            }
            AdapterDetour.a(editHistoryAdapter, -1115562774);
            this.f15300a.f15200d.setVisibility(8);
            this.f15300a.f15199c.setVisibility(0);
            this.f15300a.f15198b = true;
        }

        public final void m19285a(Throwable th) {
            this.f15300a.f15200d.setVisibility(8);
            this.f15300a.f15201e.setVisibility(0);
            this.f15300a.f15205i.a("fetchEditHistory", th);
        }
    }

    protected abstract int au();

    protected abstract EditHistoryAdapter av();

    public void mo1177c(Bundle bundle) {
        super.c(bundle);
        FbInjector an = an();
        this.f15202f = GraphQLQueryExecutor.a(an);
        this.f15203g = TasksManager.b(an());
        this.f15205i = (AbstractFbErrorReporter) FbErrorReporterImpl.a(an);
        AnalyticsLogger a = AnalyticsLoggerMethodAutoProvider.a(an);
        Bundle bundle2 = this.s;
        this.f15197a = (String) Preconditions.checkNotNull(bundle2.getString("node_id"), "Node ID cannot be null");
        String str = (String) Preconditions.checkNotNull(bundle2.getString("module"), "Module name cannot be null");
        HoneyClientEvent j = new HoneyClientEvent("open_edit_history").j(this.f15197a);
        j.c = str;
        a.a(j);
    }

    public View mo1174a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 784827668);
        View inflate = layoutInflater.inflate(au(), viewGroup, false);
        this.f15199c = (BetterListView) inflate.findViewById(2131562003);
        this.f15200d = inflate.findViewById(2131562002);
        this.f15201e = inflate.findViewById(2131560576);
        this.f15204h = av();
        this.f15199c.setAdapter(this.f15204h);
        this.f15201e.setOnClickListener(new C11481(this));
        m19198b(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1743945467, a);
        return inflate;
    }

    public void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 305706778);
        super.mi_();
        if (!this.f15198b) {
            m19198b(this);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1755960864, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1630953014);
        super.mj_();
        if (this.f15203g != null) {
            this.f15203g.c();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -739187028, a);
    }

    public static void m19198b(EditHistoryFragment editHistoryFragment) {
        if (!editHistoryFragment.f15203g.a("fetchEditHistory")) {
            editHistoryFragment.f15199c.setVisibility(8);
            editHistoryFragment.f15201e.setVisibility(8);
            editHistoryFragment.f15200d.setVisibility(0);
            final GraphQlQueryParamSet graphQlQueryParamSet = new FetchEditHistoryQueryString().a("node_id", editHistoryFragment.f15197a).a;
            editHistoryFragment.f15203g.a("fetchEditHistory", new Callable<ListenableFuture<GraphQLResult<FetchEditHistoryQueryModel>>>(editHistoryFragment) {
                final /* synthetic */ EditHistoryFragment f15299b;

                public Object call() {
                    return this.f15299b.f15202f.a(GraphQLRequest.a(new FetchEditHistoryQueryString()).a(graphQlQueryParamSet));
                }
            }, new C11503(editHistoryFragment));
        }
    }
}
