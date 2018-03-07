package com.facebook.messaging.payment.prefs.transactions;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: funding_cvv */
public class MessengerPayHistoryAdapter extends BaseAdapter {
    private final CompositeMessengerPayHistoryItemViewFactory f14329a;
    public ImmutableList<? extends Object> f14330b = RegularImmutableList.a;

    @Inject
    public MessengerPayHistoryAdapter(CompositeMessengerPayHistoryItemViewFactory compositeMessengerPayHistoryItemViewFactory) {
        this.f14329a = compositeMessengerPayHistoryItemViewFactory;
    }

    public int getCount() {
        return this.f14330b.size();
    }

    @Nullable
    public Object getItem(int i) {
        return i >= this.f14330b.size() ? null : this.f14330b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return (View) this.f14329a.mo562a(this.f14330b.get(i), view, viewGroup);
    }
}
