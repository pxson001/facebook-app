package com.facebook.imagepipeline.animated.factory;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import com.facebook.common.executors.DefaultSerialExecutorService;
import com.facebook.common.executors.SerialExecutorService;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.NotThreadSafe;

@DoNotStrip
@NotThreadSafe
/* compiled from: p2p_has_user_added_credential_before */
public class AnimatedFactoryImpl {
    public AnimatedDrawableBackendProvider f10623a;
    private AnimatedDrawableUtil f10624b;
    private AnimatedDrawableFactoryImpl f10625c;
    private AnimatedImageFactoryImpl f10626d;
    private ExecutorSupplier f10627e;
    public PlatformBitmapFactory f10628f;

    /* compiled from: p2p_has_user_added_credential_before */
    public class C04563 implements AnimatedDrawableBackendProvider {
        final /* synthetic */ AnimatedFactoryImpl f10629a;

        public C04563(AnimatedFactoryImpl animatedFactoryImpl) {
            this.f10629a = animatedFactoryImpl;
        }

        public final AnimatedDrawableBackend mo2028a(AnimatedImageResult animatedImageResult, Rect rect) {
            return new AnimatedDrawableBackendImpl(AnimatedFactoryImpl.m15817c(this.f10629a), animatedImageResult, rect);
        }
    }

    /* compiled from: p2p_has_user_added_credential_before */
    public class C06002 implements AnimatedDrawableBackendProvider {
        final /* synthetic */ AnimatedFactoryImpl f14394a;

        public C06002(AnimatedFactoryImpl animatedFactoryImpl) {
            this.f14394a = animatedFactoryImpl;
        }

        public final AnimatedDrawableBackend mo2028a(AnimatedImageResult animatedImageResult, Rect rect) {
            return new AnimatedDrawableBackendImpl(AnimatedFactoryImpl.m15817c(this.f14394a), animatedImageResult, rect);
        }
    }

    public AnimatedFactoryImpl(PlatformBitmapFactory platformBitmapFactory, ExecutorSupplier executorSupplier) {
        this.f10628f = platformBitmapFactory;
        this.f10627e = executorSupplier;
    }

    private AnimatedDrawableFactoryImpl m15815a(SerialExecutorService serialExecutorService, ActivityManager activityManager, AnimatedDrawableUtil animatedDrawableUtil, AnimatedDrawableBackendProvider animatedDrawableBackendProvider, ScheduledExecutorService scheduledExecutorService, MonotonicClock monotonicClock, Resources resources) {
        final SerialExecutorService serialExecutorService2 = serialExecutorService;
        final ActivityManager activityManager2 = activityManager;
        final AnimatedDrawableUtil animatedDrawableUtil2 = animatedDrawableUtil;
        final MonotonicClock monotonicClock2 = monotonicClock;
        return m15816a(animatedDrawableBackendProvider, new Object(this) {
            final /* synthetic */ AnimatedFactoryImpl f14401e;
        }, animatedDrawableUtil, scheduledExecutorService, resources);
    }

    public final AnimatedDrawableFactoryImpl m15818a(Context context) {
        if (this.f10625c == null) {
            SerialExecutorService defaultSerialExecutorService = new DefaultSerialExecutorService(this.f10627e.mo2024c());
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            AnimatedDrawableUtil c = m15817c(this);
            if (this.f10623a == null) {
                this.f10623a = new C06002(this);
            }
            this.f10625c = m15815a(defaultSerialExecutorService, activityManager, c, this.f10623a, UiThreadImmediateExecutorService.m20771b(), RealtimeSinceBootClock.f3978a, context.getResources());
        }
        return this.f10625c;
    }

    public static AnimatedDrawableUtil m15817c(AnimatedFactoryImpl animatedFactoryImpl) {
        if (animatedFactoryImpl.f10624b == null) {
            animatedFactoryImpl.f10624b = new AnimatedDrawableUtil();
        }
        return animatedFactoryImpl.f10624b;
    }

    public final AnimatedImageFactoryImpl m15819a() {
        if (this.f10626d == null) {
            this.f10626d = new AnimatedImageFactoryImpl(new C04563(this), this.f10628f);
        }
        return this.f10626d;
    }

    private static AnimatedDrawableFactoryImpl m15816a(AnimatedDrawableBackendProvider animatedDrawableBackendProvider, C06011 c06011, AnimatedDrawableUtil animatedDrawableUtil, ScheduledExecutorService scheduledExecutorService, Resources resources) {
        return new AnimatedDrawableFactoryImpl(animatedDrawableBackendProvider, c06011, animatedDrawableUtil, scheduledExecutorService, resources);
    }
}
