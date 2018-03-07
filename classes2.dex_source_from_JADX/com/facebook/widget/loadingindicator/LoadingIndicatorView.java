package com.facebook.widget.loadingindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.facebook.R;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.fbui.widget.layout.ImageBlockLayout.LayoutParams;
import com.facebook.inject.FbInjector;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicator.State;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: media_cache_size */
public class LoadingIndicatorView extends CustomFrameLayout implements LoadingIndicator {
    protected static final int f14580a = 2131230758;
    protected static final int f14581b = 2131230764;
    protected static final int f14582c = 2130840506;
    protected static final int f14583d = 2130840507;
    private ProgressBar f14584e;
    private ViewStub f14585f;
    private ErrorContainer f14586g;
    private View f14587h;
    private State f14588i;
    private Orientation f14589j;
    public int f14590k;
    @Nullable
    public Drawable f14591l;
    public int f14592m;
    private int f14593n;
    private int f14594o;
    private int f14595p;
    private int f14596q;
    private String f14597r;
    private String f14598s;
    private int f14599t;
    public MonotonicClock f14600u;
    private long f14601v;
    private final Handler f14602w;

    /* compiled from: media_cache_size */
    public enum Orientation {
        HORIZONTAL,
        VERTICAL
    }

    /* compiled from: media_cache_size */
    /* synthetic */ class C06303 {
        static final /* synthetic */ int[] f14729a = new int[State.values().length];

        static {
            try {
                f14729a[State.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14729a[State.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f14729a[State.LOAD_FINISHED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static <T extends View> void m20995a(Class<T> cls, T t) {
        m20996a((Object) t, t.getContext());
    }

    private static void m20996a(Object obj, Context context) {
        ((LoadingIndicatorView) obj).f14600u = AwakeTimeSinceBootClockMethodAutoProvider.m1697a(FbInjector.get(context));
    }

    private void m20993a(LoadingIndicatorState loadingIndicatorState) {
        String string;
        int defaultResourceId;
        if (loadingIndicatorState.b == null) {
            string = getResources().getString(f14580a);
        } else {
            string = loadingIndicatorState.b;
        }
        this.f14597r = string;
        if (loadingIndicatorState.c == null) {
            string = getResources().getString(f14581b);
        } else {
            string = loadingIndicatorState.c;
        }
        this.f14598s = string;
        if (loadingIndicatorState.d == 0) {
            defaultResourceId = getDefaultResourceId();
        } else {
            defaultResourceId = loadingIndicatorState.d;
        }
        this.f14590k = defaultResourceId;
    }

    @Inject
    private void m20990a(MonotonicClock monotonicClock) {
        this.f14600u = monotonicClock;
    }

    public LoadingIndicatorView(Context context) {
        this(context, null);
    }

    public LoadingIndicatorView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingIndicatorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14602w = new Handler();
        m20989a(context, attributeSet, i);
    }

    private void m20989a(Context context, @Nullable AttributeSet attributeSet, int i) {
        m20995a(LoadingIndicatorView.class, (View) this);
        setContentView(2130905114);
        this.f14584e = (ProgressBar) m16956c(2131559308);
        this.f14585f = (ViewStub) m16956c(2131563534);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LoadingIndicatorView, i, 0);
        if (obtainStyledAttributes.hasValue(6)) {
            setContentLayout(obtainStyledAttributes.getResourceId(6, 0));
        }
        if (obtainStyledAttributes.getInteger(1, 0) == 0) {
            this.f14589j = Orientation.VERTICAL;
            this.f14585f.setLayoutResource(2130905113);
        } else {
            this.f14589j = Orientation.HORIZONTAL;
            this.f14585f.setLayoutResource(2130905111);
        }
        this.f14592m = obtainStyledAttributes.getInteger(0, 0);
        this.f14590k = getDefaultResourceId();
        this.f14598s = getResources().getString(f14581b);
        this.f14593n = obtainStyledAttributes.getLayoutDimension(2, -2);
        this.f14594o = obtainStyledAttributes.getLayoutDimension(3, -2);
        this.f14595p = obtainStyledAttributes.getLayoutDimension(4, 0);
        this.f14596q = obtainStyledAttributes.getLayoutDimension(5, 0);
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(16842806, typedValue, true);
        this.f14599t = obtainStyledAttributes.getColor(7, typedValue.data);
        obtainStyledAttributes.recycle();
        m21004b();
    }

    public void setContentLayout(int i) {
        if (this.f14587h != null) {
            removeView(this.f14587h);
        }
        this.f14587h = LayoutInflater.from(getContext()).inflate(i, null);
        addView(this.f14587h);
    }

    public void setImageSize(int i) {
        this.f14592m = i;
    }

    public void setImage(int i) {
        this.f14590k = i;
    }

    public void setErrorImageDrawable(Drawable drawable) {
        this.f14591l = drawable;
    }

    public final void m20998a() {
        m20992a(State.LOADING);
        this.f14601v = this.f14600u.now();
    }

    public final void m21004b() {
        m20992a(State.LOAD_FINISHED);
    }

    public final void m21001a(LoadingIndicatorState loadingIndicatorState, RetryClickedListener retryClickedListener) {
        m20993a(loadingIndicatorState);
        m21000a(retryClickedListener, null);
    }

    public final void m21002a(String str, RetryClickedListener retryClickedListener) {
        m21003a(str, retryClickedListener, null);
    }

    public final void m21003a(String str, RetryClickedListener retryClickedListener, @Nullable Runnable runnable) {
        this.f14597r = str;
        m21000a(retryClickedListener, runnable);
    }

    public final void m21005e() {
        if (this.f14586g != null && this.f14586g.a != null) {
            this.f14586g.a.setOnClickListener(null);
        }
    }

    private int getDefaultResourceId() {
        return this.f14592m == 0 ? f14582c : f14583d;
    }

    public final void m21000a(RetryClickedListener retryClickedListener, @Nullable Runnable runnable) {
        long now;
        if (this.f14601v > 0) {
            now = this.f14600u.now() - this.f14601v;
            if (now < 500) {
                now = 500 - now;
            } else {
                now = 0;
            }
            this.f14601v = 0;
        } else {
            now = 0;
        }
        m20992a(State.LOADING);
        HandlerDetour.b(this.f14602w, new 1(this, retryClickedListener, runnable), now, -1169848024);
    }

    public final boolean m21006f() {
        return this.f14588i == State.LOADING;
    }

    public final void m20999a(int i, int i2) {
        this.f14595p = i;
        this.f14596q = i2;
        if (this.f14586g != null) {
            this.f14586g.a.setPadding(0, i, 0, i2);
        }
    }

    private void m20991a(RetryClickedListener retryClickedListener) {
        if (this.f14588i == State.LOADING) {
            m20997g();
            this.f14586g.b.setText(this.f14597r);
            this.f14586g.c.setText(this.f14598s);
            if (retryClickedListener != null) {
                this.f14586g.a.setOnClickListener(new 2(this, retryClickedListener));
                this.f14586g.c.setVisibility(0);
            } else {
                this.f14586g.c.setVisibility(8);
            }
            m20992a(State.ERROR);
        }
    }

    private void m20992a(State state) {
        int visibility;
        int i = 0;
        int i2 = 4;
        int visibility2 = this.f14584e.getVisibility();
        int visibility3 = this.f14587h != null ? this.f14587h.getVisibility() : 8;
        if (this.f14586g != null) {
            visibility = this.f14586g.a.getVisibility();
        } else {
            visibility = 8;
        }
        switch (C06303.f14729a[state.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                if (this.f14588i == State.ERROR) {
                    visibility = 4;
                    break;
                }
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                Preconditions.checkNotNull(this.f14586g, "notifyLoadingFailed() should be called before updating the state to ERROR");
                visibility = 0;
                i = 4;
                break;
            case 3:
                if (this.f14587h instanceof ViewStub) {
                    this.f14587h = ((ViewStub) this.f14587h).inflate();
                }
                visibility = 8;
                i2 = 0;
                i = 8;
                break;
            default:
                i2 = visibility3;
                i = visibility2;
                break;
        }
        this.f14584e.setVisibility(i);
        if (!(this.f14587h == null || (this.f14587h instanceof ViewStub))) {
            this.f14587h.setVisibility(i2);
        }
        if (this.f14586g != null) {
            this.f14586g.a.setVisibility(visibility);
        }
        this.f14588i = state;
    }

    private void m20997g() {
        if (this.f14586g == null) {
            this.f14586g = new ErrorContainer(this.f14585f.inflate());
            this.f14586g.b.setGravity(this.f14589j == Orientation.HORIZONTAL ? 0 : 17);
            this.f14586g.b.setTextColor(this.f14599t);
            if (this.f14591l != null) {
                this.f14586g.d.setImageDrawable(this.f14591l);
            } else {
                this.f14586g.d.setImageResource(this.f14590k);
            }
            if (this.f14589j == Orientation.HORIZONTAL) {
                this.f14586g.d.setLayoutParams(new LayoutParams(this.f14593n, this.f14594o));
            } else {
                this.f14586g.d.setLayoutParams(new LinearLayout.LayoutParams(this.f14593n, this.f14594o));
            }
            m20999a(this.f14595p, this.f14596q);
        }
    }
}
