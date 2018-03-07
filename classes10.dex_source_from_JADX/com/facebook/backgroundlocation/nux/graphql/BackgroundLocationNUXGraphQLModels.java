package com.facebook.backgroundlocation.nux.graphql;

import com.facebook.backgroundlocation.nux.graphql.BackgroundLocationNUXGraphQLParsers.BackgroundLocationNowNuxQueryParser;
import com.facebook.backgroundlocation.nux.graphql.BackgroundLocationNUXGraphQLParsers.BackgroundLocationNowNuxQueryParser.ActorParser;
import com.facebook.backgroundlocation.nux.graphql.BackgroundLocationNUXGraphQLParsers.BackgroundLocationNowNuxQueryParser.ActorParser.CurrentCityParser;
import com.facebook.backgroundlocation.nux.graphql.BackgroundLocationNUXGraphQLParsers.BackgroundLocationNowNuxQueryParser.CurrentLocationPageParser;
import com.facebook.backgroundlocation.nux.graphql.BackgroundLocationNUXGraphQLParsers.BackgroundLocationNowNuxQueryParser.CurrentLocationPageParser.LocationParser;
import com.facebook.backgroundlocation.nux.graphql.BackgroundLocationNUXGraphQLParsers.BackgroundLocationNowNuxQueryParser.CurrentLocationPageParser.LocationParser.ReverseGeocodeParser;
import com.facebook.backgroundlocation.nux.graphql.BackgroundLocationNUXGraphQLParsers.BackgroundLocationNowNuxQueryParser.LocationSharingParser;
import com.facebook.backgroundlocation.nux.graphql.BackgroundLocationNUXGraphQLParsers.BackgroundLocationNowNuxQueryParser.PrivacySettingsParser;
import com.facebook.backgroundlocation.nux.graphql.BackgroundLocationNUXGraphQLParsers.BackgroundLocationNuxFriendsSharingLocationParser;
import com.facebook.backgroundlocation.nux.graphql.BackgroundLocationNUXGraphQLParsers.BackgroundLocationNuxFriendsSharingLocationParser.FriendsSharingLocationConnectionParser;
import com.facebook.backgroundlocation.privacypicker.graphql.BackgroundLocationPrivacyPickerGraphQLModels.BackgroundLocationPrivacyPickerOptionsModel;
import com.facebook.backgroundlocation.upsell.graphql.BackgroundLocationUpsellGraphQLModels.BackgroundLocationUpsellProfileModel;
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
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
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

/* compiled from: document_closed */
public class BackgroundLocationNUXGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1279917502)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: document_closed */
    public final class BackgroundLocationNowNuxQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ActorModel f14841d;
        @Nullable
        private CurrentLocationPageModel f14842e;
        @Nullable
        private LocationSharingModel f14843f;
        @Nullable
        private PrivacySettingsModel f14844g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1234658906)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: document_closed */
        public final class ActorModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f14829d;
            @Nullable
            private CurrentCityModel f14830e;
            @Nullable
            private String f14831f;
            @Nullable
            private DefaultImageFieldsModel f14832g;
            @Nullable
            private String f14833h;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 483014131)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: document_closed */
            public final class CurrentCityModel extends BaseModel implements GraphQLVisitableConsistentModel {
                @Nullable
                private String f14828d;

                /* compiled from: document_closed */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CurrentCityModel.class, new Deserializer());
                    }

                    public Object m15204a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CurrentCityParser.m15276a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object currentCityModel = new CurrentCityModel();
                        ((BaseModel) currentCityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (currentCityModel instanceof Postprocessable) {
                            return ((Postprocessable) currentCityModel).a();
                        }
                        return currentCityModel;
                    }
                }

                /* compiled from: document_closed */
                public class Serializer extends JsonSerializer<CurrentCityModel> {
                    public final void m15205a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CurrentCityModel currentCityModel = (CurrentCityModel) obj;
                        if (currentCityModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(currentCityModel.m15207a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            currentCityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CurrentCityParser.m15277a(currentCityModel.w_(), currentCityModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(CurrentCityModel.class, new Serializer());
                    }
                }

                public CurrentCityModel() {
                    super(1);
                }

                public final void m15209a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m15210a(String str, Object obj, boolean z) {
                }

                @Nullable
                private String m15206a() {
                    this.f14828d = super.a(this.f14828d, 0);
                    return this.f14828d;
                }

                public final int jK_() {
                    return 2479791;
                }

                public final GraphQLVisitableModel m15208a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m15207a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m15206a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: document_closed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ActorModel.class, new Deserializer());
                }

                public Object m15211a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ActorParser.m15278a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object actorModel = new ActorModel();
                    ((BaseModel) actorModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (actorModel instanceof Postprocessable) {
                        return ((Postprocessable) actorModel).a();
                    }
                    return actorModel;
                }
            }

            /* compiled from: document_closed */
            public class Serializer extends JsonSerializer<ActorModel> {
                public final void m15212a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ActorModel actorModel = (ActorModel) obj;
                    if (actorModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(actorModel.m15216a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        actorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ActorParser.m15279a(actorModel.w_(), actorModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ActorModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields m15221b() {
                return m15215l();
            }

            public ActorModel() {
                super(5);
            }

            public final void m15219a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m15220a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m15213j() {
                if (this.b != null && this.f14829d == null) {
                    this.f14829d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f14829d;
            }

            @Nullable
            private CurrentCityModel m15214k() {
                this.f14830e = (CurrentCityModel) super.a(this.f14830e, 1, CurrentCityModel.class);
                return this.f14830e;
            }

            @Nullable
            public final String m15218a() {
                this.f14831f = super.a(this.f14831f, 2);
                return this.f14831f;
            }

            @Nullable
            private DefaultImageFieldsModel m15215l() {
                this.f14832g = (DefaultImageFieldsModel) super.a(this.f14832g, 3, DefaultImageFieldsModel.class);
                return this.f14832g;
            }

            @Nullable
            public final String m15222c() {
                this.f14833h = super.a(this.f14833h, 4);
                return this.f14833h;
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m15217a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15214k() != null) {
                    CurrentCityModel currentCityModel = (CurrentCityModel) graphQLModelMutatingVisitor.b(m15214k());
                    if (m15214k() != currentCityModel) {
                        graphQLVisitableModel = (ActorModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f14830e = currentCityModel;
                    }
                }
                if (m15215l() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m15215l());
                    if (m15215l() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (ActorModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f14832g = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15216a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15213j());
                int a2 = ModelHelper.a(flatBufferBuilder, m15214k());
                int b = flatBufferBuilder.b(m15218a());
                int a3 = ModelHelper.a(flatBufferBuilder, m15215l());
                int b2 = flatBufferBuilder.b(m15222c());
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, a3);
                flatBufferBuilder.b(4, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -946730832)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: document_closed */
        public final class CurrentLocationPageModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private LocationModel f14836d;

            /* compiled from: document_closed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CurrentLocationPageModel.class, new Deserializer());
                }

                public Object m15223a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CurrentLocationPageParser.m15284a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object currentLocationPageModel = new CurrentLocationPageModel();
                    ((BaseModel) currentLocationPageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (currentLocationPageModel instanceof Postprocessable) {
                        return ((Postprocessable) currentLocationPageModel).a();
                    }
                    return currentLocationPageModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -2083205154)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: document_closed */
            public final class LocationModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private ReverseGeocodeModel f14835d;

                /* compiled from: document_closed */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(LocationModel.class, new Deserializer());
                    }

                    public Object m15224a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(LocationParser.m15282a(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = -2132098501)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: document_closed */
                public final class ReverseGeocodeModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f14834d;

                    /* compiled from: document_closed */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ReverseGeocodeModel.class, new Deserializer());
                        }

                        public Object m15225a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ReverseGeocodeParser.m15280a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object reverseGeocodeModel = new ReverseGeocodeModel();
                            ((BaseModel) reverseGeocodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (reverseGeocodeModel instanceof Postprocessable) {
                                return ((Postprocessable) reverseGeocodeModel).a();
                            }
                            return reverseGeocodeModel;
                        }
                    }

                    /* compiled from: document_closed */
                    public class Serializer extends JsonSerializer<ReverseGeocodeModel> {
                        public final void m15226a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ReverseGeocodeModel reverseGeocodeModel = (ReverseGeocodeModel) obj;
                            if (reverseGeocodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(reverseGeocodeModel.m15228a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                reverseGeocodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ReverseGeocodeParser.m15281a(reverseGeocodeModel.w_(), reverseGeocodeModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ReverseGeocodeModel.class, new Serializer());
                        }
                    }

                    public ReverseGeocodeModel() {
                        super(1);
                    }

                    @Nullable
                    private String m15227a() {
                        this.f14834d = super.a(this.f14834d, 0);
                        return this.f14834d;
                    }

                    public final int jK_() {
                        return -1148071578;
                    }

                    public final GraphQLVisitableModel m15229a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m15228a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m15227a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: document_closed */
                public class Serializer extends JsonSerializer<LocationModel> {
                    public final void m15230a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        LocationModel locationModel = (LocationModel) obj;
                        if (locationModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(locationModel.m15232a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            locationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        LocationParser.m15283a(locationModel.w_(), locationModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(LocationModel.class, new Serializer());
                    }
                }

                public LocationModel() {
                    super(1);
                }

                @Nullable
                private ReverseGeocodeModel m15231a() {
                    this.f14835d = (ReverseGeocodeModel) super.a(this.f14835d, 0, ReverseGeocodeModel.class);
                    return this.f14835d;
                }

                public final int jK_() {
                    return 1965687765;
                }

                public final GraphQLVisitableModel m15233a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m15231a() != null) {
                        ReverseGeocodeModel reverseGeocodeModel = (ReverseGeocodeModel) graphQLModelMutatingVisitor.b(m15231a());
                        if (m15231a() != reverseGeocodeModel) {
                            graphQLVisitableModel = (LocationModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f14835d = reverseGeocodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m15232a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m15231a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: document_closed */
            public class Serializer extends JsonSerializer<CurrentLocationPageModel> {
                public final void m15234a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CurrentLocationPageModel currentLocationPageModel = (CurrentLocationPageModel) obj;
                    if (currentLocationPageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(currentLocationPageModel.m15236a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        currentLocationPageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CurrentLocationPageParser.m15285a(currentLocationPageModel.w_(), currentLocationPageModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CurrentLocationPageModel.class, new Serializer());
                }
            }

            public CurrentLocationPageModel() {
                super(1);
            }

            public final void m15238a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m15239a(String str, Object obj, boolean z) {
            }

            @Nullable
            private LocationModel m15235a() {
                this.f14836d = (LocationModel) super.a(this.f14836d, 0, LocationModel.class);
                return this.f14836d;
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m15237a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15235a() != null) {
                    LocationModel locationModel = (LocationModel) graphQLModelMutatingVisitor.b(m15235a());
                    if (m15235a() != locationModel) {
                        graphQLVisitableModel = (CurrentLocationPageModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f14836d = locationModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15236a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15235a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: document_closed */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BackgroundLocationNowNuxQueryModel.class, new Deserializer());
            }

            public Object m15240a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = BackgroundLocationNowNuxQueryParser.m15290a(jsonParser);
                Object backgroundLocationNowNuxQueryModel = new BackgroundLocationNowNuxQueryModel();
                ((BaseModel) backgroundLocationNowNuxQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (backgroundLocationNowNuxQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) backgroundLocationNowNuxQueryModel).a();
                }
                return backgroundLocationNowNuxQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1287148039)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: document_closed */
        public final class LocationSharingModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private BackgroundLocationNuxFriendsSharingLocationModel f14837d;
            private boolean f14838e;
            @Nullable
            private BackgroundLocationNuxFriendsSharingLocationModel f14839f;

            /* compiled from: document_closed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LocationSharingModel.class, new Deserializer());
                }

                public Object m15241a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LocationSharingParser.m15286a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object locationSharingModel = new LocationSharingModel();
                    ((BaseModel) locationSharingModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (locationSharingModel instanceof Postprocessable) {
                        return ((Postprocessable) locationSharingModel).a();
                    }
                    return locationSharingModel;
                }
            }

            /* compiled from: document_closed */
            public class Serializer extends JsonSerializer<LocationSharingModel> {
                public final void m15242a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LocationSharingModel locationSharingModel = (LocationSharingModel) obj;
                    if (locationSharingModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(locationSharingModel.m15243a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        locationSharingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LocationSharingParser.m15287a(locationSharingModel.w_(), locationSharingModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(LocationSharingModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ BackgroundLocationNuxFriendsSharingLocationModel m15244a() {
                return m15249j();
            }

            @Nullable
            public final /* synthetic */ BackgroundLocationNuxFriendsSharingLocationModel m15248c() {
                return m15250k();
            }

            public LocationSharingModel() {
                super(3);
            }

            @Nullable
            public final BackgroundLocationNuxFriendsSharingLocationModel m15249j() {
                this.f14837d = (BackgroundLocationNuxFriendsSharingLocationModel) super.a(this.f14837d, 0, BackgroundLocationNuxFriendsSharingLocationModel.class);
                return this.f14837d;
            }

            public final boolean m15247b() {
                a(0, 1);
                return this.f14838e;
            }

            @Nullable
            public final BackgroundLocationNuxFriendsSharingLocationModel m15250k() {
                this.f14839f = (BackgroundLocationNuxFriendsSharingLocationModel) super.a(this.f14839f, 2, BackgroundLocationNuxFriendsSharingLocationModel.class);
                return this.f14839f;
            }

            public final int jK_() {
                return 924875591;
            }

            public final GraphQLVisitableModel m15245a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                BackgroundLocationNuxFriendsSharingLocationModel backgroundLocationNuxFriendsSharingLocationModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15249j() != null) {
                    backgroundLocationNuxFriendsSharingLocationModel = (BackgroundLocationNuxFriendsSharingLocationModel) graphQLModelMutatingVisitor.b(m15249j());
                    if (m15249j() != backgroundLocationNuxFriendsSharingLocationModel) {
                        graphQLVisitableModel = (LocationSharingModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f14837d = backgroundLocationNuxFriendsSharingLocationModel;
                    }
                }
                if (m15250k() != null) {
                    backgroundLocationNuxFriendsSharingLocationModel = (BackgroundLocationNuxFriendsSharingLocationModel) graphQLModelMutatingVisitor.b(m15250k());
                    if (m15250k() != backgroundLocationNuxFriendsSharingLocationModel) {
                        graphQLVisitableModel = (LocationSharingModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f14839f = backgroundLocationNuxFriendsSharingLocationModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15243a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15249j());
                int a2 = ModelHelper.a(flatBufferBuilder, m15250k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f14838e);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15246a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f14838e = mutableFlatBuffer.a(i, 1);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1853691525)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: document_closed */
        public final class PrivacySettingsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private BackgroundLocationPrivacyPickerOptionsModel f14840d;

            /* compiled from: document_closed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PrivacySettingsModel.class, new Deserializer());
                }

                public Object m15251a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PrivacySettingsParser.m15288a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object privacySettingsModel = new PrivacySettingsModel();
                    ((BaseModel) privacySettingsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (privacySettingsModel instanceof Postprocessable) {
                        return ((Postprocessable) privacySettingsModel).a();
                    }
                    return privacySettingsModel;
                }
            }

            /* compiled from: document_closed */
            public class Serializer extends JsonSerializer<PrivacySettingsModel> {
                public final void m15252a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PrivacySettingsModel privacySettingsModel = (PrivacySettingsModel) obj;
                    if (privacySettingsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(privacySettingsModel.m15253a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        privacySettingsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PrivacySettingsParser.m15289a(privacySettingsModel.w_(), privacySettingsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PrivacySettingsModel.class, new Serializer());
                }
            }

            public PrivacySettingsModel() {
                super(1);
            }

            @Nullable
            public final BackgroundLocationPrivacyPickerOptionsModel m15254a() {
                this.f14840d = (BackgroundLocationPrivacyPickerOptionsModel) super.a(this.f14840d, 0, BackgroundLocationPrivacyPickerOptionsModel.class);
                return this.f14840d;
            }

            public final int jK_() {
                return 919429216;
            }

            public final GraphQLVisitableModel m15255a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15254a() != null) {
                    BackgroundLocationPrivacyPickerOptionsModel backgroundLocationPrivacyPickerOptionsModel = (BackgroundLocationPrivacyPickerOptionsModel) graphQLModelMutatingVisitor.b(m15254a());
                    if (m15254a() != backgroundLocationPrivacyPickerOptionsModel) {
                        graphQLVisitableModel = (PrivacySettingsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f14840d = backgroundLocationPrivacyPickerOptionsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15253a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15254a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: document_closed */
        public class Serializer extends JsonSerializer<BackgroundLocationNowNuxQueryModel> {
            public final void m15256a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                BackgroundLocationNowNuxQueryModel backgroundLocationNowNuxQueryModel = (BackgroundLocationNowNuxQueryModel) obj;
                if (backgroundLocationNowNuxQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(backgroundLocationNowNuxQueryModel.m15258a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    backgroundLocationNowNuxQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = backgroundLocationNowNuxQueryModel.w_();
                int u_ = backgroundLocationNowNuxQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("actor");
                    ActorParser.m15279a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("current_location_page");
                    CurrentLocationPageParser.m15285a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("location_sharing");
                    LocationSharingParser.m15287a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("privacy_settings");
                    PrivacySettingsParser.m15289a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(BackgroundLocationNowNuxQueryModel.class, new Serializer());
            }
        }

        public BackgroundLocationNowNuxQueryModel() {
            super(4);
        }

        @Nullable
        public final ActorModel m15259a() {
            this.f14841d = (ActorModel) super.a(this.f14841d, 0, ActorModel.class);
            return this.f14841d;
        }

        @Nullable
        private CurrentLocationPageModel m15257l() {
            this.f14842e = (CurrentLocationPageModel) super.a(this.f14842e, 1, CurrentLocationPageModel.class);
            return this.f14842e;
        }

        @Nullable
        public final LocationSharingModel m15261j() {
            this.f14843f = (LocationSharingModel) super.a(this.f14843f, 2, LocationSharingModel.class);
            return this.f14843f;
        }

        @Nullable
        public final PrivacySettingsModel m15262k() {
            this.f14844g = (PrivacySettingsModel) super.a(this.f14844g, 3, PrivacySettingsModel.class);
            return this.f14844g;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m15260a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15259a() != null) {
                ActorModel actorModel = (ActorModel) graphQLModelMutatingVisitor.b(m15259a());
                if (m15259a() != actorModel) {
                    graphQLVisitableModel = (BackgroundLocationNowNuxQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14841d = actorModel;
                }
            }
            if (m15257l() != null) {
                CurrentLocationPageModel currentLocationPageModel = (CurrentLocationPageModel) graphQLModelMutatingVisitor.b(m15257l());
                if (m15257l() != currentLocationPageModel) {
                    graphQLVisitableModel = (BackgroundLocationNowNuxQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f14842e = currentLocationPageModel;
                }
            }
            if (m15261j() != null) {
                LocationSharingModel locationSharingModel = (LocationSharingModel) graphQLModelMutatingVisitor.b(m15261j());
                if (m15261j() != locationSharingModel) {
                    graphQLVisitableModel = (BackgroundLocationNowNuxQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f14843f = locationSharingModel;
                }
            }
            if (m15262k() != null) {
                PrivacySettingsModel privacySettingsModel = (PrivacySettingsModel) graphQLModelMutatingVisitor.b(m15262k());
                if (m15262k() != privacySettingsModel) {
                    graphQLVisitableModel = (BackgroundLocationNowNuxQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f14844g = privacySettingsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15258a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15259a());
            int a2 = ModelHelper.a(flatBufferBuilder, m15257l());
            int a3 = ModelHelper.a(flatBufferBuilder, m15261j());
            int a4 = ModelHelper.a(flatBufferBuilder, m15262k());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 969205530)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: document_closed */
    public final class BackgroundLocationNuxFriendsSharingLocationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FriendsSharingLocationConnectionModel f14847d;

        /* compiled from: document_closed */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BackgroundLocationNuxFriendsSharingLocationModel.class, new Deserializer());
            }

            public Object m15263a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(BackgroundLocationNuxFriendsSharingLocationParser.m15293a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object backgroundLocationNuxFriendsSharingLocationModel = new BackgroundLocationNuxFriendsSharingLocationModel();
                ((BaseModel) backgroundLocationNuxFriendsSharingLocationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (backgroundLocationNuxFriendsSharingLocationModel instanceof Postprocessable) {
                    return ((Postprocessable) backgroundLocationNuxFriendsSharingLocationModel).a();
                }
                return backgroundLocationNuxFriendsSharingLocationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1402616871)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: document_closed */
        public final class FriendsSharingLocationConnectionModel extends BaseModel implements GraphQLVisitableModel {
            private int f14845d;
            @Nullable
            private List<BackgroundLocationUpsellProfileModel> f14846e;

            /* compiled from: document_closed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendsSharingLocationConnectionModel.class, new Deserializer());
                }

                public Object m15264a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FriendsSharingLocationConnectionParser.m15291a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object friendsSharingLocationConnectionModel = new FriendsSharingLocationConnectionModel();
                    ((BaseModel) friendsSharingLocationConnectionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (friendsSharingLocationConnectionModel instanceof Postprocessable) {
                        return ((Postprocessable) friendsSharingLocationConnectionModel).a();
                    }
                    return friendsSharingLocationConnectionModel;
                }
            }

            /* compiled from: document_closed */
            public class Serializer extends JsonSerializer<FriendsSharingLocationConnectionModel> {
                public final void m15265a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendsSharingLocationConnectionModel friendsSharingLocationConnectionModel = (FriendsSharingLocationConnectionModel) obj;
                    if (friendsSharingLocationConnectionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendsSharingLocationConnectionModel.m15267a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendsSharingLocationConnectionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FriendsSharingLocationConnectionParser.m15292a(friendsSharingLocationConnectionModel.w_(), friendsSharingLocationConnectionModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FriendsSharingLocationConnectionModel.class, new Serializer());
                }
            }

            public FriendsSharingLocationConnectionModel() {
                super(2);
            }

            public final int m15266a() {
                a(0, 0);
                return this.f14845d;
            }

            @Nonnull
            public final ImmutableList<BackgroundLocationUpsellProfileModel> m15270b() {
                this.f14846e = super.a(this.f14846e, 1, BackgroundLocationUpsellProfileModel.class);
                return (ImmutableList) this.f14846e;
            }

            public final int jK_() {
                return -429463942;
            }

            public final GraphQLVisitableModel m15268a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15270b() != null) {
                    Builder a = ModelHelper.a(m15270b(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (FriendsSharingLocationConnectionModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f14846e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15267a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15270b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f14845d, 0);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15269a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f14845d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: document_closed */
        public class Serializer extends JsonSerializer<BackgroundLocationNuxFriendsSharingLocationModel> {
            public final void m15271a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                BackgroundLocationNuxFriendsSharingLocationModel backgroundLocationNuxFriendsSharingLocationModel = (BackgroundLocationNuxFriendsSharingLocationModel) obj;
                if (backgroundLocationNuxFriendsSharingLocationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(backgroundLocationNuxFriendsSharingLocationModel.m15273a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    backgroundLocationNuxFriendsSharingLocationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                BackgroundLocationNuxFriendsSharingLocationParser.m15294a(backgroundLocationNuxFriendsSharingLocationModel.w_(), backgroundLocationNuxFriendsSharingLocationModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(BackgroundLocationNuxFriendsSharingLocationModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ FriendsSharingLocationConnectionModel m15274a() {
            return m15272j();
        }

        public BackgroundLocationNuxFriendsSharingLocationModel() {
            super(1);
        }

        @Nullable
        private FriendsSharingLocationConnectionModel m15272j() {
            this.f14847d = (FriendsSharingLocationConnectionModel) super.a(this.f14847d, 0, FriendsSharingLocationConnectionModel.class);
            return this.f14847d;
        }

        public final int jK_() {
            return -1360693636;
        }

        public final GraphQLVisitableModel m15275a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15272j() != null) {
                FriendsSharingLocationConnectionModel friendsSharingLocationConnectionModel = (FriendsSharingLocationConnectionModel) graphQLModelMutatingVisitor.b(m15272j());
                if (m15272j() != friendsSharingLocationConnectionModel) {
                    graphQLVisitableModel = (BackgroundLocationNuxFriendsSharingLocationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14847d = friendsSharingLocationConnectionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15273a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15272j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
