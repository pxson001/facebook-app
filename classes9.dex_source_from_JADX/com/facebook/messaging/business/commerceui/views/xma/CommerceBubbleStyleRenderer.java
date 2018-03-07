package com.facebook.messaging.business.commerceui.views.xma;

import android.content.Context;
import android.view.ViewGroup;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.commerce.model.retail.CommerceData;
import com.facebook.messaging.business.commerceui.views.CommerceBubbleView;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.xma.SimpleStyleRenderer;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: non_specified_start */
public class CommerceBubbleStyleRenderer extends SimpleStyleRenderer<ViewHolder> {
    private Context f8666a;

    /* compiled from: non_specified_start */
    public class ViewHolder extends com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder {
        public final CommerceBubbleView f8665b;

        public ViewHolder(CommerceBubbleView commerceBubbleView) {
            super(commerceBubbleView);
            this.f8665b = commerceBubbleView;
        }
    }

    private static CommerceBubbleStyleRenderer m8874b(InjectorLike injectorLike) {
        return new CommerceBubbleStyleRenderer((Context) injectorLike.getInstance(Context.class));
    }

    protected final void m8875a(com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder viewHolder, XMAModel xMAModel) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Preconditions.checkNotNull(xMAModel);
        Preconditions.checkNotNull(xMAModel.c());
        Preconditions.checkNotNull(xMAModel.c().k());
        viewHolder2.f8665b.setModel(CommerceData.a(xMAModel.c().k()).a);
    }

    @Inject
    public CommerceBubbleStyleRenderer(Context context) {
        this.f8666a = context;
    }

    protected final com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder m8876b(ViewGroup viewGroup) {
        return new ViewHolder(new CommerceBubbleView(this.f8666a));
    }
}
