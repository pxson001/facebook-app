package com.facebook.places.checkin.ui;

import android.app.Activity;
import android.view.View;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.content.AppInfo;
import com.facebook.content.SecureContextHelper;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.inject.Assisted;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController;
import com.facebook.places.checkin.PlacePickerFragment;
import com.facebook.places.checkin.analytics.PlacePickerAnalytics;
import com.facebook.qe.api.QeAccessor;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.ui.toaster.Toaster;
import javax.inject.Inject;

/* compiled from: change_password_viewed */
public class CheckinNiemPerfTestController extends CheckinNiemController {
    @Inject
    public CheckinNiemPerfTestController(@Assisted View view, @Assisted Activity activity, @Assisted PlacePickerFragment placePickerFragment, @Assisted GooglePlayServicesLocationUpsellDialogController googlePlayServicesLocationUpsellDialogController, QeAccessor qeAccessor, PlacePickerAnalytics placePickerAnalytics, FbLocationStatusUtil fbLocationStatusUtil, BaseFbBroadcastManager baseFbBroadcastManager, RuntimePermissionsUtil runtimePermissionsUtil, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, AppInfo appInfo, Toaster toaster, SecureContextHelper secureContextHelper, FunnelLoggerImpl funnelLoggerImpl, CheckinNiemMegaphoneImplProvider checkinNiemMegaphoneImplProvider, CheckinNiemAlertViewImplProvider checkinNiemAlertViewImplProvider) {
        super(view, activity, placePickerFragment, googlePlayServicesLocationUpsellDialogController, qeAccessor, placePickerAnalytics, fbLocationStatusUtil, baseFbBroadcastManager, runtimePermissionsUtil, activityRuntimePermissionsManagerProvider, appInfo, toaster, secureContextHelper, funnelLoggerImpl, checkinNiemMegaphoneImplProvider, checkinNiemAlertViewImplProvider);
    }

    public final boolean mo1081i() {
        return false;
    }

    public final boolean mo1082j() {
        return true;
    }

    public final boolean mo1083k() {
        return true;
    }

    protected final boolean mo1084l() {
        return false;
    }

    protected final boolean mo1085n() {
        return true;
    }
}
