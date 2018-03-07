package com.facebook.groups.groupsgrid.mutations;

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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.groupsgrid.mutations.GroupsOrderUpdateMutationParsers.GroupCacheUpdateOrderMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: prompt_text */
public class GroupsOrderUpdateMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: prompt_text */
    public final class GroupCacheUpdateOrderMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f5758d;

        /* compiled from: prompt_text */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupCacheUpdateOrderMutationModel.class, new Deserializer());
            }

            public Object m7061a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupCacheUpdateOrderMutationParser.m7066a(jsonParser);
                Object groupCacheUpdateOrderMutationModel = new GroupCacheUpdateOrderMutationModel();
                ((BaseModel) groupCacheUpdateOrderMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupCacheUpdateOrderMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupCacheUpdateOrderMutationModel).a();
                }
                return groupCacheUpdateOrderMutationModel;
            }
        }

        /* compiled from: prompt_text */
        public class Serializer extends JsonSerializer<GroupCacheUpdateOrderMutationModel> {
            public final void m7062a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupCacheUpdateOrderMutationModel groupCacheUpdateOrderMutationModel = (GroupCacheUpdateOrderMutationModel) obj;
                if (groupCacheUpdateOrderMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupCacheUpdateOrderMutationModel.m7064a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupCacheUpdateOrderMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupCacheUpdateOrderMutationModel.w_();
                int u_ = groupCacheUpdateOrderMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupCacheUpdateOrderMutationModel.class, new Serializer());
            }
        }

        public GroupCacheUpdateOrderMutationModel() {
            super(1);
        }

        @Nullable
        private String m7063a() {
            this.f5758d = super.a(this.f5758d, 0);
            return this.f5758d;
        }

        public final int jK_() {
            return 942227285;
        }

        public final GraphQLVisitableModel m7065a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m7064a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m7063a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
