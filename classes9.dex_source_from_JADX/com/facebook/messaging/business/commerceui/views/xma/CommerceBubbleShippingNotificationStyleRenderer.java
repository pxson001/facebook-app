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
import com.facebook.messaging.business.commerceui.views.retail.ShippingDetailsFragment;
import com.facebook.messaging.business.commerceui.views.retail.ShippingNotificationView;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.xma.SimpleStyleRenderer;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: normalizedId */
public class CommerceBubbleShippingNotificationStyleRenderer extends SimpleStyleRenderer<ViewHolder> {
    private Context f8662a;
    public MessengerCommerceAnalyticsLogger f8663b;
    public SecureContextHelper f8664c;

    /* compiled from: normalizedId */
    public class ViewHolder extends com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder {
        public final ShippingNotificationView f8661b;

        public ViewHolder(ShippingNotificationView shippingNotificationView) {
            super(shippingNotificationView);
            this.f8661b = shippingNotificationView;
        }
    }

    protected final void m8872a(com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder viewHolder, XMAModel xMAModel) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Preconditions.checkNotNull(xMAModel);
        Preconditions.checkNotNull(xMAModel.c());
        Preconditions.checkNotNull(xMAModel.c().k());
        ShippingNotificationView shippingNotificationView = viewHolder2.f8661b;
        final CommerceData a = CommerceData.a(xMAModel.c().k());
        Preconditions.checkNotNull(a);
        shippingNotificationView.setModel(a.a);
        final Intent a2 = ShippingDetailsFragment.m8817a(shippingNotificationView.getContext(), a);
        Preconditions.checkNotNull(a2);
        shippingNotificationView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CommerceBubbleShippingNotificationStyleRenderer f8660c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -798518669);
                this.f8660c.f8663b.m8654a(a.a.b(), a.a.a());
                this.f8660c.f8664c.a(a2, view.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, 835971386, a);
            }
        });
    }

    @Inject
    public CommerceBubbleShippingNotificationStyleRenderer(Context context, MessengerCommerceAnalyticsLogger messengerCommerceAnalyticsLogger, SecureContextHelper secureContextHelper) {
        this.f8662a = context;
        this.f8663b = messengerCommerceAnalyticsLogger;
        this.f8664c = secureContextHelper;
    }

    protected final com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder m8873b(ViewGroup viewGroup) {
        return new ViewHolder(new ShippingNotificationView(this.f8662a));
    }
}
