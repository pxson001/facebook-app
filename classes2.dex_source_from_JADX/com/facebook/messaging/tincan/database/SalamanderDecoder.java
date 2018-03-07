package com.facebook.messaging.tincan.database;

import android.content.Context;
import android.util.Base64;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.attachments.DecryptedAttachmentProvider;
import com.facebook.messaging.model.attachment.Attachment;
import com.facebook.messaging.model.attachment.AttachmentBuilder;
import com.facebook.messaging.model.attachment.AttachmentBuilder.UrlBuilder;
import com.facebook.messaging.model.attachment.AttachmentImageMap;
import com.facebook.messaging.model.attachment.AttachmentImageMapBuilder;
import com.facebook.messaging.model.attachment.AttachmentImageType;
import com.facebook.messaging.model.attachment.ImageData;
import com.facebook.messaging.model.attachment.ImageData.Source;
import com.facebook.messaging.model.messages.GenericAdminMessageInfo;
import com.facebook.messaging.model.messages.Message.ChannelSource;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.send.SendError;
import com.facebook.messaging.model.send.SendErrorType;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.tincan.thrift.AttachmentInfo;
import com.facebook.messaging.tincan.thrift.ImageMetadata;
import com.facebook.messaging.tincan.thrift.Salamander;
import com.facebook.messaging.tincan.thrift.ThriftUtil;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: machine_id */
public class SalamanderDecoder {
    private static volatile SalamanderDecoder f15277d;
    private final ThriftUtil f15278a;
    private final Provider<String> f15279b;
    private final Provider<Context> f15280c;

    public static com.facebook.messaging.tincan.database.SalamanderDecoder m21822a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f15277d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.tincan.database.SalamanderDecoder.class;
        monitor-enter(r1);
        r0 = f15277d;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m21827b(r0);	 Catch:{ all -> 0x0035 }
        f15277d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15277d;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.SalamanderDecoder.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.database.SalamanderDecoder");
    }

    private static SalamanderDecoder m21827b(InjectorLike injectorLike) {
        return new SalamanderDecoder(ThriftUtil.m21835a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4442), injectorLike.getProvider(Context.class));
    }

    @Inject
    public SalamanderDecoder(ThriftUtil thriftUtil, Provider<String> provider, Provider<Context> provider2) {
        this.f15278a = thriftUtil;
        this.f15279b = provider;
        this.f15280c = provider2;
    }

    public final void m21833a(String str, String str2, long j, long j2, Salamander salamander, MessageBuilder messageBuilder) {
        m21821a(str, str2, j, j2, messageBuilder);
        m21832a(messageBuilder, str, salamander);
    }

    public final void m21832a(MessageBuilder messageBuilder, String str, Salamander salamander) {
        boolean z = true;
        if (salamander == null || salamander.type == null) {
            m21825a(messageBuilder);
            return;
        }
        try {
            if (salamander.type.intValue() == 3) {
                if (salamander.body == null || salamander.body.a() != 3) {
                    z = false;
                }
                Preconditions.checkState(z);
                messageBuilder.b(salamander.body.c());
            } else if (salamander.type.intValue() == 4) {
                if (salamander.body == null || salamander.body.a() != 4) {
                    z = false;
                }
                Preconditions.checkState(z);
                messageBuilder.a(m21823a(str, salamander.body.d()));
            } else if (salamander.type.intValue() == 2) {
                messageBuilder.b(((Context) this.f15280c.get()).getResources().getString(2131232401));
                m21829c(messageBuilder);
            } else if (salamander.type.intValue() == 6) {
                if (salamander.body == null || salamander.body.a() != 6) {
                    z = false;
                }
                Preconditions.checkState(z);
                messageBuilder.c(String.valueOf(salamander.body.f().fbid));
            } else if (salamander.type.intValue() == 5) {
                if (salamander.body == null) {
                    z = false;
                }
                Preconditions.checkState(z);
                messageBuilder.b(salamander.body.e());
                m21829c(messageBuilder);
            } else {
                m21828b(messageBuilder);
            }
            if (salamander.ephemeral_lifetime_micros != null && salamander.ephemeral_lifetime_micros.longValue() > 0) {
                messageBuilder.a(Integer.valueOf((int) Math.max(Math.min(salamander.ephemeral_lifetime_micros.longValue() / 1000, 2147483647L), 0)));
                if (messageBuilder.K() == null) {
                    messageBuilder.a(Long.valueOf(-1));
                }
            }
        } catch (IllegalStateException e) {
            m21825a(messageBuilder);
            throw e;
        }
    }

    @Nullable
    public final Salamander m21831a(byte[] bArr) {
        return ThriftUtil.m21837b(bArr);
    }

    public final ThreadKey m21830a(String str, long j) {
        String str2 = (String) this.f15279b.get();
        Preconditions.checkState(str2 != null);
        return ThreadKey.a(str, j, Long.parseLong(str2));
    }

    private MessageBuilder m21821a(String str, String str2, long j, long j2, MessageBuilder messageBuilder) {
        ParticipantInfo participantInfo = new ParticipantInfo(new UserKey(Type.FACEBOOK, Long.toString(j)), null);
        messageBuilder.a(str);
        messageBuilder.n = str;
        messageBuilder.b = m21830a(str2, j);
        messageBuilder.c = j2 / 1000;
        messageBuilder.e = participantInfo;
        messageBuilder.q = ChannelSource.MQTT;
        messageBuilder.p = "o";
        messageBuilder.g = messageBuilder.c;
        return messageBuilder;
    }

    private void m21825a(MessageBuilder messageBuilder) {
        m21824a(2131232404, messageBuilder);
    }

    private void m21828b(MessageBuilder messageBuilder) {
        m21824a(2131232403, messageBuilder);
    }

    private static void m21829c(MessageBuilder messageBuilder) {
        messageBuilder.l = MessageType.ADMIN;
        messageBuilder.u = SendError.a;
        messageBuilder.I = GenericAdminMessageInfo.newBuilder().a();
    }

    private static List<Attachment> m21823a(String str, List<AttachmentInfo> list) {
        List<Attachment> arrayList = new ArrayList();
        for (AttachmentInfo a : list) {
            arrayList.add(m21820a(str, a));
        }
        return arrayList;
    }

    private static Attachment m21820a(String str, AttachmentInfo attachmentInfo) {
        String encodeToString;
        String valueOf = String.valueOf(attachmentInfo.download_fbid);
        AttachmentBuilder attachmentBuilder = new AttachmentBuilder(valueOf, str);
        attachmentBuilder.c = valueOf;
        AttachmentBuilder attachmentBuilder2 = attachmentBuilder;
        attachmentBuilder2.e = attachmentInfo.suggested_file_name;
        attachmentBuilder2 = attachmentBuilder2;
        attachmentBuilder2.f = Ints.m4486a(attachmentInfo.download_size_bytes.longValue());
        attachmentBuilder2 = attachmentBuilder2;
        attachmentBuilder2.d = attachmentInfo.file_mime_type;
        attachmentBuilder2 = attachmentBuilder2;
        ImageMetadata imageMetadata = attachmentInfo.image_metadata;
        if (attachmentInfo.thumbnail_data != null) {
            encodeToString = Base64.encodeToString(attachmentInfo.thumbnail_data, 0);
        } else {
            encodeToString = null;
        }
        attachmentBuilder2.g = new ImageData(imageMetadata.width.intValue(), imageMetadata.height.intValue(), m21826b(attachmentInfo), null, Source.NONQUICKCAM, false, encodeToString);
        attachmentBuilder2 = attachmentBuilder2;
        attachmentBuilder2.j = Base64.encodeToString(attachmentInfo.secret_key, 0);
        return attachmentBuilder2.k();
    }

    public static AttachmentImageMap m21826b(AttachmentInfo attachmentInfo) {
        ImageMetadata imageMetadata = attachmentInfo.image_metadata;
        AttachmentImageMapBuilder attachmentImageMapBuilder = new AttachmentImageMapBuilder();
        AttachmentImageType attachmentImageType = AttachmentImageType.FULL_SCREEN;
        UrlBuilder urlBuilder = new UrlBuilder();
        urlBuilder.c = DecryptedAttachmentProvider.a(String.valueOf(attachmentInfo.download_fbid), Base64.encodeToString(attachmentInfo.secret_key, 0)).toString();
        urlBuilder = urlBuilder;
        urlBuilder.a = imageMetadata.width.intValue();
        urlBuilder = urlBuilder;
        urlBuilder.b = imageMetadata.height.intValue();
        return attachmentImageMapBuilder.a(attachmentImageType, urlBuilder.d()).b();
    }

    private void m21824a(int i, MessageBuilder messageBuilder) {
        if (messageBuilder.u.b == SendErrorType.NONE) {
            messageBuilder.f = ((Context) this.f15280c.get()).getResources().getString(i, new Object[]{messageBuilder.e.c});
            m21829c(messageBuilder);
        }
    }
}
