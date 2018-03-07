package com.facebook.topics.protocol;

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
import com.facebook.topics.protocol.TopicFavoritesQueryInterfaces.VideoTopicFragment;
import com.facebook.topics.protocol.TopicFavoritesQueryParsers.TopicFeedFragmentParser;
import com.facebook.topics.protocol.TopicFavoritesQueryParsers.TopicFeedFragmentParser.DisabledFavoriteIconParser;
import com.facebook.topics.protocol.TopicFavoritesQueryParsers.TopicFeedFragmentParser.EnabledFavoriteIconParser;
import com.facebook.topics.protocol.TopicFavoritesQueryParsers.TopicFeedFragmentParser.HeaderImageParser;
import com.facebook.topics.protocol.TopicFavoritesQueryParsers.TopicFeedListParser;
import com.facebook.topics.protocol.TopicFavoritesQueryParsers.VideoTopicFragmentParser;
import com.facebook.topics.protocol.TopicFavoritesQueryParsers.VideoTopicFragmentParser.SquareHeaderImageParser;
import com.facebook.topics.protocol.TopicFavoritesQueryParsers.VideoTopicFragmentParser.VideoChannelSubtitleParser;
import com.facebook.topics.protocol.TopicFavoritesQueryParsers.VideoTopicFragmentParser.VideoChannelTitleParser;
import com.facebook.topics.protocol.TopicFavoritesQueryParsers.VideoTopicListParser;
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

/* compiled from: extra_place_name */
public class TopicFavoritesQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -695830821)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_place_name */
    public final class TopicFeedFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f15013d;
        private boolean f15014e;
        @Nullable
        private DisabledFavoriteIconModel f15015f;
        @Nullable
        private EnabledFavoriteIconModel f15016g;
        @Nullable
        private HeaderImageModel f15017h;
        @Nullable
        private String f15018i;
        private boolean f15019j;
        private int f15020k;
        @Nullable
        private String f15021l;
        private boolean f15022m;

        /* compiled from: extra_place_name */
        public final class Builder {
            @Nullable
            public String f15000a;
            public boolean f15001b;
            @Nullable
            public DisabledFavoriteIconModel f15002c;
            @Nullable
            public EnabledFavoriteIconModel f15003d;
            @Nullable
            public HeaderImageModel f15004e;
            @Nullable
            public String f15005f;
            public boolean f15006g;
            public int f15007h;
            @Nullable
            public String f15008i;
            public boolean f15009j;

            public final TopicFeedFragmentModel m18920a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f15000a);
                int a = ModelHelper.a(flatBufferBuilder, this.f15002c);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f15003d);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f15004e);
                int b2 = flatBufferBuilder.b(this.f15005f);
                int b3 = flatBufferBuilder.b(this.f15008i);
                flatBufferBuilder.c(10);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f15001b);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.b(5, b2);
                flatBufferBuilder.a(6, this.f15006g);
                flatBufferBuilder.a(7, this.f15007h, 0);
                flatBufferBuilder.b(8, b3);
                flatBufferBuilder.a(9, this.f15009j);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new TopicFeedFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: extra_place_name */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TopicFeedFragmentModel.class, new Deserializer());
            }

            public Object m18921a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TopicFeedFragmentParser.m19012b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object topicFeedFragmentModel = new TopicFeedFragmentModel();
                ((BaseModel) topicFeedFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (topicFeedFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) topicFeedFragmentModel).a();
                }
                return topicFeedFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: extra_place_name */
        public final class DisabledFavoriteIconModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f15010d;

            /* compiled from: extra_place_name */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(DisabledFavoriteIconModel.class, new Deserializer());
                }

                public Object m18922a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(DisabledFavoriteIconParser.m19006a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object disabledFavoriteIconModel = new DisabledFavoriteIconModel();
                    ((BaseModel) disabledFavoriteIconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (disabledFavoriteIconModel instanceof Postprocessable) {
                        return ((Postprocessable) disabledFavoriteIconModel).a();
                    }
                    return disabledFavoriteIconModel;
                }
            }

            /* compiled from: extra_place_name */
            public class Serializer extends JsonSerializer<DisabledFavoriteIconModel> {
                public final void m18923a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    DisabledFavoriteIconModel disabledFavoriteIconModel = (DisabledFavoriteIconModel) obj;
                    if (disabledFavoriteIconModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(disabledFavoriteIconModel.m18924a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        disabledFavoriteIconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    DisabledFavoriteIconParser.m19007a(disabledFavoriteIconModel.w_(), disabledFavoriteIconModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(DisabledFavoriteIconModel.class, new Serializer());
                }
            }

            public DisabledFavoriteIconModel() {
                super(1);
            }

            @Nullable
            public final String m18926a() {
                this.f15010d = super.a(this.f15010d, 0);
                return this.f15010d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m18925a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m18924a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m18926a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: extra_place_name */
        public final class EnabledFavoriteIconModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f15011d;

            /* compiled from: extra_place_name */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EnabledFavoriteIconModel.class, new Deserializer());
                }

                public Object m18927a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EnabledFavoriteIconParser.m19008a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object enabledFavoriteIconModel = new EnabledFavoriteIconModel();
                    ((BaseModel) enabledFavoriteIconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (enabledFavoriteIconModel instanceof Postprocessable) {
                        return ((Postprocessable) enabledFavoriteIconModel).a();
                    }
                    return enabledFavoriteIconModel;
                }
            }

            /* compiled from: extra_place_name */
            public class Serializer extends JsonSerializer<EnabledFavoriteIconModel> {
                public final void m18928a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EnabledFavoriteIconModel enabledFavoriteIconModel = (EnabledFavoriteIconModel) obj;
                    if (enabledFavoriteIconModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(enabledFavoriteIconModel.m18929a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        enabledFavoriteIconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EnabledFavoriteIconParser.m19009a(enabledFavoriteIconModel.w_(), enabledFavoriteIconModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(EnabledFavoriteIconModel.class, new Serializer());
                }
            }

            public EnabledFavoriteIconModel() {
                super(1);
            }

            @Nullable
            public final String m18931a() {
                this.f15011d = super.a(this.f15011d, 0);
                return this.f15011d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m18930a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m18929a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m18931a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: extra_place_name */
        public final class HeaderImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f15012d;

            /* compiled from: extra_place_name */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(HeaderImageModel.class, new Deserializer());
                }

                public Object m18932a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(HeaderImageParser.m19010a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object headerImageModel = new HeaderImageModel();
                    ((BaseModel) headerImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (headerImageModel instanceof Postprocessable) {
                        return ((Postprocessable) headerImageModel).a();
                    }
                    return headerImageModel;
                }
            }

            /* compiled from: extra_place_name */
            public class Serializer extends JsonSerializer<HeaderImageModel> {
                public final void m18933a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    HeaderImageModel headerImageModel = (HeaderImageModel) obj;
                    if (headerImageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(headerImageModel.m18934a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        headerImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    HeaderImageParser.m19011a(headerImageModel.w_(), headerImageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(HeaderImageModel.class, new Serializer());
                }
            }

            public HeaderImageModel() {
                super(1);
            }

            @Nullable
            public final String m18936a() {
                this.f15012d = super.a(this.f15012d, 0);
                return this.f15012d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m18935a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m18934a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m18936a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: extra_place_name */
        public class Serializer extends JsonSerializer<TopicFeedFragmentModel> {
            public final void m18937a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TopicFeedFragmentModel topicFeedFragmentModel = (TopicFeedFragmentModel) obj;
                if (topicFeedFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(topicFeedFragmentModel.m18939a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    topicFeedFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TopicFeedFragmentParser.m19013b(topicFeedFragmentModel.w_(), topicFeedFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TopicFeedFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DisabledFavoriteIconModel m18947d() {
            return m18952m();
        }

        @Nullable
        public final /* synthetic */ EnabledFavoriteIconModel fd_() {
            return m18953n();
        }

        @Nullable
        public final /* synthetic */ HeaderImageModel m18948g() {
            return m18954o();
        }

        public TopicFeedFragmentModel() {
            super(10);
        }

        public TopicFeedFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(10);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m18943a(String str, ConsistencyTuple consistencyTuple) {
            if ("is_favorited".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(fc_());
                consistencyTuple.b = u_();
                consistencyTuple.c = 6;
                return;
            }
            consistencyTuple.a();
        }

        public final void m18944a(String str, Object obj, boolean z) {
            if ("is_favorited".equals(str)) {
                m18938a(((Boolean) obj).booleanValue());
            }
        }

        @Nullable
        public final String m18945b() {
            this.f15013d = super.a(this.f15013d, 0);
            return this.f15013d;
        }

        public final boolean m18946c() {
            a(0, 1);
            return this.f15014e;
        }

        @Nullable
        public final DisabledFavoriteIconModel m18952m() {
            this.f15015f = (DisabledFavoriteIconModel) super.a(this.f15015f, 2, DisabledFavoriteIconModel.class);
            return this.f15015f;
        }

        @Nullable
        public final EnabledFavoriteIconModel m18953n() {
            this.f15016g = (EnabledFavoriteIconModel) super.a(this.f15016g, 3, EnabledFavoriteIconModel.class);
            return this.f15016g;
        }

        @Nullable
        public final HeaderImageModel m18954o() {
            this.f15017h = (HeaderImageModel) super.a(this.f15017h, 4, HeaderImageModel.class);
            return this.f15017h;
        }

        @Nullable
        public final String fb_() {
            this.f15018i = super.a(this.f15018i, 5);
            return this.f15018i;
        }

        public final boolean fc_() {
            a(0, 6);
            return this.f15019j;
        }

        private void m18938a(boolean z) {
            this.f15019j = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 6, z);
            }
        }

        public final int m18949j() {
            a(0, 7);
            return this.f15020k;
        }

        @Nullable
        public final String m18950k() {
            this.f15021l = super.a(this.f15021l, 8);
            return this.f15021l;
        }

        public final boolean m18951l() {
            a(1, 1);
            return this.f15022m;
        }

        @Nullable
        public final String m18941a() {
            return fb_();
        }

        public final int jK_() {
            return 218987185;
        }

        public final GraphQLVisitableModel m18940a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18952m() != null) {
                DisabledFavoriteIconModel disabledFavoriteIconModel = (DisabledFavoriteIconModel) graphQLModelMutatingVisitor.b(m18952m());
                if (m18952m() != disabledFavoriteIconModel) {
                    graphQLVisitableModel = (TopicFeedFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15015f = disabledFavoriteIconModel;
                }
            }
            if (m18953n() != null) {
                EnabledFavoriteIconModel enabledFavoriteIconModel = (EnabledFavoriteIconModel) graphQLModelMutatingVisitor.b(m18953n());
                if (m18953n() != enabledFavoriteIconModel) {
                    graphQLVisitableModel = (TopicFeedFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15016g = enabledFavoriteIconModel;
                }
            }
            if (m18954o() != null) {
                HeaderImageModel headerImageModel = (HeaderImageModel) graphQLModelMutatingVisitor.b(m18954o());
                if (m18954o() != headerImageModel) {
                    graphQLVisitableModel = (TopicFeedFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15017h = headerImageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18939a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m18945b());
            int a = ModelHelper.a(flatBufferBuilder, m18952m());
            int a2 = ModelHelper.a(flatBufferBuilder, m18953n());
            int a3 = ModelHelper.a(flatBufferBuilder, m18954o());
            int b2 = flatBufferBuilder.b(fb_());
            int b3 = flatBufferBuilder.b(m18950k());
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f15014e);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, b2);
            flatBufferBuilder.a(6, this.f15019j);
            flatBufferBuilder.a(7, this.f15020k, 0);
            flatBufferBuilder.b(8, b3);
            flatBufferBuilder.a(9, this.f15022m);
            i();
            return flatBufferBuilder.d();
        }

        public final void m18942a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f15014e = mutableFlatBuffer.a(i, 1);
            this.f15019j = mutableFlatBuffer.a(i, 6);
            this.f15020k = mutableFlatBuffer.a(i, 7, 0);
            this.f15022m = mutableFlatBuffer.a(i, 9);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 148254054)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_place_name */
    public final class TopicFeedListModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<TopicFeedFragmentModel> f15024d;

        /* compiled from: extra_place_name */
        public final class Builder {
            @Nullable
            public ImmutableList<TopicFeedFragmentModel> f15023a;

            public final TopicFeedListModel m18955a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f15023a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new TopicFeedListModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: extra_place_name */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TopicFeedListModel.class, new Deserializer());
            }

            public Object m18956a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TopicFeedListParser.m19014a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object topicFeedListModel = new TopicFeedListModel();
                ((BaseModel) topicFeedListModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (topicFeedListModel instanceof Postprocessable) {
                    return ((Postprocessable) topicFeedListModel).a();
                }
                return topicFeedListModel;
            }
        }

        /* compiled from: extra_place_name */
        public class Serializer extends JsonSerializer<TopicFeedListModel> {
            public final void m18957a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TopicFeedListModel topicFeedListModel = (TopicFeedListModel) obj;
                if (topicFeedListModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(topicFeedListModel.m18958a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    topicFeedListModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = topicFeedListModel.w_();
                int u_ = topicFeedListModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("topics_list");
                    jsonGenerator.d();
                    for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                        TopicFeedFragmentParser.m19013b(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TopicFeedListModel.class, new Serializer());
            }
        }

        public TopicFeedListModel() {
            super(1);
        }

        public TopicFeedListModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nonnull
        public final ImmutableList<TopicFeedFragmentModel> m18960a() {
            this.f15024d = super.a(this.f15024d, 0, TopicFeedFragmentModel.class);
            return (ImmutableList) this.f15024d;
        }

        public final int jK_() {
            return -93741489;
        }

        public final GraphQLVisitableModel m18959a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18960a() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m18960a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (TopicFeedListModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15024d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18958a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18960a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 105662137)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_place_name */
    public final class VideoTopicFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, VideoTopicFragment {
        @Nullable
        private String f15039d;
        private int f15040e;
        @Nullable
        private SquareHeaderImageModel f15041f;
        private boolean f15042g;
        private boolean f15043h;
        private int f15044i;
        @Nullable
        private VideoChannelSubtitleModel f15045j;
        @Nullable
        private VideoChannelTitleModel f15046k;

        /* compiled from: extra_place_name */
        public final class Builder {
            @Nullable
            public String f15025a;
            public int f15026b;
            @Nullable
            public SquareHeaderImageModel f15027c;
            public boolean f15028d;
            public boolean f15029e;
            public int f15030f;
            @Nullable
            public VideoChannelSubtitleModel f15031g;
            @Nullable
            public VideoChannelTitleModel f15032h;

            public final VideoTopicFragmentModel m18961a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f15025a);
                int a = ModelHelper.a(flatBufferBuilder, this.f15027c);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f15031g);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f15032h);
                flatBufferBuilder.c(8);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f15026b, 0);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.a(3, this.f15028d);
                flatBufferBuilder.a(4, this.f15029e);
                flatBufferBuilder.a(5, this.f15030f, 0);
                flatBufferBuilder.b(6, a2);
                flatBufferBuilder.b(7, a3);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new VideoTopicFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: extra_place_name */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(VideoTopicFragmentModel.class, new Deserializer());
            }

            public Object m18962a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(VideoTopicFragmentParser.m19021a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object videoTopicFragmentModel = new VideoTopicFragmentModel();
                ((BaseModel) videoTopicFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (videoTopicFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) videoTopicFragmentModel).a();
                }
                return videoTopicFragmentModel;
            }
        }

        /* compiled from: extra_place_name */
        public class Serializer extends JsonSerializer<VideoTopicFragmentModel> {
            public final void m18963a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                VideoTopicFragmentModel videoTopicFragmentModel = (VideoTopicFragmentModel) obj;
                if (videoTopicFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(videoTopicFragmentModel.m18987a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    videoTopicFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                VideoTopicFragmentParser.m19022b(videoTopicFragmentModel.w_(), videoTopicFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(VideoTopicFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: extra_place_name */
        public final class SquareHeaderImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f15034d;

            /* compiled from: extra_place_name */
            public final class Builder {
                @Nullable
                public String f15033a;

                public final SquareHeaderImageModel m18964a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(this.f15033a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new SquareHeaderImageModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: extra_place_name */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SquareHeaderImageModel.class, new Deserializer());
                }

                public Object m18965a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SquareHeaderImageParser.m19015a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object squareHeaderImageModel = new SquareHeaderImageModel();
                    ((BaseModel) squareHeaderImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (squareHeaderImageModel instanceof Postprocessable) {
                        return ((Postprocessable) squareHeaderImageModel).a();
                    }
                    return squareHeaderImageModel;
                }
            }

            /* compiled from: extra_place_name */
            public class Serializer extends JsonSerializer<SquareHeaderImageModel> {
                public final void m18966a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SquareHeaderImageModel squareHeaderImageModel = (SquareHeaderImageModel) obj;
                    if (squareHeaderImageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(squareHeaderImageModel.m18968a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        squareHeaderImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SquareHeaderImageParser.m19016a(squareHeaderImageModel.w_(), squareHeaderImageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SquareHeaderImageModel.class, new Serializer());
                }
            }

            public SquareHeaderImageModel() {
                super(1);
            }

            public SquareHeaderImageModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m18970a() {
                this.f15034d = super.a(this.f15034d, 0);
                return this.f15034d;
            }

            public static SquareHeaderImageModel m18967a(SquareHeaderImageModel squareHeaderImageModel) {
                if (squareHeaderImageModel == null) {
                    return null;
                }
                if (squareHeaderImageModel instanceof SquareHeaderImageModel) {
                    return squareHeaderImageModel;
                }
                Builder builder = new Builder();
                builder.f15033a = squareHeaderImageModel.m18970a();
                return builder.m18964a();
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m18969a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m18968a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m18970a());
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
        /* compiled from: extra_place_name */
        public final class VideoChannelSubtitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f15036d;

            /* compiled from: extra_place_name */
            public final class Builder {
                @Nullable
                public String f15035a;

                public final VideoChannelSubtitleModel m18971a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(this.f15035a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new VideoChannelSubtitleModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: extra_place_name */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VideoChannelSubtitleModel.class, new Deserializer());
                }

                public Object m18972a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VideoChannelSubtitleParser.m19017a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object videoChannelSubtitleModel = new VideoChannelSubtitleModel();
                    ((BaseModel) videoChannelSubtitleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (videoChannelSubtitleModel instanceof Postprocessable) {
                        return ((Postprocessable) videoChannelSubtitleModel).a();
                    }
                    return videoChannelSubtitleModel;
                }
            }

            /* compiled from: extra_place_name */
            public class Serializer extends JsonSerializer<VideoChannelSubtitleModel> {
                public final void m18973a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VideoChannelSubtitleModel videoChannelSubtitleModel = (VideoChannelSubtitleModel) obj;
                    if (videoChannelSubtitleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(videoChannelSubtitleModel.m18975a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        videoChannelSubtitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VideoChannelSubtitleParser.m19018a(videoChannelSubtitleModel.w_(), videoChannelSubtitleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(VideoChannelSubtitleModel.class, new Serializer());
                }
            }

            public VideoChannelSubtitleModel() {
                super(1);
            }

            public VideoChannelSubtitleModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m18977a() {
                this.f15036d = super.a(this.f15036d, 0);
                return this.f15036d;
            }

            public static VideoChannelSubtitleModel m18974a(VideoChannelSubtitleModel videoChannelSubtitleModel) {
                if (videoChannelSubtitleModel == null) {
                    return null;
                }
                if (videoChannelSubtitleModel instanceof VideoChannelSubtitleModel) {
                    return videoChannelSubtitleModel;
                }
                Builder builder = new Builder();
                builder.f15035a = videoChannelSubtitleModel.m18977a();
                return builder.m18971a();
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m18976a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m18975a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m18977a());
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
        /* compiled from: extra_place_name */
        public final class VideoChannelTitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f15038d;

            /* compiled from: extra_place_name */
            public final class Builder {
                @Nullable
                public String f15037a;

                public final VideoChannelTitleModel m18978a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(this.f15037a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new VideoChannelTitleModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: extra_place_name */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VideoChannelTitleModel.class, new Deserializer());
                }

                public Object m18979a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VideoChannelTitleParser.m19019a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object videoChannelTitleModel = new VideoChannelTitleModel();
                    ((BaseModel) videoChannelTitleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (videoChannelTitleModel instanceof Postprocessable) {
                        return ((Postprocessable) videoChannelTitleModel).a();
                    }
                    return videoChannelTitleModel;
                }
            }

            /* compiled from: extra_place_name */
            public class Serializer extends JsonSerializer<VideoChannelTitleModel> {
                public final void m18980a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VideoChannelTitleModel videoChannelTitleModel = (VideoChannelTitleModel) obj;
                    if (videoChannelTitleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(videoChannelTitleModel.m18982a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        videoChannelTitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VideoChannelTitleParser.m19020a(videoChannelTitleModel.w_(), videoChannelTitleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(VideoChannelTitleModel.class, new Serializer());
                }
            }

            public VideoChannelTitleModel() {
                super(1);
            }

            public VideoChannelTitleModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m18984a() {
                this.f15038d = super.a(this.f15038d, 0);
                return this.f15038d;
            }

            public static VideoChannelTitleModel m18981a(VideoChannelTitleModel videoChannelTitleModel) {
                if (videoChannelTitleModel == null) {
                    return null;
                }
                if (videoChannelTitleModel instanceof VideoChannelTitleModel) {
                    return videoChannelTitleModel;
                }
                Builder builder = new Builder();
                builder.f15037a = videoChannelTitleModel.m18984a();
                return builder.m18978a();
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m18983a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m18982a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m18984a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ SquareHeaderImageModel mo842d() {
            return m18998k();
        }

        @Nullable
        public final /* synthetic */ VideoChannelSubtitleModel fg_() {
            return m18999l();
        }

        @Nullable
        public final /* synthetic */ VideoChannelTitleModel mo847j() {
            return m19000m();
        }

        public VideoTopicFragmentModel() {
            super(8);
        }

        public VideoTopicFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(8);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m18991a(String str, ConsistencyTuple consistencyTuple) {
            if ("video_channel_is_viewer_pinned".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(mo846g());
                consistencyTuple.b = u_();
                consistencyTuple.c = 4;
                return;
            }
            consistencyTuple.a();
        }

        public final void m18992a(String str, Object obj, boolean z) {
            if ("video_channel_is_viewer_pinned".equals(str)) {
                m18986a(((Boolean) obj).booleanValue());
            }
        }

        @Nullable
        public final String mo840b() {
            this.f15039d = super.a(this.f15039d, 0);
            return this.f15039d;
        }

        public final int mo841c() {
            a(0, 1);
            return this.f15040e;
        }

        @Nullable
        public final SquareHeaderImageModel m18998k() {
            this.f15041f = (SquareHeaderImageModel) super.a(this.f15041f, 2, SquareHeaderImageModel.class);
            return this.f15041f;
        }

        public final boolean fe_() {
            a(0, 3);
            return this.f15042g;
        }

        public final boolean mo846g() {
            a(0, 4);
            return this.f15043h;
        }

        private void m18986a(boolean z) {
            this.f15043h = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 4, z);
            }
        }

        public final int ff_() {
            a(0, 5);
            return this.f15044i;
        }

        @Nullable
        public final VideoChannelSubtitleModel m18999l() {
            this.f15045j = (VideoChannelSubtitleModel) super.a(this.f15045j, 6, VideoChannelSubtitleModel.class);
            return this.f15045j;
        }

        @Nullable
        public final VideoChannelTitleModel m19000m() {
            this.f15046k = (VideoChannelTitleModel) super.a(this.f15046k, 7, VideoChannelTitleModel.class);
            return this.f15046k;
        }

        public static VideoTopicFragmentModel m18985a(VideoTopicFragment videoTopicFragment) {
            if (videoTopicFragment == null) {
                return null;
            }
            if (videoTopicFragment instanceof VideoTopicFragmentModel) {
                return (VideoTopicFragmentModel) videoTopicFragment;
            }
            Builder builder = new Builder();
            builder.f15025a = videoTopicFragment.mo840b();
            builder.f15026b = videoTopicFragment.mo841c();
            builder.f15027c = SquareHeaderImageModel.m18967a(videoTopicFragment.mo842d());
            builder.f15028d = videoTopicFragment.fe_();
            builder.f15029e = videoTopicFragment.mo846g();
            builder.f15030f = videoTopicFragment.ff_();
            builder.f15031g = VideoChannelSubtitleModel.m18974a(videoTopicFragment.fg_());
            builder.f15032h = VideoChannelTitleModel.m18981a(videoTopicFragment.mo847j());
            return builder.m18961a();
        }

        @Nullable
        public final String m18989a() {
            return mo840b();
        }

        public final int jK_() {
            return 218987185;
        }

        public final GraphQLVisitableModel m18988a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18998k() != null) {
                SquareHeaderImageModel squareHeaderImageModel = (SquareHeaderImageModel) graphQLModelMutatingVisitor.b(m18998k());
                if (m18998k() != squareHeaderImageModel) {
                    graphQLVisitableModel = (VideoTopicFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15041f = squareHeaderImageModel;
                }
            }
            if (m18999l() != null) {
                VideoChannelSubtitleModel videoChannelSubtitleModel = (VideoChannelSubtitleModel) graphQLModelMutatingVisitor.b(m18999l());
                if (m18999l() != videoChannelSubtitleModel) {
                    graphQLVisitableModel = (VideoTopicFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15045j = videoChannelSubtitleModel;
                }
            }
            if (m19000m() != null) {
                VideoChannelTitleModel videoChannelTitleModel = (VideoChannelTitleModel) graphQLModelMutatingVisitor.b(m19000m());
                if (m19000m() != videoChannelTitleModel) {
                    graphQLVisitableModel = (VideoTopicFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15046k = videoChannelTitleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18987a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(mo840b());
            int a = ModelHelper.a(flatBufferBuilder, m18998k());
            int a2 = ModelHelper.a(flatBufferBuilder, m18999l());
            int a3 = ModelHelper.a(flatBufferBuilder, m19000m());
            flatBufferBuilder.c(8);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f15040e, 0);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.a(3, this.f15042g);
            flatBufferBuilder.a(4, this.f15043h);
            flatBufferBuilder.a(5, this.f15044i, 0);
            flatBufferBuilder.b(6, a2);
            flatBufferBuilder.b(7, a3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m18990a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f15040e = mutableFlatBuffer.a(i, 1, 0);
            this.f15042g = mutableFlatBuffer.a(i, 3);
            this.f15043h = mutableFlatBuffer.a(i, 4);
            this.f15044i = mutableFlatBuffer.a(i, 5, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -358689081)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_place_name */
    public final class VideoTopicListModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<VideoTopicFragmentModel> f15047d;

        /* compiled from: extra_place_name */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(VideoTopicListModel.class, new Deserializer());
            }

            public Object m19001a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(VideoTopicListParser.m19023a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object videoTopicListModel = new VideoTopicListModel();
                ((BaseModel) videoTopicListModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (videoTopicListModel instanceof Postprocessable) {
                    return ((Postprocessable) videoTopicListModel).a();
                }
                return videoTopicListModel;
            }
        }

        /* compiled from: extra_place_name */
        public class Serializer extends JsonSerializer<VideoTopicListModel> {
            public final void m19002a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                VideoTopicListModel videoTopicListModel = (VideoTopicListModel) obj;
                if (videoTopicListModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(videoTopicListModel.m19003a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    videoTopicListModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = videoTopicListModel.w_();
                int u_ = videoTopicListModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("all_topics");
                    jsonGenerator.d();
                    for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                        VideoTopicFragmentParser.m19022b(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(VideoTopicListModel.class, new Serializer());
            }
        }

        public VideoTopicListModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<VideoTopicFragmentModel> m19005a() {
            this.f15047d = super.a(this.f15047d, 0, VideoTopicFragmentModel.class);
            return (ImmutableList) this.f15047d;
        }

        public final int jK_() {
            return -93741489;
        }

        public final GraphQLVisitableModel m19004a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19005a() != null) {
                Builder a = ModelHelper.a(m19005a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (VideoTopicListModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15047d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19003a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19005a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
