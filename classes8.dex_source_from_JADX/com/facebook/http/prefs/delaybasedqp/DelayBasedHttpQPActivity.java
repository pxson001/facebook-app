package com.facebook.http.prefs.delaybasedqp;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.prefs.InternalHttpPrefKeys;
import com.facebook.http.qe.ExperimentsForHttpQeModule;
import com.facebook.inject.FbInjector;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Preconditions;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* compiled from: edit_call_to_action_key */
public class DelayBasedHttpQPActivity extends FbFragmentActivity {
    @Inject
    FbSharedPreferences f14925p;
    @Inject
    QeAccessor f14926q;

    private static <T extends Context> void m17393a(Class<T> cls, T t) {
        m17394a((Object) t, (Context) t);
    }

    public static void m17394a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((DelayBasedHttpQPActivity) obj).m17392a((FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    public final void m17395b(Bundle bundle) {
        super.b(bundle);
        Class cls = DelayBasedHttpQPActivity.class;
        m17394a((Object) this, (Context) this);
        int a = this.f14926q.a(ExperimentsForHttpQeModule.an, 3600000);
        String string = getIntent().getExtras().getString("enable");
        Preconditions.checkNotNull(string);
        boolean equals = string.equals("enable");
        this.f14925p.edit().putBoolean(InternalHttpPrefKeys.m, equals).commit();
        Toast.makeText(this, equals ? StringFormatUtil.formatStrLocaleSafe("Enabled 2G Empathy for %d minutes", Long.valueOf(TimeUnit.MINUTES.convert((long) a, TimeUnit.MILLISECONDS))) : "Disabled 2G Empathy", 1).show();
        finish();
    }

    private void m17392a(FbSharedPreferences fbSharedPreferences, QeAccessor qeAccessor) {
        this.f14925p = fbSharedPreferences;
        this.f14926q = qeAccessor;
    }
}
