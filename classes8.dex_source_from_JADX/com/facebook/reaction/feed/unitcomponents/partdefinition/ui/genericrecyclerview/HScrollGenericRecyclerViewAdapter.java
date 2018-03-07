package com.facebook.reaction.feed.unitcomponents.partdefinition.ui.genericrecyclerview;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.inject.Lazy;
import com.facebook.multirow.api.ViewType;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: abe51b3f34d611987e311b02a59ec4b4 */
public class HScrollGenericRecyclerViewAdapter extends Adapter<HScrollGenericRecyclerViewHolder> {
    private static final String f20187a = HScrollGenericRecyclerViewAdapter.class.getSimpleName();
    private final Lazy<FbErrorReporter> f20188b;
    private List<SubComponentProps> f20189c;
    private final Map<ViewType, Integer> f20190d;

    /* compiled from: abe51b3f34d611987e311b02a59ec4b4 */
    public class HScrollGenericRecyclerViewHolder extends ViewHolder {
        public HScrollGenericRecyclerViewHolder(View view) {
            super(view);
        }
    }

    public final void m24053a(ViewHolder viewHolder, int i) {
        ((SubComponentProps) this.f20189c.get(i)).f20191a.a(((HScrollGenericRecyclerViewHolder) viewHolder).a);
    }

    public HScrollGenericRecyclerViewAdapter(Lazy<FbErrorReporter> lazy, List<SubComponentProps> list, Map<ViewType, Integer> map) {
        this.f20188b = lazy;
        this.f20189c = list;
        this.f20190d = map;
    }

    public final ViewHolder m24052a(ViewGroup viewGroup, int i) {
        for (Entry entry : this.f20190d.entrySet()) {
            if (((Integer) entry.getValue()).intValue() == i) {
                return new HScrollGenericRecyclerViewHolder(((ViewType) entry.getKey()).a(viewGroup.getContext()));
            }
        }
        ((AbstractFbErrorReporter) this.f20188b.get()).a(f20187a, "Uknown ViewType found, returning empty view");
        return new HScrollGenericRecyclerViewHolder(new View(viewGroup.getContext()));
    }

    public final int aZ_() {
        return this.f20189c.size();
    }

    public int getItemViewType(int i) {
        return ((Integer) this.f20190d.get(((SubComponentProps) this.f20189c.get(i)).f20192b)).intValue();
    }
}
