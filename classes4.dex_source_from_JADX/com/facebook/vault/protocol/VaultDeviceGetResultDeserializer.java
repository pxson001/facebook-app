package com.facebook.vault.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.vault.model.FacebookVaultDevice;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: fetchImage */
public class VaultDeviceGetResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11779a;

    static {
        GlobalAutoGenDeserializerCache.a(VaultDeviceGetResult.class, new VaultDeviceGetResultDeserializer());
        m12360e();
    }

    public VaultDeviceGetResultDeserializer() {
        a(VaultDeviceGetResult.class);
    }

    private static synchronized Map<String, FbJsonField> m12360e() {
        Map<String, FbJsonField> map;
        synchronized (VaultDeviceGetResultDeserializer.class) {
            if (f11779a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("data", FbJsonField.jsonField(VaultDeviceGetResult.class.getDeclaredField("data"), FacebookVaultDevice.class));
                    f11779a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11779a;
        }
        return map;
    }

    public final FbJsonField m12361a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m12360e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m12360e().keySet());
    }
}
