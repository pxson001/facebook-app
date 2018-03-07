package com.facebook.payments.paymentsflow.uicomponents;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomRelativeLayout;
import javax.annotation.Nullable;

/* compiled from: ipAddr */
public class CardHeader extends CustomRelativeLayout {
    private FbTextView f12292a;

    public CardHeader(Context context) {
        this(context, null);
    }

    public CardHeader(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m19193a();
    }

    public CardHeader(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19193a();
    }

    private void m19193a() {
        setContentView(2130903502);
        this.f12292a = (FbTextView) a(2131560207);
    }

    public void setText(int i) {
        this.f12292a.setText(i);
    }
}
