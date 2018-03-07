package com.facebook.events.ui.themeselector;

import android.net.Uri;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.controller.connectioncontroller.adapters.RecyclerViewConnectionAdapter;
import com.facebook.controller.connectioncontroller.common.ConnectionState;
import com.facebook.controller.connectioncontroller.common.EmptyConnectionState;
import com.facebook.events.ui.themeselector.protocol.EventsThemeSelectorGraphQLModels.EventsThemeSuggestionsModel.EventThemesModel.NodesModel;

/* compiled from: app_invite_promotion_parsing_failed */
public class ThemeSelectionRecyclerViewAdapter extends Adapter<ViewHolder> implements RecyclerViewConnectionAdapter<NodesModel> {
    public ConnectionState<NodesModel> f19579a = EmptyConnectionState.a;
    public int f19580b;
    private boolean f19581c;

    public final ViewHolder m19778a(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i == 0) {
            return new ThemeViewHolder(from.inflate(this.f19580b == 1 ? 2130904171 : 2130904172, viewGroup, false));
        } else if (i == 1) {
            return new ThemeLoaderViewHolder(from.inflate(2130904173, viewGroup, false));
        } else {
            return null;
        }
    }

    public final void m19779a(ViewHolder viewHolder, int i) {
        switch (getItemViewType(i)) {
            case 0:
                NodesModel nodesModel;
                ThemeViewHolder themeViewHolder = (ThemeViewHolder) viewHolder;
                if (i < this.f19579a.d()) {
                    nodesModel = (NodesModel) this.f19579a.a(i);
                } else {
                    nodesModel = null;
                }
                NodesModel nodesModel2 = nodesModel;
                if (nodesModel2 != null && nodesModel2.m19855l() != null && nodesModel2.m19855l().m19836a() != null && nodesModel2.m19853j() != null && nodesModel2.m19853j().m19829a() != null) {
                    String k = nodesModel2.m19854k();
                    String a = nodesModel2.m19855l().m19836a();
                    String a2 = nodesModel2.m19853j().m19829a();
                    themeViewHolder.f19599m = k;
                    themeViewHolder.f19600n = a2;
                    themeViewHolder.f19598l.a(Uri.parse(a), ThemeViewHolder.f19597p);
                    themeViewHolder.f19598l.setOnClickListener(themeViewHolder.f19601o);
                    return;
                }
                return;
            case 1:
                ((ThemeLoaderViewHolder) viewHolder).f19578l.setVisibility(this.f19581c ? 0 : 8);
                return;
            default:
                return;
        }
    }

    public final int aZ_() {
        return (this.f19581c ? 1 : 0) + this.f19579a.d();
    }

    public int getItemViewType(int i) {
        if (i < this.f19579a.d()) {
            return 0;
        }
        return 1;
    }

    public final void m19780a(ConnectionState<NodesModel> connectionState) {
        this.f19579a = connectionState;
    }

    public final void b_(int i, int i2) {
        c(i, i2);
    }

    public final void m19781b(boolean z) {
        if (this.f19581c != z) {
            this.f19581c = z;
            if (z) {
                k_(this.f19579a.d());
            } else {
                l_(this.f19579a.d());
            }
        }
    }
}
