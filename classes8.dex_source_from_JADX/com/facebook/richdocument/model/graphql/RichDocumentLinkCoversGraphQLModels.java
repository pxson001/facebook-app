package com.facebook.richdocument.model.graphql;

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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentFontResourceModel;
import com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLParsers.RichDocumentLinkCoverConfigFragmentParser;
import com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLParsers.RichDocumentNonTextConfigParser;
import com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLParsers.RichDocumentTextConfigParser;
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

/* compiled from: photo_menu_viewer */
public class RichDocumentLinkCoversGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -467116792)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_menu_viewer */
    public final class InstantArticleLinkCoverConfigFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f6287d;
        @Nullable
        private LatestVersionModel f6288e;

        /* compiled from: photo_menu_viewer */
        public class Deserializer extends FbJsonDeserializer {
            public Deserializer() {
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
                r0.<init>();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.Deserializer.<init>():void");
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
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.class;
                r1 = new com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels$InstantArticleLinkCoverConfigFragmentModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m6601a(com.fasterxml.jackson.core.JsonParser r6, com.fasterxml.jackson.databind.DeserializationContext r7) {
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
                r5 = this;
                r2 = com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLParsers.InstantArticleLinkCoverConfigFragmentParser.m6686a(r6);
                r1 = new com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels$InstantArticleLinkCoverConfigFragmentModel;
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1185172898)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_menu_viewer */
        public final class LatestVersionModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private FeedCoverConfigModel f6286d;

            /* compiled from: photo_menu_viewer */
            public class Deserializer extends FbJsonDeserializer {
                public Deserializer() {
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
                    r0 = this;
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.Deserializer.<init>():void");
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
                    r0 = com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.class;
                    r1 = new com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels$InstantArticleLinkCoverConfigFragmentModel$LatestVersionModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m6602a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                    r5 = com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLParsers.InstantArticleLinkCoverConfigFragmentParser.LatestVersionParser.m6684a(r11, r4);
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
                    r1 = new com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels$InstantArticleLinkCoverConfigFragmentModel$LatestVersionModel;
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 968010928)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: photo_menu_viewer */
            public final class FeedCoverConfigModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<RichDocumentNonTextConfigModel> f6271d;
                @Nullable
                private RichDocumentNonTextConfigModel f6272e;
                @Nullable
                private RichDocumentNonTextConfigModel f6273f;
                @Nullable
                private RichDocumentTextConfigModel f6274g;
                @Nullable
                private RichDocumentNonTextConfigModel f6275h;
                @Nullable
                private List<RichDocumentFontResourceModel> f6276i;
                @Nullable
                private RichDocumentTextConfigModel f6277j;
                @Nullable
                private String f6278k;
                @Nullable
                private RichDocumentLinkCoverConfigFragmentModel f6279l;
                @Nullable
                private RichDocumentTextConfigModel f6280m;
                @Nullable
                private String f6281n;
                @Nullable
                private String f6282o;
                private boolean f6283p;
                private boolean f6284q;
                @Nullable
                private RichDocumentNonTextConfigModel f6285r;

                /* compiled from: photo_menu_viewer */
                public class Deserializer extends FbJsonDeserializer {
                    public Deserializer() {
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
                        r0.<init>();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.Deserializer.<init>():void");
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
                        r0 = com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.class;
                        r1 = new com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels$InstantArticleLinkCoverConfigFragmentModel$LatestVersionModel$FeedCoverConfigModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m6603a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                        r5 = com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLParsers.InstantArticleLinkCoverConfigFragmentParser.LatestVersionParser.FeedCoverConfigParser.m6682a(r11, r4);
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
                        r1 = new com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels$InstantArticleLinkCoverConfigFragmentModel$LatestVersionModel$FeedCoverConfigModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: photo_menu_viewer */
                public class Serializer extends JsonSerializer<FeedCoverConfigModel> {
                    public Serializer() {
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
                        r0.<init>();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.Serializer.<init>():void");
                    }

                    public final void m6604a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                        r8 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m6610a(r0);
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
                        com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLParsers.InstantArticleLinkCoverConfigFragmentParser.LatestVersionParser.FeedCoverConfigParser.m6683a(r0, r1, r9, r10);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.class;
                        r1 = new com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels$InstantArticleLinkCoverConfigFragmentModel$LatestVersionModel$FeedCoverConfigModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.Serializer.<clinit>():void");
                    }
                }

                public FeedCoverConfigModel() {
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
                    r0 = 15;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.<init>():void");
                }

                @javax.annotation.Nonnull
                public final com.google.common.collect.ImmutableList<com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentNonTextConfigModel> m6612a() {
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
                    r0 = r3.f6271d;
                    r1 = 0;
                    r2 = com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentNonTextConfigModel.class;
                    r0 = super.a(r0, r1, r2);
                    r3.f6271d = r0;
                    r0 = r3.f6271d;
                    r0 = (com.google.common.collect.ImmutableList) r0;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.a():com.google.common.collect.ImmutableList<com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels$RichDocumentNonTextConfigModel>");
                }

                @javax.annotation.Nullable
                public final com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentNonTextConfigModel m6614j() {
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
                    r0 = r3.f6272e;
                    r1 = 1;
                    r2 = com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentNonTextConfigModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentNonTextConfigModel) r0;
                    r3.f6272e = r0;
                    r0 = r3.f6272e;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.j():com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels$RichDocumentNonTextConfigModel");
                }

                @javax.annotation.Nullable
                public final com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentNonTextConfigModel m6615k() {
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
                    r0 = r3.f6273f;
                    r1 = 2;
                    r2 = com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentNonTextConfigModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentNonTextConfigModel) r0;
                    r3.f6273f = r0;
                    r0 = r3.f6273f;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.k():com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels$RichDocumentNonTextConfigModel");
                }

                @javax.annotation.Nullable
                public final com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentTextConfigModel m6616l() {
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
                    r0 = r3.f6274g;
                    r1 = 3;
                    r2 = com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentTextConfigModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentTextConfigModel) r0;
                    r3.f6274g = r0;
                    r0 = r3.f6274g;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.l():com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels$RichDocumentTextConfigModel");
                }

                @javax.annotation.Nullable
                public final com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentNonTextConfigModel m6617m() {
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
                    r0 = r3.f6275h;
                    r1 = 4;
                    r2 = com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentNonTextConfigModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentNonTextConfigModel) r0;
                    r3.f6275h = r0;
                    r0 = r3.f6275h;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.m():com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels$RichDocumentNonTextConfigModel");
                }

                @javax.annotation.Nonnull
                private com.google.common.collect.ImmutableList<com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentFontResourceModel> m6605s() {
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
                    r0 = r3.f6276i;
                    r1 = 5;
                    r2 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentFontResourceModel.class;
                    r0 = super.a(r0, r1, r2);
                    r3.f6276i = r0;
                    r0 = r3.f6276i;
                    r0 = (com.google.common.collect.ImmutableList) r0;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.s():com.google.common.collect.ImmutableList<com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RichDocumentFontResourceModel>");
                }

                @javax.annotation.Nullable
                public final com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentTextConfigModel m6618n() {
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
                    r0 = r3.f6277j;
                    r1 = 6;
                    r2 = com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentTextConfigModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentTextConfigModel) r0;
                    r3.f6277j = r0;
                    r0 = r3.f6277j;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.n():com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels$RichDocumentTextConfigModel");
                }

                @javax.annotation.Nullable
                private java.lang.String m6606t() {
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
                    r2 = this;
                    r0 = r2.f6278k;
                    r1 = 7;
                    r0 = super.a(r0, r1);
                    r2.f6278k = r0;
                    r0 = r2.f6278k;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.t():java.lang.String");
                }

                @javax.annotation.Nullable
                private com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentLinkCoverConfigFragmentModel m6607u() {
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
                    r0 = r3.f6279l;
                    r1 = 8;
                    r2 = com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentLinkCoverConfigFragmentModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentLinkCoverConfigFragmentModel) r0;
                    r3.f6279l = r0;
                    r0 = r3.f6279l;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.u():com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels$RichDocumentLinkCoverConfigFragmentModel");
                }

                @javax.annotation.Nullable
                public final com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentTextConfigModel m6619o() {
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
                    r0 = r3.f6280m;
                    r1 = 9;
                    r2 = com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentTextConfigModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentTextConfigModel) r0;
                    r3.f6280m = r0;
                    r0 = r3.f6280m;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.o():com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels$RichDocumentTextConfigModel");
                }

                @javax.annotation.Nullable
                private java.lang.String m6608v() {
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
                    r2 = this;
                    r0 = r2.f6281n;
                    r1 = 10;
                    r0 = super.a(r0, r1);
                    r2.f6281n = r0;
                    r0 = r2.f6281n;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.v():java.lang.String");
                }

                @javax.annotation.Nullable
                private java.lang.String m6609w() {
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
                    r2 = this;
                    r0 = r2.f6282o;
                    r1 = 11;
                    r0 = super.a(r0, r1);
                    r2.f6282o = r0;
                    r0 = r2.f6282o;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.w():java.lang.String");
                }

                public final boolean m6620p() {
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
                    r2 = this;
                    r0 = 1;
                    r1 = 4;
                    r2.a(r0, r1);
                    r0 = r2.f6283p;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.p():boolean");
                }

                public final boolean m6621q() {
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
                    r2 = this;
                    r0 = 1;
                    r1 = 5;
                    r2.a(r0, r1);
                    r0 = r2.f6284q;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.q():boolean");
                }

                @javax.annotation.Nullable
                public final com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentNonTextConfigModel m6622r() {
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
                    r0 = r3.f6285r;
                    r1 = 14;
                    r2 = com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentNonTextConfigModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentNonTextConfigModel) r0;
                    r3.f6285r = r0;
                    r0 = r3.f6285r;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.r():com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels$RichDocumentNonTextConfigModel");
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
                    r0 = -884238688; // 0xffffffffcb4b96a0 float:-1.3342368E7 double:NaN;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m6611a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
                    r1 = r3.m6612a();
                    if (r1 == 0) goto L_0x0136;
                L_0x000a:
                    r1 = r3.m6612a();
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r4);
                    if (r1 == 0) goto L_0x0136;
                L_0x0014:
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r3);
                    r0 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel) r0;
                    r1 = r1.b();
                    r0.f6271d = r1;
                    r1 = r0;
                L_0x0021:
                    r0 = r3.m6614j();
                    if (r0 == 0) goto L_0x003f;
                L_0x0027:
                    r0 = r3.m6614j();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentNonTextConfigModel) r0;
                    r2 = r3.m6614j();
                    if (r2 == r0) goto L_0x003f;
                L_0x0037:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel) r1;
                    r1.f6272e = r0;
                L_0x003f:
                    r0 = r3.m6615k();
                    if (r0 == 0) goto L_0x005d;
                L_0x0045:
                    r0 = r3.m6615k();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentNonTextConfigModel) r0;
                    r2 = r3.m6615k();
                    if (r2 == r0) goto L_0x005d;
                L_0x0055:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel) r1;
                    r1.f6273f = r0;
                L_0x005d:
                    r0 = r3.m6616l();
                    if (r0 == 0) goto L_0x007b;
                L_0x0063:
                    r0 = r3.m6616l();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentTextConfigModel) r0;
                    r2 = r3.m6616l();
                    if (r2 == r0) goto L_0x007b;
                L_0x0073:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel) r1;
                    r1.f6274g = r0;
                L_0x007b:
                    r0 = r3.m6617m();
                    if (r0 == 0) goto L_0x0099;
                L_0x0081:
                    r0 = r3.m6617m();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentNonTextConfigModel) r0;
                    r2 = r3.m6617m();
                    if (r2 == r0) goto L_0x0099;
                L_0x0091:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel) r1;
                    r1.f6275h = r0;
                L_0x0099:
                    r0 = r3.m6605s();
                    if (r0 == 0) goto L_0x00b6;
                L_0x009f:
                    r0 = r3.m6605s();
                    r2 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r4);
                    if (r2 == 0) goto L_0x00b6;
                L_0x00a9:
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r0 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel) r0;
                    r1 = r2.b();
                    r0.f6276i = r1;
                    r1 = r0;
                L_0x00b6:
                    r0 = r3.m6618n();
                    if (r0 == 0) goto L_0x00d4;
                L_0x00bc:
                    r0 = r3.m6618n();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentTextConfigModel) r0;
                    r2 = r3.m6618n();
                    if (r2 == r0) goto L_0x00d4;
                L_0x00cc:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel) r1;
                    r1.f6277j = r0;
                L_0x00d4:
                    r0 = r3.m6607u();
                    if (r0 == 0) goto L_0x00f2;
                L_0x00da:
                    r0 = r3.m6607u();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentLinkCoverConfigFragmentModel) r0;
                    r2 = r3.m6607u();
                    if (r2 == r0) goto L_0x00f2;
                L_0x00ea:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel) r1;
                    r1.f6279l = r0;
                L_0x00f2:
                    r0 = r3.m6619o();
                    if (r0 == 0) goto L_0x0110;
                L_0x00f8:
                    r0 = r3.m6619o();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentTextConfigModel) r0;
                    r2 = r3.m6619o();
                    if (r2 == r0) goto L_0x0110;
                L_0x0108:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel) r1;
                    r1.f6280m = r0;
                L_0x0110:
                    r0 = r3.m6622r();
                    if (r0 == 0) goto L_0x012e;
                L_0x0116:
                    r0 = r3.m6622r();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentNonTextConfigModel) r0;
                    r2 = r3.m6622r();
                    if (r2 == r0) goto L_0x012e;
                L_0x0126:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel) r1;
                    r1.f6285r = r0;
                L_0x012e:
                    r3.i();
                    if (r1 != 0) goto L_0x0134;
                L_0x0133:
                    return r3;
                L_0x0134:
                    r3 = r1;
                    goto L_0x0133;
                L_0x0136:
                    r1 = r0;
                    goto L_0x0021;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m6610a(com.facebook.flatbuffers.FlatBufferBuilder r15) {
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
                    r14 = this;
                    r14.h();
                    r0 = r14.m6612a();
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r15, r0);
                    r1 = r14.m6614j();
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r15, r1);
                    r2 = r14.m6615k();
                    r2 = com.facebook.graphql.modelutil.ModelHelper.a(r15, r2);
                    r3 = r14.m6616l();
                    r3 = com.facebook.graphql.modelutil.ModelHelper.a(r15, r3);
                    r4 = r14.m6617m();
                    r4 = com.facebook.graphql.modelutil.ModelHelper.a(r15, r4);
                    r5 = r14.m6605s();
                    r5 = com.facebook.graphql.modelutil.ModelHelper.a(r15, r5);
                    r6 = r14.m6618n();
                    r6 = com.facebook.graphql.modelutil.ModelHelper.a(r15, r6);
                    r7 = r14.m6606t();
                    r7 = r15.b(r7);
                    r8 = r14.m6607u();
                    r8 = com.facebook.graphql.modelutil.ModelHelper.a(r15, r8);
                    r9 = r14.m6619o();
                    r9 = com.facebook.graphql.modelutil.ModelHelper.a(r15, r9);
                    r10 = r14.m6608v();
                    r10 = r15.b(r10);
                    r11 = r14.m6609w();
                    r11 = r15.b(r11);
                    r12 = r14.m6622r();
                    r12 = com.facebook.graphql.modelutil.ModelHelper.a(r15, r12);
                    r13 = 15;
                    r15.c(r13);
                    r13 = 0;
                    r15.b(r13, r0);
                    r0 = 1;
                    r15.b(r0, r1);
                    r0 = 2;
                    r15.b(r0, r2);
                    r0 = 3;
                    r15.b(r0, r3);
                    r0 = 4;
                    r15.b(r0, r4);
                    r0 = 5;
                    r15.b(r0, r5);
                    r0 = 6;
                    r15.b(r0, r6);
                    r0 = 7;
                    r15.b(r0, r7);
                    r0 = 8;
                    r15.b(r0, r8);
                    r0 = 9;
                    r15.b(r0, r9);
                    r0 = 10;
                    r15.b(r0, r10);
                    r0 = 11;
                    r15.b(r0, r11);
                    r0 = 12;
                    r1 = r14.f6283p;
                    r15.a(r0, r1);
                    r0 = 13;
                    r1 = r14.f6284q;
                    r15.a(r0, r1);
                    r0 = 14;
                    r15.b(r0, r12);
                    r14.i();
                    r0 = r15.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }

                public final void m6613a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
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
                    super.a(r2, r3, r4);
                    r0 = 12;
                    r0 = r2.a(r3, r0);
                    r1.f6283p = r0;
                    r0 = 13;
                    r0 = r2.a(r3, r0);
                    r1.f6284q = r0;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                }
            }

            /* compiled from: photo_menu_viewer */
            public class Serializer extends JsonSerializer<LatestVersionModel> {
                public Serializer() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.instructions.mods.ConstructorInsn.<init>(ConstructorInsn.java:45)
	at jadx.core.dex.visitors.ModVisitor.processInvoke(ModVisitor.java:193)
	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:83)
	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:68)
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
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.Serializer.<init>():void");
                }

                public final void m6623a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.instructions.mods.ConstructorInsn.<init>(ConstructorInsn.java:45)
	at jadx.core.dex.visitors.ModVisitor.processInvoke(ModVisitor.java:193)
	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:83)
	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:68)
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
                    r8 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m6624a(r0);
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
                    com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLParsers.InstantArticleLinkCoverConfigFragmentParser.LatestVersionParser.m6685a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.instructions.mods.ConstructorInsn.<init>(ConstructorInsn.java:45)
	at jadx.core.dex.visitors.ModVisitor.processInvoke(ModVisitor.java:193)
	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:83)
	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:68)
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
                    r0 = com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.class;
                    r1 = new com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels$InstantArticleLinkCoverConfigFragmentModel$LatestVersionModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.Serializer.<clinit>():void");
                }
            }

            public LatestVersionModel() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.instructions.mods.ConstructorInsn.<init>(ConstructorInsn.java:45)
	at jadx.core.dex.visitors.ModVisitor.processInvoke(ModVisitor.java:193)
	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:83)
	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:68)
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.<init>():void");
            }

            @javax.annotation.Nullable
            public final com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel m6626a() {
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
                r0 = r3.f6286d;
                r1 = 0;
                r2 = com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel) r0;
                r3.f6286d = r0;
                r0 = r3.f6286d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.a():com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels$InstantArticleLinkCoverConfigFragmentModel$LatestVersionModel$FeedCoverConfigModel");
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
                r0 = 1619159843; // 0x60826b23 float:7.518115E19 double:7.999712536E-315;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m6625a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.IfMakerHelper.getNextIfNode(IfMakerHelper.java:347)
	at jadx.core.dex.visitors.regions.IfMakerHelper.getNextIf(IfMakerHelper.java:303)
	at jadx.core.dex.visitors.regions.IfMakerHelper.mergeNestedIfNodes(IfMakerHelper.java:146)
	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:612)
	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:127)
	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
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
                r0 = r3.m6626a();
                if (r0 == 0) goto L_0x0022;
            L_0x000a:
                r0 = r3.m6626a();
                r0 = r4.b(r0);
                r0 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel) r0;
                r2 = r3.m6626a();
                if (r2 == r0) goto L_0x0022;
            L_0x001a:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel) r1;
                r1.f6286d = r0;
            L_0x0022:
                r3.i();
                if (r1 != 0) goto L_0x0028;
            L_0x0027:
                return r3;
            L_0x0028:
                r3 = r1;
                goto L_0x0027;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m6624a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                r0 = r2.m6626a();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                r1 = 1;
                r3.c(r1);
                r1 = 0;
                r3.b(r1, r0);
                r2.i();
                r0 = r3.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        /* compiled from: photo_menu_viewer */
        public class Serializer extends JsonSerializer<InstantArticleLinkCoverConfigFragmentModel> {
            public Serializer() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.instructions.mods.ConstructorInsn.<init>(ConstructorInsn.java:45)
	at jadx.core.dex.visitors.ModVisitor.processInvoke(ModVisitor.java:193)
	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:83)
	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:68)
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
                r0.<init>();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.Serializer.<init>():void");
            }

            public final void m6627a(java.lang.Object r9, com.fasterxml.jackson.core.JsonGenerator r10, com.fasterxml.jackson.databind.SerializerProvider r11) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.instructions.mods.ConstructorInsn.<init>(ConstructorInsn.java:45)
	at jadx.core.dex.visitors.ModVisitor.processInvoke(ModVisitor.java:193)
	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:83)
	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:68)
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
                r9 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel) r9;
                r2 = 0;
                r0 = r9.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r9.m6629a(r0);
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
                r7 = 0;
                r10.f();
                r6 = r0.g(r1, r7);
                if (r6 == 0) goto L_0x0053;
            L_0x0047:
                r6 = "id";
                r10.a(r6);
                r6 = r0.c(r1, r7);
                r10.b(r6);
            L_0x0053:
                r6 = 1;
                r6 = r0.g(r1, r6);
                if (r6 == 0) goto L_0x0062;
            L_0x005a:
                r7 = "latest_version";
                r10.a(r7);
                com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLParsers.InstantArticleLinkCoverConfigFragmentParser.LatestVersionParser.m6685a(r0, r6, r10, r11);
            L_0x0062:
                r10.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
            }

            static {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.instructions.mods.ConstructorInsn.<init>(ConstructorInsn.java:45)
	at jadx.core.dex.visitors.ModVisitor.processInvoke(ModVisitor.java:193)
	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:83)
	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:68)
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
                r0 = com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.class;
                r1 = new com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels$InstantArticleLinkCoverConfigFragmentModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.Serializer.<clinit>():void");
            }
        }

        public InstantArticleLinkCoverConfigFragmentModel() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.instructions.mods.ConstructorInsn.<init>(ConstructorInsn.java:45)
	at jadx.core.dex.visitors.ModVisitor.processInvoke(ModVisitor.java:193)
	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:83)
	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:68)
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
            r0 = 2;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.<init>():void");
        }

        @javax.annotation.Nullable
        private java.lang.String m6628k() {
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
            r2 = this;
            r0 = r2.f6287d;
            r1 = 0;
            r0 = super.a(r0, r1);
            r2.f6287d = r0;
            r0 = r2.f6287d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.k():java.lang.String");
        }

        @javax.annotation.Nullable
        public final com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel m6632j() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f6288e;
            r1 = 1;
            r2 = com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel) r0;
            r3.f6288e = r0;
            r0 = r3.f6288e;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.j():com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels$InstantArticleLinkCoverConfigFragmentModel$LatestVersionModel");
        }

        @javax.annotation.Nullable
        public final java.lang.String m6631a() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.m6628k();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.a():java.lang.String");
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
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = 1607392245; // 0x5fcedbf5 float:2.9811554E19 double:7.941572876E-315;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m6630a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.IfMakerHelper.getNextIfNode(IfMakerHelper.java:347)
	at jadx.core.dex.visitors.regions.IfMakerHelper.getNextIf(IfMakerHelper.java:303)
	at jadx.core.dex.visitors.regions.IfMakerHelper.mergeNestedIfNodes(IfMakerHelper.java:146)
	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:612)
	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:127)
	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
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
            r1 = 0;
            r3.h();
            r0 = r3.m6632j();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m6632j();
            r0 = r4.b(r0);
            r0 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel) r0;
            r2 = r3.m6632j();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel) r1;
            r1.f6288e = r0;
        L_0x0022:
            r3.i();
            if (r1 != 0) goto L_0x0028;
        L_0x0027:
            return r3;
        L_0x0028:
            r3 = r1;
            goto L_0x0027;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m6629a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
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
            r0 = r3.m6628k();
            r0 = r4.b(r0);
            r1 = r3.m6632j();
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 256260560)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_menu_viewer */
    public final class RichDocumentLinkCoverConfigFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<RichDocumentNonTextConfigModel> f6289d;
        @Nullable
        private RichDocumentNonTextConfigModel f6290e;
        @Nullable
        private RichDocumentNonTextConfigModel f6291f;
        @Nullable
        private RichDocumentTextConfigModel f6292g;
        @Nullable
        private RichDocumentNonTextConfigModel f6293h;
        @Nullable
        private List<RichDocumentFontResourceModel> f6294i;
        @Nullable
        private RichDocumentTextConfigModel f6295j;
        @Nullable
        private String f6296k;
        @Nullable
        private RichDocumentTextConfigModel f6297l;
        @Nullable
        private String f6298m;
        @Nullable
        private String f6299n;
        private boolean f6300o;
        private boolean f6301p;
        @Nullable
        private RichDocumentNonTextConfigModel f6302q;

        /* compiled from: photo_menu_viewer */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentLinkCoverConfigFragmentModel.class, new Deserializer());
            }

            public Object m6633a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RichDocumentLinkCoverConfigFragmentParser.m6687a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object richDocumentLinkCoverConfigFragmentModel = new RichDocumentLinkCoverConfigFragmentModel();
                ((BaseModel) richDocumentLinkCoverConfigFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (richDocumentLinkCoverConfigFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentLinkCoverConfigFragmentModel).a();
                }
                return richDocumentLinkCoverConfigFragmentModel;
            }
        }

        /* compiled from: photo_menu_viewer */
        public class Serializer extends JsonSerializer<RichDocumentLinkCoverConfigFragmentModel> {
            public final void m6634a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RichDocumentLinkCoverConfigFragmentModel richDocumentLinkCoverConfigFragmentModel = (RichDocumentLinkCoverConfigFragmentModel) obj;
                if (richDocumentLinkCoverConfigFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentLinkCoverConfigFragmentModel.m6647a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentLinkCoverConfigFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RichDocumentLinkCoverConfigFragmentParser.m6688a(richDocumentLinkCoverConfigFragmentModel.w_(), richDocumentLinkCoverConfigFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(RichDocumentLinkCoverConfigFragmentModel.class, new Serializer());
            }
        }

        public RichDocumentLinkCoverConfigFragmentModel() {
            super(14);
        }

        @Nonnull
        private ImmutableList<RichDocumentNonTextConfigModel> m6635a() {
            this.f6289d = super.a(this.f6289d, 0, RichDocumentNonTextConfigModel.class);
            return (ImmutableList) this.f6289d;
        }

        @Nullable
        private RichDocumentNonTextConfigModel m6636j() {
            this.f6290e = (RichDocumentNonTextConfigModel) super.a(this.f6290e, 1, RichDocumentNonTextConfigModel.class);
            return this.f6290e;
        }

        @Nullable
        private RichDocumentNonTextConfigModel m6637k() {
            this.f6291f = (RichDocumentNonTextConfigModel) super.a(this.f6291f, 2, RichDocumentNonTextConfigModel.class);
            return this.f6291f;
        }

        @Nullable
        private RichDocumentTextConfigModel m6638l() {
            this.f6292g = (RichDocumentTextConfigModel) super.a(this.f6292g, 3, RichDocumentTextConfigModel.class);
            return this.f6292g;
        }

        @Nullable
        private RichDocumentNonTextConfigModel m6639m() {
            this.f6293h = (RichDocumentNonTextConfigModel) super.a(this.f6293h, 4, RichDocumentNonTextConfigModel.class);
            return this.f6293h;
        }

        @Nonnull
        private ImmutableList<RichDocumentFontResourceModel> m6640n() {
            this.f6294i = super.a(this.f6294i, 5, RichDocumentFontResourceModel.class);
            return (ImmutableList) this.f6294i;
        }

        @Nullable
        private RichDocumentTextConfigModel m6641o() {
            this.f6295j = (RichDocumentTextConfigModel) super.a(this.f6295j, 6, RichDocumentTextConfigModel.class);
            return this.f6295j;
        }

        @Nullable
        private String m6642p() {
            this.f6296k = super.a(this.f6296k, 7);
            return this.f6296k;
        }

        @Nullable
        private RichDocumentTextConfigModel m6643q() {
            this.f6297l = (RichDocumentTextConfigModel) super.a(this.f6297l, 8, RichDocumentTextConfigModel.class);
            return this.f6297l;
        }

        @Nullable
        private String m6644r() {
            this.f6298m = super.a(this.f6298m, 9);
            return this.f6298m;
        }

        @Nullable
        private String m6645s() {
            this.f6299n = super.a(this.f6299n, 10);
            return this.f6299n;
        }

        @Nullable
        private RichDocumentNonTextConfigModel m6646t() {
            this.f6302q = (RichDocumentNonTextConfigModel) super.a(this.f6302q, 13, RichDocumentNonTextConfigModel.class);
            return this.f6302q;
        }

        public final int jK_() {
            return -884238688;
        }

        public final GraphQLVisitableModel m6648a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            RichDocumentLinkCoverConfigFragmentModel richDocumentLinkCoverConfigFragmentModel;
            GraphQLVisitableModel graphQLVisitableModel;
            RichDocumentNonTextConfigModel richDocumentNonTextConfigModel;
            RichDocumentTextConfigModel richDocumentTextConfigModel;
            Builder a;
            h();
            if (m6635a() != null) {
                Builder a2 = ModelHelper.a(m6635a(), graphQLModelMutatingVisitor);
                if (a2 != null) {
                    richDocumentLinkCoverConfigFragmentModel = (RichDocumentLinkCoverConfigFragmentModel) ModelHelper.a(null, this);
                    richDocumentLinkCoverConfigFragmentModel.f6289d = a2.b();
                    graphQLVisitableModel = richDocumentLinkCoverConfigFragmentModel;
                    if (m6636j() != null) {
                        richDocumentNonTextConfigModel = (RichDocumentNonTextConfigModel) graphQLModelMutatingVisitor.b(m6636j());
                        if (m6636j() != richDocumentNonTextConfigModel) {
                            graphQLVisitableModel = (RichDocumentLinkCoverConfigFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f6290e = richDocumentNonTextConfigModel;
                        }
                    }
                    if (m6637k() != null) {
                        richDocumentNonTextConfigModel = (RichDocumentNonTextConfigModel) graphQLModelMutatingVisitor.b(m6637k());
                        if (m6637k() != richDocumentNonTextConfigModel) {
                            graphQLVisitableModel = (RichDocumentLinkCoverConfigFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f6291f = richDocumentNonTextConfigModel;
                        }
                    }
                    if (m6638l() != null) {
                        richDocumentTextConfigModel = (RichDocumentTextConfigModel) graphQLModelMutatingVisitor.b(m6638l());
                        if (m6638l() != richDocumentTextConfigModel) {
                            graphQLVisitableModel = (RichDocumentLinkCoverConfigFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f6292g = richDocumentTextConfigModel;
                        }
                    }
                    if (m6639m() != null) {
                        richDocumentNonTextConfigModel = (RichDocumentNonTextConfigModel) graphQLModelMutatingVisitor.b(m6639m());
                        if (m6639m() != richDocumentNonTextConfigModel) {
                            graphQLVisitableModel = (RichDocumentLinkCoverConfigFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f6293h = richDocumentNonTextConfigModel;
                        }
                    }
                    if (m6640n() != null) {
                        a = ModelHelper.a(m6640n(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            richDocumentLinkCoverConfigFragmentModel = (RichDocumentLinkCoverConfigFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            richDocumentLinkCoverConfigFragmentModel.f6294i = a.b();
                            graphQLVisitableModel = richDocumentLinkCoverConfigFragmentModel;
                        }
                    }
                    if (m6641o() != null) {
                        richDocumentTextConfigModel = (RichDocumentTextConfigModel) graphQLModelMutatingVisitor.b(m6641o());
                        if (m6641o() != richDocumentTextConfigModel) {
                            graphQLVisitableModel = (RichDocumentLinkCoverConfigFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f6295j = richDocumentTextConfigModel;
                        }
                    }
                    if (m6643q() != null) {
                        richDocumentTextConfigModel = (RichDocumentTextConfigModel) graphQLModelMutatingVisitor.b(m6643q());
                        if (m6643q() != richDocumentTextConfigModel) {
                            graphQLVisitableModel = (RichDocumentLinkCoverConfigFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f6297l = richDocumentTextConfigModel;
                        }
                    }
                    if (m6646t() != null) {
                        richDocumentNonTextConfigModel = (RichDocumentNonTextConfigModel) graphQLModelMutatingVisitor.b(m6646t());
                        if (m6646t() != richDocumentNonTextConfigModel) {
                            graphQLVisitableModel = (RichDocumentLinkCoverConfigFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f6302q = richDocumentNonTextConfigModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m6636j() != null) {
                richDocumentNonTextConfigModel = (RichDocumentNonTextConfigModel) graphQLModelMutatingVisitor.b(m6636j());
                if (m6636j() != richDocumentNonTextConfigModel) {
                    graphQLVisitableModel = (RichDocumentLinkCoverConfigFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6290e = richDocumentNonTextConfigModel;
                }
            }
            if (m6637k() != null) {
                richDocumentNonTextConfigModel = (RichDocumentNonTextConfigModel) graphQLModelMutatingVisitor.b(m6637k());
                if (m6637k() != richDocumentNonTextConfigModel) {
                    graphQLVisitableModel = (RichDocumentLinkCoverConfigFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6291f = richDocumentNonTextConfigModel;
                }
            }
            if (m6638l() != null) {
                richDocumentTextConfigModel = (RichDocumentTextConfigModel) graphQLModelMutatingVisitor.b(m6638l());
                if (m6638l() != richDocumentTextConfigModel) {
                    graphQLVisitableModel = (RichDocumentLinkCoverConfigFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6292g = richDocumentTextConfigModel;
                }
            }
            if (m6639m() != null) {
                richDocumentNonTextConfigModel = (RichDocumentNonTextConfigModel) graphQLModelMutatingVisitor.b(m6639m());
                if (m6639m() != richDocumentNonTextConfigModel) {
                    graphQLVisitableModel = (RichDocumentLinkCoverConfigFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6293h = richDocumentNonTextConfigModel;
                }
            }
            if (m6640n() != null) {
                a = ModelHelper.a(m6640n(), graphQLModelMutatingVisitor);
                if (a != null) {
                    richDocumentLinkCoverConfigFragmentModel = (RichDocumentLinkCoverConfigFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    richDocumentLinkCoverConfigFragmentModel.f6294i = a.b();
                    graphQLVisitableModel = richDocumentLinkCoverConfigFragmentModel;
                }
            }
            if (m6641o() != null) {
                richDocumentTextConfigModel = (RichDocumentTextConfigModel) graphQLModelMutatingVisitor.b(m6641o());
                if (m6641o() != richDocumentTextConfigModel) {
                    graphQLVisitableModel = (RichDocumentLinkCoverConfigFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6295j = richDocumentTextConfigModel;
                }
            }
            if (m6643q() != null) {
                richDocumentTextConfigModel = (RichDocumentTextConfigModel) graphQLModelMutatingVisitor.b(m6643q());
                if (m6643q() != richDocumentTextConfigModel) {
                    graphQLVisitableModel = (RichDocumentLinkCoverConfigFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6297l = richDocumentTextConfigModel;
                }
            }
            if (m6646t() != null) {
                richDocumentNonTextConfigModel = (RichDocumentNonTextConfigModel) graphQLModelMutatingVisitor.b(m6646t());
                if (m6646t() != richDocumentNonTextConfigModel) {
                    graphQLVisitableModel = (RichDocumentLinkCoverConfigFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6302q = richDocumentNonTextConfigModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m6647a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6635a());
            int a2 = ModelHelper.a(flatBufferBuilder, m6636j());
            int a3 = ModelHelper.a(flatBufferBuilder, m6637k());
            int a4 = ModelHelper.a(flatBufferBuilder, m6638l());
            int a5 = ModelHelper.a(flatBufferBuilder, m6639m());
            int a6 = ModelHelper.a(flatBufferBuilder, m6640n());
            int a7 = ModelHelper.a(flatBufferBuilder, m6641o());
            int b = flatBufferBuilder.b(m6642p());
            int a8 = ModelHelper.a(flatBufferBuilder, m6643q());
            int b2 = flatBufferBuilder.b(m6644r());
            int b3 = flatBufferBuilder.b(m6645s());
            int a9 = ModelHelper.a(flatBufferBuilder, m6646t());
            flatBufferBuilder.c(14);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, a5);
            flatBufferBuilder.b(5, a6);
            flatBufferBuilder.b(6, a7);
            flatBufferBuilder.b(7, b);
            flatBufferBuilder.b(8, a8);
            flatBufferBuilder.b(9, b2);
            flatBufferBuilder.b(10, b3);
            flatBufferBuilder.a(11, this.f6300o);
            flatBufferBuilder.a(12, this.f6301p);
            flatBufferBuilder.b(13, a9);
            i();
            return flatBufferBuilder.d();
        }

        public final void m6649a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f6300o = mutableFlatBuffer.a(i, 11);
            this.f6301p = mutableFlatBuffer.a(i, 12);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1991433298)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_menu_viewer */
    public final class RichDocumentNonTextConfigModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f6303d;
        @Nullable
        private String f6304e;
        @Nullable
        private String f6305f;
        @Nullable
        private String f6306g;
        private boolean f6307h;
        @Nullable
        private String f6308i;
        @Nullable
        private String f6309j;
        @Nullable
        private String f6310k;

        /* compiled from: photo_menu_viewer */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentNonTextConfigModel.class, new Deserializer());
            }

            public Object m6650a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RichDocumentNonTextConfigParser.m6689a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object richDocumentNonTextConfigModel = new RichDocumentNonTextConfigModel();
                ((BaseModel) richDocumentNonTextConfigModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (richDocumentNonTextConfigModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentNonTextConfigModel).a();
                }
                return richDocumentNonTextConfigModel;
            }
        }

        /* compiled from: photo_menu_viewer */
        public class Serializer extends JsonSerializer<RichDocumentNonTextConfigModel> {
            public final void m6651a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RichDocumentNonTextConfigModel richDocumentNonTextConfigModel = (RichDocumentNonTextConfigModel) obj;
                if (richDocumentNonTextConfigModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentNonTextConfigModel.m6652a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentNonTextConfigModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RichDocumentNonTextConfigParser.m6690a(richDocumentNonTextConfigModel.w_(), richDocumentNonTextConfigModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(RichDocumentNonTextConfigModel.class, new Serializer());
            }
        }

        public RichDocumentNonTextConfigModel() {
            super(8);
        }

        @Nullable
        public final String m6654a() {
            this.f6303d = super.a(this.f6303d, 0);
            return this.f6303d;
        }

        @Nullable
        public final String m6656j() {
            this.f6304e = super.a(this.f6304e, 1);
            return this.f6304e;
        }

        @Nullable
        public final String m6657k() {
            this.f6305f = super.a(this.f6305f, 2);
            return this.f6305f;
        }

        @Nullable
        public final String m6658l() {
            this.f6306g = super.a(this.f6306g, 3);
            return this.f6306g;
        }

        public final boolean m6659m() {
            a(0, 4);
            return this.f6307h;
        }

        @Nullable
        public final String m6660n() {
            this.f6308i = super.a(this.f6308i, 5);
            return this.f6308i;
        }

        @Nullable
        public final String m6661o() {
            this.f6309j = super.a(this.f6309j, 6);
            return this.f6309j;
        }

        @Nullable
        public final String m6662p() {
            this.f6310k = super.a(this.f6310k, 7);
            return this.f6310k;
        }

        public final int jK_() {
            return 1075850371;
        }

        public final GraphQLVisitableModel m6653a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m6652a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m6654a());
            int b2 = flatBufferBuilder.b(m6656j());
            int b3 = flatBufferBuilder.b(m6657k());
            int b4 = flatBufferBuilder.b(m6658l());
            int b5 = flatBufferBuilder.b(m6660n());
            int b6 = flatBufferBuilder.b(m6661o());
            int b7 = flatBufferBuilder.b(m6662p());
            flatBufferBuilder.c(8);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.b(3, b4);
            flatBufferBuilder.a(4, this.f6307h);
            flatBufferBuilder.b(5, b5);
            flatBufferBuilder.b(6, b6);
            flatBufferBuilder.b(7, b7);
            i();
            return flatBufferBuilder.d();
        }

        public final void m6655a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f6307h = mutableFlatBuffer.a(i, 4);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 363447233)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_menu_viewer */
    public final class RichDocumentTextConfigModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f6311d;
        @Nullable
        private String f6312e;
        @Nullable
        private String f6313f;
        @Nullable
        private String f6314g;
        private double f6315h;
        private double f6316i;
        private double f6317j;
        @Nullable
        private String f6318k;
        private double f6319l;
        private double f6320m;
        private double f6321n;
        @Nullable
        private String f6322o;
        private boolean f6323p;
        @Nullable
        private String f6324q;
        @Nullable
        private String f6325r;

        /* compiled from: photo_menu_viewer */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentTextConfigModel.class, new Deserializer());
            }

            public Object m6663a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RichDocumentTextConfigParser.m6693a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object richDocumentTextConfigModel = new RichDocumentTextConfigModel();
                ((BaseModel) richDocumentTextConfigModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (richDocumentTextConfigModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentTextConfigModel).a();
                }
                return richDocumentTextConfigModel;
            }
        }

        /* compiled from: photo_menu_viewer */
        public class Serializer extends JsonSerializer<RichDocumentTextConfigModel> {
            public final void m6664a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RichDocumentTextConfigModel richDocumentTextConfigModel = (RichDocumentTextConfigModel) obj;
                if (richDocumentTextConfigModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentTextConfigModel.m6665a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentTextConfigModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RichDocumentTextConfigParser.m6694a(richDocumentTextConfigModel.w_(), richDocumentTextConfigModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(RichDocumentTextConfigModel.class, new Serializer());
            }
        }

        public RichDocumentTextConfigModel() {
            super(15);
        }

        @Nullable
        public final String m6667a() {
            this.f6311d = super.a(this.f6311d, 0);
            return this.f6311d;
        }

        @Nullable
        public final String m6669j() {
            this.f6312e = super.a(this.f6312e, 1);
            return this.f6312e;
        }

        @Nullable
        public final String m6670k() {
            this.f6313f = super.a(this.f6313f, 2);
            return this.f6313f;
        }

        @Nullable
        public final String m6671l() {
            this.f6314g = super.a(this.f6314g, 3);
            return this.f6314g;
        }

        public final double m6672m() {
            a(0, 4);
            return this.f6315h;
        }

        public final double m6673n() {
            a(0, 5);
            return this.f6316i;
        }

        public final double m6674o() {
            a(0, 6);
            return this.f6317j;
        }

        @Nullable
        public final String m6675p() {
            this.f6318k = super.a(this.f6318k, 7);
            return this.f6318k;
        }

        public final double m6676q() {
            a(1, 0);
            return this.f6319l;
        }

        public final double m6677r() {
            a(1, 1);
            return this.f6320m;
        }

        public final double m6678s() {
            a(1, 2);
            return this.f6321n;
        }

        @Nullable
        public final String m6679t() {
            this.f6322o = super.a(this.f6322o, 11);
            return this.f6322o;
        }

        @Nullable
        public final String m6680u() {
            this.f6324q = super.a(this.f6324q, 13);
            return this.f6324q;
        }

        @Nullable
        public final String m6681v() {
            this.f6325r = super.a(this.f6325r, 14);
            return this.f6325r;
        }

        public final int jK_() {
            return -974655192;
        }

        public final GraphQLVisitableModel m6666a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m6665a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m6667a());
            int b2 = flatBufferBuilder.b(m6669j());
            int b3 = flatBufferBuilder.b(m6670k());
            int b4 = flatBufferBuilder.b(m6671l());
            int b5 = flatBufferBuilder.b(m6675p());
            int b6 = flatBufferBuilder.b(m6679t());
            int b7 = flatBufferBuilder.b(m6680u());
            int b8 = flatBufferBuilder.b(m6681v());
            flatBufferBuilder.c(15);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.b(3, b4);
            flatBufferBuilder.a(4, this.f6315h, 0.0d);
            flatBufferBuilder.a(5, this.f6316i, 0.0d);
            flatBufferBuilder.a(6, this.f6317j, 0.0d);
            flatBufferBuilder.b(7, b5);
            flatBufferBuilder.a(8, this.f6319l, 0.0d);
            flatBufferBuilder.a(9, this.f6320m, 0.0d);
            flatBufferBuilder.a(10, this.f6321n, 0.0d);
            flatBufferBuilder.b(11, b6);
            flatBufferBuilder.a(12, this.f6323p);
            flatBufferBuilder.b(13, b7);
            flatBufferBuilder.b(14, b8);
            i();
            return flatBufferBuilder.d();
        }

        public final void m6668a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f6315h = mutableFlatBuffer.a(i, 4, 0.0d);
            this.f6316i = mutableFlatBuffer.a(i, 5, 0.0d);
            this.f6317j = mutableFlatBuffer.a(i, 6, 0.0d);
            this.f6319l = mutableFlatBuffer.a(i, 8, 0.0d);
            this.f6320m = mutableFlatBuffer.a(i, 9, 0.0d);
            this.f6321n = mutableFlatBuffer.a(i, 10, 0.0d);
            this.f6323p = mutableFlatBuffer.a(i, 12);
        }
    }
}
