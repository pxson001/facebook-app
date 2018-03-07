package com.facebook.commerce.storefront.ui;

import android.content.Context;
import com.facebook.commerce.core.ui.PageInfoView;
import com.facebook.commerce.core.ui.PageInfoViewProvider;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: core_graph_delete_request */
public class StorefrontHeaderView extends CustomLinearLayout {
    @Inject
    public PageInfoViewProvider f15818a;
    public PageInfoView f15819b = this.f15818a.a((ContentView) a(2131567673));
    public FbTextView f15820c = ((FbTextView) a(2131567674));
    public MerchantSubscriptionView f15821d = ((MerchantSubscriptionView) a(2131567675));
    public FeaturedProductCollectionView f15822e = ((FeaturedProductCollectionView) a(2131567676));
    public FbTextView f15823f = ((FbTextView) a(2131567677));

    public static void m16285a(Object obj, Context context) {
        ((StorefrontHeaderView) obj).f15818a = (PageInfoViewProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(PageInfoViewProvider.class);
    }

    public StorefrontHeaderView(Context context) {
        super(context);
        Class cls = StorefrontHeaderView.class;
        m16285a(this, getContext());
        setContentView(2130907245);
        setOrientation(1);
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getResources().getDimensionPixelSize(2131427416));
    }
}
