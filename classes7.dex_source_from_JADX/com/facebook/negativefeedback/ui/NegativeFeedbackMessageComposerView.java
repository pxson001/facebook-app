package com.facebook.negativefeedback.ui;

import android.content.Context;
import android.widget.LinearLayout;
import com.facebook.negativefeedback.protocol.NegativeFeedbackQueryInterfaces.NegativeFeedbackPromptQueryFragment.Responses;
import com.facebook.negativefeedback.ui.messagecomposer.MessageRecipientAutoCompleteTextView;
import com.facebook.resources.ui.FbEditText;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: non_admin_share_photo */
public class NegativeFeedbackMessageComposerView extends CustomLinearLayout implements NegativeFeedbackDialogContent<Responses> {
    public FbEditText f8094a = ((FbEditText) a(2131564187));
    public FbTextView f8095b = ((FbTextView) a(2131564185));
    public MessageRecipientAutoCompleteTextView f8096c = ((MessageRecipientAutoCompleteTextView) a(2131564186));
    public LinearLayout f8097d = ((LinearLayout) a(2131564184));

    public NegativeFeedbackMessageComposerView(Context context) {
        super(context);
        NegativeFeedbackDialogContentHelper.m9722a(this);
        setContentView(2130905419);
    }

    public String getMessageBody() {
        if (this.f8094a != null) {
            return this.f8094a.getText().toString();
        }
        return "";
    }

    public void setProgressBarVisibility(boolean z) {
    }
}
