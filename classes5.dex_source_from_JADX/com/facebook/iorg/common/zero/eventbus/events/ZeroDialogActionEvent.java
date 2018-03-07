package com.facebook.iorg.common.zero.eventbus.events;

import com.facebook.iorg.common.zero.constants.ZeroDialogFailureReason;
import com.facebook.iorg.common.zero.constants.ZeroDialogState;
import com.facebook.iorg.common.zero.eventbus.ZeroEvent;
import com.facebook.zero.sdk.common.ZeroFeatureKey;

/* compiled from: TOPICS_UPSELL_UNIT */
public class ZeroDialogActionEvent extends ZeroEvent {
    public final ZeroFeatureKey f13887a;
    public final ActionType f13888b;
    public final ZeroDialogState f13889c;
    public final ZeroDialogFailureReason f13890d;
    public final Object f13891e;

    /* compiled from: TOPICS_UPSELL_UNIT */
    public enum ActionType {
        CONFIRM,
        CANCEL,
        FAILURE
    }

    public ZeroDialogActionEvent(ZeroFeatureKey zeroFeatureKey, ActionType actionType, Object obj, ZeroDialogState zeroDialogState) {
        this(zeroFeatureKey, actionType, obj, zeroDialogState, ZeroDialogFailureReason.UNKNOWN);
    }

    public ZeroDialogActionEvent(ZeroFeatureKey zeroFeatureKey, ActionType actionType, Object obj, ZeroDialogState zeroDialogState, ZeroDialogFailureReason zeroDialogFailureReason) {
        this.f13887a = zeroFeatureKey;
        this.f13888b = actionType;
        this.f13891e = obj;
        this.f13889c = zeroDialogState;
        this.f13890d = zeroDialogFailureReason;
    }
}
