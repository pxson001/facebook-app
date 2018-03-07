package com.facebook.friendsharing.souvenirs.layout;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: Received an ACTION_CANCEL touch event for which we have no corresponding ACTION_DOWN */
public class SouvenirEditorModelDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f24046a;

    static {
        GlobalAutoGenDeserializerCache.a(SouvenirEditorModel.class, new SouvenirEditorModelDeserializer());
        m26145e();
    }

    public SouvenirEditorModelDeserializer() {
        a(SouvenirEditorModel.class);
    }

    private static synchronized Map<String, FbJsonField> m26145e() {
        Map<String, FbJsonField> map;
        synchronized (SouvenirEditorModelDeserializer.class) {
            if (f24046a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("metadata", FbJsonField.jsonField(SouvenirEditorModel.class.getDeclaredField("mMetadata")));
                    builder.b("rows", FbJsonField.jsonField(SouvenirEditorModel.class.getDeclaredField("mRows"), SouvenirRow.class));
                    f24046a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f24046a;
        }
        return map;
    }

    public final FbJsonField m26146a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m26145e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m26145e().keySet());
    }
}
