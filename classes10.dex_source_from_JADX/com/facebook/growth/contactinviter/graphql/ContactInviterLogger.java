package com.facebook.growth.contactinviter.graphql;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: TDAO;)V */
public class ContactInviterLogger {
    public static String f23318a;
    public final Lazy<AnalyticsLogger> f23319b;

    /* compiled from: TDAO;)V */
    public enum ActionType {
        INVITE,
        UNDO,
        SMS
    }

    @Inject
    public ContactInviterLogger(Lazy<AnalyticsLogger> lazy) {
        this.f23319b = lazy;
    }
}
