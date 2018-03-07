package com.facebook.commerce.publishing.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.commerce.core.util.CommerceCurrencyUtil;
import com.facebook.commerce.core.util.CommerceNavigationUtil;
import com.facebook.commerce.publishing.adapter.AdminShopCurrencySelectorView;
import com.facebook.commerce.publishing.analytics.CommercePublishingAnalytics.CommercePublishingAnalyticsEvent;
import com.facebook.commerce.publishing.analytics.CommercePublishingLogger;
import com.facebook.commerce.publishing.constants.AdminShopConstants;
import com.facebook.commerce.publishing.event.CommercePublishingEventBus;
import com.facebook.commerce.publishing.fetcher.AdminAddShopFetcher;
import com.facebook.commerce.publishing.fetcher.AdminAddShopFetcher.AdminAddShopFields;
import com.facebook.commerce.publishing.fetcher.AdminAddShopFetcher.C21411;
import com.facebook.commerce.publishing.fetcher.AdminAddShopFetcher.C21422;
import com.facebook.commerce.publishing.graphql.CommerceStoreCreateMutation.CommerceStoreCreateMutationString;
import com.facebook.commerce.publishing.graphql.CommerceStoreCreateMutationModels.CommerceStoreCreateMutationModel;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverMenuWindow.OnMenuItemClickListener;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.graphql.calls.CommerceContactMerchantStoreCreateInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.viewercontextutils.PageViewerContextLifecycleHelper;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.text.BetterButton;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: cymk_suggestion_contact_add */
public class AdminAddShopFragment extends FbFragment implements CanHandleBackPressed {
    public static final String f15541g = AdminAddShopFragment.class.getSimpleName();
    @Inject
    public TasksManager f15542a;
    public boolean al = false;
    public boolean am = false;
    public AddShopScreen an = AddShopScreen.SET_UP_SHOP;
    public ViewGroup ao;
    public ViewGroup ap;
    public ViewGroup aq;
    public AdminShopCurrencySelectorView ar;
    public BetterButton as;
    public DialogBasedProgressIndicator at;
    @Nullable
    public FigPopoverMenuWindow au;
    @Nullable
    public String av;
    @Inject
    public AdminAddShopFetcher f15543b;
    @Inject
    Toaster f15544c;
    @Inject
    public CommercePublishingLogger f15545d;
    @Inject
    PageViewerContextLifecycleHelper f15546e;
    @Inject
    public Lazy<CommerceNavigationUtil> f15547f;
    public long f15548h;
    public boolean f15549i = false;

    /* compiled from: cymk_suggestion_contact_add */
    public class C21451 extends AbstractDisposableFutureCallback<AdminAddShopFields> {
        final /* synthetic */ AdminAddShopFragment f15531a;

        public C21451(AdminAddShopFragment adminAddShopFragment) {
            this.f15531a = adminAddShopFragment;
        }

        protected final void m16030a(Object obj) {
            Object obj2;
            AdminAddShopFields adminAddShopFields = (AdminAddShopFields) obj;
            AdminAddShopFragment adminAddShopFragment = this.f15531a;
            if (adminAddShopFields.f15514b) {
                adminAddShopFragment.ao().finish();
                ((CommerceNavigationUtil) adminAddShopFragment.f15547f.get()).a(adminAddShopFragment.f15548h);
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 == null) {
                adminAddShopFragment = this.f15531a;
                adminAddShopFragment.f15549i = adminAddShopFields.f15515c;
                ViewGroup viewGroup = adminAddShopFragment.ao;
                adminAddShopFragment.ap = (ViewGroup) LayoutInflater.from(adminAddShopFragment.o()).inflate(2130903181, viewGroup, false);
                adminAddShopFragment.ar = (AdminShopCurrencySelectorView) adminAddShopFragment.ap.findViewById(2131559426);
                adminAddShopFragment.ar.setOnClickListener(new C21506(adminAddShopFragment));
                adminAddShopFragment.as = (BetterButton) adminAddShopFragment.ap.findViewById(2131559424);
                adminAddShopFragment.as.setText(adminAddShopFragment.f15549i ? 2131239312 : 2131239311);
                adminAddShopFragment.as.setOnClickListener(new C21517(adminAddShopFragment));
                adminAddShopFragment.ap.findViewById(2131559425).setOnClickListener(new C21528(adminAddShopFragment));
                viewGroup.addView(adminAddShopFragment.ap);
                ImmutableList immutableList = adminAddShopFields.f15513a;
                adminAddShopFragment.au = new FigPopoverMenuWindow(adminAddShopFragment.getContext());
                PopoverMenu popoverMenu = new PopoverMenu(adminAddShopFragment.getContext());
                for (int i = 0; i < immutableList.size(); i++) {
                    popoverMenu.a(i, i, (String) ((Pair) immutableList.get(i)).b);
                }
                adminAddShopFragment.au.a(popoverMenu);
                adminAddShopFragment.au.p = new C21462(adminAddShopFragment, immutableList);
                if (!adminAddShopFragment.al) {
                    adminAddShopFragment.f15545d.a(CommercePublishingAnalyticsEvent.IMP_CURRENCY_SELECTION, String.valueOf(adminAddShopFragment.f15548h));
                    adminAddShopFragment.al = true;
                }
            }
        }

        protected final void m16031a(Throwable th) {
            BLog.a(AdminAddShopFragment.f15541g, "failed to load currency data", th);
        }
    }

    /* compiled from: cymk_suggestion_contact_add */
    public class C21462 implements OnMenuItemClickListener {
        final /* synthetic */ ImmutableList f15532a;
        final /* synthetic */ AdminAddShopFragment f15533b;

        public C21462(AdminAddShopFragment adminAddShopFragment, ImmutableList immutableList) {
            this.f15533b = adminAddShopFragment;
            this.f15532a = immutableList;
        }

        public final boolean m16032a(MenuItem menuItem) {
            Pair pair = (Pair) this.f15532a.get(menuItem.getOrder());
            this.f15533b.av = (String) pair.a;
            this.f15533b.ar.setText((CharSequence) pair.b);
            this.f15533b.as.setEnabled(true);
            return true;
        }
    }

    /* compiled from: cymk_suggestion_contact_add */
    public class C21473 extends AbstractDisposableFutureCallback<CommerceStoreCreateMutationModel> {
        final /* synthetic */ AdminAddShopFragment f15534a;

        public C21473(AdminAddShopFragment adminAddShopFragment) {
            this.f15534a = adminAddShopFragment;
        }

        protected final void m16033a(Object obj) {
            this.f15534a.at.b();
            this.f15534a.am = true;
            this.f15534a.o().finish();
            ((CommerceNavigationUtil) this.f15534a.f15547f.get()).a(this.f15534a.f15548h);
        }

        protected final void m16034a(Throwable th) {
            BLog.a(AdminAddShopFragment.f15541g, "create shop mutation failed", th);
            this.f15534a.at.b();
            this.f15534a.f15544c.b(new ToastBuilder(2131234805));
        }
    }

    /* compiled from: cymk_suggestion_contact_add */
    public class C21484 implements Runnable {
        final /* synthetic */ AdminAddShopFragment f15535a;

        public C21484(AdminAddShopFragment adminAddShopFragment) {
            this.f15535a = adminAddShopFragment;
        }

        public void run() {
            this.f15535a.f15545d.a(CommercePublishingAnalyticsEvent.IMP_PRIVATE_MESSAGE_SELECTION, String.valueOf(this.f15535a.f15548h));
            this.f15535a.an = AddShopScreen.TURN_ON_MESSAGING;
        }
    }

    /* compiled from: cymk_suggestion_contact_add */
    class C21495 implements Runnable {
        final /* synthetic */ AdminAddShopFragment f15536a;

        C21495(AdminAddShopFragment adminAddShopFragment) {
            this.f15536a = adminAddShopFragment;
        }

        public void run() {
            this.f15536a.an = AddShopScreen.SET_UP_SHOP;
        }
    }

    /* compiled from: cymk_suggestion_contact_add */
    public class C21506 implements OnClickListener {
        final /* synthetic */ AdminAddShopFragment f15537a;

        public C21506(AdminAddShopFragment adminAddShopFragment) {
            this.f15537a = adminAddShopFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1238389126);
            if (this.f15537a.au == null || this.f15537a.au.r) {
                Logger.a(2, EntryType.UI_INPUT_END, 1390480713, a);
                return;
            }
            this.f15537a.au.f(view);
            LogUtils.a(-1245676454, a);
        }
    }

    /* compiled from: cymk_suggestion_contact_add */
    public class C21517 implements OnClickListener {
        final /* synthetic */ AdminAddShopFragment f15538a;

        public C21517(AdminAddShopFragment adminAddShopFragment) {
            this.f15538a = adminAddShopFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 93785590);
            if (this.f15538a.f15549i) {
                AdminAddShopFragment.av(this.f15538a);
            } else {
                AdminAddShopFragment adminAddShopFragment = this.f15538a;
                if (adminAddShopFragment.aq == null) {
                    ViewGroup viewGroup = adminAddShopFragment.ao;
                    adminAddShopFragment.aq = (ViewGroup) LayoutInflater.from(adminAddShopFragment.o()).inflate(2130903180, viewGroup, false);
                    adminAddShopFragment.aq.findViewById(2131559424).setOnClickListener(new C21539(adminAddShopFragment));
                    adminAddShopFragment.aq.findViewById(2131559425).setOnClickListener(new OnClickListener(adminAddShopFragment) {
                        final /* synthetic */ AdminAddShopFragment f15529a;

                        {
                            this.f15529a = r1;
                        }

                        public void onClick(View view) {
                            int a = Logger.a(2, EntryType.UI_INPUT_START, 1456198682);
                            AdminAddShopFragment.au(this.f15529a);
                            Logger.a(2, EntryType.UI_INPUT_END, -555577579, a);
                        }
                    });
                    viewGroup.addView(adminAddShopFragment.aq);
                }
                int width = adminAddShopFragment.ao.getWidth();
                adminAddShopFragment.aq.setTranslationX((float) width);
                adminAddShopFragment.aq.animate().translationX(0.0f);
                adminAddShopFragment.ap.animate().translationX((float) (-width)).setDuration(300);
                adminAddShopFragment.ap.postDelayed(new C21484(adminAddShopFragment), 300);
                adminAddShopFragment.an = AddShopScreen.ANIMATING;
            }
            LogUtils.a(-1480954678, a);
        }
    }

    /* compiled from: cymk_suggestion_contact_add */
    public class C21528 implements OnClickListener {
        final /* synthetic */ AdminAddShopFragment f15539a;

        public C21528(AdminAddShopFragment adminAddShopFragment) {
            this.f15539a = adminAddShopFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1917175210);
            this.f15539a.o().finish();
            Logger.a(2, EntryType.UI_INPUT_END, 954734670, a);
        }
    }

    /* compiled from: cymk_suggestion_contact_add */
    public class C21539 implements OnClickListener {
        final /* synthetic */ AdminAddShopFragment f15540a;

        public C21539(AdminAddShopFragment adminAddShopFragment) {
            this.f15540a = adminAddShopFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1645277121);
            AdminAddShopFragment.av(this.f15540a);
            Logger.a(2, EntryType.UI_INPUT_END, 1698984001, a);
        }
    }

    /* compiled from: cymk_suggestion_contact_add */
    public enum AddShopScreen {
        SET_UP_SHOP,
        TURN_ON_MESSAGING,
        ANIMATING
    }

    /* compiled from: cymk_suggestion_contact_add */
    public enum Task {
        FETCH_ADD_SHOP_FIELDS,
        CREATE_SHOP_MUTATION
    }

    public static void m16036a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((AdminAddShopFragment) obj).m16035a(TasksManager.b(fbInjector), new AdminAddShopFetcher(GraphQLQueryExecutor.a(fbInjector), ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(fbInjector), CommerceCurrencyUtil.b(fbInjector), GraphQLCacheManager.a(fbInjector), CommercePublishingEventBus.a(fbInjector)), Toaster.b(fbInjector), CommercePublishingLogger.a(fbInjector), PageViewerContextLifecycleHelper.a(fbInjector), IdBasedLazy.a(fbInjector, 5054));
    }

    private void m16035a(TasksManager tasksManager, AdminAddShopFetcher adminAddShopFetcher, Toaster toaster, CommercePublishingLogger commercePublishingLogger, PageViewerContextLifecycleHelper pageViewerContextLifecycleHelper, Lazy<CommerceNavigationUtil> lazy) {
        this.f15542a = tasksManager;
        this.f15543b = adminAddShopFetcher;
        this.f15544c = toaster;
        this.f15545d = commercePublishingLogger;
        this.f15546e = pageViewerContextLifecycleHelper;
        this.f15547f = lazy;
    }

    public final void m16040c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = AdminAddShopFragment.class;
        m16036a((Object) this, getContext());
        this.f15548h = this.s.getLong(AdminShopConstants.f15509a);
        this.f15546e.a();
        this.f15546e.a(Long.toString(this.f15548h));
    }

    public final View m16038a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 907794393);
        View inflate = layoutInflater.inflate(2130903179, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 759436429, a);
        return inflate;
    }

    public final void m16039a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        if (o() != null) {
            o().setRequestedOrientation(1);
        }
        this.ao = (ViewGroup) e(2131559419);
        this.at = new DialogBasedProgressIndicator(getContext(), 2131239302);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1474676723);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.c(true);
            hasTitleBar.y_(2131239294);
        }
        if (this.au == null) {
            TasksManager tasksManager = this.f15542a;
            Task task = Task.FETCH_ADD_SHOP_FIELDS;
            AdminAddShopFetcher adminAddShopFetcher = this.f15543b;
            tasksManager.a(task, adminAddShopFetcher.f15517b.a(new C21422(adminAddShopFetcher, this.f15548h)), new C21451(this));
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1504027484, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -788522968);
        super.mj_();
        this.f15542a.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1660096880, a);
    }

    public final void m16037I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 950972466);
        super.I();
        this.f15546e.b();
        if (this.al && !this.am) {
            this.f15545d.a(CommercePublishingAnalyticsEvent.ACTN_CANCEL_CURRENCY_SELECTION, String.valueOf(this.f15548h));
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 846419462, a);
    }

    public final boolean O_() {
        switch (this.an) {
            case TURN_ON_MESSAGING:
                au(this);
                return true;
            case ANIMATING:
                return true;
            default:
                return false;
        }
    }

    public static void au(AdminAddShopFragment adminAddShopFragment) {
        adminAddShopFragment.f15545d.a(CommercePublishingAnalyticsEvent.ACTN_PRIVATE_MESSAGE_BACK_CLICK, String.valueOf(adminAddShopFragment.f15548h));
        int width = adminAddShopFragment.ao.getWidth();
        adminAddShopFragment.ap.animate().translationX(0.0f);
        adminAddShopFragment.aq.animate().translationX((float) width).setDuration(300);
        adminAddShopFragment.aq.postDelayed(new C21495(adminAddShopFragment), 300);
        adminAddShopFragment.an = AddShopScreen.ANIMATING;
    }

    public static void av(AdminAddShopFragment adminAddShopFragment) {
        if (adminAddShopFragment.av == null) {
            adminAddShopFragment.f15544c.b(new ToastBuilder(2131239299));
            return;
        }
        adminAddShopFragment.at.a();
        TasksManager tasksManager = adminAddShopFragment.f15542a;
        Task task = Task.CREATE_SHOP_MUTATION;
        AdminAddShopFetcher adminAddShopFetcher = adminAddShopFragment.f15543b;
        long j = adminAddShopFragment.f15548h;
        String str = adminAddShopFragment.av;
        CommerceContactMerchantStoreCreateInputData commerceContactMerchantStoreCreateInputData = new CommerceContactMerchantStoreCreateInputData();
        commerceContactMerchantStoreCreateInputData.a("page_id", String.valueOf(j));
        GraphQlCallInput graphQlCallInput = commerceContactMerchantStoreCreateInputData;
        graphQlCallInput.a("currency", str);
        ListenableFuture a = GraphQLQueryExecutor.a(adminAddShopFetcher.f15516a.a(GraphQLRequest.a((CommerceStoreCreateMutationString) new CommerceStoreCreateMutationString().a("input", graphQlCallInput).a("COMMERCE_SMALL_IMAGE_SIZE", Integer.valueOf(50)).a("COMMERCE_MEDIUM_IMAGE_SIZE", Integer.valueOf(230)))));
        Futures.a(a, new C21411(adminAddShopFetcher));
        tasksManager.a(task, a, new C21473(adminAddShopFragment));
    }
}
