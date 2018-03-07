package com.facebook.messaging.peopleyoumaymessage.graphql;

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
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.peopleyoumaymessage.graphql.PeopleYouMayMessageMutationsParsers.HidePYMMSuggestionParser;
import com.facebook.messaging.peopleyoumaymessage.graphql.PeopleYouMayMessageMutationsParsers.HidePYMMSuggestionParser.SuggestionParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: download_id */
public class PeopleYouMayMessageMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1146955384)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: download_id */
    public final class HidePYMMSuggestionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SuggestionModel f15994d;

        /* compiled from: download_id */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(HidePYMMSuggestionModel.class, new Deserializer());
            }

            public Object m16111a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = HidePYMMSuggestionParser.m16129a(jsonParser);
                Object hidePYMMSuggestionModel = new HidePYMMSuggestionModel();
                ((BaseModel) hidePYMMSuggestionModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (hidePYMMSuggestionModel instanceof Postprocessable) {
                    return ((Postprocessable) hidePYMMSuggestionModel).a();
                }
                return hidePYMMSuggestionModel;
            }
        }

        /* compiled from: download_id */
        public class Serializer extends JsonSerializer<HidePYMMSuggestionModel> {
            public final void m16112a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                HidePYMMSuggestionModel hidePYMMSuggestionModel = (HidePYMMSuggestionModel) obj;
                if (hidePYMMSuggestionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(hidePYMMSuggestionModel.m16125a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    hidePYMMSuggestionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = hidePYMMSuggestionModel.w_();
                int u_ = hidePYMMSuggestionModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("suggestion");
                    SuggestionParser.m16128a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(HidePYMMSuggestionModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1547430626)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: download_id */
        public final class SuggestionModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f15992d;
            private boolean f15993e;

            /* compiled from: download_id */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SuggestionModel.class, new Deserializer());
                }

                public Object m16113a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SuggestionParser.m16127a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object suggestionModel = new SuggestionModel();
                    ((BaseModel) suggestionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (suggestionModel instanceof Postprocessable) {
                        return ((Postprocessable) suggestionModel).a();
                    }
                    return suggestionModel;
                }
            }

            /* compiled from: download_id */
            public class Serializer extends JsonSerializer<SuggestionModel> {
                public final void m16114a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SuggestionModel suggestionModel = (SuggestionModel) obj;
                    if (suggestionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(suggestionModel.m16118a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        suggestionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SuggestionParser.m16128a(suggestionModel.w_(), suggestionModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SuggestionModel.class, new Serializer());
                }
            }

            public SuggestionModel() {
                super(2);
            }

            public final void m16122a(String str, ConsistencyTuple consistencyTuple) {
                if ("is_pymm_hidden".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m16117k());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m16123a(String str, Object obj, boolean z) {
                if ("is_pymm_hidden".equals(str)) {
                    m16115a(((Boolean) obj).booleanValue());
                }
            }

            @Nullable
            private String m16116j() {
                this.f15992d = super.a(this.f15992d, 0);
                return this.f15992d;
            }

            private boolean m16117k() {
                a(0, 1);
                return this.f15993e;
            }

            private void m16115a(boolean z) {
                this.f15993e = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, z);
                }
            }

            @Nullable
            public final String m16120a() {
                return m16116j();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m16119a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16118a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16116j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f15993e);
                i();
                return flatBufferBuilder.d();
            }

            public final void m16121a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f15993e = mutableFlatBuffer.a(i, 1);
            }
        }

        public HidePYMMSuggestionModel() {
            super(1);
        }

        @Nullable
        private SuggestionModel m16124a() {
            this.f15994d = (SuggestionModel) super.a(this.f15994d, 0, SuggestionModel.class);
            return this.f15994d;
        }

        public final int jK_() {
            return -68122946;
        }

        public final GraphQLVisitableModel m16126a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16124a() != null) {
                SuggestionModel suggestionModel = (SuggestionModel) graphQLModelMutatingVisitor.b(m16124a());
                if (m16124a() != suggestionModel) {
                    graphQLVisitableModel = (HidePYMMSuggestionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15994d = suggestionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16125a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16124a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
