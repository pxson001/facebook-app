package com.facebook.ui.edithistory.protocol;

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
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels.LinkableUtilApplyActorsLinksGraphQLModel;
import com.facebook.ui.edithistory.protocol.FetchEditHistoryGraphQLParsers.EditActionFragmentParser;
import com.facebook.ui.edithistory.protocol.FetchEditHistoryGraphQLParsers.FetchEditHistoryQueryParser;
import com.facebook.ui.edithistory.protocol.FetchEditHistoryGraphQLParsers.FetchEditHistoryQueryParser.EditHistoryParser;
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

/* compiled from: encoding */
public class FetchEditHistoryGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 716108252)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: encoding */
    public final class EditActionFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f15301d;
        @Nullable
        private LinkableUtilApplyActorsLinksGraphQLModel f15302e;
        private long f15303f;
        @Nullable
        private String f15304g;

        /* compiled from: encoding */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EditActionFragmentModel.class, new Deserializer());
            }

            public Object m19287a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(EditActionFragmentParser.m19311b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object editActionFragmentModel = new EditActionFragmentModel();
                ((BaseModel) editActionFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (editActionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) editActionFragmentModel).a();
                }
                return editActionFragmentModel;
            }
        }

        /* compiled from: encoding */
        public class Serializer extends JsonSerializer<EditActionFragmentModel> {
            public final void m19288a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                EditActionFragmentModel editActionFragmentModel = (EditActionFragmentModel) obj;
                if (editActionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(editActionFragmentModel.m19291a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    editActionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                EditActionFragmentParser.m19312b(editActionFragmentModel.w_(), editActionFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(EditActionFragmentModel.class, new Serializer());
            }
        }

        public EditActionFragmentModel() {
            super(4);
        }

        @Nullable
        private String m19289l() {
            this.f15301d = super.a(this.f15301d, 0);
            return this.f15301d;
        }

        @Nullable
        public final LinkableUtilApplyActorsLinksGraphQLModel m19295j() {
            this.f15302e = (LinkableUtilApplyActorsLinksGraphQLModel) super.a(this.f15302e, 1, LinkableUtilApplyActorsLinksGraphQLModel.class);
            return this.f15302e;
        }

        public final long m19296k() {
            a(0, 2);
            return this.f15303f;
        }

        @Nullable
        private String m19290m() {
            this.f15304g = super.a(this.f15304g, 3);
            return this.f15304g;
        }

        @Nullable
        public final String m19293a() {
            return m19289l();
        }

        public final int jK_() {
            return -892762880;
        }

        public final GraphQLVisitableModel m19292a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19295j() != null) {
                LinkableUtilApplyActorsLinksGraphQLModel linkableUtilApplyActorsLinksGraphQLModel = (LinkableUtilApplyActorsLinksGraphQLModel) graphQLModelMutatingVisitor.b(m19295j());
                if (m19295j() != linkableUtilApplyActorsLinksGraphQLModel) {
                    graphQLVisitableModel = (EditActionFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15302e = linkableUtilApplyActorsLinksGraphQLModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19291a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m19289l());
            int a = ModelHelper.a(flatBufferBuilder, m19295j());
            int b2 = flatBufferBuilder.b(m19290m());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.a(2, this.f15303f, 0);
            flatBufferBuilder.b(3, b2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m19294a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f15303f = mutableFlatBuffer.a(i, 2, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1842057582)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: encoding */
    public final class FetchEditHistoryQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f15307d;
        @Nullable
        private EditHistoryModel f15308e;

        /* compiled from: encoding */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchEditHistoryQueryModel.class, new Deserializer());
            }

            public Object m19297a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchEditHistoryQueryParser.m19315a(jsonParser);
                Object fetchEditHistoryQueryModel = new FetchEditHistoryQueryModel();
                ((BaseModel) fetchEditHistoryQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchEditHistoryQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchEditHistoryQueryModel).a();
                }
                return fetchEditHistoryQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -5642457)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: encoding */
        public final class EditHistoryModel extends BaseModel implements GraphQLVisitableModel {
            private int f15305d;
            @Nullable
            private List<EditActionFragmentModel> f15306e;

            /* compiled from: encoding */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EditHistoryModel.class, new Deserializer());
                }

                public Object m19298a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EditHistoryParser.m19313a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object editHistoryModel = new EditHistoryModel();
                    ((BaseModel) editHistoryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (editHistoryModel instanceof Postprocessable) {
                        return ((Postprocessable) editHistoryModel).a();
                    }
                    return editHistoryModel;
                }
            }

            /* compiled from: encoding */
            public class Serializer extends JsonSerializer<EditHistoryModel> {
                public final void m19299a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EditHistoryModel editHistoryModel = (EditHistoryModel) obj;
                    if (editHistoryModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(editHistoryModel.m19300a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        editHistoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EditHistoryParser.m19314a(editHistoryModel.w_(), editHistoryModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EditHistoryModel.class, new Serializer());
                }
            }

            public EditHistoryModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<EditActionFragmentModel> m19302a() {
                this.f15306e = super.a(this.f15306e, 1, EditActionFragmentModel.class);
                return (ImmutableList) this.f15306e;
            }

            public final int jK_() {
                return -1196208760;
            }

            public final GraphQLVisitableModel m19301a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m19302a() != null) {
                    Builder a = ModelHelper.a(m19302a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (EditHistoryModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f15306e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m19300a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m19302a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f15305d, 0);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m19303a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f15305d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: encoding */
        public class Serializer extends JsonSerializer<FetchEditHistoryQueryModel> {
            public final void m19304a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchEditHistoryQueryModel fetchEditHistoryQueryModel = (FetchEditHistoryQueryModel) obj;
                if (fetchEditHistoryQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchEditHistoryQueryModel.m19306a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchEditHistoryQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchEditHistoryQueryModel.w_();
                int u_ = fetchEditHistoryQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("edit_history");
                    EditHistoryParser.m19314a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchEditHistoryQueryModel.class, new Serializer());
            }
        }

        public FetchEditHistoryQueryModel() {
            super(2);
        }

        public final void m19309a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m19310a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m19305j() {
            if (this.b != null && this.f15307d == null) {
                this.f15307d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f15307d;
        }

        @Nullable
        public final EditHistoryModel m19308a() {
            this.f15308e = (EditHistoryModel) super.a(this.f15308e, 1, EditHistoryModel.class);
            return this.f15308e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m19307a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19308a() != null) {
                EditHistoryModel editHistoryModel = (EditHistoryModel) graphQLModelMutatingVisitor.b(m19308a());
                if (m19308a() != editHistoryModel) {
                    graphQLVisitableModel = (FetchEditHistoryQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15308e = editHistoryModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19306a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19305j());
            int a2 = ModelHelper.a(flatBufferBuilder, m19308a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
