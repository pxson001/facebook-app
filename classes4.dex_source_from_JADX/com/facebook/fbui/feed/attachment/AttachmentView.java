package com.facebook.fbui.feed.attachment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.AspectRatioMeasure;
import com.facebook.drawee.view.AspectRatioMeasure.Spec;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.fbui.widget.layout.ImageBlockLayout.LayoutParams;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: privacy_row_input */
public class AttachmentView extends ImageBlockLayout {
    private static final Spec f4173h = new Spec();
    private static final LayoutParams f4174i = new LayoutParams(-1, -2);
    private final Rect f4175A = new Rect();
    private float f4176B;
    private boolean f4177C;
    private int f4178D;
    private int f4179E;
    private int f4180F;
    private Drawable[] f4181G;
    private LayerDrawable f4182H;
    private final Rect f4183I = new Rect();
    public Drawable f4184J;
    public boolean f4185K;
    private final int f4186L;
    private final int f4187M;
    private final int f4188N;
    private final int f4189O;
    private final Rect f4190P = new Rect();
    private DraweeHolder<GenericDraweeHierarchy> f4191j;
    private Drawable f4192k;
    private int f4193l;
    private int f4194m;
    private int f4195n;
    public float f4196o;
    public TextHelper f4197p;
    public TextHelper f4198q;
    public TextHelper f4199r;
    private int f4200s;
    private int f4201t;
    private int f4202u;
    public Drawable f4203v;
    public Drawable f4204w;
    private final Rect f4205x;
    public boolean f4206y;
    public boolean f4207z;

    public AttachmentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4197p = new TextHelper(this, context, 2131624459);
        this.f4198q = new TextHelper(this, context, 2131624460);
        this.f4199r = new TextHelper(this, context, 2131624461);
        Resources resources = getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(2131427478);
        setThumbnailPadding(dimensionPixelSize);
        setAuxViewPadding(dimensionPixelSize);
        setThumbnailSize(resources.getDimensionPixelSize(2131427477));
        setThumbnailGravity(48);
        setGravity(16);
        this.f4200s = resources.getDimensionPixelSize(2131427479);
        this.f4195n = resources.getDimensionPixelSize(2131427480);
        this.f4201t = resources.getDimensionPixelSize(2131427481);
        this.f4202u = resources.getDimensionPixelSize(2131427480);
        this.f4205x = new Rect();
        this.f4196o = getDefaultCoverDrawableAspectRatio();
        dimensionPixelSize = resources.getDimensionPixelSize(2131427482);
        this.f4186L = dimensionPixelSize;
        this.f4187M = dimensionPixelSize;
        this.f4188N = resources.getDimensionPixelSize(2131427483);
        this.f4189O = resources.getDimensionPixelSize(2131427484);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -782040057);
        super.onAttachedToWindow();
        getCoverDraweeHolder().b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1413928490, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1153843259);
        super.onDetachedFromWindow();
        getCoverDraweeHolder().d();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -335618453, a);
    }

    protected final void m4720b() {
        super.b();
        setCoverDrawableController(null);
        setCoverDrawable(null);
        this.f4184J = null;
        this.f4185K = false;
        this.f4206y = false;
        this.f4205x.set(0, 0, 0, 0);
        this.f4207z = false;
        this.f4196o = getDefaultCoverDrawableAspectRatio();
        this.f4197p.a();
        this.f4198q.a();
        this.f4199r.a();
        this.f4176B = 0.0f;
        this.f4177C = false;
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        getCoverDraweeHolder().d();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        getCoverDraweeHolder().b();
    }

    protected void onMeasure(int i, int i2) {
        if (getCoverDrawableController() == null && this.f4192k == null) {
            this.f4193l = 0;
            this.f4194m = 0;
        } else {
            f4173h.a = i;
            f4173h.b = i2;
            int paddingLeft = ((this.f4195n * 2) + getPaddingLeft()) + getPaddingRight();
            AspectRatioMeasure.a(f4173h, this.f4196o, f4174i, paddingLeft, getPaddingTop());
            this.f4193l = MeasureSpec.getSize(f4173h.a) - paddingLeft;
            this.f4194m = MeasureSpec.getSize(f4173h.b);
        }
        super.onMeasure(i, i2);
    }

    protected final void m4718a(int i, int i2) {
        int max;
        int i3 = 0;
        boolean e = this.f4197p.e();
        boolean e2 = this.f4198q.e();
        boolean e3 = this.f4199r.e();
        if (e) {
            this.f4197p.a(i);
            max = Math.max(0, this.f4197p.c());
            i3 = this.f4197p.d() + 0;
        } else {
            max = 0;
        }
        if (e2) {
            this.f4198q.a(i);
            max = Math.max(max, this.f4198q.c());
            i3 += this.f4198q.d();
        }
        if (e3) {
            this.f4199r.a(i);
            max = Math.max(max, this.f4199r.c());
            i3 += this.f4199r.d();
        }
        if (e && e2) {
            i3 += this.f4202u;
        }
        if (e3 && (e || e2)) {
            i3 += this.f4202u;
        }
        if (this.f4177C) {
            i3 += this.f4179E;
            max = Math.max(max, this.f4180F);
        }
        b(max, Math.max(i3, this.f4201t - (this.f4200s * 2)));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Rect bounds;
        super.onLayout(z, i, i2, i3, i4);
        int h = ViewCompat.h(this);
        if (this.f4192k != null) {
            this.f4192k.setBounds(getPaddingLeft() + this.f4195n, getPaddingTop(), (getPaddingLeft() + this.f4195n) + this.f4193l, getPaddingTop() + this.f4194m);
            if (this.f4206y) {
                GravityCompat.m4736a(17, this.f4203v.getIntrinsicWidth(), this.f4203v.getIntrinsicHeight(), this.f4192k.getBounds(), this.f4205x, h);
                this.f4203v.setBounds(this.f4205x);
            }
            if (this.f4185K && this.f4184J != null) {
                bounds = this.f4192k.getBounds();
                if (this.f4185K && this.f4184J != null) {
                    Rect rect;
                    if (bounds == null) {
                        int paddingLeft = getPaddingLeft();
                        int paddingTop = getPaddingTop();
                        this.f4175A.set(paddingLeft, paddingTop, ((i3 - i) - (getPaddingRight() + paddingLeft)) + paddingLeft, ((i4 - i2) - (getPaddingBottom() - paddingTop)) + paddingTop);
                        rect = this.f4175A;
                    } else {
                        rect = bounds;
                    }
                    GravityCompat.m4735a(8388661, this.f4186L, this.f4187M, rect, this.f4189O, this.f4188N, this.f4190P, h);
                    this.f4184J.setBounds(this.f4190P);
                    return;
                }
            }
        }
        bounds = null;
        if (this.f4185K) {
        }
    }

    protected final void m4719a(int i, int i2, int i3) {
        int i4;
        boolean e = this.f4197p.e();
        boolean e2 = this.f4198q.e();
        boolean e3 = this.f4199r.e();
        if (e) {
            this.f4197p.a(i, i2, i3);
            i2 += this.f4197p.d();
        }
        if (!this.f4177C || this.f4182H == null) {
            i4 = i2;
        } else {
            i4 = c() ? i : i3 - this.f4180F;
            this.f4183I.set(i4, i2, this.f4180F + i4, this.f4179E + i2);
            this.f4182H.setBounds(0, 0, this.f4180F, this.f4179E);
            i4 = i2 + this.f4179E;
        }
        if (e2) {
            if (e) {
                i4 += this.f4202u;
            }
            this.f4198q.a(i, i4, i3);
            i4 += this.f4198q.d();
        }
        if (e3) {
            if (e || e2) {
                i4 += this.f4202u;
            }
            this.f4199r.a(i, i4, i3);
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f4192k != null) {
            this.f4192k.draw(canvas);
            if (this.f4206y) {
                this.f4203v.draw(canvas);
            }
        }
        this.f4197p.a(canvas);
        if (this.f4185K && this.f4184J != null) {
            this.f4184J.draw(canvas);
        }
        if (this.f4177C && this.f4182H != null) {
            int save = canvas.save();
            if (c()) {
                canvas.translate((float) this.f4183I.left, (float) this.f4183I.top);
            } else {
                canvas.translate((float) this.f4183I.right, (float) this.f4183I.top);
                canvas.scale(-1.0f, 1.0f);
            }
            this.f4182H.draw(canvas);
            canvas.restoreToCount(save);
        }
        this.f4198q.a(canvas);
        this.f4199r.a(canvas);
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return this.f4192k == drawable || super.verifyDrawable(drawable);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof LayoutParams) && ((LayoutParams) layoutParams).a) {
            throw new IllegalStateException("Cannot replace the thumbnail or the auxView in attachments");
        }
        super.addView(view, i, layoutParams);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        this.f4197p.a(accessibilityEvent);
        this.f4198q.a(accessibilityEvent);
        this.f4199r.a(accessibilityEvent);
        return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    protected int getInsetTop() {
        return this.f4200s + this.f4194m;
    }

    protected int getInsetBottom() {
        return this.f4200s;
    }

    protected int getInsetLeft() {
        return this.f4200s;
    }

    protected int getInsetRight() {
        return this.f4200s;
    }

    public CharSequence getTitleText() {
        return this.f4197p.b;
    }

    public CharSequence getSubtitleText() {
        return this.f4198q.b;
    }

    public CharSequence getMetaText() {
        return this.f4199r.b;
    }

    public DraweeController getCoverDrawableController() {
        return getCoverDraweeHolder().f;
    }

    public void setCoverDrawableController(DraweeController draweeController) {
        DraweeHolder coverDraweeHolder = getCoverDraweeHolder();
        coverDraweeHolder.a(draweeController);
        setCoverDrawable(coverDraweeHolder.h());
        requestLayout();
        invalidate();
    }

    private void setCoverDrawable(int i) {
        setCoverDrawable(getResources().getDrawable(i));
    }

    public void setCoverDrawable(Drawable drawable) {
        if (this.f4192k != drawable) {
            if (this.f4192k != null) {
                this.f4192k.setCallback(null);
            }
            this.f4192k = drawable;
            if (this.f4192k != null) {
                this.f4192k.setCallback(this);
            }
            requestLayout();
            invalidate();
        }
    }

    protected float getDefaultCoverDrawableAspectRatio() {
        return 0.0f;
    }

    protected DraweeHolder<GenericDraweeHierarchy> mo342f() {
        Context context = getContext();
        return DraweeHolder.a(new GenericDraweeHierarchyBuilder(context.getResources()).u(), context);
    }

    private DraweeHolder<GenericDraweeHierarchy> getCoverDraweeHolder() {
        if (this.f4191j == null) {
            this.f4191j = mo342f();
        }
        return this.f4191j;
    }

    public void setRating(float f) {
        if (this.f4176B != f) {
            this.f4176B = f;
            if (this.f4177C) {
                mo341a();
                invalidate();
            }
        }
    }

    public void setShowRating(boolean z) {
        if (this.f4177C != z) {
            this.f4177C = z;
            if (z) {
                mo341a();
                this.f4180F = this.f4178D * 5;
            }
            requestLayout();
            invalidate();
        }
    }

    private void mo341a() {
        if (this.f4182H == null) {
            m4717g();
        }
        if (this.f4181G != null) {
            int round = (int) (((((float) Math.round(this.f4176B * 4.0f)) * 1.0f) / 20.0f) * 10000.0f);
            this.f4181G[2].setLevel(round);
            this.f4181G[1].setLevel(10000 - round);
        }
    }

    private void m4717g() {
        m4716a(0);
    }

    private void m4716a(int i) {
        if (i != 0) {
            this.f4178D = 0;
            this.f4179E = 0;
            Drawable drawable = getResources().getDrawable(i);
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i2 = 0; i2 < numberOfLayers; i2++) {
                    boolean z;
                    int id = layerDrawable.getId(i2);
                    Drawable drawable2 = layerDrawable.getDrawable(i2);
                    if (id == 16908301 || id == 16908303) {
                        z = true;
                    } else {
                        z = false;
                    }
                    drawableArr[i2] = m4714a(drawable2, z);
                }
                this.f4182H = new LayerDrawable(drawableArr);
                this.f4181G = drawableArr;
                return;
            }
            throw new IllegalArgumentException("AttachmentView only supports LayerDrawables");
        }
    }

    private Drawable m4714a(Drawable drawable, boolean z) {
        if (!(drawable instanceof BitmapDrawable)) {
            return drawable;
        }
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        if (this.f4178D == 0 || this.f4179E == 0) {
            this.f4178D = bitmap.getWidth();
            this.f4179E = bitmap.getHeight();
        }
        Drawable shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, TileMode.REPEAT, TileMode.CLAMP));
        if (z) {
            return new ClipDrawable(shapeDrawable, 8388611, 1);
        }
        return shapeDrawable;
    }
}
