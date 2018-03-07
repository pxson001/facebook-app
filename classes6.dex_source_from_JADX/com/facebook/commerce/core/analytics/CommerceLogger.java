package com.facebook.commerce.core.analytics;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceAnalyticsKey;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceEvent;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceModule;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceRefType;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.Assisted;
import java.util.ArrayList;
import java.util.HashMap;
import javax.inject.Inject;
import org.json.JSONArray;

/* compiled from: privacyJson */
public class CommerceLogger {
    private CommerceEvent f7436a;
    private CommerceModule f7437b;
    private Boolean f7438c;
    public String f7439d;
    public Long f7440e;
    public Long f7441f;
    public Long f7442g;
    public int f7443h;
    public String f7444i;
    public String f7445j;
    public String f7446k;
    public String f7447l;
    public ArrayList<HashMap<String, Object>> f7448m = new ArrayList();
    private AnalyticsLogger f7449n;
    public MonotonicClock f7450o;

    @Inject
    public CommerceLogger(MonotonicClock monotonicClock, AnalyticsLogger analyticsLogger, @Assisted CommerceEvent commerceEvent, @Assisted CommerceModule commerceModule, @Assisted CommerceRefType commerceRefType, @Assisted Long l) {
        this.f7449n = analyticsLogger;
        this.f7450o = monotonicClock;
        this.f7436a = commerceEvent;
        this.f7437b = commerceModule;
        this.f7443h = CommerceAnalytics.m10500a(commerceRefType);
        this.f7444i = String.valueOf(l);
        this.f7440e = Long.valueOf(this.f7450o.now());
        this.f7438c = Boolean.valueOf(false);
        m10505a();
    }

    public final void m10505a() {
        if (!this.f7438c.booleanValue()) {
            this.f7438c = Boolean.valueOf(true);
            this.f7439d = SafeUUIDGenerator.a().toString();
            this.f7448m.clear();
            this.f7441f = Long.valueOf(this.f7450o.now());
        }
    }

    public final void m10506b() {
        if (this.f7438c.booleanValue()) {
            this.f7438c = Boolean.valueOf(false);
            this.f7442g = Long.valueOf(this.f7450o.now());
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent(this.f7436a.value);
            honeyClientEvent.c = this.f7437b.value;
            honeyClientEvent = honeyClientEvent;
            honeyClientEvent.b(CommerceAnalyticsKey.SESSION_ID.value, this.f7439d.toString());
            honeyClientEvent.a(CommerceAnalyticsKey.LOGGER_CREATION_TIME.value, this.f7440e);
            honeyClientEvent.a(CommerceAnalyticsKey.LOGGING_START_TIME.value, this.f7441f);
            honeyClientEvent.a(CommerceAnalyticsKey.LOGGING_STOP_TIME.value, this.f7442g);
            honeyClientEvent.b(CommerceAnalyticsKey.EVENTS.value, new JSONArray(this.f7448m).toString());
            if (this.f7443h != CommerceAnalytics.m10500a(CommerceRefType.UNKNOWN)) {
                honeyClientEvent.a(CommerceAnalyticsKey.REF_TYPE.value, this.f7443h);
                honeyClientEvent.b(CommerceAnalyticsKey.REF_ID.value, this.f7444i);
            }
            if (!StringUtil.a(this.f7445j)) {
                honeyClientEvent.b(CommerceAnalyticsKey.PAGE_ID.value, this.f7445j);
            }
            if (!StringUtil.a(this.f7446k)) {
                honeyClientEvent.b(CommerceAnalyticsKey.COLLECTION_ID.value, this.f7446k);
            }
            if (!StringUtil.a(this.f7447l)) {
                honeyClientEvent.b(CommerceAnalyticsKey.PRODUCT_ID.value, this.f7447l);
            }
            this.f7449n.a(honeyClientEvent);
        }
    }
}
