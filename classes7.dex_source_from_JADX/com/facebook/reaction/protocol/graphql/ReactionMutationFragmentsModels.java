package com.facebook.reaction.protocol.graphql;

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
import com.facebook.reaction.protocol.graphql.ReactionMutationFragmentsParsers.C1052x9456cfc2;
import com.facebook.reaction.protocol.graphql.ReactionMutationFragmentsParsers.CrisisMarkSelfSafeMutationParser;
import com.facebook.reaction.protocol.graphql.ReactionMutationFragmentsParsers.DeclareCrisisLocationOutMutationParser;
import com.facebook.reaction.protocol.graphql.ReactionMutationFragmentsParsers.PageAdminInviteAcceptMutationParser;
import com.facebook.reaction.protocol.graphql.ReactionMutationFragmentsParsers.PageAdminInviteDeclineMutationParser;
import com.facebook.reaction.protocol.graphql.ReactionMutationFragmentsParsers.ReactionSettingsEnableUnitMutationFragmentParser;
import com.facebook.reaction.protocol.graphql.ReactionMutationFragmentsParsers.ReactionUnitUserSettingsFragmentParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: fetched_candidates_size */
public class ReactionMutationFragmentsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: fetched_candidates_size */
    public final class CrisisMarkSelfSafeMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f13259d;

        /* compiled from: fetched_candidates_size */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CrisisMarkSelfSafeMutationModel.class, new Deserializer());
            }

            public Object m16640a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CrisisMarkSelfSafeMutationParser.m16678a(jsonParser);
                Object crisisMarkSelfSafeMutationModel = new CrisisMarkSelfSafeMutationModel();
                ((BaseModel) crisisMarkSelfSafeMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (crisisMarkSelfSafeMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) crisisMarkSelfSafeMutationModel).a();
                }
                return crisisMarkSelfSafeMutationModel;
            }
        }

        /* compiled from: fetched_candidates_size */
        public class Serializer extends JsonSerializer<CrisisMarkSelfSafeMutationModel> {
            public final void m16641a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CrisisMarkSelfSafeMutationModel crisisMarkSelfSafeMutationModel = (CrisisMarkSelfSafeMutationModel) obj;
                if (crisisMarkSelfSafeMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(crisisMarkSelfSafeMutationModel.m16643a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    crisisMarkSelfSafeMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = crisisMarkSelfSafeMutationModel.w_();
                int u_ = crisisMarkSelfSafeMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CrisisMarkSelfSafeMutationModel.class, new Serializer());
            }
        }

        public CrisisMarkSelfSafeMutationModel() {
            super(1);
        }

        @Nullable
        private String m16642a() {
            this.f13259d = super.a(this.f13259d, 0);
            return this.f13259d;
        }

        public final int jK_() {
            return -478464473;
        }

        public final GraphQLVisitableModel m16644a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m16643a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16642a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: fetched_candidates_size */
    public final class DeclareCrisisLocationOutMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f13260d;

        /* compiled from: fetched_candidates_size */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DeclareCrisisLocationOutMutationModel.class, new Deserializer());
            }

            public Object m16645a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = DeclareCrisisLocationOutMutationParser.m16679a(jsonParser);
                Object declareCrisisLocationOutMutationModel = new DeclareCrisisLocationOutMutationModel();
                ((BaseModel) declareCrisisLocationOutMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (declareCrisisLocationOutMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) declareCrisisLocationOutMutationModel).a();
                }
                return declareCrisisLocationOutMutationModel;
            }
        }

        /* compiled from: fetched_candidates_size */
        public class Serializer extends JsonSerializer<DeclareCrisisLocationOutMutationModel> {
            public final void m16646a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                DeclareCrisisLocationOutMutationModel declareCrisisLocationOutMutationModel = (DeclareCrisisLocationOutMutationModel) obj;
                if (declareCrisisLocationOutMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(declareCrisisLocationOutMutationModel.m16648a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    declareCrisisLocationOutMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = declareCrisisLocationOutMutationModel.w_();
                int u_ = declareCrisisLocationOutMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(DeclareCrisisLocationOutMutationModel.class, new Serializer());
            }
        }

        public DeclareCrisisLocationOutMutationModel() {
            super(1);
        }

        @Nullable
        private String m16647a() {
            this.f13260d = super.a(this.f13260d, 0);
            return this.f13260d;
        }

        public final int jK_() {
            return 1715868161;
        }

        public final GraphQLVisitableModel m16649a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m16648a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16647a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: fetched_candidates_size */
    public final class PageAdminInviteAcceptMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f13261d;

        /* compiled from: fetched_candidates_size */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageAdminInviteAcceptMutationModel.class, new Deserializer());
            }

            public Object m16650a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageAdminInviteAcceptMutationParser.m16680a(jsonParser);
                Object pageAdminInviteAcceptMutationModel = new PageAdminInviteAcceptMutationModel();
                ((BaseModel) pageAdminInviteAcceptMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageAdminInviteAcceptMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) pageAdminInviteAcceptMutationModel).a();
                }
                return pageAdminInviteAcceptMutationModel;
            }
        }

        /* compiled from: fetched_candidates_size */
        public class Serializer extends JsonSerializer<PageAdminInviteAcceptMutationModel> {
            public final void m16651a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageAdminInviteAcceptMutationModel pageAdminInviteAcceptMutationModel = (PageAdminInviteAcceptMutationModel) obj;
                if (pageAdminInviteAcceptMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageAdminInviteAcceptMutationModel.m16653a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageAdminInviteAcceptMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageAdminInviteAcceptMutationModel.w_();
                int u_ = pageAdminInviteAcceptMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageAdminInviteAcceptMutationModel.class, new Serializer());
            }
        }

        public PageAdminInviteAcceptMutationModel() {
            super(1);
        }

        @Nullable
        private String m16652a() {
            this.f13261d = super.a(this.f13261d, 0);
            return this.f13261d;
        }

        public final int jK_() {
            return 871978588;
        }

        public final GraphQLVisitableModel m16654a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m16653a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16652a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: fetched_candidates_size */
    public final class PageAdminInviteDeclineMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f13262d;

        /* compiled from: fetched_candidates_size */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageAdminInviteDeclineMutationModel.class, new Deserializer());
            }

            public Object m16655a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageAdminInviteDeclineMutationParser.m16681a(jsonParser);
                Object pageAdminInviteDeclineMutationModel = new PageAdminInviteDeclineMutationModel();
                ((BaseModel) pageAdminInviteDeclineMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageAdminInviteDeclineMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) pageAdminInviteDeclineMutationModel).a();
                }
                return pageAdminInviteDeclineMutationModel;
            }
        }

        /* compiled from: fetched_candidates_size */
        public class Serializer extends JsonSerializer<PageAdminInviteDeclineMutationModel> {
            public final void m16656a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageAdminInviteDeclineMutationModel pageAdminInviteDeclineMutationModel = (PageAdminInviteDeclineMutationModel) obj;
                if (pageAdminInviteDeclineMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageAdminInviteDeclineMutationModel.m16658a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageAdminInviteDeclineMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageAdminInviteDeclineMutationModel.w_();
                int u_ = pageAdminInviteDeclineMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageAdminInviteDeclineMutationModel.class, new Serializer());
            }
        }

        public PageAdminInviteDeclineMutationModel() {
            super(1);
        }

        @Nullable
        private String m16657a() {
            this.f13262d = super.a(this.f13262d, 0);
            return this.f13262d;
        }

        public final int jK_() {
            return -1536350048;
        }

        public final GraphQLVisitableModel m16659a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m16658a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16657a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1460473842)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: fetched_candidates_size */
    public final class ReactionSettingsEnableUnitMutationFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ReactionUnitUserSettingsFragmentModel f13263d;

        /* compiled from: fetched_candidates_size */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionSettingsEnableUnitMutationFragmentModel.class, new Deserializer());
            }

            public Object m16660a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionSettingsEnableUnitMutationFragmentParser.m16682a(jsonParser);
                Object reactionSettingsEnableUnitMutationFragmentModel = new ReactionSettingsEnableUnitMutationFragmentModel();
                ((BaseModel) reactionSettingsEnableUnitMutationFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionSettingsEnableUnitMutationFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionSettingsEnableUnitMutationFragmentModel).a();
                }
                return reactionSettingsEnableUnitMutationFragmentModel;
            }
        }

        /* compiled from: fetched_candidates_size */
        public class Serializer extends JsonSerializer<ReactionSettingsEnableUnitMutationFragmentModel> {
            public final void m16661a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionSettingsEnableUnitMutationFragmentModel reactionSettingsEnableUnitMutationFragmentModel = (ReactionSettingsEnableUnitMutationFragmentModel) obj;
                if (reactionSettingsEnableUnitMutationFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionSettingsEnableUnitMutationFragmentModel.m16663a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionSettingsEnableUnitMutationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionSettingsEnableUnitMutationFragmentModel.w_();
                int u_ = reactionSettingsEnableUnitMutationFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("reaction_unit_user_settings");
                    ReactionUnitUserSettingsFragmentParser.m16685a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionSettingsEnableUnitMutationFragmentModel.class, new Serializer());
            }
        }

        public ReactionSettingsEnableUnitMutationFragmentModel() {
            super(1);
        }

        @Nullable
        private ReactionUnitUserSettingsFragmentModel m16662a() {
            this.f13263d = (ReactionUnitUserSettingsFragmentModel) super.a(this.f13263d, 0, ReactionUnitUserSettingsFragmentModel.class);
            return this.f13263d;
        }

        public final int jK_() {
            return 87301873;
        }

        public final GraphQLVisitableModel m16664a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16662a() != null) {
                ReactionUnitUserSettingsFragmentModel reactionUnitUserSettingsFragmentModel = (ReactionUnitUserSettingsFragmentModel) graphQLModelMutatingVisitor.b(m16662a());
                if (m16662a() != reactionUnitUserSettingsFragmentModel) {
                    graphQLVisitableModel = (ReactionSettingsEnableUnitMutationFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13263d = reactionUnitUserSettingsFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16663a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16662a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1460473842)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: fetched_candidates_size */
    public final class ReactionUnitUserSettingsDisableUnitTypeCoreMutationFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ReactionUnitUserSettingsFragmentModel f13264d;

        /* compiled from: fetched_candidates_size */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionUnitUserSettingsDisableUnitTypeCoreMutationFragmentModel.class, new Deserializer());
            }

            public Object m16665a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = C1052x9456cfc2.m16683a(jsonParser);
                Object reactionUnitUserSettingsDisableUnitTypeCoreMutationFragmentModel = new ReactionUnitUserSettingsDisableUnitTypeCoreMutationFragmentModel();
                ((BaseModel) reactionUnitUserSettingsDisableUnitTypeCoreMutationFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionUnitUserSettingsDisableUnitTypeCoreMutationFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionUnitUserSettingsDisableUnitTypeCoreMutationFragmentModel).a();
                }
                return reactionUnitUserSettingsDisableUnitTypeCoreMutationFragmentModel;
            }
        }

        /* compiled from: fetched_candidates_size */
        public class Serializer extends JsonSerializer<ReactionUnitUserSettingsDisableUnitTypeCoreMutationFragmentModel> {
            public final void m16666a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionUnitUserSettingsDisableUnitTypeCoreMutationFragmentModel reactionUnitUserSettingsDisableUnitTypeCoreMutationFragmentModel = (ReactionUnitUserSettingsDisableUnitTypeCoreMutationFragmentModel) obj;
                if (reactionUnitUserSettingsDisableUnitTypeCoreMutationFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionUnitUserSettingsDisableUnitTypeCoreMutationFragmentModel.m16668a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionUnitUserSettingsDisableUnitTypeCoreMutationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionUnitUserSettingsDisableUnitTypeCoreMutationFragmentModel.w_();
                int u_ = reactionUnitUserSettingsDisableUnitTypeCoreMutationFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("reaction_unit_user_settings");
                    ReactionUnitUserSettingsFragmentParser.m16685a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionUnitUserSettingsDisableUnitTypeCoreMutationFragmentModel.class, new Serializer());
            }
        }

        public ReactionUnitUserSettingsDisableUnitTypeCoreMutationFragmentModel() {
            super(1);
        }

        @Nullable
        private ReactionUnitUserSettingsFragmentModel m16667a() {
            this.f13264d = (ReactionUnitUserSettingsFragmentModel) super.a(this.f13264d, 0, ReactionUnitUserSettingsFragmentModel.class);
            return this.f13264d;
        }

        public final int jK_() {
            return -1788513470;
        }

        public final GraphQLVisitableModel m16669a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16667a() != null) {
                ReactionUnitUserSettingsFragmentModel reactionUnitUserSettingsFragmentModel = (ReactionUnitUserSettingsFragmentModel) graphQLModelMutatingVisitor.b(m16667a());
                if (m16667a() != reactionUnitUserSettingsFragmentModel) {
                    graphQLVisitableModel = (ReactionUnitUserSettingsDisableUnitTypeCoreMutationFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13264d = reactionUnitUserSettingsFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16668a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16667a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1679487358)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: fetched_candidates_size */
    public final class ReactionUnitUserSettingsFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        private boolean f13265d;
        @Nullable
        private String f13266e;
        @Nullable
        private String f13267f;

        /* compiled from: fetched_candidates_size */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionUnitUserSettingsFragmentModel.class, new Deserializer());
            }

            public Object m16670a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionUnitUserSettingsFragmentParser.m16684a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionUnitUserSettingsFragmentModel = new ReactionUnitUserSettingsFragmentModel();
                ((BaseModel) reactionUnitUserSettingsFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionUnitUserSettingsFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionUnitUserSettingsFragmentModel).a();
                }
                return reactionUnitUserSettingsFragmentModel;
            }
        }

        /* compiled from: fetched_candidates_size */
        public class Serializer extends JsonSerializer<ReactionUnitUserSettingsFragmentModel> {
            public final void m16671a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReactionUnitUserSettingsFragmentModel reactionUnitUserSettingsFragmentModel = (ReactionUnitUserSettingsFragmentModel) obj;
                if (reactionUnitUserSettingsFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionUnitUserSettingsFragmentModel.m16674a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionUnitUserSettingsFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReactionUnitUserSettingsFragmentParser.m16685a(reactionUnitUserSettingsFragmentModel.w_(), reactionUnitUserSettingsFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(ReactionUnitUserSettingsFragmentModel.class, new Serializer());
            }
        }

        public ReactionUnitUserSettingsFragmentModel() {
            super(3);
        }

        @Nullable
        private String m16672j() {
            this.f13266e = super.a(this.f13266e, 1);
            return this.f13266e;
        }

        @Nullable
        private String m16673k() {
            this.f13267f = super.a(this.f13267f, 2);
            return this.f13267f;
        }

        @Nullable
        public final String m16676a() {
            return m16672j();
        }

        public final int jK_() {
            return 1961814299;
        }

        public final GraphQLVisitableModel m16675a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m16674a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16672j());
            int b2 = flatBufferBuilder.b(m16673k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f13265d);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16677a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f13265d = mutableFlatBuffer.a(i, 0);
        }
    }
}
