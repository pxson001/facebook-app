package com.facebook.analytics;

import android.os.Handler;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.debug.log.BLog;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: group_invite_link */
public class PrefetchAnalytics {
    public static final String f21698a = PrefetchAnalytics.class.getSimpleName();
    public final AnalyticsLogger f21699b;
    private final BaseAnalyticsConfig f21700c;
    private final ConcurrentMap<String, Long> f21701d;
    public final String f21702e;
    public final String f21703f;
    private final Random f21704g;
    public final Map<ActionType, ConcurrentLinkedQueue<ObjectNode>> f21705h;
    public final AtomicBoolean f21706i;
    private final Handler f21707j;
    private final Runnable f21708k = new C08641(this);

    /* compiled from: group_invite_link */
    class C08641 implements Runnable {
        final /* synthetic */ PrefetchAnalytics f21709a;

        public void run() {
            String str = PrefetchAnalytics.f21698a;
            str = this.f21709a.f21702e;
            this.f21709a.f21706i.set(false);
            PrefetchAnalytics prefetchAnalytics = this.f21709a;
            for (Entry entry : prefetchAnalytics.f21705h.entrySet()) {
                if (!((ConcurrentLinkedQueue) entry.getValue()).isEmpty()) {
                    JsonNode arrayNode = new ArrayNode(JsonNodeFactory.f3121a);
                    int i = 0;
                    while (true) {
                        ObjectNode objectNode = (ObjectNode) ((ConcurrentLinkedQueue) entry.getValue()).poll();
                        if (objectNode == null) {
                            break;
                        }
                        int i2 = i + 1;
                        arrayNode.m13380a(i, objectNode);
                        i = i2;
                    }
                    HoneyClientEventFast a = prefetchAnalytics.f21699b.mo535a("prefetch_cache_efficiency", false);
                    if (a.m17388a()) {
                        a.m17385a("cache_name", prefetchAnalytics.f21702e);
                        a.m17385a("query_name", prefetchAnalytics.f21703f);
                        a.m17384a("action_type", entry.getKey());
                        a.m17383a("cache_entries", arrayNode);
                        a.m17390b();
                    }
                }
            }
        }

        C08641(PrefetchAnalytics prefetchAnalytics) {
            this.f21709a = prefetchAnalytics;
        }
    }

    /* compiled from: group_invite_link */
    enum ActionType {
        COULD_PREFETCH("could_prefetch"),
        PREFETCH_SUCCEEDED("prefetch_succeeded"),
        PREFETCH_FAILED("prefetch_failed"),
        CACHE_HIT("cache_hit"),
        CACHE_STALE_HIT("cache_stale_hit"),
        CACHE_MISS("cache_miss"),
        CACHE_MISS_PREFETCH_IN_FLIGHT("cache_miss_prefetch_in_flight");
        
        private final String mText;

        private ActionType(String str) {
            this.mText = str;
        }

        public final String toString() {
            return this.mText;
        }
    }

    @Inject
    public PrefetchAnalytics(AnalyticsLogger analyticsLogger, BaseAnalyticsConfig baseAnalyticsConfig, Handler handler, @Assisted String str, @Assisted String str2) {
        int i = 0;
        this.f21699b = analyticsLogger;
        this.f21700c = baseAnalyticsConfig;
        this.f21707j = handler;
        this.f21704g = new Random();
        this.f21702e = str;
        this.f21703f = str2;
        this.f21706i = new AtomicBoolean(false);
        this.f21705h = Maps.m811a(ActionType.class);
        ActionType[] values = ActionType.values();
        int length = values.length;
        while (i < length) {
            this.f21705h.put(values[i], new ConcurrentLinkedQueue());
            i++;
        }
        this.f21701d = new MapMaker().m1483c(2).m1476a(8).m1489l();
    }

    public final void m29411a(String str) {
        m29402a(ActionType.CACHE_HIT, str);
    }

    public final void m29413b(String str) {
        m29405a(str, null, null);
    }

    private void m29405a(String str, String str2, Long l) {
        m29403a(m29416d(str) ? ActionType.CACHE_MISS_PREFETCH_IN_FLIGHT : ActionType.CACHE_MISS, str, l, null, null, str2);
    }

    public final void m29415c(String str) {
        m29406b(str, null);
    }

    private void m29406b(String str, String str2) {
        m29407b(str, str2, null);
    }

    private void m29407b(String str, String str2, Long l) {
        m29403a(ActionType.CACHE_STALE_HIT, str, l, null, null, str2);
    }

    public final boolean m29416d(String str) {
        return this.f21701d.containsKey(str);
    }

    public final void m29417e(String str) {
        if (str != null) {
            m29402a(ActionType.COULD_PREFETCH, str);
        }
    }

    public final void m29418f(String str) {
        if (str != null) {
            this.f21701d.putIfAbsent(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public final void m29419g(String str) {
        m29408c(str, null);
    }

    private void m29408c(String str, String str2) {
        if (str != null) {
            long h = m29410h(str);
            Long.valueOf(h);
            m29403a(ActionType.PREFETCH_SUCCEEDED, str, Long.valueOf(h), null, null, str2);
        }
    }

    public final void m29414b(Collection<String> collection) {
        if (collection != null) {
            int nextInt = this.f21704g.nextInt();
            for (String str : collection) {
                long h = m29410h(str);
                Long.valueOf(h);
                Integer.valueOf(nextInt);
                m29403a(ActionType.PREFETCH_SUCCEEDED, str, Long.valueOf(h), null, Integer.valueOf(nextInt), null);
            }
        }
    }

    public final void m29412a(String str, String str2) {
        if (str != null) {
            String str3;
            long h = m29410h(str);
            String str4 = f21698a;
            String str5 = "failed prefetching %s after %d ms for reason: %s";
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = Long.valueOf(h);
            if (str2 == null) {
                str3 = "";
            } else {
                str3 = str2;
            }
            objArr[2] = str3;
            BLog.a(str4, str5, objArr);
            m29404a(str, h, str2);
        }
    }

    private long m29410h(String str) {
        Long l = (Long) this.f21701d.remove(str);
        if (l != null) {
            return System.currentTimeMillis() - l.longValue();
        }
        return 0;
    }

    private void m29402a(ActionType actionType, String str) {
        m29403a(actionType, str, null, null, null, null);
    }

    private void m29403a(ActionType actionType, String str, @Nullable Long l, @Nullable Long l2, @Nullable Integer num, @Nullable String str2) {
        if (str != null && m29409c()) {
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.f3121a);
            objectNode.m5137a("cache_key", str);
            if (l != null) {
                objectNode.m5135a("prefetch_duration_ms", l);
            }
            if (l2 != null) {
                objectNode.m5135a("prefetch_bytes", l2);
            }
            if (num != null) {
                objectNode.m5134a("prefetch_batch_id", num);
            }
            if (str2 != null) {
                objectNode.m5137a("prefetch_source", str2);
            }
            objectNode.m5130a("action_timestamp", System.currentTimeMillis());
            m29401a(actionType, objectNode);
        }
    }

    private void m29404a(String str, long j, String str2) {
        if (str != null && m29409c()) {
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.f3121a);
            objectNode.m5137a("cache_key", str);
            objectNode.m5130a("prefetch_duration_ms", j);
            if (str2 != null) {
                objectNode.m5137a("failure_reason", str2);
            }
            m29401a(ActionType.PREFETCH_FAILED, objectNode);
        }
    }

    private void m29401a(ActionType actionType, ObjectNode objectNode) {
        ((ConcurrentLinkedQueue) this.f21705h.get(actionType)).add(objectNode);
        if (this.f21706i.compareAndSet(false, true)) {
            HandlerDetour.b(this.f21707j, this.f21708k, 60000, -2114288857);
        }
    }

    private boolean m29409c() {
        return this.f21700c.m3563a("prefetch_cache_efficiency");
    }
}
