package com.facebook.payments.contactinfo.form;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.contactinfo.form.ContactInfoFormFragment.C21651;
import com.facebook.payments.contactinfo.model.ContactInfoFormInput;
import com.facebook.payments.contactinfo.model.EmailContactInfoFormInput;
import com.facebook.payments.contactinfo.model.EmailContactInfoFormInputBuilder;
import com.facebook.payments.paymentmethods.cardform.PaymentFormEditTextView;
import com.facebook.widget.SwitchCompat;
import javax.inject.Inject;

/* compiled from: button_name */
public class ContactInfoFormInputControllerFragment extends FbFragment {
    @Inject
    public SimpleContactInfoFormManager f18665a;
    private ContactInfoCommonFormParams f18666b;
    public C21651 f18667c;
    public PaymentFormEditTextView f18668d;

    /* compiled from: button_name */
    public class C21711 implements OnEditorActionListener {
        final /* synthetic */ ContactInfoFormInputControllerFragment f18664a;

        public C21711(ContactInfoFormInputControllerFragment contactInfoFormInputControllerFragment) {
            this.f18664a = contactInfoFormInputControllerFragment;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 6) {
                return this.f18664a.m18678b();
            }
            return false;
        }
    }

    public static void m18677a(Object obj, Context context) {
        ((ContactInfoFormInputControllerFragment) obj).f18665a = SimpleContactInfoFormManager.m18690a(FbInjector.get(context));
    }

    public final void m18679c(Bundle bundle) {
        super.c(bundle);
        Class cls = ContactInfoFormInputControllerFragment.class;
        m18677a(this, getContext());
    }

    public final void m18680d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 861110180);
        super.d(bundle);
        this.f18666b = (ContactInfoCommonFormParams) this.s.getParcelable("extra_contact_info_form_params");
        this.f18668d.setOnEditorActionListener(new C21711(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -310792474, a);
    }

    public final boolean m18678b() {
        boolean isChecked;
        C21651 c21651 = this.f18667c;
        SimpleContactInfoFormMutator a = c21651.f18649a.f18656a.m18692a(c21651.f18649a.f18661f.f18641a);
        ContactInfoCommonFormParams contactInfoCommonFormParams = c21651.f18649a.f18661f;
        ContactInfoFormFragment contactInfoFormFragment = c21651.f18649a;
        EmailContactInfoFormInputBuilder emailContactInfoFormInputBuilder = new EmailContactInfoFormInputBuilder();
        emailContactInfoFormInputBuilder.f18685a = contactInfoFormFragment.f18659d.getInputText();
        emailContactInfoFormInputBuilder = emailContactInfoFormInputBuilder;
        if (contactInfoFormFragment.f18660e != null) {
            isChecked = ((SwitchCompat) contactInfoFormFragment.e(2131565822)).isChecked();
        } else {
            isChecked = false;
        }
        emailContactInfoFormInputBuilder.f18686b = isChecked;
        a.mo734a(contactInfoCommonFormParams, (ContactInfoFormInput) new EmailContactInfoFormInput(emailContactInfoFormInputBuilder));
        return true;
    }
}
