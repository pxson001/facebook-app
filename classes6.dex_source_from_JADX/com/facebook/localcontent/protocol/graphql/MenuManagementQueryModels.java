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
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryInterfaces.AvailableMenus;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryParsers.AvailableMenusParser;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryParsers.AvailableMenusParser.AvailableMenuInfoParser;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryParsers.LinkMenuInfoParser;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryParsers.LinkMenuInfoParser.PageLinkMenusParser;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryParsers.LinkMenuInfoParser.PageLinkMenusParser.NodesParser;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryParsers.MenuManagementInfoFieldsParser;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryParsers.MenuManagementInfoFieldsParser.MenuInfoParser;
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

/* compiled from: keywords_v2 */
public class MenuManagementQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2015155611)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: keywords_v2 */
    public final class AvailableMenusModel extends BaseModel implements GraphQLVisitableModel, AvailableMenus {
        @Nullable
        private AvailableMenuInfoModel f11784d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1158654523)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: keywords_v2 */
        public final class AvailableMenuInfoModel extends BaseModel implements GraphQLVisitableModel {
            private boolean f11781d;
            private boolean f11782e;
            private boolean f11783f;

            /* compiled from: keywords_v2 */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AvailableMenuInfoModel.class, new Deserializer());
                }

                public Object m18581a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AvailableMenuInfoParser.m18627a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object availableMenuInfoModel = new AvailableMenuInfoModel();
                    ((BaseModel) availableMenuInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (availableMenuInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) availableMenuInfoModel).a();
                    }
                    return availableMenuInfoModel;
                }
            }

            /* compiled from: keywords_v2 */
            public class Serializer extends JsonSerializer<AvailableMenuInfoModel> {
                public final void m18582a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AvailableMenuInfoModel availableMenuInfoModel = (AvailableMenuInfoModel) obj;
                    if (availableMenuInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(availableMenuInfoModel.m18583a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        availableMenuInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AvailableMenuInfoParser.m18628a(availableMenuInfoModel.w_(), availableMenuInfoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AvailableMenuInfoModel.class, new Serializer());
                }
            }

            public AvailableMenuInfoModel() {
                super(3);
            }

            public final boolean m18587j() {
                a(0, 1);
                return this.f11782e;
            }

            public final boolean m18586a() {
                a(0, 2);
                return this.f11783f;
            }

            public final int jK_() {
                return 480901543;
            }

            public final GraphQLVisitableModel m18584a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m18583a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f11781d);
                flatBufferBuilder.a(1, this.f11782e);
                flatBufferBuilder.a(2, this.f11783f);
                i();
                return flatBufferBuilder.d();
            }

            public final void m18585a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f11781d = mutableFlatBuffer.a(i, 0);
                this.f11782e = mutableFlatBuffer.a(i, 1);
                this.f11783f = mutableFlatBuffer.a(i, 2);
            }
        }

        /* compiled from: keywords_v2 */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AvailableMenusModel.class, new Deserializer());
            }

            public Object m18588a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AvailableMenusParser.m18629a(jsonParser);
                Object availableMenusModel = new AvailableMenusModel();
                ((BaseModel) availableMenusModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (availableMenusModel instanceof Postprocessable) {
                    return ((Postprocessable) availableMenusModel).a();
                }
                return availableMenusModel;
            }
        }

        /* compiled from: keywords_v2 */
        public class Serializer extends JsonSerializer<AvailableMenusModel> {
            public final void m18589a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AvailableMenusModel availableMenusModel = (AvailableMenusModel) obj;
                if (availableMenusModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(availableMenusModel.m18591a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    availableMenusModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = availableMenusModel.w_();
                int u_ = availableMenusModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("available_menu_info");
                    AvailableMenuInfoParser.m18628a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AvailableMenusModel.class, new Serializer());
            }
        }

        public AvailableMenusModel() {
            super(1);
        }

        @Nullable
        private AvailableMenuInfoModel m18590a() {
            this.f11784d = (AvailableMenuInfoModel) super.a(this.f11784d, 0, AvailableMenuInfoModel.class);
            return this.f11784d;
        }

        public final int jK_() {
            return 2056274556;
        }

        public final GraphQLVisitableModel m18592a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18590a() != null) {
                AvailableMenuInfoModel availableMenuInfoModel = (AvailableMenuInfoModel) graphQLModelMutatingVisitor.b(m18590a());
                if (m18590a() != availableMenuInfoModel) {
                    graphQLVisitableModel = (AvailableMenusModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11784d = availableMenuInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18591a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18590a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 892151490)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: keywords_v2 */
    public final class LinkMenuInfoModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private PageLinkMenusModel f11787d;

        /* compiled from: keywords_v2 */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LinkMenuInfoModel.class, new Deserializer());
            }

            public Object m18593a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = LinkMenuInfoParser.m18634a(jsonParser);
                Object linkMenuInfoModel = new LinkMenuInfoModel();
                ((BaseModel) linkMenuInfoModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (linkMenuInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) linkMenuInfoModel).a();
                }
                return linkMenuInfoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 893310243)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: keywords_v2 */
        public final class PageLinkMenusModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f11786d;

            /* compiled from: keywords_v2 */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageLinkMenusModel.class, new Deserializer());
                }

                public Object m18594a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageLinkMenusParser.m18632a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageLinkMenusModel = new PageLinkMenusModel();
                    ((BaseModel) pageLinkMenusModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageLinkMenusModel instanceof Postprocessable) {
                        return ((Postprocessable) pageLinkMenusModel).a();
                    }
                    return pageLinkMenusModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1772011547)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: keywords_v2 */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f11785d;

                /* compiled from: keywords_v2 */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m18595a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m18631b(jsonParser, flatBufferBuilder));
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

                /* compiled from: keywords_v2 */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m18596a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m18597a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m18630a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(1);
                }

                @Nullable
                public final String m18599a() {
                    this.f11785d = super.a(this.f11785d, 0);
                    return this.f11785d;
                }

                public final int jK_() {
                    return -440612792;
                }

                public final GraphQLVisitableModel m18598a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m18597a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m18599a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: keywords_v2 */
            public class Serializer extends JsonSerializer<PageLinkMenusModel> {
                public final void m18600a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageLinkMenusModel pageLinkMenusModel = (PageLinkMenusModel) obj;
                    if (pageLinkMenusModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageLinkMenusModel.m18601a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageLinkMenusModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageLinkMenusParser.m18633a(pageLinkMenusModel.w_(), pageLinkMenusModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PageLinkMenusModel.class, new Serializer());
                }
            }

            public PageLinkMenusModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m18603a() {
                this.f11786d = super.a(this.f11786d, 0, NodesModel.class);
                return (ImmutableList) this.f11786d;
            }

            public final int jK_() {
                return -1958780311;
            }

            public final GraphQLVisitableModel m18602a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m18603a() != null) {
                    Builder a = ModelHelper.a(m18603a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PageLinkMenusModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11786d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m18601a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m18603a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: keywords_v2 */
        public class Serializer extends JsonSerializer<LinkMenuInfoModel> {
            public final void m18604a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                LinkMenuInfoModel linkMenuInfoModel = (LinkMenuInfoModel) obj;
                if (linkMenuInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(linkMenuInfoModel.m18606a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    linkMenuInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = linkMenuInfoModel.w_();
                int u_ = linkMenuInfoModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("page_link_menus");
                    PageLinkMenusParser.m18633a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(LinkMenuInfoModel.class, new Serializer());
            }
        }

        public LinkMenuInfoModel() {
            super(1);
        }

        public final void m18608a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m18609a(String str, Object obj, boolean z) {
        }

        @Nullable
        private PageLinkMenusModel m18605a() {
            this.f11787d = (PageLinkMenusModel) super.a(this.f11787d, 0, PageLinkMenusModel.class);
            return this.f11787d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m18607a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18605a() != null) {
                PageLinkMenusModel pageLinkMenusModel = (PageLinkMenusModel) graphQLModelMutatingVisitor.b(m18605a());
                if (m18605a() != pageLinkMenusModel) {
                    graphQLVisitableModel = (LinkMenuInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11787d = pageLinkMenusModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18606a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18605a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -683878721)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: keywords_v2 */
    public final class MenuManagementInfoFieldsModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private MenuInfoModel f11792d;
        @Nullable
        private PageLinkMenusModel f11793e;

        /* compiled from: keywords_v2 */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MenuManagementInfoFieldsModel.class, new Deserializer());
            }

            public Object m18610a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MenuManagementInfoFieldsParser.m18637a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object menuManagementInfoFieldsModel = new MenuManagementInfoFieldsModel();
                ((BaseModel) menuManagementInfoFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (menuManagementInfoFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) menuManagementInfoFieldsModel).a();
                }
                return menuManagementInfoFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1214824792)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: keywords_v2 */
        public final class MenuInfoModel extends BaseModel implements GraphQLVisitableModel, AvailableMenus {
            @Nullable
            private AvailableMenuInfoModel f11788d;
            private boolean f11789e;
            private boolean f11790f;
            private boolean f11791g;

            /* compiled from: keywords_v2 */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MenuInfoModel.class, new Deserializer());
                }

                public Object m18611a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MenuInfoParser.m18635a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object menuInfoModel = new MenuInfoModel();
                    ((BaseModel) menuInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (menuInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) menuInfoModel).a();
                    }
                    return menuInfoModel;
                }
            }

            /* compiled from: keywords_v2 */
            public class Serializer extends JsonSerializer<MenuInfoModel> {
                public final void m18612a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MenuInfoModel menuInfoModel = (MenuInfoModel) obj;
                    if (menuInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(menuInfoModel.m18613a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        menuInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MenuInfoParser.m18636a(menuInfoModel.w_(), menuInfoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MenuInfoModel.class, new Serializer());
                }
            }

            public MenuInfoModel() {
                super(4);
            }

            @Nullable
            public final AvailableMenuInfoModel m18619j() {
                this.f11788d = (AvailableMenuInfoModel) super.a(this.f11788d, 0, AvailableMenuInfoModel.class);
                return this.f11788d;
            }

            public final boolean m18616a() {
                a(0, 1);
                return this.f11789e;
            }

            public final boolean m18617b() {
                a(0, 2);
                return this.f11790f;
            }

            public final boolean m18618c() {
                a(0, 3);
                return this.f11791g;
            }

            public final int jK_() {
                return 2056274556;
            }

            public final GraphQLVisitableModel m18614a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m18619j() != null) {
                    AvailableMenuInfoModel availableMenuInfoModel = (AvailableMenuInfoModel) graphQLModelMutatingVisitor.b(m18619j());
                    if (m18619j() != availableMenuInfoModel) {
                        graphQLVisitableModel = (MenuInfoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11788d = availableMenuInfoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m18613a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m18619j());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f11789e);
                flatBufferBuilder.a(2, this.f11790f);
                flatBufferBuilder.a(3, this.f11791g);
                i();
                return flatBufferBuilder.d();
            }

            public final void m18615a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f11789e = mutableFlatBuffer.a(i, 1);
                this.f11790f = mutableFlatBuffer.a(i, 2);
                this.f11791g = mutableFlatBuffer.a(i, 3);
            }
        }

        /* compiled from: keywords_v2 */
        public class Serializer extends JsonSerializer<MenuManagementInfoFieldsModel> {
            public final void m18620a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MenuManagementInfoFieldsModel menuManagementInfoFieldsModel = (MenuManagementInfoFieldsModel) obj;
                if (menuManagementInfoFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(menuManagementInfoFieldsModel.m18621a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    menuManagementInfoFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MenuManagementInfoFieldsParser.m18638a(menuManagementInfoFieldsModel.w_(), menuManagementInfoFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MenuManagementInfoFieldsModel.class, new Serializer());
            }
        }

        public MenuManagementInfoFieldsModel() {
            super(2);
        }

        public final void m18624a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m18625a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final MenuInfoModel m18623a() {
            this.f11792d = (MenuInfoModel) super.a(this.f11792d, 0, MenuInfoModel.class);
            return this.f11792d;
        }

        @Nullable
        public final PageLinkMenusModel m18626j() {
            this.f11793e = (PageLinkMenusModel) super.a(this.f11793e, 1, PageLinkMenusModel.class);
            return this.f11793e;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m18622a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18623a() != null) {
                MenuInfoModel menuInfoModel = (MenuInfoModel) graphQLModelMutatingVisitor.b(m18623a());
                if (m18623a() != menuInfoModel) {
                    graphQLVisitableModel = (MenuManagementInfoFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11792d = menuInfoModel;
                }
            }
            if (m18626j() != null) {
                PageLinkMenusModel pageLinkMenusModel = (PageLinkMenusModel) graphQLModelMutatingVisitor.b(m18626j());
                if (m18626j() != pageLinkMenusModel) {
                    graphQLVisitableModel = (MenuManagementInfoFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11793e = pageLinkMenusModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18621a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18623a());
            int a2 = ModelHelper.a(flatBufferBuilder, m18626j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
