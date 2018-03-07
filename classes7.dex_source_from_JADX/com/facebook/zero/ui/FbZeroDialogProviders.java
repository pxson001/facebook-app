package com.facebook.zero.ui;

import android.support.v4.app.DialogFragment;
import com.facebook.inject.InjectorLike;
import com.facebook.iorg.common.upsell.ui.dialogprovider.ZeroDialogProvider;
import com.facebook.iorg.common.zero.constants.ZeroDialogState;
import com.facebook.iorg.common.zero.ui.ZeroDialogController.DialogData;
import com.facebook.iorg.common.zero.ui.ZeroDialogFragment;
import com.facebook.zero.sdk.common.ZeroFeatureKey;

/* compiled from: weather_icon */
public class FbZeroDialogProviders {

    /* compiled from: weather_icon */
    public class NoDataControlNoUpsellDialogProvider implements ZeroDialogProvider {
        public static NoDataControlNoUpsellDialogProvider m248a(InjectorLike injectorLike) {
            return new NoDataControlNoUpsellDialogProvider();
        }

        public final DialogFragment m249a(DialogData dialogData, Object obj, ZeroFeatureKey zeroFeatureKey) {
            String str = dialogData.b;
            String str2 = dialogData.c;
            ZeroDialogState zeroDialogState = ZeroDialogState.NO_DATA_CONTROL_NO_UPSELL;
            ExtraChargesDialogFragment extraChargesDialogFragment = new ExtraChargesDialogFragment();
            extraChargesDialogFragment.g(ZeroDialogFragment.a(zeroFeatureKey, str, str2, obj, zeroDialogState, null));
            return extraChargesDialogFragment;
        }
    }
}
