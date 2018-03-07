package com.facebook.messaging.contextbanner.graphql;

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
import com.facebook.messaging.contextbanner.graphql.PageContextQueryParsers.PageContextQueryParser;
import com.facebook.messaging.contextbanner.graphql.PageContextQueryParsers.PageContextQueryParser.MessengerContextBannerParser;
import com.facebook.messaging.contextbanner.graphql.PageContextQueryParsers.PageContextQueryParser.MessengerContextBannerParser.SubtitlesParser;
import com.facebook.messaging.contextbanner.graphql.PageContextQueryParsers.PageContextQueryParser.MessengerContextBannerParser.TitleParser;
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

/* compiled from: suggested photos should be between 1 and 4. actual is  */
public class PageContextQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1851187093)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: suggested photos should be between 1 and 4. actual is  */
    public final class PageContextQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f2204d;
        private boolean f2205e;
        private boolean f2206f;
        @Nullable
        private MessengerContextBannerModel f2207g;
        @Nullable
        private String f2208h;

        /* compiled from: suggested photos should be between 1 and 4. actual is  */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageContextQueryModel.class, new Deserializer());
            }

            public Object m2016a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PageContextQueryParser.m2052a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pageContextQueryModel = new PageContextQueryModel();
                ((BaseModel) pageContextQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pageContextQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) pageContextQueryModel).a();
                }
                return pageContextQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1665531868)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: suggested photos should be between 1 and 4. actual is  */
        public final class MessengerContextBannerModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<SubtitlesModel> f2202d;
            @Nullable
            private TitleModel f2203e;

            /* compiled from: suggested photos should be between 1 and 4. actual is  */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessengerContextBannerModel.class, new Deserializer());
                }

                public Object m2017a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessengerContextBannerParser.m2050a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messengerContextBannerModel = new MessengerContextBannerModel();
                    ((BaseModel) messengerContextBannerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messengerContextBannerModel instanceof Postprocessable) {
                        return ((Postprocessable) messengerContextBannerModel).a();
                    }
                    return messengerContextBannerModel;
                }
            }

            /* compiled from: suggested photos should be between 1 and 4. actual is  */
            public class Serializer extends JsonSerializer<MessengerContextBannerModel> {
                public final void m2018a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessengerContextBannerModel messengerContextBannerModel = (MessengerContextBannerModel) obj;
                    if (messengerContextBannerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messengerContextBannerModel.m2030a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messengerContextBannerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessengerContextBannerParser.m2051a(messengerContextBannerModel.w_(), messengerContextBannerModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MessengerContextBannerModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: suggested photos should be between 1 and 4. actual is  */
            public final class SubtitlesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f2200d;

                /* compiled from: suggested photos should be between 1 and 4. actual is  */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(SubtitlesModel.class, new Deserializer());
                    }

                    public Object m2019a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(SubtitlesParser.m2047b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object subtitlesModel = new SubtitlesModel();
                        ((BaseModel) subtitlesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (subtitlesModel instanceof Postprocessable) {
                            return ((Postprocessable) subtitlesModel).a();
                        }
                        return subtitlesModel;
                    }
                }

                /* compiled from: suggested photos should be between 1 and 4. actual is  */
                public class Serializer extends JsonSerializer<SubtitlesModel> {
                    public final void m2020a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        SubtitlesModel subtitlesModel = (SubtitlesModel) obj;
                        if (subtitlesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(subtitlesModel.m2021a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            subtitlesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        SubtitlesParser.m2046a(subtitlesModel.w_(), subtitlesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(SubtitlesModel.class, new Serializer());
                    }
                }

                public SubtitlesModel() {
                    super(1);
                }

                @Nullable
                public final String m2023a() {
                    this.f2200d = super.a(this.f2200d, 0);
                    return this.f2200d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m2022a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2021a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m2023a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: suggested photos should be between 1 and 4. actual is  */
            public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f2201d;

                /* compiled from: suggested photos should be between 1 and 4. actual is  */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                    }

                    public Object m2024a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(TitleParser.m2048a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object titleModel = new TitleModel();
                        ((BaseModel) titleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (titleModel instanceof Postprocessable) {
                            return ((Postprocessable) titleModel).a();
                        }
                        return titleModel;
                    }
                }

                /* compiled from: suggested photos should be between 1 and 4. actual is  */
                public class Serializer extends JsonSerializer<TitleModel> {
                    public final void m2025a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TitleModel titleModel = (TitleModel) obj;
                        if (titleModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(titleModel.m2026a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        TitleParser.m2049a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(TitleModel.class, new Serializer());
                    }
                }

                public TitleModel() {
                    super(1);
                }

                @Nullable
                public final String m2028a() {
                    this.f2201d = super.a(this.f2201d, 0);
                    return this.f2201d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m2027a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2026a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m2028a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @Nullable
            public final /* synthetic */ TitleModel m2033b() {
                return m2029j();
            }

            public MessengerContextBannerModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<SubtitlesModel> m2032a() {
                this.f2202d = super.a(this.f2202d, 0, SubtitlesModel.class);
                return (ImmutableList) this.f2202d;
            }

            @Nullable
            private TitleModel m2029j() {
                this.f2203e = (TitleModel) super.a(this.f2203e, 1, TitleModel.class);
                return this.f2203e;
            }

            public final int jK_() {
                return -314091128;
            }

            public final GraphQLVisitableModel m2031a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                TitleModel titleModel;
                h();
                if (m2032a() != null) {
                    Builder a = ModelHelper.a(m2032a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        MessengerContextBannerModel messengerContextBannerModel = (MessengerContextBannerModel) ModelHelper.a(null, this);
                        messengerContextBannerModel.f2202d = a.b();
                        graphQLVisitableModel = messengerContextBannerModel;
                        if (m2029j() != null) {
                            titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m2029j());
                            if (m2029j() != titleModel) {
                                graphQLVisitableModel = (MessengerContextBannerModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f2203e = titleModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m2029j() != null) {
                    titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m2029j());
                    if (m2029j() != titleModel) {
                        graphQLVisitableModel = (MessengerContextBannerModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f2203e = titleModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m2030a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2032a());
                int a2 = ModelHelper.a(flatBufferBuilder, m2029j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: suggested photos should be between 1 and 4. actual is  */
        public class Serializer extends JsonSerializer<PageContextQueryModel> {
            public final void m2034a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageContextQueryModel pageContextQueryModel = (PageContextQueryModel) obj;
                if (pageContextQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageContextQueryModel.m2037a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageContextQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageContextQueryModel.w_();
                int u_ = pageContextQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                boolean a = mutableFlatBuffer.a(u_, 1);
                if (a) {
                    jsonGenerator.a("is_verified");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(u_, 2);
                if (a) {
                    jsonGenerator.a("is_verified_page");
                    jsonGenerator.a(a);
                }
                int g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("messenger_context_banner");
                    MessengerContextBannerParser.m2051a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 4) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 4));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageContextQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ MessengerContextBannerModel m2044c() {
            return m2036k();
        }

        public PageContextQueryModel() {
            super(5);
        }

        public final void m2041a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m2042a(String str, Object obj, boolean z) {
        }

        @Nullable
        private String m2035j() {
            this.f2204d = super.a(this.f2204d, 0);
            return this.f2204d;
        }

        public final boolean m2043b() {
            a(0, 2);
            return this.f2206f;
        }

        @Nullable
        private MessengerContextBannerModel m2036k() {
            this.f2207g = (MessengerContextBannerModel) super.a(this.f2207g, 3, MessengerContextBannerModel.class);
            return this.f2207g;
        }

        @Nullable
        public final String m2045d() {
            this.f2208h = super.a(this.f2208h, 4);
            return this.f2208h;
        }

        @Nullable
        public final String m2039a() {
            return m2035j();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m2038a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2036k() != null) {
                MessengerContextBannerModel messengerContextBannerModel = (MessengerContextBannerModel) graphQLModelMutatingVisitor.b(m2036k());
                if (m2036k() != messengerContextBannerModel) {
                    graphQLVisitableModel = (PageContextQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2207g = messengerContextBannerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2037a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2035j());
            int a = ModelHelper.a(flatBufferBuilder, m2036k());
            int b2 = flatBufferBuilder.b(m2045d());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f2205e);
            flatBufferBuilder.a(2, this.f2206f);
            flatBufferBuilder.b(3, a);
            flatBufferBuilder.b(4, b2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m2040a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f2205e = mutableFlatBuffer.a(i, 1);
            this.f2206f = mutableFlatBuffer.a(i, 2);
        }
    }
}
