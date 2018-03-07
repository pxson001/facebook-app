package com.facebook.backgroundlocation.settings.graphql;

import com.facebook.backgroundlocation.privacypicker.graphql.BackgroundLocationPrivacyPickerGraphQLModels.BackgroundLocationPrivacyPickerOptionsModel;
import com.facebook.backgroundlocation.settings.graphql.BackgroundLocationSettingsGraphQLParsers.LocationSharingPrivacyOptionsQueryParser;
import com.facebook.backgroundlocation.settings.graphql.BackgroundLocationSettingsGraphQLParsers.LocationSharingPrivacyOptionsQueryParser.LocationSharingParser;
import com.facebook.backgroundlocation.settings.graphql.BackgroundLocationSettingsGraphQLParsers.LocationSharingPrivacyOptionsQueryParser.LocationSharingParser.UpsellParser;
import com.facebook.backgroundlocation.settings.graphql.BackgroundLocationSettingsGraphQLParsers.LocationSharingPrivacyOptionsQueryParser.LocationSharingParser.UpsellParser.FriendsSharingLocationConnectionParser;
import com.facebook.backgroundlocation.settings.graphql.BackgroundLocationSettingsGraphQLParsers.LocationSharingPrivacyOptionsQueryParser.PrivacySettingsParser;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: device_stat_interval */
public class BackgroundLocationSettingsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1639854511)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: device_stat_interval */
    public final class LocationSharingPrivacyOptionsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private LocationSharingModel f15056d;
        @Nullable
        private PrivacySettingsModel f15057e;

        /* compiled from: device_stat_interval */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LocationSharingPrivacyOptionsQueryModel.class, new Deserializer());
            }

            public Object m15511a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = LocationSharingPrivacyOptionsQueryParser.m15555a(jsonParser);
                Object locationSharingPrivacyOptionsQueryModel = new LocationSharingPrivacyOptionsQueryModel();
                ((BaseModel) locationSharingPrivacyOptionsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (locationSharingPrivacyOptionsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) locationSharingPrivacyOptionsQueryModel).a();
                }
                return locationSharingPrivacyOptionsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 329626698)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: device_stat_interval */
        public final class LocationSharingModel extends BaseModel implements GraphQLVisitableModel {
            private boolean f15052d;
            private boolean f15053e;
            @Nullable
            private UpsellModel f15054f;

            /* compiled from: device_stat_interval */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LocationSharingModel.class, new Deserializer());
                }

                public Object m15512a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LocationSharingParser.m15551a(jsonParser, flatBufferBuilder));
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

            /* compiled from: device_stat_interval */
            public class Serializer extends JsonSerializer<LocationSharingModel> {
                public final void m15513a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LocationSharingModel locationSharingModel = (LocationSharingModel) obj;
                    if (locationSharingModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(locationSharingModel.m15528a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        locationSharingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LocationSharingParser.m15552a(locationSharingModel.w_(), locationSharingModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(LocationSharingModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1288141755)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: device_stat_interval */
            public final class UpsellModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private FriendsSharingLocationConnectionModel f15051d;

                /* compiled from: device_stat_interval */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(UpsellModel.class, new Deserializer());
                    }

                    public Object m15514a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(UpsellParser.m15549a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object upsellModel = new UpsellModel();
                        ((BaseModel) upsellModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (upsellModel instanceof Postprocessable) {
                            return ((Postprocessable) upsellModel).a();
                        }
                        return upsellModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1402616871)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: device_stat_interval */
                public final class FriendsSharingLocationConnectionModel extends BaseModel implements GraphQLVisitableModel {
                    private int f15049d;
                    @Nullable
                    private List<BackgroundLocationUpsellProfileModel> f15050e;

                    /* compiled from: device_stat_interval */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(FriendsSharingLocationConnectionModel.class, new Deserializer());
                        }

                        public Object m15515a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(FriendsSharingLocationConnectionParser.m15547a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: device_stat_interval */
                    public class Serializer extends JsonSerializer<FriendsSharingLocationConnectionModel> {
                        public final void m15516a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            FriendsSharingLocationConnectionModel friendsSharingLocationConnectionModel = (FriendsSharingLocationConnectionModel) obj;
                            if (friendsSharingLocationConnectionModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(friendsSharingLocationConnectionModel.m15518a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                friendsSharingLocationConnectionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            FriendsSharingLocationConnectionParser.m15548a(friendsSharingLocationConnectionModel.w_(), friendsSharingLocationConnectionModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(FriendsSharingLocationConnectionModel.class, new Serializer());
                        }
                    }

                    public FriendsSharingLocationConnectionModel() {
                        super(2);
                    }

                    public final int m15517a() {
                        a(0, 0);
                        return this.f15049d;
                    }

                    @Nonnull
                    public final ImmutableList<BackgroundLocationUpsellProfileModel> m15521b() {
                        this.f15050e = super.a(this.f15050e, 1, BackgroundLocationUpsellProfileModel.class);
                        return (ImmutableList) this.f15050e;
                    }

                    public final int jK_() {
                        return -429463942;
                    }

                    public final GraphQLVisitableModel m15519a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m15521b() != null) {
                            Builder a = ModelHelper.a(m15521b(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (FriendsSharingLocationConnectionModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f15050e = a.b();
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m15518a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m15521b());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.a(0, this.f15049d, 0);
                        flatBufferBuilder.b(1, a);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m15520a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f15049d = mutableFlatBuffer.a(i, 0, 0);
                    }
                }

                /* compiled from: device_stat_interval */
                public class Serializer extends JsonSerializer<UpsellModel> {
                    public final void m15522a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        UpsellModel upsellModel = (UpsellModel) obj;
                        if (upsellModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(upsellModel.m15524a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            upsellModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        UpsellParser.m15550a(upsellModel.w_(), upsellModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(UpsellModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ FriendsSharingLocationConnectionModel m15525a() {
                    return m15523j();
                }

                public UpsellModel() {
                    super(1);
                }

                @Nullable
                private FriendsSharingLocationConnectionModel m15523j() {
                    this.f15051d = (FriendsSharingLocationConnectionModel) super.a(this.f15051d, 0, FriendsSharingLocationConnectionModel.class);
                    return this.f15051d;
                }

                public final int jK_() {
                    return -1360693636;
                }

                public final GraphQLVisitableModel m15526a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m15523j() != null) {
                        FriendsSharingLocationConnectionModel friendsSharingLocationConnectionModel = (FriendsSharingLocationConnectionModel) graphQLModelMutatingVisitor.b(m15523j());
                        if (m15523j() != friendsSharingLocationConnectionModel) {
                            graphQLVisitableModel = (UpsellModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f15051d = friendsSharingLocationConnectionModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m15524a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m15523j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @Nullable
            public final /* synthetic */ UpsellModel m15533c() {
                return m15527j();
            }

            public LocationSharingModel() {
                super(3);
            }

            public final boolean m15531a() {
                a(0, 0);
                return this.f15052d;
            }

            public final boolean m15532b() {
                a(0, 1);
                return this.f15053e;
            }

            @Nullable
            private UpsellModel m15527j() {
                this.f15054f = (UpsellModel) super.a(this.f15054f, 2, UpsellModel.class);
                return this.f15054f;
            }

            public final int jK_() {
                return 924875591;
            }

            public final GraphQLVisitableModel m15529a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15527j() != null) {
                    UpsellModel upsellModel = (UpsellModel) graphQLModelMutatingVisitor.b(m15527j());
                    if (m15527j() != upsellModel) {
                        graphQLVisitableModel = (LocationSharingModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f15054f = upsellModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15528a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15527j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f15052d);
                flatBufferBuilder.a(1, this.f15053e);
                flatBufferBuilder.b(2, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15530a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f15052d = mutableFlatBuffer.a(i, 0);
                this.f15053e = mutableFlatBuffer.a(i, 1);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1853691525)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: device_stat_interval */
        public final class PrivacySettingsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private BackgroundLocationPrivacyPickerOptionsModel f15055d;

            /* compiled from: device_stat_interval */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PrivacySettingsModel.class, new Deserializer());
                }

                public Object m15534a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PrivacySettingsParser.m15553a(jsonParser, flatBufferBuilder));
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

            /* compiled from: device_stat_interval */
            public class Serializer extends JsonSerializer<PrivacySettingsModel> {
                public final void m15535a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PrivacySettingsModel privacySettingsModel = (PrivacySettingsModel) obj;
                    if (privacySettingsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(privacySettingsModel.m15537a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        privacySettingsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PrivacySettingsParser.m15554a(privacySettingsModel.w_(), privacySettingsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PrivacySettingsModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ BackgroundLocationPrivacyPickerOptionsModel m15538a() {
                return m15536j();
            }

            public PrivacySettingsModel() {
                super(1);
            }

            @Nullable
            private BackgroundLocationPrivacyPickerOptionsModel m15536j() {
                this.f15055d = (BackgroundLocationPrivacyPickerOptionsModel) super.a(this.f15055d, 0, BackgroundLocationPrivacyPickerOptionsModel.class);
                return this.f15055d;
            }

            public final int jK_() {
                return 919429216;
            }

            public final GraphQLVisitableModel m15539a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15536j() != null) {
                    BackgroundLocationPrivacyPickerOptionsModel backgroundLocationPrivacyPickerOptionsModel = (BackgroundLocationPrivacyPickerOptionsModel) graphQLModelMutatingVisitor.b(m15536j());
                    if (m15536j() != backgroundLocationPrivacyPickerOptionsModel) {
                        graphQLVisitableModel = (PrivacySettingsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f15055d = backgroundLocationPrivacyPickerOptionsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15537a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15536j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: device_stat_interval */
        public class Serializer extends JsonSerializer<LocationSharingPrivacyOptionsQueryModel> {
            public final void m15540a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                LocationSharingPrivacyOptionsQueryModel locationSharingPrivacyOptionsQueryModel = (LocationSharingPrivacyOptionsQueryModel) obj;
                if (locationSharingPrivacyOptionsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(locationSharingPrivacyOptionsQueryModel.m15543a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    locationSharingPrivacyOptionsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = locationSharingPrivacyOptionsQueryModel.w_();
                int u_ = locationSharingPrivacyOptionsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("location_sharing");
                    LocationSharingParser.m15552a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("privacy_settings");
                    PrivacySettingsParser.m15554a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(LocationSharingPrivacyOptionsQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ LocationSharingModel m15544a() {
            return m15541j();
        }

        @Nullable
        public final /* synthetic */ PrivacySettingsModel m15546b() {
            return m15542k();
        }

        public LocationSharingPrivacyOptionsQueryModel() {
            super(2);
        }

        @Nullable
        private LocationSharingModel m15541j() {
            this.f15056d = (LocationSharingModel) super.a(this.f15056d, 0, LocationSharingModel.class);
            return this.f15056d;
        }

        @Nullable
        private PrivacySettingsModel m15542k() {
            this.f15057e = (PrivacySettingsModel) super.a(this.f15057e, 1, PrivacySettingsModel.class);
            return this.f15057e;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m15545a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15541j() != null) {
                LocationSharingModel locationSharingModel = (LocationSharingModel) graphQLModelMutatingVisitor.b(m15541j());
                if (m15541j() != locationSharingModel) {
                    graphQLVisitableModel = (LocationSharingPrivacyOptionsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15056d = locationSharingModel;
                }
            }
            if (m15542k() != null) {
                PrivacySettingsModel privacySettingsModel = (PrivacySettingsModel) graphQLModelMutatingVisitor.b(m15542k());
                if (m15542k() != privacySettingsModel) {
                    graphQLVisitableModel = (LocationSharingPrivacyOptionsQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15057e = privacySettingsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15543a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15541j());
            int a2 = ModelHelper.a(flatBufferBuilder, m15542k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
