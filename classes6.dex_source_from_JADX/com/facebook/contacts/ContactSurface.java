package com.facebook.contacts;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = ContactSurfaceDeserializer.class)
/* compiled from: photo_num_likes */
public enum ContactSurface {
    GROWTH_CONTACT_IMPORTER,
    MESSENGER,
    OTHERS;

    @JsonCreator
    public static ContactSurface fromString(String str) {
        if (GROWTH_CONTACT_IMPORTER.name().equals(str)) {
            return GROWTH_CONTACT_IMPORTER;
        }
        if (MESSENGER.name().equals(str)) {
            return MESSENGER;
        }
        return OTHERS;
    }
}
