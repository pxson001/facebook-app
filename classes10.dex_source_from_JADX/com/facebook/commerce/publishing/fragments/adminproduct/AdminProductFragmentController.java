package com.facebook.commerce.publishing.fragments.adminproduct;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.commerce.core.util.CommerceCurrencyUtil;
import com.facebook.commerce.publishing.fetcher.AdminProductFetcher;
import com.facebook.commerce.publishing.fragments.adminproduct.ProductInitializationLoadable.ResultHandler;
import com.facebook.commerce.publishing.graphql.CommercePublishingGraphQLUtils;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsInterfaces.AdminCommerceProductItem;
import com.facebook.commerce.publishing.graphql.FetchAdminCommerceProductCreationFieldsModels.PageShopProductCreationFieldsModel;
import com.facebook.commerce.publishing.graphql.FetchAdminCommerceProductItemModels.FetchAdminCommerceProductItemModel;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.pages.common.viewercontextutils.PageViewerContextLifecycleHelper;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.util.Currency;
import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: cvbzwsjjjcxzwww */
public class AdminProductFragmentController {
    private static final String f15608a = AdminProductFragmentController.class.getCanonicalName();
    private final AdminProductFragmentLoader f15609b;
    public final AdminProductFragment f15610c;
    public final ProductCreationFieldsProvider f15611d;
    public final ProductWithEditFieldsProvider f15612e;
    public final PageViewerContextLoadableProvider f15613f;
    public final Lazy<TasksManager> f15614g;
    private final Lazy<FbErrorReporter> f15615h;
    public final ResultHandler<PageShopProductCreationFieldsModel> f15616i = new C21751(this);
    public final ResultHandler<FetchAdminCommerceProductItemModel> f15617j = new C21762(this);
    public final ResultHandler<ViewerContext> f15618k = new C21773(this);

    /* compiled from: cvbzwsjjjcxzwww */
    class C21751 implements ResultHandler<PageShopProductCreationFieldsModel> {
        final /* synthetic */ AdminProductFragmentController f15605a;

        C21751(AdminProductFragmentController adminProductFragmentController) {
            this.f15605a = adminProductFragmentController;
        }

        public final void mo760a(@Nullable Object obj) {
            AdminProductFragmentController.m16091a(this.f15605a, (PageShopProductCreationFieldsModel) obj);
            AdminProductFragmentController.m16094c(this.f15605a);
        }

        public final void mo761a(String str, @Nullable Throwable th) {
            AdminProductFragmentController.m16092a(this.f15605a, str, th);
        }
    }

    /* compiled from: cvbzwsjjjcxzwww */
    class C21762 implements ResultHandler<FetchAdminCommerceProductItemModel> {
        final /* synthetic */ AdminProductFragmentController f15606a;

        C21762(AdminProductFragmentController adminProductFragmentController) {
            this.f15606a = adminProductFragmentController;
        }

        public final void mo760a(@Nullable Object obj) {
            FetchAdminCommerceProductItemModel fetchAdminCommerceProductItemModel = (FetchAdminCommerceProductItemModel) obj;
            AdminProductFragmentController adminProductFragmentController = this.f15606a;
            if (fetchAdminCommerceProductItemModel != null) {
                AdminProductFragment adminProductFragment = adminProductFragmentController.f15610c;
                Optional fromNullable = Optional.fromNullable(fetchAdminCommerceProductItemModel);
                if (fromNullable.isPresent()) {
                    adminProductFragment.az = (AdminCommerceProductItem) fromNullable.get();
                }
                AdminProductFragmentController.m16091a(adminProductFragmentController, fetchAdminCommerceProductItemModel.k());
            }
            AdminProductFragmentController.m16094c(this.f15606a);
        }

        public final void mo761a(String str, @Nullable Throwable th) {
            AdminProductFragmentController.m16092a(this.f15606a, str, th);
        }
    }

    /* compiled from: cvbzwsjjjcxzwww */
    class C21773 implements ResultHandler<ViewerContext> {
        final /* synthetic */ AdminProductFragmentController f15607a;

        C21773(AdminProductFragmentController adminProductFragmentController) {
            this.f15607a = adminProductFragmentController;
        }

        public final void mo760a(@Nullable Object obj) {
            ViewerContext viewerContext = (ViewerContext) obj;
            if (viewerContext != null) {
                this.f15607a.f15610c.au = viewerContext;
                AdminProductFragmentController.m16094c(this.f15607a);
                return;
            }
            String str = "PageViewerContextResultHandler, Page ViewerContext is null";
            mo761a(str, new Throwable(str));
        }

        public final void mo761a(String str, @Nullable Throwable th) {
            AdminProductFragmentController.m16092a(this.f15607a, str, th);
        }
    }

    @Inject
    public AdminProductFragmentController(AdminProductFragmentLoader adminProductFragmentLoader, @Assisted ViewDelegate viewDelegate, ProductCreationFieldsProvider productCreationFieldsProvider, ProductWithEditFieldsProvider productWithEditFieldsProvider, PageViewerContextLoadableProvider pageViewerContextLoadableProvider, Lazy<TasksManager> lazy, Lazy<FbErrorReporter> lazy2) {
        this.f15609b = adminProductFragmentLoader;
        this.f15610c = viewDelegate;
        this.f15611d = productCreationFieldsProvider;
        this.f15612e = productWithEditFieldsProvider;
        this.f15613f = pageViewerContextLoadableProvider;
        this.f15614g = lazy;
        this.f15615h = lazy2;
    }

    public final void m16096a(boolean z, String str, Optional<String> optional, Optional<ViewerContext> optional2) {
        boolean z2;
        Preconditions.checkNotNull(str);
        Queue linkedList = new LinkedList();
        if (z) {
            if (optional.isPresent()) {
                ProductWithEditFieldsProvider productWithEditFieldsProvider = this.f15612e;
                linkedList.add(new ProductWithEditFields(AdminProductFetcher.m16028a(productWithEditFieldsProvider), (TasksManager) this.f15614g.get(), (String) optional.get(), this.f15617j));
            } else {
                ProductCreationFieldsProvider productCreationFieldsProvider = this.f15611d;
                linkedList.add(new ProductCreationFields(AdminProductFetcher.m16028a(productCreationFieldsProvider), (TasksManager) this.f15614g.get(), str, this.f15616i));
            }
        }
        if (!optional2.isPresent()) {
            PageViewerContextLoadableProvider pageViewerContextLoadableProvider = this.f15613f;
            linkedList.add(new PageViewerContextLoadable(PageViewerContextLifecycleHelper.a(pageViewerContextLoadableProvider), str, this.f15618k));
        }
        Queue queue = linkedList;
        AdminProductFragmentLoader adminProductFragmentLoader = this.f15609b;
        if (adminProductFragmentLoader.f15620b) {
            z2 = false;
        } else {
            adminProductFragmentLoader.f15620b = true;
            adminProductFragmentLoader.f15619a = queue;
            z2 = adminProductFragmentLoader.m16098a();
        }
        if (!z2) {
            m16093b();
        }
    }

    public final void m16095a() {
        AdminProductFragmentLoader adminProductFragmentLoader = this.f15609b;
        adminProductFragmentLoader.f15620b = false;
        adminProductFragmentLoader.f15619a.clear();
        ((TasksManager) this.f15614g.get()).c();
    }

    private void m16093b() {
        this.f15610c.m16081b();
    }

    public static void m16094c(AdminProductFragmentController adminProductFragmentController) {
        if ((!adminProductFragmentController.f15609b.m16098a() ? 1 : null) != null) {
            adminProductFragmentController.m16093b();
        }
    }

    public static void m16092a(AdminProductFragmentController adminProductFragmentController, @Nullable String str, Throwable th) {
        if (th == null) {
            th = new Throwable(str);
        }
        adminProductFragmentController.m16095a();
        ((AbstractFbErrorReporter) adminProductFragmentController.f15615h.get()).b(f15608a, str, th);
        adminProductFragmentController.f15610c.aH.setVisibility(8);
    }

    public static void m16091a(@Nullable AdminProductFragmentController adminProductFragmentController, PageShopProductCreationFieldsModel pageShopProductCreationFieldsModel) {
        if (pageShopProductCreationFieldsModel != null) {
            Optional optional;
            if (pageShopProductCreationFieldsModel == null || pageShopProductCreationFieldsModel.j() == null || pageShopProductCreationFieldsModel.j().a() == null || pageShopProductCreationFieldsModel.j().a().a() == null) {
                optional = Absent.INSTANCE;
            } else {
                optional = Optional.fromNullable(CommerceCurrencyUtil.b(pageShopProductCreationFieldsModel.j().a().a()));
            }
            Optional optional2 = optional;
            if (pageShopProductCreationFieldsModel == null || pageShopProductCreationFieldsModel.j() == null || pageShopProductCreationFieldsModel.j().j() == null) {
                optional = Absent.INSTANCE;
            } else {
                optional = Optional.of(Integer.valueOf(CommercePublishingGraphQLUtils.a(pageShopProductCreationFieldsModel.j().j())));
            }
            Optional optional3 = optional;
            AdminProductFragment adminProductFragment = adminProductFragmentController.f15610c;
            if (optional2.isPresent()) {
                adminProductFragment.ay = (Currency) optional2.get();
            }
            if (optional3.isPresent()) {
                adminProductFragment.aB = ((Integer) optional3.get()).intValue();
            }
        }
    }
}
