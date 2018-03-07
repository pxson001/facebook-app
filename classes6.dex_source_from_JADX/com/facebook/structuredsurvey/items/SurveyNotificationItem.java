package com.facebook.structuredsurvey.items;

import com.facebook.structuredsurvey.items.SurveyItem.ItemType;
import com.facebook.structuredsurvey.util.SurveyNotificationWrapper;

/* compiled from: displayUri */
public class SurveyNotificationItem extends SurveyItem {
    public SurveyNotificationWrapper f17173c;

    public SurveyNotificationItem(SurveyNotificationWrapper surveyNotificationWrapper) {
        super(ItemType.NOTIFICATION, "");
        this.f17173c = surveyNotificationWrapper;
    }
}
