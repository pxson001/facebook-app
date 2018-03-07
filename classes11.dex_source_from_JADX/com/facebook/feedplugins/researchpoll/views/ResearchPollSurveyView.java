package com.facebook.feedplugins.researchpoll.views;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.annotations.VisibleForTesting;

/* compiled from: bytecode_cache_drops */
public class ResearchPollSurveyView extends CustomLinearLayout {
    @VisibleForTesting
    public LinearLayout f9145a = ((LinearLayout) a(2131566965));
    public View f9146b = a(2131566957);
    public TextView f9147c = ((TextView) a(2131566960));
    public TextView f9148d = ((TextView) a(2131566961));
    public TextView f9149e = ((TextView) a(2131566964));
    public TextView f9150f = ((TextView) a(2131566966));
    public View f9151g = a(2131566967);
    public TextView f9152h = ((TextView) a(2131566968));
    public ResearchPollQuestionView f9153i = ((ResearchPollQuestionView) a(2131566963));

    public ResearchPollSurveyView(Context context) {
        super(context);
        setContentView(2130906829);
    }

    public void setCallToActionViewListener(OnClickListener onClickListener) {
        this.f9146b.setOnClickListener(onClickListener);
    }

    public void setVoteButtonListener(OnClickListener onClickListener) {
        this.f9145a.setOnClickListener(onClickListener);
    }

    public void setVoteButtonActive(boolean z) {
        this.f9145a.setVisibility(z ? 0 : 8);
    }

    public final void m9828a() {
        this.f9153i.setVisibility(8);
        this.f9149e.setVisibility(8);
        this.f9145a.setVisibility(8);
        this.f9151g.setVisibility(0);
    }

    public void setOnAnswerClickListener(OnClickListener onClickListener) {
        this.f9153i.setOnAnswerClickListener(onClickListener);
    }

    public void setQuestionHint(String str) {
        this.f9153i.setQuestionHint(str);
    }

    public void setVoteButtonEnabled(boolean z) {
        this.f9145a.setEnabled(z);
        this.f9145a.setAlpha(z ? 1.0f : 0.5f);
    }
}
