package com.facebook.groupcommerce.protocol;

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
import com.facebook.groupcommerce.protocol.GroupMarketplaceCrossPostNuxSeenMutationParsers.GroupMarketplaceCrossPostNuxSeenMutationFieldsParser;
import com.facebook.groupcommerce.protocol.GroupMarketplaceCrossPostNuxSeenMutationParsers.GroupMarketplaceCrossPostNuxSeenMutationFieldsParser.GroupParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: reactnativejni */
public class GroupMarketplaceCrossPostNuxSeenMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1648188095)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: reactnativejni */
    public final class GroupMarketplaceCrossPostNuxSeenMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GroupModel f5418d;

        /* compiled from: reactnativejni */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupMarketplaceCrossPostNuxSeenMutationFieldsModel.class, new Deserializer());
            }

            public Object m6056a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupMarketplaceCrossPostNuxSeenMutationFieldsParser.m6071a(jsonParser);
                Object groupMarketplaceCrossPostNuxSeenMutationFieldsModel = new GroupMarketplaceCrossPostNuxSeenMutationFieldsModel();
                ((BaseModel) groupMarketplaceCrossPostNuxSeenMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupMarketplaceCrossPostNuxSeenMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) groupMarketplaceCrossPostNuxSeenMutationFieldsModel).a();
                }
                return groupMarketplaceCrossPostNuxSeenMutationFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: reactnativejni */
        public final class GroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f5417d;

            /* compiled from: reactnativejni */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupModel.class, new Deserializer());
                }

                public Object m6057a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupParser.m6069a(jsonParser, flatBufferBuilder));
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

            /* compiled from: reactnativejni */
            public class Serializer extends JsonSerializer<GroupModel> {
                public final void m6058a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupModel groupModel = (GroupModel) obj;
                    if (groupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupModel.m6060a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupParser.m6070a(groupModel.w_(), groupModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(GroupModel.class, new Serializer());
                }
            }

            public GroupModel() {
                super(1);
            }

            public final void m6063a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m6064a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m6059j() {
                this.f5417d = super.a(this.f5417d, 0);
                return this.f5417d;
            }

            @Nullable
            public final String m6062a() {
                return m6059j();
            }

            public final int jK_() {
                return 69076575;
            }

            public final GraphQLVisitableModel m6061a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m6060a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m6059j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: reactnativejni */
        public class Serializer extends JsonSerializer<GroupMarketplaceCrossPostNuxSeenMutationFieldsModel> {
            public final void m6065a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupMarketplaceCrossPostNuxSeenMutationFieldsModel groupMarketplaceCrossPostNuxSeenMutationFieldsModel = (GroupMarketplaceCrossPostNuxSeenMutationFieldsModel) obj;
                if (groupMarketplaceCrossPostNuxSeenMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupMarketplaceCrossPostNuxSeenMutationFieldsModel.m6067a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupMarketplaceCrossPostNuxSeenMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupMarketplaceCrossPostNuxSeenMutationFieldsModel.w_();
                int u_ = groupMarketplaceCrossPostNuxSeenMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group");
                    GroupParser.m6070a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupMarketplaceCrossPostNuxSeenMutationFieldsModel.class, new Serializer());
            }
        }

        public GroupMarketplaceCrossPostNuxSeenMutationFieldsModel() {
            super(1);
        }

        @Nullable
        private GroupModel m6066a() {
            this.f5418d = (GroupModel) super.a(this.f5418d, 0, GroupModel.class);
            return this.f5418d;
        }

        public final int jK_() {
            return 725272419;
        }

        public final GraphQLVisitableModel m6068a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6066a() != null) {
                GroupModel groupModel = (GroupModel) graphQLModelMutatingVisitor.b(m6066a());
                if (m6066a() != groupModel) {
                    graphQLVisitableModel = (GroupMarketplaceCrossPostNuxSeenMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5418d = groupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6067a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6066a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
