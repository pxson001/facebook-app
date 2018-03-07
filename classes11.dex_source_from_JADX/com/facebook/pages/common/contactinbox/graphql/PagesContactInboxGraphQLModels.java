package com.facebook.pages.common.contactinbox.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLPageLeadGenInfoState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLParsers.PageContactUsLeadFieldsParser;
import com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLParsers.PageContactUsLeadFieldsParser.PhoneNumberParser;
import com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLParsers.PagesContactInboxGraphQLParser;
import com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLParsers.PagesContactInboxGraphQLParser.AdminInfoParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: state_item_list */
public class PagesContactInboxGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1091049493)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: state_item_list */
    public final class PageContactUsLeadFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f1430d;
        private long f1431e;
        @Nullable
        private String f1432f;
        private long f1433g;
        @Nullable
        private String f1434h;
        @Nullable
        private String f1435i;
        @Nullable
        private GraphQLPageLeadGenInfoState f1436j;
        @Nullable
        private PhoneNumberModel f1437k;
        @Nullable
        private String f1438l;

        /* compiled from: state_item_list */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageContactUsLeadFieldsModel.class, new Deserializer());
            }

            public Object m2053a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PageContactUsLeadFieldsParser.m2102b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pageContactUsLeadFieldsModel = new PageContactUsLeadFieldsModel();
                ((BaseModel) pageContactUsLeadFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pageContactUsLeadFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) pageContactUsLeadFieldsModel).a();
                }
                return pageContactUsLeadFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 44074500)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: state_item_list */
        public final class PhoneNumberModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f1428d;
            @Nullable
            private String f1429e;

            /* compiled from: state_item_list */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhoneNumberModel.class, new Deserializer());
                }

                public Object m2054a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhoneNumberParser.m2100a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object phoneNumberModel = new PhoneNumberModel();
                    ((BaseModel) phoneNumberModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (phoneNumberModel instanceof Postprocessable) {
                        return ((Postprocessable) phoneNumberModel).a();
                    }
                    return phoneNumberModel;
                }
            }

            /* compiled from: state_item_list */
            public class Serializer extends JsonSerializer<PhoneNumberModel> {
                public final void m2055a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhoneNumberModel phoneNumberModel = (PhoneNumberModel) obj;
                    if (phoneNumberModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(phoneNumberModel.m2056a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        phoneNumberModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhoneNumberParser.m2101a(phoneNumberModel.w_(), phoneNumberModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PhoneNumberModel.class, new Serializer());
                }
            }

            public PhoneNumberModel() {
                super(2);
            }

            @Nullable
            public final String m2058a() {
                this.f1428d = super.a(this.f1428d, 0);
                return this.f1428d;
            }

            @Nullable
            public final String m2059j() {
                this.f1429e = super.a(this.f1429e, 1);
                return this.f1429e;
            }

            public final int jK_() {
                return 474898999;
            }

            public final GraphQLVisitableModel m2057a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2056a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2058a());
                int b2 = flatBufferBuilder.b(m2059j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: state_item_list */
        public class Serializer extends JsonSerializer<PageContactUsLeadFieldsModel> {
            public final void m2060a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PageContactUsLeadFieldsModel pageContactUsLeadFieldsModel = (PageContactUsLeadFieldsModel) obj;
                if (pageContactUsLeadFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageContactUsLeadFieldsModel.m2061a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageContactUsLeadFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PageContactUsLeadFieldsParser.m2103b(pageContactUsLeadFieldsModel.w_(), pageContactUsLeadFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PageContactUsLeadFieldsModel.class, new Serializer());
            }
        }

        public PageContactUsLeadFieldsModel() {
            super(9);
        }

        @Nullable
        public final String m2065j() {
            this.f1430d = super.a(this.f1430d, 0);
            return this.f1430d;
        }

        public final long m2066k() {
            a(0, 1);
            return this.f1431e;
        }

        @Nullable
        public final String m2067l() {
            this.f1432f = super.a(this.f1432f, 2);
            return this.f1432f;
        }

        public final long m2068m() {
            a(0, 3);
            return this.f1433g;
        }

        @Nullable
        public final String m2069n() {
            this.f1434h = super.a(this.f1434h, 4);
            return this.f1434h;
        }

        @Nullable
        public final String m2070o() {
            this.f1435i = super.a(this.f1435i, 5);
            return this.f1435i;
        }

        @Nullable
        public final GraphQLPageLeadGenInfoState m2071p() {
            this.f1436j = (GraphQLPageLeadGenInfoState) super.b(this.f1436j, 6, GraphQLPageLeadGenInfoState.class, GraphQLPageLeadGenInfoState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f1436j;
        }

        @Nullable
        public final PhoneNumberModel m2072q() {
            this.f1437k = (PhoneNumberModel) super.a(this.f1437k, 7, PhoneNumberModel.class);
            return this.f1437k;
        }

        @Nullable
        public final String m2073r() {
            this.f1438l = super.a(this.f1438l, 8);
            return this.f1438l;
        }

        @Nullable
        public final String m2063a() {
            return m2070o();
        }

        public final int jK_() {
            return 1222248683;
        }

        public final GraphQLVisitableModel m2062a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2072q() != null) {
                PhoneNumberModel phoneNumberModel = (PhoneNumberModel) graphQLModelMutatingVisitor.b(m2072q());
                if (m2072q() != phoneNumberModel) {
                    graphQLVisitableModel = (PageContactUsLeadFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1437k = phoneNumberModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2061a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2065j());
            int b2 = flatBufferBuilder.b(m2067l());
            int b3 = flatBufferBuilder.b(m2069n());
            int b4 = flatBufferBuilder.b(m2070o());
            int a = flatBufferBuilder.a(m2071p());
            int a2 = ModelHelper.a(flatBufferBuilder, m2072q());
            int b5 = flatBufferBuilder.b(m2073r());
            flatBufferBuilder.c(9);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f1431e, 0);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.a(3, this.f1433g, 0);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.b(5, b4);
            flatBufferBuilder.b(6, a);
            flatBufferBuilder.b(7, a2);
            flatBufferBuilder.b(8, b5);
            i();
            return flatBufferBuilder.d();
        }

        public final void m2064a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1431e = mutableFlatBuffer.a(i, 1, 0);
            this.f1433g = mutableFlatBuffer.a(i, 3, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 557637742)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: state_item_list */
    public final class PagesContactInboxGraphQLModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private AdminInfoModel f1444d;
        @Nullable
        private String f1445e;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1218249207)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: state_item_list */
        public final class AdminInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PageContactUsLeadsModel f1443d;

            /* compiled from: state_item_list */
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
                    r0 = com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.class;
                    r1 = new com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels$PagesContactInboxGraphQLModel$AdminInfoModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m2074a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLParsers.PagesContactInboxGraphQLParser.AdminInfoParser.m2108a(r11, r4);
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
                    r1 = new com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels$PagesContactInboxGraphQLModel$AdminInfoModel;
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 599696939)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: state_item_list */
            public final class PageContactUsLeadsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<PageContactUsLeadFieldsModel> f1441d;
                @Nullable
                private PageInfoModel f1442e;

                /* compiled from: state_item_list */
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
                        r0 = com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.class;
                        r1 = new com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels$PagesContactInboxGraphQLModel$AdminInfoModel$PageContactUsLeadsModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m2075a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                        r10 = this;
                        r8 = 1;
                        r6 = 0;
                        r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r4.<init>(r5);
                        r5 = com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLParsers.PagesContactInboxGraphQLParser.AdminInfoParser.PageContactUsLeadsParser.m2106a(r11, r4);
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
                        r1 = new com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels$PagesContactInboxGraphQLModel$AdminInfoModel$PageContactUsLeadsModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -2005169142)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: state_item_list */
                public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f1439d;
                    private boolean f1440e;

                    /* compiled from: state_item_list */
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
                            r0 = com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.PageInfoModel.class;
                            r1 = new com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels$PagesContactInboxGraphQLModel$AdminInfoModel$PageContactUsLeadsModel$PageInfoModel$Deserializer;
                            r1.<init>();
                            com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.PageInfoModel.Deserializer.<clinit>():void");
                        }

                        public java.lang.Object m2076a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                            r5 = com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLParsers.PagesContactInboxGraphQLParser.AdminInfoParser.PageContactUsLeadsParser.PageInfoParser.m2104a(r11, r4);
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
                            r1 = new com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels$PagesContactInboxGraphQLModel$AdminInfoModel$PageContactUsLeadsModel$PageInfoModel;
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.PageInfoModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                        }
                    }

                    /* compiled from: state_item_list */
                    public class Serializer extends JsonSerializer<PageInfoModel> {
                        public final void m2077a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                            r8 = (com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.PageInfoModel) r8;
                            r2 = 0;
                            r0 = r8.w_();
                            if (r0 != 0) goto L_0x0035;
                        L_0x0009:
                            r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r0.<init>(r1);
                            r1 = r8.m2078a(r0);
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
                            com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLParsers.PagesContactInboxGraphQLParser.AdminInfoParser.PageContactUsLeadsParser.PageInfoParser.m2105a(r0, r1, r9);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.PageInfoModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                            r0 = com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.PageInfoModel.class;
                            r1 = new com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels$PagesContactInboxGraphQLModel$AdminInfoModel$PageContactUsLeadsModel$PageInfoModel$Serializer;
                            r1.<init>();
                            com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.PageInfoModel.Serializer.<clinit>():void");
                        }
                    }

                    public PageInfoModel() {
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
                        r0 = 2;
                        r1.<init>(r0);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.PageInfoModel.<init>():void");
                    }

                    @javax.annotation.Nullable
                    public final java.lang.String m2080a() {
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
                        r0 = r2.f1439d;
                        r1 = 0;
                        r0 = super.a(r0, r1);
                        r2.f1439d = r0;
                        r0 = r2.f1439d;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.PageInfoModel.a():java.lang.String");
                    }

                    public final boolean m2082j() {
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
                        r0 = 0;
                        r1 = 1;
                        r2.a(r0, r1);
                        r0 = r2.f1440e;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.PageInfoModel.j():boolean");
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
                        r0 = 923779069; // 0x370fbffd float:8.568165E-6 double:4.564075023E-315;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.PageInfoModel.jK_():int");
                    }

                    public final com.facebook.graphql.visitor.GraphQLVisitableModel m2079a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.PageInfoModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                    }

                    public final int m2078a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                        r0 = r2.m2080a();
                        r0 = r3.b(r0);
                        r1 = 2;
                        r3.c(r1);
                        r1 = 0;
                        r3.b(r1, r0);
                        r0 = 1;
                        r1 = r2.f1440e;
                        r3.a(r0, r1);
                        r2.i();
                        r0 = r3.d();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.PageInfoModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                    }

                    public final void m2081a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
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
                        super.a(r2, r3, r4);
                        r0 = 1;
                        r0 = r2.a(r3, r0);
                        r1.f1440e = r0;
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.PageInfoModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                    }
                }

                /* compiled from: state_item_list */
                public class Serializer extends JsonSerializer<PageContactUsLeadsModel> {
                    public final void m2083a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                        r7 = this;
                        r8 = (com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m2084a(r0);
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
                        com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLParsers.PagesContactInboxGraphQLParser.AdminInfoParser.PageContactUsLeadsParser.m2107a(r0, r1, r9, r10);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.class;
                        r1 = new com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels$PagesContactInboxGraphQLModel$AdminInfoModel$PageContactUsLeadsModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.Serializer.<clinit>():void");
                    }
                }

                public PageContactUsLeadsModel() {
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
                    r0 = 2;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.<init>():void");
                }

                @javax.annotation.Nonnull
                public final com.google.common.collect.ImmutableList<com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PageContactUsLeadFieldsModel> m2086a() {
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
                    r0 = r3.f1441d;
                    r1 = 0;
                    r2 = com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PageContactUsLeadFieldsModel.class;
                    r0 = super.a(r0, r1, r2);
                    r3.f1441d = r0;
                    r0 = r3.f1441d;
                    r0 = (com.google.common.collect.ImmutableList) r0;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.a():com.google.common.collect.ImmutableList<com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels$PageContactUsLeadFieldsModel>");
                }

                @javax.annotation.Nullable
                public final com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.PageInfoModel m2087j() {
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
                    r0 = r3.f1442e;
                    r1 = 1;
                    r2 = com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.PageInfoModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.PageInfoModel) r0;
                    r3.f1442e = r0;
                    r0 = r3.f1442e;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.j():com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels$PagesContactInboxGraphQLModel$AdminInfoModel$PageContactUsLeadsModel$PageInfoModel");
                }

                public final int jK_() {
                    return 1400270310;
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m2085a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
                    r0 = 0;
                    r3.h();
                    r1 = r3.m2086a();
                    if (r1 == 0) goto L_0x0047;
                L_0x000a:
                    r1 = r3.m2086a();
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r4);
                    if (r1 == 0) goto L_0x0047;
                L_0x0014:
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r3);
                    r0 = (com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel) r0;
                    r1 = r1.b();
                    r0.f1441d = r1;
                    r1 = r0;
                L_0x0021:
                    r0 = r3.m2087j();
                    if (r0 == 0) goto L_0x003f;
                L_0x0027:
                    r0 = r3.m2087j();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.PageInfoModel) r0;
                    r2 = r3.m2087j();
                    if (r2 == r0) goto L_0x003f;
                L_0x0037:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel) r1;
                    r1.f1442e = r0;
                L_0x003f:
                    r3.i();
                    if (r1 != 0) goto L_0x0045;
                L_0x0044:
                    return r3;
                L_0x0045:
                    r3 = r1;
                    goto L_0x0044;
                L_0x0047:
                    r1 = r0;
                    goto L_0x0021;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m2084a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
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
                    r3.h();
                    r0 = r3.m2086a();
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r0);
                    r1 = r3.m2087j();
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r1);
                    r2 = 2;
                    r4.c(r2);
                    r2 = 0;
                    r4.b(r2, r0);
                    r0 = 1;
                    r4.b(r0, r1);
                    r3.i();
                    r0 = r4.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: state_item_list */
            public class Serializer extends JsonSerializer<AdminInfoModel> {
                public final void m2088a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AdminInfoModel adminInfoModel = (AdminInfoModel) r8;
                    if (adminInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(adminInfoModel.m2089a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        adminInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AdminInfoParser.m2109a(adminInfoModel.w_(), adminInfoModel.u_(), r9, r10);
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
                    r0 = com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.class;
                    r1 = new com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels$PagesContactInboxGraphQLModel$AdminInfoModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.Serializer.<clinit>():void");
                }
            }

            public AdminInfoModel() {
                super(1);
            }

            @Nullable
            public final PageContactUsLeadsModel m2091a() {
                this.f1443d = (PageContactUsLeadsModel) super.a(this.f1443d, 0, PageContactUsLeadsModel.class);
                return this.f1443d;
            }

            public final int jK_() {
                return 888797870;
            }

            public final GraphQLVisitableModel m2090a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2091a() != null) {
                    PageContactUsLeadsModel pageContactUsLeadsModel = (PageContactUsLeadsModel) r4.b(m2091a());
                    if (m2091a() != pageContactUsLeadsModel) {
                        graphQLVisitableModel = (AdminInfoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1443d = pageContactUsLeadsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2089a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(r3, m2091a());
                r3.c(1);
                r3.b(0, a);
                i();
                return r3.d();
            }
        }

        /* compiled from: state_item_list */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PagesContactInboxGraphQLModel.class, new Deserializer());
            }

            public Object m2092a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PagesContactInboxGraphQLParser.m2110a(r6);
                Object pagesContactInboxGraphQLModel = new PagesContactInboxGraphQLModel();
                ((BaseModel) pagesContactInboxGraphQLModel).a(a, FlatBuffer.a(a.a), r6);
                if (pagesContactInboxGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) pagesContactInboxGraphQLModel).a();
                }
                return pagesContactInboxGraphQLModel;
            }
        }

        /* compiled from: state_item_list */
        public class Serializer extends JsonSerializer<PagesContactInboxGraphQLModel> {
            public final void m2093a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PagesContactInboxGraphQLModel pagesContactInboxGraphQLModel = (PagesContactInboxGraphQLModel) r10;
                if (pagesContactInboxGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pagesContactInboxGraphQLModel.m2094a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pagesContactInboxGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pagesContactInboxGraphQLModel.w_();
                int u_ = pagesContactInboxGraphQLModel.u_();
                r11.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    r11.a("admin_info");
                    AdminInfoParser.m2109a(mutableFlatBuffer, g, r11, r12);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    r11.a("name");
                    r11.b(mutableFlatBuffer.c(u_, 1));
                }
                r11.g();
            }

            static {
                FbSerializerProvider.a(PagesContactInboxGraphQLModel.class, new Serializer());
            }
        }

        public PagesContactInboxGraphQLModel() {
            super(2);
        }

        public final void m2097a(String str, ConsistencyTuple consistencyTuple) {
            r2.a();
        }

        public final void m2098a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final AdminInfoModel m2096a() {
            this.f1444d = (AdminInfoModel) super.a(this.f1444d, 0, AdminInfoModel.class);
            return this.f1444d;
        }

        @Nullable
        public final String m2099j() {
            this.f1445e = super.a(this.f1445e, 1);
            return this.f1445e;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m2095a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2096a() != null) {
                AdminInfoModel adminInfoModel = (AdminInfoModel) r4.b(m2096a());
                if (m2096a() != adminInfoModel) {
                    graphQLVisitableModel = (PagesContactInboxGraphQLModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1444d = adminInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2094a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(r4, m2096a());
            int b = r4.b(m2099j());
            r4.c(2);
            r4.b(0, a);
            r4.b(1, b);
            i();
            return r4.d();
        }
    }
}
