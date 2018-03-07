package com.facebook.feedplugins.survey;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.facebook.graphql.model.GraphQLStructuredSurveyResponseOption;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: anniversary_video_state */
public class SurveyFeedUnitView extends CustomLinearLayout {
    public final TextView f9879a;
    public final LinearLayout f9880b;
    private final TextView f9881c;

    public SurveyFeedUnitView(Context context) {
        this(context, null);
    }

    private SurveyFeedUnitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130907336);
        this.f9879a = (TextView) a(2131567778);
        this.f9880b = (LinearLayout) a(2131567779);
        this.f9881c = (TextView) a(2131567780);
    }

    public void setAnswerClickListener(OnClickListener onClickListener) {
        int childCount = this.f9880b.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((RadioButton) this.f9880b.getChildAt(i)).setOnClickListener(onClickListener);
        }
    }

    public void setQuestionActive(boolean z) {
        int i;
        int i2 = 0;
        TextView textView = this.f9879a;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        LinearLayout linearLayout = this.f9880b;
        if (!z) {
            i2 = 8;
        }
        linearLayout.setVisibility(i2);
    }

    public void setCompleteLayoutActive(boolean z) {
        this.f9881c.setVisibility(z ? 0 : 8);
    }

    public final void m10256a(int i, GraphQLStructuredSurveyResponseOption graphQLStructuredSurveyResponseOption, String str) {
        RadioButton radioButton = (RadioButton) this.f9880b.getChildAt(i);
        if (graphQLStructuredSurveyResponseOption == null) {
            radioButton.setVisibility(8);
            return;
        }
        radioButton.setText(graphQLStructuredSurveyResponseOption.j().a());
        radioButton.setTag(2131558533, graphQLStructuredSurveyResponseOption.k());
        radioButton.setTag(2131558532, str);
        radioButton.setVisibility(0);
        radioButton.setChecked(false);
    }
}
