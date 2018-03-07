package com.facebook.composer.attachments;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.base.media.MediaItemValidator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@Immutable
/* compiled from: place_picker_location_failed */
public class AttachmentsValidator {
    private static volatile AttachmentsValidator f7796c;
    private final MediaItemValidator f7797a;
    private final Provider<Integer> f7798b;

    /* compiled from: place_picker_location_failed */
    public enum Error {
        NONEXISTANT_PHOTO,
        TOO_MANY_PHOTOS
    }

    /* compiled from: place_picker_location_failed */
    public class Result {
        public final ImmutableList<ComposerAttachment> f7794a;
        public final ImmutableList<Error> f7795b;

        public Result(ImmutableList<ComposerAttachment> immutableList, ImmutableList<Error> immutableList2) {
            this.f7794a = immutableList;
            this.f7795b = immutableList2;
        }
    }

    public static com.facebook.composer.attachments.AttachmentsValidator m11208a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7796c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.composer.attachments.AttachmentsValidator.class;
        monitor-enter(r1);
        r0 = f7796c;	 Catch:{ all -> 0x003a }
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
        r0 = m11209b(r0);	 Catch:{ all -> 0x0035 }
        f7796c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7796c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.attachments.AttachmentsValidator.a(com.facebook.inject.InjectorLike):com.facebook.composer.attachments.AttachmentsValidator");
    }

    private static AttachmentsValidator m11209b(InjectorLike injectorLike) {
        return new AttachmentsValidator(MediaItemValidator.m20110a(injectorLike), IdBasedProvider.a(injectorLike, 4421));
    }

    @Inject
    public AttachmentsValidator(MediaItemValidator mediaItemValidator, Provider<Integer> provider) {
        this.f7797a = mediaItemValidator;
        this.f7798b = provider;
    }

    public final Result m11210a(ImmutableList<ComposerAttachment> immutableList, boolean z) {
        Builder builder = ImmutableList.builder();
        Collection arrayList = new ArrayList();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ComposerAttachment composerAttachment = (ComposerAttachment) immutableList.get(i);
            if (composerAttachment.m11225a()) {
                MediaItem b = composerAttachment.m11227b();
                if (!z && !MediaItemValidator.m20111a(b)) {
                    builder.c(Error.NONEXISTANT_PHOTO);
                } else if (arrayList.size() >= ((Integer) this.f7798b.get()).intValue()) {
                    builder.c(Error.TOO_MANY_PHOTOS);
                    break;
                } else {
                    arrayList.add(composerAttachment);
                }
            } else if (z) {
                arrayList.add(composerAttachment);
            } else {
                builder.c(Error.NONEXISTANT_PHOTO);
            }
        }
        return new Result(ImmutableList.copyOf(arrayList), builder.b());
    }
}
