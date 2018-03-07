package com.facebook.feedplugins.placetips.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feedplugins.placetips.graphql.SuggestifierQuestionVoteMutationParsers.SuggestifierQuestionVoteMutationParser;
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

/* compiled from: friend_end_cursor */
public class SuggestifierQuestionVoteMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: friend_end_cursor */
    public final class SuggestifierQuestionVoteMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f12939d;

        /* compiled from: friend_end_cursor */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SuggestifierQuestionVoteMutationModel.class, new Deserializer());
            }

            public Object m14665a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SuggestifierQuestionVoteMutationParser.m14670a(jsonParser);
                Object suggestifierQuestionVoteMutationModel = new SuggestifierQuestionVoteMutationModel();
                ((BaseModel) suggestifierQuestionVoteMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (suggestifierQuestionVoteMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) suggestifierQuestionVoteMutationModel).a();
                }
                return suggestifierQuestionVoteMutationModel;
            }
        }

        /* compiled from: friend_end_cursor */
        public class Serializer extends JsonSerializer<SuggestifierQuestionVoteMutationModel> {
            public final void m14666a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SuggestifierQuestionVoteMutationModel suggestifierQuestionVoteMutationModel = (SuggestifierQuestionVoteMutationModel) obj;
                if (suggestifierQuestionVoteMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(suggestifierQuestionVoteMutationModel.m14668a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    suggestifierQuestionVoteMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = suggestifierQuestionVoteMutationModel.w_();
                int u_ = suggestifierQuestionVoteMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SuggestifierQuestionVoteMutationModel.class, new Serializer());
            }
        }

        public SuggestifierQuestionVoteMutationModel() {
            super(1);
        }

        @Nullable
        private String m14667a() {
            this.f12939d = super.a(this.f12939d, 0);
            return this.f12939d;
        }

        public final int jK_() {
            return 443790088;
        }

        public final GraphQLVisitableModel m14669a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m14668a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m14667a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
