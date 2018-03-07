package com.facebook.common.banner;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.widget.AdvancedVerticalLinearLayout.LayoutParams;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Optional;

/* compiled from: place_rating */
public class BasicBannerNotificationView extends CustomFrameLayout {
    private final TextView f7708a;
    private final TextView f7709b;
    private final Optional<ProgressBar> f7710c;
    private final Optional<LinearLayout> f7711d;

    /* compiled from: place_rating */
    public class Params {
        public final CharSequence f7699a;
        public final boolean f7700b;
        public final ColorDrawable f7701c;
        public final Drawable f7702d;
        public final boolean f7703e;
        public final CharSequence f7704f;
        public final int f7705g;
        public final Drawable f7706h;
        public final DisplayMode f7707i;

        public Params(Builder builder) {
            this.f7699a = builder.a;
            this.f7700b = builder.b;
            this.f7702d = builder.c;
            this.f7703e = builder.d;
            this.f7704f = builder.e;
            this.f7705g = builder.f;
            this.f7706h = builder.g;
            this.f7707i = builder.h;
            this.f7701c = builder.i;
        }
    }

    public BasicBannerNotificationView(Context context) {
        this(context, null);
    }

    public BasicBannerNotificationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BasicBannerNotificationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905473);
        this.f7708a = (TextView) c(2131564262);
        this.f7709b = (TextView) c(2131564263);
        this.f7710c = d(2131559554);
        this.f7711d = d(2131564261);
    }

    private void m11021a() {
        this.f7709b.setVisibility(0);
        this.f7708a.setGravity(19);
        if (this.f7711d.isPresent()) {
            ((LinearLayout) this.f7711d.get()).setGravity(19);
        }
    }

    private void m11022b() {
        this.f7709b.setVisibility(8);
        this.f7708a.setGravity(17);
        if (this.f7711d.isPresent()) {
            ((LinearLayout) this.f7711d.get()).setGravity(17);
        }
    }

    public void setParams(Params params) {
        boolean z = false;
        this.f7708a.setText(params.f7699a);
        if (params.f7701c != null) {
            this.f7708a.setTextColor(params.f7701c.getColor());
        }
        setBackgroundDrawable(params.f7702d);
        if (params.f7703e) {
            m11021a();
            this.f7709b.setText(params.f7704f);
            if (params.f7705g != 0) {
                this.f7709b.setTextColor(params.f7705g);
            }
            if (params.f7706h != null) {
                this.f7709b.setBackgroundDrawable(params.f7706h);
            }
        } else {
            m11022b();
        }
        if (this.f7710c.isPresent()) {
            if (params.f7700b) {
                ((ProgressBar) this.f7710c.get()).setVisibility(0);
            } else {
                ((ProgressBar) this.f7710c.get()).setVisibility(8);
            }
        }
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        if (params.f7707i == DisplayMode.ONLY_WHEN_SPACE_AVAILABLE) {
            z = true;
        }
        layoutParams.a = z;
        requestLayout();
    }

    public void setOnBannerButtonClickListener(OnClickListener onClickListener) {
        this.f7709b.setOnClickListener(onClickListener);
    }
}
