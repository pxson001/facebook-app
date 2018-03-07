package com.facebook.payments.shipping.form;

import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.inject.Assisted;
import com.facebook.payments.model.FormFieldProperty;
import com.facebook.payments.paymentmethods.cardform.PaymentFormEditTextView;
import com.facebook.payments.paymentmethods.cardform.controller.PaymentInputControllerFragment;
import com.facebook.payments.paymentmethods.cardform.controller.PaymentInputControllerFragment.Listener;
import com.facebook.payments.paymentmethods.cardform.formatting.BillingZipFormattingTextWatcher;
import com.facebook.payments.paymentmethods.cardform.validation.InputValidatorParams;
import com.facebook.payments.paymentmethods.cardform.validation.SimpleInputValidatorParams;
import com.facebook.payments.shipping.form.ShippingAddressFragment.C22306;
import com.facebook.payments.shipping.validation.SimpleShippingStateInputValidator;
import com.facebook.payments.shipping.validation.SimpleShippingZipInputValidator;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: backstage_upload_complete */
public class ShippingAddressFormController {
    public C22306 f18923a;
    public PaymentFormEditTextView f18924b;
    public PaymentFormEditTextView f18925c;
    public PaymentFormEditTextView f18926d;
    public PaymentFormEditTextView f18927e;
    public PaymentFormEditTextView f18928f;
    public PaymentFormEditTextView f18929g;
    private PaymentInputControllerFragment f18930h;
    private PaymentInputControllerFragment f18931i;
    private PaymentInputControllerFragment f18932j;
    public PaymentInputControllerFragment f18933k;
    public PaymentInputControllerFragment f18934l;
    public FragmentManager f18935m;
    public SimpleShippingStateInputValidator f18936n;
    public SimpleShippingZipInputValidator f18937o;
    public BillingZipFormattingTextWatcher f18938p;
    public FormFieldProperty f18939q;

    /* compiled from: backstage_upload_complete */
    public class C22191 implements OnEditorActionListener {
        final /* synthetic */ ShippingAddressFormController f18915a;

        public C22191(ShippingAddressFormController shippingAddressFormController) {
            this.f18915a = shippingAddressFormController;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 6) {
                return this.f18915a.m18932a();
            }
            return false;
        }
    }

    /* compiled from: backstage_upload_complete */
    public class C22202 implements TextWatcher {
        final /* synthetic */ ShippingAddressFormController f18916a;
        private boolean f18917b;

        public C22202(ShippingAddressFormController shippingAddressFormController) {
            this.f18916a = shippingAddressFormController;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (!this.f18917b) {
                this.f18917b = true;
                editable.replace(0, editable.length(), editable.toString().toUpperCase(Locale.US));
                this.f18917b = false;
                if (this.f18916a.f18936n.a(ShippingAddressFormController.m18929g(this.f18916a)) && editable.length() == this.f18916a.f18936n.mo513a()) {
                    this.f18916a.f18929g.requestFocus();
                } else if (editable.length() < this.f18916a.f18936n.mo513a()) {
                    this.f18916a.f18933k.b(false);
                } else {
                    this.f18916a.f18933k.b(true);
                }
                this.f18916a.f18923a.m18940a(this.f18916a.m18933b());
            }
        }
    }

    /* compiled from: backstage_upload_complete */
    public class C22213 implements Listener {
        final /* synthetic */ ShippingAddressFormController f18918a;

        public C22213(ShippingAddressFormController shippingAddressFormController) {
            this.f18918a = shippingAddressFormController;
        }

        public final InputValidatorParams m18925a() {
            return ShippingAddressFormController.m18929g(this.f18918a);
        }
    }

    /* compiled from: backstage_upload_complete */
    public class C22224 implements TextWatcher {
        final /* synthetic */ ShippingAddressFormController f18919a;

        public C22224(ShippingAddressFormController shippingAddressFormController) {
            this.f18919a = shippingAddressFormController;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() <= this.f18919a.f18937o.mo517a()) {
                this.f18919a.f18934l.b(false);
            }
            this.f18919a.f18923a.m18940a(this.f18919a.m18933b());
        }
    }

    /* compiled from: backstage_upload_complete */
    public class C22235 implements Listener {
        final /* synthetic */ ShippingAddressFormController f18920a;

        public C22235(ShippingAddressFormController shippingAddressFormController) {
            this.f18920a = shippingAddressFormController;
        }

        public final InputValidatorParams m18926a() {
            return new SimpleInputValidatorParams(this.f18920a.f18929g.getInputText());
        }
    }

    @Inject
    public ShippingAddressFormController(@Assisted FragmentManager fragmentManager, BillingZipFormattingTextWatcher billingZipFormattingTextWatcher) {
        this.f18935m = fragmentManager;
        this.f18938p = billingZipFormattingTextWatcher;
    }

    public final void m18930a(PaymentFormEditTextView paymentFormEditTextView, PaymentFormEditTextView paymentFormEditTextView2, PaymentFormEditTextView paymentFormEditTextView3, PaymentFormEditTextView paymentFormEditTextView4, PaymentFormEditTextView paymentFormEditTextView5, PaymentFormEditTextView paymentFormEditTextView6) {
        this.f18924b = paymentFormEditTextView;
        this.f18925c = paymentFormEditTextView2;
        this.f18926d = paymentFormEditTextView3;
        this.f18927e = paymentFormEditTextView4;
        this.f18928f = paymentFormEditTextView5;
        this.f18929g = paymentFormEditTextView6;
        m18928c();
    }

    private void m18928c() {
        boolean z;
        OnEditorActionListener c22191 = new C22191(this);
        this.f18924b.setOnEditorActionListener(c22191);
        this.f18925c.setOnEditorActionListener(c22191);
        this.f18926d.setOnEditorActionListener(c22191);
        this.f18927e.setOnEditorActionListener(c22191);
        this.f18928f.setOnEditorActionListener(c22191);
        this.f18929g.setOnEditorActionListener(c22191);
        this.f18930h = m18927a("name_input_controller_fragment_tag", this.f18924b, 2131558787);
        this.f18931i = m18927a("address1_input_controller_fragment_tag", this.f18925c, 2131558788);
        this.f18932j = m18927a("city_input_controller_fragment_tag", this.f18927e, 2131558789);
        this.f18933k = (PaymentInputControllerFragment) this.f18935m.a("state_input_controller_fragment_tag");
        if (this.f18933k == null) {
            this.f18933k = new PaymentInputControllerFragment();
            this.f18935m.a().a(this.f18933k, "state_input_controller_fragment_tag").b();
        }
        TextWatcher c22202 = new C22202(this);
        this.f18933k.a(this.f18928f, 2131558790);
        this.f18933k.c = this.f18936n;
        this.f18933k.d = c22202;
        this.f18933k.a = new C22213(this);
        this.f18934l = (PaymentInputControllerFragment) this.f18935m.a("billing_zip_input_controller_fragment_tag");
        if (this.f18934l == null) {
            this.f18934l = new PaymentInputControllerFragment();
            this.f18935m.a().a(this.f18934l, "billing_zip_input_controller_fragment_tag").b();
        }
        c22202 = new C22224(this);
        this.f18934l.a(this.f18929g, 2131558786);
        this.f18934l.b = this.f18938p;
        this.f18934l.c = this.f18937o;
        this.f18934l.d = c22202;
        this.f18934l.a = new C22235(this);
        PaymentInputControllerFragment paymentInputControllerFragment = this.f18934l;
        if (this.f18939q == FormFieldProperty.HIDDEN || this.f18939q == FormFieldProperty.OPTIONAL) {
            z = true;
        } else {
            z = false;
        }
        paymentInputControllerFragment.g = z;
    }

    public final boolean m18932a() {
        this.f18930h.ar();
        this.f18931i.ar();
        this.f18932j.ar();
        this.f18933k.ar();
        this.f18934l.ar();
        if (!m18933b()) {
            return false;
        }
        C22306 c22306 = this.f18923a;
        ShippingAddressFragment.aw(c22306.f18946a);
        c22306.f18946a.f18951c.m18957a(c22306.f18946a.aw.mo759a().f18987a).mo512a(c22306.f18946a.aD);
        if (c22306.f18946a.aw.mo759a().f18990d != null) {
            c22306.f18946a.f18951c.m18957a(c22306.f18946a.aw.mo759a().f18987a).mo510a(ShippingAddressFragment.ay(c22306.f18946a), c22306.f18946a.aw.mo759a().f18990d.mo760a(), false, false);
        } else {
            c22306.f18946a.f18951c.m18957a(c22306.f18946a.aw.mo759a().f18987a).mo509a(ShippingAddressFragment.ay(c22306.f18946a));
        }
        return true;
    }

    public final boolean m18933b() {
        return this.f18930h.as() && this.f18931i.as() && this.f18932j.as() && this.f18933k.as() && this.f18934l.as();
    }

    public final void m18931a(boolean z) {
        this.f18924b.setEnabled(z);
        this.f18925c.setEnabled(z);
        this.f18926d.setEnabled(z);
        this.f18927e.setEnabled(z);
        this.f18928f.setEnabled(z);
        this.f18929g.setEnabled(z);
    }

    private PaymentInputControllerFragment m18927a(String str, PaymentFormEditTextView paymentFormEditTextView, int i) {
        PaymentInputControllerFragment paymentInputControllerFragment = (PaymentInputControllerFragment) this.f18935m.a(str);
        if (paymentInputControllerFragment == null) {
            paymentInputControllerFragment = new PaymentInputControllerFragment();
            this.f18935m.a().a(paymentInputControllerFragment, str).b();
        }
        paymentInputControllerFragment.a(paymentFormEditTextView, i);
        paymentInputControllerFragment.d = new TextWatcher(this) {
            final /* synthetic */ ShippingAddressFormController f18922b;

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                paymentInputControllerFragment.b(false);
                this.f18922b.f18923a.m18940a(this.f18922b.m18933b());
            }
        };
        return paymentInputControllerFragment;
    }

    public static InputValidatorParams m18929g(ShippingAddressFormController shippingAddressFormController) {
        return new SimpleInputValidatorParams(shippingAddressFormController.f18928f.getInputText());
    }
}
