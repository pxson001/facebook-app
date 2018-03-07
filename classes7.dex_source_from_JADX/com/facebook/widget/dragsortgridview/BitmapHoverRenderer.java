package com.facebook.widget.dragsortgridview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.dragsortgridview.DragSortGridView.C12355;
import javax.annotation.Nullable;

/* compiled from: delay_delete */
public class BitmapHoverRenderer implements HoverRenderer {
    @Nullable
    public BitmapDrawable f15934a;
    @Nullable
    public Rect f15935b;
    @Nullable
    private Rect f15936c;
    private Point f15937d = new Point();
    public final C12355 f15938e;

    /* compiled from: delay_delete */
    public class C12281 implements TypeEvaluator<Rect> {
        final /* synthetic */ BitmapHoverRenderer f15930a;

        public C12281(BitmapHoverRenderer bitmapHoverRenderer) {
            this.f15930a = bitmapHoverRenderer;
        }

        public Object evaluate(float f, Object obj, Object obj2) {
            Rect rect = (Rect) obj;
            Rect rect2 = (Rect) obj2;
            return new Rect(C12281.m19874a(rect.left, rect2.left, f), C12281.m19874a(rect.top, rect2.top, f), C12281.m19874a(rect.right, rect2.right, f), C12281.m19874a(rect.bottom, rect2.bottom, f));
        }

        private static int m19874a(int i, int i2, float f) {
            return (int) (((float) i) + (((float) (i2 - i)) * f));
        }
    }

    /* compiled from: delay_delete */
    public class C12292 implements AnimatorUpdateListener {
        final /* synthetic */ BitmapHoverRenderer f15931a;

        public C12292(BitmapHoverRenderer bitmapHoverRenderer) {
            this.f15931a = bitmapHoverRenderer;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f15931a.f15938e.m19894a();
        }
    }

    public BitmapHoverRenderer(C12355 c12355) {
        this.f15938e = c12355;
    }

    public final Point mo1217a(double d) {
        Rect rect = this.f15936c;
        Rect rect2 = this.f15935b;
        int width = (int) (((double) rect.width()) * d);
        int height = (int) (((double) rect.height()) * d);
        int width2 = rect2.left - ((width - rect2.width()) / 2);
        int height2 = rect2.top - ((height - rect2.height()) / 2);
        this.f15935b.set(width2, height2, width2 + width, height2 + height);
        this.f15934a.setBounds(this.f15935b);
        this.f15937d.x = (width - rect2.width()) / 2;
        this.f15937d.y = (height - rect2.height()) / 2;
        return this.f15937d;
    }

    public final boolean mo1221a() {
        return this.f15934a != null;
    }

    public final void mo1219a(Canvas canvas) {
        if (this.f15934a != null) {
            this.f15934a.draw(canvas);
        }
    }

    public final void mo1218a(int i, int i2) {
        this.f15935b.offsetTo(this.f15936c.left + i, this.f15936c.top + i2);
        this.f15934a.setBounds(this.f15935b);
    }

    public final void mo1222b() {
        this.f15934a.getBitmap().recycle();
        this.f15934a = null;
    }

    public final Rect mo1224c() {
        return this.f15936c;
    }

    public final Rect mo1225d() {
        return this.f15935b;
    }

    public final void mo1223b(final View view) {
        this.f15935b.set(view.getLeft(), view.getTop(), view.getLeft() + view.getWidth(), view.getTop() + view.getHeight());
        if (VERSION.SDK_INT > 11) {
            ObjectAnimator ofObject = ObjectAnimator.ofObject(this.f15934a, "bounds", new C12281(this), new Object[]{this.f15935b});
            ofObject.addUpdateListener(new C12292(this));
            ofObject.addListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ BitmapHoverRenderer f15933b;

                public void onAnimationStart(Animator animator) {
                    this.f15933b.f15938e.m19897b();
                }

                public void onAnimationEnd(Animator animator) {
                    this.f15933b.f15938e.m19898c();
                    this.f15933b.f15938e.m19895a(view);
                }
            });
            ofObject.start();
            return;
        }
        this.f15934a.setBounds(this.f15935b);
        this.f15938e.m19894a();
        this.f15938e.m19895a(view);
    }

    public final void mo1220a(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = view.getBackground();
        if (this.f15938e.m19899d() != null) {
            CustomViewUtils.b(view, this.f15938e.m19899d());
        }
        view.draw(canvas);
        CustomViewUtils.b(view, background);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(view.getResources(), createBitmap);
        this.f15936c = new Rect(view.getLeft(), view.getTop(), view.getLeft() + view.getWidth(), view.getTop() + view.getHeight());
        this.f15935b = new Rect(this.f15936c);
        bitmapDrawable.setBounds(this.f15935b);
        this.f15934a = bitmapDrawable;
    }
}
