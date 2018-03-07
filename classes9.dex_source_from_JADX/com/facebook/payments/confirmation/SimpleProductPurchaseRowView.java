package com.facebook.payments.confirmation;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.payments.ui.PaymentsComponentViewGroup;
import javax.annotation.Nullable;

/* compiled from: ca912ad3262f05715b4cf15610829f5d */
public class SimpleProductPurchaseRowView extends PaymentsComponentViewGroup {
    private TextView f18640a;

    public SimpleProductPurchaseRowView(Context context) {
        super(context);
        m18660a();
    }

    public SimpleProductPurchaseRowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18660a();
    }

    public SimpleProductPurchaseRowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18660a();
    }

    public void setMessageText(String str) {
        this.f18640a.setText(str);
    }

    private void m18660a() {
        setContentView(2130907116);
        this.f18640a = (TextView) getView(2131567473);
    }
}
