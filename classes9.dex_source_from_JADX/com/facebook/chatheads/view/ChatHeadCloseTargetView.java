package com.facebook.chatheads.view;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: read_status */
public class ChatHeadCloseTargetView extends CustomFrameLayout {
    private static final SpringConfig f5761b = SpringConfig.a(40.0d, 7.0d);
    private static final SpringConfig f5762c = SpringConfig.a(150.0d, 9.0d);
    public SettableFuture<Void> f5763A;
    private PointF f5764B;
    private boolean f5765C;
    public boolean f5766a;
    private final View f5767d;
    private final View f5768e;
    public final View f5769f;
    private final View f5770g;
    public final Spring f5771h;
    public final Spring f5772i;
    public final Spring f5773j;
    public final Spring f5774k;
    private final int f5775l;
    private final int f5776m;
    private final int f5777n;
    private final int f5778o;
    private final int f5779p;
    private final int f5780q;
    private final int f5781r;
    private final int f5782s;
    private SpringSystem f5783t;
    private boolean f5784u;
    private boolean f5785v;
    public float f5786w;
    public float f5787x;
    private OnCloseBaublePositionChangeListener f5788y;
    private OnCloseBaubleStateChangeListener f5789z;

    /* compiled from: read_status */
    class C06081 implements FutureCallback<Void> {
        final /* synthetic */ ChatHeadCloseTargetView f5759a;

        C06081(ChatHeadCloseTargetView chatHeadCloseTargetView) {
            this.f5759a = chatHeadCloseTargetView;
        }

        public void onSuccess(Object obj) {
            ChatHeadCloseTargetView.m5992c(this.f5759a, this.f5759a.f5786w, this.f5759a.f5787x);
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: read_status */
    class MySpringListener extends SimpleSpringListener {
        final /* synthetic */ ChatHeadCloseTargetView f5760a;

        public MySpringListener(ChatHeadCloseTargetView chatHeadCloseTargetView) {
            this.f5760a = chatHeadCloseTargetView;
        }

        public final void m5980a(Spring spring) {
            if (spring == this.f5760a.f5771h) {
                ChatHeadCloseTargetView.setBaubleX(this.f5760a, (float) spring.d());
            } else if (spring == this.f5760a.f5772i) {
                ChatHeadCloseTargetView.setBaubleY(this.f5760a, (float) spring.d());
            } else if (spring == this.f5760a.f5773j) {
                this.f5760a.f5769f.setScaleX((float) spring.d());
                this.f5760a.f5769f.setScaleY((float) spring.d());
            } else if (spring == this.f5760a.f5774k) {
                this.f5760a.m6000h();
            }
        }

        public final void m5981b(Spring spring) {
            if (this.f5760a.f5774k.k() && this.f5760a.f5774k.d() == 0.0d) {
                this.f5760a.f5773j.a(0.7d).l();
            }
            if (this.f5760a.f5763A != null && this.f5760a.f5774k) {
                FutureDetour.a(this.f5760a.f5763A, null, -1303717029);
                this.f5760a.f5763A = null;
            }
        }
    }

    /* compiled from: read_status */
    public interface OnCloseBaublePositionChangeListener {
    }

    /* compiled from: read_status */
    public interface OnCloseBaubleStateChangeListener {
    }

    private static <T extends View> void m5987a(Class<T> cls, T t) {
        m5988a((Object) t, t.getContext());
    }

    private static void m5988a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ChatHeadCloseTargetView) obj).m5986a(SpringSystem_ForChatHeadsMethodAutoProvider.m6049a(fbInjector), IdBasedProvider.a(fbInjector, 4129));
    }

    public ChatHeadCloseTargetView(Context context) {
        this(context, null);
    }

    public ChatHeadCloseTargetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatHeadCloseTargetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5764B = new PointF();
        m5987a(ChatHeadCloseTargetView.class, (View) this);
        setContentView(2130905573);
        this.f5767d = c(2131560476);
        this.f5768e = c(2131564461);
        this.f5769f = c(2131564462);
        this.f5770g = c(2131564464);
        MySpringListener mySpringListener = new MySpringListener(this);
        this.f5771h = this.f5783t.a().a(f5761b).a(mySpringListener);
        this.f5772i = this.f5783t.a().a(f5761b).a(mySpringListener);
        Spring b = this.f5783t.a().a(f5762c).a(mySpringListener).a(0.7d).b(0.7d);
        b.l = 0.004999999888241291d;
        b = b;
        b.l = 0.004999999888241291d;
        this.f5773j = b;
        Spring b2 = this.f5783t.a().a(f5761b).a(mySpringListener).a(0.0d).b(0.0d);
        b2.c = true;
        b2 = b2;
        b2.l = 0.004999999888241291d;
        b2 = b2;
        b2.l = 0.004999999888241291d;
        this.f5774k = b2;
        this.f5775l = getResources().getDimensionPixelOffset(2131427778);
        this.f5776m = getResources().getDimensionPixelOffset(2131427779);
        this.f5777n = getResources().getDimensionPixelSize(2131427780);
        this.f5778o = getResources().getDimensionPixelSize(2131427781);
        this.f5779p = getResources().getDimensionPixelSize(2131427782);
        this.f5780q = getResources().getDimensionPixelOffset(2131427783);
        this.f5781r = getResources().getDimensionPixelOffset(2131427784);
        this.f5782s = getResources().getDimensionPixelOffset(2131427785);
        m6004a();
        m5997f();
    }

    public void setShowEndCallBauble(boolean z) {
        this.f5766a = z;
    }

    @Inject
    private void m5986a(SpringSystem springSystem, Provider<Boolean> provider) {
        this.f5783t = springSystem;
        this.f5765C = !((Boolean) provider.get()).booleanValue();
    }

    public void setOnCloseBaublePositionListener(OnCloseBaublePositionChangeListener onCloseBaublePositionChangeListener) {
        this.f5788y = onCloseBaublePositionChangeListener;
    }

    public void setOnCloseBaubleStateChangeListener(OnCloseBaubleStateChangeListener onCloseBaubleStateChangeListener) {
        this.f5789z = onCloseBaubleStateChangeListener;
    }

    public final ListenableFuture<Void> m6004a() {
        if (!this.f5784u) {
            Spring spring;
            m5995e();
            this.f5785v = false;
            this.f5784u = true;
            this.f5763A = SettableFuture.f();
            this.f5771h.b(0.0d).c = true;
            this.f5772i.b((double) this.f5776m).c = true;
            if (this.f5765C) {
                spring = this.f5773j;
                spring.c = true;
                spring.b(0.7d);
            }
            spring = this.f5774k;
            spring.c = true;
            spring.b(0.0d);
            if (this.f5774k) {
                FutureDetour.a(this.f5763A, null, -1254407558);
            }
            return this.f5763A;
        } else if (this.f5763A != null) {
            return this.f5763A;
        } else {
            return Futures.a(null);
        }
    }

    public final void m6005a(float f, float f2) {
        if (this.f5784u) {
            m5995e();
        }
        this.f5784u = false;
        if (this.f5785v || m6008b(f, f2)) {
            m5992c(this, f, f2);
        }
        if (!this.f5785v) {
            this.f5786w = f;
            this.f5787x = f2;
            if (this.f5763A == null) {
                this.f5763A = SettableFuture.f();
                Futures.a(this.f5763A, new C06081(this));
                this.f5774k.b(1.0d);
                if (this.f5774k) {
                    FutureDetour.a(this.f5763A, null, 1530622996);
                }
            }
        }
    }

    public final void m6007b() {
        if (!this.f5785v) {
            m5995e();
        }
        m5992c(this, (float) getCloseBaubleCenterXInScreen(), 0.0f);
    }

    public static void m5992c(ChatHeadCloseTargetView chatHeadCloseTargetView, float f, float f2) {
        chatHeadCloseTargetView.m5995e();
        chatHeadCloseTargetView.f5784u = false;
        chatHeadCloseTargetView.f5785v = true;
        float closeBaubleCenterXInScreen = (f - ((float) chatHeadCloseTargetView.getCloseBaubleCenterXInScreen())) * 0.1f;
        float max = Math.max((float) (-chatHeadCloseTargetView.f5782s), (f2 - chatHeadCloseTargetView.getCloseBaubleCenterYInScreen$133adb()) * 0.1f);
        chatHeadCloseTargetView.f5771h.b((double) closeBaubleCenterXInScreen).c = false;
        chatHeadCloseTargetView.f5772i.b((double) max).c = false;
        double d = chatHeadCloseTargetView.m6008b(f, f2) ? 1.0d : 0.7d;
        if (chatHeadCloseTargetView.f5766a && chatHeadCloseTargetView.m6008b(f, f2)) {
            chatHeadCloseTargetView.f5770g.setVisibility(0);
        } else {
            chatHeadCloseTargetView.f5770g.setVisibility(8);
        }
        if (chatHeadCloseTargetView.f5765C) {
            Spring spring = chatHeadCloseTargetView.f5773j;
            spring.c = false;
            spring.b(d);
        } else {
            chatHeadCloseTargetView.f5773j.a(d).l();
        }
        if (chatHeadCloseTargetView.f5765C) {
            chatHeadCloseTargetView.f5774k.c = false;
        }
        chatHeadCloseTargetView.f5774k.b(1.0d);
    }

    public final boolean m6008b(float f, float f2) {
        int closeBaubleCenterXInScreen = getCloseBaubleCenterXInScreen();
        return closeBaubleCenterXInScreen != 0 && Math.abs(f - ((float) closeBaubleCenterXInScreen)) < ((float) (this.f5777n / 2)) && f2 - ((float) (getHeight() - this.f5778o)) >= 0.0f;
    }

    public final boolean m6006a(float f, float f2, float f3, float f4) {
        if (f4 > 0.0f && Math.abs(((((((float) getResources().getDisplayMetrics().heightPixels) - f2) / f4) * f3) + f) - ((float) getCloseBaubleCenterXInScreen())) < ((float) (this.f5779p / 2))) {
            return true;
        }
        return false;
    }

    public float getRestingCloseBaubleCenterYInScreen() {
        return getCloseBaubleCenterYInScreen$133adb();
    }

    private int getCloseBaubleCenterXInScreen() {
        return getWidth() / 2;
    }

    private float getCloseBaubleCenterYInScreen$133adb() {
        return (float) ((getHeight() + this.f5775l) - (this.f5768e.getHeight() / 2));
    }

    private void m5995e() {
        if (this.f5763A != null) {
            this.f5763A.cancel(false);
            this.f5763A = null;
        }
    }

    private void m5997f() {
        this.f5771h.a(this.f5771h.i);
        this.f5772i.a(this.f5772i.i);
        this.f5773j.a(this.f5773j.i);
        this.f5774k.a(this.f5774k.i);
        m5995e();
    }

    public static void setBaubleX(ChatHeadCloseTargetView chatHeadCloseTargetView, float f) {
        chatHeadCloseTargetView.f5768e.setTranslationX(f);
    }

    public static void setBaubleY(ChatHeadCloseTargetView chatHeadCloseTargetView, float f) {
        chatHeadCloseTargetView.f5768e.setTranslationY(f);
    }

    public static boolean m5999g(ChatHeadCloseTargetView chatHeadCloseTargetView) {
        return chatHeadCloseTargetView.f5771h.k() && chatHeadCloseTargetView.f5772i.k() && chatHeadCloseTargetView.f5773j.k() && chatHeadCloseTargetView.f5774k.k();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            m6000h();
        }
    }

    private void m6000h() {
        if (this.f5765C) {
            this.f5767d.setAlpha((float) this.f5774k.d());
            return;
        }
        this.f5767d.setTranslationY((float) ((int) ((1.0d - this.f5774k.d()) * ((double) this.f5767d.getHeight()))));
    }
}
