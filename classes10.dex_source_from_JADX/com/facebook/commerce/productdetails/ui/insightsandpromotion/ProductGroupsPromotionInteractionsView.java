package com.facebook.commerce.productdetails.ui.insightsandpromotion;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.adinterfaces.abtest.ExperimentsForAdInterfacesModule;
import com.facebook.adinterfaces.external.AdInterfacesIntentUtil;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.util.AdInterfacesHelper;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.FetchProductGroupQueryModel;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.FetchProductGroupQueryModel.CommerceInsightsModel;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.FetchProductGroupQueryModel.ProductPromotionsModel.NodesModel;
import com.facebook.graphql.enums.GraphQLBoostedComponentStatus;
import com.facebook.groups.staticadapter.StaticAdapter.Bindable;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: default_cover_photo */
public class ProductGroupsPromotionInteractionsView extends CustomFrameLayout implements Bindable<FetchProductGroupQueryModel> {
    public InsightsAndPromotionView f15265a = ((InsightsAndPromotionView) c(2131566286));
    public AdInterfacesHelper f15266b;

    public static void m15909a(Object obj, Context context) {
        ((ProductGroupsPromotionInteractionsView) obj).f15266b = AdInterfacesHelper.a(FbInjector.get(context));
    }

    public final void mo758a(Object obj) {
        final FetchProductGroupQueryModel fetchProductGroupQueryModel = (FetchProductGroupQueryModel) obj;
        this.f15265a.setVisibility(0);
        this.f15265a.setFirstDataLabel(getResources().getString(2131241877));
        this.f15265a.setSecondDataLabel(getResources().getString(2131241876));
        if (fetchProductGroupQueryModel.m15822t() != null && this.f15266b.b.a(ExperimentsForAdInterfacesModule.i, false)) {
            String string;
            if (((NodesModel) fetchProductGroupQueryModel.m15823u().m15785a().get(0)).m15780a() == GraphQLBoostedComponentStatus.ACTIVE) {
                string = getResources().getString(2131241875);
            } else {
                string = getResources().getString(2131241874);
            }
            this.f15265a.m15908a(string, new OnClickListener(this) {
                final /* synthetic */ ProductGroupsPromotionInteractionsView f15264b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1512185030);
                    AdInterfacesHelper adInterfacesHelper = this.f15264b.f15266b;
                    Context context = view.getContext();
                    String l = fetchProductGroupQueryModel.m15822t().m15772l();
                    String r = fetchProductGroupQueryModel.m15820r();
                    String valueOf = String.valueOf(l);
                    String valueOf2 = String.valueOf(r);
                    Intent a2 = AdInterfacesIntentUtil.a(context, ObjectiveType.PROMOTE_PRODUCT, Integer.valueOf(2131234050), "pages_manager_activity_tab");
                    a2.putExtra("page_id", valueOf);
                    a2.putExtra("promotion_target_id", valueOf2);
                    adInterfacesHelper.a.a(a2, context);
                    Logger.a(2, EntryType.UI_INPUT_END, -27150290, a);
                }
            });
        }
        CommerceInsightsModel k = fetchProductGroupQueryModel.m15813k();
        int parseInt = Integer.parseInt(k.m15693j());
        this.f15265a.setFirstDataValue(Integer.toString(Integer.parseInt(k.m15694k()) + parseInt));
        this.f15265a.setSecondDataValue(fetchProductGroupQueryModel.m15813k().m15692a());
    }

    public ProductGroupsPromotionInteractionsView(Context context) {
        super(context);
        Class cls = ProductGroupsPromotionInteractionsView.class;
        m15909a(this, getContext());
        setContentView(2130906408);
    }
}
