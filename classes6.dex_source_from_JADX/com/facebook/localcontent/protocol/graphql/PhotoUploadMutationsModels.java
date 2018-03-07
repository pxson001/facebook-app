package com.facebook.localcontent.protocol.graphql;

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
import com.facebook.localcontent.protocol.graphql.PhotoUploadMutationsParsers.PagePhotoMenuUploadParser;
import com.facebook.localcontent.protocol.graphql.PhotoUploadMutationsParsers.PlacePhotoUploadParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: keywords_top(%s) */
public class PhotoUploadMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: keywords_top(%s) */
    public final class PagePhotoMenuUploadModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f11795d;

        /* compiled from: keywords_top(%s) */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PagePhotoMenuUploadModel.class, new Deserializer());
            }

            public Object m18648a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PagePhotoMenuUploadParser.m18658a(jsonParser);
                Object pagePhotoMenuUploadModel = new PagePhotoMenuUploadModel();
                ((BaseModel) pagePhotoMenuUploadModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pagePhotoMenuUploadModel instanceof Postprocessable) {
                    return ((Postprocessable) pagePhotoMenuUploadModel).a();
                }
                return pagePhotoMenuUploadModel;
            }
        }

        /* compiled from: keywords_top(%s) */
        public class Serializer extends JsonSerializer<PagePhotoMenuUploadModel> {
            public final void m18649a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PagePhotoMenuUploadModel pagePhotoMenuUploadModel = (PagePhotoMenuUploadModel) obj;
                if (pagePhotoMenuUploadModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pagePhotoMenuUploadModel.m18651a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pagePhotoMenuUploadModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pagePhotoMenuUploadModel.w_();
                int u_ = pagePhotoMenuUploadModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PagePhotoMenuUploadModel.class, new Serializer());
            }
        }

        public PagePhotoMenuUploadModel() {
            super(1);
        }

        @Nullable
        private String m18650a() {
            this.f11795d = super.a(this.f11795d, 0);
            return this.f11795d;
        }

        public final int jK_() {
            return 1545167132;
        }

        public final GraphQLVisitableModel m18652a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m18651a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m18650a());
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
    /* compiled from: keywords_top(%s) */
    public final class PlacePhotoUploadModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f11796d;

        /* compiled from: keywords_top(%s) */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PlacePhotoUploadModel.class, new Deserializer());
            }

            public Object m18653a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PlacePhotoUploadParser.m18659a(jsonParser);
                Object placePhotoUploadModel = new PlacePhotoUploadModel();
                ((BaseModel) placePhotoUploadModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (placePhotoUploadModel instanceof Postprocessable) {
                    return ((Postprocessable) placePhotoUploadModel).a();
                }
                return placePhotoUploadModel;
            }
        }

        /* compiled from: keywords_top(%s) */
        public class Serializer extends JsonSerializer<PlacePhotoUploadModel> {
            public final void m18654a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PlacePhotoUploadModel placePhotoUploadModel = (PlacePhotoUploadModel) obj;
                if (placePhotoUploadModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(placePhotoUploadModel.m18656a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    placePhotoUploadModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = placePhotoUploadModel.w_();
                int u_ = placePhotoUploadModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PlacePhotoUploadModel.class, new Serializer());
            }
        }

        public PlacePhotoUploadModel() {
            super(1);
        }

        @Nullable
        private String m18655a() {
            this.f11796d = super.a(this.f11796d, 0);
            return this.f11796d;
        }

        public final int jK_() {
            return -1603733247;
        }

        public final GraphQLVisitableModel m18657a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m18656a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m18655a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
