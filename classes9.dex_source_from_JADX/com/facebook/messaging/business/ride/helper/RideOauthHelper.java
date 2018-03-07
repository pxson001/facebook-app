package com.facebook.messaging.business.ride.helper;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.common.helper.BusinessMessageDialogHelper;
import com.facebook.messaging.business.common.helper.BusinessMessageDialogHelper.C10002;
import com.facebook.messaging.business.common.model.BusinessBottomSheetItem;
import com.facebook.messaging.business.common.model.BusinessBottomSheetItem.BusinessBottomSheetItemBuilder;
import com.facebook.messaging.business.common.view.adapters.BusinessBottomSheetAdapter;
import com.facebook.messaging.business.nativesignup.model.NativeSignUpParams;
import com.facebook.messaging.business.nativesignup.model.NativeSignUpParams.NativeSignUpParamsBuilder;
import com.facebook.messaging.business.nativesignup.view.BusinessSignUpFragment;
import com.facebook.messaging.business.ride.abtest.ExperimentsForRideAbtestModule;
import com.facebook.messaging.business.ride.analytics.RideAnalyticsLogger;
import com.facebook.messaging.business.ride.graphql.RideQueryFragmentsModels.RideProvidersQueryModel.MessengerCommerceModel.RideProvidersModel;
import com.facebook.messaging.business.ride.utils.RideServiceParams;
import com.facebook.messaging.business.ride.utils.RideServiceParams.RideServiceParamsBuilder;
import com.facebook.messaging.business.ride.view.RideRequestFragment;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.orca.compose.ComposeFragment.31;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.dialogs.DialogWindowUtils;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.user.model.User.CommercePageType;
import com.facebook.user.model.UserKey;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: moments_bot_invite_postback */
public class RideOauthHelper {
    public final Context f9222a;
    private final String f9223b;
    public final AbstractFbErrorReporter f9224c;
    private final SecureContextHelper f9225d;
    private final RideNativeSignUpResultHandler f9226e;
    public final GatekeeperStoreImpl f9227f;
    private final BusinessMessageDialogHelper f9228g;
    public final RideAnalyticsLogger f9229h;
    public final RideProviderLoader f9230i;
    private final UserCache f9231j;
    public final QeAccessor f9232k;
    public final MonotonicClock f9233l;
    public Handler f9234m = new Handler();
    @Nullable
    public Runnable f9235n;
    @Nullable
    public ProgressDialog f9236o;

    /* compiled from: moments_bot_invite_postback */
    public class C10644 implements Runnable {
        final /* synthetic */ RideOauthHelper f9221a;

        /* compiled from: moments_bot_invite_postback */
        class C10631 implements OnDismissListener {
            final /* synthetic */ C10644 f9220a;

            C10631(C10644 c10644) {
                this.f9220a = c10644;
            }

            public void onDismiss(DialogInterface dialogInterface) {
                this.f9220a.f9221a.f9230i.f9260g.c();
            }
        }

        public C10644(RideOauthHelper rideOauthHelper) {
            this.f9221a = rideOauthHelper;
        }

        public void run() {
            if (this.f9221a.f9236o == null) {
                this.f9221a.f9236o = new ProgressDialog(this.f9221a.f9222a);
                this.f9221a.f9236o.a(this.f9221a.f9222a.getString(2131230739));
                this.f9221a.f9236o.setOnDismissListener(new C10631(this));
                DialogWindowUtils.a(this.f9221a.f9236o);
                this.f9221a.f9236o.show();
            }
        }
    }

    public static RideOauthHelper m9729b(InjectorLike injectorLike) {
        return new RideOauthHelper((Context) injectorLike.getInstance(Context.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4442), RideProviderLoader.m9747b(injectorLike), BusinessMessageDialogHelper.m9018b(injectorLike), RideAnalyticsLogger.m9362b(injectorLike), RideMutationHelper.m9712b(injectorLike), RideNativeSignUpResultHandler.m9718b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), UserCache.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    public static void m9726a(RideOauthHelper rideOauthHelper, RideServiceParams rideServiceParams, RideProvidersModel rideProvidersModel) {
        ThreadKey a = rideOauthHelper.m9724a(rideServiceParams.f9309b, rideProvidersModel);
        RideServiceParamsBuilder rideServiceParamsBuilder = new RideServiceParamsBuilder();
        rideServiceParamsBuilder.f9299a = rideServiceParams.f9308a;
        rideServiceParamsBuilder = rideServiceParamsBuilder;
        rideServiceParamsBuilder.f9300b = rideServiceParams.f9309b;
        rideServiceParamsBuilder = rideServiceParamsBuilder;
        rideServiceParamsBuilder.f9301c = rideServiceParams.f9310c;
        rideServiceParamsBuilder = rideServiceParamsBuilder;
        rideServiceParamsBuilder.f9302d = rideServiceParams.f9311d;
        rideServiceParamsBuilder = rideServiceParamsBuilder;
        rideServiceParamsBuilder.f9303e = rideServiceParams.f9312e;
        rideServiceParamsBuilder = rideServiceParamsBuilder;
        rideServiceParamsBuilder.f9304f = rideServiceParams.f9313f;
        rideServiceParamsBuilder = rideServiceParamsBuilder;
        rideServiceParamsBuilder.f9305g = rideServiceParams.f9314g;
        rideServiceParamsBuilder = rideServiceParamsBuilder;
        rideServiceParamsBuilder.f9306h = rideServiceParams.f9315h;
        rideServiceParamsBuilder = rideServiceParamsBuilder;
        rideServiceParamsBuilder.f9307i = rideServiceParams.f9316i;
        RideServiceParamsBuilder rideServiceParamsBuilder2 = rideServiceParamsBuilder;
        rideServiceParamsBuilder2.f9302d = rideProvidersModel.m9586m();
        rideServiceParamsBuilder2 = rideServiceParamsBuilder2;
        rideServiceParamsBuilder2.f9303e = rideProvidersModel.m9587n().m9573j();
        rideServiceParamsBuilder2 = rideServiceParamsBuilder2;
        rideServiceParamsBuilder2.f9300b = a;
        rideServiceParamsBuilder2 = rideServiceParamsBuilder2;
        rideServiceParamsBuilder2.f9307i = rideProvidersModel.m9585l();
        RideServiceParams j = rideServiceParamsBuilder2.m9767j();
        if (rideProvidersModel.m9584k()) {
            Intent a2 = RideRequestFragment.m9841a(rideOauthHelper.f9222a, j);
            a2.addFlags(268435456);
            rideOauthHelper.f9225d.a(a2, rideOauthHelper.f9222a);
            return;
        }
        Context context = rideOauthHelper.f9222a;
        NativeSignUpParamsBuilder newBuilder = NativeSignUpParams.newBuilder();
        newBuilder.f8877a = rideProvidersModel.m9586m();
        newBuilder = newBuilder;
        newBuilder.f8878b = rideOauthHelper.f9226e.mo321a();
        newBuilder = newBuilder;
        newBuilder.f8879c = j.f9308a;
        newBuilder = newBuilder;
        newBuilder.f8880d = j.f9313f;
        newBuilder = newBuilder;
        newBuilder.f8881e = a;
        NativeSignUpParamsBuilder nativeSignUpParamsBuilder = newBuilder;
        nativeSignUpParamsBuilder.f8883g = j.f9315h;
        nativeSignUpParamsBuilder = nativeSignUpParamsBuilder;
        Bundle bundle = new Bundle();
        bundle.putString("entry_point", "native_sign_up");
        bundle.putString("provider_display_name", j.f9312e);
        bundle.putBoolean("is_dest_optional", j.f9316i);
        bundle.putString("address", j.f9310c);
        bundle.putString("request_tag", j.f9313f);
        bundle.putParcelable("dest_coordinates", j.f9314g);
        nativeSignUpParamsBuilder.f8882f = bundle;
        rideOauthHelper.f9225d.a(BusinessSignUpFragment.m9267a(context, nativeSignUpParamsBuilder.m9162h()), rideOauthHelper.f9222a);
    }

    private boolean m9733b(RideServiceParams rideServiceParams) {
        return !Strings.isNullOrEmpty(rideServiceParams.f9311d) || m9728a(rideServiceParams.f9309b);
    }

    @Inject
    public RideOauthHelper(Context context, FbErrorReporter fbErrorReporter, SecureContextHelper secureContextHelper, GatekeeperStore gatekeeperStore, Provider<String> provider, RideProviderLoader rideProviderLoader, BusinessMessageDialogHelper businessMessageDialogHelper, RideAnalyticsLogger rideAnalyticsLogger, RideMutationHelper rideMutationHelper, RideNativeSignUpResultHandler rideNativeSignUpResultHandler, QeAccessor qeAccessor, UserCache userCache, MonotonicClock monotonicClock) {
        this.f9222a = context;
        this.f9231j = userCache;
        this.f9223b = (String) provider.get();
        this.f9224c = fbErrorReporter;
        this.f9225d = secureContextHelper;
        this.f9227f = gatekeeperStore;
        this.f9230i = rideProviderLoader;
        this.f9226e = rideNativeSignUpResultHandler;
        this.f9228g = businessMessageDialogHelper;
        this.f9229h = rideAnalyticsLogger;
        this.f9232k = qeAccessor;
        this.f9233l = monotonicClock;
    }

    public final void m9735a(RideServiceParams rideServiceParams) {
        m9736a(rideServiceParams, null);
    }

    public final void m9736a(RideServiceParams rideServiceParams, 31 31) {
        this.f9229h.m9364a(rideServiceParams);
        m9731b(rideServiceParams, 31);
    }

    public static void m9727a(RideOauthHelper rideOauthHelper, RideServiceParams rideServiceParams, ImmutableList immutableList) {
        if (immutableList.isEmpty()) {
            rideOauthHelper.m9725a();
        } else if (!Strings.isNullOrEmpty(rideServiceParams.f9311d)) {
            String str = rideServiceParams.f9311d;
            r3 = immutableList.size();
            for (int i = 0; i < r3; i++) {
                r1 = (RideProvidersModel) immutableList.get(i);
                if (r1.m9586m().equals(str)) {
                    break;
                }
            }
            r1 = null;
            rideOauthHelper.m9730b(rideServiceParams, r1);
        } else if (rideOauthHelper.m9728a(rideServiceParams.f9309b)) {
            ThreadKey threadKey = rideServiceParams.f9309b;
            if (threadKey == null) {
                r1 = null;
            } else {
                int size = immutableList.size();
                for (r3 = 0; r3 < size; r3++) {
                    r1 = (RideProvidersModel) immutableList.get(r3);
                    if (r1.m9587n().m9574k().equals(Long.toString(threadKey.i()))) {
                        break;
                    }
                }
                r1 = null;
            }
            RideProvidersModel rideProvidersModel = r1;
            if (rideProvidersModel != null) {
                m9726a(rideOauthHelper, rideServiceParams, rideProvidersModel);
            } else {
                rideOauthHelper.m9725a();
            }
        } else {
            boolean z = true;
            if (!rideOauthHelper.f9227f.a(303, false) || immutableList.size() <= 1) {
                z = false;
            }
            if (z) {
                rideOauthHelper.m9732b(rideServiceParams, immutableList);
            } else {
                m9726a(rideOauthHelper, rideServiceParams, (RideProvidersModel) immutableList.get(0));
            }
        }
    }

    private void m9730b(RideServiceParams rideServiceParams, @Nullable RideProvidersModel rideProvidersModel) {
        if (rideProvidersModel != null) {
            m9726a(this, rideServiceParams, rideProvidersModel);
        } else {
            m9725a();
        }
    }

    private boolean m9728a(@Nullable ThreadKey threadKey) {
        if (threadKey == null) {
            return false;
        }
        User a = this.f9231j.a(UserKey.b(String.valueOf(threadKey.i())));
        if (a == null || a.v == null || !a.v.equals(CommercePageType.COMMERCE_PAGE_TYPE_RIDE_SHARE)) {
            return false;
        }
        return true;
    }

    private BusinessBottomSheetItem m9723a(RideProvidersModel rideProvidersModel) {
        BusinessBottomSheetItemBuilder businessBottomSheetItemBuilder = new BusinessBottomSheetItemBuilder(rideProvidersModel.m9587n().m9573j());
        businessBottomSheetItemBuilder.f8770a = rideProvidersModel.m9587n().m9575l().m9566a();
        businessBottomSheetItemBuilder.f8771b = this.f9222a.getResources().getDrawable(2130841348);
        if (rideProvidersModel.m9583j() != null) {
            int a = rideProvidersModel.m9583j().m9556a() / 60;
            businessBottomSheetItemBuilder.f8773d = this.f9222a.getResources().getQuantityString(2131689768, a, new Object[]{Integer.valueOf(a)});
        }
        if (!Strings.isNullOrEmpty(rideProvidersModel.m9581a())) {
            businessBottomSheetItemBuilder.f8774e = rideProvidersModel.m9581a();
        }
        return new BusinessBottomSheetItem(businessBottomSheetItemBuilder);
    }

    private void m9725a() {
        BusinessMessageDialogHelper businessMessageDialogHelper = this.f9228g;
        CharSequence string = this.f9222a.getString(2131240768);
        new FbAlertDialogBuilder(businessMessageDialogHelper.f8754a).a(string).b(this.f9222a.getString(2131240769)).a(businessMessageDialogHelper.f8754a.getResources().getString(2131236790), new C10002(businessMessageDialogHelper)).a(true).b();
    }

    private void m9731b(RideServiceParams rideServiceParams, @Nullable 31 31) {
        this.f9235n = new C10644(this);
        HandlerDetour.b(this.f9234m, this.f9235n, 1000, -814015855);
        final long now = this.f9233l.now();
        final RideServiceParams rideServiceParams2 = rideServiceParams;
        final 31 312 = 31;
        C10601 c10601 = new Object(this) {
            public final /* synthetic */ RideOauthHelper f9213d;

            public final void m9722a(ImmutableList<RideProvidersModel> immutableList) {
                this.f9213d.f9229h.m9365a(rideServiceParams2, "success", this.f9213d.f9233l.now() - now);
                RideOauthHelper.m9734c(this.f9213d);
                RideOauthHelper.m9727a(this.f9213d, rideServiceParams2, (ImmutableList) immutableList);
            }
        };
        if (m9733b(rideServiceParams)) {
            this.f9230i.m9748a(null, c10601);
        } else {
            this.f9230i.m9749a(c10601);
        }
    }

    public static void m9734c(RideOauthHelper rideOauthHelper) {
        if (rideOauthHelper.f9235n != null) {
            HandlerDetour.a(rideOauthHelper.f9234m, rideOauthHelper.f9235n);
        }
        if (rideOauthHelper.f9236o != null && rideOauthHelper.f9236o.isShowing()) {
            try {
                rideOauthHelper.f9236o.dismiss();
            } catch (IllegalArgumentException e) {
            } finally {
                rideOauthHelper.f9236o = null;
            }
        }
    }

    private ThreadKey m9724a(@Nullable ThreadKey threadKey, RideProvidersModel rideProvidersModel) {
        Preconditions.checkNotNull(rideProvidersModel.m9587n());
        return threadKey != null ? threadKey : ThreadKey.a(Long.parseLong(rideProvidersModel.m9587n().m9574k()), Long.parseLong(this.f9223b));
    }

    private void m9732b(final RideServiceParams rideServiceParams, final ImmutableList<RideProvidersModel> immutableList) {
        this.f9232k.a(Liveness.Live, ExperimentsForRideAbtestModule.f9049a);
        BusinessBottomSheetAdapter businessBottomSheetAdapter = new BusinessBottomSheetAdapter(this.f9222a);
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this.f9222a);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < immutableList.size(); i++) {
            arrayList.add(m9723a((RideProvidersModel) immutableList.get(i)));
        }
        businessBottomSheetAdapter.f8817b = arrayList;
        businessBottomSheetAdapter.f8818c = new Object(this) {
            public final /* synthetic */ RideOauthHelper f9217d;
        };
        bottomSheetDialog.a(businessBottomSheetAdapter);
        bottomSheetDialog.setOnShowListener(new OnShowListener(this) {
            final /* synthetic */ RideOauthHelper f9219b;

            public void onShow(DialogInterface dialogInterface) {
                this.f9219b.f9229h.m9368b(rideServiceParams);
            }
        });
        bottomSheetDialog.show();
    }
}
