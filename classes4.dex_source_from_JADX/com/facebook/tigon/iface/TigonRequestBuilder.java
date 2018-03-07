package com.facebook.tigon.iface;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.tigon.iface.TigonRequestLayers.LayerInfo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@DoNotStrip
/* compiled from: push_missing_topic */
public class TigonRequestBuilder {
    public String f9519a;
    public String f9520b;
    Map<String, String> f9521c = new HashMap();
    public TigonPriorityData f9522d = new TigonPriorityData(1);
    Map<LayerInfo<?>, Object> f9523e;

    /* compiled from: push_missing_topic */
    class Impl implements TigonRequest {
        private final String f4032a;
        private final String f4033b;
        private final Map<String, String> f4034c;
        private final TigonPriorityData f4035d;
        @Nullable
        private final Map<LayerInfo<?>, Object> f4036e;

        Impl(TigonRequestBuilder tigonRequestBuilder) {
            this.f4032a = tigonRequestBuilder.f9519a;
            this.f4033b = tigonRequestBuilder.f9520b;
            this.f4034c = Collections.unmodifiableMap(tigonRequestBuilder.f9521c);
            this.f4035d = tigonRequestBuilder.f9522d;
            this.f4036e = tigonRequestBuilder.f9523e != null ? Collections.unmodifiableMap(tigonRequestBuilder.f9523e) : null;
        }

        public final String mo308a() {
            return this.f4032a;
        }

        public final String mo309b() {
            return this.f4033b;
        }

        public final Map<String, String> mo310c() {
            return this.f4034c;
        }

        public final TigonPriorityData mo311d() {
            return this.f4035d;
        }

        @Nullable
        public final <T> T mo307a(LayerInfo<T> layerInfo) {
            if (this.f4036e == null) {
                return null;
            }
            return this.f4036e.get(layerInfo);
        }
    }

    @DoNotStrip
    private static TigonRequest create(String str, String str2, String[] strArr, int i, int i2, FacebookLoggingRequestInfoImpl facebookLoggingRequestInfoImpl, TigonRetrierRequestInfoImpl tigonRetrierRequestInfoImpl) {
        TigonRequestBuilder tigonRequestBuilder = new TigonRequestBuilder();
        tigonRequestBuilder.f9519a = str;
        tigonRequestBuilder = tigonRequestBuilder;
        tigonRequestBuilder.f9520b = str2;
        tigonRequestBuilder = tigonRequestBuilder;
        tigonRequestBuilder.f9522d = new TigonPriorityData(i, i2);
        TigonRequestBuilder tigonRequestBuilder2 = tigonRequestBuilder;
        if ((strArr.length & 1) != 0) {
            throw new IllegalArgumentException("must have even number of flattened headers");
        }
        for (int i3 = 0; i3 < strArr.length; i3 += 2) {
            tigonRequestBuilder2.m9902a(strArr[i3], strArr[i3 + 1]);
        }
        if (facebookLoggingRequestInfoImpl != null) {
            tigonRequestBuilder2.m9900a(TigonRequestLayers.f4023c, (Object) facebookLoggingRequestInfoImpl);
        }
        if (tigonRetrierRequestInfoImpl != null) {
            tigonRequestBuilder2.m9900a(TigonRequestLayers.f4028h, (Object) tigonRetrierRequestInfoImpl);
        }
        return tigonRequestBuilder2.m9898a();
    }

    public final TigonRequestBuilder m9901a(String str) {
        this.f9519a = str;
        return this;
    }

    public final TigonRequestBuilder m9903b(String str) {
        this.f9520b = str;
        return this;
    }

    public final TigonRequestBuilder m9899a(TigonPriorityData tigonPriorityData) {
        this.f9522d = tigonPriorityData;
        return this;
    }

    public final TigonRequestBuilder m9902a(String str, String str2) {
        this.f9521c.put(str, str2);
        return this;
    }

    public final <T> TigonRequestBuilder m9900a(LayerInfo<T> layerInfo, T t) {
        if (this.f9523e == null) {
            this.f9523e = new HashMap();
        }
        this.f9523e.put(layerInfo, t);
        return this;
    }

    public final TigonRequest m9898a() {
        return new Impl(this);
    }
}
