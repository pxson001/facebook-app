package com.facebook.messaging.peopleyoumaymessage;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.inbox2.items.InboxAdapter;
import com.facebook.messaging.inbox2.items.InboxItem;
import com.facebook.orca.threadlist.ThreadListAdapter.AnonymousClass12;
import com.facebook.orca.threadlist.ThreadListFragment.AnonymousClass18;
import com.facebook.orca.threadlist.ThreadListFragment.ThreadListItemClickListener;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: renderTimelineContextItemView */
public class PeopleYouMayMessageAdapter extends Adapter<PeopleYouMayMessageItemViewHolder> implements InboxAdapter {
    private final LayoutInflater f3468a;
    public PeopleYouMayMessageViewData f3469b;
    public ImmutableList<PersonYouMayMessage> f3470c;
    public AnonymousClass12 f3471d;
    private final OnClickListener f3472e = new C05511(this);
    private final OnLongClickListener f3473f = new C05522(this);

    /* compiled from: renderTimelineContextItemView */
    class C05511 implements OnClickListener {
        final /* synthetic */ PeopleYouMayMessageAdapter f3466a;

        C05511(PeopleYouMayMessageAdapter peopleYouMayMessageAdapter) {
            this.f3466a = peopleYouMayMessageAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1774240802);
            PeopleYouMayMessageAdapter peopleYouMayMessageAdapter = this.f3466a;
            PersonYouMayMessage personYouMayMessage = (PersonYouMayMessage) view.getTag();
            if (!(personYouMayMessage == null || peopleYouMayMessageAdapter.f3471d == null)) {
                AnonymousClass12 anonymousClass12 = peopleYouMayMessageAdapter.f3471d;
                if (anonymousClass12.f6546b.f6573j != null) {
                    AnonymousClass18 anonymousClass18 = anonymousClass12.f6546b.f6573j;
                    anonymousClass18.f6606a.bB.m2624a(personYouMayMessage.f3503c, anonymousClass12.f6545a);
                    ThreadListItemClickListener threadListItemClickListener = anonymousClass18.f6606a.cI;
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1708095231, a);
        }
    }

    /* compiled from: renderTimelineContextItemView */
    class C05522 implements OnLongClickListener {
        final /* synthetic */ PeopleYouMayMessageAdapter f3467a;

        C05522(PeopleYouMayMessageAdapter peopleYouMayMessageAdapter) {
            this.f3467a = peopleYouMayMessageAdapter;
        }

        public boolean onLongClick(View view) {
            boolean z;
            PeopleYouMayMessageAdapter peopleYouMayMessageAdapter = this.f3467a;
            PersonYouMayMessage personYouMayMessage = (PersonYouMayMessage) view.getTag();
            if (personYouMayMessage == null || peopleYouMayMessageAdapter.f3471d == null) {
                z = false;
            } else {
                boolean z2;
                AnonymousClass12 anonymousClass12 = peopleYouMayMessageAdapter.f3471d;
                if (anonymousClass12.f6546b.f6573j != null) {
                    AnonymousClass18 anonymousClass18 = anonymousClass12.f6546b.f6573j;
                    PeopleYouMayMessageLogger peopleYouMayMessageLogger = anonymousClass18.f6606a.bp;
                    HoneyClientEvent honeyClientEvent = new HoneyClientEvent("pymm_long_click");
                    honeyClientEvent.c = "people_you_may_message";
                    peopleYouMayMessageLogger.f3487b.a(honeyClientEvent.b("id", personYouMayMessage.f3501a.a).b("type", "top"));
                    anonymousClass18.f6606a.m6344b(personYouMayMessage.f3503c);
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = z2;
            }
            return z;
        }
    }

    public final void m3355a(ViewHolder viewHolder, int i) {
        PeopleYouMayMessageItemView peopleYouMayMessageItemView = (PeopleYouMayMessageItemView) ((PeopleYouMayMessageItemViewHolder) viewHolder).a;
        PersonYouMayMessage personYouMayMessage = (PersonYouMayMessage) this.f3470c.get(i);
        peopleYouMayMessageItemView.m3365a(personYouMayMessage);
        peopleYouMayMessageItemView.m3366a(this.f3469b.f3498b);
        peopleYouMayMessageItemView.setTag(personYouMayMessage);
    }

    @Inject
    public PeopleYouMayMessageAdapter(LayoutInflater layoutInflater) {
        this.f3468a = layoutInflater;
        a(true);
    }

    public final ViewHolder m3354a(ViewGroup viewGroup, int i) {
        View inflate = this.f3468a.inflate(2130906168, viewGroup, false);
        inflate.setOnClickListener(this.f3472e);
        inflate.setOnLongClickListener(this.f3473f);
        return new PeopleYouMayMessageItemViewHolder(inflate);
    }

    public final int aZ_() {
        return this.f3470c.size();
    }

    public final int m3356b() {
        return this.f3470c.size();
    }

    public final InboxItem m3357b(int i) {
        return ((PersonYouMayMessage) this.f3470c.get(i)).f3503c;
    }

    public final long H_(int i) {
        return m3357b(i).c();
    }
}
