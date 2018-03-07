package com.facebook.commerce.publishing.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.commerce.core.ui.ProductItemViewBinder;
import com.facebook.commerce.core.ui.ProductItemViewHolder;
import com.facebook.commerce.core.ui.ProductItemViewModel.Builder;
import com.facebook.commerce.core.util.CommerceCurrencyUtil;
import com.facebook.commerce.publishing.adapter.AdminShopAdapterViewHolders.AddProductButtonAmplifiedViewHolder;
import com.facebook.commerce.publishing.adapter.AdminShopAdapterViewHolders.AddProductButtonViewHolder;
import com.facebook.commerce.publishing.adapter.AdminShopAdapterViewHolders.HeaderViewHolder;
import com.facebook.commerce.publishing.adapter.AdminShopAdapterViewHolders.IntroSummaryViewHolder;
import com.facebook.commerce.publishing.adapter.AdminShopAdapterViewHolders.ShopFooterViewHolder;
import com.facebook.commerce.publishing.adapter.AdminShopIntroSummaryView.IntroSummaryTextChangedListener;
import com.facebook.commerce.publishing.adapter.SectionedAdapterHelper.C21401;
import com.facebook.commerce.publishing.fragments.AdminEditShopFragment;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsInterfaces.AdminCommerceProductItem;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsModels.AdminCommerceProductItemModel;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsModels.AdminCommerceProductItemModel.ProductImageLargeModel;
import com.facebook.commerce.publishing.ui.AdminProductItemViewModelCreator;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLCommerceProductVisibility;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.util.Currency;
import javax.inject.Inject;

/* compiled from: data_savings_mode_settings */
public class AdminShopAdapter extends Adapter<ViewHolder> {
    private static final CallerContext f15451a = CallerContext.a(AdminShopAdapter.class);
    public final Context f15452b;
    private final LayoutInflater f15453c;
    private final ProductItemViewBinder f15454d;
    private final AdminProductItemViewModelCreator f15455e;
    public final SectionedAdapterHelper f15456f;
    public final GridLayoutManager f15457g;
    public final AdminShopAdapterDataProvider f15458h;
    private final ItemInsetDecoration f15459i;
    public final SectionSpanSizeLookup f15460j;
    public AdminEditShopFragment f15461k;
    private final OnClickListener f15462l = new C21342(this);

    /* compiled from: data_savings_mode_settings */
    public class C21331 implements IntroSummaryTextChangedListener {
        final /* synthetic */ AdminShopAdapter f15445a;

        public C21331(AdminShopAdapter adminShopAdapter) {
            this.f15445a = adminShopAdapter;
        }

        public final void mo759a(String str) {
            this.f15445a.f15458h.f15467e = (String) Preconditions.checkNotNull(str);
        }
    }

    /* compiled from: data_savings_mode_settings */
    class C21342 implements OnClickListener {
        final /* synthetic */ AdminShopAdapter f15446a;

        C21342(AdminShopAdapter adminShopAdapter) {
            this.f15446a = adminShopAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1154543627);
            if (this.f15446a.f15461k == null) {
                Logger.a(2, EntryType.UI_INPUT_END, -1895672514, a);
                return;
            }
            GridLayoutManager gridLayoutManager = this.f15446a.f15457g;
            int c = LayoutManager.c(view);
            int a2 = this.f15446a.f15456f.m16024a(c);
            c = this.f15446a.f15456f.m16025b(c);
            if (a2 == 3 || a2 == 2) {
                this.f15446a.f15461k.m16055a();
            } else if (a2 == 4) {
                AdminCommerceProductItemModel a3 = this.f15446a.f15458h.m15997a(c);
                if (!(a3 == null || this.f15446a.f15458h.m15999b(a3))) {
                    this.f15446a.f15461k.m16057a(a3);
                }
            }
            LogUtils.a(568685522, a);
        }
    }

    /* compiled from: data_savings_mode_settings */
    public class ItemInsetDecoration extends ItemDecoration {
        public final /* synthetic */ AdminShopAdapter f15447a;
        private final int f15448b;
        private final int f15449c;

        public ItemInsetDecoration(AdminShopAdapter adminShopAdapter, Resources resources) {
            this.f15447a = adminShopAdapter;
            this.f15448b = resources.getDimensionPixelSize(2131432927);
            this.f15449c = resources.getDimensionPixelSize(2131432928);
        }

        public final void m15985a(Rect rect, View view, RecyclerView recyclerView, State state) {
            super.a(rect, view, recyclerView, state);
            int e = recyclerView.a(view).e();
            if (this.f15447a.f15460j.m15986a(e) == 2) {
                e = this.f15447a.getItemViewType(e) == AdminShopAdapterViewHolders.f15478d ? 0 : this.f15448b;
                rect.set(e, 0, e, 0);
                return;
            }
            Object obj;
            if (this.f15447a.f15460j.a(e, 2) == 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                rect.set(this.f15448b, 0, this.f15449c / 2, 0);
            } else {
                rect.set(this.f15449c / 2, 0, this.f15448b, 0);
            }
        }
    }

    /* compiled from: data_savings_mode_settings */
    class SectionSpanSizeLookup extends SpanSizeLookup {
        final /* synthetic */ AdminShopAdapter f15450b;

        public SectionSpanSizeLookup(AdminShopAdapter adminShopAdapter) {
            this.f15450b = adminShopAdapter;
        }

        public final int m15986a(int i) {
            int a = this.f15450b.f15456f.m16024a(i);
            if (a == 4 || a == 3) {
                return 1;
            }
            return 2;
        }
    }

    @Inject
    public AdminShopAdapter(Context context, LayoutInflater layoutInflater, ProductItemViewBinder productItemViewBinder, AdminProductItemViewModelCreator adminProductItemViewModelCreator, @Assisted AdminShopAdapterDataProvider adminShopAdapterDataProvider) {
        this.f15452b = context;
        this.f15453c = layoutInflater;
        this.f15454d = productItemViewBinder;
        this.f15455e = adminProductItemViewModelCreator;
        this.f15458h = adminShopAdapterDataProvider;
        this.f15456f = new SectionedAdapterHelper(this);
        this.f15457g = new GridLayoutManager(context, 2);
        this.f15459i = new ItemInsetDecoration(this, this.f15452b.getResources());
        this.f15460j = new SectionSpanSizeLookup(this);
        a(new C21401(this.f15456f));
        AdminShopAdapterDataProvider adminShopAdapterDataProvider2 = this.f15458h;
        adminShopAdapterDataProvider2.f15466d = this;
        if (adminShopAdapterDataProvider2.f15466d != null) {
            adminShopAdapterDataProvider2.f15466d.notifyDataSetChanged();
        }
        this.f15460j.b = true;
        this.f15457g.h = this.f15460j;
    }

    public final ViewHolder m15989a(ViewGroup viewGroup, int i) {
        ViewHolder viewHolder = null;
        View inflate = this.f15453c.inflate(i, viewGroup, false);
        if (i == AdminShopAdapterViewHolders.f15475a) {
            viewHolder = new IntroSummaryViewHolder(inflate);
        } else if (i == AdminShopAdapterViewHolders.f15478d) {
            viewHolder = new ShopFooterViewHolder(inflate, this.f15461k);
        } else if (i == AdminShopAdapterViewHolders.f15479e) {
            viewHolder = new HeaderViewHolder(inflate);
        } else if (i == AdminShopAdapterViewHolders.f15476b) {
            viewHolder = new AddProductButtonAmplifiedViewHolder(inflate);
        } else if (i == AdminShopAdapterViewHolders.f15477c) {
            viewHolder = new AddProductButtonViewHolder(inflate, this.f15452b.getResources().getColor(2131361917));
        } else if (i == AdminShopAdapterViewHolders.f15480f) {
            viewHolder = new ProductItemViewHolder(inflate);
        }
        Preconditions.checkNotNull(viewHolder);
        viewHolder.a.setOnClickListener(this.f15462l);
        return viewHolder;
    }

    public final void m15990a(ViewHolder viewHolder, int i) {
        int a = this.f15456f.m16024a(i);
        if (a == 6) {
            ShopFooterViewHolder shopFooterViewHolder = (ShopFooterViewHolder) viewHolder;
            Currency b = this.f15458h.m15998b();
            if (b != null) {
                shopFooterViewHolder.f15472l.setText(b.getCurrencyCode());
            }
        } else if (a == 1) {
            r6 = (HeaderViewHolder) viewHolder;
            r6.f15469l.setText(this.f15452b.getResources().getString(2131239293));
        } else if (a == 5) {
            r6 = (HeaderViewHolder) viewHolder;
            r6.f15469l.setText(this.f15452b.getResources().getString(2131239292));
        } else if (a == 0) {
            String str;
            IntroSummaryViewHolder introSummaryViewHolder = (IntroSummaryViewHolder) viewHolder;
            AdminShopIntroSummaryView adminShopIntroSummaryView = introSummaryViewHolder.f15470l;
            AdminShopAdapterDataProvider adminShopAdapterDataProvider = this.f15458h;
            if (adminShopAdapterDataProvider.f15463a == null || adminShopAdapterDataProvider.f15463a.n() == null || adminShopAdapterDataProvider.f15463a.n().a() == null) {
                str = null;
            } else {
                str = adminShopAdapterDataProvider.f15463a.n().a();
            }
            adminShopIntroSummaryView.m16012a(str);
            introSummaryViewHolder.f15470l.m16013b(this.f15458h.m16001e());
            introSummaryViewHolder.f15470l.f15490e = new C21331(this);
        } else if (a == 4) {
            m15987a((ProductItemViewHolder) viewHolder, i);
        }
    }

    private void m15987a(ProductItemViewHolder productItemViewHolder, int i) {
        boolean z;
        String str;
        AdminCommerceProductItem adminCommerceProductItem = (AdminCommerceProductItem) Preconditions.checkNotNull(this.f15458h.m15997a(this.f15456f.m16025b(i)));
        AdminShopAdapterDataProvider adminShopAdapterDataProvider = this.f15458h;
        boolean z2 = true;
        Builder builder = new Builder();
        builder.e = adminCommerceProductItem.g();
        Builder builder2 = builder;
        builder2.f = CommerceCurrencyUtil.a(adminCommerceProductItem.j());
        Builder builder3 = builder2;
        if (adminCommerceProductItem.c() == GraphQLCommerceProductVisibility.PRODUCT_REJECTED) {
            z = true;
        } else {
            z = false;
        }
        builder3.b = z;
        builder2 = builder3;
        if (adminCommerceProductItem.c() != GraphQLCommerceProductVisibility.PRODUCT_IN_REVIEW) {
            z2 = false;
        }
        builder2.c = z2;
        builder2 = builder2;
        builder2.d = adminCommerceProductItem.b();
        builder2.a = adminShopAdapterDataProvider.m15999b(adminCommerceProductItem);
        if (adminCommerceProductItem == null || adminCommerceProductItem.cw_() == null || adminCommerceProductItem.cw_().size() <= 0 || ((ProductImageLargeModel) adminCommerceProductItem.cw_().get(0)).b() == null || ((ProductImageLargeModel) adminCommerceProductItem.cw_().get(0)).b().a() == null) {
            str = null;
        } else {
            str = ((ProductImageLargeModel) adminCommerceProductItem.cw_().get(0)).b().a();
        }
        String str2 = str;
        if (!StringUtil.a(str2)) {
            builder.g = Optional.of(Uri.parse(str2));
        }
        ProductItemViewBinder.a(productItemViewHolder, builder.a());
    }

    public final int aZ_() {
        return this.f15456f.m16023a();
    }

    public int getItemViewType(int i) {
        boolean z = true;
        int a = this.f15456f.m16024a(i);
        if (a == 2) {
            return AdminShopAdapterViewHolders.f15476b;
        }
        if (a == 1) {
            return AdminShopAdapterViewHolders.f15479e;
        }
        if (a == 5) {
            return AdminShopAdapterViewHolders.f15479e;
        }
        if (a == 0) {
            return AdminShopAdapterViewHolders.f15475a;
        }
        if (a == 4) {
            return AdminShopAdapterViewHolders.f15480f;
        }
        if (a == 3) {
            return AdminShopAdapterViewHolders.f15477c;
        }
        if (a != 6) {
            z = false;
        }
        Preconditions.checkState(z);
        return AdminShopAdapterViewHolders.f15478d;
    }

    public final int m15991e(int i) {
        if (i == 4) {
            return this.f15458h.m16003g();
        }
        if (i == 2) {
            if (m15988f()) {
                return 1;
            }
            return 0;
        } else if (i == 3 && m15988f()) {
            return 0;
        } else {
            return 1;
        }
    }

    public final void a_(RecyclerView recyclerView) {
        super.a_(recyclerView);
        recyclerView.setLayoutManager(this.f15457g);
        recyclerView.a(this.f15459i);
    }

    private boolean m15988f() {
        return this.f15458h.m16003g() == 0;
    }
}
