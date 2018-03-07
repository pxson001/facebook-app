package com.facebook.messaging.location.sending;

import com.facebook.location.FbLocationStatusUtil;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController.GoogleLocationDialogResult;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController.OnGooglePlayServicesLocationUpsellDialogFinishedListener;
import com.facebook.qe.api.QeAccessor;
import javax.inject.Inject;

/* compiled from: mPaymentCards */
public class LocationGmsLsUpsellController implements OnGooglePlayServicesLocationUpsellDialogFinishedListener {
    public FbLocationStatusUtil f11378a;
    public QeAccessor f11379b;
    public GooglePlayServicesLocationUpsellDialogController f11380c;
    public LocationSendingMainFragment f11381d;

    /* compiled from: mPaymentCards */
    /* synthetic */ class C12561 {
        static final /* synthetic */ int[] f11377a = new int[GoogleLocationDialogResult.values().length];

        static {
            try {
                f11377a[GoogleLocationDialogResult.DIALOG_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f11377a[GoogleLocationDialogResult.DIALOG_NOT_NEEDED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f11377a[GoogleLocationDialogResult.DIALOG_CANCEL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f11377a[GoogleLocationDialogResult.DIALOG_NOT_POSSIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f11377a[GoogleLocationDialogResult.UNKNOWN_FAILURE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    @Inject
    public LocationGmsLsUpsellController(FbLocationStatusUtil fbLocationStatusUtil, QeAccessor qeAccessor) {
        this.f11378a = fbLocationStatusUtil;
        this.f11379b = qeAccessor;
    }

    public final void m11966a(GoogleLocationDialogResult googleLocationDialogResult) {
        switch (C12561.f11377a[googleLocationDialogResult.ordinal()]) {
            case 1:
            case 2:
                LocationSendingMainFragment locationSendingMainFragment = this.f11381d;
                locationSendingMainFragment.f11410g.m12049a(true);
                if (locationSendingMainFragment.an != null) {
                    locationSendingMainFragment.an.m12100b();
                }
                return;
            default:
                return;
        }
    }
}
