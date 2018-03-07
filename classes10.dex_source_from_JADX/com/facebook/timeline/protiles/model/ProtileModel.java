package com.facebook.timeline.protiles.model;

import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLProfileTileSectionType;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.ProtileItemFieldsModel;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.ProtileItemFieldsModel.NodeModel;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.ProtileSectionFieldsModel;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.ProtileViewFieldsModel;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.ProtileViewsConnectionFieldsModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: feed_filter_h_chr */
public class ProtileModel {
    public String f12105a;
    public final ProtileSectionFieldsModel f12106b;
    public ImmutableList<ProtileItemFieldsModel> f12107c;
    public boolean f12108d;
    public long f12109e;
    public boolean f12110f;

    public ProtileModel(ProtileSectionFieldsModel protileSectionFieldsModel) {
        Preconditions.checkNotNull(protileSectionFieldsModel);
        this.f12106b = protileSectionFieldsModel;
        ProtileViewFieldsModel l = m12106l();
        if (l == null || l.m12240j() == null) {
            this.f12107c = RegularImmutableList.a;
        } else {
            this.f12107c = l.m12240j().m12191a();
        }
        this.f12108d = l == null;
    }

    public final String m12107a() {
        return this.f12105a;
    }

    @Nullable
    public final GraphQLProfileTileSectionType m12109b() {
        return this.f12106b.m12218k();
    }

    @Nullable
    public final String m12111d() {
        if (this.f12106b.m12221n() == null) {
            return null;
        }
        return this.f12106b.m12221n().m12213a();
    }

    @Nullable
    public final String m12112e() {
        if (this.f12106b.m12220m() == null) {
            return null;
        }
        return this.f12106b.m12220m().m12208a();
    }

    @Nullable
    public final String m12113f() {
        if (this.f12106b.m12216a() == null) {
            return null;
        }
        return this.f12106b.m12216a().m12197a();
    }

    @Nullable
    public final String m12114g() {
        ProtileViewFieldsModel l = m12106l();
        if (l == null || l.m12241k() == null) {
            return null;
        }
        return l.m12241k().m12235j();
    }

    public final void m12108a(String str, GraphQLFriendshipStatus graphQLFriendshipStatus) {
        ProtileItemFieldsModel c = m12105c(str);
        if (c != null) {
            m12104a(str, c.m12184k().m12158o(), graphQLFriendshipStatus);
        }
    }

    public final void m12110b(String str) {
        ProtileItemFieldsModel c = m12105c(str);
        if (c != null && c.m12184k().m12158o() > 0) {
            m12104a(str, 0, c.m12184k().m12156m());
        }
    }

    private void m12104a(String str, int i, GraphQLFriendshipStatus graphQLFriendshipStatus) {
        Builder builder = ImmutableList.builder();
        int size = this.f12107c.size();
        for (int i2 = 0; i2 < size; i2++) {
            ProtileItemFieldsModel protileItemFieldsModel = (ProtileItemFieldsModel) this.f12107c.get(i2);
            if (protileItemFieldsModel.m12184k() == null || protileItemFieldsModel.m12184k().m12151d() == null || !protileItemFieldsModel.m12184k().m12151d().equals(str)) {
                builder.c(protileItemFieldsModel);
            } else {
                NodeModel k = protileItemFieldsModel.m12184k();
                NodeModel.Builder builder2 = new NodeModel.Builder();
                builder2.f12135a = k.m12149b();
                builder2.f12136b = k.m12153j();
                builder2.f12137c = k.m12159p();
                builder2.f12138d = k.m12155l();
                builder2.f12139e = k.m12160q();
                builder2.f12140f = k.m12156m();
                builder2.f12141g = k.m12151d();
                builder2.f12142h = k.m12161r();
                builder2.f12143i = k.m12162s();
                builder2.f12144j = k.m12163t();
                builder2.f12145k = k.m12164u();
                builder2.f12146l = k.m12165v();
                builder2.f12147m = k.m12158o();
                NodeModel.Builder builder3 = builder2;
                builder3.f12147m = i;
                builder3 = builder3;
                builder3.f12140f = graphQLFriendshipStatus;
                k = builder3.m12139a();
                ProtileItemFieldsModel.Builder builder4 = new ProtileItemFieldsModel.Builder();
                builder4.f12127a = protileItemFieldsModel.m12183j();
                builder4.f12128b = protileItemFieldsModel.m12184k();
                builder4.f12129c = protileItemFieldsModel.m12185l();
                builder4.f12130d = protileItemFieldsModel.m12186m();
                ProtileItemFieldsModel.Builder builder5 = builder4;
                builder5.f12128b = k;
                builder.c(builder5.m12128a());
            }
        }
        this.f12107c = builder.b();
    }

    @Nullable
    private ProtileItemFieldsModel m12105c(String str) {
        int size = this.f12107c.size();
        for (int i = 0; i < size; i++) {
            ProtileItemFieldsModel protileItemFieldsModel = (ProtileItemFieldsModel) this.f12107c.get(i);
            if (protileItemFieldsModel.m12184k() != null && protileItemFieldsModel.m12184k().m12151d() != null && protileItemFieldsModel.m12184k().m12151d().equals(str)) {
                return protileItemFieldsModel;
            }
        }
        return null;
    }

    private ProtileViewFieldsModel m12106l() {
        ProtileViewsConnectionFieldsModel l = this.f12106b.m12219l();
        if (l == null || l.m12246a().isEmpty()) {
            return null;
        }
        return (ProtileViewFieldsModel) l.m12246a().get(0);
    }
}
