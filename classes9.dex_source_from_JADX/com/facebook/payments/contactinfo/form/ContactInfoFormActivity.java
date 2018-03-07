package com.facebook.payments.contactinfo.form;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentTransaction;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: buyerFbId */
public class ContactInfoFormActivity extends FbFragmentActivity {
    @Inject
    public SimpleContactInfoFormManager f18647p;
    private ContactInfoCommonFormParams f18648q;

    private static <T extends Context> void m18663a(Class<T> cls, T t) {
        m18664a((Object) t, (Context) t);
    }

    public static void m18664a(Object obj, Context context) {
        ((ContactInfoFormActivity) obj).f18647p = SimpleContactInfoFormManager.m18690a(FbInjector.get(context));
    }

    protected final void m18666a(Bundle bundle) {
        Class cls = ContactInfoFormActivity.class;
        m18664a((Object) this, (Context) this);
        this.f18648q = (ContactInfoCommonFormParams) getIntent().getParcelableExtra("extra_contact_info_form_params");
    }

    protected final void m18667b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130903760);
        if (bundle == null) {
            m18665i();
        }
    }

    private void m18665i() {
        if (kO_().a("contact_info_form_fragment_tag") == null) {
            FragmentTransaction a = kO_().a();
            Parcelable parcelable = this.f18648q;
            ContactInfoFormFragment contactInfoFormFragment = new ContactInfoFormFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_contact_info_form_params", parcelable);
            contactInfoFormFragment.g(bundle);
            a.b(2131560203, contactInfoFormFragment, "contact_info_form_fragment_tag").b();
        }
    }
}
