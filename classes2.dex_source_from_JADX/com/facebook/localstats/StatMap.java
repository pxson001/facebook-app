package com.facebook.localstats;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: promote_product/?page_id=%s&promotion_target_id=%s&referral=%s */
public class StatMap {
    private static final ObjectMapper f8770e = new ObjectMapper();
    private long[] f8771a = new long[192];
    public int f8772b = 0;
    public Map<Long, String> f8773c = new HashMap();
    private final String f8774d = "StatMap.class";

    public final synchronized void m13625a(int i, short s, long j) {
        int i2;
        long a = m13623a(i, s);
        int i3 = this.f8772b / 6;
        int i4 = 0;
        while (i4 < i3) {
            i2 = ((i3 - i4) / 2) + i4;
            if (this.f8771a[i2 * 6] < a) {
                i4 = i2 + 1;
            } else {
                i3 = i2;
            }
        }
        i3 *= 6;
        if (i3 >= this.f8772b || this.f8771a[i3] > a) {
            if (this.f8772b >= this.f8771a.length) {
                Object obj = new long[(this.f8771a.length * 2)];
                System.arraycopy(this.f8771a, 0, obj, 0, i3);
                System.arraycopy(this.f8771a, i3, obj, i3 + 6, this.f8772b - i3);
                this.f8771a = obj;
            } else {
                System.arraycopy(this.f8771a, i3, this.f8771a, i3 + 6, this.f8772b - i3);
                Arrays.fill(this.f8771a, i3, i3 + 6, 0);
            }
            this.f8771a[i3 + 0] = a;
            this.f8772b += 6;
        }
        long[] jArr = this.f8771a;
        i4 = i3 + 1;
        jArr[i4] = jArr[i4] + 1;
        jArr = this.f8771a;
        i4 = i3 + 2;
        jArr[i4] = jArr[i4] + j;
        jArr = this.f8771a;
        i4 = i3 + 3;
        jArr[i4] = jArr[i4] + (j * j);
        i2 = i3 + 4;
        this.f8771a[i2] = Math.max(this.f8771a[i2], j);
        this.f8771a[i3 + 5] = j;
    }

    public final synchronized void m13626a(int i, short s, String str) {
        this.f8773c.put(Long.valueOf(m13623a(i, s)), str);
    }

    public final synchronized StatMap m13627b() {
        StatMap statMap;
        statMap = new StatMap();
        long[] jArr = this.f8771a;
        this.f8771a = statMap.f8771a;
        statMap.f8771a = jArr;
        Map map = this.f8773c;
        this.f8773c = statMap.f8773c;
        statMap.f8773c = map;
        int i = this.f8772b;
        this.f8772b = statMap.f8772b;
        statMap.f8772b = i;
        return statMap;
    }

    public final JsonNode m13624a(@Nullable ImmutableMap<Integer, Integer> immutableMap, @Nullable ImmutableSet<Integer> immutableSet) {
        int i;
        JsonNode objectNode = new ObjectNode(JsonNodeFactory.f3121a);
        for (i = 0; i < this.f8772b; i += 6) {
            long j = this.f8771a[i + 0];
            int i2 = (int) (j >> 32);
            int i3 = -1;
            if (immutableMap != null) {
                Integer num = (Integer) immutableMap.get(Integer.valueOf(i2));
                i3 = num != null ? num.intValue() : 0;
            } else if (immutableSet != null) {
                if (immutableSet.contains(Integer.valueOf(i2))) {
                }
            }
            if (i3 != 0) {
                JsonNode objectNode2 = new ObjectNode(JsonNodeFactory.f3121a);
                if ((i3 & 1) != 0) {
                    objectNode2.m5130a("count", this.f8771a[i + 1]);
                }
                if ((i3 & 2) != 0) {
                    objectNode2.m5130a("sum", this.f8771a[i + 2]);
                }
                if ((i3 & 4) != 0) {
                    objectNode2.m5130a("s_sum", this.f8771a[i + 3]);
                }
                if ((i3 & 8) != 0) {
                    objectNode2.m5130a("max", this.f8771a[i + 4]);
                }
                if ((i3 & 16) != 0) {
                    objectNode2.m5130a("last", this.f8771a[i + 5]);
                }
                objectNode.m5143c(String.valueOf(i2) + "_" + String.valueOf((short) ((int) j)), objectNode2);
            }
        }
        for (Entry entry : this.f8773c.entrySet()) {
            j = ((Long) entry.getKey()).longValue();
            i = (int) (j >> 32);
            if (immutableMap != null) {
                if (immutableMap.get(Integer.valueOf(i)) == null) {
                }
            } else if (immutableSet != null) {
                if (immutableSet.contains(Integer.valueOf(i))) {
                }
            }
            String valueOf = String.valueOf(i);
            String valueOf2 = String.valueOf((short) ((int) j));
            try {
                JsonNode a = f8770e.m6636a((String) entry.getValue());
                if (a == null) {
                    objectNode.m5137a(valueOf + "_" + valueOf2, (String) entry.getValue());
                } else {
                    objectNode.m5143c(valueOf + "_" + valueOf2, a);
                }
            } catch (JsonParseException e) {
                entry.getValue();
                e.getMessage();
                objectNode.m5137a(valueOf + "_" + valueOf2, (String) entry.getValue());
            } catch (IOException e2) {
                BLog.b("StatMap.class", StringFormatUtil.formatStrLocaleSafe("IO Exception in readTree(). %s", e2.getMessage()));
            }
        }
        return objectNode;
    }

    private static long m13623a(int i, short s) {
        return (((long) i) << 32) | (((long) s) & 4294967295L);
    }
}
