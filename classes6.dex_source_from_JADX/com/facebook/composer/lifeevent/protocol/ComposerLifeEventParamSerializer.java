package com.facebook.composer.lifeevent.protocol;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: place_lat_lng */
public class ComposerLifeEventParamSerializer extends JsonSerializer<ComposerLifeEventParam> {
    public final void m11273a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ComposerLifeEventParam composerLifeEventParam = (ComposerLifeEventParam) obj;
        if (composerLifeEventParam == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m11272b(composerLifeEventParam, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ComposerLifeEventParam.class, new ComposerLifeEventParamSerializer());
    }

    private static void m11272b(ComposerLifeEventParam composerLifeEventParam, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "composer_session_id", composerLifeEventParam.composerSessionId);
        AutoGenJsonHelper.a(jsonGenerator, "user_id", composerLifeEventParam.userId);
        AutoGenJsonHelper.a(jsonGenerator, "icon_id", composerLifeEventParam.iconId);
        AutoGenJsonHelper.a(jsonGenerator, "description", composerLifeEventParam.description);
        AutoGenJsonHelper.a(jsonGenerator, "story", composerLifeEventParam.story);
        AutoGenJsonHelper.a(jsonGenerator, "start_date", composerLifeEventParam.startDate);
        AutoGenJsonHelper.a(jsonGenerator, "end_date", composerLifeEventParam.endDate);
        AutoGenJsonHelper.a(jsonGenerator, "surface", composerLifeEventParam.surface);
        AutoGenJsonHelper.a(jsonGenerator, "place", composerLifeEventParam.place);
        AutoGenJsonHelper.a(jsonGenerator, "privacy", composerLifeEventParam.privacy);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "tags", composerLifeEventParam.tags);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "photo_fbids", composerLifeEventParam.photoFbids);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "life_event_type", composerLifeEventParam.lifeEventType);
        AutoGenJsonHelper.a(jsonGenerator, "should_update_relationship_status", Boolean.valueOf(composerLifeEventParam.shouldUpdateRelationshipStatus));
        AutoGenJsonHelper.a(jsonGenerator, "is_graduate", Boolean.valueOf(composerLifeEventParam.isGraduated));
        AutoGenJsonHelper.a(jsonGenerator, "school_type", composerLifeEventParam.schoolType);
        AutoGenJsonHelper.a(jsonGenerator, "school_hub_id", composerLifeEventParam.schoolHubId);
        AutoGenJsonHelper.a(jsonGenerator, "is_current", Boolean.valueOf(composerLifeEventParam.isCurrent));
        AutoGenJsonHelper.a(jsonGenerator, "employer_hub_id", composerLifeEventParam.employerHubId);
    }
}
