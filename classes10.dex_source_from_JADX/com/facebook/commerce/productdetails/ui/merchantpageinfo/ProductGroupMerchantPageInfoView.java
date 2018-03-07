package com.facebook.commerce.productdetails.ui.merchantpageinfo;

import android.content.Context;
import android.net.Uri;
import com.facebook.commerce.core.ui.PageInfoView;
import com.facebook.commerce.core.ui.PageInfoViewProvider;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.FetchProductGroupQueryModel;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.FetchProductGroupQueryModel.PageModel;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.groups.staticadapter.StaticAdapter.Bindable;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

/* compiled from: deeplink_context */
public class ProductGroupMerchantPageInfoView extends CustomFrameLayout implements Bindable<FetchProductGroupQueryModel> {
    @Inject
    public PageInfoViewProvider f15267a;
    public PageInfoView f15268b = this.f15267a.a((ContentView) c(2131560409));

    public static void m15911a(Object obj, Context context) {
        ((ProductGroupMerchantPageInfoView) obj).f15267a = (PageInfoViewProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(PageInfoViewProvider.class);
    }

    public final void mo758a(Object obj) {
        FetchProductGroupQueryModel fetchProductGroupQueryModel = (FetchProductGroupQueryModel) obj;
        PageInfoView pageInfoView = this.f15268b;
        int i = 0;
        PageModel t = fetchProductGroupQueryModel.m15822t();
        if (t != null) {
            pageInfoView.c = t.m15772l();
            pageInfoView.a(t.m15773m());
            if (t.m15775o() == null || StringUtil.a(t.m15775o().a())) {
                pageInfoView.a(null);
            } else {
                pageInfoView.a(Uri.parse(t.m15775o().a()));
            }
            String str = "";
            if (!(t.m15770j().isEmpty() || t.m15774n() == null)) {
                String str2 = (String) t.m15770j().get(0);
                str = str2;
                i = t.m15774n().a();
            }
            pageInfoView.a(str, i);
        }
    }

    public ProductGroupMerchantPageInfoView(Context context) {
        super(context);
        Class cls = ProductGroupMerchantPageInfoView.class;
        m15911a(this, getContext());
        setContentView(2130906410);
        setBackgroundResource(2131361864);
    }
}
