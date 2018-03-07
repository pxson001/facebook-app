package com.facebook.messaging.business.subscription.common.graphql;

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
import com.facebook.messaging.business.subscription.common.graphql.BusinessSubscriptionMutationsParsers.ContentPageSubscribeMutationParser;
import com.facebook.messaging.business.subscription.common.graphql.BusinessSubscriptionMutationsParsers.ContentPageSubscribeMutationParser.PageParser;
import com.facebook.messaging.business.subscription.common.graphql.BusinessSubscriptionMutationsParsers.ContentPageUnsubscribeMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: tracker_type */
public class BusinessSubscriptionMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1112433618)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: tracker_type */
    public final class ContentPageSubscribeMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f1437d;
        @Nullable
        private PageModel f1438e;

        /* compiled from: tracker_type */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ContentPageSubscribeMutationModel.class, new Deserializer());
            }

            public Object m1595a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ContentPageSubscribeMutationParser.m1631a(jsonParser);
                Object contentPageSubscribeMutationModel = new ContentPageSubscribeMutationModel();
                ((BaseModel) contentPageSubscribeMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (contentPageSubscribeMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) contentPageSubscribeMutationModel).a();
                }
                return contentPageSubscribeMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1339061743)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: tracker_type */
        public final class PageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f1435d;
            private boolean f1436e;

            /* compiled from: tracker_type */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                }

                public Object m1596a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageParser.m1629a(jsonParser, flatBufferBuilder));
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

            /* compiled from: tracker_type */
            public class Serializer extends JsonSerializer<PageModel> {
                public final void m1597a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageModel pageModel = (PageModel) obj;
                    if (pageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageModel.m1601a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageParser.m1630a(pageModel.w_(), pageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageModel.class, new Serializer());
                }
            }

            public PageModel() {
                super(2);
            }

            public final void m1605a(String str, ConsistencyTuple consistencyTuple) {
                if ("is_viewer_subscribed_to_messenger_content".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m1600k());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m1606a(String str, Object obj, boolean z) {
                if ("is_viewer_subscribed_to_messenger_content".equals(str)) {
                    m1598a(((Boolean) obj).booleanValue());
                }
            }

            @Nullable
            private String m1599j() {
                this.f1435d = super.a(this.f1435d, 0);
                return this.f1435d;
            }

            private boolean m1600k() {
                a(0, 1);
                return this.f1436e;
            }

            private void m1598a(boolean z) {
                this.f1436e = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, z);
                }
            }

            @Nullable
            public final String m1603a() {
                return m1599j();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m1602a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1601a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1599j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f1436e);
                i();
                return flatBufferBuilder.d();
            }

            public final void m1604a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1436e = mutableFlatBuffer.a(i, 1);
            }
        }

        /* compiled from: tracker_type */
        public class Serializer extends JsonSerializer<ContentPageSubscribeMutationModel> {
            public final void m1607a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ContentPageSubscribeMutationModel contentPageSubscribeMutationModel = (ContentPageSubscribeMutationModel) obj;
                if (contentPageSubscribeMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(contentPageSubscribeMutationModel.m1610a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    contentPageSubscribeMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = contentPageSubscribeMutationModel.w_();
                int u_ = contentPageSubscribeMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("page");
                    PageParser.m1630a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ContentPageSubscribeMutationModel.class, new Serializer());
            }
        }

        public ContentPageSubscribeMutationModel() {
            super(2);
        }

        @Nullable
        private String m1608a() {
            this.f1437d = super.a(this.f1437d, 0);
            return this.f1437d;
        }

        @Nullable
        private PageModel m1609j() {
            this.f1438e = (PageModel) super.a(this.f1438e, 1, PageModel.class);
            return this.f1438e;
        }

        public final int jK_() {
            return 2029054520;
        }

        public final GraphQLVisitableModel m1611a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1609j() != null) {
                PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m1609j());
                if (m1609j() != pageModel) {
                    graphQLVisitableModel = (ContentPageSubscribeMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1438e = pageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1610a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m1608a());
            int a = ModelHelper.a(flatBufferBuilder, m1609j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1159264202)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: tracker_type */
    public final class ContentPageUnsubscribeMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f1441d;
        @Nullable
        private PageModel f1442e;

        /* compiled from: tracker_type */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ContentPageUnsubscribeMutationModel.class, new Deserializer());
            }

            public Object m1612a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ContentPageUnsubscribeMutationParser.m1634a(jsonParser);
                Object contentPageUnsubscribeMutationModel = new ContentPageUnsubscribeMutationModel();
                ((BaseModel) contentPageUnsubscribeMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (contentPageUnsubscribeMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) contentPageUnsubscribeMutationModel).a();
                }
                return contentPageUnsubscribeMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1339061743)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: tracker_type */
        public final class PageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f1439d;
            private boolean f1440e;

            /* compiled from: tracker_type */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                }

                public Object m1613a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ContentPageUnsubscribeMutationParser.PageParser.m1632a(jsonParser, flatBufferBuilder));
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

            /* compiled from: tracker_type */
            public class Serializer extends JsonSerializer<PageModel> {
                public final void m1614a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageModel pageModel = (PageModel) obj;
                    if (pageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageModel.m1618a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ContentPageUnsubscribeMutationParser.PageParser.m1633a(pageModel.w_(), pageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageModel.class, new Serializer());
                }
            }

            public PageModel() {
                super(2);
            }

            public final void m1622a(String str, ConsistencyTuple consistencyTuple) {
                if ("is_viewer_subscribed_to_messenger_content".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m1617k());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m1623a(String str, Object obj, boolean z) {
                if ("is_viewer_subscribed_to_messenger_content".equals(str)) {
                    m1615a(((Boolean) obj).booleanValue());
                }
            }

            @Nullable
            private String m1616j() {
                this.f1439d = super.a(this.f1439d, 0);
                return this.f1439d;
            }

            private boolean m1617k() {
                a(0, 1);
                return this.f1440e;
            }

            private void m1615a(boolean z) {
                this.f1440e = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, z);
                }
            }

            @Nullable
            public final String m1620a() {
                return m1616j();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m1619a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1618a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1616j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f1440e);
                i();
                return flatBufferBuilder.d();
            }

            public final void m1621a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1440e = mutableFlatBuffer.a(i, 1);
            }
        }

        /* compiled from: tracker_type */
        public class Serializer extends JsonSerializer<ContentPageUnsubscribeMutationModel> {
            public final void m1624a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ContentPageUnsubscribeMutationModel contentPageUnsubscribeMutationModel = (ContentPageUnsubscribeMutationModel) obj;
                if (contentPageUnsubscribeMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(contentPageUnsubscribeMutationModel.m1627a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    contentPageUnsubscribeMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = contentPageUnsubscribeMutationModel.w_();
                int u_ = contentPageUnsubscribeMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("page");
                    ContentPageUnsubscribeMutationParser.PageParser.m1633a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ContentPageUnsubscribeMutationModel.class, new Serializer());
            }
        }

        public ContentPageUnsubscribeMutationModel() {
            super(2);
        }

        @Nullable
        private String m1625a() {
            this.f1441d = super.a(this.f1441d, 0);
            return this.f1441d;
        }

        @Nullable
        private PageModel m1626j() {
            this.f1442e = (PageModel) super.a(this.f1442e, 1, PageModel.class);
            return this.f1442e;
        }

        public final int jK_() {
            return -478176111;
        }

        public final GraphQLVisitableModel m1628a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1626j() != null) {
                PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m1626j());
                if (m1626j() != pageModel) {
                    graphQLVisitableModel = (ContentPageUnsubscribeMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1442e = pageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1627a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m1625a());
            int a = ModelHelper.a(flatBufferBuilder, m1626j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
