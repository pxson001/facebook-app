package com.facebook.redspace.ui.titlebar;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.inject.FbInjector;
import com.facebook.ultralight.Inject;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: PRIVACY_CHECKUP_COMPOSER_STEP_NEXT */
public class RedSpaceUserTitleBar extends CustomFrameLayout {
    @Inject
    public RTLUtil f12501a;
    private ImageButton f12502b;
    private int f12503c;
    private BetterTextView f12504d;
    private BetterTextView f12505e;
    private RedSpaceTitleAdapter f12506f;
    private int f12507g;
    private int f12508h;
    private boolean f12509i;
    private final DataSetObserver f12510j;

    /* compiled from: PRIVACY_CHECKUP_COMPOSER_STEP_NEXT */
    class C14781 extends DataSetObserver {
        final /* synthetic */ RedSpaceUserTitleBar f12500a;

        C14781(RedSpaceUserTitleBar redSpaceUserTitleBar) {
            this.f12500a = redSpaceUserTitleBar;
        }

        public void onChanged() {
            super.onChanged();
            this.f12500a.m12910a();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: PRIVACY_CHECKUP_COMPOSER_STEP_NEXT */
    public @interface SwipeDirection {
    }

    private static <T extends View> void m12907a(Class<T> cls, T t) {
        m12908a((Object) t, t.getContext());
    }

    private static void m12908a(Object obj, Context context) {
        ((RedSpaceUserTitleBar) obj).f12501a = RTLUtil.a(FbInjector.get(context));
    }

    private void m12906a(RTLUtil rTLUtil) {
        this.f12501a = rTLUtil;
    }

    public RedSpaceUserTitleBar(Context context) {
        this(context, null);
    }

    public RedSpaceUserTitleBar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12503c = 0;
        this.f12508h = -1;
        this.f12509i = false;
        this.f12510j = new C14781(this);
        m12909b();
    }

    private void m12909b() {
        m12907a(RedSpaceUserTitleBar.class, (View) this);
        setContentView(2130906794);
        this.f12502b = (ImageButton) c(2131566896);
        this.f12504d = (BetterTextView) c(2131566897);
        this.f12505e = (BetterTextView) c(2131566898);
    }

    public void setOnBackButtonClickListener(OnClickListener onClickListener) {
        this.f12502b.setOnClickListener(onClickListener);
    }

    public void setBackButtonGlyph(@DrawableRes int i) {
        this.f12502b.setImageDrawable(this.f12501a.a(i));
    }

    public <T extends PagerAdapter & RedSpaceTitleAdapter> void setAdapter(T t) {
        if (this.f12506f != null) {
            ((PagerAdapter) this.f12506f).b(this.f12510j);
        }
        t.a(this.f12510j);
        this.f12506f = (RedSpaceTitleAdapter) t;
    }

    public final void m12910a() {
        Preconditions.checkNotNull(this.f12506f, "Adapter must be set");
        setCurrentItem(this.f12507g);
    }

    public int getCurrentItem() {
        return this.f12507g;
    }

    public void setCurrentItem(int i) {
        CharSequence e = this.f12506f.mo331e(i);
        this.f12507g = i;
        this.f12504d.setText(e);
        this.f12504d.setTranslationX(0.0f);
        this.f12505e.setAlpha(0.0f);
    }

    public final void m12911a(int i, float f, int i2) {
        if (this.f12503c == 0 || this.f12508h != i) {
            if (f < 0.5f) {
                this.f12503c = -1;
                if (i < this.f12506f.mo328b() - 1) {
                    this.f12505e.setText(this.f12506f.mo331e(i + 1));
                }
                this.f12504d.setText(this.f12506f.mo331e(i));
            } else {
                this.f12503c = 1;
                this.f12505e.setText(this.f12506f.mo331e(i + 1));
                this.f12504d.setText(this.f12506f.mo331e(i));
            }
            this.f12509i = false;
        }
        if (i2 == 0) {
            CharSequence e = this.f12506f.mo331e(i);
            this.f12505e.setText(e);
            this.f12504d.setText(e);
        }
        this.f12504d.setAlpha(Math.abs(1.0f - f));
        this.f12505e.setAlpha(f);
        switch (this.f12503c) {
            case -1:
                this.f12504d.setTranslationX((float) (-i2));
                this.f12505e.setTranslationX((float) (this.f12504d.getWidth() - i2));
                return;
            case 1:
                this.f12504d.setTranslationX((float) (-i2));
                this.f12505e.setTranslationX((float) ((-i2) + this.f12504d.getWidth()));
                return;
            default:
                return;
        }
    }

    public void setPageState(int i) {
        if (i == 0) {
            this.f12503c = 0;
        }
    }
}
