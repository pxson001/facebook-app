package com.facebook.api.graphql.feed;

import com.facebook.api.graphql.feed.StoryMutationParsers.HideableStoryMutationFieldsParser;
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
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
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

/* compiled from: apiKey */
public class StoryMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -912710348)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: apiKey */
    public final class HideableStoryMutationFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f9470d;
        @Nullable
        private String f9471e;
        @Nullable
        private String f9472f;

        /* compiled from: apiKey */
        public final class Builder {
            @Nullable
            public String f9467a;
            @Nullable
            public String f9468b;
            @Nullable
            public String f9469c;

            public final HideableStoryMutationFieldsModel m16140a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f9467a);
                int b2 = flatBufferBuilder.b(this.f9468b);
                int b3 = flatBufferBuilder.b(this.f9469c);
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, b3);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new HideableStoryMutationFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: apiKey */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(HideableStoryMutationFieldsModel.class, new Deserializer());
            }

            public Object m16141a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = HideableStoryMutationFieldsParser.m16153a(jsonParser);
                Object hideableStoryMutationFieldsModel = new HideableStoryMutationFieldsModel();
                ((BaseModel) hideableStoryMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (hideableStoryMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) hideableStoryMutationFieldsModel).a();
                }
                return hideableStoryMutationFieldsModel;
            }
        }

        /* compiled from: apiKey */
        public class Serializer extends JsonSerializer<HideableStoryMutationFieldsModel> {
            public final void m16142a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                HideableStoryMutationFieldsModel hideableStoryMutationFieldsModel = (HideableStoryMutationFieldsModel) obj;
                if (hideableStoryMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(hideableStoryMutationFieldsModel.m16148a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    hideableStoryMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = hideableStoryMutationFieldsModel.w_();
                int u_ = hideableStoryMutationFieldsModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("local_last_negative_feedback_action_type");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("local_story_visibility");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(HideableStoryMutationFieldsModel.class, new Serializer());
            }
        }

        public HideableStoryMutationFieldsModel() {
            super(3);
        }

        public HideableStoryMutationFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m16151a(String str, ConsistencyTuple consistencyTuple) {
            if ("local_last_negative_feedback_action_type".equals(str)) {
                consistencyTuple.a = m16146k();
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
            } else if ("local_story_visibility".equals(str)) {
                consistencyTuple.a = m16147l();
                consistencyTuple.b = u_();
                consistencyTuple.c = 2;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m16152a(String str, Object obj, boolean z) {
            if ("local_last_negative_feedback_action_type".equals(str)) {
                m16143a((String) obj);
            } else if ("local_story_visibility".equals(str)) {
                m16144b((String) obj);
            }
        }

        @Nullable
        private String m16145j() {
            this.f9470d = super.a(this.f9470d, 0);
            return this.f9470d;
        }

        @Nullable
        private String m16146k() {
            this.f9471e = super.a(this.f9471e, 1);
            return this.f9471e;
        }

        private void m16143a(@Nullable String str) {
            this.f9471e = str;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, str);
            }
        }

        @Nullable
        private String m16147l() {
            this.f9472f = super.a(this.f9472f, 2);
            return this.f9472f;
        }

        private void m16144b(@Nullable String str) {
            this.f9472f = str;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 2, str);
            }
        }

        @Nullable
        public final String m16150a() {
            return m16145j();
        }

        public final int jK_() {
            return 80218325;
        }

        public final GraphQLVisitableModel m16149a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m16148a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16145j());
            int b2 = flatBufferBuilder.b(m16146k());
            int b3 = flatBufferBuilder.b(m16147l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            i();
            return flatBufferBuilder.d();
        }
    }
}
