package com.facebook.growth.sem.graphql;

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
import com.facebook.growth.sem.graphql.UserSemClickTrackingMutationsParsers.UserSemClickTrackingMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: vnd.android.cursor.item/vnd.facebook.profile */
public class UserSemClickTrackingMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: vnd.android.cursor.item/vnd.facebook.profile */
    public final class UserSemClickTrackingMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f359d;

        /* compiled from: vnd.android.cursor.item/vnd.facebook.profile */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(UserSemClickTrackingMutationModel.class, new Deserializer());
            }

            public Object m488a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = UserSemClickTrackingMutationParser.m493a(jsonParser);
                Object userSemClickTrackingMutationModel = new UserSemClickTrackingMutationModel();
                ((BaseModel) userSemClickTrackingMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (userSemClickTrackingMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) userSemClickTrackingMutationModel).a();
                }
                return userSemClickTrackingMutationModel;
            }
        }

        /* compiled from: vnd.android.cursor.item/vnd.facebook.profile */
        public class Serializer extends JsonSerializer<UserSemClickTrackingMutationModel> {
            public final void m489a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                UserSemClickTrackingMutationModel userSemClickTrackingMutationModel = (UserSemClickTrackingMutationModel) obj;
                if (userSemClickTrackingMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(userSemClickTrackingMutationModel.m491a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    userSemClickTrackingMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = userSemClickTrackingMutationModel.w_();
                int u_ = userSemClickTrackingMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(UserSemClickTrackingMutationModel.class, new Serializer());
            }
        }

        public UserSemClickTrackingMutationModel() {
            super(1);
        }

        @Nullable
        private String m490a() {
            this.f359d = super.a(this.f359d, 0);
            return this.f359d;
        }

        public final int jK_() {
            return 1189706814;
        }

        public final GraphQLVisitableModel m492a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m491a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m490a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
