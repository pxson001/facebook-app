package com.facebook.messaging.payment.prefs.receipts.manual.ui;

import android.view.ViewGroup;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.messaging.payment.prefs.receipts.manual.model.BasicReceiptSummaryModelAdapter;

/* compiled from: generic_attachment_small_cover_image_height */
public class BasicReceiptSummaryBindableProvider extends AbstractAssistedProvider<BasicReceiptSummaryBindable> {
    public final BasicReceiptSummaryBindable m14699a(ViewGroup viewGroup, BasicReceiptSummaryModelAdapter basicReceiptSummaryModelAdapter) {
        return new BasicReceiptSummaryBindable(LayoutInflaterMethodAutoProvider.b(this), viewGroup, basicReceiptSummaryModelAdapter);
    }
}
