package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterEditTextView;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: V2_ACTIVE_NOW */
public class AdInterfacesPhoneNumberView extends CustomLinearLayout {
    private BetterEditTextView f22851a;
    private BetterTextView f22852b;

    public AdInterfacesPhoneNumberView(Context context) {
        super(context);
        m24815a();
    }

    public AdInterfacesPhoneNumberView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m24815a();
    }

    protected AdInterfacesPhoneNumberView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24815a();
    }

    private void m24815a() {
        setContentView(2130903130);
        setOrientation(0);
        this.f22851a = (BetterEditTextView) a(2131559312);
        this.f22852b = (BetterTextView) a(2131559311);
    }

    public void setCountryCode(CharSequence charSequence) {
        this.f22852b.setText("+" + charSequence);
    }

    public BetterEditTextView getPhoneNumberEditView() {
        return this.f22851a;
    }
}
