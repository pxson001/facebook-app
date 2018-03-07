package com.facebook.pages.common.surface.calltoaction.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.adinterfaces.external.AdInterfacesIntentUtil;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.external.abtest.ExperimentsForAdInterfacesExternalModule;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.funnellogger.FunnelLogger;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.PageCallToActionCreateInputData;
import com.facebook.graphql.calls.PageCallToActionDeleteInputData;
import com.facebook.graphql.calls.PageCallToActionDeleteInputData.Source;
import com.facebook.graphql.calls.PageCallToActionUpdateInputData;
import com.facebook.graphql.calls.PageCallToActionUpdateInputData.CtaType;
import com.facebook.graphql.calls.PageCallToActionUpdateInputData.FieldsData;
import com.facebook.graphql.enums.GraphQLBoostedComponentStatus;
import com.facebook.graphql.enums.GraphQLPageCallToActionActionType;
import com.facebook.graphql.enums.GraphQLPageCallToActionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.surface.calltoaction.PageCallToActionFetcher;
import com.facebook.pages.common.surface.calltoaction.PageCallToActionFetcherProvider;
import com.facebook.pages.common.surface.calltoaction.analytics.PageCallToActionAnalytics;
import com.facebook.pages.common.surface.calltoaction.analytics.PageCallToActionEvent;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.CallToActionAdminConfigModel;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.PageAdminCallToActionModel;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.PageAdminCallToActionModel.AdminInfoModel;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.PageAdminCallToActionModel.AdminInfoModel.BoostedCtaPromotionsModel.NodesModel;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.PageAdminCallToActionModel.PageCallToActionModel;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.PhoneNumberCommonFieldsModel;
import com.facebook.pages.common.surface.calltoaction.graphql.PageCallToActionMutations.PageCallToActionCoreCreateMutationString;
import com.facebook.pages.common.surface.calltoaction.graphql.PageCallToActionMutations.PageCallToActionCoreDeleteMutationString;
import com.facebook.pages.common.surface.calltoaction.graphql.PageCallToActionMutations.PageCallToActionCoreUpdateMutationString;
import com.facebook.pages.common.surface.calltoaction.graphql.PageCallToActionMutationsModels.PageCallToActionCoreCreateMutationFieldsModel;
import com.facebook.pages.common.surface.calltoaction.graphql.PageCallToActionMutationsModels.PageCallToActionCoreDeleteMutationModel;
import com.facebook.pages.common.surface.calltoaction.graphql.PageCallToActionMutationsModels.PageCallToActionCoreUpdateMutationFieldsModel;
import com.facebook.pages.common.surface.calltoaction.ui.PageCallToActionInputFieldsContainer;
import com.facebook.pages.common.surface.calltoaction.ui.PageCallToActionLinkRow;
import com.facebook.pages.common.surface.calltoaction.ui.PageCallToActionLinkoutFieldsContainer;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil.PageCallToActionErrorState;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Enums;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: create_overlay */
public class PageConfigureCallToActionFragment extends FbFragment implements CanHandleBackPressed {
    @Inject
    TasksManager f16679a;
    public final OnClickListener aA = new C18107(this);
    @Inject
    UriIntentMapper al;
    public PageCallToActionInputFieldsContainer am;
    public PageCallToActionLinkoutFieldsContainer an;
    private PageCallToActionLinkRow ao;
    private PageCallToActionLinkRow ap;
    private View aq;
    public String ar;
    public boolean as;
    public PageAdminCallToActionModel at;
    public CallToActionAdminConfigModel au;
    public final OnToolbarButtonListener av = new ToolbarButtonListener(this);
    private final View.OnClickListener aw = new CallToActionClickListener(this);
    private final View.OnClickListener ax = new ViewInsightsCallToActionClickListener(this);
    private final View.OnClickListener ay = new DeleteCallToActionClickListener(this);
    public final OnClickListener az = new C18096(this);
    @Inject
    Toaster f16680b;
    @Inject
    PageCallToActionAnalytics f16681c;
    @Inject
    Lazy<FbErrorReporter> f16682d;
    @Inject
    PageCallToActionUtil f16683e;
    @Inject
    PageCallToActionFetcherProvider f16684f;
    @Inject
    SecureContextHelper f16685g;
    @Inject
    QeAccessor f16686h;
    @Inject
    FunnelLoggerImpl f16687i;

    /* compiled from: create_overlay */
    class C18031 implements View.OnClickListener {
        final /* synthetic */ PageConfigureCallToActionFragment f16666a;

        C18031(PageConfigureCallToActionFragment pageConfigureCallToActionFragment) {
            this.f16666a = pageConfigureCallToActionFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 179629056);
            PageConfigureCallToActionFragment.at(this.f16666a);
            this.f16666a.f16681c.f16655a.a(PageCallToActionAnalytics.m19689a(PageCallToActionEvent.EVENT_ADMIN_CALL_TO_ACTION_SWITCH_TO_LINKOUT, this.f16666a.ar));
            Logger.a(2, EntryType.UI_INPUT_END, -510108058, a);
        }
    }

    /* compiled from: create_overlay */
    class C18042 implements View.OnClickListener {
        final /* synthetic */ PageConfigureCallToActionFragment f16667a;

        C18042(PageConfigureCallToActionFragment pageConfigureCallToActionFragment) {
            this.f16667a = pageConfigureCallToActionFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1212762950);
            PageConfigureCallToActionFragment.au(this.f16667a);
            this.f16667a.f16681c.f16655a.a(PageCallToActionAnalytics.m19689a(PageCallToActionEvent.EVENT_ADMIN_CALL_TO_ACTION_SWITCH_FROM_LINKOUT, this.f16667a.ar));
            Logger.a(2, EntryType.UI_INPUT_END, 1542258626, a);
        }
    }

    /* compiled from: create_overlay */
    class C18053 implements View.OnClickListener {
        final /* synthetic */ PageConfigureCallToActionFragment f16668a;

        C18053(PageConfigureCallToActionFragment pageConfigureCallToActionFragment) {
            this.f16668a = pageConfigureCallToActionFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -372594524);
            SecureContextHelper secureContextHelper = this.f16668a.f16685g;
            Context context = this.f16668a.getContext();
            String str = this.f16668a.ar;
            Intent a2 = AdInterfacesIntentUtil.a(context, ObjectiveType.PROMOTE_CTA, Integer.valueOf(2131234051), "edit_cta");
            a2.putExtra("page_id", str);
            secureContextHelper.a(a2, this.f16668a.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, -691083286, a);
        }
    }

    /* compiled from: create_overlay */
    class C18064 extends AbstractDisposableFutureCallback<PageCallToActionCoreUpdateMutationFieldsModel> {
        final /* synthetic */ PageConfigureCallToActionFragment f16669a;

        C18064(PageConfigureCallToActionFragment pageConfigureCallToActionFragment) {
            this.f16669a = pageConfigureCallToActionFragment;
        }

        protected final void m19706a(Object obj) {
            this.f16669a.f16687i.a(FunnelRegistry.O, "save_success", this.f16669a.au.m19786j().name());
            PageConfigureCallToActionFragment.m19714a(this.f16669a, this.f16669a.jW_().getString(2131239578, new Object[]{this.f16669a.au.m19789m()}));
        }

        protected final void m19707a(Throwable th) {
            this.f16669a.f16687i.a(FunnelRegistry.O, "error_message_shown", "server_error");
            PageConfigureCallToActionFragment.m19715a(this.f16669a, th);
        }
    }

    /* compiled from: create_overlay */
    class C18075 extends AbstractDisposableFutureCallback<PageCallToActionCoreCreateMutationFieldsModel> {
        final /* synthetic */ PageConfigureCallToActionFragment f16670a;

        C18075(PageConfigureCallToActionFragment pageConfigureCallToActionFragment) {
            this.f16670a = pageConfigureCallToActionFragment;
        }

        protected final void m19708a(Object obj) {
            this.f16670a.f16687i.a(FunnelRegistry.N, "save_success", this.f16670a.au.m19786j().name());
            PageConfigureCallToActionFragment.m19714a(this.f16670a, this.f16670a.jW_().getString(2131239577, new Object[]{this.f16670a.au.m19789m()}));
        }

        protected final void m19709a(Throwable th) {
            this.f16670a.f16687i.a(FunnelRegistry.N, "error_message_shown", "server_error");
            PageConfigureCallToActionFragment.m19715a(this.f16670a, th);
        }
    }

    /* compiled from: create_overlay */
    class C18096 implements OnClickListener {
        final /* synthetic */ PageConfigureCallToActionFragment f16672a;

        /* compiled from: create_overlay */
        class C18081 extends AbstractDisposableFutureCallback<PageCallToActionCoreDeleteMutationModel> {
            final /* synthetic */ C18096 f16671a;

            C18081(C18096 c18096) {
                this.f16671a = c18096;
            }

            protected final void m19710a(Object obj) {
                PageConfigureCallToActionFragment.m19718b(this.f16671a.f16672a, this.f16671a.f16672a.jW_().getString(2131239579, new Object[]{this.f16671a.f16672a.au.m19789m()}));
            }

            protected final void m19711a(Throwable th) {
                this.f16671a.f16672a.f16680b.a(new ToastBuilder(this.f16671a.f16672a.jW_().getString(2131239580)));
                ((AbstractFbErrorReporter) this.f16671a.f16672a.f16682d.get()).a(PageConfigureCallToActionFragment.class.getSimpleName(), th);
            }
        }

        C18096(PageConfigureCallToActionFragment pageConfigureCallToActionFragment) {
            this.f16672a = pageConfigureCallToActionFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f16672a.f16681c.f16655a.a(PageCallToActionAnalytics.m19689a(PageCallToActionEvent.EVENT_ADMIN_CALL_TO_ACTION_DELETE_CONFIRM, this.f16672a.ar));
            this.f16672a.f16687i.b(FunnelRegistry.O, "tap_delete_confirm_button");
            this.f16672a.f16683e.m20178a(this.f16672a.T);
            if (this.f16672a.at.m19902l() == null) {
                this.f16672a.f16680b.a(new ToastBuilder(this.f16672a.jW_().getString(2131239580)));
                PageConfigureCallToActionFragment.m19718b(this.f16672a, this.f16672a.jW_().getString(2131239580, new Object[]{this.f16672a.au.m19789m()}));
                return;
            }
            PageCallToActionFetcher a = this.f16672a.f16684f.m19688a(this.f16672a.ar);
            PageAdminCallToActionModel pageAdminCallToActionModel = this.f16672a.at;
            PageCallToActionDeleteInputData pageCallToActionDeleteInputData = new PageCallToActionDeleteInputData();
            pageCallToActionDeleteInputData.a("id", pageAdminCallToActionModel.m19902l().m19892m());
            GraphQlCallInput graphQlCallInput = pageCallToActionDeleteInputData;
            graphQlCallInput.a("source", Source.MOBILE_PAGE_PRESENCE_CALL_TO_ACTION);
            this.f16672a.f16679a.a("delete_call_to_action_key", GraphQLQueryExecutor.a(a.f16645a.a(GraphQLRequest.a((PageCallToActionCoreDeleteMutationString) new PageCallToActionCoreDeleteMutationString().a("input", graphQlCallInput)))), new C18081(this));
        }
    }

    /* compiled from: create_overlay */
    class C18107 implements OnClickListener {
        final /* synthetic */ PageConfigureCallToActionFragment f16673a;

        C18107(PageConfigureCallToActionFragment pageConfigureCallToActionFragment) {
            this.f16673a = pageConfigureCallToActionFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f16673a.f16681c.f16655a.a(PageCallToActionAnalytics.m19689a(PageCallToActionEvent.EVENT_ADMIN_CALL_TO_ACTION_DELETE_CANCEL, this.f16673a.ar));
            this.f16673a.f16687i.b(FunnelRegistry.O, "tap_delete_cancel_button");
        }
    }

    /* compiled from: create_overlay */
    /* synthetic */ class C18118 {
        static final /* synthetic */ int[] f16674a = new int[GraphQLBoostedComponentStatus.values().length];

        static {
            try {
                f16674a[GraphQLBoostedComponentStatus.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f16674a[GraphQLBoostedComponentStatus.CREATING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f16674a[GraphQLBoostedComponentStatus.PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f16674a[GraphQLBoostedComponentStatus.PENDING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* compiled from: create_overlay */
    class CallToActionClickListener implements View.OnClickListener {
        final /* synthetic */ PageConfigureCallToActionFragment f16675a;

        public CallToActionClickListener(PageConfigureCallToActionFragment pageConfigureCallToActionFragment) {
            this.f16675a = pageConfigureCallToActionFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2012836522);
            this.f16675a.f16683e.m20178a(this.f16675a.T);
            this.f16675a.f16687i.b(FunnelRegistry.O, "tap_change_cta_button");
            PageCallToActionUtil pageCallToActionUtil = this.f16675a.f16683e;
            PageCallToActionUtil.m20165a(this.f16675a.kO_(), this.f16675a, PageSelectCallToActionFragment.m19725a(this.f16675a.at, this.f16675a.ar, true));
            this.f16675a.f16681c.m19692a(this.f16675a.ar, PageCallToActionUtil.m20163a(this.f16675a.an.isShown(), this.f16675a.au.m19786j()));
            Logger.a(2, EntryType.UI_INPUT_END, -237202435, a);
        }
    }

    /* compiled from: create_overlay */
    class DeleteCallToActionClickListener implements View.OnClickListener {
        final /* synthetic */ PageConfigureCallToActionFragment f16676a;

        public DeleteCallToActionClickListener(PageConfigureCallToActionFragment pageConfigureCallToActionFragment) {
            this.f16676a = pageConfigureCallToActionFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1491877173);
            this.f16676a.f16681c.f16655a.a(PageCallToActionAnalytics.m19689a(PageCallToActionEvent.EVENT_ADMIN_CALL_TO_ACTION_DELETE, this.f16676a.ar));
            this.f16676a.f16687i.b(FunnelRegistry.O, "tap_delete_button");
            new Builder(this.f16676a.getContext()).a(2131239575).b(this.f16676a.b(2131239576)).a(this.f16676a.b(2131230729), this.f16676a.az).b(this.f16676a.b(2131230727), this.f16676a.aA).b();
            Logger.a(2, EntryType.UI_INPUT_END, -354630174, a);
        }
    }

    /* compiled from: create_overlay */
    class ToolbarButtonListener extends OnToolbarButtonListener {
        final /* synthetic */ PageConfigureCallToActionFragment f16677a;

        public ToolbarButtonListener(PageConfigureCallToActionFragment pageConfigureCallToActionFragment) {
            this.f16677a = pageConfigureCallToActionFragment;
        }

        public final void m19712a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            PageCallToActionErrorState a;
            GraphQLPageCallToActionType j = this.f16677a.au.m19786j();
            this.f16677a.f16681c.m19692a(this.f16677a.ar, PageCallToActionUtil.m20163a(this.f16677a.an.isShown(), j));
            PageConfigureCallToActionFragment pageConfigureCallToActionFragment = this.f16677a;
            if (pageConfigureCallToActionFragment.am.isShown()) {
                a = pageConfigureCallToActionFragment.am.m20081a();
            } else {
                a = pageConfigureCallToActionFragment.an.m20092a();
            }
            PageCallToActionErrorState pageCallToActionErrorState = a;
            if (pageCallToActionErrorState != PageCallToActionErrorState.NONE) {
                this.f16677a.f16681c.m19691a(this.f16677a.ar, pageCallToActionErrorState);
                return;
            }
            this.f16677a.am.m20083a(true);
            if (this.f16677a.as) {
                this.f16677a.f16687i.a(FunnelRegistry.O, "tap_save_cta_button", j.name());
                PageConfigureCallToActionFragment.av(this.f16677a);
            } else {
                this.f16677a.f16687i.a(FunnelRegistry.N, "tap_save_cta_button", j.name());
                PageConfigureCallToActionFragment.aw(this.f16677a);
            }
            PageCallToActionAnalytics pageCallToActionAnalytics = this.f16677a.f16681c;
            String str = this.f16677a.ar;
            Map b = this.f16677a.m19723b();
            HoneyClientEvent a2 = PageCallToActionAnalytics.m19689a(PageCallToActionEvent.EVENT_ADMIN_CALL_TO_ACTION_SAVE, str);
            for (Entry entry : b.entrySet()) {
                a2.b((String) entry.getKey(), (String) entry.getValue());
            }
            pageCallToActionAnalytics.f16655a.a(a2);
        }
    }

    /* compiled from: create_overlay */
    class ViewInsightsCallToActionClickListener implements View.OnClickListener {
        final /* synthetic */ PageConfigureCallToActionFragment f16678a;

        public ViewInsightsCallToActionClickListener(PageConfigureCallToActionFragment pageConfigureCallToActionFragment) {
            this.f16678a = pageConfigureCallToActionFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1188660735);
            if (!(this.f16678a.at == null || this.f16678a.at.m19902l() == null)) {
                this.f16678a.f16685g.a(this.f16678a.al.a(this.f16678a.getContext(), this.f16678a.at.m19902l().m19891l()), this.f16678a.getContext());
            }
            Logger.a(2, EntryType.UI_INPUT_END, -762220414, a);
        }
    }

    public static void m19717a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PageConfigureCallToActionFragment) obj).m19716a(TasksManager.b(injectorLike), Toaster.b(injectorLike), PageCallToActionAnalytics.m19690b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), PageCallToActionUtil.m20160a(injectorLike), (PageCallToActionFetcherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PageCallToActionFetcherProvider.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FunnelLoggerImpl.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike));
    }

    private void m19716a(TasksManager tasksManager, Toaster toaster, PageCallToActionAnalytics pageCallToActionAnalytics, Lazy<FbErrorReporter> lazy, PageCallToActionUtil pageCallToActionUtil, PageCallToActionFetcherProvider pageCallToActionFetcherProvider, SecureContextHelper secureContextHelper, QeAccessor qeAccessor, FunnelLogger funnelLogger, UriIntentMapper uriIntentMapper) {
        this.f16679a = tasksManager;
        this.f16680b = toaster;
        this.f16681c = pageCallToActionAnalytics;
        this.f16682d = lazy;
        this.f16683e = pageCallToActionUtil;
        this.f16684f = pageCallToActionFetcherProvider;
        this.f16685g = secureContextHelper;
        this.f16686h = qeAccessor;
        this.f16687i = funnelLogger;
        this.al = uriIntentMapper;
    }

    public static PageConfigureCallToActionFragment m19713a(PageAdminCallToActionModel pageAdminCallToActionModel, CallToActionAdminConfigModel callToActionAdminConfigModel, String str) {
        PageConfigureCallToActionFragment pageConfigureCallToActionFragment = new PageConfigureCallToActionFragment();
        Bundle bundle = new Bundle();
        FlatBufferModelHelper.a(bundle, "arg_page_admin_cta", pageAdminCallToActionModel);
        FlatBufferModelHelper.a(bundle, "arg_admin_config", callToActionAdminConfigModel);
        bundle.putString("arg_page_id", str);
        pageConfigureCallToActionFragment.g(bundle);
        return pageConfigureCallToActionFragment;
    }

    public final void m19724c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = PageConfigureCallToActionFragment.class;
        m19717a((Object) this, getContext());
        Bundle bundle2 = this.s;
        this.at = (PageAdminCallToActionModel) FlatBufferModelHelper.a(bundle2, "arg_page_admin_cta");
        this.au = (CallToActionAdminConfigModel) FlatBufferModelHelper.a(bundle2, "arg_admin_config");
        this.ar = bundle2.getString("arg_page_id");
    }

    public final View m19721a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2054392208);
        this.aq = layoutInflater.inflate(2130905996, viewGroup, false);
        View view = this.aq;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1675362718, a);
        return view;
    }

    public final void m19722a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.as = !PageCallToActionUtil.m20173c(this.at);
        this.am = (PageCallToActionInputFieldsContainer) e(2131565399);
        this.an = (PageCallToActionLinkoutFieldsContainer) e(2131565400);
        FbTextView fbTextView = (FbTextView) e(2131565401);
        this.ao = (PageCallToActionLinkRow) e(2131565402);
        this.ao.setOnClickListener(new C18031(this));
        this.ap = (PageCallToActionLinkRow) e(2131565403);
        this.ap.setOnClickListener(new C18042(this));
        PageCallToActionLinkRow pageCallToActionLinkRow = (PageCallToActionLinkRow) e(2131565406);
        PageCallToActionLinkRow pageCallToActionLinkRow2 = (PageCallToActionLinkRow) e(2131565407);
        PageCallToActionLinkRow pageCallToActionLinkRow3 = (PageCallToActionLinkRow) e(2131565408);
        AdminInfoModel j = this.at.m19900j();
        if (j != null && j.m19870j() && this.f16686h.a(ExperimentsForAdInterfacesExternalModule.e, false) && !j.m19868a().m19863a().isEmpty()) {
            PageCallToActionLinkRow pageCallToActionLinkRow4;
            switch (C18118.f16674a[((NodesModel) j.m19868a().m19863a().get(0)).m19858a().ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    pageCallToActionLinkRow4 = (PageCallToActionLinkRow) e(2131565405);
                    break;
                default:
                    pageCallToActionLinkRow4 = (PageCallToActionLinkRow) e(2131565404);
                    break;
            }
            pageCallToActionLinkRow4.setVisibility(0);
            pageCallToActionLinkRow4.setOnClickListener(new C18053(this));
        }
        if (!PageCallToActionUtil.m20173c(this.at)) {
            pageCallToActionLinkRow.setVisibility(0);
            pageCallToActionLinkRow.setOnClickListener(this.aw);
            pageCallToActionLinkRow2.setVisibility(0);
            pageCallToActionLinkRow2.setOnClickListener(this.ax);
            pageCallToActionLinkRow3.setVisibility(0);
            pageCallToActionLinkRow3.setOnClickListener(this.ay);
        }
        if (!this.ao.isShown() && !this.ap.isShown() && !pageCallToActionLinkRow.isShown() && !pageCallToActionLinkRow2.isShown() && !pageCallToActionLinkRow3.isShown()) {
            fbTextView.setVisibility(8);
            CustomViewUtils.b(this.aq, new ColorDrawable(jW_().getColor(2131361920)));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mi_() {
        /*
        r9 = this;
        r3 = 2;
        r0 = com.facebook.loom.logger.LogEntry.EntryType.LIFECYCLE_FRAGMENT_START;
        r1 = -1361978040; // 0xffffffffaed1dd48 float:-9.543527E-11 double:NaN;
        r0 = com.facebook.loom.logger.Logger.a(r3, r0, r1);
        super.mi_();
        r4 = com.facebook.widget.titlebar.HasTitleBar.class;
        r4 = r9.a(r4);
        r4 = (com.facebook.widget.titlebar.HasTitleBar) r4;
        if (r4 == 0) goto L_0x004f;
    L_0x0017:
        r5 = r9.au;
        r6 = r5.m19789m();
        r5 = com.facebook.common.util.StringUtil.a(r6);
        if (r5 == 0) goto L_0x009a;
    L_0x0023:
        r5 = 2131239549; // 0x7f08227d float:1.8095408E38 double:1.052972244E-314;
        r4.y_(r5);
    L_0x0029:
        r5 = 1;
        r4.c(r5);
        r6 = com.facebook.widget.titlebar.TitleBarButtonSpec.a();
        r7 = r9.jW_();
        r5 = r9.as;
        if (r5 == 0) goto L_0x00c0;
    L_0x0039:
        r5 = 2131239545; // 0x7f082279 float:1.80954E38 double:1.052972242E-314;
    L_0x003c:
        r5 = r7.getString(r5);
        r6.g = r5;
        r5 = r6;
        r5 = r5.a();
        r4.a(r5);
        r5 = r9.av;
        r4.a(r5);
    L_0x004f:
        r4 = r9.as;
        if (r4 == 0) goto L_0x0067;
    L_0x0053:
        r4 = r9.au;
        r5 = com.facebook.graphql.enums.GraphQLPageCallToActionActionType.WEBSITE;
        r5 = com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil.m20159a(r5, r4);
        if (r5 == 0) goto L_0x00c9;
    L_0x005d:
        r5 = r5.m19764k();
        if (r5 == 0) goto L_0x00c9;
    L_0x0063:
        r5 = 1;
    L_0x0064:
        r4 = r5;
        if (r4 != 0) goto L_0x008e;
    L_0x0067:
        r4 = r9.au;
        r5 = 0;
        if (r4 == 0) goto L_0x008b;
    L_0x006c:
        r6 = r4.m19785a();
        if (r6 == 0) goto L_0x008b;
    L_0x0072:
        r6 = r4.m19785a();
        r6 = r6.m19768a();
        if (r6 == 0) goto L_0x008b;
    L_0x007c:
        r6 = r4.m19785a();
        r6 = r6.m19768a();
        r6 = r6.size();
        r7 = 1;
        if (r6 == r7) goto L_0x00cb;
    L_0x008b:
        r4 = r5;
        if (r4 == 0) goto L_0x00c5;
    L_0x008e:
        at(r9);
    L_0x0091:
        r1 = com.facebook.loom.logger.LogEntry.EntryType.LIFECYCLE_FRAGMENT_END;
        r2 = -68961232; // 0xfffffffffbe3bc30 float:-2.3649366E36 double:NaN;
        com.facebook.loom.logger.Logger.a(r3, r1, r2, r0);
        return;
    L_0x009a:
        r7 = "%s %s";
        r5 = r9.as;
        if (r5 == 0) goto L_0x00b4;
    L_0x00a0:
        r5 = r9.jW_();
        r8 = 2131239547; // 0x7f08227b float:1.8095404E38 double:1.052972243E-314;
        r5 = r5.getString(r8);
    L_0x00ab:
        r5 = com.facebook.common.stringformat.StringFormatUtil.formatStrLocaleSafe(r7, r5, r6);
        r4.a_(r5);
        goto L_0x0029;
    L_0x00b4:
        r5 = r9.jW_();
        r8 = 2131239546; // 0x7f08227a float:1.8095402E38 double:1.0529722427E-314;
        r5 = r5.getString(r8);
        goto L_0x00ab;
    L_0x00c0:
        r5 = 2131239546; // 0x7f08227a float:1.8095402E38 double:1.0529722427E-314;
        goto L_0x003c;
    L_0x00c5:
        au(r9);
        goto L_0x0091;
    L_0x00c9:
        r5 = 0;
        goto L_0x0064;
    L_0x00cb:
        r6 = r4.m19785a();
        r6 = r6.m19768a();
        r5 = r6.get(r5);
        r5 = (com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.CallToActionAdminConfigModel.ConfigFieldsModel.NodesModel) r5;
        r5 = r5.m19760a();
        r6 = com.facebook.graphql.enums.GraphQLPageCallToActionActionType.WEBSITE;
        r5 = r5.equals(r6);
        goto L_0x008b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.surface.calltoaction.fragment.PageConfigureCallToActionFragment.mi_():void");
    }

    public static void at(PageConfigureCallToActionFragment pageConfigureCallToActionFragment) {
        Object obj;
        int i = 0;
        pageConfigureCallToActionFragment.an.setVisibility(0);
        pageConfigureCallToActionFragment.am.setVisibility(8);
        pageConfigureCallToActionFragment.an.m20093a(pageConfigureCallToActionFragment.as, pageConfigureCallToActionFragment.au, pageConfigureCallToActionFragment.ar);
        PageCallToActionLinkRow pageCallToActionLinkRow = pageConfigureCallToActionFragment.ap;
        if (PageCallToActionUtil.m20159a(GraphQLPageCallToActionActionType.LEAD_GEN, pageConfigureCallToActionFragment.au) != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            i = 8;
        }
        pageCallToActionLinkRow.setVisibility(i);
        pageConfigureCallToActionFragment.ao.setVisibility(8);
    }

    public static void au(PageConfigureCallToActionFragment pageConfigureCallToActionFragment) {
        Object obj;
        int i = 0;
        pageConfigureCallToActionFragment.an.setVisibility(8);
        pageConfigureCallToActionFragment.am.setVisibility(0);
        PageCallToActionUtil pageCallToActionUtil = pageConfigureCallToActionFragment.f16683e;
        CallToActionAdminConfigModel callToActionAdminConfigModel = pageConfigureCallToActionFragment.au;
        PageCallToActionInputFieldsContainer pageCallToActionInputFieldsContainer = pageConfigureCallToActionFragment.am;
        PhoneNumberCommonFieldsModel phoneNumberCommonFieldsModel = null;
        PageCallToActionModel l = pageConfigureCallToActionFragment.at.m19902l();
        if (l != null && (l.m19890k() == GraphQLPageCallToActionType.CALL_NOW || l.m19890k() == GraphQLPageCallToActionType.NONE)) {
            phoneNumberCommonFieldsModel = l.m19893n();
        }
        pageCallToActionUtil.m20179a(callToActionAdminConfigModel, pageCallToActionInputFieldsContainer, phoneNumberCommonFieldsModel, pageConfigureCallToActionFragment.ar, false);
        PageCallToActionLinkRow pageCallToActionLinkRow = pageConfigureCallToActionFragment.ao;
        if (PageCallToActionUtil.m20159a(GraphQLPageCallToActionActionType.WEBSITE, pageConfigureCallToActionFragment.au) != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            i = 8;
        }
        pageCallToActionLinkRow.setVisibility(i);
        pageConfigureCallToActionFragment.ap.setVisibility(8);
    }

    public final Map<String, String> m19723b() {
        if (this.an.isShown()) {
            return this.an.getFieldValues();
        }
        Preconditions.checkArgument(this.am.isShown());
        return this.am.getFieldValues();
    }

    public static void m19714a(PageConfigureCallToActionFragment pageConfigureCallToActionFragment, String str) {
        pageConfigureCallToActionFragment.am.m20083a(false);
        m19718b(pageConfigureCallToActionFragment, str);
    }

    public static void m19715a(PageConfigureCallToActionFragment pageConfigureCallToActionFragment, Throwable th) {
        pageConfigureCallToActionFragment.am.m20083a(false);
        pageConfigureCallToActionFragment.am.m20084c(2131239574);
        ((AbstractFbErrorReporter) pageConfigureCallToActionFragment.f16682d.get()).a(PageConfigureCallToActionFragment.class.getSimpleName(), th);
        pageConfigureCallToActionFragment.f16681c.m19691a(pageConfigureCallToActionFragment.ar, PageCallToActionErrorState.SERVER);
    }

    public static void av(PageConfigureCallToActionFragment pageConfigureCallToActionFragment) {
        TasksManager tasksManager = pageConfigureCallToActionFragment.f16679a;
        String str = "edit_call_to_action_key";
        PageCallToActionFetcher a = pageConfigureCallToActionFragment.f16684f.m19688a(pageConfigureCallToActionFragment.ar);
        PageAdminCallToActionModel pageAdminCallToActionModel = pageConfigureCallToActionFragment.at;
        CallToActionAdminConfigModel callToActionAdminConfigModel = pageConfigureCallToActionFragment.au;
        Map b = pageConfigureCallToActionFragment.m19723b();
        CtaType ctaType = (CtaType) Enums.getIfPresent(CtaType.class, callToActionAdminConfigModel.m19786j().toString()).or(CtaType.NONE);
        List arrayList = new ArrayList();
        for (Entry entry : b.entrySet()) {
            FieldsData fieldsData = new FieldsData();
            fieldsData.a("field_key", (String) entry.getKey());
            GraphQlCallInput graphQlCallInput = fieldsData;
            graphQlCallInput.a("field_value", (String) entry.getValue());
            arrayList.add(graphQlCallInput);
        }
        PageCallToActionUpdateInputData pageCallToActionUpdateInputData = new PageCallToActionUpdateInputData();
        pageCallToActionUpdateInputData.a("id", pageAdminCallToActionModel.m19902l().m19892m());
        GraphQlCallInput graphQlCallInput2 = pageCallToActionUpdateInputData;
        graphQlCallInput2.a("source", PageCallToActionUpdateInputData.Source.MOBILE_PAGE_PRESENCE_CALL_TO_ACTION);
        graphQlCallInput2 = graphQlCallInput2;
        graphQlCallInput2.a("cta_type", ctaType);
        GraphQlCallInput graphQlCallInput3 = graphQlCallInput2;
        graphQlCallInput3.a("fields_data", arrayList);
        tasksManager.a(str, GraphQLQueryExecutor.a(a.f16645a.a(GraphQLRequest.a((PageCallToActionCoreUpdateMutationString) new PageCallToActionCoreUpdateMutationString().a("input", graphQlCallInput3)))), new C18064(pageConfigureCallToActionFragment));
    }

    public static void aw(PageConfigureCallToActionFragment pageConfigureCallToActionFragment) {
        TasksManager tasksManager = pageConfigureCallToActionFragment.f16679a;
        String str = "create_call_to_action_key";
        PageCallToActionFetcher a = pageConfigureCallToActionFragment.f16684f.m19688a(pageConfigureCallToActionFragment.ar);
        PageAdminCallToActionModel pageAdminCallToActionModel = pageConfigureCallToActionFragment.at;
        CallToActionAdminConfigModel callToActionAdminConfigModel = pageConfigureCallToActionFragment.au;
        Map b = pageConfigureCallToActionFragment.m19723b();
        PageCallToActionCreateInputData.CtaType ctaType = (PageCallToActionCreateInputData.CtaType) Enums.getIfPresent(PageCallToActionCreateInputData.CtaType.class, callToActionAdminConfigModel.m19786j().toString()).or(PageCallToActionCreateInputData.CtaType.NONE);
        List arrayList = new ArrayList();
        for (Entry entry : b.entrySet()) {
            PageCallToActionCreateInputData.FieldsData fieldsData = new PageCallToActionCreateInputData.FieldsData();
            fieldsData.a("field_key", (String) entry.getKey());
            GraphQlCallInput graphQlCallInput = fieldsData;
            graphQlCallInput.a("field_value", (String) entry.getValue());
            arrayList.add(graphQlCallInput);
        }
        PageCallToActionCreateInputData pageCallToActionCreateInputData = new PageCallToActionCreateInputData();
        pageCallToActionCreateInputData.a("page_id", pageAdminCallToActionModel.m19901k());
        GraphQlCallInput graphQlCallInput2 = pageCallToActionCreateInputData;
        graphQlCallInput2.a("source", PageCallToActionCreateInputData.Source.MOBILE_PAGE_PRESENCE_CALL_TO_ACTION);
        graphQlCallInput2 = graphQlCallInput2;
        graphQlCallInput2.a("cta_type", ctaType);
        GraphQlCallInput graphQlCallInput3 = graphQlCallInput2;
        graphQlCallInput3.a("fields_data", arrayList);
        tasksManager.a(str, GraphQLQueryExecutor.a(a.f16645a.a(GraphQLRequest.a((PageCallToActionCoreCreateMutationString) new PageCallToActionCoreCreateMutationString().a("input", graphQlCallInput3)))), new C18075(pageConfigureCallToActionFragment));
    }

    public final void m19719H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2024541461);
        this.f16683e.m20178a(this.T);
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2031655081, a);
    }

    public final void m19720I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -820417687);
        super.I();
        this.f16679a.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2084491891, a);
    }

    public final boolean O_() {
        this.f16681c.m19693b(this.ar, PageCallToActionUtil.m20163a(this.an.isShown(), this.au.m19786j()));
        return false;
    }

    public static void m19718b(PageConfigureCallToActionFragment pageConfigureCallToActionFragment, String str) {
        pageConfigureCallToActionFragment.f16687i.b(pageConfigureCallToActionFragment.as ? FunnelRegistry.O : FunnelRegistry.N);
        Intent intent = new Intent();
        intent.putExtra("show_snackbar_extra", str);
        FragmentActivity o = pageConfigureCallToActionFragment.o();
        o.setResult(-1, intent);
        o.finish();
    }
}
