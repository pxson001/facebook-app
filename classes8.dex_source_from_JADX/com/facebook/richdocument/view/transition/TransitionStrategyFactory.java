package com.facebook.richdocument.view.transition;

import android.content.Context;
import com.facebook.richdocument.view.transition.MediaSlideTransitionStrategy.AspectFitMediaSlideTransitionStrategy;
import com.facebook.richdocument.view.transition.MediaSlideTransitionStrategy.FullscreenMediaSlideTransitionStrategy;
import com.facebook.richdocument.view.transition.MediaSlideshowTransitionStrategy.CoverMediaSlideshowTransitionStrategy;
import com.facebook.richdocument.view.transition.MediaTransitionStrategy.AspectFitCoverMediaTransitionStrategy;
import com.facebook.richdocument.view.transition.MediaTransitionStrategy.AspectFitMediaTransitionStrategy;
import com.facebook.richdocument.view.transition.MediaTransitionStrategy.AspectFitOnlyCoverMediaTransitionStrategy;
import com.facebook.richdocument.view.transition.MediaTransitionStrategy.AspectFitOnlyMediaTransitionStrategy;
import com.facebook.richdocument.view.transition.MediaTransitionStrategy.FullscreenMediaTransitionStrategy;
import com.facebook.richdocument.view.transition.MediaTransitionStrategy.NonInteractiveCoverMediaTransitionStrategy;
import com.facebook.richdocument.view.transition.MediaTransitionStrategy.NonInteractiveMediaTransitionStrategy;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import javax.inject.Singleton;

@Singleton
/* compiled from: originalName */
public class TransitionStrategyFactory {
    private static volatile TransitionStrategyFactory f6997a;

    /* compiled from: originalName */
    public enum StrategyType {
        ASPECT_FIT,
        ASPECT_FIT_ONLY,
        NATIVE_ADS_ASPECT_FIT_ONLY,
        FULLSCREEN,
        NON_INTERACTIVE,
        ASPECT_FIT_SLIDESHOW,
        FULLSCREEN_SLIDESHOW,
        ASPECT_FIT_SLIDE,
        FULLSCREEN_SLIDE,
        NON_ADJUSTED_FIT_TO_WIDTH_SLIDE
    }

    public static com.facebook.richdocument.view.transition.TransitionStrategyFactory m7291a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6997a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.richdocument.view.transition.TransitionStrategyFactory.class;
        monitor-enter(r1);
        r0 = f6997a;	 Catch:{ all -> 0x0039 }
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
        r0 = m7290a();	 Catch:{ all -> 0x0034 }
        f6997a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f6997a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.view.transition.TransitionStrategyFactory.a(com.facebook.inject.InjectorLike):com.facebook.richdocument.view.transition.TransitionStrategyFactory");
    }

    private static TransitionStrategyFactory m7290a() {
        return new TransitionStrategyFactory();
    }

    public AbstractTransitionStrategy m7292a(StrategyType strategyType, Context context, MediaFrame mediaFrame, boolean z) {
        TransitionSpring transitionSpring = new TransitionSpring(context);
        if (z) {
            switch (strategyType) {
                case ASPECT_FIT:
                    return new AspectFitCoverMediaTransitionStrategy(mediaFrame, transitionSpring);
                case ASPECT_FIT_ONLY:
                    return new AspectFitOnlyCoverMediaTransitionStrategy(mediaFrame, transitionSpring);
                case NON_INTERACTIVE:
                    return new NonInteractiveCoverMediaTransitionStrategy(mediaFrame, transitionSpring);
                case ASPECT_FIT_SLIDESHOW:
                case FULLSCREEN_SLIDESHOW:
                    return new CoverMediaSlideshowTransitionStrategy(mediaFrame, transitionSpring);
                default:
                    return new AspectFitCoverMediaTransitionStrategy(mediaFrame, transitionSpring);
            }
        }
        switch (strategyType) {
            case ASPECT_FIT:
                return new AspectFitMediaTransitionStrategy(mediaFrame, transitionSpring);
            case ASPECT_FIT_ONLY:
                return new AspectFitOnlyMediaTransitionStrategy(mediaFrame, transitionSpring);
            case NON_INTERACTIVE:
                return new NonInteractiveMediaTransitionStrategy(mediaFrame, transitionSpring);
            case ASPECT_FIT_SLIDESHOW:
            case FULLSCREEN_SLIDESHOW:
                return new MediaSlideshowTransitionStrategy(mediaFrame, transitionSpring);
            case NATIVE_ADS_ASPECT_FIT_ONLY:
                return new NativeAdsAspectFitOnlyMediaTransitionStrategy(mediaFrame, transitionSpring);
            case FULLSCREEN:
                return new FullscreenMediaTransitionStrategy(mediaFrame, transitionSpring);
            case ASPECT_FIT_SLIDE:
                return new AspectFitMediaSlideTransitionStrategy(mediaFrame, transitionSpring);
            case FULLSCREEN_SLIDE:
                return new FullscreenMediaSlideTransitionStrategy(mediaFrame, transitionSpring);
            default:
                return new AspectFitMediaTransitionStrategy(mediaFrame, transitionSpring);
        }
    }
}
