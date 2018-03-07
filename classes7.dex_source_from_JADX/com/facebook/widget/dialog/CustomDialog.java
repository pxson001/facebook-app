package com.facebook.widget.dialog;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.lockscreenservice.LockScreenService.AnonymousClass15;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.springs.SpringUtil;
import com.facebook.ui.animations.AnimationUtil;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: new_zoom_level */
public class CustomDialog extends CustomFrameLayout {
    private static final SpringConfig f8199a = new SpringConfig(40.0d, 7.0d);
    public final CustomFrameLayout f8200b;
    public final CustomFrameLayout f8201c;
    public final Spring f8202d;
    public final View f8203e;
    private final View f8204f;
    private final AnimationSpringListener f8205g;
    public final GestureDetector f8206h;
    public SpringSystem f8207i;
    public AnimationUtil f8208j;
    private boolean f8209k;
    private boolean f8210l;
    private Runnable f8211m;
    private boolean f8212n;
    public AnonymousClass15 f8213o;
    public AnimationType f8214p;
    public ViewGroup f8215q;
    public AnimationState f8216r = AnimationState.HIDDEN;

    /* compiled from: new_zoom_level */
    class C12131 extends SimpleOnGestureListener {
        final /* synthetic */ CustomDialog f15897a;

        C12131(CustomDialog customDialog) {
            this.f15897a = customDialog;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            this.f15897a.f8213o.m9836b();
            return true;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return CustomDialog.m9812e(this.f15897a);
        }
    }

    /* compiled from: new_zoom_level */
    class C12142 implements OnTouchListener {
        final /* synthetic */ CustomDialog f15898a;

        C12142(CustomDialog customDialog) {
            this.f15898a = customDialog;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!CustomDialog.m9812e(this.f15898a)) {
                return false;
            }
            this.f15898a.f8206h.onTouchEvent(motionEvent);
            return true;
        }
    }

    /* compiled from: new_zoom_level */
    class C12153 implements OnTouchListener {
        final /* synthetic */ CustomDialog f15899a;

        C12153(CustomDialog customDialog) {
            this.f15899a = customDialog;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* compiled from: new_zoom_level */
    class AnimationSpringListener extends SimpleSpringListener {
        final /* synthetic */ CustomDialog f15903a;

        public final void m19866b(Spring spring) {
            if (spring.i == 0.0d) {
                CustomDialog.m9815j(this.f15903a);
            } else if (spring.i == 1.0d) {
                CustomDialog.m9816k(this.f15903a);
            }
        }

        public final void m19867c(Spring spring) {
            if (spring.i == 0.0d) {
                CustomDialog.m9813h(this.f15903a);
            } else if (spring.i == 1.0d) {
                CustomDialog.m9814i(this.f15903a);
            }
        }

        public AnimationSpringListener(CustomDialog customDialog) {
            this.f15903a = customDialog;
        }

        public final void m19865a(Spring spring) {
            float a;
            float f;
            float f2 = 1.0f;
            float f3 = 0.0f;
            double d = spring.d();
            switch (this.f15903a.f8214p) {
                case HOOK_SHOT_BOTTOM:
                    f3 = (float) SpringUtil.a(d, 0.0d, 1.0d, (double) (((float) this.f15903a.getHeight()) * 1.1f), 0.0d);
                    a = (float) SpringUtil.a(d, 0.0d, 1.0d, 25.0d, 0.0d);
                    f = 1.0f;
                    break;
                case HOOK_SHOT_TOP:
                    f3 = (float) SpringUtil.a(d, 0.0d, 1.0d, (double) (((float) (-this.f15903a.getHeight())) * 1.1f), 0.0d);
                    a = (float) SpringUtil.a(d, 0.0d, 1.0d, -25.0d, 0.0d);
                    f = 1.0f;
                    break;
                case ZOOM:
                    f = (float) SpringUtil.a(d, 0.0d, 2.0d);
                    f2 = (float) SpringUtil.a(d, 0.0d, 1.0d);
                    a = 0.0f;
                    break;
                case APPEAR:
                    a = 0.0f;
                    f = 1.0f;
                    f2 = (float) SpringUtil.a(d, 0.0d, 1.0d);
                    break;
                case SLIDE_IN_BOTTOM:
                    a = 0.0f;
                    f3 = (float) SpringUtil.a(d, 0.0d, 1.0d, (double) (((float) this.f15903a.getHeight()) * 1.1f), 0.0d);
                    f = 1.0f;
                    break;
                default:
                    f = 1.0f;
                    a = 0.0f;
                    break;
            }
            float a2 = (float) SpringUtil.a(d, 0.0d, 1.0d);
            this.f15903a.f8203e.setTranslationY(f3);
            this.f15903a.f8203e.setRotation(a);
            this.f15903a.f8203e.setScaleX(f);
            this.f15903a.f8203e.setScaleY(f);
            this.f15903a.f8203e.setAlpha(f2);
            this.f15903a.f8200b.setAlpha(a2);
        }
    }

    /* compiled from: new_zoom_level */
    public enum AnimationState {
        HIDDEN,
        HIDING,
        REVEALING,
        REVEALED
    }

    /* compiled from: new_zoom_level */
    public enum AnimationType {
        HOOK_SHOT_TOP,
        HOOK_SHOT_BOTTOM,
        ZOOM,
        APPEAR,
        SLIDE_IN_BOTTOM
    }

    public static void m9811a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        CustomDialog customDialog = (CustomDialog) obj;
        SpringSystem b = SpringSystem.b(fbInjector);
        AnimationUtil a = AnimationUtil.a(fbInjector);
        customDialog.f8207i = b;
        customDialog.f8208j = a;
    }

    public CustomDialog(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = CustomDialog.class;
        m9811a((Object) this, getContext());
        LayoutInflater.from(context).inflate(2130903894, this, true);
        this.f8202d = this.f8207i.a().a(f8199a);
        this.f8205g = new AnimationSpringListener(this);
        this.f8200b = (CustomFrameLayout) c(2131560969);
        this.f8204f = c(2131560968);
        this.f8203e = c(2131560970);
        this.f8201c = (CustomFrameLayout) c(2131559223);
        this.f8204f.setVisibility(8);
        this.f8214p = AnimationType.HOOK_SHOT_BOTTOM;
        setFocusableInTouchMode(true);
        this.f8206h = new GestureDetector(context, new C12131(this));
        this.f8200b.setOnTouchListener(new C12142(this));
        this.f8201c.setOnTouchListener(new C12153(this));
    }

    protected void onConfigurationChanged(Configuration configuration) {
        this.f8212n = false;
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -228164496);
        super.onDetachedFromWindow();
        this.f8202d.b(this.f8205g);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -311729270, a);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 32418980);
        super.onAttachedToWindow();
        this.f8202d.a(this.f8205g);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1874924631, a);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f8209k = true;
        if (this.f8210l) {
            this.f8210l = false;
            post(this.f8211m);
        }
    }

    public void setBackground(Drawable drawable) {
        m9810a(this.f8200b, drawable);
    }

    public void setContainerLayout(LayoutParams layoutParams) {
        this.f8201c.setLayoutParams(layoutParams);
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        Object obj;
        if (this.f8216r == AnimationState.REVEALED) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null || i != 4 || this.f8213o == null) {
            return false;
        }
        this.f8213o.m9837c();
        return true;
    }

    public static boolean m9812e(CustomDialog customDialog) {
        return customDialog.f8216r == AnimationState.REVEALING || customDialog.f8216r == AnimationState.REVEALED;
    }

    public final CustomDialog m9817a(final boolean z) {
        if (!m9812e(this)) {
            if (this.f8209k) {
                this.f8216r = AnimationState.REVEALING;
                if (!this.f8212n) {
                    this.f8202d.b(0.0d).a(0.0d).l();
                    this.f8200b.setAlpha(0.0f);
                    this.f8203e.setTranslationY(((float) getHeight()) * 1.1f);
                    this.f8203e.setRotation(25.0f);
                    this.f8212n = true;
                }
                this.f8204f.setVisibility(0);
                if (z) {
                    Spring spring = this.f8202d;
                    spring.c = false;
                    spring.b(1.0d);
                } else {
                    m9814i(this);
                    this.f8200b.setAlpha(1.0f);
                    this.f8203e.setTranslationY(0.0f);
                    this.f8203e.setRotation(0.0f);
                    this.f8203e.setScaleX(1.0f);
                    this.f8203e.setScaleY(1.0f);
                    this.f8203e.setAlpha(1.0f);
                    this.f8202d.b(1.0d).a(1.0d).l();
                    m9816k(this);
                }
            } else {
                this.f8210l = true;
                this.f8211m = new Runnable(this) {
                    final /* synthetic */ CustomDialog f15901b;

                    public void run() {
                        this.f15901b.m9817a(z);
                    }
                };
            }
        }
        return this;
    }

    public final CustomDialog m9818b(boolean z) {
        Object obj;
        if (this.f8216r == AnimationState.HIDING || this.f8216r == AnimationState.HIDDEN) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            this.f8216r = AnimationState.HIDING;
            this.f8210l = false;
            this.f8211m = null;
            if (z) {
                Spring spring = this.f8202d;
                spring.c = true;
                spring.b(0.0d);
            } else {
                m9813h(this);
                this.f8200b.setAlpha(0.0f);
                this.f8203e.setTranslationY(((float) getHeight()) * 1.1f);
                this.f8203e.setRotation(25.0f);
                this.f8202d.b(0.0d).a(0.0d).l();
                m9815j(this);
            }
        }
        return this;
    }

    @TargetApi(16)
    public static void m9810a(View view, Drawable drawable) {
        if (VERSION.SDK_INT > 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void m9813h(CustomDialog customDialog) {
        customDialog.f8200b.setClickable(false);
        if (customDialog.f8213o != null) {
            customDialog.f8208j.a(customDialog.f8201c);
            customDialog.f8208j.a(customDialog.f8200b);
        }
    }

    public static void m9814i(CustomDialog customDialog) {
        if (customDialog.f8213o != null) {
            customDialog.f8208j.a(customDialog.f8201c);
            customDialog.f8208j.a(customDialog.f8200b);
        }
    }

    public static void m9815j(CustomDialog customDialog) {
        customDialog.f8216r = AnimationState.HIDDEN;
        customDialog.f8204f.setVisibility(8);
        if (customDialog.f8213o != null) {
            customDialog.f8208j.b(customDialog.f8201c);
            customDialog.f8208j.b(customDialog.f8200b);
            customDialog.f8213o.m9835a();
        }
    }

    public static void m9816k(CustomDialog customDialog) {
        customDialog.f8216r = AnimationState.REVEALED;
        customDialog.f8200b.setClickable(true);
        customDialog.requestFocus();
        if (customDialog.f8213o != null) {
            customDialog.f8208j.b(customDialog.f8201c);
            customDialog.f8208j.b(customDialog.f8200b);
        }
    }
}
