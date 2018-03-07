package com.facebook.confirmation.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListAdapter;
import android_src.telephony.PhoneNumberFormattingTextWatcher;
import com.facebook.common.hardware.PhoneIsoCountryCode;
import com.facebook.common.locale.Locales;
import com.facebook.common.phonenumbers.PhoneNumberUtilMethodAutoProvider;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.confirmation.constants.ConfFragmentState;
import com.facebook.growth.model.Contactpoint;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.phonenumbers.NumberParseException;
import com.facebook.phonenumbers.PhoneNumberUtil;
import com.facebook.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.facebook.resources.ui.FbButton;
import com.facebook.widget.countryselector.CountrySelector;
import com.facebook.widget.countryselector.CountrySelector$OnCountrySelectListener;
import com.facebook.widget.countryselector.CountrySelectorProvider;
import com.facebook.widget.countryspinner.CountryCode;
import com.facebook.widget.text.watcher.BaseTextWatcher;
import com.google.common.base.CharMatcher;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: interaction_source */
public class ConfPhoneFragment extends ConfContactpointFragment {
    public CountrySelector as;
    private String at = "";
    private TextWatcher au;
    private Locale av;
    private AutoCompleteTextView aw;
    @Inject
    public Locales f10759e;
    @Inject
    public CountrySelectorProvider f10760f;
    @Inject
    @PhoneIsoCountryCode
    public Provider<String> f10761g;
    @Inject
    public PhoneNumberUtil f10762h;
    private FbButton f10763i;

    /* compiled from: interaction_source */
    class C11591 extends BaseTextWatcher {
        final /* synthetic */ ConfPhoneFragment f10756a;

        C11591(ConfPhoneFragment confPhoneFragment) {
            this.f10756a = confPhoneFragment;
        }

        public void afterTextChanged(Editable editable) {
            this.f10756a.aq.setVisibility(8);
        }
    }

    /* compiled from: interaction_source */
    class C11612 implements OnClickListener {
        final /* synthetic */ ConfPhoneFragment f10758a;

        /* compiled from: interaction_source */
        class C11601 implements CountrySelector$OnCountrySelectListener {
            final /* synthetic */ C11612 f10757a;

            C11601(C11612 c11612) {
                this.f10757a = c11612;
            }

            public final void mo766a(CountryCode countryCode) {
                ConfPhoneFragment.m12685a(this.f10757a.f10758a, countryCode);
            }
        }

        C11612(ConfPhoneFragment confPhoneFragment) {
            this.f10758a = confPhoneFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -539146542);
            if (this.f10758a.as == null) {
                this.f10758a.as = this.f10758a.f10760f.a(this.f10758a.getContext(), true);
            }
            this.f10758a.as.u = new C11601(this);
            this.f10758a.as.a(view);
            Logger.a(2, EntryType.UI_INPUT_END, -1924937362, a);
        }
    }

    public static void m12686a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ConfPhoneFragment confPhoneFragment = (ConfPhoneFragment) obj;
        Locales a = Locales.a(fbInjector);
        CountrySelectorProvider countrySelectorProvider = (CountrySelectorProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CountrySelectorProvider.class);
        Provider a2 = IdBasedProvider.a(fbInjector, 4446);
        PhoneNumberUtil a3 = PhoneNumberUtilMethodAutoProvider.a(fbInjector);
        confPhoneFragment.f10759e = a;
        confPhoneFragment.f10760f = countrySelectorProvider;
        confPhoneFragment.f10761g = a2;
        confPhoneFragment.f10762h = a3;
    }

    public final void mo755c(Bundle bundle) {
        super.mo755c(bundle);
        Class cls = ConfPhoneFragment.class;
        m12686a((Object) this, getContext());
    }

    protected final void mo765b(View view) {
        this.av = this.f10759e.a();
        this.f10763i = (FbButton) FindViewUtil.b(view, 2131560678);
        this.aw = (AutoCompleteTextView) FindViewUtil.b(view, 2131560679);
        this.aw.addTextChangedListener(new C11591(this));
        m12662a(this.aw);
        aw();
    }

    protected final int az() {
        return 2131239771;
    }

    protected final int aB() {
        return 2131239759;
    }

    protected final int mo756e() {
        return 2130903747;
    }

    protected final int ar() {
        return 2131239770;
    }

    protected final ConfFragmentState ay() {
        return ConfFragmentState.PHONE_SWITCH_TO_EMAIL;
    }

    @Nullable
    protected final Contactpoint au() {
        Contactpoint contactpoint = null;
        String obj = this.aw.getText().toString();
        if (!(StringUtil.a(this.aw.getText().toString()) || StringUtil.a(this.at))) {
            try {
                contactpoint = Contactpoint.m17344a(this.f10762h.format(this.f10762h.parse(obj, this.at), PhoneNumberFormat.E164), this.at);
            } catch (NumberParseException e) {
            }
        }
        return contactpoint;
    }

    protected final ConfFragmentState av() {
        return ConfFragmentState.PHONE_ACQUIRED;
    }

    private void aw() {
        if (StringUtil.c(this.al.f10776a.isoCountryCode)) {
            m12687a((String) this.f10761g.get());
        } else {
            m12687a(this.al.f10776a.isoCountryCode);
        }
        this.f10763i.setOnClickListener(new C11612(this));
    }

    private void m12687a(String str) {
        m12685a(this, new CountryCode(str, "+" + Integer.toString(this.f10762h.getCountryCodeForRegion(str)), new Locale(this.av.getLanguage(), str).getDisplayCountry(this.av)));
    }

    public static void m12685a(ConfPhoneFragment confPhoneFragment, CountryCode countryCode) {
        confPhoneFragment.f10763i.setText(countryCode.c);
        if (!confPhoneFragment.at.isEmpty()) {
            confPhoneFragment.aw.removeTextChangedListener(confPhoneFragment.au);
        }
        confPhoneFragment.au = new PhoneNumberFormattingTextWatcher(countryCode.a, confPhoneFragment.getContext());
        confPhoneFragment.aw.addTextChangedListener(confPhoneFragment.au);
        String removeFrom = CharMatcher.WHITESPACE.or(CharMatcher.anyOf("()-.")).removeFrom(confPhoneFragment.aw.getText().toString());
        m12684a(confPhoneFragment.aw, "");
        m12684a(confPhoneFragment.aw, removeFrom);
        confPhoneFragment.at = countryCode.a;
    }

    private static void m12684a(AutoCompleteTextView autoCompleteTextView, String str) {
        ListAdapter adapter = autoCompleteTextView.getAdapter();
        if (adapter instanceof ArrayAdapter) {
            autoCompleteTextView.setAdapter(null);
            autoCompleteTextView.setText(str);
            autoCompleteTextView.setAdapter((ArrayAdapter) adapter);
            return;
        }
        autoCompleteTextView.setText(str);
    }
}
