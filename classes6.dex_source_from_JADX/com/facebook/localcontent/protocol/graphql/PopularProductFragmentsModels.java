package com.facebook.localcontent.protocol.graphql;

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
import com.facebook.localcontent.protocol.graphql.PopularProductFragmentsParsers.PageProductParser;
import com.facebook.localcontent.protocol.graphql.PopularProductFragmentsParsers.PageProductParser.ViewerDoesNotLikeSentenceParser;
import com.facebook.localcontent.protocol.graphql.PopularProductFragmentsParsers.PageProductParser.ViewerLikesSentenceParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: keywords_pulse_topic(%s) */
public class PopularProductFragmentsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 926902933)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: keywords_pulse_topic(%s) */
    public final class PageProductModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        private boolean f11806d;
        @Nullable
        private String f11807e;
        @Nullable
        private String f11808f;
        @Nullable
        private ViewerDoesNotLikeSentenceModel f11809g;
        @Nullable
        private ViewerLikesSentenceModel f11810h;

        /* compiled from: keywords_pulse_topic(%s) */
        public final class Builder {
            public boolean f11797a;
            @Nullable
            public String f11798b;
            @Nullable
            public String f11799c;
            @Nullable
            public ViewerDoesNotLikeSentenceModel f11800d;
            @Nullable
            public ViewerLikesSentenceModel f11801e;

            public final PageProductModel m18660a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f11798b);
                int b2 = flatBufferBuilder.b(this.f11799c);
                int a = ModelHelper.a(flatBufferBuilder, this.f11800d);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f11801e);
                flatBufferBuilder.c(5);
                flatBufferBuilder.a(0, this.f11797a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, a);
                flatBufferBuilder.b(4, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PageProductModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: keywords_pulse_topic(%s) */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageProductModel.class, new Deserializer());
            }

            public Object m18661a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PageProductParser.m18693a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pageProductModel = new PageProductModel();
                ((BaseModel) pageProductModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pageProductModel instanceof Postprocessable) {
                    return ((Postprocessable) pageProductModel).a();
                }
                return pageProductModel;
            }
        }

        /* compiled from: keywords_pulse_topic(%s) */
        public class Serializer extends JsonSerializer<PageProductModel> {
            public final void m18662a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PageProductModel pageProductModel = (PageProductModel) obj;
                if (pageProductModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageProductModel.m18677a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageProductModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PageProductParser.m18694a(pageProductModel.w_(), pageProductModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PageProductModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: keywords_pulse_topic(%s) */
        public final class ViewerDoesNotLikeSentenceModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f11803d;

            /* compiled from: keywords_pulse_topic(%s) */
            public final class Builder {
                @Nullable
                public String f11802a;
            }

            /* compiled from: keywords_pulse_topic(%s) */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerDoesNotLikeSentenceModel.class, new Deserializer());
                }

                public Object m18663a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewerDoesNotLikeSentenceParser.m18689a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object viewerDoesNotLikeSentenceModel = new ViewerDoesNotLikeSentenceModel();
                    ((BaseModel) viewerDoesNotLikeSentenceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (viewerDoesNotLikeSentenceModel instanceof Postprocessable) {
                        return ((Postprocessable) viewerDoesNotLikeSentenceModel).a();
                    }
                    return viewerDoesNotLikeSentenceModel;
                }
            }

            /* compiled from: keywords_pulse_topic(%s) */
            public class Serializer extends JsonSerializer<ViewerDoesNotLikeSentenceModel> {
                public final void m18664a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerDoesNotLikeSentenceModel viewerDoesNotLikeSentenceModel = (ViewerDoesNotLikeSentenceModel) obj;
                    if (viewerDoesNotLikeSentenceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerDoesNotLikeSentenceModel.m18666a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerDoesNotLikeSentenceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ViewerDoesNotLikeSentenceParser.m18690a(viewerDoesNotLikeSentenceModel.w_(), viewerDoesNotLikeSentenceModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ViewerDoesNotLikeSentenceModel.class, new Serializer());
                }
            }

            public ViewerDoesNotLikeSentenceModel() {
                super(1);
            }

            public ViewerDoesNotLikeSentenceModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m18668a() {
                this.f11803d = super.a(this.f11803d, 0);
                return this.f11803d;
            }

            public static ViewerDoesNotLikeSentenceModel m18665a(ViewerDoesNotLikeSentenceModel viewerDoesNotLikeSentenceModel) {
                if (viewerDoesNotLikeSentenceModel == null) {
                    return null;
                }
                if (viewerDoesNotLikeSentenceModel instanceof ViewerDoesNotLikeSentenceModel) {
                    return viewerDoesNotLikeSentenceModel;
                }
                Builder builder = new Builder();
                builder.f11802a = viewerDoesNotLikeSentenceModel.m18668a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f11802a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ViewerDoesNotLikeSentenceModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m18667a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m18666a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m18668a());
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
        /* compiled from: keywords_pulse_topic(%s) */
        public final class ViewerLikesSentenceModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f11805d;

            /* compiled from: keywords_pulse_topic(%s) */
            public final class Builder {
                @Nullable
                public String f11804a;
            }

            /* compiled from: keywords_pulse_topic(%s) */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerLikesSentenceModel.class, new Deserializer());
                }

                public Object m18669a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewerLikesSentenceParser.m18691a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object viewerLikesSentenceModel = new ViewerLikesSentenceModel();
                    ((BaseModel) viewerLikesSentenceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (viewerLikesSentenceModel instanceof Postprocessable) {
                        return ((Postprocessable) viewerLikesSentenceModel).a();
                    }
                    return viewerLikesSentenceModel;
                }
            }

            /* compiled from: keywords_pulse_topic(%s) */
            public class Serializer extends JsonSerializer<ViewerLikesSentenceModel> {
                public final void m18670a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerLikesSentenceModel viewerLikesSentenceModel = (ViewerLikesSentenceModel) obj;
                    if (viewerLikesSentenceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerLikesSentenceModel.m18672a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerLikesSentenceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ViewerLikesSentenceParser.m18692a(viewerLikesSentenceModel.w_(), viewerLikesSentenceModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ViewerLikesSentenceModel.class, new Serializer());
                }
            }

            public ViewerLikesSentenceModel() {
                super(1);
            }

            public ViewerLikesSentenceModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m18674a() {
                this.f11805d = super.a(this.f11805d, 0);
                return this.f11805d;
            }

            public static ViewerLikesSentenceModel m18671a(ViewerLikesSentenceModel viewerLikesSentenceModel) {
                if (viewerLikesSentenceModel == null) {
                    return null;
                }
                if (viewerLikesSentenceModel instanceof ViewerLikesSentenceModel) {
                    return viewerLikesSentenceModel;
                }
                Builder builder = new Builder();
                builder.f11804a = viewerLikesSentenceModel.m18674a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f11804a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ViewerLikesSentenceModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m18673a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m18672a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m18674a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ ViewerDoesNotLikeSentenceModel cR_() {
            return m18687j();
        }

        @Nullable
        public final /* synthetic */ ViewerLikesSentenceModel m18686g() {
            return m18688k();
        }

        public PageProductModel() {
            super(5);
        }

        public PageProductModel(MutableFlatBuffer mutableFlatBuffer) {
            super(5);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m18681a(String str, ConsistencyTuple consistencyTuple) {
            if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m18683b());
                consistencyTuple.b = u_();
                consistencyTuple.c = 0;
                return;
            }
            consistencyTuple.a();
        }

        public final void m18682a(String str, Object obj, boolean z) {
            if ("does_viewer_like".equals(str)) {
                m18676a(((Boolean) obj).booleanValue());
            }
        }

        public final boolean m18683b() {
            a(0, 0);
            return this.f11806d;
        }

        private void m18676a(boolean z) {
            this.f11806d = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 0, z);
            }
        }

        @Nullable
        public final String m18684c() {
            this.f11807e = super.a(this.f11807e, 1);
            return this.f11807e;
        }

        @Nullable
        public final String m18685d() {
            this.f11808f = super.a(this.f11808f, 2);
            return this.f11808f;
        }

        @Nullable
        public final ViewerDoesNotLikeSentenceModel m18687j() {
            this.f11809g = (ViewerDoesNotLikeSentenceModel) super.a(this.f11809g, 3, ViewerDoesNotLikeSentenceModel.class);
            return this.f11809g;
        }

        @Nullable
        public final ViewerLikesSentenceModel m18688k() {
            this.f11810h = (ViewerLikesSentenceModel) super.a(this.f11810h, 4, ViewerLikesSentenceModel.class);
            return this.f11810h;
        }

        public static PageProductModel m18675a(PageProductModel pageProductModel) {
            if (pageProductModel == null) {
                return null;
            }
            if (pageProductModel instanceof PageProductModel) {
                return pageProductModel;
            }
            Builder builder = new Builder();
            builder.f11797a = pageProductModel.m18683b();
            builder.f11798b = pageProductModel.m18684c();
            builder.f11799c = pageProductModel.m18685d();
            builder.f11800d = ViewerDoesNotLikeSentenceModel.m18665a(pageProductModel.cR_());
            builder.f11801e = ViewerLikesSentenceModel.m18671a(pageProductModel.m18686g());
            return builder.m18660a();
        }

        @Nullable
        public final String m18679a() {
            return m18684c();
        }

        public final int jK_() {
            return 191986496;
        }

        public final GraphQLVisitableModel m18678a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18687j() != null) {
                ViewerDoesNotLikeSentenceModel viewerDoesNotLikeSentenceModel = (ViewerDoesNotLikeSentenceModel) graphQLModelMutatingVisitor.b(m18687j());
                if (m18687j() != viewerDoesNotLikeSentenceModel) {
                    graphQLVisitableModel = (PageProductModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11809g = viewerDoesNotLikeSentenceModel;
                }
            }
            if (m18688k() != null) {
                ViewerLikesSentenceModel viewerLikesSentenceModel = (ViewerLikesSentenceModel) graphQLModelMutatingVisitor.b(m18688k());
                if (m18688k() != viewerLikesSentenceModel) {
                    graphQLVisitableModel = (PageProductModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11810h = viewerLikesSentenceModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18677a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m18684c());
            int b2 = flatBufferBuilder.b(m18685d());
            int a = ModelHelper.a(flatBufferBuilder, m18687j());
            int a2 = ModelHelper.a(flatBufferBuilder, m18688k());
            flatBufferBuilder.c(5);
            flatBufferBuilder.a(0, this.f11806d);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a);
            flatBufferBuilder.b(4, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m18680a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f11806d = mutableFlatBuffer.a(i, 0);
        }
    }
}
