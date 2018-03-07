package com.facebook.photos.galleryutil;

import com.facebook.content.event.FbEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.galleryutil.events.C0423xe259026e;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEvents$MediaGalleryFragmentVisibilityChangeEvent;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: hide_topic_id */
public class GalleryVisibilityState {
    private static volatile GalleryVisibilityState f21037d;
    private final C0423xe259026e f21038a = new C08381(this);
    private final ConsumptionPhotoEventBus f21039b;
    public int f21040c = -1;

    /* compiled from: hide_topic_id */
    class C08381 extends C0423xe259026e {
        final /* synthetic */ GalleryVisibilityState f21041a;

        C08381(GalleryVisibilityState galleryVisibilityState) {
            this.f21041a = galleryVisibilityState;
        }

        public final void mo650b(FbEvent fbEvent) {
            int i;
            ConsumptionPhotoEvents$MediaGalleryFragmentVisibilityChangeEvent consumptionPhotoEvents$MediaGalleryFragmentVisibilityChangeEvent = (ConsumptionPhotoEvents$MediaGalleryFragmentVisibilityChangeEvent) fbEvent;
            GalleryVisibilityState galleryVisibilityState = this.f21041a;
            if (consumptionPhotoEvents$MediaGalleryFragmentVisibilityChangeEvent.f14047a) {
                i = consumptionPhotoEvents$MediaGalleryFragmentVisibilityChangeEvent.f14048b;
            } else {
                i = -1;
            }
            galleryVisibilityState.f21040c = i;
        }
    }

    public static com.facebook.photos.galleryutil.GalleryVisibilityState m28771a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21037d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.galleryutil.GalleryVisibilityState.class;
        monitor-enter(r1);
        r0 = f21037d;	 Catch:{ all -> 0x003a }
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
        r0 = m28772b(r0);	 Catch:{ all -> 0x0035 }
        f21037d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21037d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.galleryutil.GalleryVisibilityState.a(com.facebook.inject.InjectorLike):com.facebook.photos.galleryutil.GalleryVisibilityState");
    }

    private static GalleryVisibilityState m28772b(InjectorLike injectorLike) {
        return new GalleryVisibilityState(ConsumptionPhotoEventBus.m14866a(injectorLike));
    }

    @Inject
    public GalleryVisibilityState(ConsumptionPhotoEventBus consumptionPhotoEventBus) {
        this.f21039b = consumptionPhotoEventBus;
    }

    public final void m28773a() {
        this.f21039b.m4568a(this.f21038a);
    }
}
