package com.facebook.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: display_name IS NOT NULL AND LENGTH(display_name) > 0 */
public class LocationSettingRowView extends CustomLinearLayout {
    public final TextView f15244a;
    public final TextView f15245b;

    public LocationSettingRowView(Context context) {
        this(context, null);
    }

    private LocationSettingRowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private LocationSettingRowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905132);
        setOrientation(1);
        setGravity(16);
        setBackgroundResource(2130839798);
        this.f15244a = (TextView) a(2131563595);
        this.f15245b = (TextView) a(2131563596);
    }
}
