package com.facebook.privacy.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: fed92222a692cfa09cd76182cddf12d9 */
public class PrivacyOptionsResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f15092a;

    static {
        GlobalAutoGenDeserializerCache.a(PrivacyOptionsResult.class, new PrivacyOptionsResultDeserializer());
        m22681e();
    }

    public PrivacyOptionsResultDeserializer() {
        a(PrivacyOptionsResult.class);
    }

    private static synchronized Map<String, FbJsonField> m22681e() {
        Map<String, FbJsonField> map;
        synchronized (PrivacyOptionsResultDeserializer.class) {
            if (f15092a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("basic_privacy_options", FbJsonField.jsonField(PrivacyOptionsResult.class.getDeclaredField("basicPrivacyOptions"), GraphQLPrivacyOption.class));
                    builder.b("friend_list_privacy_options", FbJsonField.jsonField(PrivacyOptionsResult.class.getDeclaredField("friendListPrivacyOptions"), GraphQLPrivacyOption.class));
                    builder.b("selected_privacy_option", FbJsonField.jsonField(PrivacyOptionsResult.class.getDeclaredField("selectedPrivacyOption")));
                    builder.b("is_selected_option_external", FbJsonField.jsonField(PrivacyOptionsResult.class.getDeclaredField("isSelectedOptionExternal")));
                    builder.b("recent_privacy_option", FbJsonField.jsonField(PrivacyOptionsResult.class.getDeclaredField("recentPrivacyOption")));
                    builder.b("is_result_from_server", FbJsonField.jsonField(PrivacyOptionsResult.class.getDeclaredField("isResultFromServer")));
                    f15092a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f15092a;
        }
        return map;
    }

    public final FbJsonField m22682a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m22681e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m22681e().keySet());
    }
}
