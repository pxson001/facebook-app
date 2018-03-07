package com.facebook.reaction.ui.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.facebook.common.dispose.Disposable;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.inject.Assisted;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.feed.showmore.ReactionShowMoreComponentsFeedAdapterFactory;
import com.facebook.reaction.feed.showmore.ReactionShowMoreComponentsFeedListType;
import com.facebook.reaction.ui.datafetcher.ReactionShowMoreComponentsDataFetcher;
import com.facebook.reaction.ui.datafetcher.ReactionShowMoreComponentsDataFetcherProvider;
import com.facebook.reaction.ui.datafetcher.ReactionShowMoreDataFetcher.FetcherListener;
import javax.inject.Inject;

/* compiled from: Unexpected type */
public class ReactionShowMoreComponentsRecyclerViewAdapter extends Adapter<ReactionFeedRowViewHolder> implements Disposable, FetcherListener {
    private final ReactionShowMoreComponentsFeedAdapterFactory f21193a;
    private final ReactionShowMoreComponentsDataFetcher f21194b;
    private MultiRowAdapter f21195c;
    private boolean f21196d;

    /* compiled from: Unexpected type */
    class C22561 implements Runnable {
        final /* synthetic */ ReactionShowMoreComponentsRecyclerViewAdapter f21192a;

        C22561(ReactionShowMoreComponentsRecyclerViewAdapter reactionShowMoreComponentsRecyclerViewAdapter) {
            this.f21192a = reactionShowMoreComponentsRecyclerViewAdapter;
        }

        public void run() {
            this.f21192a.mo1126d();
        }
    }

    public final void m24814a(ViewHolder viewHolder, int i) {
        ReactionFeedRowViewHolder reactionFeedRowViewHolder = (ReactionFeedRowViewHolder) viewHolder;
        this.f21195c.a(i, this.f21195c.getItem(i), reactionFeedRowViewHolder.a, getItemViewType(i), reactionFeedRowViewHolder.f21173l);
    }

    @Inject
    public ReactionShowMoreComponentsRecyclerViewAdapter(@Assisted Context context, @Assisted ReactionCardContainer reactionCardContainer, @Assisted String str, @Assisted ReactionSession reactionSession, @Assisted String str2, @Assisted String str3, @Assisted String str4, @Assisted Delegate delegate, ReactionShowMoreComponentsFeedAdapterFactory reactionShowMoreComponentsFeedAdapterFactory, ReactionShowMoreComponentsDataFetcherProvider reactionShowMoreComponentsDataFetcherProvider) {
        this.f21194b = reactionShowMoreComponentsDataFetcherProvider.m24731a(str, this, reactionSession, str2, str3, str4);
        this.f21193a = reactionShowMoreComponentsFeedAdapterFactory;
        this.f21195c = this.f21193a.m23445a(context, ReactionShowMoreComponentsFeedListType.m23446b(), null, this.f21194b.m24728a(), new C22561(this), reactionCardContainer, reactionSession, delegate);
    }

    public final void mo1126d() {
        this.f21195c.notifyDataSetChanged();
        notifyDataSetChanged();
    }

    public final int aZ_() {
        return this.f21195c.getCount();
    }

    public int getItemViewType(int i) {
        return this.f21195c.getItemViewType(i);
    }

    public final ViewHolder m24813a(ViewGroup viewGroup, int i) {
        return new ReactionFeedRowViewHolder(viewGroup, this.f21195c.a(i, viewGroup));
    }

    public final void jc_() {
        if (this.f21195c != null) {
            this.f21195c.jc_();
        }
        this.f21196d = true;
    }

    public final boolean ba_() {
        return this.f21196d;
    }

    public final void m24816e() {
        this.f21194b.m24721b();
    }
}
