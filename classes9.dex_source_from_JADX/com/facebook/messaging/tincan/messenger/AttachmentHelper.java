package com.facebook.messaging.tincan.messenger;

import com.facebook.messaging.attachments.DecryptedAttachmentProvider;
import com.facebook.messaging.model.attachment.Attachment;
import com.facebook.messaging.model.attachment.AttachmentBuilder;
import com.facebook.messaging.model.attachment.AttachmentBuilder.UrlBuilder;
import com.facebook.messaging.model.attachment.AttachmentImageMapBuilder;
import com.facebook.messaging.model.attachment.AttachmentImageType;
import com.facebook.messaging.model.attachment.ImageData;
import com.facebook.messaging.model.attachment.ImageData.Source;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.primitives.Ints;
import javax.annotation.Nullable;

/* compiled from: client_country */
public class AttachmentHelper {
    public static Attachment m17970a(MediaResource mediaResource, String str, String str2, @Nullable String str3) {
        AttachmentBuilder attachmentBuilder = new AttachmentBuilder(str, str2);
        attachmentBuilder.e = mediaResource.c.getLastPathSegment();
        attachmentBuilder = attachmentBuilder;
        attachmentBuilder.f = Ints.a(mediaResource.p);
        attachmentBuilder = attachmentBuilder;
        attachmentBuilder.d = mediaResource.o;
        attachmentBuilder = attachmentBuilder;
        attachmentBuilder.g = m17971a(mediaResource, str, str3);
        attachmentBuilder = attachmentBuilder;
        attachmentBuilder.c = str;
        attachmentBuilder = attachmentBuilder;
        attachmentBuilder.j = mediaResource.D;
        return attachmentBuilder.k();
    }

    private static ImageData m17971a(MediaResource mediaResource, String str, @Nullable String str2) {
        int i = mediaResource.j;
        int i2 = mediaResource.k;
        AttachmentImageMapBuilder attachmentImageMapBuilder = new AttachmentImageMapBuilder();
        AttachmentImageType attachmentImageType = AttachmentImageType.FULL_SCREEN;
        UrlBuilder urlBuilder = new UrlBuilder();
        urlBuilder.c = DecryptedAttachmentProvider.m8001a(str, mediaResource.D).toString();
        urlBuilder = urlBuilder;
        urlBuilder.a = mediaResource.j;
        urlBuilder = urlBuilder;
        urlBuilder.b = mediaResource.k;
        return new ImageData(i, i2, attachmentImageMapBuilder.a(attachmentImageType, urlBuilder.d()).b(), null, Source.NONQUICKCAM, false, str2);
    }
}
