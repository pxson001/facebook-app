package com.facebook.sync.connection;

import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.attachment.AttachmentImageType;
import com.facebook.messaging.photos.size.MediaSizeUtil;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: feed_unit */
public class SyncParamsUtil {
    private static volatile SyncParamsUtil f14500c;
    public final FbSharedPreferences f14501a;
    public final MediaSizeUtil f14502b;

    public static com.facebook.sync.connection.SyncParamsUtil m18395a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14500c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.sync.connection.SyncParamsUtil.class;
        monitor-enter(r1);
        r0 = f14500c;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m18396b(r0);	 Catch:{ all -> 0x0035 }
        f14500c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14500c;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.sync.connection.SyncParamsUtil.a(com.facebook.inject.InjectorLike):com.facebook.sync.connection.SyncParamsUtil");
    }

    private static SyncParamsUtil m18396b(InjectorLike injectorLike) {
        return new SyncParamsUtil((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), MediaSizeUtil.m9463a(injectorLike));
    }

    @Inject
    public SyncParamsUtil(FbSharedPreferences fbSharedPreferences, MediaSizeUtil mediaSizeUtil) {
        this.f14501a = fbSharedPreferences;
        this.f14502b = mediaSizeUtil;
    }

    public final ObjectNode m18399b() {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        Integer num = AttachmentImageType.FULL_SCREEN.persistentIndex;
        objectNode.a(num.toString(), MediaSizeUtil.m9464a(m18397a(num.intValue()), m18398b(num.intValue())));
        num = AttachmentImageType.LARGE_PREVIEW.persistentIndex;
        objectNode.a(num.toString(), MediaSizeUtil.m9464a(m18397a(num.intValue()), m18398b(num.intValue())));
        num = AttachmentImageType.MEDIUM_PREVIEW.persistentIndex;
        objectNode.a(num.toString(), MediaSizeUtil.m9464a(m18397a(num.intValue()), m18398b(num.intValue())));
        num = AttachmentImageType.SMALL_PREVIEW.persistentIndex;
        objectNode.a(num.toString(), MediaSizeUtil.m9464a(m18397a(num.intValue()), m18398b(num.intValue())));
        return objectNode;
    }

    public final int m18397a(int i) {
        return this.f14501a.a(SyncParamsPrefKeys.m18393a(Integer.valueOf(i)), -1);
    }

    public final int m18398b(int i) {
        return this.f14501a.a(SyncParamsPrefKeys.m18394b(Integer.valueOf(i)), -1);
    }
}
