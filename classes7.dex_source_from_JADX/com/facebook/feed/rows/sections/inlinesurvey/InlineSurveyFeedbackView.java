package com.facebook.feed.rows.sections.inlinesurvey;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;

/* compiled from: Unable to execute operation  */
public class InlineSurveyFeedbackView extends SegmentedLinearLayout {
    public InlineSurveyFeedbackView(Context context) {
        this(context, null);
    }

    private InlineSurveyFeedbackView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        setSegmentedDivider(new ColorDrawable(getResources().getColor(2131361986)));
        setSegmentedDividerThickness(1);
        setShowSegmentedDividers(1);
        setContentView(2130904918);
    }
}
