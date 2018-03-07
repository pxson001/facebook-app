package com.facebook.commerce.productdetails.ui.userinteractions;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.commerce.core.event.CommerceEvent.CommerceEventMessageToBuyClicked;
import com.facebook.commerce.core.event.CommerceEventBus;
import com.facebook.commerce.core.util.CommerceCurrencyUtil;
import com.facebook.commerce.core.util.CommerceMerchantUtil;
import com.facebook.commerce.core.util.ProductApprovalUtils;
import com.facebook.commerce.productdetails.api.CheckoutParams;
import com.facebook.commerce.productdetails.api.ProductDetailsFetcher;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.FetchProductGroupQueryModel;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.FetchProductGroupQueryModel.GroupModel.ProductItemsEdgeModel.NodesModel;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.FetchProductGroupQueryModel.GroupModel.ProductItemsEdgeModel.NodesModel.ImagesModel;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.ProductGroupFeedbackModel;
import com.facebook.commerce.productdetails.ui.userinteractions.ProductGroupUserInteractionsViewModel.CheckoutType;
import com.facebook.commerce.productdetails.ui.userinteractions.ProductVariantViewModel.VariantValueState;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.Product;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.feedback.ui.FeedbackPopoverLauncher;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLCommerceCheckoutStyle;
import com.facebook.graphql.enums.GraphQLCommerceProductVisibility;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLFeedback.Builder;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLLikersOfContentConnection;
import com.facebook.graphql.model.GraphQLTopLevelCommentsConnection;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerPageData;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.pages.PageInfo;
import com.facebook.messaging.sharing.sendasmessage.SendAsMessageUtil;
import com.facebook.messaging.util.MessengerAppUtils;
import com.facebook.pages.data.cache.PagesInfoCache;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ufiservices.flyout.FeedbackParams;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: dbl_nux_save_placeholder */
public class ProductGroupUserInteractionsViewControllerImpl {
    public final ProductApprovalUtils f15377a;
    public final ProductDetailsFetcher f15378b;
    public final ListeningExecutorService f15379c;
    public final Lazy<SecureContextHelper> f15380d;
    private final Lazy<SendAsMessageUtil> f15381e;
    private final Lazy<MessengerAppUtils> f15382f;
    private final Lazy<FbUriIntentHandler> f15383g;
    private final Lazy<CommerceEventBus> f15384h;
    private final Lazy<GatekeeperStore> f15385i;
    public final Lazy<UriIntentMapper> f15386j;
    private final Lazy<ComposerLauncher> f15387k;
    private final Lazy<FeedbackPopoverLauncher> f15388l;
    private final Lazy<ViewerContextManager> f15389m;
    public final Lazy<Toaster> f15390n;
    private final Lazy<FbErrorReporter> f15391o;
    public final Lazy<Product> f15392p;
    private final Lazy<PagesInfoCache> f15393q;

    /* compiled from: dbl_nux_save_placeholder */
    public class C21312 implements FutureCallback<GraphQLResult> {
        final /* synthetic */ Callable f15375a;
        final /* synthetic */ ProductGroupUserInteractionsViewControllerImpl f15376b;

        public C21312(ProductGroupUserInteractionsViewControllerImpl productGroupUserInteractionsViewControllerImpl, Callable callable) {
            this.f15376b = productGroupUserInteractionsViewControllerImpl;
            this.f15375a = callable;
        }

        public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
        }

        public void onFailure(Throwable th) {
            BLog.b("ProductGroupUserInteractionsViewControllerImpl", "Couldn't toggle like.", th);
            ((Toaster) this.f15376b.f15390n.get()).a(new ToastBuilder(2131234805));
            try {
                this.f15375a.call();
            } catch (Throwable e) {
                BLog.b("ProductGroupUserInteractionsViewControllerImpl", "Couldn't call onFailureCallback", e);
            }
        }
    }

    /* compiled from: dbl_nux_save_placeholder */
    final class C21323 implements Comparator<NodesModel> {
        C21323() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((NodesModel) obj).m15735l().a() - ((NodesModel) obj2).m15735l().a();
        }
    }

    public static ProductGroupUserInteractionsViewControllerImpl m15961b(InjectorLike injectorLike) {
        return new ProductGroupUserInteractionsViewControllerImpl(ProductApprovalUtils.a(injectorLike), ProductDetailsFetcher.m15662a(injectorLike), (ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 968), IdBasedSingletonScopeProvider.b(injectorLike, 8437), IdBasedSingletonScopeProvider.b(injectorLike, 2747), IdBasedSingletonScopeProvider.b(injectorLike, 616), IdBasedSingletonScopeProvider.b(injectorLike, 5051), IdBasedSingletonScopeProvider.b(injectorLike, 2128), IdBasedSingletonScopeProvider.b(injectorLike, 2436), IdBasedSingletonScopeProvider.b(injectorLike, 849), IdBasedLazy.a(injectorLike, 1794), IdBasedLazy.a(injectorLike, 375), IdBasedLazy.a(injectorLike, 3588), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedLazy.a(injectorLike, 873), IdBasedSingletonScopeProvider.b(injectorLike, 9013));
    }

    public final void m15967a(ProductGroupFeedbackViewModel productGroupFeedbackViewModel, Context context) {
        GraphQLFeedback graphQLFeedback;
        ProductGroupFeedbackModel productGroupFeedbackModel = productGroupFeedbackViewModel.f15314f;
        if (productGroupFeedbackModel == null) {
            graphQLFeedback = null;
        } else {
            Builder b = new Builder().b(productGroupFeedbackModel.m15853b());
            b.f = productGroupFeedbackModel.m15854c();
            b = b;
            b.g = productGroupFeedbackModel.m15855d();
            b = b;
            b.h = productGroupFeedbackModel.nj_();
            b = b.f(productGroupFeedbackModel.m15856g()).j(productGroupFeedbackModel.nk_());
            b.v = productGroupFeedbackModel.nl_();
            b = b;
            b.A = productGroupFeedbackModel.m15857j();
            b = b;
            b.N = productGroupFeedbackModel.m15860m();
            b = b;
            if (productGroupFeedbackModel.m15858k() != null) {
                b.C = new GraphQLLikersOfContentConnection.Builder().a(productGroupFeedbackModel.m15858k().m15829a()).a();
            }
            if (productGroupFeedbackModel.m15859l() != null) {
                b.L = new GraphQLTopLevelCommentsConnection.Builder().a(productGroupFeedbackModel.m15859l().m15837a()).b(productGroupFeedbackModel.m15859l().m15842b()).a();
            }
            graphQLFeedback = b.a();
        }
        GraphQLFeedback graphQLFeedback2 = graphQLFeedback;
        if (graphQLFeedback2 != null) {
            ViewerContextManager viewerContextManager = (ViewerContextManager) this.f15389m.get();
            if (graphQLFeedback2.O() != null) {
                ViewerContext b2 = viewerContextManager.b();
                if (!(b2 == null || !b2.mIsPageContext || StringUtil.a(b2.mAuthToken))) {
                    PropertyHelper.a(graphQLFeedback2, b2.mAuthToken);
                }
            }
            FeedbackParams.Builder builder = new FeedbackParams.Builder();
            builder.a = graphQLFeedback2;
            builder = builder;
            builder.d = graphQLFeedback2.z_();
            builder = builder;
            builder.e = graphQLFeedback2.j();
            builder = builder;
            builder.i = true;
            builder = builder;
            FeedbackLoggingParams.Builder builder2 = new FeedbackLoggingParams.Builder();
            builder2.c = "commerce_product_details";
            builder.g = builder2.a();
            ((FeedbackPopoverLauncher) this.f15388l.get()).a(context, builder.a());
        }
    }

    @Inject
    public ProductGroupUserInteractionsViewControllerImpl(ProductApprovalUtils productApprovalUtils, ProductDetailsFetcher productDetailsFetcher, ListeningExecutorService listeningExecutorService, Lazy<SecureContextHelper> lazy, Lazy<SendAsMessageUtil> lazy2, Lazy<MessengerAppUtils> lazy3, Lazy<FbUriIntentHandler> lazy4, Lazy<CommerceEventBus> lazy5, Lazy<GatekeeperStore> lazy6, Lazy<UriIntentMapper> lazy7, Lazy<ComposerLauncher> lazy8, Lazy<FeedbackPopoverLauncher> lazy9, Lazy<ViewerContextManager> lazy10, Lazy<Toaster> lazy11, Lazy<FbErrorReporter> lazy12, Lazy<Product> lazy13, Lazy<PagesInfoCache> lazy14) {
        this.f15377a = productApprovalUtils;
        this.f15378b = productDetailsFetcher;
        this.f15379c = listeningExecutorService;
        this.f15380d = lazy;
        this.f15381e = lazy2;
        this.f15382f = lazy3;
        this.f15383g = lazy4;
        this.f15384h = lazy5;
        this.f15385i = lazy6;
        this.f15386j = lazy7;
        this.f15387k = lazy8;
        this.f15388l = lazy9;
        this.f15389m = lazy10;
        this.f15390n = lazy11;
        this.f15391o = lazy12;
        this.f15392p = lazy13;
        this.f15393q = lazy14;
    }

    @Nullable
    private static NodesModel m15947a(ProductGroupUserInteractionsViewModel productGroupUserInteractionsViewModel) {
        if (productGroupUserInteractionsViewModel.f15428o.isEmpty()) {
            return null;
        }
        return (NodesModel) productGroupUserInteractionsViewModel.f15428o.get(0);
    }

    public final void m15968a(ProductGroupUserInteractionsViewModel productGroupUserInteractionsViewModel, int i, final Context context) {
        if (productGroupUserInteractionsViewModel.f15429p != null) {
            if (productGroupUserInteractionsViewModel.f15429p == CheckoutType.OFFSITE) {
                m15963b(productGroupUserInteractionsViewModel, context);
            } else if (productGroupUserInteractionsViewModel.f15429p == CheckoutType.CONTACT_MERCHANT) {
                ((CommerceEventBus) this.f15384h.get()).a(new CommerceEventMessageToBuyClicked());
                m15955a(productGroupUserInteractionsViewModel.f15433t, productGroupUserInteractionsViewModel.f15428o, context);
            } else if (productGroupUserInteractionsViewModel.f15429p == CheckoutType.ONSITE) {
                NodesModel a = m15947a(productGroupUserInteractionsViewModel);
                if (a == null) {
                    return;
                }
                if (((GatekeeperStoreImpl) this.f15385i.get()).a(553, false)) {
                    ProductDetailsFetcher productDetailsFetcher = this.f15378b;
                    Parcelable checkoutParams = new CheckoutParams(a.m15738o(), i);
                    String str = "checkoutParams";
                    String str2 = "submit_item_for_checkout";
                    Bundle bundle = new Bundle();
                    if (checkoutParams != null) {
                        bundle.putParcelable(str, checkoutParams);
                    }
                    Futures.a(BlueServiceOperationFactoryDetour.a((DefaultBlueServiceOperationFactory) productDetailsFetcher.f15134a.get(), str2, bundle, 1237699512).b(), new FutureCallback<OperationResult>(this) {
                        final /* synthetic */ ProductGroupUserInteractionsViewControllerImpl f15374b;

                        public void onSuccess(@Nullable Object obj) {
                            OperationResult operationResult = (OperationResult) obj;
                            if (operationResult != null) {
                                ((SecureContextHelper) this.f15374b.f15380d.get()).a(((UriIntentMapper) this.f15374b.f15386j.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, operationResult.c)), context);
                            }
                        }

                        public void onFailure(Throwable th) {
                        }
                    }, this.f15379c);
                    return;
                }
                m15958a(a.m15736m(), context);
            }
        }
    }

    public final ProductGroupUserInteractionsViewModel m15965a(FetchProductGroupQueryModel fetchProductGroupQueryModel) {
        boolean z;
        ProductGroupUserInteractionsViewModel.Builder builder = new ProductGroupUserInteractionsViewModel.Builder();
        builder.f15413t = fetchProductGroupQueryModel;
        builder.f15397d = fetchProductGroupQueryModel.m15821s();
        if (fetchProductGroupQueryModel.m15815m() == GraphQLCommerceProductVisibility.VISIBLE) {
            z = true;
        } else {
            z = false;
        }
        builder.f15398e = z;
        if (!(fetchProductGroupQueryModel.m15819q() == null || fetchProductGroupQueryModel.m15819q().m15751j() == null || fetchProductGroupQueryModel.m15819q().m15751j().m15746a().size() > 1)) {
            builder.f15404k = true;
        }
        if (!(fetchProductGroupQueryModel.m15814l() == null || !fetchProductGroupQueryModel.m15814l().m15702k() || ProductApprovalUtils.a(fetchProductGroupQueryModel.m15815m()) == null)) {
            GraphQLCommerceProductVisibility m = fetchProductGroupQueryModel.m15815m();
            builder.f15394a = Optional.of(ProductApprovalUtils.a(m));
            builder.f15395b = this.f15377a.b(m);
            builder.f15396c = this.f15377a.c(m);
        }
        m15962b(fetchProductGroupQueryModel, builder);
        if (fetchProductGroupQueryModel == null || fetchProductGroupQueryModel.m15819q() == null) {
            builder.f15412s = Absent.INSTANCE;
        } else {
            builder.f15412s = m15949a(fetchProductGroupQueryModel.m15819q().m15749a());
        }
        m15956a(builder, m15964c(fetchProductGroupQueryModel), fetchProductGroupQueryModel);
        return builder.m15970a();
    }

    public static Optional<ProductGroupFeedbackViewModel> m15949a(@Nullable ProductGroupFeedbackModel productGroupFeedbackModel) {
        if (productGroupFeedbackModel == null) {
            return Absent.INSTANCE;
        }
        Optional of;
        Optional of2;
        boolean z = (!productGroupFeedbackModel.m15856g() || StringUtil.a(productGroupFeedbackModel.nl_()) || StringUtil.a(productGroupFeedbackModel.m15857j())) ? false : true;
        if (productGroupFeedbackModel.m15861n() != null) {
            of = Optional.of(Integer.valueOf(productGroupFeedbackModel.m15861n().m15829a()));
        } else {
            of = Absent.INSTANCE;
        }
        if (productGroupFeedbackModel.m15862o() != null) {
            of2 = Optional.of(Integer.valueOf(productGroupFeedbackModel.m15862o().m15837a()));
        } else {
            of2 = Absent.INSTANCE;
        }
        return Optional.of(new ProductGroupFeedbackViewModel(z, productGroupFeedbackModel.m15853b(), productGroupFeedbackModel.nk_(), of, of2, productGroupFeedbackModel));
    }

    public final ProductGroupUserInteractionsViewModel m15966a(ProductGroupUserInteractionsViewModel productGroupUserInteractionsViewModel, int i, int i2) {
        boolean z;
        Optional optional;
        boolean z2 = true;
        if (i < productGroupUserInteractionsViewModel.f15425l.size()) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        if (i2 >= ((ProductVariantViewModel) productGroupUserInteractionsViewModel.f15425l.get(i)).f15435b.size()) {
            z2 = false;
        }
        Preconditions.checkState(z2);
        Optional optional2 = ((ProductVariantViewModel) productGroupUserInteractionsViewModel.f15425l.get(i)).f15437d;
        if (i2 == -1) {
            optional = Absent.INSTANCE;
        } else {
            optional = Optional.of(Integer.valueOf(i2));
        }
        if (!optional2.isPresent() && !optional.isPresent()) {
            return productGroupUserInteractionsViewModel;
        }
        if (optional2.isPresent() && optional.isPresent() && optional2.get() == optional.get()) {
            return productGroupUserInteractionsViewModel;
        }
        ProductGroupUserInteractionsViewModel.Builder builder = new ProductGroupUserInteractionsViewModel.Builder();
        builder.f15394a = productGroupUserInteractionsViewModel.f15414a;
        builder = builder;
        builder.f15395b = productGroupUserInteractionsViewModel.f15415b;
        builder = builder;
        builder.f15396c = productGroupUserInteractionsViewModel.f15416c;
        builder = builder;
        builder.f15397d = productGroupUserInteractionsViewModel.f15417d;
        builder = builder;
        builder.f15398e = productGroupUserInteractionsViewModel.f15418e;
        builder = builder;
        builder.f15399f = productGroupUserInteractionsViewModel.f15419f;
        builder = builder;
        builder.f15400g = productGroupUserInteractionsViewModel.f15420g;
        builder = builder;
        builder.f15401h = productGroupUserInteractionsViewModel.f15421h;
        builder = builder;
        builder.f15402i = productGroupUserInteractionsViewModel.f15422i;
        builder = builder;
        builder.f15403j = productGroupUserInteractionsViewModel.f15423j;
        builder = builder;
        builder.f15404k = productGroupUserInteractionsViewModel.f15424k;
        builder = builder;
        builder.f15405l = ImmutableList.copyOf(productGroupUserInteractionsViewModel.f15425l);
        builder = builder;
        builder.f15406m = productGroupUserInteractionsViewModel.f15426m;
        builder = builder;
        builder.f15407n = productGroupUserInteractionsViewModel.f15427n;
        builder = builder;
        builder.f15408o = productGroupUserInteractionsViewModel.f15428o;
        builder = builder;
        builder.f15409p = productGroupUserInteractionsViewModel.f15429p;
        builder = builder;
        builder.f15410q = productGroupUserInteractionsViewModel.f15430q;
        builder = builder;
        builder.f15411r = productGroupUserInteractionsViewModel.f15431r;
        builder = builder;
        builder.f15412s = productGroupUserInteractionsViewModel.f15432s;
        builder = builder;
        builder.f15413t = productGroupUserInteractionsViewModel.f15433t;
        ProductGroupUserInteractionsViewModel.Builder builder2 = builder;
        m15956a(builder2, m15952a(m15951a(productGroupUserInteractionsViewModel.f15425l, i, optional), productGroupUserInteractionsViewModel.f15433t.m15819q().m15751j().m15746a()), productGroupUserInteractionsViewModel.f15433t);
        return builder2.m15970a();
    }

    private static void m15956a(ProductGroupUserInteractionsViewModel.Builder builder, ImmutableList<ProductVariantViewModel> immutableList, FetchProductGroupQueryModel fetchProductGroupQueryModel) {
        boolean z;
        builder.f15405l = immutableList;
        ImmutableList a = fetchProductGroupQueryModel.m15819q().m15751j().m15746a();
        int[] iArr = new int[immutableList.size()];
        for (int i = 0; i < immutableList.size(); i++) {
            int intValue;
            if (((ProductVariantViewModel) immutableList.get(i)).f15437d.isPresent()) {
                intValue = ((Integer) ((ProductVariantViewModel) immutableList.get(i)).f15437d.get()).intValue();
            } else {
                intValue = -1;
            }
            iArr[i] = intValue;
        }
        List a2 = m15953a(iArr, (ImmutableList) immutableList, a);
        builder.f15408o = a2;
        boolean z2 = fetchProductGroupQueryModel.m15814l() != null && CommerceMerchantUtil.a(fetchProductGroupQueryModel.m15814l().m15697a());
        if (fetchProductGroupQueryModel.m15812j() != null) {
            Object obj;
            if (fetchProductGroupQueryModel.m15812j() == GraphQLCommerceCheckoutStyle.OFFSITE_LINK) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                z = true;
                if (z2) {
                    builder.f15409p = CheckoutType.CONTACT_MERCHANT;
                } else if (z) {
                    builder.f15409p = CheckoutType.ONSITE;
                } else {
                    builder.f15409p = CheckoutType.OFFSITE;
                }
                if (z) {
                    builder.f15410q = m15954a(fetchProductGroupQueryModel.m15818p());
                }
                if (!z2 || z) {
                    builder.f15406m = Absent.INSTANCE;
                    builder.f15407n = false;
                    builder.f15411r = true;
                } else {
                    int size = immutableList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (!((ProductVariantViewModel) immutableList.get(i2)).f15437d.isPresent()) {
                            z2 = false;
                            break;
                        }
                    }
                    z2 = true;
                    if (a2.size() == 1 && r1 && !m15960a(a2)) {
                        intValue = Math.min(((NodesModel) a2.get(0)).m15734k(), 9);
                        builder.f15407n = true;
                        builder.f15406m = Optional.of(Integer.valueOf(intValue));
                        builder.f15411r = true;
                    } else {
                        builder.f15406m = Optional.of(Integer.valueOf(1));
                        builder.f15407n = false;
                        builder.f15411r = false;
                    }
                }
                m15957a((ImmutableList) a2, builder);
            }
        }
        z = false;
        if (z2) {
            builder.f15409p = CheckoutType.CONTACT_MERCHANT;
        } else if (z) {
            builder.f15409p = CheckoutType.ONSITE;
        } else {
            builder.f15409p = CheckoutType.OFFSITE;
        }
        if (z) {
            builder.f15410q = m15954a(fetchProductGroupQueryModel.m15818p());
        }
        if (z2) {
        }
        builder.f15406m = Absent.INSTANCE;
        builder.f15407n = false;
        builder.f15411r = true;
        m15957a((ImmutableList) a2, builder);
    }

    public final void m15969a(ProductGroupUserInteractionsViewModel productGroupUserInteractionsViewModel, Context context) {
        boolean z;
        if (StringUtil.a(productGroupUserInteractionsViewModel.f15433t.m15820r())) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkState(z);
        ComposerConfiguration.Builder isFireAndForget = ComposerConfigurationFactory.c(ComposerSourceType.PRODUCT_DETAILS, ComposerShareParams.Builder.a(GraphQLHelper.a(productGroupUserInteractionsViewModel.f15433t.m15820r(), 175920258)).b()).setIsFireAndForget(true);
        if (m15959a(productGroupUserInteractionsViewModel, isFireAndForget)) {
            ((ComposerLauncher) this.f15387k.get()).a(null, isFireAndForget.a(), context);
        }
    }

    private boolean m15959a(ProductGroupUserInteractionsViewModel productGroupUserInteractionsViewModel, ComposerConfiguration.Builder builder) {
        Object obj;
        if (this.f15392p.get() == Product.PAA) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            return true;
        }
        ViewerContext b = ((ViewerContextManager) this.f15389m.get()).b();
        if (b == null || !b.mIsPageContext) {
            b = null;
        }
        ViewerContext viewerContext = b;
        if (viewerContext == null) {
            ((AbstractFbErrorReporter) this.f15391o.get()).b("ProductGroupUserInteractionsViewControllerImpl", "No overridden ViewerContext available to attach to Composer.");
            return false;
        }
        long parseLong;
        String m;
        String a;
        if (viewerContext.mUserId.equals(productGroupUserInteractionsViewModel.f15433t.m15822t().m15772l())) {
            parseLong = Long.parseLong(productGroupUserInteractionsViewModel.f15433t.m15822t().m15772l());
            m = productGroupUserInteractionsViewModel.f15433t.m15822t().m15773m();
            if (productGroupUserInteractionsViewModel.f15433t.m15822t().m15775o() != null) {
                a = productGroupUserInteractionsViewModel.f15433t.m15822t().m15775o().a();
            } else {
                a = "";
            }
        } else {
            PageInfo a2 = ((PagesInfoCache) this.f15393q.get()).m8312a(viewerContext.mUserId);
            if (a2 == null) {
                ((AbstractFbErrorReporter) this.f15391o.get()).b("ProductGroupUserInteractionsViewControllerImpl", "No PageInfo available for Page (page_id: " + viewerContext.mUserId + ")");
                return false;
            }
            parseLong = a2.pageId;
            m = a2.pageName;
            a = a2.squareProfilePicUrl;
        }
        ComposerTargetData.Builder builder2 = new ComposerTargetData.Builder();
        builder2.b = TargetType.PAGE;
        builder2 = builder2;
        builder2.f = true;
        builder2 = builder2;
        builder2.a = parseLong;
        ComposerTargetData.Builder builder3 = builder2;
        builder3.c = m;
        ComposerTargetData.Builder builder4 = builder3;
        builder4.d = a;
        ComposerTargetData a3 = builder4.a();
        ComposerPageData.Builder postAsPageViewerContext = ComposerPageData.newBuilder().setPostAsPageViewerContext(viewerContext);
        builder.setInitialTargetData(a3);
        builder.setInitialPageData(postAsPageViewerContext.a());
        return true;
    }

    private void m15963b(ProductGroupUserInteractionsViewModel productGroupUserInteractionsViewModel, Context context) {
        NodesModel a = m15947a(productGroupUserInteractionsViewModel);
        if (a != null) {
            m15958a(((GatekeeperStoreImpl) this.f15385i.get()).a(552, false) ? a.m15733j() : a.m15736m(), context);
        }
    }

    private void m15958a(String str, Context context) {
        if (!StringUtil.a(str)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            ((SecureContextHelper) this.f15380d.get()).b(intent, context);
        }
    }

    private void m15955a(@Nullable FetchProductGroupQueryModel fetchProductGroupQueryModel, ImmutableList<NodesModel> immutableList, Context context) {
        if (fetchProductGroupQueryModel != null) {
            String str;
            String str2;
            String str3;
            String m;
            String s = fetchProductGroupQueryModel.m15821s();
            if (fetchProductGroupQueryModel.m15819q() == null || fetchProductGroupQueryModel.m15819q().m15751j() == null || fetchProductGroupQueryModel.m15819q().m15751j().m15746a().isEmpty() || fetchProductGroupQueryModel.m15819q().m15751j().m15746a().get(0) == null || ((NodesModel) fetchProductGroupQueryModel.m15819q().m15751j().m15746a().get(0)).m15737n() == null || ((NodesModel) fetchProductGroupQueryModel.m15819q().m15751j().m15746a().get(0)).m15737n().m15722a() == null) {
                str = null;
            } else {
                str = ((NodesModel) fetchProductGroupQueryModel.m15819q().m15751j().m15746a().get(0)).m15737n().m15722a();
            }
            String str4 = str;
            String string = context.getResources().getString(2131241867, new Object[]{s});
            if (immutableList.isEmpty()) {
                str2 = null;
            } else {
                str2 = CommerceCurrencyUtil.a(((NodesModel) immutableList.get(0)).m15735l());
            }
            if (fetchProductGroupQueryModel.m15822t() != null) {
                str3 = fetchProductGroupQueryModel.m15822t().m15772l().toString();
                m = fetchProductGroupQueryModel.m15822t().m15773m();
            } else {
                m = null;
                str3 = null;
            }
            if (((MessengerAppUtils) this.f15382f.get()).a() && ((MessengerAppUtils) this.f15382f.get()).d() && ((MessengerAppUtils) this.f15382f.get()).a("35.0")) {
                ((SendAsMessageUtil) this.f15381e.get()).a(context, fetchProductGroupQueryModel.m15820r(), m, m, str4, str2, str3, string, "emerging_market_commerce");
                return;
            }
            ((FbUriIntentHandler) this.f15383g.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.eG, fetchProductGroupQueryModel.m15820r()));
        }
    }

    private static void m15962b(FetchProductGroupQueryModel fetchProductGroupQueryModel, ProductGroupUserInteractionsViewModel.Builder builder) {
        if (fetchProductGroupQueryModel.m15819q() != null && fetchProductGroupQueryModel.m15819q().m15751j() != null) {
            Collection linkedHashSet = new LinkedHashSet();
            ImmutableList a = fetchProductGroupQueryModel.m15819q().m15751j().m15746a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                NodesModel nodesModel = (NodesModel) a.get(i);
                if (!(nodesModel.m15739p() == null || nodesModel.m15739p().isEmpty())) {
                    ImmutableList p = nodesModel.m15739p();
                    int size2 = p.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ImagesModel imagesModel = (ImagesModel) p.get(i2);
                        if (!StringUtil.a(imagesModel.m15727a())) {
                            linkedHashSet.add(imagesModel.m15727a());
                        }
                    }
                }
            }
            builder.f15399f = ImmutableList.copyOf(linkedHashSet);
        }
    }

    private static void m15957a(ImmutableList<NodesModel> immutableList, ProductGroupUserInteractionsViewModel.Builder builder) {
        builder.f15401h = Absent.INSTANCE;
        builder.f15402i = Absent.INSTANCE;
        if (immutableList.isEmpty()) {
            builder.f15400g = "--";
            return;
        }
        List arrayList = new ArrayList(immutableList);
        Collections.sort(arrayList, new C21323());
        if (arrayList.size() == 1) {
            NodesModel nodesModel = (NodesModel) arrayList.get(0);
            if (nodesModel.m15740q() && nodesModel.m15735l().a() != nodesModel.m15741r().a()) {
                builder.f15401h = Optional.of(CommerceCurrencyUtil.a(nodesModel.m15741r()));
            }
            if (nodesModel.m15734k() < 10) {
                builder.f15402i = Optional.of(Integer.valueOf(nodesModel.m15734k()));
            }
        }
        builder.f15403j = m15960a(arrayList);
        if (((long) ((NodesModel) arrayList.get(0)).m15735l().a()) == ((long) ((NodesModel) arrayList.get(arrayList.size() - 1)).m15735l().a())) {
            builder.f15400g = CommerceCurrencyUtil.a(((NodesModel) arrayList.get(0)).m15735l());
        } else {
            builder.f15400g = CommerceCurrencyUtil.a(((NodesModel) arrayList.get(0)).m15735l()) + " - " + CommerceCurrencyUtil.a(((NodesModel) arrayList.get(arrayList.size() - 1)).m15735l());
        }
    }

    public static boolean m15960a(List<NodesModel> list) {
        for (NodesModel k : list) {
            if (k.m15734k() > 0) {
                return false;
            }
        }
        return true;
    }

    private ImmutableList<ProductVariantViewModel> m15964c(FetchProductGroupQueryModel fetchProductGroupQueryModel) {
        if (fetchProductGroupQueryModel.m15819q() == null || fetchProductGroupQueryModel.m15819q().m15752k().isEmpty() || fetchProductGroupQueryModel.m15819q().m15751j() == null || fetchProductGroupQueryModel.m15819q().m15751j().m15746a().isEmpty()) {
            return RegularImmutableList.a;
        }
        NodesModel nodesModel;
        ImmutableList copyOf = ImmutableList.copyOf(fetchProductGroupQueryModel.m15819q().m15751j().m15746a());
        String r = fetchProductGroupQueryModel.m15820r();
        int size = copyOf.size();
        for (int i = 0; i < size; i++) {
            nodesModel = (NodesModel) copyOf.get(i);
            if (nodesModel.m15738o().equals(r)) {
                break;
            }
        }
        nodesModel = null;
        NodesModel nodesModel2 = nodesModel;
        int size2 = fetchProductGroupQueryModel.m15819q().m15752k().size();
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i2 = 0; i2 < size2; i2++) {
            builder.c(m15948a(i2, fetchProductGroupQueryModel, copyOf, nodesModel2));
        }
        return m15952a(builder.b(), copyOf);
    }

    private static ProductVariantViewModel m15948a(int i, FetchProductGroupQueryModel fetchProductGroupQueryModel, ImmutableList<NodesModel> immutableList, @Nullable NodesModel nodesModel) {
        Optional a;
        String str = (String) fetchProductGroupQueryModel.m15819q().m15752k().get(i);
        ImmutableList.Builder builder = new ImmutableList.Builder();
        Set hashSet = new HashSet();
        int size = immutableList.size();
        for (int i2 = 0; i2 < size; i2++) {
            NodesModel nodesModel2 = (NodesModel) immutableList.get(i2);
            if (i < nodesModel2.m15742s().size()) {
                String str2 = (String) nodesModel2.m15742s().get(i);
                if (!hashSet.contains(str2)) {
                    hashSet.add(str2);
                    builder.c(str2);
                }
            }
        }
        ImmutableList b = builder.b();
        VariantValueState[] variantValueStateArr = new VariantValueState[b.size()];
        for (int i3 = 0; i3 < variantValueStateArr.length; i3++) {
            variantValueStateArr[i3] = VariantValueState.AVAILABLE;
        }
        ImmutableList copyOf = ImmutableList.copyOf(variantValueStateArr);
        if (nodesModel != null) {
            a = m15950a((String) nodesModel.m15742s().get(i), b);
        } else {
            a = Absent.INSTANCE;
        }
        return new ProductVariantViewModel(str, b, copyOf, a);
    }

    private ImmutableList<ProductVariantViewModel> m15952a(ImmutableList<ProductVariantViewModel> immutableList, ImmutableList<NodesModel> immutableList2) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i = 0; i < immutableList.size(); i++) {
            int i2;
            int[] iArr = new int[immutableList.size()];
            for (i2 = 0; i2 < immutableList.size(); i2++) {
                int intValue;
                if (((ProductVariantViewModel) immutableList.get(i2)).f15437d.isPresent()) {
                    intValue = ((Integer) ((ProductVariantViewModel) immutableList.get(i2)).f15437d.get()).intValue();
                } else {
                    intValue = -1;
                }
                iArr[i2] = intValue;
            }
            ImmutableList.Builder builder2 = new ImmutableList.Builder();
            for (i2 = 0; i2 < ((ProductVariantViewModel) immutableList.get(i)).f15435b.size(); i2++) {
                iArr[i] = i2;
                ImmutableList a = m15953a(iArr, (ImmutableList) immutableList, (ImmutableList) immutableList2);
                if (a.isEmpty()) {
                    builder2.c(VariantValueState.NOT_AVAILABLE);
                } else {
                    int i3 = 0;
                    for (int i4 = 0; i4 < a.size(); i4++) {
                        i3 += ((NodesModel) a.get(i4)).m15734k();
                    }
                    if (i3 == 0) {
                        builder2.c(VariantValueState.SOLD_OUT);
                    } else {
                        builder2.c(VariantValueState.AVAILABLE);
                    }
                }
            }
            builder.c(new ProductVariantViewModel(((ProductVariantViewModel) immutableList.get(i)).f15434a, ((ProductVariantViewModel) immutableList.get(i)).f15435b, builder2.b(), ((ProductVariantViewModel) immutableList.get(i)).f15437d));
        }
        return builder.b();
    }

    private static ImmutableList<ProductVariantViewModel> m15951a(ImmutableList<ProductVariantViewModel> immutableList, int i, Optional<Integer> optional) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i2 = 0; i2 < immutableList.size(); i2++) {
            if (i2 != i) {
                builder.c(immutableList.get(i2));
            } else {
                ProductVariantViewModel productVariantViewModel = (ProductVariantViewModel) immutableList.get(i2);
                builder.c(new ProductVariantViewModel(productVariantViewModel.f15434a, productVariantViewModel.f15435b, productVariantViewModel.f15436c, optional));
            }
        }
        return builder.b();
    }

    private static Optional<Integer> m15950a(String str, ImmutableList<String> immutableList) {
        for (int i = 0; i < immutableList.size(); i++) {
            if (((String) immutableList.get(i)).equals(str)) {
                return Optional.of(Integer.valueOf(i));
            }
        }
        return Absent.INSTANCE;
    }

    public static ImmutableList<NodesModel> m15953a(int[] iArr, ImmutableList<ProductVariantViewModel> immutableList, ImmutableList<NodesModel> immutableList2) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int length = iArr.length;
        int size = immutableList2.size();
        for (int i = 0; i < size; i++) {
            NodesModel nodesModel = (NodesModel) immutableList2.get(i);
            int i2 = 0;
            while (i2 < length) {
                int i3 = iArr[i2];
                if (i3 != -1 && !((String) nodesModel.m15742s().get(i2)).equals((String) ((ProductVariantViewModel) immutableList.get(i2)).f15435b.get(i3))) {
                    Object obj = null;
                    break;
                }
                i2++;
            }
            int i4 = 1;
            if (obj != null) {
                builder.c(nodesModel);
            }
        }
        return builder.b();
    }

    @Nullable
    public static String m15954a(@Nullable String str) {
        String str2 = null;
        if (!StringUtil.a(str)) {
            try {
                str2 = new URL(str).getHost();
            } catch (Throwable e) {
                BLog.b(ProductGroupUserInteractionsViewControllerImpl.class, e, "Could not parse URL: %s", new Object[]{str});
            }
        }
        return str2;
    }
}
