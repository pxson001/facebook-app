package com.facebook.payments.checkout.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.payments.ui.PaymentsComponentViewGroup;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: campaign_name */
public class TermsAndPoliciesCheckoutView extends PaymentsComponentViewGroup {
    private BetterTextView f18563a;

    public TermsAndPoliciesCheckoutView(Context context) {
        super(context);
        m18590a();
    }

    public TermsAndPoliciesCheckoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18590a();
    }

    public TermsAndPoliciesCheckoutView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18590a();
    }

    private void m18590a() {
        setContentView(2130907376);
        this.f18563a = (BetterTextView) getView(2131558966);
    }

    public final void m18591a(String str, final Uri uri) {
        C21501 c21501 = new ClickableSpan(this) {
            final /* synthetic */ TermsAndPoliciesCheckoutView f18562b;

            public void onClick(View view) {
                this.f18562b.a(new Intent("android.intent.action.VIEW").setData(uri));
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
                textPaint.setColor(this.f18562b.getResources().getColor(2131362112));
            }
        };
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(getResources());
        styledStringBuilder.a(str);
        styledStringBuilder.a("[[terms_and_policies]]", getResources().getString(2131240253), c21501, 33);
        this.f18563a.setMovementMethod(LinkMovementMethod.getInstance());
        this.f18563a.setText(styledStringBuilder.b());
    }
}
