package com.facebook.pages.common.photos;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.util.FindViewUtil;
import com.facebook.photos.pandora.common.ui.feedadapter.PandoraBasicFeedAdapter;
import com.facebook.reaction.ui.recyclerview.ReactionMixedRecyclerViewAdapter;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;

/* compiled from: setup_profile/ */
public class PageMixedReactionPandoraAdapter extends Adapter<ViewHolder> {
    public static final ImmutableSet<Integer> f1682a = ImmutableSet.of(Integer.valueOf(com.facebook.photos.pandora.common.ui.feedadapter.PandoraBasicFeedAdapter.ViewType.a), Integer.valueOf(com.facebook.photos.pandora.common.ui.feedadapter.PandoraBasicFeedAdapter.ViewType.b), Integer.valueOf(com.facebook.photos.pandora.common.ui.feedadapter.PandoraBasicFeedAdapter.ViewType.c), Integer.valueOf(com.facebook.photos.pandora.common.ui.feedadapter.PandoraBasicFeedAdapter.ViewType.d), Integer.valueOf(com.facebook.photos.pandora.common.ui.feedadapter.PandoraBasicFeedAdapter.ViewType.e), Integer.valueOf(com.facebook.photos.pandora.common.ui.feedadapter.PandoraBasicFeedAdapter.ViewType.f), new Integer[]{Integer.valueOf(com.facebook.photos.pandora.common.ui.feedadapter.PandoraBasicFeedAdapter.ViewType.g), Integer.valueOf(com.facebook.photos.pandora.common.ui.feedadapter.PandoraBasicFeedAdapter.ViewType.h)});
    private RecyclerView f1683b;
    private LayoutInflater f1684c;
    private final ReactionMixedRecyclerViewAdapter f1685d;
    public final PandoraBasicFeedAdapter f1686e;
    private final View f1687f;

    /* compiled from: setup_profile/ */
    public class PandoraHeaderViewHolder extends ViewHolder {
        public BetterTextView f1679l;

        public PandoraHeaderViewHolder(View view) {
            super(view);
            this.f1679l = (BetterTextView) FindViewUtil.b(view, 2131565633);
            this.f1679l.setText(view.getContext().getResources().getString(2131234397));
        }
    }

    /* compiled from: setup_profile/ */
    public class PandoraRowSimpleViewHolder extends ViewHolder {
        public PandoraRowSimpleViewHolder(View view) {
            super(view);
        }
    }

    /* compiled from: setup_profile/ */
    public class SimpleViewHolder extends ViewHolder {
        public SimpleViewHolder(View view) {
            super(view);
        }
    }

    /* compiled from: setup_profile/ */
    public class ViewType {
        @IdRes
        public static final int f1680a = 2131558808;
        @IdRes
        public static final int f1681b = 2131558811;
    }

    public PageMixedReactionPandoraAdapter(RecyclerView recyclerView, ReactionMixedRecyclerViewAdapter reactionMixedRecyclerViewAdapter, PandoraBasicFeedAdapter pandoraBasicFeedAdapter, View view) {
        Preconditions.checkNotNull(recyclerView);
        Preconditions.checkNotNull(reactionMixedRecyclerViewAdapter);
        Preconditions.checkNotNull(pandoraBasicFeedAdapter);
        this.f1683b = recyclerView;
        this.f1684c = LayoutInflater.from(recyclerView.getContext());
        this.f1685d = reactionMixedRecyclerViewAdapter;
        this.f1686e = pandoraBasicFeedAdapter;
        this.f1687f = view;
    }

    public final int aZ_() {
        return ((this.f1685d.aZ_() + m2492e()) + this.f1686e.getCount()) + 1;
    }

    public int getItemViewType(int i) {
        if (i < m2493f()) {
            return this.f1685d.getItemViewType(i);
        }
        if (i < m2494g()) {
            return ViewType.f1680a;
        }
        if (i >= m2495h()) {
            return ViewType.f1681b;
        }
        return this.f1686e.b(i - m2494g());
    }

    public final ViewHolder m2496a(ViewGroup viewGroup, int i) {
        if (i == ViewType.f1680a) {
            return new PandoraHeaderViewHolder(this.f1684c.inflate(2130906071, viewGroup, false));
        }
        if (i == ViewType.f1681b) {
            return new SimpleViewHolder(this.f1687f);
        }
        if (f1682a.contains(Integer.valueOf(i))) {
            return new PandoraRowSimpleViewHolder(this.f1686e.a(viewGroup, i));
        }
        return this.f1685d.a(viewGroup, i);
    }

    public final void m2498a(ViewHolder viewHolder, int i) {
        if (i < m2493f()) {
            this.f1685d.a(viewHolder, i);
        } else if (i >= m2494g() && i < m2495h()) {
            this.f1686e.getView(i - m2494g(), viewHolder.a, this.f1683b);
        }
    }

    public final void m2497a(AdapterDataObserver adapterDataObserver) {
        super.a(adapterDataObserver);
        this.f1685d.a(adapterDataObserver);
    }

    public final void m2499b(AdapterDataObserver adapterDataObserver) {
        super.b(adapterDataObserver);
        this.f1685d.b(adapterDataObserver);
    }

    private int m2492e() {
        return this.f1686e.getCount() == 0 ? 0 : 1;
    }

    private int m2493f() {
        return this.f1685d.aZ_();
    }

    private int m2494g() {
        return m2493f() + m2492e();
    }

    private int m2495h() {
        return m2494g() + this.f1686e.getCount();
    }
}
