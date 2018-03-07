package com.facebook.events.planning.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.events.planning.graphql.EventsPlanningMutationsParsers.CreatePollMutationParser;
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
import javax.annotation.Nullable;

/* compiled from: awareness_tutorial_nux */
public class EventsPlanningMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: awareness_tutorial_nux */
    public final class CreatePollMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f19004d;

        /* compiled from: awareness_tutorial_nux */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CreatePollMutationModel.class, new Deserializer());
            }

            public Object m19238a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CreatePollMutationParser.m19243a(jsonParser);
                Object createPollMutationModel = new CreatePollMutationModel();
                ((BaseModel) createPollMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (createPollMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) createPollMutationModel).a();
                }
                return createPollMutationModel;
            }
        }

        /* compiled from: awareness_tutorial_nux */
        public class Serializer extends JsonSerializer<CreatePollMutationModel> {
            public final void m19239a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CreatePollMutationModel createPollMutationModel = (CreatePollMutationModel) obj;
                if (createPollMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(createPollMutationModel.m19241a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    createPollMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = createPollMutationModel.w_();
                int u_ = createPollMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CreatePollMutationModel.class, new Serializer());
            }
        }

        public CreatePollMutationModel() {
            super(1);
        }

        @Nullable
        private String m19240a() {
            this.f19004d = super.a(this.f19004d, 0);
            return this.f19004d;
        }

        public final int jK_() {
            return -1184016484;
        }

        public final GraphQLVisitableModel m19242a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m19241a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m19240a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
