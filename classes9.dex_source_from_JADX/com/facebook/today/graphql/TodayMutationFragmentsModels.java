package com.facebook.today.graphql;

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
import com.facebook.graphql.enums.GraphQLWeatherTemperature;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.today.graphql.TodayMutationFragmentsParsers.TodayCalendarSettingsFragmentParser;
import com.facebook.today.graphql.TodayMutationFragmentsParsers.TodaySetWeatherPlaceProfilesMutationParser;
import com.facebook.today.graphql.TodayMutationFragmentsParsers.TodaySetWeatherTemperatureScaleUnitMutationParser;
import com.facebook.today.graphql.TodayMutationFragmentsParsers.TodayWeatherContentSettingsFragmentParser;
import com.facebook.today.graphql.TodayMutationFragmentsParsers.TodayWeatherContentSettingsFragmentParser.ProfilesParser;
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

/* compiled from: uber */
public class TodayMutationFragmentsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -401391568)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: uber */
    public final class TodayCalendarSettingsFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLWeatherTemperature f1194d;

        /* compiled from: uber */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TodayCalendarSettingsFragmentModel.class, new Deserializer());
            }

            public Object m1322a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TodayCalendarSettingsFragmentParser.m1351a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object todayCalendarSettingsFragmentModel = new TodayCalendarSettingsFragmentModel();
                ((BaseModel) todayCalendarSettingsFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (todayCalendarSettingsFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) todayCalendarSettingsFragmentModel).a();
                }
                return todayCalendarSettingsFragmentModel;
            }
        }

        /* compiled from: uber */
        public class Serializer extends JsonSerializer<TodayCalendarSettingsFragmentModel> {
            public final void m1323a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TodayCalendarSettingsFragmentModel todayCalendarSettingsFragmentModel = (TodayCalendarSettingsFragmentModel) obj;
                if (todayCalendarSettingsFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(todayCalendarSettingsFragmentModel.m1325a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    todayCalendarSettingsFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TodayCalendarSettingsFragmentParser.m1352a(todayCalendarSettingsFragmentModel.w_(), todayCalendarSettingsFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(TodayCalendarSettingsFragmentModel.class, new Serializer());
            }
        }

        public TodayCalendarSettingsFragmentModel() {
            super(1);
        }

        @Nullable
        private GraphQLWeatherTemperature m1324a() {
            this.f1194d = (GraphQLWeatherTemperature) super.b(this.f1194d, 0, GraphQLWeatherTemperature.class, GraphQLWeatherTemperature.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f1194d;
        }

        public final int jK_() {
            return -538426975;
        }

        public final GraphQLVisitableModel m1326a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m1325a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m1324a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1382296051)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: uber */
    public final class TodaySetWeatherPlaceProfilesMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private TodayWeatherContentSettingsFragmentModel f1195d;

        /* compiled from: uber */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TodaySetWeatherPlaceProfilesMutationModel.class, new Deserializer());
            }

            public Object m1327a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TodaySetWeatherPlaceProfilesMutationParser.m1353a(jsonParser);
                Object todaySetWeatherPlaceProfilesMutationModel = new TodaySetWeatherPlaceProfilesMutationModel();
                ((BaseModel) todaySetWeatherPlaceProfilesMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (todaySetWeatherPlaceProfilesMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) todaySetWeatherPlaceProfilesMutationModel).a();
                }
                return todaySetWeatherPlaceProfilesMutationModel;
            }
        }

        /* compiled from: uber */
        public class Serializer extends JsonSerializer<TodaySetWeatherPlaceProfilesMutationModel> {
            public final void m1328a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TodaySetWeatherPlaceProfilesMutationModel todaySetWeatherPlaceProfilesMutationModel = (TodaySetWeatherPlaceProfilesMutationModel) obj;
                if (todaySetWeatherPlaceProfilesMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(todaySetWeatherPlaceProfilesMutationModel.m1330a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    todaySetWeatherPlaceProfilesMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = todaySetWeatherPlaceProfilesMutationModel.w_();
                int u_ = todaySetWeatherPlaceProfilesMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("acorn_weather_content_settings");
                    TodayWeatherContentSettingsFragmentParser.m1358a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TodaySetWeatherPlaceProfilesMutationModel.class, new Serializer());
            }
        }

        public TodaySetWeatherPlaceProfilesMutationModel() {
            super(1);
        }

        @Nullable
        private TodayWeatherContentSettingsFragmentModel m1329a() {
            this.f1195d = (TodayWeatherContentSettingsFragmentModel) super.a(this.f1195d, 0, TodayWeatherContentSettingsFragmentModel.class);
            return this.f1195d;
        }

        public final int jK_() {
            return 714573522;
        }

        public final GraphQLVisitableModel m1331a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1329a() != null) {
                TodayWeatherContentSettingsFragmentModel todayWeatherContentSettingsFragmentModel = (TodayWeatherContentSettingsFragmentModel) graphQLModelMutatingVisitor.b(m1329a());
                if (m1329a() != todayWeatherContentSettingsFragmentModel) {
                    graphQLVisitableModel = (TodaySetWeatherPlaceProfilesMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1195d = todayWeatherContentSettingsFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1330a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1329a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -300994650)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: uber */
    public final class TodaySetWeatherTemperatureScaleUnitMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private TodayCalendarSettingsFragmentModel f1196d;

        /* compiled from: uber */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TodaySetWeatherTemperatureScaleUnitMutationModel.class, new Deserializer());
            }

            public Object m1332a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TodaySetWeatherTemperatureScaleUnitMutationParser.m1354a(jsonParser);
                Object todaySetWeatherTemperatureScaleUnitMutationModel = new TodaySetWeatherTemperatureScaleUnitMutationModel();
                ((BaseModel) todaySetWeatherTemperatureScaleUnitMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (todaySetWeatherTemperatureScaleUnitMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) todaySetWeatherTemperatureScaleUnitMutationModel).a();
                }
                return todaySetWeatherTemperatureScaleUnitMutationModel;
            }
        }

        /* compiled from: uber */
        public class Serializer extends JsonSerializer<TodaySetWeatherTemperatureScaleUnitMutationModel> {
            public final void m1333a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TodaySetWeatherTemperatureScaleUnitMutationModel todaySetWeatherTemperatureScaleUnitMutationModel = (TodaySetWeatherTemperatureScaleUnitMutationModel) obj;
                if (todaySetWeatherTemperatureScaleUnitMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(todaySetWeatherTemperatureScaleUnitMutationModel.m1335a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    todaySetWeatherTemperatureScaleUnitMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = todaySetWeatherTemperatureScaleUnitMutationModel.w_();
                int u_ = todaySetWeatherTemperatureScaleUnitMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("calendar_settings");
                    TodayCalendarSettingsFragmentParser.m1352a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TodaySetWeatherTemperatureScaleUnitMutationModel.class, new Serializer());
            }
        }

        public TodaySetWeatherTemperatureScaleUnitMutationModel() {
            super(1);
        }

        @Nullable
        private TodayCalendarSettingsFragmentModel m1334a() {
            this.f1196d = (TodayCalendarSettingsFragmentModel) super.a(this.f1196d, 0, TodayCalendarSettingsFragmentModel.class);
            return this.f1196d;
        }

        public final int jK_() {
            return -906889722;
        }

        public final GraphQLVisitableModel m1336a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1334a() != null) {
                TodayCalendarSettingsFragmentModel todayCalendarSettingsFragmentModel = (TodayCalendarSettingsFragmentModel) graphQLModelMutatingVisitor.b(m1334a());
                if (m1334a() != todayCalendarSettingsFragmentModel) {
                    graphQLVisitableModel = (TodaySetWeatherTemperatureScaleUnitMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1196d = todayCalendarSettingsFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1335a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1334a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2145335799)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: uber */
    public final class TodayWeatherContentSettingsFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<ProfilesModel> f1199d;

        /* compiled from: uber */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TodayWeatherContentSettingsFragmentModel.class, new Deserializer());
            }

            public Object m1337a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TodayWeatherContentSettingsFragmentParser.m1357a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object todayWeatherContentSettingsFragmentModel = new TodayWeatherContentSettingsFragmentModel();
                ((BaseModel) todayWeatherContentSettingsFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (todayWeatherContentSettingsFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) todayWeatherContentSettingsFragmentModel).a();
                }
                return todayWeatherContentSettingsFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1787905591)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: uber */
        public final class ProfilesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f1197d;
            @Nullable
            private String f1198e;

            /* compiled from: uber */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfilesModel.class, new Deserializer());
                }

                public Object m1338a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfilesParser.m1356b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object profilesModel = new ProfilesModel();
                    ((BaseModel) profilesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (profilesModel instanceof Postprocessable) {
                        return ((Postprocessable) profilesModel).a();
                    }
                    return profilesModel;
                }
            }

            /* compiled from: uber */
            public class Serializer extends JsonSerializer<ProfilesModel> {
                public final void m1339a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfilesModel profilesModel = (ProfilesModel) obj;
                    if (profilesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profilesModel.m1342a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profilesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfilesParser.m1355a(profilesModel.w_(), profilesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ProfilesModel.class, new Serializer());
                }
            }

            public ProfilesModel() {
                super(2);
            }

            public final void m1345a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m1346a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m1340j() {
                if (this.b != null && this.f1197d == null) {
                    this.f1197d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f1197d;
            }

            @Nullable
            private String m1341k() {
                this.f1198e = super.a(this.f1198e, 1);
                return this.f1198e;
            }

            @Nullable
            public final String m1344a() {
                return m1341k();
            }

            public final int jK_() {
                return 1355227529;
            }

            public final GraphQLVisitableModel m1343a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1342a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1340j());
                int b = flatBufferBuilder.b(m1341k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: uber */
        public class Serializer extends JsonSerializer<TodayWeatherContentSettingsFragmentModel> {
            public final void m1347a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TodayWeatherContentSettingsFragmentModel todayWeatherContentSettingsFragmentModel = (TodayWeatherContentSettingsFragmentModel) obj;
                if (todayWeatherContentSettingsFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(todayWeatherContentSettingsFragmentModel.m1349a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    todayWeatherContentSettingsFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TodayWeatherContentSettingsFragmentParser.m1358a(todayWeatherContentSettingsFragmentModel.w_(), todayWeatherContentSettingsFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TodayWeatherContentSettingsFragmentModel.class, new Serializer());
            }
        }

        public TodayWeatherContentSettingsFragmentModel() {
            super(1);
        }

        @Nonnull
        private ImmutableList<ProfilesModel> m1348a() {
            this.f1199d = super.a(this.f1199d, 0, ProfilesModel.class);
            return (ImmutableList) this.f1199d;
        }

        public final int jK_() {
            return 548262897;
        }

        public final GraphQLVisitableModel m1350a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1348a() != null) {
                Builder a = ModelHelper.a(m1348a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (TodayWeatherContentSettingsFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1199d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1349a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1348a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
