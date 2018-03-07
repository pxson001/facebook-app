package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod;

/* compiled from: TRAVEL_SUGGESTION */
public class AnimatedImageCompositor {
    private final AnimatedDrawableBackend f13672a;
    private final Callback f13673b;
    private final Paint f13674c = new Paint();

    /* compiled from: TRAVEL_SUGGESTION */
    public interface Callback {
        CloseableReference<Bitmap> mo1257a(int i);

        void mo1258a(int i, Bitmap bitmap);
    }

    /* compiled from: TRAVEL_SUGGESTION */
    /* synthetic */ class C13011 {
        static final /* synthetic */ int[] f13671a = new int[FrameNeededResult.values().length];

        static {
            try {
                f13671a[FrameNeededResult.REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13671a[FrameNeededResult.NOT_REQUIRED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f13671a[FrameNeededResult.ABORT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f13671a[FrameNeededResult.SKIP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* compiled from: TRAVEL_SUGGESTION */
    enum FrameNeededResult {
        REQUIRED,
        NOT_REQUIRED,
        SKIP,
        ABORT
    }

    public AnimatedImageCompositor(AnimatedDrawableBackend animatedDrawableBackend, Callback callback) {
        this.f13672a = animatedDrawableBackend;
        this.f13673b = callback;
        this.f13674c.setColor(0);
        this.f13674c.setStyle(Style.FILL);
        this.f13674c.setXfermode(new PorterDuffXfermode(Mode.SRC));
    }

    public final void m22989a(int i, Bitmap bitmap) {
        int i2;
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, Mode.SRC);
        if (!this.f13672a.mo1239a(i).f13603f || i <= 0) {
            i2 = i;
        } else {
            i2 = m22986a(i - 1, canvas);
        }
        while (i2 < i) {
            AnimatedDrawableFrameInfo a = this.f13672a.mo1239a(i2);
            DisposalMethod disposalMethod = a.f13604g;
            if (disposalMethod != DisposalMethod.DISPOSE_TO_PREVIOUS) {
                this.f13672a.mo1241a(i2, canvas);
                this.f13673b.mo1258a(i2, bitmap);
                if (disposalMethod == DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    m22988a(canvas, a);
                }
            }
            i2++;
        }
        this.f13672a.mo1241a(i, canvas);
    }

    private int m22986a(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            switch (C13011.f13671a[m22987a(i2).ordinal()]) {
                case 1:
                    AnimatedDrawableFrameInfo a = this.f13672a.mo1239a(i2);
                    CloseableReference a2 = this.f13673b.mo1257a(i2);
                    if (a2 == null) {
                        if (a.f13603f) {
                            break;
                        }
                        return i2;
                    }
                    try {
                        canvas.drawBitmap((Bitmap) a2.a(), 0.0f, 0.0f, null);
                        if (a.f13604g == DisposalMethod.DISPOSE_TO_BACKGROUND) {
                            m22988a(canvas, a);
                        }
                        int i3 = i2 + 1;
                        a2.close();
                        return i3;
                    } catch (Throwable th) {
                        a2.close();
                    }
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    return i2 + 1;
                case 3:
                    return i2;
                default:
                    break;
            }
        }
        return 0;
    }

    private void m22988a(Canvas canvas, AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        canvas.drawRect((float) animatedDrawableFrameInfo.f13599b, (float) animatedDrawableFrameInfo.f13600c, (float) (animatedDrawableFrameInfo.f13599b + animatedDrawableFrameInfo.f13601d), (float) (animatedDrawableFrameInfo.f13600c + animatedDrawableFrameInfo.f13602e), this.f13674c);
    }

    private FrameNeededResult m22987a(int i) {
        AnimatedDrawableFrameInfo a = this.f13672a.mo1239a(i);
        DisposalMethod disposalMethod = a.f13604g;
        if (disposalMethod == DisposalMethod.DISPOSE_DO_NOT) {
            return FrameNeededResult.REQUIRED;
        }
        if (disposalMethod == DisposalMethod.DISPOSE_TO_BACKGROUND) {
            if (a.f13599b == 0 && a.f13600c == 0 && a.f13601d == this.f13672a.mo1252g() && a.f13602e == this.f13672a.mo1253h()) {
                return FrameNeededResult.NOT_REQUIRED;
            }
            return FrameNeededResult.REQUIRED;
        } else if (disposalMethod == DisposalMethod.DISPOSE_TO_PREVIOUS) {
            return FrameNeededResult.SKIP;
        } else {
            return FrameNeededResult.ABORT;
        }
    }
}
