package com.facebook.messaging.inbox2.bymm;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.inbox2.items.InboxAdapter;
import com.facebook.messaging.inbox2.items.InboxItem;
import com.facebook.orca.threadlist.ThreadListAdapter.C09897;
import com.facebook.orca.threadlist.ThreadListFragment.AnonymousClass18;
import com.facebook.orca.threadlist.ThreadListFragment.ThreadListItemClickListener;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: set_new_event_reminder */
public class InboxBYMMAdapter extends Adapter<InboxBYMMItemViewHolder> implements InboxAdapter {
    private final LayoutInflater f2676a;
    private final OnClickListener f2677b = new C04431(this);
    public InboxBYMMViewData f2678c;
    public C09897 f2679d;
    public ImmutableList<InboxBusinessYouMayMessage> f2680e;

    /* compiled from: set_new_event_reminder */
    class C04431 implements OnClickListener {
        final /* synthetic */ InboxBYMMAdapter f2675a;

        C04431(InboxBYMMAdapter inboxBYMMAdapter) {
            this.f2675a = inboxBYMMAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1150471232);
            InboxBYMMAdapter.m2645a(this.f2675a, view);
            Logger.a(2, EntryType.UI_INPUT_END, 2005145761, a);
        }
    }

    public final void m2647a(ViewHolder viewHolder, int i) {
        ((InboxBYMMItemView) ((InboxBYMMItemViewHolder) viewHolder).a).m2654a((InboxBusinessYouMayMessage) this.f2680e.get(i));
    }

    @Inject
    public InboxBYMMAdapter(LayoutInflater layoutInflater) {
        this.f2676a = layoutInflater;
        a(true);
    }

    public static void m2645a(InboxBYMMAdapter inboxBYMMAdapter, View view) {
        InboxBusinessYouMayMessage inboxBusinessYouMayMessage = ((InboxBYMMItemView) view).f2683b;
        if (inboxBusinessYouMayMessage != null && inboxBYMMAdapter.f2679d != null) {
            C09897 c09897 = inboxBYMMAdapter.f2679d;
            if (c09897.f6560b.f6573j != null) {
                AnonymousClass18 anonymousClass18 = c09897.f6560b.f6573j;
                anonymousClass18.f6606a.bB.m2624a(inboxBusinessYouMayMessage.f2692b, c09897.f6559a);
                ThreadListItemClickListener threadListItemClickListener = anonymousClass18.f6606a.cI;
            }
        }
    }

    public final int aZ_() {
        return this.f2680e.size();
    }

    public final InboxItem m2649b(int i) {
        return ((InboxBusinessYouMayMessage) this.f2680e.get(i)).f2692b;
    }

    public final long H_(int i) {
        return m2649b(i).c();
    }

    public final ViewHolder m2646a(ViewGroup viewGroup, int i) {
        View inflate = this.f2676a.inflate(2130904857, viewGroup, false);
        inflate.setOnClickListener(this.f2677b);
        return new InboxBYMMItemViewHolder(inflate);
    }

    public final int m2648b() {
        return this.f2680e.size();
    }
}
