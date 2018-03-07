package com.facebook.messaging.business.common.activity;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.messaging.business.commerceui.views.CommerceOrderHistoryFragment;
import com.facebook.messaging.business.commerceui.views.retail.CommerceCheckoutSelectionFragment;
import com.facebook.messaging.business.commerceui.views.retail.CommerceShoppingTrendingFragment;
import com.facebook.messaging.business.commerceui.views.retail.ReceiptDetailsFragment;
import com.facebook.messaging.business.commerceui.views.retail.ShippingDetailsFragment;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment.Factory;
import com.facebook.messaging.business.nativesignup.view.BusinessConfirmCodeFragment;
import com.facebook.messaging.business.nativesignup.view.BusinessCreateAccountFragment;
import com.facebook.messaging.business.nativesignup.view.BusinessEmailInputFragment;
import com.facebook.messaging.business.nativesignup.view.BusinessOauthFragment;
import com.facebook.messaging.business.nativesignup.view.BusinessRequestCodeFragment;
import com.facebook.messaging.business.nativesignup.view.BusinessSignUpFragment;
import com.facebook.messaging.business.review.view.ReviewUpdateFragment;
import com.facebook.messaging.business.ride.view.RideRequestFragment;
import com.facebook.messaging.payment.prefs.receipts.manual.InvoicesProofOfPaymentFragment;
import com.facebook.messaging.payment.prefs.receipts.manual.InvoicesSummaryFragment;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: recommended_radius */
public final class STATICDI_MULTIBIND_PROVIDER$BusinessActivityFragment_Factory implements MultiBindIndexedProvider<Factory>, Provider<Set<Factory>> {
    private final InjectorLike f8692a;

    public STATICDI_MULTIBIND_PROVIDER$BusinessActivityFragment_Factory(InjectorLike injectorLike) {
        this.f8692a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f8692a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 15;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new CommerceOrderHistoryFragment.Factory();
            case 1:
                return new CommerceCheckoutSelectionFragment.Factory();
            case 2:
                return new CommerceShoppingTrendingFragment.Factory();
            case 3:
                return new ReceiptDetailsFragment.Factory();
            case 4:
                return new ShippingDetailsFragment.Factory();
            case 5:
                return new BusinessConfirmCodeFragment.Factory();
            case 6:
                return new BusinessCreateAccountFragment.Factory();
            case 7:
                return new BusinessEmailInputFragment.Factory();
            case 8:
                return new BusinessOauthFragment.Factory();
            case 9:
                return new BusinessRequestCodeFragment.Factory();
            case 10:
                return new BusinessSignUpFragment.Factory();
            case 11:
                return new ReviewUpdateFragment.Factory();
            case 12:
                return new RideRequestFragment.Factory();
            case 13:
                return new InvoicesProofOfPaymentFragment.Factory();
            case 14:
                return new InvoicesSummaryFragment.Factory();
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
