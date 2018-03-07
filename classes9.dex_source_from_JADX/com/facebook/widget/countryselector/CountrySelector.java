package com.facebook.widget.countryselector;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.common.locale.Locales;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.phonenumbers.PhoneNumberUtil;
import com.facebook.resources.ui.FbButton;
import com.facebook.ui.search.SearchEditText;
import com.facebook.widget.countryspinner.CountryCode;
import com.facebook.widget.listview.BetterListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: shift_JIS */
public class CountrySelector extends PopoverWindow {
    public final boolean f3535a;
    public final Locales f3536l;
    public final PhoneNumberUtil f3537m;
    public View f3538n = LayoutInflater.from(getContext()).inflate(2130903809, this.f);
    public SearchEditText f3539o = ((SearchEditText) this.f3538n.findViewById(2131560811));
    public BetterListView f3540p = ((BetterListView) this.f3538n.findViewById(2131560812));
    public FbButton f3541q = ((FbButton) this.f3538n.findViewById(2131560414));
    public Locale f3542r;
    public CountryCode[] f3543s;
    public ArrayAdapter<CountryCode> f3544t;
    public OnCountrySelectListener f3545u;

    /* compiled from: shift_JIS */
    public class C03241 implements OnCountrySelectListener {
        final /* synthetic */ CountrySelector f3530a;

        public C03241(CountrySelector countrySelector) {
            this.f3530a = countrySelector;
        }

        public final void m3340a(CountryCode countryCode) {
        }
    }

    /* compiled from: shift_JIS */
    public class C03263 implements OnItemClickListener {
        final /* synthetic */ CountrySelector f3532a;

        public C03263(CountrySelector countrySelector) {
            this.f3532a = countrySelector;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f3532a.f3545u.a((CountryCode) this.f3532a.f3544t.getItem(i));
            this.f3532a.f3539o.setText("");
            this.f3532a.l();
        }
    }

    /* compiled from: shift_JIS */
    public class C03274 implements TextWatcher {
        final /* synthetic */ CountrySelector f3533a;

        public C03274(CountrySelector countrySelector) {
            this.f3533a = countrySelector;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f3533a.f3544t.getFilter().filter(charSequence);
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: shift_JIS */
    public class C03285 implements OnClickListener {
        final /* synthetic */ CountrySelector f3534a;

        public C03285(CountrySelector countrySelector) {
            this.f3534a = countrySelector;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -190218932);
            this.f3534a.l();
            Logger.a(2, EntryType.UI_INPUT_END, -773239534, a);
        }
    }

    @Inject
    public CountrySelector(@Assisted Context context, @Assisted boolean z, Locales locales, PhoneNumberUtil phoneNumberUtil) {
        super(context);
        this.f3535a = z;
        this.f3536l = locales;
        this.f3537m = phoneNumberUtil;
        this.f3539o.requestFocus();
        this.f3545u = new C03241(this);
        this.f3542r = this.f3536l.a();
        String[] iSOCountries = Locale.getISOCountries();
        List arrayList = new ArrayList();
        for (String str : iSOCountries) {
            CountryCode countryCode;
            int countryCodeForRegion = this.f3537m.getCountryCodeForRegion(str);
            if (countryCodeForRegion == 0) {
                countryCode = null;
            } else {
                countryCode = new CountryCode(str, "+" + countryCodeForRegion, new Locale(this.f3542r.getLanguage(), str).getDisplayCountry(this.f3542r));
            }
            CountryCode countryCode2 = countryCode;
            if (countryCode2 != null) {
                arrayList.add(countryCode2);
            }
        }
        Collections.sort(arrayList);
        this.f3543s = (CountryCode[]) arrayList.toArray(new CountryCode[0]);
        this.f3544t = new ArrayAdapter<CountryCode>(this, getContext(), 2130903808, this.f3543s) {
            final /* synthetic */ CountrySelector f3531a;

            public View getView(int i, View view, ViewGroup viewGroup) {
                if (view == null) {
                    view = View.inflate(getContext(), 2130903808, null);
                }
                CountryCode countryCode = (CountryCode) this.f3531a.f3544t.getItem(i);
                ((TextView) view.findViewById(2131560809)).setText(countryCode.f3549c);
                if (this.f3531a.f3535a) {
                    ((TextView) view.findViewById(2131560810)).setText(countryCode.f3548b);
                }
                return view;
            }
        };
        this.f3540p.setAdapter(this.f3544t);
        this.f3540p.setOnItemClickListener(new C03263(this));
        this.f3539o.addTextChangedListener(new C03274(this));
        this.f3541q.setOnClickListener(new C03285(this));
        ((LayoutParams) this.f.getLayoutParams()).height = -1;
        this.s = 1003;
    }

    public final void m3341l() {
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f3539o.getWindowToken(), 0);
        super.l();
    }
}
