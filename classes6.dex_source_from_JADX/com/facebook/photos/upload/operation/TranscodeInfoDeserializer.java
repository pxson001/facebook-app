package com.facebook.photos.upload.operation;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: gms_ls_upsell_result */
public class TranscodeInfoDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13690a;

    static {
        GlobalAutoGenDeserializerCache.a(TranscodeInfo.class, new TranscodeInfoDeserializer());
        m21440e();
    }

    public TranscodeInfoDeserializer() {
        a(TranscodeInfo.class);
    }

    private static synchronized Map<String, FbJsonField> m21440e() {
        Map<String, FbJsonField> map;
        synchronized (TranscodeInfoDeserializer.class) {
            if (f13690a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("flowStartCount", FbJsonField.jsonField(TranscodeInfo.class.getDeclaredField("flowStartCount")));
                    builder.b("transcodeStartCount", FbJsonField.jsonField(TranscodeInfo.class.getDeclaredField("transcodeStartCount")));
                    builder.b("transcodeSuccessCount", FbJsonField.jsonField(TranscodeInfo.class.getDeclaredField("transcodeSuccessCount")));
                    builder.b("transcodeFailCount", FbJsonField.jsonField(TranscodeInfo.class.getDeclaredField("transcodeFailCount")));
                    builder.b("isSegmentedTranscode", FbJsonField.jsonField(TranscodeInfo.class.getDeclaredField("isSegmentedTranscode")));
                    builder.b("isRequestedServerSettings", FbJsonField.jsonField(TranscodeInfo.class.getDeclaredField("isRequestedServerSettings")));
                    builder.b("isServerSettingsAvailable", FbJsonField.jsonField(TranscodeInfo.class.getDeclaredField("isServerSettingsAvailable")));
                    builder.b("serverSpecifiedTranscodeBitrate", FbJsonField.jsonField(TranscodeInfo.class.getDeclaredField("serverSpecifiedTranscodeBitrate")));
                    builder.b("serverSpecifiedTranscodeDimension", FbJsonField.jsonField(TranscodeInfo.class.getDeclaredField("serverSpecifiedTranscodeDimension")));
                    f13690a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13690a;
        }
        return map;
    }

    public final FbJsonField m21441a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m21440e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m21440e().keySet());
    }
}
