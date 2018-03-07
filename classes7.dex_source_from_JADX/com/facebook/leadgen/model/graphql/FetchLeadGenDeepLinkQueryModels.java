package com.facebook.leadgen.model.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.leadgen.model.graphql.FetchLeadGenDeepLinkQueryParsers.FetchLeadGenDeepLinkParser;
import com.facebook.leadgen.model.graphql.LeadGenGraphQLModels.LeadGenDeepLinkDataFragModel.ErrorCodesModel;
import com.facebook.leadgen.model.graphql.LeadGenGraphQLModels.LeadGenDeepLinkDataFragModel.LeadGenDataModel;
import com.facebook.leadgen.model.graphql.LeadGenGraphQLModels.LeadGenDeepLinkDataFragModel.LeadGenDeepLinkUserStatusModel;
import com.facebook.leadgen.model.graphql.LeadGenGraphQLModels.LeadGenDeepLinkDataFragModel.PageModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: photos_count */
public class FetchLeadGenDeepLinkQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2028358560)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photos_count */
    public final class FetchLeadGenDeepLinkModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private String f6437A;
        @Nullable
        private String f6438B;
        private boolean f6439C;
        @Nullable
        private String f6440D;
        @Nullable
        private String f6441E;
        @Nullable
        private String f6442F;
        @Nullable
        private String f6443G;
        @Nullable
        private GraphQLObjectType f6444d;
        @Nullable
        private String f6445e;
        private int f6446f;
        @Nullable
        private String f6447g;
        @Nullable
        private String f6448h;
        @Nullable
        private List<ErrorCodesModel> f6449i;
        @Nullable
        private String f6450j;
        @Nullable
        private String f6451k;
        @Nullable
        private String f6452l;
        @Nullable
        private String f6453m;
        @Nullable
        private String f6454n;
        @Nullable
        private String f6455o;
        @Nullable
        private String f6456p;
        @Nullable
        private String f6457q;
        @Nullable
        private LeadGenDataModel f6458r;
        @Nullable
        private LeadGenDeepLinkUserStatusModel f6459s;
        @Nullable
        private PageModel f6460t;
        @Nullable
        private String f6461u;
        @Nullable
        private String f6462v;
        @Nullable
        private String f6463w;
        @Nullable
        private String f6464x;
        @Nullable
        private String f6465y;
        @Nullable
        private String f6466z;

        /* compiled from: photos_count */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchLeadGenDeepLinkModel.class, new Deserializer());
            }

            public Object m8262a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FetchLeadGenDeepLinkParser.m8297a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fetchLeadGenDeepLinkModel = new FetchLeadGenDeepLinkModel();
                ((BaseModel) fetchLeadGenDeepLinkModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fetchLeadGenDeepLinkModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchLeadGenDeepLinkModel).a();
                }
                return fetchLeadGenDeepLinkModel;
            }
        }

        /* compiled from: photos_count */
        public class Serializer extends JsonSerializer<FetchLeadGenDeepLinkModel> {
            public final void m8263a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FetchLeadGenDeepLinkModel fetchLeadGenDeepLinkModel = (FetchLeadGenDeepLinkModel) obj;
                if (fetchLeadGenDeepLinkModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchLeadGenDeepLinkModel.m8292a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchLeadGenDeepLinkModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FetchLeadGenDeepLinkParser.m8298a(fetchLeadGenDeepLinkModel.w_(), fetchLeadGenDeepLinkModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FetchLeadGenDeepLinkModel.class, new Serializer());
            }
        }

        public FetchLeadGenDeepLinkModel() {
            super(30);
        }

        public final void m8295a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m8296a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m8274a() {
            if (this.b != null && this.f6444d == null) {
                this.f6444d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f6444d;
        }

        @Nullable
        private String m8275j() {
            this.f6445e = super.a(this.f6445e, 1);
            return this.f6445e;
        }

        @Nullable
        private String m8276k() {
            this.f6447g = super.a(this.f6447g, 3);
            return this.f6447g;
        }

        @Nullable
        private String m8277l() {
            this.f6448h = super.a(this.f6448h, 4);
            return this.f6448h;
        }

        @Nonnull
        private ImmutableList<ErrorCodesModel> m8278m() {
            this.f6449i = super.a(this.f6449i, 5, ErrorCodesModel.class);
            return (ImmutableList) this.f6449i;
        }

        @Nullable
        private String m8279n() {
            this.f6450j = super.a(this.f6450j, 6);
            return this.f6450j;
        }

        @Nullable
        private String m8280o() {
            this.f6451k = super.a(this.f6451k, 7);
            return this.f6451k;
        }

        @Nullable
        private String m8281p() {
            this.f6452l = super.a(this.f6452l, 8);
            return this.f6452l;
        }

        @Nullable
        private String m8282q() {
            this.f6453m = super.a(this.f6453m, 9);
            return this.f6453m;
        }

        @Nullable
        private String m8283r() {
            this.f6454n = super.a(this.f6454n, 10);
            return this.f6454n;
        }

        @Nullable
        private String m8284s() {
            this.f6455o = super.a(this.f6455o, 11);
            return this.f6455o;
        }

        @Nullable
        private String m8285t() {
            this.f6456p = super.a(this.f6456p, 12);
            return this.f6456p;
        }

        @Nullable
        private String m8286u() {
            this.f6457q = super.a(this.f6457q, 13);
            return this.f6457q;
        }

        @Nullable
        private LeadGenDataModel m8287v() {
            this.f6458r = (LeadGenDataModel) super.a(this.f6458r, 14, LeadGenDataModel.class);
            return this.f6458r;
        }

        @Nullable
        private LeadGenDeepLinkUserStatusModel m8288w() {
            this.f6459s = (LeadGenDeepLinkUserStatusModel) super.a(this.f6459s, 15, LeadGenDeepLinkUserStatusModel.class);
            return this.f6459s;
        }

        @Nullable
        private PageModel m8289x() {
            this.f6460t = (PageModel) super.a(this.f6460t, 16, PageModel.class);
            return this.f6460t;
        }

        @Nullable
        private String m8290y() {
            this.f6461u = super.a(this.f6461u, 17);
            return this.f6461u;
        }

        @Nullable
        private String m8291z() {
            this.f6462v = super.a(this.f6462v, 18);
            return this.f6462v;
        }

        @Nullable
        private String m8264A() {
            this.f6463w = super.a(this.f6463w, 19);
            return this.f6463w;
        }

        @Nullable
        private String m8265B() {
            this.f6464x = super.a(this.f6464x, 20);
            return this.f6464x;
        }

        @Nullable
        private String m8266C() {
            this.f6465y = super.a(this.f6465y, 21);
            return this.f6465y;
        }

        @Nullable
        private String m8267D() {
            this.f6466z = super.a(this.f6466z, 22);
            return this.f6466z;
        }

        @Nullable
        private String m8268E() {
            this.f6437A = super.a(this.f6437A, 23);
            return this.f6437A;
        }

        @Nullable
        private String m8269F() {
            this.f6438B = super.a(this.f6438B, 24);
            return this.f6438B;
        }

        @Nullable
        private String m8270G() {
            this.f6440D = super.a(this.f6440D, 26);
            return this.f6440D;
        }

        @Nullable
        private String m8271H() {
            this.f6441E = super.a(this.f6441E, 27);
            return this.f6441E;
        }

        @Nullable
        private String m8272I() {
            this.f6442F = super.a(this.f6442F, 28);
            return this.f6442F;
        }

        @Nullable
        private String m8273J() {
            this.f6443G = super.a(this.f6443G, 29);
            return this.f6443G;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m8293a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            LeadGenDataModel leadGenDataModel;
            LeadGenDeepLinkUserStatusModel leadGenDeepLinkUserStatusModel;
            PageModel pageModel;
            h();
            if (m8278m() != null) {
                Builder a = ModelHelper.a(m8278m(), graphQLModelMutatingVisitor);
                if (a != null) {
                    FetchLeadGenDeepLinkModel fetchLeadGenDeepLinkModel = (FetchLeadGenDeepLinkModel) ModelHelper.a(null, this);
                    fetchLeadGenDeepLinkModel.f6449i = a.b();
                    graphQLVisitableModel = fetchLeadGenDeepLinkModel;
                    if (m8287v() != null) {
                        leadGenDataModel = (LeadGenDataModel) graphQLModelMutatingVisitor.b(m8287v());
                        if (m8287v() != leadGenDataModel) {
                            graphQLVisitableModel = (FetchLeadGenDeepLinkModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f6458r = leadGenDataModel;
                        }
                    }
                    if (m8288w() != null) {
                        leadGenDeepLinkUserStatusModel = (LeadGenDeepLinkUserStatusModel) graphQLModelMutatingVisitor.b(m8288w());
                        if (m8288w() != leadGenDeepLinkUserStatusModel) {
                            graphQLVisitableModel = (FetchLeadGenDeepLinkModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f6459s = leadGenDeepLinkUserStatusModel;
                        }
                    }
                    if (m8289x() != null) {
                        pageModel = (PageModel) graphQLModelMutatingVisitor.b(m8289x());
                        if (m8289x() != pageModel) {
                            graphQLVisitableModel = (FetchLeadGenDeepLinkModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f6460t = pageModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m8287v() != null) {
                leadGenDataModel = (LeadGenDataModel) graphQLModelMutatingVisitor.b(m8287v());
                if (m8287v() != leadGenDataModel) {
                    graphQLVisitableModel = (FetchLeadGenDeepLinkModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6458r = leadGenDataModel;
                }
            }
            if (m8288w() != null) {
                leadGenDeepLinkUserStatusModel = (LeadGenDeepLinkUserStatusModel) graphQLModelMutatingVisitor.b(m8288w());
                if (m8288w() != leadGenDeepLinkUserStatusModel) {
                    graphQLVisitableModel = (FetchLeadGenDeepLinkModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6459s = leadGenDeepLinkUserStatusModel;
                }
            }
            if (m8289x() != null) {
                pageModel = (PageModel) graphQLModelMutatingVisitor.b(m8289x());
                if (m8289x() != pageModel) {
                    graphQLVisitableModel = (FetchLeadGenDeepLinkModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6460t = pageModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m8292a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m8274a());
            int b = flatBufferBuilder.b(m8275j());
            int b2 = flatBufferBuilder.b(m8276k());
            int b3 = flatBufferBuilder.b(m8277l());
            int a2 = ModelHelper.a(flatBufferBuilder, m8278m());
            int b4 = flatBufferBuilder.b(m8279n());
            int b5 = flatBufferBuilder.b(m8280o());
            int b6 = flatBufferBuilder.b(m8281p());
            int b7 = flatBufferBuilder.b(m8282q());
            int b8 = flatBufferBuilder.b(m8283r());
            int b9 = flatBufferBuilder.b(m8284s());
            int b10 = flatBufferBuilder.b(m8285t());
            int b11 = flatBufferBuilder.b(m8286u());
            int a3 = ModelHelper.a(flatBufferBuilder, m8287v());
            int a4 = ModelHelper.a(flatBufferBuilder, m8288w());
            int a5 = ModelHelper.a(flatBufferBuilder, m8289x());
            int b12 = flatBufferBuilder.b(m8290y());
            int b13 = flatBufferBuilder.b(m8291z());
            int b14 = flatBufferBuilder.b(m8264A());
            int b15 = flatBufferBuilder.b(m8265B());
            int b16 = flatBufferBuilder.b(m8266C());
            int b17 = flatBufferBuilder.b(m8267D());
            int b18 = flatBufferBuilder.b(m8268E());
            int b19 = flatBufferBuilder.b(m8269F());
            int b20 = flatBufferBuilder.b(m8270G());
            int b21 = flatBufferBuilder.b(m8271H());
            int b22 = flatBufferBuilder.b(m8272I());
            int b23 = flatBufferBuilder.b(m8273J());
            flatBufferBuilder.c(30);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.a(2, this.f6446f, 0);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.b(5, a2);
            flatBufferBuilder.b(6, b4);
            flatBufferBuilder.b(7, b5);
            flatBufferBuilder.b(8, b6);
            flatBufferBuilder.b(9, b7);
            flatBufferBuilder.b(10, b8);
            flatBufferBuilder.b(11, b9);
            flatBufferBuilder.b(12, b10);
            flatBufferBuilder.b(13, b11);
            flatBufferBuilder.b(14, a3);
            flatBufferBuilder.b(15, a4);
            flatBufferBuilder.b(16, a5);
            flatBufferBuilder.b(17, b12);
            flatBufferBuilder.b(18, b13);
            flatBufferBuilder.b(19, b14);
            flatBufferBuilder.b(20, b15);
            flatBufferBuilder.b(21, b16);
            flatBufferBuilder.b(22, b17);
            flatBufferBuilder.b(23, b18);
            flatBufferBuilder.b(24, b19);
            flatBufferBuilder.a(25, this.f6439C);
            flatBufferBuilder.b(26, b20);
            flatBufferBuilder.b(27, b21);
            flatBufferBuilder.b(28, b22);
            flatBufferBuilder.b(29, b23);
            i();
            return flatBufferBuilder.d();
        }

        public final void m8294a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f6446f = mutableFlatBuffer.a(i, 2, 0);
            this.f6439C = mutableFlatBuffer.a(i, 25);
        }
    }
}
