package com.facebook.events.tickets.modal;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventTicketOrder;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketOrderModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketOrdersQueryModel.PurchasedTicketOrdersModel.EdgesModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.tickets.modal.views.EventTicketOrderRowView;
import com.facebook.widget.listview.AdapterCompatibleWithListView;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: arg_is_checkpoint */
public class EventTicketOrdersAdapter extends Adapter<TicketOrderViewHolder> implements AdapterCompatibleWithListView<TicketOrderViewHolder> {
    public static final Function<EdgesModel, EventTicketOrder> f19266a = new C27231();
    private final FetchEventPermalinkFragmentModel f19267b;
    public ImmutableList<EventTicketOrder> f19268c = RegularImmutableList.a;

    /* compiled from: arg_is_checkpoint */
    final class C27231 implements Function<EdgesModel, EventTicketOrder> {
        C27231() {
        }

        @Nullable
        public final Object apply(Object obj) {
            return ((EdgesModel) obj).a();
        }
    }

    /* compiled from: arg_is_checkpoint */
    public class TicketOrderViewHolder extends ViewHolder {
        public TicketOrderViewHolder(View view) {
            super(view);
        }
    }

    public final void m19427a(ViewHolder viewHolder, int i) {
        ((EventTicketOrderRowView) ((TicketOrderViewHolder) viewHolder).a).m19510a((EventTicketOrderModel) this.f19268c.get(i), this.f19267b);
    }

    public EventTicketOrdersAdapter(FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        this.f19267b = fetchEventPermalinkFragmentModel;
    }

    public final ViewHolder m19426a(ViewGroup viewGroup, int i) {
        EventTicketOrderRowView eventTicketOrderRowView = new EventTicketOrderRowView(viewGroup.getContext());
        eventTicketOrderRowView.setLayoutParams(new LayoutParams(-1, -2));
        return new TicketOrderViewHolder(eventTicketOrderRowView);
    }

    public final int aZ_() {
        return this.f19268c.size();
    }

    public final int iy_() {
        return 1;
    }

    public Object getItem(int i) {
        return this.f19268c.get(i);
    }
}
