package com.facebook.sequencelogger;

import com.facebook.common.util.JSONUtil;
import com.facebook.sequencelogger.SequenceData.SequenceElement;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;

/* compiled from: sessionID */
class SequenceData$SubEvent implements SequenceElement {
    final String f4894a;
    final long f4895b;
    final ImmutableMap<String, String> f4896c;
    final /* synthetic */ SequenceData f4897d;

    private SequenceData$SubEvent(SequenceData sequenceData, String str, long j, @Nullable ImmutableMap<String, String> immutableMap) {
        this.f4897d = sequenceData;
        this.f4894a = str;
        this.f4895b = j;
        this.f4896c = immutableMap;
    }

    public final JsonNode m7688b() {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("name", this.f4894a);
        objectNode.a("type", "m");
        objectNode.a("relative_start_ms", this.f4895b - this.f4897d.k);
        if (this.f4896c != null) {
            objectNode.c("extra", JSONUtil.a(this.f4896c));
        }
        return objectNode;
    }

    public final long m7687a() {
        return this.f4897d.k;
    }
}
