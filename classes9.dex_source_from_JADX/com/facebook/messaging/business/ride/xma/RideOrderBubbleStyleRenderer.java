package com.facebook.messaging.business.ride.xma;

import android.content.Context;
import android.view.ViewGroup;
import com.facebook.messaging.business.ride.view.RideOrderBubbleView;
import com.facebook.messaging.business.ride.view.RideOrderBubbleView.C10881;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.StoryAttachmentTargetFragmentModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.xma.SimpleStyleRenderer;
import javax.inject.Inject;

/* compiled from: mms_network_extension_timer */
public class RideOrderBubbleStyleRenderer extends SimpleStyleRenderer<ViewHolder> {
    private Context f9427a;

    /* compiled from: mms_network_extension_timer */
    public class ViewHolder extends com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder {
        public ViewHolder(RideOrderBubbleView rideOrderBubbleView) {
            super(rideOrderBubbleView);
        }
    }

    protected final void m9891a(com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder viewHolder, XMAModel xMAModel) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        if (xMAModel != null && xMAModel.c() != null && xMAModel.c().k() != null) {
            RideOrderBubbleView rideOrderBubbleView = (RideOrderBubbleView) viewHolder2.a;
            StoryAttachmentTargetFragmentModel k = xMAModel.c().k();
            rideOrderBubbleView.f9367c.setText(rideOrderBubbleView.getResources().getString(2131240758, new Object[]{k.bf()}));
            rideOrderBubbleView.f9368d.m9868a(k.bl(), k.am());
            rideOrderBubbleView.f9366b.a(new C10881(rideOrderBubbleView, k));
        }
    }

    @Inject
    public RideOrderBubbleStyleRenderer(Context context) {
        this.f9427a = context;
    }

    protected final com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder m9892b(ViewGroup viewGroup) {
        return new ViewHolder(new RideOrderBubbleView(this.f9427a));
    }
}
