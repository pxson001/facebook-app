package com.facebook.pages.common.editpage.graphql;

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
import com.facebook.graphql.enums.GraphQLPagePresenceTabContentType;
import com.facebook.graphql.enums.GraphQLPagePresenceTabType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryInterfaces.EditPageData;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryInterfaces.SectionsCanAddData;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryParsers.EditPageDataParser;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryParsers.EditPageDataParser.CommerceStoreParser;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryParsers.EditPageDataParser.CommerceStoreParser.CommerceMerchantSettingsParser;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryParsers.EditPageDataParser.ServicesCardParser;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryParsers.EditPageDataParser.TabsParser;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryParsers.EditPageDataParser.TabsParser.NameParser;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryParsers.EditPageDataParser.TabsParser.TitleParser;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryParsers.FetchEditPageQueryParser;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryParsers.SectionsCanAddDataParser.SectionsCanAddParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLInterfaces.PageCallToActionData;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageCallToActionDataParser.PageCallToActionParser;
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

/* compiled from: should_show_beside_title */
public class FetchEditPageQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -474393786)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: should_show_beside_title */
    public final class EditPageDataModel extends BaseModel implements GraphQLVisitableConsistentModel, EditPageData {
        @Nullable
        private CommerceStoreModel f1584d;
        private boolean f1585e;
        @Nullable
        private ServicesCardModel f1586f;
        @Nullable
        private List<TabsModel> f1587g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 301935899)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: should_show_beside_title */
        public final class CommerceStoreModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private CommerceMerchantSettingsModel f1575d;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 251044169)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: should_show_beside_title */
            public final class CommerceMerchantSettingsModel extends BaseModel implements GraphQLVisitableModel {
                private boolean f1574d;

                /* compiled from: should_show_beside_title */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CommerceMerchantSettingsModel.class, new Deserializer());
                    }

                    public Object m2266a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CommerceMerchantSettingsParser.m2366a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object commerceMerchantSettingsModel = new CommerceMerchantSettingsModel();
                        ((BaseModel) commerceMerchantSettingsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (commerceMerchantSettingsModel instanceof Postprocessable) {
                            return ((Postprocessable) commerceMerchantSettingsModel).a();
                        }
                        return commerceMerchantSettingsModel;
                    }
                }

                /* compiled from: should_show_beside_title */
                public class Serializer extends JsonSerializer<CommerceMerchantSettingsModel> {
                    public final void m2267a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CommerceMerchantSettingsModel commerceMerchantSettingsModel = (CommerceMerchantSettingsModel) obj;
                        if (commerceMerchantSettingsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(commerceMerchantSettingsModel.m2268a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            commerceMerchantSettingsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CommerceMerchantSettingsParser.m2367a(commerceMerchantSettingsModel.w_(), commerceMerchantSettingsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(CommerceMerchantSettingsModel.class, new Serializer());
                    }
                }

                public CommerceMerchantSettingsModel() {
                    super(1);
                }

                public final boolean m2271a() {
                    a(0, 0);
                    return this.f1574d;
                }

                public final int jK_() {
                    return -1128014042;
                }

                public final GraphQLVisitableModel m2269a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2268a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f1574d);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m2270a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f1574d = mutableFlatBuffer.a(i, 0);
                }
            }

            /* compiled from: should_show_beside_title */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CommerceStoreModel.class, new Deserializer());
                }

                public Object m2272a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CommerceStoreParser.m2368a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object commerceStoreModel = new CommerceStoreModel();
                    ((BaseModel) commerceStoreModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (commerceStoreModel instanceof Postprocessable) {
                        return ((Postprocessable) commerceStoreModel).a();
                    }
                    return commerceStoreModel;
                }
            }

            /* compiled from: should_show_beside_title */
            public class Serializer extends JsonSerializer<CommerceStoreModel> {
                public final void m2273a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CommerceStoreModel commerceStoreModel = (CommerceStoreModel) obj;
                    if (commerceStoreModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(commerceStoreModel.m2275a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        commerceStoreModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CommerceStoreParser.m2369a(commerceStoreModel.w_(), commerceStoreModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CommerceStoreModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ CommerceMerchantSettingsModel m2277a() {
                return m2274j();
            }

            public CommerceStoreModel() {
                super(1);
            }

            @Nullable
            private CommerceMerchantSettingsModel m2274j() {
                this.f1575d = (CommerceMerchantSettingsModel) super.a(this.f1575d, 0, CommerceMerchantSettingsModel.class);
                return this.f1575d;
            }

            public final int jK_() {
                return 308731558;
            }

            public final GraphQLVisitableModel m2276a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2274j() != null) {
                    CommerceMerchantSettingsModel commerceMerchantSettingsModel = (CommerceMerchantSettingsModel) graphQLModelMutatingVisitor.b(m2274j());
                    if (m2274j() != commerceMerchantSettingsModel) {
                        graphQLVisitableModel = (CommerceStoreModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1575d = commerceMerchantSettingsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2275a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2274j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: should_show_beside_title */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EditPageDataModel.class, new Deserializer());
            }

            public Object m2278a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(EditPageDataParser.m2380a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object editPageDataModel = new EditPageDataModel();
                ((BaseModel) editPageDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (editPageDataModel instanceof Postprocessable) {
                    return ((Postprocessable) editPageDataModel).a();
                }
                return editPageDataModel;
            }
        }

        /* compiled from: should_show_beside_title */
        public class Serializer extends JsonSerializer<EditPageDataModel> {
            public final void m2279a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                EditPageDataModel editPageDataModel = (EditPageDataModel) obj;
                if (editPageDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(editPageDataModel.m2309a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    editPageDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = editPageDataModel.w_();
                int u_ = editPageDataModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("commerce_store");
                    CommerceStoreParser.m2369a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                boolean a = mutableFlatBuffer.a(u_, 1);
                if (a) {
                    jsonGenerator.a("is_service_page");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("services_card");
                    ServicesCardParser.m2371a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("tabs");
                    TabsParser.m2377a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(EditPageDataModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: should_show_beside_title */
        public final class ServicesCardModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f1576d;

            /* compiled from: should_show_beside_title */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ServicesCardModel.class, new Deserializer());
                }

                public Object m2280a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ServicesCardParser.m2370a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object servicesCardModel = new ServicesCardModel();
                    ((BaseModel) servicesCardModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (servicesCardModel instanceof Postprocessable) {
                        return ((Postprocessable) servicesCardModel).a();
                    }
                    return servicesCardModel;
                }
            }

            /* compiled from: should_show_beside_title */
            public class Serializer extends JsonSerializer<ServicesCardModel> {
                public final void m2281a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ServicesCardModel servicesCardModel = (ServicesCardModel) obj;
                    if (servicesCardModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(servicesCardModel.m2283a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        servicesCardModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ServicesCardParser.m2371a(servicesCardModel.w_(), servicesCardModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ServicesCardModel.class, new Serializer());
                }
            }

            public ServicesCardModel() {
                super(1);
            }

            @Nullable
            private String m2282j() {
                this.f1576d = super.a(this.f1576d, 0);
                return this.f1576d;
            }

            @Nullable
            public final String m2285a() {
                return m2282j();
            }

            public final int jK_() {
                return -1544864547;
            }

            public final GraphQLVisitableModel m2284a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2283a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2282j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1666201481)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: should_show_beside_title */
        public final class TabsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLPagePresenceTabContentType f1579d;
            @Nullable
            private NameModel f1580e;
            @Nullable
            private String f1581f;
            @Nullable
            private GraphQLPagePresenceTabType f1582g;
            @Nullable
            private TitleModel f1583h;

            /* compiled from: should_show_beside_title */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TabsModel.class, new Deserializer());
                }

                public Object m2286a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TabsParser.m2378b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object tabsModel = new TabsModel();
                    ((BaseModel) tabsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (tabsModel instanceof Postprocessable) {
                        return ((Postprocessable) tabsModel).a();
                    }
                    return tabsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: should_show_beside_title */
            public final class NameModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f1577d;

                /* compiled from: should_show_beside_title */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NameModel.class, new Deserializer());
                    }

                    public Object m2287a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NameParser.m2372a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nameModel = new NameModel();
                        ((BaseModel) nameModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nameModel instanceof Postprocessable) {
                            return ((Postprocessable) nameModel).a();
                        }
                        return nameModel;
                    }
                }

                /* compiled from: should_show_beside_title */
                public class Serializer extends JsonSerializer<NameModel> {
                    public final void m2288a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NameModel nameModel = (NameModel) obj;
                        if (nameModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nameModel.m2289a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nameModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NameParser.m2373a(nameModel.w_(), nameModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NameModel.class, new Serializer());
                    }
                }

                public NameModel() {
                    super(1);
                }

                @Nullable
                public final String m2291a() {
                    this.f1577d = super.a(this.f1577d, 0);
                    return this.f1577d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m2290a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2289a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m2291a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: should_show_beside_title */
            public class Serializer extends JsonSerializer<TabsModel> {
                public final void m2292a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TabsModel tabsModel = (TabsModel) obj;
                    if (tabsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(tabsModel.m2302a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        tabsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TabsParser.m2379b(tabsModel.w_(), tabsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TabsModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: should_show_beside_title */
            public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f1578d;

                /* compiled from: should_show_beside_title */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                    }

                    public Object m2293a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(TitleParser.m2374a(jsonParser, flatBufferBuilder));
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

                /* compiled from: should_show_beside_title */
                public class Serializer extends JsonSerializer<TitleModel> {
                    public final void m2294a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TitleModel titleModel = (TitleModel) obj;
                        if (titleModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(titleModel.m2296a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        TitleParser.m2375a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(TitleModel.class, new Serializer());
                    }
                }

                public TitleModel() {
                    super(1);
                }

                @Nullable
                private String m2295a() {
                    this.f1578d = super.a(this.f1578d, 0);
                    return this.f1578d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m2297a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2296a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m2295a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @Nullable
            public final /* synthetic */ NameModel m2304a() {
                return m2299k();
            }

            public TabsModel() {
                super(5);
            }

            @Nullable
            private GraphQLPagePresenceTabContentType m2298j() {
                this.f1579d = (GraphQLPagePresenceTabContentType) super.b(this.f1579d, 0, GraphQLPagePresenceTabContentType.class, GraphQLPagePresenceTabContentType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f1579d;
            }

            @Nullable
            private NameModel m2299k() {
                this.f1580e = (NameModel) super.a(this.f1580e, 1, NameModel.class);
                return this.f1580e;
            }

            @Nullable
            private String m2300l() {
                this.f1581f = super.a(this.f1581f, 2);
                return this.f1581f;
            }

            @Nullable
            public final GraphQLPagePresenceTabType m2305b() {
                this.f1582g = (GraphQLPagePresenceTabType) super.b(this.f1582g, 3, GraphQLPagePresenceTabType.class, GraphQLPagePresenceTabType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f1582g;
            }

            @Nullable
            private TitleModel m2301m() {
                this.f1583h = (TitleModel) super.a(this.f1583h, 4, TitleModel.class);
                return this.f1583h;
            }

            public final int jK_() {
                return -1024957845;
            }

            public final GraphQLVisitableModel m2303a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2299k() != null) {
                    NameModel nameModel = (NameModel) graphQLModelMutatingVisitor.b(m2299k());
                    if (m2299k() != nameModel) {
                        graphQLVisitableModel = (TabsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1580e = nameModel;
                    }
                }
                if (m2301m() != null) {
                    TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m2301m());
                    if (m2301m() != titleModel) {
                        graphQLVisitableModel = (TabsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1583h = titleModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2302a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(m2298j());
                int a2 = ModelHelper.a(flatBufferBuilder, m2299k());
                int b = flatBufferBuilder.b(m2300l());
                int a3 = flatBufferBuilder.a(m2305b());
                int a4 = ModelHelper.a(flatBufferBuilder, m2301m());
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, a3);
                flatBufferBuilder.b(4, a4);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ CommerceStoreModel mo31a() {
            return m2306j();
        }

        @Nullable
        public final /* synthetic */ ServicesCardModel mo33c() {
            return m2307k();
        }

        public EditPageDataModel() {
            super(4);
        }

        public final void m2313a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m2314a(String str, Object obj, boolean z) {
        }

        @Nullable
        private CommerceStoreModel m2306j() {
            this.f1584d = (CommerceStoreModel) super.a(this.f1584d, 0, CommerceStoreModel.class);
            return this.f1584d;
        }

        public final boolean mo32b() {
            a(0, 1);
            return this.f1585e;
        }

        @Nullable
        private ServicesCardModel m2307k() {
            this.f1586f = (ServicesCardModel) super.a(this.f1586f, 2, ServicesCardModel.class);
            return this.f1586f;
        }

        @Nonnull
        private ImmutableList<TabsModel> m2308l() {
            this.f1587g = super.a(this.f1587g, 3, TabsModel.class);
            return (ImmutableList) this.f1587g;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m2310a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2306j() != null) {
                CommerceStoreModel commerceStoreModel = (CommerceStoreModel) graphQLModelMutatingVisitor.b(m2306j());
                if (m2306j() != commerceStoreModel) {
                    graphQLVisitableModel = (EditPageDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1584d = commerceStoreModel;
                }
            }
            if (m2307k() != null) {
                ServicesCardModel servicesCardModel = (ServicesCardModel) graphQLModelMutatingVisitor.b(m2307k());
                if (m2307k() != servicesCardModel) {
                    graphQLVisitableModel = (EditPageDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1586f = servicesCardModel;
                }
            }
            if (m2308l() != null) {
                Builder a = ModelHelper.a(m2308l(), graphQLModelMutatingVisitor);
                if (a != null) {
                    EditPageDataModel editPageDataModel = (EditPageDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    editPageDataModel.f1587g = a.b();
                    graphQLVisitableModel = editPageDataModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2309a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2306j());
            int a2 = ModelHelper.a(flatBufferBuilder, m2307k());
            int a3 = ModelHelper.a(flatBufferBuilder, m2308l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f1585e);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m2312a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1585e = mutableFlatBuffer.a(i, 1);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 969138947)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: should_show_beside_title */
    public final class FetchEditPageQueryModel extends BaseModel implements GraphQLVisitableConsistentModel, EditPageData, SectionsCanAddData, PageCallToActionData {
        @Nullable
        private GraphQLObjectType f1588d;
        @Nullable
        private CommerceStoreModel f1589e;
        private boolean f1590f;
        @Nullable
        private PageCallToActionModel f1591g;
        @Nullable
        private List<SectionsCanAddModel> f1592h;
        @Nullable
        private ServicesCardModel f1593i;
        @Nullable
        private List<TabsModel> f1594j;

        /* compiled from: should_show_beside_title */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchEditPageQueryModel.class, new Deserializer());
            }

            public Object m2317a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FetchEditPageQueryParser.m2381a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fetchEditPageQueryModel = new FetchEditPageQueryModel();
                ((BaseModel) fetchEditPageQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fetchEditPageQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchEditPageQueryModel).a();
                }
                return fetchEditPageQueryModel;
            }
        }

        /* compiled from: should_show_beside_title */
        public class Serializer extends JsonSerializer<FetchEditPageQueryModel> {
            public final void m2318a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchEditPageQueryModel fetchEditPageQueryModel = (FetchEditPageQueryModel) obj;
                if (fetchEditPageQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchEditPageQueryModel.m2323a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchEditPageQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchEditPageQueryModel.w_();
                int u_ = fetchEditPageQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("commerce_store");
                    CommerceStoreParser.m2369a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                boolean a = mutableFlatBuffer.a(u_, 2);
                if (a) {
                    jsonGenerator.a("is_service_page");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("page_call_to_action");
                    PageCallToActionParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("sections_can_add");
                    SectionsCanAddParser.m2389a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("services_card");
                    ServicesCardParser.m2371a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 6);
                if (g != 0) {
                    jsonGenerator.a("tabs");
                    TabsParser.m2377a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchEditPageQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ CommerceStoreModel mo31a() {
            return m2320k();
        }

        @Nullable
        public final /* synthetic */ ServicesCardModel mo33c() {
            return m2322m();
        }

        @Nullable
        public final /* synthetic */ PageCallToActionModel m2331d() {
            return m2321l();
        }

        public FetchEditPageQueryModel() {
            super(7);
        }

        public final void m2327a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m2328a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m2319j() {
            if (this.b != null && this.f1588d == null) {
                this.f1588d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f1588d;
        }

        @Nullable
        private CommerceStoreModel m2320k() {
            this.f1589e = (CommerceStoreModel) super.a(this.f1589e, 1, CommerceStoreModel.class);
            return this.f1589e;
        }

        public final boolean mo32b() {
            a(0, 2);
            return this.f1590f;
        }

        @Nullable
        private PageCallToActionModel m2321l() {
            this.f1591g = (PageCallToActionModel) super.a(this.f1591g, 3, PageCallToActionModel.class);
            return this.f1591g;
        }

        @Nonnull
        public final ImmutableList<SectionsCanAddModel> mo34g() {
            this.f1592h = super.a(this.f1592h, 4, SectionsCanAddModel.class);
            return (ImmutableList) this.f1592h;
        }

        @Nullable
        private ServicesCardModel m2322m() {
            this.f1593i = (ServicesCardModel) super.a(this.f1593i, 5, ServicesCardModel.class);
            return this.f1593i;
        }

        @Nonnull
        public final ImmutableList<TabsModel> mS_() {
            this.f1594j = super.a(this.f1594j, 6, TabsModel.class);
            return (ImmutableList) this.f1594j;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m2324a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2320k() != null) {
                CommerceStoreModel commerceStoreModel = (CommerceStoreModel) graphQLModelMutatingVisitor.b(m2320k());
                if (m2320k() != commerceStoreModel) {
                    graphQLVisitableModel = (FetchEditPageQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1589e = commerceStoreModel;
                }
            }
            if (m2321l() != null) {
                PageCallToActionModel pageCallToActionModel = (PageCallToActionModel) graphQLModelMutatingVisitor.b(m2321l());
                if (m2321l() != pageCallToActionModel) {
                    graphQLVisitableModel = (FetchEditPageQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1591g = pageCallToActionModel;
                }
            }
            if (mo34g() != null) {
                a = ModelHelper.a(mo34g(), graphQLModelMutatingVisitor);
                if (a != null) {
                    FetchEditPageQueryModel fetchEditPageQueryModel = (FetchEditPageQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    fetchEditPageQueryModel.f1592h = a.b();
                    graphQLVisitableModel = fetchEditPageQueryModel;
                }
            }
            if (m2322m() != null) {
                ServicesCardModel servicesCardModel = (ServicesCardModel) graphQLModelMutatingVisitor.b(m2322m());
                if (m2322m() != servicesCardModel) {
                    graphQLVisitableModel = (FetchEditPageQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1593i = servicesCardModel;
                }
            }
            if (mS_() != null) {
                a = ModelHelper.a(mS_(), graphQLModelMutatingVisitor);
                if (a != null) {
                    fetchEditPageQueryModel = (FetchEditPageQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    fetchEditPageQueryModel.f1594j = a.b();
                    graphQLVisitableModel = fetchEditPageQueryModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2323a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2319j());
            int a2 = ModelHelper.a(flatBufferBuilder, m2320k());
            int a3 = ModelHelper.a(flatBufferBuilder, m2321l());
            int a4 = ModelHelper.a(flatBufferBuilder, mo34g());
            int a5 = ModelHelper.a(flatBufferBuilder, m2322m());
            int a6 = ModelHelper.a(flatBufferBuilder, mS_());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.a(2, this.f1590f);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, a6);
            i();
            return flatBufferBuilder.d();
        }

        public final void m2326a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1590f = mutableFlatBuffer.a(i, 2);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1385825155)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: should_show_beside_title */
    public final class SectionsCanAddDataModel extends BaseModel implements GraphQLVisitableConsistentModel, SectionsCanAddData {
        @Nullable
        private List<SectionsCanAddModel> f1602d;

        /* compiled from: should_show_beside_title */
        public class Deserializer extends FbJsonDeserializer {
            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.class;
                r1 = new com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels$SectionsCanAddDataModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m2333a(com.fasterxml.jackson.core.JsonParser r6, com.fasterxml.jackson.databind.DeserializationContext r7) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r5 = this;
                r2 = com.facebook.pages.common.editpage.graphql.FetchEditPageQueryParsers.SectionsCanAddDataParser.m2392a(r6);
                r1 = new com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels$SectionsCanAddDataModel;
                r1.<init>();
                r4 = r2.a;
                r0 = r4;
                r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                r0 = r1;
                r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                r0.a(r2, r3, r6);
                r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                if (r0 == 0) goto L_0x0020;
            L_0x001a:
                r1 = (com.facebook.common.json.Postprocessable) r1;
                r1 = r1.a();
            L_0x0020:
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1137526291)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: should_show_beside_title */
        public final class SectionsCanAddModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private NameModel f1598d;
            @Nullable
            private SubtitleModel f1599e;
            @Nullable
            private GraphQLPagePresenceTabType f1600f;
            @Nullable
            private TitleModel f1601g;

            /* compiled from: should_show_beside_title */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.class;
                    r1 = new com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels$SectionsCanAddDataModel$SectionsCanAddModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m2334a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.pages.common.editpage.graphql.FetchEditPageQueryParsers.SectionsCanAddDataParser.SectionsCanAddParser.m2390b(r11, r4);
                    r4.d(r5);
                    r4 = r4.e();
                    r5 = java.nio.ByteBuffer.wrap(r4);
                    r4 = 0;
                    r5.position(r4);
                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r7 = r6;
                    r9 = r6;
                    r4.<init>(r5, r6, r7, r8, r9);
                    r5 = 4;
                    r6 = java.lang.Boolean.valueOf(r8);
                    r4.a(r5, r6);
                    r2 = r4;
                    r1 = new com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels$SectionsCanAddDataModel$SectionsCanAddModel;
                    r1.<init>();
                    r4 = r2.a;
                    r0 = r4;
                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r0 = r1;
                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                    r0.a(r2, r3, r11);
                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                    if (r0 == 0) goto L_0x0048;
                L_0x0042:
                    r1 = (com.facebook.common.json.Postprocessable) r1;
                    r1 = r1.a();
                L_0x0048:
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: should_show_beside_title */
            public final class NameModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f1595d;

                /* compiled from: should_show_beside_title */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.NameModel.class;
                        r1 = new com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels$SectionsCanAddDataModel$SectionsCanAddModel$NameModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.NameModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m2335a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r10 = this;
                        r8 = 1;
                        r6 = 0;
                        r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r4.<init>(r5);
                        r5 = com.facebook.pages.common.editpage.graphql.FetchEditPageQueryParsers.SectionsCanAddDataParser.SectionsCanAddParser.NameParser.m2382a(r11, r4);
                        r4.d(r5);
                        r4 = r4.e();
                        r5 = java.nio.ByteBuffer.wrap(r4);
                        r4 = 0;
                        r5.position(r4);
                        r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r7 = r6;
                        r9 = r6;
                        r4.<init>(r5, r6, r7, r8, r9);
                        r5 = 4;
                        r6 = java.lang.Boolean.valueOf(r8);
                        r4.a(r5, r6);
                        r2 = r4;
                        r1 = new com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels$SectionsCanAddDataModel$SectionsCanAddModel$NameModel;
                        r1.<init>();
                        r4 = r2.a;
                        r0 = r4;
                        r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                        r0 = r1;
                        r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                        r0.a(r2, r3, r11);
                        r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                        if (r0 == 0) goto L_0x0048;
                    L_0x0042:
                        r1 = (com.facebook.common.json.Postprocessable) r1;
                        r1 = r1.a();
                    L_0x0048:
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.NameModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: should_show_beside_title */
                public class Serializer extends JsonSerializer<NameModel> {
                    public final void m2336a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r7 = this;
                        r8 = (com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.NameModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m2337a(r0);
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r0 = 0;
                        r1.position(r0);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r4 = 1;
                        r3 = r2;
                        r5 = r2;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r6 = r0.a;
                        r1 = r6;
                        r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                        r8.a(r0, r1);
                    L_0x0035:
                        r0 = r8.w_();
                        r1 = r8.u_();
                        com.facebook.pages.common.editpage.graphql.FetchEditPageQueryParsers.SectionsCanAddDataParser.SectionsCanAddParser.NameParser.m2383a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.NameModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.NameModel.class;
                        r1 = new com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels$SectionsCanAddDataModel$SectionsCanAddModel$NameModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.NameModel.Serializer.<clinit>():void");
                    }
                }

                public NameModel() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 1;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.NameModel.<init>():void");
                }

                @javax.annotation.Nullable
                public final java.lang.String m2339a() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f1595d;
                    r1 = 0;
                    r0 = super.a(r0, r1);
                    r2.f1595d = r0;
                    r0 = r2.f1595d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.NameModel.a():java.lang.String");
                }

                public final int jK_() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = -1919764332; // 0xffffffff8d92b894 float:-9.04238E-31 double:NaN;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.NameModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m2338a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r0.h();
                    r0.i();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.NameModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m2337a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r2.h();
                    r0 = r2.m2339a();
                    r0 = r3.b(r0);
                    r1 = 1;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.NameModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: should_show_beside_title */
            public class Serializer extends JsonSerializer<SectionsCanAddModel> {
                public final void m2340a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r7 = this;
                    r8 = (com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m2354a(r0);
                    r0.d(r1);
                    r0 = r0.e();
                    r1 = java.nio.ByteBuffer.wrap(r0);
                    r0 = 0;
                    r1.position(r0);
                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r4 = 1;
                    r3 = r2;
                    r5 = r2;
                    r0.<init>(r1, r2, r3, r4, r5);
                    r6 = r0.a;
                    r1 = r6;
                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                    r8.a(r0, r1);
                L_0x0035:
                    r0 = r8.w_();
                    r1 = r8.u_();
                    com.facebook.pages.common.editpage.graphql.FetchEditPageQueryParsers.SectionsCanAddDataParser.SectionsCanAddParser.m2391b(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.class;
                    r1 = new com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels$SectionsCanAddDataModel$SectionsCanAddModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.Serializer.<clinit>():void");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: should_show_beside_title */
            public final class SubtitleModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f1596d;

                /* compiled from: should_show_beside_title */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.SubtitleModel.class;
                        r1 = new com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels$SectionsCanAddDataModel$SectionsCanAddModel$SubtitleModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.SubtitleModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m2341a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r10 = this;
                        r8 = 1;
                        r6 = 0;
                        r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r4.<init>(r5);
                        r5 = com.facebook.pages.common.editpage.graphql.FetchEditPageQueryParsers.SectionsCanAddDataParser.SectionsCanAddParser.SubtitleParser.m2384a(r11, r4);
                        r4.d(r5);
                        r4 = r4.e();
                        r5 = java.nio.ByteBuffer.wrap(r4);
                        r4 = 0;
                        r5.position(r4);
                        r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r7 = r6;
                        r9 = r6;
                        r4.<init>(r5, r6, r7, r8, r9);
                        r5 = 4;
                        r6 = java.lang.Boolean.valueOf(r8);
                        r4.a(r5, r6);
                        r2 = r4;
                        r1 = new com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels$SectionsCanAddDataModel$SectionsCanAddModel$SubtitleModel;
                        r1.<init>();
                        r4 = r2.a;
                        r0 = r4;
                        r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                        r0 = r1;
                        r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                        r0.a(r2, r3, r11);
                        r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                        if (r0 == 0) goto L_0x0048;
                    L_0x0042:
                        r1 = (com.facebook.common.json.Postprocessable) r1;
                        r1 = r1.a();
                    L_0x0048:
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.SubtitleModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: should_show_beside_title */
                public class Serializer extends JsonSerializer<SubtitleModel> {
                    public final void m2342a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r7 = this;
                        r8 = (com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.SubtitleModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m2343a(r0);
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r0 = 0;
                        r1.position(r0);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r4 = 1;
                        r3 = r2;
                        r5 = r2;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r6 = r0.a;
                        r1 = r6;
                        r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                        r8.a(r0, r1);
                    L_0x0035:
                        r0 = r8.w_();
                        r1 = r8.u_();
                        com.facebook.pages.common.editpage.graphql.FetchEditPageQueryParsers.SectionsCanAddDataParser.SectionsCanAddParser.SubtitleParser.m2385a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.SubtitleModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.SubtitleModel.class;
                        r1 = new com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels$SectionsCanAddDataModel$SectionsCanAddModel$SubtitleModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.SubtitleModel.Serializer.<clinit>():void");
                    }
                }

                public SubtitleModel() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 1;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.SubtitleModel.<init>():void");
                }

                @javax.annotation.Nullable
                public final java.lang.String m2345a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f1596d;
                    r1 = 0;
                    r0 = super.a(r0, r1);
                    r2.f1596d = r0;
                    r0 = r2.f1596d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.SubtitleModel.a():java.lang.String");
                }

                public final int jK_() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = -1919764332; // 0xffffffff8d92b894 float:-9.04238E-31 double:NaN;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.SubtitleModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m2344a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r0.h();
                    r0.i();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.SubtitleModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m2343a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r2.h();
                    r0 = r2.m2345a();
                    r0 = r3.b(r0);
                    r1 = 1;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.SubtitleModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: should_show_beside_title */
            public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f1597d;

                /* compiled from: should_show_beside_title */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.TitleModel.class;
                        r1 = new com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels$SectionsCanAddDataModel$SectionsCanAddModel$TitleModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.TitleModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m2346a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r10 = this;
                        r8 = 1;
                        r6 = 0;
                        r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r4.<init>(r5);
                        r5 = com.facebook.pages.common.editpage.graphql.FetchEditPageQueryParsers.SectionsCanAddDataParser.SectionsCanAddParser.TitleParser.m2386a(r11, r4);
                        r4.d(r5);
                        r4 = r4.e();
                        r5 = java.nio.ByteBuffer.wrap(r4);
                        r4 = 0;
                        r5.position(r4);
                        r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r7 = r6;
                        r9 = r6;
                        r4.<init>(r5, r6, r7, r8, r9);
                        r5 = 4;
                        r6 = java.lang.Boolean.valueOf(r8);
                        r4.a(r5, r6);
                        r2 = r4;
                        r1 = new com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels$SectionsCanAddDataModel$SectionsCanAddModel$TitleModel;
                        r1.<init>();
                        r4 = r2.a;
                        r0 = r4;
                        r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                        r0 = r1;
                        r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                        r0.a(r2, r3, r11);
                        r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                        if (r0 == 0) goto L_0x0048;
                    L_0x0042:
                        r1 = (com.facebook.common.json.Postprocessable) r1;
                        r1 = r1.a();
                    L_0x0048:
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.TitleModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: should_show_beside_title */
                public class Serializer extends JsonSerializer<TitleModel> {
                    public final void m2347a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r7 = this;
                        r8 = (com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.TitleModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m2348a(r0);
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r0 = 0;
                        r1.position(r0);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r4 = 1;
                        r3 = r2;
                        r5 = r2;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r6 = r0.a;
                        r1 = r6;
                        r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                        r8.a(r0, r1);
                    L_0x0035:
                        r0 = r8.w_();
                        r1 = r8.u_();
                        com.facebook.pages.common.editpage.graphql.FetchEditPageQueryParsers.SectionsCanAddDataParser.SectionsCanAddParser.TitleParser.m2387a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.TitleModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.TitleModel.class;
                        r1 = new com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels$SectionsCanAddDataModel$SectionsCanAddModel$TitleModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.TitleModel.Serializer.<clinit>():void");
                    }
                }

                public TitleModel() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 1;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.TitleModel.<init>():void");
                }

                @javax.annotation.Nullable
                public final java.lang.String m2350a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f1597d;
                    r1 = 0;
                    r0 = super.a(r0, r1);
                    r2.f1597d = r0;
                    r0 = r2.f1597d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.TitleModel.a():java.lang.String");
                }

                public final int jK_() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = -1919764332; // 0xffffffff8d92b894 float:-9.04238E-31 double:NaN;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.TitleModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m2349a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r0.h();
                    r0.i();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.TitleModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m2348a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r2.h();
                    r0 = r2.m2350a();
                    r0 = r3.b(r0);
                    r1 = 1;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.TitleModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            @javax.annotation.Nullable
            public final /* synthetic */ com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.NameModel m2356a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m2351j();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.a():com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels$SectionsCanAddDataModel$SectionsCanAddModel$NameModel");
            }

            @javax.annotation.Nullable
            public final /* synthetic */ com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.SubtitleModel m2357b() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m2352k();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.b():com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels$SectionsCanAddDataModel$SectionsCanAddModel$SubtitleModel");
            }

            @javax.annotation.Nullable
            public final /* synthetic */ com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.TitleModel m2359d() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m2353l();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.d():com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels$SectionsCanAddDataModel$SectionsCanAddModel$TitleModel");
            }

            public SectionsCanAddModel() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 4;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.<init>():void");
            }

            @javax.annotation.Nullable
            private com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.NameModel m2351j() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f1598d;
                r1 = 0;
                r2 = com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.NameModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.NameModel) r0;
                r3.f1598d = r0;
                r0 = r3.f1598d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.j():com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels$SectionsCanAddDataModel$SectionsCanAddModel$NameModel");
            }

            @javax.annotation.Nullable
            private com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.SubtitleModel m2352k() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f1599e;
                r1 = 1;
                r2 = com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.SubtitleModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.SubtitleModel) r0;
                r3.f1599e = r0;
                r0 = r3.f1599e;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.k():com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels$SectionsCanAddDataModel$SectionsCanAddModel$SubtitleModel");
            }

            @javax.annotation.Nullable
            public final com.facebook.graphql.enums.GraphQLPagePresenceTabType m2358c() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r4 = this;
                r0 = r4.f1600f;
                r1 = 2;
                r2 = com.facebook.graphql.enums.GraphQLPagePresenceTabType.class;
                r3 = com.facebook.graphql.enums.GraphQLPagePresenceTabType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                r0 = super.b(r0, r1, r2, r3);
                r0 = (com.facebook.graphql.enums.GraphQLPagePresenceTabType) r0;
                r4.f1600f = r0;
                r0 = r4.f1600f;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.c():com.facebook.graphql.enums.GraphQLPagePresenceTabType");
            }

            @javax.annotation.Nullable
            private com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.TitleModel m2353l() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f1601g;
                r1 = 3;
                r2 = com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.TitleModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.TitleModel) r0;
                r3.f1601g = r0;
                r0 = r3.f1601g;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.l():com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels$SectionsCanAddDataModel$SectionsCanAddModel$TitleModel");
            }

            public final int jK_() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = -1024957845; // 0xffffffffc2e8626b float:-116.19222 double:NaN;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m2355a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r1 = 0;
                r3.h();
                r0 = r3.m2351j();
                if (r0 == 0) goto L_0x0022;
            L_0x000a:
                r0 = r3.m2351j();
                r0 = r4.b(r0);
                r0 = (com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.NameModel) r0;
                r2 = r3.m2351j();
                if (r2 == r0) goto L_0x0022;
            L_0x001a:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel) r1;
                r1.f1598d = r0;
            L_0x0022:
                r0 = r3.m2352k();
                if (r0 == 0) goto L_0x0040;
            L_0x0028:
                r0 = r3.m2352k();
                r0 = r4.b(r0);
                r0 = (com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.SubtitleModel) r0;
                r2 = r3.m2352k();
                if (r2 == r0) goto L_0x0040;
            L_0x0038:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel) r1;
                r1.f1599e = r0;
            L_0x0040:
                r0 = r3.m2353l();
                if (r0 == 0) goto L_0x005e;
            L_0x0046:
                r0 = r3.m2353l();
                r0 = r4.b(r0);
                r0 = (com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.TitleModel) r0;
                r2 = r3.m2353l();
                if (r2 == r0) goto L_0x005e;
            L_0x0056:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel) r1;
                r1.f1601g = r0;
            L_0x005e:
                r3.i();
                if (r1 != 0) goto L_0x0064;
            L_0x0063:
                return r3;
            L_0x0064:
                r3 = r1;
                goto L_0x0063;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m2354a(com.facebook.flatbuffers.FlatBufferBuilder r6) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r5 = this;
                r5.h();
                r0 = r5.m2351j();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r6, r0);
                r1 = r5.m2352k();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r6, r1);
                r2 = r5.m2358c();
                r2 = r6.a(r2);
                r3 = r5.m2353l();
                r3 = com.facebook.graphql.modelutil.ModelHelper.a(r6, r3);
                r4 = 4;
                r6.c(r4);
                r4 = 0;
                r6.b(r4, r0);
                r0 = 1;
                r6.b(r0, r1);
                r0 = 2;
                r6.b(r0, r2);
                r0 = 3;
                r6.b(r0, r3);
                r5.i();
                r0 = r6.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        /* compiled from: should_show_beside_title */
        public class Serializer extends JsonSerializer<SectionsCanAddDataModel> {
            public final void m2360a(java.lang.Object r9, com.fasterxml.jackson.core.JsonGenerator r10, com.fasterxml.jackson.databind.SerializerProvider r11) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r8 = this;
                r9 = (com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel) r9;
                r2 = 0;
                r0 = r9.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r9.m2361a(r0);
                r0.d(r1);
                r0 = r0.e();
                r1 = java.nio.ByteBuffer.wrap(r0);
                r0 = 0;
                r1.position(r0);
                r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r4 = 1;
                r3 = r2;
                r5 = r2;
                r0.<init>(r1, r2, r3, r4, r5);
                r6 = r0.a;
                r1 = r6;
                r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                r9.a(r0, r1);
            L_0x0035:
                r0 = r9.w_();
                r1 = r9.u_();
                r10.f();
                r6 = 0;
                r6 = r0.g(r1, r6);
                if (r6 == 0) goto L_0x004f;
            L_0x0047:
                r7 = "sections_can_add";
                r10.a(r7);
                com.facebook.pages.common.editpage.graphql.FetchEditPageQueryParsers.SectionsCanAddDataParser.SectionsCanAddParser.m2389a(r0, r6, r10, r11);
            L_0x004f:
                r10.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
            }

            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.class;
                r1 = new com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels$SectionsCanAddDataModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.Serializer.<clinit>():void");
            }
        }

        public SectionsCanAddDataModel() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = 1;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.<init>():void");
        }

        public final void m2363a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = this;
            r2.a();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
        }

        public final void m2364a(java.lang.String r1, java.lang.Object r2, boolean r3) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.a(java.lang.String, java.lang.Object, boolean):void");
        }

        @javax.annotation.Nonnull
        public final com.google.common.collect.ImmutableList<com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel> mo34g() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f1602d;
            r1 = 0;
            r2 = com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel.class;
            r0 = super.a(r0, r1, r2);
            r3.f1602d = r0;
            r0 = r3.f1602d;
            r0 = (com.google.common.collect.ImmutableList) r0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.g():com.google.common.collect.ImmutableList<com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels$SectionsCanAddDataModel$SectionsCanAddModel>");
        }

        public final int jK_() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = 2479791; // 0x25d6af float:3.474927E-39 double:1.2251795E-317;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m2362a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = 0;
            r2.h();
            r1 = r2.mo34g();
            if (r1 == 0) goto L_0x0020;
        L_0x000a:
            r1 = r2.mo34g();
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            if (r1 == 0) goto L_0x0020;
        L_0x0014:
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
            r0 = (com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel) r0;
            r1 = r1.b();
            r0.f1602d = r1;
        L_0x0020:
            r2.i();
            if (r0 != 0) goto L_0x0026;
        L_0x0025:
            return r2;
        L_0x0026:
            r2 = r0;
            goto L_0x0025;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m2361a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r2.h();
            r0 = r2.mo34g();
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
            r1 = 1;
            r3.c(r1);
            r1 = 0;
            r3.b(r1, r0);
            r2.i();
            r0 = r3.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }
}
