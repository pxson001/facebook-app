package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentValidationMessageModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentValidationMessageParser;
import com.facebook.adinterfaces.protocol.BoostedComponentCreateMutationParsers.BoostedComponentCreateMutationParser;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: XMA doesn't contain a story attachment. */
public class BoostedComponentCreateMutationModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2062329032)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: XMA doesn't contain a story attachment. */
    public final class BoostedComponentCreateMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private BoostedComponentModel f22278d;
        @Nullable
        private List<BoostedComponentValidationMessageModel> f22279e;

        /* compiled from: XMA doesn't contain a story attachment. */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BoostedComponentCreateMutationModel.class, new Deserializer());
            }

            public Object m23964a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = BoostedComponentCreateMutationParser.m23970a(jsonParser);
                Object boostedComponentCreateMutationModel = new BoostedComponentCreateMutationModel();
                ((BaseModel) boostedComponentCreateMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (boostedComponentCreateMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) boostedComponentCreateMutationModel).a();
                }
                return boostedComponentCreateMutationModel;
            }
        }

        /* compiled from: XMA doesn't contain a story attachment. */
        public class Serializer extends JsonSerializer<BoostedComponentCreateMutationModel> {
            public final void m23965a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                BoostedComponentCreateMutationModel boostedComponentCreateMutationModel = (BoostedComponentCreateMutationModel) obj;
                if (boostedComponentCreateMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(boostedComponentCreateMutationModel.m23967a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    boostedComponentCreateMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = boostedComponentCreateMutationModel.w_();
                int u_ = boostedComponentCreateMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("boosted_component");
                    BoostedComponentParser.m23827b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("validation_messages");
                    BoostedComponentValidationMessageParser.m23829a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(BoostedComponentCreateMutationModel.class, new Serializer());
            }
        }

        public BoostedComponentCreateMutationModel() {
            super(2);
        }

        @Nullable
        private BoostedComponentModel m23966j() {
            this.f22278d = (BoostedComponentModel) super.a(this.f22278d, 0, BoostedComponentModel.class);
            return this.f22278d;
        }

        @Nonnull
        public final ImmutableList<BoostedComponentValidationMessageModel> m23969a() {
            this.f22279e = super.a(this.f22279e, 1, BoostedComponentValidationMessageModel.class);
            return (ImmutableList) this.f22279e;
        }

        public final int jK_() {
            return 1469140086;
        }

        public final GraphQLVisitableModel m23968a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23966j() != null) {
                BoostedComponentModel boostedComponentModel = (BoostedComponentModel) graphQLModelMutatingVisitor.b(m23966j());
                if (m23966j() != boostedComponentModel) {
                    graphQLVisitableModel = (BoostedComponentCreateMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22278d = boostedComponentModel;
                }
            }
            if (m23969a() != null) {
                Builder a = ModelHelper.a(m23969a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    BoostedComponentCreateMutationModel boostedComponentCreateMutationModel = (BoostedComponentCreateMutationModel) ModelHelper.a(graphQLVisitableModel, this);
                    boostedComponentCreateMutationModel.f22279e = a.b();
                    graphQLVisitableModel = boostedComponentCreateMutationModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23967a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23966j());
            int a2 = ModelHelper.a(flatBufferBuilder, m23969a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
