package com.facebook.negativefeedback.ui;

import android.content.Context;
import com.facebook.negativefeedback.protocol.NegativeFeedbackQueryInterfaces.NegativeFeedbackPromptQueryFragment.Responses;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: notable_liked_comments */
public class NegativeFeedbackErrorView extends CustomLinearLayout implements NegativeFeedbackDialogContent<Responses> {
    public FbTextView f8069a = ((FbTextView) a(2131564175));
    public FbTextView f8070b = ((FbTextView) a(2131564176));

    /* compiled from: notable_liked_comments */
    public enum ErrorType {
        NETWORK_ERROR,
        DATA_ERROR
    }

    public NegativeFeedbackErrorView(Context context) {
        super(context);
        NegativeFeedbackDialogContentHelper.m9722a(this);
        setContentView(2130905415);
    }

    public void setProgressBarVisibility(boolean z) {
    }
}
