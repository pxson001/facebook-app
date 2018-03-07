package com.facebook.groups.feed.protocol;

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
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.feed.protocol.GroupSuggestionMutationParsers.GroupSuggestionLoggingMutationParser;
import com.facebook.groups.feed.protocol.GroupSuggestionMutationParsers.GroupSuggestionLoggingMutationParser.AymtChannelParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: purpose_enum */
public class GroupSuggestionMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 191530334)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: purpose_enum */
    public final class GroupSuggestionLoggingMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private AymtChannelModel f5693d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: purpose_enum */
        public final class AymtChannelModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f5692d;

            /* compiled from: purpose_enum */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AymtChannelModel.class, new Deserializer());
                }

                public Object m6934a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AymtChannelParser.m6945a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object aymtChannelModel = new AymtChannelModel();
                    ((BaseModel) aymtChannelModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (aymtChannelModel instanceof Postprocessable) {
                        return ((Postprocessable) aymtChannelModel).a();
                    }
                    return aymtChannelModel;
                }
            }

            /* compiled from: purpose_enum */
            public class Serializer extends JsonSerializer<AymtChannelModel> {
                public final void m6935a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AymtChannelModel aymtChannelModel = (AymtChannelModel) obj;
                    if (aymtChannelModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(aymtChannelModel.m6937a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        aymtChannelModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AymtChannelParser.m6946a(aymtChannelModel.w_(), aymtChannelModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AymtChannelModel.class, new Serializer());
                }
            }

            public AymtChannelModel() {
                super(1);
            }

            @Nullable
            private String m6936j() {
                this.f5692d = super.a(this.f5692d, 0);
                return this.f5692d;
            }

            @Nullable
            public final String m6939a() {
                return m6936j();
            }

            public final int jK_() {
                return -111810524;
            }

            public final GraphQLVisitableModel m6938a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m6937a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m6936j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: purpose_enum */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupSuggestionLoggingMutationModel.class, new Deserializer());
            }

            public Object m6940a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupSuggestionLoggingMutationParser.m6947a(jsonParser);
                Object groupSuggestionLoggingMutationModel = new GroupSuggestionLoggingMutationModel();
                ((BaseModel) groupSuggestionLoggingMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupSuggestionLoggingMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupSuggestionLoggingMutationModel).a();
                }
                return groupSuggestionLoggingMutationModel;
            }
        }

        /* compiled from: purpose_enum */
        public class Serializer extends JsonSerializer<GroupSuggestionLoggingMutationModel> {
            public final void m6941a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupSuggestionLoggingMutationModel groupSuggestionLoggingMutationModel = (GroupSuggestionLoggingMutationModel) obj;
                if (groupSuggestionLoggingMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupSuggestionLoggingMutationModel.m6943a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupSuggestionLoggingMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupSuggestionLoggingMutationModel.w_();
                int u_ = groupSuggestionLoggingMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("aymt_channel");
                    AymtChannelParser.m6946a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupSuggestionLoggingMutationModel.class, new Serializer());
            }
        }

        public GroupSuggestionLoggingMutationModel() {
            super(1);
        }

        @Nullable
        private AymtChannelModel m6942a() {
            this.f5693d = (AymtChannelModel) super.a(this.f5693d, 0, AymtChannelModel.class);
            return this.f5693d;
        }

        public final int jK_() {
            return -1281540488;
        }

        public final GraphQLVisitableModel m6944a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6942a() != null) {
                AymtChannelModel aymtChannelModel = (AymtChannelModel) graphQLModelMutatingVisitor.b(m6942a());
                if (m6942a() != aymtChannelModel) {
                    graphQLVisitableModel = (GroupSuggestionLoggingMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5693d = aymtChannelModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6943a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6942a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
