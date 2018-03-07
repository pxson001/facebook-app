package com.facebook.pages.adminedpages.protocol;

import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQLModels.AdminedPagesPrefetchQueryModel.AdminedPagesModel.NodesModel;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.annotation.Nonnull;

/* compiled from: cta_select_list */
public class AdminedPagesPrefetchNode {
    @Nonnull
    public NodesModel f16549a;
    public Optional<String> f16550b;

    public AdminedPagesPrefetchNode(NodesModel nodesModel) {
        this.f16549a = nodesModel;
        this.f16550b = Absent.INSTANCE;
    }

    public AdminedPagesPrefetchNode(NodesModel nodesModel, String str) {
        this.f16549a = nodesModel;
        this.f16550b = Optional.of(str);
    }

    public final NodesModel m19526a() {
        return this.f16549a;
    }

    public final Optional<String> m19527b() {
        return this.f16550b;
    }
}
