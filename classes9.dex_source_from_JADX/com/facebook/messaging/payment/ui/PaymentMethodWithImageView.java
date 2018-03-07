package com.facebook.messaging.payment.ui;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.payments.ui.FloatingLabelTextView;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: facepileImageUrls */
public class PaymentMethodWithImageView extends CustomLinearLayout {
    private static final CallerContext f15136a = CallerContext.a(PaymentMethodWithImageView.class);
    private FloatingLabelTextView f15137b;
    private FbDraweeView f15138c;

    public PaymentMethodWithImageView(Context context) {
        super(context);
        m15507a();
    }

    public PaymentMethodWithImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m15507a();
    }

    protected PaymentMethodWithImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15507a();
    }

    private void m15507a() {
        setContentView(2130906146);
        setOrientation(0);
        setGravity(16);
        this.f15137b = (FloatingLabelTextView) a(2131565806);
        this.f15138c = (FbDraweeView) a(2131559119);
    }

    public void setText(CharSequence charSequence) {
        this.f15137b.setText(charSequence);
    }

    public void setHint(CharSequence charSequence) {
        this.f15137b.setHint(charSequence);
    }

    public void setImageUri(Uri uri) {
        this.f15138c.a(uri, f15136a);
    }
}
