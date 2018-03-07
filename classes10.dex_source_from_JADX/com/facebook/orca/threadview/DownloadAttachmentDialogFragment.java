package com.facebook.orca.threadview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.numbers.FileSizeUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.IntentResolver;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback2;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.FbInjector;
import com.facebook.iorg.common.upsell.ui.FbZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController.Listener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.attachments.OtherAttachmentData;
import com.facebook.messaging.dialog.ConfirmActionDialogFragment;
import com.facebook.messaging.dialog.ConfirmActionParams.Builder;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: montageMessage */
public class DownloadAttachmentDialogFragment extends ConfirmActionDialogFragment {
    public Context am;
    public SecureContextHelper an;
    private ZeroDialogController ao;
    public DefaultBlueServiceOperationFactory ap;
    public Executor aq;
    public ErrorDialogs ar;
    private FileSizeUtil as;
    public OtherAttachmentData at;
    public OperationFuture au;

    /* compiled from: montageMessage */
    class C10351 implements Listener {
        final /* synthetic */ DownloadAttachmentDialogFragment f6895a;

        C10351(DownloadAttachmentDialogFragment downloadAttachmentDialogFragment) {
            this.f6895a = downloadAttachmentDialogFragment;
        }

        public final void m6529a(Object obj) {
            DownloadAttachmentDialogFragment downloadAttachmentDialogFragment = this.f6895a;
            if (downloadAttachmentDialogFragment.at.d != null) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(downloadAttachmentDialogFragment.at.d.y, downloadAttachmentDialogFragment.at.d.o);
                if (IntentResolver.b(downloadAttachmentDialogFragment.am, intent)) {
                    downloadAttachmentDialogFragment.an.b(intent, downloadAttachmentDialogFragment.am);
                    return;
                } else {
                    downloadAttachmentDialogFragment.ar.a(ErrorDialogParams.a(downloadAttachmentDialogFragment.jW_()).a(2131230721).b(2131231607).l());
                    return;
                }
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("attachment", downloadAttachmentDialogFragment.at);
            downloadAttachmentDialogFragment.au = BlueServiceOperationFactoryDetour.a(downloadAttachmentDialogFragment.ap, "get_authenticated_attachment_url", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(downloadAttachmentDialogFragment.getClass()), -481985030).a();
            Futures.a(downloadAttachmentDialogFragment.au, new C10362(downloadAttachmentDialogFragment), downloadAttachmentDialogFragment.aq);
        }

        public final void m6528a() {
        }
    }

    /* compiled from: montageMessage */
    public class C10362 extends OperationResultFutureCallback2 {
        final /* synthetic */ DownloadAttachmentDialogFragment f6896a;

        public C10362(DownloadAttachmentDialogFragment downloadAttachmentDialogFragment) {
            this.f6896a = downloadAttachmentDialogFragment;
        }

        protected final void m6530a(OperationResult operationResult) {
            Uri uri = (Uri) operationResult.h();
            String str = this.f6896a.at.b;
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uri, str);
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(uri);
            if (IntentResolver.b(this.f6896a.am, intent)) {
                this.f6896a.an.b(intent, this.f6896a.am);
            } else if (IntentResolver.b(this.f6896a.am, intent2)) {
                this.f6896a.an.b(intent2, this.f6896a.am);
            } else {
                this.f6896a.ar.a(ErrorDialogParams.a(this.f6896a.jW_()).a(2131230721).b(2131231607).l());
            }
            this.f6896a.b();
        }

        protected final void m6532a(Throwable th) {
            this.f6896a.ar.a(ErrorDialogParams.a(this.f6896a.am).a(2131230721).b(2131231609).l());
            this.f6896a.b();
        }

        protected final void m6533a(CancellationException cancellationException) {
            this.f6896a.b();
        }
    }

    public static void m6535a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((DownloadAttachmentDialogFragment) obj).m6534a((Context) fbInjector.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), (ZeroDialogController) FbZeroDialogController.b(fbInjector), DefaultBlueServiceOperationFactory.b(fbInjector), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), ErrorDialogs.a(fbInjector), FileSizeUtil.b(fbInjector));
    }

    @Inject
    private void m6534a(Context context, SecureContextHelper secureContextHelper, ZeroDialogController zeroDialogController, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, Executor executor, ErrorDialogs errorDialogs, FileSizeUtil fileSizeUtil) {
        this.am = context;
        this.an = secureContextHelper;
        this.ao = zeroDialogController;
        this.ap = defaultBlueServiceOperationFactory;
        this.aq = executor;
        this.ar = errorDialogs;
        this.as = fileSizeUtil;
    }

    public final void m6536a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1368478190);
        super.a(bundle);
        Class cls = DownloadAttachmentDialogFragment.class;
        m6535a(this, getContext());
        this.at = (OtherAttachmentData) Preconditions.checkNotNull((OtherAttachmentData) this.s.getParcelable("attachment_data"), "DownloadAttachmentDialogFragment needs an attachment in its argument Bundle");
        Builder builder = new Builder(this.at.a, b(2131231718));
        if (this.at.c > 0) {
            FileSizeUtil fileSizeUtil = this.as;
            double max = Math.max((double) (((float) this.at.c) / 1048576.0f), 0.1d);
            builder.d = fileSizeUtil.a.getString(2131235908, new Object[]{Double.valueOf(max)});
        }
        this.am = builder.a();
        this.ao.a(ZeroFeatureKey.ATTACHMENT_DOWNLOAD_INTERSTITIAL, getContext().getString(2131232936), new C10351(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -37291988, a);
    }

    protected final void aq() {
        if (this.au == null) {
            if (this.at.b.toLowerCase().contains("video")) {
                this.ao.a(ZeroFeatureKey.VIDEO_PLAY_INTERSTITIAL, this.D);
            } else {
                this.ao.a(ZeroFeatureKey.ATTACHMENT_DOWNLOAD_INTERSTITIAL, this.D);
            }
        }
    }

    protected final void ar() {
        b();
    }
}
