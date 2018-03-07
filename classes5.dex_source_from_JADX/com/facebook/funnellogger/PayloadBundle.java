package com.facebook.funnellogger;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

/* compiled from: remove_from_experiment */
public class PayloadBundle {
    public final ObjectNode f3171a = new ObjectNode(JsonNodeFactory.a);

    private PayloadBundle() {
    }

    public static PayloadBundle m4297a() {
        return new PayloadBundle();
    }

    public final PayloadBundle m4298a(String str, long j) {
        this.f3171a.a(str, j);
        return this;
    }

    public final PayloadBundle m4299a(String str, String str2) {
        this.f3171a.a(str, str2);
        return this;
    }
}
