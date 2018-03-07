package com.facebook.structuredsurvey.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.common.util.StringUtil;
import com.facebook.structuredsurvey.items.SurveyItem;
import com.facebook.structuredsurvey.items.SurveyItem.ItemType;
import com.facebook.structuredsurvey.items.SurveyQuestionItem;
import com.facebook.widget.text.BetterTextView;

/* compiled from: disable_photos */
public class SurveyQuestionListItemView extends SurveyListItemView {
    private BetterTextView f17227b;
    private BetterTextView f17228c;
    private BetterTextView f17229d;

    public SurveyQuestionListItemView(Context context) {
        super(context);
        m24972a();
    }

    public SurveyQuestionListItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24972a();
    }

    public static SurveyQuestionListItemView m24971a(ViewGroup viewGroup) {
        SurveyQuestionListItemView surveyQuestionListItemView = (SurveyQuestionListItemView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907346, viewGroup, false);
        surveyQuestionListItemView.setTag(ItemType.QUESTION);
        return surveyQuestionListItemView;
    }

    private void m24972a() {
        setContentView(2130907345);
        this.f17227b = (BetterTextView) findViewById(2131567794);
        this.f17228c = (BetterTextView) findViewById(2131567778);
        this.f17229d = (BetterTextView) findViewById(2131567795);
    }

    public final void mo1296a(SurveyItem surveyItem) {
        SurveyQuestionItem surveyQuestionItem = (SurveyQuestionItem) surveyItem;
        if (StringUtil.a(surveyQuestionItem.f17174c)) {
            this.f17227b.setVisibility(8);
        } else {
            this.f17227b.setText(surveyQuestionItem.f17174c);
        }
        this.f17228c.setText(surveyQuestionItem.f17175d);
        if (StringUtil.a(surveyQuestionItem.f17176e)) {
            this.f17229d.setVisibility(8);
            return;
        }
        this.f17229d.setVisibility(0);
        this.f17229d.setText(surveyQuestionItem.f17176e);
    }
}
