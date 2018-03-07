package com.facebook.search.protocol.nullstate;

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
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.protocol.nullstate.C0922x2ae50003.SuggestionsParser;
import com.facebook.search.protocol.nullstate.C0922x2ae50003.SuggestionsParser.EntityParser;
import com.facebook.search.protocol.nullstate.C0922x2ae50003.SuggestionsParser.ImageParser;
import com.facebook.search.protocol.nullstate.C0922x2ae50003.SuggestionsParser.QueryParser;
import com.facebook.search.protocol.nullstate.C0922x2ae50003.SuggestionsParser.QueryParser.QueryTitleParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -697275349)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: multi_photo_attachment */
public final class C0919xbd29c99b extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private EntityModel f8294d;
    private boolean f8295e;
    @Nullable
    private ImageModel f8296f;
    @Nullable
    private QueryModel f8297g;
    @Nullable
    private String f8298h;
    @Nullable
    private String f8299i;
    @Nullable
    private String f8300j;
    @Nullable
    private String f8301k;
    @Nullable
    private String f8302l;
    @Nullable
    private String f8303m;

    /* compiled from: multi_photo_attachment */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0919xbd29c99b.class, new Deserializer());
        }

        public Object m9429a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(SuggestionsParser.m9481b(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0919xbd29c99b = new C0919xbd29c99b();
            ((BaseModel) c0919xbd29c99b).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0919xbd29c99b instanceof Postprocessable) {
                return ((Postprocessable) c0919xbd29c99b).a();
            }
            return c0919xbd29c99b;
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1072676332)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: multi_photo_attachment */
    public final class EntityModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f8287d;
        @Nullable
        private String f8288e;
        @Nullable
        private String f8289f;

        /* compiled from: multi_photo_attachment */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EntityModel.class, new Deserializer());
            }

            public Object m9430a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(EntityParser.m9472a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object entityModel = new EntityModel();
                ((BaseModel) entityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (entityModel instanceof Postprocessable) {
                    return ((Postprocessable) entityModel).a();
                }
                return entityModel;
            }
        }

        /* compiled from: multi_photo_attachment */
        public class Serializer extends JsonSerializer<EntityModel> {
            public final void m9431a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                EntityModel entityModel = (EntityModel) obj;
                if (entityModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(entityModel.m9433a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    entityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                EntityParser.m9473a(entityModel.w_(), entityModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(EntityModel.class, new Serializer());
            }
        }

        public EntityModel() {
            super(3);
        }

        public final void m9436a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m9437a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m9432l() {
            if (this.b != null && this.f8287d == null) {
                this.f8287d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f8287d;
        }

        @Nullable
        public final String m9438j() {
            this.f8288e = super.a(this.f8288e, 1);
            return this.f8288e;
        }

        @Nullable
        public final String m9439k() {
            this.f8289f = super.a(this.f8289f, 2);
            return this.f8289f;
        }

        @Nullable
        public final String m9435a() {
            return m9438j();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m9434a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m9433a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9432l());
            int b = flatBufferBuilder.b(m9438j());
            int b2 = flatBufferBuilder.b(m9439k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 842551240)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: multi_photo_attachment */
    public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f8290d;

        /* compiled from: multi_photo_attachment */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
            }

            public Object m9440a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ImageParser.m9474a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object imageModel = new ImageModel();
                ((BaseModel) imageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (imageModel instanceof Postprocessable) {
                    return ((Postprocessable) imageModel).a();
                }
                return imageModel;
            }
        }

        /* compiled from: multi_photo_attachment */
        public class Serializer extends JsonSerializer<ImageModel> {
            public final void m9441a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ImageModel imageModel = (ImageModel) obj;
                if (imageModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(imageModel.m9442a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ImageParser.m9475a(imageModel.w_(), imageModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(ImageModel.class, new Serializer());
            }
        }

        public ImageModel() {
            super(1);
        }

        @Nullable
        public final String m9444a() {
            this.f8290d = super.a(this.f8290d, 0);
            return this.f8290d;
        }

        public final int jK_() {
            return 70760763;
        }

        public final GraphQLVisitableModel m9443a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m9442a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m9444a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1070564086)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: multi_photo_attachment */
    public final class QueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f8292d;
        @Nullable
        private QueryTitleModel f8293e;

        /* compiled from: multi_photo_attachment */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(QueryModel.class, new Deserializer());
            }

            public Object m9445a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(QueryParser.m9478a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object queryModel = new QueryModel();
                ((BaseModel) queryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (queryModel instanceof Postprocessable) {
                    return ((Postprocessable) queryModel).a();
                }
                return queryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: multi_photo_attachment */
        public final class QueryTitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8291d;

            /* compiled from: multi_photo_attachment */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(QueryTitleModel.class, new Deserializer());
                }

                public Object m9446a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(QueryTitleParser.m9476a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object queryTitleModel = new QueryTitleModel();
                    ((BaseModel) queryTitleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (queryTitleModel instanceof Postprocessable) {
                        return ((Postprocessable) queryTitleModel).a();
                    }
                    return queryTitleModel;
                }
            }

            /* compiled from: multi_photo_attachment */
            public class Serializer extends JsonSerializer<QueryTitleModel> {
                public final void m9447a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    QueryTitleModel queryTitleModel = (QueryTitleModel) obj;
                    if (queryTitleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(queryTitleModel.m9448a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        queryTitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    QueryTitleParser.m9477a(queryTitleModel.w_(), queryTitleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(QueryTitleModel.class, new Serializer());
                }
            }

            public QueryTitleModel() {
                super(1);
            }

            @Nullable
            public final String m9450a() {
                this.f8291d = super.a(this.f8291d, 0);
                return this.f8291d;
            }

            public final int jK_() {
                return -1696096378;
            }

            public final GraphQLVisitableModel m9449a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m9448a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m9450a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: multi_photo_attachment */
        public class Serializer extends JsonSerializer<QueryModel> {
            public final void m9451a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                QueryModel queryModel = (QueryModel) obj;
                if (queryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(queryModel.m9452a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    queryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                QueryParser.m9479a(queryModel.w_(), queryModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(QueryModel.class, new Serializer());
            }
        }

        public QueryModel() {
            super(2);
        }

        @Nullable
        public final String m9454a() {
            this.f8292d = super.a(this.f8292d, 0);
            return this.f8292d;
        }

        @Nullable
        public final QueryTitleModel m9455j() {
            this.f8293e = (QueryTitleModel) super.a(this.f8293e, 1, QueryTitleModel.class);
            return this.f8293e;
        }

        public final int jK_() {
            return -466486798;
        }

        public final GraphQLVisitableModel m9453a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9455j() != null) {
                QueryTitleModel queryTitleModel = (QueryTitleModel) graphQLModelMutatingVisitor.b(m9455j());
                if (m9455j() != queryTitleModel) {
                    graphQLVisitableModel = (QueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8293e = queryTitleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9452a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m9454a());
            int a = ModelHelper.a(flatBufferBuilder, m9455j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    /* compiled from: multi_photo_attachment */
    public class Serializer extends JsonSerializer<C0919xbd29c99b> {
        public final void m9456a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0919xbd29c99b c0919xbd29c99b = (C0919xbd29c99b) obj;
            if (c0919xbd29c99b.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0919xbd29c99b.m9457a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0919xbd29c99b.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            SuggestionsParser.m9482b(c0919xbd29c99b.w_(), c0919xbd29c99b.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(C0919xbd29c99b.class, new Serializer());
        }
    }

    public C0919xbd29c99b() {
        super(10);
    }

    @Nullable
    public final EntityModel m9459a() {
        this.f8294d = (EntityModel) super.a(this.f8294d, 0, EntityModel.class);
        return this.f8294d;
    }

    public final boolean m9461j() {
        a(0, 1);
        return this.f8295e;
    }

    @Nullable
    public final ImageModel m9462k() {
        this.f8296f = (ImageModel) super.a(this.f8296f, 2, ImageModel.class);
        return this.f8296f;
    }

    @Nullable
    public final QueryModel m9463l() {
        this.f8297g = (QueryModel) super.a(this.f8297g, 3, QueryModel.class);
        return this.f8297g;
    }

    @Nullable
    public final String m9464m() {
        this.f8298h = super.a(this.f8298h, 4);
        return this.f8298h;
    }

    @Nullable
    public final String m9465n() {
        this.f8299i = super.a(this.f8299i, 5);
        return this.f8299i;
    }

    @Nullable
    public final String m9466o() {
        this.f8300j = super.a(this.f8300j, 6);
        return this.f8300j;
    }

    @Nullable
    public final String m9467p() {
        this.f8301k = super.a(this.f8301k, 7);
        return this.f8301k;
    }

    @Nullable
    public final String m9468q() {
        this.f8302l = super.a(this.f8302l, 8);
        return this.f8302l;
    }

    @Nullable
    public final String m9469r() {
        this.f8303m = super.a(this.f8303m, 9);
        return this.f8303m;
    }

    public final int jK_() {
        return 1928432792;
    }

    public final GraphQLVisitableModel m9458a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m9459a() != null) {
            EntityModel entityModel = (EntityModel) graphQLModelMutatingVisitor.b(m9459a());
            if (m9459a() != entityModel) {
                graphQLVisitableModel = (C0919xbd29c99b) ModelHelper.a(null, this);
                graphQLVisitableModel.f8294d = entityModel;
            }
        }
        if (m9462k() != null) {
            ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m9462k());
            if (m9462k() != imageModel) {
                graphQLVisitableModel = (C0919xbd29c99b) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f8296f = imageModel;
            }
        }
        if (m9463l() != null) {
            QueryModel queryModel = (QueryModel) graphQLModelMutatingVisitor.b(m9463l());
            if (m9463l() != queryModel) {
                graphQLVisitableModel = (C0919xbd29c99b) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f8297g = queryModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m9457a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m9459a());
        int a2 = ModelHelper.a(flatBufferBuilder, m9462k());
        int a3 = ModelHelper.a(flatBufferBuilder, m9463l());
        int b = flatBufferBuilder.b(m9464m());
        int b2 = flatBufferBuilder.b(m9465n());
        int b3 = flatBufferBuilder.b(m9466o());
        int b4 = flatBufferBuilder.b(m9467p());
        int b5 = flatBufferBuilder.b(m9468q());
        int b6 = flatBufferBuilder.b(m9469r());
        flatBufferBuilder.c(10);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.a(1, this.f8295e);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(4, b);
        flatBufferBuilder.b(5, b2);
        flatBufferBuilder.b(6, b3);
        flatBufferBuilder.b(7, b4);
        flatBufferBuilder.b(8, b5);
        flatBufferBuilder.b(9, b6);
        i();
        return flatBufferBuilder.d();
    }

    public final void m9460a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f8295e = mutableFlatBuffer.a(i, 1);
    }
}
