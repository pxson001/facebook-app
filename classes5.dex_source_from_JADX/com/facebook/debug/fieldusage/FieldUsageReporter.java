package com.facebook.debug.fieldusage;

import android.support.v4.util.ArrayMap;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.Assisted;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: scrolling */
public final class FieldUsageReporter implements InjectableComponentWithoutContext, Runnable {
    public final FieldAccessQueryTracker f2899a;
    public final Object f2900b;
    public final AnalyticsLogger f2901c;

    @Inject
    public FieldUsageReporter(AnalyticsLogger analyticsLogger, @Assisted FieldAccessQueryTracker fieldAccessQueryTracker, @Assisted Object obj) {
        this.f2901c = analyticsLogger;
        this.f2899a = fieldAccessQueryTracker;
        this.f2900b = obj;
    }

    public final void run() {
        if (this.f2899a != null) {
            if (this.f2901c != null && FieldAccessQueryContext.a()) {
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent("graphql_fields_tracking");
                ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
                FieldAccessQueryTracker fieldAccessQueryTracker = this.f2899a;
                Map arrayMap = new ArrayMap();
                for (FieldAccessTracker a : fieldAccessQueryTracker.b) {
                    a.m4038a(arrayMap, fieldAccessQueryTracker.h);
                }
                ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
                for (Entry entry : arrayMap.entrySet()) {
                    ObjectNode objectNode3 = new ObjectNode(JsonNodeFactory.a);
                    objectNode3.a("set_count", ((Long) ((Map) entry.getValue()).get("set_count")).longValue());
                    objectNode3.a("used_count", ((Long) ((Map) entry.getValue()).get("used_count")).longValue());
                    objectNode2.c((String) entry.getKey(), objectNode3);
                }
                ObjectNode objectNode4 = new ObjectNode(JsonNodeFactory.a);
                objectNode4.a("tr_start_date", new Date().toString());
                objectNode4.a("age", (fieldAccessQueryTracker.g.now() - fieldAccessQueryTracker.f) / 1000);
                objectNode4.c("fields", objectNode2);
                if (!(fieldAccessQueryTracker.e == null || fieldAccessQueryTracker.e.isEmpty())) {
                    objectNode4.a("persist_id", fieldAccessQueryTracker.e);
                }
                ObjectNode objectNode5 = objectNode4;
                if (this.f2899a.h) {
                    objectNode5.a("flatbuffer_version", 1);
                    objectNode5.a("flatbuffer_schema_id", "10154690582226729");
                }
                objectNode.c(this.f2899a.d, objectNode5);
                honeyClientEvent.a("queries", objectNode);
                honeyClientEvent.b("source", "prod");
                this.f2901c.a(honeyClientEvent);
            }
            FieldAccessQueryContext.a(this.f2900b);
        }
    }
}
