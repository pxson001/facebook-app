package com.facebook.groups.discover.protocol;

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
import com.facebook.groups.discover.protocol.DiscoverMutationsParsers.GroupHideSuggestionMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: UserTimelineHeaderView.bindModel */
public class DiscoverMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: UserTimelineHeaderView.bindModel */
    public final class GroupHideSuggestionMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f21287d;

        /* compiled from: UserTimelineHeaderView.bindModel */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupHideSuggestionMutationModel.class, new Deserializer());
            }

            public Object m22183a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupHideSuggestionMutationParser.m22188a(jsonParser);
                Object groupHideSuggestionMutationModel = new GroupHideSuggestionMutationModel();
                ((BaseModel) groupHideSuggestionMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupHideSuggestionMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupHideSuggestionMutationModel).a();
                }
                return groupHideSuggestionMutationModel;
            }
        }

        /* compiled from: UserTimelineHeaderView.bindModel */
        public class Serializer extends JsonSerializer<GroupHideSuggestionMutationModel> {
            public final void m22184a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupHideSuggestionMutationModel groupHideSuggestionMutationModel = (GroupHideSuggestionMutationModel) obj;
                if (groupHideSuggestionMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupHideSuggestionMutationModel.m22186a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupHideSuggestionMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupHideSuggestionMutationModel.w_();
                int u_ = groupHideSuggestionMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupHideSuggestionMutationModel.class, new Serializer());
            }
        }

        public GroupHideSuggestionMutationModel() {
            super(1);
        }

        @Nullable
        private String m22185a() {
            this.f21287d = super.a(this.f21287d, 0);
            return this.f21287d;
        }

        public final int jK_() {
            return -538781144;
        }

        public final GraphQLVisitableModel m22187a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m22186a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m22185a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
