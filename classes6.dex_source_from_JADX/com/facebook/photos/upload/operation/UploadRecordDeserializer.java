package com.facebook.photos.upload.operation;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: glCreateProgram */
public class UploadRecordDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13831a;

    static {
        GlobalAutoGenDeserializerCache.a(UploadRecord.class, new UploadRecordDeserializer());
        m21595e();
    }

    public UploadRecordDeserializer() {
        a(UploadRecord.class);
    }

    private static synchronized Map<String, FbJsonField> m21595e() {
        Map<String, FbJsonField> map;
        synchronized (UploadRecordDeserializer.class) {
            if (f13831a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("fbid", FbJsonField.jsonField(UploadRecord.class.getDeclaredField("fbid")));
                    builder.b("uploadTime", FbJsonField.jsonField(UploadRecord.class.getDeclaredField("uploadTime")));
                    builder.b("isRawUpload", FbJsonField.jsonField(UploadRecord.class.getDeclaredField("isRawUpload")));
                    builder.b("sameHashExist", FbJsonField.jsonField(UploadRecord.class.getDeclaredField("sameHashExist")));
                    builder.b("partitionInfo", FbJsonField.jsonField(UploadRecord.class.getDeclaredField("partitionInfo"), UploadPartitionInfo.class));
                    builder.b("videoId", FbJsonField.jsonField(UploadRecord.class.getDeclaredField("videoId")));
                    builder.b("transcodeInfo", FbJsonField.jsonField(UploadRecord.class.getDeclaredField("transcodeInfo")));
                    builder.b("multimediaInfo", FbJsonField.jsonField(UploadRecord.class.getDeclaredField("multimediaInfo")));
                    f13831a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13831a;
        }
        return map;
    }

    public final FbJsonField m21596a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m21595e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m21595e().keySet());
    }
}
