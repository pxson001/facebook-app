package com.facebook.messaging.model.messagemetadata;

import com.google.common.base.Objects;
import com.google.common.base.Strings;

/* compiled from: uri_when_installed */
public enum PlatformMetadataType {
    NONE(""),
    IGNORE_FOR_WEBHOOK("ignore_for_webhook"),
    QUICK_REPLIES("quick_replies");
    
    public final String value;

    private PlatformMetadataType(String str) {
        this.value = str;
    }

    public static PlatformMetadataType fromRawValue(String str) {
        if (Strings.isNullOrEmpty(str)) {
            return NONE;
        }
        for (PlatformMetadataType platformMetadataType : values()) {
            if (Objects.equal(platformMetadataType.value, str)) {
                return platformMetadataType;
            }
        }
        return NONE;
    }
}
