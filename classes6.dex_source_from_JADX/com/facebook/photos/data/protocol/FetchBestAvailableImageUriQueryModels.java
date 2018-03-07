package com.facebook.photos.data.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.photos.data.protocol.FetchBestAvailableImageUriQueryParsers.FetchBestAvailableImageUriQueryParser;
import com.facebook.photos.data.protocol.FetchBestAvailableImageUriQueryParsers.FetchBestAvailableImageUriQueryParser.ImageParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: suggested_with_tags */
public class FetchBestAvailableImageUriQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -226605444)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: suggested_with_tags */
    public final class FetchBestAvailableImageUriQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f3546d;
        @Nullable
        private ImageModel f3547e;

        /* compiled from: suggested_with_tags */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchBestAvailableImageUriQueryModel.class, new Deserializer());
            }

            public Object m4753a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchBestAvailableImageUriQueryParser.m4771a(jsonParser);
                Object fetchBestAvailableImageUriQueryModel = new FetchBestAvailableImageUriQueryModel();
                ((BaseModel) fetchBestAvailableImageUriQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchBestAvailableImageUriQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchBestAvailableImageUriQueryModel).a();
                }
                return fetchBestAvailableImageUriQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 729935302)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: suggested_with_tags */
        public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
            private int f3543d;
            @Nullable
            private String f3544e;
            private int f3545f;

            /* compiled from: suggested_with_tags */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                }

                public Object m4754a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ImageParser.m4769a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object imageModel = new ImageModel();
                    ((BaseModel) imageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (imageModel instanceof Postprocessable) {
                        return ((Postprocessable) imageModel).a();
                    }
                    return imageModel;
                }
            }

            /* compiled from: suggested_with_tags */
            public class Serializer extends JsonSerializer<ImageModel> {
                public final void m4755a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ImageModel imageModel = (ImageModel) obj;
                    if (imageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(imageModel.m4757a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ImageParser.m4770a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ImageModel.class, new Serializer());
                }
            }

            public ImageModel() {
                super(3);
            }

            public final int m4756a() {
                a(0, 0);
                return this.f3543d;
            }

            @Nullable
            public final String m4760j() {
                this.f3544e = super.a(this.f3544e, 1);
                return this.f3544e;
            }

            public final int m4761k() {
                a(0, 2);
                return this.f3545f;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m4758a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m4757a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m4760j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f3543d, 0);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.a(2, this.f3545f, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m4759a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f3543d = mutableFlatBuffer.a(i, 0, 0);
                this.f3545f = mutableFlatBuffer.a(i, 2, 0);
            }
        }

        /* compiled from: suggested_with_tags */
        public class Serializer extends JsonSerializer<FetchBestAvailableImageUriQueryModel> {
            public final void m4762a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchBestAvailableImageUriQueryModel fetchBestAvailableImageUriQueryModel = (FetchBestAvailableImageUriQueryModel) obj;
                if (fetchBestAvailableImageUriQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchBestAvailableImageUriQueryModel.m4764a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchBestAvailableImageUriQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchBestAvailableImageUriQueryModel.w_();
                int u_ = fetchBestAvailableImageUriQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("image");
                    ImageParser.m4770a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchBestAvailableImageUriQueryModel.class, new Serializer());
            }
        }

        public FetchBestAvailableImageUriQueryModel() {
            super(2);
        }

        public final void m4767a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m4768a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m4763j() {
            if (this.b != null && this.f3546d == null) {
                this.f3546d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f3546d;
        }

        @Nullable
        public final ImageModel m4766a() {
            this.f3547e = (ImageModel) super.a(this.f3547e, 1, ImageModel.class);
            return this.f3547e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m4765a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m4766a() != null) {
                ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m4766a());
                if (m4766a() != imageModel) {
                    graphQLVisitableModel = (FetchBestAvailableImageUriQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3547e = imageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m4764a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m4763j());
            int a2 = ModelHelper.a(flatBufferBuilder, m4766a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
