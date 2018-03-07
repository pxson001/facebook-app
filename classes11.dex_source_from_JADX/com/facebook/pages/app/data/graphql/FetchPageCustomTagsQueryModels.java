package com.facebook.pages.app.data.graphql;

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
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.app.data.graphql.FetchPageCustomTagsQueryParsers.FetchPageTagsParser;
import com.facebook.pages.app.data.graphql.FetchPageCustomTagsQueryParsers.FetchPageTagsParser.CustomTagsParser;
import com.facebook.pages.app.data.graphql.FetchPageCustomTagsQueryParsers.FetchPageTagsParser.CustomTagsParser.NodesParser;
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

/* compiled from: tapped_unlike_page_on_landing */
public class FetchPageCustomTagsQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 24218423)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: tapped_unlike_page_on_landing */
    public final class FetchPageTagsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f1118d;
        @Nullable
        private CustomTagsModel f1119e;
        @Nullable
        private String f1120f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1335601081)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: tapped_unlike_page_on_landing */
        public final class CustomTagsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f1117d;

            /* compiled from: tapped_unlike_page_on_landing */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CustomTagsModel.class, new Deserializer());
                }

                public Object m1437a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CustomTagsParser.m1469a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object customTagsModel = new CustomTagsModel();
                    ((BaseModel) customTagsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (customTagsModel instanceof Postprocessable) {
                        return ((Postprocessable) customTagsModel).a();
                    }
                    return customTagsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 685646730)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: tapped_unlike_page_on_landing */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f1112d;
                @Nullable
                private String f1113e;
                @Nullable
                private String f1114f;
                @Nullable
                private String f1115g;
                @Nullable
                private String f1116h;

                /* compiled from: tapped_unlike_page_on_landing */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m1438a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m1468b(jsonParser, flatBufferBuilder));
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

                /* compiled from: tapped_unlike_page_on_landing */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m1439a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m1448a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m1467a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(5);
                }

                public final void m1451a(String str, ConsistencyTuple consistencyTuple) {
                    if ("border_color".equals(str)) {
                        consistencyTuple.a = m1443j();
                        consistencyTuple.b = u_();
                        consistencyTuple.c = 0;
                    } else if ("color".equals(str)) {
                        consistencyTuple.a = m1444k();
                        consistencyTuple.b = u_();
                        consistencyTuple.c = 1;
                    } else if ("fill_color".equals(str)) {
                        consistencyTuple.a = m1445l();
                        consistencyTuple.b = u_();
                        consistencyTuple.c = 2;
                    } else {
                        consistencyTuple.a();
                    }
                }

                public final void m1452a(String str, Object obj, boolean z) {
                    if ("border_color".equals(str)) {
                        m1440a((String) obj);
                    } else if ("color".equals(str)) {
                        m1441b((String) obj);
                    } else if ("fill_color".equals(str)) {
                        m1442c((String) obj);
                    }
                }

                @Nullable
                private String m1443j() {
                    this.f1112d = super.a(this.f1112d, 0);
                    return this.f1112d;
                }

                private void m1440a(@Nullable String str) {
                    this.f1112d = str;
                    if (this.b != null && this.b.d) {
                        this.b.a(this.c, 0, str);
                    }
                }

                @Nullable
                private String m1444k() {
                    this.f1113e = super.a(this.f1113e, 1);
                    return this.f1113e;
                }

                private void m1441b(@Nullable String str) {
                    this.f1113e = str;
                    if (this.b != null && this.b.d) {
                        this.b.a(this.c, 1, str);
                    }
                }

                @Nullable
                private String m1445l() {
                    this.f1114f = super.a(this.f1114f, 2);
                    return this.f1114f;
                }

                private void m1442c(@Nullable String str) {
                    this.f1114f = str;
                    if (this.b != null && this.b.d) {
                        this.b.a(this.c, 2, str);
                    }
                }

                @Nullable
                private String m1446m() {
                    this.f1115g = super.a(this.f1115g, 3);
                    return this.f1115g;
                }

                @Nullable
                private String m1447n() {
                    this.f1116h = super.a(this.f1116h, 4);
                    return this.f1116h;
                }

                @Nullable
                public final String m1450a() {
                    return m1446m();
                }

                public final int jK_() {
                    return -1816160134;
                }

                public final GraphQLVisitableModel m1449a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m1448a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m1443j());
                    int b2 = flatBufferBuilder.b(m1444k());
                    int b3 = flatBufferBuilder.b(m1445l());
                    int b4 = flatBufferBuilder.b(m1446m());
                    int b5 = flatBufferBuilder.b(m1447n());
                    flatBufferBuilder.c(5);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    flatBufferBuilder.b(2, b3);
                    flatBufferBuilder.b(3, b4);
                    flatBufferBuilder.b(4, b5);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: tapped_unlike_page_on_landing */
            public class Serializer extends JsonSerializer<CustomTagsModel> {
                public final void m1453a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CustomTagsModel customTagsModel = (CustomTagsModel) obj;
                    if (customTagsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(customTagsModel.m1455a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        customTagsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CustomTagsParser.m1470a(customTagsModel.w_(), customTagsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CustomTagsModel.class, new Serializer());
                }
            }

            public CustomTagsModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<NodesModel> m1454a() {
                this.f1117d = super.a(this.f1117d, 0, NodesModel.class);
                return (ImmutableList) this.f1117d;
            }

            public final int jK_() {
                return 1057808119;
            }

            public final GraphQLVisitableModel m1456a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1454a() != null) {
                    Builder a = ModelHelper.a(m1454a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (CustomTagsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1117d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1455a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1454a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: tapped_unlike_page_on_landing */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchPageTagsModel.class, new Deserializer());
            }

            public Object m1457a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchPageTagsParser.m1471a(jsonParser);
                Object fetchPageTagsModel = new FetchPageTagsModel();
                ((BaseModel) fetchPageTagsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchPageTagsModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchPageTagsModel).a();
                }
                return fetchPageTagsModel;
            }
        }

        /* compiled from: tapped_unlike_page_on_landing */
        public class Serializer extends JsonSerializer<FetchPageTagsModel> {
            public final void m1458a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchPageTagsModel fetchPageTagsModel = (FetchPageTagsModel) obj;
                if (fetchPageTagsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchPageTagsModel.m1462a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchPageTagsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchPageTagsModel.w_();
                int u_ = fetchPageTagsModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("custom_tags");
                    CustomTagsParser.m1470a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchPageTagsModel.class, new Serializer());
            }
        }

        public FetchPageTagsModel() {
            super(3);
        }

        public final void m1465a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m1466a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m1459j() {
            if (this.b != null && this.f1118d == null) {
                this.f1118d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f1118d;
        }

        @Nullable
        private CustomTagsModel m1460k() {
            this.f1119e = (CustomTagsModel) super.a(this.f1119e, 1, CustomTagsModel.class);
            return this.f1119e;
        }

        @Nullable
        private String m1461l() {
            this.f1120f = super.a(this.f1120f, 2);
            return this.f1120f;
        }

        @Nullable
        public final String m1464a() {
            return m1461l();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m1463a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1460k() != null) {
                CustomTagsModel customTagsModel = (CustomTagsModel) graphQLModelMutatingVisitor.b(m1460k());
                if (m1460k() != customTagsModel) {
                    graphQLVisitableModel = (FetchPageTagsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1119e = customTagsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1462a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1459j());
            int a2 = ModelHelper.a(flatBufferBuilder, m1460k());
            int b = flatBufferBuilder.b(m1461l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
