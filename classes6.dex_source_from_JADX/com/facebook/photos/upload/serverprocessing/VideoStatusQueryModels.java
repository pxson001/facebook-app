package com.facebook.photos.upload.serverprocessing;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLVideoStatusType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.photos.upload.serverprocessing.VideoStatusQueryParsers.VideoStatusQueryParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: fullTextMatchedSubstrings */
public class VideoStatusQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1315002444)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: fullTextMatchedSubstrings */
    public final class VideoStatusQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f14251d;
        private int f14252e;
        @Nullable
        private GraphQLVideoStatusType f14253f;

        /* compiled from: fullTextMatchedSubstrings */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(VideoStatusQueryModel.class, new Deserializer());
            }

            public Object m21923a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(VideoStatusQueryParser.m21931a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object videoStatusQueryModel = new VideoStatusQueryModel();
                ((BaseModel) videoStatusQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (videoStatusQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) videoStatusQueryModel).a();
                }
                return videoStatusQueryModel;
            }
        }

        /* compiled from: fullTextMatchedSubstrings */
        public class Serializer extends JsonSerializer<VideoStatusQueryModel> {
            public final void m21924a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                VideoStatusQueryModel videoStatusQueryModel = (VideoStatusQueryModel) obj;
                if (videoStatusQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(videoStatusQueryModel.m21926a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    videoStatusQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = videoStatusQueryModel.w_();
                int u_ = videoStatusQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int a = mutableFlatBuffer.a(u_, 1, 0);
                if (a != 0) {
                    jsonGenerator.a("processing_progress");
                    jsonGenerator.b(a);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("video_status_type");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(VideoStatusQueryModel.class, new Serializer());
            }
        }

        public VideoStatusQueryModel() {
            super(3);
        }

        @Nullable
        private String m21925k() {
            this.f14251d = super.a(this.f14251d, 0);
            return this.f14251d;
        }

        @Nullable
        public final GraphQLVideoStatusType m21930j() {
            this.f14253f = (GraphQLVideoStatusType) super.b(this.f14253f, 2, GraphQLVideoStatusType.class, GraphQLVideoStatusType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f14253f;
        }

        @Nullable
        public final String m21928a() {
            return m21925k();
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m21927a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m21926a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m21925k());
            int a = flatBufferBuilder.a(m21930j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f14252e, 0);
            flatBufferBuilder.b(2, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m21929a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f14252e = mutableFlatBuffer.a(i, 1, 0);
        }
    }
}
