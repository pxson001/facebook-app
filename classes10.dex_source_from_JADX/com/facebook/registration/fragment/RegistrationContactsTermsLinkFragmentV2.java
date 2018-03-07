package com.facebook.registration.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.common.util.FindViewUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.registration.util.RegistrationUtil;
import javax.inject.Inject;

/* compiled from: last_on_stack */
public class RegistrationContactsTermsLinkFragmentV2 extends RegistrationContactsTermsBaseFragment {
    public View al;
    @Inject
    public RegistrationUtil f8797f;
    private Button f8798g;
    private TextView f8799h;
    public View f8800i;

    /* compiled from: last_on_stack */
    class C13221 implements OnClickListener {
        final /* synthetic */ RegistrationContactsTermsLinkFragmentV2 f8795a;

        C13221(RegistrationContactsTermsLinkFragmentV2 registrationContactsTermsLinkFragmentV2) {
            this.f8795a = registrationContactsTermsLinkFragmentV2;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 282942957);
            this.f8795a.m8785a(true);
            Logger.a(2, EntryType.UI_INPUT_END, -2058701306, a);
        }
    }

    /* compiled from: last_on_stack */
    class C13232 implements OnClickListener {
        final /* synthetic */ RegistrationContactsTermsLinkFragmentV2 f8796a;

        C13232(RegistrationContactsTermsLinkFragmentV2 registrationContactsTermsLinkFragmentV2) {
            this.f8796a = registrationContactsTermsLinkFragmentV2;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1952721691);
            this.f8796a.m8785a(false);
            Logger.a(2, EntryType.UI_INPUT_END, -1010260980, a);
        }
    }

    public static void m8793a(Object obj, Context context) {
        ((RegistrationContactsTermsLinkFragmentV2) obj).f8797f = RegistrationUtil.b(FbInjector.get(context));
    }

    public final void mo399c(Bundle bundle) {
        super.mo399c(bundle);
        Class cls = RegistrationContactsTermsLinkFragmentV2.class;
        m8793a(this, getContext());
    }

    protected final int aq() {
        return 2130906798;
    }

    protected final void mo398b(View view) {
        this.f8798g = (Button) FindViewUtil.b(view, 2131566905);
        this.f8799h = (TextView) FindViewUtil.b(view, 2131566913);
        this.f8800i = FindViewUtil.b(view, 2131566912);
        this.al = FindViewUtil.b(view, 2131566914);
        if (this.f8797f.d()) {
            LayoutParams layoutParams = (LayoutParams) this.f8800i.getLayoutParams();
            if (layoutParams.weight > 0.0f) {
                layoutParams.weight = 4.0f;
                this.f8800i.setLayoutParams(layoutParams);
            }
            layoutParams = (LayoutParams) this.al.getLayoutParams();
            layoutParams.weight = 0.0f;
            this.al.setLayoutParams(layoutParams);
        }
        super.mo398b(view);
    }

    protected final void as() {
        this.f8798g.setOnClickListener(new C13221(this));
        this.f8799h.setOnClickListener(new C13232(this));
    }
}
