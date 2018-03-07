package com.facebook.widget.images;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.imagepipeline.animated.factory.AnimatedDrawableFactoryImpl;
import com.facebook.imagepipeline.module.AnimatedDrawableFactoryMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.NeedsApplicationInjector;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Deprecated
/* compiled from: hideable_token */
public class DrawableUtil {
    private static volatile DrawableUtil f21029c;
    private final Resources f21030a;
    private final AnimatedDrawableFactoryImpl f21031b;

    public static com.facebook.widget.images.DrawableUtil m28756a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21029c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.widget.images.DrawableUtil.class;
        monitor-enter(r1);
        r0 = f21029c;	 Catch:{ all -> 0x003a }
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
        r0 = m28757b(r0);	 Catch:{ all -> 0x0035 }
        f21029c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21029c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.widget.images.DrawableUtil.a(com.facebook.inject.InjectorLike):com.facebook.widget.images.DrawableUtil");
    }

    public final android.graphics.drawable.Drawable m28759a(com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
        r3 = this;
        r0 = r4.m15682a();	 Catch:{ Exception -> 0x002e, all -> 0x0034 }
        r0 = (com.facebook.imagepipeline.image.CloseableImage) r0;	 Catch:{ Exception -> 0x002e, all -> 0x0034 }
        r1 = r0 instanceof com.facebook.imagepipeline.image.CloseableGIFImageOld;	 Catch:{ Exception -> 0x002e, all -> 0x0034 }
        if (r1 == 0) goto L_0x0013;	 Catch:{ Exception -> 0x002e, all -> 0x0034 }
    L_0x000a:
        r0 = new com.facebook.widget.images.CloseableGifDrawable;	 Catch:{ Exception -> 0x002e, all -> 0x0034 }
        r0.<init>(r4);	 Catch:{ Exception -> 0x002e, all -> 0x0034 }
    L_0x000f:
        r4.close();
    L_0x0012:
        return r0;
    L_0x0013:
        r1 = r0 instanceof com.facebook.imagepipeline.image.CloseableAnimatedImage;	 Catch:{  }
        if (r1 == 0) goto L_0x0026;	 Catch:{  }
    L_0x0017:
        r1 = new com.facebook.widget.images.CloseableAnimatedDrawable;	 Catch:{  }
        r2 = r3.f21031b;	 Catch:{  }
        r0 = r2.m20777a(r0);	 Catch:{  }
        r0 = (com.facebook.imagepipeline.animated.base.AnimatedDrawable) r0;	 Catch:{  }
        r1.<init>(r0, r4);	 Catch:{  }
        r0 = r1;	 Catch:{  }
        goto L_0x000f;	 Catch:{  }
    L_0x0026:
        r0 = new com.facebook.widget.images.CloseableBitmapDrawable;	 Catch:{  }
        r1 = r3.f21030a;	 Catch:{  }
        r0.<init>(r1, r4);	 Catch:{  }
        goto L_0x000f;
    L_0x002e:
        r0 = move-exception;
        r4.close();
        r0 = 0;
        goto L_0x0012;
    L_0x0034:
        r0 = move-exception;
        r4.close();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.widget.images.DrawableUtil.a(com.facebook.common.references.CloseableReference):android.graphics.drawable.Drawable");
    }

    private static DrawableUtil m28757b(InjectorLike injectorLike) {
        return new DrawableUtil(ResourcesMethodAutoProvider.m6510a(injectorLike.getApplicationInjector()), AnimatedDrawableFactoryMethodAutoProvider.m20763a(injectorLike));
    }

    @Inject
    public DrawableUtil(@NeedsApplicationInjector Resources resources, AnimatedDrawableFactoryImpl animatedDrawableFactoryImpl) {
        this.f21030a = resources;
        this.f21031b = animatedDrawableFactoryImpl;
    }

    public final Rect m28758a(int i) {
        return m28755a(this.f21030a.getDrawable(i));
    }

    private static Rect m28755a(Drawable drawable) {
        Rect rect = new Rect(0, 0, 0, 0);
        try {
            drawable.getPadding(rect);
        } catch (NullPointerException e) {
        }
        return rect;
    }
}
