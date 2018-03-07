package com.facebook.greetingcards.verve.render;

import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.greetingcards.verve.model.VMSlide;
import com.facebook.greetingcards.verve.model.VMView;
import com.facebook.greetingcards.verve.model.VMViewType;
import com.facebook.greetingcards.verve.mutablemodel.DeckInfo;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: viewed_coupon */
public class FlatVerveAdapter extends Adapter<FlatVerveSlideViewHolder> {
    public final DeckInfo f381a;
    private final ImmutableList<Integer> f382b;
    public final SparseArrayCompat<View> f383c = new SparseArrayCompat();

    /* compiled from: viewed_coupon */
    public class FlatVerveSlideViewHolder extends ViewHolder {
        public final /* synthetic */ FlatVerveAdapter f380l;

        public FlatVerveSlideViewHolder(FlatVerveAdapter flatVerveAdapter, View view) {
            this.f380l = flatVerveAdapter;
            super(view);
        }
    }

    public final void m356a(ViewHolder viewHolder, int i) {
        FlatVerveSlideViewHolder flatVerveSlideViewHolder = (FlatVerveSlideViewHolder) viewHolder;
        int intValue = ((Integer) this.f382b.get(i)).intValue();
        DeckInfo deckInfo = this.f381a;
        ViewGroup viewGroup = (ViewGroup) flatVerveSlideViewHolder.a;
        VerveViewFactory.m408a(deckInfo, viewGroup);
        flatVerveSlideViewHolder.f380l.f383c.b();
        ImmutableList b = deckInfo.m318b(intValue);
        VerveViewFactory.m409a(b, intValue, deckInfo, viewGroup.getContext(), flatVerveSlideViewHolder.f380l.f383c);
        int size = b.size();
        for (int i2 = 0; i2 < size; i2++) {
            VMView vMView = (VMView) b.get(i2);
            View view = (View) flatVerveSlideViewHolder.f380l.f383c.a(vMView.f340a);
            viewGroup.addView(view);
            if (vMView.m308o() == VMViewType.GROUP) {
                ((VerveGroupView) view).f417a.m377a();
            }
        }
        flatVerveSlideViewHolder.a.setLayoutParams(new LayoutParams(-1, (int) (((VMSlide) deckInfo.f346a.slides.get(intValue)).m276c() * deckInfo.f351f)));
    }

    public FlatVerveAdapter(DeckInfo deckInfo) {
        this.f381a = deckInfo;
        Builder builder = new Builder();
        for (int i = 0; i < this.f381a.f346a.slides.size(); i++) {
            if (!((VMSlide) this.f381a.f346a.slides.get(i)).master) {
                builder.c(Integer.valueOf(i));
            }
        }
        this.f382b = builder.b();
    }

    public final ViewHolder m355a(ViewGroup viewGroup, int i) {
        return new FlatVerveSlideViewHolder(this, new FrameLayout(viewGroup.getContext()));
    }

    public final int aZ_() {
        return this.f382b.size();
    }
}
