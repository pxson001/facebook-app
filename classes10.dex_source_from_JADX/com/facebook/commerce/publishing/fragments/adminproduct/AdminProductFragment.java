package com.facebook.commerce.publishing.fragments.adminproduct;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.ProductItemPriceFieldsModel;
import com.facebook.commerce.core.ui.NoticeView;
import com.facebook.commerce.core.ui.NoticeView.NoticeLevel;
import com.facebook.commerce.core.util.CommerceCurrencyUtil;
import com.facebook.commerce.core.util.ProductApprovalUtils;
import com.facebook.commerce.publishing.adapter.AddEditProductImagesDataProvider;
import com.facebook.commerce.publishing.adapter.AddEditProductImagesDataProvider.ImageProviderModel;
import com.facebook.commerce.publishing.adapter.ProductEditImagesAdapter;
import com.facebook.commerce.publishing.adapter.ProductEditImagesAdapter.HorizontalSpacingDecoration;
import com.facebook.commerce.publishing.adapter.ProductEditImagesAdapterProvider;
import com.facebook.commerce.publishing.analytics.CommercePublishingAnalytics.CommercePublishingAnalyticsEvent;
import com.facebook.commerce.publishing.analytics.CommercePublishingAnalytics.CommercePublishingAnalyticsKey;
import com.facebook.commerce.publishing.analytics.CommercePublishingLogger;
import com.facebook.commerce.publishing.event.CommercePublishingEventBus;
import com.facebook.commerce.publishing.event.CommercePublishingMutationEvent.Method;
import com.facebook.commerce.publishing.event.CommercePublishingMutationEvent.Status;
import com.facebook.commerce.publishing.event.ProductItemMutationEvent;
import com.facebook.commerce.publishing.event.ProductItemMutationEvent.ProductItemMutationEventSubscriber;
import com.facebook.commerce.publishing.fragments.AutoShareController;
import com.facebook.commerce.publishing.fragments.AutoShareController.C21621;
import com.facebook.commerce.publishing.fragments.AutoShareControllerProvider;
import com.facebook.commerce.publishing.graphql.CommerceProductDeleteMutation.CommerceProductDeleteMutationString;
import com.facebook.commerce.publishing.graphql.CommerceProductItemMutateParams;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsInterfaces.AdminCommerceProductItem;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsInterfaces.AdminCommerceProductItem.OrderedImages;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsModels.AdminCommerceProductItemModel.OrderedImagesModel;
import com.facebook.commerce.publishing.mutator.ProductItemMutator;
import com.facebook.commerce.publishing.mutator.ProductItemMutator.1;
import com.facebook.commerce.publishing.mutator.ProductItemPendingMutationsCache;
import com.facebook.commerce.publishing.ui.InterceptSwitchCompat;
import com.facebook.commerce.publishing.ui.nux.FirstTimeAddNuxController;
import com.facebook.commerce.publishing.ui.nux.FirstTimeAddNuxControllerProvider;
import com.facebook.commerce.publishing.util.AdminShopTextUtil;
import com.facebook.commerce.publishing.util.ProductItemImageHelper;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.calls.ProductItemsDeleteInputData;
import com.facebook.graphql.enums.GraphQLCommerceProductVisibility;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Builder;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.operation.UploadOperationFactory;
import com.facebook.resources.ui.FbEditText;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Currency;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: cymk_click_add */
public class AdminProductFragment extends FbFragment implements CanHandleBackPressed {
    @Inject
    ProductEditImagesAdapterProvider f15596a;
    private ImmutableList<OrderedImages> aA;
    public int aB;
    public boolean aC;
    public boolean aD = false;
    private InitialViewFields aE;
    public boolean aF;
    private ViewGroup aG;
    public ProgressBar aH;
    public NoticeView aI;
    private BetterRecyclerView aJ;
    public FbEditText aK;
    public FbEditText aL;
    private FbEditText aM;
    private GlyphView aN;
    private InterceptSwitchCompat aO;
    private View aP;
    public NoticeView aQ;
    private BetterTextView aR;
    private ProductEditImagesAdapter aS;
    public AddEditProductImagesDataProvider aT;
    public DialogBasedProgressIndicator aU;
    public final FbEventSubscriberListManager aV = new FbEventSubscriberListManager();
    public FirstTimeAddNuxController aW;
    private AutoShareController aX;
    private AdminProductFragmentController aY;
    public String aZ;
    @Inject
    SecureContextHelper al;
    @Inject
    UriIntentMapper am;
    @Inject
    Toaster an;
    @Inject
    public CommercePublishingEventBus ao;
    @Inject
    AbstractFbErrorReporter ap;
    @Inject
    public ProductItemImageHelper aq;
    @Inject
    FirstTimeAddNuxControllerProvider ar;
    @Inject
    AutoShareControllerProvider as;
    @Inject
    AdminProductFragmentControllerProvider at;
    public ViewerContext au;
    public Optional<String> av;
    public boolean aw;
    public long ax;
    public Currency ay;
    public AdminCommerceProductItem az;
    @Inject
    UploadManager f15597b;
    private final OnClickListener ba = new C21641(this);
    @Inject
    UploadOperationFactory f15598c;
    @Inject
    public ProductItemMutator f15599d;
    @Inject
    CommerceCurrencyUtil f15600e;
    @Inject
    ProductItemPendingMutationsCache f15601f;
    @Inject
    public TasksManager f15602g;
    @Inject
    CommercePublishingLogger f15603h;
    @Inject
    public ProductApprovalUtils f15604i;

    /* compiled from: cymk_click_add */
    class C21641 implements OnClickListener {
        final /* synthetic */ AdminProductFragment f15578a;

        C21641(AdminProductFragment adminProductFragment) {
            this.f15578a = adminProductFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1637400526);
            Intent a2 = this.f15578a.am.a(view.getContext(), "https://m.facebook.com/business/help/223106797811279");
            if (a2 != null) {
                this.f15578a.al.a(a2, view.getContext());
            }
            Logger.a(2, EntryType.UI_INPUT_END, 2146760643, a);
        }
    }

    /* compiled from: cymk_click_add */
    class C21652 implements OnFocusChangeListener {
        final /* synthetic */ AdminProductFragment f15579a;

        C21652(AdminProductFragment adminProductFragment) {
            this.f15579a = adminProductFragment;
        }

        public void onFocusChange(View view, boolean z) {
            if (!z) {
                AdminProductFragment.m16074a(this.f15579a, true);
            }
        }
    }

    /* compiled from: cymk_click_add */
    class C21663 implements OnClickListener {
        final /* synthetic */ AdminProductFragment f15580a;

        C21663(AdminProductFragment adminProductFragment) {
            this.f15580a = adminProductFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -234365447);
            AdminProductFragment adminProductFragment = this.f15580a;
            adminProductFragment.a(SimplePickerIntent.a(adminProductFragment.getContext(), new Builder(SimplePickerSource.PAGE_PROFILE_PIC).a(Action.NONE).i().k()), 2509);
            Logger.a(2, EntryType.UI_INPUT_END, -610056796, a);
        }
    }

    /* compiled from: cymk_click_add */
    public class C21674 {
        public final /* synthetic */ AdminProductFragment f15581a;

        C21674(AdminProductFragment adminProductFragment) {
            this.f15581a = adminProductFragment;
        }
    }

    /* compiled from: cymk_click_add */
    class C21685 implements OnClickListener {
        final /* synthetic */ AdminProductFragment f15582a;

        C21685(AdminProductFragment adminProductFragment) {
            this.f15582a = adminProductFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1733034477);
            AdminProductFragment.m16076g(this.f15582a, 2131239274);
            Logger.a(2, EntryType.UI_INPUT_END, 239502411, a);
        }
    }

    /* compiled from: cymk_click_add */
    class C21696 implements OnClickListener {
        final /* synthetic */ AdminProductFragment f15583a;

        C21696(AdminProductFragment adminProductFragment) {
            this.f15583a = adminProductFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -528300988);
            Preconditions.checkState(this.f15583a.aB >= 10);
            AdminProductFragment.m16076g(this.f15583a, 2131239275);
            LogUtils.a(667006544, a);
        }
    }

    /* compiled from: cymk_click_add */
    class C21727 implements OnClickListener {
        final /* synthetic */ AdminProductFragment f15586a;

        /* compiled from: cymk_click_add */
        class C21701 implements DialogInterface.OnClickListener {
            final /* synthetic */ C21727 f15584a;

            C21701(C21727 c21727) {
                this.f15584a = c21727;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                AdminProductFragment adminProductFragment = this.f15584a.f15586a;
                adminProductFragment.aU.a();
                TasksManager tasksManager = adminProductFragment.f15602g;
                Tasks tasks = Tasks.DELETE_PRODUCT_ITEM;
                ProductItemMutator productItemMutator = adminProductFragment.f15599d;
                String cu_ = adminProductFragment.az.cu_();
                GraphQLQueryExecutor graphQLQueryExecutor = productItemMutator.a;
                List arrayList = new ArrayList();
                arrayList.add(cu_);
                ProductItemsDeleteInputData productItemsDeleteInputData = new ProductItemsDeleteInputData();
                productItemsDeleteInputData.a("ids", arrayList);
                ListenableFuture a = graphQLQueryExecutor.a(GraphQLRequest.a((CommerceProductDeleteMutationString) new CommerceProductDeleteMutationString().a("input", productItemsDeleteInputData)));
                Futures.a(a, new 1(productItemMutator, cu_));
                tasksManager.a(tasks, a, new C21738(adminProductFragment));
            }
        }

        /* compiled from: cymk_click_add */
        class C21712 implements DialogInterface.OnClickListener {
            final /* synthetic */ C21727 f15585a;

            C21712(C21727 c21727) {
                this.f15585a = c21727;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }

        C21727(AdminProductFragment adminProductFragment) {
            this.f15586a = adminProductFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1757947914);
            new AlertDialog.Builder(this.f15586a.getContext()).a(2131239305).b(2131239306).b(2131239310, new C21712(this)).a(2131239307, new C21701(this)).b();
            Logger.a(2, EntryType.UI_INPUT_END, -1710545630, a);
        }
    }

    /* compiled from: cymk_click_add */
    public class C21738 extends AbstractDisposableFutureCallback {
        final /* synthetic */ AdminProductFragment f15587a;

        public C21738(AdminProductFragment adminProductFragment) {
            this.f15587a = adminProductFragment;
        }

        protected final void m16063a(Object obj) {
            this.f15587a.aU.b();
            this.f15587a.aD = true;
            AdminProductFragment.m16072a(this.f15587a, this.f15587a.az, Method.DELETE);
        }

        protected final void m16064a(Throwable th) {
            this.f15587a.aU.b();
        }
    }

    /* compiled from: cymk_click_add */
    class C21749 extends OnToolbarButtonListener {
        final /* synthetic */ AdminProductFragment f15588a;

        C21749(AdminProductFragment adminProductFragment) {
            this.f15588a = adminProductFragment;
        }

        public final void m16065a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            AdminProductFragment.aB(this.f15588a);
        }
    }

    /* compiled from: cymk_click_add */
    class ClearErrorTextWatcher implements TextWatcher {
        private TextView f15589a;

        public ClearErrorTextWatcher(TextView textView) {
            this.f15589a = textView;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.f15589a.setError(null);
        }
    }

    /* compiled from: cymk_click_add */
    public class CommerceProductChangeset {
        public CommerceProductItemMutateParams f15590a;
        public ImmutableList<MediaItem> f15591b;

        public final boolean m16066b() {
            return (this.f15591b == null || this.f15591b.isEmpty()) ? false : true;
        }
    }

    /* compiled from: cymk_click_add */
    class InitialViewFields {
        String f15592a;
        String f15593b;
        String f15594c;
        boolean f15595d;

        InitialViewFields(String str, String str2, String str3, boolean z) {
            this.f15592a = str;
            this.f15593b = str2;
            this.f15594c = str3;
            this.f15595d = z;
        }
    }

    /* compiled from: cymk_click_add */
    public enum Tasks {
        LOAD_PRODUCT_ITEM,
        DELETE_PRODUCT_ITEM
    }

    public static void m16073a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((AdminProductFragment) obj).m16070a((ProductEditImagesAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ProductEditImagesAdapterProvider.class), UploadManager.a(fbInjector), UploadOperationFactory.a(fbInjector), ProductItemMutator.a(fbInjector), CommerceCurrencyUtil.a(fbInjector), ProductItemPendingMutationsCache.a(fbInjector), TasksManager.a(fbInjector), CommercePublishingLogger.a(fbInjector), ProductApprovalUtils.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), (UriIntentMapper) Fb4aUriIntentMapper.a(fbInjector), Toaster.a(fbInjector), CommercePublishingEventBus.a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), ProductItemImageHelper.m16112a(fbInjector), (FirstTimeAddNuxControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FirstTimeAddNuxControllerProvider.class), (AutoShareControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(AutoShareControllerProvider.class), (AdminProductFragmentControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(AdminProductFragmentControllerProvider.class));
    }

    public static AdminProductFragment m16067a(long j, AdminCommerceProductItem adminCommerceProductItem, Currency currency, int i, boolean z, ViewerContext viewerContext, boolean z2) {
        Preconditions.checkNotNull(viewerContext);
        Preconditions.checkState(viewerContext.mIsPageContext);
        Preconditions.checkState(j > 0);
        Preconditions.checkNotNull(currency);
        Bundle bundle = new Bundle();
        bundle.putLong("com.facebook.katana.profile.id", j);
        FlatBufferModelHelper.a(bundle, "extra_admin_product_item", adminCommerceProductItem);
        bundle.putSerializable("extra_currency", currency);
        bundle.putInt("extra_featured_products_count", i);
        bundle.putBoolean("extra_wait_for_mutation_finish", z);
        bundle.putParcelable("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT", viewerContext);
        bundle.putBoolean("extra_has_empty_catalog", z2);
        AdminProductFragment adminProductFragment = new AdminProductFragment();
        adminProductFragment.g(bundle);
        return adminProductFragment;
    }

    public static AdminProductFragment m16068a(long j, Optional<String> optional, boolean z, @Nullable ViewerContext viewerContext) {
        Bundle bundle = new Bundle();
        bundle.putLong("com.facebook.katana.profile.id", j);
        bundle.putBoolean("extra_requires_initial_fetch", true);
        bundle.putString("extra_product_item_id_to_fetch", (String) optional.orNull());
        bundle.putBoolean("extra_wait_for_mutation_finish", z);
        bundle.putParcelable("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT", viewerContext);
        AdminProductFragment adminProductFragment = new AdminProductFragment();
        adminProductFragment.g(bundle);
        return adminProductFragment;
    }

    public final void m16082c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = AdminProductFragment.class;
        m16073a((Object) this, getContext());
        Bundle bundle2 = this.s;
        this.au = (ViewerContext) bundle2.getParcelable("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT");
        this.aC = bundle2.getBoolean("extra_wait_for_mutation_finish");
        this.ax = bundle2.getLong("com.facebook.katana.profile.id");
        Preconditions.checkState(this.ax > 0);
        this.aw = bundle2.getBoolean("extra_requires_initial_fetch");
        this.av = Optional.fromNullable(bundle2.getString("extra_product_item_id_to_fetch"));
        if (!this.aw) {
            this.ay = (Currency) bundle2.getSerializable("extra_currency");
            this.az = (AdminCommerceProductItem) FlatBufferModelHelper.a(bundle2, "extra_admin_product_item");
            this.aB = bundle2.getInt("extra_featured_products_count");
            this.aF = bundle2.getBoolean("extra_has_empty_catalog", false);
            Preconditions.checkNotNull(this.au);
            Preconditions.checkState(this.au.mIsPageContext);
            Preconditions.checkNotNull(this.ay);
        }
        CommercePublishingAnalyticsEvent commercePublishingAnalyticsEvent = (!this.aw || aK()) ? CommercePublishingAnalyticsEvent.ACTN_ADD_PRODUCT_CLICK : CommercePublishingAnalyticsEvent.ACTN_EDIT_PRODUCT_CLICK;
        m16071a(commercePublishingAnalyticsEvent);
        if (this.aC) {
            this.aV.a(new ProductItemMutationEventSubscriber(this) {
                final /* synthetic */ AdminProductFragment f15575a;

                {
                    this.f15575a = r1;
                }

                public final void m16062b(FbEvent fbEvent) {
                    Object obj;
                    final ProductItemMutationEvent productItemMutationEvent = (ProductItemMutationEvent) fbEvent;
                    AdminProductFragment adminProductFragment = this.f15575a;
                    if (adminProductFragment.aC && adminProductFragment.aZ != null && adminProductFragment.aZ.equals(productItemMutationEvent.b)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        this.f15575a.o().runOnUiThread(new Runnable(this) {
                            final /* synthetic */ AnonymousClass10 f15574b;

                            public void run() {
                                if (this.f15574b.f15575a.aU != null) {
                                    this.f15574b.f15575a.aU.b();
                                }
                                if (productItemMutationEvent.a == Status.SUCCESS) {
                                    boolean z;
                                    AdminProductFragment adminProductFragment = this.f15574b.f15575a;
                                    ProductItemMutationEvent productItemMutationEvent = productItemMutationEvent;
                                    if (productItemMutationEvent.a == Status.SUCCESS) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    Preconditions.checkState(z);
                                    AdminProductFragment.m16072a(adminProductFragment, (AdminCommerceProductItem) productItemMutationEvent.a, productItemMutationEvent.b);
                                } else if (productItemMutationEvent.a == Status.FAILED) {
                                    this.f15574b.f15575a.an.b(new ToastBuilder(2131234805));
                                }
                            }
                        });
                    }
                }
            });
            this.aV.a(this.ao);
        }
        this.aW = new FirstTimeAddNuxController(this.aF, IdBasedLazy.a(this.ar, 5088));
        this.aX = new AutoShareController(aK());
        this.aY = this.at.m16097a(this);
    }

    public final View m16078a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 575992397);
        View inflate = layoutInflater.inflate(2130903178, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1863062903, a);
        return inflate;
    }

    public final void m16080a(View view, @Nullable Bundle bundle) {
        this.aG = (ViewGroup) e(2131559405);
        this.aH = (ProgressBar) e(2131559418);
        this.aY.m16096a(this.aw, String.valueOf(this.ax), this.av, Optional.fromNullable(this.au));
    }

    private void ar() {
        this.aG.setVisibility(0);
        this.aH.setVisibility(8);
        this.aI = (NoticeView) e(2131559406);
        this.aJ = (BetterRecyclerView) e(2131559407);
        this.aK = (FbEditText) e(2131559408);
        this.aL = (FbEditText) e(2131559409);
        this.aM = (FbEditText) e(2131559410);
        this.aN = (GlyphView) e(2131559413);
        this.aO = (InterceptSwitchCompat) e(2131559415);
        this.aP = e(2131559414);
        this.aQ = (NoticeView) e(2131559416);
        this.aR = (BetterTextView) e(2131559417);
        ViewStub viewStub = (ViewStub) e(2131559401);
        AutoShareController autoShareController = this.aX;
        if (autoShareController.f15572c) {
            View inflate = viewStub.inflate();
            autoShareController.f15570a = (CompoundButton) FindViewUtil.b(inflate, 2131559403);
            autoShareController.f15571b = FindViewUtil.b(inflate, 2131559404);
            autoShareController.f15570a.setOnCheckedChangeListener(new C21621(autoShareController));
        }
        this.aI.setOnClickListener(this.ba);
        this.aQ.setOnClickListener(this.ba);
        this.aU = new DialogBasedProgressIndicator(getContext(), 2131239302);
        this.aK.addTextChangedListener(new ClearErrorTextWatcher(this.aK));
        this.aL.setRawInputType(2);
        this.aL.addTextChangedListener(new ClearErrorTextWatcher(this.aL));
        this.aL.setOnFocusChangeListener(new C21652(this));
        this.aT = new AddEditProductImagesDataProvider(null);
        this.aq.f15645d = this.aT;
        this.aS = new ProductEditImagesAdapter(o(), this.aT, new C21663(this));
        this.aS.f15505g = new C21674(this);
        this.aT.f15444b = this.aS;
        this.aJ.setLayoutManager(new BetterLinearLayoutManager(getContext(), 0, false));
        this.aJ.setAdapter(this.aS);
        this.aJ.a(new HorizontalSpacingDecoration(jW_().getDimensionPixelSize(2131427418)));
        this.aN.setOnClickListener(new C21685(this));
        this.aO.f15635a = aL();
        this.aP.setOnClickListener(new C21696(this));
        this.aR.setOnClickListener(new C21727(this));
        if (aK()) {
            this.aR.setVisibility(8);
        }
        aA();
        ax();
        if (aK()) {
            ay();
        } else {
            av();
        }
        this.aE = new InitialViewFields(this.aK.getText().toString(), this.aL.getText().toString(), this.aM.getText().toString(), this.aO.isChecked());
        at();
    }

    public final void m16081b() {
        ar();
    }

    public final void m16079a(int i, int i2, @Nullable Intent intent) {
        super.a(i, i2, intent);
        if (this.aq.m16114a(i, i2, intent)) {
            if (this.aS != null) {
                this.aS.notifyDataSetChanged();
            }
        } else if (i == 2509 && i2 == -1 && intent != null && intent.hasExtra("extra_media_items")) {
            List<MediaItem> parcelableArrayListExtra = intent.getParcelableArrayListExtra("extra_media_items");
            if (parcelableArrayListExtra != null) {
                AddEditProductImagesDataProvider addEditProductImagesDataProvider = this.aT;
                if (!parcelableArrayListExtra.isEmpty()) {
                    Collection collection;
                    List list = addEditProductImagesDataProvider.f15443a;
                    if (parcelableArrayListExtra == null) {
                        collection = null;
                    } else {
                        List arrayList = new ArrayList();
                        for (MediaItem imageProviderModel : parcelableArrayListExtra) {
                            arrayList.add(new ImageProviderModel(imageProviderModel));
                        }
                        Object obj = arrayList;
                    }
                    list.addAll(collection);
                }
                if (addEditProductImagesDataProvider.f15444b != null) {
                    addEditProductImagesDataProvider.f15444b.notifyDataSetChanged();
                }
            }
        }
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -857105719);
        super.mi_();
        if (!this.aw) {
            at();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1000712068, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1050873265);
        super.mj_();
        this.f15602g.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -370534090, a);
    }

    public final void m16077I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1580048999);
        super.I();
        this.aY.m16095a();
        this.aV.b(this.ao);
        if (!this.aD) {
            m16071a(aK() ? CommercePublishingAnalyticsEvent.ACTN_CANCEL_ADD_PRODUCT : CommercePublishingAnalyticsEvent.ACTN_CANCEL_EDIT_PRODUCT);
        }
        LogUtils.f(1598238592, a);
    }

    public final boolean O_() {
        if (!au()) {
            return false;
        }
        new AlertDialog.Builder(getContext()).a(2131239309).b(2131239308).b(2131239280, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ AdminProductFragment f15576a;

            {
                this.f15576a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f15576a.o().finish();
            }
        }).a(2131239281, null).b();
        return true;
    }

    private void at() {
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(aK() ? 2131239264 : 2131239265);
            hasTitleBar.c(true);
            TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
            a.g = jW_().getString(2131239278);
            hasTitleBar.a(a.a());
            hasTitleBar.a(new C21749(this));
        }
    }

    private boolean au() {
        if (this.aE == null) {
            return false;
        }
        String obj = this.aK.getText().toString();
        String obj2 = this.aL.getText().toString();
        String obj3 = this.aM.getText().toString();
        if (this.aE.f15595d == this.aO.isChecked() && AdminShopTextUtil.m16111a(this.aE.f15592a, obj) && AdminShopTextUtil.m16111a(this.aE.f15593b, obj2) && AdminShopTextUtil.m16111a(this.aE.f15594c, obj3) && !m16075a(this.aT.m15980a(true))) {
            return false;
        }
        return true;
    }

    private void av() {
        Object obj;
        Preconditions.checkNotNull(this.az);
        this.aK.setText(this.az.g());
        this.aM.setText(this.az.d());
        Preconditions.checkNotNull(this.az.j());
        this.aL.setText(CommerceCurrencyUtil.a(this.az.j()));
        AddEditProductImagesDataProvider addEditProductImagesDataProvider = this.aT;
        ImmutableList<OrderedImagesModel> immutableList = this.aA;
        if (immutableList == null) {
            obj = null;
        } else {
            List arrayList = new ArrayList();
            for (OrderedImagesModel imageProviderModel : immutableList) {
                arrayList.add(new ImageProviderModel(imageProviderModel));
            }
            List list = arrayList;
        }
        Object obj2 = obj;
        if (!(obj2 == null || obj2.isEmpty())) {
            addEditProductImagesDataProvider.f15443a.addAll(obj2);
            if (addEditProductImagesDataProvider.f15444b != null) {
                int size = obj2.size();
                addEditProductImagesDataProvider.f15444b.c(addEditProductImagesDataProvider.m15979a() - size, size);
            }
        }
        ay();
        GraphQLCommerceProductVisibility c = this.az.c();
        NoticeLevel a = ProductApprovalUtils.a(c);
        if (a != null) {
            this.aI.setVisibility(0);
            this.aI.setLevel(a);
            this.aI.setTitle(this.f15604i.b(c));
            this.aI.setMessage(this.f15604i.c(c));
        } else {
            this.aI.setVisibility(8);
        }
        if (c == GraphQLCommerceProductVisibility.VISIBLE) {
            this.aQ.setVisibility(0);
            this.aQ.setLevel(NoticeLevel.NOTIFY);
            this.aQ.setMessage(b(2131234801));
            return;
        }
        this.aQ.setVisibility(8);
    }

    private void ax() {
        InterceptSwitchCompat interceptSwitchCompat = this.aO;
        boolean z = !aK() && this.az.b();
        interceptSwitchCompat.setChecked(z);
    }

    private void ay() {
        boolean z = false;
        boolean z2 = !aK() && this.az.b() && this.aO.isChecked();
        if (this.aB < 10 || z2) {
            z = true;
        }
        this.aO.f15635a = z;
    }

    private void aA() {
        if (!aK() && this.az.cv_() != null) {
            Set hashSet = new HashSet();
            ImmutableList.Builder builder = new ImmutableList.Builder();
            ImmutableList cv_ = this.az.cv_();
            int size = cv_.size();
            for (int i = 0; i < size; i++) {
                OrderedImagesModel orderedImagesModel = (OrderedImagesModel) cv_.get(i);
                if (!hashSet.contains(orderedImagesModel.b())) {
                    hashSet.add(orderedImagesModel.b());
                    builder.c(orderedImagesModel);
                }
            }
            this.aA = builder.b();
        }
    }

    public static void aB(AdminProductFragment adminProductFragment) {
        boolean z = false;
        if (StringUtil.c(adminProductFragment.aK.getText().toString())) {
            adminProductFragment.aK.setError(adminProductFragment.b(2131239267));
        } else if (m16074a(adminProductFragment, false)) {
            if (ImmutableList.copyOf(adminProductFragment.aT.f15443a).isEmpty()) {
                Toast.makeText(adminProductFragment.o(), 2131239273, 0).show();
            } else {
                z = true;
            }
        }
        if (z) {
            CommerceProductChangeset aD = adminProductFragment.aD();
            if (aD == null) {
                adminProductFragment.an.a(new ToastBuilder(2131234805));
                return;
            }
            AdminCommerceProductItem a = adminProductFragment.m16069a(aD);
            if (a == null) {
                adminProductFragment.aI();
            } else if (adminProductFragment.aC) {
                adminProductFragment.aU.a();
            } else {
                m16072a(adminProductFragment, a, adminProductFragment.aK() ? Method.CREATE : Method.EDIT);
            }
        }
    }

    public static boolean m16074a(AdminProductFragment adminProductFragment, boolean z) {
        if (!StringUtil.c(adminProductFragment.aL.getText().toString())) {
            ProductItemPriceFieldsModel aM = adminProductFragment.aM();
            if (aM == null || aM.a() < 0) {
                adminProductFragment.aL.setError(adminProductFragment.b(2131239270));
                return false;
            }
            adminProductFragment.aL.setError(null);
            adminProductFragment.aL.setText(CommerceCurrencyUtil.a(aM));
            return true;
        } else if (z) {
            return true;
        } else {
            adminProductFragment.aL.setError(adminProductFragment.b(2131239269));
            return false;
        }
    }

    @Nullable
    private CommerceProductChangeset aD() {
        boolean z = true;
        CommerceProductChangeset commerceProductChangeset = new CommerceProductChangeset();
        CommerceProductItemMutateParams.Builder builder = new CommerceProductItemMutateParams.Builder();
        ProductItemPriceFieldsModel aM = aM();
        if (aM == null) {
            this.ap.b("ProductTools", "Could not parse price: " + this.aL.getText().toString() + " with currency " + this.ay.toString());
            return null;
        }
        TriState valueOf;
        String obj = this.aK.getText().toString();
        String obj2 = this.aM.getText().toString();
        ImmutableList a = this.aT.m15980a(true);
        boolean isChecked = this.aO.isChecked();
        AutoShareController autoShareController = this.aX;
        if (autoShareController.f15572c) {
            valueOf = TriState.valueOf(autoShareController.f15570a.isChecked());
        } else {
            valueOf = TriState.UNSET;
        }
        TriState triState = valueOf;
        commerceProductChangeset.f15591b = this.aT.m15982b();
        if (aK()) {
            if (commerceProductChangeset.f15591b.size() != a.size()) {
                z = false;
            }
            Preconditions.checkState(z);
            builder.d = obj;
            CommerceProductItemMutateParams.Builder builder2 = builder;
            builder2.e = obj2;
            builder2 = builder2;
            builder2.g = Integer.valueOf(aM.a());
            builder2 = builder2;
            builder2.i = a;
            builder2 = builder2;
            builder2.j = TriState.valueOf(isChecked);
            builder2 = builder2;
            builder2.k = triState;
            commerceProductChangeset.f15590a = builder2.a();
            return commerceProductChangeset;
        }
        if (!AdminShopTextUtil.m16111a(this.az.g(), obj)) {
            builder.d = obj;
        }
        if (!AdminShopTextUtil.m16111a(this.az.d(), obj2)) {
            builder.e = obj2;
        }
        if (m16075a(a)) {
            builder.i = a;
        }
        if (this.az.b() != isChecked) {
            builder.j = TriState.valueOf(isChecked);
        }
        if (this.az.j() == null || this.az.j().a() != aM.a()) {
            builder.g = Integer.valueOf(aM.a());
        }
        commerceProductChangeset.f15590a = builder.a();
        return commerceProductChangeset;
    }

    private boolean m16075a(ImmutableList<String> immutableList) {
        ImmutableList immutableList2 = this.aA;
        if (immutableList2 == null || immutableList2.isEmpty()) {
            if (immutableList == null || immutableList.isEmpty()) {
                return false;
            }
            return true;
        } else if (immutableList.size() != immutableList2.size()) {
            return true;
        } else {
            for (int i = 0; i < immutableList2.size(); i++) {
                if (!AdminShopTextUtil.m16111a(((OrderedImagesModel) immutableList2.get(i)).b(), (String) immutableList.get(i))) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsInterfaces.AdminCommerceProductItem m16069a(com.facebook.commerce.publishing.fragments.adminproduct.AdminProductFragment.CommerceProductChangeset r15) {
        /*
        r14 = this;
        r9 = 1;
        r8 = 0;
        r10 = 0;
        r11 = r15.f15590a;
        if (r11 == 0) goto L_0x003d;
    L_0x0007:
        r11 = r15.f15590a;
        r12 = r11.a;
        if (r12 != 0) goto L_0x0039;
    L_0x000d:
        r12 = r11.b;
        if (r12 != 0) goto L_0x0039;
    L_0x0011:
        r12 = r11.c;
        if (r12 != 0) goto L_0x0039;
    L_0x0015:
        r12 = r11.d;
        if (r12 != 0) goto L_0x0039;
    L_0x0019:
        r12 = r11.e;
        if (r12 != 0) goto L_0x0039;
    L_0x001d:
        r12 = r11.f;
        if (r12 != 0) goto L_0x0039;
    L_0x0021:
        r12 = r11.g;
        if (r12 != 0) goto L_0x0039;
    L_0x0025:
        r12 = r11.h;
        if (r12 != 0) goto L_0x0039;
    L_0x0029:
        r12 = r11.i;
        if (r12 != 0) goto L_0x0039;
    L_0x002d:
        r12 = r11.j;
        r13 = com.facebook.common.util.TriState.UNSET;
        if (r12 != r13) goto L_0x0039;
    L_0x0033:
        r12 = r11.k;
        r13 = com.facebook.common.util.TriState.UNSET;
        if (r12 == r13) goto L_0x0120;
    L_0x0039:
        r12 = 1;
    L_0x003a:
        r11 = r12;
        if (r11 != 0) goto L_0x0043;
    L_0x003d:
        r11 = r15.m16066b();
        if (r11 == 0) goto L_0x011d;
    L_0x0043:
        r11 = 1;
    L_0x0044:
        r0 = r11;
        if (r0 != 0) goto L_0x0048;
    L_0x0047:
        return r8;
    L_0x0048:
        r0 = com.facebook.common.identifiers.SafeUUIDGenerator.a();
        r7 = r0.toString();
        r0 = r14.aK();
        if (r0 == 0) goto L_0x00ed;
    L_0x0056:
        r6 = r7;
    L_0x0057:
        r0 = r14.aC;
        if (r0 == 0) goto L_0x005d;
    L_0x005b:
        r14.aZ = r6;
    L_0x005d:
        r0 = r14.aK();
        if (r0 != 0) goto L_0x00f6;
    L_0x0063:
        r0 = r14.az;
        r0 = r0.cu_();
    L_0x0069:
        r1 = r14.aK;
        r1 = r1.getText();
        r1 = r1.toString();
        r2 = r14.aM;
        r2 = r2.getText();
        r2 = r2.toString();
        r3 = r14.aO;
        r3 = r3.isChecked();
        r4 = r14.aM();
        r5 = r14.aT;
        r5 = r5.m15981a(r10);
        r1 = com.facebook.commerce.publishing.graphql.CommercePublishingGraphQLUtils.a(r0, r1, r2, r3, r4, r5);
        r0 = r15.f15590a;
        r0 = com.facebook.commerce.publishing.graphql.CommerceProductItemMutateParams.Builder.a(r0);
        r2 = r14.az;
        if (r2 == 0) goto L_0x00a1;
    L_0x009b:
        r2 = r14.az;
        r8 = r2.cu_();
    L_0x00a1:
        r0.a = r8;
        r0 = r0;
        r2 = r14.au;
        r2 = r2.a();
        r0.b = r2;
        r0 = r0;
        r2 = r14.ax;
        r2 = java.lang.String.valueOf(r2);
        r0.c = r2;
        r0 = r0;
        r2 = r14.ay;
        r2 = r2.getCurrencyCode();
        r0.f = r2;
        r0 = r0;
        r0 = r0.a(r1, r6);
        r2 = r14.au;
        r0.n = r2;
        r0 = r0;
        r0 = r0.a();
        r15.f15590a = r0;
        r0 = r14.f15601f;
        r0.a(r1, r6);
        r0 = r15.m16066b();
        if (r0 == 0) goto L_0x00f9;
    L_0x00d9:
        r0 = r14.f15597b;
        r2 = r14.f15598c;
        r3 = r15.f15590a;
        r4 = r15.f15591b;
        r5 = r14.au;
        r2 = r2.a(r3, r4, r7, r5);
        r0.a(r2);
    L_0x00ea:
        r8 = r1;
        goto L_0x0047;
    L_0x00ed:
        r0 = r14.az;
        r0 = r0.cu_();
        r6 = r0;
        goto L_0x0057;
    L_0x00f6:
        r0 = r8;
        goto L_0x0069;
    L_0x00f9:
        r0 = r14.aK();
        if (r0 != 0) goto L_0x011b;
    L_0x00ff:
        r0 = r9;
    L_0x0100:
        com.google.common.base.Preconditions.checkState(r0);
        r0 = r15.f15591b;
        if (r0 == 0) goto L_0x010f;
    L_0x0107:
        r0 = r15.f15591b;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x0110;
    L_0x010f:
        r10 = r9;
    L_0x0110:
        com.google.common.base.Preconditions.checkArgument(r10);
        r0 = r14.f15599d;
        r2 = r15.f15590a;
        r0.a(r2);
        goto L_0x00ea;
    L_0x011b:
        r0 = r10;
        goto L_0x0100;
    L_0x011d:
        r11 = 0;
        goto L_0x0044;
    L_0x0120:
        r12 = 0;
        goto L_0x003a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.commerce.publishing.fragments.adminproduct.AdminProductFragment.a(com.facebook.commerce.publishing.fragments.adminproduct.AdminProductFragment$CommerceProductChangeset):com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsInterfaces$AdminCommerceProductItem");
    }

    public static void m16076g(AdminProductFragment adminProductFragment, int i) {
        new AlertDialog.Builder(adminProductFragment.o()).b(i).b();
    }

    public static void m16072a(AdminProductFragment adminProductFragment, AdminCommerceProductItem adminCommerceProductItem, Method method) {
        boolean z = true;
        adminProductFragment.aD = true;
        adminProductFragment.aJ();
        Intent intent = new Intent();
        FlatBufferModelHelper.a(intent, "result_optimistic_product", adminCommerceProductItem);
        intent.putExtra("result_mutation_method", method);
        adminProductFragment.o().setResult(-1, intent);
        if (!(method == Method.CREATE && adminProductFragment.aW.a)) {
            z = false;
        }
        if (z) {
            adminProductFragment.aW.a(adminProductFragment.o(), new OnDismissListener(adminProductFragment) {
                final /* synthetic */ AdminProductFragment f15577a;

                {
                    this.f15577a = r1;
                }

                public void onDismiss(DialogInterface dialogInterface) {
                    this.f15577a.o().finish();
                }
            });
        } else {
            adminProductFragment.o().finish();
        }
    }

    private void aI() {
        aJ();
        o().setResult(0);
        o().finish();
    }

    private void aJ() {
        ((InputMethodManager) o().getSystemService("input_method")).hideSoftInputFromWindow(this.aK.getWindowToken(), 0);
    }

    private boolean aK() {
        return this.az == null;
    }

    private boolean aL() {
        if ((aK() || !this.az.b()) && this.aB >= 10) {
            return false;
        }
        return true;
    }

    @Nullable
    private ProductItemPriceFieldsModel aM() {
        return this.f15600e.a(this.ay, this.aL.getText().toString());
    }

    private void m16070a(ProductEditImagesAdapterProvider productEditImagesAdapterProvider, UploadManager uploadManager, UploadOperationFactory uploadOperationFactory, ProductItemMutator productItemMutator, CommerceCurrencyUtil commerceCurrencyUtil, ProductItemPendingMutationsCache productItemPendingMutationsCache, TasksManager tasksManager, CommercePublishingLogger commercePublishingLogger, ProductApprovalUtils productApprovalUtils, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper, Toaster toaster, CommercePublishingEventBus commercePublishingEventBus, AbstractFbErrorReporter abstractFbErrorReporter, ProductItemImageHelper productItemImageHelper, FirstTimeAddNuxControllerProvider firstTimeAddNuxControllerProvider, AutoShareControllerProvider autoShareControllerProvider, AdminProductFragmentControllerProvider adminProductFragmentControllerProvider) {
        this.f15596a = productEditImagesAdapterProvider;
        this.f15597b = uploadManager;
        this.f15598c = uploadOperationFactory;
        this.f15599d = productItemMutator;
        this.f15600e = commerceCurrencyUtil;
        this.f15601f = productItemPendingMutationsCache;
        this.f15602g = tasksManager;
        this.f15603h = commercePublishingLogger;
        this.f15604i = productApprovalUtils;
        this.al = secureContextHelper;
        this.am = uriIntentMapper;
        this.an = toaster;
        this.ao = commercePublishingEventBus;
        this.ap = abstractFbErrorReporter;
        this.aq = productItemImageHelper;
        this.ar = firstTimeAddNuxControllerProvider;
        this.as = autoShareControllerProvider;
        this.at = adminProductFragmentControllerProvider;
    }

    private void m16071a(CommercePublishingAnalyticsEvent commercePublishingAnalyticsEvent) {
        String cu_;
        CommercePublishingLogger commercePublishingLogger = this.f15603h;
        String valueOf = String.valueOf(this.ax);
        if (this.az != null) {
            cu_ = this.az.cu_();
        } else {
            cu_ = "";
        }
        HoneyClientEvent b = CommercePublishingLogger.b(commercePublishingAnalyticsEvent, valueOf);
        b.b(CommercePublishingAnalyticsKey.TARGET_ID.value, cu_);
        commercePublishingLogger.a.a(b);
    }
}
