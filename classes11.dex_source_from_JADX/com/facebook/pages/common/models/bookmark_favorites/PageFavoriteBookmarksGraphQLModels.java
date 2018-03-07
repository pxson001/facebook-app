package com.facebook.pages.common.models.bookmark_favorites;

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
import com.facebook.pages.common.models.bookmark_favorites.PageFavoriteBookmarksGraphQLParsers.FBBookmarkAddToFavoritesMutationParser;
import com.facebook.pages.common.models.bookmark_favorites.PageFavoriteBookmarksGraphQLParsers.FBBookmarkRemoveFromFavoritesMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: sgny_xout */
public class PageFavoriteBookmarksGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sgny_xout */
    public final class FBBookmarkAddToFavoritesMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f1669d;

        /* compiled from: sgny_xout */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBBookmarkAddToFavoritesMutationModel.class, new Deserializer());
            }

            public Object m2472a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBBookmarkAddToFavoritesMutationParser.m2482a(jsonParser);
                Object fBBookmarkAddToFavoritesMutationModel = new FBBookmarkAddToFavoritesMutationModel();
                ((BaseModel) fBBookmarkAddToFavoritesMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBBookmarkAddToFavoritesMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) fBBookmarkAddToFavoritesMutationModel).a();
                }
                return fBBookmarkAddToFavoritesMutationModel;
            }
        }

        /* compiled from: sgny_xout */
        public class Serializer extends JsonSerializer<FBBookmarkAddToFavoritesMutationModel> {
            public final void m2473a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBBookmarkAddToFavoritesMutationModel fBBookmarkAddToFavoritesMutationModel = (FBBookmarkAddToFavoritesMutationModel) obj;
                if (fBBookmarkAddToFavoritesMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBBookmarkAddToFavoritesMutationModel.m2475a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBBookmarkAddToFavoritesMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBBookmarkAddToFavoritesMutationModel.w_();
                int u_ = fBBookmarkAddToFavoritesMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBBookmarkAddToFavoritesMutationModel.class, new Serializer());
            }
        }

        public FBBookmarkAddToFavoritesMutationModel() {
            super(1);
        }

        @Nullable
        private String m2474a() {
            this.f1669d = super.a(this.f1669d, 0);
            return this.f1669d;
        }

        public final int jK_() {
            return 864631836;
        }

        public final GraphQLVisitableModel m2476a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m2475a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2474a());
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
    /* compiled from: sgny_xout */
    public final class FBBookmarkRemoveFromFavoritesMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f1670d;

        /* compiled from: sgny_xout */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBBookmarkRemoveFromFavoritesMutationModel.class, new Deserializer());
            }

            public Object m2477a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBBookmarkRemoveFromFavoritesMutationParser.m2483a(jsonParser);
                Object fBBookmarkRemoveFromFavoritesMutationModel = new FBBookmarkRemoveFromFavoritesMutationModel();
                ((BaseModel) fBBookmarkRemoveFromFavoritesMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBBookmarkRemoveFromFavoritesMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) fBBookmarkRemoveFromFavoritesMutationModel).a();
                }
                return fBBookmarkRemoveFromFavoritesMutationModel;
            }
        }

        /* compiled from: sgny_xout */
        public class Serializer extends JsonSerializer<FBBookmarkRemoveFromFavoritesMutationModel> {
            public final void m2478a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBBookmarkRemoveFromFavoritesMutationModel fBBookmarkRemoveFromFavoritesMutationModel = (FBBookmarkRemoveFromFavoritesMutationModel) obj;
                if (fBBookmarkRemoveFromFavoritesMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBBookmarkRemoveFromFavoritesMutationModel.m2480a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBBookmarkRemoveFromFavoritesMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBBookmarkRemoveFromFavoritesMutationModel.w_();
                int u_ = fBBookmarkRemoveFromFavoritesMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBBookmarkRemoveFromFavoritesMutationModel.class, new Serializer());
            }
        }

        public FBBookmarkRemoveFromFavoritesMutationModel() {
            super(1);
        }

        @Nullable
        private String m2479a() {
            this.f1670d = super.a(this.f1670d, 0);
            return this.f1670d;
        }

        public final int jK_() {
            return -1742492902;
        }

        public final GraphQLVisitableModel m2481a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m2480a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2479a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
