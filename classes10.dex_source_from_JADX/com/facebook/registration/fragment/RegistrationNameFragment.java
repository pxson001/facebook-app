package com.facebook.registration.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import com.facebook.common.locale.Locales;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.growth.model.FullName;
import com.facebook.inject.FbInjector;
import com.facebook.registration.constants.RegErrorCategory;
import com.facebook.registration.constants.RegFragmentState;
import com.facebook.registration.fragment.RegistrationInputFragment.RegInputException;
import com.facebook.registration.logging.SimpleRegLogger;
import com.facebook.widget.text.watcher.BaseTextWatcher;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;

/* compiled from: language_switcher_visit */
public class RegistrationNameFragment extends RegistrationInputFragment {
    public AutoCompleteTextView an;
    private final List<String> ao = new ArrayList();
    @Inject
    public SimpleRegLogger f8860b;
    @Inject
    public Locales f8861c;
    public AutoCompleteTextView f8862d;

    /* compiled from: language_switcher_visit */
    class C13421 extends BaseTextWatcher {
        final /* synthetic */ RegistrationNameFragment f8858a;

        C13421(RegistrationNameFragment registrationNameFragment) {
            this.f8858a = registrationNameFragment;
        }

        public void afterTextChanged(Editable editable) {
            this.f8858a.f8777f.c = editable.toString();
        }
    }

    /* compiled from: language_switcher_visit */
    class C13432 extends BaseTextWatcher {
        final /* synthetic */ RegistrationNameFragment f8859a;

        C13432(RegistrationNameFragment registrationNameFragment) {
            this.f8859a = registrationNameFragment;
        }

        public void afterTextChanged(Editable editable) {
            this.f8859a.f8777f.d = editable.toString();
        }
    }

    public static void m8835a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        RegistrationNameFragment registrationNameFragment = (RegistrationNameFragment) obj;
        SimpleRegLogger b = SimpleRegLogger.b(fbInjector);
        Locales a = Locales.a(fbInjector);
        registrationNameFragment.f8860b = b;
        registrationNameFragment.f8861c = a;
    }

    public final void mo394c(Bundle bundle) {
        super.mo394c(bundle);
        Class cls = RegistrationNameFragment.class;
        m8835a(this, getContext());
    }

    protected final void mo393b(View view) {
        this.f8862d = (AutoCompleteTextView) FindViewUtil.b(view, 2131566932);
        this.f8862d.setText(this.f8777f.c);
        this.f8862d.addTextChangedListener(new C13421(this));
        this.an = (AutoCompleteTextView) FindViewUtil.b(view, 2131566933);
        this.an.setText(this.f8777f.d);
        this.an.addTextChangedListener(new C13432(this));
        m8774a(this.an);
        String locale = this.f8861c.a().toString();
        boolean z = true;
        switch (locale.hashCode()) {
            case 115861276:
                if (locale.equals("zh_CN")) {
                    z = false;
                    break;
                }
                break;
            case 115861428:
                if (locale.equals("zh_HK")) {
                    z = true;
                    break;
                }
                break;
            case 115861812:
                if (locale.equals("zh_TW")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
            case true:
            case true:
                TriState a = this.f8776e.a(20);
                this.f8860b.a("fb4a_reg_name_hint_zh_promo", a);
                if (a.asBoolean(false)) {
                    String str = "（中文）";
                    this.f8862d.setHint(b(2131239817) + str);
                    this.an.setHint(b(2131239818) + str);
                    break;
                }
                break;
        }
        aB();
    }

    protected final int mo384e() {
        return 2131239814;
    }

    protected final int as() {
        return 2131239819;
    }

    protected final int at() {
        boolean z = false;
        String locale = this.f8861c.a().toString();
        boolean z2 = true;
        switch (locale.hashCode()) {
            case 99625343:
                if (locale.equals("hu_HU")) {
                    z2 = true;
                    break;
                }
                break;
            case 100876622:
                if (locale.equals("ja_JP")) {
                    z2 = true;
                    break;
                }
                break;
            case 102217250:
                if (locale.equals("ko_KR")) {
                    z2 = true;
                    break;
                }
                break;
            case 104034559:
                if (locale.equals("mn_MN")) {
                    z2 = true;
                    break;
                }
                break;
            case 108920447:
                if (locale.equals("rw_RW")) {
                    z2 = true;
                    break;
                }
                break;
            case 110230963:
                if (locale.equals("te_IN")) {
                    z2 = true;
                    break;
                }
                break;
            case 110290882:
                if (locale.equals("tg_TJ")) {
                    z2 = true;
                    break;
                }
                break;
            case 112197572:
                if (locale.equals("vi_VN")) {
                    z2 = true;
                    break;
                }
                break;
            case 115861276:
                if (locale.equals("zh_CN")) {
                    z2 = false;
                    break;
                }
                break;
            case 115861428:
                if (locale.equals("zh_HK")) {
                    z2 = true;
                    break;
                }
                break;
            case 115861812:
                if (locale.equals("zh_TW")) {
                    z2 = true;
                    break;
                }
                break;
        }
        switch (z2) {
            case false:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
                TriState a = this.f8776e.a(21);
                this.f8860b.a("fb4a_reg_name_locale_order", a);
                z = a.asBoolean(false);
                break;
        }
        if (z) {
            return 2130906810;
        }
        return 2130906809;
    }

    protected final void au() {
        if (StringUtil.c(this.f8862d.getText().toString()) || StringUtil.c(this.an.getText().toString())) {
            throw new RegInputException(2131239820);
        }
    }

    protected final void av() {
        this.f8777f.c = this.f8862d.getText().toString();
        this.f8777f.d = this.an.getText().toString();
    }

    protected final RegFragmentState aw() {
        return RegFragmentState.NAME_ACQUIRED;
    }

    protected final RegErrorCategory ax() {
        return RegErrorCategory.NAME;
    }

    private void aB() {
        ImmutableList b = this.f8777f.s().b();
        Collection arrayList = new ArrayList();
        Collection arrayList2 = new ArrayList();
        Collection arrayList3 = new ArrayList();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            FullName fullName = (FullName) b.get(i);
            if (fullName != null) {
                if (!StringUtil.c(fullName.b)) {
                    arrayList.add(fullName.b);
                }
                if (!StringUtil.c(fullName.d)) {
                    arrayList2.add(fullName.d);
                }
                if (!StringUtil.c(fullName.c)) {
                    arrayList3.add(fullName.c);
                }
            }
        }
        this.ao.clear();
        this.ao.addAll(arrayList);
        this.ao.addAll(arrayList2);
        this.ao.addAll(arrayList3);
        if (!this.ao.isEmpty()) {
            this.f8862d.setAdapter(new ArrayAdapter(getContext(), 17367050, this.ao.toArray(new String[0])));
            this.f8862d.setThreshold(1);
            this.an.setAdapter(new ArrayAdapter(getContext(), 17367050, this.ao.toArray(new String[0])));
            this.an.setThreshold(1);
        }
    }

    protected final void aA() {
        String obj = this.f8862d.getText().toString();
        String obj2 = this.an.getText().toString();
        this.f8860b.a(ax().name() + "_first_name", this.ao.indexOf(obj), this.ao.size());
        this.f8860b.a(ax().name() + "_last_name", this.ao.indexOf(obj2), this.ao.size());
    }

    protected final int mz_() {
        TriState a = this.f8776e.a(22);
        this.f8860b.a("fb4a_reg_name_title", a);
        if (a.asBoolean(false)) {
            return 2131239816;
        }
        return 2131239815;
    }
}
