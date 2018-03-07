package com.facebook.rtcpresence;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.JSONUtil;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.mqtt.model.thrift.Callability;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.UserKey;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: service_type */
public class RtcPresenceDecoder {
    private static final Class<?> f2545a = RtcPresenceDecoder.class;
    private final MonotonicClock f2546b;
    private final Resources f2547c;
    private final Provider<UserCache> f2548d;

    public static RtcPresenceDecoder m2830b(InjectorLike injectorLike) {
        return new RtcPresenceDecoder((MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 3593));
    }

    @Inject
    public RtcPresenceDecoder(MonotonicClock monotonicClock, Context context, Provider<UserCache> provider) {
        this.f2546b = monotonicClock;
        this.f2547c = context.getResources();
        this.f2548d = provider;
    }

    public final RtcPresenceState m2832a(JsonNode jsonNode) {
        jsonNode.toString();
        if (jsonNode.d("voip_info")) {
            JsonNode b = jsonNode.b("voip_info");
            if (b.d("is_callable")) {
                String str;
                boolean g = JSONUtil.g(b.b("is_callable"));
                boolean a = JSONUtil.a(b.b("is_callable_webrtc"), false);
                boolean a2 = JSONUtil.a(b.b("has_permission"), false);
                ImmutableMap of = ImmutableMap.of("mobile", Boolean.toString(g), "desktop", Boolean.toString(a), "permission", Boolean.toString(a2));
                boolean z = g || a;
                if (z || !b.d("reason_description")) {
                    str = null;
                } else {
                    str = JSONUtil.b(b.b("reason_description"));
                }
                String str2 = !z ? a2 ? RtcAbortedCallReasonIds.b : RtcAbortedCallReasonIds.a : null;
                return new RtcPresenceState(z, str, str2, this.f2546b.now(), of);
            }
            throw new IOException("Expected voip_info to contain is_callable field.");
        }
        throw new IOException("Expected response body to contain a voip_info field.");
    }

    public final RtcPresenceState m2831a(Callability callability) {
        String str;
        String str2;
        ImmutableMap of = ImmutableMap.of("mobile", Boolean.toString(callability.is_callable_mobile.booleanValue()), "desktop", Boolean.toString(callability.is_callable_webrtc.booleanValue()), "permission", Boolean.toString(callability.has_permission.booleanValue()));
        boolean z = callability.is_callable_mobile.booleanValue() || callability.is_callable_webrtc.booleanValue();
        if (z) {
            str = null;
            str2 = null;
        } else {
            String string;
            switch (callability.reason_code.intValue()) {
                case 1356044:
                    string = this.f2547c.getString(2131232173);
                    break;
                case 1356049:
                    UserKey b = UserKey.b(String.valueOf(callability.userId));
                    string = this.f2547c.getString(2131232174, new Object[]{((UserCache) this.f2548d.get()).m10373a(b).h()});
                    break;
                default:
                    string = null;
                    break;
            }
            if (callability.has_permission.booleanValue()) {
                str = RtcAbortedCallReasonIds.b;
                str2 = string;
            } else {
                str = RtcAbortedCallReasonIds.a;
                str2 = string;
            }
        }
        return new RtcPresenceState(z, str2, str, this.f2546b.now(), of);
    }
}
