package com.facebook;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: event_args */
public class FacebookActivity extends FragmentActivity {
    public static String f13742p = "PassThrough";
    private static String f13743q = "SingleFragment";
    public Fragment f13744r;

    public void onCreate(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1526783036);
        super.onCreate(bundle);
        setContentView(2130903610);
        Intent intent = getIntent();
        if (f13742p.equals(intent.getAction())) {
            FacebookException facebookException;
            Intent intent2 = getIntent();
            Bundle a2 = NativeProtocol.m25296a(intent2);
            if (a2 == null) {
                facebookException = null;
            } else {
                String string = a2.getString("error_type");
                if (string == null) {
                    string = a2.getString("com.facebook.platform.status.ERROR_TYPE");
                }
                String string2 = a2.getString("error_description");
                if (string2 == null) {
                    string2 = a2.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
                }
                if (string == null || !string.equalsIgnoreCase("UserCanceled")) {
                    facebookException = new FacebookException(string2);
                } else {
                    facebookException = new FacebookOperationCanceledException(string2);
                }
            }
            setResult(0, NativeProtocol.m25295a(intent2, null, facebookException));
            finish();
            Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -309335048, a);
            return;
        }
        FragmentManager kO_ = kO_();
        Fragment a3 = kO_.a(f13743q);
        if (a3 == null) {
            if ("FacebookDialogFragment".equals(intent.getAction())) {
                a3 = new FacebookDialogFragment();
                a3.d(true);
                a3.a(kO_, f13743q);
            } else {
                a3 = new LoginFragment();
                a3.d(true);
                kO_.a().a(2131560410, a3, f13743q).b();
            }
        }
        this.f13744r = a3;
        LogUtils.c(1587592410, a);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f13744r != null) {
            this.f13744r.onConfigurationChanged(configuration);
        }
    }
}
