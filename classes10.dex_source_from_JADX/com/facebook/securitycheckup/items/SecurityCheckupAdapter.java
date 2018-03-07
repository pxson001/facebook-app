package com.facebook.securitycheckup.items;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.inject.Assisted;
import com.facebook.inject.InjectorLike;
import com.facebook.securitycheckup.SecurityCheckupLogger;
import com.facebook.securitycheckup.SecurityCheckupScrollingController.SecurityCheckupItemStateChangeListener;
import com.facebook.securitycheckup.items.SecurityCheckupItem.ItemType;
import com.facebook.securitycheckup.utils.HelpPageUtil;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: image_element_end */
public class SecurityCheckupAdapter extends Adapter<SecurityCheckupViewHolder> {
    private ImmutableList<SecurityCheckupItem> f9791a;
    public SecurityCheckupItemStateChangeListener f9792b;
    public SparseArray<SecurityCheckupViewHolder> f9793c = new SparseArray();
    public int f9794d = -1;
    private SecurityCheckupExpandableViewHolderProvider f9795e;
    private SecurityCheckupConclusionViewHolderProvider f9796f;

    public final ViewHolder m10014a(ViewGroup viewGroup, int i) {
        boolean z = i == 0 || i == 1;
        Preconditions.checkArgument(z);
        if (i == 1) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130907026, viewGroup, false);
            InjectorLike injectorLike = this.f9796f;
            ViewHolder securityCheckupConclusionViewHolder = new SecurityCheckupConclusionViewHolder(inflate, viewGroup.getContext(), HelpPageUtil.m10066b(injectorLike), SecurityCheckupLogger.m9901a(injectorLike));
            inflate.setTag(securityCheckupConclusionViewHolder);
            return securityCheckupConclusionViewHolder;
        }
        inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130907027, viewGroup, false);
        securityCheckupConclusionViewHolder = this.f9795e.m10034a(inflate, viewGroup.getContext());
        inflate.setTag(securityCheckupConclusionViewHolder);
        return securityCheckupConclusionViewHolder;
    }

    public final void m10015a(ViewHolder viewHolder, int i) {
        SecurityCheckupViewHolder securityCheckupViewHolder = (SecurityCheckupViewHolder) viewHolder;
        SecurityCheckupItem securityCheckupItem = (SecurityCheckupItem) this.f9791a.get(i);
        if (securityCheckupViewHolder.f9802n != -1) {
            this.f9793c.remove(securityCheckupViewHolder.f9802n);
        }
        this.f9793c.put(i, securityCheckupViewHolder);
        securityCheckupViewHolder.mo452a(securityCheckupItem, i);
        if (this.f9794d != -1 && (i == this.f9794d - 1 || i == this.f9794d + 1)) {
            m10016e(this.f9794d);
        }
        if (securityCheckupItem.f9845d != ItemType.CONCLUSION && this.f9792b != null) {
            ((SecurityCheckupExpandableViewHolder) securityCheckupViewHolder).f9839x = this.f9792b;
        }
    }

    @Inject
    public SecurityCheckupAdapter(@Assisted List<SecurityCheckupItem> list, SecurityCheckupExpandableViewHolderProvider securityCheckupExpandableViewHolderProvider, SecurityCheckupConclusionViewHolderProvider securityCheckupConclusionViewHolderProvider) {
        this.f9791a = ImmutableList.copyOf(list);
        this.f9795e = securityCheckupExpandableViewHolderProvider;
        this.f9796f = securityCheckupConclusionViewHolderProvider;
    }

    public final int aZ_() {
        return this.f9791a.size();
    }

    public int getItemViewType(int i) {
        return ((SecurityCheckupItem) this.f9791a.get(i)).f9845d == ItemType.CONCLUSION ? 1 : 0;
    }

    public final void m10016e(int i) {
        SecurityCheckupViewHolder securityCheckupViewHolder;
        this.f9794d = i;
        if (this.f9793c.indexOfKey(i - 1) >= 0) {
            securityCheckupViewHolder = (SecurityCheckupViewHolder) this.f9793c.get(i - 1);
            if (securityCheckupViewHolder instanceof SecurityCheckupExpandableViewHolder) {
                ((SecurityCheckupExpandableViewHolder) securityCheckupViewHolder).m10030c(0);
            }
        }
        if (this.f9793c.indexOfKey(i + 1) >= 0) {
            securityCheckupViewHolder = (SecurityCheckupViewHolder) this.f9793c.get(i + 1);
            if (securityCheckupViewHolder instanceof SecurityCheckupExpandableViewHolder) {
                ((SecurityCheckupExpandableViewHolder) securityCheckupViewHolder).m10030c(0);
            }
        }
    }
}
