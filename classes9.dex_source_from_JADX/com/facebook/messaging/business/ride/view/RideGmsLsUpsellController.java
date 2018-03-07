package com.facebook.messaging.business.ride.view;

import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController.GoogleLocationDialogResult;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController.OnGooglePlayServicesLocationUpsellDialogFinishedListener;
import javax.inject.Inject;

/* compiled from: mn_platform_msg_request_imp */
public class RideGmsLsUpsellController implements OnGooglePlayServicesLocationUpsellDialogFinishedListener {
    public FbLocationStatusUtil f9324a;
    public RideRequestFragment f9325b;

    /* compiled from: mn_platform_msg_request_imp */
    /* synthetic */ class C10751 {
        static final /* synthetic */ int[] f9323a = new int[GoogleLocationDialogResult.values().length];

        static {
            try {
                f9323a[GoogleLocationDialogResult.DIALOG_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9323a[GoogleLocationDialogResult.DIALOG_NOT_NEEDED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f9323a[GoogleLocationDialogResult.DIALOG_CANCEL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f9323a[GoogleLocationDialogResult.DIALOG_NOT_POSSIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f9323a[GoogleLocationDialogResult.UNKNOWN_FAILURE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static RideGmsLsUpsellController m9774b(InjectorLike injectorLike) {
        return new RideGmsLsUpsellController(FbLocationStatusUtil.a(injectorLike));
    }

    @Inject
    public RideGmsLsUpsellController(FbLocationStatusUtil fbLocationStatusUtil) {
        this.f9324a = fbLocationStatusUtil;
    }

    public final void m9775a(GoogleLocationDialogResult googleLocationDialogResult) {
        switch (C10751.f9323a[googleLocationDialogResult.ordinal()]) {
            case 1:
            case 2:
                this.f9325b.m9864b();
                return;
            default:
                return;
        }
    }
}
