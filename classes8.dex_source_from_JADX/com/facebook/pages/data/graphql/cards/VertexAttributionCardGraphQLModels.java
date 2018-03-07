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
import com.facebook.graphql.enums.GraphQLAttributionSource;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.data.graphql.cards.VertexAttributionCardGraphQLParsers.VertexAttributionQueryParser;
import com.facebook.pages.data.graphql.cards.VertexAttributionCardGraphQLParsers.VertexAttributionQueryParser.AttributionParser;
import com.facebook.pages.data.graphql.cards.VertexAttributionCardGraphQLParsers.VertexAttributionQueryParser.AttributionParser.AttributionAttributionParser;
import com.facebook.pages.data.graphql.cards.VertexAttributionCardGraphQLParsers.VertexAttributionQueryParser.AttributionParser.AttributionAttributionParser.RangesParser;
import com.facebook.pages.data.graphql.cards.VertexAttributionCardGraphQLParsers.VertexAttributionQueryParser.AttributionParser.AttributionAttributionParser.RangesParser.EntityParser;
import com.facebook.pages.data.graphql.cards.VertexAttributionCardGraphQLParsers.VertexAttributionQueryParser.AttributionParser.IconParser;
import com.facebook.pages.data.graphql.cards.VertexAttributionCardGraphQLParsers.VertexAttributionQueryParser.AttributionParser.IconParser.IconImageParser;
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

/* compiled from: confirmation_resend_code_attempt */
public class VertexAttributionCardGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1614340589)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: confirmation_resend_code_attempt */
    public final class VertexAttributionQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private List<AttributionModel> f17071d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 192792638)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: confirmation_resend_code_attempt */
        public final class AttributionModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private AttributionAttributionModel f17068d;
            @Nullable
            private IconModel f17069e;
            @Nullable
            private GraphQLAttributionSource f17070f;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 981159570)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: confirmation_resend_code_attempt */
            public final class AttributionAttributionModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<RangesModel> f17062d;
                @Nullable
                private String f17063e;

                /* compiled from: confirmation_resend_code_attempt */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(AttributionAttributionModel.class, new Deserializer());
                    }

                    public Object m20767a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(AttributionAttributionParser.m20822a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object attributionAttributionModel = new AttributionAttributionModel();
                        ((BaseModel) attributionAttributionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (attributionAttributionModel instanceof Postprocessable) {
                            return ((Postprocessable) attributionAttributionModel).a();
                        }
                        return attributionAttributionModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -2138855080)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: confirmation_resend_code_attempt */
                public final class RangesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private EntityModel f17059d;
                    private int f17060e;
                    private int f17061f;

                    /* compiled from: confirmation_resend_code_attempt */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(RangesModel.class, new Deserializer());
                        }

                        public Object m20768a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(RangesParser.m20820b(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object rangesModel = new RangesModel();
                            ((BaseModel) rangesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (rangesModel instanceof Postprocessable) {
                                return ((Postprocessable) rangesModel).a();
                            }
                            return rangesModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -1205772718)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: confirmation_resend_code_attempt */
                    public final class EntityModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private GraphQLObjectType f17057d;
                        @Nullable
                        private String f17058e;

                        /* compiled from: confirmation_resend_code_attempt */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(EntityModel.class, new Deserializer());
                            }

                            public Object m20769a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(EntityParser.m20818a(jsonParser, flatBufferBuilder));
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

                        /* compiled from: confirmation_resend_code_attempt */
                        public class Serializer extends JsonSerializer<EntityModel> {
                            public final void m20770a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                EntityModel entityModel = (EntityModel) obj;
                                if (entityModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(entityModel.m20771a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    entityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                EntityParser.m20819a(entityModel.w_(), entityModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(EntityModel.class, new Serializer());
                            }
                        }

                        public EntityModel() {
                            super(2);
                        }

                        @Nullable
                        public final GraphQLObjectType m20772a() {
                            if (this.b != null && this.f17057d == null) {
                                this.f17057d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                            }
                            return this.f17057d;
                        }

                        @Nullable
                        public final String m20774b() {
                            this.f17058e = super.a(this.f17058e, 1);
                            return this.f17058e;
                        }

                        public final int jK_() {
                            return 2080559107;
                        }

                        public final GraphQLVisitableModel m20773a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m20771a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m20772a());
                            int b = flatBufferBuilder.b(m20774b());
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.b(1, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: confirmation_resend_code_attempt */
                    public class Serializer extends JsonSerializer<RangesModel> {
                        public final void m20775a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            RangesModel rangesModel = (RangesModel) obj;
                            if (rangesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(rangesModel.m20777a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                rangesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            RangesParser.m20821b(rangesModel.w_(), rangesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(RangesModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ EntityModel m20779a() {
                        return m20776j();
                    }

                    public RangesModel() {
                        super(3);
                    }

                    @Nullable
                    private EntityModel m20776j() {
                        this.f17059d = (EntityModel) super.a(this.f17059d, 0, EntityModel.class);
                        return this.f17059d;
                    }

                    public final int m20781b() {
                        a(0, 1);
                        return this.f17060e;
                    }

                    public final int m20782c() {
                        a(0, 2);
                        return this.f17061f;
                    }

                    public final int jK_() {
                        return -1024511161;
                    }

                    public final GraphQLVisitableModel m20778a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m20776j() != null) {
                            EntityModel entityModel = (EntityModel) graphQLModelMutatingVisitor.b(m20776j());
                            if (m20776j() != entityModel) {
                                graphQLVisitableModel = (RangesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f17059d = entityModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m20777a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m20776j());
                        flatBufferBuilder.c(3);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.a(1, this.f17060e, 0);
                        flatBufferBuilder.a(2, this.f17061f, 0);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m20780a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f17060e = mutableFlatBuffer.a(i, 1, 0);
                        this.f17061f = mutableFlatBuffer.a(i, 2, 0);
                    }
                }

                /* compiled from: confirmation_resend_code_attempt */
                public class Serializer extends JsonSerializer<AttributionAttributionModel> {
                    public final void m20783a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        AttributionAttributionModel attributionAttributionModel = (AttributionAttributionModel) obj;
                        if (attributionAttributionModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(attributionAttributionModel.m20784a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            attributionAttributionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        AttributionAttributionParser.m20823a(attributionAttributionModel.w_(), attributionAttributionModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(AttributionAttributionModel.class, new Serializer());
                    }
                }

                public AttributionAttributionModel() {
                    super(2);
                }

                @Nonnull
                public final ImmutableList<RangesModel> m20786a() {
                    this.f17062d = super.a(this.f17062d, 0, RangesModel.class);
                    return (ImmutableList) this.f17062d;
                }

                @Nullable
                public final String m20787b() {
                    this.f17063e = super.a(this.f17063e, 1);
                    return this.f17063e;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m20785a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m20786a() != null) {
                        Builder a = ModelHelper.a(m20786a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (AttributionAttributionModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f17062d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m20784a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m20786a());
                    int b = flatBufferBuilder.b(m20787b());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: confirmation_resend_code_attempt */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AttributionModel.class, new Deserializer());
                }

                public Object m20788a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AttributionParser.m20828b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object attributionModel = new AttributionModel();
                    ((BaseModel) attributionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (attributionModel instanceof Postprocessable) {
                        return ((Postprocessable) attributionModel).a();
                    }
                    return attributionModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1852918713)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: confirmation_resend_code_attempt */
            public final class IconModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private IconImageModel f17067d;

                /* compiled from: confirmation_resend_code_attempt */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(IconModel.class, new Deserializer());
                    }

                    public Object m20789a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(IconParser.m20826a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object iconModel = new IconModel();
                        ((BaseModel) iconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (iconModel instanceof Postprocessable) {
                            return ((Postprocessable) iconModel).a();
                        }
                        return iconModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 729935302)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: confirmation_resend_code_attempt */
                public final class IconImageModel extends BaseModel implements GraphQLVisitableModel {
                    private int f17064d;
                    @Nullable
                    private String f17065e;
                    private int f17066f;

                    /* compiled from: confirmation_resend_code_attempt */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(IconImageModel.class, new Deserializer());
                        }

                        public Object m20790a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(IconImageParser.m20824a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object iconImageModel = new IconImageModel();
                            ((BaseModel) iconImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (iconImageModel instanceof Postprocessable) {
                                return ((Postprocessable) iconImageModel).a();
                            }
                            return iconImageModel;
                        }
                    }

                    /* compiled from: confirmation_resend_code_attempt */
                    public class Serializer extends JsonSerializer<IconImageModel> {
                        public final void m20791a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            IconImageModel iconImageModel = (IconImageModel) obj;
                            if (iconImageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(iconImageModel.m20793a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                iconImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            IconImageParser.m20825a(iconImageModel.w_(), iconImageModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(IconImageModel.class, new Serializer());
                        }
                    }

                    public IconImageModel() {
                        super(3);
                    }

                    public final int m20792a() {
                        a(0, 0);
                        return this.f17064d;
                    }

                    @Nullable
                    public final String m20796b() {
                        this.f17065e = super.a(this.f17065e, 1);
                        return this.f17065e;
                    }

                    public final int m20797c() {
                        a(0, 2);
                        return this.f17066f;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m20794a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m20793a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m20796b());
                        flatBufferBuilder.c(3);
                        flatBufferBuilder.a(0, this.f17064d, 0);
                        flatBufferBuilder.b(1, b);
                        flatBufferBuilder.a(2, this.f17066f, 0);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m20795a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f17064d = mutableFlatBuffer.a(i, 0, 0);
                        this.f17066f = mutableFlatBuffer.a(i, 2, 0);
                    }
                }

                /* compiled from: confirmation_resend_code_attempt */
                public class Serializer extends JsonSerializer<IconModel> {
                    public final void m20798a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        IconModel iconModel = (IconModel) obj;
                        if (iconModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(iconModel.m20800a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            iconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        IconParser.m20827a(iconModel.w_(), iconModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(IconModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ IconImageModel m20802a() {
                    return m20799j();
                }

                public IconModel() {
                    super(1);
                }

                @Nullable
                private IconImageModel m20799j() {
                    this.f17067d = (IconImageModel) super.a(this.f17067d, 0, IconImageModel.class);
                    return this.f17067d;
                }

                public final int jK_() {
                    return 1667242696;
                }

                public final GraphQLVisitableModel m20801a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m20799j() != null) {
                        IconImageModel iconImageModel = (IconImageModel) graphQLModelMutatingVisitor.b(m20799j());
                        if (m20799j() != iconImageModel) {
                            graphQLVisitableModel = (IconModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f17067d = iconImageModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m20800a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m20799j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: confirmation_resend_code_attempt */
            public class Serializer extends JsonSerializer<AttributionModel> {
                public final void m20803a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AttributionModel attributionModel = (AttributionModel) obj;
                    if (attributionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(attributionModel.m20806a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        attributionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AttributionParser.m20829b(attributionModel.w_(), attributionModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AttributionModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ AttributionAttributionModel m20808a() {
                return m20804j();
            }

            @Nullable
            public final /* synthetic */ IconModel m20809b() {
                return m20805k();
            }

            public AttributionModel() {
                super(3);
            }

            @Nullable
            private AttributionAttributionModel m20804j() {
                this.f17068d = (AttributionAttributionModel) super.a(this.f17068d, 0, AttributionAttributionModel.class);
                return this.f17068d;
            }

            @Nullable
            private IconModel m20805k() {
                this.f17069e = (IconModel) super.a(this.f17069e, 1, IconModel.class);
                return this.f17069e;
            }

            @Nullable
            public final GraphQLAttributionSource m20810c() {
                this.f17070f = (GraphQLAttributionSource) super.b(this.f17070f, 2, GraphQLAttributionSource.class, GraphQLAttributionSource.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f17070f;
            }

            public final int jK_() {
                return -751942829;
            }

            public final GraphQLVisitableModel m20807a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m20804j() != null) {
                    AttributionAttributionModel attributionAttributionModel = (AttributionAttributionModel) graphQLModelMutatingVisitor.b(m20804j());
                    if (m20804j() != attributionAttributionModel) {
                        graphQLVisitableModel = (AttributionModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17068d = attributionAttributionModel;
                    }
                }
                if (m20805k() != null) {
                    IconModel iconModel = (IconModel) graphQLModelMutatingVisitor.b(m20805k());
                    if (m20805k() != iconModel) {
                        graphQLVisitableModel = (AttributionModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f17069e = iconModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m20806a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20804j());
                int a2 = ModelHelper.a(flatBufferBuilder, m20805k());
                int a3 = flatBufferBuilder.a(m20810c());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: confirmation_resend_code_attempt */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(VertexAttributionQueryModel.class, new Deserializer());
            }

            public Object m20811a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(VertexAttributionQueryParser.m20830a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object vertexAttributionQueryModel = new VertexAttributionQueryModel();
                ((BaseModel) vertexAttributionQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (vertexAttributionQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) vertexAttributionQueryModel).a();
                }
                return vertexAttributionQueryModel;
            }
        }

        /* compiled from: confirmation_resend_code_attempt */
        public class Serializer extends JsonSerializer<VertexAttributionQueryModel> {
            public final void m20812a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                VertexAttributionQueryModel vertexAttributionQueryModel = (VertexAttributionQueryModel) obj;
                if (vertexAttributionQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(vertexAttributionQueryModel.m20813a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    vertexAttributionQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = vertexAttributionQueryModel.w_();
                int u_ = vertexAttributionQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("attribution");
                    jsonGenerator.d();
                    for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                        AttributionParser.m20829b(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(VertexAttributionQueryModel.class, new Serializer());
            }
        }

        public VertexAttributionQueryModel() {
            super(1);
        }

        public final void m20816a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20817a(String str, Object obj, boolean z) {
        }

        @Nonnull
        public final ImmutableList<AttributionModel> m20815a() {
            this.f17071d = super.a(this.f17071d, 0, AttributionModel.class);
            return (ImmutableList) this.f17071d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m20814a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20815a() != null) {
                Builder a = ModelHelper.a(m20815a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (VertexAttributionQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17071d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20813a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20815a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
