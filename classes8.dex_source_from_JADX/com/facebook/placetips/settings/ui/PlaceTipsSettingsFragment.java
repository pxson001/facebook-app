package com.facebook.placetips.settings.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.facebook.auth.annotations.IsMeUserAnEmployee;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.calls.GravitySettingsForUserUpdateInputData.FeatureEnabled;
import com.facebook.graphql.calls.GravitySettingsForUserUpdateInputData.NotificationsEnabled;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.placetips.bootstrap.IsUserPlaceTipsDebugEmployee;
import com.facebook.placetips.settings.PlaceTipsSettingsHelper;
import com.facebook.placetips.settings.PlaceTipsSettingsHelper.C04931;
import com.facebook.placetips.settings.PlaceTipsSettingsHelper.C04942;
import com.facebook.placetips.settings.PlaceTipsSettingsPrefs.Accessor;
import com.facebook.placetips.settings.graphql.GravitySettingsGraphQlFragmentInterfaces.GravitySettingsGraphQlFragment;
import com.facebook.placetips.settings.graphql.GravitySettingsGraphQlFragmentModels.GravitySettingsGraphQlFragmentModel;
import com.facebook.placetips.settings.graphql.GravitySettingsQuery;
import com.facebook.placetips.settings.ui.abtest.ExperimentsForPlaceTipsSettingsUiModule;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.BetterSwitch;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: captcha/challenges */
public class PlaceTipsSettingsFragment extends FbFragment {
    public static final CallerContext am = CallerContext.a(PlaceTipsSettingsFragment.class);
    @Inject
    SecureContextHelper f18456a;
    @Inject
    public QeAccessor al;
    private final OnCheckedChangeListener an = new C20261(this);
    private View ao;
    private View ap;
    private View aq;
    private BetterSwitch ar;
    private View as;
    private View at;
    private View au;
    private TextView av;
    private TextView aw;
    @Inject
    UriIntentMapper f18457b;
    @Inject
    AbstractFbErrorReporter f18458c;
    @Inject
    public Lazy<Accessor> f18459d;
    @Inject
    Toaster f18460e;
    @Inject
    @IsMeUserAnEmployee
    Provider<TriState> f18461f;
    @Inject
    @IsUserPlaceTipsDebugEmployee
    Provider<Boolean> f18462g;
    @Inject
    public PlaceTipsSettingsHelper f18463h;
    @Inject
    public TasksManager f18464i;

    /* compiled from: captcha/challenges */
    class C20261 implements OnCheckedChangeListener {
        final /* synthetic */ PlaceTipsSettingsFragment f18445a;

        C20261(PlaceTipsSettingsFragment placeTipsSettingsFragment) {
            this.f18445a = placeTipsSettingsFragment;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            PlaceTipsSettingsFragment placeTipsSettingsFragment = this.f18445a;
            FeatureEnabled featureEnabled = z ? FeatureEnabled.ENABLED : FeatureEnabled.DISABLED;
            if (featureEnabled != null || null != null) {
                ListenableFuture a;
                DialogFragment a2 = ProgressDialogFragment.a(2131230739, true, false, false);
                a2.a(placeTipsSettingsFragment.kO_(), "save_setting_progress");
                if (null != NotificationsEnabled.ENABLED || ((Accessor) placeTipsSettingsFragment.f18459d.get()).f()) {
                    a = placeTipsSettingsFragment.f18463h.m3889a(featureEnabled, null);
                } else {
                    a = Futures.b(placeTipsSettingsFragment.f18463h.m3888a(PlaceTipsSettingsFragment.am), new C20327(placeTipsSettingsFragment, featureEnabled, null), MoreExecutors.a());
                }
                placeTipsSettingsFragment.f18464i.a(Task.TOUCH_SETTINGS, a, new C20338(placeTipsSettingsFragment, a2));
            }
        }
    }

    /* compiled from: captcha/challenges */
    class C20272 implements OnClickListener {
        final /* synthetic */ PlaceTipsSettingsFragment f18446a;

        C20272(PlaceTipsSettingsFragment placeTipsSettingsFragment) {
            this.f18446a = placeTipsSettingsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1067100440);
            PlaceTipsSettingsFragment.m22389e(this.f18446a);
            Logger.a(2, EntryType.UI_INPUT_END, -1919528506, a);
        }
    }

    /* compiled from: captcha/challenges */
    class C20283 implements OnClickListener {
        final /* synthetic */ PlaceTipsSettingsFragment f18447a;

        C20283(PlaceTipsSettingsFragment placeTipsSettingsFragment) {
            this.f18447a = placeTipsSettingsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 490897501);
            GravitySettingsGraphQlFragmentModel b = ((Accessor) this.f18447a.f18459d.get()).b();
            if (!(b == null || b.b() == null)) {
                PlaceTipsSettingsFragment.m22386a(this.f18447a, b.b());
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1825610892, a);
        }
    }

    /* compiled from: captcha/challenges */
    class C20294 implements OnClickListener {
        final /* synthetic */ PlaceTipsSettingsFragment f18448a;

        C20294(PlaceTipsSettingsFragment placeTipsSettingsFragment) {
            this.f18448a = placeTipsSettingsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1927125468);
            PlaceTipsSettingsFragment.m22386a(this.f18448a, FBLinks.db);
            Logger.a(2, EntryType.UI_INPUT_END, 1860074945, a);
        }
    }

    /* compiled from: captcha/challenges */
    class C20305 implements OnClickListener {
        final /* synthetic */ PlaceTipsSettingsFragment f18449a;

        C20305(PlaceTipsSettingsFragment placeTipsSettingsFragment) {
            this.f18449a = placeTipsSettingsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -185447353);
            PlaceTipsSettingsFragment.m22386a(this.f18449a, FBLinks.cZ);
            Logger.a(2, EntryType.UI_INPUT_END, -951037523, a);
        }
    }

    /* compiled from: captcha/challenges */
    class C20316 extends AbstractDisposableFutureCallback<GravitySettingsGraphQlFragment> {
        final /* synthetic */ PlaceTipsSettingsFragment f18450a;

        C20316(PlaceTipsSettingsFragment placeTipsSettingsFragment) {
            this.f18450a = placeTipsSettingsFragment;
        }

        protected final void m22378a(Object obj) {
            PlaceTipsSettingsFragment.m22384a(this.f18450a, (GravitySettingsGraphQlFragmentModel) obj);
            PlaceTipsSettingsFragment.m22385a(this.f18450a, DisplayStatus.SETTINGS);
        }

        protected final void m22379a(Throwable th) {
            PlaceTipsSettingsFragment.m22385a(this.f18450a, DisplayStatus.ERROR);
        }
    }

    /* compiled from: captcha/challenges */
    public class C20327 implements AsyncFunction<OperationResult, GravitySettingsGraphQlFragment> {
        final /* synthetic */ FeatureEnabled f18451a;
        final /* synthetic */ NotificationsEnabled f18452b;
        final /* synthetic */ PlaceTipsSettingsFragment f18453c;

        public C20327(PlaceTipsSettingsFragment placeTipsSettingsFragment, FeatureEnabled featureEnabled, NotificationsEnabled notificationsEnabled) {
            this.f18453c = placeTipsSettingsFragment;
            this.f18451a = featureEnabled;
            this.f18452b = notificationsEnabled;
        }

        public final ListenableFuture m22380a(Object obj) {
            return this.f18453c.f18463h.m3889a(this.f18451a, this.f18452b);
        }
    }

    /* compiled from: captcha/challenges */
    public class C20338 extends AbstractDisposableFutureCallback<GravitySettingsGraphQlFragment> {
        final /* synthetic */ DialogFragment f18454a;
        final /* synthetic */ PlaceTipsSettingsFragment f18455b;

        public C20338(PlaceTipsSettingsFragment placeTipsSettingsFragment, DialogFragment dialogFragment) {
            this.f18455b = placeTipsSettingsFragment;
            this.f18454a = dialogFragment;
        }

        protected final void m22381a(Object obj) {
            GravitySettingsGraphQlFragmentModel gravitySettingsGraphQlFragmentModel = (GravitySettingsGraphQlFragmentModel) obj;
            this.f18454a.b();
            PlaceTipsSettingsFragment.m22384a(this.f18455b, gravitySettingsGraphQlFragmentModel);
        }

        protected final void m22382a(Throwable th) {
            this.f18454a.b();
            this.f18455b.f18460e.b(new ToastBuilder(2131230758));
            PlaceTipsSettingsFragment.aq(this.f18455b);
            this.f18455b.f18458c.a("place_tips_settings_save", "Failed to update gravity settings", th);
        }
    }

    /* compiled from: captcha/challenges */
    enum DisplayStatus {
        SETTINGS(true, false, false),
        PROGRESS(false, false, true),
        ERROR(false, true, false);
        
        final int errorVisibility;
        final int progressVisibility;
        final int settingsVisibility;

        private DisplayStatus(boolean z, boolean z2, boolean z3) {
            int i;
            int i2 = 0;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            this.settingsVisibility = i;
            if (z2) {
                i = 0;
            } else {
                i = 8;
            }
            this.errorVisibility = i;
            if (!z3) {
                i2 = 8;
            }
            this.progressVisibility = i2;
        }
    }

    /* compiled from: captcha/challenges */
    public enum Task {
        TOUCH_SETTINGS
    }

    public static void m22387a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PlaceTipsSettingsFragment) obj).m22383a((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedLazy.a(injectorLike, 3022), Toaster.b(injectorLike), IdBasedProvider.a(injectorLike, 640), IdBasedProvider.a(injectorLike, 4262), PlaceTipsSettingsHelper.m3886a(injectorLike), TasksManager.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    private void m22383a(SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper, FbErrorReporter fbErrorReporter, Lazy<Accessor> lazy, Toaster toaster, Provider<TriState> provider, Provider<Boolean> provider2, PlaceTipsSettingsHelper placeTipsSettingsHelper, TasksManager tasksManager, QeAccessor qeAccessor) {
        this.f18456a = secureContextHelper;
        this.f18457b = uriIntentMapper;
        this.f18458c = fbErrorReporter;
        this.f18459d = lazy;
        this.f18460e = toaster;
        this.f18461f = provider;
        this.f18462g = provider2;
        this.f18463h = placeTipsSettingsHelper;
        this.f18464i = tasksManager;
        this.al = qeAccessor;
    }

    public final void m22393c(Bundle bundle) {
        super.c(bundle);
        Class cls = PlaceTipsSettingsFragment.class;
        m22387a((Object) this, getContext());
    }

    public final View m22391a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -447351088);
        View inflate = layoutInflater.inflate(2130906285, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1673208993, a);
        return inflate;
    }

    public final void m22392a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.ao = e(2131566055);
        this.ap = e(2131566064);
        this.aq = e(2131566065);
        this.ar = (BetterSwitch) e(2131566057);
        this.as = e(2131566060);
        this.at = e(2131566061);
        this.au = e(2131566062);
        this.av = (TextView) e(2131566058);
        this.av.setText(this.al.a(Liveness.Live, ExperimentsForPlaceTipsSettingsUiModule.f18470a, 2131239379, jW_()));
        this.aw = (TextView) e(2131566059);
        this.aw.setText(this.al.a(Liveness.Live, ExperimentsForPlaceTipsSettingsUiModule.f18471b, 2131239392, jW_()));
        this.aq.setOnClickListener(new C20272(this));
        this.as.setOnClickListener(new C20283(this));
        this.at.setOnClickListener(new C20294(this));
        Object obj = 1;
        Bundle bundle2 = this.s;
        if (bundle2 != null && FBLinks.cZ.equals(bundle2.getString("extra_from_uri"))) {
            obj = null;
        }
        if (obj != null) {
            this.au.setOnClickListener(new C20305(this));
        } else {
            this.au.setVisibility(8);
        }
        if (((TriState) this.f18461f.get()).asBoolean(false) && ((Boolean) this.f18462g.get()).booleanValue() && s().a(2131566063) == null) {
            s().a().a(2131566063, new PlaceTipsEmployeeSettingsFragment()).b();
        }
        m22389e(this);
    }

    public final void m22390G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -245584675);
        super.G();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131239376);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1427166458, a);
    }

    public static void m22386a(PlaceTipsSettingsFragment placeTipsSettingsFragment, String str) {
        placeTipsSettingsFragment.f18456a.a(placeTipsSettingsFragment.f18457b.a(placeTipsSettingsFragment.getContext(), str).putExtra("extra_from_uri", FBLinks.da), placeTipsSettingsFragment.getContext());
    }

    public static void m22385a(PlaceTipsSettingsFragment placeTipsSettingsFragment, DisplayStatus displayStatus) {
        placeTipsSettingsFragment.ao.setVisibility(displayStatus.settingsVisibility);
        placeTipsSettingsFragment.ap.setVisibility(displayStatus.progressVisibility);
        placeTipsSettingsFragment.aq.setVisibility(displayStatus.errorVisibility);
    }

    private void m22388a(boolean z) {
        this.ar.setOnCheckedChangeListener(null);
        this.ar.setChecked(z);
        this.ar.setOnCheckedChangeListener(this.an);
    }

    public static void m22389e(PlaceTipsSettingsFragment placeTipsSettingsFragment) {
        m22385a(placeTipsSettingsFragment, DisplayStatus.PROGRESS);
        TasksManager tasksManager = placeTipsSettingsFragment.f18464i;
        Task task = Task.TOUCH_SETTINGS;
        PlaceTipsSettingsHelper placeTipsSettingsHelper = placeTipsSettingsFragment.f18463h;
        ListenableFuture b = Futures.b(((GraphQLQueryExecutor) placeTipsSettingsHelper.f3917b.get()).a(GraphQLRequest.a(GravitySettingsQuery.a()).a(GraphQLCachePolicy.c)), new C04931(placeTipsSettingsHelper), MoreExecutors.a());
        Futures.a(b, new C04942(placeTipsSettingsHelper), MoreExecutors.a());
        tasksManager.a(task, b, new C20316(placeTipsSettingsFragment));
    }

    public static void m22384a(PlaceTipsSettingsFragment placeTipsSettingsFragment, GravitySettingsGraphQlFragmentModel gravitySettingsGraphQlFragmentModel) {
        placeTipsSettingsFragment.m22388a(gravitySettingsGraphQlFragmentModel.a());
        placeTipsSettingsFragment.aw.setVisibility(gravitySettingsGraphQlFragmentModel.c() ? 0 : 8);
    }

    public static void aq(PlaceTipsSettingsFragment placeTipsSettingsFragment) {
        placeTipsSettingsFragment.m22388a(((Accessor) placeTipsSettingsFragment.f18459d.get()).c());
        placeTipsSettingsFragment.aw.setVisibility(((Accessor) placeTipsSettingsFragment.f18459d.get()).f() ? 0 : 8);
    }
}
