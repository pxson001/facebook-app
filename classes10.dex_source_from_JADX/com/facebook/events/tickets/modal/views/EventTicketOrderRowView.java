package com.facebook.events.tickets.modal.views;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.i18n.BasicDateTimeFormat;
import com.facebook.common.util.FinanceUtils;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventTicketOrder.EventTickets.Nodes.Fbqrcode;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketOrderModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketOrderModel.EventTicketsModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketOrderModel.EventTicketsModel.NodesModel.FbqrcodeModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketTierPermalinkFragmentModel.TicketTiersModel.NodesModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: application_tracking_enabled */
public class EventTicketOrderRowView extends EventTicketingLinearLayout {
    @Inject
    public BasicDateTimeFormat f19350a;
    public EventTicketingInfoRowView f19351c = ((EventTicketingInfoRowView) a(2131561438));
    public FbTextView f19352d = ((FbTextView) a(2131561441));
    public FbTextView f19353e = ((FbTextView) a(2131561440));
    public FbTextView f19354f = ((FbTextView) a(2131561439));
    public FbTextView f19355g = ((FbTextView) a(2131561442));
    public FbTextView f19356h = ((FbTextView) a(2131561443));
    public FbTextView f19357i = ((FbTextView) a(2131561444));
    public FbTextView f19358j = ((FbTextView) a(2131561437));
    @Nullable
    private EventTicketOrderModel f19359k;

    public static void m19505a(Object obj, Context context) {
        ((EventTicketOrderRowView) obj).f19350a = BasicDateTimeFormat.a(FbInjector.get(context));
    }

    public EventTicketOrderRowView(Context context) {
        super(context);
        Class cls = EventTicketOrderRowView.class;
        m19505a((Object) this, getContext());
        setContentView(2130904106);
    }

    public final void m19510a(EventTicketOrderModel eventTicketOrderModel, FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        this.f19359k = (EventTicketOrderModel) Preconditions.checkNotNull(eventTicketOrderModel);
        EventTicketingInfoRowView eventTicketingInfoRowView = this.f19351c;
        String str = null;
        eventTicketingInfoRowView.f19365a.setText(fetchEventPermalinkFragmentModel.dM_());
        EventTicketingInfoRowView.m19517a(eventTicketingInfoRowView.f19366c, fetchEventPermalinkFragmentModel.d() != null ? fetchEventPermalinkFragmentModel.d().dU_() : null);
        if (fetchEventPermalinkFragmentModel.d() == null || Strings.isNullOrEmpty(fetchEventPermalinkFragmentModel.d().dU_())) {
            eventTicketingInfoRowView.f19366c.setVisibility(8);
        } else {
            eventTicketingInfoRowView.f19366c.setText(fetchEventPermalinkFragmentModel.d().dU_());
            eventTicketingInfoRowView.f19366c.setVisibility(0);
        }
        if (!(fetchEventPermalinkFragmentModel.ac() == null || fetchEventPermalinkFragmentModel.ac().a().isEmpty())) {
            str = ((NodesModel) fetchEventPermalinkFragmentModel.ac().a().get(0)).g();
        }
        EventTicketingInfoRowView.m19517a(eventTicketingInfoRowView.f19367d, eventTicketingInfoRowView.getResources().getString(2131241927, new Object[]{str}));
        this.f19353e.setText(FinanceUtils.a(this.f19359k.j().b(), (long) this.f19359k.j().a(), 2));
        this.f19354f.setText(m19506b(this.f19359k));
        if (m19508c()) {
            this.f19355g.setVisibility(0);
            this.f19356h.setVisibility(0);
            this.f19356h.setText(this.f19359k.c());
        } else {
            this.f19355g.setVisibility(8);
            this.f19356h.setVisibility(8);
        }
        if (m19509d()) {
            this.f19357i.setVisibility(0);
            this.f19358j.setVisibility(0);
            this.f19358j.setText(this.f19359k.b());
        } else {
            this.f19357i.setVisibility(8);
            this.f19358j.setVisibility(8);
        }
        this.f19352d.setText(m19504a(this.f19359k));
        m19507b();
    }

    private void m19507b() {
        Preconditions.checkNotNull(this.f19359k);
        Deque<View> linkedList = new LinkedList();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof EventTicketQrCodeView) {
                linkedList.offer((EventTicketQrCodeView) childAt);
            }
        }
        for (View childAt2 : linkedList) {
            removeView(childAt2);
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131427418);
        ImmutableList qrCodes = getQrCodes();
        for (int i2 = 0; i2 < qrCodes.size(); i2++) {
            boolean z;
            boolean z2;
            int i3;
            FbqrcodeModel fbqrcodeModel = (FbqrcodeModel) qrCodes.get(i2);
            EventTicketQrCodeView eventTicketQrCodeView = !linkedList.isEmpty() ? (EventTicketQrCodeView) linkedList.poll() : (EventTicketQrCodeView) LayoutInflater.from(getContext()).inflate(2130904110, this, false);
            LayoutParams layoutParams = (LayoutParams) eventTicketQrCodeView.getLayoutParams();
            if (i2 == 0) {
                z = true;
            } else {
                z = false;
            }
            if (i2 == qrCodes.size() - 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            layoutParams.f19368a = z;
            if (z) {
                i3 = dimensionPixelSize;
            } else {
                i3 = 0;
            }
            eventTicketQrCodeView.setPadding(0, i3, 0, z2 ? dimensionPixelSize : 0);
            addView(eventTicketQrCodeView);
            eventTicketQrCodeView.m19515a(this.f19359k, fbqrcodeModel, i2 + 1, qrCodes.size());
        }
    }

    private ImmutableList<Fbqrcode> getQrCodes() {
        Builder builder = ImmutableList.builder();
        EventTicketsModel g = this.f19359k.g();
        if (g != null) {
            ImmutableList a = g.a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                Object obj;
                FbqrcodeModel a2 = ((EventTicketsModel.NodesModel) a.get(i)).a();
                if (a2 == null || a2.b() == null || a2.b().b() == null || a2.b().b().b() == null) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    builder.c(a2);
                }
            }
        }
        return builder.b();
    }

    private boolean m19508c() {
        return !Strings.isNullOrEmpty(this.f19359k.c());
    }

    private boolean m19509d() {
        return !Strings.isNullOrEmpty(this.f19359k.b());
    }

    private String m19504a(EventTicketOrderModel eventTicketOrderModel) {
        String format = this.f19350a.h().format(new Date(eventTicketOrderModel.d() * 1000));
        return getResources().getString(2131241950, new Object[]{format, eventTicketOrderModel.dY_().a(), eventTicketOrderModel.dY_().b()});
    }

    private String m19506b(EventTicketOrderModel eventTicketOrderModel) {
        if (eventTicketOrderModel.dX_() == null || Strings.isNullOrEmpty(eventTicketOrderModel.dX_().b())) {
            if (eventTicketOrderModel.dW_() == 1) {
                return getResources().getQuantityString(2131689811, eventTicketOrderModel.dW_());
            }
            return getResources().getQuantityString(2131689811, eventTicketOrderModel.dW_(), new Object[]{Integer.valueOf(eventTicketOrderModel.dW_())});
        } else if (eventTicketOrderModel.dW_() == 1) {
            return getResources().getQuantityString(2131689810, eventTicketOrderModel.dW_(), new Object[]{eventTicketOrderModel.dX_().b()});
        } else {
            return getResources().getQuantityString(2131689810, eventTicketOrderModel.dW_(), new Object[]{Integer.valueOf(eventTicketOrderModel.dW_()), eventTicketOrderModel.dX_().b()});
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f19349b.b(canvas);
    }
}
