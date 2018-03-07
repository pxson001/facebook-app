package com.facebook.oxygen.preloads.integration.appupdates;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.oxygen.preloads.sdk.firstparty.settings.FirstPartySettings;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: textShadowRadius */
public class AppUpdateSettings {
    public static final String f1057a = AppUpdateSettings.class.getName();
    public final Context f1058b;
    public final FbSharedPreferences f1059c;
    public final AbstractFbErrorReporter f1060d;
    private final ListeningExecutorService f1061e;
    private final ExecutorService f1062f;
    public PrefKey f1063g;
    public PrefKey f1064h;
    private PrefKey f1065i;
    public CheckBoxOrSwitchPreference f1066j;
    private Preference f1067k;
    public Preference f1068l;
    public CheckBoxOrSwitchPreference f1069m;
    public CheckBoxOrSwitchPreference f1070n;
    public FirstPartySettings f1071o;
    private PreferenceScreen f1072p;
    public PreferenceCategory f1073q;
    public boolean f1074r;
    public boolean f1075s;
    private boolean f1076t;
    public String f1077u;

    /* compiled from: textShadowRadius */
    public class AnonymousClass10 implements OnClickListener {
        final /* synthetic */ PrefKey f1037a;
        final /* synthetic */ boolean f1038b;
        final /* synthetic */ CheckBoxOrSwitchPreference f1039c;
        final /* synthetic */ AppUpdateSettings f1040d;

        public AnonymousClass10(AppUpdateSettings appUpdateSettings, PrefKey prefKey, boolean z, CheckBoxOrSwitchPreference checkBoxOrSwitchPreference) {
            this.f1040d = appUpdateSettings;
            this.f1037a = prefKey;
            this.f1038b = z;
            this.f1039c = checkBoxOrSwitchPreference;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f1040d.m1396a(this.f1037a, this.f1038b, this.f1039c);
            dialogInterface.dismiss();
        }
    }

    /* compiled from: textShadowRadius */
    public class AnonymousClass11 implements OnClickListener {
        final /* synthetic */ CheckBoxOrSwitchPreference f1041a;
        final /* synthetic */ boolean f1042b;
        final /* synthetic */ PrefKey f1043c;
        final /* synthetic */ AppUpdateSettings f1044d;

        public AnonymousClass11(AppUpdateSettings appUpdateSettings, CheckBoxOrSwitchPreference checkBoxOrSwitchPreference, boolean z, PrefKey prefKey) {
            this.f1044d = appUpdateSettings;
            this.f1041a = checkBoxOrSwitchPreference;
            this.f1042b = z;
            this.f1043c = prefKey;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            boolean z = true;
            if (this.f1041a != null) {
                this.f1041a.setChecked(!this.f1042b);
                if (this.f1041a.getKey().equals(this.f1044d.f1063g.a())) {
                    AppUpdateSettings.m1400b(this.f1044d, this.f1042b);
                }
            }
            Editor edit = this.f1044d.f1059c.edit();
            PrefKey prefKey = this.f1043c;
            if (this.f1042b) {
                z = false;
            }
            edit.putBoolean(prefKey, z).commit();
            dialogInterface.dismiss();
        }
    }

    /* compiled from: textShadowRadius */
    public class C01481 implements OnPreferenceChangeListener {
        final /* synthetic */ AppUpdateSettings f1045a;

        public C01481(AppUpdateSettings appUpdateSettings) {
            this.f1045a = appUpdateSettings;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            if (((Boolean) obj).booleanValue()) {
                AppUpdateSettings.m1395a(this.f1045a, true);
            } else {
                AppUpdateSettings appUpdateSettings = this.f1045a;
                FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(appUpdateSettings.f1058b);
                fbAlertDialogBuilder.a(2131241727);
                fbAlertDialogBuilder.b(2131241728);
                fbAlertDialogBuilder.a(2131241729, new C01492(appUpdateSettings));
                fbAlertDialogBuilder.b(17039360, new C01503(appUpdateSettings));
                fbAlertDialogBuilder.a(false);
                fbAlertDialogBuilder.a().show();
            }
            return false;
        }
    }

    /* compiled from: textShadowRadius */
    public class C01492 implements OnClickListener {
        final /* synthetic */ AppUpdateSettings f1046a;

        public C01492(AppUpdateSettings appUpdateSettings) {
            this.f1046a = appUpdateSettings;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            AppUpdateSettings.m1395a(this.f1046a, false);
        }
    }

    /* compiled from: textShadowRadius */
    public class C01503 implements OnClickListener {
        final /* synthetic */ AppUpdateSettings f1047a;

        public C01503(AppUpdateSettings appUpdateSettings) {
            this.f1047a = appUpdateSettings;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: textShadowRadius */
    public class C01514 implements OnPreferenceChangeListener {
        final /* synthetic */ AppUpdateSettings f1048a;

        public C01514(AppUpdateSettings appUpdateSettings) {
            this.f1048a = appUpdateSettings;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            if (((Boolean) obj).booleanValue()) {
                AppUpdateSettings.m1401b(this.f1048a, true, this.f1048a.f1069m);
                this.f1048a.f1069m.setChecked(true);
                return false;
            }
            AppUpdateSettings appUpdateSettings = this.f1048a;
            boolean z = false;
            if (appUpdateSettings.f1071o.f1096d) {
                AppUpdateSettings.m1401b(appUpdateSettings, false, appUpdateSettings.f1069m);
                z = true;
            } else {
                FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(appUpdateSettings.f1058b);
                fbAlertDialogBuilder.a(2131241736);
                fbAlertDialogBuilder.b(appUpdateSettings.f1058b.getString(2131241737, new Object[]{appUpdateSettings.f1077u}));
                fbAlertDialogBuilder.a(2131241729, new C01525(appUpdateSettings));
                fbAlertDialogBuilder.b(17039360, new C01536(appUpdateSettings));
                fbAlertDialogBuilder.a(false);
                fbAlertDialogBuilder.a().show();
            }
            return z;
        }
    }

    /* compiled from: textShadowRadius */
    public class C01525 implements OnClickListener {
        final /* synthetic */ AppUpdateSettings f1049a;

        public C01525(AppUpdateSettings appUpdateSettings) {
            this.f1049a = appUpdateSettings;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            AppUpdateSettings.m1401b(this.f1049a, false, this.f1049a.f1069m);
            this.f1049a.f1069m.setChecked(false);
        }
    }

    /* compiled from: textShadowRadius */
    public class C01536 implements OnClickListener {
        final /* synthetic */ AppUpdateSettings f1050a;

        public C01536(AppUpdateSettings appUpdateSettings) {
            this.f1050a = appUpdateSettings;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: textShadowRadius */
    class C01547 implements OnPreferenceChangeListener {
        final /* synthetic */ AppUpdateSettings f1051a;

        C01547(AppUpdateSettings appUpdateSettings) {
            this.f1051a = appUpdateSettings;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            if (((Boolean) obj).booleanValue()) {
                AppUpdateSettings.m1404c(this.f1051a, true, this.f1051a.f1070n);
            } else {
                AppUpdateSettings.m1404c(this.f1051a, false, this.f1051a.f1070n);
            }
            return true;
        }
    }

    /* compiled from: textShadowRadius */
    class C01558 implements Runnable {
        final /* synthetic */ AppUpdateSettings f1052a;

        C01558(AppUpdateSettings appUpdateSettings) {
            this.f1052a = appUpdateSettings;
        }

        public void run() {
            this.f1052a.f1071o.m1427b(this.f1052a.f1058b);
        }
    }

    @Inject
    public AppUpdateSettings(Context context, FbSharedPreferences fbSharedPreferences, AbstractFbErrorReporter abstractFbErrorReporter, ListeningExecutorService listeningExecutorService, ExecutorService executorService) {
        this.f1058b = context;
        this.f1059c = fbSharedPreferences;
        this.f1060d = abstractFbErrorReporter;
        this.f1061e = listeningExecutorService;
        this.f1062f = executorService;
    }

    public final void m1407a(@Nullable FirstPartySettings firstPartySettings, PreferenceScreen preferenceScreen, PrefKey prefKey, PrefKey prefKey2, PrefKey prefKey3) {
        this.f1071o = firstPartySettings;
        this.f1072p = preferenceScreen;
        this.f1063g = prefKey;
        this.f1064h = prefKey2;
        this.f1065i = prefKey3;
        this.f1077u = this.f1058b.getString(this.f1058b.getApplicationInfo().labelRes);
        if (firstPartySettings != null) {
            m1406h();
        }
        PreferenceScreen preferenceScreen2 = this.f1072p;
        this.f1066j = new CheckBoxOrSwitchPreference(this.f1058b);
        this.f1066j.setTitle(this.f1058b.getString(2131241725, new Object[]{this.f1077u}));
        this.f1066j.setKey(this.f1063g.a());
        this.f1066j.setSummary(this.f1058b.getString(2131241726, new Object[]{this.f1077u}));
        this.f1066j.setDefaultValue(Boolean.valueOf(this.f1074r));
        this.f1066j.setOrder(2);
        this.f1066j.setOnPreferenceChangeListener(new C01481(this));
        preferenceScreen2.addPreference(this.f1066j);
        m1403c(this.f1072p);
        m1402c();
        m1398b(this.f1072p);
    }

    private void m1397a(boolean z, CheckBoxOrSwitchPreference checkBoxOrSwitchPreference) {
        this.f1059c.edit().putBoolean(this.f1063g, z).commit();
        this.f1071o.f1096d = z;
        m1396a(this.f1063g, z, checkBoxOrSwitchPreference);
    }

    public static void m1395a(AppUpdateSettings appUpdateSettings, boolean z) {
        appUpdateSettings.m1397a(z, appUpdateSettings.f1066j);
        m1400b(appUpdateSettings, !z);
        appUpdateSettings.f1066j.setChecked(z);
    }

    public static void m1400b(AppUpdateSettings appUpdateSettings, boolean z) {
        if (appUpdateSettings.f1067k == null) {
            appUpdateSettings.m1402c();
        }
        if (z) {
            appUpdateSettings.f1072p.addPreference(appUpdateSettings.f1067k);
        } else {
            appUpdateSettings.f1072p.removePreference(appUpdateSettings.f1067k);
        }
    }

    private void m1402c() {
        boolean z = true;
        this.f1067k = new Preference(this.f1058b);
        this.f1067k.setSelectable(false);
        this.f1067k.setLayoutResource(2130906331);
        this.f1067k.setShouldDisableView(true);
        this.f1067k.setSummary(2131241730);
        this.f1067k.setOrder(4);
        if (this.f1074r) {
            z = false;
        }
        m1400b(this, z);
    }

    private void m1398b(PreferenceScreen preferenceScreen) {
        this.f1073q = new PreferenceCategory(this.f1058b);
        this.f1073q.setTitle(2131241731);
        this.f1073q.setOrder(5);
        preferenceScreen.addPreference(this.f1073q);
        this.f1069m = new CheckBoxOrSwitchPreference(this.f1058b);
        this.f1069m.setKey(this.f1064h.a());
        this.f1069m.setTitle(this.f1058b.getString(2131241732, new Object[]{this.f1077u}));
        this.f1069m.setSummary(2131241733);
        this.f1069m.setDefaultValue(Boolean.valueOf(this.f1075s));
        this.f1069m.setOnPreferenceChangeListener(new C01514(this));
        this.f1073q.addPreference(this.f1069m);
        m1405g();
    }

    public static void m1401b(AppUpdateSettings appUpdateSettings, boolean z, CheckBoxOrSwitchPreference checkBoxOrSwitchPreference) {
        appUpdateSettings.f1059c.edit().putBoolean(appUpdateSettings.f1064h, z).commit();
        appUpdateSettings.f1071o.f1097e = z;
        appUpdateSettings.m1396a(appUpdateSettings.f1064h, z, checkBoxOrSwitchPreference);
    }

    private void m1405g() {
        this.f1070n = new CheckBoxOrSwitchPreference(this.f1058b);
        this.f1070n.setKey(this.f1065i.a());
        this.f1070n.setTitle(this.f1058b.getString(2131241734, new Object[]{this.f1077u}));
        this.f1070n.setSummary(this.f1058b.getString(2131241735, new Object[]{this.f1077u}));
        this.f1070n.setDefaultValue(Boolean.valueOf(this.f1076t));
        this.f1070n.setOnPreferenceChangeListener(new C01547(this));
        this.f1073q.addPreference(this.f1070n);
    }

    public static void m1404c(AppUpdateSettings appUpdateSettings, boolean z, CheckBoxOrSwitchPreference checkBoxOrSwitchPreference) {
        appUpdateSettings.f1059c.edit().putBoolean(appUpdateSettings.f1065i, z).commit();
        appUpdateSettings.f1071o.f1098f = z;
        appUpdateSettings.m1396a(appUpdateSettings.f1065i, z, checkBoxOrSwitchPreference);
    }

    private void m1406h() {
        this.f1074r = this.f1059c.a(this.f1063g, true);
        if (this.f1071o.f1096d != this.f1074r) {
            this.f1071o.f1096d = this.f1074r;
            m1396a(this.f1063g, this.f1074r, null);
        }
        this.f1075s = this.f1059c.a(this.f1064h, true);
        if (this.f1071o.f1097e != this.f1075s) {
            this.f1071o.f1097e = this.f1075s;
            m1396a(this.f1064h, this.f1075s, null);
        }
        this.f1076t = this.f1059c.a(this.f1065i, true);
        if (this.f1071o.f1098f != this.f1076t) {
            this.f1071o.f1098f = this.f1076t;
            m1396a(this.f1065i, this.f1076t, null);
        }
    }

    private void m1396a(final PrefKey prefKey, final boolean z, @Nullable final CheckBoxOrSwitchPreference checkBoxOrSwitchPreference) {
        Futures.a(this.f1061e.a(new C01558(this)), new FutureCallback<Object>(this) {
            final /* synthetic */ AppUpdateSettings f1056d;

            public void onSuccess(@Nullable Object obj) {
                AppUpdateSettings.class.getSimpleName();
                prefKey.a();
                Boolean.toString(z);
            }

            public void onFailure(Throwable th) {
                if (checkBoxOrSwitchPreference != null) {
                    AppUpdateSettings appUpdateSettings = this.f1056d;
                    PrefKey prefKey = prefKey;
                    boolean z = z;
                    CheckBoxOrSwitchPreference checkBoxOrSwitchPreference = checkBoxOrSwitchPreference;
                    FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(appUpdateSettings.f1058b);
                    fbAlertDialogBuilder.a(2131241722);
                    fbAlertDialogBuilder.b(2131241723);
                    fbAlertDialogBuilder.a(2131241724, new AnonymousClass10(appUpdateSettings, prefKey, z, checkBoxOrSwitchPreference));
                    fbAlertDialogBuilder.b(17039360, new AnonymousClass11(appUpdateSettings, checkBoxOrSwitchPreference, z, prefKey));
                    fbAlertDialogBuilder.a(false);
                    fbAlertDialogBuilder.a().show();
                }
                this.f1056d.f1060d.a(AppUpdateSettings.f1057a, "Failed to persist setting:" + prefKey.toString(), th);
            }
        }, this.f1062f);
    }

    private void m1403c(PreferenceScreen preferenceScreen) {
        Preference preference = new Preference(this.f1058b);
        preference.setLayoutResource(2130903928);
        preference.setSelectable(false);
        preference.setOrder(3);
        preferenceScreen.addPreference(preference);
    }
}
