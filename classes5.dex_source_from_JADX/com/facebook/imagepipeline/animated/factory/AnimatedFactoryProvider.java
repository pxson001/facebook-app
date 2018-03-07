package com.facebook.imagepipeline.animated.factory;

import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.core.ExecutorSupplier;

/* compiled from: TRAVEL_TRANSPORTATION */
public class AnimatedFactoryProvider {
    private static boolean f13623a;
    private static AnimatedFactoryImpl f13624b = null;

    public static AnimatedFactoryImpl m22908a(PlatformBitmapFactory platformBitmapFactory, ExecutorSupplier executorSupplier) {
        if (!f13623a) {
            try {
                f13624b = (AnimatedFactoryImpl) Class.forName("com.facebook.imagepipeline.animated.factory.AnimatedFactoryImplSupport").getConstructor(new Class[]{PlatformBitmapFactory.class, ExecutorSupplier.class}).newInstance(new Object[]{platformBitmapFactory, executorSupplier});
            } catch (Throwable th) {
            }
            if (f13624b != null) {
                f13623a = true;
                return f13624b;
            }
            try {
                f13624b = (AnimatedFactoryImpl) Class.forName("com.facebook.imagepipeline.animated.factory.AnimatedFactoryImpl").getConstructor(new Class[]{PlatformBitmapFactory.class, ExecutorSupplier.class}).newInstance(new Object[]{platformBitmapFactory, executorSupplier});
            } catch (Throwable th2) {
            }
            f13623a = true;
        }
        return f13624b;
    }
}
