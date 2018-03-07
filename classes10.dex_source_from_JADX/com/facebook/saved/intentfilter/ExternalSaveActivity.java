package com.facebook.saved.intentfilter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Toast;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.katana.dbl.FbAndroidAuthActivityUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.saved.common.protocol.UpdateSavedStateUtils;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.regex.Matcher;
import javax.inject.Inject;

/* compiled from: invalidation_report_url */
public class ExternalSaveActivity extends FbFragmentActivity implements IAuthNotRequired {
    @Inject
    public UpdateSavedStateUtils f9180p;
    @Inject
    public LoggedInUserSessionManager f9181q;
    @Inject
    public FbAndroidAuthActivityUtil f9182r;
    private boolean f9183s;

    private static <T extends Context> void m9191a(Class<T> cls, T t) {
        m9192a((Object) t, (Context) t);
    }

    public static void m9192a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ExternalSaveActivity externalSaveActivity = (ExternalSaveActivity) obj;
        UpdateSavedStateUtils a = UpdateSavedStateUtils.a(fbInjector);
        LoggedInUserSessionManager a2 = LoggedInUserSessionManager.a(fbInjector);
        FbAndroidAuthActivityUtil b = FbAndroidAuthActivityUtil.b(fbInjector);
        externalSaveActivity.f9180p = a;
        externalSaveActivity.f9181q = a2;
        externalSaveActivity.f9182r = b;
    }

    protected final void m9195b(Bundle bundle) {
        super.b(bundle);
        Class cls = ExternalSaveActivity.class;
        m9192a((Object) this, (Context) this);
        if (bundle != null) {
            this.f9183s = bundle.getBoolean("has_launched_login", false);
        }
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1802990407);
        super.onResume();
        if (this.f9181q.b()) {
            Intent intent = getIntent();
            final Context applicationContext = getApplicationContext();
            if (intent == null) {
                m9194b(applicationContext);
                finish();
                LogUtils.c(-1403992204, a);
                return;
            }
            String b = m9193b(intent.getStringExtra("android.intent.extra.TEXT"));
            if (b == null) {
                m9194b(applicationContext);
                finish();
                LogUtils.c(1041624961, a);
                return;
            }
            Toast.makeText(applicationContext, 2131232734, 0).show();
            this.f9180p.e(b, CurationSurface.NATIVE_SHARE_EXTENSION, CurationMechanism.SAVED_ADD, new OperationResultFutureCallback(this) {
                final /* synthetic */ ExternalSaveActivity f9179b;

                protected final void m9188a(ServiceException serviceException) {
                    ExternalSaveActivity.m9194b(applicationContext);
                }
            });
            finish();
            LogUtils.c(-1512665959, a);
            return;
        }
        if (!this.f9183s) {
            this.f9183s = true;
            this.f9182r.a(this, false);
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -432121707, a);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("has_launched_login", this.f9183s);
    }

    private static String m9193b(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = Patterns.WEB_URL.matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    public static void m9194b(Context context) {
        Toast.makeText(context, 2131232733, 0).show();
    }
}
