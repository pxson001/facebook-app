package com.facebook.friendsnearby.pingdialog.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: [[easier_to_find]] */
public class LocationPingOptionView extends CustomRelativeLayout implements Checkable {
    private final TextView f20661a;
    private final ImageView f20662b;
    private boolean f20663c;

    public LocationPingOptionView(Context context) {
        this(context, null);
    }

    public LocationPingOptionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LocationPingOptionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905124);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131434239);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.f20661a = (TextView) a(2131563554);
        this.f20662b = (ImageView) a(2131563555);
    }

    public boolean isChecked() {
        return this.f20663c;
    }

    public void setChecked(boolean z) {
        this.f20663c = z;
        this.f20662b.setVisibility(this.f20663c ? 0 : 8);
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    public void setPingOption(LocationPingOption locationPingOption) {
        this.f20661a.setText(locationPingOption.f20659c);
    }
}
