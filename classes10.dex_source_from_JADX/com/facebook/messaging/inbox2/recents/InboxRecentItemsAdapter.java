package com.facebook.messaging.inbox2.recents;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.messaging.inbox2.items.InboxAdapter;
import com.facebook.messaging.inbox2.items.InboxItem;
import com.facebook.messaging.send.common.SendResult;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: selfupdate_skip_fql_download */
public class InboxRecentItemsAdapter extends Adapter<RecentItemViewHolder> implements InboxAdapter {
    private final LayoutInflater f2908a;
    public ImmutableList<? extends InboxRecentItem> f2909b;
    @Nullable
    public InboxRecentItemsListener f2910c;
    private final InboxRecentItemsListener f2911d = new C04801(this);

    /* compiled from: selfupdate_skip_fql_download */
    class C04801 implements InboxRecentItemsListener {
        final /* synthetic */ InboxRecentItemsAdapter f2907a;

        C04801(InboxRecentItemsAdapter inboxRecentItemsAdapter) {
            this.f2907a = inboxRecentItemsAdapter;
        }

        public final void mo89a(InboxRecentItem inboxRecentItem) {
            if (this.f2907a.f2910c != null) {
                this.f2907a.f2910c.mo89a(inboxRecentItem);
            }
        }

        public final void mo90a(InboxRecentItem inboxRecentItem, User user, FutureCallback<SendResult> futureCallback) {
            if (this.f2907a.f2910c != null) {
                this.f2907a.f2910c.mo90a(inboxRecentItem, user, (FutureCallback) futureCallback);
            }
        }

        public final boolean mo92b(InboxRecentItem inboxRecentItem) {
            if (this.f2907a.f2910c != null) {
                return this.f2907a.f2910c.mo92b(inboxRecentItem);
            }
            return false;
        }

        public final void mo91a(InboxRecentItem inboxRecentItem, String str, @Nullable Map<String, String> map) {
            if (this.f2907a.f2910c != null) {
                this.f2907a.f2910c.mo91a(inboxRecentItem, str, (Map) map);
            }
        }
    }

    /* compiled from: selfupdate_skip_fql_download */
    class RecentItemViewHolder extends ViewHolder {
        public RecentItemViewHolder(View view) {
            super(view);
        }
    }

    public final void m2879a(ViewHolder viewHolder, int i) {
        ((InboxRecentItemView) ((RecentItemViewHolder) viewHolder).a).setItem((InboxRecentItem) this.f2909b.get(i));
    }

    @Inject
    public InboxRecentItemsAdapter(Context context) {
        this.f2908a = LayoutInflater.from(context);
        a(true);
    }

    public final ViewHolder m2878a(ViewGroup viewGroup, int i) {
        InboxRecentItemView inboxRecentItemView = (InboxRecentItemView) this.f2908a.inflate(2130904875, viewGroup, false);
        inboxRecentItemView.f2905h = this.f2911d;
        return new RecentItemViewHolder(inboxRecentItemView);
    }

    public final int aZ_() {
        return this.f2909b == null ? 0 : this.f2909b.size();
    }

    public final int m2880b() {
        return aZ_();
    }

    public final InboxItem m2881b(int i) {
        return (InboxItem) this.f2909b.get(i);
    }

    public final long H_(int i) {
        return ((InboxRecentItem) this.f2909b.get(i)).c();
    }
}
