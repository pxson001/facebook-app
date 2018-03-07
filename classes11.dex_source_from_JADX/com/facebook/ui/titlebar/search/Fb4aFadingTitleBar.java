package com.facebook.ui.titlebar.search;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.util.ContextUtils;
import com.facebook.ui.titlebar.Fb4aTitleBar.TitleBarState;
import com.facebook.widget.text.BetterEditTextView;
import com.facebook.widget.titlebar.FadingFbTitleBar;

/* compiled from: nearbyTiles */
public class Fb4aFadingTitleBar extends Fb4aSearchTitleBar implements FadingFbTitleBar {
    private boolean f5161r;
    private final Drawable f5162s;

    public Fb4aFadingTitleBar(Context context) {
        this(context, null);
    }

    public Fb4aFadingTitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Fb4aFadingTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5161r = false;
        this.f5162s = getResources().getDrawable(2130840943);
    }

    public View getSearchEditText() {
        return this.q == null ? null : this.q.e;
    }

    public void setTitle(String str) {
        if (this.i != TitleBarState.SEARCH_TITLES_APP || this.q == null || this.q.e == null || !this.q.b()) {
            super.setTitle(str);
            return;
        }
        this.q.e.setText(str);
        this.q.a();
    }

    public void setTitleHint(String str) {
        if (this.i == TitleBarState.SEARCH_TITLES_APP && this.q != null && this.q.e != null) {
            BetterEditTextView betterEditTextView = this.q.e;
            betterEditTextView.a();
            betterEditTextView.setHint(str);
            betterEditTextView.setEllipsize(TruncateAt.END);
        }
    }

    public void setFadingModeEnabled(boolean z) {
        this.f5161r = z;
        if (this.f5161r) {
            m6418a(0.0f);
        }
    }

    public int getActualHeight() {
        return getHeight();
    }

    public final void m6418a(float f) {
        if (f == 1.0f) {
            m6417k();
            setBackgroundDrawable(new ColorDrawable(ContextUtils.c(getContext(), 2130772517, 0)));
            setClickable(true);
            return;
        }
        setClickable(false);
        m6414c(f);
        b(f);
        m6415d(f);
    }

    private void m6414c(float f) {
        float f2 = 0.0f;
        if (f > 0.5f) {
            f2 = (f % 0.5f) / 0.5f;
        }
        this.e.setAlpha(f2);
    }

    private void m6415d(float f) {
        if (f < 0.2f) {
            this.f5162s.setAlpha(255);
            setBackgroundDrawable(this.f5162s);
        } else if (f < 0.2f || f >= 0.5f) {
            setBackgroundDrawable(new ColorDrawable(0));
        } else {
            this.f5162s.setAlpha((int) (255.0f * (1.0f - ((f - 0.2f) / 0.3f))));
            setBackgroundDrawable(this.f5162s);
        }
    }

    private void m6417k() {
        m6416e(1.0f);
    }

    private void m6416e(float f) {
        if (f == 1.0f) {
            setBackgroundColor(ContextUtils.c(getContext(), 2130772517, 0));
        } else {
            setBackgroundColor(0);
        }
        this.e.setAlpha(f);
    }

    private static void m6413a(View view, float f) {
        view.setAlpha(f);
    }
}
