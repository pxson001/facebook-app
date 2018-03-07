package com.facebook.events.create.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.events.create.EventCreationNikumanActivity.C22502;
import com.facebook.events.create.ui.ThemeSuggestifierOptionViewHolder.OnOptionSelectedListener;
import com.facebook.events.ui.themeselector.protocol.EventsThemeSelectorGraphQLModels.EventsThemeSuggestionsModel.EventThemesModel.NodesModel;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: composer_icon */
public class ThemeSuggestifierAdapter extends Adapter<ViewHolder> {
    private final int f16415a = 2;
    private Resources f16416b;
    private GlyphColorizer f16417c;
    @Nullable
    private Drawable f16418d;
    private Drawable f16419e;
    private ImmutableList<NodesModel> f16420f = RegularImmutableList.a;
    public C22502 f16421g;
    public OnOptionSelectedListener f16422h;

    public ThemeSuggestifierAdapter(Context context, @Nullable Drawable drawable, Drawable drawable2) {
        this.f16416b = context.getResources();
        this.f16417c = new GlyphColorizer(this.f16416b);
        this.f16418d = drawable;
        this.f16419e = drawable2;
    }

    public final ViewHolder m16871a(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i == 0) {
            return new ThemeSuggestionViewHolder(from.inflate(2130907318, viewGroup, false));
        }
        return new ThemeSuggestifierOptionViewHolder(from.inflate(2130903815, viewGroup, false));
    }

    public final void m16872a(ViewHolder viewHolder, int i) {
        switch (viewHolder.e) {
            case 0:
                m16869a((ThemeSuggestionViewHolder) viewHolder, i);
                return;
            case 1:
                m16868a((ThemeSuggestifierOptionViewHolder) viewHolder, this.f16416b.getString(2131236917), this.f16419e, this.f16417c.a(2130840019, -1), 1);
                return;
            case 2:
                m16868a((ThemeSuggestifierOptionViewHolder) viewHolder, this.f16416b.getString(2131236919), this.f16418d, this.f16417c.a(2130840021, -1), 2);
                return;
            default:
                return;
        }
    }

    public int getItemViewType(int i) {
        if (i < this.f16420f.size()) {
            return 0;
        }
        if (i == this.f16420f.size()) {
            return 1;
        }
        return 2;
    }

    public final int aZ_() {
        return this.f16420f.size() + 2;
    }

    public final void m16873a(OnOptionSelectedListener onOptionSelectedListener) {
        this.f16422h = onOptionSelectedListener;
    }

    public final void m16874a(ImmutableList<NodesModel> immutableList) {
        this.f16420f = immutableList;
        notifyDataSetChanged();
    }

    private void m16869a(ThemeSuggestionViewHolder themeSuggestionViewHolder, int i) {
        NodesModel e = m16870e(i);
        if (e == null || e.m19855l() == null || e.m19855l().m19836a() == null || e.m19853j() == null || e.m19853j().m19829a() == null) {
            themeSuggestionViewHolder.a.setVisibility(8);
        } else {
            themeSuggestionViewHolder.m16878a(e.m19854k(), e.m19855l().m19836a(), e.m19853j().m19829a(), this.f16421g, i == 0);
        }
    }

    private void m16868a(ThemeSuggestifierOptionViewHolder themeSuggestifierOptionViewHolder, String str, @Nullable Drawable drawable, Drawable drawable2, int i) {
        themeSuggestifierOptionViewHolder.m16877a(str, drawable, drawable2, this.f16422h, i);
    }

    @Nullable
    private NodesModel m16870e(int i) {
        if (i < this.f16420f.size()) {
            return (NodesModel) this.f16420f.get(i);
        }
        return null;
    }
}
