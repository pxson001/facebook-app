package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentParser;
import com.facebook.adinterfaces.protocol.BoostedComponentDeleteMutationParsers.BoostedComponentDeleteMutationParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
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

/* compiled from: X-Entity-Name */
public class BoostedComponentDeleteMutationModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1511475002)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: X-Entity-Name */
    public final class BoostedComponentDeleteMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private BoostedComponentModel f22303d;

        /* compiled from: X-Entity-Name */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BoostedComponentDeleteMutationModel.class, new Deserializer());
            }

            public Object m24034a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = BoostedComponentDeleteMutationParser.m24039a(jsonParser);
                Object boostedComponentDeleteMutationModel = new BoostedComponentDeleteMutationModel();
                ((BaseModel) boostedComponentDeleteMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (boostedComponentDeleteMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) boostedComponentDeleteMutationModel).a();
                }
                return boostedComponentDeleteMutationModel;
            }
        }

        /* compiled from: X-Entity-Name */
        public class Serializer extends JsonSerializer<BoostedComponentDeleteMutationModel> {
            public final void m24035a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                BoostedComponentDeleteMutationModel boostedComponentDeleteMutationModel = (BoostedComponentDeleteMutationModel) obj;
                if (boostedComponentDeleteMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(boostedComponentDeleteMutationModel.m24037a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    boostedComponentDeleteMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = boostedComponentDeleteMutationModel.w_();
                int u_ = boostedComponentDeleteMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("boosted_component");
                    BoostedComponentParser.m23827b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(BoostedComponentDeleteMutationModel.class, new Serializer());
            }
        }

        public BoostedComponentDeleteMutationModel() {
            super(1);
        }

        @Nullable
        private BoostedComponentModel m24036a() {
            this.f22303d = (BoostedComponentModel) super.a(this.f22303d, 0, BoostedComponentModel.class);
            return this.f22303d;
        }

        public final int jK_() {
            return 1390580711;
        }

        public final GraphQLVisitableModel m24038a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24036a() != null) {
                BoostedComponentModel boostedComponentModel = (BoostedComponentModel) graphQLModelMutatingVisitor.b(m24036a());
                if (m24036a() != boostedComponentModel) {
                    graphQLVisitableModel = (BoostedComponentDeleteMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22303d = boostedComponentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24037a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24036a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
