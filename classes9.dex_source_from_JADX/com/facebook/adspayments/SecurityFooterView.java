package com.facebook.adspayments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: Unable to get file for UDP Upload */
public class SecurityFooterView extends CustomLinearLayout {
    @Inject
    public SecureContextHelper f23609a;
    private final TextView f23610b = ((TextView) a(2131561717));

    /* compiled from: Unable to get file for UDP Upload */
    class C28411 extends ClickableSpan {
        final /* synthetic */ SecurityFooterView f23608a;

        C28411(SecurityFooterView securityFooterView) {
            this.f23608a = securityFooterView;
        }

        public void onClick(View view) {
            SecurityFooterView.m25603b(this.f23608a);
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(2131361916);
        }
    }

    private static <T extends View> void m25601a(Class<T> cls, T t) {
        m25602a((Object) t, t.getContext());
    }

    private static void m25602a(Object obj, Context context) {
        ((SecurityFooterView) obj).f23609a = (SecureContextHelper) DefaultSecureContextHelper.a(FbInjector.get(context));
    }

    private void m25600a(SecureContextHelper secureContextHelper) {
        this.f23609a = secureContextHelper;
    }

    public SecurityFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25601a(SecurityFooterView.class, (View) this);
        setContentView(2130907040);
    }

    public final void m25604a() {
        C28411 c28411 = new C28411(this);
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(getResources());
        styledStringBuilder.a(2131240172);
        styledStringBuilder.a("[[learn_more_link]]", getContext().getString(2131230747), c28411, 33);
        this.f23610b.setMovementMethod(LinkMovementMethod.getInstance());
        this.f23610b.setText(styledStringBuilder.b());
    }

    public static void m25603b(SecurityFooterView securityFooterView) {
        securityFooterView.f23609a.b(new Intent("android.intent.action.VIEW").setData(Uri.parse("https://m.facebook.com/payer_protection").buildUpon().build()), securityFooterView.getContext());
    }
}
