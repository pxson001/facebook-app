package com.facebook.fig.bottomsheet;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.menu.BottomSheetMenu;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;

/* compiled from: remoteAsync */
public class FigBottomSheetAdapter extends BottomSheetMenu {
    public Context f5355c;
    public boolean f5356d = false;
    public TitleType f5357e = TitleType.NONE;
    public String f5358f;
    private View f5359g;
    public float f5360h;
    public boolean f5361i = false;

    /* compiled from: remoteAsync */
    public class CondensedItemViewHolder extends ViewHolder {
        GlyphView f5351l;
        FbTextView f5352m;

        public CondensedItemViewHolder(View view) {
            super(view);
            this.f5351l = (GlyphView) view.findViewById(2131559975);
            this.f5352m = (FbTextView) view.findViewById(2131559976);
        }
    }

    /* compiled from: remoteAsync */
    public class CustomViewHolder extends ViewHolder {
        public CustomViewHolder(View view) {
            super(view);
        }
    }

    /* compiled from: remoteAsync */
    public class ItemViewHolder extends CondensedItemViewHolder {
        FbTextView f5353n;

        public ItemViewHolder(View view) {
            super(view);
            this.f5353n = (FbTextView) view.findViewById(2131559977);
        }
    }

    /* compiled from: remoteAsync */
    public class SpaceViewHolder extends ViewHolder {
        public SpaceViewHolder(View view) {
            super(view);
        }
    }

    /* compiled from: remoteAsync */
    public enum TitleType {
        NONE,
        BASIC,
        CUSTOM
    }

    /* compiled from: remoteAsync */
    public class TitleViewHolder extends ViewHolder {
        public FbTextView f5354l;

        public TitleViewHolder(View view) {
            super(view);
            this.f5354l = (FbTextView) view.findViewById(2131559978);
        }
    }

    public FigBottomSheetAdapter(Context context) {
        super(context);
        this.f5355c = context;
    }

    public final void m5791a(View view, float f) {
        if (this.f5357e == TitleType.BASIC) {
            throw new UnsupportedOperationException("Bottom-sheet has basic title");
        }
        this.f5357e = TitleType.CUSTOM;
        this.f5360h = f;
        this.f5359g = view;
        this.f5359g.setLayoutParams(new LayoutParams(-1, (int) this.f5360h));
    }

    public final boolean m5792h() {
        return this.f5357e != TitleType.NONE;
    }

    public final ViewHolder m5789a(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(this.f5355c);
        switch (i) {
            case 0:
                return new ItemViewHolder(from.inflate(2130904370, viewGroup, false));
            case 1:
                return new CondensedItemViewHolder(from.inflate(2130904369, viewGroup, false));
            case 2:
                return new TitleViewHolder(from.inflate(2130904371, viewGroup, false));
            case 3:
                return new CustomViewHolder(this.f5359g);
            case 4:
                View view = new View(this.f5355c);
                view.setLayoutParams(new LayoutParams(-1, this.f5355c.getResources().getDimensionPixelOffset(2131430834)));
                return new SpaceViewHolder(view);
            default:
                throw new IllegalArgumentException("Invalid view type for creating view holder.");
        }
    }

    public int getItemViewType(int i) {
        if (i == m5788j() || i == aZ_() - 1) {
            return 4;
        }
        if (!m5792h() || i != 0) {
            return this.f5356d ? 1 : 0;
        } else {
            if (this.f5357e == TitleType.CUSTOM) {
                return 3;
            }
            return 2;
        }
    }

    public final void m5790a(ViewHolder viewHolder, int i) {
        switch (getItemViewType(i)) {
            case 0:
                m5787a((ItemViewHolder) viewHolder, getItem((i - m5788j()) - 1));
                return;
            case 1:
                m5786a((CondensedItemViewHolder) viewHolder, getItem((i - m5788j()) - 1));
                return;
            case 2:
                ((TitleViewHolder) viewHolder).f5354l.setText(this.f5358f);
                return;
            case 3:
            case 4:
                return;
            default:
                throw new IllegalArgumentException("Invalid view type for binding view holder.");
        }
    }

    private void m5786a(CondensedItemViewHolder condensedItemViewHolder, final MenuItem menuItem) {
        if (menuItem.getIcon() != null) {
            condensedItemViewHolder.f5351l.setImageDrawable(menuItem.getIcon());
        }
        if (!this.f5361i) {
            condensedItemViewHolder.f5351l.setGlyphColor(ContextCompat.b(this.c, 2131362111));
        }
        if (!TextUtils.isEmpty(menuItem.getTitle())) {
            condensedItemViewHolder.f5352m.setText(menuItem.getTitle());
        }
        condensedItemViewHolder.a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FigBottomSheetAdapter f5350b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1241841810);
                this.f5350b.a(menuItem);
                Logger.a(2, EntryType.UI_INPUT_END, -2048923983, a);
            }
        });
    }

    private void m5787a(ItemViewHolder itemViewHolder, MenuItem menuItem) {
        m5786a((CondensedItemViewHolder) itemViewHolder, menuItem);
        if (menuItem instanceof MenuItemImpl) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
            if (TextUtils.isEmpty(menuItemImpl.d)) {
                itemViewHolder.f5353n.setVisibility(8);
                return;
            }
            itemViewHolder.f5353n.setVisibility(0);
            itemViewHolder.f5353n.setText(menuItemImpl.d);
            return;
        }
        itemViewHolder.f5353n.setVisibility(8);
    }

    public final int aZ_() {
        return ((m5792h() ? 1 : 0) + super.aZ_()) + 2;
    }

    private int m5788j() {
        return m5792h() ? 1 : 0;
    }
}
