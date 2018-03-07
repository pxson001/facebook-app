package com.facebook.negativefeedback.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.facebook.negativefeedback.protocol.NegativeFeedbackQueryInterfaces.NegativeFeedbackPromptQueryFragment;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: node_token */
public class NegativeFeedbackResponsesView extends CustomLinearLayout implements NegativeFeedbackDialogContent<NegativeFeedbackPromptQueryFragment> {
    public ListView f8102a = ((ListView) a(2131564190));
    public FbTextView f8103b;
    public FrameLayout f8104c = ((FrameLayout) a(2131564189));
    public NegativeFeedbackResponseAdapter f8105d;

    /* compiled from: node_token */
    class C06501 implements Runnable {
        final /* synthetic */ NegativeFeedbackResponsesView f8101a;

        C06501(NegativeFeedbackResponsesView negativeFeedbackResponsesView) {
            this.f8101a = negativeFeedbackResponsesView;
        }

        public void run() {
            this.f8101a.f8104c.setVisibility(0);
            this.f8101a.f8102a.setVisibility(8);
        }
    }

    public NegativeFeedbackResponsesView(Context context) {
        super(context);
        NegativeFeedbackDialogContentHelper.m9722a(this);
        setContentView(2130905421);
        this.f8102a.addFooterView((LinearLayout) LayoutInflater.from(getContext()).inflate(2130903833, null), null, false);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(2130905422, null);
        this.f8102a.addHeaderView(linearLayout);
        this.f8103b = (FbTextView) linearLayout.findViewById(2131564174);
        this.f8105d = new NegativeFeedbackResponseAdapter(getContext(), 2131564188);
        this.f8102a.setAdapter(this.f8105d);
        this.f8102a.getViewTreeObserver().addOnGlobalLayoutListener(NegativeFeedbackDialogContentHelper.m9721a(this.f8102a, this));
    }

    public void setProgressBarVisibility(boolean z) {
        if (z) {
            this.f8104c.setMinimumHeight(this.f8102a.getHeight());
            postDelayed(new C06501(this), 100);
            return;
        }
        this.f8104c.setVisibility(8);
        this.f8102a.setVisibility(0);
    }
}
