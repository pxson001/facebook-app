package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentParser;
import com.facebook.adinterfaces.protocol.BoostedComponentEditMutationParsers.BoostedComponentEditMutationParser;
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

/* compiled from: Wrong object type used with protocol message reflection. */
public class BoostedComponentEditMutationModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1511475002)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: Wrong object type used with protocol message reflection. */
    public final class BoostedComponentEditMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private BoostedComponentModel f22304d;

        /* compiled from: Wrong object type used with protocol message reflection. */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BoostedComponentEditMutationModel.class, new Deserializer());
            }

            public Object m24041a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = BoostedComponentEditMutationParser.m24046a(jsonParser);
                Object boostedComponentEditMutationModel = new BoostedComponentEditMutationModel();
                ((BaseModel) boostedComponentEditMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (boostedComponentEditMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) boostedComponentEditMutationModel).a();
                }
                return boostedComponentEditMutationModel;
            }
        }

        /* compiled from: Wrong object type used with protocol message reflection. */
        public class Serializer extends JsonSerializer<BoostedComponentEditMutationModel> {
            public final void m24042a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                BoostedComponentEditMutationModel boostedComponentEditMutationModel = (BoostedComponentEditMutationModel) obj;
                if (boostedComponentEditMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(boostedComponentEditMutationModel.m24044a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    boostedComponentEditMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = boostedComponentEditMutationModel.w_();
                int u_ = boostedComponentEditMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("boosted_component");
                    BoostedComponentParser.m23827b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(BoostedComponentEditMutationModel.class, new Serializer());
            }
        }

        public BoostedComponentEditMutationModel() {
            super(1);
        }

        @Nullable
        private BoostedComponentModel m24043a() {
            this.f22304d = (BoostedComponentModel) super.a(this.f22304d, 0, BoostedComponentModel.class);
            return this.f22304d;
        }

        public final int jK_() {
            return -139657496;
        }

        public final GraphQLVisitableModel m24045a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24043a() != null) {
                BoostedComponentModel boostedComponentModel = (BoostedComponentModel) graphQLModelMutatingVisitor.b(m24043a());
                if (m24043a() != boostedComponentModel) {
                    graphQLVisitableModel = (BoostedComponentEditMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22304d = boostedComponentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24044a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24043a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
