package com.facebook.payments.contactinfo.form;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.ContextUtils;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.contactinfo.model.ContactInfo;
import com.facebook.payments.contactinfo.model.EmailContactInfo;
import com.facebook.payments.contactinfo.model.PhoneNumberContactInfo;
import com.facebook.payments.paymentmethods.cardform.PaymentFormEditTextView;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentAction.Action;
import com.facebook.payments.ui.PaymentsFormFooterView;
import com.facebook.payments.ui.titlebar.PaymentsTitleBarViewStub;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnBackPressedListener;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: buyer */
public class ContactInfoFormFragment extends FbFragment {
    @Inject
    public SimpleContactInfoFormManager f18656a;
    private Context f18657b;
    private LinearLayout f18658c;
    public PaymentFormEditTextView f18659d;
    public PaymentsFormFooterView f18660e;
    public ContactInfoCommonFormParams f18661f;
    public ContactInfoFormInputControllerFragment f18662g;
    public final C21651 f18663h = new C21651(this);

    /* compiled from: buyer */
    public class C21651 {
        public final /* synthetic */ ContactInfoFormFragment f18649a;

        C21651(ContactInfoFormFragment contactInfoFormFragment) {
            this.f18649a = contactInfoFormFragment;
        }
    }

    /* compiled from: buyer */
    public class C21673 extends OnToolbarButtonListener {
        final /* synthetic */ ContactInfoFormFragment f18652a;

        public C21673(ContactInfoFormFragment contactInfoFormFragment) {
            this.f18652a = contactInfoFormFragment;
        }

        public final void m18669a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            this.f18652a.f18662g.m18678b();
        }
    }

    /* compiled from: buyer */
    class C21684 implements OnClickListener {
        final /* synthetic */ ContactInfoFormFragment f18653a;

        C21684(ContactInfoFormFragment contactInfoFormFragment) {
            this.f18653a = contactInfoFormFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2013809514);
            ContactInfoFormFragment.m18670a(this.f18653a, "make_default_mutation");
            Logger.a(2, EntryType.UI_INPUT_END, 852699686, a);
        }
    }

    /* compiled from: buyer */
    public class C21695 implements OnClickListener {
        final /* synthetic */ ContactInfoFormFragment f18654a;

        public C21695(ContactInfoFormFragment contactInfoFormFragment) {
            this.f18654a = contactInfoFormFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1414740148);
            ContactInfoFormFragment.m18670a(this.f18654a, "delete_mutation");
            Logger.a(2, EntryType.UI_INPUT_END, -1581661377, a);
        }
    }

    public static void m18672a(Object obj, Context context) {
        ((ContactInfoFormFragment) obj).f18656a = SimpleContactInfoFormManager.m18690a(FbInjector.get(context));
    }

    public final void m18676c(Bundle bundle) {
        super.c(bundle);
        this.f18657b = ContextUtils.a(getContext(), 2130772893, 2131624691);
        Class cls = ContactInfoFormFragment.class;
        m18672a((Object) this, this.f18657b);
        this.f18661f = (ContactInfoCommonFormParams) this.s.getParcelable("extra_contact_info_form_params");
        Preconditions.checkNotNull(this.f18661f);
    }

    public final View m18674a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 258179652);
        View inflate = layoutInflater.cloneInContext(this.f18657b).inflate(2130903761, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1203320624, a);
        return inflate;
    }

    public final void m18675a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f18658c = (LinearLayout) e(2131560204);
        this.f18659d = (PaymentFormEditTextView) e(2131560707);
        this.f18659d.setHint(b(2131241048));
        if (bundle == null) {
            m18673b();
        }
        this.f18662g = (ContactInfoFormInputControllerFragment) kO_().a("contact_info_form_input_controller_fragment_tag");
        if (this.f18662g == null) {
            Parcelable parcelable = this.f18661f;
            ContactInfoFormInputControllerFragment contactInfoFormInputControllerFragment = new ContactInfoFormInputControllerFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("extra_contact_info_form_params", parcelable);
            contactInfoFormInputControllerFragment.g(bundle2);
            this.f18662g = contactInfoFormInputControllerFragment;
            kO_().a().a(this.f18662g, "contact_info_form_input_controller_fragment_tag").b();
        }
        this.f18662g.f18667c = this.f18663h;
        this.f18662g.f18668d = this.f18659d;
        final Activity activity = (Activity) ContextUtils.a(getContext(), Activity.class);
        PaymentsTitleBarViewStub paymentsTitleBarViewStub = (PaymentsTitleBarViewStub) e(2131558562);
        paymentsTitleBarViewStub.a((ViewGroup) this.T, new OnBackPressedListener(this) {
            final /* synthetic */ ContactInfoFormFragment f18651b;

            public final void m18668a() {
                activity.onBackPressed();
            }
        });
        FbTitleBar fbTitleBar = paymentsTitleBarViewStub.c;
        fbTitleBar.setTitle(b(2131241047));
        Builder a = TitleBarButtonSpec.a();
        a.g = b(2131241049);
        a = a;
        a.d = true;
        fbTitleBar.setButtonSpecs(ImmutableList.of(a.a()));
        fbTitleBar.setOnToolbarButtonListener(new C21673(this));
        ar();
    }

    private void m18673b() {
        ContactInfo contactInfo = this.f18661f.f18642b;
        if (contactInfo != null) {
            m18671a(contactInfo);
        }
    }

    private void ar() {
        this.f18660e = new PaymentsFormFooterView(this.f18658c.getContext());
        PaymentsFormFooterView paymentsFormFooterView = this.f18660e;
        paymentsFormFooterView.a.setText(b(2131241050));
        paymentsFormFooterView = this.f18660e;
        int dimensionPixelSize = jW_().getDimensionPixelSize(2131433712);
        paymentsFormFooterView.a.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        paymentsFormFooterView.c.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        paymentsFormFooterView.d.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        paymentsFormFooterView.f.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        paymentsFormFooterView.b.setPadding(dimensionPixelSize, paymentsFormFooterView.b.getPaddingTop(), dimensionPixelSize, paymentsFormFooterView.b.getPaddingBottom());
        paymentsFormFooterView.e.setPadding(dimensionPixelSize, paymentsFormFooterView.e.getPaddingTop(), dimensionPixelSize, paymentsFormFooterView.e.getPaddingBottom());
        if (!(at() || au())) {
            av();
        }
        if (this.f18661f.f18642b != null) {
            PaymentsFormFooterView paymentsFormFooterView2 = this.f18660e;
            paymentsFormFooterView2.f.setText(b(2131241055));
            this.f18660e.setOnClickListenerForDeleteButton(new C21695(this));
            this.f18660e.setVisibilityOfDeleteButton(0);
        } else {
            this.f18660e.setVisibilityOfDeleteButton(8);
        }
        this.f18658c.addView(this.f18660e);
    }

    private void m18671a(ContactInfo contactInfo) {
        switch (this.f18661f.f18641a) {
            case EMAIL:
                this.f18659d.setInputText(((EmailContactInfo) contactInfo).f18681b);
                return;
            case PHONE_NUMBER:
                this.f18659d.setInputText(((PhoneNumberContactInfo) contactInfo).f18688b);
                return;
            default:
                return;
        }
    }

    private boolean at() {
        if (this.f18661f.f18642b != null || this.f18661f.f18643c <= 0) {
            this.f18660e.setVisibilityOfMakeDefaultSwitch(8);
            ay();
            return false;
        }
        PaymentsFormFooterView paymentsFormFooterView = this.f18660e;
        paymentsFormFooterView.b.setText(b(2131241051));
        this.f18660e.setVisibilityOfMakeDefaultSwitch(0);
        ax();
        return true;
    }

    private boolean au() {
        if (this.f18661f.f18642b == null || this.f18661f.f18642b.mo737b() || this.f18661f.f18643c <= 1) {
            this.f18660e.setVisibilityOfMakeDefaultButton(8);
            ay();
            return false;
        }
        PaymentsFormFooterView paymentsFormFooterView = this.f18660e;
        paymentsFormFooterView.c.setText(b(2131241052));
        this.f18660e.setOnClickListenerForMakeDefaultButton(new C21684(this));
        this.f18660e.setVisibilityOfMakeDefaultButton(0);
        ax();
        return true;
    }

    private boolean av() {
        if (this.f18661f.f18642b == null || !this.f18661f.f18642b.mo737b() || this.f18661f.f18643c <= 1) {
            this.f18660e.setVisibilityOfDefaultInfoView(8);
            ay();
            return false;
        }
        PaymentsFormFooterView paymentsFormFooterView = this.f18660e;
        paymentsFormFooterView.d.setText(b(2131241053));
        this.f18660e.setVisibilityOfDefaultInfoView(0);
        ax();
        return true;
    }

    private void ax() {
        PaymentsFormFooterView paymentsFormFooterView = this.f18660e;
        paymentsFormFooterView.e.setText(b(2131241054));
        this.f18660e.setVisibilityOfDefaultActionSummary(0);
    }

    private void ay() {
        this.f18660e.setVisibilityOfDefaultActionSummary(8);
    }

    public static void m18670a(ContactInfoFormFragment contactInfoFormFragment, String str) {
        Preconditions.checkNotNull(contactInfoFormFragment.f18661f.f18642b);
        Bundle bundle = new Bundle();
        bundle.putString("extra_mutation", str);
        contactInfoFormFragment.f18656a.m18692a(contactInfoFormFragment.f18661f.f18641a).mo735a(contactInfoFormFragment.f18661f, new PaymentsComponentAction(Action.MUTATION, bundle));
    }
}
