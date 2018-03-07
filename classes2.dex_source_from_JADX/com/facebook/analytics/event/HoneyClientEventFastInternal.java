package com.facebook.analytics.event;

import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.common.paramsutil.JsonToParamsCollectionUtil;
import com.facebook.crudolib.params.ParamsCollection;
import com.facebook.crudolib.params.ParamsCollectionMap;
import com.facebook.crudolib.params.ParamsCollectionPool;
import com.facebook.crudolib.params.ParamsJsonEncoder;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Objects;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: telprompt */
public class HoneyClientEventFastInternal extends HoneyAnalyticsEvent {
    private static final ParamsCollectionPool f3126c = ParamsCollectionPool.m5397a();
    private String f3127d;
    private String f3128e;
    private String f3129f;
    private String f3130g;
    private String f3131h;
    private String f3132i;
    private ParamsCollectionMap f3133j;
    public boolean f3134k;
    private boolean f3135l;
    private boolean f3136m;
    private final boolean f3137n;

    public HoneyClientEventFastInternal(String str, boolean z) {
        super("client_event", str);
        this.f3137n = z;
    }

    private void m5260t() {
        if (!this.f3135l) {
            throw new IllegalStateException("isSampled was not invoked, how can you have known?");
        } else if (!this.f3137n) {
            throw new IllegalStateException("Event is not sampled");
        }
    }

    private void m5261u() {
        if (this.f3136m) {
            throw new IllegalStateException("You have already ejected params.");
        }
    }

    private void m5262v() {
        m5260t();
        m5261u();
    }

    public final HoneyClientEventFastInternal m5271b(String str, @Nullable String str2) {
        m5262v();
        m5263w();
        if (str2 != null) {
            this.f3133j.m5421a(str, str2);
        }
        return this;
    }

    public final boolean mo732l() {
        this.f3135l = true;
        return this.f3137n;
    }

    private void m5263w() {
        if (this.f3133j == null) {
            this.f3133j = f3126c.m5398b();
            this.f3133j.m5438a(ParamsJsonEncoder.m5454a());
        }
    }

    public final HoneyClientEventFastInternal m5265a(String str, int i) {
        m5262v();
        m5263w();
        this.f3133j.m5420a(str, Integer.valueOf(i));
        return this;
    }

    public final HoneyClientEventFastInternal m5266a(String str, long j) {
        m5262v();
        m5263w();
        this.f3133j.m5420a(str, Long.valueOf(j));
        return this;
    }

    public final HoneyClientEventFastInternal m5269a(String str, boolean z) {
        m5262v();
        m5263w();
        this.f3133j.m5419a(str, Boolean.valueOf(z));
        return this;
    }

    public final HoneyClientEventFastInternal m5264a(String str, double d) {
        m5262v();
        m5263w();
        this.f3133j.m5420a(str, Double.valueOf(d));
        return this;
    }

    private HoneyClientEventFastInternal m5258a(String str, Number number) {
        m5262v();
        m5263w();
        this.f3133j.m5420a(str, number);
        return this;
    }

    private HoneyClientEventFastInternal m5257a(String str, Boolean bool) {
        m5262v();
        m5263w();
        this.f3133j.m5419a(str, bool);
        return this;
    }

    public final HoneyClientEventFastInternal m5270a(@Nullable Map<String, ?> map) {
        m5262v();
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof JsonNode) {
                    m5267a((String) entry.getKey(), (JsonNode) value);
                } else if (value instanceof String) {
                    m5271b((String) entry.getKey(), (String) value);
                } else if (value instanceof Number) {
                    m5258a((String) entry.getKey(), (Number) value);
                } else if (value instanceof Boolean) {
                    m5257a((String) entry.getKey(), (Boolean) value);
                } else {
                    m5268a((String) entry.getKey(), value);
                }
            }
        }
        return this;
    }

    public final HoneyClientEventFastInternal m5268a(String str, @Nullable Object obj) {
        m5262v();
        return obj == null ? this : m5271b(str, obj.toString());
    }

    public final HoneyClientEventFastInternal m5267a(String str, @Nullable JsonNode jsonNode) {
        m5262v();
        m5263w();
        try {
            JsonToParamsCollectionUtil.m5474a(str, jsonNode, this.f3133j);
            return this;
        } catch (Throwable e) {
            throw new IllegalArgumentException(jsonNode.mo719B(), e);
        }
    }

    public final HoneyClientEventFastInternal m5272g(String str) {
        m5262v();
        this.f3127d = str;
        return this;
    }

    public final HoneyClientEventFastInternal m5273h(@Nullable String str) {
        m5262v();
        this.f3128e = str;
        return this;
    }

    public final String m5278m() {
        m5262v();
        return this.f3128e;
    }

    public final HoneyClientEventFastInternal m5274i(@Nullable String str) {
        m5262v();
        this.f3129f = str;
        return this;
    }

    public final String m5279n() {
        m5262v();
        return this.f3129f;
    }

    public final HoneyClientEventFastInternal m5275j(@Nullable String str) {
        m5262v();
        this.f3130g = str;
        return this;
    }

    public final String m5280o() {
        m5262v();
        return this.f3130g;
    }

    public final String m5281p() {
        m5262v();
        return this.f3131h;
    }

    public final String m5282q() {
        m5262v();
        return this.f3132i;
    }

    public final String mo702j() {
        m5262v();
        ParamsCollectionMap b = f3126c.m5398b();
        b.m5438a(ParamsJsonEncoder.m5454a());
        m5259a(b, this);
        Writer stringWriter = new StringWriter();
        try {
            b.m5439a(stringWriter);
            b.m5434a();
            return stringWriter.toString();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static void m5259a(ParamsCollectionMap paramsCollectionMap, HoneyClientEventFastInternal honeyClientEventFastInternal) {
        paramsCollectionMap.m5421a("time", HoneyProtocolUtils.a(honeyClientEventFastInternal.f3112e));
        paramsCollectionMap.m5421a("log_type", honeyClientEventFastInternal.f3109a);
        paramsCollectionMap.m5421a("name", honeyClientEventFastInternal.f3111d);
        if (honeyClientEventFastInternal.f3127d != null) {
            paramsCollectionMap.m5421a("module", honeyClientEventFastInternal.f3127d);
        }
        if (honeyClientEventFastInternal.f3128e != null) {
            paramsCollectionMap.m5421a("obj_type", honeyClientEventFastInternal.f3128e);
        }
        if (honeyClientEventFastInternal.f3129f != null) {
            paramsCollectionMap.m5421a("obj_id", honeyClientEventFastInternal.f3129f);
        }
        if (honeyClientEventFastInternal.f3130g != null) {
            paramsCollectionMap.m5421a("uuid", honeyClientEventFastInternal.f3130g);
        }
        String str = honeyClientEventFastInternal.f3116i;
        if (!(str == null || str == "AUTO_SET")) {
            honeyClientEventFastInternal.m5271b("process", str);
        }
        JsonNode jsonNode = honeyClientEventFastInternal.f3118k;
        if (jsonNode != null) {
            honeyClientEventFastInternal.m5267a("enabled_features", jsonNode);
        }
        ParamsCollection r = honeyClientEventFastInternal.m5283r();
        if (r != null) {
            paramsCollectionMap.m5418a("extra", r);
        }
        if (honeyClientEventFastInternal.f3131h != null) {
            paramsCollectionMap.m5421a("interface", honeyClientEventFastInternal.f3131h);
            paramsCollectionMap.m5421a("src_interface", honeyClientEventFastInternal.f3131h);
        }
        if (honeyClientEventFastInternal.f3132i != null) {
            paramsCollectionMap.m5421a("dst_interface", honeyClientEventFastInternal.f3132i);
        }
        if (honeyClientEventFastInternal.f3114g) {
            paramsCollectionMap.m5419a("bg", Boolean.valueOf(true));
        }
    }

    @Nullable
    public final ParamsCollectionMap m5283r() {
        m5262v();
        ParamsCollectionMap paramsCollectionMap = this.f3133j;
        this.f3133j = null;
        this.f3136m = true;
        return paramsCollectionMap;
    }

    public final String m5284s() {
        m5262v();
        return this.f3127d;
    }

    public int hashCode() {
        return Objects.hashCode(this.f3109a, this.f3111d, this.f3127d);
    }

    public String toString() {
        return this.f3109a + ":" + this.f3111d + ":" + m5284s();
    }
}
