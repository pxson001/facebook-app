package com.facebook.messaging.business.commerceui.views.xma;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.content.SecureContextHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.commerce.model.retail.CommerceData;
import com.facebook.messaging.business.commerceui.analytics.MessengerCommerceAnalyticsLogger;
import com.facebook.messaging.business.commerceui.views.retail.CommerceViewHelpers;
import com.facebook.messaging.business.commerceui.views.retail.MultiItemReceiptView;
import com.facebook.messaging.business.commerceui.views.retail.ReceiptDetailsFragment;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.xma.SimpleStyleRenderer;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: notif_delay */
public class CommerceBubbleReceiptAndCancellationStyleRenderer extends SimpleStyleRenderer<ViewHolder> {
    private Context f8650a;
    public MessengerCommerceAnalyticsLogger f8651b;
    public SecureContextHelper f8652c;

    /* compiled from: notif_delay */
    public class ViewHolder extends com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder {
        public final MultiItemReceiptView f8649b;

        public ViewHolder(MultiItemReceiptView multiItemReceiptView) {
            super(multiItemReceiptView);
            this.f8649b = multiItemReceiptView;
        }
    }

    protected final void m8863a(com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder viewHolder, XMAModel xMAModel) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Preconditions.checkNotNull(xMAModel);
        Preconditions.checkNotNull(xMAModel.c());
        Preconditions.checkNotNull(xMAModel.c().k());
        MultiItemReceiptView multiItemReceiptView = viewHolder2.f8649b;
        final CommerceData a = CommerceData.a(xMAModel.c().k());
        Preconditions.checkNotNull(a);
        multiItemReceiptView.setModel(a.a);
        final Intent c = ReceiptDetailsFragment.m8792c(multiItemReceiptView.getContext(), CommerceViewHelpers.m8753a(a.a));
        Preconditions.checkNotNull(c);
        multiItemReceiptView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CommerceBubbleReceiptAndCancellationStyleRenderer f8648c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 533654189);
                this.f8648c.f8651b.m8654a(a.a.b(), a.a.a());
                this.f8648c.f8652c.a(c, view.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, -963889327, a);
            }
        });
    }

    @Inject
    public CommerceBubbleReceiptAndCancellationStyleRenderer(Context context, MessengerCommerceAnalyticsLogger messengerCommerceAnalyticsLogger, SecureContextHelper secureContextHelper) {
        this.f8650a = context;
        this.f8651b = messengerCommerceAnalyticsLogger;
        this.f8652c = secureContextHelper;
    }

    protected final com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder m8864b(ViewGroup viewGroup) {
        return new ViewHolder(new MultiItemReceiptView(this.f8650a));
    }
}
