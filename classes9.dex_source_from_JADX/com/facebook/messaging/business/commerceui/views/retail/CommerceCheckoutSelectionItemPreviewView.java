package com.facebook.messaging.business.commerceui.views.retail;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.FlowLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: null params bundle received */
public class CommerceCheckoutSelectionItemPreviewView extends CustomLinearLayout {
    public FbDraweeView f8472a;
    public BetterTextView f8473b;
    public FlowLayout f8474c;
    public BetterTextView f8475d;

    public CommerceCheckoutSelectionItemPreviewView(Context context) {
        this(context, null, 0);
    }

    private CommerceCheckoutSelectionItemPreviewView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905624);
        this.f8472a = (FbDraweeView) a(2131564657);
        this.f8473b = (BetterTextView) a(2131564659);
        this.f8474c = (FlowLayout) a(2131564660);
        this.f8475d = (BetterTextView) a(2131564661);
        setOrientation(1);
    }
}
