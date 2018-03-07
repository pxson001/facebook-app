package com.facebook.iorg.common.upsell.ui;

import com.facebook.iorg.common.zero.constants.ZeroDialogFailureReason;
import com.facebook.iorg.common.zero.constants.ZeroDialogState;
import com.facebook.iorg.common.zero.eventbus.events.ZeroDialogActionEvent.ActionType;
import com.facebook.iorg.common.zero.ui.ZeroDialogController.DialogToShow;

/* compiled from: mBannerText */
/* synthetic */ class FbZeroDialogController$1 {
    static final /* synthetic */ int[] f11348a = new int[ActionType.values().length];
    static final /* synthetic */ int[] f11349b = new int[ZeroDialogFailureReason.values().length];
    static final /* synthetic */ int[] f11350c = new int[ZeroDialogState.values().length];
    static final /* synthetic */ int[] f11351d = new int[DialogToShow.values().length];

    static {
        try {
            f11351d[DialogToShow.SPINNER.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f11351d[DialogToShow.DATA_CONTROL_WITHOUT_UPSELL.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f11351d[DialogToShow.DEFAULT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f11350c[ZeroDialogState.UPSELL_WITH_DATA_CONTROL.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f11350c[ZeroDialogState.UPSELL_WITHOUT_DATA_CONTROL.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f11350c[ZeroDialogState.DATA_CONTROL_WITHOUT_UPSELL.ordinal()] = 3;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f11350c[ZeroDialogState.NO_DATA_CONTROL_NO_UPSELL.ordinal()] = 4;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f11349b[ZeroDialogFailureReason.DATA_CONTROL_FAILURE.ordinal()] = 1;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f11349b[ZeroDialogFailureReason.UPSELL_FAILURE.ordinal()] = 2;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f11348a[ActionType.CONFIRM.ordinal()] = 1;
        } catch (NoSuchFieldError e10) {
        }
        try {
            f11348a[ActionType.CANCEL.ordinal()] = 2;
        } catch (NoSuchFieldError e11) {
        }
        try {
            f11348a[ActionType.FAILURE.ordinal()] = 3;
        } catch (NoSuchFieldError e12) {
        }
    }
}
