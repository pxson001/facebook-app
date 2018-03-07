package com.facebook.saved2.ui.itemadapters;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.crudolib.dao.DAOItem;
import com.facebook.crudolib.dao.recyclerview.DAOItemCursorAdapter;
import com.facebook.inject.Assisted;
import com.facebook.saved2.model.Saved2ItemTable_Queries.BaseQueryDAO;
import javax.inject.Inject;

/* compiled from: inf_hscroll_final_size */
public class Saved2DAOItemsAdapter extends DAOItemCursorAdapter<BaseQueryDAO, ViewHolder> {
    private static final int f9590b = 2130906935;
    private final FragmentActivity f9591c;
    private final String f9592d;
    private final Saved2DashboardItemViewHolderProvider f9593e;
    private final PopoverTrackingState f9594f = new PopoverTrackingState();

    @Inject
    public Saved2DAOItemsAdapter(@Assisted FragmentActivity fragmentActivity, @Assisted String str, Saved2DashboardItemViewHolderProvider saved2DashboardItemViewHolderProvider) {
        super(fragmentActivity);
        a(true);
        this.f9591c = fragmentActivity;
        this.f9592d = str;
        this.f9593e = saved2DashboardItemViewHolderProvider;
    }

    public int getItemViewType(int i) {
        return f9590b;
    }

    public final void m9845a(ViewHolder viewHolder, int i) {
        this.b.moveToPosition(i);
        ((Saved2DashboardItemViewHolder) viewHolder).m9865a((BaseQueryDAO) d());
    }

    public final ViewHolder m9844a(ViewGroup viewGroup, int i) {
        return this.f9593e.m9868a(this.f9591c, LayoutInflater.from(this.f9591c).inflate(i, viewGroup, false), this.f9592d, this.f9594f);
    }

    public final void m9847c(ViewHolder viewHolder) {
        ((Saved2DashboardItemViewHolder) viewHolder).m9866w();
    }

    public final void m9848d(ViewHolder viewHolder) {
        ((Saved2DashboardItemViewHolder) viewHolder).m9867x();
    }

    protected final void m9846a(ViewHolder viewHolder, DAOItem dAOItem) {
        throw new UnsupportedOperationException("Should convert to delegation to better avoid this method");
    }
}
