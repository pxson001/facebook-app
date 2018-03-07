package com.facebook.composer.ui.feedonly;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: feed_friends_locations_see_all */
public class ComposerFeedOnlyPostToggleView extends CustomLinearLayout {
    private TextView f6997a;
    private TextView f6998b;
    private CompoundButton f6999c;
    private boolean f7000d;
    private AlphaAnimation f7001e;
    private String f7002f;
    private String f7003g;

    public ComposerFeedOnlyPostToggleView(Context context) {
        super(context);
        m8290a();
    }

    public ComposerFeedOnlyPostToggleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8290a();
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f6999c.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public void setToggleChecked(boolean z) {
        if (z != this.f7000d) {
            m8291a(z);
            this.f7000d = z;
            this.f6999c.setChecked(z);
        }
    }

    public void setTitleText(String str) {
        this.f6998b.setText(str);
    }

    public final void m8292a(String str, String str2) {
        this.f7002f = str;
        this.f7003g = str2;
    }

    private void m8290a() {
        setContentView(2130903671);
        this.f6998b = (TextView) a(2131560499);
        this.f6997a = (TextView) a(2131560500);
        this.f6999c = (CompoundButton) a(2131560501);
        this.f7000d = false;
        this.f7001e = new AlphaAnimation(0.0f, 1.0f);
    }

    private void m8291a(boolean z) {
        if (this.f6997a.getVisibility() == 8) {
            this.f6997a.setVisibility(0);
            this.f6997a.startAnimation(this.f7001e);
            this.f7001e.setDuration(600);
            this.f7001e.setFillAfter(true);
        }
        this.f6997a.setText(z ? this.f7002f : this.f7003g);
    }
}
