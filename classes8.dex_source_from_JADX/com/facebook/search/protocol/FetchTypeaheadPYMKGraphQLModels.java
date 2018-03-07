package com.facebook.search.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.protocol.FetchTypeaheadPYMKGraphQLParsers.FBTypeaheadPYMKQueryParser;
import com.facebook.search.protocol.FetchTypeaheadPYMKGraphQLParsers.FBTypeaheadPYMKQueryParser.PeopleYouMayKnowParser;
import com.facebook.search.protocol.FetchTypeaheadPYMKGraphQLParsers.FBTypeaheadPYMKQueryParser.PeopleYouMayKnowParser.NodesParser;
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

/* compiled from: net_banking */
public class FetchTypeaheadPYMKGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 233400114)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: net_banking */
    public final class FBTypeaheadPYMKQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PeopleYouMayKnowModel f8080d;

        /* compiled from: net_banking */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBTypeaheadPYMKQueryModel.class, new Deserializer());
            }

            public Object m8915a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBTypeaheadPYMKQueryParser.m8939a(jsonParser);
                Object fBTypeaheadPYMKQueryModel = new FBTypeaheadPYMKQueryModel();
                ((BaseModel) fBTypeaheadPYMKQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBTypeaheadPYMKQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fBTypeaheadPYMKQueryModel).a();
                }
                return fBTypeaheadPYMKQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1005408448)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: net_banking */
        public final class PeopleYouMayKnowModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f8079d;

            /* compiled from: net_banking */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PeopleYouMayKnowModel.class, new Deserializer());
                }

                public Object m8916a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PeopleYouMayKnowParser.m8937a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object peopleYouMayKnowModel = new PeopleYouMayKnowModel();
                    ((BaseModel) peopleYouMayKnowModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (peopleYouMayKnowModel instanceof Postprocessable) {
                        return ((Postprocessable) peopleYouMayKnowModel).a();
                    }
                    return peopleYouMayKnowModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 2106355611)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: net_banking */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f8076d;
                @Nullable
                private String f8077e;
                @Nullable
                private DefaultImageFieldsModel f8078f;

                /* compiled from: net_banking */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m8917a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m8935b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                /* compiled from: net_banking */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m8918a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m8919a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m8936b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(3);
                }

                public final void m8922a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m8923a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final String m8924j() {
                    this.f8076d = super.a(this.f8076d, 0);
                    return this.f8076d;
                }

                @Nullable
                public final String m8925k() {
                    this.f8077e = super.a(this.f8077e, 1);
                    return this.f8077e;
                }

                @Nullable
                public final DefaultImageFieldsModel m8926l() {
                    this.f8078f = (DefaultImageFieldsModel) super.a(this.f8078f, 2, DefaultImageFieldsModel.class);
                    return this.f8078f;
                }

                @Nullable
                public final String m8921a() {
                    return m8924j();
                }

                public final int jK_() {
                    return 2645995;
                }

                public final GraphQLVisitableModel m8920a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m8926l() != null) {
                        DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m8926l());
                        if (m8926l() != defaultImageFieldsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f8078f = defaultImageFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m8919a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m8924j());
                    int b2 = flatBufferBuilder.b(m8925k());
                    int a = ModelHelper.a(flatBufferBuilder, m8926l());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    flatBufferBuilder.b(2, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: net_banking */
            public class Serializer extends JsonSerializer<PeopleYouMayKnowModel> {
                public final void m8927a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PeopleYouMayKnowModel peopleYouMayKnowModel = (PeopleYouMayKnowModel) obj;
                    if (peopleYouMayKnowModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(peopleYouMayKnowModel.m8928a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        peopleYouMayKnowModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PeopleYouMayKnowParser.m8938a(peopleYouMayKnowModel.w_(), peopleYouMayKnowModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PeopleYouMayKnowModel.class, new Serializer());
                }
            }

            public PeopleYouMayKnowModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m8930a() {
                this.f8079d = super.a(this.f8079d, 0, NodesModel.class);
                return (ImmutableList) this.f8079d;
            }

            public final int jK_() {
                return 1781614462;
            }

            public final GraphQLVisitableModel m8929a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m8930a() != null) {
                    Builder a = ModelHelper.a(m8930a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PeopleYouMayKnowModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8079d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m8928a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m8930a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: net_banking */
        public class Serializer extends JsonSerializer<FBTypeaheadPYMKQueryModel> {
            public final void m8931a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBTypeaheadPYMKQueryModel fBTypeaheadPYMKQueryModel = (FBTypeaheadPYMKQueryModel) obj;
                if (fBTypeaheadPYMKQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBTypeaheadPYMKQueryModel.m8932a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBTypeaheadPYMKQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBTypeaheadPYMKQueryModel.w_();
                int u_ = fBTypeaheadPYMKQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("people_you_may_know");
                    PeopleYouMayKnowParser.m8938a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBTypeaheadPYMKQueryModel.class, new Serializer());
            }
        }

        public FBTypeaheadPYMKQueryModel() {
            super(1);
        }

        @Nullable
        public final PeopleYouMayKnowModel m8934a() {
            this.f8080d = (PeopleYouMayKnowModel) super.a(this.f8080d, 0, PeopleYouMayKnowModel.class);
            return this.f8080d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m8933a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m8934a() != null) {
                PeopleYouMayKnowModel peopleYouMayKnowModel = (PeopleYouMayKnowModel) graphQLModelMutatingVisitor.b(m8934a());
                if (m8934a() != peopleYouMayKnowModel) {
                    graphQLVisitableModel = (FBTypeaheadPYMKQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8080d = peopleYouMayKnowModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m8932a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m8934a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
