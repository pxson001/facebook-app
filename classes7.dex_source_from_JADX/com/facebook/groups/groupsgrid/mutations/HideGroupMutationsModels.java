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
import com.facebook.groups.groupsgrid.mutations.HideGroupMutationsParsers.GroupHideMutationParser;
import com.facebook.groups.groupsgrid.mutations.HideGroupMutationsParsers.GroupUnhideMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: promotion_external_url */
public class HideGroupMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: promotion_external_url */
    public final class GroupHideMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f5761d;

        /* compiled from: promotion_external_url */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupHideMutationModel.class, new Deserializer());
            }

            public Object m7069a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupHideMutationParser.m7079a(jsonParser);
                Object groupHideMutationModel = new GroupHideMutationModel();
                ((BaseModel) groupHideMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupHideMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupHideMutationModel).a();
                }
                return groupHideMutationModel;
            }
        }

        /* compiled from: promotion_external_url */
        public class Serializer extends JsonSerializer<GroupHideMutationModel> {
            public final void m7070a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupHideMutationModel groupHideMutationModel = (GroupHideMutationModel) obj;
                if (groupHideMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupHideMutationModel.m7072a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupHideMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupHideMutationModel.w_();
                int u_ = groupHideMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupHideMutationModel.class, new Serializer());
            }
        }

        public GroupHideMutationModel() {
            super(1);
        }

        @Nullable
        private String m7071a() {
            this.f5761d = super.a(this.f5761d, 0);
            return this.f5761d;
        }

        public final int jK_() {
            return 215828364;
        }

        public final GraphQLVisitableModel m7073a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m7072a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m7071a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: promotion_external_url */
    public final class GroupUnhideMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f5762d;

        /* compiled from: promotion_external_url */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupUnhideMutationModel.class, new Deserializer());
            }

            public Object m7074a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupUnhideMutationParser.m7080a(jsonParser);
                Object groupUnhideMutationModel = new GroupUnhideMutationModel();
                ((BaseModel) groupUnhideMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupUnhideMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupUnhideMutationModel).a();
                }
                return groupUnhideMutationModel;
            }
        }

        /* compiled from: promotion_external_url */
        public class Serializer extends JsonSerializer<GroupUnhideMutationModel> {
            public final void m7075a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupUnhideMutationModel groupUnhideMutationModel = (GroupUnhideMutationModel) obj;
                if (groupUnhideMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupUnhideMutationModel.m7077a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupUnhideMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupUnhideMutationModel.w_();
                int u_ = groupUnhideMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupUnhideMutationModel.class, new Serializer());
            }
        }

        public GroupUnhideMutationModel() {
            super(1);
        }

        @Nullable
        private String m7076a() {
            this.f5762d = super.a(this.f5762d, 0);
            return this.f5762d;
        }

        public final int jK_() {
            return -2048371693;
        }

        public final GraphQLVisitableModel m7078a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m7077a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m7076a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
