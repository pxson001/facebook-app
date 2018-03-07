package com.facebook.ipc.composer.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.ipc.composer.model.ProductItemLocationPickerSettings.Builder;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: TIMELINE_COLLECTIONS_PYMK */
public class ProductItemLocationPickerSettings_BuilderDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14028a;

    static {
        GlobalAutoGenDeserializerCache.a(Builder.class, new ProductItemLocationPickerSettings_BuilderDeserializer());
        m23407e();
    }

    public ProductItemLocationPickerSettings_BuilderDeserializer() {
        a(Builder.class);
    }

    private static synchronized Map<String, FbJsonField> m23407e() {
        Map<String, FbJsonField> map;
        synchronized (ProductItemLocationPickerSettings_BuilderDeserializer.class) {
            if (f14028a == null) {
                try {
                    ImmutableMap.Builder builder = new ImmutableMap.Builder();
                    builder.b("is_compulsory", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setIsCompulsory", new Class[]{Boolean.TYPE})));
                    builder.b("use_neighborhood_data_source", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setUseNeighborhoodDataSource", new Class[]{Boolean.TYPE})));
                    builder.b("use_zip_code", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setUseZipCode", new Class[]{Boolean.TYPE})));
                    f14028a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14028a;
        }
        return map;
    }

    public final FbJsonField m23408a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23407e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23407e().keySet());
    }
}
