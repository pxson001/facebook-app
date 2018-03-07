package com.facebook.messaging.model.attachment;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: v0.1 */
public enum AttachmentImageType {
    FULL_SCREEN(Integer.valueOf(0), "FULL_SCREEN"),
    SMALL_PREVIEW(Integer.valueOf(3), "SMALL_PREVIEW"),
    MEDIUM_PREVIEW(Integer.valueOf(2), "MEDIUM_PREVIEW"),
    LARGE_PREVIEW(Integer.valueOf(1), "LARGE_PREVIEW");
    
    public final Integer persistentIndex;
    public final String serializedName;

    private AttachmentImageType(Integer num, String str) {
        this.persistentIndex = num;
        this.serializedName = str;
    }

    @Nullable
    public static AttachmentImageType fromSerializedName(String str) {
        for (AttachmentImageType attachmentImageType : values()) {
            if (Objects.equal(attachmentImageType.serializedName, str)) {
                return attachmentImageType;
            }
        }
        return null;
    }

    public static AttachmentImageType fromPersistentIndex(int i) {
        boolean z = i >= 0 && i <= 3;
        Preconditions.checkState(z);
        switch (i) {
            case 0:
                return FULL_SCREEN;
            case 1:
                return LARGE_PREVIEW;
            case 2:
                return MEDIUM_PREVIEW;
            case 3:
                return SMALL_PREVIEW;
            default:
                throw new IllegalArgumentException();
        }
    }
}
