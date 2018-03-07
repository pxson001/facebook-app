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
import com.facebook.groups.groupsgrid.mutations.FavoriteGroupsMutationsParsers.GroupsBookmarkAddToFavoritesMutationParser;
import com.facebook.groups.groupsgrid.mutations.FavoriteGroupsMutationsParsers.GroupsBookmarkRemoveFromFavoritesMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: protile_photo_counts */
public class FavoriteGroupsMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: protile_photo_counts */
    public final class GroupsBookmarkAddToFavoritesMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f5730d;

        /* compiled from: protile_photo_counts */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupsBookmarkAddToFavoritesMutationModel.class, new Deserializer());
            }

            public Object m7038a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupsBookmarkAddToFavoritesMutationParser.m7048a(jsonParser);
                Object groupsBookmarkAddToFavoritesMutationModel = new GroupsBookmarkAddToFavoritesMutationModel();
                ((BaseModel) groupsBookmarkAddToFavoritesMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupsBookmarkAddToFavoritesMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupsBookmarkAddToFavoritesMutationModel).a();
                }
                return groupsBookmarkAddToFavoritesMutationModel;
            }
        }

        /* compiled from: protile_photo_counts */
        public class Serializer extends JsonSerializer<GroupsBookmarkAddToFavoritesMutationModel> {
            public final void m7039a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupsBookmarkAddToFavoritesMutationModel groupsBookmarkAddToFavoritesMutationModel = (GroupsBookmarkAddToFavoritesMutationModel) obj;
                if (groupsBookmarkAddToFavoritesMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupsBookmarkAddToFavoritesMutationModel.m7041a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupsBookmarkAddToFavoritesMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupsBookmarkAddToFavoritesMutationModel.w_();
                int u_ = groupsBookmarkAddToFavoritesMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupsBookmarkAddToFavoritesMutationModel.class, new Serializer());
            }
        }

        public GroupsBookmarkAddToFavoritesMutationModel() {
            super(1);
        }

        @Nullable
        private String m7040a() {
            this.f5730d = super.a(this.f5730d, 0);
            return this.f5730d;
        }

        public final int jK_() {
            return 864631836;
        }

        public final GraphQLVisitableModel m7042a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m7041a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m7040a());
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
    /* compiled from: protile_photo_counts */
    public final class GroupsBookmarkRemoveFromFavoritesMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f5731d;

        /* compiled from: protile_photo_counts */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupsBookmarkRemoveFromFavoritesMutationModel.class, new Deserializer());
            }

            public Object m7043a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupsBookmarkRemoveFromFavoritesMutationParser.m7049a(jsonParser);
                Object groupsBookmarkRemoveFromFavoritesMutationModel = new GroupsBookmarkRemoveFromFavoritesMutationModel();
                ((BaseModel) groupsBookmarkRemoveFromFavoritesMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupsBookmarkRemoveFromFavoritesMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupsBookmarkRemoveFromFavoritesMutationModel).a();
                }
                return groupsBookmarkRemoveFromFavoritesMutationModel;
            }
        }

        /* compiled from: protile_photo_counts */
        public class Serializer extends JsonSerializer<GroupsBookmarkRemoveFromFavoritesMutationModel> {
            public final void m7044a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupsBookmarkRemoveFromFavoritesMutationModel groupsBookmarkRemoveFromFavoritesMutationModel = (GroupsBookmarkRemoveFromFavoritesMutationModel) obj;
                if (groupsBookmarkRemoveFromFavoritesMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupsBookmarkRemoveFromFavoritesMutationModel.m7046a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupsBookmarkRemoveFromFavoritesMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupsBookmarkRemoveFromFavoritesMutationModel.w_();
                int u_ = groupsBookmarkRemoveFromFavoritesMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupsBookmarkRemoveFromFavoritesMutationModel.class, new Serializer());
            }
        }

        public GroupsBookmarkRemoveFromFavoritesMutationModel() {
            super(1);
        }

        @Nullable
        private String m7045a() {
            this.f5731d = super.a(this.f5731d, 0);
            return this.f5731d;
        }

        public final int jK_() {
            return -1742492902;
        }

        public final GraphQLVisitableModel m7047a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m7046a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m7045a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
