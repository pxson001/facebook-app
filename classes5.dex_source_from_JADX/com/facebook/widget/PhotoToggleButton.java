package com.facebook.widget;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import com.facebook.R;
import com.facebook.inject.FbInjector;
import com.facebook.ui.animations.BounceAnimationCreator;
import com.facebook.ui.animations.ViewAnimator$Listener;
import com.facebook.ui.animations.ViewAnimator$SimpleListener;
import com.facebook.ui.animations.ViewHelperViewAnimator;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;

/* compiled from: com.google.android.gms.common.internal.IResolveAccountCallbacks */
public class PhotoToggleButton extends PhotoButton implements Checkable {
    private int f5688a = 0;
    private int f5689b = 0;
    private int f5690c = 0;
    private int f5691d = 0;
    public OnCheckedChangeListener f5692e;
    public ViewHelperViewAnimator f5693f;
    public ViewAnimator$Listener f5694g;
    public ViewAnimator$Listener f5695h;
    public ObjectAnimator f5696i;
    public boolean f5697j;
    private boolean f5698k;
    public boolean f5699l;
    private ViewTransform f5700m;
    public boolean f5701n = false;
    public boolean f5702o = false;

    /* compiled from: com.google.android.gms.common.internal.IResolveAccountCallbacks */
    public class C05231 extends ViewAnimator$SimpleListener {
        final /* synthetic */ PhotoToggleButton f5686a;

        public C05231(PhotoToggleButton photoToggleButton) {
            this.f5686a = photoToggleButton;
        }

        public final void mo626b() {
            this.f5686a.f5693f.m10282a(null);
            this.f5686a.f5702o = true;
            if (!this.f5686a.f5697j) {
                this.f5686a.f5696i;
            }
        }
    }

    /* compiled from: com.google.android.gms.common.internal.IResolveAccountCallbacks */
    public class C05242 extends ViewAnimator$SimpleListener {
        final /* synthetic */ PhotoToggleButton f5687a;

        public C05242(PhotoToggleButton photoToggleButton) {
            this.f5687a = photoToggleButton;
        }

        public final void mo626b() {
            this.f5687a.f5693f.m10282a(null);
            if (this.f5687a.f5701n && this.f5687a.f5699l) {
                this.f5687a.f5696i.start();
                this.f5687a.f5699l = false;
            }
        }
    }

    /* compiled from: com.google.android.gms.common.internal.IResolveAccountCallbacks */
    public interface OnCheckedChangeListener {
        void m10477a(boolean z);
    }

    public PhotoToggleButton(Context context) {
        super(context);
        m10479a(null);
    }

    public PhotoToggleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10479a(attributeSet);
    }

    public PhotoToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10479a(attributeSet);
    }

    private final void m10479a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.PhotoToggleButton);
            this.f5688a = obtainStyledAttributes.getResourceId(0, this.f5688a);
            this.f5689b = obtainStyledAttributes.getResourceId(1, this.f5689b);
            this.f5701n = obtainStyledAttributes.getBoolean(4, this.f5701n);
            this.f5690c = obtainStyledAttributes.getResourceId(2, this.f5690c);
            this.f5691d = obtainStyledAttributes.getResourceId(3, this.f5691d);
            obtainStyledAttributes.recycle();
        }
        this.f5700m = new ViewTransform(this);
        setChecked(false);
        this.f5696i = BounceAnimationCreator.m10254a(this);
    }

    private void m10484d() {
        if (this.f5693f == null) {
            ViewHelperViewAnimator a = ViewHelperViewAnimatorFactory.m10293a(FbInjector.get(getContext())).m10294a((View) this);
            this.f5694g = new C05231(this);
            this.f5695h = new C05242(this);
            this.f5693f = a;
        }
    }

    protected final void mo628a() {
        m10486e();
        this.f5697j = true;
    }

    protected final void mo629b() {
        if (this.f5702o) {
            this.f5696i;
        }
        this.f5697j = false;
    }

    protected final void mo630c() {
        toggle();
        m10490h();
    }

    @TargetApi(16)
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.f5693f != null) {
            this.f5693f.m10282a(null);
            this.f5696i.cancel();
            this.f5693f.m10279a(1.0f);
            this.f5693f.m10284c(1.0f);
            this.f5702o = false;
        }
        if (VERSION.SDK_INT >= 16) {
            setHasTransientState(false);
        }
    }

    private void m10486e() {
        m10484d();
        this.f5693f.m10278a();
        this.f5693f.m10282a(this.f5694g);
        this.f5693f.m10281a(120);
        this.f5693f.m10283b(0.75f);
        this.f5693f.m10285d(0.75f);
    }

    public static void m10489f(PhotoToggleButton photoToggleButton) {
        photoToggleButton.f5702o = false;
        photoToggleButton.m10484d();
        photoToggleButton.f5693f.m10282a(photoToggleButton.f5695h);
        photoToggleButton.f5693f.m10281a(100);
        photoToggleButton.f5693f.m10283b(1.0f);
        photoToggleButton.f5693f.m10285d(1.0f);
    }

    public void setChecked(boolean z) {
        CharSequence charSequence = null;
        if (z) {
            setImageResource(this.f5689b);
            if (this.f5691d != 0) {
                charSequence = getContext().getString(this.f5691d);
            }
            setContentDescription(charSequence);
        } else {
            setImageResource(this.f5688a);
            if (this.f5690c != 0) {
                charSequence = getContext().getString(this.f5690c);
            }
            setContentDescription(charSequence);
        }
        this.f5698k = z;
        this.f5699l = z;
    }

    public boolean isChecked() {
        return this.f5698k;
    }

    public void toggle() {
        setChecked(!this.f5698k);
    }

    public void setCheckedImageResId(int i) {
        this.f5689b = i;
    }

    public void setUncheckedImageResId(int i) {
        this.f5688a = i;
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f5692e = onCheckedChangeListener;
    }

    private void m10490h() {
        if (this.f5692e != null) {
            this.f5692e.m10477a(isChecked());
        }
    }
}
