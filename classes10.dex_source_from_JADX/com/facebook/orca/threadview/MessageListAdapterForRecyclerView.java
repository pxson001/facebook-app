package com.facebook.orca.threadview;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.inject.Assisted;
import com.facebook.messaging.threadview.rows.RowItem;
import com.facebook.messaging.threadview.rows.RowViewType;
import com.facebook.orca.threadview.messagelist.MessageListViewTypeHelper;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: messenger_photo_reminders_inbox_header */
public class MessageListAdapterForRecyclerView extends Adapter<MessageListItemViewHolder> {
    private final MessageListAdapter f7213a;
    private final MessageListViewTypeHelper f7214b;

    /* compiled from: messenger_photo_reminders_inbox_header */
    class C10821 extends AdapterDataObserver {
        final /* synthetic */ MessageListAdapterForRecyclerView f7212a;

        C10821(MessageListAdapterForRecyclerView messageListAdapterForRecyclerView) {
            this.f7212a = messageListAdapterForRecyclerView;
        }

        public final void bb_() {
            this.f7212a.notifyDataSetChanged();
        }

        public final void m6901a(int i, int i2) {
            this.f7212a.a(i, i2);
        }

        public final void m6903b(int i, int i2) {
            this.f7212a.c(i, i2);
        }

        public final void m6904c(int i, int i2) {
            this.f7212a.d(i, i2);
        }

        public final void m6902a(int i, int i2, int i3) {
            boolean z = true;
            if (i3 != 1) {
                z = false;
            }
            Preconditions.checkArgument(z);
            this.f7212a.b(i, i2);
        }
    }

    /* compiled from: messenger_photo_reminders_inbox_header */
    public final class MessageListItemViewHolder extends ViewHolder {
        public MessageListItemViewHolder(View view) {
            super(view);
        }
    }

    @Inject
    @SuppressLint({"ConstructorMayLeakThis"})
    public MessageListAdapterForRecyclerView(MessageListViewTypeHelper messageListViewTypeHelper, @Assisted MessageListAdapter messageListAdapter) {
        this.f7214b = messageListViewTypeHelper;
        this.f7213a = messageListAdapter;
        a(true);
    }

    public final ViewHolder m6905a(ViewGroup viewGroup, int i) {
        return new MessageListItemViewHolder(this.f7213a.m6884a(RowViewType.fromOrdinal(i), viewGroup));
    }

    public final void m6907a(MessageListItemViewHolder messageListItemViewHolder, int i) {
        Preconditions.checkElementIndex(i, aZ_(), "");
        this.f7213a.m6886a(messageListItemViewHolder.a, this.f7213a.m6885a(i));
    }

    public int getItemViewType(int i) {
        RowItem e = m6910e(i);
        return e != null ? this.f7214b.m8237a(e).ordinal() : -1;
    }

    public final long H_(int i) {
        RowItem e = m6910e(i);
        return e != null ? e.a() : -1;
    }

    public final int aZ_() {
        return this.f7213a.m6889g();
    }

    public final RowItem m6910e(int i) {
        return this.f7213a.m6885a(i);
    }

    public final ImmutableList<RowItem> m6909d() {
        return this.f7213a.f7184J;
    }

    public final void m6908a(List<RowItem> list) {
        this.f7213a.m6888a(ImmutableList.copyOf(list));
    }
}
