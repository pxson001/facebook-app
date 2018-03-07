package com.facebook.messaging.contacts.picker;

import android.content.Context;
import android.support.v7.internal.widget.ViewStubCompat;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.touch.TouchDelegateUtils;

/* compiled from: tap_moment_button */
public class ContactPickerSectionUpsellView extends CustomRelativeLayout {
    private final BetterTextView f1992a;
    public final BetterTextView f1993b;
    private final Button f1994c;
    public final ImageView f1995d;
    private final ViewStubHolder<LinearLayout> f1996e;

    /* compiled from: tap_moment_button */
    public class C03361 {
        final /* synthetic */ ContactPickerSectionUpsellView f1991a;

        C03361(ContactPickerSectionUpsellView contactPickerSectionUpsellView) {
            this.f1991a = contactPickerSectionUpsellView;
        }

        public final void m1825a() {
            this.f1991a.setTouchDelegate(TouchDelegateUtils.a(this.f1991a.f1995d, this.f1991a, 15));
        }
    }

    public ContactPickerSectionUpsellView(Context context) {
        this(context, null, 0);
    }

    public ContactPickerSectionUpsellView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContactPickerSectionUpsellView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905670);
        this.f1992a = (BetterTextView) a(2131564793);
        this.f1993b = (BetterTextView) a(2131564794);
        this.f1994c = (Button) a(2131564795);
        this.f1995d = (ImageView) a(2131564792);
        this.f1996e = ViewStubHolder.a((ViewStubCompat) a(2131564199));
        this.h = new C03361(this);
    }

    public void setNegativeButtonContentDescription(String str) {
        this.f1995d.setContentDescription(str);
    }

    public void setTitle(String str) {
        this.f1992a.setText(str);
    }

    public BetterTextView getTextView() {
        return this.f1993b;
    }

    public void setText(String str) {
        this.f1993b.setText(str);
    }

    public void setTextContentDescription(String str) {
        this.f1993b.setContentDescription(str);
    }

    public void setPositiveButtonText(String str) {
        this.f1994c.setText(str);
    }

    public void setPositiveButtonOnClickListener(OnClickListener onClickListener) {
        this.f1994c.setOnClickListener(onClickListener);
    }

    public void setNegativeButtonOnClickListener(OnClickListener onClickListener) {
        this.f1995d.setOnClickListener(onClickListener);
    }

    public final void m1827a(boolean z) {
        if (z) {
            this.f1994c.setVisibility(8);
            this.f1996e.f();
            return;
        }
        this.f1994c.setVisibility(0);
        this.f1996e.e();
    }
}
