package com.facebook.messaging.payment.prefs.receipts.manual;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.messaging.media.upload.MediaUploadManagerImpl;
import com.facebook.messaging.payment.prefs.receipts.manual.InvoicesProofOfPaymentFragment.C16111;
import com.facebook.ui.futures.TasksManager;

/* compiled from: getPaymentCardIdForTransaction */
public class InvoicesProofOfPaymentPresenterProvider extends AbstractAssistedProvider<InvoicesProofOfPaymentPresenter> {
    public final InvoicesProofOfPaymentPresenter m14657a(InvoicesProofOfPaymentView invoicesProofOfPaymentView, String str, C16111 c16111, String str2, String str3) {
        return new InvoicesProofOfPaymentPresenter(InvoiceSummaryFetcher.m14628b(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), MediaUploadManagerImpl.a(this), TasksManager.b(this), invoicesProofOfPaymentView, str, c16111, str2, str3);
    }
}
