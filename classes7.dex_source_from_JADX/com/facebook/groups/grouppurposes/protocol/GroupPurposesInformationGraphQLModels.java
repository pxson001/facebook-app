package com.facebook.groups.grouppurposes.protocol;

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
import com.facebook.groups.grouppurposes.protocol.FetchGroupPurposesQueryInterfaces.GroupPurposeFragment;
import com.facebook.groups.grouppurposes.protocol.FetchGroupPurposesQueryModels.GroupPurposeFragmentModel;
import com.facebook.groups.grouppurposes.protocol.GroupPurposesInformationGraphQLInterfaces.GroupPurposesInformation;
import com.facebook.groups.grouppurposes.protocol.GroupPurposesInformationGraphQLParsers.GroupPurposesInformationParser;
import com.facebook.groups.grouppurposes.protocol.GroupPurposesInformationGraphQLParsers.GroupPurposesInformationParser.GroupPurposesParser;
import com.facebook.groups.grouppurposes.protocol.GroupPurposesInformationGraphQLParsers.GroupPurposesInformationParser.SuggestedPurposeParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: protocol_version */
public class GroupPurposesInformationGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 140064718)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: protocol_version */
    public final class GroupPurposesInformationModel extends BaseModel implements GraphQLVisitableConsistentModel, GroupPurposesInformation {
        @Nullable
        private GroupPurposesModel f5728d;
        @Nullable
        private SuggestedPurposeModel f5729e;

        /* compiled from: protocol_version */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupPurposesInformationModel.class, new Deserializer());
            }

            public Object m7011a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupPurposesInformationParser.m7035a(jsonParser);
                Object groupPurposesInformationModel = new GroupPurposesInformationModel();
                ((BaseModel) groupPurposesInformationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupPurposesInformationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupPurposesInformationModel).a();
                }
                return groupPurposesInformationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -520604827)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: protocol_version */
        public final class GroupPurposesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<GroupPurposeFragmentModel> f5725d;

            /* compiled from: protocol_version */
            public final class Builder {
                @Nullable
                public ImmutableList<GroupPurposeFragmentModel> f5724a;
            }

            /* compiled from: protocol_version */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupPurposesModel.class, new Deserializer());
                }

                public Object m7012a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupPurposesParser.m7031a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupPurposesModel = new GroupPurposesModel();
                    ((BaseModel) groupPurposesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupPurposesModel instanceof Postprocessable) {
                        return ((Postprocessable) groupPurposesModel).a();
                    }
                    return groupPurposesModel;
                }
            }

            /* compiled from: protocol_version */
            public class Serializer extends JsonSerializer<GroupPurposesModel> {
                public final void m7013a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupPurposesModel groupPurposesModel = (GroupPurposesModel) obj;
                    if (groupPurposesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupPurposesModel.m7015a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupPurposesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupPurposesParser.m7032a(groupPurposesModel.w_(), groupPurposesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupPurposesModel.class, new Serializer());
                }
            }

            public GroupPurposesModel() {
                super(1);
            }

            public GroupPurposesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nonnull
            public final ImmutableList<GroupPurposeFragmentModel> m7017a() {
                this.f5725d = super.a(this.f5725d, 0, GroupPurposeFragmentModel.class);
                return (ImmutableList) this.f5725d;
            }

            public static GroupPurposesModel m7014a(GroupPurposesModel groupPurposesModel) {
                if (groupPurposesModel == null) {
                    return null;
                }
                if (groupPurposesModel instanceof GroupPurposesModel) {
                    return groupPurposesModel;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < groupPurposesModel.m7017a().size(); i++) {
                    builder2.c(GroupPurposeFragmentModel.m6980a((GroupPurposeFragment) groupPurposesModel.m7017a().get(i)));
                }
                builder.f5724a = builder2.b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f5724a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new GroupPurposesModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1875344723;
            }

            public final GraphQLVisitableModel m7016a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m7017a() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m7017a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (GroupPurposesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5725d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m7015a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m7017a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: protocol_version */
        public class Serializer extends JsonSerializer<GroupPurposesInformationModel> {
            public final void m7018a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupPurposesInformationModel groupPurposesInformationModel = (GroupPurposesInformationModel) obj;
                if (groupPurposesInformationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupPurposesInformationModel.m7027a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupPurposesInformationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupPurposesInformationModel.w_();
                int u_ = groupPurposesInformationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group_purposes");
                    GroupPurposesParser.m7032a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("suggested_purpose");
                    SuggestedPurposeParser.m7034a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupPurposesInformationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1611730139)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: protocol_version */
        public final class SuggestedPurposeModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f5727d;

            /* compiled from: protocol_version */
            public final class Builder {
                @Nullable
                public String f5726a;
            }

            /* compiled from: protocol_version */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SuggestedPurposeModel.class, new Deserializer());
                }

                public Object m7019a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SuggestedPurposeParser.m7033a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object suggestedPurposeModel = new SuggestedPurposeModel();
                    ((BaseModel) suggestedPurposeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (suggestedPurposeModel instanceof Postprocessable) {
                        return ((Postprocessable) suggestedPurposeModel).a();
                    }
                    return suggestedPurposeModel;
                }
            }

            /* compiled from: protocol_version */
            public class Serializer extends JsonSerializer<SuggestedPurposeModel> {
                public final void m7020a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SuggestedPurposeModel suggestedPurposeModel = (SuggestedPurposeModel) obj;
                    if (suggestedPurposeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(suggestedPurposeModel.m7022a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        suggestedPurposeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SuggestedPurposeParser.m7034a(suggestedPurposeModel.w_(), suggestedPurposeModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SuggestedPurposeModel.class, new Serializer());
                }
            }

            public SuggestedPurposeModel() {
                super(1);
            }

            public SuggestedPurposeModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m7024a() {
                this.f5727d = super.a(this.f5727d, 0);
                return this.f5727d;
            }

            public static SuggestedPurposeModel m7021a(SuggestedPurposeModel suggestedPurposeModel) {
                if (suggestedPurposeModel == null) {
                    return null;
                }
                if (suggestedPurposeModel instanceof SuggestedPurposeModel) {
                    return suggestedPurposeModel;
                }
                Builder builder = new Builder();
                builder.f5726a = suggestedPurposeModel.m7024a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f5726a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new SuggestedPurposeModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -405572161;
            }

            public final GraphQLVisitableModel m7023a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m7022a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m7024a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public GroupPurposesInformationModel() {
            super(2);
        }

        public final void m7029a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m7030a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GroupPurposesModel m7025a() {
            this.f5728d = (GroupPurposesModel) super.a(this.f5728d, 0, GroupPurposesModel.class);
            return this.f5728d;
        }

        @Nullable
        private SuggestedPurposeModel m7026j() {
            this.f5729e = (SuggestedPurposeModel) super.a(this.f5729e, 1, SuggestedPurposeModel.class);
            return this.f5729e;
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m7028a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7025a() != null) {
                GroupPurposesModel groupPurposesModel = (GroupPurposesModel) graphQLModelMutatingVisitor.b(m7025a());
                if (m7025a() != groupPurposesModel) {
                    graphQLVisitableModel = (GroupPurposesInformationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5728d = groupPurposesModel;
                }
            }
            if (m7026j() != null) {
                SuggestedPurposeModel suggestedPurposeModel = (SuggestedPurposeModel) graphQLModelMutatingVisitor.b(m7026j());
                if (m7026j() != suggestedPurposeModel) {
                    graphQLVisitableModel = (GroupPurposesInformationModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5729e = suggestedPurposeModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7027a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m7025a());
            int a2 = ModelHelper.a(flatBufferBuilder, m7026j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
