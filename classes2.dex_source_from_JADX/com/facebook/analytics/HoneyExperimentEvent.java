package com.facebook.analytics;

import com.facebook.analytics.event.HoneyProtocolUtils;
import com.facebook.common.paramsutil.JsonToParamsCollectionUtil;
import com.facebook.crudolib.params.ParamsCollectionMap;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

/* compiled from: logging_data */
public class HoneyExperimentEvent extends HoneyAnalyticsEvent {
    public String f16095c;
    private ObjectNode f16096d;

    public HoneyExperimentEvent(String str) {
        super("experiment", str);
    }

    public final HoneyExperimentEvent m22924b(String str, String str2) {
        if (this.f16096d == null) {
            this.f16096d = new ObjectNode(JsonNodeFactory.f3121a);
        }
        if (str2 != null) {
            this.f16096d.m5137a(str, str2);
        }
        return this;
    }

    public final HoneyExperimentEvent m22922a(String str, JsonNode jsonNode) {
        if (this.f16096d == null) {
            this.f16096d = new ObjectNode(JsonNodeFactory.f3121a);
        }
        this.f16096d.m5143c(str, jsonNode);
        return this;
    }

    public final void m22923a(ParamsCollectionMap paramsCollectionMap) {
        if (this.f16096d != null) {
            try {
                JsonToParamsCollectionUtil.m5473a(this.f16096d, paramsCollectionMap);
            } catch (Throwable e) {
                throw new IllegalArgumentException(this.f16096d.mo719B(), e);
            }
        }
    }

    public final String mo702j() {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.f3121a);
        objectNode.m5137a("time", HoneyProtocolUtils.a(this.f3112e));
        objectNode.m5137a("log_type", this.f3109a);
        objectNode.m5137a("name", this.f3111d);
        if (this.f16095c != null) {
            objectNode.m5137a("exprID", this.f16095c);
        }
        JsonNode jsonNode = this.f3118k;
        if (jsonNode != null) {
            m22922a("enabled_features", jsonNode);
        }
        if (this.f16096d != null) {
            objectNode.m5143c("result", this.f16096d);
        }
        if (this.f3114g) {
            objectNode.m5138a("bg", true);
        }
        return objectNode.toString();
    }

    public final String mo700d() {
        return mo702j();
    }
}
