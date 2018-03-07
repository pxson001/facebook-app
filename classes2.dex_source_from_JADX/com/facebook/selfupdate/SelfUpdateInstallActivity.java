package com.facebook.selfupdate;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.common.file.StatFsHelperMethodAutoProvider;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableBiMap;
import java.io.File;
import java.net.URI;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: query_function */
public class SelfUpdateInstallActivity extends FbFragmentActivity {
    private View f8434A;
    public String f8435B;
    @Inject
    SelfUpdateLogger f8436p;
    @Inject
    SelfUpdateNotifier f8437q;
    @Inject
    SelfUpdateChecker f8438r;
    @Inject
    FbSharedPreferences f8439s;
    @Inject
    StatFsHelper f8440t;
    @DefaultExecutorService
    @Inject
    ExecutorService f8441u;
    @Inject
    AppVersionInfo f8442v;
    @Inject
    MoreFileUtils f8443w;
    @Inject
    SecureContextHelper f8444x;
    @Inject
    ObjectMapper f8445y;
    private boolean f8446z;

    private static <T extends Context> void m12987a(Class<T> cls, T t) {
        m12988a((Object) t, (Context) t);
    }

    private static void m12988a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((SelfUpdateInstallActivity) obj).m12986a(SelfUpdateLogger.m12754b(injectorLike), SelfUpdateNotifier.a(injectorLike), SelfUpdateChecker.m12685b(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), StatFsHelperMethodAutoProvider.m2307a(injectorLike), C0055x2995691a.m1881a(injectorLike), AppVersionInfoMethodAutoProvider.m2629a(injectorLike), MoreFileUtils.m5023a(injectorLike), DefaultSecureContextHelper.m4636a(injectorLike), FbObjectMapperMethodAutoProvider.m6609a(injectorLike));
    }

    private void m12986a(SelfUpdateLogger selfUpdateLogger, SelfUpdateNotifier selfUpdateNotifier, SelfUpdateChecker selfUpdateChecker, FbSharedPreferences fbSharedPreferences, StatFsHelper statFsHelper, ExecutorService executorService, AppVersionInfo appVersionInfo, MoreFileUtils moreFileUtils, SecureContextHelper secureContextHelper, ObjectMapper objectMapper) {
        this.f8436p = selfUpdateLogger;
        this.f8437q = selfUpdateNotifier;
        this.f8438r = selfUpdateChecker;
        this.f8439s = fbSharedPreferences;
        this.f8440t = statFsHelper;
        this.f8441u = executorService;
        this.f8442v = appVersionInfo;
        this.f8443w = moreFileUtils;
        this.f8444x = secureContextHelper;
        this.f8445y = objectMapper;
    }

    public final void mo790b(Bundle bundle) {
        super.mo790b(bundle);
        m12987a(SelfUpdateInstallActivity.class, (Context) this);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("local_uri");
        this.f8435B = this.f8439s.mo278a(SelfUpdateConstants.f8183r, "");
        if (this.f8437q.a(stringExtra)) {
            long a = this.f8440t.m2314a(StorageType.INTERNAL);
            long a2 = this.f8439s.mo277a(SelfUpdateConstants.f8182q, 31457280);
            if (a < 2 * a2) {
                this.f8436p.m12755a("Not enough free space in internal storage for installation");
                ObjectNode e = this.f8445y.m6668e();
                e.m5130a("free_space", a);
                e.m5130a("file_size", a2);
                m12989a("not_enough_space", e);
                finish();
                return;
            }
            Object obj;
            Object obj2;
            setContentView(2130904937);
            String stringExtra2 = intent.getStringExtra("app_name");
            if (stringExtra2 == null) {
                obj = "";
            } else {
                String str = stringExtra2;
            }
            stringExtra2 = "2.3";
            PackageInfo b = m12990b(stringExtra);
            if (b != null) {
                obj2 = b.versionName;
            } else {
                String str2 = stringExtra2;
            }
            ((TextView) findViewById(2131558927)).setText(StringFormatUtil.a(getString(2131236749), new Object[]{obj}));
            ((TextView) findViewById(2131558966)).setText(StringFormatUtil.a(getString(2131236750), new Object[]{obj}));
            try {
                ((ImageView) mo2563a(2131559621)).setImageDrawable(getPackageManager().getApplicationIcon(getPackageName()));
            } catch (NameNotFoundException e2) {
            }
            ((TextView) findViewById(2131563219)).setText(StringFormatUtil.a(getString(2131236751), new Object[]{obj2}));
            CharSequence stringExtra3 = getIntent().getStringExtra("release_notes");
            if (StringUtil.m3599c(stringExtra3)) {
                stringExtra3 = getString(2131236753);
            }
            TextView textView = (TextView) findViewById(2131563220);
            textView.setText(StringFormatUtil.a(getString(2131236752), new Object[]{stringExtra3}));
            m12985a(textView);
            findViewById(2131563223).setOnClickListener(new 1(this, stringExtra));
            this.f8434A = findViewById(2131563222);
            this.f8434A.setOnClickListener(new 2(this));
            this.f8436p.m12757a("selfupdate_install_activity_shows", ImmutableBiMap.m978b("source", this.f8435B));
            return;
        }
        this.f8436p.m12755a("File doesn't exist for SelfUpdateInstallActivity");
        e = this.f8445y.m6668e();
        e.m5137a("local_file", stringExtra);
        m12989a("invalid_file", e);
        finish();
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1082622198);
        super.onResume();
        m12991i();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -2084335343, a);
    }

    public void onBackPressed() {
        this.f8436p.m12757a("selfupdate_back_button", ImmutableBiMap.m978b("source", this.f8435B));
        if (!this.f8446z || VERSION.SDK_INT >= 11) {
            if (!this.f8446z) {
                m12989a("back_pressed", null);
            }
            super.onBackPressed();
            return;
        }
        m12993k();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 4) {
            if (i2 != -1) {
                this.f8436p.m12757a("selfupdate_installation_result_failure", ImmutableBiMap.m978b("result_code", Integer.toString(i2)));
                m12989a("installation_failure", null);
                Toast.makeText(getApplicationContext(), 2131236760, 1).show();
            }
            finish();
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    private void m12989a(String str, @Nullable ObjectNode objectNode) {
        this.f8437q.c();
        ExecutorDetour.a(this.f8441u, new 3(this, str, objectNode), 112869417);
    }

    private void m12991i() {
        this.f8446z = getIntent().getBooleanExtra("no_cancel", false);
        if (this.f8446z && (!this.f8438r.m12689d() || m12992j())) {
            this.f8446z = false;
        }
        if (this.f8434A == null) {
            return;
        }
        if (this.f8446z) {
            this.f8434A.setVisibility(8);
        } else {
            this.f8434A.setVisibility(0);
        }
    }

    private boolean m12992j() {
        return this.f8442v.m2713d();
    }

    private PackageInfo m12990b(String str) {
        try {
            File a;
            URI uri = new URI(str);
            if (uri.isAbsolute()) {
                a = MoreFileUtils.m5027a(uri);
            } else {
                a = MoreFileUtils.m5026a(str);
            }
            return getPackageManager().getPackageArchiveInfo(a.getAbsolutePath(), 0);
        } catch (Exception e) {
            getClass();
            new StringBuilder("Invalid file: ").append(str);
            return null;
        }
    }

    private void m12993k() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(268435456);
        this.f8444x.mo665b(intent, getApplicationContext());
    }

    private void m12985a(TextView textView) {
        if (this.f8439s.mo286a(SelfUpdateConstants.f8185t, false)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FOR DEBUG ONLY:\n");
            stringBuilder.append("Source: ").append(this.f8439s.mo278a(SelfUpdateConstants.f8183r, "fql")).append("\n");
            stringBuilder.append("File Size: ").append(Long.valueOf(Long.valueOf(this.f8439s.mo277a(SelfUpdateConstants.f8182q, 0)).longValue() / 1048576)).append(" MB \n");
            stringBuilder.append("URL: ").append(this.f8439s.mo278a(SelfUpdateConstants.f8170e, null)).append("\n");
            stringBuilder.append("Local File: ").append(this.f8439s.mo278a(SelfUpdateConstants.f8173h, null)).append("\n");
            stringBuilder.append("Mime Type: ").append(this.f8439s.mo278a(SelfUpdateConstants.f8181p, null)).append("\n");
            textView.setText(stringBuilder.toString());
        }
    }
}
