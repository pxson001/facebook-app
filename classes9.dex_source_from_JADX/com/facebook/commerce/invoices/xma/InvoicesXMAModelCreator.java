package com.facebook.commerce.invoices.xma;

import com.facebook.commerce.core.util.CommerceCurrencyUtil;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.util.StringUtil;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachmentItemBuilder;
import com.facebook.messaging.business.commerce.model.retail.Receipt;
import com.facebook.messaging.business.commerce.model.retail.ReceiptBuilder;
import com.facebook.messaging.graphql.threads.InvoicesFragmentsModels.InvoicesFragmentModel.TransactionProductsModel.EdgesModel;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.StoryAttachmentTargetFragmentModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: queue_failure */
public class InvoicesXMAModelCreator {
    public final AbstractFbErrorReporter f5959a;

    @Inject
    public InvoicesXMAModelCreator(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f5959a = abstractFbErrorReporter;
    }

    public static Receipt m6292a(StoryAttachmentTargetFragmentModel storyAttachmentTargetFragmentModel) {
        String ai = storyAttachmentTargetFragmentModel.ai();
        ReceiptBuilder receiptBuilder = new ReceiptBuilder();
        receiptBuilder.a = storyAttachmentTargetFragmentModel.c();
        if (storyAttachmentTargetFragmentModel.bu() != null) {
            ImmutableList a = storyAttachmentTargetFragmentModel.bu().a();
            Builder builder = new Builder();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                EdgesModel edgesModel = (EdgesModel) a.get(i);
                PlatformGenericAttachmentItemBuilder platformGenericAttachmentItemBuilder = new PlatformGenericAttachmentItemBuilder();
                String a2 = CommerceCurrencyUtil.a(ai, edgesModel.c());
                platformGenericAttachmentItemBuilder.f = edgesModel.aA_();
                platformGenericAttachmentItemBuilder.e = a2;
                platformGenericAttachmentItemBuilder.g = CommerceCurrencyUtil.a(ai, storyAttachmentTargetFragmentModel.by());
                if (edgesModel.b() != null) {
                    if (edgesModel.b() != null) {
                        platformGenericAttachmentItemBuilder.a = edgesModel.b().b();
                    }
                    platformGenericAttachmentItemBuilder.b = edgesModel.a();
                    if (!(edgesModel.d() == null || edgesModel.d().a() == null || StringUtil.a(edgesModel.d().a().a()))) {
                        platformGenericAttachmentItemBuilder.d(edgesModel.d().a().a());
                    }
                }
                builder.c(platformGenericAttachmentItemBuilder.n());
            }
            receiptBuilder.q = builder.b();
        }
        return receiptBuilder.u();
    }
}
