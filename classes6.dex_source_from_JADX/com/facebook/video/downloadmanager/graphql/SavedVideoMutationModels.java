package com.facebook.video.downloadmanager.graphql;

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
import com.facebook.video.downloadmanager.graphql.SavedVideoMutationParsers.SavedVideoDownloadStateMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: connected_wifi */
public class SavedVideoMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1150285657)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: connected_wifi */
    public final class SavedVideoDownloadStateMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f18736d;

        /* compiled from: connected_wifi */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SavedVideoDownloadStateMutationModel.class, new Deserializer());
            }

            public Object m27474a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SavedVideoDownloadStateMutationParser.m27479a(jsonParser);
                Object savedVideoDownloadStateMutationModel = new SavedVideoDownloadStateMutationModel();
                ((BaseModel) savedVideoDownloadStateMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (savedVideoDownloadStateMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) savedVideoDownloadStateMutationModel).a();
                }
                return savedVideoDownloadStateMutationModel;
            }
        }

        /* compiled from: connected_wifi */
        public class Serializer extends JsonSerializer<SavedVideoDownloadStateMutationModel> {
            public final void m27475a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SavedVideoDownloadStateMutationModel savedVideoDownloadStateMutationModel = (SavedVideoDownloadStateMutationModel) obj;
                if (savedVideoDownloadStateMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(savedVideoDownloadStateMutationModel.m27477a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    savedVideoDownloadStateMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = savedVideoDownloadStateMutationModel.w_();
                int u_ = savedVideoDownloadStateMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("video_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SavedVideoDownloadStateMutationModel.class, new Serializer());
            }
        }

        public SavedVideoDownloadStateMutationModel() {
            super(1);
        }

        @Nullable
        private String m27476a() {
            this.f18736d = super.a(this.f18736d, 0);
            return this.f18736d;
        }

        public final int jK_() {
            return 1776578136;
        }

        public final GraphQLVisitableModel m27478a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m27477a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m27476a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
