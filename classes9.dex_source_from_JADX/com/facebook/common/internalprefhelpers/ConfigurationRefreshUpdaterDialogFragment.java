package com.facebook.common.internalprefhelpers;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.config.background.ConfigurationComponent;
import com.facebook.config.background.STATICDI_MULTIBIND_PROVIDER;
import com.facebook.debug.log.BLog;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.http.protocol.BatchComponentRunner;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ui.dialogs.DialogWindowUtils;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: pushProperty */
public class ConfigurationRefreshUpdaterDialogFragment extends FbDialogFragment {
    public static final Class<?> ar = ConfigurationRefreshUpdaterDialogFragment.class;
    @Inject
    public BatchComponentRunner am;
    @Inject
    public Set<ConfigurationComponent> an;
    @DefaultExecutorService
    @Inject
    public ListeningExecutorService ao;
    @Inject
    @ForUiThread
    public Executor ap;
    @Inject
    Toaster aq;
    public ListenableFuture<Object> as;

    /* compiled from: pushProperty */
    public class C06231 implements Callable<Object> {
        final /* synthetic */ ConfigurationRefreshUpdaterDialogFragment f5973a;

        public C06231(ConfigurationRefreshUpdaterDialogFragment configurationRefreshUpdaterDialogFragment) {
            this.f5973a = configurationRefreshUpdaterDialogFragment;
        }

        public Object call() {
            ConfigurationRefreshUpdaterDialogFragment configurationRefreshUpdaterDialogFragment = this.f5973a;
            int i = 0;
            for (ConfigurationComponent configurationComponent : configurationRefreshUpdaterDialogFragment.an) {
                if (configurationRefreshUpdaterDialogFragment.as == null) {
                    break;
                }
                BatchComponent b = configurationComponent.b();
                if (b != null) {
                    configurationComponent.getClass().getSimpleName();
                    ExecutorDetour.a(configurationRefreshUpdaterDialogFragment.ap, new C06253(configurationRefreshUpdaterDialogFragment, i, configurationComponent), -393450195);
                    ApiMethodRunnerParams apiMethodRunnerParams = new ApiMethodRunnerParams();
                    apiMethodRunnerParams.f = RequestPriority.INTERACTIVE;
                    configurationRefreshUpdaterDialogFragment.am.a("handleFetchConfiguration", CallerContext.a(configurationRefreshUpdaterDialogFragment.getClass()), ImmutableList.of(b), apiMethodRunnerParams);
                }
                i++;
            }
            return null;
        }
    }

    /* compiled from: pushProperty */
    public class C06242 implements FutureCallback<Object> {
        final /* synthetic */ ConfigurationRefreshUpdaterDialogFragment f5974a;

        public C06242(ConfigurationRefreshUpdaterDialogFragment configurationRefreshUpdaterDialogFragment) {
            this.f5974a = configurationRefreshUpdaterDialogFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f5974a.as = null;
            this.f5974a.b();
        }

        public void onFailure(Throwable th) {
            BLog.a(ConfigurationRefreshUpdaterDialogFragment.ar, "Failed to fetch configuration", th);
            this.f5974a.aq.b(new ToastBuilder("Failed to fetch configuration"));
            this.f5974a.as = null;
            this.f5974a.b();
        }
    }

    /* compiled from: pushProperty */
    public class C06253 implements Runnable {
        final /* synthetic */ int f5975a;
        final /* synthetic */ ConfigurationComponent f5976b;
        final /* synthetic */ ConfigurationRefreshUpdaterDialogFragment f5977c;

        public C06253(ConfigurationRefreshUpdaterDialogFragment configurationRefreshUpdaterDialogFragment, int i, ConfigurationComponent configurationComponent) {
            this.f5977c = configurationRefreshUpdaterDialogFragment;
            this.f5975a = i;
            this.f5976b = configurationComponent;
        }

        public void run() {
            ConfigurationRefreshUpdaterDialogFragment configurationRefreshUpdaterDialogFragment = this.f5977c;
            int i = this.f5975a;
            ConfigurationComponent configurationComponent = this.f5976b;
            if (configurationRefreshUpdaterDialogFragment.as != null) {
                ProgressDialog progressDialog = (ProgressDialog) configurationRefreshUpdaterDialogFragment.f;
                if (progressDialog != null) {
                    progressDialog.setProgress(i);
                    progressDialog.setMessage("Fetching " + StringUtil.a(configurationComponent.getClass().getSimpleName(), 16));
                }
            }
        }
    }

    public static void m6306a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ConfigurationRefreshUpdaterDialogFragment) obj).m6305a(BatchComponentRunner.a(fbInjector), STATICDI_MULTIBIND_PROVIDER.ConfigurationComponent.a(fbInjector), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), Toaster.b(fbInjector));
    }

    private void m6305a(BatchComponentRunner batchComponentRunner, Set<ConfigurationComponent> set, ListeningExecutorService listeningExecutorService, Executor executor, Toaster toaster) {
        this.am = batchComponentRunner;
        this.an = set;
        this.ao = listeningExecutorService;
        this.ap = executor;
        this.aq = toaster;
    }

    public final void m6307a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1915405280);
        super.a(bundle);
        Class cls = ConfigurationRefreshUpdaterDialogFragment.class;
        m6306a(this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1285213111, a);
    }

    public final Dialog m6308c(Bundle bundle) {
        Dialog progressDialog = new ProgressDialog(getContext());
        DialogWindowUtils.a(progressDialog);
        progressDialog.setProgressStyle(1);
        progressDialog.setIndeterminate(false);
        progressDialog.setMax(this.an.size());
        progressDialog.setCancelable(true);
        progressDialog.setTitle("Fetching Configuration");
        progressDialog.setMessage("Starting fetch");
        return progressDialog;
    }

    public final void m6309d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 807223164);
        super.d(bundle);
        if (bundle == null) {
            this.as = this.ao.a(new C06231(this));
            Futures.a(this.as, new C06242(this), this.ap);
        } else {
            b();
        }
        LogUtils.f(-1142985850, a);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.as != null) {
            this.as.cancel(false);
            this.as = null;
        }
    }
}
