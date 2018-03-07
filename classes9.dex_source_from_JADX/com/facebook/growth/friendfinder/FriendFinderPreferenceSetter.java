package com.facebook.growth.friendfinder;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.TriState;
import com.facebook.contacts.upload.ContactsUploadRunner;
import com.facebook.contacts.upload.ContactsUploadVisibility;
import com.facebook.contacts.upload.prefs.ContactUploadStatusHelper;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.growth.logging.FriendFinderAnalyticsLogger;
import com.facebook.growth.prefs.FriendFinderPrefKeys;
import com.facebook.growth.prefs.GrowthPrefKeys;
import com.facebook.growth.protocol.SetContinuousContactsUploadMethod.Setting;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.nux.status.NuxStepListener;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: participant_profiles */
public class FriendFinderPreferenceSetter {
    private static final CallerContext f7263a = CallerContext.a(FriendFinderPreferenceSetter.class);
    private final Context f7264b;
    private final ContactsUploadRunner f7265c;
    private final FbSharedPreferences f7266d;
    private final DefaultBlueServiceOperationFactory f7267e;
    private final Provider<String> f7268f;
    private final Provider<TriState> f7269g;
    private final Provider<TriState> f7270h;
    private final Lazy<Toaster> f7271i;
    private final ContactUploadStatusHelper f7272j;
    private final Lazy<RuntimePermissionsUtil> f7273k;
    private final GatekeeperStoreImpl f7274l;
    public final PrefKey f7275m;
    private final PrefKey f7276n;

    public static FriendFinderPreferenceSetter m7544b(InjectorLike injectorLike) {
        return new FriendFinderPreferenceSetter((Context) injectorLike.getInstance(Context.class), ContactsUploadRunner.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), FriendFinderAnalyticsLogger.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), IdBasedProvider.a(injectorLike, 4442), IdBasedProvider.a(injectorLike, 659), IdBasedProvider.a(injectorLike, 691), IdBasedLazy.a(injectorLike, 3588), ContactUploadStatusHelper.b(injectorLike), IdBasedLazy.a(injectorLike, 3364), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FriendFinderPreferenceSetter(Context context, ContactsUploadRunner contactsUploadRunner, FbSharedPreferences fbSharedPreferences, FriendFinderAnalyticsLogger friendFinderAnalyticsLogger, BlueServiceOperationFactory blueServiceOperationFactory, Provider<String> provider, Provider<TriState> provider2, Provider<TriState> provider3, Lazy<Toaster> lazy, ContactUploadStatusHelper contactUploadStatusHelper, Lazy<RuntimePermissionsUtil> lazy2, GatekeeperStore gatekeeperStore) {
        this.f7264b = context;
        this.f7266d = fbSharedPreferences;
        this.f7265c = contactsUploadRunner;
        this.f7267e = blueServiceOperationFactory;
        this.f7268f = provider;
        this.f7269g = provider2;
        this.f7270h = provider3;
        this.f7271i = lazy;
        this.f7272j = contactUploadStatusHelper;
        this.f7273k = lazy2;
        this.f7274l = gatekeeperStore;
        this.f7275m = GrowthPrefKeys.a((String) provider.get());
        this.f7276n = FriendFinderPrefKeys.a((String) provider.get(), this.f7266d);
    }

    public final ListenableFuture<OperationResult> m7546a(boolean z) {
        if (m7547a() == z) {
            return Futures.a(OperationResult.a);
        }
        this.f7266d.edit().putBoolean(this.f7275m, z).commit();
        if (!z) {
            this.f7272j.a(false);
            m7545c(false);
        } else if (this.f7274l.a(387, false)) {
            this.f7272j.a(true);
        } else {
            this.f7265c.a(ContactsUploadVisibility.SHOW);
        }
        this.f7266d.edit().a(GrowthPrefKeys.b((String) this.f7268f.get())).commit();
        Bundle bundle = new Bundle();
        bundle.putSerializable("growthSetContinuousContactsUploadParamsKey", z ? Setting.ON : Setting.OFF);
        return BlueServiceOperationFactoryDetour.a(this.f7267e, "growth_set_continuous_contacts_upload", bundle, ErrorPropagation.BY_EXCEPTION, f7263a, 560880753).a();
    }

    public final boolean m7547a() {
        return this.f7266d.a(this.f7275m, false);
    }

    private void m7545c(boolean z) {
        this.f7266d.edit().putBoolean(this.f7276n, z).commit();
    }

    public final void m7549b(boolean z) {
        m7545c(true);
        if (this.f7269g.get() == TriState.YES && !m7547a()) {
            m7546a(true);
            if (z) {
                ((Toaster) this.f7271i.get()).b(new ToastBuilder(this.f7264b.getString(2131236410) + "\n" + this.f7264b.getString(2131236411)));
            }
        }
    }

    public final boolean m7550c() {
        if (this.f7268f.get() == null) {
            return true;
        }
        if (!((RuntimePermissionsUtil) this.f7273k.get()).a("android.permission.READ_CONTACTS")) {
            return true;
        }
        return (((TriState) this.f7270h.get()).asBoolean(false) && (this.f7266d.a(GrowthPrefKeys.b((String) this.f7268f.get()), false) || this.f7266d.a(GrowthPrefKeys.a((String) this.f7268f.get()), false))) ? false : true;
    }

    public final boolean m7548a(Activity activity) {
        return (activity instanceof NuxStepListener) && !this.f7266d.a(GrowthPrefKeys.b((String) this.f7268f.get()), true);
    }
}
