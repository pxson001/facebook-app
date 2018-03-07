package com.facebook.messaging.composershortcuts;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;

/* compiled from: messenger_business_you_may_message */
public class ComposerButton extends ImageView {
    private static final CallerContext f9943d = CallerContext.a(ComposerButton.class);
    @Inject
    FbDraweeControllerBuilder f9944a;
    @Inject
    ComposerButtonColorUtil f9945b;
    @Inject
    GlyphColorizer f9946c;
    private DraweeHolder<GenericDraweeHierarchy> f9947e;
    private ComposerShortcutItem f9948f;
    public OnClickListener f9949g;
    public OnFlingUpListener f9950h;
    private float f9951i;
    private float f9952j;
    private int f9953k;
    public ComposerButtonStateObserver f9954l;
    private GestureDetectorCompat f9955m;
    private OnGestureListener f9956n;
    public int f9957o;
    private boolean f9958p;
    private Drawable f9959q;
    private int f9960r;
    private int f9961s;

    /* compiled from: messenger_business_you_may_message */
    class C11601 implements OnClickListener {
        final /* synthetic */ ComposerButton f9941a;

        C11601(ComposerButton composerButton) {
            this.f9941a = composerButton;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1224088355);
            if (!this.f9941a.f9950h) {
                this.f9941a.setSelected(false);
            } else if (this.f9941a.f9949g != null) {
                this.f9941a.f9949g.onClick(view);
            }
            LogUtils.a(48733221, a);
        }
    }

    /* compiled from: messenger_business_you_may_message */
    public interface ComposerButtonStateObserver {
        float m10494a(ComposerShortcutItem composerShortcutItem);

        float m10495b(ComposerShortcutItem composerShortcutItem);
    }

    /* compiled from: messenger_business_you_may_message */
    class OnButtonGestureListener extends SimpleOnGestureListener {
        final /* synthetic */ ComposerButton f9942a;

        public OnButtonGestureListener(ComposerButton composerButton) {
            this.f9942a = composerButton;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (f2 <= ((float) (-this.f9942a.f9957o)) && this.f9942a.f9950h != null) {
                this.f9942a.f9950h.mo405a();
            }
            return true;
        }
    }

    /* compiled from: messenger_business_you_may_message */
    public interface OnFlingUpListener {
        void mo405a();
    }

    private static <T extends View> void m10498a(Class<T> cls, T t) {
        m10499a((Object) t, t.getContext());
    }

    private static void m10499a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ComposerButton) obj).m10497a(FbDraweeControllerBuilder.b(injectorLike), ComposerButtonColorUtil.m10509a(injectorLike), GlyphColorizer.a(injectorLike));
    }

    private void m10497a(FbDraweeControllerBuilder fbDraweeControllerBuilder, ComposerButtonColorUtil composerButtonColorUtil, GlyphColorizer glyphColorizer) {
        this.f9944a = fbDraweeControllerBuilder;
        this.f9945b = composerButtonColorUtil;
        this.f9946c = glyphColorizer;
    }

    public ComposerButton(Context context) {
        super(context);
        m10503c();
    }

    public ComposerButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10503c();
    }

    public ComposerButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10503c();
    }

    private void m10503c() {
        m10498a(ComposerButton.class, (View) this);
        Resources resources = getResources();
        this.f9953k = resources.getDimensionPixelSize(2131427831);
        setScaleType(ScaleType.CENTER_INSIDE);
        GenericDraweeHierarchyBuilder e = new GenericDraweeHierarchyBuilder(resources).e(ScalingUtils.ScaleType.f);
        e.u = RoundingParams.e();
        this.f9947e = DraweeHolder.a(e.u(), getContext());
        this.f9957o = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 246216602);
        super.onAttachedToWindow();
        this.f9947e.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 471236920, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 194981496);
        super.onDetachedFromWindow();
        this.f9947e.d();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 755764413, a);
    }

    public final void m10507a() {
        this.f9958p = true;
        invalidate();
    }

    public final void m10508b() {
        this.f9958p = false;
        invalidate();
    }

    public void setComposerShortcut(ComposerShortcutItem composerShortcutItem) {
        int i = this.f9948f != composerShortcutItem ? 1 : 0;
        this.f9948f = composerShortcutItem;
        if (composerShortcutItem == null) {
            setImageDrawable(null);
            setContentDescription(null);
        } else if (i != 0) {
            Drawable a = this.f9945b.m10515a(this.f9948f);
            if (a != null) {
                setImageDrawable(a);
                this.f9947e.a(null);
                setPadding(0, 0, 0, 0);
            } else if (this.f9948f.f9976e != null) {
                this.f9947e.a(((FbDraweeControllerBuilder) this.f9944a.a(f9943d).b(Uri.parse(this.f9948f.f9976e)).b(this.f9947e.f)).s());
                setImageDrawable(this.f9947e.h());
                setPadding(this.f9953k, this.f9953k, this.f9953k, this.f9953k);
            } else {
                this.f9947e.a(null);
                setImageDrawable(null);
                setPadding(0, 0, 0, 0);
            }
            setContentDescription(this.f9948f.f9978g);
        }
        m10506e();
    }

    public ComposerShortcutItem getComposerShortcut() {
        return this.f9948f;
    }

    public String getComposerShortcutId() {
        return this.f9948f != null ? this.f9948f.f9973b : null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean a;
        boolean z = false;
        int a2 = Logger.a(2, EntryType.UI_INPUT_START, 250057587);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && this.f9955m == null) {
            if (this.f9956n == null) {
                this.f9956n = new OnButtonGestureListener(this);
            }
            this.f9955m = new GestureDetectorCompat(getContext(), this.f9956n);
        }
        if (this.f9955m != null) {
            a = this.f9955m.a(motionEvent);
            if (a) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(3);
                super.onTouchEvent(obtain);
            }
        } else {
            a = false;
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f9955m = null;
        }
        this.f9951i = motionEvent.getX();
        this.f9952j = motionEvent.getY();
        if (a || super.onTouchEvent(motionEvent)) {
            z = true;
        }
        LogUtils.a(1388810359, a2);
        return z;
    }

    public void setPressed(boolean z) {
        if (!z || this.f9950h) {
            super.setPressed(z);
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f9949g = onClickListener;
        super.setOnClickListener(new C11601(this));
    }

    public void setOnFlingUpListener(OnFlingUpListener onFlingUpListener) {
        this.f9950h = onFlingUpListener;
    }

    public void setComposerButtonStateObserver(ComposerButtonStateObserver composerButtonStateObserver) {
        this.f9954l = composerButtonStateObserver;
    }

    public static boolean m10505d(ComposerButton composerButton) {
        if (composerButton.f9954l == null) {
            return true;
        }
        float a = composerButton.f9954l.m10494a(composerButton.f9948f);
        float b = composerButton.f9954l.m10495b(composerButton.f9948f);
        if (composerButton.f9951i >= 0.0f && composerButton.f9951i <= ((float) composerButton.getWidth()) && composerButton.f9952j >= a * ((float) composerButton.getHeight())) {
            if (composerButton.f9952j <= (1.0f - b) * ((float) composerButton.getHeight())) {
                return true;
            }
        }
        return false;
    }

    public void setDefaultColorFilterColorOverride(int i) {
        if (this.f9961s != i) {
            this.f9961s = i;
            drawableStateChanged();
        }
    }

    public void setSelectedColorFilterColorOverride(int i) {
        if (this.f9948f != null && this.f9948f.f9988q != 0) {
            this.f9960r = this.f9948f.f9988q;
        } else if (this.f9960r != i) {
            this.f9960r = i;
            drawableStateChanged();
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        m10506e();
    }

    private void m10506e() {
        if (this.f9948f == null || !this.f9948f.f9987p) {
            setColorFilter(null);
        } else if (!isEnabled()) {
            setColorFilter(this.f9945b.m10516b());
        } else if (isSelected()) {
            if (this.f9960r != 0) {
                setColorFilter(this.f9946c.a(this.f9960r));
            } else {
                setColorFilter(this.f9945b.m10513a());
            }
        } else if (this.f9961s != 0) {
            setColorFilter(this.f9946c.a(this.f9961s));
        } else {
            setColorFilter(this.f9945b.m10514a(this.f9948f.f9973b));
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        boolean equals = this.f9948f.f9973b.equals("overflow");
        if (this.f9958p && equals) {
            if (this.f9959q == null) {
                this.f9959q = getResources().getDrawable(2130842426).mutate();
            }
            float dimension = getResources().getDimension(2131428502);
            canvas.translate(((float) (getWidth() / 2)) + dimension, ((float) (getHeight() / 2)) - dimension);
            this.f9959q.draw(canvas);
        }
    }
}
