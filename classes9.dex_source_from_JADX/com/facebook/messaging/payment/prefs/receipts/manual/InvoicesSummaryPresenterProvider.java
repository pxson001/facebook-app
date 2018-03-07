package com.facebook.messaging.payment.prefs.receipts.manual;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: getDAOItem called from an illegal context */
public class InvoicesSummaryPresenterProvider extends AbstractAssistedProvider<InvoicesSummaryPresenter> {
    public final InvoicesSummaryPresenter m14682a(InvoicesSummaryView invoicesSummaryView, String str) {
        return new InvoicesSummaryPresenter(InvoiceSummaryFetcher.m14628b(this), InvoicesSummaryAdapter.m14661b(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), invoicesSummaryView, str);
    }
}
