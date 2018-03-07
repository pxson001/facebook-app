package com.facebook.notifications.protocol;

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
import com.facebook.notifications.protocol.NotificationSettingMutationsParsers.PushNotificationsMuteMutationParser;
import com.facebook.notifications.protocol.NotificationSettingMutationsParsers.PushNotificationsMuteMutationParser.PushTokenParser;
import com.facebook.notifications.protocol.NotificationSettingMutationsParsers.PushNotificationsMuteMutationParser.PushTokenParser.ApplicationParser;
import com.facebook.notifications.protocol.NotificationSettingMutationsParsers.PushNotificationsMuteMutationParser.PushTokenParser.OwnerParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: name can not be null */
public class NotificationSettingMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 364156867)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: name can not be null */
    public final class PushNotificationsMuteMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f8570d;
        @Nullable
        private PushTokenModel f8571e;

        /* compiled from: name can not be null */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PushNotificationsMuteMutationModel.class, new Deserializer());
            }

            public Object m10387a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PushNotificationsMuteMutationParser.m10425a(jsonParser);
                Object pushNotificationsMuteMutationModel = new PushNotificationsMuteMutationModel();
                ((BaseModel) pushNotificationsMuteMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pushNotificationsMuteMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) pushNotificationsMuteMutationModel).a();
                }
                return pushNotificationsMuteMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1337468779)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: name can not be null */
        public final class PushTokenModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ApplicationModel f8567d;
            private long f8568e;
            @Nullable
            private OwnerModel f8569f;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 415735059)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: name can not be null */
            public final class ApplicationModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private String f8560d;
                @Nullable
                private String f8561e;
                @Nullable
                private String f8562f;

                /* compiled from: name can not be null */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ApplicationModel.class, new Deserializer());
                    }

                    public Object m10388a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ApplicationParser.m10419a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object applicationModel = new ApplicationModel();
                        ((BaseModel) applicationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (applicationModel instanceof Postprocessable) {
                            return ((Postprocessable) applicationModel).a();
                        }
                        return applicationModel;
                    }
                }

                /* compiled from: name can not be null */
                public class Serializer extends JsonSerializer<ApplicationModel> {
                    public final void m10389a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ApplicationModel applicationModel = (ApplicationModel) obj;
                        if (applicationModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(applicationModel.m10393a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            applicationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ApplicationParser.m10420a(applicationModel.w_(), applicationModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ApplicationModel.class, new Serializer());
                    }
                }

                public ApplicationModel() {
                    super(3);
                }

                @Nullable
                private String m10390j() {
                    this.f8560d = super.a(this.f8560d, 0);
                    return this.f8560d;
                }

                @Nullable
                private String m10391k() {
                    this.f8561e = super.a(this.f8561e, 1);
                    return this.f8561e;
                }

                @Nullable
                private String m10392l() {
                    this.f8562f = super.a(this.f8562f, 2);
                    return this.f8562f;
                }

                @Nullable
                public final String m10395a() {
                    return m10390j();
                }

                public final int jK_() {
                    return -1072845520;
                }

                public final GraphQLVisitableModel m10394a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m10393a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m10390j());
                    int b2 = flatBufferBuilder.b(m10391k());
                    int b3 = flatBufferBuilder.b(m10392l());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    flatBufferBuilder.b(2, b3);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: name can not be null */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PushTokenModel.class, new Deserializer());
                }

                public Object m10396a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PushTokenParser.m10423a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pushTokenModel = new PushTokenModel();
                    ((BaseModel) pushTokenModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pushTokenModel instanceof Postprocessable) {
                        return ((Postprocessable) pushTokenModel).a();
                    }
                    return pushTokenModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1821837936)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: name can not be null */
            public final class OwnerModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f8563d;
                @Nullable
                private String f8564e;
                @Nullable
                private String f8565f;
                @Nullable
                private String f8566g;

                /* compiled from: name can not be null */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(OwnerModel.class, new Deserializer());
                    }

                    public Object m10397a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(OwnerParser.m10421a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object ownerModel = new OwnerModel();
                        ((BaseModel) ownerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (ownerModel instanceof Postprocessable) {
                            return ((Postprocessable) ownerModel).a();
                        }
                        return ownerModel;
                    }
                }

                /* compiled from: name can not be null */
                public class Serializer extends JsonSerializer<OwnerModel> {
                    public final void m10398a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        OwnerModel ownerModel = (OwnerModel) obj;
                        if (ownerModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ownerModel.m10403a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            ownerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        OwnerParser.m10422a(ownerModel.w_(), ownerModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(OwnerModel.class, new Serializer());
                    }
                }

                public OwnerModel() {
                    super(4);
                }

                public final void m10406a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m10407a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLObjectType m10399j() {
                    if (this.b != null && this.f8563d == null) {
                        this.f8563d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f8563d;
                }

                @Nullable
                private String m10400k() {
                    this.f8564e = super.a(this.f8564e, 1);
                    return this.f8564e;
                }

                @Nullable
                private String m10401l() {
                    this.f8565f = super.a(this.f8565f, 2);
                    return this.f8565f;
                }

                @Nullable
                private String m10402m() {
                    this.f8566g = super.a(this.f8566g, 3);
                    return this.f8566g;
                }

                @Nullable
                public final String m10405a() {
                    return m10400k();
                }

                public final int jK_() {
                    return 63093205;
                }

                public final GraphQLVisitableModel m10404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m10403a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m10399j());
                    int b = flatBufferBuilder.b(m10400k());
                    int b2 = flatBufferBuilder.b(m10401l());
                    int b3 = flatBufferBuilder.b(m10402m());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.b(3, b3);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: name can not be null */
            public class Serializer extends JsonSerializer<PushTokenModel> {
                public final void m10408a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PushTokenModel pushTokenModel = (PushTokenModel) obj;
                    if (pushTokenModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pushTokenModel.m10411a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pushTokenModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PushTokenParser.m10424a(pushTokenModel.w_(), pushTokenModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PushTokenModel.class, new Serializer());
                }
            }

            public PushTokenModel() {
                super(3);
            }

            @Nullable
            private ApplicationModel m10409a() {
                this.f8567d = (ApplicationModel) super.a(this.f8567d, 0, ApplicationModel.class);
                return this.f8567d;
            }

            @Nullable
            private OwnerModel m10410j() {
                this.f8569f = (OwnerModel) super.a(this.f8569f, 2, OwnerModel.class);
                return this.f8569f;
            }

            public final int jK_() {
                return 1225038559;
            }

            public final GraphQLVisitableModel m10412a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10409a() != null) {
                    ApplicationModel applicationModel = (ApplicationModel) graphQLModelMutatingVisitor.b(m10409a());
                    if (m10409a() != applicationModel) {
                        graphQLVisitableModel = (PushTokenModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8567d = applicationModel;
                    }
                }
                if (m10410j() != null) {
                    OwnerModel ownerModel = (OwnerModel) graphQLModelMutatingVisitor.b(m10410j());
                    if (m10410j() != ownerModel) {
                        graphQLVisitableModel = (PushTokenModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8569f = ownerModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10411a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10409a());
                int a2 = ModelHelper.a(flatBufferBuilder, m10410j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f8568e, 0);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m10413a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f8568e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        /* compiled from: name can not be null */
        public class Serializer extends JsonSerializer<PushNotificationsMuteMutationModel> {
            public final void m10414a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PushNotificationsMuteMutationModel pushNotificationsMuteMutationModel = (PushNotificationsMuteMutationModel) obj;
                if (pushNotificationsMuteMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pushNotificationsMuteMutationModel.m10417a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pushNotificationsMuteMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pushNotificationsMuteMutationModel.w_();
                int u_ = pushNotificationsMuteMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("push_token");
                    PushTokenParser.m10424a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PushNotificationsMuteMutationModel.class, new Serializer());
            }
        }

        public PushNotificationsMuteMutationModel() {
            super(2);
        }

        @Nullable
        private String m10415a() {
            this.f8570d = super.a(this.f8570d, 0);
            return this.f8570d;
        }

        @Nullable
        private PushTokenModel m10416j() {
            this.f8571e = (PushTokenModel) super.a(this.f8571e, 1, PushTokenModel.class);
            return this.f8571e;
        }

        public final int jK_() {
            return -344974915;
        }

        public final GraphQLVisitableModel m10418a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10416j() != null) {
                PushTokenModel pushTokenModel = (PushTokenModel) graphQLModelMutatingVisitor.b(m10416j());
                if (m10416j() != pushTokenModel) {
                    graphQLVisitableModel = (PushNotificationsMuteMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8571e = pushTokenModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10417a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m10415a());
            int a = ModelHelper.a(flatBufferBuilder, m10416j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
