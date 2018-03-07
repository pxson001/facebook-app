package com.facebook.messaging.tincan.messenger;

import android.util.Base64;
import com.facebook.messaging.model.attachment.Attachment;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.tincan.thrift.AttachmentInfo;
import com.facebook.messaging.tincan.thrift.ImageMetadata;
import com.facebook.messaging.tincan.thrift.SalamanderBody;
import com.facebook.messaging.tincan.thrift.ThriftFactory;
import com.facebook.messaging.tincan.thrift.ThriftUtil;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: click_term_checkbox */
public class SignedContentBinaryCreator {
    public static byte[] m18021a(Message message) {
        List arrayList = new ArrayList();
        ImmutableList immutableList = message.i;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(m18020a((Attachment) immutableList.get(i)));
        }
        return ThriftUtil.a(ThriftFactory.m18182a(4, SalamanderBody.m18150a(arrayList), message.J));
    }

    private static AttachmentInfo m18020a(Attachment attachment) {
        Preconditions.checkNotNull(attachment.c);
        Long valueOf = Long.valueOf(Long.parseLong(attachment.c));
        byte[] decode = Base64.decode(attachment.j, 0);
        Long valueOf2 = Long.valueOf((long) attachment.f);
        String str = attachment.e;
        String str2 = attachment.d;
        String str3 = attachment.g.g;
        return ThriftFactory.m18177a(decode, valueOf, valueOf2, null, str, str2, str3 != null ? Base64.decode(str3, 0) : null, new ImageMetadata(Integer.valueOf(attachment.g.a), Integer.valueOf(attachment.g.b)), null);
    }
}
