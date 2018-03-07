package com.facebook.widget.bottomsheet;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.widget.bottomsheet.BottomSheetAdapter.ItemViewHolder;

/* compiled from: delta_batch_size */
public class DescriptiveBottomSheetAdapter extends BottomSheetAdapter {

    /* compiled from: delta_batch_size */
    public enum ViewType {
        VIEW_TYPE_REGULAR_ITEM,
        VIEW_TYPE_DESCRIPTION_ONLY_ITEM,
        VIEW_TYPE_BOTTOM_PADDING,
        VIEW_TYPE_UNKNOWN
    }

    public DescriptiveBottomSheetAdapter(Context context) {
        super(context);
    }

    public final ViewHolder mo1207a(ViewGroup viewGroup, int i) {
        Context context = this.c;
        LayoutInflater from = LayoutInflater.from(context);
        View view = null;
        if (i == ViewType.VIEW_TYPE_REGULAR_ITEM.ordinal()) {
            view = from.inflate(2130903430, viewGroup, false);
            LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = context.getResources().getDimensionPixelSize(2131429137);
            view.setLayoutParams(layoutParams);
        } else if (i == ViewType.VIEW_TYPE_DESCRIPTION_ONLY_ITEM.ordinal()) {
            view = from.inflate(2130903429, viewGroup, false);
        } else if (i == ViewType.VIEW_TYPE_BOTTOM_PADDING.ordinal()) {
            view = new View(context);
            view.setLayoutParams(new LayoutParams(-1, context.getResources().getDimensionPixelSize(2131429139)));
        }
        if (view != null) {
            return new ItemViewHolder(view);
        }
        throw new IllegalArgumentException("Invalid view type for creating view holder.");
    }

    public int getItemViewType(int i) {
        return m19818f(i).ordinal();
    }

    private ViewType m19818f(int i) {
        if (i == aZ_()) {
            return ViewType.VIEW_TYPE_BOTTOM_PADDING;
        }
        if (TextUtils.isEmpty(((MenuItemImpl) getItem(i)).getTitle())) {
            return ViewType.VIEW_TYPE_DESCRIPTION_ONLY_ITEM;
        }
        return ViewType.VIEW_TYPE_REGULAR_ITEM;
    }

    public final int aZ_() {
        return super.aZ_() + 1;
    }

    public final void mo1208a(ViewHolder viewHolder, int i) {
        if (i != aZ_()) {
            if (m19818f(i) == ViewType.VIEW_TYPE_UNKNOWN) {
                throw new IllegalArgumentException("Invalid view type for binding view holder.");
            }
            mo1209a((ItemViewHolder) viewHolder, (MenuItemImpl) getItem(i));
        }
    }

    protected final void mo1209a(ItemViewHolder itemViewHolder, MenuItemImpl menuItemImpl) {
        if (TextUtils.isEmpty(menuItemImpl.getTitle())) {
            itemViewHolder.f15836n.setVisibility(0);
            if (!TextUtils.isEmpty(menuItemImpl.d)) {
                itemViewHolder.f15836n.setText(menuItemImpl.d);
                return;
            }
            return;
        }
        super.mo1209a(itemViewHolder, menuItemImpl);
    }
}
