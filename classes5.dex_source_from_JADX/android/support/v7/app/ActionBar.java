package android.support.v7.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.facebook.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: userRecoveryIntent */
public abstract class ActionBar {

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: userRecoveryIntent */
    public @interface DisplayOptions {
    }

    /* compiled from: userRecoveryIntent */
    public class LayoutParams extends MarginLayoutParams {
        public int f572a;

        public LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f572a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBarLayout);
            this.f572a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f572a = 0;
            this.f572a = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f572a = 0;
            this.f572a = layoutParams.f572a;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f572a = 0;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: userRecoveryIntent */
    public @interface NavigationMode {
    }

    /* compiled from: userRecoveryIntent */
    public abstract class Tab {
        public abstract int mo256a();

        public abstract Drawable mo257b();

        public abstract CharSequence mo258c();

        public abstract View mo259d();

        public abstract void mo260e();

        public abstract CharSequence mo261f();
    }

    public abstract View mo263a();

    public abstract void mo265a(int i);

    public abstract void mo266a(int i, int i2);

    public abstract void mo267a(View view);

    public abstract void mo268a(CharSequence charSequence);

    public abstract void mo269a(boolean z);

    public abstract int mo270b();

    public abstract void mo271b(@StringRes int i);

    public abstract void mo274c();

    public abstract void mo275c(int i);

    public abstract void mo277d();

    public Context mo280e() {
        return null;
    }

    public void mo278d(@DrawableRes int i) {
    }

    public void mo273b(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    public void mo264a(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public void mo276c(boolean z) {
    }

    public void mo279d(boolean z) {
    }

    public ActionMode mo262a(Callback callback) {
        return null;
    }

    public boolean mo283h() {
        return false;
    }

    public void mo272b(CharSequence charSequence) {
    }
}
