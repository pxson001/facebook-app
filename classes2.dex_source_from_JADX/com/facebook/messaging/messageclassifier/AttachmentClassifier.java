package com.facebook.messaging.messageclassifier;

import com.facebook.messaging.model.attachment.Attachment;
import javax.inject.Singleton;

@Singleton
/* compiled from: mRetainInstance= */
public class AttachmentClassifier {
    private static volatile AttachmentClassifier f15457a;

    public static com.facebook.messaging.messageclassifier.AttachmentClassifier m22003a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f15457a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.messaging.messageclassifier.AttachmentClassifier.class;
        monitor-enter(r1);
        r0 = f15457a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m22002a();	 Catch:{ all -> 0x0034 }
        f15457a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f15457a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.messageclassifier.AttachmentClassifier.a(com.facebook.inject.InjectorLike):com.facebook.messaging.messageclassifier.AttachmentClassifier");
    }

    private static AttachmentClassifier m22002a() {
        return new AttachmentClassifier();
    }

    public static boolean m22004a(Attachment attachment) {
        String str = attachment.e;
        String str2 = attachment.d;
        return str2 != null && str2.startsWith("audio/") && str != null && str.startsWith("audioclip-");
    }

    public static boolean m22005b(Attachment attachment) {
        String str = attachment.d;
        return str != null && str.startsWith("image/");
    }

    public static boolean m22006c(Attachment attachment) {
        if (attachment.g == null || attachment.g.d == null) {
            return false;
        }
        return true;
    }

    public static boolean m22007d(Attachment attachment) {
        String str = attachment.d;
        return str != null && str.startsWith("video/");
    }

    public final boolean m22008e(Attachment attachment) {
        return !m22005b(attachment);
    }
}
