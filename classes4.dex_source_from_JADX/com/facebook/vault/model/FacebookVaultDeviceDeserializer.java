package com.facebook.vault.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: fetchFacewebUriMap */
public class FacebookVaultDeviceDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11786a;

    static {
        GlobalAutoGenDeserializerCache.a(FacebookVaultDevice.class, new FacebookVaultDeviceDeserializer());
        m12373e();
    }

    public FacebookVaultDeviceDeserializer() {
        a(FacebookVaultDevice.class);
    }

    private static synchronized Map<String, FbJsonField> m12373e() {
        Map<String, FbJsonField> map;
        synchronized (FacebookVaultDeviceDeserializer.class) {
            if (f11786a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(FacebookVaultDevice.class.getDeclaredField("mFbid")));
                    builder.b("owner_id", FbJsonField.jsonField(FacebookVaultDevice.class.getDeclaredField("mOwnerId")));
                    builder.b("identifier_value", FbJsonField.jsonField(FacebookVaultDevice.class.getDeclaredField("mIdentifier")));
                    builder.b("date_created", FbJsonField.jsonField(FacebookVaultDevice.class.getDeclaredField("mTimeCreated")));
                    builder.b("last_sync_time", FbJsonField.jsonField(FacebookVaultDevice.class.getDeclaredField("mLastSyncTime")));
                    builder.b("enabled", FbJsonField.jsonField(FacebookVaultDevice.class.getDeclaredField("mEnabled")));
                    builder.b("sync_mode", FbJsonField.jsonField(FacebookVaultDevice.class.getDeclaredField("mSyncMode")));
                    builder.b("sync_older_photos", FbJsonField.jsonField(FacebookVaultDevice.class.getDeclaredField("mSyncOlderPhotos")));
                    f11786a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11786a;
        }
        return map;
    }

    public final FbJsonField m12374a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m12373e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m12373e().keySet());
    }
}
