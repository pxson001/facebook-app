package com.facebook.loom.config;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.loom.config.Config.RootControllerConfig;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = LoomConfigurationDeserializer.class)
/* compiled from: getTopPushableFriends */
public class LoomConfiguration implements Config {
    @JsonProperty("id")
    private final long mID = 0;
    @JsonProperty("system_control")
    @Nullable
    private final SystemControlConfiguration mSystemControl = null;
    @JsonProperty("trace_control")
    @Nullable
    private final TraceControlConfiguration mTraceControl = null;

    public final SystemControlConfiguration m11517b() {
        return this.mSystemControl;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int m11515a(java.util.List<java.lang.String> r6) {
        /*
        r2 = 0;
        if (r6 != 0) goto L_0x0004;
    L_0x0003:
        return r2;
    L_0x0004:
        r4 = r6.iterator();
        r1 = r2;
    L_0x0009:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x00a9;
    L_0x000f:
        r0 = r4.next();
        r0 = (java.lang.String) r0;
        r3 = -1;
        r5 = r0.hashCode();
        switch(r5) {
            case -1292562226: goto L_0x006a;
            case -1047627255: goto L_0x004c;
            case -321469461: goto L_0x0056;
            case -302323862: goto L_0x002e;
            case 112173: goto L_0x0042;
            case 93127292: goto L_0x0024;
            case 102970551: goto L_0x0074;
            case 106069776: goto L_0x0038;
            case 1903701511: goto L_0x0060;
            default: goto L_0x001d;
        };
    L_0x001d:
        r0 = r3;
    L_0x001e:
        switch(r0) {
            case 0: goto L_0x007f;
            case 1: goto L_0x0083;
            case 2: goto L_0x0087;
            case 3: goto L_0x008c;
            case 4: goto L_0x0091;
            case 5: goto L_0x0096;
            case 6: goto L_0x009b;
            case 7: goto L_0x00a0;
            case 8: goto L_0x00a5;
            default: goto L_0x0021;
        };
    L_0x0021:
        r0 = r1;
    L_0x0022:
        r1 = r0;
        goto L_0x0009;
    L_0x0024:
        r5 = "async";
        r0 = r0.equals(r5);
        if (r0 == 0) goto L_0x001d;
    L_0x002c:
        r0 = r2;
        goto L_0x001e;
    L_0x002e:
        r5 = "lifecycle";
        r0 = r0.equals(r5);
        if (r0 == 0) goto L_0x001d;
    L_0x0036:
        r0 = 1;
        goto L_0x001e;
    L_0x0038:
        r5 = "other";
        r0 = r0.equals(r5);
        if (r0 == 0) goto L_0x001d;
    L_0x0040:
        r0 = 2;
        goto L_0x001e;
    L_0x0042:
        r5 = "qpl";
        r0 = r0.equals(r5);
        if (r0 == 0) goto L_0x001d;
    L_0x004a:
        r0 = 3;
        goto L_0x001e;
    L_0x004c:
        r5 = "fbtrace";
        r0 = r0.equals(r5);
        if (r0 == 0) goto L_0x001d;
    L_0x0054:
        r0 = 4;
        goto L_0x001e;
    L_0x0056:
        r5 = "user_counters";
        r0 = r0.equals(r5);
        if (r0 == 0) goto L_0x001d;
    L_0x005e:
        r0 = 5;
        goto L_0x001e;
    L_0x0060:
        r5 = "system_counters";
        r0 = r0.equals(r5);
        if (r0 == 0) goto L_0x001d;
    L_0x0068:
        r0 = 6;
        goto L_0x001e;
    L_0x006a:
        r5 = "stack_trace";
        r0 = r0.equals(r5);
        if (r0 == 0) goto L_0x001d;
    L_0x0072:
        r0 = 7;
        goto L_0x001e;
    L_0x0074:
        r5 = "liger";
        r0 = r0.equals(r5);
        if (r0 == 0) goto L_0x001d;
    L_0x007c:
        r0 = 8;
        goto L_0x001e;
    L_0x007f:
        r0 = r1 | 1;
        r1 = r0;
        goto L_0x0009;
    L_0x0083:
        r0 = r1 | 2;
        r1 = r0;
        goto L_0x0009;
    L_0x0087:
        r0 = r1 | 8;
        r1 = r0;
        goto L_0x0009;
    L_0x008c:
        r0 = r1 | 4;
        r1 = r0;
        goto L_0x0009;
    L_0x0091:
        r0 = r1 | 16;
        r1 = r0;
        goto L_0x0009;
    L_0x0096:
        r0 = r1 | 32;
        r1 = r0;
        goto L_0x0009;
    L_0x009b:
        r0 = r1 | 64;
        r1 = r0;
        goto L_0x0009;
    L_0x00a0:
        r0 = r1 | 128;
        r1 = r0;
        goto L_0x0009;
    L_0x00a5:
        r0 = r1 | 256;
        goto L_0x0022;
    L_0x00a9:
        r2 = r1;
        goto L_0x0003;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.loom.config.LoomConfiguration.a(java.util.List):int");
    }

    @Nullable
    public final RootControllerConfig m11516a() {
        return this.mTraceControl;
    }

    public final int m11518c() {
        TraceControlConfiguration traceControlConfiguration = this.mTraceControl;
        if (traceControlConfiguration == null) {
            return 0;
        }
        HTTPTraceControlConfiguration d = traceControlConfiguration.m11526d();
        if (d != null) {
            return d.m11532b();
        }
        return 0;
    }

    public final long m11519d() {
        return this.mID;
    }
}
