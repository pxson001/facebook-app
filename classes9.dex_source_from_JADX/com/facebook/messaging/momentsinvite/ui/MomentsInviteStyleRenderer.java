package com.facebook.messaging.momentsinvite.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.xma.SimpleStyleRenderer;
import javax.inject.Inject;

/* compiled from: itemAmount */
public class MomentsInviteStyleRenderer extends SimpleStyleRenderer<ViewHolder> {
    private Context f12341a;

    /* compiled from: itemAmount */
    public class ViewHolder extends com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder {
        public final MomentsInviteView f12340b = ((MomentsInviteView) a(2131564932));

        public ViewHolder(View view) {
            super(view);
        }
    }

    protected final void m12806a(com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder viewHolder, XMAModel xMAModel) {
        ((ViewHolder) viewHolder).f12340b.setModelFromXMA(xMAModel);
    }

    @Inject
    public MomentsInviteStyleRenderer(Context context) {
        this.f12341a = context;
    }

    protected final com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder m12807b(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.f12341a).inflate(2130905746, viewGroup, false));
    }
}
