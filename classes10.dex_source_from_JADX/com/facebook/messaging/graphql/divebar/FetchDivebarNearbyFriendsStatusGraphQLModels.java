package com.facebook.messaging.graphql.divebar;

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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.graphql.divebar.FetchDivebarNearbyFriendsStatusGraphQLParsers.DivebarNearbyFriendsStatusQueryParser;
import com.facebook.messaging.graphql.divebar.FetchDivebarNearbyFriendsStatusGraphQLParsers.LocationSharingFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: size_medium */
public class FetchDivebarNearbyFriendsStatusGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1540036005)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: size_medium */
    public final class DivebarNearbyFriendsStatusQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private LocationSharingFieldsModel f2397d;

        /* compiled from: size_medium */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DivebarNearbyFriendsStatusQueryModel.class, new Deserializer());
            }

            public Object m2247a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = DivebarNearbyFriendsStatusQueryParser.m2259a(jsonParser);
                Object divebarNearbyFriendsStatusQueryModel = new DivebarNearbyFriendsStatusQueryModel();
                ((BaseModel) divebarNearbyFriendsStatusQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (divebarNearbyFriendsStatusQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) divebarNearbyFriendsStatusQueryModel).a();
                }
                return divebarNearbyFriendsStatusQueryModel;
            }
        }

        /* compiled from: size_medium */
        public class Serializer extends JsonSerializer<DivebarNearbyFriendsStatusQueryModel> {
            public final void m2248a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                DivebarNearbyFriendsStatusQueryModel divebarNearbyFriendsStatusQueryModel = (DivebarNearbyFriendsStatusQueryModel) obj;
                if (divebarNearbyFriendsStatusQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(divebarNearbyFriendsStatusQueryModel.m2249a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    divebarNearbyFriendsStatusQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = divebarNearbyFriendsStatusQueryModel.w_();
                int u_ = divebarNearbyFriendsStatusQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("location_sharing");
                    LocationSharingFieldsParser.m2261a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(DivebarNearbyFriendsStatusQueryModel.class, new Serializer());
            }
        }

        public DivebarNearbyFriendsStatusQueryModel() {
            super(1);
        }

        @Nullable
        public final LocationSharingFieldsModel m2251a() {
            this.f2397d = (LocationSharingFieldsModel) super.a(this.f2397d, 0, LocationSharingFieldsModel.class);
            return this.f2397d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m2250a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2251a() != null) {
                LocationSharingFieldsModel locationSharingFieldsModel = (LocationSharingFieldsModel) graphQLModelMutatingVisitor.b(m2251a());
                if (m2251a() != locationSharingFieldsModel) {
                    graphQLVisitableModel = (DivebarNearbyFriendsStatusQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2397d = locationSharingFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2249a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2251a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -198565270)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: size_medium */
    public final class LocationSharingFieldsModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f2398d;
        private boolean f2399e;

        /* compiled from: size_medium */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LocationSharingFieldsModel.class, new Deserializer());
            }

            public Object m2252a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LocationSharingFieldsParser.m2260a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object locationSharingFieldsModel = new LocationSharingFieldsModel();
                ((BaseModel) locationSharingFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (locationSharingFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) locationSharingFieldsModel).a();
                }
                return locationSharingFieldsModel;
            }
        }

        /* compiled from: size_medium */
        public class Serializer extends JsonSerializer<LocationSharingFieldsModel> {
            public final void m2253a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                LocationSharingFieldsModel locationSharingFieldsModel = (LocationSharingFieldsModel) obj;
                if (locationSharingFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(locationSharingFieldsModel.m2254a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    locationSharingFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                LocationSharingFieldsParser.m2261a(locationSharingFieldsModel.w_(), locationSharingFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(LocationSharingFieldsModel.class, new Serializer());
            }
        }

        public LocationSharingFieldsModel() {
            super(2);
        }

        public final boolean m2257a() {
            a(0, 0);
            return this.f2398d;
        }

        public final boolean m2258b() {
            a(0, 1);
            return this.f2399e;
        }

        public final int jK_() {
            return 924875591;
        }

        public final GraphQLVisitableModel m2255a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m2254a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f2398d);
            flatBufferBuilder.a(1, this.f2399e);
            i();
            return flatBufferBuilder.d();
        }

        public final void m2256a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f2398d = mutableFlatBuffer.a(i, 0);
            this.f2399e = mutableFlatBuffer.a(i, 1);
        }
    }
}
