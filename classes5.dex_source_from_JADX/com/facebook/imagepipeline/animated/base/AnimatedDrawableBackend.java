package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.facebook.common.references.CloseableReference;
import javax.annotation.Nullable;

/* compiled from: TREEHOUSE_HOME */
public interface AnimatedDrawableBackend {
    AnimatedDrawableBackend mo1259a(Rect rect);

    AnimatedDrawableFrameInfo mo1239a(int i);

    AnimatedImageResult mo1240a();

    void mo1241a(int i, Canvas canvas);

    int mo1242b();

    int mo1243b(int i);

    int mo1244c();

    int mo1245c(int i);

    int mo1246d();

    int mo1247d(int i);

    int mo1248e();

    @Nullable
    CloseableReference<Bitmap> mo1249e(int i);

    int mo1250f();

    boolean mo1251f(int i);

    int mo1252g();

    int mo1253h();

    int mo1254i();

    int mo1255j();

    void mo1256k();
}
