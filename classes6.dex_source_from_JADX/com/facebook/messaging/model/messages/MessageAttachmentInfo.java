package com.facebook.messaging.model.messages;

import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: upload_success */
public final class MessageAttachmentInfo {
    public final long f2036a;
    public final int f2037b;
    public final int f2038c;
    public final int f2039d;
    public final int f2040e;
    public final int f2041f;
    public final int f2042g;
    public final int f2043h;
    public final int f2044i;
    public final ImmutableListMultimap<Type, Source> f2045j;
    public final ImmutableList<String> f2046k;

    MessageAttachmentInfo(MessageAttachmentInfoBuilder messageAttachmentInfoBuilder) {
        this.f2036a = messageAttachmentInfoBuilder.f2049c;
        this.f2037b = messageAttachmentInfoBuilder.f2050d;
        this.f2038c = messageAttachmentInfoBuilder.f2051e;
        this.f2039d = messageAttachmentInfoBuilder.f2052f;
        this.f2040e = messageAttachmentInfoBuilder.f2053g;
        this.f2041f = messageAttachmentInfoBuilder.f2054h;
        this.f2042g = messageAttachmentInfoBuilder.f2055i;
        this.f2043h = messageAttachmentInfoBuilder.f2056j;
        this.f2044i = messageAttachmentInfoBuilder.f2057k;
        this.f2045j = ImmutableListMultimap.b(messageAttachmentInfoBuilder.f2047a);
        this.f2046k = ImmutableList.copyOf(messageAttachmentInfoBuilder.f2048b);
    }
}
