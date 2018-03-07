package com.facebook.katana.dbl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.growth.nux.UserAccountNUXActivity;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.activity.FacebookActivity;
import com.facebook.katana.login.ComponentName_LoginActivityComponentMethodAutoProvider;
import com.facebook.languages.switcher.activity.LanguageSwitcherActivity;
import com.facebook.registration.activity.AccountRegistrationActivity;
import com.facebook.registration.activity.RegistrationLoginActivity;
import javax.inject.Inject;

/* compiled from: extra_message */
public class FacebookLoginIntentManager {
    private static final String f12493a = FacebookLoginIntentManager.class.getSimpleName();
    private final ComponentName f12494b;
    private final SecureContextHelper f12495c;

    public static FacebookLoginIntentManager m13240b(InjectorLike injectorLike) {
        return new FacebookLoginIntentManager(ComponentName_LoginActivityComponentMethodAutoProvider.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public FacebookLoginIntentManager(ComponentName componentName, SecureContextHelper secureContextHelper) {
        this.f12494b = componentName;
        this.f12495c = secureContextHelper;
    }

    private Intent m13241c(Activity activity) {
        Intent component = new Intent().setComponent(this.f12494b);
        if (!((activity instanceof AccountRegistrationActivity) || (activity instanceof RegistrationLoginActivity) || (activity instanceof LanguageSwitcherActivity) || (activity instanceof UserAccountNUXActivity))) {
            component.putExtra("calling_intent", activity.getIntent());
        }
        if (activity.getIntent().hasExtra("start")) {
            component.putExtra("start", activity.getIntent().getBooleanExtra("start", false));
        }
        if (activity.getIntent().hasExtra("ref")) {
            component.putExtra("ref", activity.getIntent().getStringExtra("ref"));
        }
        component.setAction("android.intent.action.VIEW");
        component.addFlags(67108864);
        return component;
    }

    private Intent m13242d(Activity activity) {
        Intent component = new Intent().setComponent(this.f12494b);
        if ((activity instanceof FacebookActivity) && ((FacebookActivity) activity).mo54i().c()) {
            activity.toString();
            return component;
        } else if (activity instanceof DBLLogoutActivity) {
            if (activity.getIntent().hasExtra("otp") && activity.getIntent().hasExtra("username")) {
                component.putExtra("otp", activity.getIntent().getStringExtra("otp"));
                component.putExtra("username", activity.getIntent().getStringExtra("username"));
            }
            return component;
        } else {
            activity.toString();
            return m13241c(activity);
        }
    }

    public final void m13243a(Activity activity) {
        m13244a(activity, null);
    }

    public final void m13244a(Activity activity, Bundle bundle) {
        Intent d = m13242d(activity);
        if (bundle != null && ((activity instanceof AccountRegistrationActivity) || (activity instanceof RegistrationLoginActivity))) {
            if (bundle.containsKey("extra_uid")) {
                d.putExtra("extra_uid", bundle.getString("extra_uid"));
            }
            if (bundle.containsKey("extra_pwd")) {
                d.putExtra("extra_pwd", bundle.getString("extra_pwd"));
            }
        }
        this.f12495c.a(d, activity);
        activity.overridePendingTransition(2130968626, 2130968632);
        activity.finish();
    }

    public final void m13245b(Activity activity) {
        Intent c = m13241c(activity);
        c.putExtra("login_redirect", true);
        this.f12495c.a(c, 2210, activity);
    }
}
