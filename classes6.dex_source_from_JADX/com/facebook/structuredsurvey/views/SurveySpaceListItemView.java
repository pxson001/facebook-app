package com.facebook.structuredsurvey.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.structuredsurvey.items.SurveyItem;
import com.facebook.structuredsurvey.items.SurveyItem.ItemType;
import com.facebook.structuredsurvey.items.SurveySpaceItem;

/* compiled from: disable_mentions */
public class SurveySpaceListItemView extends SurveyListItemView {
    private View f17233b;

    public SurveySpaceListItemView(Context context) {
        super(context);
        m24980a();
    }

    public SurveySpaceListItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24980a();
    }

    public static SurveySpaceListItemView m24979a(ViewGroup viewGroup) {
        SurveySpaceListItemView surveySpaceListItemView = (SurveySpaceListItemView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907351, viewGroup, false);
        surveySpaceListItemView.setTag(ItemType.WHITESPACE);
        return surveySpaceListItemView;
    }

    private void m24980a() {
        setContentView(2130907350);
        this.f17233b = findViewById(2131567798);
    }

    public final void mo1296a(SurveyItem surveyItem) {
        SurveySpaceItem surveySpaceItem = (SurveySpaceItem) surveyItem;
        LayoutParams layoutParams = (LayoutParams) this.f17233b.getLayoutParams();
        float f = (float) surveySpaceItem.f17179c;
        layoutParams.height = Math.round(getContext().getResources().getDisplayMetrics().density * f);
        this.f17233b.setLayoutParams(layoutParams);
    }
}
