package com.facebook.payments.util;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: story_report */
public class PaymentsTextViewLinkHelper {
    public SecureContextHelper f2014a;
    private Resources f2015b;
    public Context f2016c;

    public static PaymentsTextViewLinkHelper m2249b(InjectorLike injectorLike) {
        return new PaymentsTextViewLinkHelper((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public PaymentsTextViewLinkHelper(SecureContextHelper secureContextHelper, Resources resources, Context context) {
        this.f2014a = secureContextHelper;
        this.f2015b = resources;
        this.f2016c = context;
    }

    public final void m2250a(int i, String str, String str2, TextView textView, final String str3) {
        final int color = this.f2015b.getColor(2131363624);
        C02321 c02321 = new ClickableSpan(this) {
            final /* synthetic */ PaymentsTextViewLinkHelper f2013c;

            public void onClick(View view) {
                PaymentsTextViewLinkHelper paymentsTextViewLinkHelper = this.f2013c;
                String str = str3;
                Context context = this.f2013c.f2016c;
                paymentsTextViewLinkHelper.f2014a.b(new Intent("android.intent.action.VIEW").setData(Uri.parse(str).buildUpon().build()), context);
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(color);
            }
        };
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(this.f2015b);
        styledStringBuilder.a(i);
        styledStringBuilder.a(str, str2, c02321, 33);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(styledStringBuilder.b());
    }
}
