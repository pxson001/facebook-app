package com.facebook.adsexperiencetool.protocol;

import com.facebook.adsexperiencetool.protocol.AdsExperienceMutationsParsers.AdsExperienceDeclineMutationParser;
import com.facebook.adsexperiencetool.protocol.AdsExperienceMutationsParsers.AdsExperienceDeclineMutationParser.ViewerParser;
import com.facebook.adsexperiencetool.protocol.AdsExperienceMutationsParsers.AdsExperienceDeclineMutationParser.ViewerParser.ActorParser;
import com.facebook.adsexperiencetool.protocol.AdsExperienceMutationsParsers.AdsExperienceInjectMutationParser;
import com.facebook.adsexperiencetool.protocol.AdsExperienceMutationsParsers.AdsExperienceRemoveMutationParser;
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
import com.facebook.zero.onboarding.graphql.AssistedOnboardingParsers.AssistedRegSendInviteWithSourceParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: ephemeral_keyboard */
public class AdsExperienceMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 284860537)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ephemeral_keyboard */
    public final class AdsExperienceDeclineMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ViewerModel f14437d;

        /* compiled from: ephemeral_keyboard */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AdsExperienceDeclineMutationModel.class, new Deserializer());
            }

            public Object m14523a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AdsExperienceDeclineMutationParser.m14583a(jsonParser);
                Object adsExperienceDeclineMutationModel = new AdsExperienceDeclineMutationModel();
                ((BaseModel) adsExperienceDeclineMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (adsExperienceDeclineMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) adsExperienceDeclineMutationModel).a();
                }
                return adsExperienceDeclineMutationModel;
            }
        }

        /* compiled from: ephemeral_keyboard */
        public class Serializer extends JsonSerializer<AdsExperienceDeclineMutationModel> {
            public final void m14524a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AdsExperienceDeclineMutationModel adsExperienceDeclineMutationModel = (AdsExperienceDeclineMutationModel) obj;
                if (adsExperienceDeclineMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(adsExperienceDeclineMutationModel.m14540a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    adsExperienceDeclineMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = adsExperienceDeclineMutationModel.w_();
                int u_ = adsExperienceDeclineMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("viewer");
                    AssistedRegSendInviteWithSourceParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AdsExperienceDeclineMutationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1180634904)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ephemeral_keyboard */
        public final class ViewerModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ActorModel f14436d;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1787905591)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: ephemeral_keyboard */
            public final class ActorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f14434d;
                @Nullable
                private String f14435e;

                /* compiled from: ephemeral_keyboard */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ActorModel.class, new Deserializer());
                    }

                    public Object m14525a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ActorParser.m14581a(jsonParser, flatBufferBuilder));
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

                /* compiled from: ephemeral_keyboard */
                public class Serializer extends JsonSerializer<ActorModel> {
                    public final void m14526a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ActorModel actorModel = (ActorModel) obj;
                        if (actorModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(actorModel.m14529a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            actorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        AssistedRegSendInviteWithSourceParser.a(actorModel.w_(), actorModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ActorModel.class, new Serializer());
                    }
                }

                public ActorModel() {
                    super(2);
                }

                public final void m14532a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m14533a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLObjectType m14527j() {
                    if (this.b != null && this.f14434d == null) {
                        this.f14434d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f14434d;
                }

                @Nullable
                private String m14528k() {
                    this.f14435e = super.a(this.f14435e, 1);
                    return this.f14435e;
                }

                @Nullable
                public final String m14531a() {
                    return m14528k();
                }

                public final int jK_() {
                    return 63093205;
                }

                public final GraphQLVisitableModel m14530a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m14529a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m14527j());
                    int b = flatBufferBuilder.b(m14528k());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: ephemeral_keyboard */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerModel.class, new Deserializer());
                }

                public Object m14534a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewerParser.m14582a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object viewerModel = new ViewerModel();
                    ((BaseModel) viewerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (viewerModel instanceof Postprocessable) {
                        return ((Postprocessable) viewerModel).a();
                    }
                    return viewerModel;
                }
            }

            /* compiled from: ephemeral_keyboard */
            public class Serializer extends JsonSerializer<ViewerModel> {
                public final void m14535a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerModel viewerModel = (ViewerModel) obj;
                    if (viewerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerModel.m14537a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AssistedRegSendInviteWithSourceParser.a(viewerModel.w_(), viewerModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ViewerModel.class, new Serializer());
                }
            }

            public ViewerModel() {
                super(1);
            }

            @Nullable
            private ActorModel m14536a() {
                this.f14436d = (ActorModel) super.a(this.f14436d, 0, ActorModel.class);
                return this.f14436d;
            }

            public final int jK_() {
                return -1732764110;
            }

            public final GraphQLVisitableModel m14538a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14536a() != null) {
                    ActorModel actorModel = (ActorModel) graphQLModelMutatingVisitor.b(m14536a());
                    if (m14536a() != actorModel) {
                        graphQLVisitableModel = (ViewerModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f14436d = actorModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14537a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m14536a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public AdsExperienceDeclineMutationModel() {
            super(1);
        }

        @Nullable
        private ViewerModel m14539a() {
            this.f14437d = (ViewerModel) super.a(this.f14437d, 0, ViewerModel.class);
            return this.f14437d;
        }

        public final int jK_() {
            return -1405283599;
        }

        public final GraphQLVisitableModel m14541a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14539a() != null) {
                ViewerModel viewerModel = (ViewerModel) graphQLModelMutatingVisitor.b(m14539a());
                if (m14539a() != viewerModel) {
                    graphQLVisitableModel = (AdsExperienceDeclineMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14437d = viewerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14540a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14539a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1217692918)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ephemeral_keyboard */
    public final class AdsExperienceInjectMutationModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f14441d;
        @Nullable
        private ViewerModel f14442e;

        /* compiled from: ephemeral_keyboard */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AdsExperienceInjectMutationModel.class, new Deserializer());
            }

            public Object m14542a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AdsExperienceInjectMutationParser.m14588a(jsonParser);
                Object adsExperienceInjectMutationModel = new AdsExperienceInjectMutationModel();
                ((BaseModel) adsExperienceInjectMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (adsExperienceInjectMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) adsExperienceInjectMutationModel).a();
                }
                return adsExperienceInjectMutationModel;
            }
        }

        /* compiled from: ephemeral_keyboard */
        public class Serializer extends JsonSerializer<AdsExperienceInjectMutationModel> {
            public final void m14543a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AdsExperienceInjectMutationModel adsExperienceInjectMutationModel = (AdsExperienceInjectMutationModel) obj;
                if (adsExperienceInjectMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(adsExperienceInjectMutationModel.m14559a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    adsExperienceInjectMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = adsExperienceInjectMutationModel.w_();
                int u_ = adsExperienceInjectMutationModel.u_();
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(u_, 0);
                if (a) {
                    jsonGenerator.a("inject_status");
                    jsonGenerator.a(a);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("viewer");
                    AdsExperienceInjectMutationParser.ViewerParser.m14587a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AdsExperienceInjectMutationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2077514118)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ephemeral_keyboard */
        public final class ViewerModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ActorModel f14440d;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1787905591)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: ephemeral_keyboard */
            public final class ActorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f14438d;
                @Nullable
                private String f14439e;

                /* compiled from: ephemeral_keyboard */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ActorModel.class, new Deserializer());
                    }

                    public Object m14544a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(AdsExperienceInjectMutationParser.ViewerParser.ActorParser.m14584a(jsonParser, flatBufferBuilder));
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

                /* compiled from: ephemeral_keyboard */
                public class Serializer extends JsonSerializer<ActorModel> {
                    public final void m14545a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ActorModel actorModel = (ActorModel) obj;
                        if (actorModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(actorModel.m14548a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            actorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        AdsExperienceInjectMutationParser.ViewerParser.ActorParser.m14585a(actorModel.w_(), actorModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ActorModel.class, new Serializer());
                    }
                }

                public ActorModel() {
                    super(2);
                }

                public final void m14551a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m14552a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLObjectType m14546j() {
                    if (this.b != null && this.f14438d == null) {
                        this.f14438d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f14438d;
                }

                @Nullable
                private String m14547k() {
                    this.f14439e = super.a(this.f14439e, 1);
                    return this.f14439e;
                }

                @Nullable
                public final String m14550a() {
                    return m14547k();
                }

                public final int jK_() {
                    return 63093205;
                }

                public final GraphQLVisitableModel m14549a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m14548a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m14546j());
                    int b = flatBufferBuilder.b(m14547k());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: ephemeral_keyboard */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerModel.class, new Deserializer());
                }

                public Object m14553a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AdsExperienceInjectMutationParser.ViewerParser.m14586a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object viewerModel = new ViewerModel();
                    ((BaseModel) viewerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (viewerModel instanceof Postprocessable) {
                        return ((Postprocessable) viewerModel).a();
                    }
                    return viewerModel;
                }
            }

            /* compiled from: ephemeral_keyboard */
            public class Serializer extends JsonSerializer<ViewerModel> {
                public final void m14554a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerModel viewerModel = (ViewerModel) obj;
                    if (viewerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerModel.m14556a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AdsExperienceInjectMutationParser.ViewerParser.m14587a(viewerModel.w_(), viewerModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ViewerModel.class, new Serializer());
                }
            }

            public ViewerModel() {
                super(1);
            }

            @Nullable
            private ActorModel m14555a() {
                this.f14440d = (ActorModel) super.a(this.f14440d, 0, ActorModel.class);
                return this.f14440d;
            }

            public final int jK_() {
                return -1732764110;
            }

            public final GraphQLVisitableModel m14557a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14555a() != null) {
                    ActorModel actorModel = (ActorModel) graphQLModelMutatingVisitor.b(m14555a());
                    if (m14555a() != actorModel) {
                        graphQLVisitableModel = (ViewerModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f14440d = actorModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14556a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m14555a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public AdsExperienceInjectMutationModel() {
            super(2);
        }

        @Nullable
        private ViewerModel m14558a() {
            this.f14442e = (ViewerModel) super.a(this.f14442e, 1, ViewerModel.class);
            return this.f14442e;
        }

        public final int jK_() {
            return 1443800642;
        }

        public final GraphQLVisitableModel m14560a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14558a() != null) {
                ViewerModel viewerModel = (ViewerModel) graphQLModelMutatingVisitor.b(m14558a());
                if (m14558a() != viewerModel) {
                    graphQLVisitableModel = (AdsExperienceInjectMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14442e = viewerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14559a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14558a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f14441d);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m14561a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f14441d = mutableFlatBuffer.a(i, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1548277243)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ephemeral_keyboard */
    public final class AdsExperienceRemoveMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ViewerModel f14446d;

        /* compiled from: ephemeral_keyboard */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AdsExperienceRemoveMutationModel.class, new Deserializer());
            }

            public Object m14562a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AdsExperienceRemoveMutationParser.m14593a(jsonParser);
                Object adsExperienceRemoveMutationModel = new AdsExperienceRemoveMutationModel();
                ((BaseModel) adsExperienceRemoveMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (adsExperienceRemoveMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) adsExperienceRemoveMutationModel).a();
                }
                return adsExperienceRemoveMutationModel;
            }
        }

        /* compiled from: ephemeral_keyboard */
        public class Serializer extends JsonSerializer<AdsExperienceRemoveMutationModel> {
            public final void m14563a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AdsExperienceRemoveMutationModel adsExperienceRemoveMutationModel = (AdsExperienceRemoveMutationModel) obj;
                if (adsExperienceRemoveMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(adsExperienceRemoveMutationModel.m14579a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    adsExperienceRemoveMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = adsExperienceRemoveMutationModel.w_();
                int u_ = adsExperienceRemoveMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("viewer");
                    AdsExperienceRemoveMutationParser.ViewerParser.m14592a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AdsExperienceRemoveMutationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1906642885)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ephemeral_keyboard */
        public final class ViewerModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ActorModel f14445d;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1787905591)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: ephemeral_keyboard */
            public final class ActorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f14443d;
                @Nullable
                private String f14444e;

                /* compiled from: ephemeral_keyboard */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ActorModel.class, new Deserializer());
                    }

                    public Object m14564a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(AdsExperienceRemoveMutationParser.ViewerParser.ActorParser.m14589a(jsonParser, flatBufferBuilder));
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

                /* compiled from: ephemeral_keyboard */
                public class Serializer extends JsonSerializer<ActorModel> {
                    public final void m14565a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ActorModel actorModel = (ActorModel) obj;
                        if (actorModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(actorModel.m14568a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            actorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        AdsExperienceRemoveMutationParser.ViewerParser.ActorParser.m14590a(actorModel.w_(), actorModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ActorModel.class, new Serializer());
                    }
                }

                public ActorModel() {
                    super(2);
                }

                public final void m14571a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m14572a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLObjectType m14566j() {
                    if (this.b != null && this.f14443d == null) {
                        this.f14443d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f14443d;
                }

                @Nullable
                private String m14567k() {
                    this.f14444e = super.a(this.f14444e, 1);
                    return this.f14444e;
                }

                @Nullable
                public final String m14570a() {
                    return m14567k();
                }

                public final int jK_() {
                    return 63093205;
                }

                public final GraphQLVisitableModel m14569a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m14568a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m14566j());
                    int b = flatBufferBuilder.b(m14567k());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: ephemeral_keyboard */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerModel.class, new Deserializer());
                }

                public Object m14573a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AdsExperienceRemoveMutationParser.ViewerParser.m14591a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object viewerModel = new ViewerModel();
                    ((BaseModel) viewerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (viewerModel instanceof Postprocessable) {
                        return ((Postprocessable) viewerModel).a();
                    }
                    return viewerModel;
                }
            }

            /* compiled from: ephemeral_keyboard */
            public class Serializer extends JsonSerializer<ViewerModel> {
                public final void m14574a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerModel viewerModel = (ViewerModel) obj;
                    if (viewerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerModel.m14576a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AdsExperienceRemoveMutationParser.ViewerParser.m14592a(viewerModel.w_(), viewerModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ViewerModel.class, new Serializer());
                }
            }

            public ViewerModel() {
                super(1);
            }

            @Nullable
            private ActorModel m14575a() {
                this.f14445d = (ActorModel) super.a(this.f14445d, 0, ActorModel.class);
                return this.f14445d;
            }

            public final int jK_() {
                return -1732764110;
            }

            public final GraphQLVisitableModel m14577a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14575a() != null) {
                    ActorModel actorModel = (ActorModel) graphQLModelMutatingVisitor.b(m14575a());
                    if (m14575a() != actorModel) {
                        graphQLVisitableModel = (ViewerModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f14445d = actorModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14576a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m14575a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public AdsExperienceRemoveMutationModel() {
            super(1);
        }

        @Nullable
        private ViewerModel m14578a() {
            this.f14446d = (ViewerModel) super.a(this.f14446d, 0, ViewerModel.class);
            return this.f14446d;
        }

        public final int jK_() {
            return 2122330863;
        }

        public final GraphQLVisitableModel m14580a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14578a() != null) {
                ViewerModel viewerModel = (ViewerModel) graphQLModelMutatingVisitor.b(m14578a());
                if (m14578a() != viewerModel) {
                    graphQLVisitableModel = (AdsExperienceRemoveMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14446d = viewerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14579a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14578a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
