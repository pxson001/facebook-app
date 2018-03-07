package com.facebook.growth.nux;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.login.ipc.LaunchAuthActivityUtil;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.growth.friendfinder.FriendFinderPreferenceSetter;
import com.facebook.growth.nux.analytics.NUXAnalyticsLogger;
import com.facebook.growth.nux.analytics.NUXAnalyticsLogger.Events;
import com.facebook.growth.prefs.GrowthPrefKeys;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.model.NuxStep;
import com.facebook.katana.dbl.FbAndroidAuthActivityUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nux.status.NuxStepListener;
import com.facebook.nux.status.UpdateNuxStatusParams;
import com.facebook.nux.status.UpdateNuxStatusParams.Status;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: p2p_settings_get_request_success */
public class UserAccountNUXActivity extends FbFragmentActivity implements NuxStepListener, HasTitleBar {
    public static final Class<?> f7419p = UserAccountNUXActivity.class;
    private FbAndroidAuthActivityUtil f7420A;
    private OnToolbarButtonListener f7421B;
    private OnToolbarButtonListener f7422C;
    private Provider<TriState> f7423D;
    private boolean f7424E = false;
    public ViewPager f7425q;
    private FbTitleBar f7426r;
    public NUXStepAdapter f7427s;
    private NUXStepsValidator f7428t;
    private BaseFbBroadcastManager f7429u;
    private DefaultBlueServiceOperationFactory f7430v;
    private NUXAnalyticsLogger f7431w;
    private FbSharedPreferences f7432x;
    private FriendFinderPreferenceSetter f7433y;
    private Provider<String> f7434z;

    /* compiled from: p2p_settings_get_request_success */
    class C08082 implements OnPageChangeListener {
        final /* synthetic */ UserAccountNUXActivity f7414a;

        C08082(UserAccountNUXActivity userAccountNUXActivity) {
            this.f7414a = userAccountNUXActivity;
        }

        public final void m7738a(int i, float f, int i2) {
        }

        public final void e_(int i) {
            UserAccountNUXActivity.m7749b(this.f7414a, i);
        }

        public final void m7739b(int i) {
        }
    }

    /* compiled from: p2p_settings_get_request_success */
    class C08104 implements OnClickListener {
        final /* synthetic */ UserAccountNUXActivity f7417a;

        C08104(UserAccountNUXActivity userAccountNUXActivity) {
            this.f7417a = userAccountNUXActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: p2p_settings_get_request_success */
    class C08115 implements OnClickListener {
        final /* synthetic */ UserAccountNUXActivity f7418a;

        C08115(UserAccountNUXActivity userAccountNUXActivity) {
            this.f7418a = userAccountNUXActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f7418a.m7743a(this.f7418a.f7427s.m7733e(this.f7418a.f7425q.k), Status.SKIPPED);
            UserAccountNUXActivity.m7754j(this.f7418a);
        }
    }

    private static <T extends Context> void m7746a(Class<T> cls, T t) {
        m7747a((Object) t, (Context) t);
    }

    public static void m7747a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((UserAccountNUXActivity) obj).m7744a(NUXStepAdapter.m7730b(injectorLike), NUXStepsValidator.m7734a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), NUXAnalyticsLogger.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), FriendFinderPreferenceSetter.m7544b(injectorLike), IdBasedProvider.a(injectorLike, 4442), FbAndroidAuthActivityUtil.b(injectorLike), IdBasedProvider.a(injectorLike, 690));
    }

    @Inject
    private void m7744a(NUXStepAdapter nUXStepAdapter, NUXStepsValidator nUXStepsValidator, FbBroadcastManager fbBroadcastManager, BlueServiceOperationFactory blueServiceOperationFactory, NUXAnalyticsLogger nUXAnalyticsLogger, FbSharedPreferences fbSharedPreferences, FriendFinderPreferenceSetter friendFinderPreferenceSetter, Provider<String> provider, LaunchAuthActivityUtil launchAuthActivityUtil, Provider<TriState> provider2) {
        this.f7427s = nUXStepAdapter;
        this.f7428t = nUXStepsValidator;
        this.f7429u = fbBroadcastManager;
        this.f7430v = blueServiceOperationFactory;
        this.f7431w = nUXAnalyticsLogger;
        this.f7432x = fbSharedPreferences;
        this.f7433y = friendFinderPreferenceSetter;
        this.f7434z = provider;
        this.f7420A = launchAuthActivityUtil;
        this.f7423D = provider2;
    }

    protected final void m7762b(Bundle bundle) {
        NUXStepAdapter nUXStepAdapter;
        super.b(bundle);
        Class cls = UserAccountNUXActivity.class;
        m7747a((Object) this, (Context) this);
        setContentView(2130907622);
        FbTitleBarUtil.b(this);
        this.f7426r = (FbTitleBar) a(2131558563);
        this.f7425q = (ViewPager) a(2131568007);
        NUXAnalyticsLogger nUXAnalyticsLogger = this.f7431w;
        nUXAnalyticsLogger.b.b(FunnelRegistry.f, Events.NUX_START.getEventName());
        nUXAnalyticsLogger.b.b(FunnelRegistry.g, Events.NUX_START.getEventName());
        FunnelRegistry.h.c = 600;
        nUXAnalyticsLogger.b.a(FunnelRegistry.h);
        m7759o();
        if (!StringUtil.a(getIntent().getStringExtra("show_single_step"))) {
            String[] strArr = new String[]{getIntent().getStringExtra("show_single_step")};
            nUXStepAdapter = this.f7427s;
            List arrayList = new ArrayList();
            int length = strArr.length;
            boolean z = true;
            int i = 0;
            while (i < length) {
                arrayList.add(new NuxStep(strArr[i], z));
                i++;
                z = false;
            }
            nUXStepAdapter.f7408b = nUXStepAdapter.f7410d.m7736a(arrayList);
        }
        if (this.f7427s.b() == 0) {
            m7754j(this);
        }
        nUXStepAdapter = this.f7427s;
        int i2 = 0;
        while (i2 < nUXStepAdapter.f7408b.size()) {
            if (((NuxStep) nUXStepAdapter.f7408b.get(i2)).b()) {
                break;
            }
            i2++;
        }
        i2 = 0;
        int i3 = i2;
        this.f7425q.setAdapter(this.f7427s);
        this.f7425q.setCurrentItem(i3);
        this.f7425q.setOnPageChangeListener(m7757m());
        this.f7421B = m7741a(Status.SKIPPED);
        this.f7422C = m7741a(Status.COMPLETE);
        m7749b(this, i3);
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 158125469);
        if (this.f7424E) {
            this.f7429u.a("com.facebook.growth.constants.nux_completed");
        }
        super.onDestroy();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -2049469434, a);
    }

    public void onBackPressed() {
        int i = this.f7425q.k;
        if (i > 0 && i < this.f7427s.b()) {
            this.f7425q.a(i - 1, true);
        }
    }

    public final void a_(String str) {
        this.f7426r.setTitle(str);
    }

    public final void y_(int i) {
    }

    public void setCustomTitle(View view) {
    }

    public final void m7761a(TitleBarButtonSpec titleBarButtonSpec) {
        this.f7426r.setButtonSpecs(titleBarButtonSpec == null ? null : ImmutableList.of(titleBarButtonSpec));
    }

    public final void m7763b(TitleBarButtonSpec titleBarButtonSpec) {
    }

    public final void m7760a(OnToolbarButtonListener onToolbarButtonListener) {
        this.f7426r.setOnToolbarButtonListener(onToolbarButtonListener);
    }

    public final void kg_() {
    }

    public final void m7766c(boolean z) {
    }

    @Nullable
    public final View lh_() {
        return null;
    }

    public static void m7754j(UserAccountNUXActivity userAccountNUXActivity) {
        int i = userAccountNUXActivity.f7425q.k;
        NUXAnalyticsLogger nUXAnalyticsLogger = userAccountNUXActivity.f7431w;
        String e = userAccountNUXActivity.f7427s.m7733e(i);
        nUXAnalyticsLogger.b.b(FunnelRegistry.f, "finish_" + e);
        nUXAnalyticsLogger.b.b(FunnelRegistry.g, "finish_" + e);
        nUXAnalyticsLogger.b.b(FunnelRegistry.h, "finish_" + e);
        if (i < 0 || i >= userAccountNUXActivity.f7427s.b() - 1) {
            NUXAnalyticsLogger nUXAnalyticsLogger2 = userAccountNUXActivity.f7431w;
            nUXAnalyticsLogger2.b.b(FunnelRegistry.f, Events.NUX_FINISH.getEventName());
            nUXAnalyticsLogger2.b.b(FunnelRegistry.f);
            nUXAnalyticsLogger2.b.b(FunnelRegistry.g, Events.NUX_FINISH.getEventName());
            nUXAnalyticsLogger2.b.b(FunnelRegistry.g);
            nUXAnalyticsLogger2.b.b(FunnelRegistry.h, Events.NUX_FINISH.getEventName());
            nUXAnalyticsLogger2.b.b(FunnelRegistry.h);
            userAccountNUXActivity.f7432x.edit().putBoolean(GrowthPrefKeys.b, true).commit();
            userAccountNUXActivity.f7424E = true;
            userAccountNUXActivity.f7420A.a(userAccountNUXActivity);
            return;
        }
        userAccountNUXActivity.f7425q.a(i + 1, true);
    }

    public static void m7749b(UserAccountNUXActivity userAccountNUXActivity, int i) {
        String e = userAccountNUXActivity.f7427s.m7733e(i);
        userAccountNUXActivity.m7752d(e);
        if (!"contact_importer".equals(e) || userAccountNUXActivity.f7433y.m7550c()) {
            userAccountNUXActivity.m7755k();
        }
        NUXAnalyticsLogger nUXAnalyticsLogger = userAccountNUXActivity.f7431w;
        nUXAnalyticsLogger.b.b(FunnelRegistry.f, "start_" + e);
        nUXAnalyticsLogger.b.b(FunnelRegistry.g, "start_" + e);
        nUXAnalyticsLogger.b.b(FunnelRegistry.h, "start_" + e);
        AnalyticsLogger analyticsLogger = nUXAnalyticsLogger.a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Events.NUX_STEP_VIEW.getEventName());
        honeyClientEvent.c = "account_nux";
        analyticsLogger.a(honeyClientEvent.b("step", e).b("event", "saw_step").b("platform", "android").b("event_type", "step"));
    }

    private void m7752d(String str) {
        if ("upload_profile_pic".equals(str)) {
            this.f7426r.setTitle(2131236355);
        } else if ("contact_importer".equals(str)) {
            if (this.f7433y.m7550c()) {
                this.f7426r.setTitle(2131236365);
            }
        } else if ("people_you_may_know".equals(str)) {
            this.f7426r.setTitle(2131236366);
        } else if ("native_name".equals(str)) {
            this.f7426r.setTitle(2131236370);
        }
    }

    private void m7755k() {
        String string = getResources().getString(2131236369);
        Builder a = TitleBarButtonSpec.a();
        a.g = string;
        a = a;
        a.j = string;
        this.f7426r.setButtonSpecs(ImmutableList.of(a.a()));
        this.f7426r.setOnToolbarButtonListener(this.f7421B);
    }

    private void m7756l() {
        if (this.f7426r != null) {
            String string = getResources().getString(2131236368);
            Builder a = TitleBarButtonSpec.a();
            a.g = string;
            a = a;
            a.j = string;
            this.f7426r.setButtonSpecs(ImmutableList.of(a.a()));
            this.f7426r.setOnToolbarButtonListener(this.f7422C);
        }
    }

    private OnToolbarButtonListener m7741a(final Status status) {
        return new OnToolbarButtonListener(this) {
            final /* synthetic */ UserAccountNUXActivity f7413b;

            public final void m7737a(View view, TitleBarButtonSpec titleBarButtonSpec) {
                if (this.f7413b.f7425q != null && this.f7413b.f7427s != null) {
                    String e = this.f7413b.f7427s.m7733e(this.f7413b.f7425q.k);
                    if (e.equals("contact_importer") && status.equals(Status.SKIPPED)) {
                        UserAccountNUXActivity.m7758n(this.f7413b);
                        return;
                    }
                    this.f7413b.m7743a(e, status);
                    UserAccountNUXActivity.m7754j(this.f7413b);
                }
            }
        };
    }

    private OnPageChangeListener m7757m() {
        return new C08082(this);
    }

    public final void m7764b(String str) {
        m7743a(str, Status.COMPLETE);
        m7754j(this);
    }

    public final void m7765c(String str) {
        if (NUXStepsValidator.m7735a(str)) {
            m7756l();
        }
    }

    private ListenableFuture<Boolean> m7743a(final String str, Status status) {
        if (!NUXStepsValidator.m7735a(str)) {
            return Futures.a(Boolean.valueOf(false));
        }
        UpdateNuxStatusParams updateNuxStatusParams = new UpdateNuxStatusParams("android_new_account_wizard", "1630", str, status, RegularImmutableBiMap.a);
        Bundle bundle = new Bundle();
        bundle.putParcelable("updateNuxStatusParams", updateNuxStatusParams);
        return Futures.a(BlueServiceOperationFactoryDetour.a(this.f7430v, "update_nux_status", bundle, -319963410).a(), new Function<OperationResult, Boolean>(this) {
            final /* synthetic */ UserAccountNUXActivity f7416b;

            public Object apply(@Nullable Object obj) {
                OperationResult operationResult = (OperationResult) obj;
                if (operationResult != null) {
                    return Boolean.valueOf(operationResult.b);
                }
                BLog.b(UserAccountNUXActivity.f7419p, "Null result from updating status of NUX step: " + str);
                return Boolean.valueOf(false);
            }
        });
    }

    public static void m7758n(UserAccountNUXActivity userAccountNUXActivity) {
        OnClickListener c08104 = new C08104(userAccountNUXActivity);
        new AlertDialog.Builder(userAccountNUXActivity).a(2131236365).b(userAccountNUXActivity.getString(2131236390)).a(userAccountNUXActivity.getString(2131236365), c08104).b(userAccountNUXActivity.getString(2131236369), new C08115(userAccountNUXActivity)).a(false).a().show();
    }

    private void m7759o() {
        Object a = this.f7432x.a(GrowthPrefKeys.c((String) this.f7434z.get()), null);
        if (!StringUtil.a(a)) {
            Object obj;
            String str = "upload_profile_pic";
            NUXStepAdapter nUXStepAdapter = this.f7427s;
            for (NuxStep nuxStep : nUXStepAdapter.f7408b) {
                if (nuxStep.name.compareTo(str) == 0) {
                    nUXStepAdapter.f7408b.remove(nuxStep);
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj != null) {
                m7743a(str, Status.valueOf(a));
            }
        }
    }
}
