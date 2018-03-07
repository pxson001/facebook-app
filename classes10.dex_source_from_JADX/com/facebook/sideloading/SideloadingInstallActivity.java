package com.facebook.sideloading;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.file.StatFsHelperMethodAutoProvider;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.google.common.collect.ImmutableBiMap;
import java.io.File;
import javax.inject.Inject;

/* compiled from: has_clicked_on_cover_photo_fb_album */
public class SideloadingInstallActivity extends FbFragmentActivity {
    private static final Class<?> f10033t = SideloadingInstallActivity.class;
    @Inject
    SecureContextHelper f10034p;
    @Inject
    StatFsHelper f10035q;
    @Inject
    FbSharedPreferences f10036r;
    @Inject
    SideloadingLogger f10037s;

    private static <T extends Context> void m10123a(Class<T> cls, T t) {
        m10124a((Object) t, (Context) t);
    }

    public static void m10124a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((SideloadingInstallActivity) obj).m10122a((SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), StatFsHelperMethodAutoProvider.a(fbInjector), (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), SideloadingLogger.m10126b(fbInjector));
    }

    public final void m10125b(Bundle bundle) {
        super.b(bundle);
        Class cls = SideloadingInstallActivity.class;
        m10124a((Object) this, (Context) this);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("local_uri");
        String stringExtra2 = intent.getStringExtra("package_name");
        String stringExtra3 = intent.getStringExtra("triggered_from");
        if (this.f10035q.a(StorageType.INTERNAL) < this.f10036r.a(SideloadingPrefKeys.m10160e(stringExtra2), 31457280) * 2) {
            finish();
            return;
        }
        Uri parse = Uri.parse(stringExtra);
        if (parse.getScheme() == null) {
            parse = Uri.fromFile(new File(stringExtra));
        }
        m10121a(parse, (Activity) this);
        this.f10037s.m10128a("sideloading_show_android_installer", ImmutableBiMap.b("triggered_from", stringExtra3));
        finish();
    }

    private void m10122a(SecureContextHelper secureContextHelper, StatFsHelper statFsHelper, FbSharedPreferences fbSharedPreferences, SideloadingLogger sideloadingLogger) {
        this.f10034p = secureContextHelper;
        this.f10035q = statFsHelper;
        this.f10036r = fbSharedPreferences;
        this.f10037s = sideloadingLogger;
    }

    private void m10121a(Uri uri, Activity activity) {
        Intent a = m10120a(uri);
        a.setAction("android.intent.action.VIEW");
        a.setFlags(268435456);
        this.f10034p.b(a, activity);
    }

    private static Intent m10120a(Uri uri) {
        Intent intent = new Intent();
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        return intent;
    }
}
