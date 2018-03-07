package com.facebook.selfupdate.remotepushtrigger.protocol;

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
import com.facebook.selfupdate.remotepushtrigger.protocol.SideloadingFb4aUpgradeWifiActiveGraphQlMutationParsers.SideloadingFb4aUpgradeWifiActiveGraphQlMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: PMA_OVERVIEW_INITIAL_CARDS_DRAWN */
public class SideloadingFb4aUpgradeWifiActiveGraphQlMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: PMA_OVERVIEW_INITIAL_CARDS_DRAWN */
    public final class SideloadingFb4aUpgradeWifiActiveGraphQlMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f12546d;

        /* compiled from: PMA_OVERVIEW_INITIAL_CARDS_DRAWN */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SideloadingFb4aUpgradeWifiActiveGraphQlMutationModel.class, new Deserializer());
            }

            public Object m12943a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SideloadingFb4aUpgradeWifiActiveGraphQlMutationParser.m12948a(jsonParser);
                Object sideloadingFb4aUpgradeWifiActiveGraphQlMutationModel = new SideloadingFb4aUpgradeWifiActiveGraphQlMutationModel();
                ((BaseModel) sideloadingFb4aUpgradeWifiActiveGraphQlMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (sideloadingFb4aUpgradeWifiActiveGraphQlMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) sideloadingFb4aUpgradeWifiActiveGraphQlMutationModel).a();
                }
                return sideloadingFb4aUpgradeWifiActiveGraphQlMutationModel;
            }
        }

        /* compiled from: PMA_OVERVIEW_INITIAL_CARDS_DRAWN */
        public class Serializer extends JsonSerializer<SideloadingFb4aUpgradeWifiActiveGraphQlMutationModel> {
            public final void m12944a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SideloadingFb4aUpgradeWifiActiveGraphQlMutationModel sideloadingFb4aUpgradeWifiActiveGraphQlMutationModel = (SideloadingFb4aUpgradeWifiActiveGraphQlMutationModel) obj;
                if (sideloadingFb4aUpgradeWifiActiveGraphQlMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(sideloadingFb4aUpgradeWifiActiveGraphQlMutationModel.m12946a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    sideloadingFb4aUpgradeWifiActiveGraphQlMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = sideloadingFb4aUpgradeWifiActiveGraphQlMutationModel.w_();
                int u_ = sideloadingFb4aUpgradeWifiActiveGraphQlMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SideloadingFb4aUpgradeWifiActiveGraphQlMutationModel.class, new Serializer());
            }
        }

        public SideloadingFb4aUpgradeWifiActiveGraphQlMutationModel() {
            super(1);
        }

        @Nullable
        private String m12945a() {
            this.f12546d = super.a(this.f12546d, 0);
            return this.f12546d;
        }

        public final int jK_() {
            return 720514047;
        }

        public final GraphQLVisitableModel m12947a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m12946a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m12945a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
