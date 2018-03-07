package com.facebook.feedback.ui;

import com.facebook.feed.rows.adapter.DelegatingMultiRowAdapter;
import com.facebook.feed.rows.adapter.OneItemListItemCollection;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: right_label */
public class TypingIndicatorAdapter extends DelegatingMultiRowAdapter implements Bindable<Integer> {
    private final OneItemListItemCollection<Integer> f4783a;

    @Inject
    public TypingIndicatorAdapter(@Assisted MultiRowAdapter multiRowAdapter, @Assisted OneItemListItemCollection<Integer> oneItemListItemCollection) {
        super(multiRowAdapter);
        this.f4783a = oneItemListItemCollection;
    }

    public final void m5323a(Integer num) {
        this.f4783a.a = num;
        notifyDataSetChanged();
    }
}
