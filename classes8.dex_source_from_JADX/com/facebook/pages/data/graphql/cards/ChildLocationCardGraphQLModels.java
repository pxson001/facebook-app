package com.facebook.pages.data.graphql.cards;

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
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultLocationFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.data.graphql.cards.ChildLocationCardGraphQLParsers.ChildLocationConnectionFieldsParser;
import com.facebook.pages.data.graphql.cards.ChildLocationCardGraphQLParsers.ChildLocationConnectionFieldsParser.NodesParser;
import com.facebook.pages.data.graphql.cards.ChildLocationCardGraphQLParsers.ChildLocationConnectionFieldsParser.NodesParser.AddressParser;
import com.facebook.pages.data.graphql.cards.ChildLocationCardGraphQLParsers.ChildLocationQueryWithViewerLocationParser;
import com.facebook.pages.data.graphql.cards.ChildLocationCardGraphQLParsers.ChildLocationQueryWithoutViewerLocationParser;
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

/* compiled from: control_style */
public class ChildLocationCardGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1379877086)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: control_style */
    public final class ChildLocationConnectionFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<NodesModel> f16935d;

        /* compiled from: control_style */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ChildLocationConnectionFieldsModel.class, new Deserializer());
            }

            public Object m20227a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ChildLocationConnectionFieldsParser.m20268a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object childLocationConnectionFieldsModel = new ChildLocationConnectionFieldsModel();
                ((BaseModel) childLocationConnectionFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (childLocationConnectionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) childLocationConnectionFieldsModel).a();
                }
                return childLocationConnectionFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1922741464)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: control_style */
        public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private AddressModel f16930d;
            @Nullable
            private String f16931e;
            @Nullable
            private DefaultLocationFieldsModel f16932f;
            @Nullable
            private String f16933g;
            @Nullable
            private DefaultImageFieldsModel f16934h;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1492488211)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: control_style */
            public final class AddressModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f16928d;
                @Nullable
                private String f16929e;

                /* compiled from: control_style */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(AddressModel.class, new Deserializer());
                    }

                    public Object m20228a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(AddressParser.m20264a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object addressModel = new AddressModel();
                        ((BaseModel) addressModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (addressModel instanceof Postprocessable) {
                            return ((Postprocessable) addressModel).a();
                        }
                        return addressModel;
                    }
                }

                /* compiled from: control_style */
                public class Serializer extends JsonSerializer<AddressModel> {
                    public final void m20229a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        AddressModel addressModel = (AddressModel) obj;
                        if (addressModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(addressModel.m20230a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            addressModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        AddressParser.m20265a(addressModel.w_(), addressModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(AddressModel.class, new Serializer());
                    }
                }

                public AddressModel() {
                    super(2);
                }

                @Nullable
                public final String m20232a() {
                    this.f16928d = super.a(this.f16928d, 0);
                    return this.f16928d;
                }

                @Nullable
                public final String m20233j() {
                    this.f16929e = super.a(this.f16929e, 1);
                    return this.f16929e;
                }

                public final int jK_() {
                    return 799251025;
                }

                public final GraphQLVisitableModel m20231a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m20230a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m20232a());
                    int b2 = flatBufferBuilder.b(m20233j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: control_style */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                }

                public Object m20234a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NodesParser.m20266b(jsonParser, flatBufferBuilder));
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

            /* compiled from: control_style */
            public class Serializer extends JsonSerializer<NodesModel> {
                public final void m20235a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NodesModel nodesModel = (NodesModel) obj;
                    if (nodesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(nodesModel.m20236a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NodesParser.m20267b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(NodesModel.class, new Serializer());
                }
            }

            public NodesModel() {
                super(5);
            }

            public final void m20239a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m20240a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final AddressModel m20241j() {
                this.f16930d = (AddressModel) super.a(this.f16930d, 0, AddressModel.class);
                return this.f16930d;
            }

            @Nullable
            public final String m20242k() {
                this.f16931e = super.a(this.f16931e, 1);
                return this.f16931e;
            }

            @Nullable
            public final DefaultLocationFieldsModel m20243l() {
                this.f16932f = (DefaultLocationFieldsModel) super.a(this.f16932f, 2, DefaultLocationFieldsModel.class);
                return this.f16932f;
            }

            @Nullable
            public final String m20244m() {
                this.f16933g = super.a(this.f16933g, 3);
                return this.f16933g;
            }

            @Nullable
            public final DefaultImageFieldsModel m20245n() {
                this.f16934h = (DefaultImageFieldsModel) super.a(this.f16934h, 4, DefaultImageFieldsModel.class);
                return this.f16934h;
            }

            @Nullable
            public final String m20238a() {
                return m20242k();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m20237a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m20241j() != null) {
                    AddressModel addressModel = (AddressModel) graphQLModelMutatingVisitor.b(m20241j());
                    if (m20241j() != addressModel) {
                        graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f16930d = addressModel;
                    }
                }
                if (m20243l() != null) {
                    DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(m20243l());
                    if (m20243l() != defaultLocationFieldsModel) {
                        graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f16932f = defaultLocationFieldsModel;
                    }
                }
                if (m20245n() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20245n());
                    if (m20245n() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f16934h = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m20236a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20241j());
                int b = flatBufferBuilder.b(m20242k());
                int a2 = ModelHelper.a(flatBufferBuilder, m20243l());
                int b2 = flatBufferBuilder.b(m20244m());
                int a3 = ModelHelper.a(flatBufferBuilder, m20245n());
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.b(4, a3);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: control_style */
        public class Serializer extends JsonSerializer<ChildLocationConnectionFieldsModel> {
            public final void m20246a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ChildLocationConnectionFieldsModel childLocationConnectionFieldsModel = (ChildLocationConnectionFieldsModel) obj;
                if (childLocationConnectionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(childLocationConnectionFieldsModel.m20247a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    childLocationConnectionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ChildLocationConnectionFieldsParser.m20269a(childLocationConnectionFieldsModel.w_(), childLocationConnectionFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ChildLocationConnectionFieldsModel.class, new Serializer());
            }
        }

        public ChildLocationConnectionFieldsModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<NodesModel> m20249a() {
            this.f16935d = super.a(this.f16935d, 0, NodesModel.class);
            return (ImmutableList) this.f16935d;
        }

        public final int jK_() {
            return 592926703;
        }

        public final GraphQLVisitableModel m20248a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20249a() != null) {
                Builder a = ModelHelper.a(m20249a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (ChildLocationConnectionFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16935d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20247a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20249a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 610103003)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: control_style */
    public final class ChildLocationQueryWithViewerLocationModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private ChildLocationConnectionFieldsModel f16936d;

        /* compiled from: control_style */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ChildLocationQueryWithViewerLocationModel.class, new Deserializer());
            }

            public Object m20250a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ChildLocationQueryWithViewerLocationParser.m20270a(jsonParser);
                Object childLocationQueryWithViewerLocationModel = new ChildLocationQueryWithViewerLocationModel();
                ((BaseModel) childLocationQueryWithViewerLocationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (childLocationQueryWithViewerLocationModel instanceof Postprocessable) {
                    return ((Postprocessable) childLocationQueryWithViewerLocationModel).a();
                }
                return childLocationQueryWithViewerLocationModel;
            }
        }

        /* compiled from: control_style */
        public class Serializer extends JsonSerializer<ChildLocationQueryWithViewerLocationModel> {
            public final void m20251a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ChildLocationQueryWithViewerLocationModel childLocationQueryWithViewerLocationModel = (ChildLocationQueryWithViewerLocationModel) obj;
                if (childLocationQueryWithViewerLocationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(childLocationQueryWithViewerLocationModel.m20252a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    childLocationQueryWithViewerLocationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = childLocationQueryWithViewerLocationModel.w_();
                int u_ = childLocationQueryWithViewerLocationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("child_locations");
                    ChildLocationConnectionFieldsParser.m20269a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ChildLocationQueryWithViewerLocationModel.class, new Serializer());
            }
        }

        public ChildLocationQueryWithViewerLocationModel() {
            super(1);
        }

        public final void m20255a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20256a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final ChildLocationConnectionFieldsModel m20254a() {
            this.f16936d = (ChildLocationConnectionFieldsModel) super.a(this.f16936d, 0, ChildLocationConnectionFieldsModel.class);
            return this.f16936d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m20253a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20254a() != null) {
                ChildLocationConnectionFieldsModel childLocationConnectionFieldsModel = (ChildLocationConnectionFieldsModel) graphQLModelMutatingVisitor.b(m20254a());
                if (m20254a() != childLocationConnectionFieldsModel) {
                    graphQLVisitableModel = (ChildLocationQueryWithViewerLocationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16936d = childLocationConnectionFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20252a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20254a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 610103003)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: control_style */
    public final class ChildLocationQueryWithoutViewerLocationModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private ChildLocationConnectionFieldsModel f16937d;

        /* compiled from: control_style */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ChildLocationQueryWithoutViewerLocationModel.class, new Deserializer());
            }

            public Object m20257a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ChildLocationQueryWithoutViewerLocationParser.m20271a(jsonParser);
                Object childLocationQueryWithoutViewerLocationModel = new ChildLocationQueryWithoutViewerLocationModel();
                ((BaseModel) childLocationQueryWithoutViewerLocationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (childLocationQueryWithoutViewerLocationModel instanceof Postprocessable) {
                    return ((Postprocessable) childLocationQueryWithoutViewerLocationModel).a();
                }
                return childLocationQueryWithoutViewerLocationModel;
            }
        }

        /* compiled from: control_style */
        public class Serializer extends JsonSerializer<ChildLocationQueryWithoutViewerLocationModel> {
            public final void m20258a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ChildLocationQueryWithoutViewerLocationModel childLocationQueryWithoutViewerLocationModel = (ChildLocationQueryWithoutViewerLocationModel) obj;
                if (childLocationQueryWithoutViewerLocationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(childLocationQueryWithoutViewerLocationModel.m20259a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    childLocationQueryWithoutViewerLocationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = childLocationQueryWithoutViewerLocationModel.w_();
                int u_ = childLocationQueryWithoutViewerLocationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("child_locations");
                    ChildLocationConnectionFieldsParser.m20269a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ChildLocationQueryWithoutViewerLocationModel.class, new Serializer());
            }
        }

        public ChildLocationQueryWithoutViewerLocationModel() {
            super(1);
        }

        public final void m20262a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20263a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final ChildLocationConnectionFieldsModel m20261a() {
            this.f16937d = (ChildLocationConnectionFieldsModel) super.a(this.f16937d, 0, ChildLocationConnectionFieldsModel.class);
            return this.f16937d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m20260a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20261a() != null) {
                ChildLocationConnectionFieldsModel childLocationConnectionFieldsModel = (ChildLocationConnectionFieldsModel) graphQLModelMutatingVisitor.b(m20261a());
                if (m20261a() != childLocationConnectionFieldsModel) {
                    graphQLVisitableModel = (ChildLocationQueryWithoutViewerLocationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16937d = childLocationConnectionFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20259a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20261a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
