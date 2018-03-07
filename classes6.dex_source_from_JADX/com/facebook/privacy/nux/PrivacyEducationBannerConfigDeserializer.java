package com.facebook.privacy.nux;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: fbupload_file_upload_failed */
public class PrivacyEducationBannerConfigDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f15118a;

    static {
        GlobalAutoGenDeserializerCache.a(PrivacyEducationBannerConfig.class, new PrivacyEducationBannerConfigDeserializer());
        m22715e();
    }

    public PrivacyEducationBannerConfigDeserializer() {
        a(PrivacyEducationBannerConfig.class);
    }

    private static synchronized Map<String, FbJsonField> m22715e() {
        Map<String, FbJsonField> map;
        synchronized (PrivacyEducationBannerConfigDeserializer.class) {
            if (f15118a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("seen_counts", FbJsonField.jsonField(PrivacyEducationBannerConfig.class.getDeclaredField("mSeenCounts")));
                    builder.b("banner_expanded", FbJsonField.jsonField(PrivacyEducationBannerConfig.class.getDeclaredField("mBannersExpanded")));
                    f15118a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f15118a;
        }
        return map;
    }

    public final FbJsonField m22716a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m22715e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m22715e().keySet());
    }
}
