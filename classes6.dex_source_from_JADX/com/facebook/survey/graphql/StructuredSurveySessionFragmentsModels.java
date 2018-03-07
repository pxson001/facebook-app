package com.facebook.survey.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLStructuredSurveyCustomQuestionType;
import com.facebook.graphql.enums.GraphQLStructuredSurveyQuestionTokenParamType;
import com.facebook.graphql.enums.GraphQLStructuredSurveyQuestionType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsInterfaces.StructuredSurveyNestedControlNodeFragment;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsParsers.StructuredSurveyBranchNodeResponseMapEntryFragmentParser;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsParsers.StructuredSurveyConfiguredQuestionFragmentParser;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsParsers.StructuredSurveyControlNodeFragmentParser;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsParsers.StructuredSurveyFlowFragmentParser;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsParsers.StructuredSurveyFlowPageFragmentParser;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsParsers.StructuredSurveyFlowPageFragmentParser.BucketsParser;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsParsers.StructuredSurveyFragmentParser;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsParsers.StructuredSurveyNestedControlNodeFragmentParser;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsParsers.StructuredSurveyQuestionTokenParamFragmentParser;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsParsers.StructuredSurveyResponseOptionFragmentParser;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsParsers.SurveyConfigFragmentParser;
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

/* compiled from: direct_next_page_index_int */
public class StructuredSurveySessionFragmentsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1891483651)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: direct_next_page_index_int */
    public final class StructuredSurveyBranchNodeResponseMapEntryFragmentModel extends BaseModel implements GraphQLVisitableModel {
        private int f17246d;
        private int f17247e;

        /* compiled from: direct_next_page_index_int */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StructuredSurveyBranchNodeResponseMapEntryFragmentModel.class, new Deserializer());
            }

            public Object m25010a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(StructuredSurveyBranchNodeResponseMapEntryFragmentParser.m25119b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object structuredSurveyBranchNodeResponseMapEntryFragmentModel = new StructuredSurveyBranchNodeResponseMapEntryFragmentModel();
                ((BaseModel) structuredSurveyBranchNodeResponseMapEntryFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (structuredSurveyBranchNodeResponseMapEntryFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) structuredSurveyBranchNodeResponseMapEntryFragmentModel).a();
                }
                return structuredSurveyBranchNodeResponseMapEntryFragmentModel;
            }
        }

        /* compiled from: direct_next_page_index_int */
        public class Serializer extends JsonSerializer<StructuredSurveyBranchNodeResponseMapEntryFragmentModel> {
            public final void m25011a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                StructuredSurveyBranchNodeResponseMapEntryFragmentModel structuredSurveyBranchNodeResponseMapEntryFragmentModel = (StructuredSurveyBranchNodeResponseMapEntryFragmentModel) obj;
                if (structuredSurveyBranchNodeResponseMapEntryFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(structuredSurveyBranchNodeResponseMapEntryFragmentModel.m25013a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    structuredSurveyBranchNodeResponseMapEntryFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                StructuredSurveyBranchNodeResponseMapEntryFragmentParser.m25117a(structuredSurveyBranchNodeResponseMapEntryFragmentModel.w_(), structuredSurveyBranchNodeResponseMapEntryFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(StructuredSurveyBranchNodeResponseMapEntryFragmentModel.class, new Serializer());
            }
        }

        public StructuredSurveyBranchNodeResponseMapEntryFragmentModel() {
            super(2);
        }

        public final int m25012a() {
            a(0, 0);
            return this.f17246d;
        }

        public final int m25016b() {
            a(0, 1);
            return this.f17247e;
        }

        public final int jK_() {
            return 179014;
        }

        public final GraphQLVisitableModel m25014a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m25013a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f17246d, 0);
            flatBufferBuilder.a(1, this.f17247e, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m25015a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f17246d = mutableFlatBuffer.a(i, 0, 0);
            this.f17247e = mutableFlatBuffer.a(i, 1, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1882222003)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: direct_next_page_index_int */
    public final class StructuredSurveyConfiguredQuestionFragmentModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f17248d;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f17249e;
        @Nullable
        private GraphQLStructuredSurveyCustomQuestionType f17250f;
        private boolean f17251g;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f17252h;
        @Nullable
        private GraphQLStructuredSurveyQuestionType f17253i;
        @Nullable
        private String f17254j;
        @Nullable
        private List<StructuredSurveyResponseOptionFragmentModel> f17255k;
        @Nullable
        private List<DefaultTextWithEntitiesLongFieldsModel> f17256l;
        @Nullable
        private List<StructuredSurveyQuestionTokenParamFragmentModel> f17257m;

        /* compiled from: direct_next_page_index_int */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StructuredSurveyConfiguredQuestionFragmentModel.class, new Deserializer());
            }

            public Object m25017a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(StructuredSurveyConfiguredQuestionFragmentParser.m25120b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object structuredSurveyConfiguredQuestionFragmentModel = new StructuredSurveyConfiguredQuestionFragmentModel();
                ((BaseModel) structuredSurveyConfiguredQuestionFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (structuredSurveyConfiguredQuestionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) structuredSurveyConfiguredQuestionFragmentModel).a();
                }
                return structuredSurveyConfiguredQuestionFragmentModel;
            }
        }

        /* compiled from: direct_next_page_index_int */
        public class Serializer extends JsonSerializer<StructuredSurveyConfiguredQuestionFragmentModel> {
            public final void m25018a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                StructuredSurveyConfiguredQuestionFragmentModel structuredSurveyConfiguredQuestionFragmentModel = (StructuredSurveyConfiguredQuestionFragmentModel) obj;
                if (structuredSurveyConfiguredQuestionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(structuredSurveyConfiguredQuestionFragmentModel.m25020a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    structuredSurveyConfiguredQuestionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                StructuredSurveyConfiguredQuestionFragmentParser.m25121b(structuredSurveyConfiguredQuestionFragmentModel.w_(), structuredSurveyConfiguredQuestionFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(StructuredSurveyConfiguredQuestionFragmentModel.class, new Serializer());
            }
        }

        public StructuredSurveyConfiguredQuestionFragmentModel() {
            super(10);
        }

        public final boolean m25023a() {
            a(0, 0);
            return this.f17248d;
        }

        @Nullable
        public final DefaultTextWithEntitiesLongFieldsModel m25024j() {
            this.f17249e = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f17249e, 1, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f17249e;
        }

        @Nullable
        public final GraphQLStructuredSurveyCustomQuestionType m25025k() {
            this.f17250f = (GraphQLStructuredSurveyCustomQuestionType) super.b(this.f17250f, 2, GraphQLStructuredSurveyCustomQuestionType.class, GraphQLStructuredSurveyCustomQuestionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17250f;
        }

        @Nullable
        public final DefaultTextWithEntitiesLongFieldsModel m25026l() {
            this.f17252h = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f17252h, 4, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f17252h;
        }

        @Nullable
        public final GraphQLStructuredSurveyQuestionType m25027m() {
            this.f17253i = (GraphQLStructuredSurveyQuestionType) super.b(this.f17253i, 5, GraphQLStructuredSurveyQuestionType.class, GraphQLStructuredSurveyQuestionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17253i;
        }

        @Nullable
        public final String m25028n() {
            this.f17254j = super.a(this.f17254j, 6);
            return this.f17254j;
        }

        @Nonnull
        public final ImmutableList<StructuredSurveyResponseOptionFragmentModel> m25029o() {
            this.f17255k = super.a(this.f17255k, 7, StructuredSurveyResponseOptionFragmentModel.class);
            return (ImmutableList) this.f17255k;
        }

        @Nonnull
        private ImmutableList<DefaultTextWithEntitiesLongFieldsModel> m25019q() {
            this.f17256l = super.a(this.f17256l, 8, DefaultTextWithEntitiesLongFieldsModel.class);
            return (ImmutableList) this.f17256l;
        }

        @Nonnull
        public final ImmutableList<StructuredSurveyQuestionTokenParamFragmentModel> m25030p() {
            this.f17257m = super.a(this.f17257m, 9, StructuredSurveyQuestionTokenParamFragmentModel.class);
            return (ImmutableList) this.f17257m;
        }

        public final int jK_() {
            return -2122712113;
        }

        public final GraphQLVisitableModel m25021a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel;
            Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25024j() != null) {
                defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m25024j());
                if (m25024j() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (StructuredSurveyConfiguredQuestionFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17249e = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            if (m25026l() != null) {
                defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m25026l());
                if (m25026l() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (StructuredSurveyConfiguredQuestionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17252h = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            if (m25029o() != null) {
                a = ModelHelper.a(m25029o(), graphQLModelMutatingVisitor);
                if (a != null) {
                    StructuredSurveyConfiguredQuestionFragmentModel structuredSurveyConfiguredQuestionFragmentModel = (StructuredSurveyConfiguredQuestionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    structuredSurveyConfiguredQuestionFragmentModel.f17255k = a.b();
                    graphQLVisitableModel = structuredSurveyConfiguredQuestionFragmentModel;
                }
            }
            if (m25019q() != null) {
                a = ModelHelper.a(m25019q(), graphQLModelMutatingVisitor);
                if (a != null) {
                    structuredSurveyConfiguredQuestionFragmentModel = (StructuredSurveyConfiguredQuestionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    structuredSurveyConfiguredQuestionFragmentModel.f17256l = a.b();
                    graphQLVisitableModel = structuredSurveyConfiguredQuestionFragmentModel;
                }
            }
            if (m25030p() != null) {
                a = ModelHelper.a(m25030p(), graphQLModelMutatingVisitor);
                if (a != null) {
                    structuredSurveyConfiguredQuestionFragmentModel = (StructuredSurveyConfiguredQuestionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    structuredSurveyConfiguredQuestionFragmentModel.f17257m = a.b();
                    graphQLVisitableModel = structuredSurveyConfiguredQuestionFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25020a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25024j());
            int a2 = flatBufferBuilder.a(m25025k());
            int a3 = ModelHelper.a(flatBufferBuilder, m25026l());
            int a4 = flatBufferBuilder.a(m25027m());
            int b = flatBufferBuilder.b(m25028n());
            int a5 = ModelHelper.a(flatBufferBuilder, m25029o());
            int a6 = ModelHelper.a(flatBufferBuilder, m25019q());
            int a7 = ModelHelper.a(flatBufferBuilder, m25030p());
            flatBufferBuilder.c(10);
            flatBufferBuilder.a(0, this.f17248d);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.a(3, this.f17251g);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, b);
            flatBufferBuilder.b(7, a5);
            flatBufferBuilder.b(8, a6);
            flatBufferBuilder.b(9, a7);
            i();
            return flatBufferBuilder.d();
        }

        public final void m25022a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f17248d = mutableFlatBuffer.a(i, 0);
            this.f17251g = mutableFlatBuffer.a(i, 3);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1971623532)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: direct_next_page_index_int */
    public final class StructuredSurveyControlNodeFragmentModel extends BaseModel implements GraphQLVisitableModel, StructuredSurveyNestedControlNodeFragment {
        private int f17258d;
        @Nullable
        private String f17259e;
        @Nullable
        private List<StructuredSurveyBranchNodeResponseMapEntryFragmentModel> f17260f;
        private int f17261g;
        @Nullable
        private StructuredSurveyNestedControlNodeFragmentModel f17262h;
        @Nullable
        private List<StructuredSurveyNestedControlNodeFragmentModel> f17263i;
        private int f17264j;
        @Nullable
        private String f17265k;
        private int f17266l;
        @Nullable
        private List<Integer> f17267m;

        /* compiled from: direct_next_page_index_int */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StructuredSurveyControlNodeFragmentModel.class, new Deserializer());
            }

            public Object m25031a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(StructuredSurveyControlNodeFragmentParser.m25122a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object structuredSurveyControlNodeFragmentModel = new StructuredSurveyControlNodeFragmentModel();
                ((BaseModel) structuredSurveyControlNodeFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (structuredSurveyControlNodeFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) structuredSurveyControlNodeFragmentModel).a();
                }
                return structuredSurveyControlNodeFragmentModel;
            }
        }

        /* compiled from: direct_next_page_index_int */
        public class Serializer extends JsonSerializer<StructuredSurveyControlNodeFragmentModel> {
            public final void m25032a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                StructuredSurveyControlNodeFragmentModel structuredSurveyControlNodeFragmentModel = (StructuredSurveyControlNodeFragmentModel) obj;
                if (structuredSurveyControlNodeFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(structuredSurveyControlNodeFragmentModel.m25034a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    structuredSurveyControlNodeFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                StructuredSurveyControlNodeFragmentParser.m25123a(structuredSurveyControlNodeFragmentModel.w_(), structuredSurveyControlNodeFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(StructuredSurveyControlNodeFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ StructuredSurveyNestedControlNodeFragment m25036a() {
            return m25033k();
        }

        public StructuredSurveyControlNodeFragmentModel() {
            super(10);
        }

        public final int mo1297c() {
            a(0, 0);
            return this.f17258d;
        }

        @Nullable
        public final String mo1301d() {
            this.f17259e = super.a(this.f17259e, 1);
            return this.f17259e;
        }

        @Nonnull
        public final ImmutableList<StructuredSurveyBranchNodeResponseMapEntryFragmentModel> cS_() {
            this.f17260f = super.a(this.f17260f, 2, StructuredSurveyBranchNodeResponseMapEntryFragmentModel.class);
            return (ImmutableList) this.f17260f;
        }

        @Nullable
        private StructuredSurveyNestedControlNodeFragmentModel m25033k() {
            this.f17262h = (StructuredSurveyNestedControlNodeFragmentModel) super.a(this.f17262h, 4, StructuredSurveyNestedControlNodeFragmentModel.class);
            return this.f17262h;
        }

        @Nonnull
        public final ImmutableList<StructuredSurveyNestedControlNodeFragmentModel> m25038b() {
            this.f17263i = super.a(this.f17263i, 5, StructuredSurveyNestedControlNodeFragmentModel.class);
            return (ImmutableList) this.f17263i;
        }

        public final int mo1302g() {
            a(0, 6);
            return this.f17264j;
        }

        @Nullable
        public final String cT_() {
            this.f17265k = super.a(this.f17265k, 7);
            return this.f17265k;
        }

        public final int cU_() {
            a(1, 0);
            return this.f17266l;
        }

        @Nonnull
        public final ImmutableList<Integer> mo1303j() {
            this.f17267m = super.b(this.f17267m, 9);
            return (ImmutableList) this.f17267m;
        }

        public final int jK_() {
            return 158377940;
        }

        public final GraphQLVisitableModel m25035a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            StructuredSurveyControlNodeFragmentModel structuredSurveyControlNodeFragmentModel;
            GraphQLVisitableModel graphQLVisitableModel;
            StructuredSurveyNestedControlNodeFragmentModel structuredSurveyNestedControlNodeFragmentModel;
            Builder a;
            h();
            if (cS_() != null) {
                Builder a2 = ModelHelper.a(cS_(), graphQLModelMutatingVisitor);
                if (a2 != null) {
                    structuredSurveyControlNodeFragmentModel = (StructuredSurveyControlNodeFragmentModel) ModelHelper.a(null, this);
                    structuredSurveyControlNodeFragmentModel.f17260f = a2.b();
                    graphQLVisitableModel = structuredSurveyControlNodeFragmentModel;
                    if (m25033k() != null) {
                        structuredSurveyNestedControlNodeFragmentModel = (StructuredSurveyNestedControlNodeFragmentModel) graphQLModelMutatingVisitor.b(m25033k());
                        if (m25033k() != structuredSurveyNestedControlNodeFragmentModel) {
                            graphQLVisitableModel = (StructuredSurveyControlNodeFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f17262h = structuredSurveyNestedControlNodeFragmentModel;
                        }
                    }
                    if (m25038b() != null) {
                        a = ModelHelper.a(m25038b(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            structuredSurveyControlNodeFragmentModel = (StructuredSurveyControlNodeFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            structuredSurveyControlNodeFragmentModel.f17263i = a.b();
                            graphQLVisitableModel = structuredSurveyControlNodeFragmentModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m25033k() != null) {
                structuredSurveyNestedControlNodeFragmentModel = (StructuredSurveyNestedControlNodeFragmentModel) graphQLModelMutatingVisitor.b(m25033k());
                if (m25033k() != structuredSurveyNestedControlNodeFragmentModel) {
                    graphQLVisitableModel = (StructuredSurveyControlNodeFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17262h = structuredSurveyNestedControlNodeFragmentModel;
                }
            }
            if (m25038b() != null) {
                a = ModelHelper.a(m25038b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    structuredSurveyControlNodeFragmentModel = (StructuredSurveyControlNodeFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    structuredSurveyControlNodeFragmentModel.f17263i = a.b();
                    graphQLVisitableModel = structuredSurveyControlNodeFragmentModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m25034a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(mo1301d());
            int a = ModelHelper.a(flatBufferBuilder, cS_());
            int a2 = ModelHelper.a(flatBufferBuilder, m25033k());
            int a3 = ModelHelper.a(flatBufferBuilder, m25038b());
            int b2 = flatBufferBuilder.b(cT_());
            int a4 = flatBufferBuilder.a(mo1303j());
            flatBufferBuilder.c(10);
            flatBufferBuilder.a(0, this.f17258d, 0);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.a(3, this.f17261g, 0);
            flatBufferBuilder.b(4, a2);
            flatBufferBuilder.b(5, a3);
            flatBufferBuilder.a(6, this.f17264j, 0);
            flatBufferBuilder.b(7, b2);
            flatBufferBuilder.a(8, this.f17266l, 0);
            flatBufferBuilder.b(9, a4);
            i();
            return flatBufferBuilder.d();
        }

        public final void m25037a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f17258d = mutableFlatBuffer.a(i, 0, 0);
            this.f17261g = mutableFlatBuffer.a(i, 3, 0);
            this.f17264j = mutableFlatBuffer.a(i, 6, 0);
            this.f17266l = mutableFlatBuffer.a(i, 8, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1328624443)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: direct_next_page_index_int */
    public final class StructuredSurveyFlowFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f17268d;
        @Nullable
        private StructuredSurveyControlNodeFragmentModel f17269e;
        @Nullable
        private List<StructuredSurveyFlowPageFragmentModel> f17270f;

        /* compiled from: direct_next_page_index_int */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StructuredSurveyFlowFragmentModel.class, new Deserializer());
            }

            public Object m25043a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(StructuredSurveyFlowFragmentParser.m25124a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object structuredSurveyFlowFragmentModel = new StructuredSurveyFlowFragmentModel();
                ((BaseModel) structuredSurveyFlowFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (structuredSurveyFlowFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) structuredSurveyFlowFragmentModel).a();
                }
                return structuredSurveyFlowFragmentModel;
            }
        }

        /* compiled from: direct_next_page_index_int */
        public class Serializer extends JsonSerializer<StructuredSurveyFlowFragmentModel> {
            public final void m25044a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                StructuredSurveyFlowFragmentModel structuredSurveyFlowFragmentModel = (StructuredSurveyFlowFragmentModel) obj;
                if (structuredSurveyFlowFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(structuredSurveyFlowFragmentModel.m25045a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    structuredSurveyFlowFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                StructuredSurveyFlowFragmentParser.m25125a(structuredSurveyFlowFragmentModel.w_(), structuredSurveyFlowFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(StructuredSurveyFlowFragmentModel.class, new Serializer());
            }
        }

        public StructuredSurveyFlowFragmentModel() {
            super(3);
        }

        @Nullable
        public final String m25047a() {
            this.f17268d = super.a(this.f17268d, 0);
            return this.f17268d;
        }

        @Nullable
        public final StructuredSurveyControlNodeFragmentModel m25048j() {
            this.f17269e = (StructuredSurveyControlNodeFragmentModel) super.a(this.f17269e, 1, StructuredSurveyControlNodeFragmentModel.class);
            return this.f17269e;
        }

        @Nonnull
        public final ImmutableList<StructuredSurveyFlowPageFragmentModel> m25049k() {
            this.f17270f = super.a(this.f17270f, 2, StructuredSurveyFlowPageFragmentModel.class);
            return (ImmutableList) this.f17270f;
        }

        public final int jK_() {
            return -1780695047;
        }

        public final GraphQLVisitableModel m25046a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25048j() != null) {
                StructuredSurveyControlNodeFragmentModel structuredSurveyControlNodeFragmentModel = (StructuredSurveyControlNodeFragmentModel) graphQLModelMutatingVisitor.b(m25048j());
                if (m25048j() != structuredSurveyControlNodeFragmentModel) {
                    graphQLVisitableModel = (StructuredSurveyFlowFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17269e = structuredSurveyControlNodeFragmentModel;
                }
            }
            if (m25049k() != null) {
                Builder a = ModelHelper.a(m25049k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    StructuredSurveyFlowFragmentModel structuredSurveyFlowFragmentModel = (StructuredSurveyFlowFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    structuredSurveyFlowFragmentModel.f17270f = a.b();
                    graphQLVisitableModel = structuredSurveyFlowFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25045a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m25047a());
            int a = ModelHelper.a(flatBufferBuilder, m25048j());
            int a2 = ModelHelper.a(flatBufferBuilder, m25049k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1189922202)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: direct_next_page_index_int */
    public final class StructuredSurveyFlowPageFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<BucketsModel> f17272d;
        @Nullable
        private StructuredSurveyControlNodeFragmentModel f17273e;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1733732423)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: direct_next_page_index_int */
        public final class BucketsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<StructuredSurveyConfiguredQuestionFragmentModel> f17271d;

            /* compiled from: direct_next_page_index_int */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(BucketsModel.class, new Deserializer());
                }

                public Object m25050a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BucketsParser.m25126b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object bucketsModel = new BucketsModel();
                    ((BaseModel) bucketsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (bucketsModel instanceof Postprocessable) {
                        return ((Postprocessable) bucketsModel).a();
                    }
                    return bucketsModel;
                }
            }

            /* compiled from: direct_next_page_index_int */
            public class Serializer extends JsonSerializer<BucketsModel> {
                public final void m25051a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    BucketsModel bucketsModel = (BucketsModel) obj;
                    if (bucketsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(bucketsModel.m25052a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        bucketsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BucketsParser.m25127b(bucketsModel.w_(), bucketsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(BucketsModel.class, new Serializer());
                }
            }

            public BucketsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<StructuredSurveyConfiguredQuestionFragmentModel> m25054a() {
                this.f17271d = super.a(this.f17271d, 0, StructuredSurveyConfiguredQuestionFragmentModel.class);
                return (ImmutableList) this.f17271d;
            }

            public final int jK_() {
                return 1916819267;
            }

            public final GraphQLVisitableModel m25053a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m25054a() != null) {
                    Builder a = ModelHelper.a(m25054a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (BucketsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17271d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m25052a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m25054a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: direct_next_page_index_int */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StructuredSurveyFlowPageFragmentModel.class, new Deserializer());
            }

            public Object m25055a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(StructuredSurveyFlowPageFragmentParser.m25128b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object structuredSurveyFlowPageFragmentModel = new StructuredSurveyFlowPageFragmentModel();
                ((BaseModel) structuredSurveyFlowPageFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (structuredSurveyFlowPageFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) structuredSurveyFlowPageFragmentModel).a();
                }
                return structuredSurveyFlowPageFragmentModel;
            }
        }

        /* compiled from: direct_next_page_index_int */
        public class Serializer extends JsonSerializer<StructuredSurveyFlowPageFragmentModel> {
            public final void m25056a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                StructuredSurveyFlowPageFragmentModel structuredSurveyFlowPageFragmentModel = (StructuredSurveyFlowPageFragmentModel) obj;
                if (structuredSurveyFlowPageFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(structuredSurveyFlowPageFragmentModel.m25057a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    structuredSurveyFlowPageFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                StructuredSurveyFlowPageFragmentParser.m25129b(structuredSurveyFlowPageFragmentModel.w_(), structuredSurveyFlowPageFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(StructuredSurveyFlowPageFragmentModel.class, new Serializer());
            }
        }

        public StructuredSurveyFlowPageFragmentModel() {
            super(2);
        }

        @Nonnull
        public final ImmutableList<BucketsModel> m25059a() {
            this.f17272d = super.a(this.f17272d, 0, BucketsModel.class);
            return (ImmutableList) this.f17272d;
        }

        @Nullable
        public final StructuredSurveyControlNodeFragmentModel m25060j() {
            this.f17273e = (StructuredSurveyControlNodeFragmentModel) super.a(this.f17273e, 1, StructuredSurveyControlNodeFragmentModel.class);
            return this.f17273e;
        }

        public final int jK_() {
            return -650120664;
        }

        public final GraphQLVisitableModel m25058a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            StructuredSurveyControlNodeFragmentModel structuredSurveyControlNodeFragmentModel;
            h();
            if (m25059a() != null) {
                Builder a = ModelHelper.a(m25059a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    StructuredSurveyFlowPageFragmentModel structuredSurveyFlowPageFragmentModel = (StructuredSurveyFlowPageFragmentModel) ModelHelper.a(null, this);
                    structuredSurveyFlowPageFragmentModel.f17272d = a.b();
                    graphQLVisitableModel = structuredSurveyFlowPageFragmentModel;
                    if (m25060j() != null) {
                        structuredSurveyControlNodeFragmentModel = (StructuredSurveyControlNodeFragmentModel) graphQLModelMutatingVisitor.b(m25060j());
                        if (m25060j() != structuredSurveyControlNodeFragmentModel) {
                            graphQLVisitableModel = (StructuredSurveyFlowPageFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f17273e = structuredSurveyControlNodeFragmentModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m25060j() != null) {
                structuredSurveyControlNodeFragmentModel = (StructuredSurveyControlNodeFragmentModel) graphQLModelMutatingVisitor.b(m25060j());
                if (m25060j() != structuredSurveyControlNodeFragmentModel) {
                    graphQLVisitableModel = (StructuredSurveyFlowPageFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17273e = structuredSurveyControlNodeFragmentModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m25057a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25059a());
            int a2 = ModelHelper.a(flatBufferBuilder, m25060j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1938861645)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: direct_next_page_index_int */
    public final class StructuredSurveyFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f17274d;
        @Nullable
        private String f17275e;
        @Nullable
        private StructuredSurveyFlowFragmentModel f17276f;

        /* compiled from: direct_next_page_index_int */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StructuredSurveyFragmentModel.class, new Deserializer());
            }

            public Object m25061a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = StructuredSurveyFragmentParser.m25130a(jsonParser);
                Object structuredSurveyFragmentModel = new StructuredSurveyFragmentModel();
                ((BaseModel) structuredSurveyFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (structuredSurveyFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) structuredSurveyFragmentModel).a();
                }
                return structuredSurveyFragmentModel;
            }
        }

        /* compiled from: direct_next_page_index_int */
        public class Serializer extends JsonSerializer<StructuredSurveyFragmentModel> {
            public final void m25062a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                StructuredSurveyFragmentModel structuredSurveyFragmentModel = (StructuredSurveyFragmentModel) obj;
                if (structuredSurveyFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(structuredSurveyFragmentModel.m25064a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    structuredSurveyFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = structuredSurveyFragmentModel.w_();
                int u_ = structuredSurveyFragmentModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("survey_flow");
                    StructuredSurveyFlowFragmentParser.m25125a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(StructuredSurveyFragmentModel.class, new Serializer());
            }
        }

        public StructuredSurveyFragmentModel() {
            super(3);
        }

        @Nullable
        public final String m25067j() {
            this.f17274d = super.a(this.f17274d, 0);
            return this.f17274d;
        }

        @Nullable
        private String m25063l() {
            this.f17275e = super.a(this.f17275e, 1);
            return this.f17275e;
        }

        @Nullable
        public final StructuredSurveyFlowFragmentModel m25068k() {
            this.f17276f = (StructuredSurveyFlowFragmentModel) super.a(this.f17276f, 2, StructuredSurveyFlowFragmentModel.class);
            return this.f17276f;
        }

        @Nullable
        public final String m25066a() {
            return m25067j();
        }

        public final int jK_() {
            return -943106005;
        }

        public final GraphQLVisitableModel m25065a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25068k() != null) {
                StructuredSurveyFlowFragmentModel structuredSurveyFlowFragmentModel = (StructuredSurveyFlowFragmentModel) graphQLModelMutatingVisitor.b(m25068k());
                if (m25068k() != structuredSurveyFlowFragmentModel) {
                    graphQLVisitableModel = (StructuredSurveyFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17276f = structuredSurveyFlowFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25064a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m25067j());
            int b2 = flatBufferBuilder.b(m25063l());
            int a = ModelHelper.a(flatBufferBuilder, m25068k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 427872476)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: direct_next_page_index_int */
    public final class StructuredSurveyNestedControlNodeFragmentModel extends BaseModel implements GraphQLVisitableModel, StructuredSurveyNestedControlNodeFragment {
        private int f17277d;
        @Nullable
        private String f17278e;
        @Nullable
        private List<StructuredSurveyBranchNodeResponseMapEntryFragmentModel> f17279f;
        private int f17280g;
        private int f17281h;
        @Nullable
        private String f17282i;
        private int f17283j;
        @Nullable
        private List<Integer> f17284k;

        /* compiled from: direct_next_page_index_int */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StructuredSurveyNestedControlNodeFragmentModel.class, new Deserializer());
            }

            public Object m25069a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(StructuredSurveyNestedControlNodeFragmentParser.m25131a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object structuredSurveyNestedControlNodeFragmentModel = new StructuredSurveyNestedControlNodeFragmentModel();
                ((BaseModel) structuredSurveyNestedControlNodeFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (structuredSurveyNestedControlNodeFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) structuredSurveyNestedControlNodeFragmentModel).a();
                }
                return structuredSurveyNestedControlNodeFragmentModel;
            }
        }

        /* compiled from: direct_next_page_index_int */
        public class Serializer extends JsonSerializer<StructuredSurveyNestedControlNodeFragmentModel> {
            public final void m25070a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                StructuredSurveyNestedControlNodeFragmentModel structuredSurveyNestedControlNodeFragmentModel = (StructuredSurveyNestedControlNodeFragmentModel) obj;
                if (structuredSurveyNestedControlNodeFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(structuredSurveyNestedControlNodeFragmentModel.m25071a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    structuredSurveyNestedControlNodeFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                StructuredSurveyNestedControlNodeFragmentParser.m25133b(structuredSurveyNestedControlNodeFragmentModel.w_(), structuredSurveyNestedControlNodeFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(StructuredSurveyNestedControlNodeFragmentModel.class, new Serializer());
            }
        }

        public StructuredSurveyNestedControlNodeFragmentModel() {
            super(8);
        }

        public final int mo1297c() {
            a(0, 0);
            return this.f17277d;
        }

        @Nullable
        public final String mo1301d() {
            this.f17278e = super.a(this.f17278e, 1);
            return this.f17278e;
        }

        @Nonnull
        public final ImmutableList<StructuredSurveyBranchNodeResponseMapEntryFragmentModel> cS_() {
            this.f17279f = super.a(this.f17279f, 2, StructuredSurveyBranchNodeResponseMapEntryFragmentModel.class);
            return (ImmutableList) this.f17279f;
        }

        public final int mo1302g() {
            a(0, 4);
            return this.f17281h;
        }

        @Nullable
        public final String cT_() {
            this.f17282i = super.a(this.f17282i, 5);
            return this.f17282i;
        }

        public final int cU_() {
            a(0, 6);
            return this.f17283j;
        }

        @Nonnull
        public final ImmutableList<Integer> mo1303j() {
            this.f17284k = super.b(this.f17284k, 7);
            return (ImmutableList) this.f17284k;
        }

        public final int jK_() {
            return 158377940;
        }

        public final GraphQLVisitableModel m25072a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (cS_() != null) {
                Builder a = ModelHelper.a(cS_(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (StructuredSurveyNestedControlNodeFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17279f = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25071a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(mo1301d());
            int a = ModelHelper.a(flatBufferBuilder, cS_());
            int b2 = flatBufferBuilder.b(cT_());
            int a2 = flatBufferBuilder.a(mo1303j());
            flatBufferBuilder.c(8);
            flatBufferBuilder.a(0, this.f17277d, 0);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.a(3, this.f17280g, 0);
            flatBufferBuilder.a(4, this.f17281h, 0);
            flatBufferBuilder.b(5, b2);
            flatBufferBuilder.a(6, this.f17283j, 0);
            flatBufferBuilder.b(7, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m25073a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f17277d = mutableFlatBuffer.a(i, 0, 0);
            this.f17280g = mutableFlatBuffer.a(i, 3, 0);
            this.f17281h = mutableFlatBuffer.a(i, 4, 0);
            this.f17283j = mutableFlatBuffer.a(i, 6, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -289858639)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: direct_next_page_index_int */
    public final class StructuredSurveyQuestionTokenParamFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f17285d;
        @Nullable
        private GraphQLStructuredSurveyQuestionTokenParamType f17286e;

        /* compiled from: direct_next_page_index_int */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StructuredSurveyQuestionTokenParamFragmentModel.class, new Deserializer());
            }

            public Object m25078a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(StructuredSurveyQuestionTokenParamFragmentParser.m25136b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object structuredSurveyQuestionTokenParamFragmentModel = new StructuredSurveyQuestionTokenParamFragmentModel();
                ((BaseModel) structuredSurveyQuestionTokenParamFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (structuredSurveyQuestionTokenParamFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) structuredSurveyQuestionTokenParamFragmentModel).a();
                }
                return structuredSurveyQuestionTokenParamFragmentModel;
            }
        }

        /* compiled from: direct_next_page_index_int */
        public class Serializer extends JsonSerializer<StructuredSurveyQuestionTokenParamFragmentModel> {
            public final void m25079a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                StructuredSurveyQuestionTokenParamFragmentModel structuredSurveyQuestionTokenParamFragmentModel = (StructuredSurveyQuestionTokenParamFragmentModel) obj;
                if (structuredSurveyQuestionTokenParamFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(structuredSurveyQuestionTokenParamFragmentModel.m25080a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    structuredSurveyQuestionTokenParamFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                StructuredSurveyQuestionTokenParamFragmentParser.m25135a(structuredSurveyQuestionTokenParamFragmentModel.w_(), structuredSurveyQuestionTokenParamFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(StructuredSurveyQuestionTokenParamFragmentModel.class, new Serializer());
            }
        }

        public StructuredSurveyQuestionTokenParamFragmentModel() {
            super(2);
        }

        @Nullable
        public final String m25082a() {
            this.f17285d = super.a(this.f17285d, 0);
            return this.f17285d;
        }

        @Nullable
        public final GraphQLStructuredSurveyQuestionTokenParamType m25083j() {
            this.f17286e = (GraphQLStructuredSurveyQuestionTokenParamType) super.b(this.f17286e, 1, GraphQLStructuredSurveyQuestionTokenParamType.class, GraphQLStructuredSurveyQuestionTokenParamType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17286e;
        }

        public final int jK_() {
            return 1228223013;
        }

        public final GraphQLVisitableModel m25081a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m25080a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m25082a());
            int a = flatBufferBuilder.a(m25083j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1137274450)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: direct_next_page_index_int */
    public final class StructuredSurveyResponseOptionFragmentModel extends BaseModel implements GraphQLVisitableModel {
        private int f17287d;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f17288e;
        @Nullable
        private String f17289f;

        /* compiled from: direct_next_page_index_int */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StructuredSurveyResponseOptionFragmentModel.class, new Deserializer());
            }

            public Object m25084a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(StructuredSurveyResponseOptionFragmentParser.m25138b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object structuredSurveyResponseOptionFragmentModel = new StructuredSurveyResponseOptionFragmentModel();
                ((BaseModel) structuredSurveyResponseOptionFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (structuredSurveyResponseOptionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) structuredSurveyResponseOptionFragmentModel).a();
                }
                return structuredSurveyResponseOptionFragmentModel;
            }
        }

        /* compiled from: direct_next_page_index_int */
        public class Serializer extends JsonSerializer<StructuredSurveyResponseOptionFragmentModel> {
            public final void m25085a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                StructuredSurveyResponseOptionFragmentModel structuredSurveyResponseOptionFragmentModel = (StructuredSurveyResponseOptionFragmentModel) obj;
                if (structuredSurveyResponseOptionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(structuredSurveyResponseOptionFragmentModel.m25087a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    structuredSurveyResponseOptionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                StructuredSurveyResponseOptionFragmentParser.m25139b(structuredSurveyResponseOptionFragmentModel.w_(), structuredSurveyResponseOptionFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(StructuredSurveyResponseOptionFragmentModel.class, new Serializer());
            }
        }

        public StructuredSurveyResponseOptionFragmentModel() {
            super(3);
        }

        public final int m25086a() {
            a(0, 0);
            return this.f17287d;
        }

        @Nullable
        public final DefaultTextWithEntitiesLongFieldsModel m25090j() {
            this.f17288e = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f17288e, 1, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f17288e;
        }

        @Nullable
        public final String m25091k() {
            this.f17289f = super.a(this.f17289f, 2);
            return this.f17289f;
        }

        public final int jK_() {
            return 997036321;
        }

        public final GraphQLVisitableModel m25088a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25090j() != null) {
                DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m25090j());
                if (m25090j() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (StructuredSurveyResponseOptionFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17288e = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25087a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25090j());
            int b = flatBufferBuilder.b(m25091k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f17287d, 0);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }

        public final void m25089a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f17287d = mutableFlatBuffer.a(i, 0, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 422381097)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: direct_next_page_index_int */
    public final class SurveyConfigFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        private boolean f17293d;
        private int f17294e;
        @Nullable
        private String f17295f;
        @Nullable
        private String f17296g;
        @Nullable
        private String f17297h;
        @Nullable
        private String f17298i;
        private boolean f17299j;
        @Nullable
        private String f17300k;
        @Nullable
        private String f17301l;

        /* compiled from: direct_next_page_index_int */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SurveyConfigFragmentModel.class, new Deserializer());
            }

            public Object m25102a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SurveyConfigFragmentParser.m25144a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object surveyConfigFragmentModel = new SurveyConfigFragmentModel();
                ((BaseModel) surveyConfigFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (surveyConfigFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) surveyConfigFragmentModel).a();
                }
                return surveyConfigFragmentModel;
            }
        }

        /* compiled from: direct_next_page_index_int */
        public class Serializer extends JsonSerializer<SurveyConfigFragmentModel> {
            public final void m25103a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SurveyConfigFragmentModel surveyConfigFragmentModel = (SurveyConfigFragmentModel) obj;
                if (surveyConfigFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(surveyConfigFragmentModel.m25105a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    surveyConfigFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SurveyConfigFragmentParser.m25145a(surveyConfigFragmentModel.w_(), surveyConfigFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(SurveyConfigFragmentModel.class, new Serializer());
            }
        }

        public SurveyConfigFragmentModel() {
            super(9);
        }

        public final boolean m25109j() {
            a(0, 0);
            return this.f17293d;
        }

        @Nullable
        private String m25104q() {
            this.f17295f = super.a(this.f17295f, 2);
            return this.f17295f;
        }

        @Nullable
        public final String m25110k() {
            this.f17296g = super.a(this.f17296g, 3);
            return this.f17296g;
        }

        @Nullable
        public final String m25111l() {
            this.f17297h = super.a(this.f17297h, 4);
            return this.f17297h;
        }

        @Nullable
        public final String m25112m() {
            this.f17298i = super.a(this.f17298i, 5);
            return this.f17298i;
        }

        public final boolean m25113n() {
            a(0, 6);
            return this.f17299j;
        }

        @Nullable
        public final String m25114o() {
            this.f17300k = super.a(this.f17300k, 7);
            return this.f17300k;
        }

        @Nullable
        public final String m25115p() {
            this.f17301l = super.a(this.f17301l, 8);
            return this.f17301l;
        }

        @Nullable
        public final String m25107a() {
            return m25104q();
        }

        public final int jK_() {
            return 548077404;
        }

        public final GraphQLVisitableModel m25106a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m25105a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m25104q());
            int b2 = flatBufferBuilder.b(m25110k());
            int b3 = flatBufferBuilder.b(m25111l());
            int b4 = flatBufferBuilder.b(m25112m());
            int b5 = flatBufferBuilder.b(m25114o());
            int b6 = flatBufferBuilder.b(m25115p());
            flatBufferBuilder.c(9);
            flatBufferBuilder.a(0, this.f17293d);
            flatBufferBuilder.a(1, this.f17294e, 0);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.b(5, b4);
            flatBufferBuilder.a(6, this.f17299j);
            flatBufferBuilder.b(7, b5);
            flatBufferBuilder.b(8, b6);
            i();
            return flatBufferBuilder.d();
        }

        public final void m25108a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f17293d = mutableFlatBuffer.a(i, 0);
            this.f17294e = mutableFlatBuffer.a(i, 1, 0);
            this.f17299j = mutableFlatBuffer.a(i, 6);
        }
    }
}
