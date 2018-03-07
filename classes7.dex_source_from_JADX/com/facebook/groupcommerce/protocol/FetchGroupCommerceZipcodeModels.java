package com.facebook.groupcommerce.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLPageCategoryType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groupcommerce.protocol.FetchGroupCommerceZipcodeParsers.StructuredLocationZipcodeQueryParser;
import com.facebook.groupcommerce.protocol.FetchGroupCommerceZipcodeParsers.StructuredLocationZipcodeQueryParser.GroupCommerceSuggestedLocationParser;
import com.facebook.groupcommerce.protocol.FetchGroupCommerceZipcodeParsers.StructuredLocationZipcodeQueryParser.GroupCommerceSuggestedLocationParser.LocationParser;
import com.facebook.groupcommerce.protocol.FetchGroupCommerceZipcodeParsers.StructuredLocationZipcodeQueryParser.GroupCommerceSuggestedLocationParser.LocationParser.ReverseGeocodeDetailedParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: recommendation_unlike_fail */
public class FetchGroupCommerceZipcodeModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 76033179)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: recommendation_unlike_fail */
    public final class StructuredLocationZipcodeQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GroupCommerceSuggestedLocationModel f5387d;

        /* compiled from: recommendation_unlike_fail */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StructuredLocationZipcodeQueryModel.class, new Deserializer());
            }

            public Object m5863a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = StructuredLocationZipcodeQueryParser.m5894a(jsonParser);
                Object structuredLocationZipcodeQueryModel = new StructuredLocationZipcodeQueryModel();
                ((BaseModel) structuredLocationZipcodeQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (structuredLocationZipcodeQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) structuredLocationZipcodeQueryModel).a();
                }
                return structuredLocationZipcodeQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1205130918)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: recommendation_unlike_fail */
        public final class GroupCommerceSuggestedLocationModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLPageCategoryType f5384d;
            @Nullable
            private String f5385e;
            @Nullable
            private LocationModel f5386f;

            /* compiled from: recommendation_unlike_fail */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupCommerceSuggestedLocationModel.class, new Deserializer());
                }

                public Object m5864a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupCommerceSuggestedLocationParser.m5892a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupCommerceSuggestedLocationModel = new GroupCommerceSuggestedLocationModel();
                    ((BaseModel) groupCommerceSuggestedLocationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupCommerceSuggestedLocationModel instanceof Postprocessable) {
                        return ((Postprocessable) groupCommerceSuggestedLocationModel).a();
                    }
                    return groupCommerceSuggestedLocationModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1766331106)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: recommendation_unlike_fail */
            public final class LocationModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private ReverseGeocodeDetailedModel f5383d;

                /* compiled from: recommendation_unlike_fail */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(LocationModel.class, new Deserializer());
                    }

                    public Object m5865a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(LocationParser.m5890a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object locationModel = new LocationModel();
                        ((BaseModel) locationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (locationModel instanceof Postprocessable) {
                            return ((Postprocessable) locationModel).a();
                        }
                        return locationModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -2144345651)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: recommendation_unlike_fail */
                public final class ReverseGeocodeDetailedModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f5382d;

                    /* compiled from: recommendation_unlike_fail */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ReverseGeocodeDetailedModel.class, new Deserializer());
                        }

                        public Object m5866a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ReverseGeocodeDetailedParser.m5888a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object reverseGeocodeDetailedModel = new ReverseGeocodeDetailedModel();
                            ((BaseModel) reverseGeocodeDetailedModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (reverseGeocodeDetailedModel instanceof Postprocessable) {
                                return ((Postprocessable) reverseGeocodeDetailedModel).a();
                            }
                            return reverseGeocodeDetailedModel;
                        }
                    }

                    /* compiled from: recommendation_unlike_fail */
                    public class Serializer extends JsonSerializer<ReverseGeocodeDetailedModel> {
                        public final void m5867a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ReverseGeocodeDetailedModel reverseGeocodeDetailedModel = (ReverseGeocodeDetailedModel) obj;
                            if (reverseGeocodeDetailedModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(reverseGeocodeDetailedModel.m5868a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                reverseGeocodeDetailedModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ReverseGeocodeDetailedParser.m5889a(reverseGeocodeDetailedModel.w_(), reverseGeocodeDetailedModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ReverseGeocodeDetailedModel.class, new Serializer());
                        }
                    }

                    public ReverseGeocodeDetailedModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m5870a() {
                        this.f5382d = super.a(this.f5382d, 0);
                        return this.f5382d;
                    }

                    public final int jK_() {
                        return -1148071578;
                    }

                    public final GraphQLVisitableModel m5869a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m5868a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m5870a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: recommendation_unlike_fail */
                public class Serializer extends JsonSerializer<LocationModel> {
                    public final void m5871a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        LocationModel locationModel = (LocationModel) obj;
                        if (locationModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(locationModel.m5872a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            locationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        LocationParser.m5891a(locationModel.w_(), locationModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(LocationModel.class, new Serializer());
                    }
                }

                public LocationModel() {
                    super(1);
                }

                @Nullable
                public final ReverseGeocodeDetailedModel m5874a() {
                    this.f5383d = (ReverseGeocodeDetailedModel) super.a(this.f5383d, 0, ReverseGeocodeDetailedModel.class);
                    return this.f5383d;
                }

                public final int jK_() {
                    return 1965687765;
                }

                public final GraphQLVisitableModel m5873a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m5874a() != null) {
                        ReverseGeocodeDetailedModel reverseGeocodeDetailedModel = (ReverseGeocodeDetailedModel) graphQLModelMutatingVisitor.b(m5874a());
                        if (m5874a() != reverseGeocodeDetailedModel) {
                            graphQLVisitableModel = (LocationModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f5383d = reverseGeocodeDetailedModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m5872a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m5874a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: recommendation_unlike_fail */
            public class Serializer extends JsonSerializer<GroupCommerceSuggestedLocationModel> {
                public final void m5875a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupCommerceSuggestedLocationModel groupCommerceSuggestedLocationModel = (GroupCommerceSuggestedLocationModel) obj;
                    if (groupCommerceSuggestedLocationModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupCommerceSuggestedLocationModel.m5878a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupCommerceSuggestedLocationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupCommerceSuggestedLocationParser.m5893a(groupCommerceSuggestedLocationModel.w_(), groupCommerceSuggestedLocationModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupCommerceSuggestedLocationModel.class, new Serializer());
                }
            }

            public GroupCommerceSuggestedLocationModel() {
                super(3);
            }

            public final void m5881a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m5882a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLPageCategoryType m5876k() {
                this.f5384d = (GraphQLPageCategoryType) super.b(this.f5384d, 0, GraphQLPageCategoryType.class, GraphQLPageCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f5384d;
            }

            @Nullable
            private String m5877l() {
                this.f5385e = super.a(this.f5385e, 1);
                return this.f5385e;
            }

            @Nullable
            public final LocationModel m5883j() {
                this.f5386f = (LocationModel) super.a(this.f5386f, 2, LocationModel.class);
                return this.f5386f;
            }

            @Nullable
            public final String m5880a() {
                return m5877l();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m5879a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5883j() != null) {
                    LocationModel locationModel = (LocationModel) graphQLModelMutatingVisitor.b(m5883j());
                    if (m5883j() != locationModel) {
                        graphQLVisitableModel = (GroupCommerceSuggestedLocationModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5386f = locationModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5878a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(m5876k());
                int b = flatBufferBuilder.b(m5877l());
                int a2 = ModelHelper.a(flatBufferBuilder, m5883j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: recommendation_unlike_fail */
        public class Serializer extends JsonSerializer<StructuredLocationZipcodeQueryModel> {
            public final void m5884a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                StructuredLocationZipcodeQueryModel structuredLocationZipcodeQueryModel = (StructuredLocationZipcodeQueryModel) obj;
                if (structuredLocationZipcodeQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(structuredLocationZipcodeQueryModel.m5885a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    structuredLocationZipcodeQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = structuredLocationZipcodeQueryModel.w_();
                int u_ = structuredLocationZipcodeQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group_commerce_suggested_location");
                    GroupCommerceSuggestedLocationParser.m5893a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(StructuredLocationZipcodeQueryModel.class, new Serializer());
            }
        }

        public StructuredLocationZipcodeQueryModel() {
            super(1);
        }

        @Nullable
        public final GroupCommerceSuggestedLocationModel m5887a() {
            this.f5387d = (GroupCommerceSuggestedLocationModel) super.a(this.f5387d, 0, GroupCommerceSuggestedLocationModel.class);
            return this.f5387d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m5886a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5887a() != null) {
                GroupCommerceSuggestedLocationModel groupCommerceSuggestedLocationModel = (GroupCommerceSuggestedLocationModel) graphQLModelMutatingVisitor.b(m5887a());
                if (m5887a() != groupCommerceSuggestedLocationModel) {
                    graphQLVisitableModel = (StructuredLocationZipcodeQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5387d = groupCommerceSuggestedLocationModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5885a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5887a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
