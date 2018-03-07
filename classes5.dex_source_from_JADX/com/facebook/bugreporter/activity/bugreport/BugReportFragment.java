package com.facebook.bugreporter.activity.bugreport;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.actionbar.AppCompatFragmentOverrider;
import com.facebook.actionbar.FragmentActionBarHost;
import com.facebook.auth.module.TriState_IsMeUserAnEmployeeMethodAutoProvider;
import com.facebook.base.fragment.FbFragment;
import com.facebook.base.fragment.NavigableFragment;
import com.facebook.base.fragment.NavigableFragment.Listener;
import com.facebook.bugreporter.BugReport;
import com.facebook.bugreporter.BugReportAttachment;
import com.facebook.bugreporter.BugReportBuilder;
import com.facebook.bugreporter.BugReportRetryManager;
import com.facebook.bugreporter.BugReportWriter;
import com.facebook.bugreporter.BugReporterFileUtil;
import com.facebook.bugreporter.BugReportingData;
import com.facebook.bugreporter.BugReportingXConfig;
import com.facebook.bugreporter.analytics.BugReporterAnalyticsLogger;
import com.facebook.bugreporter.analytics.BugReporterAnalyticsLogger.CoreEvent;
import com.facebook.bugreporter.imagepicker.BugReporterImagePickerFragment.ImagePickerContainer;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.build.SignatureType;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.manifest.AppBuildInfo;
import com.facebook.common.manifest.AppBuildInfoMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.common.util.TriState;
import com.facebook.config.application.SignatureTypeMethodAutoProvider;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.text.CustomUrlLikeSpan;
import com.facebook.widget.text.CustomUrlLikeSpan.OnUrlClickHandler;
import com.facebook.widget.titlebar.ActionBarBasedFbTitleBar;
import com.facebook.widget.titlebar.FbActionBarUtil;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar$OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: android.media.metadata.DISC_NUMBER */
public class BugReportFragment extends FbFragment implements NavigableFragment, ImagePickerContainer {
    public static final Class<?> f10684a = BugReportFragment.class;
    public Provider<Boolean> aA;
    public ListenableFuture aB;
    public BugReportWriter aC;
    public XConfigReader aD;
    public BugReporterFileUtil al;
    public BugReportRetryManager am;
    public Clock an;
    public BugReportBuilder ao;
    public Listener ap;
    public EditText aq;
    private TextView ar;
    private boolean as;
    public boolean at;
    private boolean au;
    private boolean av;
    private AppCompatFragmentOverrider aw;
    private FbTitleBar ax;
    private ActionBarBasedFbTitleBar ay;
    private Provider<AppCompatFragmentOverrider> az;
    public AppVersionInfo f10685b;
    public ListeningExecutorService f10686c;
    private Executor f10687d;
    public AppBuildInfo f10688e;
    public SignatureType f10689f;
    public Toaster f10690g;
    public SecureContextHelper f10691h;
    public BugReporterAnalyticsLogger f10692i;

    /* compiled from: android.media.metadata.DISC_NUMBER */
    class C10241 implements Callable<BugReportBuilder> {
        final /* synthetic */ BugReportFragment f10672a;

        C10241(BugReportFragment bugReportFragment) {
            this.f10672a = bugReportFragment;
        }

        public Object call() {
            return this.f10672a.aC.m18623a(this.f10672a.ao);
        }
    }

    /* compiled from: android.media.metadata.DISC_NUMBER */
    class C10252 extends FbTitleBar$OnToolbarButtonListener {
        final /* synthetic */ BugReportFragment f10673a;

        C10252(BugReportFragment bugReportFragment) {
            this.f10673a = bugReportFragment;
        }

        public final void mo1123a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            BugReportFragment bugReportFragment = this.f10673a;
            String obj = bugReportFragment.aq.getText().toString();
            if (Strings.isNullOrEmpty(obj)) {
                bugReportFragment.f10690g.b(new ToastBuilder(2131235800));
                return;
            }
            boolean z = !((Boolean) bugReportFragment.aA.get()).booleanValue();
            ProgressDialog progressDialog = new ProgressDialog(bugReportFragment.getContext());
            progressDialog.setTitle("Finalizing Bug Report");
            progressDialog.a("Please wait");
            progressDialog.show();
            Futures.a(bugReportFragment.aB, new C10284(bugReportFragment, z, obj, progressDialog), bugReportFragment.f10686c);
        }
    }

    /* compiled from: android.media.metadata.DISC_NUMBER */
    class C10263 extends OnUrlClickHandler {
        final /* synthetic */ BugReportFragment f10674a;

        C10263(BugReportFragment bugReportFragment) {
            this.f10674a = bugReportFragment;
        }

        public final void mo1124a() {
            this.f10674a.f10691h.b(new Intent("android.intent.action.VIEW", Uri.parse("http://m.facebook.com/about/privacy")), this.f10674a.getContext());
        }
    }

    /* compiled from: android.media.metadata.DISC_NUMBER */
    public class C10284 implements FutureCallback<BugReportBuilder> {
        final /* synthetic */ boolean f10677a;
        final /* synthetic */ String f10678b;
        final /* synthetic */ ProgressDialog f10679c;
        final /* synthetic */ BugReportFragment f10680d;

        public C10284(BugReportFragment bugReportFragment, boolean z, String str, ProgressDialog progressDialog) {
            this.f10680d = bugReportFragment;
            this.f10677a = z;
            this.f10678b = str;
            this.f10679c = progressDialog;
        }

        public void onSuccess(@Nullable Object obj) {
            BugReportBuilder bugReportBuilder = (BugReportBuilder) obj;
            if (this.f10677a && bugReportBuilder != null) {
                BugReportFragment.ar(this.f10680d);
                BugReportFragment bugReportFragment = this.f10680d;
                String str = this.f10678b;
                bugReportBuilder.f10442d = bugReportFragment.ao.m18540d();
                bugReportBuilder.f10440b = str;
                long b = (long) bugReportFragment.f10685b.b();
                String valueOf = b >= 0 ? String.valueOf(b) : "";
                bugReportBuilder.f10449k = bugReportFragment.f10688e.f2699a;
                bugReportBuilder.f10450l = valueOf;
                if (bugReportFragment.f10689f == SignatureType.PROD) {
                    bugReportBuilder.f10451m = null;
                    bugReportBuilder.f10452n = null;
                } else {
                    bugReportBuilder.f10451m = bugReportFragment.f10688e.f2702d;
                    bugReportBuilder.f10452n = bugReportFragment.f10688e.f2700b;
                }
                final Object x = bugReportBuilder.m18542x();
                if (BuildConstants.i) {
                    BugReportFragment bugReportFragment2 = this.f10680d;
                    Parcel obtain = Parcel.obtain();
                    obtain.writeParcelable(x, 0);
                    Integer.valueOf(obtain.dataSize());
                    obtain.recycle();
                }
                ExecutorDetour.a(this.f10680d.f10686c, new Runnable(this) {
                    final /* synthetic */ C10284 f10676b;

                    public void run() {
                        try {
                            this.f10676b.f10680d.al.m18658b(x);
                        } catch (Throwable e) {
                            BLog.b(BugReportFragment.f10684a, e, "Failed to persist serialized bug report.", new Object[0]);
                        }
                        this.f10676b.f10680d.am.m18560a(x);
                    }
                }, 1665904756);
                this.f10680d.f10692i.m18746a(CoreEvent.BUG_REPORT_DID_COMPLETE);
            }
            this.f10679c.dismiss();
            Intent intent = new Intent();
            intent.putExtra("isSendClickedFlag", true);
            this.f10680d.ap.mo564a(this.f10680d, intent);
            this.f10680d.at = true;
        }

        public void onFailure(Throwable th) {
            this.f10679c.dismiss();
            Intent intent = new Intent();
            intent.putExtra("isSendClickedFlag", true);
            this.f10680d.ap.mo564a(this.f10680d, intent);
            this.f10680d.at = true;
        }
    }

    /* compiled from: android.media.metadata.DISC_NUMBER */
    class C10306 implements FutureCallback<Uri> {
        final /* synthetic */ BugReportFragment f10683a;

        C10306(BugReportFragment bugReportFragment) {
            this.f10683a = bugReportFragment;
        }

        public void onSuccess(Object obj) {
            Uri uri = (Uri) obj;
            BugReportBuilder bugReportBuilder = this.f10683a.ao;
            if (bugReportBuilder.f10442d == null) {
                bugReportBuilder.f10442d = Lists.a();
            }
            bugReportBuilder.f10442d.add(uri);
        }

        public void onFailure(Throwable th) {
            BLog.b(BugReportFragment.f10684a, "Unable to copy attachment for bug report.", th);
        }
    }

    public static void m18709a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((BugReportFragment) obj).m18708a(FbActionBarUtil.a(injectorLike), IdBasedProvider.a(injectorLike, 4578), AppVersionInfoMethodAutoProvider.a(injectorLike), BugReportRetryManager.m18550a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), AppBuildInfoMethodAutoProvider.m3809a(injectorLike), SignatureTypeMethodAutoProvider.a(injectorLike), Toaster.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), BugReporterAnalyticsLogger.m18741a(injectorLike), BugReporterFileUtil.m18646a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), TriState_IsMeUserAnEmployeeMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3908), BugReportWriter.m18602a(injectorLike), XConfigReader.a(injectorLike));
    }

    @Inject
    private void m18708a(FbActionBarUtil fbActionBarUtil, Provider<AppCompatFragmentOverrider> provider, AppVersionInfo appVersionInfo, BugReportRetryManager bugReportRetryManager, ListeningExecutorService listeningExecutorService, Executor executor, AppBuildInfo appBuildInfo, SignatureType signatureType, Toaster toaster, SecureContextHelper secureContextHelper, BugReporterAnalyticsLogger bugReporterAnalyticsLogger, BugReporterFileUtil bugReporterFileUtil, Clock clock, TriState triState, Provider<Boolean> provider2, BugReportWriter bugReportWriter, XConfigReader xConfigReader) {
        this.az = provider;
        this.f10685b = appVersionInfo;
        this.am = bugReportRetryManager;
        this.f10686c = listeningExecutorService;
        this.f10687d = executor;
        this.f10688e = appBuildInfo;
        this.f10689f = signatureType;
        this.f10690g = toaster;
        this.f10691h = secureContextHelper;
        this.f10692i = bugReporterAnalyticsLogger;
        this.al = bugReporterFileUtil;
        this.an = clock;
        this.av = fbActionBarUtil.a();
        this.au = triState.asBoolean(false);
        this.aA = provider2;
        this.aC = bugReportWriter;
        this.aD = xConfigReader;
    }

    public final void m18720c(Bundle bundle) {
        BugReport bugReport;
        super.c(bundle);
        Class cls = BugReportFragment.class;
        m18709a((Object) this, getContext());
        if (this.av) {
            this.aw = (AppCompatFragmentOverrider) this.az.get();
            this.aw.f8012b = new FragmentActionBarHost(this);
            a(this.aw);
            this.aw.m14165a(8);
        }
        if (bundle != null) {
            bugReport = (BugReport) bundle.getParcelable("report");
        } else {
            bugReport = (BugReport) this.s.getParcelable("report");
        }
        if (bugReport == null) {
            BLog.a(f10684a, "Missing bug report in intent");
            this.ap.mo564a(this, null);
            this.at = true;
            return;
        }
        this.ao = BugReport.newBuilder().m18535a(bugReport);
    }

    public final View m18713a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1478706704);
        View inflate = layoutInflater.inflate(2130903457, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -587981450, a);
        return inflate;
    }

    public final void m18721d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 446651617);
        super.d(bundle);
        this.aB = this.f10686c.a(new C10241(this));
        if (this.av) {
            this.ay = new ActionBarBasedFbTitleBar(this, this.aw.m14170f());
            this.ax = this.ay;
            e(true);
        } else {
            FbTitleBarUtil.a(this.T);
            this.ax = (FbTitleBar) e(2131558563);
        }
        this.ax.setTitle(2131235796);
        this.aq = (EditText) e(2131558966);
        if (this.au) {
            this.aq.setHint("May others login as you to debug? How do you reproduce the issue?");
        }
        this.ar = (TextView) e(2131560064);
        Builder a2 = TitleBarButtonSpec.a();
        a2.a = 1;
        a2 = a2;
        a2.g = b(2131235817);
        a2 = a2;
        a2.h = -2;
        this.ax.setButtonSpecs(ImmutableList.of(a2.a()));
        this.ax.setOnToolbarButtonListener(new C10252(this));
        if (this.ao.f10440b != null) {
            this.aq.setText(this.ao.f10440b);
            this.as = true;
        }
        Object customUrlLikeSpan = new CustomUrlLikeSpan();
        customUrlLikeSpan.f5854a = new C10263(this);
        Resources jW_ = jW_();
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(jW_());
        styledStringBuilder.m3921a(jW_.getString(2131235797));
        styledStringBuilder.m3925a("[[link]]", jW_.getString(2131235798), customUrlLikeSpan, 33);
        this.ar.setText(styledStringBuilder.m3926b());
        this.ar.setMovementMethod(LinkMovementMethod.getInstance());
        LogUtils.f(41436403, a);
    }

    public final void m18722e(Bundle bundle) {
        super.e(bundle);
        this.ao.f10440b = this.aq.getText().toString();
        bundle.putParcelable("report", this.ao.m18542x());
    }

    public final void m18711G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1691536597);
        super.G();
        this.aq.requestFocus();
        KeyboardUtils.b(getContext(), this.aq);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -186201882, a);
    }

    public final void m18712H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -203392790);
        super.H();
        KeyboardUtils.a(o());
        ar(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1851675211, a);
    }

    public static void ar(BugReportFragment bugReportFragment) {
        if (!bugReportFragment.as && !Strings.isNullOrEmpty(bugReportFragment.aq.getText().toString())) {
            bugReportFragment.f10692i.m18746a(CoreEvent.BUG_REPORT_DID_ENTER_DESCRIPTION);
            bugReportFragment.as = true;
        }
    }

    public final void mo563a(Listener listener) {
        this.ap = listener;
    }

    public final void dE_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 99730041);
        super.dE_();
        if (!(this.at || this.ap == null)) {
            Intent intent = new Intent();
            intent.putExtra("bug_desc", this.aq.getText().toString());
            intent.putParcelableArrayListExtra("bug_shots", Lists.a(this.ao.m18540d()));
            this.ap.mo564a(this, intent);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 776549843, a);
    }

    public final void m18716a(Menu menu, MenuInflater menuInflater) {
        super.a(menu, menuInflater);
        if (this.av) {
            this.ay.a(menu);
        }
    }

    public final void m18715a(Menu menu) {
        super.a(menu);
    }

    public final boolean a_(MenuItem menuItem) {
        boolean a_ = super.a_(menuItem);
        if (a_ || !this.av) {
            return a_;
        }
        return this.ay.a(menuItem);
    }

    public final ListenableFuture<Uri> mo1125a(final Uri uri) {
        this.f10692i.m18746a(CoreEvent.BUG_REPORT_DID_ATTACH_SCREENSHOT);
        ListenableFuture<Uri> a = this.f10686c.a(new Callable<Uri>(this) {
            final /* synthetic */ BugReportFragment f10682b;

            public Object call() {
                BugReportAttachment bugReportAttachment = null;
                try {
                    BugReportingData a = BugReportingData.m18659a();
                    boolean a2 = this.f10682b.aD.a(BugReportingXConfig.q, false);
                    this.f10682b.al;
                    bugReportAttachment = BugReporterFileUtil.m18645a(a2 ? a.m18662i() : a.m18660b(), "bug_report_image_" + this.f10682b.an.a());
                    this.f10682b.al;
                    BugReporterFileUtil.m18650a(this.f10682b.getContext().getContentResolver().openInputStream(uri), bugReportAttachment);
                    Object b = bugReportAttachment.m18527b();
                    return b;
                } finally {
                    if (bugReportAttachment != null) {
                        bugReportAttachment.m18526a().close();
                    }
                }
            }
        });
        Futures.a(a, new C10306(this), this.f10687d);
        return a;
    }

    public final void mo1127b(Uri uri) {
        this.f10692i.m18746a(CoreEvent.BUG_REPORT_DID_DETACH_SCREENSHOT);
        BugReportBuilder bugReportBuilder = this.ao;
        if (bugReportBuilder.f10442d != null) {
            bugReportBuilder.f10442d.remove(uri);
        }
    }

    public final ImmutableList<Uri> mo1126b() {
        return this.ao.m18540d();
    }
}
