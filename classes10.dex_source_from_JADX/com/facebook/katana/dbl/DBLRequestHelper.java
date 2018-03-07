package com.facebook.katana.dbl;

import android.os.Bundle;
import com.facebook.auth.credentials.DBLFacebookCredentials;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.bootstrapcache.core.BootstrapCache;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.devicebasedlogin.logging.DBLLoggerHelper;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.NeedsApplicationInjector;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.user.model.User;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: update_postponed */
public final class DBLRequestHelper {
    public static final Class<?> f892a = DBLRequestHelper.class;
    public static final CallerContext f893b = CallerContext.a(DBLRequestHelper.class);
    public Lazy<BlueServiceOperationFactory> f894c;
    public ExecutorService f895d;
    public DBLStorageAndRetrievalHelper f896e;
    private FbSharedPreferences f897f;
    public DBLLoggerHelper f898g;
    private Provider<User> f899h;
    public BootstrapCache f900i;

    public static DBLRequestHelper m918b(InjectorLike injectorLike) {
        return new DBLRequestHelper(DBLStorageAndRetrievalHelper.b(injectorLike), IdBasedLazy.a(injectorLike.getApplicationInjector(), 1144), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 3595), DBLLoggerHelper.b(injectorLike), BootstrapCache.b(injectorLike));
    }

    @Inject
    public DBLRequestHelper(DBLStorageAndRetrievalHelper dBLStorageAndRetrievalHelper, @NeedsApplicationInjector Lazy<BlueServiceOperationFactory> lazy, ExecutorService executorService, FbSharedPreferences fbSharedPreferences, Provider<User> provider, DBLLoggerHelper dBLLoggerHelper, BootstrapCache bootstrapCache) {
        this.f896e = dBLStorageAndRetrievalHelper;
        this.f894c = lazy;
        this.f895d = executorService;
        this.f897f = fbSharedPreferences;
        this.f899h = provider;
        this.f898g = dBLLoggerHelper;
        this.f900i = bootstrapCache;
    }

    public final void m920a(String str, @Nullable FutureCallback<OperationResult> futureCallback, @Nullable final String str2) {
        String a = this.f897f.a(AuthPrefKeys.f, null);
        Bundle bundle = new Bundle();
        bundle.putString("machine_id", a);
        bundle.putString("pin", str);
        bundle.putString("nonce_to_keep", "");
        bundle.toString();
        OperationFuture a2 = BlueServiceOperationFactoryDetour.a((DefaultBlueServiceOperationFactory) this.f894c.get(), "set_nonce", bundle, ErrorPropagation.BY_ERROR_CODE, f893b, 687697467).a();
        boolean z = false;
        if (!str.equals("")) {
            z = true;
        }
        Futures.a(a2, new FutureCallback<OperationResult>(this) {
            final /* synthetic */ DBLRequestHelper f891c;

            public void onSuccess(Object obj) {
                DBLFacebookCredentials dBLFacebookCredentials = (DBLFacebookCredentials) ((OperationResult) obj).g().getParcelable("result");
                if (dBLFacebookCredentials != null) {
                    this.f891c.f896e.a(dBLFacebookCredentials);
                    DBLRequestHelper dBLRequestHelper = this.f891c;
                    Object obj2 = str2;
                    Bundle bundle = new Bundle();
                    if (dBLFacebookCredentials.mIsPinSet.booleanValue()) {
                        bundle.putBoolean("has_pin", true);
                    } else {
                        bundle.putBoolean("has_pin", false);
                    }
                    if (!StringUtil.a(obj2)) {
                        bundle.putString("source", obj2);
                    }
                    dBLRequestHelper.f898g.a("dbl_nux_save_account", bundle);
                    return;
                }
                BLog.b(DBLRequestHelper.f892a, "Fetched result was null");
                DBLRequestHelper.m917a(this.f891c, Boolean.valueOf(z));
            }

            public void onFailure(Throwable th) {
                DBLRequestHelper.m917a(this.f891c, Boolean.valueOf(z));
            }
        }, this.f895d);
        if (futureCallback != null) {
            Futures.a(a2, futureCallback, this.f895d);
        }
    }

    public final void m919a(DBLFacebookCredentials dBLFacebookCredentials, @Nullable String str) {
        if (!dBLFacebookCredentials.mNonce.equals("")) {
            Bundle bundle = new Bundle();
            bundle.putString("account_id", dBLFacebookCredentials.mUserId);
            bundle.putString("nonce", dBLFacebookCredentials.mNonce);
            BlueServiceOperationFactoryDetour.a((DefaultBlueServiceOperationFactory) this.f894c.get(), "remove_nonce", bundle, ErrorPropagation.BY_ERROR_CODE, f893b, -3980253).a(true).a();
        }
        if (dBLFacebookCredentials.mNonce.equals("password_account")) {
            this.f896e.e(dBLFacebookCredentials.mUserId);
        } else {
            this.f896e.b(dBLFacebookCredentials.mUserId);
        }
        this.f900i.a(dBLFacebookCredentials.mUserId);
        Bundle bundle2 = new Bundle();
        bundle2.putString("fbid", dBLFacebookCredentials.mUserId);
        if (!StringUtil.a(str)) {
            bundle2.putString("source", str);
        }
        if (dBLFacebookCredentials.mNonce.equals("password_account")) {
            bundle2.putString("account_type", "password_account");
        } else {
            bundle2.putString("account_type", "dbl");
        }
        this.f898g.a("dbl_settings_account_remove", bundle2);
    }

    public final void m921b(DBLFacebookCredentials dBLFacebookCredentials, @Nullable String str) {
        this.f896e.b(dBLFacebookCredentials.mUserId);
        this.f896e.b(new DBLFacebookCredentials(dBLFacebookCredentials.mUserId, dBLFacebookCredentials.mTime, dBLFacebookCredentials.mName, dBLFacebookCredentials.mUsername, dBLFacebookCredentials.mPicUrl, "password_account", false));
        Bundle bundle = new Bundle();
        bundle.putString("switch_to", "password_account");
        bundle.putString("fbid", dBLFacebookCredentials.mUserId);
        if (!StringUtil.a(str)) {
            bundle.putString("source", str);
        }
        this.f898g.a("switch_account", bundle);
    }

    public static void m917a(DBLRequestHelper dBLRequestHelper, Boolean bool) {
        if (dBLRequestHelper.f899h.get() != null) {
            dBLRequestHelper.f896e.a(new DBLFacebookCredentials(((User) dBLRequestHelper.f899h.get()).a, 0, ((User) dBLRequestHelper.f899h.get()).h(), ((User) dBLRequestHelper.f899h.get()).j(), ((User) dBLRequestHelper.f899h.get()).x(), "", bool.booleanValue()));
            Bundle bundle = new Bundle();
            if (bool.booleanValue()) {
                bundle.putBoolean("has_pin", true);
            } else {
                bundle.putBoolean("has_pin", false);
            }
            dBLRequestHelper.f898g.a("dbl_nux_save_placeholder", bundle);
        }
    }
}
