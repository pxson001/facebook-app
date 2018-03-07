package com.facebook.structuredsurvey.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: doodle_list */
public class SurveyNotificationQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 345578869)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: doodle_list */
    public final class FetchNotificationForSurveyModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f17156d;
        @Nullable
        private List<ActorsModel> f17157e;
        @Nullable
        private AppIconModel f17158f;
        private long f17159g;
        @Nullable
        private TitleForSummaryModel f17160h;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1384518279)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: doodle_list */
        public final class ActorsModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f17146d;
            @Nullable
            private ProfilePictureModel f17147e;

            /* compiled from: doodle_list */
            public class Deserializer extends FbJsonDeserializer {
                public Deserializer() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r0 = this;
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.Deserializer.<init>():void");
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
                    r0 = com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.class;
                    r1 = new com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels$FetchNotificationForSurveyModel$ActorsModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m24828a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                    r5 = com.facebook.structuredsurvey.graphql.SurveyNotificationQueryParsers.FetchNotificationForSurveyParser.ActorsParser.m24882b(r11, r4);
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
                    r1 = new com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels$FetchNotificationForSurveyModel$ActorsModel;
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: doodle_list */
            public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f17145d;

                /* compiled from: doodle_list */
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.ProfilePictureModel.Deserializer.<init>():void");
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
                        r0 = com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.ProfilePictureModel.class;
                        r1 = new com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels$FetchNotificationForSurveyModel$ActorsModel$ProfilePictureModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.ProfilePictureModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m24829a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                        r5 = com.facebook.structuredsurvey.graphql.SurveyNotificationQueryParsers.FetchNotificationForSurveyParser.ActorsParser.ProfilePictureParser.m24879a(r11, r4);
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
                        r1 = new com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels$FetchNotificationForSurveyModel$ActorsModel$ProfilePictureModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.ProfilePictureModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: doodle_list */
                public class Serializer extends JsonSerializer<ProfilePictureModel> {
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.ProfilePictureModel.Serializer.<init>():void");
                    }

                    public final void m24830a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                        r8 = (com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.ProfilePictureModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m24831a(r0);
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
                        com.facebook.structuredsurvey.graphql.SurveyNotificationQueryParsers.FetchNotificationForSurveyParser.ActorsParser.ProfilePictureParser.m24880a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.ProfilePictureModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.ProfilePictureModel.class;
                        r1 = new com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels$FetchNotificationForSurveyModel$ActorsModel$ProfilePictureModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.ProfilePictureModel.Serializer.<clinit>():void");
                    }
                }

                public ProfilePictureModel() {
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
                    r0 = 1;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.ProfilePictureModel.<init>():void");
                }

                @javax.annotation.Nullable
                public final java.lang.String m24833a() {
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
                    r0 = r2.f17145d;
                    r1 = 0;
                    r0 = super.a(r0, r1);
                    r2.f17145d = r0;
                    r0 = r2.f17145d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.ProfilePictureModel.a():java.lang.String");
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
                    r0 = 70760763; // 0x437b93b float:2.15966E-36 double:3.4960462E-316;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.ProfilePictureModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m24832a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                    r0.h();
                    r0.i();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.ProfilePictureModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m24831a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                    r2.h();
                    r0 = r2.m24833a();
                    r0 = r3.b(r0);
                    r1 = 1;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.ProfilePictureModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: doodle_list */
            public class Serializer extends JsonSerializer<ActorsModel> {
                public Serializer() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r0 = this;
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.Serializer.<init>():void");
                }

                public final void m24834a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r7 = this;
                    r8 = (com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m24836a(r0);
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
                    com.facebook.structuredsurvey.graphql.SurveyNotificationQueryParsers.FetchNotificationForSurveyParser.ActorsParser.m24883b(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r0 = com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.class;
                    r1 = new com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels$FetchNotificationForSurveyModel$ActorsModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.Serializer.<clinit>():void");
                }
            }

            public ActorsModel() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r1 = this;
                r0 = 2;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.<init>():void");
            }

            public final void m24839a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
            }

            public final void m24840a(java.lang.String r1, java.lang.Object r2, boolean r3) {
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.a(java.lang.String, java.lang.Object, boolean):void");
            }

            @javax.annotation.Nullable
            private com.facebook.graphql.enums.GraphQLObjectType m24835j() {
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
                r4 = this;
                r0 = r4.b;
                if (r0 == 0) goto L_0x0017;
            L_0x0004:
                r0 = r4.f17146d;
                if (r0 != 0) goto L_0x0017;
            L_0x0008:
                r0 = r4.b;
                r1 = r4.c;
                r2 = 0;
                r3 = com.facebook.graphql.enums.GraphQLObjectType.class;
                r0 = r0.d(r1, r2, r3);
                r0 = (com.facebook.graphql.enums.GraphQLObjectType) r0;
                r4.f17146d = r0;
            L_0x0017:
                r0 = r4.f17146d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.j():com.facebook.graphql.enums.GraphQLObjectType");
            }

            @javax.annotation.Nullable
            public final com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.ProfilePictureModel m24838a() {
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
                r0 = r3.f17147e;
                r1 = 1;
                r2 = com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.ProfilePictureModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.ProfilePictureModel) r0;
                r3.f17147e = r0;
                r0 = r3.f17147e;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.a():com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels$FetchNotificationForSurveyModel$ActorsModel$ProfilePictureModel");
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
                r0 = 63093205; // 0x3c2b9d5 float:1.144496E-36 double:3.1172185E-316;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m24837a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
                r1 = 0;
                r3.h();
                r0 = r3.m24838a();
                if (r0 == 0) goto L_0x0022;
            L_0x000a:
                r0 = r3.m24838a();
                r0 = r4.b(r0);
                r0 = (com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.ProfilePictureModel) r0;
                r2 = r3.m24838a();
                if (r2 == r0) goto L_0x0022;
            L_0x001a:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel) r1;
                r1.f17147e = r0;
            L_0x0022:
                r3.i();
                if (r1 != 0) goto L_0x0028;
            L_0x0027:
                return r3;
            L_0x0028:
                r3 = r1;
                goto L_0x0027;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m24836a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
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
                r3.h();
                r0 = r3.m24835j();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r0);
                r1 = r3.m24838a();
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: doodle_list */
        public final class AppIconModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f17148d;

            /* compiled from: doodle_list */
            public class Deserializer extends FbJsonDeserializer {
                public Deserializer() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r0 = this;
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.AppIconModel.Deserializer.<init>():void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r0 = com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.AppIconModel.class;
                    r1 = new com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels$FetchNotificationForSurveyModel$AppIconModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.AppIconModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m24841a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.structuredsurvey.graphql.SurveyNotificationQueryParsers.FetchNotificationForSurveyParser.AppIconParser.m24884a(r11, r4);
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
                    r1 = new com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels$FetchNotificationForSurveyModel$AppIconModel;
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.AppIconModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            /* compiled from: doodle_list */
            public class Serializer extends JsonSerializer<AppIconModel> {
                public Serializer() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r0 = this;
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.AppIconModel.Serializer.<init>():void");
                }

                public final void m24842a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r7 = this;
                    r8 = (com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.AppIconModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m24843a(r0);
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
                    com.facebook.structuredsurvey.graphql.SurveyNotificationQueryParsers.FetchNotificationForSurveyParser.AppIconParser.m24885a(r0, r1, r9);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.AppIconModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r0 = com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.AppIconModel.class;
                    r1 = new com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels$FetchNotificationForSurveyModel$AppIconModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.AppIconModel.Serializer.<clinit>():void");
                }
            }

            public AppIconModel() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r1 = this;
                r0 = 1;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.AppIconModel.<init>():void");
            }

            @javax.annotation.Nullable
            public final java.lang.String m24845a() {
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
                r0 = r2.f17148d;
                r1 = 0;
                r0 = super.a(r0, r1);
                r2.f17148d = r0;
                r0 = r2.f17148d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.AppIconModel.a():java.lang.String");
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
                r0 = 70760763; // 0x437b93b float:2.15966E-36 double:3.4960462E-316;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.AppIconModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m24844a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                r0.h();
                r0.i();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.AppIconModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m24843a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                r0 = r2.m24845a();
                r0 = r3.b(r0);
                r1 = 1;
                r3.c(r1);
                r1 = 0;
                r3.b(r1, r0);
                r2.i();
                r0 = r3.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.AppIconModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        /* compiled from: doodle_list */
        public class Deserializer extends FbJsonDeserializer {
            public Deserializer() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r0 = this;
                r0.<init>();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.Deserializer.<init>():void");
            }

            static {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r0 = com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.class;
                r1 = new com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels$FetchNotificationForSurveyModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m24846a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r10 = this;
                r8 = 1;
                r6 = 0;
                r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r4.<init>(r5);
                r5 = com.facebook.structuredsurvey.graphql.SurveyNotificationQueryParsers.FetchNotificationForSurveyParser.m24893a(r11, r4);
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
                r1 = new com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels$FetchNotificationForSurveyModel;
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        /* compiled from: doodle_list */
        public class Serializer extends JsonSerializer<FetchNotificationForSurveyModel> {
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.Serializer.<init>():void");
            }

            public final void m24847a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                r7 = this;
                r8 = (com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel) r8;
                r2 = 0;
                r0 = r8.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r8.m24870a(r0);
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
                com.facebook.structuredsurvey.graphql.SurveyNotificationQueryParsers.FetchNotificationForSurveyParser.m24894a(r0, r1, r9, r10);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
            }

            static {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r0 = com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.class;
                r1 = new com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels$FetchNotificationForSurveyModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.Serializer.<clinit>():void");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1609058445)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: doodle_list */
        public final class TitleForSummaryModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<AggregatedRangesModel> f17153d;
            @Nullable
            private List<RangesModel> f17154e;
            @Nullable
            private String f17155f;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 732242581)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: doodle_list */
            public final class AggregatedRangesModel extends BaseModel implements GraphQLVisitableModel {
                private int f17149d;
                private int f17150e;

                /* compiled from: doodle_list */
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.AggregatedRangesModel.Deserializer.<init>():void");
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
                        r0 = com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.AggregatedRangesModel.class;
                        r1 = new com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels$FetchNotificationForSurveyModel$TitleForSummaryModel$AggregatedRangesModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.AggregatedRangesModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m24848a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                        r5 = com.facebook.structuredsurvey.graphql.SurveyNotificationQueryParsers.FetchNotificationForSurveyParser.TitleForSummaryParser.AggregatedRangesParser.m24887b(r11, r4);
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
                        r1 = new com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels$FetchNotificationForSurveyModel$TitleForSummaryModel$AggregatedRangesModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.AggregatedRangesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: doodle_list */
                public class Serializer extends JsonSerializer<AggregatedRangesModel> {
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.AggregatedRangesModel.Serializer.<init>():void");
                    }

                    public final void m24849a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                        r8 = (com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.AggregatedRangesModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m24851a(r0);
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
                        com.facebook.structuredsurvey.graphql.SurveyNotificationQueryParsers.FetchNotificationForSurveyParser.TitleForSummaryParser.AggregatedRangesParser.m24886a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.AggregatedRangesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.AggregatedRangesModel.class;
                        r1 = new com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels$FetchNotificationForSurveyModel$TitleForSummaryModel$AggregatedRangesModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.AggregatedRangesModel.Serializer.<clinit>():void");
                    }
                }

                public AggregatedRangesModel() {
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.AggregatedRangesModel.<init>():void");
                }

                public final int m24850a() {
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
                    r0 = 0;
                    r1.a(r0, r0);
                    r0 = r1.f17149d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.AggregatedRangesModel.a():int");
                }

                public final int m24854j() {
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
                    r0 = 0;
                    r1 = 1;
                    r2.a(r0, r1);
                    r0 = r2.f17150e;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.AggregatedRangesModel.j():int");
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
                    r0 = 1563462756; // 0x5d308c64 float:7.9510331E17 double:7.724532363E-315;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.AggregatedRangesModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m24852a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                    r0.h();
                    r0.i();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.AggregatedRangesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m24851a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
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
                    r2 = 0;
                    r3.h();
                    r0 = 2;
                    r4.c(r0);
                    r0 = r3.f17149d;
                    r4.a(r2, r0, r2);
                    r0 = 1;
                    r1 = r3.f17150e;
                    r4.a(r0, r1, r2);
                    r3.i();
                    r0 = r4.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.AggregatedRangesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }

                public final void m24853a(com.facebook.flatbuffers.MutableFlatBuffer r3, int r4, java.lang.Object r5) {
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
                    r1 = 0;
                    super.a(r3, r4, r5);
                    r0 = r3.a(r4, r1, r1);
                    r2.f17149d = r0;
                    r0 = 1;
                    r0 = r3.a(r4, r0, r1);
                    r2.f17150e = r0;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.AggregatedRangesModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                }
            }

            /* compiled from: doodle_list */
            public class Deserializer extends FbJsonDeserializer {
                public Deserializer() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r0 = this;
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.Deserializer.<init>():void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r0 = com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.class;
                    r1 = new com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels$FetchNotificationForSurveyModel$TitleForSummaryModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m24855a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.structuredsurvey.graphql.SurveyNotificationQueryParsers.FetchNotificationForSurveyParser.TitleForSummaryParser.m24891a(r11, r4);
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
                    r1 = new com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels$FetchNotificationForSurveyModel$TitleForSummaryModel;
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 732242581)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: doodle_list */
            public final class RangesModel extends BaseModel implements GraphQLVisitableModel {
                private int f17151d;
                private int f17152e;

                /* compiled from: doodle_list */
                public class Deserializer extends FbJsonDeserializer {
                    public Deserializer() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                        /*
                        r0 = this;
                        r0.<init>();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.RangesModel.Deserializer.<init>():void");
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                        /*
                        r0 = com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.RangesModel.class;
                        r1 = new com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels$FetchNotificationForSurveyModel$TitleForSummaryModel$RangesModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.RangesModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m24856a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                        /*
                        r10 = this;
                        r8 = 1;
                        r6 = 0;
                        r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r4.<init>(r5);
                        r5 = com.facebook.structuredsurvey.graphql.SurveyNotificationQueryParsers.FetchNotificationForSurveyParser.TitleForSummaryParser.RangesParser.m24890b(r11, r4);
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
                        r1 = new com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels$FetchNotificationForSurveyModel$TitleForSummaryModel$RangesModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.RangesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: doodle_list */
                public class Serializer extends JsonSerializer<RangesModel> {
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.RangesModel.Serializer.<init>():void");
                    }

                    public final void m24857a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                        r8 = (com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.RangesModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m24859a(r0);
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
                        com.facebook.structuredsurvey.graphql.SurveyNotificationQueryParsers.FetchNotificationForSurveyParser.TitleForSummaryParser.RangesParser.m24889a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.RangesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.RangesModel.class;
                        r1 = new com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels$FetchNotificationForSurveyModel$TitleForSummaryModel$RangesModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.RangesModel.Serializer.<clinit>():void");
                    }
                }

                public RangesModel() {
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.RangesModel.<init>():void");
                }

                public final int m24858a() {
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
                    r0 = 0;
                    r1.a(r0, r0);
                    r0 = r1.f17151d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.RangesModel.a():int");
                }

                public final int m24862j() {
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
                    r0 = 0;
                    r1 = 1;
                    r2.a(r0, r1);
                    r0 = r2.f17152e;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.RangesModel.j():int");
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
                    r0 = -1024511161; // 0xffffffffc2ef3347 float:-119.60015 double:NaN;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.RangesModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m24860a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                    r0.h();
                    r0.i();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.RangesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m24859a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
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
                    r2 = 0;
                    r3.h();
                    r0 = 2;
                    r4.c(r0);
                    r0 = r3.f17151d;
                    r4.a(r2, r0, r2);
                    r0 = 1;
                    r1 = r3.f17152e;
                    r4.a(r0, r1, r2);
                    r3.i();
                    r0 = r4.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.RangesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }

                public final void m24861a(com.facebook.flatbuffers.MutableFlatBuffer r3, int r4, java.lang.Object r5) {
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
                    r1 = 0;
                    super.a(r3, r4, r5);
                    r0 = r3.a(r4, r1, r1);
                    r2.f17151d = r0;
                    r0 = 1;
                    r0 = r3.a(r4, r0, r1);
                    r2.f17152e = r0;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.RangesModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                }
            }

            /* compiled from: doodle_list */
            public class Serializer extends JsonSerializer<TitleForSummaryModel> {
                public Serializer() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r0 = this;
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.Serializer.<init>():void");
                }

                public final void m24863a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r7 = this;
                    r8 = (com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m24864a(r0);
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
                    com.facebook.structuredsurvey.graphql.SurveyNotificationQueryParsers.FetchNotificationForSurveyParser.TitleForSummaryParser.m24892a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r0 = com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.class;
                    r1 = new com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels$FetchNotificationForSurveyModel$TitleForSummaryModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.Serializer.<clinit>():void");
                }
            }

            public TitleForSummaryModel() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r1 = this;
                r0 = 3;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.<init>():void");
            }

            @javax.annotation.Nonnull
            public final com.google.common.collect.ImmutableList<com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.AggregatedRangesModel> m24866a() {
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
                r0 = r3.f17153d;
                r1 = 0;
                r2 = com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.AggregatedRangesModel.class;
                r0 = super.a(r0, r1, r2);
                r3.f17153d = r0;
                r0 = r3.f17153d;
                r0 = (com.google.common.collect.ImmutableList) r0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.a():com.google.common.collect.ImmutableList<com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels$FetchNotificationForSurveyModel$TitleForSummaryModel$AggregatedRangesModel>");
            }

            @javax.annotation.Nonnull
            public final com.google.common.collect.ImmutableList<com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.RangesModel> m24867j() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r3 = this;
                r0 = r3.f17154e;
                r1 = 1;
                r2 = com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.RangesModel.class;
                r0 = super.a(r0, r1, r2);
                r3.f17154e = r0;
                r0 = r3.f17154e;
                r0 = (com.google.common.collect.ImmutableList) r0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.j():com.google.common.collect.ImmutableList<com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels$FetchNotificationForSurveyModel$TitleForSummaryModel$RangesModel>");
            }

            @javax.annotation.Nullable
            public final java.lang.String m24868k() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r2 = this;
                r0 = r2.f17155f;
                r1 = 2;
                r0 = super.a(r0, r1);
                r2.f17155f = r0;
                r0 = r2.f17155f;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.k():java.lang.String");
            }

            public final int jK_() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r1 = this;
                r0 = -1919764332; // 0xffffffff8d92b894 float:-9.04238E-31 double:NaN;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m24865a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
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
                r2 = this;
                r0 = 0;
                r2.h();
                r1 = r2.m24866a();
                if (r1 == 0) goto L_0x0020;
            L_0x000a:
                r1 = r2.m24866a();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                if (r1 == 0) goto L_0x0020;
            L_0x0014:
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
                r0 = (com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel) r0;
                r1 = r1.b();
                r0.f17153d = r1;
            L_0x0020:
                r1 = r2.m24867j();
                if (r1 == 0) goto L_0x003c;
            L_0x0026:
                r1 = r2.m24867j();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                if (r1 == 0) goto L_0x003c;
            L_0x0030:
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
                r0 = (com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel) r0;
                r1 = r1.b();
                r0.f17154e = r1;
            L_0x003c:
                r2.i();
                if (r0 != 0) goto L_0x0042;
            L_0x0041:
                return r2;
            L_0x0042:
                r2 = r0;
                goto L_0x0041;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m24864a(com.facebook.flatbuffers.FlatBufferBuilder r5) {
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
                r4 = this;
                r4.h();
                r0 = r4.m24866a();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r0);
                r1 = r4.m24867j();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r1);
                r2 = r4.m24868k();
                r2 = r5.b(r2);
                r3 = 3;
                r5.c(r3);
                r3 = 0;
                r5.b(r3, r0);
                r0 = 1;
                r5.b(r0, r1);
                r0 = 2;
                r5.b(r0, r2);
                r4.i();
                r0 = r5.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        public FetchNotificationForSurveyModel() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r1 = this;
            r0 = 5;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.<init>():void");
        }

        public final void m24874a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = this;
            r2.a();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
        }

        public final void m24875a(java.lang.String r1, java.lang.Object r2, boolean r3) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.a(java.lang.String, java.lang.Object, boolean):void");
        }

        @javax.annotation.Nullable
        private com.facebook.graphql.enums.GraphQLObjectType m24869m() {
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
            r4 = this;
            r0 = r4.b;
            if (r0 == 0) goto L_0x0017;
        L_0x0004:
            r0 = r4.f17156d;
            if (r0 != 0) goto L_0x0017;
        L_0x0008:
            r0 = r4.b;
            r1 = r4.c;
            r2 = 0;
            r3 = com.facebook.graphql.enums.GraphQLObjectType.class;
            r0 = r0.d(r1, r2, r3);
            r0 = (com.facebook.graphql.enums.GraphQLObjectType) r0;
            r4.f17156d = r0;
        L_0x0017:
            r0 = r4.f17156d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.m():com.facebook.graphql.enums.GraphQLObjectType");
        }

        @javax.annotation.Nonnull
        public final com.google.common.collect.ImmutableList<com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel> m24872a() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = r3.f17157e;
            r1 = 1;
            r2 = com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel.class;
            r0 = super.a(r0, r1, r2);
            r3.f17157e = r0;
            r0 = r3.f17157e;
            r0 = (com.google.common.collect.ImmutableList) r0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.a():com.google.common.collect.ImmutableList<com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels$FetchNotificationForSurveyModel$ActorsModel>");
        }

        @javax.annotation.Nullable
        public final com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.AppIconModel m24876j() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = r3.f17158f;
            r1 = 2;
            r2 = com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.AppIconModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.AppIconModel) r0;
            r3.f17158f = r0;
            r0 = r3.f17158f;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.j():com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels$FetchNotificationForSurveyModel$AppIconModel");
        }

        public final long m24877k() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r2 = this;
            r0 = 0;
            r1 = 3;
            r2.a(r0, r1);
            r0 = r2.f17159g;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.k():long");
        }

        @javax.annotation.Nullable
        public final com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel m24878l() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = r3.f17160h;
            r1 = 4;
            r2 = com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel) r0;
            r3.f17160h = r0;
            r0 = r3.f17160h;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.l():com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels$FetchNotificationForSurveyModel$TitleForSummaryModel");
        }

        public final int jK_() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r1 = this;
            r0 = 2433570; // 0x252222 float:3.410158E-39 double:1.2023433E-317;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m24871a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
            r0 = 0;
            r3.h();
            r1 = r3.m24872a();
            if (r1 == 0) goto L_0x0065;
        L_0x000a:
            r1 = r3.m24872a();
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r4);
            if (r1 == 0) goto L_0x0065;
        L_0x0014:
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r3);
            r0 = (com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel) r0;
            r1 = r1.b();
            r0.f17157e = r1;
            r1 = r0;
        L_0x0021:
            r0 = r3.m24876j();
            if (r0 == 0) goto L_0x003f;
        L_0x0027:
            r0 = r3.m24876j();
            r0 = r4.b(r0);
            r0 = (com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.AppIconModel) r0;
            r2 = r3.m24876j();
            if (r2 == r0) goto L_0x003f;
        L_0x0037:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel) r1;
            r1.f17158f = r0;
        L_0x003f:
            r0 = r3.m24878l();
            if (r0 == 0) goto L_0x005d;
        L_0x0045:
            r0 = r3.m24878l();
            r0 = r4.b(r0);
            r0 = (com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel) r0;
            r2 = r3.m24878l();
            if (r2 == r0) goto L_0x005d;
        L_0x0055:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel) r1;
            r1.f17160h = r0;
        L_0x005d:
            r3.i();
            if (r1 != 0) goto L_0x0063;
        L_0x0062:
            return r3;
        L_0x0063:
            r3 = r1;
            goto L_0x0062;
        L_0x0065:
            r1 = r0;
            goto L_0x0021;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m24870a(com.facebook.flatbuffers.FlatBufferBuilder r8) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r7 = this;
            r7.h();
            r0 = r7.m24869m();
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r8, r0);
            r1 = r7.m24872a();
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r8, r1);
            r2 = r7.m24876j();
            r2 = com.facebook.graphql.modelutil.ModelHelper.a(r8, r2);
            r3 = r7.m24878l();
            r6 = com.facebook.graphql.modelutil.ModelHelper.a(r8, r3);
            r3 = 5;
            r8.c(r3);
            r3 = 0;
            r8.b(r3, r0);
            r0 = 1;
            r8.b(r0, r1);
            r0 = 2;
            r8.b(r0, r2);
            r1 = 3;
            r2 = r7.f17159g;
            r4 = 0;
            r0 = r8;
            r0.a(r1, r2, r4);
            r0 = 4;
            r8.b(r0, r6);
            r7.i();
            r0 = r8.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }

        public final void m24873a(com.facebook.flatbuffers.MutableFlatBuffer r5, int r6, java.lang.Object r7) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            super.a(r5, r6, r7);
            r0 = 3;
            r2 = 0;
            r0 = r5.a(r6, r0, r2);
            r4.f17159g = r0;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
        }
    }
}
