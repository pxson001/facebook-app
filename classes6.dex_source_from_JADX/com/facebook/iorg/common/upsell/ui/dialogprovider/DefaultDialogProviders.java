package com.facebook.iorg.common.upsell.ui.dialogprovider;

import android.support.v4.app.DialogFragment;
import com.facebook.iorg.common.upsell.model.PromoDataModel;
import com.facebook.iorg.common.upsell.ui.UpsellDialogFragment;
import com.facebook.iorg.common.upsell.ui.UpsellDialogFragment.Screen;
import com.facebook.iorg.common.zero.constants.ZeroDialogState;
import com.facebook.iorg.common.zero.ui.ZeroDialogController.DialogData;
import com.facebook.zero.sdk.common.ZeroFeatureKey;

/* compiled from: loiteringTimeMillis */
public class DefaultDialogProviders {

    /* compiled from: loiteringTimeMillis */
    public class DefaultDataControlWithoutUpsellDialogProvider implements ZeroDialogProvider {
        public final DialogFragment mo1071a(DialogData dialogData, Object obj, ZeroFeatureKey zeroFeatureKey) {
            PromoDataModel promoDataModel = new PromoDataModel();
            promoDataModel.f11245b = dialogData.b;
            promoDataModel.f11247d = dialogData.c;
            return UpsellDialogFragment.m18159a(zeroFeatureKey, promoDataModel, Screen.VPN_CALL_TO_HANDLE, 0, obj, ZeroDialogState.DATA_CONTROL_WITHOUT_UPSELL);
        }
    }

    /* compiled from: loiteringTimeMillis */
    public class DefaultUpsellWithDataControlDialogProvider implements ZeroDialogProvider {
        public final DialogFragment mo1071a(DialogData dialogData, Object obj, ZeroFeatureKey zeroFeatureKey) {
            PromoDataModel promoDataModel = new PromoDataModel();
            promoDataModel.f11245b = dialogData.b;
            promoDataModel.f11247d = dialogData.c;
            return UpsellDialogFragment.m18159a(zeroFeatureKey, promoDataModel, Screen.VPN_CALL_TO_HANDLE, 0, obj, ZeroDialogState.UPSELL_WITH_DATA_CONTROL);
        }
    }

    /* compiled from: loiteringTimeMillis */
    public class DefaultUpsellWithoutDataControlDialogProvider implements ZeroDialogProvider {
        public final DialogFragment mo1071a(DialogData dialogData, Object obj, ZeroFeatureKey zeroFeatureKey) {
            PromoDataModel promoDataModel = new PromoDataModel();
            promoDataModel.f11245b = dialogData.b;
            promoDataModel.f11247d = dialogData.c;
            return UpsellDialogFragment.m18159a(zeroFeatureKey, promoDataModel, Screen.FETCH_UPSELL, 0, obj, ZeroDialogState.UPSELL_WITHOUT_DATA_CONTROL);
        }
    }
}
