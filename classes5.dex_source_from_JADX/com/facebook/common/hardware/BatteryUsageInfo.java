package com.facebook.common.hardware;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

/* compiled from: split_flow_landing_page_hint_title */
public class BatteryUsageInfo {
    public ObjectNode f2602a = new ObjectNode(JsonNodeFactory.a);

    public final void m3706a(double d) {
        this.f2602a.a("fb_percent", d);
    }

    public final void m3707a(String str) {
        if (!this.f2602a.d("errors")) {
            this.f2602a.c("errors", new ArrayNode(JsonNodeFactory.a));
        }
        ((ArrayNode) this.f2602a.b("errors")).h(str);
    }

    public final void m3710a(String str, ObjectNode objectNode) {
        this.f2602a.c(str, objectNode);
    }

    public final void m3709a(String str, long j) {
        this.f2602a.a(str, j);
    }

    public final void m3708a(String str, double d) {
        this.f2602a.a(str, d);
    }
}
