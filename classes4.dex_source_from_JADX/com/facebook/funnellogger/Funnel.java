package com.facebook.funnellogger;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.Clock;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;

/* compiled from: dblCredentials */
public class Funnel {
    public final FunnelDefinition f14186a;
    private final long f14187b;
    private final Clock f14188c;
    private final int f14189d;
    public final long f14190e;
    public long f14191f;
    private ArrayList<String> f14192g;
    private ArrayList<FunnelAction> f14193h;
    public boolean f14194i = false;

    Funnel(FunnelDefinition funnelDefinition, long j, Clock clock, int i) {
        this.f14186a = funnelDefinition;
        this.f14187b = j;
        this.f14188c = clock;
        this.f14190e = clock.a();
        this.f14191f = this.f14190e;
        this.f14189d = i;
    }

    final void m15000a(String str) {
        if (str != null) {
            if (this.f14192g == null) {
                this.f14192g = new ArrayList();
            }
            this.f14192g.add(str);
            this.f14191f = this.f14188c.a();
        }
    }

    final void m14999a(FunnelAction funnelAction) {
        if (this.f14193h == null) {
            this.f14193h = new ArrayList();
        }
        this.f14193h.add(funnelAction);
        this.f14191f = this.f14188c.a();
    }

    final String m15001b() {
        return this.f14186a.a;
    }

    final long m15002d() {
        return this.f14190e;
    }

    final boolean m15003g() {
        return this.f14193h == null || this.f14193h.size() < 100;
    }

    final HoneyClientEvent m15004h() {
        int i = 0;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("funnel_analytics");
        honeyClientEvent.b("name", m15001b());
        honeyClientEvent.a("funnel_id", this.f14186a.b);
        honeyClientEvent.a("instance_id", this.f14187b);
        honeyClientEvent.a("start_time", this.f14190e);
        honeyClientEvent.a("sampling_rate", this.f14189d);
        if (this.f14194i) {
            m15000a("tracked");
        }
        if (this.f14192g != null) {
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
            int size = this.f14192g.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayNode.h((String) this.f14192g.get(i2));
            }
            honeyClientEvent.a("tags", arrayNode);
        }
        if (this.f14193h != null) {
            ArrayNode arrayNode2 = new ArrayNode(JsonNodeFactory.a);
            int size2 = this.f14193h.size();
            while (i < size2) {
                FunnelAction funnelAction = (FunnelAction) this.f14193h.get(i);
                ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
                objectNode.a("name", funnelAction.a);
                objectNode.a("relative_time", funnelAction.d);
                if (funnelAction.b != null) {
                    objectNode.a("tag", funnelAction.b);
                }
                if (funnelAction.c != null) {
                    objectNode.c("payload", funnelAction.c.a);
                }
                arrayNode2.a(objectNode);
                i++;
            }
            honeyClientEvent.a("actions", arrayNode2);
        }
        return honeyClientEvent;
    }
}
