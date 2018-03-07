package com.facebook.commerce.productdetails.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.commerce.productdetails.adapter.ProductGroupAdapterRows.ProductGroupViewType;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.FetchProductGroupQueryModel;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.FetchProductGroupQueryModel.Builder;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.FetchProductGroupQueryModel.CommerceUiDetailSectionsModel.NodesModel;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.graphql.enums.GraphQLCommerceUIProductDetailSectionType;
import com.facebook.groups.staticadapter.StaticAdapter.BindableSection;
import com.facebook.groups.staticadapter.StaticAdapter.Section;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import java.util.EnumMap;
import javax.inject.Inject;

/* compiled from: delete_outgoing_ping */
public class ProductDetailsAdapter extends FbBaseAdapter {
    private static final String f15121a = ProductDetailsAdapter.class.getSimpleName();
    private final EnumMap<GraphQLCommerceUIProductDetailSectionType, ProductGroupViewType> f15122b;
    private final Lazy<FbErrorReporter> f15123c;
    private ImmutableList<Section> f15124d = RegularImmutableList.a;
    private FetchProductGroupQueryModel f15125e;

    public static ProductDetailsAdapter m15641b(InjectorLike injectorLike) {
        return new ProductDetailsAdapter(IdBasedSingletonScopeProvider.b(injectorLike, 494));
    }

    @Inject
    public ProductDetailsAdapter(Lazy<FbErrorReporter> lazy) {
        this.f15123c = lazy;
        this.f15125e = new Builder().m15687a();
        this.f15122b = Maps.a(GraphQLCommerceUIProductDetailSectionType.class);
        ImmutableList immutableList = ProductGroupAdapterRows.f15131f;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ProductGroupViewType productGroupViewType = (ProductGroupViewType) immutableList.get(i);
            this.f15122b.put(productGroupViewType.mo756a(), productGroupViewType);
        }
    }

    public final void m15644a(FetchProductGroupQueryModel fetchProductGroupQueryModel) {
        if (fetchProductGroupQueryModel == null || fetchProductGroupQueryModel.m15816n() == null || fetchProductGroupQueryModel.m15816n().m15713a() == null) {
            this.f15124d = RegularImmutableList.a;
            AdapterDetour.a(this, 398351296);
        } else if (this.f15125e != fetchProductGroupQueryModel) {
            this.f15125e = fetchProductGroupQueryModel;
            ImmutableList.Builder builder = ImmutableList.builder();
            ImmutableList a = this.f15125e.m15816n().m15713a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                NodesModel nodesModel = (NodesModel) a.get(i);
                if (this.f15122b.containsKey(nodesModel.m15708a())) {
                    ProductGroupViewType productGroupViewType = (ProductGroupViewType) this.f15122b.get(nodesModel.m15708a());
                    if (productGroupViewType.mo757a(this.f15125e)) {
                        builder.c(new BindableSection(productGroupViewType, this.f15125e));
                    }
                } else {
                    ((AbstractFbErrorReporter) this.f15123c.get()).a(f15121a, "Unsupported section type: " + nodesModel.m15708a().name());
                }
            }
            this.f15124d = builder.b();
            AdapterDetour.a(this, 2095803467);
        }
    }

    public int getItemViewType(int i) {
        return ProductGroupAdapterRows.f15131f.indexOf(((Section) this.f15124d.get(i)).mo10a());
    }

    public int getViewTypeCount() {
        return ProductGroupAdapterRows.f15131f.size();
    }

    public final View m15642a(int i, ViewGroup viewGroup) {
        return ((ProductGroupViewType) ProductGroupAdapterRows.f15131f.get(i)).mo12a(viewGroup);
    }

    public final void m15643a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        ((Section) obj).mo11a(view);
    }

    public int getCount() {
        return this.f15124d.size();
    }

    public Object getItem(int i) {
        return this.f15124d.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
