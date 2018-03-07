package com.facebook.messaging.business.ride.xma;

import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.messaging.business.ride.view.RideReceiptBubbleView;
import com.facebook.messaging.business.ride.view.RideReceiptBubbleView.C10913;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.StoryAttachmentTargetFragmentModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.xma.SimpleStyleRenderer;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: mms-sms */
public class RideReceiptBubbleStyleRenderer extends SimpleStyleRenderer<ViewHolder> {
    private Context f9429a;

    /* compiled from: mms-sms */
    public class ViewHolder extends com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder {
        public ViewHolder(RideReceiptBubbleView rideReceiptBubbleView) {
            super(rideReceiptBubbleView);
        }
    }

    protected final void m9894a(com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder viewHolder, XMAModel xMAModel) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        if (xMAModel != null && xMAModel.c() != null && xMAModel.c().k() != null) {
            RideReceiptBubbleView rideReceiptBubbleView = (RideReceiptBubbleView) viewHolder2.a;
            StoryAttachmentTargetFragmentModel k = xMAModel.c().k();
            String n = xMAModel.c().n();
            rideReceiptBubbleView.f9376d = !Strings.isNullOrEmpty(n) ? Uri.parse(n) : null;
            rideReceiptBubbleView.f9380h.setText(k.bf());
            rideReceiptBubbleView.f9381i.setTitle(k.as());
            rideReceiptBubbleView.f9381i.setText(String.valueOf(k.ar()));
            rideReceiptBubbleView.f9382j.setText(k.ap());
            rideReceiptBubbleView.f9383k.setText(k.aq());
            rideReceiptBubbleView.f9379g.m9868a(k.bl(), k.am());
            rideReceiptBubbleView.f9377e.a(new C10913(rideReceiptBubbleView, k));
            if (k.bg() != null) {
                rideReceiptBubbleView.f9374b.m9023a(k.bg().a(), rideReceiptBubbleView.f9378f, CallerContext.a(RideReceiptBubbleView.class));
            }
        }
    }

    @Inject
    public RideReceiptBubbleStyleRenderer(Context context) {
        this.f9429a = context;
    }

    protected final com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder m9895b(ViewGroup viewGroup) {
        return new ViewHolder(new RideReceiptBubbleView(this.f9429a));
    }
}
