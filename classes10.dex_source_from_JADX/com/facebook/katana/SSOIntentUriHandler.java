package com.facebook.katana;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.DeliverOnNewIntentWhenFinishing;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.util.StringUtil;
import com.facebook.katana.service.AppSession;
import com.facebook.katana.service.AppSession.LoginStatus;
import com.facebook.katana.urimap.IntentHandlerUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.annotation.Nullable;

@DeliverOnNewIntentWhenFinishing
/* compiled from: valueType */
public class SSOIntentUriHandler extends FbFragmentActivity implements IAuthNotRequired {
    public final void m706b(@Nullable Bundle bundle) {
        AppSession a = AppSession.a(this);
        if (a != null && AppSession.b(this) && a.f == LoginStatus.STATUS_LOGGED_IN) {
            super.b(bundle);
            Intent intent = getIntent();
            m705a(intent, FBLinks.a);
            IntentHandlerUtil.m1246a(hz_()).m1253a((Context) this, intent);
        }
        finish();
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -209465157);
        super.onResume();
        finish();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 578732823, a);
    }

    private static void m705a(Intent intent, String str) {
        if (intent != null && intent.getData() != null && !StringUtil.a(intent.getData().toString()) && !StringUtil.a(str)) {
            intent.setData(intent.getData().buildUpon().scheme(str).build());
        }
    }
}
