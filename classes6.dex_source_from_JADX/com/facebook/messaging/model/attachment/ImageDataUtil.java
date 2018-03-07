package com.facebook.messaging.model.attachment;

import javax.annotation.Nullable;

/* compiled from: user_selected_place */
public class ImageDataUtil {
    public static boolean m3263a(AttachmentImageMap attachmentImageMap) {
        for (AttachmentImageType a : AttachmentImageType.values()) {
            if (!m3264a(attachmentImageMap.m3259a(a))) {
                return false;
            }
        }
        return true;
    }

    private static boolean m3264a(@Nullable ImageUrl imageUrl) {
        return (imageUrl == null || imageUrl.f1894c == null) ? false : true;
    }

    public static boolean m3265b(AttachmentImageMap attachmentImageMap) {
        for (AttachmentImageType attachmentImageType : AttachmentImageType.values()) {
            ImageUrl a = attachmentImageMap.m3259a(attachmentImageType);
            if (attachmentImageType == AttachmentImageType.FULL_SCREEN) {
                if (!m3264a(a)) {
                    return false;
                }
            } else if (m3264a(a)) {
                return false;
            }
        }
        return true;
    }

    public static String m3262a(String str, AttachmentImageMap attachmentImageMap) {
        StringBuilder stringBuilder = new StringBuilder(200);
        stringBuilder.append("Message ID: ").append(str).append('\n');
        for (AttachmentImageType attachmentImageType : AttachmentImageType.values()) {
            ImageUrl a = attachmentImageMap.m3259a(attachmentImageType);
            if (a == null) {
                stringBuilder.append(attachmentImageType.name()).append(" - Not in the URL map\n");
            } else if (a.f1894c == null) {
                stringBuilder.append(attachmentImageType.name()).append(" - SRC is null for type\n");
            }
        }
        return stringBuilder.toString();
    }
}
