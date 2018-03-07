package com.facebook.friends.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.friends.protocol.FetchDailyDialogueContactImporterParsers.DailyDialogueContactImporterQueryParser;
import com.facebook.friends.protocol.FetchDailyDialogueContactImporterParsers.DailyDialogueContactImporterQueryParser.ActorParser;
import com.facebook.friends.protocol.FetchDailyDialogueContactImporterParsers.DailyDialogueContactImporterQueryParser.DailyDialogueContactImporterParser;
import com.facebook.friends.protocol.FetchDailyDialogueContactImporterParsers.DailyDialogueContactImporterQueryParser.DailyDialogueContactImporterParser.SubtitleParser;
import com.facebook.friends.protocol.FetchDailyDialogueContactImporterParsers.DailyDialogueContactImporterQueryParser.DailyDialogueContactImporterParser.TitleParser;
import com.facebook.friends.protocol.FriendsWhoUsedContactImporterGraphQLModels.FacepileFriendsConnectionModel;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
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
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: marking  */
public class FetchDailyDialogueContactImporterModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1975074020)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: marking  */
    public final class DailyDialogueContactImporterQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ActorModel f10698d;
        @Nullable
        private DailyDialogueContactImporterModel f10699e;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1308842479)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: marking  */
        public final class ActorModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f10690d;
            @Nullable
            private FacepileFriendsConnectionModel f10691e;

            /* compiled from: marking  */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ActorModel.class, new Deserializer());
                }

                public Object m16875a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ActorParser.m16907a(jsonParser, flatBufferBuilder));
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

            /* compiled from: marking  */
            public class Serializer extends JsonSerializer<ActorModel> {
                public final void m16876a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ActorModel actorModel = (ActorModel) obj;
                    if (actorModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(actorModel.m16878a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        actorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ActorParser.m16908a(actorModel.w_(), actorModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ActorModel.class, new Serializer());
                }
            }

            public ActorModel() {
                super(2);
            }

            public final void m16881a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m16882a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m16877j() {
                if (this.b != null && this.f10690d == null) {
                    this.f10690d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f10690d;
            }

            @Nullable
            public final FacepileFriendsConnectionModel m16879a() {
                this.f10691e = (FacepileFriendsConnectionModel) super.a(this.f10691e, 1, FacepileFriendsConnectionModel.class);
                return this.f10691e;
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m16880a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16879a() != null) {
                    FacepileFriendsConnectionModel facepileFriendsConnectionModel = (FacepileFriendsConnectionModel) graphQLModelMutatingVisitor.b(m16879a());
                    if (m16879a() != facepileFriendsConnectionModel) {
                        graphQLVisitableModel = (ActorModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10691e = facepileFriendsConnectionModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16878a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16877j());
                int a2 = ModelHelper.a(flatBufferBuilder, m16879a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1279259670)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: marking  */
        public final class DailyDialogueContactImporterModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private DefaultImageFieldsModel f10694d;
            @Nullable
            private DefaultImageFieldsModel f10695e;
            @Nullable
            private SubtitleModel f10696f;
            @Nullable
            private TitleModel f10697g;

            /* compiled from: marking  */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(DailyDialogueContactImporterModel.class, new Deserializer());
                }

                public Object m16883a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(DailyDialogueContactImporterParser.m16913a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object dailyDialogueContactImporterModel = new DailyDialogueContactImporterModel();
                    ((BaseModel) dailyDialogueContactImporterModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (dailyDialogueContactImporterModel instanceof Postprocessable) {
                        return ((Postprocessable) dailyDialogueContactImporterModel).a();
                    }
                    return dailyDialogueContactImporterModel;
                }
            }

            /* compiled from: marking  */
            public class Serializer extends JsonSerializer<DailyDialogueContactImporterModel> {
                public final void m16884a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    DailyDialogueContactImporterModel dailyDialogueContactImporterModel = (DailyDialogueContactImporterModel) obj;
                    if (dailyDialogueContactImporterModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(dailyDialogueContactImporterModel.m16895a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        dailyDialogueContactImporterModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    DailyDialogueContactImporterParser.m16914a(dailyDialogueContactImporterModel.w_(), dailyDialogueContactImporterModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(DailyDialogueContactImporterModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: marking  */
            public final class SubtitleModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f10692d;

                /* compiled from: marking  */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(SubtitleModel.class, new Deserializer());
                    }

                    public Object m16885a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(SubtitleParser.m16909a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object subtitleModel = new SubtitleModel();
                        ((BaseModel) subtitleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (subtitleModel instanceof Postprocessable) {
                            return ((Postprocessable) subtitleModel).a();
                        }
                        return subtitleModel;
                    }
                }

                /* compiled from: marking  */
                public class Serializer extends JsonSerializer<SubtitleModel> {
                    public final void m16886a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        SubtitleModel subtitleModel = (SubtitleModel) obj;
                        if (subtitleModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(subtitleModel.m16887a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            subtitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        SubtitleParser.m16910a(subtitleModel.w_(), subtitleModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(SubtitleModel.class, new Serializer());
                    }
                }

                public SubtitleModel() {
                    super(1);
                }

                @Nullable
                public final String m16889a() {
                    this.f10692d = super.a(this.f10692d, 0);
                    return this.f10692d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m16888a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m16887a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m16889a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: marking  */
            public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f10693d;

                /* compiled from: marking  */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                    }

                    public Object m16890a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(TitleParser.m16911a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object titleModel = new TitleModel();
                        ((BaseModel) titleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (titleModel instanceof Postprocessable) {
                            return ((Postprocessable) titleModel).a();
                        }
                        return titleModel;
                    }
                }

                /* compiled from: marking  */
                public class Serializer extends JsonSerializer<TitleModel> {
                    public final void m16891a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TitleModel titleModel = (TitleModel) obj;
                        if (titleModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(titleModel.m16892a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        TitleParser.m16912a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(TitleModel.class, new Serializer());
                    }
                }

                public TitleModel() {
                    super(1);
                }

                @Nullable
                public final String m16894a() {
                    this.f10693d = super.a(this.f10693d, 0);
                    return this.f10693d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m16893a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m16892a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m16894a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public DailyDialogueContactImporterModel() {
                super(4);
            }

            @Nullable
            public final DefaultImageFieldsModel m16896a() {
                this.f10694d = (DefaultImageFieldsModel) super.a(this.f10694d, 0, DefaultImageFieldsModel.class);
                return this.f10694d;
            }

            @Nullable
            public final DefaultImageFieldsModel m16898j() {
                this.f10695e = (DefaultImageFieldsModel) super.a(this.f10695e, 1, DefaultImageFieldsModel.class);
                return this.f10695e;
            }

            @Nullable
            public final SubtitleModel m16899k() {
                this.f10696f = (SubtitleModel) super.a(this.f10696f, 2, SubtitleModel.class);
                return this.f10696f;
            }

            @Nullable
            public final TitleModel m16900l() {
                this.f10697g = (TitleModel) super.a(this.f10697g, 3, TitleModel.class);
                return this.f10697g;
            }

            public final int jK_() {
                return -1381672669;
            }

            public final GraphQLVisitableModel m16897a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                DefaultImageFieldsModel defaultImageFieldsModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16896a() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m16896a());
                    if (m16896a() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (DailyDialogueContactImporterModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10694d = defaultImageFieldsModel;
                    }
                }
                if (m16898j() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m16898j());
                    if (m16898j() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (DailyDialogueContactImporterModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10695e = defaultImageFieldsModel;
                    }
                }
                if (m16899k() != null) {
                    SubtitleModel subtitleModel = (SubtitleModel) graphQLModelMutatingVisitor.b(m16899k());
                    if (m16899k() != subtitleModel) {
                        graphQLVisitableModel = (DailyDialogueContactImporterModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10696f = subtitleModel;
                    }
                }
                if (m16900l() != null) {
                    TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m16900l());
                    if (m16900l() != titleModel) {
                        graphQLVisitableModel = (DailyDialogueContactImporterModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10697g = titleModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16895a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16896a());
                int a2 = ModelHelper.a(flatBufferBuilder, m16898j());
                int a3 = ModelHelper.a(flatBufferBuilder, m16899k());
                int a4 = ModelHelper.a(flatBufferBuilder, m16900l());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, a4);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: marking  */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DailyDialogueContactImporterQueryModel.class, new Deserializer());
            }

            public Object m16901a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = DailyDialogueContactImporterQueryParser.m16915a(jsonParser);
                Object dailyDialogueContactImporterQueryModel = new DailyDialogueContactImporterQueryModel();
                ((BaseModel) dailyDialogueContactImporterQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (dailyDialogueContactImporterQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) dailyDialogueContactImporterQueryModel).a();
                }
                return dailyDialogueContactImporterQueryModel;
            }
        }

        /* compiled from: marking  */
        public class Serializer extends JsonSerializer<DailyDialogueContactImporterQueryModel> {
            public final void m16902a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                DailyDialogueContactImporterQueryModel dailyDialogueContactImporterQueryModel = (DailyDialogueContactImporterQueryModel) obj;
                if (dailyDialogueContactImporterQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(dailyDialogueContactImporterQueryModel.m16903a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    dailyDialogueContactImporterQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = dailyDialogueContactImporterQueryModel.w_();
                int u_ = dailyDialogueContactImporterQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("actor");
                    ActorParser.m16908a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("daily_dialogue_contact_importer");
                    DailyDialogueContactImporterParser.m16914a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(DailyDialogueContactImporterQueryModel.class, new Serializer());
            }
        }

        public DailyDialogueContactImporterQueryModel() {
            super(2);
        }

        @Nullable
        public final ActorModel m16904a() {
            this.f10698d = (ActorModel) super.a(this.f10698d, 0, ActorModel.class);
            return this.f10698d;
        }

        @Nullable
        public final DailyDialogueContactImporterModel m16906j() {
            this.f10699e = (DailyDialogueContactImporterModel) super.a(this.f10699e, 1, DailyDialogueContactImporterModel.class);
            return this.f10699e;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m16905a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16904a() != null) {
                ActorModel actorModel = (ActorModel) graphQLModelMutatingVisitor.b(m16904a());
                if (m16904a() != actorModel) {
                    graphQLVisitableModel = (DailyDialogueContactImporterQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10698d = actorModel;
                }
            }
            if (m16906j() != null) {
                DailyDialogueContactImporterModel dailyDialogueContactImporterModel = (DailyDialogueContactImporterModel) graphQLModelMutatingVisitor.b(m16906j());
                if (m16906j() != dailyDialogueContactImporterModel) {
                    graphQLVisitableModel = (DailyDialogueContactImporterQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10699e = dailyDialogueContactImporterModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16903a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16904a());
            int a2 = ModelHelper.a(flatBufferBuilder, m16906j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
