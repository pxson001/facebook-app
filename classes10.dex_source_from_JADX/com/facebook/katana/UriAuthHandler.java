package com.facebook.katana;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.activity.FragmentBaseActivityUtil;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.katana.login.ComponentName_LoginActivityComponentMethodAutoProvider;
import com.facebook.katana.util.AlertDialogs;
import com.facebook.user.model.User;
import com.google.common.base.Objects;

/* compiled from: vCKSz9ulPV-fu56O6kQlOLW0hEJL7wzb */
public class UriAuthHandler extends FbFragmentActivity implements IAuthNotRequired {

    /* compiled from: vCKSz9ulPV-fu56O6kQlOLW0hEJL7wzb */
    class C00951 implements OnClickListener {
        final /* synthetic */ UriAuthHandler f674a;

        C00951(UriAuthHandler uriAuthHandler) {
            this.f674a = uriAuthHandler;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f674a.finish();
        }
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 23984:
                return AlertDialogs.a(this, getString(2131232457), 17301543, getString(2131232458), getString(2131230756), new C00951(this), null, null, null, true);
            default:
                return super.onCreateDialog(i);
        }
    }

    public final void m707b(Bundle bundle) {
        Intent intent;
        super.b(bundle);
        Uri data = getIntent().getData();
        FbInjector hz_ = hz_();
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(hz_);
        ComponentName b = ComponentName_LoginActivityComponentMethodAutoProvider.b(hz_);
        Object queryParameter = data.getQueryParameter("landing_page");
        if (StringUtil.c(queryParameter)) {
            intent = null;
        } else {
            intent = new Intent("android.intent.action.VIEW", Uri.parse(queryParameter));
        }
        String queryParameter2 = data.getQueryParameter("contactpoint");
        LoggedInUserSessionManager a = LoggedInUserSessionManager.a(hz_);
        if (a != null && a.b()) {
            User c = a.c();
            if (c != null && Objects.equal(queryParameter2, c.a)) {
                FragmentBaseActivityUtil b2 = FragmentBaseActivityUtil.b(hz_);
                if (intent == null) {
                    intent = b2.a();
                }
                secureContextHelper.a(intent, this);
                finish();
                return;
            } else if (c != null) {
                showDialog(23984);
                return;
            }
        }
        Intent putExtra = new Intent().setComponent(b).putExtra("username", queryParameter2).putExtra("reg_login_nonce", data.getQueryParameter("nonce"));
        if (intent != null) {
            putExtra.putExtra("calling_intent", intent);
        }
        secureContextHelper.a(putExtra, this);
        finish();
    }
}
