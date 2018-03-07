package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.text.Spanned;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: User triggered crash from Intern settings */
public class AdInterfacesReceiptView extends CustomLinearLayout {
    private BetterTextView f22890a;
    private BetterTextView f22891b;

    public AdInterfacesReceiptView(Context context) {
        super(context);
        m24853a();
    }

    public AdInterfacesReceiptView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24853a();
    }

    protected AdInterfacesReceiptView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24853a();
    }

    private void m24853a() {
        setContentView(2130903138);
        setOrientation(1);
        this.f22890a = (BetterTextView) a(2131559324);
        this.f22891b = (BetterTextView) a(2131559286);
    }

    public void setBudgetSummaryText(String str) {
        this.f22890a.setText(str);
    }

    public void setLegalDisclaimerText(Spanned spanned) {
        this.f22891b.setText(spanned);
    }

    public void setLegalDisclaimerMovementMethod(MovementMethod movementMethod) {
        this.f22891b.setMovementMethod(movementMethod);
    }
}
