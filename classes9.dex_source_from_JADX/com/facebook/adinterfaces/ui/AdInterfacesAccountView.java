package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: VT */
public class AdInterfacesAccountView extends CustomLinearLayout {
    public AdInterfacesSpinnerView f22474a;

    public AdInterfacesAccountView(Context context) {
        this(context, null);
    }

    public AdInterfacesAccountView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdInterfacesAccountView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24333a();
    }

    private void m24333a() {
        setContentView(2130903097);
        setOrientation(1);
        this.f22474a = (AdInterfacesSpinnerView) a(2131559246);
    }

    public AdInterfacesSpinnerView getSpinnerView() {
        return this.f22474a;
    }
}
