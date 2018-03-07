package com.facebook.registration.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.TextView;
import com.facebook.api.growth.profile.SetProfilePhotoParams;
import com.facebook.auth.login.ipc.LaunchAuthActivityUtil;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.common.util.TriState;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.gk.sessionless.GatekeeperStoreImpl_SessionlessMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.growth.util.DeviceOwnerDataFetcher;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.dbl.FbAndroidAuthActivityUtil;
import com.facebook.registration.constants.RegPermissions;
import com.facebook.registration.logging.SimpleRegLogger;
import com.facebook.registration.model.SimpleRegFormData;
import com.facebook.registration.ui.RegClickableSpan.TargetActivity;
import com.facebook.registration.ui.RegClickableSpanProvider;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.widget.text.BetterLinkMovementMethod;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: extra_pwd */
public class RegistrationUtil {
    public final Context f12448a;
    public final BetterLinkMovementMethod f12449b;
    public final RegClickableSpanProvider f12450c;
    public final SimpleRegFormData f12451d;
    private final ActivityRuntimePermissionsManagerProvider f12452e;
    private final Lazy<DeviceOwnerDataFetcher> f12453f;
    private final Lazy<Executor> f12454g;
    private final DefaultBlueServiceOperationFactory f12455h;
    private final SimpleRegLogger f12456i;
    private final FbAndroidAuthActivityUtil f12457j;
    private final GatekeeperStoreImpl f12458k;
    public final RuntimePermissionsUtil f12459l;

    public static RegistrationUtil m13191b(InjectorLike injectorLike) {
        return new RegistrationUtil((Context) injectorLike.getInstance(Context.class), BetterLinkMovementMethod.m13207a(injectorLike), (RegClickableSpanProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RegClickableSpanProvider.class), SimpleRegFormData.m13214a(injectorLike), (ActivityRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), IdBasedLazy.a(injectorLike, 7151), IdBasedSingletonScopeProvider.b(injectorLike, 3863), DefaultBlueServiceOperationFactory.b(injectorLike), SimpleRegLogger.m13147b(injectorLike), FbAndroidAuthActivityUtil.m13234b(injectorLike), GatekeeperStoreImpl_SessionlessMethodAutoProvider.a(injectorLike), RuntimePermissionsUtil.b(injectorLike));
    }

    @Inject
    public RegistrationUtil(Context context, BetterLinkMovementMethod betterLinkMovementMethod, RegClickableSpanProvider regClickableSpanProvider, SimpleRegFormData simpleRegFormData, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, Lazy<DeviceOwnerDataFetcher> lazy, Lazy<Executor> lazy2, BlueServiceOperationFactory blueServiceOperationFactory, SimpleRegLogger simpleRegLogger, LaunchAuthActivityUtil launchAuthActivityUtil, GatekeeperStore gatekeeperStore, RuntimePermissionsUtil runtimePermissionsUtil) {
        this.f12448a = context;
        this.f12449b = betterLinkMovementMethod;
        this.f12450c = regClickableSpanProvider;
        this.f12451d = simpleRegFormData;
        this.f12452e = activityRuntimePermissionsManagerProvider;
        this.f12453f = lazy;
        this.f12454g = lazy2;
        this.f12455h = blueServiceOperationFactory;
        this.f12456i = simpleRegLogger;
        this.f12457j = launchAuthActivityUtil;
        this.f12458k = gatekeeperStore;
        this.f12459l = runtimePermissionsUtil;
    }

    public final void m13197a(TextView textView) {
        Resources resources = this.f12448a.getResources();
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(resources);
        styledStringBuilder.a(StringFormatUtil.formatStrLocaleSafe(resources.getString(2131239797), "[[fb_terms]]", "[[data_policy]]", "[[cookies_Use_policy]]"));
        styledStringBuilder.a("[[fb_terms]]", resources.getString(2131239798), this.f12450c.m13212a(TargetActivity.BROWSER, "https://m.facebook.com/legal/terms/"), 33).a("[[data_policy]]", resources.getString(2131239799), this.f12450c.m13212a(TargetActivity.BROWSER, "https://m.facebook.com/about/privacy/"), 33).a("[[cookies_Use_policy]]", resources.getString(2131239800), this.f12450c.m13212a(TargetActivity.BROWSER, "https://m.facebook.com/help/cookies"), 33);
        CharSequence b = styledStringBuilder.b();
        textView.setContentDescription(b);
        textView.setText(b);
        textView.setMovementMethod(this.f12449b);
    }

    public final ListenableFuture<?> m13194a(Activity activity) {
        if (VERSION.SDK_INT <= 22) {
            return Futures.a(null);
        }
        ActivityRuntimePermissionsManager a = this.f12452e.m13233a(activity);
        SettableFuture f = SettableFuture.f();
        a.a(RegPermissions.a, new 4(this, f));
        return f;
    }

    public final OperationFuture m13193a(CallerContext callerContext) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("registrationRegisterAccountParams", this.f12451d);
        return BlueServiceOperationFactoryDetour.a(this.f12455h, "registration_register_account", bundle, ErrorPropagation.BY_ERROR_CODE, callerContext, 1378112366).a();
    }

    public final ListenableFuture<OperationResult> m13195a(String str, String str2) {
        SetProfilePhotoParams setProfilePhotoParams = new SetProfilePhotoParams(Long.parseLong(str), str2);
        Bundle bundle = new Bundle();
        bundle.putParcelable("growthSetProfilePhotoParams", setProfilePhotoParams);
        return BlueServiceOperationFactoryDetour.a(this.f12455h, "growth_set_profile_photo", bundle, -1732700976).a();
    }

    public final void m13196a(Activity activity, String str, boolean z) {
        KeyboardUtils.m1055a(activity);
        if (z) {
            new Builder(activity).m14329a(2131239844).m14343b(2131239845).mo962a(2131230735, new 3(this, activity, str)).mo965b(2131230736, new 2(this)).m14331a(new 1(this)).mo964a().show();
            return;
        }
        this.f12456i.m13162b(str);
        this.f12457j.m13235a(activity);
    }

    public final boolean m13198a() {
        return m13200b() || m13202c() || m13204d() || m13206e();
    }

    public final boolean m13200b() {
        return m13199a(false);
    }

    public final boolean m13199a(boolean z) {
        if (m13192g()) {
            return false;
        }
        return m13190a(24, "reg_terms_contacts_end_v1", z);
    }

    public final boolean m13202c() {
        return m13201b(false);
    }

    public final boolean m13201b(boolean z) {
        if (m13192g() || this.f12458k.a(24, false)) {
            return false;
        }
        return m13190a(25, "reg_terms_contacts_end_v2", z);
    }

    public final boolean m13204d() {
        return m13203c(false);
    }

    public final boolean m13203c(boolean z) {
        if (m13192g() || this.f12458k.a(24, false) || this.f12458k.a(25, false)) {
            return false;
        }
        return m13190a(26, "reg_terms_contacts_end_v3", z);
    }

    public final boolean m13206e() {
        return m13205d(false);
    }

    public final boolean m13205d(boolean z) {
        if (m13192g() || this.f12458k.a(24, false) || this.f12458k.a(25, false) || this.f12458k.a(26, false) || this.f12458k.a(14, false)) {
            return false;
        }
        return m13190a(27, "reg_terms_contacts_end_v4", z);
    }

    public static void m13189a(RegistrationUtil registrationUtil, SettableFuture settableFuture) {
        Futures.a(((DeviceOwnerDataFetcher) registrationUtil.f12453f.get()).a(true), new 5(registrationUtil, settableFuture), (Executor) registrationUtil.f12454g.get());
    }

    private boolean m13192g() {
        return this.f12458k.a(16, false) || this.f12458k.a(18, false) || this.f12458k.a(19, false) || this.f12458k.a(28, false);
    }

    private boolean m13190a(int i, String str, boolean z) {
        TriState a = this.f12458k.a(i);
        if (z) {
            this.f12456i.m13154a(str, a);
        }
        return a.asBoolean(false);
    }
}
