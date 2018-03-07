package com.facebook.search.results.factory.graphsearch;

import android.content.Context;
import com.facebook.api.graphql.media.NewsFeedMediaGraphQLModels.SphericalMetadataModel.GuidedTourModel;
import com.facebook.api.graphql.media.NewsFeedMediaGraphQLModels.SphericalMetadataModel.GuidedTourModel.KeyframesModel;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLVideoGuidedTour;
import com.facebook.graphql.model.GraphQLVideoGuidedTourKeyframe;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesEntityFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel.RangesModel;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.ModuleResultEdgeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.Builder;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel;
import com.facebook.search.results.protocol.video.SearchResultsVideoModels.SearchResultsVideoModel.OwnerModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

@ContextScoped
/* compiled from: SPECIFIED_LOCATION */
public class GraphSearchVideosModuleFactory extends GraphSearchResultsBridgeFactory {
    private static GraphSearchVideosModuleFactory f22768a;
    private static final Object f22769b = new Object();

    private static GraphSearchVideosModuleFactory m26401a() {
        return new GraphSearchVideosModuleFactory();
    }

    @Nullable
    public final EdgesModel mo1267a(ModuleResultEdgeModel moduleResultEdgeModel) {
        GraphQLNode b = moduleResultEdgeModel.m8668b();
        if (b == null) {
            return null;
        }
        GraphQLStory bv = b.bv();
        if (bv == null) {
            return null;
        }
        OwnerModel ownerModel;
        DefaultImageFieldsModel defaultImageFieldsModel;
        Builder builder = new Builder();
        EdgesNodeModel.Builder builder2 = new EdgesNodeModel.Builder();
        builder2.f8418n = b.dp();
        builder2 = builder2;
        builder2.f8409e = b.bu();
        builder2 = builder2;
        builder2.f8410f = bv;
        EdgesNodeModel.Builder builder3 = builder2;
        builder3.f8415k = b.kq();
        builder3 = builder3;
        builder3.f8416l = b.kr();
        builder3 = builder3;
        builder3.f8417m = b.ks();
        builder3 = builder3;
        builder3.f8426v = b.dN();
        builder3 = builder3;
        builder3.f8408d = b.ao();
        builder3 = builder3;
        builder3.f8427w = b.ku();
        builder3 = builder3;
        builder3.f8429y = b.kv();
        builder3 = builder3;
        builder3.f8381A = b.eq();
        builder3 = builder3;
        builder3.f8382B = b.kw();
        builder3 = builder3;
        GraphQLActor p = b.p();
        if (p == null) {
            ownerModel = null;
        } else {
            OwnerModel.Builder builder4 = new OwnerModel.Builder();
            builder4.f8838b = p.R();
            builder4 = builder4;
            builder4.f8839c = p.aa();
            ownerModel = builder4.m10534a();
        }
        builder3.f8386F = ownerModel;
        builder3 = builder3;
        builder3.f8388H = b.fB();
        builder3 = builder3;
        builder3.f8389I = b.kx();
        builder3 = builder3;
        builder3.f8390J = b.ky();
        builder3 = builder3;
        builder3.f8400T = b.kz();
        builder3 = builder3;
        builder3.f8383C = m26400a(b.eD());
        builder3 = builder3;
        builder3.f8404X = b.kA();
        builder3 = builder3;
        GraphQLImage kt = b.kt();
        if (kt == null) {
            defaultImageFieldsModel = null;
        } else {
            DefaultImageFieldsModel.Builder builder5 = new DefaultImageFieldsModel.Builder();
            builder5.a = kt.a();
            builder5 = builder5;
            builder5.c = kt.c();
            builder5 = builder5;
            builder5.b = kt.b();
            defaultImageFieldsModel = builder5.a();
        }
        builder3.f8421q = defaultImageFieldsModel;
        builder3 = builder3;
        builder3.f8428x = b.dW();
        builder3 = builder3;
        builder3.f8391K = b.gl();
        builder3 = builder3;
        builder3.f8422r = b.dw();
        builder3 = builder3;
        builder3.f8423s = b.dx();
        builder3 = builder3;
        builder3.f8424t = b.dy();
        builder3 = builder3;
        builder3.f8397Q = b.hD();
        builder3 = builder3;
        builder3.f8396P = b.hC();
        builder3 = builder3;
        builder3.f8398R = b.hE();
        builder3 = builder3;
        builder3.f8395O = b.hB();
        builder3 = builder3;
        builder3.f8394N = b.hA();
        builder3 = builder3;
        builder3.f8414j = m26399a(b.df());
        builder.f8377a = builder3.m9596a();
        return builder.m9586a();
    }

    public static GraphSearchVideosModuleFactory m26402a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GraphSearchVideosModuleFactory a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f22769b) {
                GraphSearchVideosModuleFactory graphSearchVideosModuleFactory;
                if (a3 != null) {
                    graphSearchVideosModuleFactory = (GraphSearchVideosModuleFactory) a3.a(f22769b);
                } else {
                    graphSearchVideosModuleFactory = f22768a;
                }
                if (graphSearchVideosModuleFactory == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m26401a();
                        if (a3 != null) {
                            a3.a(f22769b, a2);
                        } else {
                            f22768a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = graphSearchVideosModuleFactory;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }

    @Nullable
    private static DefaultTextWithEntitiesLongFieldsModel m26400a(@Nullable GraphQLTextWithEntities graphQLTextWithEntities) {
        if (graphQLTextWithEntities == null) {
            return null;
        }
        ImmutableList immutableList;
        DefaultTextWithEntitiesLongFieldsModel.Builder builder = new DefaultTextWithEntitiesLongFieldsModel.Builder();
        builder.b = graphQLTextWithEntities.a();
        builder = builder;
        ImmutableList b = graphQLTextWithEntities.b();
        if (b.isEmpty()) {
            immutableList = RegularImmutableList.a;
        } else {
            ImmutableList.Builder builder2 = new ImmutableList.Builder();
            int size = b.size();
            for (int i = 0; i < size; i++) {
                DefaultTextWithEntitiesEntityFieldsModel defaultTextWithEntitiesEntityFieldsModel;
                GraphQLEntityAtRange graphQLEntityAtRange = (GraphQLEntityAtRange) b.get(i);
                RangesModel.Builder builder3 = new RangesModel.Builder();
                builder3.c = graphQLEntityAtRange.c();
                builder3 = builder3;
                builder3.b = graphQLEntityAtRange.b();
                builder3 = builder3;
                GraphQLEntity j = graphQLEntityAtRange.j();
                if (j == null) {
                    defaultTextWithEntitiesEntityFieldsModel = null;
                } else {
                    DefaultTextWithEntitiesEntityFieldsModel.Builder builder4 = new DefaultTextWithEntitiesEntityFieldsModel.Builder();
                    builder4.c = j.d();
                    builder4 = builder4;
                    builder4.d = j.C_();
                    builder4 = builder4;
                    builder4.e = j.g();
                    builder4 = builder4;
                    builder4.f = j.D_();
                    defaultTextWithEntitiesEntityFieldsModel = builder4.a();
                }
                builder3.a = defaultTextWithEntitiesEntityFieldsModel;
                builder2.c(builder3.a());
            }
            immutableList = builder2.b();
        }
        builder.a = immutableList;
        return builder.a();
    }

    @Nullable
    private static GuidedTourModel m26399a(@Nullable GraphQLVideoGuidedTour graphQLVideoGuidedTour) {
        if (graphQLVideoGuidedTour == null) {
            return null;
        }
        ImmutableList immutableList;
        GuidedTourModel.Builder builder = new GuidedTourModel.Builder();
        ImmutableList a = graphQLVideoGuidedTour.a();
        if (a.isEmpty()) {
            immutableList = RegularImmutableList.a;
        } else {
            ImmutableList.Builder builder2 = new ImmutableList.Builder();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                GraphQLVideoGuidedTourKeyframe graphQLVideoGuidedTourKeyframe = (GraphQLVideoGuidedTourKeyframe) a.get(i);
                KeyframesModel.Builder builder3 = new KeyframesModel.Builder();
                builder3.b = graphQLVideoGuidedTourKeyframe.j();
                builder3 = builder3;
                builder3.a = graphQLVideoGuidedTourKeyframe.a();
                builder3 = builder3;
                builder3.c = graphQLVideoGuidedTourKeyframe.k();
                builder2.c(builder3.a());
            }
            immutableList = builder2.b();
        }
        builder.a = immutableList;
        return builder.a();
    }
}
