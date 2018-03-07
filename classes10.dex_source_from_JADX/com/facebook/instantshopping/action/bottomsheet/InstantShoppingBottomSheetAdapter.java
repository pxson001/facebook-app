package com.facebook.instantshopping.action.bottomsheet;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.widget.bottomsheet.BottomSheetAdapter;
import com.facebook.widget.bottomsheet.BottomSheetAdapter.ItemViewHolder;

/* compiled from: Simulate a stalled main thread and come back after 10 seconds */
public class InstantShoppingBottomSheetAdapter extends BottomSheetAdapter {
    public Context f23514c;

    /* compiled from: Simulate a stalled main thread and come back after 10 seconds */
    public class DividerViewHolder extends ViewHolder {
        public DividerViewHolder(View view) {
            super(view);
        }
    }

    public InstantShoppingBottomSheetAdapter(Context context) {
        super(context);
        this.f23514c = context;
    }

    public int getItemViewType(int i) {
        if (i == 1) {
            return 1;
        }
        return super.getItemViewType(i);
    }

    public final ViewHolder m24816a(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(this.f23514c);
        if (i == 1) {
            return new DividerViewHolder(from.inflate(2130904949, viewGroup, false));
        }
        return super.a(viewGroup, i);
    }

    public final void m24817a(ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType != 1) {
            super.a(viewHolder, i);
            if (itemViewType != 1) {
                ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
                if (getItem(i).isChecked()) {
                    itemViewHolder.m.setTextColor(this.f23514c.getResources().getColor(2131363673));
                }
            }
        }
    }
}
