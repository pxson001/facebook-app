package com.facebook.payments.checkout.recyclerview;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.facebook.payments.checkout.CheckoutParams;
import com.facebook.payments.checkout.CheckoutStyle;
import com.facebook.payments.checkout.CheckoutStyleAssociation;
import com.facebook.payments.checkout.SimpleCheckoutManager;
import com.facebook.payments.ui.PaymentsComponentRow;
import com.facebook.payments.ui.PaymentsComponentViewHolder;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: canonical_presence_checks */
public class CheckoutAdapter extends Adapter<PaymentsComponentViewHolder> {
    private final SimpleCheckoutManager f18526a;
    public CheckoutParams f18527b;
    public ImmutableList<CheckoutRow> f18528c = RegularImmutableList.a;
    public SimplePaymentsComponentCallback f18529d;

    public final void m18542a(ViewHolder viewHolder, int i) {
        PaymentsComponentViewHolder paymentsComponentViewHolder = (PaymentsComponentViewHolder) viewHolder;
        paymentsComponentViewHolder.a(this.f18529d);
        paymentsComponentViewHolder.a((PaymentsComponentRow) this.f18528c.get(i));
    }

    @Inject
    public CheckoutAdapter(SimpleCheckoutManager simpleCheckoutManager) {
        this.f18526a = simpleCheckoutManager;
    }

    public int getItemViewType(int i) {
        return ((CheckoutRow) this.f18528c.get(i)).mo635a().ordinal();
    }

    public final ViewHolder m18541a(ViewGroup viewGroup, int i) {
        SimpleCheckoutRowViewHolderFactory simpleCheckoutRowViewHolderFactory;
        SimpleCheckoutManager simpleCheckoutManager = this.f18526a;
        CheckoutStyle checkoutStyle = this.f18527b.mo627a().f18459a;
        if (simpleCheckoutManager.f18488a.containsKey(checkoutStyle)) {
            simpleCheckoutRowViewHolderFactory = (SimpleCheckoutRowViewHolderFactory) ((CheckoutStyleAssociation) simpleCheckoutManager.f18488a.get(checkoutStyle)).f15733k.get();
        } else {
            simpleCheckoutRowViewHolderFactory = (SimpleCheckoutRowViewHolderFactory) ((CheckoutStyleAssociation) simpleCheckoutManager.f18488a.get(CheckoutStyle.SIMPLE)).f15733k.get();
        }
        return simpleCheckoutRowViewHolderFactory.mo628a(viewGroup, CheckoutRowType.values()[i]);
    }

    public final int aZ_() {
        return this.f18528c.size();
    }
}
