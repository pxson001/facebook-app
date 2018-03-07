package com.facebook.commerce.invoices.xma;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.commerce.model.retail.CommerceBubbleModel;
import com.facebook.messaging.business.commerce.model.retail.Receipt;
import com.facebook.messaging.graphql.threads.InvoicesFragmentsModels.InvoicesFragmentModel.TransactionPaymentModel.CredentialResponseModel;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.StoryAttachmentTargetFragmentModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.xma.SimpleStyleRenderer;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: quick cam popup */
public class InvoicesStyleRenderer extends SimpleStyleRenderer<ViewHolder> {
    public final Lazy<InvoicesXMAClickHandler> f5948a;
    private final Lazy<InvoicesXMAModelCreator> f5949b;
    private final Product f5950c;

    /* compiled from: quick cam popup */
    public class ViewHolder extends com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder {
        public final MultiItemInvoiceView f5947b;

        public ViewHolder(MultiItemInvoiceView multiItemInvoiceView) {
            super(multiItemInvoiceView);
            this.f5947b = multiItemInvoiceView;
        }
    }

    public static InvoicesStyleRenderer m6285b(InjectorLike injectorLike) {
        return new InvoicesStyleRenderer(IdBasedLazy.a(injectorLike, 5061), IdBasedLazy.a(injectorLike, 5062), ProductMethodAutoProvider.b(injectorLike));
    }

    protected final void m6286a(com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder viewHolder, XMAModel xMAModel) {
        CommerceBubbleModel commerceBubbleModel;
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        InvoicesXMAModelCreator invoicesXMAModelCreator = (InvoicesXMAModelCreator) this.f5949b.get();
        if (xMAModel.c() == null || xMAModel.c().k() == null) {
            invoicesXMAModelCreator.f5959a.a("InvoicesXMAModelCreator_createBubbleModel", "storyAttachment or getTarget is null");
            commerceBubbleModel = null;
        } else {
            StoryAttachmentTargetFragmentModel k = xMAModel.c().k();
            InvoiceBuilder invoiceBuilder = new InvoiceBuilder();
            invoiceBuilder.f5940b = k.bv();
            invoiceBuilder.f5941c = k.bw();
            invoiceBuilder.f5939a = (Receipt) Preconditions.checkNotNull(InvoicesXMAModelCreator.m6292a(k));
            if (k.ba() != null) {
                invoiceBuilder.f5942d = k.ba().b();
            }
            if (!(k.bt() == null || k.bt().a() == null)) {
                CredentialResponseModel a = k.bt().a();
                invoiceBuilder.f5944f = a.a().g() == -634454287;
                invoiceBuilder.f5943e = a.b();
            }
            commerceBubbleModel = new Invoice(invoiceBuilder);
        }
        final CommerceBubbleModel commerceBubbleModel2 = commerceBubbleModel;
        viewHolder2.f5947b.setModel(commerceBubbleModel2);
        if (commerceBubbleModel2 != null && this.f5950c == Product.MESSENGER) {
            viewHolder2.f5947b.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ InvoicesStyleRenderer f5946b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1184257057);
                    ((InvoicesXMAClickHandler) this.f5946b.f5948a.get()).m6291a(view.getContext(), commerceBubbleModel2);
                    Logger.a(2, EntryType.UI_INPUT_END, 1208305732, a);
                }
            });
        }
    }

    @Inject
    public InvoicesStyleRenderer(Lazy<InvoicesXMAClickHandler> lazy, Lazy<InvoicesXMAModelCreator> lazy2, Product product) {
        this.f5948a = lazy;
        this.f5949b = lazy2;
        this.f5950c = product;
    }

    protected final com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder m6287b(ViewGroup viewGroup) {
        return new ViewHolder(new MultiItemInvoiceView(viewGroup.getContext()));
    }
}
