package com.facebook.abtest.qe.settings;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.facebook.abtest.qe.settings.QuickExperimentListActivity.AnonymousClass10;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback2;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.dialogs.DialogWindowUtils;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: top_filters */
public class QuickExperimentSyncDialogFragment extends FbDialogFragment {
    public static final Class<?> ap = QuickExperimentSyncDialogFragment.class;
    @Inject
    public DefaultBlueServiceOperationFactory am;
    @Inject
    public TasksManager an;
    @Inject
    public Toaster ao;
    @Nullable
    public AnonymousClass10 aq;

    /* compiled from: top_filters */
    public class C01161 extends OperationResultFutureCallback2 {
        final /* synthetic */ QuickExperimentSyncDialogFragment f1811a;

        public C01161(QuickExperimentSyncDialogFragment quickExperimentSyncDialogFragment) {
            this.f1811a = quickExperimentSyncDialogFragment;
        }

        protected final void mo478a(OperationResult operationResult) {
        }

        protected final void mo480a(Throwable th) {
            BLog.a(QuickExperimentSyncDialogFragment.ap, "Failed to fetch QEs", th);
            this.f1811a.ao.b(new ToastBuilder("Failed to fetch QEs"));
        }
    }

    /* compiled from: top_filters */
    public class C01172 extends OperationResultFutureCallback2 {
        final /* synthetic */ QuickExperimentSyncDialogFragment f1812a;

        public C01172(QuickExperimentSyncDialogFragment quickExperimentSyncDialogFragment) {
            this.f1812a = quickExperimentSyncDialogFragment;
        }

        protected final void mo478a(OperationResult operationResult) {
            this.f1812a.b();
        }

        protected final void mo480a(Throwable th) {
            BLog.a(QuickExperimentSyncDialogFragment.ap, "Failed to fetch sessionless QEs", th);
            this.f1812a.ao.b(new ToastBuilder("Failed to fetch Sessionless QEs"));
            this.f1812a.b();
        }
    }

    public static void m2497a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        QuickExperimentSyncDialogFragment quickExperimentSyncDialogFragment = (QuickExperimentSyncDialogFragment) obj;
        DefaultBlueServiceOperationFactory b = DefaultBlueServiceOperationFactory.b(fbInjector);
        TasksManager b2 = TasksManager.b(fbInjector);
        Toaster b3 = Toaster.b(fbInjector);
        quickExperimentSyncDialogFragment.am = b;
        quickExperimentSyncDialogFragment.an = b2;
        quickExperimentSyncDialogFragment.ao = b3;
    }

    public final void m2498a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -467921985);
        super.a(bundle);
        Class cls = QuickExperimentSyncDialogFragment.class;
        m2497a(this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1128384214, a);
    }

    public final Dialog m2499c(Bundle bundle) {
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        DialogWindowUtils.m10316a(progressDialog);
        progressDialog.f3133d = 0;
        progressDialog.m4247a(true);
        progressDialog.setCancelable(true);
        progressDialog.setTitle("Quick Experiments");
        progressDialog.a("Syncing...");
        return progressDialog;
    }

    public final void m2500d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1800719945);
        super.d(bundle);
        if (bundle == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("force_refresh", true);
            this.an.c();
            this.an.c("syncRegular", BlueServiceOperationFactoryDetour.a(this.am, "sync_qe", bundle2, ErrorPropagation.BY_EXCEPTION, CallerContext.a(QuickExperimentSyncDialogFragment.class), 2073469889).a(), new C01161(this));
            this.an.c("syncSessionless", BlueServiceOperationFactoryDetour.a(this.am, "sync_sessionless_qe", bundle2, ErrorPropagation.BY_EXCEPTION, CallerContext.a(QuickExperimentSyncDialogFragment.class), -2112799843).a(), new C01172(this));
        } else {
            b();
        }
        LogUtils.f(1057081520, a);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.an.c();
        if (this.aq != null) {
            this.aq.m2461a();
        }
    }
}
