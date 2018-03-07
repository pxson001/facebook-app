package com.facebook.groups.mutations.protocol;

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
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.mutations.protocol.ReportedPostsMutationsParsers.GroupIgnoreReportedStoryCoreMutationParser;
import com.facebook.groups.mutations.protocol.ReportedPostsMutationsParsers.GroupIgnoreReportedStoryCoreMutationParser.GroupParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: entity_cards_launcher_bad_parameters */
public class ReportedPostsMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1131823543)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: entity_cards_launcher_bad_parameters */
    public final class GroupIgnoreReportedStoryCoreMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GroupModel f14792d;

        /* compiled from: entity_cards_launcher_bad_parameters */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupIgnoreReportedStoryCoreMutationModel.class, new Deserializer());
            }

            public Object m17139a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupIgnoreReportedStoryCoreMutationParser.m17154a(jsonParser);
                Object groupIgnoreReportedStoryCoreMutationModel = new GroupIgnoreReportedStoryCoreMutationModel();
                ((BaseModel) groupIgnoreReportedStoryCoreMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupIgnoreReportedStoryCoreMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupIgnoreReportedStoryCoreMutationModel).a();
                }
                return groupIgnoreReportedStoryCoreMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: entity_cards_launcher_bad_parameters */
        public final class GroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f14791d;

            /* compiled from: entity_cards_launcher_bad_parameters */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupModel.class, new Deserializer());
                }

                public Object m17140a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupParser.m17152a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupModel = new GroupModel();
                    ((BaseModel) groupModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupModel instanceof Postprocessable) {
                        return ((Postprocessable) groupModel).a();
                    }
                    return groupModel;
                }
            }

            /* compiled from: entity_cards_launcher_bad_parameters */
            public class Serializer extends JsonSerializer<GroupModel> {
                public final void m17141a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupModel groupModel = (GroupModel) obj;
                    if (groupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupModel.m17143a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupParser.m17153a(groupModel.w_(), groupModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(GroupModel.class, new Serializer());
                }
            }

            public GroupModel() {
                super(1);
            }

            public final void m17146a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m17147a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m17142j() {
                this.f14791d = super.a(this.f14791d, 0);
                return this.f14791d;
            }

            @Nullable
            public final String m17145a() {
                return m17142j();
            }

            public final int jK_() {
                return 69076575;
            }

            public final GraphQLVisitableModel m17144a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17143a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17142j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: entity_cards_launcher_bad_parameters */
        public class Serializer extends JsonSerializer<GroupIgnoreReportedStoryCoreMutationModel> {
            public final void m17148a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupIgnoreReportedStoryCoreMutationModel groupIgnoreReportedStoryCoreMutationModel = (GroupIgnoreReportedStoryCoreMutationModel) obj;
                if (groupIgnoreReportedStoryCoreMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupIgnoreReportedStoryCoreMutationModel.m17150a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupIgnoreReportedStoryCoreMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupIgnoreReportedStoryCoreMutationModel.w_();
                int u_ = groupIgnoreReportedStoryCoreMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group");
                    GroupParser.m17153a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupIgnoreReportedStoryCoreMutationModel.class, new Serializer());
            }
        }

        public GroupIgnoreReportedStoryCoreMutationModel() {
            super(1);
        }

        @Nullable
        private GroupModel m17149a() {
            this.f14792d = (GroupModel) super.a(this.f14792d, 0, GroupModel.class);
            return this.f14792d;
        }

        public final int jK_() {
            return 2023817084;
        }

        public final GraphQLVisitableModel m17151a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17149a() != null) {
                GroupModel groupModel = (GroupModel) graphQLModelMutatingVisitor.b(m17149a());
                if (m17149a() != groupModel) {
                    graphQLVisitableModel = (GroupIgnoreReportedStoryCoreMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14792d = groupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17150a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17149a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
