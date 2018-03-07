package com.facebook.uicontrib.pog;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringConfigRegistry;
import com.facebook.springs.SpringListener;
import com.facebook.springs.SpringSystem;
import com.facebook.tablet.Boolean_IsTabletMethodAutoProvider;
import com.facebook.tablet.IsTablet;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.dragsortgridview.ViewHoverRenderer.HoverableView;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: profile_cover_photo_vpv */
public class PogView extends CustomFrameLayout implements HoverableView {
    public static final SpringConfig f5920a = SpringConfig.a(70.0d, 5.0d);
    public static SpringSystem f5921g;
    @Inject
    public Resources f5922b;
    @Inject
    public Provider<SpringSystem> f5923c;
    @Inject
    public SpringConfigRegistry f5924d;
    @Inject
    FbDraweeControllerBuilder f5925e;
    @Inject
    @IsTablet
    public Boolean f5926f;
    private double f5927h;
    public DraweeHolder<GenericDraweeHierarchy> f5928i;
    public TextView f5929j;
    public TextView f5930k;
    private float f5931l;
    private int f5932m = -1;
    public Spring f5933n;
    public SpringListener f5934o;
    private Object f5935p;
    public boolean f5936q;
    private String f5937r;
    private boolean f5938s;
    public boolean f5939t;

    /* compiled from: profile_cover_photo_vpv */
    public class C11511 extends SimpleSpringListener {
        final /* synthetic */ PogView f15327a;

        public C11511(PogView pogView) {
            this.f15327a = pogView;
        }

        public final void m19342a(Spring spring) {
            this.f15327a.m7558a((float) this.f15327a.f5933n.d());
        }
    }

    public static void m7554a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PogView) obj).m7552a(ResourcesMethodAutoProvider.a(fbInjector), IdBasedProvider.a(fbInjector, 3433), SpringConfigRegistry.a(fbInjector), FbDraweeControllerBuilder.b(fbInjector), Boolean_IsTabletMethodAutoProvider.a(fbInjector));
    }

    public PogView(Context context) {
        super(context);
        Class cls = PogView.class;
        m7554a((Object) this, getContext());
        setContentView(2130906337);
        Resources resources = this.f5922b;
        int dimensionPixelSize = (resources.getDimensionPixelSize(2131430527) + resources.getDimensionPixelSize(2131430523)) + resources.getDimensionPixelSize(2131430541);
        int dimensionPixelSize2 = this.f5922b.getDimensionPixelSize(2131430521);
        setMinimumHeight(dimensionPixelSize);
        setMinimumWidth(dimensionPixelSize2);
        this.f5930k = (TextView) c(2131566171);
        this.f5929j = (TextView) c(2131563154);
        if (null != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, R.styleable.PogView);
            dimensionPixelSize2 = obtainStyledAttributes.getColor(0, getResources().getColor(2131363116));
            obtainStyledAttributes.recycle();
            GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(2130842715);
            gradientDrawable.setColor(dimensionPixelSize2);
            if (VERSION.SDK_INT >= 16) {
                this.f5930k.setBackground(gradientDrawable);
            } else {
                this.f5930k.setBackgroundDrawable(gradientDrawable);
            }
        }
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());
        genericDraweeHierarchyBuilder.u = RoundingParams.e().a(getResources().getColor(2131363119), TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        if (this.f5926f.booleanValue()) {
            genericDraweeHierarchyBuilder.a(null, ScaleType.c);
        } else {
            genericDraweeHierarchyBuilder.a(null, ScaleType.e);
        }
        this.f5928i = DraweeHolder.a(genericDraweeHierarchyBuilder.u(), getContext());
        this.f5928i.h().setCallback(this);
        if (f5921g == null) {
            f5921g = (SpringSystem) this.f5923c.get();
            SpringConfigRegistry springConfigRegistry = this.f5924d;
            SpringConfig springConfig = f5920a;
            String str = "POG Press/Release Scale";
            if (!springConfigRegistry.a.containsKey(Preconditions.checkNotNull(springConfig))) {
                springConfigRegistry.a.put(springConfig, Preconditions.checkNotNull(str));
            }
        }
        this.f5933n = f5921g.a().a(f5920a);
        this.f5934o = new C11511(this);
        setClickable(true);
        setWillNotDraw(false);
        this.f5936q = true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1617411013);
        if (this.f5939t) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            Logger.a(2, EntryType.UI_INPUT_END, 1695811604, a);
            return onTouchEvent;
        }
        LogUtils.a(1431643023, a);
        return false;
    }

    private void m7552a(Resources resources, Provider<SpringSystem> provider, SpringConfigRegistry springConfigRegistry, FbDraweeControllerBuilder fbDraweeControllerBuilder, Boolean bool) {
        this.f5922b = resources;
        this.f5923c = provider;
        this.f5924d = springConfigRegistry;
        this.f5925e = fbDraweeControllerBuilder;
        this.f5926f = bool;
    }

    public final void m7559a(String str, String str2, int i, String str3, double d, CallerContext callerContext) {
        if (!str.equals(this.f5937r)) {
            m7558a(0.0f);
        }
        this.f5927h = d;
        m7550a();
        if (m7555a(str, str2)) {
            this.f5935p = str2;
            this.f5937r = str;
            m7553a(str2 != null ? Uri.parse(str2) : null, str, callerContext);
        }
        this.f5929j.setText(str3);
        if (this.f5932m != i) {
            int dimensionPixelOffset = this.f5922b.getDimensionPixelOffset(2131430528) + ((((int) (((double) m7549a(this.f5922b)) * this.f5927h)) / 2) - (this.f5922b.getDimensionPixelOffset(2131430533) / 2));
            this.f5930k.setVisibility(i == 0 ? 8 : 0);
            this.f5930k.setText(i > 20 ? "20+" : String.valueOf(i));
            int dimensionPixelSize = this.f5922b.getDimensionPixelSize(2131430533);
            int dimensionPixelSize2 = this.f5922b.getDimensionPixelSize(2131430534);
            if (i > 20) {
                this.f5930k.setMinWidth(dimensionPixelSize + (dimensionPixelSize2 * 2));
                dimensionPixelSize = dimensionPixelOffset - dimensionPixelSize2;
            } else if (i > 9) {
                this.f5930k.setMinWidth(dimensionPixelSize + dimensionPixelSize2);
                dimensionPixelSize = dimensionPixelOffset - (dimensionPixelSize2 / 2);
            } else {
                this.f5930k.setMinWidth(dimensionPixelSize);
                dimensionPixelSize = dimensionPixelOffset;
            }
            m7551a(dimensionPixelSize);
        }
        this.f5932m = i;
        this.f5936q = false;
    }

    private void m7553a(Uri uri, String str, CallerContext callerContext) {
        if (uri != null || mo333a(str) == 0) {
            ((GenericDraweeHierarchy) this.f5928i.f()).b(null);
        } else {
            ((GenericDraweeHierarchy) this.f5928i.f()).b(mo333a(str));
        }
        ((FbDraweeControllerBuilder) this.f5925e.b(this.f5928i.f)).b(uri).a(callerContext);
        this.f5928i.a(this.f5925e.s());
    }

    protected int mo333a(String str) {
        return 0;
    }

    private boolean m7555a(String str, String str2) {
        if (this.f5936q || !this.f5937r.equals(str)) {
            return true;
        }
        if (str2 == null) {
            if (this.f5935p == null) {
                return false;
            }
            return true;
        } else if (str2.equals(this.f5935p)) {
            return false;
        } else {
            return true;
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f5928i.h();
    }

    protected void dispatchSetPressed(boolean z) {
        float f;
        super.dispatchSetPressed(z);
        if (z) {
            f = -1.0f;
        } else {
            f = 0.0f;
        }
        this.f5933n.b((double) f);
    }

    public final void mo331a(double d) {
        if (this.f5938s) {
            m7558a(((float) (d - 1.0d)) * 5.0f);
        }
    }

    public void draw(Canvas canvas) {
        int i = 0;
        int a = (int) (((double) m7549a(this.f5922b)) * this.f5927h);
        int left = (this.f5938s ? getLeft() : 0) + ((getWidth() - a) / 2);
        float min = Math.min(1.0f + (this.f5931l * 0.1f), 1.15f);
        int save = canvas.save();
        int dimensionPixelOffset = this.f5922b.getDimensionPixelOffset(2131430526);
        if (this.f5938s) {
            i = getTop();
        }
        i += dimensionPixelOffset;
        canvas.scale(min, min, ((float) getWidth()) / 2.0f, ((float) dimensionPixelOffset) + (((float) a) / 2.0f));
        Drawable h = this.f5928i.h();
        h.setBounds(left, i, left + a, a + i);
        h.draw(canvas);
        if (!this.f5938s) {
            if (this.f5932m != 0) {
                drawChild(canvas, this.f5930k, getDrawingTime());
            }
            canvas.restoreToCount(save);
            drawChild(canvas, this.f5929j, getDrawingTime());
        }
    }

    public void setHovering(boolean z) {
        if (z != this.f5938s) {
            if (z) {
                this.f5928i.b();
            } else {
                this.f5928i.d();
            }
            this.f5938s = z;
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), ((int) (this.f5927h * ((double) this.f5922b.getDimensionPixelSize(2131430523)))) + this.f5922b.getDimensionPixelSize(2131430541));
    }

    private void m7550a() {
        int dimensionPixelOffset = (int) (this.f5927h * ((double) this.f5922b.getDimensionPixelOffset(2131430523)));
        LayoutParams layoutParams = (LayoutParams) this.f5929j.getLayoutParams();
        if (layoutParams.topMargin != dimensionPixelOffset) {
            layoutParams.topMargin = dimensionPixelOffset;
            this.f5929j.setLayoutParams(layoutParams);
        }
    }

    private void m7551a(int i) {
        LayoutParams layoutParams = (LayoutParams) this.f5930k.getLayoutParams();
        if (layoutParams.leftMargin != i) {
            layoutParams.leftMargin = i;
            this.f5930k.setLayoutParams(layoutParams);
        }
    }

    public static int m7549a(Resources resources) {
        return resources.getDimensionPixelOffset(2131430522);
    }

    public final void m7558a(float f) {
        float f2 = 1.0f;
        this.f5931l = f;
        float f3 = f - 0.25f;
        if (f3 > 0.0f) {
            f2 = Math.max(0.0f, 1.0f - (f3 * 2.0f));
        }
        int currentTextColor = this.f5929j.getCurrentTextColor();
        this.f5929j.setTextColor(Color.argb((int) (f2 * 255.0f), Color.red(currentTextColor), Color.green(currentTextColor), Color.blue(currentTextColor)));
        invalidate();
    }

    public void setCurrentDragLevel(float f) {
        this.f5933n.a((double) f);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1823126096);
        super.onAttachedToWindow();
        this.f5933n.a(this.f5934o);
        this.f5928i.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1181071601, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f5928i.d();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f5928i.b();
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1925394928);
        super.onDetachedFromWindow();
        this.f5933n.b(this.f5934o);
        this.f5928i.d();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1759363789, a);
    }
}
