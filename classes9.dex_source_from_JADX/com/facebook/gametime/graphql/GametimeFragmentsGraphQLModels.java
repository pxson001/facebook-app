package com.facebook.gametime.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLInterfaces.GametimeMatchHeaderFragment;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLInterfaces.GametimeMatchHeaderFragment.SportsMatchData;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimeDashboardReactionTailLoadFragmentParser;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimeFanFavoriteAddVoteMutationParser;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimeMatchHeaderLiveUpdatingFragmentParser;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimeMatchHeaderLiveUpdatingFragmentParser.SportsMatchDataParser;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimeMatchHeaderLiveUpdatingFragmentParser.SportsMatchDataParser.ActiveTeamWithBallParser;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimeMatchHeaderQueryParser;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimeMatchHeaderUpdateSubscriptionParser;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimeMatchReactionUnitsFragmentParser;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimePlaySubscriptionParser;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimePlaySubscriptionParser.PlayParser;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimeReactionHeadLoadFragmentParser;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimeReactionTailLoadFragmentParser;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimeReactionUnitsFragmentParser;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimeSportsPlaysQueryParser;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimeSportsPlaysQueryParser.SportsMatchDataParser.FactsParser;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimeSportsPlaysQueryParser.SportsMatchDataParser.FactsParser.EdgesParser;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.GametimeDataFactFragment;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLModels.GametimeDataFactFeedbackFieldsModel;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLModels.GametimeDataFactFragmentModel;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLModels.GametimeDataFactFragmentModel.ActingTeamModel;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLModels.GametimeDataFactFragmentModel.PreviewCommentModel;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLModels.GametimeDataFactFragmentModel.StoryModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoriesModel.EdgesModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitExpirationConditionFragmentModel;
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

/* compiled from: TEMP */
public class GametimeFragmentsGraphQLModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2064806770)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: TEMP */
    public final class GametimeDashboardReactionTailLoadFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GametimeReactionUnitsFragmentModel f24980d;

        /* compiled from: TEMP */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GametimeDashboardReactionTailLoadFragmentModel.class, new Deserializer());
            }

            public Object m26796a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GametimeDashboardReactionTailLoadFragmentParser.m27021a(jsonParser);
                Object gametimeDashboardReactionTailLoadFragmentModel = new GametimeDashboardReactionTailLoadFragmentModel();
                ((BaseModel) gametimeDashboardReactionTailLoadFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (gametimeDashboardReactionTailLoadFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) gametimeDashboardReactionTailLoadFragmentModel).a();
                }
                return gametimeDashboardReactionTailLoadFragmentModel;
            }
        }

        /* compiled from: TEMP */
        public class Serializer extends JsonSerializer<GametimeDashboardReactionTailLoadFragmentModel> {
            public final void m26797a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GametimeDashboardReactionTailLoadFragmentModel gametimeDashboardReactionTailLoadFragmentModel = (GametimeDashboardReactionTailLoadFragmentModel) obj;
                if (gametimeDashboardReactionTailLoadFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(gametimeDashboardReactionTailLoadFragmentModel.m26799a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    gametimeDashboardReactionTailLoadFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = gametimeDashboardReactionTailLoadFragmentModel.w_();
                int u_ = gametimeDashboardReactionTailLoadFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("reaction_units");
                    GametimeReactionUnitsFragmentParser.m27052a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GametimeDashboardReactionTailLoadFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ GametimeReactionUnitsFragmentModel m26800a() {
            return m26798j();
        }

        public GametimeDashboardReactionTailLoadFragmentModel() {
            super(1);
        }

        @Nullable
        private GametimeReactionUnitsFragmentModel m26798j() {
            this.f24980d = (GametimeReactionUnitsFragmentModel) super.a(this.f24980d, 0, GametimeReactionUnitsFragmentModel.class);
            return this.f24980d;
        }

        public final int jK_() {
            return -1619642585;
        }

        public final GraphQLVisitableModel m26801a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26798j() != null) {
                GametimeReactionUnitsFragmentModel gametimeReactionUnitsFragmentModel = (GametimeReactionUnitsFragmentModel) graphQLModelMutatingVisitor.b(m26798j());
                if (m26798j() != gametimeReactionUnitsFragmentModel) {
                    graphQLVisitableModel = (GametimeDashboardReactionTailLoadFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f24980d = gametimeReactionUnitsFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26799a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26798j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: TEMP */
    public final class GametimeFanFavoriteAddVoteMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f24981d;

        /* compiled from: TEMP */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GametimeFanFavoriteAddVoteMutationModel.class, new Deserializer());
            }

            public Object m26802a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GametimeFanFavoriteAddVoteMutationParser.m27022a(jsonParser);
                Object gametimeFanFavoriteAddVoteMutationModel = new GametimeFanFavoriteAddVoteMutationModel();
                ((BaseModel) gametimeFanFavoriteAddVoteMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (gametimeFanFavoriteAddVoteMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) gametimeFanFavoriteAddVoteMutationModel).a();
                }
                return gametimeFanFavoriteAddVoteMutationModel;
            }
        }

        /* compiled from: TEMP */
        public class Serializer extends JsonSerializer<GametimeFanFavoriteAddVoteMutationModel> {
            public final void m26803a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GametimeFanFavoriteAddVoteMutationModel gametimeFanFavoriteAddVoteMutationModel = (GametimeFanFavoriteAddVoteMutationModel) obj;
                if (gametimeFanFavoriteAddVoteMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(gametimeFanFavoriteAddVoteMutationModel.m26805a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    gametimeFanFavoriteAddVoteMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = gametimeFanFavoriteAddVoteMutationModel.w_();
                int u_ = gametimeFanFavoriteAddVoteMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GametimeFanFavoriteAddVoteMutationModel.class, new Serializer());
            }
        }

        public GametimeFanFavoriteAddVoteMutationModel() {
            super(1);
        }

        @Nullable
        private String m26804a() {
            this.f24981d = super.a(this.f24981d, 0);
            return this.f24981d;
        }

        public final int jK_() {
            return 1322750409;
        }

        public final GraphQLVisitableModel m26806a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m26805a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m26804a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1523648181)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: TEMP */
    public final class GametimeMatchHeaderFragmentModel extends BaseModel implements GametimeMatchHeaderFragment, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f25002d;
        @Nullable
        private SportsMatchDataModel f25003e;

        /* compiled from: TEMP */
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.Deserializer.<init>():void");
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
                r0 = com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.class;
                r1 = new com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels$GametimeMatchHeaderFragmentModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m26807a(com.fasterxml.jackson.core.JsonParser r6, com.fasterxml.jackson.databind.DeserializationContext r7) {
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
                r2 = com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimeMatchHeaderFragmentParser.m27033a(r6);
                r1 = new com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels$GametimeMatchHeaderFragmentModel;
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        /* compiled from: TEMP */
        public class Serializer extends JsonSerializer<GametimeMatchHeaderFragmentModel> {
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.Serializer.<init>():void");
            }

            public final void m26808a(java.lang.Object r9, com.fasterxml.jackson.core.JsonGenerator r10, com.fasterxml.jackson.databind.SerializerProvider r11) {
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
                r8 = this;
                r9 = (com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel) r9;
                r2 = 0;
                r0 = r9.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r9.m26862a(r0);
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
                r7 = "sports_match_data";
                r10.a(r7);
                com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimeMatchHeaderFragmentParser.SportsMatchDataParser.m27032a(r0, r6, r10, r11);
            L_0x0062:
                r10.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                r0 = com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.class;
                r1 = new com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels$GametimeMatchHeaderFragmentModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.Serializer.<clinit>():void");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 133902670)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: TEMP */
        public final class SportsMatchDataModel extends BaseModel implements SportsMatchData, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private ActiveTeamWithBallModel f24990d;
            @Nullable
            private AwayTeamObjectModel f24991e;
            @Nullable
            private String f24992f;
            private int f24993g;
            private boolean f24994h;
            @Nullable
            private HomeTeamObjectModel f24995i;
            @Nullable
            private String f24996j;
            private int f24997k;
            @Nullable
            private String f24998l;
            @Nullable
            private String f24999m;
            @Nullable
            private String f25000n;
            private long f25001o;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -758980457)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: TEMP */
            public final class AwayTeamObjectModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f24983d;
                @Nullable
                private OfficialPageModel f24984e;
                @Nullable
                private String f24985f;

                /* compiled from: TEMP */
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.Deserializer.<init>():void");
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
                        r0 = com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.class;
                        r1 = new com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels$GametimeMatchHeaderFragmentModel$SportsMatchDataModel$AwayTeamObjectModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m26809a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                        r5 = com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimeMatchHeaderFragmentParser.SportsMatchDataParser.AwayTeamObjectParser.m27025a(r11, r4);
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
                        r1 = new com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels$GametimeMatchHeaderFragmentModel$SportsMatchDataModel$AwayTeamObjectModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1801334754)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: TEMP */
                public final class OfficialPageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private String f24982d;

                    /* compiled from: TEMP */
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.OfficialPageModel.Deserializer.<init>():void");
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
                            r0 = com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.OfficialPageModel.class;
                            r1 = new com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels$GametimeMatchHeaderFragmentModel$SportsMatchDataModel$AwayTeamObjectModel$OfficialPageModel$Deserializer;
                            r1.<init>();
                            com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.OfficialPageModel.Deserializer.<clinit>():void");
                        }

                        public java.lang.Object m26810a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                            r5 = com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimeMatchHeaderFragmentParser.SportsMatchDataParser.AwayTeamObjectParser.OfficialPageParser.m27023a(r11, r4);
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
                            r1 = new com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels$GametimeMatchHeaderFragmentModel$SportsMatchDataModel$AwayTeamObjectModel$OfficialPageModel;
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.OfficialPageModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                        }
                    }

                    /* compiled from: TEMP */
                    public class Serializer extends JsonSerializer<OfficialPageModel> {
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.OfficialPageModel.Serializer.<init>():void");
                        }

                        public final void m26811a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                            r8 = (com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.OfficialPageModel) r8;
                            r2 = 0;
                            r0 = r8.w_();
                            if (r0 != 0) goto L_0x0035;
                        L_0x0009:
                            r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r0.<init>(r1);
                            r1 = r8.m26813a(r0);
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
                            com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimeMatchHeaderFragmentParser.SportsMatchDataParser.AwayTeamObjectParser.OfficialPageParser.m27024a(r0, r1, r9);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.OfficialPageModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                            r0 = com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.OfficialPageModel.class;
                            r1 = new com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels$GametimeMatchHeaderFragmentModel$SportsMatchDataModel$AwayTeamObjectModel$OfficialPageModel$Serializer;
                            r1.<init>();
                            com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.OfficialPageModel.Serializer.<clinit>():void");
                        }
                    }

                    public OfficialPageModel() {
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.OfficialPageModel.<init>():void");
                    }

                    public final void m26816a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
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
                        r2.a();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.OfficialPageModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
                    }

                    public final void m26817a(java.lang.String r1, java.lang.Object r2, boolean r3) {
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
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.OfficialPageModel.a(java.lang.String, java.lang.Object, boolean):void");
                    }

                    @javax.annotation.Nullable
                    private java.lang.String m26812j() {
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
                        r0 = r2.f24982d;
                        r1 = 0;
                        r0 = super.a(r0, r1);
                        r2.f24982d = r0;
                        r0 = r2.f24982d;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.OfficialPageModel.j():java.lang.String");
                    }

                    @javax.annotation.Nullable
                    public final java.lang.String m26815a() {
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
                        r0 = r1.m26812j();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.OfficialPageModel.a():java.lang.String");
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
                        r0 = 2479791; // 0x25d6af float:3.474927E-39 double:1.2251795E-317;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.OfficialPageModel.jK_():int");
                    }

                    public final com.facebook.graphql.visitor.GraphQLVisitableModel m26814a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.OfficialPageModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                    }

                    public final int m26813a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                        r0 = r2.m26812j();
                        r0 = r3.b(r0);
                        r1 = 1;
                        r3.c(r1);
                        r1 = 0;
                        r3.b(r1, r0);
                        r2.i();
                        r0 = r3.d();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.OfficialPageModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                    }
                }

                /* compiled from: TEMP */
                public class Serializer extends JsonSerializer<AwayTeamObjectModel> {
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.Serializer.<init>():void");
                    }

                    public final void m26818a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                        r8 = (com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m26821a(r0);
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
                        com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimeMatchHeaderFragmentParser.SportsMatchDataParser.AwayTeamObjectParser.m27026a(r0, r1, r9, r10);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.class;
                        r1 = new com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels$GametimeMatchHeaderFragmentModel$SportsMatchDataModel$AwayTeamObjectModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.Serializer.<clinit>():void");
                    }
                }

                public AwayTeamObjectModel() {
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
                    r0 = 3;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.<init>():void");
                }

                @javax.annotation.Nullable
                private com.facebook.graphql.enums.GraphQLObjectType m26819j() {
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
                    r0 = r4.b;
                    if (r0 == 0) goto L_0x0017;
                L_0x0004:
                    r0 = r4.f24983d;
                    if (r0 != 0) goto L_0x0017;
                L_0x0008:
                    r0 = r4.b;
                    r1 = r4.c;
                    r2 = 0;
                    r3 = com.facebook.graphql.enums.GraphQLObjectType.class;
                    r0 = r0.d(r1, r2, r3);
                    r0 = (com.facebook.graphql.enums.GraphQLObjectType) r0;
                    r4.f24983d = r0;
                L_0x0017:
                    r0 = r4.f24983d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.j():com.facebook.graphql.enums.GraphQLObjectType");
                }

                @javax.annotation.Nullable
                private com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.OfficialPageModel m26820k() {
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
                    r0 = r3.f24984e;
                    r1 = 1;
                    r2 = com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.OfficialPageModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.OfficialPageModel) r0;
                    r3.f24984e = r0;
                    r0 = r3.f24984e;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.k():com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels$GametimeMatchHeaderFragmentModel$SportsMatchDataModel$AwayTeamObjectModel$OfficialPageModel");
                }

                @javax.annotation.Nullable
                public final java.lang.String m26823a() {
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
                    r0 = r2.f24985f;
                    r1 = 2;
                    r0 = super.a(r0, r1);
                    r2.f24985f = r0;
                    r0 = r2.f24985f;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.a():java.lang.String");
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
                    r0 = 2002223772; // 0x7757829c float:4.371066E33 double:9.89229981E-315;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m26822a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
                    r0 = r3.m26820k();
                    if (r0 == 0) goto L_0x0022;
                L_0x000a:
                    r0 = r3.m26820k();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.OfficialPageModel) r0;
                    r2 = r3.m26820k();
                    if (r2 == r0) goto L_0x0022;
                L_0x001a:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel) r1;
                    r1.f24984e = r0;
                L_0x0022:
                    r3.i();
                    if (r1 != 0) goto L_0x0028;
                L_0x0027:
                    return r3;
                L_0x0028:
                    r3 = r1;
                    goto L_0x0027;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m26821a(com.facebook.flatbuffers.FlatBufferBuilder r5) {
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
                    r4.h();
                    r0 = r4.m26819j();
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r0);
                    r1 = r4.m26820k();
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r1);
                    r2 = r4.m26823a();
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: TEMP */
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.Deserializer.<init>():void");
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
                    r0 = com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.class;
                    r1 = new com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels$GametimeMatchHeaderFragmentModel$SportsMatchDataModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m26824a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                    r5 = com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimeMatchHeaderFragmentParser.SportsMatchDataParser.m27031a(r11, r4);
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
                    r1 = new com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels$GametimeMatchHeaderFragmentModel$SportsMatchDataModel;
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -566435518)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: TEMP */
            public final class HomeTeamObjectModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f24987d;
                @Nullable
                private OfficialPageModel f24988e;
                @Nullable
                private String f24989f;

                /* compiled from: TEMP */
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.Deserializer.<init>():void");
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
                        r0 = com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.class;
                        r1 = new com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels$GametimeMatchHeaderFragmentModel$SportsMatchDataModel$HomeTeamObjectModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m26825a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                        r5 = com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimeMatchHeaderFragmentParser.SportsMatchDataParser.HomeTeamObjectParser.m27029a(r11, r4);
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
                        r1 = new com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels$GametimeMatchHeaderFragmentModel$SportsMatchDataModel$HomeTeamObjectModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1801334754)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: TEMP */
                public final class OfficialPageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private String f24986d;

                    /* compiled from: TEMP */
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.OfficialPageModel.Deserializer.<init>():void");
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
                            r0 = com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.OfficialPageModel.class;
                            r1 = new com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels$GametimeMatchHeaderFragmentModel$SportsMatchDataModel$HomeTeamObjectModel$OfficialPageModel$Deserializer;
                            r1.<init>();
                            com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.OfficialPageModel.Deserializer.<clinit>():void");
                        }

                        public java.lang.Object m26826a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                            r5 = com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimeMatchHeaderFragmentParser.SportsMatchDataParser.HomeTeamObjectParser.OfficialPageParser.m27027a(r11, r4);
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
                            r1 = new com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels$GametimeMatchHeaderFragmentModel$SportsMatchDataModel$HomeTeamObjectModel$OfficialPageModel;
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.OfficialPageModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                        }
                    }

                    /* compiled from: TEMP */
                    public class Serializer extends JsonSerializer<OfficialPageModel> {
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.OfficialPageModel.Serializer.<init>():void");
                        }

                        public final void m26827a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                            r8 = (com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.OfficialPageModel) r8;
                            r2 = 0;
                            r0 = r8.w_();
                            if (r0 != 0) goto L_0x0035;
                        L_0x0009:
                            r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r0.<init>(r1);
                            r1 = r8.m26829a(r0);
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
                            com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimeMatchHeaderFragmentParser.SportsMatchDataParser.HomeTeamObjectParser.OfficialPageParser.m27028a(r0, r1, r9);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.OfficialPageModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                            r0 = com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.OfficialPageModel.class;
                            r1 = new com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels$GametimeMatchHeaderFragmentModel$SportsMatchDataModel$HomeTeamObjectModel$OfficialPageModel$Serializer;
                            r1.<init>();
                            com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.OfficialPageModel.Serializer.<clinit>():void");
                        }
                    }

                    public OfficialPageModel() {
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.OfficialPageModel.<init>():void");
                    }

                    public final void m26832a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
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
                        r2.a();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.OfficialPageModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
                    }

                    public final void m26833a(java.lang.String r1, java.lang.Object r2, boolean r3) {
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
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.OfficialPageModel.a(java.lang.String, java.lang.Object, boolean):void");
                    }

                    @javax.annotation.Nullable
                    private java.lang.String m26828j() {
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
                        r0 = r2.f24986d;
                        r1 = 0;
                        r0 = super.a(r0, r1);
                        r2.f24986d = r0;
                        r0 = r2.f24986d;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.OfficialPageModel.j():java.lang.String");
                    }

                    @javax.annotation.Nullable
                    public final java.lang.String m26831a() {
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
                        r0 = r1.m26828j();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.OfficialPageModel.a():java.lang.String");
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
                        r0 = 2479791; // 0x25d6af float:3.474927E-39 double:1.2251795E-317;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.OfficialPageModel.jK_():int");
                    }

                    public final com.facebook.graphql.visitor.GraphQLVisitableModel m26830a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.OfficialPageModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                    }

                    public final int m26829a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                        r0 = r2.m26828j();
                        r0 = r3.b(r0);
                        r1 = 1;
                        r3.c(r1);
                        r1 = 0;
                        r3.b(r1, r0);
                        r2.i();
                        r0 = r3.d();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.OfficialPageModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                    }
                }

                /* compiled from: TEMP */
                public class Serializer extends JsonSerializer<HomeTeamObjectModel> {
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.Serializer.<init>():void");
                    }

                    public final void m26834a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                        r8 = (com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m26837a(r0);
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
                        com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimeMatchHeaderFragmentParser.SportsMatchDataParser.HomeTeamObjectParser.m27030a(r0, r1, r9, r10);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.class;
                        r1 = new com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels$GametimeMatchHeaderFragmentModel$SportsMatchDataModel$HomeTeamObjectModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.Serializer.<clinit>():void");
                    }
                }

                public HomeTeamObjectModel() {
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
                    r0 = 3;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.<init>():void");
                }

                @javax.annotation.Nullable
                private com.facebook.graphql.enums.GraphQLObjectType m26835j() {
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
                    r0 = r4.b;
                    if (r0 == 0) goto L_0x0017;
                L_0x0004:
                    r0 = r4.f24987d;
                    if (r0 != 0) goto L_0x0017;
                L_0x0008:
                    r0 = r4.b;
                    r1 = r4.c;
                    r2 = 0;
                    r3 = com.facebook.graphql.enums.GraphQLObjectType.class;
                    r0 = r0.d(r1, r2, r3);
                    r0 = (com.facebook.graphql.enums.GraphQLObjectType) r0;
                    r4.f24987d = r0;
                L_0x0017:
                    r0 = r4.f24987d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.j():com.facebook.graphql.enums.GraphQLObjectType");
                }

                @javax.annotation.Nullable
                private com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.OfficialPageModel m26836k() {
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
                    r0 = r3.f24988e;
                    r1 = 1;
                    r2 = com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.OfficialPageModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.OfficialPageModel) r0;
                    r3.f24988e = r0;
                    r0 = r3.f24988e;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.k():com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels$GametimeMatchHeaderFragmentModel$SportsMatchDataModel$HomeTeamObjectModel$OfficialPageModel");
                }

                @javax.annotation.Nullable
                public final java.lang.String m26839a() {
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
                    r0 = r2.f24989f;
                    r1 = 2;
                    r0 = super.a(r0, r1);
                    r2.f24989f = r0;
                    r0 = r2.f24989f;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.a():java.lang.String");
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
                    r0 = 2002223772; // 0x7757829c float:4.371066E33 double:9.89229981E-315;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m26838a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
                    r0 = r3.m26836k();
                    if (r0 == 0) goto L_0x0022;
                L_0x000a:
                    r0 = r3.m26836k();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.OfficialPageModel) r0;
                    r2 = r3.m26836k();
                    if (r2 == r0) goto L_0x0022;
                L_0x001a:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel) r1;
                    r1.f24988e = r0;
                L_0x0022:
                    r3.i();
                    if (r1 != 0) goto L_0x0028;
                L_0x0027:
                    return r3;
                L_0x0028:
                    r3 = r1;
                    goto L_0x0027;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m26837a(com.facebook.flatbuffers.FlatBufferBuilder r5) {
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
                    r4.h();
                    r0 = r4.m26835j();
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r0);
                    r1 = r4.m26836k();
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r1);
                    r2 = r4.m26839a();
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: TEMP */
            public class Serializer extends JsonSerializer<SportsMatchDataModel> {
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.Serializer.<init>():void");
                }

                public final void m26840a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                    r7 = this;
                    r8 = (com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m26849a(r0);
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
                    com.facebook.gametime.graphql.GametimeFragmentsGraphQLParsers.GametimeMatchHeaderFragmentParser.SportsMatchDataParser.m27032a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                    r0 = com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.class;
                    r1 = new com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels$GametimeMatchHeaderFragmentModel$SportsMatchDataModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.Serializer.<clinit>():void");
                }
            }

            @javax.annotation.Nullable
            public final /* synthetic */ com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel mo1164b() {
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
                r0 = r1.m26845l();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.b():com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels$GametimeMatchHeaderFragmentModel$SportsMatchDataModel$AwayTeamObjectModel");
            }

            @javax.annotation.Nullable
            public final /* synthetic */ com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel mo1167g() {
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
                r0 = r1.m26846m();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.g():com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels$GametimeMatchHeaderFragmentModel$SportsMatchDataModel$HomeTeamObjectModel");
            }

            public SportsMatchDataModel() {
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
                r0 = 12;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.<init>():void");
            }

            public final void m26853a(java.lang.String r2, com.facebook.graphql.visitor.ConsistencyTuple r3) {
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
                r0 = "away_team_score";
                r0 = r0.equals(r2);
                if (r0 == 0) goto L_0x001c;
            L_0x0008:
                r0 = r1.mo1166d();
                r0 = java.lang.Integer.valueOf(r0);
                r3.a = r0;
                r0 = r1.u_();
                r3.b = r0;
                r0 = 3;
                r3.c = r0;
            L_0x001b:
                return;
            L_0x001c:
                r0 = "home_team_score";
                r0 = r0.equals(r2);
                if (r0 == 0) goto L_0x0038;
            L_0x0024:
                r0 = r1.mD_();
                r0 = java.lang.Integer.valueOf(r0);
                r3.a = r0;
                r0 = r1.u_();
                r3.b = r0;
                r0 = 7;
                r3.c = r0;
                goto L_0x001b;
            L_0x0038:
                r0 = "status_text";
                r0 = r0.equals(r2);
                if (r0 == 0) goto L_0x0051;
            L_0x0040:
                r0 = r1.mo1168j();
                r3.a = r0;
                r0 = r1.u_();
                r3.b = r0;
                r0 = 10;
                r3.c = r0;
                goto L_0x001b;
            L_0x0051:
                r3.a();
                goto L_0x001b;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
            }

            public final void m26854a(java.lang.String r2, java.lang.Object r3, boolean r4) {
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
                r0 = "away_team_score";
                r0 = r0.equals(r2);
                if (r0 == 0) goto L_0x0012;
            L_0x0008:
                r3 = (java.lang.Integer) r3;
                r0 = r3.intValue();
                r1.m26841a(r0);
            L_0x0011:
                return;
            L_0x0012:
                r0 = "home_team_score";
                r0 = r0.equals(r2);
                if (r0 == 0) goto L_0x0024;
            L_0x001a:
                r3 = (java.lang.Integer) r3;
                r0 = r3.intValue();
                r1.m26843b(r0);
                goto L_0x0011;
            L_0x0024:
                r0 = "status_text";
                r0 = r0.equals(r2);
                if (r0 == 0) goto L_0x0011;
            L_0x002c:
                r3 = (java.lang.String) r3;
                r1.m26842a(r3);
                goto L_0x0011;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.a(java.lang.String, java.lang.Object, boolean):void");
            }

            @javax.annotation.Nullable
            private com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderLiveUpdatingFragmentModel.SportsMatchDataModel.ActiveTeamWithBallModel m26844k() {
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
                r0 = r3.f24990d;
                r1 = 0;
                r2 = com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderLiveUpdatingFragmentModel.SportsMatchDataModel.ActiveTeamWithBallModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderLiveUpdatingFragmentModel.SportsMatchDataModel.ActiveTeamWithBallModel) r0;
                r3.f24990d = r0;
                r0 = r3.f24990d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.k():com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels$GametimeMatchHeaderLiveUpdatingFragmentModel$SportsMatchDataModel$ActiveTeamWithBallModel");
            }

            @javax.annotation.Nullable
            private com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel m26845l() {
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
                r0 = r3.f24991e;
                r1 = 1;
                r2 = com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel) r0;
                r3.f24991e = r0;
                r0 = r3.f24991e;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.l():com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels$GametimeMatchHeaderFragmentModel$SportsMatchDataModel$AwayTeamObjectModel");
            }

            @javax.annotation.Nullable
            public final java.lang.String mo1165c() {
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
                r0 = r2.f24992f;
                r1 = 2;
                r0 = super.a(r0, r1);
                r2.f24992f = r0;
                r0 = r2.f24992f;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.c():java.lang.String");
            }

            public final int mo1166d() {
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
                r1 = 3;
                r2.a(r0, r1);
                r0 = r2.f24993g;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.d():int");
            }

            private void m26841a(int r5) {
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
                r4.f24993g = r5;
                r0 = r4.b;
                if (r0 == 0) goto L_0x0015;
            L_0x0006:
                r0 = r4.b;
                r3 = r0.d;
                r0 = r3;
                if (r0 == 0) goto L_0x0015;
            L_0x000d:
                r0 = r4.b;
                r1 = r4.c;
                r2 = 3;
                r0.b(r1, r2, r5);
            L_0x0015:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.a(int):void");
            }

            public final boolean mB_() {
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
                r1 = 4;
                r2.a(r0, r1);
                r0 = r2.f24994h;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.mB_():boolean");
            }

            @javax.annotation.Nullable
            private com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel m26846m() {
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
                r0 = r3.f24995i;
                r1 = 5;
                r2 = com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel) r0;
                r3.f24995i = r0;
                r0 = r3.f24995i;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.m():com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels$GametimeMatchHeaderFragmentModel$SportsMatchDataModel$HomeTeamObjectModel");
            }

            @javax.annotation.Nullable
            public final java.lang.String mC_() {
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
                r0 = r2.f24996j;
                r1 = 6;
                r0 = super.a(r0, r1);
                r2.f24996j = r0;
                r0 = r2.f24996j;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.mC_():java.lang.String");
            }

            public final int mD_() {
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
                r1 = 7;
                r2.a(r0, r1);
                r0 = r2.f24997k;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.mD_():int");
            }

            private void m26843b(int r5) {
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
                r4.f24997k = r5;
                r0 = r4.b;
                if (r0 == 0) goto L_0x0015;
            L_0x0006:
                r0 = r4.b;
                r3 = r0.d;
                r0 = r3;
                if (r0 == 0) goto L_0x0015;
            L_0x000d:
                r0 = r4.b;
                r1 = r4.c;
                r2 = 7;
                r0.b(r1, r2, r5);
            L_0x0015:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.b(int):void");
            }

            @javax.annotation.Nullable
            private java.lang.String m26847n() {
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
                r0 = r2.f24998l;
                r1 = 8;
                r0 = super.a(r0, r1);
                r2.f24998l = r0;
                r0 = r2.f24998l;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.n():java.lang.String");
            }

            @javax.annotation.Nullable
            private java.lang.String m26848o() {
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
                r0 = r2.f24999m;
                r1 = 9;
                r0 = super.a(r0, r1);
                r2.f24999m = r0;
                r0 = r2.f24999m;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.o():java.lang.String");
            }

            @javax.annotation.Nullable
            public final java.lang.String mo1168j() {
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
                r0 = r2.f25000n;
                r1 = 10;
                r0 = super.a(r0, r1);
                r2.f25000n = r0;
                r0 = r2.f25000n;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.j():java.lang.String");
            }

            private void m26842a(@javax.annotation.Nullable java.lang.String r5) {
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
                r4.f25000n = r5;
                r0 = r4.b;
                if (r0 == 0) goto L_0x0016;
            L_0x0006:
                r0 = r4.b;
                r3 = r0.d;
                r0 = r3;
                if (r0 == 0) goto L_0x0016;
            L_0x000d:
                r0 = r4.b;
                r1 = r4.c;
                r2 = 10;
                r0.a(r1, r2, r5);
            L_0x0016:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.a(java.lang.String):void");
            }

            @javax.annotation.Nullable
            public final java.lang.String m26851a() {
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
                r0 = r1.m26847n();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.a():java.lang.String");
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
                r0 = 827365670; // 0x31509926 float:3.0355038E-9 double:4.08772954E-315;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m26850a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
                r0 = r3.m26844k();
                if (r0 == 0) goto L_0x0022;
            L_0x000a:
                r0 = r3.m26844k();
                r0 = r4.b(r0);
                r0 = (com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderLiveUpdatingFragmentModel.SportsMatchDataModel.ActiveTeamWithBallModel) r0;
                r2 = r3.m26844k();
                if (r2 == r0) goto L_0x0022;
            L_0x001a:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel) r1;
                r1.f24990d = r0;
            L_0x0022:
                r0 = r3.m26845l();
                if (r0 == 0) goto L_0x0040;
            L_0x0028:
                r0 = r3.m26845l();
                r0 = r4.b(r0);
                r0 = (com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.AwayTeamObjectModel) r0;
                r2 = r3.m26845l();
                if (r2 == r0) goto L_0x0040;
            L_0x0038:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel) r1;
                r1.f24991e = r0;
            L_0x0040:
                r0 = r3.m26846m();
                if (r0 == 0) goto L_0x005e;
            L_0x0046:
                r0 = r3.m26846m();
                r0 = r4.b(r0);
                r0 = (com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.HomeTeamObjectModel) r0;
                r2 = r3.m26846m();
                if (r2 == r0) goto L_0x005e;
            L_0x0056:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel) r1;
                r1.f24995i = r0;
            L_0x005e:
                r3.i();
                if (r1 != 0) goto L_0x0064;
            L_0x0063:
                return r3;
            L_0x0064:
                r3 = r1;
                goto L_0x0063;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m26849a(com.facebook.flatbuffers.FlatBufferBuilder r11) {
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
                r10 = this;
                r9 = 0;
                r10.h();
                r0 = r10.m26844k();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r11, r0);
                r1 = r10.m26845l();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r11, r1);
                r2 = r10.mo1165c();
                r2 = r11.b(r2);
                r3 = r10.m26846m();
                r3 = com.facebook.graphql.modelutil.ModelHelper.a(r11, r3);
                r4 = r10.mC_();
                r4 = r11.b(r4);
                r5 = r10.m26847n();
                r5 = r11.b(r5);
                r6 = r10.m26848o();
                r6 = r11.b(r6);
                r7 = r10.mo1168j();
                r7 = r11.b(r7);
                r8 = 12;
                r11.c(r8);
                r11.b(r9, r0);
                r0 = 1;
                r11.b(r0, r1);
                r0 = 2;
                r11.b(r0, r2);
                r0 = 3;
                r1 = r10.f24993g;
                r11.a(r0, r1, r9);
                r0 = 4;
                r1 = r10.f24994h;
                r11.a(r0, r1);
                r0 = 5;
                r11.b(r0, r3);
                r0 = 6;
                r11.b(r0, r4);
                r0 = 7;
                r1 = r10.f24997k;
                r11.a(r0, r1, r9);
                r0 = 8;
                r11.b(r0, r5);
                r0 = 9;
                r11.b(r0, r6);
                r0 = 10;
                r11.b(r0, r7);
                r1 = 11;
                r2 = r10.f25001o;
                r4 = 0;
                r0 = r11;
                r0.a(r1, r2, r4);
                r10.i();
                r0 = r11.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }

            public final void m26852a(com.facebook.flatbuffers.MutableFlatBuffer r5, int r6, java.lang.Object r7) {
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
                r1 = 0;
                super.a(r5, r6, r7);
                r0 = 3;
                r0 = r5.a(r6, r0, r1);
                r4.f24993g = r0;
                r0 = 4;
                r0 = r5.a(r6, r0);
                r4.f24994h = r0;
                r0 = 7;
                r0 = r5.a(r6, r0, r1);
                r4.f24997k = r0;
                r0 = 11;
                r2 = 0;
                r0 = r5.a(r6, r0, r2);
                r4.f25001o = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
            }
        }

        public GametimeMatchHeaderFragmentModel() {
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
            r0 = 2;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.<init>():void");
        }

        public final void m26865a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
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
            r0 = this;
            r2.a();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
        }

        public final void m26866a(java.lang.String r1, java.lang.Object r2, boolean r3) {
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
            r0 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.a(java.lang.String, java.lang.Object, boolean):void");
        }

        @javax.annotation.Nullable
        private java.lang.String m26860j() {
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
            r2 = this;
            r0 = r2.f25002d;
            r1 = 0;
            r0 = super.a(r0, r1);
            r2.f25002d = r0;
            r0 = r2.f25002d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.j():java.lang.String");
        }

        @javax.annotation.Nullable
        private com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel m26861k() {
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
            r0 = r3.f25003e;
            r1 = 1;
            r2 = com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel) r0;
            r3.f25003e = r0;
            r0 = r3.f25003e;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.k():com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels$GametimeMatchHeaderFragmentModel$SportsMatchDataModel");
        }

        @javax.annotation.Nullable
        public final java.lang.String m26864a() {
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
            r0 = r1.m26860j();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.a():java.lang.String");
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
            r0 = 2479791; // 0x25d6af float:3.474927E-39 double:1.2251795E-317;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m26863a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
            r1 = 0;
            r3.h();
            r0 = r3.m26861k();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m26861k();
            r0 = r4.b(r0);
            r0 = (com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.SportsMatchDataModel) r0;
            r2 = r3.m26861k();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel) r1;
            r1.f25003e = r0;
        L_0x0022:
            r3.i();
            if (r1 != 0) goto L_0x0028;
        L_0x0027:
            return r3;
        L_0x0028:
            r3 = r1;
            goto L_0x0027;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m26862a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
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
            r0 = r3.m26860j();
            r0 = r4.b(r0);
            r1 = r3.m26861k();
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderFragmentModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1295816831)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: TEMP */
    public final class GametimeMatchHeaderLiveUpdatingFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f25013d;
        @Nullable
        private SportsMatchDataModel f25014e;

        /* compiled from: TEMP */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GametimeMatchHeaderLiveUpdatingFragmentModel.class, new Deserializer());
            }

            public Object m26867a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GametimeMatchHeaderLiveUpdatingFragmentParser.m27038a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object gametimeMatchHeaderLiveUpdatingFragmentModel = new GametimeMatchHeaderLiveUpdatingFragmentModel();
                ((BaseModel) gametimeMatchHeaderLiveUpdatingFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (gametimeMatchHeaderLiveUpdatingFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) gametimeMatchHeaderLiveUpdatingFragmentModel).a();
                }
                return gametimeMatchHeaderLiveUpdatingFragmentModel;
            }
        }

        /* compiled from: TEMP */
        public class Serializer extends JsonSerializer<GametimeMatchHeaderLiveUpdatingFragmentModel> {
            public final void m26868a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GametimeMatchHeaderLiveUpdatingFragmentModel gametimeMatchHeaderLiveUpdatingFragmentModel = (GametimeMatchHeaderLiveUpdatingFragmentModel) obj;
                if (gametimeMatchHeaderLiveUpdatingFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(gametimeMatchHeaderLiveUpdatingFragmentModel.m26896a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    gametimeMatchHeaderLiveUpdatingFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GametimeMatchHeaderLiveUpdatingFragmentParser.m27039a(gametimeMatchHeaderLiveUpdatingFragmentModel.w_(), gametimeMatchHeaderLiveUpdatingFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(GametimeMatchHeaderLiveUpdatingFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -512598103)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: TEMP */
        public final class SportsMatchDataModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private ActiveTeamWithBallModel f25005d;
            private int f25006e;
            private boolean f25007f;
            private int f25008g;
            @Nullable
            private String f25009h;
            @Nullable
            private String f25010i;
            @Nullable
            private String f25011j;
            private long f25012k;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1801334754)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: TEMP */
            public final class ActiveTeamWithBallModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f25004d;

                /* compiled from: TEMP */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ActiveTeamWithBallModel.class, new Deserializer());
                    }

                    public Object m26869a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ActiveTeamWithBallParser.m27034a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object activeTeamWithBallModel = new ActiveTeamWithBallModel();
                        ((BaseModel) activeTeamWithBallModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (activeTeamWithBallModel instanceof Postprocessable) {
                            return ((Postprocessable) activeTeamWithBallModel).a();
                        }
                        return activeTeamWithBallModel;
                    }
                }

                /* compiled from: TEMP */
                public class Serializer extends JsonSerializer<ActiveTeamWithBallModel> {
                    public final void m26870a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ActiveTeamWithBallModel activeTeamWithBallModel = (ActiveTeamWithBallModel) obj;
                        if (activeTeamWithBallModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(activeTeamWithBallModel.m26872a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            activeTeamWithBallModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ActiveTeamWithBallParser.m27035a(activeTeamWithBallModel.w_(), activeTeamWithBallModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ActiveTeamWithBallModel.class, new Serializer());
                    }
                }

                public ActiveTeamWithBallModel() {
                    super(1);
                }

                public final void m26875a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m26876a(String str, Object obj, boolean z) {
                }

                @Nullable
                private String m26871j() {
                    this.f25004d = super.a(this.f25004d, 0);
                    return this.f25004d;
                }

                @Nullable
                public final String m26874a() {
                    return m26871j();
                }

                public final int jK_() {
                    return 2479791;
                }

                public final GraphQLVisitableModel m26873a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m26872a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m26871j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: TEMP */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SportsMatchDataModel.class, new Deserializer());
                }

                public Object m26877a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SportsMatchDataParser.m27036a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object sportsMatchDataModel = new SportsMatchDataModel();
                    ((BaseModel) sportsMatchDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (sportsMatchDataModel instanceof Postprocessable) {
                        return ((Postprocessable) sportsMatchDataModel).a();
                    }
                    return sportsMatchDataModel;
                }
            }

            /* compiled from: TEMP */
            public class Serializer extends JsonSerializer<SportsMatchDataModel> {
                public final void m26878a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SportsMatchDataModel sportsMatchDataModel = (SportsMatchDataModel) obj;
                    if (sportsMatchDataModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(sportsMatchDataModel.m26888a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        sportsMatchDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SportsMatchDataParser.m27037a(sportsMatchDataModel.w_(), sportsMatchDataModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SportsMatchDataModel.class, new Serializer());
                }
            }

            public SportsMatchDataModel() {
                super(8);
            }

            public final void m26892a(String str, ConsistencyTuple consistencyTuple) {
                if ("away_team_score".equals(str)) {
                    consistencyTuple.a = Integer.valueOf(m26883k());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                } else if ("home_team_score".equals(str)) {
                    consistencyTuple.a = Integer.valueOf(m26884l());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 3;
                } else if ("status_text".equals(str)) {
                    consistencyTuple.a = m26887o();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 6;
                } else {
                    consistencyTuple.a();
                }
            }

            public final void m26893a(String str, Object obj, boolean z) {
                if ("away_team_score".equals(str)) {
                    m26879a(((Integer) obj).intValue());
                } else if ("home_team_score".equals(str)) {
                    m26881b(((Integer) obj).intValue());
                } else if ("status_text".equals(str)) {
                    m26880a((String) obj);
                }
            }

            @Nullable
            private ActiveTeamWithBallModel m26882j() {
                this.f25005d = (ActiveTeamWithBallModel) super.a(this.f25005d, 0, ActiveTeamWithBallModel.class);
                return this.f25005d;
            }

            private int m26883k() {
                a(0, 1);
                return this.f25006e;
            }

            private void m26879a(int i) {
                this.f25006e = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 1, i);
                }
            }

            private int m26884l() {
                a(0, 3);
                return this.f25008g;
            }

            private void m26881b(int i) {
                this.f25008g = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 3, i);
                }
            }

            @Nullable
            private String m26885m() {
                this.f25009h = super.a(this.f25009h, 4);
                return this.f25009h;
            }

            @Nullable
            private String m26886n() {
                this.f25010i = super.a(this.f25010i, 5);
                return this.f25010i;
            }

            @Nullable
            private String m26887o() {
                this.f25011j = super.a(this.f25011j, 6);
                return this.f25011j;
            }

            private void m26880a(@Nullable String str) {
                this.f25011j = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 6, str);
                }
            }

            @Nullable
            public final String m26890a() {
                return m26885m();
            }

            public final int jK_() {
                return 827365670;
            }

            public final GraphQLVisitableModel m26889a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m26882j() != null) {
                    ActiveTeamWithBallModel activeTeamWithBallModel = (ActiveTeamWithBallModel) graphQLModelMutatingVisitor.b(m26882j());
                    if (m26882j() != activeTeamWithBallModel) {
                        graphQLVisitableModel = (SportsMatchDataModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f25005d = activeTeamWithBallModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m26888a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m26882j());
                int b = flatBufferBuilder.b(m26885m());
                int b2 = flatBufferBuilder.b(m26886n());
                int b3 = flatBufferBuilder.b(m26887o());
                flatBufferBuilder.c(8);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f25006e, 0);
                flatBufferBuilder.a(2, this.f25007f);
                flatBufferBuilder.a(3, this.f25008g, 0);
                flatBufferBuilder.b(4, b);
                flatBufferBuilder.b(5, b2);
                flatBufferBuilder.b(6, b3);
                flatBufferBuilder.a(7, this.f25012k, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m26891a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f25006e = mutableFlatBuffer.a(i, 1, 0);
                this.f25007f = mutableFlatBuffer.a(i, 2);
                this.f25008g = mutableFlatBuffer.a(i, 3, 0);
                this.f25012k = mutableFlatBuffer.a(i, 7, 0);
            }
        }

        public GametimeMatchHeaderLiveUpdatingFragmentModel() {
            super(2);
        }

        public final void m26899a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m26900a(String str, Object obj, boolean z) {
        }

        @Nullable
        private String m26894j() {
            this.f25013d = super.a(this.f25013d, 0);
            return this.f25013d;
        }

        @Nullable
        private SportsMatchDataModel m26895k() {
            this.f25014e = (SportsMatchDataModel) super.a(this.f25014e, 1, SportsMatchDataModel.class);
            return this.f25014e;
        }

        @Nullable
        public final String m26898a() {
            return m26894j();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m26897a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26895k() != null) {
                SportsMatchDataModel sportsMatchDataModel = (SportsMatchDataModel) graphQLModelMutatingVisitor.b(m26895k());
                if (m26895k() != sportsMatchDataModel) {
                    graphQLVisitableModel = (GametimeMatchHeaderLiveUpdatingFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f25014e = sportsMatchDataModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26896a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m26894j());
            int a = ModelHelper.a(flatBufferBuilder, m26895k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1500922066)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: TEMP */
    public final class GametimeMatchHeaderQueryModel extends BaseModel implements GametimeMatchHeaderFragment, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f25027d;
        @Nullable
        private String f25028e;
        @Nullable
        private SportsMatchDataModel f25029f;

        /* compiled from: TEMP */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GametimeMatchHeaderQueryModel.class, new Deserializer());
            }

            public Object m26901a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GametimeMatchHeaderQueryParser.m27042a(jsonParser);
                Object gametimeMatchHeaderQueryModel = new GametimeMatchHeaderQueryModel();
                ((BaseModel) gametimeMatchHeaderQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (gametimeMatchHeaderQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) gametimeMatchHeaderQueryModel).a();
                }
                return gametimeMatchHeaderQueryModel;
            }
        }

        /* compiled from: TEMP */
        public class Serializer extends JsonSerializer<GametimeMatchHeaderQueryModel> {
            public final void m26902a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GametimeMatchHeaderQueryModel gametimeMatchHeaderQueryModel = (GametimeMatchHeaderQueryModel) obj;
                if (gametimeMatchHeaderQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(gametimeMatchHeaderQueryModel.m26926a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    gametimeMatchHeaderQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = gametimeMatchHeaderQueryModel.w_();
                int u_ = gametimeMatchHeaderQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("sports_match_data");
                    GametimeMatchHeaderQueryParser.SportsMatchDataParser.m27041a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GametimeMatchHeaderQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 133902670)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: TEMP */
        public final class SportsMatchDataModel extends BaseModel implements SportsMatchData, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private ActiveTeamWithBallModel f25015d;
            @Nullable
            private AwayTeamObjectModel f25016e;
            @Nullable
            private String f25017f;
            private int f25018g;
            private boolean f25019h;
            @Nullable
            private HomeTeamObjectModel f25020i;
            @Nullable
            private String f25021j;
            private int f25022k;
            @Nullable
            private String f25023l;
            @Nullable
            private String f25024m;
            @Nullable
            private String f25025n;
            private long f25026o;

            /* compiled from: TEMP */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SportsMatchDataModel.class, new Deserializer());
                }

                public Object m26903a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GametimeMatchHeaderQueryParser.SportsMatchDataParser.m27040a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object sportsMatchDataModel = new SportsMatchDataModel();
                    ((BaseModel) sportsMatchDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (sportsMatchDataModel instanceof Postprocessable) {
                        return ((Postprocessable) sportsMatchDataModel).a();
                    }
                    return sportsMatchDataModel;
                }
            }

            /* compiled from: TEMP */
            public class Serializer extends JsonSerializer<SportsMatchDataModel> {
                public final void m26904a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SportsMatchDataModel sportsMatchDataModel = (SportsMatchDataModel) obj;
                    if (sportsMatchDataModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(sportsMatchDataModel.m26913a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        sportsMatchDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GametimeMatchHeaderQueryParser.SportsMatchDataParser.m27041a(sportsMatchDataModel.w_(), sportsMatchDataModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SportsMatchDataModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ AwayTeamObjectModel mo1164b() {
                return m26909l();
            }

            @Nullable
            public final /* synthetic */ HomeTeamObjectModel mo1167g() {
                return m26910m();
            }

            public SportsMatchDataModel() {
                super(12);
            }

            public final void m26917a(String str, ConsistencyTuple consistencyTuple) {
                if ("away_team_score".equals(str)) {
                    consistencyTuple.a = Integer.valueOf(mo1166d());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 3;
                } else if ("home_team_score".equals(str)) {
                    consistencyTuple.a = Integer.valueOf(mD_());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 7;
                } else if ("status_text".equals(str)) {
                    consistencyTuple.a = mo1168j();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 10;
                } else {
                    consistencyTuple.a();
                }
            }

            public final void m26918a(String str, Object obj, boolean z) {
                if ("away_team_score".equals(str)) {
                    m26905a(((Integer) obj).intValue());
                } else if ("home_team_score".equals(str)) {
                    m26907b(((Integer) obj).intValue());
                } else if ("status_text".equals(str)) {
                    m26906a((String) obj);
                }
            }

            @Nullable
            private ActiveTeamWithBallModel m26908k() {
                this.f25015d = (ActiveTeamWithBallModel) super.a(this.f25015d, 0, ActiveTeamWithBallModel.class);
                return this.f25015d;
            }

            @Nullable
            private AwayTeamObjectModel m26909l() {
                this.f25016e = (AwayTeamObjectModel) super.a(this.f25016e, 1, AwayTeamObjectModel.class);
                return this.f25016e;
            }

            @Nullable
            public final String mo1165c() {
                this.f25017f = super.a(this.f25017f, 2);
                return this.f25017f;
            }

            public final int mo1166d() {
                a(0, 3);
                return this.f25018g;
            }

            private void m26905a(int i) {
                this.f25018g = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 3, i);
                }
            }

            public final boolean mB_() {
                a(0, 4);
                return this.f25019h;
            }

            @Nullable
            private HomeTeamObjectModel m26910m() {
                this.f25020i = (HomeTeamObjectModel) super.a(this.f25020i, 5, HomeTeamObjectModel.class);
                return this.f25020i;
            }

            @Nullable
            public final String mC_() {
                this.f25021j = super.a(this.f25021j, 6);
                return this.f25021j;
            }

            public final int mD_() {
                a(0, 7);
                return this.f25022k;
            }

            private void m26907b(int i) {
                this.f25022k = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 7, i);
                }
            }

            @Nullable
            private String m26911n() {
                this.f25023l = super.a(this.f25023l, 8);
                return this.f25023l;
            }

            @Nullable
            private String m26912o() {
                this.f25024m = super.a(this.f25024m, 9);
                return this.f25024m;
            }

            @Nullable
            public final String mo1168j() {
                this.f25025n = super.a(this.f25025n, 10);
                return this.f25025n;
            }

            private void m26906a(@Nullable String str) {
                this.f25025n = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 10, str);
                }
            }

            @Nullable
            public final String m26915a() {
                return m26911n();
            }

            public final int jK_() {
                return 827365670;
            }

            public final GraphQLVisitableModel m26914a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m26908k() != null) {
                    ActiveTeamWithBallModel activeTeamWithBallModel = (ActiveTeamWithBallModel) graphQLModelMutatingVisitor.b(m26908k());
                    if (m26908k() != activeTeamWithBallModel) {
                        graphQLVisitableModel = (SportsMatchDataModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f25015d = activeTeamWithBallModel;
                    }
                }
                if (m26909l() != null) {
                    AwayTeamObjectModel awayTeamObjectModel = (AwayTeamObjectModel) graphQLModelMutatingVisitor.b(m26909l());
                    if (m26909l() != awayTeamObjectModel) {
                        graphQLVisitableModel = (SportsMatchDataModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f25016e = awayTeamObjectModel;
                    }
                }
                if (m26910m() != null) {
                    HomeTeamObjectModel homeTeamObjectModel = (HomeTeamObjectModel) graphQLModelMutatingVisitor.b(m26910m());
                    if (m26910m() != homeTeamObjectModel) {
                        graphQLVisitableModel = (SportsMatchDataModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f25020i = homeTeamObjectModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m26913a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m26908k());
                int a2 = ModelHelper.a(flatBufferBuilder, m26909l());
                int b = flatBufferBuilder.b(mo1165c());
                int a3 = ModelHelper.a(flatBufferBuilder, m26910m());
                int b2 = flatBufferBuilder.b(mC_());
                int b3 = flatBufferBuilder.b(m26911n());
                int b4 = flatBufferBuilder.b(m26912o());
                int b5 = flatBufferBuilder.b(mo1168j());
                flatBufferBuilder.c(12);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.a(3, this.f25018g, 0);
                flatBufferBuilder.a(4, this.f25019h);
                flatBufferBuilder.b(5, a3);
                flatBufferBuilder.b(6, b2);
                flatBufferBuilder.a(7, this.f25022k, 0);
                flatBufferBuilder.b(8, b3);
                flatBufferBuilder.b(9, b4);
                flatBufferBuilder.b(10, b5);
                flatBufferBuilder.a(11, this.f25026o, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m26916a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f25018g = mutableFlatBuffer.a(i, 3, 0);
                this.f25019h = mutableFlatBuffer.a(i, 4);
                this.f25022k = mutableFlatBuffer.a(i, 7, 0);
                this.f25026o = mutableFlatBuffer.a(i, 11, 0);
            }
        }

        public GametimeMatchHeaderQueryModel() {
            super(3);
        }

        public final void m26929a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m26930a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m26924k() {
            if (this.b != null && this.f25027d == null) {
                this.f25027d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f25027d;
        }

        @Nullable
        private String m26925l() {
            this.f25028e = super.a(this.f25028e, 1);
            return this.f25028e;
        }

        @Nullable
        public final SportsMatchDataModel m26931j() {
            this.f25029f = (SportsMatchDataModel) super.a(this.f25029f, 2, SportsMatchDataModel.class);
            return this.f25029f;
        }

        @Nullable
        public final String m26928a() {
            return m26925l();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m26927a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26931j() != null) {
                SportsMatchDataModel sportsMatchDataModel = (SportsMatchDataModel) graphQLModelMutatingVisitor.b(m26931j());
                if (m26931j() != sportsMatchDataModel) {
                    graphQLVisitableModel = (GametimeMatchHeaderQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f25029f = sportsMatchDataModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26926a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26924k());
            int b = flatBufferBuilder.b(m26925l());
            int a2 = ModelHelper.a(flatBufferBuilder, m26931j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1792387942)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: TEMP */
    public final class GametimeMatchHeaderUpdateSubscriptionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GametimeMatchHeaderLiveUpdatingFragmentModel f25030d;

        /* compiled from: TEMP */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GametimeMatchHeaderUpdateSubscriptionModel.class, new Deserializer());
            }

            public Object m26932a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GametimeMatchHeaderUpdateSubscriptionParser.m27043a(jsonParser);
                Object gametimeMatchHeaderUpdateSubscriptionModel = new GametimeMatchHeaderUpdateSubscriptionModel();
                ((BaseModel) gametimeMatchHeaderUpdateSubscriptionModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (gametimeMatchHeaderUpdateSubscriptionModel instanceof Postprocessable) {
                    return ((Postprocessable) gametimeMatchHeaderUpdateSubscriptionModel).a();
                }
                return gametimeMatchHeaderUpdateSubscriptionModel;
            }
        }

        /* compiled from: TEMP */
        public class Serializer extends JsonSerializer<GametimeMatchHeaderUpdateSubscriptionModel> {
            public final void m26933a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GametimeMatchHeaderUpdateSubscriptionModel gametimeMatchHeaderUpdateSubscriptionModel = (GametimeMatchHeaderUpdateSubscriptionModel) obj;
                if (gametimeMatchHeaderUpdateSubscriptionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(gametimeMatchHeaderUpdateSubscriptionModel.m26935a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    gametimeMatchHeaderUpdateSubscriptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = gametimeMatchHeaderUpdateSubscriptionModel.w_();
                int u_ = gametimeMatchHeaderUpdateSubscriptionModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("page");
                    GametimeMatchHeaderLiveUpdatingFragmentParser.m27039a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GametimeMatchHeaderUpdateSubscriptionModel.class, new Serializer());
            }
        }

        public GametimeMatchHeaderUpdateSubscriptionModel() {
            super(1);
        }

        @Nullable
        private GametimeMatchHeaderLiveUpdatingFragmentModel m26934a() {
            this.f25030d = (GametimeMatchHeaderLiveUpdatingFragmentModel) super.a(this.f25030d, 0, GametimeMatchHeaderLiveUpdatingFragmentModel.class);
            return this.f25030d;
        }

        public final int jK_() {
            return -2087426724;
        }

        public final GraphQLVisitableModel m26936a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26934a() != null) {
                GametimeMatchHeaderLiveUpdatingFragmentModel gametimeMatchHeaderLiveUpdatingFragmentModel = (GametimeMatchHeaderLiveUpdatingFragmentModel) graphQLModelMutatingVisitor.b(m26934a());
                if (m26934a() != gametimeMatchHeaderLiveUpdatingFragmentModel) {
                    graphQLVisitableModel = (GametimeMatchHeaderUpdateSubscriptionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f25030d = gametimeMatchHeaderLiveUpdatingFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26935a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26934a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1701597681)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: TEMP */
    public final class GametimeMatchReactionUnitsFragmentModel extends BaseModel implements GraphQLVisitableModel, ReactionStories {
        @Nullable
        private List<EdgesModel> f25031d;
        @Nullable
        private ReactionUnitExpirationConditionFragmentModel f25032e;
        @Nullable
        private DefaultPageInfoFieldsModel f25033f;
        @Nullable
        private String f25034g;
        private int f25035h;

        /* compiled from: TEMP */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GametimeMatchReactionUnitsFragmentModel.class, new Deserializer());
            }

            public Object m26937a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GametimeMatchReactionUnitsFragmentParser.m27044a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object gametimeMatchReactionUnitsFragmentModel = new GametimeMatchReactionUnitsFragmentModel();
                ((BaseModel) gametimeMatchReactionUnitsFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (gametimeMatchReactionUnitsFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) gametimeMatchReactionUnitsFragmentModel).a();
                }
                return gametimeMatchReactionUnitsFragmentModel;
            }
        }

        /* compiled from: TEMP */
        public class Serializer extends JsonSerializer<GametimeMatchReactionUnitsFragmentModel> {
            public final void m26938a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GametimeMatchReactionUnitsFragmentModel gametimeMatchReactionUnitsFragmentModel = (GametimeMatchReactionUnitsFragmentModel) obj;
                if (gametimeMatchReactionUnitsFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(gametimeMatchReactionUnitsFragmentModel.m26941a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    gametimeMatchReactionUnitsFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GametimeMatchReactionUnitsFragmentParser.m27045a(gametimeMatchReactionUnitsFragmentModel.w_(), gametimeMatchReactionUnitsFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(GametimeMatchReactionUnitsFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultPageInfoFields m26945c() {
            return m26940k();
        }

        public GametimeMatchReactionUnitsFragmentModel() {
            super(5);
        }

        @Nonnull
        public final ImmutableList<EdgesModel> m26943a() {
            this.f25031d = super.a(this.f25031d, 0, EdgesModel.class);
            return (ImmutableList) this.f25031d;
        }

        @Nullable
        private ReactionUnitExpirationConditionFragmentModel m26939j() {
            this.f25032e = (ReactionUnitExpirationConditionFragmentModel) super.a(this.f25032e, 1, ReactionUnitExpirationConditionFragmentModel.class);
            return this.f25032e;
        }

        @Nullable
        private DefaultPageInfoFieldsModel m26940k() {
            this.f25033f = (DefaultPageInfoFieldsModel) super.a(this.f25033f, 2, DefaultPageInfoFieldsModel.class);
            return this.f25033f;
        }

        @Nullable
        public final String m26946d() {
            this.f25034g = super.a(this.f25034g, 3);
            return this.f25034g;
        }

        public final int jK_() {
            return -2074885058;
        }

        public final GraphQLVisitableModel m26942a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            ReactionUnitExpirationConditionFragmentModel reactionUnitExpirationConditionFragmentModel;
            DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
            h();
            if (m26943a() != null) {
                Builder a = ModelHelper.a(m26943a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    GametimeMatchReactionUnitsFragmentModel gametimeMatchReactionUnitsFragmentModel = (GametimeMatchReactionUnitsFragmentModel) ModelHelper.a(null, this);
                    gametimeMatchReactionUnitsFragmentModel.f25031d = a.b();
                    graphQLVisitableModel = gametimeMatchReactionUnitsFragmentModel;
                    if (m26939j() != null) {
                        reactionUnitExpirationConditionFragmentModel = (ReactionUnitExpirationConditionFragmentModel) graphQLModelMutatingVisitor.b(m26939j());
                        if (m26939j() != reactionUnitExpirationConditionFragmentModel) {
                            graphQLVisitableModel = (GametimeMatchReactionUnitsFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f25032e = reactionUnitExpirationConditionFragmentModel;
                        }
                    }
                    if (m26940k() != null) {
                        defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m26940k());
                        if (m26940k() != defaultPageInfoFieldsModel) {
                            graphQLVisitableModel = (GametimeMatchReactionUnitsFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f25033f = defaultPageInfoFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m26939j() != null) {
                reactionUnitExpirationConditionFragmentModel = (ReactionUnitExpirationConditionFragmentModel) graphQLModelMutatingVisitor.b(m26939j());
                if (m26939j() != reactionUnitExpirationConditionFragmentModel) {
                    graphQLVisitableModel = (GametimeMatchReactionUnitsFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f25032e = reactionUnitExpirationConditionFragmentModel;
                }
            }
            if (m26940k() != null) {
                defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m26940k());
                if (m26940k() != defaultPageInfoFieldsModel) {
                    graphQLVisitableModel = (GametimeMatchReactionUnitsFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f25033f = defaultPageInfoFieldsModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m26941a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26943a());
            int a2 = ModelHelper.a(flatBufferBuilder, m26939j());
            int a3 = ModelHelper.a(flatBufferBuilder, m26940k());
            int b = flatBufferBuilder.b(m26946d());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.a(4, this.f25035h, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m26944a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f25035h = mutableFlatBuffer.a(i, 4, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -83319864)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: TEMP */
    public final class GametimePlaySubscriptionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PlayModel f25048d;

        /* compiled from: TEMP */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GametimePlaySubscriptionModel.class, new Deserializer());
            }

            public Object m26947a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GametimePlaySubscriptionParser.m27048a(jsonParser);
                Object gametimePlaySubscriptionModel = new GametimePlaySubscriptionModel();
                ((BaseModel) gametimePlaySubscriptionModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (gametimePlaySubscriptionModel instanceof Postprocessable) {
                    return ((Postprocessable) gametimePlaySubscriptionModel).a();
                }
                return gametimePlaySubscriptionModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1381691250)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: TEMP */
        public final class PlayModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, GametimeDataFactFragment {
            @Nullable
            private ActingTeamModel f25036d;
            @Nullable
            private String f25037e;
            @Nullable
            private String f25038f;
            @Nullable
            private String f25039g;
            private long f25040h;
            @Nullable
            private GametimeDataFactFeedbackFieldsModel f25041i;
            @Nullable
            private String f25042j;
            @Nullable
            private String f25043k;
            @Nullable
            private PreviewCommentModel f25044l;
            @Nullable
            private String f25045m;
            private int f25046n;
            @Nullable
            private StoryModel f25047o;

            /* compiled from: TEMP */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PlayModel.class, new Deserializer());
                }

                public Object m26948a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlayParser.m27046a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object playModel = new PlayModel();
                    ((BaseModel) playModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (playModel instanceof Postprocessable) {
                        return ((Postprocessable) playModel).a();
                    }
                    return playModel;
                }
            }

            /* compiled from: TEMP */
            public class Serializer extends JsonSerializer<PlayModel> {
                public final void m26949a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PlayModel playModel = (PlayModel) obj;
                    if (playModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(playModel.m26954a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        playModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlayParser.m27047a(playModel.w_(), playModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PlayModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ActingTeamModel m26958b() {
                return m26950n();
            }

            @Nullable
            public final /* synthetic */ GametimeDataFactFeedbackFieldsModel m26961g() {
                return m26951o();
            }

            @Nullable
            public final /* synthetic */ PreviewCommentModel m26962j() {
                return m26952p();
            }

            @Nullable
            public final /* synthetic */ StoryModel m26965m() {
                return m26953q();
            }

            public PlayModel() {
                super(12);
            }

            @Nullable
            private ActingTeamModel m26950n() {
                this.f25036d = (ActingTeamModel) super.a(this.f25036d, 0, ActingTeamModel.class);
                return this.f25036d;
            }

            @Nullable
            public final String m26959c() {
                this.f25037e = super.a(this.f25037e, 1);
                return this.f25037e;
            }

            @Nullable
            public final String m26960d() {
                this.f25038f = super.a(this.f25038f, 2);
                return this.f25038f;
            }

            @Nullable
            public final String eP_() {
                this.f25039g = super.a(this.f25039g, 3);
                return this.f25039g;
            }

            @Nullable
            private GametimeDataFactFeedbackFieldsModel m26951o() {
                this.f25041i = (GametimeDataFactFeedbackFieldsModel) super.a(this.f25041i, 5, GametimeDataFactFeedbackFieldsModel.class);
                return this.f25041i;
            }

            @Nullable
            public final String eQ_() {
                this.f25042j = super.a(this.f25042j, 6);
                return this.f25042j;
            }

            @Nullable
            public final String eR_() {
                this.f25043k = super.a(this.f25043k, 7);
                return this.f25043k;
            }

            @Nullable
            private PreviewCommentModel m26952p() {
                this.f25044l = (PreviewCommentModel) super.a(this.f25044l, 8, PreviewCommentModel.class);
                return this.f25044l;
            }

            @Nullable
            public final String m26963k() {
                this.f25045m = super.a(this.f25045m, 9);
                return this.f25045m;
            }

            public final int m26964l() {
                a(1, 2);
                return this.f25046n;
            }

            @Nullable
            private StoryModel m26953q() {
                this.f25047o = (StoryModel) super.a(this.f25047o, 11, StoryModel.class);
                return this.f25047o;
            }

            @Nullable
            public final String m26956a() {
                return eR_();
            }

            public final int jK_() {
                return 2006245554;
            }

            public final GraphQLVisitableModel m26955a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m26950n() != null) {
                    ActingTeamModel actingTeamModel = (ActingTeamModel) graphQLModelMutatingVisitor.b(m26950n());
                    if (m26950n() != actingTeamModel) {
                        graphQLVisitableModel = (PlayModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f25036d = actingTeamModel;
                    }
                }
                if (m26951o() != null) {
                    GametimeDataFactFeedbackFieldsModel gametimeDataFactFeedbackFieldsModel = (GametimeDataFactFeedbackFieldsModel) graphQLModelMutatingVisitor.b(m26951o());
                    if (m26951o() != gametimeDataFactFeedbackFieldsModel) {
                        graphQLVisitableModel = (PlayModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f25041i = gametimeDataFactFeedbackFieldsModel;
                    }
                }
                if (m26952p() != null) {
                    PreviewCommentModel previewCommentModel = (PreviewCommentModel) graphQLModelMutatingVisitor.b(m26952p());
                    if (m26952p() != previewCommentModel) {
                        graphQLVisitableModel = (PlayModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f25044l = previewCommentModel;
                    }
                }
                if (m26953q() != null) {
                    StoryModel storyModel = (StoryModel) graphQLModelMutatingVisitor.b(m26953q());
                    if (m26953q() != storyModel) {
                        graphQLVisitableModel = (PlayModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f25047o = storyModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m26954a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m26950n());
                int b = flatBufferBuilder.b(m26959c());
                int b2 = flatBufferBuilder.b(m26960d());
                int b3 = flatBufferBuilder.b(eP_());
                int a2 = ModelHelper.a(flatBufferBuilder, m26951o());
                int b4 = flatBufferBuilder.b(eQ_());
                int b5 = flatBufferBuilder.b(eR_());
                int a3 = ModelHelper.a(flatBufferBuilder, m26952p());
                int b6 = flatBufferBuilder.b(m26963k());
                int a4 = ModelHelper.a(flatBufferBuilder, m26953q());
                flatBufferBuilder.c(12);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, b3);
                flatBufferBuilder.a(4, this.f25040h, 0);
                flatBufferBuilder.b(5, a2);
                flatBufferBuilder.b(6, b4);
                flatBufferBuilder.b(7, b5);
                flatBufferBuilder.b(8, a3);
                flatBufferBuilder.b(9, b6);
                flatBufferBuilder.a(10, this.f25046n, 0);
                flatBufferBuilder.b(11, a4);
                i();
                return flatBufferBuilder.d();
            }

            public final void m26957a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f25040h = mutableFlatBuffer.a(i, 4, 0);
                this.f25046n = mutableFlatBuffer.a(i, 10, 0);
            }
        }

        /* compiled from: TEMP */
        public class Serializer extends JsonSerializer<GametimePlaySubscriptionModel> {
            public final void m26966a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GametimePlaySubscriptionModel gametimePlaySubscriptionModel = (GametimePlaySubscriptionModel) obj;
                if (gametimePlaySubscriptionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(gametimePlaySubscriptionModel.m26967a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    gametimePlaySubscriptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = gametimePlaySubscriptionModel.w_();
                int u_ = gametimePlaySubscriptionModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("play");
                    PlayParser.m27047a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GametimePlaySubscriptionModel.class, new Serializer());
            }
        }

        public GametimePlaySubscriptionModel() {
            super(1);
        }

        @Nullable
        public final PlayModel m26968a() {
            this.f25048d = (PlayModel) super.a(this.f25048d, 0, PlayModel.class);
            return this.f25048d;
        }

        public final int jK_() {
            return -622759271;
        }

        public final GraphQLVisitableModel m26969a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26968a() != null) {
                PlayModel playModel = (PlayModel) graphQLModelMutatingVisitor.b(m26968a());
                if (m26968a() != playModel) {
                    graphQLVisitableModel = (GametimePlaySubscriptionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f25048d = playModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26967a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26968a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 916722424)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: TEMP */
    public final class GametimeReactionHeadLoadFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GametimeMatchReactionUnitsFragmentModel f25049d;

        /* compiled from: TEMP */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GametimeReactionHeadLoadFragmentModel.class, new Deserializer());
            }

            public Object m26970a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GametimeReactionHeadLoadFragmentParser.m27049a(jsonParser);
                Object gametimeReactionHeadLoadFragmentModel = new GametimeReactionHeadLoadFragmentModel();
                ((BaseModel) gametimeReactionHeadLoadFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (gametimeReactionHeadLoadFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) gametimeReactionHeadLoadFragmentModel).a();
                }
                return gametimeReactionHeadLoadFragmentModel;
            }
        }

        /* compiled from: TEMP */
        public class Serializer extends JsonSerializer<GametimeReactionHeadLoadFragmentModel> {
            public final void m26971a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GametimeReactionHeadLoadFragmentModel gametimeReactionHeadLoadFragmentModel = (GametimeReactionHeadLoadFragmentModel) obj;
                if (gametimeReactionHeadLoadFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(gametimeReactionHeadLoadFragmentModel.m26973a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    gametimeReactionHeadLoadFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = gametimeReactionHeadLoadFragmentModel.w_();
                int u_ = gametimeReactionHeadLoadFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("reaction_units");
                    GametimeMatchReactionUnitsFragmentParser.m27045a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GametimeReactionHeadLoadFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ GametimeMatchReactionUnitsFragmentModel m26974a() {
            return m26972j();
        }

        public GametimeReactionHeadLoadFragmentModel() {
            super(1);
        }

        @Nullable
        private GametimeMatchReactionUnitsFragmentModel m26972j() {
            this.f25049d = (GametimeMatchReactionUnitsFragmentModel) super.a(this.f25049d, 0, GametimeMatchReactionUnitsFragmentModel.class);
            return this.f25049d;
        }

        public final int jK_() {
            return 1148451136;
        }

        public final GraphQLVisitableModel m26975a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26972j() != null) {
                GametimeMatchReactionUnitsFragmentModel gametimeMatchReactionUnitsFragmentModel = (GametimeMatchReactionUnitsFragmentModel) graphQLModelMutatingVisitor.b(m26972j());
                if (m26972j() != gametimeMatchReactionUnitsFragmentModel) {
                    graphQLVisitableModel = (GametimeReactionHeadLoadFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f25049d = gametimeMatchReactionUnitsFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26973a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26972j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 916722424)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: TEMP */
    public final class GametimeReactionTailLoadFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GametimeMatchReactionUnitsFragmentModel f25050d;

        /* compiled from: TEMP */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GametimeReactionTailLoadFragmentModel.class, new Deserializer());
            }

            public Object m26976a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GametimeReactionTailLoadFragmentParser.m27050a(jsonParser);
                Object gametimeReactionTailLoadFragmentModel = new GametimeReactionTailLoadFragmentModel();
                ((BaseModel) gametimeReactionTailLoadFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (gametimeReactionTailLoadFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) gametimeReactionTailLoadFragmentModel).a();
                }
                return gametimeReactionTailLoadFragmentModel;
            }
        }

        /* compiled from: TEMP */
        public class Serializer extends JsonSerializer<GametimeReactionTailLoadFragmentModel> {
            public final void m26977a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GametimeReactionTailLoadFragmentModel gametimeReactionTailLoadFragmentModel = (GametimeReactionTailLoadFragmentModel) obj;
                if (gametimeReactionTailLoadFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(gametimeReactionTailLoadFragmentModel.m26979a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    gametimeReactionTailLoadFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = gametimeReactionTailLoadFragmentModel.w_();
                int u_ = gametimeReactionTailLoadFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("reaction_units");
                    GametimeMatchReactionUnitsFragmentParser.m27045a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GametimeReactionTailLoadFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ GametimeMatchReactionUnitsFragmentModel m26980a() {
            return m26978j();
        }

        public GametimeReactionTailLoadFragmentModel() {
            super(1);
        }

        @Nullable
        private GametimeMatchReactionUnitsFragmentModel m26978j() {
            this.f25050d = (GametimeMatchReactionUnitsFragmentModel) super.a(this.f25050d, 0, GametimeMatchReactionUnitsFragmentModel.class);
            return this.f25050d;
        }

        public final int jK_() {
            return 1148451136;
        }

        public final GraphQLVisitableModel m26981a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26978j() != null) {
                GametimeMatchReactionUnitsFragmentModel gametimeMatchReactionUnitsFragmentModel = (GametimeMatchReactionUnitsFragmentModel) graphQLModelMutatingVisitor.b(m26978j());
                if (m26978j() != gametimeMatchReactionUnitsFragmentModel) {
                    graphQLVisitableModel = (GametimeReactionTailLoadFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f25050d = gametimeMatchReactionUnitsFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26979a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26978j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2067463380)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: TEMP */
    public final class GametimeReactionUnitsFragmentModel extends BaseModel implements GraphQLVisitableModel, ReactionStories {
        @Nullable
        private List<EdgesModel> f25051d;
        @Nullable
        private ReactionUnitExpirationConditionFragmentModel f25052e;
        @Nullable
        private DefaultPageInfoFieldsModel f25053f;
        @Nullable
        private String f25054g;

        /* compiled from: TEMP */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GametimeReactionUnitsFragmentModel.class, new Deserializer());
            }

            public Object m26982a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GametimeReactionUnitsFragmentParser.m27051a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object gametimeReactionUnitsFragmentModel = new GametimeReactionUnitsFragmentModel();
                ((BaseModel) gametimeReactionUnitsFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (gametimeReactionUnitsFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) gametimeReactionUnitsFragmentModel).a();
                }
                return gametimeReactionUnitsFragmentModel;
            }
        }

        /* compiled from: TEMP */
        public class Serializer extends JsonSerializer<GametimeReactionUnitsFragmentModel> {
            public final void m26983a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GametimeReactionUnitsFragmentModel gametimeReactionUnitsFragmentModel = (GametimeReactionUnitsFragmentModel) obj;
                if (gametimeReactionUnitsFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(gametimeReactionUnitsFragmentModel.m26986a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    gametimeReactionUnitsFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GametimeReactionUnitsFragmentParser.m27052a(gametimeReactionUnitsFragmentModel.w_(), gametimeReactionUnitsFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(GametimeReactionUnitsFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultPageInfoFields m26989c() {
            return m26985k();
        }

        public GametimeReactionUnitsFragmentModel() {
            super(4);
        }

        @Nonnull
        public final ImmutableList<EdgesModel> m26988a() {
            this.f25051d = super.a(this.f25051d, 0, EdgesModel.class);
            return (ImmutableList) this.f25051d;
        }

        @Nullable
        private ReactionUnitExpirationConditionFragmentModel m26984j() {
            this.f25052e = (ReactionUnitExpirationConditionFragmentModel) super.a(this.f25052e, 1, ReactionUnitExpirationConditionFragmentModel.class);
            return this.f25052e;
        }

        @Nullable
        private DefaultPageInfoFieldsModel m26985k() {
            this.f25053f = (DefaultPageInfoFieldsModel) super.a(this.f25053f, 2, DefaultPageInfoFieldsModel.class);
            return this.f25053f;
        }

        @Nullable
        public final String m26990d() {
            this.f25054g = super.a(this.f25054g, 3);
            return this.f25054g;
        }

        public final int jK_() {
            return 1573588325;
        }

        public final GraphQLVisitableModel m26987a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            ReactionUnitExpirationConditionFragmentModel reactionUnitExpirationConditionFragmentModel;
            DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
            h();
            if (m26988a() != null) {
                Builder a = ModelHelper.a(m26988a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    GametimeReactionUnitsFragmentModel gametimeReactionUnitsFragmentModel = (GametimeReactionUnitsFragmentModel) ModelHelper.a(null, this);
                    gametimeReactionUnitsFragmentModel.f25051d = a.b();
                    graphQLVisitableModel = gametimeReactionUnitsFragmentModel;
                    if (m26984j() != null) {
                        reactionUnitExpirationConditionFragmentModel = (ReactionUnitExpirationConditionFragmentModel) graphQLModelMutatingVisitor.b(m26984j());
                        if (m26984j() != reactionUnitExpirationConditionFragmentModel) {
                            graphQLVisitableModel = (GametimeReactionUnitsFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f25052e = reactionUnitExpirationConditionFragmentModel;
                        }
                    }
                    if (m26985k() != null) {
                        defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m26985k());
                        if (m26985k() != defaultPageInfoFieldsModel) {
                            graphQLVisitableModel = (GametimeReactionUnitsFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f25053f = defaultPageInfoFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m26984j() != null) {
                reactionUnitExpirationConditionFragmentModel = (ReactionUnitExpirationConditionFragmentModel) graphQLModelMutatingVisitor.b(m26984j());
                if (m26984j() != reactionUnitExpirationConditionFragmentModel) {
                    graphQLVisitableModel = (GametimeReactionUnitsFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f25052e = reactionUnitExpirationConditionFragmentModel;
                }
            }
            if (m26985k() != null) {
                defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m26985k());
                if (m26985k() != defaultPageInfoFieldsModel) {
                    graphQLVisitableModel = (GametimeReactionUnitsFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f25053f = defaultPageInfoFieldsModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m26986a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26988a());
            int a2 = ModelHelper.a(flatBufferBuilder, m26984j());
            int a3 = ModelHelper.a(flatBufferBuilder, m26985k());
            int b = flatBufferBuilder.b(m26990d());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -249139849)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: TEMP */
    public final class GametimeSportsPlaysQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f25060d;
        @Nullable
        private String f25061e;
        @Nullable
        private SportsMatchDataModel f25062f;

        /* compiled from: TEMP */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GametimeSportsPlaysQueryModel.class, new Deserializer());
            }

            public Object m26991a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GametimeSportsPlaysQueryParser.m27059a(jsonParser);
                Object gametimeSportsPlaysQueryModel = new GametimeSportsPlaysQueryModel();
                ((BaseModel) gametimeSportsPlaysQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (gametimeSportsPlaysQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) gametimeSportsPlaysQueryModel).a();
                }
                return gametimeSportsPlaysQueryModel;
            }
        }

        /* compiled from: TEMP */
        public class Serializer extends JsonSerializer<GametimeSportsPlaysQueryModel> {
            public final void m26992a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GametimeSportsPlaysQueryModel gametimeSportsPlaysQueryModel = (GametimeSportsPlaysQueryModel) obj;
                if (gametimeSportsPlaysQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(gametimeSportsPlaysQueryModel.m27015a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    gametimeSportsPlaysQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = gametimeSportsPlaysQueryModel.w_();
                int u_ = gametimeSportsPlaysQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("sports_match_data");
                    GametimeSportsPlaysQueryParser.SportsMatchDataParser.m27058a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GametimeSportsPlaysQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -958612925)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: TEMP */
        public final class SportsMatchDataModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private FactsModel f25058d;
            @Nullable
            private String f25059e;

            /* compiled from: TEMP */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SportsMatchDataModel.class, new Deserializer());
                }

                public Object m26993a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GametimeSportsPlaysQueryParser.SportsMatchDataParser.m27057a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object sportsMatchDataModel = new SportsMatchDataModel();
                    ((BaseModel) sportsMatchDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (sportsMatchDataModel instanceof Postprocessable) {
                        return ((Postprocessable) sportsMatchDataModel).a();
                    }
                    return sportsMatchDataModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 427837605)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: TEMP */
            public final class FactsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<EdgesModel> f25056d;
                @Nullable
                private DefaultPageInfoFieldsModel f25057e;

                /* compiled from: TEMP */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(FactsModel.class, new Deserializer());
                    }

                    public Object m26994a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FactsParser.m27055a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object factsModel = new FactsModel();
                        ((BaseModel) factsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (factsModel instanceof Postprocessable) {
                            return ((Postprocessable) factsModel).a();
                        }
                        return factsModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1996244432)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: TEMP */
                public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private GametimeDataFactFragmentModel f25055d;

                    /* compiled from: TEMP */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                        }

                        public Object m26995a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(EdgesParser.m27053b(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object edgesModel = new EdgesModel();
                            ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (edgesModel instanceof Postprocessable) {
                                return ((Postprocessable) edgesModel).a();
                            }
                            return edgesModel;
                        }
                    }

                    /* compiled from: TEMP */
                    public class Serializer extends JsonSerializer<EdgesModel> {
                        public final void m26996a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EdgesModel edgesModel = (EdgesModel) obj;
                            if (edgesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(edgesModel.m26997a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            EdgesParser.m27054b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(EdgesModel.class, new Serializer());
                        }
                    }

                    public EdgesModel() {
                        super(1);
                    }

                    @Nullable
                    public final GametimeDataFactFragmentModel m26999a() {
                        this.f25055d = (GametimeDataFactFragmentModel) super.a(this.f25055d, 0, GametimeDataFactFragmentModel.class);
                        return this.f25055d;
                    }

                    public final int jK_() {
                        return -77472595;
                    }

                    public final GraphQLVisitableModel m26998a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m26999a() != null) {
                            GametimeDataFactFragmentModel gametimeDataFactFragmentModel = (GametimeDataFactFragmentModel) graphQLModelMutatingVisitor.b(m26999a());
                            if (m26999a() != gametimeDataFactFragmentModel) {
                                graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f25055d = gametimeDataFactFragmentModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m26997a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m26999a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: TEMP */
                public class Serializer extends JsonSerializer<FactsModel> {
                    public final void m27000a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        FactsModel factsModel = (FactsModel) obj;
                        if (factsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(factsModel.m27001a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            factsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FactsParser.m27056a(factsModel.w_(), factsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(FactsModel.class, new Serializer());
                    }
                }

                public FactsModel() {
                    super(2);
                }

                @Nonnull
                public final ImmutableList<EdgesModel> m27003a() {
                    this.f25056d = super.a(this.f25056d, 0, EdgesModel.class);
                    return (ImmutableList) this.f25056d;
                }

                @Nullable
                public final DefaultPageInfoFieldsModel m27004j() {
                    this.f25057e = (DefaultPageInfoFieldsModel) super.a(this.f25057e, 1, DefaultPageInfoFieldsModel.class);
                    return this.f25057e;
                }

                public final int jK_() {
                    return -1530660402;
                }

                public final GraphQLVisitableModel m27002a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel;
                    DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                    h();
                    if (m27003a() != null) {
                        Builder a = ModelHelper.a(m27003a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            FactsModel factsModel = (FactsModel) ModelHelper.a(null, this);
                            factsModel.f25056d = a.b();
                            graphQLVisitableModel = factsModel;
                            if (m27004j() != null) {
                                defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m27004j());
                                if (m27004j() != defaultPageInfoFieldsModel) {
                                    graphQLVisitableModel = (FactsModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f25057e = defaultPageInfoFieldsModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                        }
                    }
                    graphQLVisitableModel = null;
                    if (m27004j() != null) {
                        defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m27004j());
                        if (m27004j() != defaultPageInfoFieldsModel) {
                            graphQLVisitableModel = (FactsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f25057e = defaultPageInfoFieldsModel;
                        }
                    }
                    i();
                    if (graphQLVisitableModel != null) {
                    }
                }

                public final int m27001a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m27003a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m27004j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: TEMP */
            public class Serializer extends JsonSerializer<SportsMatchDataModel> {
                public final void m27005a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SportsMatchDataModel sportsMatchDataModel = (SportsMatchDataModel) obj;
                    if (sportsMatchDataModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(sportsMatchDataModel.m27007a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        sportsMatchDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GametimeSportsPlaysQueryParser.SportsMatchDataParser.m27058a(sportsMatchDataModel.w_(), sportsMatchDataModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SportsMatchDataModel.class, new Serializer());
                }
            }

            public SportsMatchDataModel() {
                super(2);
            }

            public final void m27010a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m27011a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final FactsModel m27012j() {
                this.f25058d = (FactsModel) super.a(this.f25058d, 0, FactsModel.class);
                return this.f25058d;
            }

            @Nullable
            private String m27006k() {
                this.f25059e = super.a(this.f25059e, 1);
                return this.f25059e;
            }

            @Nullable
            public final String m27009a() {
                return m27006k();
            }

            public final int jK_() {
                return 827365670;
            }

            public final GraphQLVisitableModel m27008a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m27012j() != null) {
                    FactsModel factsModel = (FactsModel) graphQLModelMutatingVisitor.b(m27012j());
                    if (m27012j() != factsModel) {
                        graphQLVisitableModel = (SportsMatchDataModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f25058d = factsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m27007a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m27012j());
                int b = flatBufferBuilder.b(m27006k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public GametimeSportsPlaysQueryModel() {
            super(3);
        }

        public final void m27018a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m27019a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m27013k() {
            if (this.b != null && this.f25060d == null) {
                this.f25060d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f25060d;
        }

        @Nullable
        private String m27014l() {
            this.f25061e = super.a(this.f25061e, 1);
            return this.f25061e;
        }

        @Nullable
        public final SportsMatchDataModel m27020j() {
            this.f25062f = (SportsMatchDataModel) super.a(this.f25062f, 2, SportsMatchDataModel.class);
            return this.f25062f;
        }

        @Nullable
        public final String m27017a() {
            return m27014l();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m27016a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m27020j() != null) {
                SportsMatchDataModel sportsMatchDataModel = (SportsMatchDataModel) graphQLModelMutatingVisitor.b(m27020j());
                if (m27020j() != sportsMatchDataModel) {
                    graphQLVisitableModel = (GametimeSportsPlaysQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f25062f = sportsMatchDataModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m27015a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m27013k());
            int b = flatBufferBuilder.b(m27014l());
            int a2 = ModelHelper.a(flatBufferBuilder, m27020j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
