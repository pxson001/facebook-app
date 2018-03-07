package com.facebook.ipc.composer.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.ipc.composer.model.ComposerCommerceInfo.Builder;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: TOLL_FREE */
public class ComposerCommerceInfo_BuilderDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13937a;

    static {
        GlobalAutoGenDeserializerCache.a(Builder.class, new ComposerCommerceInfo_BuilderDeserializer());
        m23294e();
    }

    public ComposerCommerceInfo_BuilderDeserializer() {
        a(Builder.class);
    }

    private static synchronized Map<String, FbJsonField> m23294e() {
        Map<String, FbJsonField> map;
        synchronized (ComposerCommerceInfo_BuilderDeserializer.class) {
            if (f13937a == null) {
                try {
                    ImmutableMap.Builder builder = new ImmutableMap.Builder();
                    builder.b("currency_code", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setCurrencyCode", new Class[]{String.class})));
                    builder.b("intercept_words", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setInterceptWords", new Class[]{ImmutableList.class}), String.class));
                    builder.b("intercept_words_after_number", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setInterceptWordsAfterNumber", new Class[]{ImmutableList.class}), String.class));
                    builder.b("is_category_optional", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setIsCategoryOptional", new Class[]{Boolean.TYPE})));
                    builder.b("marketplace_cross_post_setting_model", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setMarketplaceCrossPostSettingModel", new Class[]{MarketplaceCrossPostSettingModel.class})));
                    builder.b("prefill_category_id", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setPrefillCategoryId", new Class[]{String.class})));
                    builder.b("product_item_location_picker_settings", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setProductItemLocationPickerSettings", new Class[]{ProductItemLocationPickerSettings.class})));
                    f13937a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13937a;
        }
        return map;
    }

    public final FbJsonField m23295a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23294e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23294e().keySet());
    }
}
