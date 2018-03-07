package com.facebook.assetdownload;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: profile_update_secondary_subscribe_status */
public class AssetDownloadConfigurationDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f7263a;

    static {
        GlobalAutoGenDeserializerCache.a(AssetDownloadConfiguration.class, new AssetDownloadConfigurationDeserializer());
        m10378e();
    }

    public AssetDownloadConfigurationDeserializer() {
        a(AssetDownloadConfiguration.class);
    }

    private static synchronized Map<String, FbJsonField> m10378e() {
        Map<String, FbJsonField> map;
        synchronized (AssetDownloadConfigurationDeserializer.class) {
            if (f7263a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("identifier", FbJsonField.jsonField(AssetDownloadConfiguration.class.getDeclaredField("mIdentifier")));
                    builder.b("source", FbJsonField.jsonField(AssetDownloadConfiguration.class.getDeclaredField("mStringSource")));
                    builder.b("priority", FbJsonField.jsonField(AssetDownloadConfiguration.class.getDeclaredField("mPriority")));
                    builder.b("connection_constraint", FbJsonField.jsonField(AssetDownloadConfiguration.class.getDeclaredField("mConnectionConstraint")));
                    builder.b("storage_constraint", FbJsonField.jsonField(AssetDownloadConfiguration.class.getDeclaredField("mStorageConstraint")));
                    builder.b("analytics_tag", FbJsonField.jsonField(AssetDownloadConfiguration.class.getDeclaredField("mAnalyticsTag")));
                    builder.b("custom_location", FbJsonField.jsonField(AssetDownloadConfiguration.class.getDeclaredField("mStringCustomLocation")));
                    builder.b("namespace", FbJsonField.jsonField(AssetDownloadConfiguration.class.getDeclaredField("mNamespace")));
                    builder.b("http_headers", FbJsonField.jsonField(AssetDownloadConfiguration.class.getDeclaredField("mHttpHeaders")));
                    f7263a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f7263a;
        }
        return map;
    }

    public final FbJsonField m10379a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m10378e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m10378e().keySet());
    }
}
