package com.facebook.backstage.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.facebook.backstage.util.LayoutUtil.C05902;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.inject.Inject;

/* compiled from: render_warning_message */
public class PhotoView extends ImageView {
    private static final String f5487d = PhotoView.class.getSimpleName();
    @Inject
    @ForUiThread
    ListeningExecutorService f5488a;
    @DefaultExecutorService
    @Inject
    ListeningExecutorService f5489b;
    @Inject
    QuickPerformanceLogger f5490c;
    private Bitmap f5491e;
    private int f5492f;
    private boolean f5493g;
    private ListenableFuture f5494h;

    /* compiled from: render_warning_message */
    class C05811 implements Runnable {
        final /* synthetic */ PhotoView f5486a;

        C05811(PhotoView photoView) {
            this.f5486a = photoView;
        }

        public void run() {
            PhotoView.m5725b(this.f5486a);
        }
    }

    private static <T extends View> void m5723a(Class<T> cls, T t) {
        m5724a((Object) t, t.getContext());
    }

    private static void m5724a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PhotoView) obj).m5722a((ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector), QuickPerformanceLoggerMethodAutoProvider.a(fbInjector));
    }

    private void m5722a(ListeningExecutorService listeningExecutorService, ListeningExecutorService listeningExecutorService2, QuickPerformanceLogger quickPerformanceLogger) {
        this.f5488a = listeningExecutorService;
        this.f5489b = listeningExecutorService2;
        this.f5490c = quickPerformanceLogger;
    }

    public PhotoView(Context context) {
        this(context, null);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5723a(PhotoView.class, (View) this);
        setScaleType(ScaleType.MATRIX);
    }

    public final void m5727a(Bitmap bitmap, int i, boolean z) {
        this.f5491e = bitmap;
        this.f5492f = i;
        this.f5493g = z;
        Runnable c05811 = new C05811(this);
        if (getWidth() <= 0 || getHeight() <= 0) {
            OnGlobalLayoutListener c05902 = new C05902(this, c05811);
            if (this != null) {
                getViewTreeObserver().addOnGlobalLayoutListener(c05902);
            }
            return;
        }
        c05811.run();
    }

    public final void m5726a() {
        if (this.f5494h != null) {
            this.f5494h.cancel(true);
        }
        if (this.f5491e != null) {
            this.f5491e.recycle();
            this.f5491e = null;
        }
        setImageResource(17170445);
    }

    public static void m5725b(PhotoView photoView) {
        photoView.setImageMatrix(photoView.m5720a(photoView.f5491e.getWidth(), photoView.f5491e.getHeight(), photoView.f5492f, photoView.f5493g));
        photoView.setImageBitmap(photoView.f5491e);
        photoView.f5490c.a(6160385, (short) 60);
    }

    private Matrix m5720a(int i, int i2, int i3, boolean z) {
        float f;
        boolean z2;
        boolean z3 = true;
        int width = getWidth();
        int height = getHeight();
        Matrix matrix = new Matrix();
        matrix.postTranslate((float) ((width - i) / 2), (float) ((height - i2) / 2));
        if (i3 != 0) {
            matrix.postRotate((float) i3, (float) (width / 2), (float) (height / 2));
            if (i3 == 90 || i3 == 270) {
                int i4 = i;
                i = i2;
                i2 = i4;
            }
        }
        float f2 = ((float) width) / ((float) i);
        float f3 = ((float) height) / ((float) i2);
        if (((float) i2) * f2 >= ((float) height)) {
            f3 = f2;
            f = f2;
        } else {
            f = f3;
        }
        if ((((float) i2) * f3) + 0.01f > ((float) height)) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        if ((((float) i) * f) + 0.01f <= ((float) width)) {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        matrix.postScale(f, f3, (float) (width / 2), (float) (height / 2));
        if (z) {
            matrix.postScale(-1.0f, 1.0f, (float) (width / 2), (float) (height / 2));
        }
        return matrix;
    }
}
