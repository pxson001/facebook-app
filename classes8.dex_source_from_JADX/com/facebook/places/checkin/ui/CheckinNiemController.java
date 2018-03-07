package com.facebook.places.checkin.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings.System;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.checkin.abtest.ExperimentsForCheckinAbTestModule;
import com.facebook.content.ActionReceiver;
import com.facebook.content.AppInfo;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.widget.megaphone.Megaphone;
import com.facebook.fbui.widget.megaphone.Megaphone.OnDismissListener;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.Assisted;
import com.facebook.inject.IdBasedLazy;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.location.gmsupsell.GooglePlayLocationServicesSettingsManager.LocationSettingsRequestParams;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController.GoogleLocationDialogResult;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController.OnGooglePlayServicesLocationUpsellDialogFinishedListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.places.abtest.ExperimentsForPlacesAbTestModule;
import com.facebook.places.checkin.PlacePickerFragment;
import com.facebook.places.checkin.PlacePickerFragment.RefreshAction;
import com.facebook.places.checkin.analytics.PlacePickerAnalytics;
import com.facebook.qe.api.QeAccessor;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.runtimepermissions.RuntimePermissionsManager.RuntimePermissionsListener;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.LazyView;
import com.google.common.annotations.VisibleForTesting;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: checked_places */
public class CheckinNiemController implements OnGooglePlayServicesLocationUpsellDialogFinishedListener, RuntimePermissionsListener {
    public static final String[] f18080f = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    private final OnDismissListener f18081A;
    private CheckinNiemMegaphoneImplProvider f18082B;
    private CheckinNiemAlertViewImplProvider f18083C;
    private BaseCheckinNiemUI f18084D;
    @VisibleForTesting
    protected WeakReference<Activity> f18085a;
    @VisibleForTesting
    protected FbLocationStatusUtil f18086b;
    @VisibleForTesting
    protected PlacePickerAnalytics f18087c;
    @VisibleForTesting
    protected FunnelLoggerImpl f18088d;
    @VisibleForTesting
    protected boolean f18089e = false;
    public ActivityRuntimePermissionsManagerProvider f18090g;
    public ActivityRuntimePermissionsManager f18091h;
    public QeAccessor f18092i;
    public Boolean f18093j;
    public String f18094k;
    public String f18095l;
    private View f18096m;
    private PlacePickerFragment f18097n;
    public GooglePlayServicesLocationUpsellDialogController f18098o;
    public Toaster f18099p;
    public SecureContextHelper f18100q;
    private BaseFbBroadcastManager f18101r;
    public SelfRegistrableReceiverImpl f18102s;
    private RuntimePermissionsUtil f18103t;
    public String f18104u;
    private final ActionReceiver f18105v;
    private final OnClickListener f18106w;
    private final OnClickListener f18107x;
    private final OnClickListener f18108y;
    private final OnClickListener f18109z;

    /* compiled from: checked_places */
    class C19511 implements ActionReceiver {
        final /* synthetic */ CheckinNiemController f18073a;

        C19511(CheckinNiemController checkinNiemController) {
            this.f18073a = checkinNiemController;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1881016091);
            this.f18073a.m22056g();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 370518176, a);
        }
    }

    /* compiled from: checked_places */
    class C19522 implements OnClickListener {
        final /* synthetic */ CheckinNiemController f18074a;

        C19522(CheckinNiemController checkinNiemController) {
            this.f18074a = checkinNiemController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -749938276);
            CheckinNiemController.m22038a(this.f18074a, "niem_retry_click");
            CheckinNiemController.m22047x(this.f18074a);
            Logger.a(2, EntryType.UI_INPUT_END, -1714034383, a);
        }
    }

    /* compiled from: checked_places */
    class C19533 implements OnClickListener {
        final /* synthetic */ CheckinNiemController f18075a;

        C19533(CheckinNiemController checkinNiemController) {
            this.f18075a = checkinNiemController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 568323575);
            if (((Context) this.f18075a.f18085a.get()) == null) {
                Logger.a(2, EntryType.UI_INPUT_END, 2127204177, a);
                return;
            }
            this.f18075a.f18087c.n();
            CheckinNiemController.m22038a(this.f18075a, "niem_location_settings_click");
            if (this.f18075a.f18092i.a(ExperimentsForCheckinAbTestModule.e, false)) {
                this.f18075a.f18087c.p();
                this.f18075a.f18098o.a(new LocationSettingsRequestParams(), "surface_checkin_niem_controller", "mechanism_niem");
            } else {
                CheckinNiemController.m22048y(this.f18075a);
            }
            LogUtils.a(661792826, a);
        }
    }

    /* compiled from: checked_places */
    class C19544 implements OnClickListener {
        final /* synthetic */ CheckinNiemController f18076a;

        C19544(CheckinNiemController checkinNiemController) {
            this.f18076a = checkinNiemController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -566338408);
            Activity activity = (Activity) this.f18076a.f18085a.get();
            if (activity == null) {
                Logger.a(2, EntryType.UI_INPUT_END, 1451220272, a);
                return;
            }
            CheckinNiemController.m22038a(this.f18076a, "niem_network_settings_click");
            try {
                this.f18076a.f18100q.b(new Intent("android.settings.AIRPLANE_MODE_SETTINGS"), activity);
            } catch (ActivityNotFoundException e) {
                ToastBuilder toastBuilder = new ToastBuilder(activity.getResources().getString(2131235312));
                toastBuilder.a("PlacePickerNIEM");
                this.f18076a.f18099p.b(toastBuilder);
            }
            LogUtils.a(346682987, a);
        }
    }

    /* compiled from: checked_places */
    class C19555 implements OnClickListener {
        final /* synthetic */ CheckinNiemController f18077a;

        C19555(CheckinNiemController checkinNiemController) {
            this.f18077a = checkinNiemController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 778704035);
            Activity activity = (Activity) this.f18077a.f18085a.get();
            if (activity == null) {
                Logger.a(2, EntryType.UI_INPUT_END, -346483096, a);
                return;
            }
            CheckinNiemController.m22038a(this.f18077a, "niem_permission_settings_click");
            if (this.f18077a.f18091h == null) {
                this.f18077a.f18091h = this.f18077a.f18090g.a(activity);
                Resources resources = activity.getResources();
                this.f18077a.f18094k = resources.getString(2131235310);
                this.f18077a.f18095l = resources.getString(2131235311, new Object[]{this.f18077a.f18104u});
            }
            this.f18077a.f18091h.a(CheckinNiemController.f18080f, this.f18077a.f18094k, this.f18077a.f18095l, this.f18077a);
            LogUtils.a(599101845, a);
        }
    }

    /* compiled from: checked_places */
    class C19566 implements OnDismissListener {
        final /* synthetic */ CheckinNiemController f18078a;

        C19566(CheckinNiemController checkinNiemController) {
            this.f18078a = checkinNiemController;
        }

        public final void m22037a(Megaphone megaphone) {
            CheckinNiemController.m22038a(this.f18078a, "dismiss_niem");
            this.f18078a.f18087c.q();
            this.f18078a.m22053c().mo1072a();
        }
    }

    /* compiled from: checked_places */
    /* synthetic */ class C19577 {
        static final /* synthetic */ int[] f18079a = new int[GoogleLocationDialogResult.values().length];

        static {
            try {
                f18079a[GoogleLocationDialogResult.DIALOG_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18079a[GoogleLocationDialogResult.DIALOG_NOT_NEEDED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18079a[GoogleLocationDialogResult.DIALOG_CANCEL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f18079a[GoogleLocationDialogResult.DIALOG_NOT_POSSIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f18079a[GoogleLocationDialogResult.UNKNOWN_FAILURE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    @Inject
    public CheckinNiemController(@Assisted View view, @Assisted Activity activity, @Assisted PlacePickerFragment placePickerFragment, @Assisted GooglePlayServicesLocationUpsellDialogController googlePlayServicesLocationUpsellDialogController, QeAccessor qeAccessor, PlacePickerAnalytics placePickerAnalytics, FbLocationStatusUtil fbLocationStatusUtil, BaseFbBroadcastManager baseFbBroadcastManager, RuntimePermissionsUtil runtimePermissionsUtil, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, AppInfo appInfo, Toaster toaster, SecureContextHelper secureContextHelper, FunnelLoggerImpl funnelLoggerImpl, CheckinNiemMegaphoneImplProvider checkinNiemMegaphoneImplProvider, CheckinNiemAlertViewImplProvider checkinNiemAlertViewImplProvider) {
        this.f18085a = new WeakReference(activity);
        this.f18097n = placePickerFragment;
        this.f18098o = googlePlayServicesLocationUpsellDialogController;
        this.f18092i = qeAccessor;
        this.f18087c = placePickerAnalytics;
        this.f18086b = fbLocationStatusUtil;
        this.f18101r = baseFbBroadcastManager;
        this.f18103t = runtimePermissionsUtil;
        this.f18090g = activityRuntimePermissionsManagerProvider;
        this.f18099p = toaster;
        this.f18100q = secureContextHelper;
        this.f18088d = funnelLoggerImpl;
        this.f18082B = checkinNiemMegaphoneImplProvider;
        this.f18083C = checkinNiemAlertViewImplProvider;
        this.f18096m = view;
        this.f18104u = (String) activity.getApplicationContext().getPackageManager().getApplicationLabel(appInfo.b(activity.getPackageName(), 0));
        if (this.f18104u == null) {
            this.f18104u = "Facebook";
        }
        this.f18105v = m22039p();
        this.f18106w = m22040q();
        this.f18107x = m22041r();
        this.f18108y = m22042s();
        this.f18109z = m22043t();
        this.f18081A = m22044u();
    }

    @VisibleForTesting
    public final BaseCheckinNiemUI m22053c() {
        if (this.f18084D == null) {
            if (this.f18093j == null) {
                this.f18093j = Boolean.valueOf(this.f18092i.a(ExperimentsForPlacesAbTestModule.a, false));
            }
            if (this.f18093j.booleanValue()) {
                ViewStub viewStub = (ViewStub) this.f18096m.findViewById(2131565976);
                CheckinNiemAlertViewImplProvider checkinNiemAlertViewImplProvider = this.f18083C;
                this.f18084D = new CheckinNiemAlertViewImpl(new LazyView(viewStub), this.f18104u, (Context) checkinNiemAlertViewImplProvider.getInstance(Context.class), IdBasedLazy.a(checkinNiemAlertViewImplProvider, 3585));
            } else {
                this.f18084D = new CheckinNiemMegaphoneImpl(new LazyView((ViewStub) this.f18096m.findViewById(2131565975)), this.f18104u, (Context) this.f18082B.getInstance(Context.class));
            }
        }
        return this.f18084D;
    }

    private ActionReceiver m22039p() {
        return new C19511(this);
    }

    private OnClickListener m22040q() {
        return new C19522(this);
    }

    private OnClickListener m22041r() {
        return new C19533(this);
    }

    private OnClickListener m22042s() {
        return new C19544(this);
    }

    private OnClickListener m22043t() {
        return new C19555(this);
    }

    private OnDismissListener m22044u() {
        return new C19566(this);
    }

    private void m22045v() {
        if (!this.f18089e) {
            this.f18089e = true;
            this.f18102s = this.f18101r.a().a("android.location.PROVIDERS_CHANGED", this.f18105v).a("android.net.conn.CONNECTIVITY_CHANGE", this.f18105v).a();
            this.f18102s.b();
        }
    }

    public final boolean m22054e() {
        return (mo1082j() && mo1083k() && !mo1084l() && mo1085n()) ? false : true;
    }

    public final void m22055f() {
        m22045v();
        if (m22053c().mo1074a(this.f18106w, this.f18081A) && !m22046w()) {
            m22053c().mo1073a(this.f18106w);
            m22038a(this, "timeout_niem");
        }
    }

    public final void m22056g() {
        m22045v();
        if (!m22053c().mo1074a(this.f18106w, this.f18081A) || m22046w()) {
            return;
        }
        if (!mo1085n()) {
            m22053c().mo1077c(this.f18107x);
            this.f18087c.l();
            m22038a(this, "location_disabled_niem");
        } else if (mo1084l()) {
            m22053c().mo1076b(this.f18107x);
            this.f18087c.m();
            m22038a(this, "non_optimal_niem");
        } else if (m22053c().m22024c()) {
            m22053c().mo1072a();
        }
    }

    private boolean m22046w() {
        if (!mo1082j()) {
            m22053c().mo1080f(this.f18109z);
            m22038a(this, "permissions_niem");
            return true;
        } else if (mo1081i() && !mo1083k()) {
            m22053c().mo1079e(this.f18108y);
            m22038a(this, "airplane_niem");
            return true;
        } else if (mo1083k()) {
            return false;
        } else {
            m22053c().mo1078d(this.f18108y);
            m22038a(this, "network_niem");
            return true;
        }
    }

    public final void m22050a(GoogleLocationDialogResult googleLocationDialogResult) {
        switch (C19577.f18079a[googleLocationDialogResult.ordinal()]) {
            case 1:
            case 2:
                this.f18087c.g("gms_upsell_result_succeeded");
                return;
            case 3:
                this.f18087c.g("gms_upsell_result_canceled");
                return;
            default:
                this.f18087c.g("gms_upsell_result_failed");
                m22048y(this);
                return;
        }
    }

    public boolean mo1081i() {
        if (this.f18085a == null) {
            Context context = null;
        } else {
            Activity activity = (Activity) this.f18085a.get();
        }
        if (context == null) {
            return false;
        }
        return System.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 1;
    }

    public boolean mo1082j() {
        return this.f18103t.a(f18080f);
    }

    public boolean mo1083k() {
        Context context = null;
        String property = System.getProperty("places.connectivity_override", null);
        if (property != null) {
            return Boolean.valueOf(property).booleanValue();
        }
        if (this.f18085a != null) {
            Activity activity = (Activity) this.f18085a.get();
        }
        if (context == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @VisibleForTesting
    protected boolean mo1084l() {
        return this.f18086b.b().c.contains("network");
    }

    public static void m22047x(CheckinNiemController checkinNiemController) {
        PlacePickerFragment placePickerFragment = checkinNiemController.f18097n;
        placePickerFragment.aU = RefreshAction.NIEM_CLICKED;
        placePickerFragment.f17978i.x();
        PlacePickerFragment.aQ(placePickerFragment);
        checkinNiemController.m22056g();
    }

    public static void m22048y(CheckinNiemController checkinNiemController) {
        checkinNiemController.f18087c.o();
        checkinNiemController.f18100q.b(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), (Context) checkinNiemController.f18085a.get());
    }

    public final boolean m22061m() {
        return this.f18089e && m22053c().m22024c();
    }

    public static void m22038a(CheckinNiemController checkinNiemController, String str) {
        checkinNiemController.f18088d.b(FunnelRegistry.o, str);
    }

    @VisibleForTesting
    protected boolean mo1085n() {
        return this.f18086b.a() == State.OKAY;
    }

    public final void m22049a() {
        m22047x(this);
    }

    public final void m22051a(String[] strArr, String[] strArr2) {
    }

    public final void m22052b() {
    }
}
