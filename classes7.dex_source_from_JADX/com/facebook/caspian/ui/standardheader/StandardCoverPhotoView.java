package com.facebook.caspian.ui.standardheader;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeView;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: crop_adjustment_count */
public class StandardCoverPhotoView extends DraweeView {
    @Inject
    public Provider<FbDraweeControllerBuilder> f16558a;
    private CallerContext f16559b;
    private ImageRequest f16560c;
    public ImageRequest f16561d;
    private PointF f16562e;
    private Paint f16563f;
    private ImageWithTextView f16564g;
    @Nullable
    private Drawable f16565h;
    private Drawable f16566i;
    private CoverPhotoVignetteDrawable f16567j;
    private int f16568k;
    private boolean f16569l;
    private boolean f16570m;
    private boolean f16571n;
    private int f16572o;
    public boolean f16573p;
    public BaseControllerListener f16574q;

    /* compiled from: crop_adjustment_count */
    public class StandardCoverPhotoControllerListener extends BaseControllerListener {
        final /* synthetic */ StandardCoverPhotoView f16557a;

        public StandardCoverPhotoControllerListener(StandardCoverPhotoView standardCoverPhotoView) {
            this.f16557a = standardCoverPhotoView;
        }

        public final void m20613a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            CloseableImage closeableImage = (CloseableImage) obj;
            if (this.f16557a.f16574q != null) {
                this.f16557a.f16574q.a(str, closeableImage, animatable);
            }
            if (this.f16557a.f16561d == null) {
                m20611b();
            }
        }

        public final void m20615b(String str, @Nullable Object obj) {
            CloseableImage closeableImage = (CloseableImage) obj;
            if (this.f16557a.f16574q != null) {
                this.f16557a.f16574q.b(str, closeableImage);
            }
        }

        public final void m20612a(String str, Object obj) {
            if (this.f16557a.f16574q != null) {
                this.f16557a.f16574q.a(str, obj);
            }
        }

        public final void m20614a(String str, Throwable th) {
            if (this.f16557a.f16574q != null) {
                this.f16557a.f16574q.a(str, th);
            }
        }

        public final void m20616b(String str, Throwable th) {
            if (this.f16557a.f16574q != null) {
                this.f16557a.f16574q.b(str, th);
            }
            if (this.f16557a.f16561d == null) {
                m20611b();
            }
        }

        private void m20611b() {
            if (!this.f16557a.f16573p && this.f16557a.f16561d != null) {
                this.f16557a.m20624a(true);
            }
        }
    }

    private static <T extends View> void m20621a(Class<T> cls, T t) {
        m20622a((Object) t, t.getContext());
    }

    private static void m20622a(Object obj, Context context) {
        ((StandardCoverPhotoView) obj).f16558a = IdBasedProvider.a(FbInjector.get(context), 1117);
    }

    private void m20623a(Provider<FbDraweeControllerBuilder> provider) {
        this.f16558a = provider;
    }

    public StandardCoverPhotoView(Context context) {
        this(context, null);
        m20619a(context);
    }

    public StandardCoverPhotoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16569l = false;
        this.f16570m = false;
        this.f16571n = false;
        m20619a(context);
    }

    private void m20619a(Context context) {
        m20621a(StandardCoverPhotoView.class, (View) this);
        setClickable(true);
        this.f16566i = context.getResources().getDrawable(2130843447);
        Drawable drawable = context.getResources().getDrawable(2130843446);
        this.f16567j = new CoverPhotoVignetteDrawable(getResources());
        this.f16572o = context.getResources().getDimensionPixelSize(2131427557);
        this.f16564g = (ImageWithTextView) LayoutInflater.from(context).inflate(2130907215, null, false);
        this.f16564g.setLayoutParams(new LayoutParams(0, -1));
        setHierarchy(new GenericDraweeHierarchyBuilder(context.getResources()).a(this.f16566i, ScaleType.h).f(drawable).e(ScaleType.h).u());
        this.f16563f = new Paint(1);
        this.f16563f.setStrokeWidth((float) getResources().getDimensionPixelSize(2131427380));
        this.f16563f.setColor(getResources().getColor(2131362074));
    }

    public final void m20629a(int i, int i2, boolean z, ImageRequest imageRequest, ImageRequest imageRequest2, PointF pointF, boolean z2, boolean z3, String[] strArr, CallerContext callerContext, OnClickListener onClickListener, BaseControllerListener baseControllerListener, boolean z4, boolean z5) {
        TracerDetour.a("StandardCoverPhotoView.bindModel", -2002833156);
        try {
            m20618a(i2, z, imageRequest, imageRequest2, pointF, z2, z3, strArr, callerContext, onClickListener, baseControllerListener, z4, z5);
        } finally {
            TracerDetour.a(2094448698);
        }
    }

    private void m20618a(int i, boolean z, ImageRequest imageRequest, ImageRequest imageRequest2, PointF pointF, boolean z2, boolean z3, String[] strArr, CallerContext callerContext, OnClickListener onClickListener, BaseControllerListener baseControllerListener, boolean z4, boolean z5) {
        this.f16568k = i;
        this.f16562e = pointF;
        this.f16569l = z4;
        this.f16570m = z2;
        this.f16559b = callerContext;
        this.f16573p = z;
        this.f16560c = imageRequest;
        this.f16561d = imageRequest2;
        m20628e();
        boolean z6 = !m20627d() && z5 && z3;
        this.f16571n = z6;
        if (m20627d()) {
            CharSequence a;
            if (strArr != null && strArr.length == 1) {
                a = StringLocaleUtil.a(getResources().getString(2131230843), strArr);
            } else if (strArr == null || strArr.length != 2) {
                a = getResources().getString(2131230814);
            } else {
                a = StringLocaleUtil.a(getResources().getString(2131230844), strArr);
            }
            setContentDescription(a);
            this.f16574q = baseControllerListener;
            if (this.f16560c == null) {
                z6 = true;
            } else {
                z6 = false;
            }
            m20624a(z6);
        } else if (z5) {
            setContentDescription(getResources().getString(2131230848));
            setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f16558a.get()).a(this.f16559b).b(getController())).d(null)).c(null)).a(null)).s());
        }
        setOnClickListener(onClickListener);
    }

    private boolean m20627d() {
        if (this.f16560c == null && this.f16561d == null) {
            return false;
        }
        return true;
    }

    private void m20628e() {
        getLayoutParams().height = this.f16568k;
        requestLayout();
    }

    public void setPlaceholderDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            ((GenericDraweeHierarchy) getHierarchy()).b(this.f16566i);
            return;
        }
        ((GenericDraweeHierarchy) getHierarchy()).b(drawable);
        ((GenericDraweeHierarchy) getHierarchy()).b(this.f16562e == null ? new PointF(0.5f, 0.5f) : this.f16562e);
    }

    private void m20624a(boolean z) {
        ((GenericDraweeHierarchy) getHierarchy()).a(this.f16562e != null ? this.f16562e : new PointF(0.5f, 0.5f));
        setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f16558a.get()).a(this.f16559b).b(getController())).d(this.f16560c)).c(z ? this.f16561d : null)).r().a(new StandardCoverPhotoControllerListener(this))).s());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.f16569l) {
                this.f16567j.setBounds(0, getHeight() - this.f16572o, getWidth(), getHeight());
            }
            this.f16564g.layout(0, 0, this.f16564g.getMeasuredWidth(), this.f16564g.getMeasuredHeight());
            if (this.f16570m) {
                getEditIconDrawable().setBounds(getWidth() - getEditIconDrawable().getIntrinsicWidth(), getHeight() - getEditIconDrawable().getIntrinsicHeight(), getWidth(), getHeight());
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f16564g.measure(MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i), Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), Integer.MIN_VALUE));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0.0f, (float) getHeight(), (float) getWidth(), (float) getHeight(), this.f16563f);
        if (this.f16569l) {
            this.f16567j.draw(canvas);
        }
        if (this.f16571n) {
            int width = (getWidth() - this.f16564g.getMeasuredWidth()) / 2;
            int height = (getHeight() - this.f16564g.getMeasuredHeight()) / 4;
            canvas.save();
            canvas.translate((float) width, (float) height);
            this.f16564g.draw(canvas);
            canvas.restore();
        }
        if (this.f16570m) {
            canvas.save();
            if ((ViewCompat.h(this) == 1 ? 1 : null) != null) {
                canvas.scale(-1.0f, 1.0f, ((float) getWidth()) * 0.5f, ((float) getHeight()) * 0.5f);
            }
            getEditIconDrawable().draw(canvas);
            canvas.restore();
        }
    }

    private Drawable getEditIconDrawable() {
        if (this.f16565h == null) {
            this.f16565h = getResources().getDrawable(2130842637);
        }
        return this.f16565h;
    }

    public final boolean m20630c() {
        return this.f16561d != null;
    }
}
