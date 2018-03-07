package com.facebook.quickpromotion.logger;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CounterLogger;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.hardware.SystemBatteryStateManager;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.quickpromotion.filter.QuickPromotionCounters;
import com.facebook.quickpromotion.filter.QuickPromotionCounters.CounterType;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Action;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: reaction_type */
public class QuickPromotionLogger {
    private final AnalyticsLogger f8017a;
    private final QuickPromotionCounters f8018b;
    private final InterstitialManager f8019c;
    private final DeviceConditionHelper f8020d;
    private final SystemBatteryStateManager f8021e;
    private final FbNetworkManager f8022f;
    private final ObjectMapper f8023g;
    public final CounterLogger f8024h;

    public static QuickPromotionLogger m12600b(InjectorLike injectorLike) {
        return new QuickPromotionLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), QuickPromotionCounters.m12575a(injectorLike), InterstitialManager.m8082a(injectorLike), DeviceConditionHelper.m5526a(injectorLike), SystemBatteryStateManager.m11461a(injectorLike), FbNetworkManager.m3811a(injectorLike), FbObjectMapperMethodAutoProvider.m6609a(injectorLike), CounterLogger.m12608a(injectorLike));
    }

    public static void m12598a(HoneyClientEvent honeyClientEvent, String str) {
        honeyClientEvent.m5090b("promotion_id", str);
    }

    private static void m12596a(HoneyClientEvent honeyClientEvent) {
        honeyClientEvent.f3099c = "quick_promotion";
    }

    @Inject
    public QuickPromotionLogger(AnalyticsLogger analyticsLogger, QuickPromotionCounters quickPromotionCounters, InterstitialManager interstitialManager, DeviceConditionHelper deviceConditionHelper, SystemBatteryStateManager systemBatteryStateManager, FbNetworkManager fbNetworkManager, ObjectMapper objectMapper, CounterLogger counterLogger) {
        this.f8017a = analyticsLogger;
        this.f8018b = quickPromotionCounters;
        this.f8019c = interstitialManager;
        this.f8020d = deviceConditionHelper;
        this.f8021e = systemBatteryStateManager;
        this.f8022f = fbNetworkManager;
        this.f8023g = objectMapper;
        this.f8024h = counterLogger;
    }

    public final void m12603a(Action action, ActionType actionType, QuickPromotionDefinition quickPromotionDefinition, String str) {
        Preconditions.checkNotNull(actionType);
        switch (1.a[actionType.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                this.f8019c.m8121a().b(str);
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                this.f8019c.m8121a().c(str);
                break;
            case 3:
                this.f8019c.m8121a().d(str);
                break;
        }
        m12599a(action, actionType, quickPromotionDefinition);
    }

    public final void m12602a(ActionType actionType, String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("click");
        m12596a(honeyClientEvent);
        m12598a(honeyClientEvent, str);
        honeyClientEvent.m5090b("object_id", actionType.toAnalyticEventName());
        this.f8017a.mo533c(honeyClientEvent);
    }

    public final void m12604a(QuickPromotionDefinition quickPromotionDefinition) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("qp_holdout_exposure");
        m12596a(honeyClientEvent);
        m12597a(honeyClientEvent, quickPromotionDefinition);
        m12601b(honeyClientEvent);
        this.f8017a.mo533c(honeyClientEvent);
    }

    public final void m12607b(QuickPromotionDefinition quickPromotionDefinition) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("qp_exposure");
        m12596a(honeyClientEvent);
        m12597a(honeyClientEvent, quickPromotionDefinition);
        m12601b(honeyClientEvent);
        this.f8017a.mo533c(honeyClientEvent);
    }

    public final void m12605a(QuickPromotionDefinition quickPromotionDefinition, @Nullable LayoutInfo layoutInfo) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("view");
        m12596a(honeyClientEvent);
        m12597a(honeyClientEvent, quickPromotionDefinition);
        m12601b(honeyClientEvent);
        if (layoutInfo != null) {
            if (layoutInfo.a != null) {
                honeyClientEvent.m5090b("title_truncated", layoutInfo.a);
            }
            if (layoutInfo.b != null) {
                honeyClientEvent.m5090b("content_truncated", layoutInfo.b);
            }
            if (layoutInfo.c != null) {
                honeyClientEvent.m5090b("primary_action_truncated", layoutInfo.c);
            }
            if (layoutInfo.d != null) {
                honeyClientEvent.m5090b("secondary_action_truncated", layoutInfo.d);
            }
            if (layoutInfo.e != null) {
                honeyClientEvent.m5090b("social_context_truncated", layoutInfo.e);
            }
        }
        this.f8017a.mo533c(honeyClientEvent);
    }

    public final void m12606a(QuickPromotionDefinition quickPromotionDefinition, String str) {
        if (quickPromotionDefinition.logEligibilityWaterfall) {
            HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("qp_eligibility_waterfall");
            m12596a((HoneyClientEvent) honeyClientEvent);
            m12598a((HoneyClientEvent) honeyClientEvent, quickPromotionDefinition.promotionId);
            honeyClientEvent.m5090b("step", str);
            this.f8017a.mo526a(honeyClientEvent);
        }
    }

    private void m12599a(Action action, ActionType actionType, QuickPromotionDefinition quickPromotionDefinition) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("click");
        m12596a(honeyClientEvent);
        honeyClientEvent.m5090b("object_id", actionType.toAnalyticEventName());
        m12597a(honeyClientEvent, quickPromotionDefinition);
        if (action != null) {
            honeyClientEvent.m5090b("action_url", action.url);
        }
        m12601b(honeyClientEvent);
        this.f8017a.mo533c(honeyClientEvent);
    }

    private void m12597a(HoneyClientEvent honeyClientEvent, QuickPromotionDefinition quickPromotionDefinition) {
        m12598a(honeyClientEvent, quickPromotionDefinition.promotionId);
        honeyClientEvent.m5083a("impression_count", this.f8018b.m12580c(quickPromotionDefinition, CounterType.IMPRESSION));
        honeyClientEvent.m5084a("last_impression_timestamp", this.f8018b.m12581d(quickPromotionDefinition, CounterType.IMPRESSION));
        if (quickPromotionDefinition.instanceLogData != null && !quickPromotionDefinition.instanceLogData.isEmpty()) {
            JsonNode e = this.f8023g.m6668e();
            Iterator it = quickPromotionDefinition.instanceLogData.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                e.m5137a((String) entry.getKey(), (String) entry.getValue());
            }
            honeyClientEvent.m5085a("instance_log_data", e);
        }
    }

    private void m12601b(HoneyClientEvent honeyClientEvent) {
        NetworkStatus networkStatus;
        honeyClientEvent.m5082a("battery_percentage", (double) (this.f8021e.m11465a() * 100.0f));
        honeyClientEvent.m5090b("charging_state", this.f8021e.m11468b().name());
        Calendar instance = Calendar.getInstance();
        long timeInMillis = instance.getTimeInMillis();
        instance.set(14, 0);
        instance.set(13, 0);
        instance.set(12, 0);
        instance.set(11, 0);
        honeyClientEvent.m5084a("seconds_from_midnight", (timeInMillis - instance.getTimeInMillis()) / 1000);
        if (this.f8020d.m5534b()) {
            networkStatus = NetworkStatus.WIFI;
        } else if (this.f8022f.m3828d()) {
            networkStatus = NetworkStatus.CELLULAR;
        } else {
            networkStatus = NetworkStatus.NOT_CONNECTED;
        }
        honeyClientEvent.m5090b("connection", networkStatus.name());
    }
}
