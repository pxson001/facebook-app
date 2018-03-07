package com.facebook.messaging.payment.method.input;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.widget.ImageView;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.inject.FbInjector;
import com.facebook.payments.ui.PaymentsComponentLinearLayout;
import com.facebook.payments.util.PaymentsTextViewLinkHelper;
import com.facebook.resources.ui.FbTextView;
import javax.inject.Inject;

/* compiled from: index  */
public class MessengerPayEditCardFormHeaderView extends PaymentsComponentLinearLayout {
    @Inject
    public PaymentsTextViewLinkHelper f13054a;
    @Inject
    public GlyphColorizer f13055b;
    public FbTextView f13056c = ((FbTextView) a(2131563855));
    public ImageBlockLayout f13057d = ((ImageBlockLayout) a(2131565797));
    public ImageView f13058e = ((ImageView) a(2131565798));
    public FbTextView f13059f = ((FbTextView) a(2131565799));

    public static void m13357a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        MessengerPayEditCardFormHeaderView messengerPayEditCardFormHeaderView = (MessengerPayEditCardFormHeaderView) obj;
        PaymentsTextViewLinkHelper b = PaymentsTextViewLinkHelper.b(fbInjector);
        GlyphColorizer a = GlyphColorizer.a(fbInjector);
        messengerPayEditCardFormHeaderView.f13054a = b;
        messengerPayEditCardFormHeaderView.f13055b = a;
    }

    public MessengerPayEditCardFormHeaderView(Context context) {
        super(context);
        Class cls = MessengerPayEditCardFormHeaderView.class;
        m13357a((Object) this, getContext());
        setContentView(2130905258);
        setOrientation(1);
        this.f13058e.setImageDrawable(this.f13055b.a(getResources().getDrawable(2130838451), getResources().getColor(2131362299)));
        this.f13054a.a(2131240315, "[[contact_us_link]]", getResources().getString(2131240316), this.f13059f, "https://m.facebook.com/help/contact/223254857690713");
    }

    public void setVisibilityOfIsPrimaryCardTextView(int i) {
        this.f13056c.setVisibility(i);
    }

    public final void m13360a(boolean z) {
        if (z) {
            m13359d();
        } else {
            m13358c();
        }
    }

    private void m13358c() {
        this.f13057d.setVisibility(8);
        this.f13056c.setEnabled(true);
        m13356a(this.f13056c, 2131363744);
    }

    private void m13359d() {
        this.f13057d.setVisibility(0);
        this.f13056c.setEnabled(false);
        m13356a(this.f13056c, 2131363745);
    }

    private void m13356a(FbTextView fbTextView, @ColorRes int i) {
        this.f13055b.a(fbTextView.getCompoundDrawables()[0], getResources().getColor(i));
    }
}
