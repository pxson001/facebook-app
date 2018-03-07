package com.facebook.pages.common.surface.calltoaction.ui;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.telephony.PhoneNumberUtils;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.hardware.PhoneIsoCountryCode;
import com.facebook.common.phonenumbers.PhoneNumberUtilMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil.PageCallToActionErrorState;
import com.facebook.phonenumbers.NumberParseException;
import com.facebook.phonenumbers.PhoneNumberUtil;
import com.facebook.phonenumbers.Phonenumber.PhoneNumber;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.countryselector.CountrySelector;
import com.facebook.widget.countryselector.CountrySelector$OnCountrySelectListener;
import com.facebook.widget.countryselector.CountrySelectorProvider;
import com.facebook.widget.countryspinner.CountryCode;
import com.facebook.widget.text.BetterEditTextView;
import java.util.ArrayList;
import java.util.Arrays;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: could not extract id reference from =  */
public class PageCallToActionPhoneNumberEditView extends CustomRelativeLayout implements PageCallToActionInput {
    @Inject
    PhoneNumberUtil f16853a;
    @Inject
    CountrySelectorProvider f16854b;
    @Inject
    @PhoneIsoCountryCode
    Provider<String> f16855c;
    private FbTextView f16856d;
    private BetterEditTextView f16857e;
    private FbTextView f16858f;
    private int f16859g;
    private final OnClickListener f16860h = new CountryCodeClickListener(this);
    public final CountrySelector$OnCountrySelectListener f16861i = new CountrySelectListener(this);

    /* compiled from: could not extract id reference from =  */
    class CountryCodeClickListener implements OnClickListener {
        final /* synthetic */ PageCallToActionPhoneNumberEditView f16851a;

        public CountryCodeClickListener(PageCallToActionPhoneNumberEditView pageCallToActionPhoneNumberEditView) {
            this.f16851a = pageCallToActionPhoneNumberEditView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1647934633);
            CountrySelector a2 = this.f16851a.f16854b.a(this.f16851a.getContext(), true);
            a2.u = this.f16851a.f16861i;
            a2.a(this.f16851a);
            Logger.a(2, EntryType.UI_INPUT_END, -701243037, a);
        }
    }

    /* compiled from: could not extract id reference from =  */
    class CountrySelectListener implements CountrySelector$OnCountrySelectListener {
        final /* synthetic */ PageCallToActionPhoneNumberEditView f16852a;

        public CountrySelectListener(PageCallToActionPhoneNumberEditView pageCallToActionPhoneNumberEditView) {
            this.f16852a = pageCallToActionPhoneNumberEditView;
        }

        public final void mo766a(CountryCode countryCode) {
            PageCallToActionPhoneNumberEditView.setDialingCode(this.f16852a, countryCode.b);
        }
    }

    private static <T extends View> void m20113a(Class<T> cls, T t) {
        m20114a((Object) t, t.getContext());
    }

    private static void m20114a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageCallToActionPhoneNumberEditView) obj).m20112a(PhoneNumberUtilMethodAutoProvider.a(fbInjector), (CountrySelectorProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CountrySelectorProvider.class), IdBasedProvider.a(fbInjector, 4446));
    }

    public PageCallToActionPhoneNumberEditView(Context context) {
        super(context);
        m20115f();
    }

    public PageCallToActionPhoneNumberEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20115f();
    }

    public PageCallToActionPhoneNumberEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20115f();
    }

    public View getView() {
        return this;
    }

    public final boolean mo1032a() {
        return true;
    }

    public String getValue() {
        String stripSeparators = PhoneNumberUtils.stripSeparators(this.f16857e.getText().toString());
        if (StringUtil.a(stripSeparators)) {
            return stripSeparators;
        }
        return this.f16856d.getText() + stripSeparators;
    }

    public final PageCallToActionErrorState mo1033b() {
        return !StringUtil.a(this.f16857e.getText()) ? PageCallToActionErrorState.NONE : PageCallToActionErrorState.EMPTY;
    }

    public final void mo1034c() {
        this.f16857e.getBackground().setColorFilter(this.f16859g, Mode.SRC_IN);
        this.f16858f.setVisibility(0);
    }

    public final void mo1035d() {
        this.f16857e.getBackground().setColorFilter(this.f16859g, Mode.SRC_IN);
        this.f16858f.requestFocus();
    }

    public final void mo1036e() {
        this.f16857e.getBackground().clearColorFilter();
        this.f16858f.setVisibility(8);
    }

    private void setHint(CharSequence charSequence) {
        this.f16857e.setHint(charSequence);
    }

    private void setText(CharSequence charSequence) {
        this.f16857e.setText(charSequence);
    }

    private void setCountryCode(int i) {
        setDialingCode(this, "+" + i);
    }

    public static void setDialingCode(PageCallToActionPhoneNumberEditView pageCallToActionPhoneNumberEditView, String str) {
        pageCallToActionPhoneNumberEditView.f16856d.setText(str);
    }

    private void m20115f() {
        m20113a(PageCallToActionPhoneNumberEditView.class, (View) this);
        setContentView(2130905983);
        this.f16856d = (FbTextView) a(2131565394);
        this.f16858f = (FbTextView) a(2131565378);
        this.f16859g = getResources().getColor(2131361918);
        this.f16857e = ((PageCallToActionTextWithClearButtonEditView) a(2131565395)).f16867a;
        this.f16857e.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        this.f16857e.setInputType(3);
        ArrayList arrayList = new ArrayList(Arrays.asList(this.f16857e.getFilters()));
        arrayList.add(new LengthFilter(15));
        this.f16857e.setFilters((InputFilter[]) arrayList.toArray(new InputFilter[arrayList.size()]));
        this.f16856d.setOnClickListener(this.f16860h);
        setDefaultCountryCode((String) this.f16855c.get());
    }

    private void setDefaultCountryCode(String str) {
        setCountryCode(this.f16853a.getCountryCodeForRegion(str));
    }

    public final void m20116a(String str, boolean z, String str2, int i, String str3) {
        setHint(str);
        if (z) {
            if (!StringUtil.a(str2)) {
                setText(str2);
            }
            if (i != -1) {
                setCountryCode(i);
            }
        } else if (!StringUtil.a(str3)) {
            try {
                PhoneNumber parse = this.f16853a.parse(str3, null);
                setCountryCode(parse.getCountryCode());
                setText(Long.toString(parse.getNationalNumber()));
            } catch (NumberParseException e) {
            }
        }
    }

    private void m20112a(PhoneNumberUtil phoneNumberUtil, CountrySelectorProvider countrySelectorProvider, Provider<String> provider) {
        this.f16853a = phoneNumberUtil;
        this.f16854b = countrySelectorProvider;
        this.f16855c = provider;
    }
}
