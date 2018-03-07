package com.facebook.commerce.productdetails.ui.termsandpolicies;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.FetchProductGroupQueryModel;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.groups.staticadapter.StaticAdapter.Bindable;
import com.facebook.inject.FbInjector;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: dd2839cf220218e22d4a07bda27da940 */
public class ProductGroupTermsAndPoliciesView extends CustomFrameLayout implements Bindable<FetchProductGroupQueryModel> {
    public TextView f15306a = ((TextView) c(2131566296));
    public UriIntentMapper f15307b;
    public SecureContextHelper f15308c;

    public static void m15928a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ProductGroupTermsAndPoliciesView productGroupTermsAndPoliciesView = (ProductGroupTermsAndPoliciesView) obj;
        UriIntentMapper uriIntentMapper = (UriIntentMapper) Fb4aUriIntentMapper.a(fbInjector);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        productGroupTermsAndPoliciesView.f15307b = uriIntentMapper;
        productGroupTermsAndPoliciesView.f15308c = secureContextHelper;
    }

    public final void mo758a(Object obj) {
        final FetchProductGroupQueryModel fetchProductGroupQueryModel = (FetchProductGroupQueryModel) obj;
        this.f15306a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ProductGroupTermsAndPoliciesView f15305b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1834792584);
                this.f15305b.f15308c.a(this.f15305b.f15307b.a(this.f15305b.getContext(), fetchProductGroupQueryModel.m15814l().m15703l()), this.f15305b.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, 1343015643, a);
            }
        });
    }

    public ProductGroupTermsAndPoliciesView(Context context) {
        super(context);
        Class cls = ProductGroupTermsAndPoliciesView.class;
        m15928a(this, getContext());
        setContentView(2130906413);
    }
}
