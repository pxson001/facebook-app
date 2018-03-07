package com.facebook.api.graphql.pages;

import com.facebook.api.graphql.pages.FetchPagesYouCanActGraphQLParsers.FeedbackActPagesFragmentParser;
import com.facebook.api.graphql.pages.FetchPagesYouCanActGraphQLParsers.FeedbackActPagesFragmentParser.VoiceSwitcherPagesParser;
import com.facebook.api.graphql.pages.FetchPagesYouCanActGraphQLParsers.FeedbackActPagesFragmentParser.VoiceSwitcherPagesParser.NodesParser;
import com.facebook.api.graphql.pages.FetchPagesYouCanActGraphQLParsers.FetchPagesYouCanActParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: android_popover_place_picker_long_press_report_duplicates */
public class FetchPagesYouCanActGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1453677688)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_popover_place_picker_long_press_report_duplicates */
    public final class FeedbackActPagesFragmentModel extends BaseModel implements GraphQLVisitableConsistentModel {
        private boolean f9756d;
        @Nullable
        private VoiceSwitcherPagesModel f9757e;

        /* compiled from: android_popover_place_picker_long_press_report_duplicates */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeedbackActPagesFragmentModel.class, new Deserializer());
            }

            public Object m16879a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FeedbackActPagesFragmentParser.m16917a(jsonParser);
                Object feedbackActPagesFragmentModel = new FeedbackActPagesFragmentModel();
                ((BaseModel) feedbackActPagesFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (feedbackActPagesFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) feedbackActPagesFragmentModel).a();
                }
                return feedbackActPagesFragmentModel;
            }
        }

        /* compiled from: android_popover_place_picker_long_press_report_duplicates */
        public class Serializer extends JsonSerializer<FeedbackActPagesFragmentModel> {
            public final void m16880a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FeedbackActPagesFragmentModel feedbackActPagesFragmentModel = (FeedbackActPagesFragmentModel) obj;
                if (feedbackActPagesFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(feedbackActPagesFragmentModel.m16897a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    feedbackActPagesFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = feedbackActPagesFragmentModel.w_();
                int u_ = feedbackActPagesFragmentModel.u_();
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(u_, 0);
                if (a) {
                    jsonGenerator.a("can_see_voice_switcher");
                    jsonGenerator.a(a);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("voice_switcher_pages");
                    VoiceSwitcherPagesParser.m16916a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FeedbackActPagesFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -652875769)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_popover_place_picker_long_press_report_duplicates */
        public final class VoiceSwitcherPagesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f9755d;

            /* compiled from: android_popover_place_picker_long_press_report_duplicates */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VoiceSwitcherPagesModel.class, new Deserializer());
                }

                public Object m16881a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VoiceSwitcherPagesParser.m16915a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object voiceSwitcherPagesModel = new VoiceSwitcherPagesModel();
                    ((BaseModel) voiceSwitcherPagesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (voiceSwitcherPagesModel instanceof Postprocessable) {
                        return ((Postprocessable) voiceSwitcherPagesModel).a();
                    }
                    return voiceSwitcherPagesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 2106355611)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_popover_place_picker_long_press_report_duplicates */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f9752d;
                @Nullable
                private String f9753e;
                @Nullable
                private DefaultImageFieldsModel f9754f;

                /* compiled from: android_popover_place_picker_long_press_report_duplicates */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m16882a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m16913b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                /* compiled from: android_popover_place_picker_long_press_report_duplicates */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m16883a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m16887a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m16914b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(3);
                }

                public final void m16890a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m16891a(String str, Object obj, boolean z) {
                }

                @Nullable
                private String m16884j() {
                    this.f9752d = super.a(this.f9752d, 0);
                    return this.f9752d;
                }

                @Nullable
                private String m16885k() {
                    this.f9753e = super.a(this.f9753e, 1);
                    return this.f9753e;
                }

                @Nullable
                private DefaultImageFieldsModel m16886l() {
                    this.f9754f = (DefaultImageFieldsModel) super.a(this.f9754f, 2, DefaultImageFieldsModel.class);
                    return this.f9754f;
                }

                @Nullable
                public final String m16889a() {
                    return m16884j();
                }

                public final int jK_() {
                    return 2479791;
                }

                public final GraphQLVisitableModel m16888a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m16886l() != null) {
                        DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m16886l());
                        if (m16886l() != defaultImageFieldsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f9754f = defaultImageFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m16887a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m16884j());
                    int b2 = flatBufferBuilder.b(m16885k());
                    int a = ModelHelper.a(flatBufferBuilder, m16886l());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    flatBufferBuilder.b(2, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: android_popover_place_picker_long_press_report_duplicates */
            public class Serializer extends JsonSerializer<VoiceSwitcherPagesModel> {
                public final void m16892a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VoiceSwitcherPagesModel voiceSwitcherPagesModel = (VoiceSwitcherPagesModel) obj;
                    if (voiceSwitcherPagesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(voiceSwitcherPagesModel.m16894a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        voiceSwitcherPagesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VoiceSwitcherPagesParser.m16916a(voiceSwitcherPagesModel.w_(), voiceSwitcherPagesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(VoiceSwitcherPagesModel.class, new Serializer());
                }
            }

            public VoiceSwitcherPagesModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<NodesModel> m16893a() {
                this.f9755d = super.a(this.f9755d, 0, NodesModel.class);
                return (ImmutableList) this.f9755d;
            }

            public final int jK_() {
                return 1123642159;
            }

            public final GraphQLVisitableModel m16895a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16893a() != null) {
                    Builder a = ModelHelper.a(m16893a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (VoiceSwitcherPagesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9755d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16894a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16893a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FeedbackActPagesFragmentModel() {
            super(2);
        }

        public final void m16900a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m16901a(String str, Object obj, boolean z) {
        }

        @Nullable
        private VoiceSwitcherPagesModel m16896a() {
            this.f9757e = (VoiceSwitcherPagesModel) super.a(this.f9757e, 1, VoiceSwitcherPagesModel.class);
            return this.f9757e;
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m16898a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16896a() != null) {
                VoiceSwitcherPagesModel voiceSwitcherPagesModel = (VoiceSwitcherPagesModel) graphQLModelMutatingVisitor.b(m16896a());
                if (m16896a() != voiceSwitcherPagesModel) {
                    graphQLVisitableModel = (FeedbackActPagesFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9757e = voiceSwitcherPagesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16897a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16896a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f9756d);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16899a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9756d = mutableFlatBuffer.a(i, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1542116174)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_popover_place_picker_long_press_report_duplicates */
    public final class FetchPagesYouCanActModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f9758d;
        private boolean f9759e;
        @Nullable
        private String f9760f;
        @Nullable
        private VoiceSwitcherPagesModel f9761g;

        /* compiled from: android_popover_place_picker_long_press_report_duplicates */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchPagesYouCanActModel.class, new Deserializer());
            }

            public Object m16902a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FetchPagesYouCanActParser.m16918a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fetchPagesYouCanActModel = new FetchPagesYouCanActModel();
                ((BaseModel) fetchPagesYouCanActModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fetchPagesYouCanActModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchPagesYouCanActModel).a();
                }
                return fetchPagesYouCanActModel;
            }
        }

        /* compiled from: android_popover_place_picker_long_press_report_duplicates */
        public class Serializer extends JsonSerializer<FetchPagesYouCanActModel> {
            public final void m16903a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchPagesYouCanActModel fetchPagesYouCanActModel = (FetchPagesYouCanActModel) obj;
                if (fetchPagesYouCanActModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchPagesYouCanActModel.m16907a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchPagesYouCanActModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchPagesYouCanActModel.w_();
                int u_ = fetchPagesYouCanActModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                boolean a = mutableFlatBuffer.a(u_, 1);
                if (a) {
                    jsonGenerator.a("can_see_voice_switcher");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                int g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("voice_switcher_pages");
                    VoiceSwitcherPagesParser.m16916a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchPagesYouCanActModel.class, new Serializer());
            }
        }

        public FetchPagesYouCanActModel() {
            super(4);
        }

        public final void m16911a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m16912a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m16904j() {
            if (this.b != null && this.f9758d == null) {
                this.f9758d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f9758d;
        }

        @Nullable
        private String m16905k() {
            this.f9760f = super.a(this.f9760f, 2);
            return this.f9760f;
        }

        @Nullable
        private VoiceSwitcherPagesModel m16906l() {
            this.f9761g = (VoiceSwitcherPagesModel) super.a(this.f9761g, 3, VoiceSwitcherPagesModel.class);
            return this.f9761g;
        }

        @Nullable
        public final String m16909a() {
            return m16905k();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m16908a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16906l() != null) {
                VoiceSwitcherPagesModel voiceSwitcherPagesModel = (VoiceSwitcherPagesModel) graphQLModelMutatingVisitor.b(m16906l());
                if (m16906l() != voiceSwitcherPagesModel) {
                    graphQLVisitableModel = (FetchPagesYouCanActModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9761g = voiceSwitcherPagesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16907a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16904j());
            int b = flatBufferBuilder.b(m16905k());
            int a2 = ModelHelper.a(flatBufferBuilder, m16906l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f9759e);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16910a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9759e = mutableFlatBuffer.a(i, 1);
        }
    }
}
