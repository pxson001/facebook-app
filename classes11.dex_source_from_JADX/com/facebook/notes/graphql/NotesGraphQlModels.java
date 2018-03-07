package com.facebook.notes.graphql;

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
import com.facebook.graphql.deserializers.GraphQLFeedbackDeserializer;
import com.facebook.graphql.enums.GraphQLDocumentFeedbackOptions;
import com.facebook.graphql.enums.GraphQLDocumentFormatVersion;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.notes.graphql.NotesGraphQlParsers.FBPrivacyScopeParser;
import com.facebook.notes.graphql.NotesGraphQlParsers.NoteEdgeParser;
import com.facebook.notes.graphql.NotesGraphQlParsers.NoteEdgeParser.DocumentAuthorsParser;
import com.facebook.notes.graphql.NotesGraphQlParsers.NoteEdgeParser.DocumentBodyElementsParser;
import com.facebook.notes.graphql.NotesGraphQlParsers.NoteMasterParser;
import com.facebook.notes.graphql.NotesGraphQlParsers.NoteMasterParser.CoverPhotoParser;
import com.facebook.notes.graphql.NotesGraphQlParsers.NoteMasterParser.CoverPhotoParser.FocusParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.FBPage;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.FBPhoto;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentText;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.FBPageModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.FBPhotoModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.FBProfileModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentAuthorEdgeModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentSectionEdgeModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.FBProfileParser;
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

/* compiled from: UNSPECIFIED_PROBABLY_OEM_INSECURE */
public class NotesGraphQlModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1453066845)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: UNSPECIFIED_PROBABLY_OEM_INSECURE */
    public final class FBPrivacyScopeModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f10492d;

        /* compiled from: UNSPECIFIED_PROBABLY_OEM_INSECURE */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBPrivacyScopeModel.class, new Deserializer());
            }

            public Object m10939a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FBPrivacyScopeParser.m11006a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fBPrivacyScopeModel = new FBPrivacyScopeModel();
                ((BaseModel) fBPrivacyScopeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fBPrivacyScopeModel instanceof Postprocessable) {
                    return ((Postprocessable) fBPrivacyScopeModel).a();
                }
                return fBPrivacyScopeModel;
            }
        }

        /* compiled from: UNSPECIFIED_PROBABLY_OEM_INSECURE */
        public class Serializer extends JsonSerializer<FBPrivacyScopeModel> {
            public final void m10940a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FBPrivacyScopeModel fBPrivacyScopeModel = (FBPrivacyScopeModel) obj;
                if (fBPrivacyScopeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBPrivacyScopeModel.m10941a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBPrivacyScopeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FBPrivacyScopeParser.m11007a(fBPrivacyScopeModel.w_(), fBPrivacyScopeModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(FBPrivacyScopeModel.class, new Serializer());
            }
        }

        public FBPrivacyScopeModel() {
            super(1);
        }

        @Nullable
        public final String m10943a() {
            this.f10492d = super.a(this.f10492d, 0);
            return this.f10492d;
        }

        public final int jK_() {
            return -476351540;
        }

        public final GraphQLVisitableModel m10942a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m10941a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m10943a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -292838490)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: UNSPECIFIED_PROBABLY_OEM_INSECURE */
    public final class NoteEdgeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private RichDocumentTextModel f10497d;
        @Nullable
        private RichDocumentTextModel f10498e;
        @Nullable
        private DocumentAuthorsModel f10499f;
        @Nullable
        private DocumentBodyElementsModel f10500g;
        @Nullable
        private RichDocumentTextModel f10501h;
        @Nullable
        private RichDocumentTextModel f10502i;
        @Nullable
        private FBPageModel f10503j;
        @Nullable
        private RichDocumentTextModel f10504k;
        @Nullable
        private RichDocumentTextModel f10505l;
        @Nullable
        private GraphQLFeedback f10506m;
        @Nullable
        private GraphQLDocumentFeedbackOptions f10507n;
        @Nullable
        private GraphQLDocumentFormatVersion f10508o;
        @Nullable
        private String f10509p;
        private long f10510q;
        private long f10511r;

        /* compiled from: UNSPECIFIED_PROBABLY_OEM_INSECURE */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NoteEdgeModel.class, new Deserializer());
            }

            public Object m10944a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(NoteEdgeParser.m11012a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object noteEdgeModel = new NoteEdgeModel();
                ((BaseModel) noteEdgeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (noteEdgeModel instanceof Postprocessable) {
                    return ((Postprocessable) noteEdgeModel).a();
                }
                return noteEdgeModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1286768236)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: UNSPECIFIED_PROBABLY_OEM_INSECURE */
        public final class DocumentAuthorsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<RichDocumentAuthorEdgeModel> f10493d;

            /* compiled from: UNSPECIFIED_PROBABLY_OEM_INSECURE */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(DocumentAuthorsModel.class, new Deserializer());
                }

                public Object m10945a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(DocumentAuthorsParser.m11008a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object documentAuthorsModel = new DocumentAuthorsModel();
                    ((BaseModel) documentAuthorsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (documentAuthorsModel instanceof Postprocessable) {
                        return ((Postprocessable) documentAuthorsModel).a();
                    }
                    return documentAuthorsModel;
                }
            }

            /* compiled from: UNSPECIFIED_PROBABLY_OEM_INSECURE */
            public class Serializer extends JsonSerializer<DocumentAuthorsModel> {
                public final void m10946a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    DocumentAuthorsModel documentAuthorsModel = (DocumentAuthorsModel) obj;
                    if (documentAuthorsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(documentAuthorsModel.m10947a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        documentAuthorsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    DocumentAuthorsParser.m11009a(documentAuthorsModel.w_(), documentAuthorsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(DocumentAuthorsModel.class, new Serializer());
                }
            }

            public DocumentAuthorsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<RichDocumentAuthorEdgeModel> m10949a() {
                this.f10493d = super.a(this.f10493d, 0, RichDocumentAuthorEdgeModel.class);
                return (ImmutableList) this.f10493d;
            }

            public final int jK_() {
                return 567288528;
            }

            public final GraphQLVisitableModel m10948a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10949a() != null) {
                    Builder a = ModelHelper.a(m10949a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (DocumentAuthorsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10493d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10947a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10949a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -355862965)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: UNSPECIFIED_PROBABLY_OEM_INSECURE */
        public final class DocumentBodyElementsModel extends BaseModel implements GraphQLVisitableModel {
            private int f10494d;
            @Nullable
            private List<RichDocumentSectionEdgeModel> f10495e;
            @Nullable
            private DefaultPageInfoFieldsModel f10496f;

            /* compiled from: UNSPECIFIED_PROBABLY_OEM_INSECURE */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(DocumentBodyElementsModel.class, new Deserializer());
                }

                public Object m10950a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(DocumentBodyElementsParser.m11010a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object documentBodyElementsModel = new DocumentBodyElementsModel();
                    ((BaseModel) documentBodyElementsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (documentBodyElementsModel instanceof Postprocessable) {
                        return ((Postprocessable) documentBodyElementsModel).a();
                    }
                    return documentBodyElementsModel;
                }
            }

            /* compiled from: UNSPECIFIED_PROBABLY_OEM_INSECURE */
            public class Serializer extends JsonSerializer<DocumentBodyElementsModel> {
                public final void m10951a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    DocumentBodyElementsModel documentBodyElementsModel = (DocumentBodyElementsModel) obj;
                    if (documentBodyElementsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(documentBodyElementsModel.m10953a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        documentBodyElementsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    DocumentBodyElementsParser.m11011a(documentBodyElementsModel.w_(), documentBodyElementsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(DocumentBodyElementsModel.class, new Serializer());
                }
            }

            public DocumentBodyElementsModel() {
                super(3);
            }

            @Nonnull
            public final ImmutableList<RichDocumentSectionEdgeModel> m10955a() {
                this.f10495e = super.a(this.f10495e, 1, RichDocumentSectionEdgeModel.class);
                return (ImmutableList) this.f10495e;
            }

            @Nullable
            private DefaultPageInfoFieldsModel m10952j() {
                this.f10496f = (DefaultPageInfoFieldsModel) super.a(this.f10496f, 2, DefaultPageInfoFieldsModel.class);
                return this.f10496f;
            }

            public final int jK_() {
                return -1673554030;
            }

            public final GraphQLVisitableModel m10954a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m10955a() != null) {
                    Builder a = ModelHelper.a(m10955a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        DocumentBodyElementsModel documentBodyElementsModel = (DocumentBodyElementsModel) ModelHelper.a(null, this);
                        documentBodyElementsModel.f10495e = a.b();
                        graphQLVisitableModel = documentBodyElementsModel;
                        if (m10952j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m10952j());
                            if (m10952j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (DocumentBodyElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f10496f = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m10952j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m10952j());
                    if (m10952j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (DocumentBodyElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10496f = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m10953a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10955a());
                int a2 = ModelHelper.a(flatBufferBuilder, m10952j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f10494d, 0);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m10956a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10494d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: UNSPECIFIED_PROBABLY_OEM_INSECURE */
        public class Serializer extends JsonSerializer<NoteEdgeModel> {
            public final void m10957a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                NoteEdgeModel noteEdgeModel = (NoteEdgeModel) obj;
                if (noteEdgeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(noteEdgeModel.m10970a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    noteEdgeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                NoteEdgeParser.m11013a(noteEdgeModel.w_(), noteEdgeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(NoteEdgeModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ RichDocumentText m10974b() {
            return m10958m();
        }

        @Nullable
        public final /* synthetic */ RichDocumentText m10975c() {
            return m10959n();
        }

        @Nullable
        public final /* synthetic */ DocumentAuthorsModel m10976d() {
            return m10960o();
        }

        @Nullable
        public final /* synthetic */ RichDocumentText m10977g() {
            return m10963r();
        }

        @Nullable
        public final /* synthetic */ RichDocumentText m10978j() {
            return m10966u();
        }

        @Nullable
        public final /* synthetic */ RichDocumentText ob_() {
            return m10965t();
        }

        @Nullable
        public final /* synthetic */ FBPage oc_() {
            return m10964s();
        }

        @Nullable
        public final /* synthetic */ DocumentBodyElementsModel od_() {
            return m10961p();
        }

        public NoteEdgeModel() {
            super(15);
        }

        @Nullable
        private RichDocumentTextModel m10958m() {
            this.f10497d = (RichDocumentTextModel) super.a(this.f10497d, 0, RichDocumentTextModel.class);
            return this.f10497d;
        }

        @Nullable
        private RichDocumentTextModel m10959n() {
            this.f10498e = (RichDocumentTextModel) super.a(this.f10498e, 1, RichDocumentTextModel.class);
            return this.f10498e;
        }

        @Nullable
        private DocumentAuthorsModel m10960o() {
            this.f10499f = (DocumentAuthorsModel) super.a(this.f10499f, 2, DocumentAuthorsModel.class);
            return this.f10499f;
        }

        @Nullable
        private DocumentBodyElementsModel m10961p() {
            this.f10500g = (DocumentBodyElementsModel) super.a(this.f10500g, 3, DocumentBodyElementsModel.class);
            return this.f10500g;
        }

        @Nullable
        private RichDocumentTextModel m10962q() {
            this.f10501h = (RichDocumentTextModel) super.a(this.f10501h, 4, RichDocumentTextModel.class);
            return this.f10501h;
        }

        @Nullable
        private RichDocumentTextModel m10963r() {
            this.f10502i = (RichDocumentTextModel) super.a(this.f10502i, 5, RichDocumentTextModel.class);
            return this.f10502i;
        }

        @Nullable
        private FBPageModel m10964s() {
            this.f10503j = (FBPageModel) super.a(this.f10503j, 6, FBPageModel.class);
            return this.f10503j;
        }

        @Nullable
        private RichDocumentTextModel m10965t() {
            this.f10504k = (RichDocumentTextModel) super.a(this.f10504k, 7, RichDocumentTextModel.class);
            return this.f10504k;
        }

        @Nullable
        private RichDocumentTextModel m10966u() {
            this.f10505l = (RichDocumentTextModel) super.a(this.f10505l, 8, RichDocumentTextModel.class);
            return this.f10505l;
        }

        @Nullable
        private GraphQLFeedback m10967v() {
            this.f10506m = (GraphQLFeedback) super.a(this.f10506m, 9, GraphQLFeedback.class);
            return this.f10506m;
        }

        @Nullable
        private GraphQLDocumentFeedbackOptions m10968w() {
            this.f10507n = (GraphQLDocumentFeedbackOptions) super.b(this.f10507n, 10, GraphQLDocumentFeedbackOptions.class, GraphQLDocumentFeedbackOptions.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f10507n;
        }

        @Nullable
        private GraphQLDocumentFormatVersion m10969x() {
            this.f10508o = (GraphQLDocumentFormatVersion) super.b(this.f10508o, 11, GraphQLDocumentFormatVersion.class, GraphQLDocumentFormatVersion.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f10508o;
        }

        @Nullable
        public final String m10979k() {
            this.f10509p = super.a(this.f10509p, 12);
            return this.f10509p;
        }

        public final long m10980l() {
            a(1, 6);
            return this.f10511r;
        }

        @Nullable
        public final String m10972a() {
            return m10979k();
        }

        public final int jK_() {
            return 1069615213;
        }

        public final GraphQLVisitableModel m10971a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            RichDocumentTextModel richDocumentTextModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10958m() != null) {
                richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m10958m());
                if (m10958m() != richDocumentTextModel) {
                    graphQLVisitableModel = (NoteEdgeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10497d = richDocumentTextModel;
                }
            }
            if (m10959n() != null) {
                richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m10959n());
                if (m10959n() != richDocumentTextModel) {
                    graphQLVisitableModel = (NoteEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10498e = richDocumentTextModel;
                }
            }
            if (m10960o() != null) {
                DocumentAuthorsModel documentAuthorsModel = (DocumentAuthorsModel) graphQLModelMutatingVisitor.b(m10960o());
                if (m10960o() != documentAuthorsModel) {
                    graphQLVisitableModel = (NoteEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10499f = documentAuthorsModel;
                }
            }
            if (m10961p() != null) {
                DocumentBodyElementsModel documentBodyElementsModel = (DocumentBodyElementsModel) graphQLModelMutatingVisitor.b(m10961p());
                if (m10961p() != documentBodyElementsModel) {
                    graphQLVisitableModel = (NoteEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10500g = documentBodyElementsModel;
                }
            }
            if (m10962q() != null) {
                richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m10962q());
                if (m10962q() != richDocumentTextModel) {
                    graphQLVisitableModel = (NoteEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10501h = richDocumentTextModel;
                }
            }
            if (m10963r() != null) {
                richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m10963r());
                if (m10963r() != richDocumentTextModel) {
                    graphQLVisitableModel = (NoteEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10502i = richDocumentTextModel;
                }
            }
            if (m10964s() != null) {
                FBPageModel fBPageModel = (FBPageModel) graphQLModelMutatingVisitor.b(m10964s());
                if (m10964s() != fBPageModel) {
                    graphQLVisitableModel = (NoteEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10503j = fBPageModel;
                }
            }
            if (m10965t() != null) {
                richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m10965t());
                if (m10965t() != richDocumentTextModel) {
                    graphQLVisitableModel = (NoteEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10504k = richDocumentTextModel;
                }
            }
            if (m10966u() != null) {
                richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m10966u());
                if (m10966u() != richDocumentTextModel) {
                    graphQLVisitableModel = (NoteEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10505l = richDocumentTextModel;
                }
            }
            if (m10967v() != null) {
                GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.b(m10967v());
                if (m10967v() != graphQLFeedback) {
                    graphQLVisitableModel = (NoteEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10506m = graphQLFeedback;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10970a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10958m());
            int a2 = ModelHelper.a(flatBufferBuilder, m10959n());
            int a3 = ModelHelper.a(flatBufferBuilder, m10960o());
            int a4 = ModelHelper.a(flatBufferBuilder, m10961p());
            int a5 = ModelHelper.a(flatBufferBuilder, m10962q());
            int a6 = ModelHelper.a(flatBufferBuilder, m10963r());
            int a7 = ModelHelper.a(flatBufferBuilder, m10964s());
            int a8 = ModelHelper.a(flatBufferBuilder, m10965t());
            int a9 = ModelHelper.a(flatBufferBuilder, m10966u());
            int a10 = ModelHelper.a(flatBufferBuilder, m10967v());
            int a11 = flatBufferBuilder.a(m10968w());
            int a12 = flatBufferBuilder.a(m10969x());
            int b = flatBufferBuilder.b(m10979k());
            flatBufferBuilder.c(15);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, a5);
            flatBufferBuilder.b(5, a6);
            flatBufferBuilder.b(6, a7);
            flatBufferBuilder.b(7, a8);
            flatBufferBuilder.b(8, a9);
            flatBufferBuilder.b(9, a10);
            flatBufferBuilder.b(10, a11);
            flatBufferBuilder.b(11, a12);
            flatBufferBuilder.b(12, b);
            flatBufferBuilder.a(13, this.f10510q, 0);
            flatBufferBuilder.a(14, this.f10511r, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m10973a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f10510q = mutableFlatBuffer.a(i, 13, 0);
            this.f10511r = mutableFlatBuffer.a(i, 14, 0);
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2135763177)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: UNSPECIFIED_PROBABLY_OEM_INSECURE */
    public final class NoteMasterModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private CoverPhotoModel f10516d;
        @Nullable
        private GraphQLFeedback f10517e;
        @Nullable
        private FBProfileModel f10518f;
        @Nullable
        private String f10519g;
        @Nullable
        private FBPrivacyScopeModel f10520h;
        @Nullable
        private NoteEdgeModel f10521i;
        @Nullable
        private String f10522j;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1618112414)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: UNSPECIFIED_PROBABLY_OEM_INSECURE */
        public final class CoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private FocusModel f10514d;
            @Nullable
            private FBPhotoModel f10515e;

            /* compiled from: UNSPECIFIED_PROBABLY_OEM_INSECURE */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CoverPhotoModel.class, new Deserializer());
                }

                public Object m10981a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CoverPhotoParser.m11016a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object coverPhotoModel = new CoverPhotoModel();
                    ((BaseModel) coverPhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (coverPhotoModel instanceof Postprocessable) {
                        return ((Postprocessable) coverPhotoModel).a();
                    }
                    return coverPhotoModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -496435496)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: UNSPECIFIED_PROBABLY_OEM_INSECURE */
            public final class FocusModel extends BaseModel implements GraphQLVisitableModel {
                private double f10512d;
                private double f10513e;

                /* compiled from: UNSPECIFIED_PROBABLY_OEM_INSECURE */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(FocusModel.class, new Deserializer());
                    }

                    public Object m10982a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FocusParser.m11014a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object focusModel = new FocusModel();
                        ((BaseModel) focusModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (focusModel instanceof Postprocessable) {
                            return ((Postprocessable) focusModel).a();
                        }
                        return focusModel;
                    }
                }

                /* compiled from: UNSPECIFIED_PROBABLY_OEM_INSECURE */
                public class Serializer extends JsonSerializer<FocusModel> {
                    public final void m10983a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        FocusModel focusModel = (FocusModel) obj;
                        if (focusModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(focusModel.m10984a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            focusModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FocusParser.m11015a(focusModel.w_(), focusModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(FocusModel.class, new Serializer());
                    }
                }

                public FocusModel() {
                    super(2);
                }

                public final int jK_() {
                    return 82530482;
                }

                public final GraphQLVisitableModel m10985a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m10984a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f10512d, 0.0d);
                    flatBufferBuilder.a(1, this.f10513e, 0.0d);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m10986a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f10512d = mutableFlatBuffer.a(i, 0, 0.0d);
                    this.f10513e = mutableFlatBuffer.a(i, 1, 0.0d);
                }
            }

            /* compiled from: UNSPECIFIED_PROBABLY_OEM_INSECURE */
            public class Serializer extends JsonSerializer<CoverPhotoModel> {
                public final void m10987a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CoverPhotoModel coverPhotoModel = (CoverPhotoModel) obj;
                    if (coverPhotoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(coverPhotoModel.m10990a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        coverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CoverPhotoParser.m11017a(coverPhotoModel.w_(), coverPhotoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CoverPhotoModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ FBPhoto m10992a() {
                return m10989k();
            }

            public CoverPhotoModel() {
                super(2);
            }

            @Nullable
            private FocusModel m10988j() {
                this.f10514d = (FocusModel) super.a(this.f10514d, 0, FocusModel.class);
                return this.f10514d;
            }

            @Nullable
            private FBPhotoModel m10989k() {
                this.f10515e = (FBPhotoModel) super.a(this.f10515e, 1, FBPhotoModel.class);
                return this.f10515e;
            }

            public final int jK_() {
                return 497264923;
            }

            public final GraphQLVisitableModel m10991a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10988j() != null) {
                    FocusModel focusModel = (FocusModel) graphQLModelMutatingVisitor.b(m10988j());
                    if (m10988j() != focusModel) {
                        graphQLVisitableModel = (CoverPhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10514d = focusModel;
                    }
                }
                if (m10989k() != null) {
                    FBPhotoModel fBPhotoModel = (FBPhotoModel) graphQLModelMutatingVisitor.b(m10989k());
                    if (m10989k() != fBPhotoModel) {
                        graphQLVisitableModel = (CoverPhotoModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10515e = fBPhotoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10990a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10988j());
                int a2 = ModelHelper.a(flatBufferBuilder, m10989k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: UNSPECIFIED_PROBABLY_OEM_INSECURE */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NoteMasterModel.class, new Deserializer());
            }

            public Object m10993a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = NoteMasterParser.m11018a(jsonParser);
                Object noteMasterModel = new NoteMasterModel();
                ((BaseModel) noteMasterModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (noteMasterModel instanceof Postprocessable) {
                    return ((Postprocessable) noteMasterModel).a();
                }
                return noteMasterModel;
            }
        }

        /* compiled from: UNSPECIFIED_PROBABLY_OEM_INSECURE */
        public class Serializer extends JsonSerializer<NoteMasterModel> {
            public final void m10994a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                NoteMasterModel noteMasterModel = (NoteMasterModel) obj;
                if (noteMasterModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(noteMasterModel.m10998a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    noteMasterModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = noteMasterModel.w_();
                int u_ = noteMasterModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("cover_photo");
                    CoverPhotoParser.m11017a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    GraphQLFeedbackDeserializer.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("from");
                    FBProfileParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("privacy_scope");
                    FBPrivacyScopeParser.m11007a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("published_document");
                    NoteEdgeParser.m11013a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 6) != 0) {
                    jsonGenerator.a("url");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 6));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(NoteMasterModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ CoverPhotoModel m11001b() {
            return m10995k();
        }

        @Nullable
        public final /* synthetic */ FBProfileModel m11003d() {
            return m10996l();
        }

        @Nullable
        public final /* synthetic */ FBPrivacyScopeModel m11004g() {
            return m10997m();
        }

        @Nullable
        public final /* synthetic */ NoteEdgeModel og_() {
            return m11005j();
        }

        public NoteMasterModel() {
            super(7);
        }

        @Nullable
        private CoverPhotoModel m10995k() {
            this.f10516d = (CoverPhotoModel) super.a(this.f10516d, 0, CoverPhotoModel.class);
            return this.f10516d;
        }

        @Nullable
        public final GraphQLFeedback m11002c() {
            this.f10517e = (GraphQLFeedback) super.a(this.f10517e, 1, GraphQLFeedback.class);
            return this.f10517e;
        }

        @Nullable
        private FBProfileModel m10996l() {
            this.f10518f = (FBProfileModel) super.a(this.f10518f, 2, FBProfileModel.class);
            return this.f10518f;
        }

        @Nullable
        public final String oe_() {
            this.f10519g = super.a(this.f10519g, 3);
            return this.f10519g;
        }

        @Nullable
        private FBPrivacyScopeModel m10997m() {
            this.f10520h = (FBPrivacyScopeModel) super.a(this.f10520h, 4, FBPrivacyScopeModel.class);
            return this.f10520h;
        }

        @Nullable
        public final NoteEdgeModel m11005j() {
            this.f10521i = (NoteEdgeModel) super.a(this.f10521i, 5, NoteEdgeModel.class);
            return this.f10521i;
        }

        @Nullable
        public final String of_() {
            this.f10522j = super.a(this.f10522j, 6);
            return this.f10522j;
        }

        @Nullable
        public final String m11000a() {
            return oe_();
        }

        public final int jK_() {
            return 2434066;
        }

        public final GraphQLVisitableModel m10999a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10995k() != null) {
                CoverPhotoModel coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(m10995k());
                if (m10995k() != coverPhotoModel) {
                    graphQLVisitableModel = (NoteMasterModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10516d = coverPhotoModel;
                }
            }
            if (m11002c() != null) {
                GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.b(m11002c());
                if (m11002c() != graphQLFeedback) {
                    graphQLVisitableModel = (NoteMasterModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10517e = graphQLFeedback;
                }
            }
            if (m10996l() != null) {
                FBProfileModel fBProfileModel = (FBProfileModel) graphQLModelMutatingVisitor.b(m10996l());
                if (m10996l() != fBProfileModel) {
                    graphQLVisitableModel = (NoteMasterModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10518f = fBProfileModel;
                }
            }
            if (m10997m() != null) {
                FBPrivacyScopeModel fBPrivacyScopeModel = (FBPrivacyScopeModel) graphQLModelMutatingVisitor.b(m10997m());
                if (m10997m() != fBPrivacyScopeModel) {
                    graphQLVisitableModel = (NoteMasterModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10520h = fBPrivacyScopeModel;
                }
            }
            if (m11005j() != null) {
                NoteEdgeModel noteEdgeModel = (NoteEdgeModel) graphQLModelMutatingVisitor.b(m11005j());
                if (m11005j() != noteEdgeModel) {
                    graphQLVisitableModel = (NoteMasterModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10521i = noteEdgeModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10998a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10995k());
            int a2 = ModelHelper.a(flatBufferBuilder, m11002c());
            int a3 = ModelHelper.a(flatBufferBuilder, m10996l());
            int b = flatBufferBuilder.b(oe_());
            int a4 = ModelHelper.a(flatBufferBuilder, m10997m());
            int a5 = ModelHelper.a(flatBufferBuilder, m11005j());
            int b2 = flatBufferBuilder.b(of_());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, b2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
