package com.facebook.places.checkin.ui;

import android.app.Activity;
import android.view.View;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.GlobalFbBroadcastManager;
import com.facebook.content.AppInfo;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController;
import com.facebook.places.checkin.PlacePickerFragment;
import com.facebook.places.checkin.analytics.PlacePickerAnalytics;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.ui.toaster.Toaster;

/* compiled from: check_deeplink_box */
public class CheckinNiemControllerProvider extends AbstractAssistedProvider<CheckinNiemController> {
    public final CheckinNiemController m22063a(View view, Activity activity, PlacePickerFragment placePickerFragment, GooglePlayServicesLocationUpsellDialogController googlePlayServicesLocationUpsellDialogController) {
        return new CheckinNiemController(view, activity, placePickerFragment, googlePlayServicesLocationUpsellDialogController, (QeAccessor) QeInternalImplMethodAutoProvider.a(this), PlacePickerAnalytics.a(this), FbLocationStatusUtil.a(this), (BaseFbBroadcastManager) GlobalFbBroadcastManager.a(this), RuntimePermissionsUtil.a(this), (ActivityRuntimePermissionsManagerProvider) getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), AppInfo.a(this), Toaster.a(this), (SecureContextHelper) DefaultSecureContextHelper.a(this), FunnelLoggerImpl.a(this), (CheckinNiemMegaphoneImplProvider) getOnDemandAssistedProviderForStaticDi(CheckinNiemMegaphoneImplProvider.class), (CheckinNiemAlertViewImplProvider) getOnDemandAssistedProviderForStaticDi(CheckinNiemAlertViewImplProvider.class));
    }
}
