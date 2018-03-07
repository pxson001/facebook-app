package com.facebook.payments.confirmation;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.facebook.payments.ui.PaymentsComponentRow;
import com.facebook.payments.ui.PaymentsComponentViewHolder;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: caller */
public class ConfirmationAdapter extends Adapter<PaymentsComponentViewHolder> {
    private final SimpleConfirmationManager f18589a;
    public ImmutableList<ConfirmationRow> f18590b = RegularImmutableList.a;
    public ConfirmationParams f18591c;
    public SimplePaymentsComponentCallback f18592d;

    public final void m18617a(ViewHolder viewHolder, int i) {
        PaymentsComponentViewHolder paymentsComponentViewHolder = (PaymentsComponentViewHolder) viewHolder;
        paymentsComponentViewHolder.a(this.f18592d);
        paymentsComponentViewHolder.a((PaymentsComponentRow) this.f18590b.get(i));
    }

    @Inject
    public ConfirmationAdapter(SimpleConfirmationManager simpleConfirmationManager) {
        this.f18589a = simpleConfirmationManager;
    }

    public int getItemViewType(int i) {
        return ((ConfirmationRow) this.f18590b.get(i)).mo733a().ordinal();
    }

    public final ViewHolder m18616a(ViewGroup viewGroup, int i) {
        return this.f18589a.m18649b(this.f18591c.mo732a().f18593a).m18653a(viewGroup, ConfirmationRowType.values()[i]);
    }

    public final int aZ_() {
        return this.f18590b.size();
    }
}
