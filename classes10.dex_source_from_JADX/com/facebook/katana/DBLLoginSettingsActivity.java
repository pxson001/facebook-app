package com.facebook.katana;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.facebook.auth.credentials.DBLFacebookCredentials;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.devicebasedlogin.logging.DBLLoggerHelper;
import com.facebook.devicebasedlogin.settings.DBLLoginSettingsAccountsListFragment;
import com.facebook.devicebasedlogin.settings.DBLLoginSettingsListener;
import com.facebook.devicebasedlogin.settings.DBLSettingsModule;
import com.facebook.inject.FbInjector;
import com.facebook.katana.annotations.DBLLoginSettingsFragmentName;
import com.facebook.resources.IFbResourcesNotRequired;
import javax.inject.Inject;

/* compiled from: SEND_FAILED_NO_RETRY */
public class DBLLoginSettingsActivity extends FbFragmentActivity implements IAuthNotRequired, DBLLoginSettingsListener, IFbResourcesNotRequired {
    @Inject
    SecureContextHelper f24098p;
    @Inject
    @DBLLoginSettingsFragmentName
    String f24099q;
    @Inject
    DBLLoggerHelper f24100r;
    private DBLLoginSettingsAccountsListFragment f24101s;

    private static <T extends Context> void m25405a(Class<T> cls, T t) {
        m25406a((Object) t, (Context) t);
    }

    public static void m25406a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((DBLLoginSettingsActivity) obj).m25404a((SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), DBLSettingsModule.a(), DBLLoggerHelper.b(fbInjector));
    }

    public final void m25409b(Bundle bundle) {
        super.b(bundle);
        Class cls = DBLLoginSettingsActivity.class;
        m25406a((Object) this, (Context) this);
        setContentView(2130903850);
        FragmentManager kO_ = kO_();
        Fragment a = Fragment.a(this, this.f24099q, null);
        this.f24101s = (DBLLoginSettingsAccountsListFragment) a;
        this.f24101s.al = this;
        kO_.a().a(2131558429, a).b();
    }

    public final void m25408a(DBLFacebookCredentials dBLFacebookCredentials) {
        Bundle bundle = new Bundle();
        bundle.putString("fbid", dBLFacebookCredentials.mUserId);
        if (dBLFacebookCredentials.mNonce.equals("password_account")) {
            bundle.putString("account_type", "password_account");
        } else if (dBLFacebookCredentials.mIsPinSet.booleanValue()) {
            bundle.putString("view", "pin");
        } else {
            bundle.putString("view", "no_pin");
        }
        this.f24100r.a("dbl_settings_displayed", bundle);
        Intent intent = new Intent(this, DBLAccountSettingsActivity.class);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("dbl_account_details", dBLFacebookCredentials);
        intent.putExtras(bundle2);
        this.f24098p.a(intent, this);
        overridePendingTransition(2130968626, 2130968632);
    }

    public final void m25407a() {
        finish();
    }

    private void m25404a(SecureContextHelper secureContextHelper, String str, DBLLoggerHelper dBLLoggerHelper) {
        this.f24098p = secureContextHelper;
        this.f24099q = str;
        this.f24100r = dBLLoggerHelper;
    }
}
