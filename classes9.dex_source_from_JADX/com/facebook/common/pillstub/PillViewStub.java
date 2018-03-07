package com.facebook.common.pillstub;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.common.appchoreographer.AppChoreographer.Priority;
import com.facebook.common.appchoreographer.AppChoreographer.ThreadType;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.orca.threadview.UnreadMessagesPillController;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: pstn_call */
public class PillViewStub extends View {
    public static final SpringConfig f5993a = SpringConfig.a(40.0d, 7.0d);
    @Inject
    public DefaultAppChoreographer f5994b;
    @Inject
    public Lazy<SpringSystem> f5995c;
    private Spring f5996d;
    public boolean f5997e = false;
    private int f5998f;
    public View f5999g;
    @Nullable
    private TextView f6000h;
    public UnreadMessagesPillController f6001i;

    /* compiled from: pstn_call */
    class C06261 implements Runnable {
        final /* synthetic */ PillViewStub f5990a;

        C06261(PillViewStub pillViewStub) {
            this.f5990a = pillViewStub;
        }

        public void run() {
            this.f5990a.m6323b();
        }
    }

    /* compiled from: pstn_call */
    class C06272 implements OnClickListener {
        final /* synthetic */ PillViewStub f5991a;

        C06272(PillViewStub pillViewStub) {
            this.f5991a = pillViewStub;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1726372429);
            UnreadMessagesPillController unreadMessagesPillController = this.f5991a.f6001i;
            unreadMessagesPillController.c.b(unreadMessagesPillController.e);
            this.f5991a.m6324c();
            Logger.a(2, EntryType.UI_INPUT_END, -1316039724, a);
        }
    }

    /* compiled from: pstn_call */
    class C06283 extends SimpleSpringListener {
        final /* synthetic */ PillViewStub f5992a;

        C06283(PillViewStub pillViewStub) {
            this.f5992a = pillViewStub;
        }

        public final void m6314a(Spring spring) {
            UnreadMessagesPillController unreadMessagesPillController = this.f5992a.f6001i;
            View view = this.f5992a.f5999g;
            double d = spring.d();
            int height = view.getHeight();
            if (height == 0) {
                view.setVisibility(4);
                return;
            }
            view.setTranslationY((float) (((double) (height * 2)) * (d - 1.0d)));
            view.setVisibility(0);
        }
    }

    private static <T extends View> void m6317a(Class<T> cls, T t) {
        m6318a((Object) t, t.getContext());
    }

    private static void m6318a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PillViewStub pillViewStub = (PillViewStub) obj;
        DefaultAppChoreographer a = DefaultAppChoreographer.a(fbInjector);
        Lazy a2 = IdBasedLazy.a(fbInjector, 3433);
        pillViewStub.f5994b = a;
        pillViewStub.f5995c = a2;
    }

    public PillViewStub(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        m6316a(attributeSet, 0, 0);
    }

    public PillViewStub(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0);
        m6316a(attributeSet, i, 0);
    }

    public PillViewStub(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m6316a(attributeSet, i, i2);
    }

    private void m6316a(@Nullable AttributeSet attributeSet, int i, int i2) {
        m6317a(PillViewStub.class, (View) this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.PillViewStub, i, i2);
            this.f5998f = obtainStyledAttributes.getResourceId(0, 0);
            obtainStyledAttributes.recycle();
        }
    }

    public void setLayoutResource(int i) {
        this.f5998f = i;
    }

    public final void m6322a() {
        this.f5994b.a("Delay showing pill", new C06261(this), Priority.APPLICATION_LOADED_UI_IDLE_HIGH_PRIORITY, ThreadType.UI);
    }

    public void setPillText(CharSequence charSequence) {
        m6320f();
        if (this.f6000h == null) {
            throw new IllegalStateException("Pill layout must have a TextView with id 'pill_text'");
        }
        this.f6000h.setText(charSequence);
    }

    public final void m6323b() {
        m6320f();
        if (this.f6001i.a()) {
            this.f6001i.b();
            this.f5996d.b(1.0d);
            this.f5997e = true;
        }
    }

    public final void m6324c() {
        if (this.f5996d != null) {
            this.f5996d.b(0.0d);
            this.f5997e = false;
        }
    }

    public final void m6325d() {
        if (this.f5996d != null) {
            this.f5996d.a(0.0d);
            this.f5997e = false;
        }
    }

    public final boolean m6326e() {
        return this.f5997e;
    }

    private void m6320f() {
        if (this.f6001i == null) {
            throw new IllegalStateException("You must attach a controller before showing the pill");
        } else if (this.f5999g == null) {
            m6321g();
            this.f5999g.setOnClickListener(new C06272(this));
            this.f6000h = (TextView) this.f5999g.findViewById(2131558412);
            Spring a = ((SpringSystem) this.f5995c.get()).a();
            UnreadMessagesPillController unreadMessagesPillController = this.f6001i;
            this.f5996d = a.a(f5993a);
            this.f5996d.a(new C06283(this));
            this.f5996d.a(0.0d);
            this.f5997e = false;
        }
    }

    private void m6321g() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("PillViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f5998f != 0) {
            ViewGroup viewGroup = (ViewGroup) parent;
            this.f5999g = LayoutInflater.from(getContext()).inflate(this.f5998f, viewGroup, false);
            this.f5999g.setId(getId());
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(this.f5999g, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(this.f5999g, indexOfChild);
            }
        } else {
            throw new IllegalArgumentException("PillViewStub must have a valid layoutResource");
        }
    }
}
