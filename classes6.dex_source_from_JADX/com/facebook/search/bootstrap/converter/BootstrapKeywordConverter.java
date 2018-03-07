package com.facebook.search.bootstrap.converter;

import com.facebook.search.bootstrap.common.normalizer.NormalizedTokenHelper;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapKeywordsGraphQLModels.BootstrapKeywordsEdgeFragmentModel.EdgesModel;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapKeywordsGraphQLModels.BootstrapKeywordsEdgeFragmentModel.EdgesModel.NodeModel;
import com.facebook.search.bootstrap.model.BootstrapKeyword;
import com.facebook.search.bootstrap.model.BootstrapKeyword.Builder;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchException;
import javax.inject.Inject;

/* compiled from: extra_actor_viewer_context */
public class BootstrapKeywordConverter {
    @Inject
    public NormalizedTokenHelper f15630a;

    public final BootstrapKeyword m23344a(EdgesModel edgesModel) {
        if (edgesModel == null) {
            throw new GraphSearchException(GraphSearchError.BAD_BOOTSTRAP_SUGGESTION, "null edge for keyword suggestions");
        }
        NodeModel a = edgesModel.m23326a();
        if (a == null) {
            throw new GraphSearchException(GraphSearchError.BAD_BOOTSTRAP_SUGGESTION, "Missing node for bootstrap suggestion!");
        }
        String str;
        Builder builder = new Builder();
        builder.f15775a = a.m23321g();
        builder = builder;
        builder.f15777c = a.cG_();
        Builder builder2 = builder;
        if (a.m23320d() == null) {
            str = "keyword";
        } else {
            str = a.m23320d();
        }
        builder2.f15776b = str;
        builder = builder2;
        NormalizedTokenHelper normalizedTokenHelper = this.f15630a;
        builder = builder.m23441a(normalizedTokenHelper.f15581c.m23592b(a.m23321g()));
        builder.f15778d = a.cH_();
        builder = builder;
        builder.f15779e = a.m23316a();
        builder = builder;
        builder.f15781g = a.m23319c();
        builder = builder;
        builder.f15782h = a.m23318b();
        BootstrapKeyword bootstrapKeyword = new BootstrapKeyword(builder);
        BootstrapKeyword.m23442i(bootstrapKeyword);
        return bootstrapKeyword;
    }
}
