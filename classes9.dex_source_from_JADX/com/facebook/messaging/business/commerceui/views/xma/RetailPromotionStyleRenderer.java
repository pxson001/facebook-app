package com.facebook.messaging.business.commerceui.views.xma;

import android.content.Context;
import android.view.ViewGroup;
import com.facebook.messaging.business.attachments.converters.PlatformAttachmentsConverter;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachment;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachmentBuilder;
import com.facebook.messaging.business.attachments.views.PlatformGenericAttachmentItemView;
import com.facebook.messaging.business.attachments.views.PlatformGenericAttachmentView;
import com.facebook.messaging.business.commerce.converters.ModelConverters;
import com.facebook.messaging.business.common.calltoaction.converters.CallToActionModelConverter;
import com.facebook.messaging.business.common.calltoaction.graphql.PlatformCTAFragmentsModels.PlatformCallToActionModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceRetailItem;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommercePromotionsModel.PromotionItemsModel;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.StoryAttachmentTargetFragmentModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.xma.SimpleStyleRenderer;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: nmor_payment_method */
public class RetailPromotionStyleRenderer extends SimpleStyleRenderer<ViewHolder> {
    private final Context f8671a;

    /* compiled from: nmor_payment_method */
    public class ViewHolder extends com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder {
        public ViewHolder(PlatformGenericAttachmentView platformGenericAttachmentView) {
            super(platformGenericAttachmentView);
        }
    }

    protected final void m8883a(com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder viewHolder, XMAModel xMAModel) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Preconditions.checkNotNull(xMAModel);
        Preconditions.checkNotNull(xMAModel.c());
        Preconditions.checkNotNull(xMAModel.c().k());
        StoryAttachmentTargetFragmentModel k = xMAModel.c().k();
        Preconditions.checkNotNull(k);
        PlatformGenericAttachmentBuilder platformGenericAttachmentBuilder = new PlatformGenericAttachmentBuilder();
        platformGenericAttachmentBuilder.a = k.c();
        platformGenericAttachmentBuilder.b = k.g();
        platformGenericAttachmentBuilder.c = ModelConverters.a(k.at_());
        List arrayList = new ArrayList();
        ImmutableList aB_ = k.aB_();
        if (aB_ != null) {
            int size = aB_.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(CallToActionModelConverter.a((PlatformCallToActionModel) aB_.get(i)));
            }
        }
        platformGenericAttachmentBuilder.d = arrayList;
        PromotionItemsModel u = k.u();
        if (u != null) {
            ImmutableList a = u.a();
            if (!(a == null || a.isEmpty())) {
                platformGenericAttachmentBuilder.e = PlatformAttachmentsConverter.a((CommerceRetailItem) a.get(0));
            }
        }
        PlatformGenericAttachment platformGenericAttachment = new PlatformGenericAttachment(platformGenericAttachmentBuilder);
        Preconditions.checkNotNull(platformGenericAttachment);
        PlatformGenericAttachmentView platformGenericAttachmentView = (PlatformGenericAttachmentView) viewHolder2.a;
        platformGenericAttachmentView.setModel(platformGenericAttachment);
        if (platformGenericAttachmentView.f8364d.d()) {
            ((PlatformGenericAttachmentItemView) platformGenericAttachmentView.f8364d.a()).m8645a();
        }
    }

    @Inject
    public RetailPromotionStyleRenderer(Context context) {
        this.f8671a = context;
    }

    protected final com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder m8884b(ViewGroup viewGroup) {
        return new ViewHolder(new PlatformGenericAttachmentView(this.f8671a));
    }
}
