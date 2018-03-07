package com.facebook.rtc.views;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Scroller;
import com.facebook.common.util.FindViewUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler.Corner;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import javax.inject.Inject;

/* compiled from: authorization_url */
public class VoipDragSelfView extends RelativeLayout {
    private static final SpringConfig f20256u = SpringConfig.a(40.0d, 7.0d);
    @Inject
    SpringSystem f20257a;
    int f20258b;
    int f20259c;
    int f20260d;
    int f20261e;
    Bounds f20262f = new Bounds();
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<WebrtcUiHandler> f20263g = UltralightRuntime.b;
    public TextureView f20264h;
    private View f20265i;
    public Spring f20266j;
    public Spring f20267k;
    public int f20268l;
    public int f20269m;
    public int f20270n;
    public int f20271o;
    public int f20272p;
    public int f20273q;
    private Corner f20274r;
    private final int f20275s;
    private float f20276t = 1.0f;
    public boolean f20277v;
    private MarginChangedCallback f20278w;

    /* compiled from: authorization_url */
    public interface MarginChangedCallback {
        void mo805a(int i, int i2, int i3, int i4);
    }

    /* compiled from: authorization_url */
    class Bounds {
        int f20245a;
        int f20246b;
        int f20247c;
        int f20248d;

        public Bounds() {
            this.f20245a = 0;
            this.f20246b = 0;
            this.f20247c = 0;
            this.f20248d = 0;
        }
    }

    /* compiled from: authorization_url */
    class DragSelfTouchListener implements OnTouchListener {
        final /* synthetic */ VoipDragSelfView f20249a;
        private GestureDetector f20250b;

        public DragSelfTouchListener(VoipDragSelfView voipDragSelfView) {
            this.f20249a = voipDragSelfView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.f20250b = new GestureDetector(this.f20249a.getContext(), new GestureDetectorListener(this.f20249a));
            }
            float rawX = motionEvent.getRawX() - motionEvent.getX();
            float rawY = motionEvent.getRawY() - motionEvent.getY();
            motionEvent.offsetLocation(rawX, rawY);
            boolean onTouchEvent = this.f20250b.onTouchEvent(motionEvent);
            motionEvent.offsetLocation(-rawX, -rawY);
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && !onTouchEvent) {
                this.f20249a.m19894c();
                this.f20249a.f20271o;
            }
            return onTouchEvent;
        }
    }

    /* compiled from: authorization_url */
    class GestureDetectorListener extends SimpleOnGestureListener {
        Scroller f20251a;
        final /* synthetic */ VoipDragSelfView f20252b;

        public GestureDetectorListener(VoipDragSelfView voipDragSelfView) {
            this.f20252b = voipDragSelfView;
            this.f20251a = new Scroller(voipDragSelfView.getContext());
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            this.f20252b.f20268l = (int) motionEvent2.getX();
            this.f20252b.f20269m = (int) motionEvent2.getY();
            this.f20252b.f20272p = this.f20252b.f20268l - this.f20252b.f20270n;
            this.f20252b.f20273q = this.f20252b.f20269m - this.f20252b.f20271o;
            this.f20252b.m19880f();
            return false;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Bounds bounds = VoipDragSelfView.getBounds(this.f20252b);
            this.f20251a.abortAnimation();
            this.f20251a.fling(this.f20252b.f20268l, this.f20252b.f20269m, (int) f, (int) f2, bounds.f20245a, bounds.f20246b, bounds.f20247c, bounds.f20248d);
            float f3 = ((float) (bounds.f20247c + bounds.f20248d)) / 2.0f;
            double d = ((float) this.f20251a.getFinalX()) > ((float) (bounds.f20245a + bounds.f20246b)) / 2.0f ? (double) bounds.f20246b : (double) bounds.f20245a;
            double d2 = ((float) this.f20251a.getFinalY()) > f3 ? (double) bounds.f20248d : (double) bounds.f20247c;
            this.f20252b.f20266j.a((double) this.f20252b.f20272p);
            this.f20252b.f20266j.c((double) f);
            this.f20252b.f20266j.b(d);
            this.f20252b.f20267k.a((double) this.f20252b.f20273q);
            this.f20252b.f20267k.c((double) f2);
            this.f20252b.f20267k.b(d2);
            return true;
        }

        public boolean onDown(MotionEvent motionEvent) {
            this.f20252b.f20268l = (int) motionEvent.getX();
            this.f20252b.f20269m = (int) motionEvent.getY();
            this.f20252b.f20270n = this.f20252b.f20268l - this.f20252b.f20272p;
            this.f20252b.f20271o = this.f20252b.f20269m - this.f20252b.f20273q;
            return true;
        }
    }

    /* compiled from: authorization_url */
    class MySpringListener extends SimpleSpringListener {
        final /* synthetic */ VoipDragSelfView f20253a;

        public MySpringListener(VoipDragSelfView voipDragSelfView) {
            this.f20253a = voipDragSelfView;
        }

        public final void m19861a(Spring spring) {
            if (this.f20253a.f20266j.equals(spring)) {
                this.f20253a.f20272p = (int) this.f20253a.f20266j.d();
            } else {
                this.f20253a.f20273q = (int) this.f20253a.f20267k.d();
            }
            this.f20253a.m19880f();
        }
    }

    /* compiled from: authorization_url */
    class Position {
        int f20254a;
        int f20255b;
    }

    private static <T extends View> void m19867a(Class<T> cls, T t) {
        m19868a((Object) t, t.getContext());
    }

    private static void m19868a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((VoipDragSelfView) obj).m19865a(IdBasedLazy.a(fbInjector, 10375), SpringSystem.b(fbInjector));
    }

    private void m19865a(com.facebook.inject.Lazy<WebrtcUiHandler> lazy, SpringSystem springSystem) {
        this.f20263g = lazy;
        this.f20257a = springSystem;
    }

    public VoipDragSelfView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19867a(VoipDragSelfView.class, (View) this);
        LayoutInflater.from(context).inflate(2130907747, this);
        this.f20264h = (TextureView) FindViewUtil.b(this, 2131568452);
        this.f20265i = FindViewUtil.b(this, 2131568453);
        this.f20274r = ((WebrtcUiHandler) this.f20263g.get()).bT;
        this.f20275s = getResources().getDimensionPixelSize(2131427928);
    }

    public final boolean m19891a() {
        return this.f20277v;
    }

    public final void m19888a(int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        m19873c(layoutParams.width, layoutParams.height);
        m19893b(i, i2);
        this.f20277v = true;
    }

    public final void m19890a(MarginChangedCallback marginChangedCallback) {
        Spring a = this.f20257a.a().a(f20256u);
        a.k = 0.3d;
        a = a;
        a.l = 0.3d;
        this.f20266j = a.a(new MySpringListener(this));
        a = this.f20257a.a().a(f20256u);
        a.k = 0.3d;
        a = a;
        a.l = 0.3d;
        this.f20267k = a.a(new MySpringListener(this));
        if (marginChangedCallback == null) {
            throw new IllegalArgumentException("Must pass a valid marginChangedCallback to support dragging behavior");
        }
        this.f20278w = marginChangedCallback;
        setOnTouchListener(new DragSelfTouchListener(this));
    }

    public TextureView getPreviewTextureView() {
        return this.f20264h;
    }

    public final void m19892b() {
        this.f20271o;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        Object obj = 1;
        int i5 = this.f20275s * 2;
        float f = ((float) (this.f20259c - i5)) / ((float) (this.f20258b - i5));
        boolean g = m19883g();
        int i6 = g ? this.f20259c : this.f20258b;
        int i7 = g ? this.f20258b : this.f20259c;
        if (g) {
            if (this.f20276t >= f) {
                obj = null;
            }
        } else if (this.f20276t <= f) {
            obj = null;
        }
        if (obj != null) {
            i3 = i6 - i5;
            i4 = g ? (int) (((float) i3) / this.f20276t) : (int) (((float) i3) * this.f20276t);
        } else {
            i3 = i7 - i5;
            int i8 = i3;
            i3 = g ? (int) (((float) i3) * this.f20276t) : (int) (((float) i3) / this.f20276t);
            i4 = i8;
        }
        m19873c(i6, i7);
        Matrix matrix = new Matrix();
        matrix.setScale(((float) i3) / ((float) (i6 - i5)), ((float) i4) / ((float) (i7 - i5)));
        this.f20264h.setTransform(matrix);
        setMeasuredDimension(i6, i7);
        super.onMeasure(MeasureSpec.makeMeasureSpec(i6, 1073741824), MeasureSpec.makeMeasureSpec(i7, 1073741824));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View findViewById = getRootView().findViewById(16908290);
        int width = findViewById.getWidth();
        int height = findViewById.getHeight();
        if (this.f20260d != width || this.f20261e != height) {
            m19893b(width, height);
        }
    }

    public final void m19894c() {
        Bounds bounds = getBounds(this);
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        Position position = new Position();
        position.f20254a = layoutParams.leftMargin;
        position.f20255b = layoutParams.topMargin;
        Position position2 = new Position();
        position2.f20254a = m19862a(position.f20254a, bounds.f20245a, bounds.f20246b);
        position2.f20255b = m19862a(position.f20255b, bounds.f20247c, bounds.f20248d);
        if (position2.f20254a == bounds.f20245a && position2.f20255b == bounds.f20247c) {
            this.f20274r = Corner.TOP_LEFT;
        } else if (position2.f20254a == bounds.f20246b && position2.f20255b == bounds.f20247c) {
            this.f20274r = Corner.TOP_RIGHT;
        } else if (position2.f20254a == bounds.f20246b && position2.f20255b == bounds.f20248d) {
            this.f20274r = Corner.BOTTOM_RIGHT;
        } else {
            this.f20274r = Corner.BOTTOM_LEFT;
        }
        ((WebrtcUiHandler) this.f20263g.get()).bT = this.f20274r;
    }

    public final void m19895d() {
        if (((WebrtcUiHandler) this.f20263g.get()).m19484u() && (((WebrtcUiHandler) this.f20263g.get()).az() || ((WebrtcUiHandler) this.f20263g.get()).m19433D())) {
            this.f20265i.setVisibility(0);
        } else {
            this.f20265i.setVisibility(8);
        }
    }

    private void m19873c(int i, int i2) {
        int min = Math.min(i, i2);
        this.f20259c = Math.max(i, i2);
        this.f20258b = min;
    }

    public final void m19893b(int i, int i2) {
        this.f20260d = i;
        this.f20261e = i2;
        this.f20271o;
    }

    public final void m19889a(int i, int i2, int i3, int i4, boolean z) {
        if (this.f20262f.f20245a != i || this.f20262f.f20246b != i2 || this.f20262f.f20247c != i3 || this.f20262f.f20248d != i4) {
            this.f20262f.f20245a = i;
            this.f20262f.f20246b = i2;
            this.f20262f.f20247c = i3;
            this.f20262f.f20248d = i4;
            if (z) {
                this.f20271o;
                return;
            }
            m19894c();
            this.f20271o;
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        this.f20264h.setVisibility(i);
    }

    public void setTextureAspectRatio(float f) {
        this.f20276t = f;
        if (this.f20276t < 1.0f) {
            this.f20276t = 1.0f / this.f20276t;
        }
        forceLayout();
    }

    public static void m19878e(VoipDragSelfView voipDragSelfView) {
        LayoutParams layoutParams = (LayoutParams) voipDragSelfView.getLayoutParams();
        Bounds bounds = getBounds(voipDragSelfView);
        Position position = new Position();
        switch (voipDragSelfView.f20274r) {
            case TOP_LEFT:
                position.f20254a = bounds.f20245a;
                position.f20255b = bounds.f20247c;
                break;
            case TOP_RIGHT:
                position.f20254a = bounds.f20246b;
                position.f20255b = bounds.f20247c;
                break;
            case BOTTOM_RIGHT:
                position.f20254a = bounds.f20246b;
                position.f20255b = bounds.f20248d;
                break;
            case BOTTOM_LEFT:
                position.f20254a = bounds.f20245a;
                position.f20255b = bounds.f20248d;
                break;
            default:
                return;
        }
        voipDragSelfView.f20266j.a((double) layoutParams.leftMargin);
        voipDragSelfView.f20266j.b((double) position.f20254a);
        voipDragSelfView.f20267k.a((double) layoutParams.topMargin);
        voipDragSelfView.f20267k.b((double) position.f20255b);
    }

    private void m19880f() {
        this.f20278w.mo805a(this.f20272p, this.f20273q, -250, -250);
    }

    private <T extends View> T m19864a(int i) {
        return FindViewUtil.b(this, i);
    }

    private boolean m19883g() {
        return getResources().getConfiguration().orientation == 2;
    }

    private static int m19862a(int i, int i2, int i3) {
        return Math.abs(i - i2) < Math.abs(i - i3) ? i2 : i3;
    }

    public static Bounds getBounds(VoipDragSelfView voipDragSelfView) {
        Bounds bounds = new Bounds();
        bounds.f20247c = voipDragSelfView.f20262f.f20247c;
        bounds.f20248d = (voipDragSelfView.m19883g() ? voipDragSelfView.f20261e - voipDragSelfView.f20258b : voipDragSelfView.f20261e - voipDragSelfView.f20259c) - voipDragSelfView.f20262f.f20248d;
        bounds.f20245a = voipDragSelfView.f20262f.f20245a;
        bounds.f20246b = (voipDragSelfView.m19883g() ? voipDragSelfView.f20260d - voipDragSelfView.f20259c : voipDragSelfView.f20260d - voipDragSelfView.f20258b) - voipDragSelfView.f20262f.f20246b;
        return bounds;
    }
}
