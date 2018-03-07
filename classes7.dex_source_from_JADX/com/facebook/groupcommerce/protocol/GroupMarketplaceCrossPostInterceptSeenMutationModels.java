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
import com.facebook.groupcommerce.protocol.GroupMarketplaceCrossPostInterceptSeenMutationParsers.GroupMarketplaceCrossPostInterceptSeenMutationFieldsParser;
import com.facebook.groupcommerce.protocol.GroupMarketplaceCrossPostInterceptSeenMutationParsers.GroupMarketplaceCrossPostInterceptSeenMutationFieldsParser.GroupParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: reason_msg */
public class GroupMarketplaceCrossPostInterceptSeenMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 868004735)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: reason_msg */
    public final class GroupMarketplaceCrossPostInterceptSeenMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GroupModel f5416d;

        /* compiled from: reason_msg */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupMarketplaceCrossPostInterceptSeenMutationFieldsModel.class, new Deserializer());
            }

            public Object m6039a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupMarketplaceCrossPostInterceptSeenMutationFieldsParser.m6054a(jsonParser);
                Object groupMarketplaceCrossPostInterceptSeenMutationFieldsModel = new GroupMarketplaceCrossPostInterceptSeenMutationFieldsModel();
                ((BaseModel) groupMarketplaceCrossPostInterceptSeenMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupMarketplaceCrossPostInterceptSeenMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) groupMarketplaceCrossPostInterceptSeenMutationFieldsModel).a();
                }
                return groupMarketplaceCrossPostInterceptSeenMutationFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: reason_msg */
        public final class GroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f5415d;

            /* compiled from: reason_msg */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupModel.class, new Deserializer());
                }

                public Object m6040a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupParser.m6052a(jsonParser, flatBufferBuilder));
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

            /* compiled from: reason_msg */
            public class Serializer extends JsonSerializer<GroupModel> {
                public final void m6041a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupModel groupModel = (GroupModel) obj;
                    if (groupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupModel.m6043a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupParser.m6053a(groupModel.w_(), groupModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(GroupModel.class, new Serializer());
                }
            }

            public GroupModel() {
                super(1);
            }

            public final void m6046a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m6047a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m6042j() {
                this.f5415d = super.a(this.f5415d, 0);
                return this.f5415d;
            }

            @Nullable
            public final String m6045a() {
                return m6042j();
            }

            public final int jK_() {
                return 69076575;
            }

            public final GraphQLVisitableModel m6044a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m6043a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m6042j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: reason_msg */
        public class Serializer extends JsonSerializer<GroupMarketplaceCrossPostInterceptSeenMutationFieldsModel> {
            public final void m6048a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupMarketplaceCrossPostInterceptSeenMutationFieldsModel groupMarketplaceCrossPostInterceptSeenMutationFieldsModel = (GroupMarketplaceCrossPostInterceptSeenMutationFieldsModel) obj;
                if (groupMarketplaceCrossPostInterceptSeenMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupMarketplaceCrossPostInterceptSeenMutationFieldsModel.m6050a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupMarketplaceCrossPostInterceptSeenMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupMarketplaceCrossPostInterceptSeenMutationFieldsModel.w_();
                int u_ = groupMarketplaceCrossPostInterceptSeenMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group");
                    GroupParser.m6053a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupMarketplaceCrossPostInterceptSeenMutationFieldsModel.class, new Serializer());
            }
        }

        public GroupMarketplaceCrossPostInterceptSeenMutationFieldsModel() {
            super(1);
        }

        @Nullable
        private GroupModel m6049a() {
            this.f5416d = (GroupModel) super.a(this.f5416d, 0, GroupModel.class);
            return this.f5416d;
        }

        public final int jK_() {
            return 190953746;
        }

        public final GraphQLVisitableModel m6051a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6049a() != null) {
                GroupModel groupModel = (GroupModel) graphQLModelMutatingVisitor.b(m6049a());
                if (m6049a() != groupModel) {
                    graphQLVisitableModel = (GroupMarketplaceCrossPostInterceptSeenMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5416d = groupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6050a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6049a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
