package com.facebook.structuredsurvey.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.structuredsurvey.items.SurveyItem;
import com.facebook.structuredsurvey.items.SurveyItem.ItemType;
import com.facebook.structuredsurvey.items.SurveyNotificationItem;
import com.facebook.structuredsurvey.util.SurveyNotificationWrapper;

/* compiled from: disambiguation_hide_low_quality_entity_modules */
public class SurveyNotificationListItemView extends SurveyListItemView {
    SurveyNotificationsView f17210b;

    public SurveyNotificationListItemView(Context context) {
        super(context);
        m24962a();
    }

    public SurveyNotificationListItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24962a();
    }

    public static SurveyNotificationListItemView m24961a(ViewGroup viewGroup) {
        SurveyNotificationListItemView surveyNotificationListItemView = (SurveyNotificationListItemView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907344, viewGroup, false);
        surveyNotificationListItemView.setTag(ItemType.NOTIFICATION);
        return surveyNotificationListItemView;
    }

    private void m24962a() {
        setContentView(2130907343);
        this.f17210b = (SurveyNotificationsView) findViewById(2131567793);
    }

    public final void mo1296a(SurveyItem surveyItem) {
        SurveyNotificationItem surveyNotificationItem = (SurveyNotificationItem) surveyItem;
        if (surveyNotificationItem != null && surveyNotificationItem.f17173c != null) {
            SurveyNotificationWrapper surveyNotificationWrapper = surveyNotificationItem.f17173c;
            this.f17210b.m24970a(surveyNotificationWrapper.f17196b, surveyNotificationWrapper.f17197c, surveyNotificationWrapper.f17195a, surveyNotificationWrapper.f17198d);
        }
    }
}
