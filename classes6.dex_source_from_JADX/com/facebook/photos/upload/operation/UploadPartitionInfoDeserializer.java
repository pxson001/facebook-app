package com.facebook.photos.upload.operation;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: glDrawArrays */
public class UploadPartitionInfoDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13829a;

    static {
        GlobalAutoGenDeserializerCache.a(UploadPartitionInfo.class, new UploadPartitionInfoDeserializer());
        m21589e();
    }

    public UploadPartitionInfoDeserializer() {
        a(UploadPartitionInfo.class);
    }

    private static synchronized Map<String, FbJsonField> m21589e() {
        Map<String, FbJsonField> map;
        synchronized (UploadPartitionInfoDeserializer.class) {
            if (f13829a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("partitionStartOffset", FbJsonField.jsonField(UploadPartitionInfo.class.getDeclaredField("partitionStartOffset")));
                    builder.b("partitionEndOffset", FbJsonField.jsonField(UploadPartitionInfo.class.getDeclaredField("partitionEndOffset")));
                    builder.b("chunkedUploadOffset", FbJsonField.jsonField(UploadPartitionInfo.class.getDeclaredField("chunkedUploadOffset")));
                    builder.b("chunkedUploadChunkLength", FbJsonField.jsonField(UploadPartitionInfo.class.getDeclaredField("chunkedUploadChunkLength")));
                    f13829a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13829a;
        }
        return map;
    }

    public final FbJsonField m21590a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m21589e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m21589e().keySet());
    }
}
