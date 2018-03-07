package com.facebook.messaging.business.agent.xma;

import android.content.Context;
import android.view.ViewGroup;
import com.facebook.messaging.business.agent.view.AgentItemReceiptView;
import com.facebook.messaging.business.agent.view.AgentItemReceiptView.C02531;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.StoryAttachmentTargetFragmentModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.xma.SimpleStyleRenderer;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: thread_picture */
public class AgentItemReceiptStyleRenderer extends SimpleStyleRenderer<ViewHolder> {
    private Context f1506a;

    /* compiled from: thread_picture */
    public class ViewHolder extends com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder {
        public final AgentItemReceiptView f1505b;

        public ViewHolder(AgentItemReceiptView agentItemReceiptView) {
            super(agentItemReceiptView);
            this.f1505b = agentItemReceiptView;
        }
    }

    protected final void m1476a(com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder viewHolder, XMAModel xMAModel) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Preconditions.checkNotNull(xMAModel);
        Preconditions.checkNotNull(xMAModel.c());
        Preconditions.checkNotNull(xMAModel.c().k());
        AgentItemReceiptView agentItemReceiptView = viewHolder2.f1505b;
        StoryAttachmentTargetFragmentModel k = xMAModel.c().k();
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(k.bL());
        agentItemReceiptView.f1488c = k;
        agentItemReceiptView.f1487b.setOnClickListener(new C02531(agentItemReceiptView));
    }

    @Inject
    public AgentItemReceiptStyleRenderer(Context context) {
        this.f1506a = context;
    }

    protected final com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder m1477b(ViewGroup viewGroup) {
        return new ViewHolder(new AgentItemReceiptView(this.f1506a));
    }
}
