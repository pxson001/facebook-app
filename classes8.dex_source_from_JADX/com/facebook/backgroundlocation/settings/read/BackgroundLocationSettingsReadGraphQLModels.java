package com.facebook.backgroundlocation.settings.read;

import com.facebook.backgroundlocation.settings.read.BackgroundLocationSettingsReadGraphQLParsers.LocationHistoryEnabledQueryParser;
import com.facebook.backgroundlocation.settings.read.BackgroundLocationSettingsReadGraphQLParsers.LocationSharingFeatureStatusParser;
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
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: is_cvv_tricky_bin */
public class BackgroundLocationSettingsReadGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -315159412)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: is_cvv_tricky_bin */
    public final class LocationHistoryEnabledQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private LocationSharingFeatureStatusModel f10628d;

        /* compiled from: is_cvv_tricky_bin */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LocationHistoryEnabledQueryModel.class, new Deserializer());
            }

            public Object m12558a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = LocationHistoryEnabledQueryParser.m12571a(jsonParser);
                Object locationHistoryEnabledQueryModel = new LocationHistoryEnabledQueryModel();
                ((BaseModel) locationHistoryEnabledQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (locationHistoryEnabledQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) locationHistoryEnabledQueryModel).a();
                }
                return locationHistoryEnabledQueryModel;
            }
        }

        /* compiled from: is_cvv_tricky_bin */
        public class Serializer extends JsonSerializer<LocationHistoryEnabledQueryModel> {
            public final void m12559a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                LocationHistoryEnabledQueryModel locationHistoryEnabledQueryModel = (LocationHistoryEnabledQueryModel) obj;
                if (locationHistoryEnabledQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(locationHistoryEnabledQueryModel.m12560a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    locationHistoryEnabledQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = locationHistoryEnabledQueryModel.w_();
                int u_ = locationHistoryEnabledQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("location_sharing");
                    LocationSharingFeatureStatusParser.m12573a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(LocationHistoryEnabledQueryModel.class, new Serializer());
            }
        }

        public LocationHistoryEnabledQueryModel() {
            super(1);
        }

        @Nullable
        public final LocationSharingFeatureStatusModel m12561a() {
            this.f10628d = (LocationSharingFeatureStatusModel) super.a(this.f10628d, 0, LocationSharingFeatureStatusModel.class);
            return this.f10628d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m12562a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12561a() != null) {
                LocationSharingFeatureStatusModel locationSharingFeatureStatusModel = (LocationSharingFeatureStatusModel) graphQLModelMutatingVisitor.b(m12561a());
                if (m12561a() != locationSharingFeatureStatusModel) {
                    graphQLVisitableModel = (LocationHistoryEnabledQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10628d = locationSharingFeatureStatusModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12560a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12561a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -148905961)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: is_cvv_tricky_bin */
    public final class LocationSharingFeatureStatusModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f10629d;
        private boolean f10630e;
        private boolean f10631f;

        /* compiled from: is_cvv_tricky_bin */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LocationSharingFeatureStatusModel.class, new Deserializer());
            }

            public Object m12563a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LocationSharingFeatureStatusParser.m12572a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object locationSharingFeatureStatusModel = new LocationSharingFeatureStatusModel();
                ((BaseModel) locationSharingFeatureStatusModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (locationSharingFeatureStatusModel instanceof Postprocessable) {
                    return ((Postprocessable) locationSharingFeatureStatusModel).a();
                }
                return locationSharingFeatureStatusModel;
            }
        }

        /* compiled from: is_cvv_tricky_bin */
        public class Serializer extends JsonSerializer<LocationSharingFeatureStatusModel> {
            public final void m12564a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                LocationSharingFeatureStatusModel locationSharingFeatureStatusModel = (LocationSharingFeatureStatusModel) obj;
                if (locationSharingFeatureStatusModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(locationSharingFeatureStatusModel.m12565a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    locationSharingFeatureStatusModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                LocationSharingFeatureStatusParser.m12573a(locationSharingFeatureStatusModel.w_(), locationSharingFeatureStatusModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(LocationSharingFeatureStatusModel.class, new Serializer());
            }
        }

        public LocationSharingFeatureStatusModel() {
            super(3);
        }

        public final boolean m12568a() {
            a(0, 0);
            return this.f10629d;
        }

        public final boolean m12569j() {
            a(0, 1);
            return this.f10630e;
        }

        public final boolean m12570k() {
            a(0, 2);
            return this.f10631f;
        }

        public final int jK_() {
            return 924875591;
        }

        public final GraphQLVisitableModel m12566a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m12565a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f10629d);
            flatBufferBuilder.a(1, this.f10630e);
            flatBufferBuilder.a(2, this.f10631f);
            i();
            return flatBufferBuilder.d();
        }

        public final void m12567a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f10629d = mutableFlatBuffer.a(i, 0);
            this.f10630e = mutableFlatBuffer.a(i, 1);
            this.f10631f = mutableFlatBuffer.a(i, 2);
        }
    }
}
