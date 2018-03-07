package com.facebook.placetips.common.graphql;

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
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLParsers.LocationTriggerWithReactionUnitsParser;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLParsers.LocationTriggerWithReactionUnitsParser.UnitsParser;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLParsers.LocationTriggerWithReactionUnitsParser.UnitsParser.EventsParser;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLParsers.LocationTriggerWithReactionUnitsParser.UnitsParser.EventsParser.EventParser;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLParsers.LocationTriggerWithReactionUnitsParser.UnitsParser.LocationUpsellsParser;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLParsers.LocationTriggerWithReactionUnitsParser.UnitsParser.PlacesParser;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLParsers.LocationTriggerWithReactionUnitsParser.UnitsParser.PlacesParser.PageParser;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLParsers.LocationTriggerWithReactionUnitsParser.UnitsParser.PlacesParser.PageParser.LocationParser;
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

/* compiled from: scroll_ready_ms */
public class LocationTriggerWithReactionUnitsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1792308241)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: scroll_ready_ms */
    public final class LocationTriggerWithReactionUnitsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private UnitsModel f3867d;

        /* compiled from: scroll_ready_ms */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LocationTriggerWithReactionUnitsModel.class, new Deserializer());
            }

            public Object m3745a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = LocationTriggerWithReactionUnitsParser.m3840a(jsonParser);
                Object locationTriggerWithReactionUnitsModel = new LocationTriggerWithReactionUnitsModel();
                ((BaseModel) locationTriggerWithReactionUnitsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (locationTriggerWithReactionUnitsModel instanceof Postprocessable) {
                    return ((Postprocessable) locationTriggerWithReactionUnitsModel).a();
                }
                return locationTriggerWithReactionUnitsModel;
            }
        }

        /* compiled from: scroll_ready_ms */
        public class Serializer extends JsonSerializer<LocationTriggerWithReactionUnitsModel> {
            public final void m3746a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                LocationTriggerWithReactionUnitsModel locationTriggerWithReactionUnitsModel = (LocationTriggerWithReactionUnitsModel) obj;
                if (locationTriggerWithReactionUnitsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(locationTriggerWithReactionUnitsModel.m3820a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    locationTriggerWithReactionUnitsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = locationTriggerWithReactionUnitsModel.w_();
                int u_ = locationTriggerWithReactionUnitsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("units");
                    UnitsParser.m3839a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(LocationTriggerWithReactionUnitsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -804767039)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: scroll_ready_ms */
        public final class UnitsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EventsModel> f3863d;
            private int f3864e;
            @Nullable
            private List<LocationUpsellsModel> f3865f;
            @Nullable
            private List<PlacesModel> f3866g;

            /* compiled from: scroll_ready_ms */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(UnitsModel.class, new Deserializer());
                }

                public Object m3747a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(UnitsParser.m3838a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object unitsModel = new UnitsModel();
                    ((BaseModel) unitsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (unitsModel instanceof Postprocessable) {
                        return ((Postprocessable) unitsModel).a();
                    }
                    return unitsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 559726994)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: scroll_ready_ms */
            public final class EventsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private EventModel f3842d;
                @Nullable
                private DefaultTextWithEntitiesLongFieldsModel f3843e;

                /* compiled from: scroll_ready_ms */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EventsModel.class, new Deserializer());
                    }

                    public Object m3748a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EventsParser.m3826b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object eventsModel = new EventsModel();
                        ((BaseModel) eventsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (eventsModel instanceof Postprocessable) {
                            return ((Postprocessable) eventsModel).a();
                        }
                        return eventsModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 127802168)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: scroll_ready_ms */
                public final class EventModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private String f3840d;
                    @Nullable
                    private DefaultImageFieldsModel f3841e;

                    /* compiled from: scroll_ready_ms */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EventModel.class, new Deserializer());
                        }

                        public Object m3749a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(EventParser.m3823a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object eventModel = new EventModel();
                            ((BaseModel) eventModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (eventModel instanceof Postprocessable) {
                                return ((Postprocessable) eventModel).a();
                            }
                            return eventModel;
                        }
                    }

                    /* compiled from: scroll_ready_ms */
                    public class Serializer extends JsonSerializer<EventModel> {
                        public final void m3750a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EventModel eventModel = (EventModel) obj;
                            if (eventModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(eventModel.m3752a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                eventModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            EventParser.m3824a(eventModel.w_(), eventModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(EventModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ DefaultImageFields m3758c() {
                        return m3751j();
                    }

                    public EventModel() {
                        super(2);
                    }

                    public final void m3755a(String str, ConsistencyTuple consistencyTuple) {
                        consistencyTuple.a();
                    }

                    public final void m3756a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    public final String m3757b() {
                        this.f3840d = super.a(this.f3840d, 0);
                        return this.f3840d;
                    }

                    @Nullable
                    private DefaultImageFieldsModel m3751j() {
                        this.f3841e = (DefaultImageFieldsModel) super.a(this.f3841e, 1, DefaultImageFieldsModel.class);
                        return this.f3841e;
                    }

                    @Nullable
                    public final String m3754a() {
                        return m3757b();
                    }

                    public final int jK_() {
                        return 67338874;
                    }

                    public final GraphQLVisitableModel m3753a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m3751j() != null) {
                            DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m3751j());
                            if (m3751j() != defaultImageFieldsModel) {
                                graphQLVisitableModel = (EventModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f3841e = defaultImageFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m3752a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m3757b());
                        int a = ModelHelper.a(flatBufferBuilder, m3751j());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: scroll_ready_ms */
                public class Serializer extends JsonSerializer<EventsModel> {
                    public final void m3759a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EventsModel eventsModel = (EventsModel) obj;
                        if (eventsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(eventsModel.m3762a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            eventsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EventsParser.m3827b(eventsModel.w_(), eventsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EventsModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ EventModel m3764a() {
                    return m3760j();
                }

                @Nullable
                public final /* synthetic */ DefaultTextWithEntitiesLongFields m3765b() {
                    return m3761k();
                }

                public EventsModel() {
                    super(2);
                }

                @Nullable
                private EventModel m3760j() {
                    this.f3842d = (EventModel) super.a(this.f3842d, 0, EventModel.class);
                    return this.f3842d;
                }

                @Nullable
                private DefaultTextWithEntitiesLongFieldsModel m3761k() {
                    this.f3843e = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f3843e, 1, DefaultTextWithEntitiesLongFieldsModel.class);
                    return this.f3843e;
                }

                public final int jK_() {
                    return 554057783;
                }

                public final GraphQLVisitableModel m3763a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m3760j() != null) {
                        EventModel eventModel = (EventModel) graphQLModelMutatingVisitor.b(m3760j());
                        if (m3760j() != eventModel) {
                            graphQLVisitableModel = (EventsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f3842d = eventModel;
                        }
                    }
                    if (m3761k() != null) {
                        DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m3761k());
                        if (m3761k() != defaultTextWithEntitiesLongFieldsModel) {
                            graphQLVisitableModel = (EventsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f3843e = defaultTextWithEntitiesLongFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m3762a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m3760j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m3761k());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1617735913)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: scroll_ready_ms */
            public final class LocationUpsellsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f3844d;
                @Nullable
                private DefaultImageFieldsModel f3845e;
                @Nullable
                private List<String> f3846f;
                @Nullable
                private DefaultTextWithEntitiesLongFieldsModel f3847g;
                @Nullable
                private DefaultTextWithEntitiesLongFieldsModel f3848h;
                @Nullable
                private String f3849i;
                @Nullable
                private DefaultTextWithEntitiesLongFieldsModel f3850j;

                /* compiled from: scroll_ready_ms */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(LocationUpsellsModel.class, new Deserializer());
                    }

                    public Object m3766a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(LocationUpsellsParser.m3829b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object locationUpsellsModel = new LocationUpsellsModel();
                        ((BaseModel) locationUpsellsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (locationUpsellsModel instanceof Postprocessable) {
                            return ((Postprocessable) locationUpsellsModel).a();
                        }
                        return locationUpsellsModel;
                    }
                }

                /* compiled from: scroll_ready_ms */
                public class Serializer extends JsonSerializer<LocationUpsellsModel> {
                    public final void m3767a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        LocationUpsellsModel locationUpsellsModel = (LocationUpsellsModel) obj;
                        if (locationUpsellsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(locationUpsellsModel.m3774a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            locationUpsellsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        LocationUpsellsParser.m3830b(locationUpsellsModel.w_(), locationUpsellsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(LocationUpsellsModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ DefaultImageFields m3777b() {
                    return m3768j();
                }

                @Nullable
                public final /* synthetic */ DefaultTextWithEntitiesLongFields m3778c() {
                    return m3770l();
                }

                @Nullable
                public final /* synthetic */ DefaultTextWithEntitiesLongFields m3779d() {
                    return m3771m();
                }

                public LocationUpsellsModel() {
                    super(7);
                }

                @Nullable
                public final String m3776a() {
                    this.f3844d = super.a(this.f3844d, 0);
                    return this.f3844d;
                }

                @Nullable
                private DefaultImageFieldsModel m3768j() {
                    this.f3845e = (DefaultImageFieldsModel) super.a(this.f3845e, 1, DefaultImageFieldsModel.class);
                    return this.f3845e;
                }

                @Nonnull
                private ImmutableList<String> m3769k() {
                    this.f3846f = super.a(this.f3846f, 2);
                    return (ImmutableList) this.f3846f;
                }

                @Nullable
                private DefaultTextWithEntitiesLongFieldsModel m3770l() {
                    this.f3847g = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f3847g, 3, DefaultTextWithEntitiesLongFieldsModel.class);
                    return this.f3847g;
                }

                @Nullable
                private DefaultTextWithEntitiesLongFieldsModel m3771m() {
                    this.f3848h = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f3848h, 4, DefaultTextWithEntitiesLongFieldsModel.class);
                    return this.f3848h;
                }

                @Nullable
                private String m3772n() {
                    this.f3849i = super.a(this.f3849i, 5);
                    return this.f3849i;
                }

                @Nullable
                private DefaultTextWithEntitiesLongFieldsModel m3773o() {
                    this.f3850j = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f3850j, 6, DefaultTextWithEntitiesLongFieldsModel.class);
                    return this.f3850j;
                }

                public final int jK_() {
                    return 1522549062;
                }

                public final GraphQLVisitableModel m3775a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel;
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m3768j() != null) {
                        DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m3768j());
                        if (m3768j() != defaultImageFieldsModel) {
                            graphQLVisitableModel = (LocationUpsellsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f3845e = defaultImageFieldsModel;
                        }
                    }
                    if (m3770l() != null) {
                        defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m3770l());
                        if (m3770l() != defaultTextWithEntitiesLongFieldsModel) {
                            graphQLVisitableModel = (LocationUpsellsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f3847g = defaultTextWithEntitiesLongFieldsModel;
                        }
                    }
                    if (m3771m() != null) {
                        defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m3771m());
                        if (m3771m() != defaultTextWithEntitiesLongFieldsModel) {
                            graphQLVisitableModel = (LocationUpsellsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f3848h = defaultTextWithEntitiesLongFieldsModel;
                        }
                    }
                    if (m3773o() != null) {
                        defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m3773o());
                        if (m3773o() != defaultTextWithEntitiesLongFieldsModel) {
                            graphQLVisitableModel = (LocationUpsellsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f3850j = defaultTextWithEntitiesLongFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m3774a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m3776a());
                    int a = ModelHelper.a(flatBufferBuilder, m3768j());
                    int c = flatBufferBuilder.c(m3769k());
                    int a2 = ModelHelper.a(flatBufferBuilder, m3770l());
                    int a3 = ModelHelper.a(flatBufferBuilder, m3771m());
                    int b2 = flatBufferBuilder.b(m3772n());
                    int a4 = ModelHelper.a(flatBufferBuilder, m3773o());
                    flatBufferBuilder.c(7);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, c);
                    flatBufferBuilder.b(3, a2);
                    flatBufferBuilder.b(4, a3);
                    flatBufferBuilder.b(5, b2);
                    flatBufferBuilder.b(6, a4);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1069660001)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: scroll_ready_ms */
            public final class PlacesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private PageModel f3859d;
                @Nullable
                private DefaultTextWithEntitiesFieldsModel f3860e;
                @Nullable
                private String f3861f;
                @Nullable
                private DefaultTextWithEntitiesFieldsModel f3862g;

                /* compiled from: scroll_ready_ms */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PlacesModel.class, new Deserializer());
                    }

                    public Object m3780a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PlacesParser.m3836b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object placesModel = new PlacesModel();
                        ((BaseModel) placesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (placesModel instanceof Postprocessable) {
                            return ((Postprocessable) placesModel).a();
                        }
                        return placesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1334571270)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: scroll_ready_ms */
                public final class PageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private GraphQLPageCategoryType f3853d;
                    @Nullable
                    private String f3854e;
                    @Nullable
                    private LocationModel f3855f;
                    @Nullable
                    private String f3856g;
                    @Nullable
                    private DefaultImageFieldsModel f3857h;
                    @Nullable
                    private String f3858i;

                    /* compiled from: scroll_ready_ms */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                        }

                        public Object m3781a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(PageParser.m3833a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object pageModel = new PageModel();
                            ((BaseModel) pageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (pageModel instanceof Postprocessable) {
                                return ((Postprocessable) pageModel).a();
                            }
                            return pageModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 918622653)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: scroll_ready_ms */
                    public final class LocationModel extends BaseModel implements GraphQLVisitableModel {
                        private double f3851d;
                        private double f3852e;

                        /* compiled from: scroll_ready_ms */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(LocationModel.class, new Deserializer());
                            }

                            public Object m3782a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(LocationParser.m3831a(jsonParser, flatBufferBuilder));
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

                        /* compiled from: scroll_ready_ms */
                        public class Serializer extends JsonSerializer<LocationModel> {
                            public final void m3783a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                LocationModel locationModel = (LocationModel) obj;
                                if (locationModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(locationModel.m3785a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    locationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                LocationParser.m3832a(locationModel.w_(), locationModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(LocationModel.class, new Serializer());
                            }
                        }

                        public LocationModel() {
                            super(2);
                        }

                        public final double m3784a() {
                            a(0, 0);
                            return this.f3851d;
                        }

                        public final double m3788b() {
                            a(0, 1);
                            return this.f3852e;
                        }

                        public final int jK_() {
                            return 1965687765;
                        }

                        public final GraphQLVisitableModel m3786a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m3785a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.a(0, this.f3851d, 0.0d);
                            flatBufferBuilder.a(1, this.f3852e, 0.0d);
                            i();
                            return flatBufferBuilder.d();
                        }

                        public final void m3787a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                            super.a(mutableFlatBuffer, i, obj);
                            this.f3851d = mutableFlatBuffer.a(i, 0, 0.0d);
                            this.f3852e = mutableFlatBuffer.a(i, 1, 0.0d);
                        }
                    }

                    /* compiled from: scroll_ready_ms */
                    public class Serializer extends JsonSerializer<PageModel> {
                        public final void m3789a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            PageModel pageModel = (PageModel) obj;
                            if (pageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(pageModel.m3792a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            PageParser.m3834a(pageModel.w_(), pageModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(PageModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ LocationModel m3799d() {
                        return m3790j();
                    }

                    @Nullable
                    public final /* synthetic */ DefaultImageFields m3800g() {
                        return m3791k();
                    }

                    public PageModel() {
                        super(6);
                    }

                    public final void m3795a(String str, ConsistencyTuple consistencyTuple) {
                        consistencyTuple.a();
                    }

                    public final void m3796a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    public final GraphQLPageCategoryType m3797b() {
                        this.f3853d = (GraphQLPageCategoryType) super.b(this.f3853d, 0, GraphQLPageCategoryType.class, GraphQLPageCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                        return this.f3853d;
                    }

                    @Nullable
                    public final String m3798c() {
                        this.f3854e = super.a(this.f3854e, 1);
                        return this.f3854e;
                    }

                    @Nullable
                    private LocationModel m3790j() {
                        this.f3855f = (LocationModel) super.a(this.f3855f, 2, LocationModel.class);
                        return this.f3855f;
                    }

                    @Nullable
                    public final String jd_() {
                        this.f3856g = super.a(this.f3856g, 3);
                        return this.f3856g;
                    }

                    @Nullable
                    private DefaultImageFieldsModel m3791k() {
                        this.f3857h = (DefaultImageFieldsModel) super.a(this.f3857h, 4, DefaultImageFieldsModel.class);
                        return this.f3857h;
                    }

                    @Nullable
                    public final String je_() {
                        this.f3858i = super.a(this.f3858i, 5);
                        return this.f3858i;
                    }

                    @Nullable
                    public final String m3794a() {
                        return m3798c();
                    }

                    public final int jK_() {
                        return 2479791;
                    }

                    public final GraphQLVisitableModel m3793a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m3790j() != null) {
                            LocationModel locationModel = (LocationModel) graphQLModelMutatingVisitor.b(m3790j());
                            if (m3790j() != locationModel) {
                                graphQLVisitableModel = (PageModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f3855f = locationModel;
                            }
                        }
                        if (m3791k() != null) {
                            DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m3791k());
                            if (m3791k() != defaultImageFieldsModel) {
                                graphQLVisitableModel = (PageModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f3857h = defaultImageFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m3792a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = flatBufferBuilder.a(m3797b());
                        int b = flatBufferBuilder.b(m3798c());
                        int a2 = ModelHelper.a(flatBufferBuilder, m3790j());
                        int b2 = flatBufferBuilder.b(jd_());
                        int a3 = ModelHelper.a(flatBufferBuilder, m3791k());
                        int b3 = flatBufferBuilder.b(je_());
                        flatBufferBuilder.c(6);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, b);
                        flatBufferBuilder.b(2, a2);
                        flatBufferBuilder.b(3, b2);
                        flatBufferBuilder.b(4, a3);
                        flatBufferBuilder.b(5, b3);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: scroll_ready_ms */
                public class Serializer extends JsonSerializer<PlacesModel> {
                    public final void m3801a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PlacesModel placesModel = (PlacesModel) obj;
                        if (placesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(placesModel.m3806a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            placesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PlacesParser.m3837b(placesModel.w_(), placesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(PlacesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ PageModel m3808a() {
                    return m3802j();
                }

                @Nullable
                public final /* synthetic */ DefaultTextWithEntitiesFields m3809b() {
                    return m3803k();
                }

                @Nullable
                public final /* synthetic */ DefaultTextWithEntitiesFields m3810c() {
                    return m3805m();
                }

                public PlacesModel() {
                    super(4);
                }

                @Nullable
                private PageModel m3802j() {
                    this.f3859d = (PageModel) super.a(this.f3859d, 0, PageModel.class);
                    return this.f3859d;
                }

                @Nullable
                private DefaultTextWithEntitiesFieldsModel m3803k() {
                    this.f3860e = (DefaultTextWithEntitiesFieldsModel) super.a(this.f3860e, 1, DefaultTextWithEntitiesFieldsModel.class);
                    return this.f3860e;
                }

                @Nullable
                private String m3804l() {
                    this.f3861f = super.a(this.f3861f, 2);
                    return this.f3861f;
                }

                @Nullable
                private DefaultTextWithEntitiesFieldsModel m3805m() {
                    this.f3862g = (DefaultTextWithEntitiesFieldsModel) super.a(this.f3862g, 3, DefaultTextWithEntitiesFieldsModel.class);
                    return this.f3862g;
                }

                public final int jK_() {
                    return 563914404;
                }

                public final GraphQLVisitableModel m3807a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel;
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m3802j() != null) {
                        PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m3802j());
                        if (m3802j() != pageModel) {
                            graphQLVisitableModel = (PlacesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f3859d = pageModel;
                        }
                    }
                    if (m3803k() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m3803k());
                        if (m3803k() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (PlacesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f3860e = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    if (m3805m() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m3805m());
                        if (m3805m() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (PlacesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f3862g = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m3806a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m3802j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m3803k());
                    int b = flatBufferBuilder.b(m3804l());
                    int a3 = ModelHelper.a(flatBufferBuilder, m3805m());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.b(2, b);
                    flatBufferBuilder.b(3, a3);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: scroll_ready_ms */
            public class Serializer extends JsonSerializer<UnitsModel> {
                public final void m3811a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    UnitsModel unitsModel = (UnitsModel) obj;
                    if (unitsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(unitsModel.m3812a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        unitsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    UnitsParser.m3839a(unitsModel.w_(), unitsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(UnitsModel.class, new Serializer());
                }
            }

            public UnitsModel() {
                super(4);
            }

            @Nonnull
            public final ImmutableList<EventsModel> m3814a() {
                this.f3863d = super.a(this.f3863d, 0, EventsModel.class);
                return (ImmutableList) this.f3863d;
            }

            public final int m3816b() {
                a(0, 1);
                return this.f3864e;
            }

            @Nonnull
            public final ImmutableList<LocationUpsellsModel> m3817c() {
                this.f3865f = super.a(this.f3865f, 2, LocationUpsellsModel.class);
                return (ImmutableList) this.f3865f;
            }

            @Nonnull
            public final ImmutableList<PlacesModel> m3818d() {
                this.f3866g = super.a(this.f3866g, 3, PlacesModel.class);
                return (ImmutableList) this.f3866g;
            }

            public final int jK_() {
                return 963552923;
            }

            public final GraphQLVisitableModel m3813a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                Builder a;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m3814a() != null) {
                    a = ModelHelper.a(m3814a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (UnitsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f3863d = a.b();
                    }
                }
                if (m3817c() != null) {
                    a = ModelHelper.a(m3817c(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (UnitsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f3865f = a.b();
                    }
                }
                if (m3818d() != null) {
                    a = ModelHelper.a(m3818d(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (UnitsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f3866g = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m3812a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m3814a());
                int a2 = ModelHelper.a(flatBufferBuilder, m3817c());
                int a3 = ModelHelper.a(flatBufferBuilder, m3818d());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f3864e, 0);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, a3);
                i();
                return flatBufferBuilder.d();
            }

            public final void m3815a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f3864e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        @Nullable
        public final /* synthetic */ UnitsModel m3822a() {
            return m3819j();
        }

        public LocationTriggerWithReactionUnitsModel() {
            super(1);
        }

        @Nullable
        private UnitsModel m3819j() {
            this.f3867d = (UnitsModel) super.a(this.f3867d, 0, UnitsModel.class);
            return this.f3867d;
        }

        public final int jK_() {
            return 2105729059;
        }

        public final GraphQLVisitableModel m3821a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3819j() != null) {
                UnitsModel unitsModel = (UnitsModel) graphQLModelMutatingVisitor.b(m3819j());
                if (m3819j() != unitsModel) {
                    graphQLVisitableModel = (LocationTriggerWithReactionUnitsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3867d = unitsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3820a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3819j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
