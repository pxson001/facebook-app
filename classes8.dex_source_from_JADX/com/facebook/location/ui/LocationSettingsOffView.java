package com.facebook.location.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import javax.annotation.Nullable;

/* compiled from: dismiss_unit_tap */
public class LocationSettingsOffView extends SegmentedLinearLayout {
    private TextView f15275a;
    private Button f15276b;

    public LocationSettingsOffView(Context context) {
        super(context);
        m17709a();
    }

    public LocationSettingsOffView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m17709a();
    }

    private void m17709a() {
        setContentView(2130905134);
        setOrientation(1);
        setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131361864)));
        setSegmentedDivider(new ColorDrawable(getResources().getColor(2131361982)));
        setSegmentedDividerThickness(getResources().getDimensionPixelSize(2131427382));
        setShowSegmentedDividers(5);
        this.f15275a = (TextView) a(2131563616);
        this.f15276b = (Button) a(2131563617);
    }

    public void setDescriptionText(CharSequence charSequence) {
        this.f15275a.setText(charSequence);
    }

    public void setDescriptionText(int i) {
        this.f15275a.setText(i);
    }

    public void setButtonText(CharSequence charSequence) {
        this.f15276b.setText(charSequence);
    }

    public void setButtonText(int i) {
        this.f15276b.setText(i);
    }

    public void setButtonListener(OnClickListener onClickListener) {
        this.f15276b.setOnClickListener(onClickListener);
    }
}
