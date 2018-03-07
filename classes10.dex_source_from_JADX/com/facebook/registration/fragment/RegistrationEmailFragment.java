package com.facebook.registration.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.growth.model.ContactpointType;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.registration.constants.RegErrorCategory;
import com.facebook.registration.constants.RegFragmentState;
import com.facebook.registration.fragment.RegistrationInputFragment.RegInputException;
import com.facebook.registration.logging.SimpleRegLogger;
import com.facebook.registration.model.ContactPointSuggestions;
import com.facebook.registration.model.ContactPointSuggestions.SuggestionType;
import com.facebook.widget.text.watcher.BaseTextWatcher;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: last_geofence_flushed_cancel */
public class RegistrationEmailFragment extends RegistrationInputFragment {
    public boolean an = false;
    @Inject
    public SimpleRegLogger f8824b;
    public AutoCompleteTextView f8825c;
    public final List<String> f8826d = new ArrayList();

    /* compiled from: last_geofence_flushed_cancel */
    class C13281 extends BaseTextWatcher {
        final /* synthetic */ RegistrationEmailFragment f8822a;

        C13281(RegistrationEmailFragment registrationEmailFragment) {
            this.f8822a = registrationEmailFragment;
        }

        public void afterTextChanged(Editable editable) {
            this.f8822a.f8777f.i = editable.toString();
        }
    }

    /* compiled from: last_geofence_flushed_cancel */
    class C13292 implements OnClickListener {
        final /* synthetic */ RegistrationEmailFragment f8823a;

        C13292(RegistrationEmailFragment registrationEmailFragment) {
            this.f8823a = registrationEmailFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 460870543);
            this.f8823a.av();
            this.f8823a.mo385a(RegFragmentState.EMAIL_SWITCH_TO_PHONE);
            Logger.a(2, EntryType.UI_INPUT_END, -1313056261, a);
        }
    }

    public static void m8821a(Object obj, Context context) {
        ((RegistrationEmailFragment) obj).f8824b = SimpleRegLogger.b(FbInjector.get(context));
    }

    public final void mo394c(Bundle bundle) {
        super.mo394c(bundle);
        Class cls = RegistrationEmailFragment.class;
        m8821a(this, getContext());
    }

    protected final void mo393b(View view) {
        this.f8825c = (AutoCompleteTextView) FindViewUtil.b(view, 2131560674);
        this.f8825c.setText(this.f8777f.j);
        this.f8825c.addTextChangedListener(new C13281(this));
        m8774a(this.f8825c);
        ContactPointSuggestions t = this.f8777f.t();
        this.f8824b.a(this.f8777f.u(), "email");
        ImmutableList c = this.f8777f.s().c();
        if (StringUtil.a(this.f8825c.getText().toString())) {
            this.an = true;
            CharSequence a = t.m8885a(SuggestionType.PREFILL, ContactpointType.EMAIL, 0);
            if (!StringUtil.a(a)) {
                this.f8825c.setText(a);
            } else if (!c.isEmpty()) {
                this.f8825c.setText((CharSequence) c.get(0));
            }
        }
        this.f8826d.clear();
        this.f8826d.addAll(t.m8886a(SuggestionType.AUTOCOMPLETE, ContactpointType.EMAIL));
        this.f8826d.addAll(c);
        if (!this.f8826d.isEmpty()) {
            this.f8825c.setAdapter(new ArrayAdapter(getContext(), 17367050, this.f8826d.toArray(new String[0])));
            this.f8825c.setThreshold(1);
        }
        FindViewUtil.b(view, 2131566917).setOnClickListener(new C13292(this));
    }

    protected final int mo384e() {
        return 2131239812;
    }

    protected final int mz_() {
        return 2131239808;
    }

    protected final int as() {
        return 2131239809;
    }

    protected final int at() {
        return 2130906801;
    }

    protected final int az() {
        return 2130906802;
    }

    protected final void au() {
        CharSequence obj = this.f8825c.getText().toString();
        if (StringUtil.c(obj) || !Patterns.EMAIL_ADDRESS.matcher(obj).matches()) {
            throw new RegInputException(2131239811);
        }
    }

    protected final void av() {
        this.f8777f.a(ContactpointType.EMAIL);
        this.f8777f.j = this.f8825c.getText().toString();
    }

    protected final RegFragmentState aw() {
        return RegFragmentState.EMAIL_ACQUIRED;
    }

    protected final RegErrorCategory ax() {
        return RegErrorCategory.EMAIL;
    }

    protected final void aA() {
        if (this.an) {
            this.an = false;
            this.f8824b.a(ax().name(), this.f8826d.indexOf(this.f8825c.getText().toString()), this.f8826d.size());
        }
    }
}
