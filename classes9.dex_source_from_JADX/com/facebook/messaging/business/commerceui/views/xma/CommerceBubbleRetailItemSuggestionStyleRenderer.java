package com.facebook.messaging.business.commerceui.views.xma;

import android.content.Context;
import android.view.ViewGroup;
import com.facebook.messaging.business.commerce.model.retail.CommerceData;
import com.facebook.messaging.business.commerceui.views.retail.RetailItemSuggestionView;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.xma.SimpleStyleRenderer;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: normalized_id */
public class CommerceBubbleRetailItemSuggestionStyleRenderer extends SimpleStyleRenderer<ViewHolder> {
    private Context f8655a;

    /* compiled from: normalized_id */
    public class ViewHolder extends com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder {
        public final RetailItemSuggestionView f8654b;

        public ViewHolder(RetailItemSuggestionView retailItemSuggestionView) {
            super(retailItemSuggestionView);
            this.f8654b = retailItemSuggestionView;
        }
    }

    protected final void m8866a(com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder viewHolder, XMAModel xMAModel) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Preconditions.checkNotNull(xMAModel);
        Preconditions.checkNotNull(xMAModel.c());
        Preconditions.checkNotNull(xMAModel.c().k());
        RetailItemSuggestionView retailItemSuggestionView = viewHolder2.f8654b;
        CommerceData a = CommerceData.a(xMAModel.c().k());
        Preconditions.checkNotNull(a);
        retailItemSuggestionView.setModel(a.a);
    }

    @Inject
    public CommerceBubbleRetailItemSuggestionStyleRenderer(Context context) {
        this.f8655a = context;
    }

    protected final com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder m8867b(ViewGroup viewGroup) {
        return new ViewHolder(new RetailItemSuggestionView(this.f8655a));
    }
}
