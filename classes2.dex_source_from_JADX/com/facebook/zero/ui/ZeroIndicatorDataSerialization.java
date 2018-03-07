package com.facebook.zero.ui;

import com.facebook.common.io.FbCloseables;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.json.JsonFactoryMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.zero.sdk.request.ZeroIndicatorData;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Closeable;
import javax.inject.Inject;

/* compiled from: file */
public class ZeroIndicatorDataSerialization {
    private final ObjectMapper f23726a;
    private final JsonFactory f23727b;

    public static ZeroIndicatorDataSerialization m32145b(InjectorLike injectorLike) {
        return new ZeroIndicatorDataSerialization(FbObjectMapperMethodAutoProvider.m6609a(injectorLike), JsonFactoryMethodAutoProvider.m8062a(injectorLike));
    }

    @Inject
    public ZeroIndicatorDataSerialization(ObjectMapper objectMapper, JsonFactory jsonFactory) {
        this.f23726a = objectMapper;
        this.f23727b = jsonFactory;
    }

    public final ZeroIndicatorData m32146a(String str) {
        Closeable closeable = null;
        try {
            closeable = this.f23727b.m7173b(str);
            closeable.mo1766c();
            ZeroIndicatorData zeroIndicatorData = (ZeroIndicatorData) this.f23726a.mo908a((JsonParser) closeable, ZeroIndicatorData.class);
            return zeroIndicatorData;
        } finally {
            FbCloseables.m25418a(closeable);
        }
    }

    public final String m32147a(ZeroIndicatorData zeroIndicatorData) {
        if (zeroIndicatorData != null) {
            return this.f23726a.m6659a((Object) zeroIndicatorData);
        }
        throw new IllegalArgumentException();
    }
}
