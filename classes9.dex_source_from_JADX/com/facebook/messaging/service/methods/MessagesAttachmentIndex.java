package com.facebook.messaging.service.methods;

import com.facebook.messaging.model.attachment.AttachmentImageType;
import com.facebook.messaging.model.attachment.ImageUrl;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: custom_nicknames */
public class MessagesAttachmentIndex {
    public final Map<String, MessageAttachmentIndex> f16949a = new HashMap();

    public final void m16982a(String str, String str2, AttachmentImageType attachmentImageType, ImageUrl imageUrl) {
        m16981b(str).m16971a(str2, attachmentImageType, imageUrl);
    }

    public final void m16983b(String str, String str2, AttachmentImageType attachmentImageType, ImageUrl imageUrl) {
        m16981b(str).m16973b(str2, attachmentImageType, imageUrl);
    }

    private MessageAttachmentIndex m16981b(String str) {
        MessageAttachmentIndex messageAttachmentIndex = (MessageAttachmentIndex) this.f16949a.get(str);
        if (messageAttachmentIndex != null) {
            return messageAttachmentIndex;
        }
        messageAttachmentIndex = new MessageAttachmentIndex();
        this.f16949a.put(str, messageAttachmentIndex);
        return messageAttachmentIndex;
    }
}
