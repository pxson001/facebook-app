package com.facebook.analytics.logger;

import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.event.HoneyProtocolUtils;
import com.facebook.common.paramsutil.JsonToParamsCollectionUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.crudolib.params.ParamsCollectionMap;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: textlink_open_instagram_enabled */
public class HoneyClientEvent extends HoneyAnalyticsEvent {
    public String f3099c;
    public String f3100d;
    public String f3101e;
    public String f3102f;
    public String f3103g;
    public String f3104h;
    private ObjectNode f3105i;
    public boolean f3106j;
    public boolean f3107k = false;

    public HoneyClientEvent(String str) {
        super("client_event", str);
    }

    public final HoneyClientEvent mo699b(boolean z) {
        this.f3106j = z;
        m5087a("sponsored", z);
        return this;
    }

    @Deprecated
    public final HoneyClientEvent m5092c(boolean z) {
        this.f3107k = z;
        return this;
    }

    public final HoneyClientEvent m5090b(String str, @Nullable String str2) {
        m5081v();
        if (str2 != null) {
            this.f3105i.m5137a(str, str2);
        }
        return this;
    }

    private void m5081v() {
        if (this.f3105i == null) {
            this.f3105i = new ObjectNode(JsonNodeFactory.f3121a);
        }
    }

    public final HoneyClientEvent m5083a(String str, int i) {
        m5081v();
        this.f3105i.m5129a(str, i);
        return this;
    }

    public final HoneyClientEvent m5084a(String str, long j) {
        m5081v();
        this.f3105i.m5130a(str, j);
        return this;
    }

    public final HoneyClientEvent m5087a(String str, boolean z) {
        m5081v();
        this.f3105i.m5138a(str, z);
        return this;
    }

    public final HoneyClientEvent m5082a(String str, double d) {
        m5081v();
        this.f3105i.m5127a(str, d);
        return this;
    }

    public final HoneyClientEvent m5088a(@Nullable Map<String, ?> map) {
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof JsonNode) {
                    m5085a((String) entry.getKey(), (JsonNode) value);
                } else if (value instanceof String) {
                    m5090b((String) entry.getKey(), (String) value);
                } else {
                    m5086a((String) entry.getKey(), value);
                }
            }
        }
        return this;
    }

    public final HoneyClientEvent m5086a(String str, @Nullable Object obj) {
        return obj == null ? this : m5090b(str, obj.toString());
    }

    public final HoneyClientEvent m5085a(String str, @Nullable JsonNode jsonNode) {
        m5081v();
        this.f3105i.m5143c(str, jsonNode);
        return this;
    }

    public final HoneyClientEvent m5094g(String str) {
        this.f3099c = str;
        return this;
    }

    public final HoneyClientEvent m5095h(@Nullable String str) {
        this.f3100d = str;
        return this;
    }

    public final HoneyClientEvent m5096i(@Nullable String str) {
        this.f3101e = str;
        return this;
    }

    public final HoneyClientEvent m5097j(String str) {
        this.f3100d = "fbobj";
        this.f3101e = str;
        return this;
    }

    public final HoneyClientEvent m5099k(@Nullable String str) {
        this.f3102f = str;
        return this;
    }

    public final HoneyClientEvent m5100l(String str) {
        this.f3103g = str;
        return this;
    }

    public final String mo702j() {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.f3121a);
        objectNode.m5137a("time", HoneyProtocolUtils.a(this.f3112e));
        objectNode.m5137a("log_type", this.f3109a);
        objectNode.m5137a("name", this.f3111d);
        if (this.f3099c != null) {
            objectNode.m5137a("module", this.f3099c);
        }
        if (this.f3100d != null) {
            objectNode.m5137a("obj_type", this.f3100d);
        }
        if (this.f3101e != null) {
            objectNode.m5137a("obj_id", this.f3101e);
        }
        if (this.f3102f != null) {
            objectNode.m5137a("uuid", this.f3102f);
        }
        String str = this.f3116i;
        if (!(str == null || str == "AUTO_SET")) {
            m5090b("process", str);
        }
        JsonNode jsonNode = this.f3118k;
        if (jsonNode != null) {
            m5085a("enabled_features", jsonNode);
        }
        if (this.f3105i != null) {
            objectNode.m5143c("extra", this.f3105i);
        }
        if (this.f3103g != null) {
            objectNode.m5137a("interface", this.f3103g);
            objectNode.m5137a("src_interface", this.f3103g);
        }
        if (this.f3104h != null) {
            objectNode.m5137a("dst_interface", this.f3104h);
        }
        if (this.f3114g) {
            objectNode.m5138a("bg", true);
        }
        return objectNode.toString();
    }

    public final JsonNode m5103t() {
        return m5080o("tracking");
    }

    @VisibleForTesting
    public final String m5101m(String str) {
        JsonNode o = m5080o(str);
        return o == null ? null : o.mo719B();
    }

    @VisibleForTesting
    public final String m5102n(String str) {
        JsonNode o = m5080o(str);
        return o == null ? null : o.toString();
    }

    private JsonNode m5080o(String str) {
        Preconditions.checkArgument(!StringUtil.m3589a((CharSequence) str), "Invalid Key");
        if (this.f3105i == null) {
            return null;
        }
        JsonNode b = this.f3105i.mo709b(str);
        if (b == null) {
            return null;
        }
        return b;
    }

    @Nullable
    public final String m5104u() {
        return this.f3105i != null ? this.f3105i.toString() : null;
    }

    @Nullable
    public final void m5089a(ParamsCollectionMap paramsCollectionMap) {
        if (this.f3105i != null) {
            try {
                JsonToParamsCollectionUtil.m5473a(this.f3105i, paramsCollectionMap);
            } catch (Throwable e) {
                throw new IllegalArgumentException(this.f3105i.mo719B(), e);
            }
        }
    }

    public int hashCode() {
        return Objects.hashCode(this.f3109a, this.f3111d, this.f3099c);
    }

    public String toString() {
        return this.f3109a + ":" + this.f3111d + ":" + this.f3099c;
    }

    public final String mo700d() {
        return mo702j();
    }
}
