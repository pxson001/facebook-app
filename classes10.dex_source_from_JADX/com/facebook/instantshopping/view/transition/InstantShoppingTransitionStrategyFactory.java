package com.facebook.instantshopping.view.transition;

import android.content.Context;
import com.facebook.richdocument.view.transition.AbstractTransitionStrategy;
import com.facebook.richdocument.view.transition.MediaSlideshowTransitionStrategy;
import com.facebook.richdocument.view.transition.TransitionSpring;
import com.facebook.richdocument.view.transition.TransitionStrategyFactory;
import com.facebook.richdocument.view.transition.TransitionStrategyFactory.StrategyType;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import javax.inject.Singleton;

@Singleton
/* compiled from: SNIPPET */
public class InstantShoppingTransitionStrategyFactory extends TransitionStrategyFactory {
    private static volatile InstantShoppingTransitionStrategyFactory f23852b;
    private boolean f23853a = false;

    /* compiled from: SNIPPET */
    /* synthetic */ class C34211 {
        static final /* synthetic */ int[] f23851a = new int[StrategyType.values().length];

        static {
            try {
                f23851a[StrategyType.NON_INTERACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23851a[StrategyType.FULLSCREEN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f23851a[StrategyType.ASPECT_FIT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f23851a[StrategyType.ASPECT_FIT_ONLY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f23851a[StrategyType.ASPECT_FIT_SLIDESHOW.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f23851a[StrategyType.FULLSCREEN_SLIDESHOW.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f23851a[StrategyType.NON_ADJUSTED_FIT_TO_WIDTH_SLIDE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f23851a[StrategyType.ASPECT_FIT_SLIDE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f23851a[StrategyType.FULLSCREEN_SLIDE.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    public static com.facebook.instantshopping.view.transition.InstantShoppingTransitionStrategyFactory m25135b(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23852b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.instantshopping.view.transition.InstantShoppingTransitionStrategyFactory.class;
        monitor-enter(r1);
        r0 = f23852b;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m25134a();	 Catch:{ all -> 0x0034 }
        f23852b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f23852b;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.instantshopping.view.transition.InstantShoppingTransitionStrategyFactory.b(com.facebook.inject.InjectorLike):com.facebook.instantshopping.view.transition.InstantShoppingTransitionStrategyFactory");
    }

    private static InstantShoppingTransitionStrategyFactory m25134a() {
        return new InstantShoppingTransitionStrategyFactory();
    }

    public final AbstractTransitionStrategy m25136a(StrategyType strategyType, Context context, MediaFrame mediaFrame, boolean z) {
        TransitionSpring transitionSpring = new TransitionSpring(context);
        AbstractTransitionStrategy gridMediaTransitionStrategy;
        switch (C34211.f23851a[strategyType.ordinal()]) {
            case 1:
            case 2:
                return new InstantShoppingExpandedOnlytransitionStrategy(mediaFrame, transitionSpring);
            case 3:
            case 4:
                gridMediaTransitionStrategy = new GridMediaTransitionStrategy(mediaFrame, transitionSpring);
                gridMediaTransitionStrategy.f23848b = this.f23853a;
                return gridMediaTransitionStrategy;
            case 5:
            case 6:
                gridMediaTransitionStrategy = new MediaSlideshowTransitionStrategy(mediaFrame, transitionSpring);
                gridMediaTransitionStrategy.a = this.f23853a;
                return gridMediaTransitionStrategy;
            case 7:
                return new MediaSlideshowFTWTransitionStrategy(mediaFrame, transitionSpring);
            case 8:
                gridMediaTransitionStrategy = new AspectFitInstantShoppingMediaSlideTransitionStrategy(mediaFrame, transitionSpring);
                gridMediaTransitionStrategy.f23846a = this.f23853a;
                return gridMediaTransitionStrategy;
            case 9:
                return new FullscreenInstantShoppingMediaSlideTransitionStrategy(mediaFrame, transitionSpring);
            default:
                GridMediaTransitionStrategy gridMediaTransitionStrategy2 = new GridMediaTransitionStrategy(mediaFrame, transitionSpring);
                gridMediaTransitionStrategy2.f23848b = this.f23853a;
                return gridMediaTransitionStrategy2;
        }
    }

    public final AbstractTransitionStrategy m25137a(StrategyType strategyType, Context context, MediaFrame mediaFrame, boolean z, boolean z2, boolean z3) {
        this.f23853a = z3;
        if (z2) {
            TransitionSpring transitionSpring = new TransitionSpring(context);
            switch (C34211.f23851a[strategyType.ordinal()]) {
                case 2:
                case 9:
                    return new MediaAdjustedHeightImageTransitionStratergy(mediaFrame, transitionSpring);
                case 6:
                    return new MediaAdjustedHeightSlideShowTransitionStratergy(mediaFrame, transitionSpring);
            }
        }
        return a(strategyType, context, mediaFrame, z);
    }
}
