package com.facebook.structuredsurvey.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.resources.ui.FbTextView;
import com.facebook.structuredsurvey.items.SurveyItem;
import com.facebook.structuredsurvey.items.SurveyItem.ItemType;
import com.facebook.structuredsurvey.items.SurveyMessageItem;

/* compiled from: disambiguation_multiple_posts_per_module */
public class SurveyMessageListItemView extends SurveyListItemView {
    private FbTextView f17209b;

    public SurveyMessageListItemView(Context context) {
        super(context);
        m24959a();
    }

    public SurveyMessageListItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24959a();
    }

    public static SurveyMessageListItemView m24958a(ViewGroup viewGroup) {
        SurveyMessageListItemView surveyMessageListItemView = (SurveyMessageListItemView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907341, viewGroup, false);
        surveyMessageListItemView.setTag(ItemType.MESSAGE);
        return surveyMessageListItemView;
    }

    private void m24959a() {
        setContentView(2130907340);
        this.f17209b = (FbTextView) findViewById(2131567790);
    }

    public final void mo1296a(SurveyItem surveyItem) {
        this.f17209b.setText(((SurveyMessageItem) surveyItem).f17172c);
    }
}
