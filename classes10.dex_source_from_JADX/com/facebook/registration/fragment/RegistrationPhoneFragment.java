package com.facebook.registration.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout.LayoutParams;
import android_src.telephony.PhoneNumberFormattingTextWatcher;
import com.facebook.common.hardware.PhoneIsoCountryCode;
import com.facebook.common.phonenumbers.PhoneNumberUtilMethodAutoProvider;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.growth.model.ContactpointType;
import com.facebook.growth.model.DeviceOwnerData;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.katana.app.module.LocaleMethodAutoProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.phonenumbers.NumberParseException;
import com.facebook.phonenumbers.PhoneNumberUtil;
import com.facebook.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.facebook.phonenumbers.Phonenumber.PhoneNumber;
import com.facebook.registration.constants.RegErrorCategory;
import com.facebook.registration.constants.RegFragmentState;
import com.facebook.registration.fragment.RegistrationInputFragment.RegInputException;
import com.facebook.registration.logging.SimpleRegLogger;
import com.facebook.registration.model.ContactPointSuggestions;
import com.facebook.registration.model.ContactPointSuggestions.SuggestionType;
import com.facebook.resources.ui.FbButton;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.widget.countryselector.CountrySelector;
import com.facebook.widget.countryselector.CountrySelector.OnCountrySelectListener;
import com.facebook.widget.countryselector.CountrySelectorProvider;
import com.facebook.widget.countryspinner.CountryCode;
import com.google.common.base.CharMatcher;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: language_switcher_auto_uri */
public class RegistrationPhoneFragment extends RegistrationInputFragment {
    private static final String ap = RegistrationPhoneFragment.class.getName();
    @Inject
    CountrySelectorProvider an;
    @Inject
    @PhoneIsoCountryCode
    Provider<String> ao;
    private AutoCompleteTextView aq;
    private FbButton ar;
    private TextWatcher as;
    public CountrySelector at;
    private final List<String> au = new ArrayList();
    private String av;
    private String aw;
    private boolean ax = false;
    @Inject
    Locale f8872b;
    @Inject
    PhoneNumberUtil f8873c;
    @Inject
    SimpleRegLogger f8874d;

    /* compiled from: language_switcher_auto_uri */
    class C13491 implements OnClickListener {
        final /* synthetic */ RegistrationPhoneFragment f8869a;

        C13491(RegistrationPhoneFragment registrationPhoneFragment) {
            this.f8869a = registrationPhoneFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1802553240);
            this.f8869a.av();
            this.f8869a.mo385a(RegFragmentState.PHONE_SWITCH_TO_EMAIL);
            Logger.a(2, EntryType.UI_INPUT_END, -428373320, a);
        }
    }

    /* compiled from: language_switcher_auto_uri */
    class C13512 implements OnClickListener {
        final /* synthetic */ RegistrationPhoneFragment f8871a;

        /* compiled from: language_switcher_auto_uri */
        class C13501 implements OnCountrySelectListener {
            final /* synthetic */ C13512 f8870a;

            C13501(C13512 c13512) {
                this.f8870a = c13512;
            }

            public final void m8841a(CountryCode countryCode) {
                RegistrationPhoneFragment.m8843a(this.f8870a.f8871a, countryCode);
            }
        }

        C13512(RegistrationPhoneFragment registrationPhoneFragment) {
            this.f8871a = registrationPhoneFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -909834675);
            KeyboardUtils.a(this.f8871a.o());
            this.f8871a.av();
            if (this.f8871a.at == null) {
                this.f8871a.at = this.f8871a.an.a(this.f8871a.getContext(), true);
            }
            this.f8871a.at.u = new C13501(this);
            this.f8871a.at.a(view);
            Logger.a(2, EntryType.UI_INPUT_END, -988336803, a);
        }
    }

    public static void m8844a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RegistrationPhoneFragment) obj).m8846a(LocaleMethodAutoProvider.b(fbInjector), PhoneNumberUtilMethodAutoProvider.a(fbInjector), SimpleRegLogger.b(fbInjector), (CountrySelectorProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CountrySelectorProvider.class), IdBasedProvider.a(fbInjector, 4446));
    }

    public final void mo394c(Bundle bundle) {
        super.mo394c(bundle);
        Class cls = RegistrationPhoneFragment.class;
        m8844a((Object) this, getContext());
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        aD();
    }

    protected final void mo393b(View view) {
        this.aq = (AutoCompleteTextView) FindViewUtil.b(view, 2131560679);
        this.aq.setText(this.f8777f.f);
        m8774a(this.aq);
        this.ar = (FbButton) FindViewUtil.b(view, 2131560678);
        aC();
        aD();
        aB();
        FindViewUtil.b(view, 2131566938).setOnClickListener(new C13491(this));
    }

    protected final int mo384e() {
        return 2131239803;
    }

    protected final int mz_() {
        return 2131239801;
    }

    protected final int as() {
        return 2131239802;
    }

    protected final int at() {
        return 2130906813;
    }

    protected final int az() {
        return 2130906814;
    }

    protected final RegFragmentState aw() {
        return RegFragmentState.PHONE_ACQUIRED;
    }

    protected final RegErrorCategory ax() {
        return RegErrorCategory.PHONE;
    }

    private void aB() {
        int i = 0;
        ContactPointSuggestions t = this.f8777f.t();
        this.f8874d.a(this.f8777f.u(), "phone");
        DeviceOwnerData s = this.f8777f.s();
        ImmutableList d = s.d();
        if (StringUtil.a(this.aq.getText().toString())) {
            this.ax = true;
            CharSequence a = t.m8885a(SuggestionType.PREFILL, ContactpointType.PHONE, 0);
            if (!StringUtil.a(a)) {
                try {
                    PhoneNumber parse = this.f8873c.parse(a, s.e());
                    this.aq.setText(m8842a(parse));
                    this.aw = this.f8873c.getRegionCodeForNumber(parse);
                    m8845a(this.aw);
                } catch (NumberParseException e) {
                    this.aq.setText(a);
                    BLog.b(ap, "Incorrectly formatted suggested contact point prefill phone number: ", e);
                }
            } else if (!d.isEmpty()) {
                this.aq.setText((CharSequence) d.get(0));
            }
        }
        ImmutableList b = new Builder().b(t.m8886a(SuggestionType.AUTOCOMPLETE, ContactpointType.PHONE)).b(d).b();
        if (!b.isEmpty()) {
            Collection linkedHashSet = new LinkedHashSet();
            int size = b.size();
            while (i < size) {
                String str = (String) b.get(i);
                try {
                    PhoneNumber parse2 = this.f8873c.parse(str, s.e());
                    linkedHashSet.add(m8842a(parse2));
                    linkedHashSet.add(this.f8873c.format(parse2, PhoneNumberFormat.NATIONAL));
                } catch (NumberParseException e2) {
                    linkedHashSet.add(str);
                }
                i++;
            }
            this.au.clear();
            this.au.addAll(linkedHashSet);
            this.aq.setAdapter(new ArrayAdapter(getContext(), 17367050, this.au));
            this.aq.setThreshold(1);
        }
        if (StringUtil.c(this.av)) {
            if (StringUtil.c(s.e())) {
                this.aw = (String) this.ao.get();
            } else {
                this.aw = s.e();
            }
            m8845a(this.aw);
        }
    }

    protected final void au() {
        CharSequence obj = this.aq.getText().toString();
        if (StringUtil.c(obj) || !Patterns.PHONE.matcher(obj).matches()) {
            throw new RegInputException(2131239806);
        }
    }

    protected final void av() {
        String obj = this.aq.getText().toString();
        String str = "";
        try {
            str = this.f8873c.format(this.f8873c.parse(obj, this.av), PhoneNumberFormat.E164);
        } catch (NumberParseException e) {
        }
        if (StringUtil.c(str)) {
            str = this.f8873c.getCountryCodeForRegion(this.av) + obj;
        }
        this.f8777f.a(ContactpointType.PHONE);
        this.f8777f.c(obj);
        this.f8777f.e(str);
    }

    private void aC() {
        if (!StringUtil.c(this.f8777f.g)) {
            m8845a(this.f8777f.g);
        }
        this.ar.setOnClickListener(new C13512(this));
    }

    public static void m8843a(RegistrationPhoneFragment registrationPhoneFragment, CountryCode countryCode) {
        registrationPhoneFragment.av = countryCode.a;
        registrationPhoneFragment.ar.setText(countryCode.c);
        registrationPhoneFragment.aq.removeTextChangedListener(registrationPhoneFragment.as);
        registrationPhoneFragment.as = new PhoneNumberFormattingTextWatcher(countryCode.a, registrationPhoneFragment.getContext());
        registrationPhoneFragment.aq.addTextChangedListener(registrationPhoneFragment.as);
        String removeFrom = CharMatcher.WHITESPACE.or(CharMatcher.anyOf("()-.")).removeFrom(registrationPhoneFragment.aq.getText().toString());
        RegistrationInputFragment.m8768a(registrationPhoneFragment.aq, "");
        RegistrationInputFragment.m8768a(registrationPhoneFragment.aq, removeFrom);
        registrationPhoneFragment.f8777f.g = countryCode.a;
    }

    private void m8845a(String str) {
        if (str != null) {
            m8843a(this, new CountryCode(str, "+" + Integer.toString(this.f8873c.getCountryCodeForRegion(str)), new Locale(this.f8872b.getLanguage(), str).getDisplayCountry(this.f8872b)));
        }
    }

    private String m8842a(PhoneNumber phoneNumber) {
        String format = this.f8873c.format(phoneNumber, PhoneNumberFormat.INTERNATIONAL);
        String str = "+" + String.valueOf(phoneNumber.countryCode_);
        if (!format.startsWith(str)) {
            return format;
        }
        return CharMatcher.WHITESPACE.or(CharMatcher.is('-')).trimLeadingFrom(format.substring(str.length()));
    }

    private void aD() {
        int i = 0;
        LayoutParams layoutParams = (LayoutParams) this.am.getLayoutParams();
        LayoutParams layoutParams2 = (LayoutParams) this.f8780i.getLayoutParams();
        switch (jW_().getConfiguration().orientation) {
            case 2:
                layoutParams.bottomMargin = 0;
                layoutParams2.topMargin = 0;
                layoutParams2.bottomMargin = 0;
                break;
            default:
                i = jW_().getDimensionPixelSize(2131427416);
                break;
        }
        layoutParams.bottomMargin = i;
        layoutParams2.topMargin = i;
        layoutParams2.bottomMargin = i;
    }

    protected final void aA() {
        if (this.ax) {
            this.ax = false;
            this.f8874d.a(ax().name(), this.au.indexOf(this.aq.getText().toString()), this.au.size());
            this.f8874d.a("COUNTRY_CODE", this.aw, this.av);
        }
    }

    private void m8846a(Locale locale, PhoneNumberUtil phoneNumberUtil, SimpleRegLogger simpleRegLogger, CountrySelectorProvider countrySelectorProvider, Provider<String> provider) {
        this.f8872b = locale;
        this.f8873c = phoneNumberUtil;
        this.f8874d = simpleRegLogger;
        this.an = countrySelectorProvider;
        this.ao = provider;
    }
}
