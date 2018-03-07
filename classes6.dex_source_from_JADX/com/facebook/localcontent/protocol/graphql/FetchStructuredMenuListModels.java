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
import com.facebook.localcontent.protocol.graphql.FetchStructuredMenuListParsers.MenuItemParser;
import com.facebook.localcontent.protocol.graphql.FetchStructuredMenuListParsers.MenuItemParser.ViewerDoesNotLikeSentenceParser;
import com.facebook.localcontent.protocol.graphql.FetchStructuredMenuListParsers.MenuItemParser.ViewerLikesSentenceParser;
import com.facebook.localcontent.protocol.graphql.FetchStructuredMenuListParsers.StructuredMenuListDataParser;
import com.facebook.localcontent.protocol.graphql.FetchStructuredMenuListParsers.StructuredMenuListDataParser.MenuSubListParser;
import com.facebook.localcontent.protocol.graphql.FetchStructuredMenuListParsers.StructuredMenuListDataParser.MenuSubListParser.NodesParser;
import com.facebook.localcontent.protocol.graphql.FetchStructuredMenuListParsers.StructuredMenuListDataParser.MenuSubListParser.NodesParser.MenuItemsParser;
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

/* compiled from: lastAppearanceTime */
public class FetchStructuredMenuListModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1243818970)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: lastAppearanceTime */
    public final class MenuItemModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f11769d;
        private boolean f11770e;
        @Nullable
        private String f11771f;
        @Nullable
        private String f11772g;
        @Nullable
        private ViewerDoesNotLikeSentenceModel f11773h;
        @Nullable
        private ViewerLikesSentenceModel f11774i;

        /* compiled from: lastAppearanceTime */
        public final class Builder {
            @Nullable
            public String f11759a;
            public boolean f11760b;
            @Nullable
            public String f11761c;
            @Nullable
            public String f11762d;
            @Nullable
            public ViewerDoesNotLikeSentenceModel f11763e;
            @Nullable
            public ViewerLikesSentenceModel f11764f;

            public final MenuItemModel m18510a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f11759a);
                int b2 = flatBufferBuilder.b(this.f11761c);
                int b3 = flatBufferBuilder.b(this.f11762d);
                int a = ModelHelper.a(flatBufferBuilder, this.f11763e);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f11764f);
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f11760b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, b3);
                flatBufferBuilder.b(4, a);
                flatBufferBuilder.b(5, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new MenuItemModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: lastAppearanceTime */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MenuItemModel.class, new Deserializer());
            }

            public Object m18511a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MenuItemParser.m18564b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object menuItemModel = new MenuItemModel();
                ((BaseModel) menuItemModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (menuItemModel instanceof Postprocessable) {
                    return ((Postprocessable) menuItemModel).a();
                }
                return menuItemModel;
            }
        }

        /* compiled from: lastAppearanceTime */
        public class Serializer extends JsonSerializer<MenuItemModel> {
            public final void m18512a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MenuItemModel menuItemModel = (MenuItemModel) obj;
                if (menuItemModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(menuItemModel.m18527a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    menuItemModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MenuItemParser.m18565b(menuItemModel.w_(), menuItemModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MenuItemModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: lastAppearanceTime */
        public final class ViewerDoesNotLikeSentenceModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f11766d;

            /* compiled from: lastAppearanceTime */
            public final class Builder {
                @Nullable
                public String f11765a;
            }

            /* compiled from: lastAppearanceTime */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerDoesNotLikeSentenceModel.class, new Deserializer());
                }

                public Object m18513a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewerDoesNotLikeSentenceParser.m18560a(jsonParser, flatBufferBuilder));
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

            /* compiled from: lastAppearanceTime */
            public class Serializer extends JsonSerializer<ViewerDoesNotLikeSentenceModel> {
                public final void m18514a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerDoesNotLikeSentenceModel viewerDoesNotLikeSentenceModel = (ViewerDoesNotLikeSentenceModel) obj;
                    if (viewerDoesNotLikeSentenceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerDoesNotLikeSentenceModel.m18516a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerDoesNotLikeSentenceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ViewerDoesNotLikeSentenceParser.m18561a(viewerDoesNotLikeSentenceModel.w_(), viewerDoesNotLikeSentenceModel.u_(), jsonGenerator);
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
            public final String m18518a() {
                this.f11766d = super.a(this.f11766d, 0);
                return this.f11766d;
            }

            public static ViewerDoesNotLikeSentenceModel m18515a(ViewerDoesNotLikeSentenceModel viewerDoesNotLikeSentenceModel) {
                if (viewerDoesNotLikeSentenceModel == null) {
                    return null;
                }
                if (viewerDoesNotLikeSentenceModel instanceof ViewerDoesNotLikeSentenceModel) {
                    return viewerDoesNotLikeSentenceModel;
                }
                Builder builder = new Builder();
                builder.f11765a = viewerDoesNotLikeSentenceModel.m18518a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f11765a);
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

            public final GraphQLVisitableModel m18517a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m18516a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m18518a());
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
        /* compiled from: lastAppearanceTime */
        public final class ViewerLikesSentenceModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f11768d;

            /* compiled from: lastAppearanceTime */
            public final class Builder {
                @Nullable
                public String f11767a;
            }

            /* compiled from: lastAppearanceTime */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerLikesSentenceModel.class, new Deserializer());
                }

                public Object m18519a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewerLikesSentenceParser.m18562a(jsonParser, flatBufferBuilder));
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

            /* compiled from: lastAppearanceTime */
            public class Serializer extends JsonSerializer<ViewerLikesSentenceModel> {
                public final void m18520a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerLikesSentenceModel viewerLikesSentenceModel = (ViewerLikesSentenceModel) obj;
                    if (viewerLikesSentenceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerLikesSentenceModel.m18522a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerLikesSentenceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ViewerLikesSentenceParser.m18563a(viewerLikesSentenceModel.w_(), viewerLikesSentenceModel.u_(), jsonGenerator);
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
            public final String m18524a() {
                this.f11768d = super.a(this.f11768d, 0);
                return this.f11768d;
            }

            public static ViewerLikesSentenceModel m18521a(ViewerLikesSentenceModel viewerLikesSentenceModel) {
                if (viewerLikesSentenceModel == null) {
                    return null;
                }
                if (viewerLikesSentenceModel instanceof ViewerLikesSentenceModel) {
                    return viewerLikesSentenceModel;
                }
                Builder builder = new Builder();
                builder.f11767a = viewerLikesSentenceModel.m18524a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f11767a);
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

            public final GraphQLVisitableModel m18523a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m18522a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m18524a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ ViewerLikesSentenceModel cQ_() {
            return m18538k();
        }

        @Nullable
        public final /* synthetic */ ViewerDoesNotLikeSentenceModel m18536g() {
            return m18537j();
        }

        public MenuItemModel() {
            super(6);
        }

        public MenuItemModel(MutableFlatBuffer mutableFlatBuffer) {
            super(6);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m18531a(String str, ConsistencyTuple consistencyTuple) {
            if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m18534c());
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
                return;
            }
            consistencyTuple.a();
        }

        public final void m18532a(String str, Object obj, boolean z) {
            if ("does_viewer_like".equals(str)) {
                m18526a(((Boolean) obj).booleanValue());
            }
        }

        @Nullable
        public final String m18533b() {
            this.f11769d = super.a(this.f11769d, 0);
            return this.f11769d;
        }

        public final boolean m18534c() {
            a(0, 1);
            return this.f11770e;
        }

        private void m18526a(boolean z) {
            this.f11770e = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, z);
            }
        }

        @Nullable
        public final String m18535d() {
            this.f11771f = super.a(this.f11771f, 2);
            return this.f11771f;
        }

        @Nullable
        public final String cP_() {
            this.f11772g = super.a(this.f11772g, 3);
            return this.f11772g;
        }

        @Nullable
        public final ViewerDoesNotLikeSentenceModel m18537j() {
            this.f11773h = (ViewerDoesNotLikeSentenceModel) super.a(this.f11773h, 4, ViewerDoesNotLikeSentenceModel.class);
            return this.f11773h;
        }

        @Nullable
        public final ViewerLikesSentenceModel m18538k() {
            this.f11774i = (ViewerLikesSentenceModel) super.a(this.f11774i, 5, ViewerLikesSentenceModel.class);
            return this.f11774i;
        }

        public static MenuItemModel m18525a(MenuItemModel menuItemModel) {
            if (menuItemModel == null) {
                return null;
            }
            if (menuItemModel instanceof MenuItemModel) {
                return menuItemModel;
            }
            Builder builder = new Builder();
            builder.f11759a = menuItemModel.m18533b();
            builder.f11760b = menuItemModel.m18534c();
            builder.f11761c = menuItemModel.m18535d();
            builder.f11762d = menuItemModel.cP_();
            builder.f11763e = ViewerDoesNotLikeSentenceModel.m18515a(menuItemModel.m18536g());
            builder.f11764f = ViewerLikesSentenceModel.m18521a(menuItemModel.cQ_());
            return builder.m18510a();
        }

        @Nullable
        public final String m18529a() {
            return m18535d();
        }

        public final int jK_() {
            return 191986496;
        }

        public final GraphQLVisitableModel m18528a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18537j() != null) {
                ViewerDoesNotLikeSentenceModel viewerDoesNotLikeSentenceModel = (ViewerDoesNotLikeSentenceModel) graphQLModelMutatingVisitor.b(m18537j());
                if (m18537j() != viewerDoesNotLikeSentenceModel) {
                    graphQLVisitableModel = (MenuItemModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11773h = viewerDoesNotLikeSentenceModel;
                }
            }
            if (m18538k() != null) {
                ViewerLikesSentenceModel viewerLikesSentenceModel = (ViewerLikesSentenceModel) graphQLModelMutatingVisitor.b(m18538k());
                if (m18538k() != viewerLikesSentenceModel) {
                    graphQLVisitableModel = (MenuItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11774i = viewerLikesSentenceModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18527a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m18533b());
            int b2 = flatBufferBuilder.b(m18535d());
            int b3 = flatBufferBuilder.b(cP_());
            int a = ModelHelper.a(flatBufferBuilder, m18537j());
            int a2 = ModelHelper.a(flatBufferBuilder, m18538k());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f11770e);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, b3);
            flatBufferBuilder.b(4, a);
            flatBufferBuilder.b(5, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m18530a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f11770e = mutableFlatBuffer.a(i, 1);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 697888959)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: lastAppearanceTime */
    public final class StructuredMenuListDataModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MenuSubListModel f11779d;

        /* compiled from: lastAppearanceTime */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StructuredMenuListDataModel.class, new Deserializer());
            }

            public Object m18539a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = StructuredMenuListDataParser.m18572a(jsonParser);
                Object structuredMenuListDataModel = new StructuredMenuListDataModel();
                ((BaseModel) structuredMenuListDataModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (structuredMenuListDataModel instanceof Postprocessable) {
                    return ((Postprocessable) structuredMenuListDataModel).a();
                }
                return structuredMenuListDataModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1008843378)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: lastAppearanceTime */
        public final class MenuSubListModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f11778d;

            /* compiled from: lastAppearanceTime */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MenuSubListModel.class, new Deserializer());
                }

                public Object m18540a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MenuSubListParser.m18570a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object menuSubListModel = new MenuSubListModel();
                    ((BaseModel) menuSubListModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (menuSubListModel instanceof Postprocessable) {
                        return ((Postprocessable) menuSubListModel).a();
                    }
                    return menuSubListModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1639452153)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: lastAppearanceTime */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private MenuItemsModel f11776d;
                @Nullable
                private String f11777e;

                /* compiled from: lastAppearanceTime */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m18541a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m18568b(jsonParser, flatBufferBuilder));
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

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1865227197)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: lastAppearanceTime */
                public final class MenuItemsModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<MenuItemModel> f11775d;

                    /* compiled from: lastAppearanceTime */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(MenuItemsModel.class, new Deserializer());
                        }

                        public Object m18542a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(MenuItemsParser.m18566a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object menuItemsModel = new MenuItemsModel();
                            ((BaseModel) menuItemsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (menuItemsModel instanceof Postprocessable) {
                                return ((Postprocessable) menuItemsModel).a();
                            }
                            return menuItemsModel;
                        }
                    }

                    /* compiled from: lastAppearanceTime */
                    public class Serializer extends JsonSerializer<MenuItemsModel> {
                        public final void m18543a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            MenuItemsModel menuItemsModel = (MenuItemsModel) obj;
                            if (menuItemsModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(menuItemsModel.m18544a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                menuItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            MenuItemsParser.m18567a(menuItemsModel.w_(), menuItemsModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(MenuItemsModel.class, new Serializer());
                        }
                    }

                    public MenuItemsModel() {
                        super(1);
                    }

                    @Nonnull
                    public final ImmutableList<MenuItemModel> m18546a() {
                        this.f11775d = super.a(this.f11775d, 0, MenuItemModel.class);
                        return (ImmutableList) this.f11775d;
                    }

                    public final int jK_() {
                        return -1961117696;
                    }

                    public final GraphQLVisitableModel m18545a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m18546a() != null) {
                            Builder a = ModelHelper.a(m18546a(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (MenuItemsModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f11775d = a.b();
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m18544a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m18546a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: lastAppearanceTime */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m18547a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m18548a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m18569b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(2);
                }

                @Nullable
                public final MenuItemsModel m18550a() {
                    this.f11776d = (MenuItemsModel) super.a(this.f11776d, 0, MenuItemsModel.class);
                    return this.f11776d;
                }

                @Nullable
                public final String m18551j() {
                    this.f11777e = super.a(this.f11777e, 1);
                    return this.f11777e;
                }

                public final int jK_() {
                    return -1276772354;
                }

                public final GraphQLVisitableModel m18549a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m18550a() != null) {
                        MenuItemsModel menuItemsModel = (MenuItemsModel) graphQLModelMutatingVisitor.b(m18550a());
                        if (m18550a() != menuItemsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f11776d = menuItemsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m18548a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m18550a());
                    int b = flatBufferBuilder.b(m18551j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: lastAppearanceTime */
            public class Serializer extends JsonSerializer<MenuSubListModel> {
                public final void m18552a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MenuSubListModel menuSubListModel = (MenuSubListModel) obj;
                    if (menuSubListModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(menuSubListModel.m18553a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        menuSubListModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MenuSubListParser.m18571a(menuSubListModel.w_(), menuSubListModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MenuSubListModel.class, new Serializer());
                }
            }

            public MenuSubListModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m18555a() {
                this.f11778d = super.a(this.f11778d, 0, NodesModel.class);
                return (ImmutableList) this.f11778d;
            }

            public final int jK_() {
                return 1997339313;
            }

            public final GraphQLVisitableModel m18554a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m18555a() != null) {
                    Builder a = ModelHelper.a(m18555a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (MenuSubListModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11778d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m18553a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m18555a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: lastAppearanceTime */
        public class Serializer extends JsonSerializer<StructuredMenuListDataModel> {
            public final void m18556a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                StructuredMenuListDataModel structuredMenuListDataModel = (StructuredMenuListDataModel) obj;
                if (structuredMenuListDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(structuredMenuListDataModel.m18557a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    structuredMenuListDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = structuredMenuListDataModel.w_();
                int u_ = structuredMenuListDataModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("menu_sub_list");
                    MenuSubListParser.m18571a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(StructuredMenuListDataModel.class, new Serializer());
            }
        }

        public StructuredMenuListDataModel() {
            super(1);
        }

        @Nullable
        public final MenuSubListModel m18559a() {
            this.f11779d = (MenuSubListModel) super.a(this.f11779d, 0, MenuSubListModel.class);
            return this.f11779d;
        }

        public final int jK_() {
            return -1276772354;
        }

        public final GraphQLVisitableModel m18558a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18559a() != null) {
                MenuSubListModel menuSubListModel = (MenuSubListModel) graphQLModelMutatingVisitor.b(m18559a());
                if (m18559a() != menuSubListModel) {
                    graphQLVisitableModel = (StructuredMenuListDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11779d = menuSubListModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18557a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18559a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
