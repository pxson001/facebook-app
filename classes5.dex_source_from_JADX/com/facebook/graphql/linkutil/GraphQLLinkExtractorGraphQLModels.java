package com.facebook.graphql.linkutil;

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
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.GetEntityFbLinkGraphQL;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.GetEntityFbLinkGraphQL.Page;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.GetRedirectionLinkGraphQL;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.LinkableTextWithEntities;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.LinkableTextWithEntitiesRange;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLParsers.GetEntityFbLinkGraphQLParser;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLParsers.GetEntityFbLinkGraphQLParser.PageParser;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLParsers.GetRedirectionLinkGraphQLParser;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLParsers.GetRedirectionLinkGraphQLParser.RedirectionInfoParser;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLParsers.LinkableTextWithEntitiesParser;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLParsers.LinkableTextWithEntitiesRangeParser;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
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

/* compiled from: WWW_ACTIVATE */
public class GraphQLLinkExtractorGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -145985307)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: WWW_ACTIVATE */
    public final class GetEntityFbLinkGraphQLModel extends BaseModel implements GetEntityFbLinkGraphQL, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f12369d;
        @Nullable
        private String f12370e;
        @Nullable
        private String f12371f;
        @Nullable
        private PageModel f12372g;
        @Nullable
        private List<RedirectionInfoModel> f12373h;
        @Nullable
        private String f12374i;
        @Nullable
        private String f12375j;

        /* compiled from: WWW_ACTIVATE */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f12360a;
            @Nullable
            public String f12361b;
            @Nullable
            public String f12362c;
            @Nullable
            public PageModel f12363d;
            @Nullable
            public ImmutableList<RedirectionInfoModel> f12364e;
            @Nullable
            public String f12365f;
            @Nullable
            public String f12366g;

            public final GetEntityFbLinkGraphQLModel m20438a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f12360a);
                int b = flatBufferBuilder.b(this.f12361b);
                int b2 = flatBufferBuilder.b(this.f12362c);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f12363d);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f12364e);
                int b3 = flatBufferBuilder.b(this.f12365f);
                int b4 = flatBufferBuilder.b(this.f12366g);
                flatBufferBuilder.c(7);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.b(5, b3);
                flatBufferBuilder.b(6, b4);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new GetEntityFbLinkGraphQLModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: WWW_ACTIVATE */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GetEntityFbLinkGraphQLModel.class, new Deserializer());
            }

            public Object m20439a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GetEntityFbLinkGraphQLParser.m20524a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object getEntityFbLinkGraphQLModel = new GetEntityFbLinkGraphQLModel();
                ((BaseModel) getEntityFbLinkGraphQLModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (getEntityFbLinkGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) getEntityFbLinkGraphQLModel).a();
                }
                return getEntityFbLinkGraphQLModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: WWW_ACTIVATE */
        public final class PageModel extends BaseModel implements Page, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f12368d;

            /* compiled from: WWW_ACTIVATE */
            public final class Builder {
                @Nullable
                public String f12367a;
            }

            /* compiled from: WWW_ACTIVATE */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                }

                public Object m20440a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageParser.m20522a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageModel = new PageModel();
                    ((BaseModel) pageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageModel instanceof Postprocessable) {
                        return ((Postprocessable) pageModel).a();
                    }
                    return pageModel;
                }
            }

            /* compiled from: WWW_ACTIVATE */
            public class Serializer extends JsonSerializer<PageModel> {
                public final void m20441a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageModel pageModel = (PageModel) obj;
                    if (pageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageModel.m20443a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageParser.m20523a(pageModel.w_(), pageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageModel.class, new Serializer());
                }
            }

            public PageModel() {
                super(1);
            }

            public PageModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m20446a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m20447a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m20448d() {
                this.f12368d = super.a(this.f12368d, 0);
                return this.f12368d;
            }

            public static PageModel m20442a(Page page) {
                if (page == null) {
                    return null;
                }
                if (page instanceof PageModel) {
                    return (PageModel) page;
                }
                Builder builder = new Builder();
                builder.f12367a = page.d();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f12367a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PageModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m20445a() {
                return m20448d();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m20444a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m20443a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m20448d());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: WWW_ACTIVATE */
        public class Serializer extends JsonSerializer<GetEntityFbLinkGraphQLModel> {
            public final void m20449a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GetEntityFbLinkGraphQLModel getEntityFbLinkGraphQLModel = (GetEntityFbLinkGraphQLModel) obj;
                if (getEntityFbLinkGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(getEntityFbLinkGraphQLModel.m20452a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    getEntityFbLinkGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GetEntityFbLinkGraphQLParser.m20525a(getEntityFbLinkGraphQLModel.w_(), getEntityFbLinkGraphQLModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(GetEntityFbLinkGraphQLModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ Page m20460j() {
            return m20451l();
        }

        public GetEntityFbLinkGraphQLModel() {
            super(7);
        }

        public GetEntityFbLinkGraphQLModel(MutableFlatBuffer mutableFlatBuffer) {
            super(7);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m20455a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20456a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final GraphQLObjectType m20457b() {
            if (this.b != null && this.f12369d == null) {
                this.f12369d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f12369d;
        }

        @Nullable
        public final String m20458d() {
            this.f12370e = super.a(this.f12370e, 1);
            return this.f12370e;
        }

        @Nullable
        public final String C_() {
            this.f12371f = super.a(this.f12371f, 2);
            return this.f12371f;
        }

        @Nullable
        private PageModel m20451l() {
            this.f12372g = (PageModel) super.a(this.f12372g, 3, PageModel.class);
            return this.f12372g;
        }

        @Nonnull
        public final ImmutableList<RedirectionInfoModel> m20461k() {
            this.f12373h = super.a(this.f12373h, 4, RedirectionInfoModel.class);
            return (ImmutableList) this.f12373h;
        }

        @Nullable
        public final String m20459g() {
            this.f12374i = super.a(this.f12374i, 5);
            return this.f12374i;
        }

        @Nullable
        public final String D_() {
            this.f12375j = super.a(this.f12375j, 6);
            return this.f12375j;
        }

        public static GetEntityFbLinkGraphQLModel m20450a(GetEntityFbLinkGraphQL getEntityFbLinkGraphQL) {
            if (getEntityFbLinkGraphQL == null) {
                return null;
            }
            if (getEntityFbLinkGraphQL instanceof GetEntityFbLinkGraphQLModel) {
                return (GetEntityFbLinkGraphQLModel) getEntityFbLinkGraphQL;
            }
            Builder builder = new Builder();
            builder.f12360a = getEntityFbLinkGraphQL.b();
            builder.f12361b = getEntityFbLinkGraphQL.d();
            builder.f12362c = getEntityFbLinkGraphQL.C_();
            builder.f12363d = PageModel.m20442a(getEntityFbLinkGraphQL.j());
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < getEntityFbLinkGraphQL.k().size(); i++) {
                builder2.c(RedirectionInfoModel.a((RedirectionInfoModel) getEntityFbLinkGraphQL.k().get(i)));
            }
            builder.f12364e = builder2.b();
            builder.f12365f = getEntityFbLinkGraphQL.g();
            builder.f12366g = getEntityFbLinkGraphQL.D_();
            return builder.m20438a();
        }

        @Nullable
        public final String m20454a() {
            return m20458d();
        }

        public final int jK_() {
            return 2080559107;
        }

        public final GraphQLVisitableModel m20453a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20451l() != null) {
                PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m20451l());
                if (m20451l() != pageModel) {
                    graphQLVisitableModel = (GetEntityFbLinkGraphQLModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12372g = pageModel;
                }
            }
            if (m20461k() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m20461k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    GetEntityFbLinkGraphQLModel getEntityFbLinkGraphQLModel = (GetEntityFbLinkGraphQLModel) ModelHelper.a(graphQLVisitableModel, this);
                    getEntityFbLinkGraphQLModel.f12373h = a.b();
                    graphQLVisitableModel = getEntityFbLinkGraphQLModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20452a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20457b());
            int b = flatBufferBuilder.b(m20458d());
            int b2 = flatBufferBuilder.b(C_());
            int a2 = ModelHelper.a(flatBufferBuilder, m20451l());
            int a3 = ModelHelper.a(flatBufferBuilder, m20461k());
            int b3 = flatBufferBuilder.b(m20459g());
            int b4 = flatBufferBuilder.b(D_());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, b3);
            flatBufferBuilder.b(6, b4);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1156694901)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: WWW_ACTIVATE */
    public final class GetRedirectionLinkGraphQLModel extends BaseModel implements GetRedirectionLinkGraphQL, GraphQLVisitableConsistentModel {
        @Nullable
        private List<RedirectionInfoModel> f12381d;

        /* compiled from: WWW_ACTIVATE */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GetRedirectionLinkGraphQLModel.class, new Deserializer());
            }

            public Object m20496a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GetRedirectionLinkGraphQLParser.m20539a(jsonParser);
                Object getRedirectionLinkGraphQLModel = new GetRedirectionLinkGraphQLModel();
                ((BaseModel) getRedirectionLinkGraphQLModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (getRedirectionLinkGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) getRedirectionLinkGraphQLModel).a();
                }
                return getRedirectionLinkGraphQLModel;
            }
        }

        /* compiled from: WWW_ACTIVATE */
        public class Serializer extends JsonSerializer<GetRedirectionLinkGraphQLModel> {
            public final void m20499a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GetRedirectionLinkGraphQLModel getRedirectionLinkGraphQLModel = (GetRedirectionLinkGraphQLModel) obj;
                if (getRedirectionLinkGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(getRedirectionLinkGraphQLModel.m20500a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    getRedirectionLinkGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = getRedirectionLinkGraphQLModel.w_();
                int u_ = getRedirectionLinkGraphQLModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("redirection_info");
                    RedirectionInfoParser.m20537a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GetRedirectionLinkGraphQLModel.class, new Serializer());
            }
        }

        public GetRedirectionLinkGraphQLModel() {
            super(1);
        }

        public final void m20502a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20503a(String str, Object obj, boolean z) {
        }

        @Nonnull
        public final ImmutableList<RedirectionInfoModel> m20504k() {
            this.f12381d = super.a(this.f12381d, 0, RedirectionInfoModel.class);
            return (ImmutableList) this.f12381d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m20501a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20504k() != null) {
                Builder a = ModelHelper.a(m20504k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (GetRedirectionLinkGraphQLModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12381d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20500a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20504k());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -213208375)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: WWW_ACTIVATE */
    public final class LinkableTextWithEntitiesModel extends BaseModel implements LinkableTextWithEntities, GraphQLVisitableModel {
        @Nullable
        private List<LinkableTextWithEntitiesRangeModel> f12384d;
        @Nullable
        private String f12385e;

        /* compiled from: WWW_ACTIVATE */
        public final class Builder {
            @Nullable
            public ImmutableList<LinkableTextWithEntitiesRangeModel> f12382a;
            @Nullable
            public String f12383b;
        }

        /* compiled from: WWW_ACTIVATE */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LinkableTextWithEntitiesModel.class, new Deserializer());
            }

            public Object m20505a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LinkableTextWithEntitiesParser.m20540a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object linkableTextWithEntitiesModel = new LinkableTextWithEntitiesModel();
                ((BaseModel) linkableTextWithEntitiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (linkableTextWithEntitiesModel instanceof Postprocessable) {
                    return ((Postprocessable) linkableTextWithEntitiesModel).a();
                }
                return linkableTextWithEntitiesModel;
            }
        }

        /* compiled from: WWW_ACTIVATE */
        public class Serializer extends JsonSerializer<LinkableTextWithEntitiesModel> {
            public final void m20506a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                LinkableTextWithEntitiesModel linkableTextWithEntitiesModel = (LinkableTextWithEntitiesModel) obj;
                if (linkableTextWithEntitiesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(linkableTextWithEntitiesModel.m20508a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    linkableTextWithEntitiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                LinkableTextWithEntitiesParser.m20541a(linkableTextWithEntitiesModel.w_(), linkableTextWithEntitiesModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(LinkableTextWithEntitiesModel.class, new Serializer());
            }
        }

        public LinkableTextWithEntitiesModel() {
            super(2);
        }

        public LinkableTextWithEntitiesModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nonnull
        public final ImmutableList<LinkableTextWithEntitiesRangeModel> mo1228b() {
            this.f12384d = super.a(this.f12384d, 0, LinkableTextWithEntitiesRangeModel.class);
            return (ImmutableList) this.f12384d;
        }

        @Nullable
        public final String mo1227a() {
            this.f12385e = super.a(this.f12385e, 1);
            return this.f12385e;
        }

        public static LinkableTextWithEntitiesModel m20507a(LinkableTextWithEntities linkableTextWithEntities) {
            if (linkableTextWithEntities == null) {
                return null;
            }
            if (linkableTextWithEntities instanceof LinkableTextWithEntitiesModel) {
                return (LinkableTextWithEntitiesModel) linkableTextWithEntities;
            }
            Builder builder = new Builder();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < linkableTextWithEntities.mo1228b().size(); i++) {
                builder2.c(LinkableTextWithEntitiesRangeModel.m20514a((LinkableTextWithEntitiesRange) linkableTextWithEntities.mo1228b().get(i)));
            }
            builder.f12382a = builder2.b();
            builder.f12383b = linkableTextWithEntities.mo1227a();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f12382a);
            int b = flatBufferBuilder.b(builder.f12383b);
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new LinkableTextWithEntitiesModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return -1919764332;
        }

        public final GraphQLVisitableModel m20509a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (mo1228b() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(mo1228b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (LinkableTextWithEntitiesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12384d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20508a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, mo1228b());
            int b = flatBufferBuilder.b(mo1227a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1852213855)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: WWW_ACTIVATE */
    public final class LinkableTextWithEntitiesRangeModel extends BaseModel implements LinkableTextWithEntitiesRange, GraphQLVisitableModel {
        @Nullable
        private GetEntityFbLinkGraphQLModel f12389d;
        private int f12390e;
        private int f12391f;

        /* compiled from: WWW_ACTIVATE */
        public final class Builder {
            @Nullable
            public GetEntityFbLinkGraphQLModel f12386a;
            public int f12387b;
            public int f12388c;
        }

        /* compiled from: WWW_ACTIVATE */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LinkableTextWithEntitiesRangeModel.class, new Deserializer());
            }

            public Object m20512a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LinkableTextWithEntitiesRangeParser.m20544b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object linkableTextWithEntitiesRangeModel = new LinkableTextWithEntitiesRangeModel();
                ((BaseModel) linkableTextWithEntitiesRangeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (linkableTextWithEntitiesRangeModel instanceof Postprocessable) {
                    return ((Postprocessable) linkableTextWithEntitiesRangeModel).a();
                }
                return linkableTextWithEntitiesRangeModel;
            }
        }

        /* compiled from: WWW_ACTIVATE */
        public class Serializer extends JsonSerializer<LinkableTextWithEntitiesRangeModel> {
            public final void m20513a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                LinkableTextWithEntitiesRangeModel linkableTextWithEntitiesRangeModel = (LinkableTextWithEntitiesRangeModel) obj;
                if (linkableTextWithEntitiesRangeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(linkableTextWithEntitiesRangeModel.m20516a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    linkableTextWithEntitiesRangeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                LinkableTextWithEntitiesRangeParser.m20545b(linkableTextWithEntitiesRangeModel.w_(), linkableTextWithEntitiesRangeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(LinkableTextWithEntitiesRangeModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ GetEntityFbLinkGraphQL mo1229a() {
            return m20515j();
        }

        public LinkableTextWithEntitiesRangeModel() {
            super(3);
        }

        public LinkableTextWithEntitiesRangeModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private GetEntityFbLinkGraphQLModel m20515j() {
            this.f12389d = (GetEntityFbLinkGraphQLModel) super.a(this.f12389d, 0, GetEntityFbLinkGraphQLModel.class);
            return this.f12389d;
        }

        public final int mo1230b() {
            a(0, 1);
            return this.f12390e;
        }

        public final int mo1231c() {
            a(0, 2);
            return this.f12391f;
        }

        public static LinkableTextWithEntitiesRangeModel m20514a(LinkableTextWithEntitiesRange linkableTextWithEntitiesRange) {
            if (linkableTextWithEntitiesRange == null) {
                return null;
            }
            if (linkableTextWithEntitiesRange instanceof LinkableTextWithEntitiesRangeModel) {
                return (LinkableTextWithEntitiesRangeModel) linkableTextWithEntitiesRange;
            }
            Builder builder = new Builder();
            builder.f12386a = GetEntityFbLinkGraphQLModel.m20450a(linkableTextWithEntitiesRange.mo1229a());
            builder.f12387b = linkableTextWithEntitiesRange.mo1230b();
            builder.f12388c = linkableTextWithEntitiesRange.mo1231c();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f12386a);
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, builder.f12387b, 0);
            flatBufferBuilder.a(2, builder.f12388c, 0);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new LinkableTextWithEntitiesRangeModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return -1024511161;
        }

        public final GraphQLVisitableModel m20518a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20515j() != null) {
                GetEntityFbLinkGraphQLModel getEntityFbLinkGraphQLModel = (GetEntityFbLinkGraphQLModel) graphQLModelMutatingVisitor.b(m20515j());
                if (m20515j() != getEntityFbLinkGraphQLModel) {
                    graphQLVisitableModel = (LinkableTextWithEntitiesRangeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12389d = getEntityFbLinkGraphQLModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20516a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20515j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f12390e, 0);
            flatBufferBuilder.a(2, this.f12391f, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m20519a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f12390e = mutableFlatBuffer.a(i, 1, 0);
            this.f12391f = mutableFlatBuffer.a(i, 2, 0);
        }
    }
}
