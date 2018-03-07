package com.facebook.composer.lifeevent.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: place_level_number */
public class ComposerLifeEventParamDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f7861a;

    static {
        GlobalAutoGenDeserializerCache.a(ComposerLifeEventParam.class, new ComposerLifeEventParamDeserializer());
        m11270e();
    }

    public ComposerLifeEventParamDeserializer() {
        a(ComposerLifeEventParam.class);
    }

    private static synchronized Map<String, FbJsonField> m11270e() {
        Map<String, FbJsonField> map;
        synchronized (ComposerLifeEventParamDeserializer.class) {
            if (f7861a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("composer_session_id", FbJsonField.jsonField(ComposerLifeEventParam.class.getDeclaredField("composerSessionId")));
                    builder.b("user_id", FbJsonField.jsonField(ComposerLifeEventParam.class.getDeclaredField("userId")));
                    builder.b("icon_id", FbJsonField.jsonField(ComposerLifeEventParam.class.getDeclaredField("iconId")));
                    builder.b("description", FbJsonField.jsonField(ComposerLifeEventParam.class.getDeclaredField("description")));
                    builder.b("story", FbJsonField.jsonField(ComposerLifeEventParam.class.getDeclaredField("story")));
                    builder.b("start_date", FbJsonField.jsonField(ComposerLifeEventParam.class.getDeclaredField("startDate")));
                    builder.b("end_date", FbJsonField.jsonField(ComposerLifeEventParam.class.getDeclaredField("endDate")));
                    builder.b("surface", FbJsonField.jsonField(ComposerLifeEventParam.class.getDeclaredField("surface")));
                    builder.b("place", FbJsonField.jsonField(ComposerLifeEventParam.class.getDeclaredField("place")));
                    builder.b("privacy", FbJsonField.jsonField(ComposerLifeEventParam.class.getDeclaredField("privacy")));
                    builder.b("tags", FbJsonField.jsonField(ComposerLifeEventParam.class.getDeclaredField("tags"), String.class));
                    builder.b("photo_fbids", FbJsonField.jsonField(ComposerLifeEventParam.class.getDeclaredField("photoFbids"), String.class));
                    builder.b("life_event_type", FbJsonField.jsonField(ComposerLifeEventParam.class.getDeclaredField("lifeEventType")));
                    builder.b("should_update_relationship_status", FbJsonField.jsonField(ComposerLifeEventParam.class.getDeclaredField("shouldUpdateRelationshipStatus")));
                    builder.b("is_graduate", FbJsonField.jsonField(ComposerLifeEventParam.class.getDeclaredField("isGraduated")));
                    builder.b("school_type", FbJsonField.jsonField(ComposerLifeEventParam.class.getDeclaredField("schoolType")));
                    builder.b("school_hub_id", FbJsonField.jsonField(ComposerLifeEventParam.class.getDeclaredField("schoolHubId")));
                    builder.b("is_current", FbJsonField.jsonField(ComposerLifeEventParam.class.getDeclaredField("isCurrent")));
                    builder.b("employer_hub_id", FbJsonField.jsonField(ComposerLifeEventParam.class.getDeclaredField("employerHubId")));
                    f7861a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f7861a;
        }
        return map;
    }

    public final FbJsonField m11271a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m11270e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m11270e().keySet());
    }
}
