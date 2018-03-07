package com.facebook.commerce.storefront.ui;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.commerce.storefront.api.MerchantSubscriptionParams;
import com.facebook.commerce.storefront.api.StoreFrontFetcher;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: could not construct URL for request */
public class MerchantSubscriptionViewController {
    public final StoreFrontFetcher f15799a;
    public final ListeningExecutorService f15800b;
    private String f15801c;
    public TriState f15802d = TriState.UNSET;
    public boolean f15803e;
    public OnViewModelUpdateListener f15804f;

    /* compiled from: could not construct URL for request */
    public interface OnViewModelUpdateListener {
        void mo770a();
    }

    public static MerchantSubscriptionViewController m16277b(InjectorLike injectorLike) {
        return new MerchantSubscriptionViewController(new StoreFrontFetcher(IdBasedProvider.a(injectorLike, 1144), IdBasedLazy.a(injectorLike, 375)), (ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MerchantSubscriptionViewController(StoreFrontFetcher storeFrontFetcher, ListeningExecutorService listeningExecutorService) {
        this.f15799a = storeFrontFetcher;
        this.f15800b = listeningExecutorService;
    }

    public static MerchantSubscriptionViewController m16274a(InjectorLike injectorLike) {
        return m16277b(injectorLike);
    }

    public final void m16278a(OnViewModelUpdateListener onViewModelUpdateListener) {
        this.f15804f = onViewModelUpdateListener;
    }

    public final void m16279a(String str, boolean z, boolean z2) {
        this.f15801c = str;
        this.f15803e = z2;
        if (this.f15802d == TriState.UNSET) {
            this.f15802d = TriState.valueOf(z);
        }
        if (this.f15804f != null) {
            this.f15804f.mo770a();
        }
    }

    public final boolean m16280a() {
        return (StringUtil.a(this.f15801c) || this.f15802d == TriState.UNSET) ? false : true;
    }

    public final boolean m16281b() {
        return this.f15803e;
    }

    public final boolean m16282c() {
        return this.f15802d.asBoolean(false);
    }

    public final void m16283d() {
        m16276a(this.f15802d != TriState.YES);
    }

    private void m16276a(final boolean z) {
        StoreFrontFetcher storeFrontFetcher = this.f15799a;
        Parcelable merchantSubscriptionParams = new MerchantSubscriptionParams(this.f15801c, z);
        String str = "merchantSubscriptionParams";
        String str2 = "update_merchant_subscription_status";
        Bundle bundle = new Bundle();
        if (merchantSubscriptionParams != null) {
            bundle.putParcelable(str, merchantSubscriptionParams);
        }
        bundle.putParcelable("overridden_viewer_context", ((ViewerContextManager) storeFrontFetcher.f15697b.get()).a());
        Futures.a(BlueServiceOperationFactoryDetour.a((DefaultBlueServiceOperationFactory) storeFrontFetcher.f15696a.get(), str2, bundle, 1272965864).b(), new FutureCallback<OperationResult>(this) {
            final /* synthetic */ MerchantSubscriptionViewController f15798b;

            public void onSuccess(@Nullable Object obj) {
                this.f15798b.f15802d = TriState.valueOf(z);
                if (this.f15798b.f15804f != null) {
                    this.f15798b.f15804f.mo770a();
                }
            }

            public void onFailure(Throwable th) {
            }
        }, this.f15800b);
    }
}
