package com.facebook.events.tickets.modal.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketOrderModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketOrderModel.EventTicketsModel.NodesModel.FbqrcodeModel;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: application_requests_senders */
public class EventTicketQrCodeView extends CustomFrameLayout {
    private static final CallerContext f19360b = CallerContext.a(EventTicketOrderRowView.class, "event_ticketing");
    @Inject
    public FbDraweeControllerBuilder f19361a;
    private TextView f19362c;
    private TextView f19363d;
    private FbDraweeView f19364e;

    private static <T extends View> void m19513a(Class<T> cls, T t) {
        m19514a((Object) t, t.getContext());
    }

    private static void m19514a(Object obj, Context context) {
        ((EventTicketQrCodeView) obj).f19361a = FbDraweeControllerBuilder.b(FbInjector.get(context));
    }

    public EventTicketQrCodeView(Context context) {
        super(context);
        m19511a();
    }

    public EventTicketQrCodeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m19511a();
    }

    public EventTicketQrCodeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19511a();
    }

    private void m19512a(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f19361a = fbDraweeControllerBuilder;
    }

    private void m19511a() {
        m19513a(EventTicketQrCodeView.class, (View) this);
        setContentView(2130904109);
        this.f19362c = (TextView) c(2131561408);
        this.f19363d = (TextView) c(2131561456);
        this.f19364e = (FbDraweeView) c(2131561457);
    }

    public final void m19515a(EventTicketOrderModel eventTicketOrderModel, FbqrcodeModel fbqrcodeModel, int i, int i2) {
        if (eventTicketOrderModel.dX_() == null || Strings.isNullOrEmpty(eventTicketOrderModel.dX_().b())) {
            this.f19362c.setText(2131241951);
        } else {
            this.f19362c.setText(getResources().getString(2131241952, new Object[]{eventTicketOrderModel.dX_().b()}));
        }
        this.f19363d.setText(getResources().getString(2131241953, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.f19364e.setController(this.f19361a.a(f19360b).a(fbqrcodeModel.b().b().b()).s());
    }
}
