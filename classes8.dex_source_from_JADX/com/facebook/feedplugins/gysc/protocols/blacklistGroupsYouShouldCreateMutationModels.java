package com.facebook.feedplugins.gysc.protocols;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feedplugins.gysc.protocols.blacklistGroupsYouShouldCreateMutationParsers.GroupsYouShouldCreateXoutMutationParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
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

/* compiled from: friends_tab_contacts */
public class blacklistGroupsYouShouldCreateMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: friends_tab_contacts */
    public final class GroupsYouShouldCreateXoutMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f12870d;

        /* compiled from: friends_tab_contacts */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupsYouShouldCreateXoutMutationModel.class, new Deserializer());
            }

            public Object m14617a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupsYouShouldCreateXoutMutationParser.m14622a(jsonParser);
                Object groupsYouShouldCreateXoutMutationModel = new GroupsYouShouldCreateXoutMutationModel();
                ((BaseModel) groupsYouShouldCreateXoutMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupsYouShouldCreateXoutMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupsYouShouldCreateXoutMutationModel).a();
                }
                return groupsYouShouldCreateXoutMutationModel;
            }
        }

        /* compiled from: friends_tab_contacts */
        public class Serializer extends JsonSerializer<GroupsYouShouldCreateXoutMutationModel> {
            public final void m14618a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupsYouShouldCreateXoutMutationModel groupsYouShouldCreateXoutMutationModel = (GroupsYouShouldCreateXoutMutationModel) obj;
                if (groupsYouShouldCreateXoutMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupsYouShouldCreateXoutMutationModel.m14620a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupsYouShouldCreateXoutMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupsYouShouldCreateXoutMutationModel.w_();
                int u_ = groupsYouShouldCreateXoutMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupsYouShouldCreateXoutMutationModel.class, new Serializer());
            }
        }

        public GroupsYouShouldCreateXoutMutationModel() {
            super(1);
        }

        @Nullable
        private String m14619a() {
            this.f12870d = super.a(this.f12870d, 0);
            return this.f12870d;
        }

        public final int jK_() {
            return 251006705;
        }

        public final GraphQLVisitableModel m14621a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m14620a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m14619a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
