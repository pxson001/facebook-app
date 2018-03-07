package com.facebook.orca.threadview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.inject.Assisted;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.threadview.rows.RowItem;
import com.facebook.messaging.threadview.rows.RowMessageItem;
import com.facebook.messaging.threadview.rows.RowViewType;
import com.facebook.orca.threadview.messagelist.MessageListViewTypeHelper;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.animatablelistview.ItemBasedListAdapter;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: messenger_reminder */
public class MessageListAdapterForListView extends BaseAdapter implements ItemBasedListAdapter<RowItem> {
    private final Context f7209a;
    public final MessageListAdapter f7210b;
    private final MessageListViewTypeHelper f7211c;

    /* compiled from: messenger_reminder */
    public class C10811 {
        public final /* synthetic */ MessageListAdapterForListView f7208a;

        C10811(MessageListAdapterForListView messageListAdapterForListView) {
            this.f7208a = messageListAdapterForListView;
        }
    }

    public final /* synthetic */ int m6894a(Object obj) {
        return m6892c((RowItem) obj);
    }

    public final /* synthetic */ boolean m6900c(Object obj) {
        return m6893d((RowItem) obj);
    }

    public /* synthetic */ Object getItem(int i) {
        return m6896a(i);
    }

    @Inject
    public MessageListAdapterForListView(Context context, MessageListViewTypeHelper messageListViewTypeHelper, @Assisted MessageListAdapter messageListAdapter) {
        this.f7209a = (Context) Preconditions.checkNotNull(context);
        this.f7211c = messageListViewTypeHelper;
        this.f7210b = (MessageListAdapter) Preconditions.checkNotNull(messageListAdapter);
    }

    public boolean areAllItemsEnabled() {
        return true;
    }

    public int getCount() {
        return this.f7210b.m6889g();
    }

    public final RowItem m6896a(int i) {
        return this.f7210b.m6885a(i);
    }

    public long getItemId(int i) {
        RowItem a = m6896a(i);
        return a != null ? m6891b(a) : Long.MIN_VALUE;
    }

    private static long m6891b(RowItem rowItem) {
        return rowItem.a();
    }

    public int getItemViewType(int i) {
        RowItem a = m6896a(i);
        return a != null ? m6892c(a) : -1;
    }

    private int m6892c(RowItem rowItem) {
        return this.f7211c.m8237a(rowItem).ordinal();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return m6890a(m6896a(i), view, viewGroup);
    }

    private View m6890a(RowItem rowItem, View view, ViewGroup viewGroup) {
        if (rowItem == null) {
            return new View(this.f7209a);
        }
        if (view == null) {
            view = this.f7210b.m6884a(this.f7211c.m8237a(rowItem), viewGroup);
        }
        this.f7210b.m6886a(view, rowItem);
        return view;
    }

    public int getViewTypeCount() {
        return RowViewType.LENGTH;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isEnabled(int i) {
        RowItem a = m6896a(i);
        return a != null && m6893d(a);
    }

    private static boolean m6893d(RowItem rowItem) {
        if ((rowItem instanceof RowMessageItem) && MessageUtil.B(((RowMessageItem) rowItem).f4732a)) {
            return false;
        }
        return true;
    }

    public final ImmutableList<RowItem> m6897a() {
        return this.f7210b.f7184J;
    }

    public final void m6899b(List<RowItem> list) {
        this.f7210b.m6888a((List) list);
        AdapterDetour.a(this, -851702333);
    }
}
