package com.facebook.messaging.business.commerceui.views.xma;

import android.content.Context;
import android.view.ViewGroup;
import com.facebook.messaging.business.commerce.model.retail.CommerceData;
import com.facebook.messaging.business.commerceui.views.retail.ProductSubscriptionView;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.xma.SimpleStyleRenderer;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: node(%s) { %s } */
public class CommerceBubbleSubscriptionStyleRenderer extends SimpleStyleRenderer<ViewHolder> {
    private Context f8669a;

    /* compiled from: node(%s) { %s } */
    public class ViewHolder extends com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder {
        public final ProductSubscriptionView f8668b;

        public ViewHolder(ProductSubscriptionView productSubscriptionView) {
            super(productSubscriptionView);
            this.f8668b = productSubscriptionView;
        }
    }

    protected final void m8878a(com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder viewHolder, XMAModel xMAModel) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Preconditions.checkNotNull(xMAModel);
        Preconditions.checkNotNull(xMAModel.c());
        Preconditions.checkNotNull(xMAModel.c().k());
        ProductSubscriptionView productSubscriptionView = viewHolder2.f8668b;
        CommerceData a = CommerceData.a(xMAModel.c().k());
        Preconditions.checkNotNull(a);
        productSubscriptionView.setModel(a.a);
    }

    @Inject
    public CommerceBubbleSubscriptionStyleRenderer(Context context) {
        this.f8669a = context;
    }

    protected final com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder m8879b(ViewGroup viewGroup) {
        return new ViewHolder(new ProductSubscriptionView(this.f8669a));
    }
}
