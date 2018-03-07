package com.facebook.katana.dbl;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.auth.credentials.LoginCredentials;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.CrossFbAppBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.android.ActivityMethodAutoProvider;
import com.facebook.common.executors.C0087xd695ba9d;
import com.facebook.common.util.TriState;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.feed.data.FeedDataLoaderInitializer;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.login.LoginActivityHelper;
import com.facebook.katana.prefs.FbandroidPrefKeys;
import com.facebook.katana.service.AppSession;
import com.facebook.katana.service.AppSession.AuthAndLoginCallback;
import com.facebook.katana.service.AppSession.LoginStatus;
import com.facebook.katana.service.AppSessionListener;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: social_search_conversion?post_id=%s */
public class AuthLoginHelper {
    public Activity f4371a;
    private LoginActivityHelper f4372b;
    private SecureContextHelper f4373c;
    private FeedDataLoaderInitializer f4374d;
    private DBLStorageAndRetrievalHelper f4375e;
    private boolean f4376f;
    private Provider<TriState> f4377g;
    public final BaseFbBroadcastManager f4378h;
    public final Provider<User> f4379i;
    public final FbSharedPreferences f4380j;
    public final DefaultBlueServiceOperationFactory f4381k;
    public final ExecutorService f4382l;

    public static AuthLoginHelper m8067b(InjectorLike injectorLike) {
        return new AuthLoginHelper(ActivityMethodAutoProvider.m6475b(injectorLike), LoginActivityHelper.m8072b(injectorLike), DefaultSecureContextHelper.m4636a(injectorLike), FeedDataLoaderInitializer.m8175a(injectorLike), DBLStorageAndRetrievalHelper.m8206b(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.m4525a(injectorLike), IdBasedProvider.m1811a(injectorLike, 639), CrossFbAppBroadcastManager.m3885a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3595), FbSharedPreferencesImpl.m1826a(injectorLike), DefaultBlueServiceOperationFactory.m3782b(injectorLike), C0087xd695ba9d.m2486a(injectorLike));
    }

    public static AuthLoginHelper m8065a(InjectorLike injectorLike) {
        return m8067b(injectorLike);
    }

    @Inject
    public AuthLoginHelper(Activity activity, LoginActivityHelper loginActivityHelper, SecureContextHelper secureContextHelper, FeedDataLoaderInitializer feedDataLoaderInitializer, DBLStorageAndRetrievalHelper dBLStorageAndRetrievalHelper, Boolean bool, Provider<TriState> provider, FbBroadcastManager fbBroadcastManager, Provider<User> provider2, FbSharedPreferences fbSharedPreferences, BlueServiceOperationFactory blueServiceOperationFactory, ExecutorService executorService) {
        this.f4371a = activity;
        this.f4372b = loginActivityHelper;
        this.f4373c = secureContextHelper;
        this.f4374d = feedDataLoaderInitializer;
        this.f4375e = dBLStorageAndRetrievalHelper;
        this.f4376f = bool.booleanValue();
        this.f4377g = provider;
        this.f4378h = fbBroadcastManager;
        this.f4379i = provider2;
        this.f4380j = fbSharedPreferences;
        this.f4381k = blueServiceOperationFactory;
        this.f4382l = executorService;
    }

    public final boolean m8069a() {
        if (this.f4376f && !((TriState) this.f4377g.get()).equals(TriState.YES)) {
            return false;
        }
        AppSession a = AppSession.m8847a(this.f4371a.getApplicationContext());
        if (AppSession.m8854b(this.f4371a.getApplicationContext()) && a.f4949f == LoginStatus.STATUS_LOGGED_IN) {
            return (this.f4375e.m8213c().booleanValue() && this.f4375e.m8217f().booleanValue()) ? false : true;
        } else {
            return false;
        }
    }

    @SuppressLint({"DeprecatedClass"})
    public static void m8066a(LoginCredentials loginCredentials, String str, AppSession appSession, AppSessionListener appSessionListener, FutureCallback<OperationResult> futureCallback) {
        boolean z;
        appSession.m8861a();
        if (appSessionListener != null) {
            appSession.m8863a(appSessionListener);
        }
        if (appSession.f4949f == LoginStatus.STATUS_LOGGED_OUT) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        AppSession.m8858e(appSession.f4961r);
        appSession.f4953j = futureCallback;
        Bundle bundle = new Bundle();
        bundle.putParcelable("passwordCredentials", loginCredentials);
        bundle.putString("error_detail_type_param", "button_with_disabled");
        ListenableFuture a = BlueServiceOperationFactoryDetour.a(appSession.f4959p, str, bundle, ErrorPropagation.BY_EXCEPTION, 1944085040).mo3452a();
        appSession.f4950g = new AuthAndLoginCallback(appSession);
        Futures.m2458a(a, appSession.f4950g, appSession.f4960q);
        AppSession.m8851a(appSession, LoginStatus.STATUS_LOGGING_IN);
    }

    public final void m8068a(Bundle bundle, Intent intent) {
        boolean z = false;
        if (bundle.getBoolean("finish_immediately", false) && (bundle.getInt("flags") & 1048576) != 1048576) {
            this.f4371a.finish();
            z = true;
        }
        if (!z) {
            if (this.f4372b.m8076e()) {
                this.f4371a.finish();
            } else if (bundle.getBoolean("login_redirect", false)) {
                this.f4371a.setResult(-1);
                this.f4371a.finish();
            } else if (intent != null) {
                this.f4373c.mo660a(intent, 1, this.f4371a);
            } else {
                Intent a = this.f4372b.m8073a();
                if (a == null) {
                    a = this.f4372b.m8075d();
                    this.f4374d.m8178a();
                    User user = (User) this.f4379i.get();
                    if (!(this.f4380j.mo286a(FbandroidPrefKeys.f19432x, false) || user == null)) {
                        this.f4380j.edit().putBoolean(FbandroidPrefKeys.f19432x, true).commit();
                        Futures.m2458a(BlueServiceOperationFactoryDetour.a(this.f4381k, "login_broadcast_eligibility_check", new Bundle(), -1137094836).mo3452a(), new 1(this, user), this.f4382l);
                    }
                }
                if (!this.f4376f) {
                    this.f4375e.m8221k();
                }
                this.f4373c.mo662a(a, this.f4371a);
                this.f4371a.finish();
            }
        }
    }
}
