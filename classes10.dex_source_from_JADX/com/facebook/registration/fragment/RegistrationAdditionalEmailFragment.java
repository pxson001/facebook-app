package com.facebook.registration.fragment;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.FindViewUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.registration.constants.RegFragmentState;
import com.facebook.registration.logging.SimpleRegLogger;
import com.facebook.registration.model.SimpleRegFormData;
import com.facebook.registration.util.RegistrationUtil;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: last_used_time */
public class RegistrationAdditionalEmailFragment extends RegistrationFragment {
    public RadioButton al;
    public RadioButton am;
    public Account[] an = new Account[0];
    public String ao;
    @Inject
    public RegistrationUtil f8760b;
    @Inject
    public SimpleRegFormData f8761c;
    @Inject
    public SimpleRegLogger f8762d;
    public TextView f8763e;
    private TextView f8764f;
    public Button f8765g;
    public RadioGroup f8766h;
    public RadioButton f8767i;

    /* compiled from: last_used_time */
    class C13091 implements OnClickListener {
        final /* synthetic */ RegistrationAdditionalEmailFragment f8757a;

        C13091(RegistrationAdditionalEmailFragment registrationAdditionalEmailFragment) {
            this.f8757a = registrationAdditionalEmailFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1871047835);
            this.f8757a.f8761c.q = this.f8757a.ao;
            this.f8757a.f8762d.h("ADDED");
            this.f8757a.mo385a(RegFragmentState.ADDITIONAL_EMAIL_ACQUIRED);
            Logger.a(2, EntryType.UI_INPUT_END, 1320201598, a);
        }
    }

    /* compiled from: last_used_time */
    class C13102 implements OnClickListener {
        final /* synthetic */ RegistrationAdditionalEmailFragment f8758a;

        C13102(RegistrationAdditionalEmailFragment registrationAdditionalEmailFragment) {
            this.f8758a = registrationAdditionalEmailFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2009237894);
            this.f8758a.f8761c.q = null;
            this.f8758a.f8762d.h("SKIPPED");
            this.f8758a.mo385a(RegFragmentState.ADDITIONAL_EMAIL_ACQUIRED);
            Logger.a(2, EntryType.UI_INPUT_END, 489796356, a);
        }
    }

    /* compiled from: last_used_time */
    public class C13113 implements OnCheckedChangeListener {
        final /* synthetic */ RegistrationAdditionalEmailFragment f8759a;

        public C13113(RegistrationAdditionalEmailFragment registrationAdditionalEmailFragment) {
            this.f8759a = registrationAdditionalEmailFragment;
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            RegistrationAdditionalEmailFragment registrationAdditionalEmailFragment = this.f8759a;
            RadioButton radioButton = (RadioButton) FindViewUtil.b(radioGroup, i);
            this.f8759a.ao = radioButton.getText().toString();
        }
    }

    public static void m8762a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        RegistrationAdditionalEmailFragment registrationAdditionalEmailFragment = (RegistrationAdditionalEmailFragment) obj;
        RegistrationUtil b = RegistrationUtil.b(fbInjector);
        SimpleRegFormData a = SimpleRegFormData.a(fbInjector);
        SimpleRegLogger b2 = SimpleRegLogger.b(fbInjector);
        registrationAdditionalEmailFragment.f8760b = b;
        registrationAdditionalEmailFragment.f8761c = a;
        registrationAdditionalEmailFragment.f8762d = b2;
    }

    public final void m8765c(Bundle bundle) {
        super.c(bundle);
        Class cls = RegistrationAdditionalEmailFragment.class;
        m8762a(this, getContext());
    }

    protected final void mo383b(View view, Bundle bundle) {
        Account[] accountsByType;
        KeyboardUtils.a(getContext(), view);
        this.f8763e = (TextView) FindViewUtil.b(view, 2131560281);
        this.f8764f = (TextView) FindViewUtil.b(view, 2131566906);
        this.f8765g = (Button) FindViewUtil.b(view, 2131566905);
        this.f8766h = (RadioGroup) FindViewUtil.b(view, 2131566901);
        this.f8767i = (RadioButton) FindViewUtil.b(view, 2131566902);
        this.al = (RadioButton) FindViewUtil.b(view, 2131566903);
        this.am = (RadioButton) FindViewUtil.b(view, 2131566904);
        RegistrationUtil registrationUtil = this.f8760b;
        if (registrationUtil.l.a("android.permission.GET_ACCOUNTS")) {
            accountsByType = AccountManager.get(registrationUtil.a).getAccountsByType("com.google");
        } else {
            accountsByType = new Account[0];
        }
        this.an = accountsByType;
        if (this.an.length == 0) {
            mo385a(RegFragmentState.ADDITIONAL_EMAIL_ACQUIRED);
        } else if (this.an.length == 1) {
            boolean z = true;
            if (this.an.length != 1) {
                z = false;
            }
            Preconditions.checkState(z, "setUpSingleEmailSuggestionView() requires exactly 1 Google account");
            this.ao = this.an[0].name;
            this.f8763e.setText(StringFormatUtil.formatStrLocaleSafe(b(2131239865), this.ao));
            this.f8765g.setText(2131230735);
            this.f8766h.setVisibility(8);
        } else {
            Preconditions.checkState(this.an.length >= 2, "setUpMultipleEmailSuggestionView() requires 2 or more Google accounts");
            this.f8763e.setText(2131239866);
            this.f8767i.setText(this.an[0].name);
            this.al.setText(this.an[1].name);
            if (this.an.length > 2) {
                this.am.setText(this.an[2].name);
            } else {
                this.am.setVisibility(8);
            }
            this.f8767i.toggle();
            this.ao = this.f8767i.getText().toString();
            this.f8766h.setOnCheckedChangeListener(new C13113(this));
        }
        this.f8765g.setOnClickListener(new C13091(this));
        this.f8764f.setOnClickListener(new C13102(this));
    }

    protected final int mo384e() {
        return 2131239812;
    }

    protected final int aq() {
        return 2130906796;
    }
}
