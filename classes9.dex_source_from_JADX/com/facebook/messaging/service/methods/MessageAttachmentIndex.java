package com.facebook.messaging.service.methods;

import com.facebook.messaging.model.attachment.AttachmentImageMap;
import com.facebook.messaging.model.attachment.AttachmentImageMapBuilder;
import com.facebook.messaging.model.attachment.AttachmentImageType;
import com.facebook.messaging.model.attachment.ImageUrl;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: custom_user_agent_suffix */
public class MessageAttachmentIndex {
    public static MessageAttachmentIndex f16937a = new MessageAttachmentIndex(Collections.emptyMap());
    private final Map<String, AttachmentData> f16938b;

    /* compiled from: custom_user_agent_suffix */
    public class AttachmentData {
        @Nullable
        public AttachmentImageMapBuilder f16935a;
        @Nullable
        public AttachmentImageMapBuilder f16936b;
    }

    MessageAttachmentIndex() {
        this.f16938b = new HashMap();
    }

    private MessageAttachmentIndex(Map<String, AttachmentData> map) {
        this.f16938b = map;
    }

    final void m16971a(String str, AttachmentImageType attachmentImageType, ImageUrl imageUrl) {
        AttachmentData c = m16969c(str);
        if (c.f16935a == null) {
            c.f16935a = new AttachmentImageMapBuilder();
        }
        c.f16935a.a(attachmentImageType, imageUrl);
    }

    final void m16973b(String str, AttachmentImageType attachmentImageType, ImageUrl imageUrl) {
        AttachmentData c = m16969c(str);
        if (c.f16936b == null) {
            c.f16936b = new AttachmentImageMapBuilder();
        }
        c.f16936b.a(attachmentImageType, imageUrl);
    }

    private AttachmentData m16969c(String str) {
        AttachmentData attachmentData = (AttachmentData) this.f16938b.get(str);
        if (attachmentData != null) {
            return attachmentData;
        }
        attachmentData = new AttachmentData();
        this.f16938b.put(str, attachmentData);
        return attachmentData;
    }

    @Nullable
    final AttachmentImageMap m16970a(String str) {
        AttachmentData attachmentData = (AttachmentData) this.f16938b.get(str);
        if (attachmentData == null) {
            return null;
        }
        return attachmentData.f16935a != null ? attachmentData.f16935a.b() : null;
    }

    @Nullable
    final AttachmentImageMap m16972b(String str) {
        AttachmentData attachmentData = (AttachmentData) this.f16938b.get(str);
        if (attachmentData == null) {
            return null;
        }
        return attachmentData.f16936b != null ? attachmentData.f16936b.b() : null;
    }
}
