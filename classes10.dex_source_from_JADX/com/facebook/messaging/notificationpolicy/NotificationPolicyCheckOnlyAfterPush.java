package com.facebook.messaging.notificationpolicy;

import com.facebook.analytics.CounterLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.Clock;
import com.facebook.messaging.model.threads.NotificationSetting;
import com.facebook.messaging.notificationpolicy.NotificationPolicyCheck.CheckResult;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import java.util.Iterator;
import java.util.LinkedHashMap;
import javax.inject.Inject;

/* compiled from: result_mutation_method */
public class NotificationPolicyCheckOnlyAfterPush implements NotificationPolicyCheck, NotificationPolicyPushCheck {
    private final AnalyticsLogger f3397a;
    private final Clock f3398b;
    private final CounterLogger f3399c;
    private final QeAccessor f3400d;
    private final LinkedHashMap<String, Long> f3401e = new LinkedHashMap();
    private final LinkedHashMap<String, Long> f3402f = new LinkedHashMap();

    @Inject
    public NotificationPolicyCheckOnlyAfterPush(AnalyticsLogger analyticsLogger, Clock clock, CounterLogger counterLogger, QeAccessor qeAccessor) {
        this.f3397a = analyticsLogger;
        this.f3398b = clock;
        this.f3399c = counterLogger;
        this.f3400d = qeAccessor;
    }

    public final boolean mo114a() {
        return this.f3400d.a(Liveness.Live, ExperimentsForNotificationPolicyModule.f3372b, false);
    }

    public final CheckResult mo111a(long j, String str, NotificationSetting notificationSetting) {
        long longValue;
        CheckResult checkResult;
        if (this.f3401e.containsKey(str)) {
            longValue = ((Long) this.f3401e.get(str)).longValue();
            checkResult = CheckResult.PASS;
        } else if (this.f3402f.containsKey(str)) {
            longValue = ((Long) this.f3402f.get(str)).longValue();
            checkResult = CheckResult.FAIL;
        } else {
            this.f3399c.a("android_messenger_cpe_delta_first");
            return CheckResult.FAIL;
        }
        this.f3399c.a("android_messenger_cpe_push_first");
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("cpe_delta_info");
        honeyClientEvent.a("delay_since_push_ms", this.f3398b.a() - longValue);
        this.f3397a.a(honeyClientEvent);
        return checkResult;
    }

    public final synchronized void mo117a(String str, boolean z) {
        LinkedHashMap linkedHashMap = z ? this.f3401e : this.f3402f;
        m3298a(linkedHashMap);
        linkedHashMap.put(str, Long.valueOf(this.f3398b.a()));
    }

    private static void m3298a(LinkedHashMap<String, Long> linkedHashMap) {
        if (linkedHashMap.size() >= 100) {
            Iterator it = linkedHashMap.keySet().iterator();
            it.next();
            it.remove();
        }
    }
}
