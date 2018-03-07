package com.facebook.registration.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.common.util.FindViewUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.registration.util.RegistrationUtil;
import javax.inject.Inject;

/* compiled from: last_refresh */
public class RegistrationContactsTermsLinkFragment extends RegistrationContactsTermsBaseFragment {
    private TextView al;
    @Inject
    public RegistrationUtil f8791f;
    public TextView f8792g;
    public TextView f8793h;
    private Button f8794i;

    /* compiled from: last_refresh */
    class C13201 implements OnClickListener {
        final /* synthetic */ RegistrationContactsTermsLinkFragment f8789a;

        C13201(RegistrationContactsTermsLinkFragment registrationContactsTermsLinkFragment) {
            this.f8789a = registrationContactsTermsLinkFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1767097461);
            this.f8789a.m8785a(true);
            Logger.a(2, EntryType.UI_INPUT_END, -697309386, a);
        }
    }

    /* compiled from: last_refresh */
    class C13212 implements OnClickListener {
        final /* synthetic */ RegistrationContactsTermsLinkFragment f8790a;

        C13212(RegistrationContactsTermsLinkFragment registrationContactsTermsLinkFragment) {
            this.f8790a = registrationContactsTermsLinkFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1662002723);
            this.f8790a.m8785a(false);
            Logger.a(2, EntryType.UI_INPUT_END, 918994328, a);
        }
    }

    public static void m8790a(Object obj, Context context) {
        ((RegistrationContactsTermsLinkFragment) obj).f8791f = RegistrationUtil.b(FbInjector.get(context));
    }

    public final void mo399c(Bundle bundle) {
        super.mo399c(bundle);
        Class cls = RegistrationContactsTermsLinkFragment.class;
        m8790a(this, getContext());
    }

    protected final int aq() {
        return 2130906799;
    }

    protected final void mo398b(View view) {
        this.f8792g = (TextView) FindViewUtil.b(view, 2131566908);
        this.f8793h = (TextView) FindViewUtil.b(view, 2131566915);
        this.f8794i = (Button) FindViewUtil.b(view, 2131566905);
        this.al = (TextView) FindViewUtil.b(view, 2131566913);
        if (this.f8791f.b()) {
            this.f8792g.setText(2131239794);
            this.f8793h.setVisibility(8);
        }
        super.mo398b(view);
    }

    protected final void as() {
        this.f8794i.setOnClickListener(new C13201(this));
        this.al.setOnClickListener(new C13212(this));
    }
}
