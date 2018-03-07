package com.facebook.abtest.gkprefs;

import android.content.Context;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.facebook.base.activity.FbPreferenceActivity;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.gk.GatekeeperStoreConfigMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.sessionless.GatekeeperStoreConfig_SessionlessMethodAutoProvider;
import com.facebook.gk.sessionless.GatekeeperStoreImpl_SessionlessMethodAutoProvider;
import com.facebook.gk.sessionless.Sessionless;
import com.facebook.gk.store.GatekeeperStoreConfig;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.gk.store.GatekeeperWriter;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.widget.prefs.OrcaEditTextPreference;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: treehouse_discover_search */
public class GkSettingsListActivity extends FbPreferenceActivity {
    private static final PrefKey f1686h = ((PrefKey) SharedPrefKeys.c.a("gk_editor_history_v2/"));
    @Inject
    FbSharedPreferences f1687a;
    @Inject
    GatekeeperStoreImpl f1688b;
    @Inject
    @Sessionless
    GatekeeperStoreImpl f1689c;
    @Inject
    GatekeeperStoreConfig f1690d;
    @Inject
    @Sessionless
    GatekeeperStoreConfig f1691e;
    @Inject
    GatekeeperWriter f1692f;
    @Inject
    @Sessionless
    GatekeeperWriter f1693g;
    public String f1694i;
    private List<String> f1695j;

    /* compiled from: treehouse_discover_search */
    class C00961 implements OnPreferenceClickListener {
        final /* synthetic */ GkSettingsListActivity f1671a;

        C00961(GkSettingsListActivity gkSettingsListActivity) {
            this.f1671a = gkSettingsListActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f1671a.f1692f.e().b().a(true);
            this.f1671a.f1693g.e().b().a(true);
            this.f1671a.m2277a();
            return true;
        }
    }

    /* compiled from: treehouse_discover_search */
    class C00983 implements OnPreferenceChangeListener {
        final /* synthetic */ GkSettingsListActivity f1674a;

        C00983(GkSettingsListActivity gkSettingsListActivity) {
            this.f1674a = gkSettingsListActivity;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            if (((String) obj).length() > 3) {
                this.f1674a.f1694i = (String) obj;
                this.f1674a.m2277a();
            } else {
                Toast.makeText(this.f1674a.getApplicationContext(), "Query must be > 3 char long.", 0).show();
            }
            return false;
        }
    }

    private static <T extends Context> void m2281a(Class<T> cls, T t) {
        m2282a((Object) t, (Context) t);
    }

    public static void m2282a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GkSettingsListActivity) obj).m2280a((FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), GatekeeperStoreImplMethodAutoProvider.a(fbInjector), GatekeeperStoreImpl_SessionlessMethodAutoProvider.a(fbInjector), GatekeeperStoreConfigMethodAutoProvider.a(fbInjector), GatekeeperStoreConfig_SessionlessMethodAutoProvider.a(fbInjector), (GatekeeperWriter) GatekeeperStoreImplMethodAutoProvider.a(fbInjector), (GatekeeperWriter) GatekeeperStoreImpl_SessionlessMethodAutoProvider.a(fbInjector));
    }

    private void m2280a(FbSharedPreferences fbSharedPreferences, GatekeeperStoreImpl gatekeeperStoreImpl, GatekeeperStoreImpl gatekeeperStoreImpl2, GatekeeperStoreConfig gatekeeperStoreConfig, GatekeeperStoreConfig gatekeeperStoreConfig2, GatekeeperWriter gatekeeperWriter, GatekeeperWriter gatekeeperWriter2) {
        this.f1687a = fbSharedPreferences;
        this.f1688b = gatekeeperStoreImpl;
        this.f1689c = gatekeeperStoreImpl2;
        this.f1690d = gatekeeperStoreConfig;
        this.f1691e = gatekeeperStoreConfig2;
        this.f1692f = gatekeeperWriter;
        this.f1693g = gatekeeperWriter2;
    }

    protected final void mo472c(Bundle bundle) {
        super.mo472c(bundle);
        Class cls = GkSettingsListActivity.class;
        m2282a((Object) this, (Context) this);
        this.f1694i = "";
        this.f1695j = Lists.a();
        m2285d();
        m2277a();
    }

    protected void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1627443824);
        m2286e();
        super.onStop();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 2030504272, a);
    }

    private void m2277a() {
        Preference preferenceCategory;
        String str;
        PreferenceScreen createPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
        createPreferenceScreen.addPreference(m2283b());
        if (this.f1694i.length() > 3) {
            int i;
            preferenceCategory = new PreferenceCategory(this);
            preferenceCategory.setTitle(this.f1694i);
            createPreferenceScreen.addPreference(preferenceCategory);
            ArrayList b = this.f1690d.b();
            int size = b.size();
            for (i = 0; i < size; i++) {
                str = (String) b.get(i);
                if (str.contains(this.f1694i)) {
                    createPreferenceScreen.addPreference(m2275a(str, false));
                }
            }
            b = this.f1691e.b();
            size = b.size();
            for (i = 0; i < size; i++) {
                str = (String) b.get(i);
                if (str.contains(this.f1694i)) {
                    createPreferenceScreen.addPreference(m2275a(str, true));
                }
            }
        }
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Recently Edited: ");
        createPreferenceScreen.addPreference(preferenceCategory);
        for (String str2 : this.f1695j) {
            boolean z;
            String[] split = str2.split(":");
            String str3 = split[0];
            if (split[1].equals("1")) {
                z = true;
            } else {
                z = false;
            }
            createPreferenceScreen.addPreference(m2275a(str3, z));
        }
        preferenceCategory = new Preference(this);
        preferenceCategory.setTitle("Clear");
        preferenceCategory.setOnPreferenceClickListener(new C00961(this));
        createPreferenceScreen.addPreference(preferenceCategory);
        setPreferenceScreen(createPreferenceScreen);
    }

    private Preference m2283b() {
        final Preference orcaEditTextPreference = new OrcaEditTextPreference(this);
        orcaEditTextPreference.setText(this.f1694i);
        orcaEditTextPreference.setTitle("Search Gatekeepers");
        if (this.f1694i.length() > 3) {
            orcaEditTextPreference.setSummary(this.f1694i);
        } else {
            orcaEditTextPreference.setSummary("press to start searching");
        }
        EditText editText = orcaEditTextPreference.getEditText();
        editText.setSelectAllOnFocus(true);
        editText.setSingleLine();
        editText.setImeOptions(3);
        editText.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ GkSettingsListActivity f1673b;

            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                Object dialog = orcaEditTextPreference.getDialog();
                orcaEditTextPreference.onClick(dialog, -1);
                dialog.dismiss();
                return true;
            }
        });
        orcaEditTextPreference.setOnPreferenceChangeListener(new C00983(this));
        return orcaEditTextPreference;
    }

    private Preference m2275a(String str, boolean z) {
        Preference preference = new Preference(this);
        final GatekeeperStoreImpl gatekeeperStoreImpl = z ? this.f1689c : this.f1688b;
        final GatekeeperWriter gatekeeperWriter = z ? this.f1693g : this.f1692f;
        final String str2 = str;
        final boolean z2 = z;
        preference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ GkSettingsListActivity f1679e;

            public boolean onPreferenceClick(Preference preference) {
                gatekeeperWriter.e().a(str2, !gatekeeperStoreImpl.a(str2).asBoolean(false)).a(true);
                Toast.makeText(this.f1679e.getApplicationContext(), StringFormatUtil.a("%1$s has been updated to %2$s", new Object[]{str2, Boolean.toString(r0)}), 0).show();
                GkSettingsListActivity.m2284b(this.f1679e, str2, z2);
                preference.setSummary(gatekeeperStoreImpl.a(str2).toString());
                return false;
            }
        });
        preference.setTitle(str + (z ? " (sessionless)" : ""));
        preference.setSummary(gatekeeperStoreImpl.a(str).toString());
        return preference;
    }

    private void m2285d() {
        Set<PrefKey> d = this.f1687a.d(f1686h);
        List<String> a = Lists.a();
        for (PrefKey b : d) {
            a.add(b.b(f1686h));
        }
        Collections.sort(a);
        for (String str : a) {
            boolean z;
            String[] split = this.f1687a.a((PrefKey) f1686h.a(str), "").split(":");
            String str2 = split[0];
            if (split[1].equals("1")) {
                z = true;
            } else {
                z = false;
            }
            m2284b(this, str2, z);
            this.f1687a.edit().a((PrefKey) f1686h.a(str)).commit();
        }
    }

    public static void m2284b(GkSettingsListActivity gkSettingsListActivity, String str, boolean z) {
        if ((z ? gkSettingsListActivity.f1689c : gkSettingsListActivity.f1688b).b(str)) {
            String str2 = str + (z ? ":1" : ":0");
            for (String equals : gkSettingsListActivity.f1695j) {
                if (equals.equals(str2)) {
                    return;
                }
            }
            gkSettingsListActivity.f1695j.add(0, str2);
            while (gkSettingsListActivity.f1695j.size() > 10) {
                gkSettingsListActivity.f1695j.remove(gkSettingsListActivity.f1695j.size() - 1);
            }
        }
    }

    private void m2286e() {
        for (int i = 0; i < this.f1695j.size(); i++) {
            this.f1687a.edit().a((PrefKey) f1686h.a(Integer.toString(i)), (String) this.f1695j.get(i)).commit();
        }
    }
}
