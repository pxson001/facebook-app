package com.facebook.composer.minutiae.model;

import com.facebook.common.util.StringUtil;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLInterfaces.TaggableObjectEdge;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.MinutiaeTaggableObjectsModel;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.TaggableObjectEdgeModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoTailFields;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: add_item_action_info */
public class MinutiaeObjectsData {
    public final List<TaggableObjectEdge> f11479a = Lists.a();
    public final Map<TaggableObjectEdge, String> f11480b = Maps.c();
    @Nullable
    public DefaultPageInfoTailFields f11481c;
    @Nullable
    public String f11482d;

    public final void m19641a(MinutiaeTaggableObjectsModel minutiaeTaggableObjectsModel, String str) {
        this.f11481c = minutiaeTaggableObjectsModel.m19299b();
        if (minutiaeTaggableObjectsModel.m19298a() != null && !minutiaeTaggableObjectsModel.m19298a().isEmpty()) {
            this.f11479a.addAll(minutiaeTaggableObjectsModel.m19298a());
            ImmutableList a = minutiaeTaggableObjectsModel.m19298a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                this.f11480b.put((TaggableObjectEdgeModel) a.get(i), str);
            }
            this.f11482d = str;
        }
    }

    public final boolean m19642a() {
        return (this.f11481c == null || !this.f11481c.b() || StringUtil.a(this.f11481c.a())) ? false : true;
    }

    public final int m19643b() {
        return this.f11479a.size();
    }

    public final TaggableObjectEdgeModel m19640a(int i) {
        return (TaggableObjectEdgeModel) this.f11479a.get(i);
    }
}
