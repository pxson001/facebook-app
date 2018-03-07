package com.facebook.structuredsurvey.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.structuredsurvey.items.SurveyItem.ItemType;

/* compiled from: discard */
public class SurveyDividerListItemView extends SurveyListItemView {
    public SurveyDividerListItemView(Context context) {
        super(context);
        m24949a();
    }

    public SurveyDividerListItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24949a();
    }

    public static SurveyDividerListItemView m24948a(ViewGroup viewGroup) {
        SurveyDividerListItemView surveyDividerListItemView = (SurveyDividerListItemView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907333, viewGroup, false);
        surveyDividerListItemView.setTag(ItemType.DIVIDER);
        return surveyDividerListItemView;
    }

    private void m24949a() {
        setContentView(2130907332);
    }
}
