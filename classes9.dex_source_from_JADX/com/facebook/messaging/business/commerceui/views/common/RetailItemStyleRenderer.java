package com.facebook.messaging.business.commerceui.views.common;

import android.content.Context;
import android.view.ViewGroup;
import com.facebook.messaging.business.attachments.converters.PlatformAttachmentsConverter;
import com.facebook.messaging.business.attachments.views.PlatformGenericAttachmentItemView;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentStoryFieldsModel.SubattachmentsModel;
import com.facebook.messaging.xma.SimpleStyleRenderer;
import javax.inject.Inject;

/* compiled from: null_logged_in_user */
public class RetailItemStyleRenderer extends SimpleStyleRenderer<ViewHolder> {
    private final Context f8445a;

    /* compiled from: null_logged_in_user */
    public class ViewHolder extends com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder {
        public ViewHolder(PlatformGenericAttachmentItemView platformGenericAttachmentItemView) {
            super(platformGenericAttachmentItemView);
        }
    }

    protected final void m8708a(com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder viewHolder, SubattachmentsModel subattachmentsModel) {
        ((PlatformGenericAttachmentItemView) ((ViewHolder) viewHolder).a).m8646a(PlatformAttachmentsConverter.a(subattachmentsModel.g()), null, null);
    }

    @Inject
    public RetailItemStyleRenderer(Context context) {
        this.f8445a = context;
    }

    protected final com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder m8710b(ViewGroup viewGroup) {
        return new ViewHolder(new PlatformGenericAttachmentItemView(this.f8445a));
    }
}
