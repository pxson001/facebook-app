package com.facebook.securitycheckup.inner;

import android.net.Uri;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.securitycheckup.inner.SecurityCheckupInnerController.SecurityCheckupInnerItemSelectionStateListener;
import com.google.common.base.Preconditions;
import java.util.List;

/* compiled from: immersive_system_back_pressed */
public class SecurityCheckupInnerAdapter extends Adapter<SecurityCheckupInnerViewHolder> {
    public List<SecurityCheckupInnerItem> f9739a;
    public SecurityCheckupInnerItemSelectionStateListener f9740b;

    public final void m10001a(ViewHolder viewHolder, int i) {
        SecurityCheckupInnerViewHolder securityCheckupInnerViewHolder = (SecurityCheckupInnerViewHolder) viewHolder;
        SecurityCheckupInnerItem securityCheckupInnerItem = (SecurityCheckupInnerItem) this.f9739a.get(i);
        securityCheckupInnerViewHolder.f9787r = securityCheckupInnerItem;
        securityCheckupInnerViewHolder.f9789t = i;
        securityCheckupInnerViewHolder.f9781l.setText(securityCheckupInnerItem.f9777c);
        if (StringUtil.a(securityCheckupInnerViewHolder.f9787r.f9778d)) {
            securityCheckupInnerViewHolder.f9782m.setVisibility(8);
        } else {
            securityCheckupInnerViewHolder.f9782m.setText(securityCheckupInnerItem.f9778d);
            securityCheckupInnerViewHolder.f9782m.setVisibility(0);
        }
        if (securityCheckupInnerViewHolder.f9787r.f9776b.isPresent()) {
            securityCheckupInnerViewHolder.f9784o.setVisibility(0);
            securityCheckupInnerViewHolder.f9783n.setVisibility(8);
            securityCheckupInnerViewHolder.f9784o.a((Uri) securityCheckupInnerItem.f9776b.get(), CallerContext.a(SecurityCheckupInnerViewHolder.class));
        } else if (securityCheckupInnerViewHolder.f9787r.f9775a.isPresent()) {
            securityCheckupInnerViewHolder.f9784o.setVisibility(8);
            securityCheckupInnerViewHolder.f9783n.setVisibility(0);
            securityCheckupInnerViewHolder.f9783n.setImageDrawable(securityCheckupInnerViewHolder.f9788s.getResources().getDrawable(((Integer) securityCheckupInnerItem.f9775a.get()).intValue()));
        }
        securityCheckupInnerViewHolder.f9785p.setChecked(securityCheckupInnerItem.f9779e);
    }

    public SecurityCheckupInnerAdapter(List<SecurityCheckupInnerItem> list) {
        this.f9739a = list;
    }

    public final ViewHolder m10000a(ViewGroup viewGroup, int i) {
        SecurityCheckupInnerViewHolder securityCheckupInnerViewHolder = new SecurityCheckupInnerViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2130907028, viewGroup, false), viewGroup.getContext());
        if (this.f9740b != null) {
            securityCheckupInnerViewHolder.f9786q = this.f9740b;
        }
        return securityCheckupInnerViewHolder;
    }

    public final int aZ_() {
        return this.f9739a.size();
    }

    public final SecurityCheckupInnerItem m10003e(int i) {
        Preconditions.checkArgument(i < this.f9739a.size());
        return (SecurityCheckupInnerItem) this.f9739a.get(i);
    }

    public final int m10002d() {
        int i = 0;
        for (SecurityCheckupInnerItem securityCheckupInnerItem : this.f9739a) {
            int i2;
            if (securityCheckupInnerItem.f9779e) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        return i;
    }
}
