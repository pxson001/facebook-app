package com.facebook.messaging.payment.prefs.receipts.manual;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment.EventListener;
import com.facebook.messaging.media.upload.MediaItemUploadStatus;
import com.facebook.messaging.media.upload.MediaUploadManagerImpl;
import com.facebook.messaging.payment.prefs.receipts.manual.InvoicesProofOfPaymentFragment.C16111;
import com.facebook.messaging.payment.prefs.receipts.manual.InvoicesProofOfPaymentMediaController.C16131;
import com.facebook.messaging.payment.prefs.receipts.manual.model.InvoicesSummaryModel;
import com.facebook.messaging.payment.prefs.receipts.manual.model.InvoicesSummaryModel.Builder;
import com.facebook.messaging.payment.service.model.cards.ManualTransferMethod;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: getPaymentCardIds */
public class InvoicesProofOfPaymentPresenter {
    public static final CallerContext f14179a = CallerContext.a(InvoicesProofOfPaymentPresenter.class);
    private final InvoiceSummaryFetcher f14180b;
    public final AbstractFbErrorReporter f14181c;
    public final MediaUploadManagerImpl f14182d;
    public final TasksManager f14183e;
    public final InvoicesProofOfPaymentView f14184f;
    public final C16111 f14185g;
    @Nullable
    public EventListener f14186h;
    @Nullable
    public MediaResource f14187i;
    @Nullable
    public ListenableFuture<MediaItemUploadStatus> f14188j;
    @Nullable
    public ProgressDialog f14189k;
    private final String f14190l;
    @Nullable
    public final String f14191m;
    @Nullable
    public final String f14192n;
    private final AbstractDisposableFutureCallback<InvoicesSummaryModel> f14193o = new C16141(this);

    /* compiled from: getPaymentCardIds */
    class C16141 extends AbstractDisposableFutureCallback<InvoicesSummaryModel> {
        final /* synthetic */ InvoicesProofOfPaymentPresenter f14175a;

        C16141(InvoicesProofOfPaymentPresenter invoicesProofOfPaymentPresenter) {
            this.f14175a = invoicesProofOfPaymentPresenter;
        }

        protected final void m14649a(Object obj) {
            InvoicesSummaryModel invoicesSummaryModel;
            InvoicesSummaryModel invoicesSummaryModel2 = (InvoicesSummaryModel) obj;
            InvoicesProofOfPaymentPresenter invoicesProofOfPaymentPresenter = this.f14175a;
            if (invoicesSummaryModel2 == null) {
                invoicesSummaryModel = null;
            } else {
                Builder builder = new Builder(invoicesSummaryModel2);
                if (invoicesProofOfPaymentPresenter.f14191m != null) {
                    builder.m14687d(invoicesProofOfPaymentPresenter.f14191m);
                }
                if (invoicesProofOfPaymentPresenter.f14192n != null) {
                    builder.m14688f(invoicesProofOfPaymentPresenter.f14192n);
                }
                invoicesSummaryModel = builder.m14686a();
            }
            InvoicesSummaryModel invoicesSummaryModel3 = invoicesSummaryModel;
            InvoicesProofOfPaymentView invoicesProofOfPaymentView = this.f14175a.f14184f;
            invoicesProofOfPaymentView.f14194a.setVisibility(0);
            invoicesProofOfPaymentView.f14194a.setDisplayedChild(1);
            InvoicesProofOfPaymentPresenter invoicesProofOfPaymentPresenter2 = this.f14175a;
            if (invoicesSummaryModel3.f14262o.isPresent() && invoicesSummaryModel3.f14263p.isPresent()) {
                invoicesProofOfPaymentPresenter2.f14184f.m14659a(true);
                String str = (String) invoicesSummaryModel3.f14262o.get();
                String str2 = (String) invoicesSummaryModel3.f14263p.get();
                invoicesProofOfPaymentPresenter2.f14184f.f14195b.m15482a(str, str2);
            } else {
                invoicesProofOfPaymentPresenter2.f14184f.m14659a(false);
                invoicesProofOfPaymentPresenter2.f14181c.a("InvoicesProofOfPaymentPresenter_bindPrice", "Insufficient price data: (isCurrencyPresent: " + invoicesSummaryModel3.f14262o.isPresent() + ", isTotalPricePresent: " + invoicesSummaryModel3.f14263p.isPresent() + ")");
            }
            InvoicesProofOfPaymentView invoicesProofOfPaymentView2 = invoicesProofOfPaymentPresenter2.f14184f;
            Optional optional = invoicesSummaryModel3.f14254g;
            if (optional.isPresent()) {
                invoicesProofOfPaymentView2.f14196c.setVisibility(0);
                invoicesProofOfPaymentView2.f14197d.setVisibility(0);
                invoicesProofOfPaymentView2.f14197d.setText((CharSequence) optional.get());
            } else {
                invoicesProofOfPaymentView2.f14196c.setVisibility(8);
                invoicesProofOfPaymentView2.f14197d.setVisibility(8);
            }
            invoicesProofOfPaymentView2 = invoicesProofOfPaymentPresenter2.f14184f;
            optional = invoicesSummaryModel3.f14260m;
            if (optional.isPresent()) {
                invoicesProofOfPaymentView2.f14198e.setVisibility(0);
                invoicesProofOfPaymentView2.f14199f.setVisibility(0);
                invoicesProofOfPaymentView2.f14199f.setText((CharSequence) optional.get());
            } else {
                invoicesProofOfPaymentView2.f14198e.setVisibility(8);
                invoicesProofOfPaymentView2.f14199f.setVisibility(8);
            }
            invoicesProofOfPaymentView2 = invoicesProofOfPaymentPresenter2.f14184f;
            if (invoicesSummaryModel3.f14259l.isPresent()) {
                invoicesProofOfPaymentView2.f14201h.setVisibility(0);
                invoicesProofOfPaymentView2.f14201h.setText(invoicesProofOfPaymentView2.f14201h.getContext().getString(2131240593, new Object[]{optional.get()}));
            } else {
                invoicesProofOfPaymentView2.f14201h.setVisibility(8);
            }
            if (this.f14175a.f14186h != null) {
                this.f14175a.f14186h.mo313a();
            }
        }

        protected final void m14650a(Throwable th) {
            this.f14175a.f14184f.f14194a.setVisibility(8);
            if (this.f14175a.f14186h != null) {
                this.f14175a.f14186h.mo314b();
            }
        }
    }

    /* compiled from: getPaymentCardIds */
    public class C16152 implements OnClickListener {
        final /* synthetic */ InvoicesProofOfPaymentPresenter f14176a;

        public C16152(InvoicesProofOfPaymentPresenter invoicesProofOfPaymentPresenter) {
            this.f14176a = invoicesProofOfPaymentPresenter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 571126351);
            if (this.f14176a.f14185g != null) {
                C16111 c16111 = this.f14176a.f14185g;
                InvoicesProofOfPaymentMediaController invoicesProofOfPaymentMediaController = c16111.f14160a.f14168e;
                CharSequence[] charSequenceArr = new CharSequence[]{r5.getString(2131240595), c16111.f14160a.o().getString(2131240596)};
                new AlertDialog.Builder(c16111.f14160a.o()).a(2131240600).a(charSequenceArr, new C16131(invoicesProofOfPaymentMediaController)).b();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -656833027, a);
        }
    }

    /* compiled from: getPaymentCardIds */
    class C16163 implements OnClickListener {
        final /* synthetic */ InvoicesProofOfPaymentPresenter f14177a;

        C16163(InvoicesProofOfPaymentPresenter invoicesProofOfPaymentPresenter) {
            this.f14177a = invoicesProofOfPaymentPresenter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -39294847);
            InvoicesProofOfPaymentPresenter invoicesProofOfPaymentPresenter = this.f14177a;
            invoicesProofOfPaymentPresenter.f14187i = null;
            InvoicesProofOfPaymentView invoicesProofOfPaymentView = invoicesProofOfPaymentPresenter.f14184f;
            invoicesProofOfPaymentView.f14202i.setVisibility(8);
            invoicesProofOfPaymentView.f14203j.setVisibility(8);
            invoicesProofOfPaymentView.f14200g.setVisibility(0);
            if (invoicesProofOfPaymentPresenter.f14185g != null) {
                invoicesProofOfPaymentPresenter.f14185g.f14160a.C();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1378997194, a);
        }
    }

    /* compiled from: getPaymentCardIds */
    public class C16174 extends AbstractDisposableFutureCallback<MediaItemUploadStatus> {
        final /* synthetic */ InvoicesProofOfPaymentPresenter f14178a;

        public C16174(InvoicesProofOfPaymentPresenter invoicesProofOfPaymentPresenter) {
            this.f14178a = invoicesProofOfPaymentPresenter;
        }

        public final void m14651a(@Nullable Object obj) {
            MediaItemUploadStatus mediaItemUploadStatus = (MediaItemUploadStatus) obj;
            if (mediaItemUploadStatus == null || StringUtil.a(mediaItemUploadStatus.f11848c)) {
                this.f14178a.f14181c.a("InvoicesSummaryPresenter_mediaUploadFailure", "onSuccess with empty result or result.fbid");
                this.f14178a.m14656a(null);
                return;
            }
            this.f14178a.m14655a(mediaItemUploadStatus.f11848c);
        }

        public final void m14652a(Throwable th) {
            this.f14178a.m14656a(null);
        }
    }

    /* compiled from: getPaymentCardIds */
    public enum Tasks {
        UPLOAD_RECEIPT
    }

    @Inject
    public InvoicesProofOfPaymentPresenter(InvoiceSummaryFetcher invoiceSummaryFetcher, AbstractFbErrorReporter abstractFbErrorReporter, MediaUploadManagerImpl mediaUploadManagerImpl, TasksManager tasksManager, @Assisted InvoicesProofOfPaymentView invoicesProofOfPaymentView, @Assisted String str, @Assisted C16111 c16111, @Nullable @Assisted String str2, @Nullable @Assisted String str3) {
        this.f14180b = invoiceSummaryFetcher;
        this.f14181c = abstractFbErrorReporter;
        this.f14182d = mediaUploadManagerImpl;
        this.f14183e = tasksManager;
        this.f14184f = invoicesProofOfPaymentView;
        this.f14190l = str;
        this.f14185g = c16111;
        this.f14191m = str2;
        this.f14192n = str3;
        InvoicesProofOfPaymentView invoicesProofOfPaymentView2 = this.f14184f;
        OnClickListener c16152 = new C16152(this);
        invoicesProofOfPaymentView2.f14200g.setOnClickListener(c16152);
        invoicesProofOfPaymentView2.f14203j.setOnClickListener(c16152);
        m14653f();
        this.f14184f.m14660b();
        this.f14180b.m14629a(this.f14190l, this.f14193o);
    }

    private void m14653f() {
        InvoicesProofOfPaymentView invoicesProofOfPaymentView = this.f14184f;
        invoicesProofOfPaymentView.f14205l.setOnClickListener(new C16163(this));
    }

    final void m14655a(String str) {
        m14654i();
        if (this.f14185g != null) {
            Uri uri = this.f14187i != null ? this.f14187i.c : null;
            InvoicesProofOfPaymentFragment invoicesProofOfPaymentFragment = this.f14185g.f14160a;
            Object manualTransferMethod = new ManualTransferMethod(invoicesProofOfPaymentFragment.f14172i.m15159a(), str, uri, invoicesProofOfPaymentFragment.f14172i.f14640d, invoicesProofOfPaymentFragment.f14172i.f14641e);
            Intent intent = new Intent();
            intent.putExtra("selected_payment_method", manualTransferMethod);
            invoicesProofOfPaymentFragment.ao().setResult(-1, intent);
            invoicesProofOfPaymentFragment.ao().finish();
        }
    }

    final void m14656a(@Nullable Throwable th) {
        m14654i();
        String uri = this.f14187i == null ? "(MediaResource is null)" : this.f14187i.c != null ? this.f14187i.c.toString() : "(null)";
        this.f14181c.a("InvoicesSummaryPResenter_mediaUploadFailure", "onFailure. URI: " + uri, th);
    }

    private void m14654i() {
        if (this.f14189k != null) {
            this.f14189k.dismiss();
            this.f14189k = null;
        }
    }
}
