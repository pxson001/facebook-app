package com.facebook.pages.common.surface.calltoaction.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.funnellogger.FunnelLogger;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.surface.calltoaction.PageCallToActionFetcher;
import com.facebook.pages.common.surface.calltoaction.PageCallToActionFetcherProvider;
import com.facebook.pages.common.surface.calltoaction.analytics.PageCallToActionAnalytics;
import com.facebook.pages.common.surface.calltoaction.analytics.PageCallToActionEvent;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQL.PageAdminCallToActionString;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.CallToActionAdminConfigModel;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.CallToActionConfigFieldsModel;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.PageAdminCallToActionModel;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.PageAdminCallToActionModel.PageCallToActionModel;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.framerateprogressbar.FrameRateProgressBar;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: create_prompt */
public class PageCallToActionFragment extends FbFragment {
    @Inject
    public TasksManager f16657a;
    private FrameRateProgressBar al;
    public FbTextView am;
    @Inject
    Lazy<FbErrorReporter> f16658b;
    @Inject
    PageCallToActionAnalytics f16659c;
    @Inject
    public PageCallToActionFetcherProvider f16660d;
    @Inject
    FunnelLoggerImpl f16661e;
    private String f16662f;
    public String f16663g;
    private ArrayList<CallToActionConfigFieldsModel> f16664h;
    private boolean f16665i;

    /* compiled from: create_prompt */
    public class C18021 extends AbstractDisposableFutureCallback<PageAdminCallToActionModel> {
        final /* synthetic */ PageCallToActionFragment f16656a;

        public C18021(PageCallToActionFragment pageCallToActionFragment) {
            this.f16656a = pageCallToActionFragment;
        }

        protected final void m19694a(Object obj) {
            Object obj2;
            PageAdminCallToActionModel pageAdminCallToActionModel = (PageAdminCallToActionModel) obj;
            PageCallToActionFragment.m19698a(this.f16656a, false);
            PageCallToActionModel l = pageAdminCallToActionModel.m19902l();
            if (l == null || l.m19889j() == null || l.m19889j().m19882j() == null) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 == null) {
                this.f16656a.am.setVisibility(0);
            } else if (PageCallToActionUtil.m20173c(pageAdminCallToActionModel)) {
                PageCallToActionFragment.m19697a(this.f16656a, pageAdminCallToActionModel);
            } else {
                PageCallToActionFragment.m19701b(this.f16656a, pageAdminCallToActionModel);
            }
        }

        protected final void m19695a(Throwable th) {
            PageCallToActionFragment.m19698a(this.f16656a, false);
            this.f16656a.am.setVisibility(0);
            ((AbstractFbErrorReporter) this.f16656a.f16658b.get()).a(PageSelectCallToActionFragment.class.getSimpleName(), th);
        }
    }

    public static void m19700a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageCallToActionFragment) obj).m19699a(TasksManager.b(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 494), PageCallToActionAnalytics.m19690b(fbInjector), (PageCallToActionFetcherProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PageCallToActionFetcherProvider.class), FunnelLoggerImpl.a(fbInjector));
    }

    private void m19699a(TasksManager tasksManager, Lazy<FbErrorReporter> lazy, PageCallToActionAnalytics pageCallToActionAnalytics, PageCallToActionFetcherProvider pageCallToActionFetcherProvider, FunnelLogger funnelLogger) {
        this.f16657a = tasksManager;
        this.f16658b = lazy;
        this.f16659c = pageCallToActionAnalytics;
        this.f16660d = pageCallToActionFetcherProvider;
        this.f16661e = funnelLogger;
    }

    public final void m19705c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = PageCallToActionFragment.class;
        m19700a((Object) this, getContext());
        Bundle bundle2 = this.s;
        this.f16663g = bundle2.getString("arg_page_id");
        this.f16665i = bundle2.getBoolean("arg_can_edit_cta");
        this.f16664h = (ArrayList) FlatBufferModelHelper.b(bundle2, "arg_page_call_to_action_fields");
        this.f16662f = bundle2.getString("arg_page_call_to_action_label");
    }

    public final View m19703a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -685231558);
        View inflate = layoutInflater.inflate(2130905974, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 75690851, a);
        return inflate;
    }

    public final void m19704a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.al = (FrameRateProgressBar) e(2131565382);
        this.am = (FbTextView) e(2131565383);
        m19698a(this, true);
        if (this.f16665i) {
            PageCallToActionFetcher a = this.f16660d.m19688a(this.f16663g);
            this.f16657a.a("fetch_call_to_action_types", GraphQLQueryExecutor.a(a.f16645a.a(GraphQLRequest.a((PageAdminCallToActionString) new PageAdminCallToActionString().a("page_id", a.f16646b).a("cta_icon_size", Integer.valueOf(a.f16647c.getResources().getDimensionPixelSize(2131432975))).a("cta_icon_scale", GraphQlQueryDefaults.a())))), new C18021(this));
            return;
        }
        aq();
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 220576452);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.c(true);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 971201390, a);
    }

    public final void m19702I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -569141669);
        super.I();
        this.f16657a.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1653252531, a);
    }

    public static void m19697a(PageCallToActionFragment pageCallToActionFragment, PageAdminCallToActionModel pageAdminCallToActionModel) {
        pageCallToActionFragment.m19696a(PageSelectCallToActionFragment.m19725a(pageAdminCallToActionModel, pageCallToActionFragment.f16663g, false));
        pageCallToActionFragment.f16659c.f16655a.a(PageCallToActionAnalytics.m19689a(PageCallToActionEvent.EVENT_ADMIN_CALL_TO_ACTION_CREATE, pageCallToActionFragment.f16663g));
        pageCallToActionFragment.f16661e.a(FunnelRegistry.N);
        pageCallToActionFragment.f16661e.b(FunnelRegistry.N, "tap_create_button");
    }

    public static void m19701b(PageCallToActionFragment pageCallToActionFragment, PageAdminCallToActionModel pageAdminCallToActionModel) {
        CallToActionAdminConfigModel callToActionAdminConfigModel;
        PageCallToActionModel l = pageAdminCallToActionModel.m19902l();
        ImmutableList a = l.m19889j().m19882j().m19877a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            callToActionAdminConfigModel = (CallToActionAdminConfigModel) a.get(i);
            if (callToActionAdminConfigModel.m19786j() == l.m19890k()) {
                break;
            }
        }
        callToActionAdminConfigModel = null;
        pageCallToActionFragment.m19696a(PageConfigureCallToActionFragment.m19713a(pageAdminCallToActionModel, callToActionAdminConfigModel, pageCallToActionFragment.f16663g));
        PageCallToActionAnalytics pageCallToActionAnalytics = pageCallToActionFragment.f16659c;
        String str = pageCallToActionFragment.f16663g;
        pageCallToActionAnalytics.f16655a.a(PageCallToActionAnalytics.m19689a(PageCallToActionEvent.EVENT_ADMIN_CALL_TO_ACTION_EDIT, str).b("edit_location", "header"));
        pageCallToActionFragment.f16661e.a(FunnelRegistry.O);
        pageCallToActionFragment.f16661e.b(FunnelRegistry.O, "tap_edit_button");
    }

    private void aq() {
        m19698a(this, false);
        List list = this.f16664h;
        String str = this.f16663g;
        String str2 = this.f16662f;
        PageUserCallToActionFragment pageUserCallToActionFragment = new PageUserCallToActionFragment();
        Bundle bundle = new Bundle(1);
        FlatBufferModelHelper.a(bundle, "arg_page_call_to_action_fields", list);
        bundle.putString("arg_page_id", str);
        bundle.putString("arg_page_call_to_action_label", str2);
        pageUserCallToActionFragment.g(bundle);
        m19696a(pageUserCallToActionFragment);
    }

    private void m19696a(FbFragment fbFragment) {
        FragmentActivity o = o();
        if (o != null && !o.isFinishing()) {
            o.kO_().a().b(this.H, fbFragment, "page_call_to_action_tag").c();
        }
    }

    public static void m19698a(PageCallToActionFragment pageCallToActionFragment, boolean z) {
        pageCallToActionFragment.al.setVisibility(z ? 0 : 8);
    }
}
