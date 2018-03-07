package com.facebook.privacy.selector;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.facebook.common.util.StringUtil;
import com.facebook.privacy.model.PrivacyToken;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: fb4a_permalink */
public class DefaultPrivacyOptionRowView extends CustomRelativeLayout {
    private PrivacyToken f15237a;
    private boolean f15238b;
    private ToggleButton f15239c;
    private ImageView f15240d;
    private TextView f15241e;
    private TextView f15242f;

    public DefaultPrivacyOptionRowView(Context context) {
        super(context);
        m22902a();
    }

    public DefaultPrivacyOptionRowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22902a();
    }

    private void m22902a() {
        setContentView(2130903878);
        this.f15239c = (ToggleButton) a(2131560950);
        this.f15240d = (ImageView) a(2131560951);
        this.f15241e = (TextView) a(2131560953);
        this.f15242f = (TextView) a(2131560954);
        m22903b();
    }

    public PrivacyToken getPrivacyToken() {
        return this.f15237a;
    }

    public boolean getIsSelected() {
        return this.f15238b;
    }

    private void m22903b() {
        this.f15239c.setChecked(this.f15238b);
        if (this.f15237a != null) {
            this.f15240d.setImageResource(this.f15237a.mo1190h());
            this.f15241e.setText(this.f15237a.mo1185b());
            if (StringUtil.a(this.f15237a.mo1192l())) {
                this.f15242f.setVisibility(8);
            } else {
                this.f15242f.setVisibility(0);
            }
            this.f15242f.setText(this.f15237a.mo1192l());
        }
    }
}
