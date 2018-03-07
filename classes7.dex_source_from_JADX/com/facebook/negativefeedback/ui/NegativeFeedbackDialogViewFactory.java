package com.facebook.negativefeedback.ui;

import android.content.Context;

/* compiled from: notif_ids */
public class NegativeFeedbackDialogViewFactory {
    public static NegativeFeedbackDialogContent m9751a(NegativeFeedbackDialogViewType negativeFeedbackDialogViewType, Context context) {
        switch (negativeFeedbackDialogViewType) {
            case FLOW_RESPONSES:
                return new NegativeFeedbackResponsesView(context);
            case GUIDED_ACTIONS:
                return new NegativeFeedbackGuidedActionsView(context);
            case MESSAGE_COMPOSER:
                return new NegativeFeedbackMessageComposerView(context);
            case ERROR:
                return new NegativeFeedbackErrorView(context);
            default:
                throw new RuntimeException("Invalid flow state");
        }
    }
}
