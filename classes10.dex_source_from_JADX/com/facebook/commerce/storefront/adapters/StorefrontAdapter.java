package com.facebook.commerce.storefront.adapters;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.CommerceStoreFragmentModel.CommerceCollectionsModel;
import com.facebook.commerce.core.intent.MerchantInfoViewData;
import com.facebook.commerce.storefront.ui.MerchantSubscriptionViewController;
import com.facebook.commerce.storefront.ui.StorefrontHeaderView;
import com.facebook.commerce.storefront.ui.StorefrontHeaderViewModel;
import com.facebook.commerce.storefront.ui.StorefrontPageInfoViewBinder;
import com.facebook.common.util.StringUtil;
import com.facebook.resources.ui.FbTextView;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: create_new_group */
public class StorefrontAdapter extends Adapter {
    public final Context f15673a;
    @Nullable
    public AbstractProductGroupingAdapter f15674b;
    public StorefrontHeaderViewModel f15675c;
    public View f15676d;
    @Nullable
    public View f15677e;
    public OnClickListener f15678f;

    /* compiled from: create_new_group */
    public class C21821 extends SpanSizeLookup {
        final /* synthetic */ StorefrontAdapter f15671b;

        public C21821(StorefrontAdapter storefrontAdapter) {
            this.f15671b = storefrontAdapter;
        }

        public final int m16125a(int i) {
            if (StorefrontAdapter.m16128f(this.f15671b, i)) {
                return this.f15671b.f15674b.mo763d();
            }
            return 2;
        }
    }

    /* compiled from: create_new_group */
    class SimpleViewHolder extends ViewHolder {
        public SimpleViewHolder(View view) {
            super(view);
        }
    }

    /* compiled from: create_new_group */
    public class StorefrontHeaderViewHolder extends ViewHolder {
        public StorefrontHeaderView f15672l;

        public StorefrontHeaderViewHolder(StorefrontHeaderView storefrontHeaderView) {
            super(storefrontHeaderView);
            this.f15672l = storefrontHeaderView;
        }
    }

    public StorefrontAdapter(Context context, StorefrontHeaderViewModel storefrontHeaderViewModel, @Nullable AbstractProductGroupingAdapter abstractProductGroupingAdapter) {
        this.f15673a = context;
        this.f15675c = storefrontHeaderViewModel;
        this.f15674b = abstractProductGroupingAdapter;
        View view = new View(this.f15673a);
        view.setLayoutParams(new LayoutParams(-1, 0));
        this.f15676d = view;
        Preconditions.checkNotNull(storefrontHeaderViewModel);
    }

    private int m16126e(int i) {
        return i - 2;
    }

    public static boolean m16128f(StorefrontAdapter storefrontAdapter, int i) {
        return i >= 2 && i < storefrontAdapter.m16129g();
    }

    public final int aZ_() {
        return (2 + m16127f()) + (this.f15674b != null ? this.f15674b.aZ_() : 0);
    }

    private int m16127f() {
        return this.f15677e != null ? 1 : 0;
    }

    private int m16129g() {
        return aZ_() - m16127f();
    }

    public final long H_(int i) {
        if (m16128f(this, i)) {
            return this.f15674b.H_(m16126e(i));
        }
        return (long) i;
    }

    public int getItemViewType(int i) {
        if (i >= m16129g()) {
            return -1;
        }
        if (m16128f(this, i)) {
            return 2 + this.f15674b.getItemViewType(m16126e(i));
        }
        return i;
    }

    public final void m16131a(ViewHolder viewHolder, int i) {
        if (m16128f(this, i)) {
            this.f15674b.a(viewHolder, m16126e(i));
            return;
        }
        switch (getItemViewType(i)) {
            case -1:
            case 0:
                return;
            case 1:
                int intValue;
                StorefrontHeaderViewHolder storefrontHeaderViewHolder = (StorefrontHeaderViewHolder) viewHolder;
                StorefrontHeaderViewModel storefrontHeaderViewModel = this.f15675c;
                StorefrontHeaderView storefrontHeaderView = storefrontHeaderViewHolder.f15672l;
                if (storefrontHeaderViewModel.f15835d.isPresent()) {
                    intValue = ((Integer) storefrontHeaderViewModel.f15835d.get()).intValue();
                } else {
                    intValue = storefrontHeaderView.getPaddingTop();
                }
                storefrontHeaderView.setPadding(storefrontHeaderView.getPaddingLeft(), intValue, storefrontHeaderView.getPaddingRight(), storefrontHeaderView.getPaddingBottom());
                if (storefrontHeaderViewModel.f15833b.isPresent()) {
                    storefrontHeaderView.f15819b.a(true);
                    StorefrontPageInfoViewBinder.m16288a((MerchantInfoViewData) storefrontHeaderViewModel.f15833b.get(), storefrontHeaderView.f15819b);
                } else {
                    storefrontHeaderView.f15819b.a(false);
                }
                FbTextView fbTextView = storefrontHeaderView.f15820c;
                if (storefrontHeaderViewModel.f15834c) {
                    intValue = 0;
                } else {
                    intValue = 8;
                }
                fbTextView.setVisibility(intValue);
                if (storefrontHeaderViewModel.f15836e.isPresent() && ((MerchantSubscriptionViewController) storefrontHeaderViewModel.f15836e.get()).m16280a()) {
                    storefrontHeaderView.f15821d.setVisibility(0);
                    storefrontHeaderView.f15821d.setViewController((MerchantSubscriptionViewController) storefrontHeaderViewModel.f15836e.get());
                    storefrontHeaderView.f15821d.mo770a();
                } else {
                    storefrontHeaderView.f15821d.setVisibility(8);
                }
                if (!storefrontHeaderViewModel.f15837f.isPresent() || ((CommerceCollectionsModel) storefrontHeaderViewModel.f15837f.get()).j().a() <= 0) {
                    storefrontHeaderView.f15822e.setVisibility(8);
                } else {
                    storefrontHeaderView.f15822e.setVisibility(0);
                    storefrontHeaderView.f15822e.m16264a((CommerceCollectionsModel) storefrontHeaderViewModel.f15837f.get(), (String) storefrontHeaderViewModel.f15839h.orNull());
                }
                if (!storefrontHeaderViewModel.f15838g.isPresent() || StringUtil.c((CharSequence) storefrontHeaderViewModel.f15838g.get())) {
                    storefrontHeaderView.f15823f.setVisibility(8);
                } else {
                    storefrontHeaderView.f15823f.setVisibility(0);
                    storefrontHeaderView.f15823f.setText((CharSequence) storefrontHeaderViewModel.f15838g.get());
                }
                return;
            default:
                throw new IllegalStateException("Cannot bind ViewHolder for position: " + i);
        }
    }

    public final ViewHolder m16130a(ViewGroup viewGroup, int i) {
        if (i >= 2) {
            return this.f15674b.a(viewGroup, i);
        }
        switch (i) {
            case -1:
                return new SimpleViewHolder((View) Preconditions.checkNotNull(this.f15677e));
            case 0:
                return new SimpleViewHolder((View) Preconditions.checkNotNull(this.f15676d));
            case 1:
                StorefrontHeaderView storefrontHeaderView = new StorefrontHeaderView(viewGroup.getContext());
                OnClickListener onClickListener = this.f15678f;
                if (storefrontHeaderView.f15820c != null) {
                    storefrontHeaderView.f15820c.setOnClickListener(onClickListener);
                }
                storefrontHeaderView.setLayoutParams(new LayoutParams(-1, -2));
                return new StorefrontHeaderViewHolder(storefrontHeaderView);
            default:
                throw new IllegalStateException("Cannot create ViewHolder itemViewType: " + i);
        }
    }
}
