package com.facebook.widget.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.EditTextPreference;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbPreferenceHelper;
import com.facebook.prefs.shared.FbPreferenceHelperProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.resources.ui.FbButton;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

/* compiled from: com.facebook.phone */
public class OrcaEditTextWithHistoryPreference extends EditTextPreference {
    @Inject
    public FbSharedPreferences f5834a;
    @Inject
    public FbPreferenceHelperProvider f5835b;
    private final FbPreferenceHelper f5836c = this.f5835b.m10079a(this);
    public PrefKey f5837d;
    private int f5838e;

    public static void m10581a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        OrcaEditTextWithHistoryPreference orcaEditTextWithHistoryPreference = (OrcaEditTextWithHistoryPreference) obj;
        FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector);
        FbPreferenceHelperProvider fbPreferenceHelperProvider = (FbPreferenceHelperProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FbPreferenceHelperProvider.class);
        orcaEditTextWithHistoryPreference.f5834a = fbSharedPreferences;
        orcaEditTextWithHistoryPreference.f5835b = fbPreferenceHelperProvider;
    }

    public OrcaEditTextWithHistoryPreference(Context context) {
        super(context);
        Class cls = OrcaEditTextWithHistoryPreference.class;
        m10581a((Object) this, getContext());
        this.f5838e = context.getResources().getDimensionPixelSize(2131427920);
        setDialogLayoutResource(2130906361);
    }

    public SharedPreferences getSharedPreferences() {
        return this.f5836c.f5216b;
    }

    public final void m10583a(PrefKey prefKey) {
        this.f5836c.m10076a(prefKey);
        this.f5837d = (PrefKey) prefKey.a("history");
    }

    protected String getPersistedString(String str) {
        return this.f5836c.m10075a(str);
    }

    protected boolean persistString(String str) {
        List<String> a = m10580a();
        a.add(0, str);
        List a2 = Lists.a();
        for (String str2 : a) {
            if (!a2.contains(str2)) {
                a2.add(str2);
            }
        }
        Iterable iterable = a2;
        if (iterable.size() > 5) {
            iterable = iterable.subList(0, 5);
        }
        this.f5834a.edit().a(this.f5837d, TextUtils.join(",", iterable)).commit();
        return this.f5836c.m10078b(str);
    }

    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);
        ((TextView) view.findViewById(2131559674)).setText(2131231958);
        ViewGroup viewGroup = (LinearLayout) view.findViewById(2131566206);
        for (String a : m10580a()) {
            m10582a(viewGroup, a);
        }
    }

    protected void onAddEditTextToDialogView(View view, EditText editText) {
        ViewGroup viewGroup = (ViewGroup) view.findViewById(2131566205);
        if (viewGroup != null) {
            viewGroup.addView(editText, -1, -2);
        } else {
            super.onAddEditTextToDialogView(view, editText);
        }
    }

    protected void m10582a(ViewGroup viewGroup, final String str) {
        FbButton fbButton = new FbButton(getEditText().getContext(), null, 2130772396);
        fbButton.setText(str);
        fbButton.setGravity(1);
        fbButton.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ OrcaEditTextWithHistoryPreference f5833b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1209206681);
                this.f5833b.getEditText().setText(str);
                Logger.a(2, EntryType.UI_INPUT_END, -1532447198, a);
            }
        });
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, this.f5838e, 0, this.f5838e);
        viewGroup.addView(fbButton, layoutParams);
    }

    private List<String> m10580a() {
        return Lists.a(this.f5834a.a(this.f5837d, "").split("[,]"));
    }
}
