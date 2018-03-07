package com.facebook.composer.minutiae.titlebar;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.common.util.ContextUtils;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivity;
import com.facebook.composer.minutiae.titlebar.RidgeButton.State;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnBackPressedListener;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.annotations.VisibleForTesting;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: there_is_no_token */
public class RidgeTitleBar extends CustomLinearLayout implements FbTitleBar {
    @VisibleForTesting
    public RidgeButton f1815a;
    public TextView f1816b;

    /* compiled from: there_is_no_token */
    public class C01871 implements Runnable {
        final /* synthetic */ RidgeTitleBar f1814a;

        public C01871(RidgeTitleBar ridgeTitleBar) {
            this.f1814a = ridgeTitleBar;
        }

        public void run() {
            Rect rect = new Rect();
            this.f1814a.f1815a.getHitRect(rect);
            int dimensionPixelSize = this.f1814a.getResources().getDimensionPixelSize(2131429647);
            rect.set(rect.left - dimensionPixelSize, rect.top - dimensionPixelSize, rect.right + dimensionPixelSize, dimensionPixelSize + rect.bottom);
            this.f1814a.setTouchDelegate(new TouchDelegate(rect, this.f1814a.f1815a));
        }
    }

    public RidgeTitleBar(Context context) {
        super(context);
        setContentView(2130905289);
        Drawable colorDrawable = new ColorDrawable(ContextUtils.c(getContext(), 2130772517, 0));
        if (VERSION.SDK_INT >= 16) {
            setBackground(colorDrawable);
        } else {
            setBackgroundDrawable(colorDrawable);
        }
        Class cls = RidgeTitleBar.class;
        FbInjector.get(getContext());
        this.f1816b = (TextView) a(2131558927);
        this.f1815a = (RidgeButton) a(2131563896);
        this.f1815a.setVisibility(0);
        post(new C01871(this));
    }

    public final void m1802a(@Nullable MinutiaeTaggableActivity minutiaeTaggableActivity) {
        if (minutiaeTaggableActivity == null || minutiaeTaggableActivity.p()) {
            setRidgeButtonVisibilityState(0);
        } else {
            setRidgeButtonVisibilityState(8);
        }
    }

    public void setRidgeButtonVisibilityState(int i) {
        this.f1815a.setVisibility(i);
    }

    public void setTitle(String str) {
        this.f1816b.setText(str);
    }

    public void setTitle(int i) {
        this.f1816b.setText(getResources().getText(i));
    }

    public final boolean m1803a() {
        return false;
    }

    public State getState() {
        return this.f1815a.f1787B;
    }

    public void setHasBackButton(boolean z) {
        throw new UnsupportedOperationException();
    }

    public void setCustomTitleView(View view) {
        throw new UnsupportedOperationException();
    }

    public final View f_(int i) {
        throw new UnsupportedOperationException();
    }

    public void setButtonSpecs(List<TitleBarButtonSpec> list) {
        throw new UnsupportedOperationException();
    }

    public void setOnToolbarButtonListener(OnToolbarButtonListener onToolbarButtonListener) {
        throw new UnsupportedOperationException();
    }

    public void setOnBackPressedListener(OnBackPressedListener onBackPressedListener) {
        throw new UnsupportedOperationException();
    }

    public void setShowDividers(boolean z) {
        throw new UnsupportedOperationException();
    }

    public void setHasFbLogo(boolean z) {
    }

    public final void m1801a(OnClickListener onClickListener) {
    }

    public void setTitlebarAsModal(OnClickListener onClickListener) {
    }
}
