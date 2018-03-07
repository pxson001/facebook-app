package com.facebook.messaging.messageclassifier;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentMediaModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentStoryFieldsModel;
import com.facebook.messaging.model.attachment.Attachment;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.share.SentShareAttachment;
import com.facebook.messaging.model.share.Share;
import com.facebook.messaging.momentsinvite.model.MomentsInviteData;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: mRetaining= */
public class MessageExaminer {
    private static volatile MessageExaminer f15450g;
    private final AttachmentClassifier f15451a;
    private final Provider<Boolean> f15452b;
    private final Provider<Boolean> f15453c;
    private final Provider<Boolean> f15454d;
    private final Provider<Boolean> f15455e;
    private final Provider<Boolean> f15456f;

    public static com.facebook.messaging.messageclassifier.MessageExaminer m21995a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15450g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.messageclassifier.MessageExaminer.class;
        monitor-enter(r1);
        r0 = f15450g;	 Catch:{ all -> 0x003a }
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
        r0 = m21996b(r0);	 Catch:{ all -> 0x0035 }
        f15450g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15450g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.messageclassifier.MessageExaminer.a(com.facebook.inject.InjectorLike):com.facebook.messaging.messageclassifier.MessageExaminer");
    }

    private static MessageExaminer m21996b(InjectorLike injectorLike) {
        return new MessageExaminer(AttachmentClassifier.m22003a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4219), IdBasedProvider.m1811a(injectorLike, 4170), IdBasedProvider.m1811a(injectorLike, 4113), IdBasedProvider.m1811a(injectorLike, 4182), IdBasedProvider.m1811a(injectorLike, 4220));
    }

    @Inject
    public MessageExaminer(AttachmentClassifier attachmentClassifier, Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, Provider<Boolean> provider5) {
        this.f15451a = attachmentClassifier;
        this.f15452b = provider;
        this.f15453c = provider2;
        this.f15454d = provider3;
        this.f15455e = provider4;
        this.f15456f = provider5;
    }

    public final boolean m21997b(Message message) {
        if (!((Boolean) this.f15452b.get()).booleanValue()) {
            return false;
        }
        int i;
        if ((message.i.size() != 1 || ((Attachment) message.i.get(0)).h == null) && !(message.a().size() == 1 && ((MediaResource) message.a().get(0)).d == Type.VIDEO)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0 && message.j.isEmpty() && message.u == null) {
            return true;
        }
        return false;
    }

    public final boolean m21998c(Message message) {
        if (!((Boolean) this.f15452b.get()).booleanValue()) {
            return false;
        }
        if (!((Boolean) this.f15456f.get()).booleanValue()) {
            return false;
        }
        if (message.G == null) {
            return false;
        }
        XMAAttachmentStoryFieldsModel l = message.G.l();
        if (l == null) {
            return false;
        }
        XMAAttachmentMediaModel o = l.o();
        if (o == null) {
            return false;
        }
        if (o.a() == null) {
            return false;
        }
        if (o.a().m22301g() != 82650203) {
            return false;
        }
        return o.k() != null && o.n() != null && o.l() > 0 && o.b() > 0;
    }

    public final boolean m21999e(Message message) {
        Object obj;
        if (message.u == null || message.u.a != SentShareAttachment.Type.PAYMENT) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null && message.B == null && (!((Boolean) this.f15455e.get()).booleanValue() || message.C == null)) {
            return false;
        }
        return true;
    }

    public final boolean m22000f(Message message) {
        if (!((Boolean) this.f15453c.get()).booleanValue()) {
            return false;
        }
        Share T = MessageUtil.m22056T(message);
        if (T == null) {
            return false;
        }
        MomentsInviteData momentsInviteData;
        if (T == null) {
            momentsInviteData = null;
        } else {
            momentsInviteData = T.m;
        }
        return momentsInviteData != null;
    }

    public final boolean m22001g(Message message) {
        return message.H != null && ((Boolean) this.f15454d.get()).booleanValue();
    }
}
