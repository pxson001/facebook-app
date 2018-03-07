package com.facebook.zero.sdk.util;

import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.facebook.zero.util.FbZeroSharedPreferences;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: soft_error_message */
public class UiFeatureDataSerializer {
    private static final Class<?> f4364a = UiFeatureDataSerializer.class;
    private ZeroSharedPreferences f4365b;
    private StringListDataSerializer f4366c;

    public static UiFeatureDataSerializer m8053b(InjectorLike injectorLike) {
        return new UiFeatureDataSerializer(FbZeroSharedPreferences.m7971a(injectorLike), StringListDataSerializer.m8059b(injectorLike));
    }

    @Inject
    public UiFeatureDataSerializer(ZeroSharedPreferences zeroSharedPreferences, StringListDataSerializer stringListDataSerializer) {
        this.f4365b = zeroSharedPreferences;
        this.f4366c = stringListDataSerializer;
    }

    public final synchronized ImmutableSet<ZeroFeatureKey> m8055a(String str) {
        return m8054b(this.f4365b.mo1196a(str, ""));
    }

    private synchronized ImmutableSet<ZeroFeatureKey> m8054b(String str) {
        ImmutableSet<ZeroFeatureKey> of;
        of = ImmutableSet.of();
        try {
            if (!StringUtil.m3589a((CharSequence) str)) {
                of = ZeroFeatureKey.fromStrings(this.f4366c.m8060a(str));
            }
        } catch (Exception e) {
            BLog.b(f4364a, "Error de-serializing enabled UI features - %s: %s", new Object[]{e.getMessage(), e});
        }
        return of;
    }

    public final synchronized String m8056a(Iterable<ZeroFeatureKey> iterable) {
        return this.f4366c.m8061a(ZeroFeatureKey.toStrings(iterable));
    }
}
