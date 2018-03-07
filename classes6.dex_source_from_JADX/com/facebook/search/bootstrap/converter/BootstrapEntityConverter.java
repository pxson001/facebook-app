package com.facebook.search.bootstrap.converter;

import android.net.Uri;
import com.facebook.search.bootstrap.common.BootstrapEntityCostUtil;
import com.facebook.search.bootstrap.common.normalizer.NormalizedTokenHelper;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapEntitiesGraphQLInterfaces.AddEntityFragment;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapEntitiesGraphQLModels.AddEntityFragmentModel.SearchableModel;
import com.facebook.search.bootstrap.model.BootstrapEntity;
import com.facebook.search.bootstrap.model.BootstrapEntity.Builder;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchException;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: extra_admin_product_item */
public class BootstrapEntityConverter {
    private final NormalizedTokenHelper f15629a;

    @Inject
    public BootstrapEntityConverter(NormalizedTokenHelper normalizedTokenHelper) {
        this.f15629a = normalizedTokenHelper;
    }

    public final BootstrapEntity m23343a(AddEntityFragment addEntityFragment) {
        SearchableModel b = addEntityFragment.mo1230b();
        if (b == null) {
            throw new GraphSearchException(GraphSearchError.BAD_BOOTSTRAP_SUGGESTION, "Missing searchable for bootstrap suggestion!");
        }
        boolean z;
        Builder builder = new Builder();
        builder.f15754b = b.cD_();
        builder = builder;
        builder.f15753a = b.cF_();
        builder = builder;
        builder.f15755c = b.m23213b();
        builder = builder;
        builder.f15758f = addEntityFragment.mo1229a();
        builder = builder;
        builder.f15757e = addEntityFragment.mo1232d();
        Builder builder2 = builder;
        if (b.cE_() || b.m23214c()) {
            z = true;
        } else {
            z = false;
        }
        builder2.f15761i = z;
        builder = builder2;
        builder.f15759g = b.m23216g();
        builder = builder;
        NormalizedTokenHelper normalizedTokenHelper = this.f15629a;
        ImmutableList j = b.m23217j();
        ImmutableList.Builder builder3 = ImmutableList.builder();
        if (j != null) {
            int size = j.size();
            for (int i = 0; i < size; i++) {
                builder3.c(normalizedTokenHelper.f15582d.a((String) j.get(i)));
            }
        }
        builder = builder.m23438a(builder3.b());
        builder.f15763k = BootstrapEntityCostUtil.m23187a(addEntityFragment.mo1231c());
        builder = builder;
        if (b.m23213b() != null && b.m23213b().g() == 69076575 && b.m23215d() != null && b.m23215d().m23508a() != null) {
            builder.f15756d = Uri.parse(b.m23215d().m23508a().m23502a());
        } else if (b.m23218k() != null) {
            builder.f15756d = Uri.parse(b.m23218k().b());
        }
        return builder.m23439l();
    }
}
