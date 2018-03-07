package com.facebook.messaging.business.common.calltoaction.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLMessengerCallToActionType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.business.common.calltoaction.graphql.PlatformCTAFragmentsParsers.PlatformCallToActionParser;
import com.facebook.messaging.business.common.calltoaction.graphql.PlatformCTAFragmentsParsers.PlatformCallToActionParser.ActionTargetsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: video_original_file_path */
public class PlatformCTAFragmentsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2025503509)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_original_file_path */
    public final class PlatformCallToActionModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private GraphQLMessengerCallToActionType f720d;
        @Nullable
        private List<ActionTargetsModel> f721e;
        @Nullable
        private String f722f;
        @Nullable
        private String f723g;
        @Nullable
        private String f724h;
        private boolean f725i;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1787905591)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_original_file_path */
        public final class ActionTargetsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f712d;
            @Nullable
            private String f713e;

            /* compiled from: video_original_file_path */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f710a;
                @Nullable
                public String f711b;
            }

            /* compiled from: video_original_file_path */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ActionTargetsModel.class, new Deserializer());
                }

                public Object m722a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ActionTargetsParser.m743b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object actionTargetsModel = new ActionTargetsModel();
                    ((BaseModel) actionTargetsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (actionTargetsModel instanceof Postprocessable) {
                        return ((Postprocessable) actionTargetsModel).a();
                    }
                    return actionTargetsModel;
                }
            }

            /* compiled from: video_original_file_path */
            public class Serializer extends JsonSerializer<ActionTargetsModel> {
                public final void m723a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ActionTargetsModel actionTargetsModel = (ActionTargetsModel) obj;
                    if (actionTargetsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(actionTargetsModel.m725a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        actionTargetsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ActionTargetsParser.m742a(actionTargetsModel.w_(), actionTargetsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ActionTargetsModel.class, new Serializer());
                }
            }

            public ActionTargetsModel() {
                super(2);
            }

            public ActionTargetsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final GraphQLObjectType m728b() {
                if (this.b != null && this.f712d == null) {
                    this.f712d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f712d;
            }

            @Nullable
            public final String m729c() {
                this.f713e = super.a(this.f713e, 1);
                return this.f713e;
            }

            public static ActionTargetsModel m724a(ActionTargetsModel actionTargetsModel) {
                if (actionTargetsModel == null) {
                    return null;
                }
                if (actionTargetsModel instanceof ActionTargetsModel) {
                    return actionTargetsModel;
                }
                Builder builder = new Builder();
                builder.f710a = actionTargetsModel.m728b();
                builder.f711b = actionTargetsModel.m729c();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f710a);
                int b = flatBufferBuilder.b(builder.f711b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ActionTargetsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m727a() {
                return m729c();
            }

            public final int jK_() {
                return 431209401;
            }

            public final GraphQLVisitableModel m726a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m725a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m728b());
                int b = flatBufferBuilder.b(m729c());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: video_original_file_path */
        public final class Builder {
            @Nullable
            public GraphQLMessengerCallToActionType f714a;
            @Nullable
            public ImmutableList<ActionTargetsModel> f715b;
            @Nullable
            public String f716c;
            @Nullable
            public String f717d;
            @Nullable
            public String f718e;
            public boolean f719f;
        }

        /* compiled from: video_original_file_path */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PlatformCallToActionModel.class, new Deserializer());
            }

            public Object m730a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PlatformCallToActionParser.m746b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object platformCallToActionModel = new PlatformCallToActionModel();
                ((BaseModel) platformCallToActionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (platformCallToActionModel instanceof Postprocessable) {
                    return ((Postprocessable) platformCallToActionModel).a();
                }
                return platformCallToActionModel;
            }
        }

        /* compiled from: video_original_file_path */
        public class Serializer extends JsonSerializer<PlatformCallToActionModel> {
            public final void m731a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PlatformCallToActionModel platformCallToActionModel = (PlatformCallToActionModel) obj;
                if (platformCallToActionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(platformCallToActionModel.m733a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    platformCallToActionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PlatformCallToActionParser.m747b(platformCallToActionModel.w_(), platformCallToActionModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PlatformCallToActionModel.class, new Serializer());
            }
        }

        public PlatformCallToActionModel() {
            super(6);
        }

        public PlatformCallToActionModel(MutableFlatBuffer mutableFlatBuffer) {
            super(6);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLMessengerCallToActionType m737b() {
            this.f720d = (GraphQLMessengerCallToActionType) super.b(this.f720d, 0, GraphQLMessengerCallToActionType.class, GraphQLMessengerCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f720d;
        }

        @Nonnull
        public final ImmutableList<ActionTargetsModel> m738c() {
            this.f721e = super.a(this.f721e, 1, ActionTargetsModel.class);
            return (ImmutableList) this.f721e;
        }

        @Nullable
        public final String m739d() {
            this.f722f = super.a(this.f722f, 2);
            return this.f722f;
        }

        @Nullable
        public final String an_() {
            this.f723g = super.a(this.f723g, 3);
            return this.f723g;
        }

        @Nullable
        public final String m740g() {
            this.f724h = super.a(this.f724h, 4);
            return this.f724h;
        }

        public final boolean ao_() {
            a(0, 5);
            return this.f725i;
        }

        public static PlatformCallToActionModel m732a(PlatformCallToActionModel platformCallToActionModel) {
            if (platformCallToActionModel == null) {
                return null;
            }
            if (platformCallToActionModel instanceof PlatformCallToActionModel) {
                return platformCallToActionModel;
            }
            Builder builder = new Builder();
            builder.f714a = platformCallToActionModel.m737b();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < platformCallToActionModel.m738c().size(); i++) {
                builder2.c(ActionTargetsModel.m724a((ActionTargetsModel) platformCallToActionModel.m738c().get(i)));
            }
            builder.f715b = builder2.b();
            builder.f716c = platformCallToActionModel.m739d();
            builder.f717d = platformCallToActionModel.an_();
            builder.f718e = platformCallToActionModel.m740g();
            builder.f719f = platformCallToActionModel.ao_();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = flatBufferBuilder.a(builder.f714a);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f715b);
            int b = flatBufferBuilder.b(builder.f716c);
            int b2 = flatBufferBuilder.b(builder.f717d);
            int b3 = flatBufferBuilder.b(builder.f718e);
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.a(5, builder.f719f);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new PlatformCallToActionModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        @Nullable
        public final String m735a() {
            return m740g();
        }

        public final int jK_() {
            return -1676907614;
        }

        public final GraphQLVisitableModel m734a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m738c() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m738c(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (PlatformCallToActionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f721e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m733a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m737b());
            int a2 = ModelHelper.a(flatBufferBuilder, m738c());
            int b = flatBufferBuilder.b(m739d());
            int b2 = flatBufferBuilder.b(an_());
            int b3 = flatBufferBuilder.b(m740g());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.a(5, this.f725i);
            i();
            return flatBufferBuilder.d();
        }

        public final void m736a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f725i = mutableFlatBuffer.a(i, 5);
        }
    }
}
