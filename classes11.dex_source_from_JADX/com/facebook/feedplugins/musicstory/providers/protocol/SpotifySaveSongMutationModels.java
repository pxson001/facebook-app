package com.facebook.feedplugins.musicstory.providers.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feedplugins.musicstory.providers.protocol.SpotifySaveSongMutationParsers.SpotifySaveSongMutationParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;

/* compiled from: com.facebook.places.create.NewPlaceCreationActivity */
public class SpotifySaveSongMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1777928799)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: com.facebook.places.create.NewPlaceCreationActivity */
    public final class SpotifySaveSongMutationModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f8398d;

        /* compiled from: com.facebook.places.create.NewPlaceCreationActivity */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SpotifySaveSongMutationModel.class, new Deserializer());
            }

            public Object m9294a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SpotifySaveSongMutationParser.m9300a(jsonParser);
                Object spotifySaveSongMutationModel = new SpotifySaveSongMutationModel();
                ((BaseModel) spotifySaveSongMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (spotifySaveSongMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) spotifySaveSongMutationModel).a();
                }
                return spotifySaveSongMutationModel;
            }
        }

        /* compiled from: com.facebook.places.create.NewPlaceCreationActivity */
        public class Serializer extends JsonSerializer<SpotifySaveSongMutationModel> {
            public final void m9295a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SpotifySaveSongMutationModel spotifySaveSongMutationModel = (SpotifySaveSongMutationModel) obj;
                if (spotifySaveSongMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(spotifySaveSongMutationModel.m9296a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    spotifySaveSongMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = spotifySaveSongMutationModel.w_();
                int u_ = spotifySaveSongMutationModel.u_();
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(u_, 0);
                if (a) {
                    jsonGenerator.a("save_successful");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SpotifySaveSongMutationModel.class, new Serializer());
            }
        }

        public SpotifySaveSongMutationModel() {
            super(1);
        }

        public final boolean m9299a() {
            a(0, 0);
            return this.f8398d;
        }

        public final int jK_() {
            return 2108768129;
        }

        public final GraphQLVisitableModel m9297a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m9296a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(1);
            flatBufferBuilder.a(0, this.f8398d);
            i();
            return flatBufferBuilder.d();
        }

        public final void m9298a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f8398d = mutableFlatBuffer.a(i, 0);
        }
    }
}
