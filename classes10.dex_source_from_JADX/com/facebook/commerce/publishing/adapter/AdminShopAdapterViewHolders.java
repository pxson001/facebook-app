package com.facebook.commerce.publishing.adapter;

import android.graphics.PorterDuff.Mode;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.commerce.publishing.fragments.AdminEditShopFragment;
import com.facebook.commerce.publishing.fragments.AdminEditShopFragment.C21595;
import com.facebook.commerce.publishing.fragments.AdminEditShopFragment.C21606;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: dataSz= */
public class AdminShopAdapterViewHolders {
    public static final int f15475a = 2130903189;
    public static final int f15476b = 2130903185;
    public static final int f15477c = 2130903186;
    public static final int f15478d = 2130903187;
    public static final int f15479e = 2130903188;
    public static final int f15480f = 2130906418;

    /* compiled from: dataSz= */
    public class AddProductButtonAmplifiedViewHolder extends ViewHolder {
        public AddProductButtonAmplifiedViewHolder(View view) {
            super(view);
        }
    }

    /* compiled from: dataSz= */
    public class AddProductButtonViewHolder extends ViewHolder {
        public final FbDraweeView f15468l;

        public AddProductButtonViewHolder(View view, int i) {
            super(view);
            this.f15468l = (FbDraweeView) view.findViewById(2131559436);
            this.f15468l.getTopLevelDrawable().setColorFilter(i, Mode.SRC_IN);
        }
    }

    /* compiled from: dataSz= */
    public class HeaderViewHolder extends ViewHolder {
        public final TextView f15469l;

        public HeaderViewHolder(View view) {
            super(view);
            this.f15469l = (TextView) view.findViewById(2131559439);
        }
    }

    /* compiled from: dataSz= */
    public class IntroSummaryViewHolder extends ViewHolder {
        public final AdminShopIntroSummaryView f15470l;

        public IntroSummaryViewHolder(View view) {
            super(view);
            this.f15470l = (AdminShopIntroSummaryView) view.findViewById(2131559440);
        }
    }

    /* compiled from: dataSz= */
    public class ShopFooterViewHolder extends ViewHolder {
        public final BetterTextView f15472l;
        public final BetterTextView f15473m;
        public final AdminEditShopFragment f15474n;

        /* compiled from: dataSz= */
        class C21351 implements OnClickListener {
            final /* synthetic */ ShopFooterViewHolder f15471a;

            C21351(ShopFooterViewHolder shopFooterViewHolder) {
                this.f15471a = shopFooterViewHolder;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 119034208);
                if (this.f15471a.f15474n != null) {
                    AdminEditShopFragment adminEditShopFragment = this.f15471a.f15474n;
                    new Builder(adminEditShopFragment.getContext()).a(2131239303).b(2131239304).b(2131239310, new C21606(adminEditShopFragment)).a(2131239300, new C21595(adminEditShopFragment)).b();
                }
                Logger.a(2, EntryType.UI_INPUT_END, 1794177687, a);
            }
        }

        public ShopFooterViewHolder(View view, @Nullable AdminEditShopFragment adminEditShopFragment) {
            super(view);
            this.f15472l = (BetterTextView) view.findViewById(2131559437);
            this.f15473m = (BetterTextView) view.findViewById(2131559438);
            this.f15474n = adminEditShopFragment;
            this.f15473m.setOnClickListener(new C21351(this));
        }
    }
}
