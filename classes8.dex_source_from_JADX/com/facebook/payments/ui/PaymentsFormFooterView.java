package com.facebook.payments.ui;

import android.content.Context;
import android.view.View.OnClickListener;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.SwitchCompat;

/* compiled from: structured_menu_viewer_impression */
public class PaymentsFormFooterView extends PaymentsComponentLinearLayout {
    public PaymentsSecurityInfoView f1979a = ((PaymentsSecurityInfoView) a(2131565821));
    public SwitchCompat f1980b = ((SwitchCompat) a(2131565822));
    public FbTextView f1981c = ((FbTextView) a(2131565823));
    public FbTextView f1982d = ((FbTextView) a(2131565824));
    public CallToActionSummaryView f1983e = ((CallToActionSummaryView) a(2131565825));
    public FbTextView f1984f = ((FbTextView) a(2131564858));

    public PaymentsFormFooterView(Context context) {
        super(context);
        setContentView(2130906159);
        setOrientation(1);
    }

    public void setVisibilityOfMakeDefaultSwitch(int i) {
        this.f1980b.setVisibility(i);
    }

    public void setVisibilityOfMakeDefaultButton(int i) {
        this.f1981c.setVisibility(i);
    }

    public void setVisibilityOfDefaultInfoView(int i) {
        this.f1982d.setVisibility(i);
    }

    public void setVisibilityOfDefaultActionSummary(int i) {
        this.f1983e.setVisibility(i);
    }

    public void setVisibilityOfDeleteButton(int i) {
        this.f1984f.setVisibility(i);
    }

    public void setOnClickListenerForMakeDefaultButton(OnClickListener onClickListener) {
        this.f1981c.setOnClickListener(onClickListener);
    }

    public void setOnClickListenerForDeleteButton(OnClickListener onClickListener) {
        this.f1984f.setOnClickListener(onClickListener);
    }
}
