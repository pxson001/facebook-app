package com.facebook.messaging.model.messages;

import com.facebook.common.tempfile.BackingFileResolver;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.share.SentShareAttachment;
import com.facebook.stickers.model.StickerUtil;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: upload_speed_previous */
public class MessageAttachmentInfoFactory {
    public BackingFileResolver f2058a;

    public static MessageAttachmentInfoFactory m3366b(InjectorLike injectorLike) {
        return new MessageAttachmentInfoFactory(BackingFileResolver.a(injectorLike));
    }

    @Inject
    public MessageAttachmentInfoFactory(BackingFileResolver backingFileResolver) {
        this.f2058a = backingFileResolver;
    }

    public final MessageAttachmentInfo m3368a(Message message) {
        return m3367c(message).m3364s();
    }

    public final MessageAttachmentInfo m3369b(Message message) {
        MessageAttachmentInfoBuilder c = m3367c(message);
        long j = 0;
        ImmutableList a = message.m3361a();
        for (int i = 0; i < a.size(); i++) {
            j += this.f2058a.b(((MediaResource) a.get(i)).f5166c);
        }
        c.m3362a(j);
        return c.m3364s();
    }

    private static MessageAttachmentInfoBuilder m3367c(Message message) {
        MessageAttachmentInfoBuilder messageAttachmentInfoBuilder = new MessageAttachmentInfoBuilder();
        ImmutableList a = message.m3361a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            MediaResource mediaResource = (MediaResource) a.get(i);
            if (mediaResource.f5167d == Type.AUDIO) {
                messageAttachmentInfoBuilder.f2052f++;
            } else if (mediaResource.f5167d == Type.PHOTO) {
                messageAttachmentInfoBuilder.f2050d++;
            } else if (mediaResource.f5167d == Type.VIDEO) {
                messageAttachmentInfoBuilder.f2051e++;
            }
            messageAttachmentInfoBuilder.f2047a.a(mediaResource.f5167d, mediaResource.f5168e);
            String str = mediaResource.f5178o;
            if (str != null) {
                messageAttachmentInfoBuilder.m3363a(str);
            } else {
                messageAttachmentInfoBuilder.m3363a("unknown");
            }
        }
        if (message.f2030u != null) {
            if (message.f2030u.f2179a == SentShareAttachment.Type.SHARE) {
                messageAttachmentInfoBuilder.f2055i++;
            } else if (message.f2030u.f2179a == SentShareAttachment.Type.PAYMENT) {
                messageAttachmentInfoBuilder.f2056j++;
            }
            messageAttachmentInfoBuilder.f2055i += message.f2019j.toArray().length;
        }
        if (!Strings.isNullOrEmpty(message.f2020k)) {
            if (StickerUtil.m7771a(message.f2020k)) {
                messageAttachmentInfoBuilder.f2054h++;
            } else {
                messageAttachmentInfoBuilder.f2053g++;
            }
        }
        return messageAttachmentInfoBuilder;
    }

    public static MessageAttachmentInfoFactory m3365a(InjectorLike injectorLike) {
        return m3366b(injectorLike);
    }
}
