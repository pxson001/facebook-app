package com.facebook.video.videohome.protocol;

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
import com.facebook.video.videohome.protocol.VideoHomeMutationsParsers.VideoHomeVisitMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: diode_timeline */
public class VideoHomeMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: diode_timeline */
    public final class VideoHomeVisitMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f15759d;

        /* compiled from: diode_timeline */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(VideoHomeVisitMutationModel.class, new Deserializer());
            }

            public Object m19677a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = VideoHomeVisitMutationParser.m19682a(jsonParser);
                Object videoHomeVisitMutationModel = new VideoHomeVisitMutationModel();
                ((BaseModel) videoHomeVisitMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (videoHomeVisitMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) videoHomeVisitMutationModel).a();
                }
                return videoHomeVisitMutationModel;
            }
        }

        /* compiled from: diode_timeline */
        public class Serializer extends JsonSerializer<VideoHomeVisitMutationModel> {
            public final void m19678a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                VideoHomeVisitMutationModel videoHomeVisitMutationModel = (VideoHomeVisitMutationModel) obj;
                if (videoHomeVisitMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(videoHomeVisitMutationModel.m19680a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    videoHomeVisitMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = videoHomeVisitMutationModel.w_();
                int u_ = videoHomeVisitMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(VideoHomeVisitMutationModel.class, new Serializer());
            }
        }

        public VideoHomeVisitMutationModel() {
            super(1);
        }

        @Nullable
        private String m19679a() {
            this.f15759d = super.a(this.f15759d, 0);
            return this.f15759d;
        }

        public final int jK_() {
            return -558710724;
        }

        public final GraphQLVisitableModel m19681a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m19680a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m19679a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
