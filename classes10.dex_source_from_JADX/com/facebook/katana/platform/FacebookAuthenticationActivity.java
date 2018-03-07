package com.facebook.katana.platform;

import android.accounts.AccountAuthenticatorResponse;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.katana.login.ComponentName_LoginActivityComponentMethodAutoProvider;
import com.facebook.katana.login.LoginActivityComponent;
import javax.inject.Inject;

/* compiled from: unarchive */
public class FacebookAuthenticationActivity extends FbFragmentActivity implements IAuthNotRequired {
    @Inject
    public SecureContextHelper f1057p;
    @LoginActivityComponent
    @Inject
    public ComponentName f1058q;
    @Inject
    public AbstractFbErrorReporter f1059r;

    private static <T extends Context> void m1087a(Class<T> cls, T t) {
        m1088a((Object) t, (Context) t);
    }

    public static void m1088a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        FacebookAuthenticationActivity facebookAuthenticationActivity = (FacebookAuthenticationActivity) obj;
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        ComponentName b = ComponentName_LoginActivityComponentMethodAutoProvider.b(fbInjector);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        facebookAuthenticationActivity.f1057p = secureContextHelper;
        facebookAuthenticationActivity.f1058q = b;
        facebookAuthenticationActivity.f1059r = abstractFbErrorReporter;
    }

    protected final void m1089a(Bundle bundle) {
        Object obj;
        Class cls = FacebookAuthenticationActivity.class;
        m1088a((Object) this, (Context) this);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras == null || !extras.containsKey("accountAuthenticatorResponse")) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            Bundle extras2 = intent.getExtras();
            this.f1059r.a("add_account_api", "incoming intent did not have expected extras " + (extras2 == null ? null : extras2.keySet()));
        }
        AccountAuthenticatorResponse accountAuthenticatorResponse = (AccountAuthenticatorResponse) getIntent().getParcelableExtra("accountAuthenticatorResponse");
        AddAccountIntentBuilder addAccountIntentBuilder = new AddAccountIntentBuilder();
        addAccountIntentBuilder.f1028a = accountAuthenticatorResponse;
        AddAccountIntentBuilder addAccountIntentBuilder2 = addAccountIntentBuilder;
        addAccountIntentBuilder2.f1029b = this.f1058q;
        this.f1057p.a(addAccountIntentBuilder2.m1075a(), this);
        finish();
    }
}
