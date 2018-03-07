package com.facebook.messaging.mutators;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.Operation;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.annotations.IsGlobalMessageDeleteEnabled;
import com.facebook.messaging.dialog.ConfirmActionDialogFragment;
import com.facebook.messaging.dialog.ConfirmActionParams;
import com.facebook.messaging.dialog.ConfirmActionParams.Builder;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.send.client.SendMessageManager;
import com.facebook.messaging.service.model.DeleteThreadsParams;
import com.facebook.messaging.sms.common.NotDefaultSmsAppException;
import com.facebook.orca.threadview.ThreadViewMessagesFragmentMessageRequestsController.C11856;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogParamsBuilder;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: runningInPlatformContext */
public class DeleteThreadDialogFragment extends ConfirmActionDialogFragment {
    private static final Class<?> as = DeleteThreadDialogFragment.class;
    @Inject
    public AnalyticsLogger am;
    @Inject
    public DefaultBlueServiceOperationFactory an;
    @Inject
    public Context ao;
    @Inject
    public ErrorDialogs ap;
    @Inject
    @ForUiThread
    public Executor aq;
    @Inject
    @IsGlobalMessageDeleteEnabled
    public Provider<Boolean> ar;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<SendMessageManager> at = UltralightRuntime.b;
    public ImmutableList<ThreadKey> au;
    public Operation av;
    public ListenableFuture<OperationResult> aw;
    public C11856 ax;

    /* compiled from: runningInPlatformContext */
    public class C05351 extends OperationResultFutureCallback {
        final /* synthetic */ DeleteThreadDialogFragment f3318a;

        public C05351(DeleteThreadDialogFragment deleteThreadDialogFragment) {
            this.f3318a = deleteThreadDialogFragment;
        }

        public final void m3234a(Object obj) {
            if (this.f3318a.ax != null) {
                this.f3318a.ax.m7772a();
            }
            int size = this.f3318a.au.size();
            for (int i = 0; i < size; i++) {
                ThreadKey threadKey = (ThreadKey) this.f3318a.au.get(i);
                SendMessageManager sendMessageManager = (SendMessageManager) this.f3318a.at.get();
                if (sendMessageManager.G.f(threadKey)) {
                    sendMessageManager.G.b(threadKey);
                }
            }
            this.f3318a.a();
        }

        protected final void m3233a(ServiceException serviceException) {
            this.f3318a.aw = null;
            if (this.f3318a.ax != null) {
                C11856 c11856 = this.f3318a.ax;
            }
            DeleteThreadDialogFragment deleteThreadDialogFragment = this.f3318a;
            if (deleteThreadDialogFragment.ao != null && !(serviceException.getCause() instanceof NotDefaultSmsAppException)) {
                ErrorDialogs errorDialogs = deleteThreadDialogFragment.ap;
                ErrorDialogParamsBuilder a = ErrorDialogParams.a(deleteThreadDialogFragment.ao).a(2131230721);
                a.f = serviceException;
                a = a;
                a.g = new C05362(deleteThreadDialogFragment);
                errorDialogs.a(a.l());
            }
        }
    }

    /* compiled from: runningInPlatformContext */
    public class C05362 implements OnClickListener {
        final /* synthetic */ DeleteThreadDialogFragment f3319a;

        public C05362(DeleteThreadDialogFragment deleteThreadDialogFragment) {
            this.f3319a = deleteThreadDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public static void m3237a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((DeleteThreadDialogFragment) obj).m3236a(AnalyticsLoggerMethodAutoProvider.a(fbInjector), DefaultBlueServiceOperationFactory.b(fbInjector), (Context) fbInjector.getInstance(Context.class), ErrorDialogs.a(fbInjector), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), IdBasedProvider.a(fbInjector, 4063), IdBasedLazy.a(fbInjector, 8347));
    }

    private void m3236a(AnalyticsLogger analyticsLogger, BlueServiceOperationFactory blueServiceOperationFactory, Context context, ErrorDialogs errorDialogs, Executor executor, Provider<Boolean> provider, com.facebook.inject.Lazy<SendMessageManager> lazy) {
        this.am = analyticsLogger;
        this.an = blueServiceOperationFactory;
        this.ao = context;
        this.ap = errorDialogs;
        this.aq = executor;
        this.ar = provider;
        this.at = lazy;
    }

    public static DeleteThreadDialogFragment m3235a(DeleteThreadDialogParams deleteThreadDialogParams) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("thread_keys", deleteThreadDialogParams.f3324a);
        bundle.putString("dialog_title", deleteThreadDialogParams.f3325b);
        bundle.putString("dialog_message", deleteThreadDialogParams.f3326c);
        bundle.putString("confirm_text", deleteThreadDialogParams.f3327d);
        Bundle bundle2 = bundle;
        DeleteThreadDialogFragment deleteThreadDialogFragment = new DeleteThreadDialogFragment();
        deleteThreadDialogFragment.g(bundle2);
        return deleteThreadDialogFragment;
    }

    public final void m3238a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 495192304);
        super.a(bundle);
        this.au = (ImmutableList) this.s.getSerializable("thread_keys");
        Class cls = DeleteThreadDialogFragment.class;
        m3237a(this, getContext());
        this.am = at();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -464541841, a);
    }

    protected final void aq() {
        if (this.aw == null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("deleteThreadsParams", new DeleteThreadsParams(this.au));
            this.av = BlueServiceOperationFactoryDetour.a(this.an, "delete_threads", bundle, -483024893);
            this.av.a(new DialogBasedProgressIndicator(getContext(), ((Boolean) this.ar.get()).booleanValue() ? 2131231175 : 2131231171));
            this.aw = this.av.a();
            HoneyClientEventFast a = this.am.a("delete_thread", false);
            if (a.a()) {
                if (this.G instanceof AnalyticsActivity) {
                    a.a(((AnalyticsActivity) this.G).am_());
                }
                a.a("thread_key", this.au);
                a.b();
            }
            Futures.a(this.aw, new C05351(this), this.aq);
        }
    }

    private ConfirmActionParams at() {
        int i;
        String b;
        Bundle bundle = this.s;
        String str = "dialog_title";
        if (((Boolean) this.ar.get()).booleanValue()) {
            i = 2131231172;
        } else {
            i = 2131231167;
        }
        String string = bundle.getString(str, b(i));
        Bundle bundle2 = this.s;
        String str2 = "dialog_message";
        if (((Boolean) this.ar.get()).booleanValue()) {
            i = 2131231173;
        } else {
            i = 2131231168;
        }
        str = bundle2.getString(str2, b(i));
        Bundle bundle3 = this.s;
        String str3 = "confirm_text";
        Object obj = 1;
        int size = this.au.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj2;
            if (ThreadKey.d((ThreadKey) this.au.get(i2))) {
                obj2 = obj;
            } else {
                obj2 = null;
            }
            i2++;
            obj = obj2;
        }
        if (obj != null) {
            b = b(2131231170);
        } else {
            b = b(((Boolean) this.ar.get()).booleanValue() ? 2131231174 : 2131231169);
        }
        Builder builder = new Builder(string, bundle3.getString(str3, b));
        builder.d = str;
        Builder builder2 = builder;
        builder2.e = b(2131230727);
        return builder2.a();
    }
}
