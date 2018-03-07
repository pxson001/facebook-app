package com.facebook.events.tickets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketTierPermalinkFragmentModel.TicketTiersModel.NodesModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketTierPermalinkFragmentModel.TicketTiersModel.NodesModel.TierPriceModel;
import com.facebook.events.tickets.EventBuyTicketsQuantityButtonsAdapter.OnQuantityChangeListener;
import com.facebook.inject.FbInjector;
import com.facebook.payments.model.PriceFormatter;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import java.math.BigDecimal;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: attachment_popup */
public class EventBuyTicketsQuantityPickerView extends CustomLinearLayout {
    @Inject
    public EventBuyTicketsQuantityButtonsAdapter f19170a;
    private FbTextView f19171b;
    private BetterRecyclerView f19172c;

    private static <T extends View> void m19350a(Class<T> cls, T t) {
        m19351a((Object) t, t.getContext());
    }

    private static void m19351a(Object obj, Context context) {
        ((EventBuyTicketsQuantityPickerView) obj).f19170a = EventBuyTicketsQuantityButtonsAdapter.m19341b(FbInjector.get(context));
    }

    public EventBuyTicketsQuantityPickerView(Context context) {
        super(context);
        m19348a(context);
    }

    public EventBuyTicketsQuantityPickerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m19348a(context);
    }

    private void m19348a(Context context) {
        m19350a(EventBuyTicketsQuantityPickerView.class, (View) this);
        setOrientation(1);
        setContentView(2130904004);
        this.f19172c = (BetterRecyclerView) a(2131561218);
        this.f19171b = (FbTextView) a(2131561219);
        m19352b(context);
    }

    private void m19349a(EventBuyTicketsQuantityButtonsAdapter eventBuyTicketsQuantityButtonsAdapter) {
        this.f19170a = eventBuyTicketsQuantityButtonsAdapter;
    }

    private void m19352b(Context context) {
        BetterLinearLayoutManager betterLinearLayoutManager = new BetterLinearLayoutManager(context);
        betterLinearLayoutManager.b(0);
        this.f19172c.setLayoutManager(betterLinearLayoutManager);
        this.f19172c.setAdapter(this.f19170a);
    }

    public final void m19353a(NodesModel nodesModel, int i, OnQuantityChangeListener onQuantityChangeListener) {
        this.f19170a.m19347e(i, nodesModel.c());
        this.f19170a.f19166b = onQuantityChangeListener;
        TierPriceModel ec_ = nodesModel.ec_();
        this.f19171b.setText(PriceFormatter.a(ec_.a(), new BigDecimal(ec_.c()).multiply(new BigDecimal(i)).divide(new BigDecimal(ec_.b()))));
    }
}
