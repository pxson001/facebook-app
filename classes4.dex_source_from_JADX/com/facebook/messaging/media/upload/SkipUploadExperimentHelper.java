package com.facebook.messaging.media.upload;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource$Type;
import com.facebook.ui.media.attachments.MediaResourceHelper;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: mChildren */
public class SkipUploadExperimentHelper {
    public static final ImmutableSet<MediaResource$Type> f8739b = ImmutableSet.of(MediaResource$Type.VIDEO);
    private static volatile SkipUploadExperimentHelper f8740c;
    private final Provider<Boolean> f8741a;

    public static com.facebook.messaging.media.upload.SkipUploadExperimentHelper m9035a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8740c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.media.upload.SkipUploadExperimentHelper.class;
        monitor-enter(r1);
        r0 = f8740c;	 Catch:{ all -> 0x003a }
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
        r0 = m9036b(r0);	 Catch:{ all -> 0x0035 }
        f8740c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8740c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.SkipUploadExperimentHelper.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.SkipUploadExperimentHelper");
    }

    private static SkipUploadExperimentHelper m9036b(InjectorLike injectorLike) {
        return new SkipUploadExperimentHelper(IdBasedProvider.a(injectorLike, 4166));
    }

    @Inject
    public SkipUploadExperimentHelper(Provider<Boolean> provider) {
        this.f8741a = provider;
    }

    public final boolean m9037a(MediaResource mediaResource) {
        Object obj;
        if (!f8739b.contains(mediaResource.d) || mediaResource.v || mediaResource.e.isQuickCamSource() || mediaResource.x != null || mediaResource.y != null || MediaResourceHelper.m8959c(mediaResource)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null && mediaResource.d == MediaResource$Type.VIDEO) {
            return ((Boolean) this.f8741a.get()).booleanValue();
        }
        return false;
    }
}
