package com.facebook.widget.bottomsheet;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.menu.BottomSheetMenu;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;

/* compiled from: densityDpi */
public class BottomSheetAdapter extends BottomSheetMenu {
    public boolean f15838c = false;
    public boolean f15839d = false;
    public boolean f15840e = false;
    public String f15841f;
    public boolean f15842g = true;

    /* compiled from: densityDpi */
    public class CondensedItemViewHolder extends ViewHolder {
        GlyphView f15834l;
        public FbTextView f15835m;

        public CondensedItemViewHolder(View view) {
            super(view);
            this.f15834l = (GlyphView) view.findViewById(2131559975);
            this.f15835m = (FbTextView) view.findViewById(2131559976);
        }
    }

    /* compiled from: densityDpi */
    public class ItemViewHolder extends CondensedItemViewHolder {
        FbTextView f15836n;

        public ItemViewHolder(View view) {
            super(view);
            this.f15836n = (FbTextView) view.findViewById(2131559977);
        }
    }

    /* compiled from: densityDpi */
    public class TitleViewHolder extends ViewHolder {
        public FbTextView f15837l;

        public TitleViewHolder(View view) {
            super(view);
            this.f15837l = (FbTextView) view.findViewById(2131559978);
        }
    }

    public BottomSheetAdapter(Context context) {
        super(context);
    }

    public ViewHolder mo1207a(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(this.c);
        if (i == 0) {
            return new ItemViewHolder(from.inflate(2130903430, viewGroup, false));
        }
        if (i == 1) {
            return new CondensedItemViewHolder(from.inflate(2130903428, viewGroup, false));
        }
        if (i == 2) {
            return new TitleViewHolder(from.inflate(2130903431, viewGroup, false));
        }
        throw new IllegalArgumentException("Invalid view type for creating view holder.");
    }

    public int getItemViewType(int i) {
        if (this.f15839d && i == 0) {
            return 2;
        }
        return this.f15838c ? 1 : 0;
    }

    public void mo1208a(ViewHolder viewHolder, int i) {
        int i2 = 1;
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            if (!this.f15839d) {
                i2 = 0;
            }
            mo1209a((ItemViewHolder) viewHolder, (MenuItemImpl) getItem(i - i2));
        } else if (itemViewType == 1) {
            if (!this.f15839d) {
                i2 = 0;
            }
            m19803a((CondensedItemViewHolder) viewHolder, (MenuItemImpl) getItem(i - i2));
        } else if (itemViewType == 2) {
            ((TitleViewHolder) viewHolder).f15837l.setText(this.f15841f);
        } else {
            throw new IllegalArgumentException("Invalid view type for binding view holder.");
        }
    }

    private void m19803a(CondensedItemViewHolder condensedItemViewHolder, final MenuItemImpl menuItemImpl) {
        if (this.f15842g) {
            condensedItemViewHolder.f15834l.setVisibility(0);
            if (this.f15840e) {
                condensedItemViewHolder.f15834l.setGlyphColor(null);
            }
            if (menuItemImpl.getIcon() != null) {
                condensedItemViewHolder.f15834l.setImageDrawable(menuItemImpl.getIcon());
            }
        } else {
            condensedItemViewHolder.f15834l.setVisibility(8);
        }
        if (!TextUtils.isEmpty(menuItemImpl.getTitle())) {
            condensedItemViewHolder.f15835m.setText(menuItemImpl.getTitle());
        }
        condensedItemViewHolder.a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BottomSheetAdapter f15833b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1763209043);
                this.f15833b.a(menuItemImpl);
                Logger.a(2, EntryType.UI_INPUT_END, 123394131, a);
            }
        });
    }

    protected void mo1209a(ItemViewHolder itemViewHolder, MenuItemImpl menuItemImpl) {
        m19803a((CondensedItemViewHolder) itemViewHolder, menuItemImpl);
        if (TextUtils.isEmpty(menuItemImpl.d)) {
            itemViewHolder.f15836n.setVisibility(8);
            return;
        }
        itemViewHolder.f15836n.setVisibility(0);
        itemViewHolder.f15836n.setText(menuItemImpl.d);
    }

    public int aZ_() {
        return (this.f15839d ? 1 : 0) + e();
    }
}
