package com.facebook.messaging.messageclassifier;

import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.attachment.Attachment;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceUtil;
import com.google.common.collect.ImmutableList;
import java.util.Map;
import java.util.WeakHashMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mRwLock */
public class MessageClassifier {
    private static volatile MessageClassifier f15446d;
    public final MessageExaminer f15447a;
    private final AttachmentClassifier f15448b;
    private final Map<Message, MessageClassification> f15449c = new WeakHashMap();

    public static com.facebook.messaging.messageclassifier.MessageClassifier m21990a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f15446d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.messageclassifier.MessageClassifier.class;
        monitor-enter(r1);
        r0 = f15446d;	 Catch:{ all -> 0x003a }
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
        r0 = m21991b(r0);	 Catch:{ all -> 0x0035 }
        f15446d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15446d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.messageclassifier.MessageClassifier.a(com.facebook.inject.InjectorLike):com.facebook.messaging.messageclassifier.MessageClassifier");
    }

    private static MessageClassifier m21991b(InjectorLike injectorLike) {
        return new MessageClassifier(MessageExaminer.m21995a(injectorLike), AttachmentClassifier.m22003a(injectorLike));
    }

    @Inject
    public MessageClassifier(MessageExaminer messageExaminer, AttachmentClassifier attachmentClassifier) {
        this.f15447a = messageExaminer;
        this.f15448b = attachmentClassifier;
    }

    public final MessageClassification m21993a(Message message) {
        MessageClassification messageClassification = (MessageClassification) this.f15449c.get(message);
        if (messageClassification != null) {
            return messageClassification;
        }
        messageClassification = m21992d(message);
        this.f15449c.put(message, messageClassification);
        return messageClassification;
    }

    public final String m21994b(Message message) {
        String str;
        if (message.j != null && !message.j.isEmpty()) {
            str = "h";
        } else if (message.u != null) {
            str = "h";
        } else if (StringUtil.m3599c(message.k)) {
            if (message.i != null && !message.i.isEmpty()) {
                Attachment attachment = (Attachment) message.i.get(0);
                if (AttachmentClassifier.m22004a(attachment)) {
                    str = "a";
                } else if (AttachmentClassifier.m22007d(attachment)) {
                    str = "v";
                } else if (AttachmentClassifier.m22006c(attachment)) {
                    str = "g";
                } else if (AttachmentClassifier.m22005b(attachment)) {
                    str = "i";
                } else {
                    str = "f";
                }
            } else if (message.t == null || message.t.isEmpty()) {
                str = "t";
            } else {
                MediaResource mediaResource = (MediaResource) message.t.get(0);
                if (mediaResource.d == Type.AUDIO) {
                    str = "a";
                } else if (mediaResource.d == Type.VIDEO) {
                    str = "v";
                } else if (mediaResource.d != Type.PHOTO) {
                    str = "f";
                } else if (mediaResource.c()) {
                    str = "g";
                } else {
                    str = "i";
                }
            }
        } else if ("227878347358915".equals(message.k) || "369239263222822".equals(message.k) || "369239343222814".equals(message.k) || "369239383222810".equals(message.k)) {
            str = "l";
        } else {
            str = "s";
        }
        String str2 = str;
        if (ThreadKey.f(message.b)) {
            return "p" + str2;
        }
        return str2;
    }

    private MessageClassification m21992d(Message message) {
        switch (1.a[message.l.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return MessageClassification.GROUP_MEMBERSHIP_CHANGE;
            case 3:
                return MessageClassification.GROUP_NAME_CHANGE;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
            case 5:
                return MessageClassification.GROUP_IMAGE_CHANGE;
            case 6:
            case 7:
                return MessageClassification.VIDEO_CALL;
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
            case 9:
            case 10:
                return MessageClassification.VOIP_CALL;
            case 11:
                return MessageClassification.CALL_LOG;
            case 12:
            case 13:
                return MessageClassification.TELEPHONE_COMMUNICATION_LOG;
            case 14:
            case 15:
            case HTTPTransportCallback.HEADER_BYTES_GENERATED /*16*/:
                MessageClassification messageClassification;
                if (message.k != null) {
                    messageClassification = MessageClassification.STICKER;
                } else {
                    Object obj;
                    int i;
                    MessageExaminer messageExaminer = this.f15447a;
                    Object obj2 = 1;
                    ImmutableList immutableList = message.i;
                    int size = immutableList.size();
                    int i2 = 0;
                    while (i2 < size) {
                        if (AttachmentClassifier.m22005b((Attachment) immutableList.get(i2))) {
                            i2++;
                        } else {
                            obj = 1;
                            if (message.i.size() == 0 || r3 != null) {
                                if (message.a().isEmpty()) {
                                    immutableList = message.a();
                                    size = immutableList.size();
                                    i2 = 0;
                                    while (i2 < size) {
                                        if (MediaResourceUtil.b((MediaResource) immutableList.get(i2))) {
                                            obj2 = null;
                                        } else {
                                            i2++;
                                        }
                                    }
                                } else {
                                    obj2 = null;
                                }
                            }
                            if (obj2 != null) {
                                messageClassification = MessageClassification.PHOTOS;
                            } else if (this.f15447a.m21997b(message)) {
                                messageExaminer = this.f15447a;
                                if (message.i.size() != 1 && AttachmentClassifier.m22004a((Attachment) message.i.get(0))) {
                                    i = 1;
                                } else if (message.a().size() == 1 || ((MediaResource) message.a().get(0)).d != Type.AUDIO) {
                                    i = 0;
                                } else {
                                    i = 1;
                                }
                                if (i != 0) {
                                    messageClassification = MessageClassification.AUDIO_CLIP;
                                } else if (this.f15447a.m21999e(message)) {
                                    messageClassification = MessageClassification.PAYMENT;
                                } else if (this.f15447a.m22000f(message)) {
                                    messageClassification = MessageClassification.MOMENTS_INVITE;
                                } else if (this.f15447a.m22001g(message)) {
                                    messageClassification = MessageClassification.NORMAL;
                                } else {
                                    messageClassification = MessageClassification.COMMERCE;
                                }
                            } else {
                                messageClassification = MessageClassification.VIDEO_CLIP;
                            }
                        }
                    }
                    obj = null;
                    if (message.a().isEmpty()) {
                        immutableList = message.a();
                        size = immutableList.size();
                        i2 = 0;
                        while (i2 < size) {
                            if (MediaResourceUtil.b((MediaResource) immutableList.get(i2))) {
                                i2++;
                            } else {
                                obj2 = null;
                            }
                        }
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        messageClassification = MessageClassification.PHOTOS;
                    } else if (this.f15447a.m21997b(message)) {
                        messageExaminer = this.f15447a;
                        if (message.i.size() != 1) {
                            break;
                        }
                        if (message.a().size() == 1) {
                            break;
                        }
                        i = 0;
                        if (i != 0) {
                            messageClassification = MessageClassification.AUDIO_CLIP;
                        } else if (this.f15447a.m21999e(message)) {
                            messageClassification = MessageClassification.PAYMENT;
                        } else if (this.f15447a.m22000f(message)) {
                            messageClassification = MessageClassification.MOMENTS_INVITE;
                        } else if (this.f15447a.m22001g(message)) {
                            messageClassification = MessageClassification.NORMAL;
                        } else {
                            messageClassification = MessageClassification.COMMERCE;
                        }
                    } else {
                        messageClassification = MessageClassification.VIDEO_CLIP;
                    }
                }
                return messageClassification;
            case 17:
                return MessageClassification.GLOBALLY_DELETED_MESSAGE_PLACEHOLDER;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
                return MessageClassification.ADMIN;
            default:
                throw new IllegalArgumentException("Unexpected message type");
        }
    }
}
