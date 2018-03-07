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
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.SimpleMediaFeedbackParser.LikersParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -1723990064)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: suggest_edits */
public final class PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel extends BaseModel implements GraphQLVisitableModel {
    private int f3831d;

    /* compiled from: suggest_edits */
    public final class Builder {
        public int f3830a;
    }

    /* compiled from: suggest_edits */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel.class, new Deserializer());
        }

        public Object m5337a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(LikersParser.m5486a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object photosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel = new PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel();
            ((BaseModel) photosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (photosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel instanceof Postprocessable) {
                return ((Postprocessable) photosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel).a();
            }
            return photosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel;
        }
    }

    /* compiled from: suggest_edits */
    public class Serializer extends JsonSerializer<PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel> {
        public final void m5338a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel photosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel = (PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel) obj;
            if (photosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(photosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel.m5341a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                photosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            LikersParser.m5487a(photosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel.w_(), photosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel.class, new Serializer());
        }
    }

    public PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel() {
        super(1);
    }

    public PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel(MutableFlatBuffer mutableFlatBuffer) {
        super(1);
        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
    }

    public final int m5340a() {
        a(0, 0);
        return this.f3831d;
    }

    public final void m5343a(int i) {
        this.f3831d = i;
        if (this.b != null && this.b.d) {
            this.b.b(this.c, 0, i);
        }
    }

    public static PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel m5339a(PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel photosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel) {
        if (photosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel == null) {
            return null;
        }
        if (photosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel instanceof PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel) {
            return photosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel;
        }
        Builder builder = new Builder();
        builder.f3830a = photosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel.m5340a();
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.c(1);
        flatBufferBuilder.a(0, builder.f3830a, 0);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    public final int jK_() {
        return 733369288;
    }

    public final GraphQLVisitableModel m5342a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m5341a(FlatBufferBuilder flatBufferBuilder) {
        h();
        flatBufferBuilder.c(1);
        flatBufferBuilder.a(0, this.f3831d, 0);
        i();
        return flatBufferBuilder.d();
    }

    public final void m5344a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3831d = mutableFlatBuffer.a(i, 0, 0);
    }
}
