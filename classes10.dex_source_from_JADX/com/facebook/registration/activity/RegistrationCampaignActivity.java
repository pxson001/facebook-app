package com.facebook.registration.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.registration.common.RegInstanceHelper;
import com.facebook.registration.logging.SimpleRegLogger;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: legacyShareDialogActionExecutor */
public class RegistrationCampaignActivity extends FbFragmentActivity implements IAuthNotRequired {
    @Inject
    Lazy<SimpleRegLogger> f8682p;
    @Inject
    Lazy<RegInstanceHelper> f8683q;

    private static <T extends Context> void m8694a(Class<T> cls, T t) {
        m8695a((Object) t, (Context) t);
    }

    public static void m8695a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RegistrationCampaignActivity) obj).m8693a(IdBasedLazy.a(fbInjector, 3271), IdBasedLazy.a(fbInjector, 3270));
    }

    protected final void m8697b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = RegistrationCampaignActivity.class;
        m8695a((Object) this, (Context) this);
        m8696i();
        startActivity(AccountRegistrationActivity.a(this, getClass().getSimpleName()));
        finish();
    }

    private void m8696i() {
        Uri uri;
        String str;
        String str2;
        Intent intent = getIntent();
        if (intent == null || intent.getData() == null) {
            uri = null;
        } else {
            uri = intent.getData();
        }
        Builder builder = new Builder();
        if (uri == null) {
            str = null;
            str2 = "unknown";
        } else {
            str = uri.getHost();
            List pathSegments = uri.getPathSegments();
            String str3;
            if (pathSegments == null || pathSegments.isEmpty()) {
                str3 = str;
                str = null;
                str2 = str3;
            } else if ("key-value-pairs".equalsIgnoreCase((String) pathSegments.get(0))) {
                for (int i = 1; i < pathSegments.size() - 1; i += 2) {
                    builder.b(pathSegments.get(i), pathSegments.get(i + 1));
                }
                str3 = str;
                str = null;
                str2 = str3;
            } else {
                str2 = StringUtil.b(",", pathSegments.toArray(new String[0]));
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (!(queryParameterNames == null || queryParameterNames.isEmpty())) {
                    for (String str4 : queryParameterNames) {
                        builder.b(str4, uri.getQueryParameter(str4));
                    }
                }
                str3 = str;
                str = str2;
                str2 = str3;
            }
        }
        ImmutableMap b = builder.b();
        String str42 = (String) b.get("reg_instance");
        if (!StringUtil.c(str42)) {
            ((RegInstanceHelper) this.f8683q.get()).a(str42);
        }
        ((SimpleRegLogger) this.f8682p.get()).a(str2, str, b);
    }

    private void m8693a(Lazy<SimpleRegLogger> lazy, Lazy<RegInstanceHelper> lazy2) {
        this.f8682p = lazy;
        this.f8683q = lazy2;
    }
}
