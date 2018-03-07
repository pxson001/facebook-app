package com.facebook.bugreporter;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.auth.module.TriState_IsMeUserAnEmployeeMethodAutoProvider;
import com.facebook.base.fragment.FragmentManagerHost;
import com.facebook.bugreporter.activity.BugReportActivity;
import com.facebook.bugreporter.activity.ComponentWithDebugInfo;
import com.facebook.bugreporter.activity.categorylist.CategoryInfo;
import com.facebook.bugreporter.activity.chooser.ChooserFragment;
import com.facebook.bugreporter.activity.chooser.ChooserOption;
import com.facebook.bugreporter.analytics.BugReporterAnalyticsLogger;
import com.facebook.bugreporter.analytics.BugReporterAnalyticsLogger.CoreEvent;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.fragmentconstants.FragmentConstants;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.viewdescriptionbuilder.ViewDescriptionBuilder;
import com.facebook.fbui.viewdescriptionbuilder.ViewDescriptionBuilder$ViewTraversalMode;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.features.bugreporter.Fb4aBugReporterConfig;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: android.media.metadata.WRITER */
public class BugReporter {
    private static final String f10607n = (BugReporter.class.getSimpleName() + ".");
    private static volatile BugReporter f10608o;
    private final Resources f10609a;
    private final ListeningExecutorService f10610b;
    private final Executor f10611c;
    private final AbstractFbErrorReporter f10612d;
    public final BugReporterConfig f10613e;
    private final Set<BugReportExtraDataMapProvider> f10614f;
    private final Toaster f10615g;
    private final ViewDescriptionBuilder f10616h;
    public final SecureContextHelper f10617i;
    public final BugReporterAnalyticsLogger f10618j;
    private final TriState f10619k;
    public final BugReportWriter f10620l;
    public GatekeeperStoreImpl f10621m;

    /* compiled from: android.media.metadata.WRITER */
    public class BugReporterConfigWithPreferredCategory implements BugReporterConfig {
        private final BugReporterConfig f10605a;
        private final long f10606b;

        public BugReporterConfigWithPreferredCategory(BugReporterConfig bugReporterConfig, long j) {
            this.f10605a = bugReporterConfig;
            this.f10606b = j;
        }

        public final ImmutableList<CategoryInfo> mo1120a() {
            ImmutableList<CategoryInfo> a = this.f10605a.mo1120a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                CategoryInfo categoryInfo = (CategoryInfo) a.get(i);
                if (categoryInfo.f10695c == this.f10606b) {
                    return ImmutableList.of(categoryInfo);
                }
            }
            return a;
        }

        public final ImmutableList<ChooserOption> mo1121b() {
            return this.f10605a.mo1121b();
        }
    }

    public static com.facebook.bugreporter.BugReporter m18632a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f10608o;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.bugreporter.BugReporter.class;
        monitor-enter(r1);
        r0 = f10608o;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m18641b(r0);	 Catch:{ all -> 0x0035 }
        f10608o = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10608o;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.bugreporter.BugReporter.a(com.facebook.inject.InjectorLike):com.facebook.bugreporter.BugReporter");
    }

    private static BugReporter m18641b(InjectorLike injectorLike) {
        return new BugReporter(ResourcesMethodAutoProvider.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (BugReporterConfig) Fb4aBugReporterConfig.a(injectorLike), STATICDI_MULTIBIND_PROVIDER$BugReportExtraDataMapProvider.m18683a(injectorLike), Toaster.b(injectorLike), ViewDescriptionBuilder.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), BugReporterAnalyticsLogger.m18744b(injectorLike), TriState_IsMeUserAnEmployeeMethodAutoProvider.b(injectorLike), BugReportWriter.m18613b(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BugReporter(Resources resources, ListeningExecutorService listeningExecutorService, Executor executor, FbErrorReporter fbErrorReporter, BugReporterConfig bugReporterConfig, Set<BugReportExtraDataMapProvider> set, Toaster toaster, ViewDescriptionBuilder viewDescriptionBuilder, SecureContextHelper secureContextHelper, BugReporterAnalyticsLogger bugReporterAnalyticsLogger, TriState triState, BugReportWriter bugReportWriter, GatekeeperStore gatekeeperStore) {
        this.f10609a = resources;
        this.f10610b = listeningExecutorService;
        this.f10611c = executor;
        this.f10612d = fbErrorReporter;
        this.f10613e = bugReporterConfig;
        this.f10614f = set;
        this.f10615g = toaster;
        this.f10616h = viewDescriptionBuilder;
        this.f10617i = secureContextHelper;
        this.f10618j = bugReporterAnalyticsLogger;
        this.f10619k = triState;
        this.f10620l = bugReportWriter;
        this.f10621m = gatekeeperStore;
    }

    public final void m18642a(Context context) {
        BugReportFlowStartParams a = BugReportFlowStartParams.newBuilder().m18545a(context).m18549a();
        Context context2 = a.f10469a;
        this.f10618j.m18746a(CoreEvent.RAP_BEGIN_FLOW);
        ImmutableList b = this.f10613e.mo1121b();
        if (b == null || b.isEmpty()) {
            m18644a(a);
        } else if (context2 instanceof FragmentManagerHost) {
            FragmentManager kO_ = ((FragmentManagerHost) context2).kO_();
            if (kO_.a("bug_reporter_chooser") == null) {
                FragmentTransaction a2 = kO_.a();
                Preconditions.checkNotNull(b);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("CHOOSER_OPTIONS", Lists.a(b));
                ChooserFragment chooserFragment = new ChooserFragment();
                chooserFragment.g(bundle);
                chooserFragment.a(a2, "bug_reporter_chooser", true);
            }
        } else {
            m18644a(a);
        }
    }

    public final void m18644a(final BugReportFlowStartParams bugReportFlowStartParams) {
        Bundle a;
        this.f10618j.m18746a(CoreEvent.BUG_REPORT_BEGIN_FLOW);
        HashMap hashMap = new HashMap();
        if (bugReportFlowStartParams.f10469a instanceof ComponentWithDebugInfo) {
            m18638a((ComponentWithDebugInfo) bugReportFlowStartParams.f10469a, hashMap);
        }
        if (bugReportFlowStartParams.f10469a instanceof FragmentManagerHost) {
            m18635a(((FragmentManagerHost) bugReportFlowStartParams.f10469a).kO_(), hashMap);
        }
        if (bugReportFlowStartParams.f10469a instanceof Activity) {
            Intent intent = ((Activity) bugReportFlowStartParams.f10469a).getIntent();
            if (!(intent == null || intent.getExtras() == null)) {
                hashMap.put("intent_extras", intent.getExtras().toString());
            }
        }
        if (bugReportFlowStartParams.f10469a instanceof AnalyticsActivity) {
            m18636a((AnalyticsActivity) bugReportFlowStartParams.f10469a, hashMap);
        }
        m18639a(hashMap);
        final ImmutableMap copyOf = ImmutableMap.copyOf(hashMap);
        if (bugReportFlowStartParams.f10469a instanceof Activity) {
            Object obj = 1;
            if (TriState.YES.equals(this.f10621m.a(623))) {
                Object obj2;
                String str = (String) hashMap.get("activity_analytics_tag");
                Object obj3;
                if (str == null || !str.equals("bookmarks")) {
                    obj3 = null;
                } else {
                    obj3 = 1;
                }
                if (bugReportFlowStartParams.f10470b == BugReportSource.SETTINGS_REPORT_PROBLEM) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (!(obj2 == null || r5 == null)) {
                    obj = null;
                }
            }
            if (obj != null) {
                Bitmap a2 = m18630a((Activity) bugReportFlowStartParams.f10469a);
                if (a2 != null) {
                    bugReportFlowStartParams.f10473e.add(a2);
                }
            }
            if (TriState.YES.equals(this.f10619k)) {
                a = this.f10616h.a(((Activity) bugReportFlowStartParams.f10469a).getWindow().getDecorView(), ViewDescriptionBuilder$ViewTraversalMode.ALL);
                Futures.a(m18633a(bugReportFlowStartParams.f10469a, 2131235825, new Callable<BugReport>(this) {
                    final /* synthetic */ BugReporter f10587d;

                    public Object call() {
                        try {
                            return this.f10587d.f10620l.m18624a(bugReportFlowStartParams.f10473e, a, bugReportFlowStartParams.f10469a, copyOf, bugReportFlowStartParams.f10471c, bugReportFlowStartParams.f10470b).m18542x();
                        } catch (Throwable e) {
                            BLog.c("BugReporter", e, "Error creating the bug report", new Object[0]);
                            throw new RuntimeException(e);
                        } catch (Throwable e2) {
                            BLog.c("BugReporter", e2, "Error creating the bug report", new Object[0]);
                            throw new RuntimeException(e2);
                        }
                    }
                }), new FutureCallback<BugReport>(this) {
                    final /* synthetic */ BugReporter f10589b;

                    public void onSuccess(Object obj) {
                        BugReport bugReport = (BugReport) obj;
                        BugReporterConfig bugReporterConfig = this.f10589b.f10613e;
                        if (bugReportFlowStartParams.f10472d.isPresent()) {
                            bugReporterConfig = new BugReporterConfigWithPreferredCategory(this.f10589b.f10613e, ((Long) bugReportFlowStartParams.f10472d.get()).longValue());
                        }
                        BugReporter.m18637a(this.f10589b, bugReportFlowStartParams.f10469a, bugReport, bugReporterConfig);
                    }

                    public void onFailure(Throwable th) {
                        BugReporter bugReporter = this.f10589b;
                        if (!(th instanceof CancellationException)) {
                            BLog.c("BugReporter.onBugReportFailure", "Failed to create bug report", th);
                        }
                    }
                }, this.f10611c);
            }
        }
        a = null;
        Futures.a(m18633a(bugReportFlowStartParams.f10469a, 2131235825, /* anonymous class already generated */), /* anonymous class already generated */, this.f10611c);
    }

    public static void m18637a(BugReporter bugReporter, Context context, BugReport bugReport, BugReporterConfig bugReporterConfig) {
        Intent a = BugReportActivity.m18687a(context, bugReport, bugReporterConfig);
        if (context instanceof Activity) {
            bugReporter.f10617i.a(a, 18067, (Activity) context);
            return;
        }
        bugReporter.f10617i.a(a, context);
    }

    private void m18638a(ComponentWithDebugInfo componentWithDebugInfo, HashMap<String, String> hashMap) {
        try {
            Map debugInfo = componentWithDebugInfo.getDebugInfo();
            if (debugInfo != null) {
                hashMap.putAll(debugInfo);
            }
        } catch (Throwable e) {
            this.f10612d.a(f10607n + "addComponentDebugInfo", e);
        }
    }

    private void m18635a(FragmentManager fragmentManager, HashMap<String, String> hashMap) {
        if (fragmentManager != null && hashMap != null) {
            for (String a : FragmentConstants.f11086c) {
                Fragment a2 = fragmentManager.a(a);
                if (a2 instanceof ComponentWithDebugInfo) {
                    m18638a((ComponentWithDebugInfo) a2, (HashMap) hashMap);
                }
                if (a2 != null) {
                    m18635a(a2.s(), (HashMap) hashMap);
                }
            }
        }
    }

    private void m18636a(AnalyticsActivity analyticsActivity, HashMap<String, String> hashMap) {
        try {
            String am_ = analyticsActivity.am_();
            if (am_ != null) {
                hashMap.put("activity_analytics_tag", am_.toString());
            }
        } catch (Throwable e) {
            this.f10612d.a(f10607n + "addActivityAnalyticsInfo", e);
        }
    }

    private void m18639a(HashMap<String, String> hashMap) {
        for (BugReportExtraDataMapProvider c : this.f10614f) {
            try {
                Map c2 = c.c();
                if (c2 != null) {
                    hashMap.putAll(c2);
                }
            } catch (Throwable e) {
                this.f10612d.a(f10607n + "addExtraDataFromUI", e);
            }
        }
    }

    private static List<Fragment> m18634a(FragmentManager fragmentManager) {
        try {
            Field declaredField = fragmentManager.getClass().getDeclaredField("mAdded");
            declaredField.setAccessible(true);
            List<Fragment> list = (List) declaredField.get(fragmentManager);
            declaredField.setAccessible(false);
            if (list != null) {
                return list;
            }
        } catch (Throwable e) {
            BLog.b("BugReporter", "Could not access fragment list for screenshot.", e);
        }
        return Lists.a();
    }

    private Bitmap m18630a(Activity activity) {
        Activity parent;
        if (activity.getParent() != null) {
            parent = activity.getParent();
        } else {
            parent = activity;
        }
        View decorView = parent.getWindow().getDecorView();
        try {
            Bitmap createBitmap = Bitmap.createBitmap(decorView.getWidth(), decorView.getHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            decorView.draw(canvas);
            if (parent instanceof FragmentManagerHost) {
                List a = m18634a(((FragmentManagerHost) parent).kO_());
                int[] iArr = new int[2];
                decorView.getLocationOnScreen(iArr);
                canvas.translate((float) (-iArr[0]), (float) (-iArr[1]));
                m18640a(a, canvas);
                canvas.translate((float) iArr[0], (float) iArr[1]);
            }
            return createBitmap;
        } catch (Throwable e) {
            this.f10615g.b(new ToastBuilder("Insufficient memory to capture a screenshot. Sorry!"));
            this.f10612d.a("BugReporter", "Out of memory while creating screenshot", e);
            return null;
        } catch (Throwable e2) {
            this.f10615g.b(new ToastBuilder("Failed to capture a screenshot. Sorry!"));
            this.f10612d.a("BugReporter", "Exception while creating screenshot", e2);
            return null;
        }
    }

    private void m18640a(List<Fragment> list, Canvas canvas) {
        for (Fragment fragment : list) {
            if (fragment instanceof DialogFragment) {
                DialogFragment dialogFragment = (DialogFragment) fragment;
                if (!(dialogFragment.K || dialogFragment.f == null)) {
                    View decorView = dialogFragment.f.getWindow().getDecorView();
                    int[] iArr = new int[2];
                    decorView.getLocationOnScreen(iArr);
                    canvas.translate((float) iArr[0], (float) iArr[1]);
                    decorView.draw(canvas);
                    canvas.translate((float) (-iArr[0]), (float) (-iArr[1]));
                }
            }
            m18640a(m18634a(fragment.s()), canvas);
        }
    }

    public final void m18643a(final Context context, BugReportSource bugReportSource, ImmutableSet<BugReportExtraFileMapProvider> immutableSet, final Optional<Long> optional, List<Uri> list, @Nullable Uri uri, ImmutableMap<String, String> immutableMap) {
        final List<Uri> list2 = list;
        final Uri uri2 = uri;
        final Context context2 = context;
        final ImmutableMap<String, String> immutableMap2 = immutableMap;
        final ImmutableSet<BugReportExtraFileMapProvider> immutableSet2 = immutableSet;
        final BugReportSource bugReportSource2 = bugReportSource;
        Futures.a(m18633a(context, 2131235825, new Callable<BugReport>(this) {
            final /* synthetic */ BugReporter f10596g;

            public Object call() {
                BugReporter bugReporter = this.f10596g;
                List<Uri> list = list2;
                List arrayList = new ArrayList();
                Options options = new Options();
                for (Uri path : list) {
                    arrayList.add(BitmapFactory.decodeFile(path.getPath(), options));
                }
                List list2 = arrayList;
                bugReporter = this.f10596g;
                if (uri2 == null) {
                }
                return this.f10596g.f10620l.m18624a(list2, null, context2, immutableMap2, immutableSet2, bugReportSource2).m18542x();
            }
        }), new FutureCallback<BugReport>(this) {
            final /* synthetic */ BugReporter f10599c;

            public void onSuccess(@Nullable Object obj) {
                BugReport bugReport = (BugReport) obj;
                BugReporter bugReporter = this.f10599c;
                Context context = context;
                Optional optional = optional;
                BugReporterConfig bugReporterConfig = bugReporter.f10613e;
                if (optional.isPresent()) {
                    bugReporterConfig = new BugReporterConfigWithPreferredCategory(bugReporter.f10613e, ((Long) optional.get()).longValue());
                }
                Intent a = BugReportActivity.m18687a(context, bugReport, bugReporterConfig);
                if (ContextUtils.a(context, Service.class) != null) {
                    a.addFlags(268435456);
                }
                bugReporter.f10617i.a(a, context);
            }

            public void onFailure(Throwable th) {
            }
        }, this.f10611c);
    }

    private <T> ListenableFuture<T> m18633a(final Context context, int i, Callable<T> callable) {
        CharSequence applicationLabel;
        String str = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            if (applicationLabel != null) {
                str = applicationLabel.toString();
            }
        } catch (NameNotFoundException e) {
            BLog.a("BugReporter", e.getMessage());
        }
        if (Strings.isNullOrEmpty(str)) {
            applicationLabel = context.getString(2131235795);
        } else {
            Object obj = str;
        }
        str = this.f10609a.getString(i);
        final ListenableFuture<T> a = this.f10610b.a(callable);
        final ProgressDialogFragment progressDialogFragment = (ProgressDialogFragment) ProgressDialogFragment.m10329a(str, true, false);
        progressDialogFragment.m10333a(applicationLabel);
        progressDialogFragment.m10332a(new OnDismissListener(this) {
            final /* synthetic */ BugReporter f10601b;

            public void onDismiss(DialogInterface dialogInterface) {
                if (!a.isDone()) {
                    a.cancel(false);
                    this.f10601b.f10618j.m18746a(CoreEvent.BUG_REPORT_DID_DISMISS_CREATION_DIALOG);
                }
            }
        });
        if (!(context instanceof Activity)) {
            progressDialogFragment.m10335e(2002);
        }
        if (context instanceof FragmentManagerHost) {
            progressDialogFragment.a(((FragmentManagerHost) context).kO_().a(), "bug_report_in_progress", true);
        }
        Futures.a(a, new FutureCallback<Object>(this) {
            final /* synthetic */ BugReporter f10604c;

            public void onSuccess(Object obj) {
                m18625a();
            }

            public void onFailure(Throwable th) {
                m18625a();
            }

            private void m18625a() {
                if ((context instanceof FragmentManagerHost) && ((FragmentManagerHost) context).kO_().c() && progressDialogFragment.an()) {
                    progressDialogFragment.a();
                }
            }
        }, this.f10611c);
        progressDialogFragment.d_(true);
        return a;
    }

    @Nullable
    public static Bitmap m18631a(Context context, String str) {
        Bitmap bitmap = null;
        try {
            InputStream openFileInput = context.openFileInput(str);
            bitmap = BitmapFactory.decodeStream(openFileInput);
            openFileInput.close();
            new File(str).delete();
            return bitmap;
        } catch (Exception e) {
            return bitmap;
        }
    }
}
