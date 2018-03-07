package com.facebook.search.protocol;

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
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoTailFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraMediaModel;
import com.facebook.search.protocol.Fb4aGraphSearchPhotoQueryParsers.Fb4aGraphSearchPhotoQueryParser;
import com.facebook.search.protocol.Fb4aGraphSearchPhotoQueryParsers.Fb4aGraphSearchPhotoQueryParser.FilteredQueryParser;
import com.facebook.search.protocol.Fb4aGraphSearchPhotoQueryParsers.Fb4aGraphSearchPhotoResultsConnectionFragmentParser;
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

/* compiled from: niem_network_settings_click */
public class Fb4aGraphSearchPhotoQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2056340148)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: niem_network_settings_click */
    public final class Fb4aGraphSearchPhotoQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FilteredQueryModel f7929d;

        /* compiled from: niem_network_settings_click */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(Fb4aGraphSearchPhotoQueryModel.class, new Deserializer());
            }

            public Object m8477a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = Fb4aGraphSearchPhotoQueryParser.m8499a(jsonParser);
                Object fb4aGraphSearchPhotoQueryModel = new Fb4aGraphSearchPhotoQueryModel();
                ((BaseModel) fb4aGraphSearchPhotoQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fb4aGraphSearchPhotoQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fb4aGraphSearchPhotoQueryModel).a();
                }
                return fb4aGraphSearchPhotoQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -803446726)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: niem_network_settings_click */
        public final class FilteredQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f7925d;
            @Nullable
            private String f7926e;
            @Nullable
            private Fb4aGraphSearchPhotoResultsConnectionFragmentModel f7927f;
            @Nullable
            private String f7928g;

            /* compiled from: niem_network_settings_click */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FilteredQueryModel.class, new Deserializer());
                }

                public Object m8478a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FilteredQueryParser.m8497a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object filteredQueryModel = new FilteredQueryModel();
                    ((BaseModel) filteredQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (filteredQueryModel instanceof Postprocessable) {
                        return ((Postprocessable) filteredQueryModel).a();
                    }
                    return filteredQueryModel;
                }
            }

            /* compiled from: niem_network_settings_click */
            public class Serializer extends JsonSerializer<FilteredQueryModel> {
                public final void m8479a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FilteredQueryModel filteredQueryModel = (FilteredQueryModel) obj;
                    if (filteredQueryModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(filteredQueryModel.m8481a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        filteredQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FilteredQueryParser.m8498a(filteredQueryModel.w_(), filteredQueryModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FilteredQueryModel.class, new Serializer());
                }
            }

            public FilteredQueryModel() {
                super(4);
            }

            @Nullable
            private String m8480m() {
                this.f7925d = super.a(this.f7925d, 0);
                return this.f7925d;
            }

            @Nullable
            public final String m8484j() {
                this.f7926e = super.a(this.f7926e, 1);
                return this.f7926e;
            }

            @Nullable
            public final Fb4aGraphSearchPhotoResultsConnectionFragmentModel m8485k() {
                this.f7927f = (Fb4aGraphSearchPhotoResultsConnectionFragmentModel) super.a(this.f7927f, 2, Fb4aGraphSearchPhotoResultsConnectionFragmentModel.class);
                return this.f7927f;
            }

            @Nullable
            public final String m8486l() {
                this.f7928g = super.a(this.f7928g, 3);
                return this.f7928g;
            }

            @Nullable
            public final String m8483a() {
                return m8480m();
            }

            public final int jK_() {
                return -466486798;
            }

            public final GraphQLVisitableModel m8482a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m8485k() != null) {
                    Fb4aGraphSearchPhotoResultsConnectionFragmentModel fb4aGraphSearchPhotoResultsConnectionFragmentModel = (Fb4aGraphSearchPhotoResultsConnectionFragmentModel) graphQLModelMutatingVisitor.b(m8485k());
                    if (m8485k() != fb4aGraphSearchPhotoResultsConnectionFragmentModel) {
                        graphQLVisitableModel = (FilteredQueryModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f7927f = fb4aGraphSearchPhotoResultsConnectionFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m8481a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m8480m());
                int b2 = flatBufferBuilder.b(m8484j());
                int a = ModelHelper.a(flatBufferBuilder, m8485k());
                int b3 = flatBufferBuilder.b(m8486l());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.b(3, b3);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: niem_network_settings_click */
        public class Serializer extends JsonSerializer<Fb4aGraphSearchPhotoQueryModel> {
            public final void m8487a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                Fb4aGraphSearchPhotoQueryModel fb4aGraphSearchPhotoQueryModel = (Fb4aGraphSearchPhotoQueryModel) obj;
                if (fb4aGraphSearchPhotoQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fb4aGraphSearchPhotoQueryModel.m8488a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fb4aGraphSearchPhotoQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fb4aGraphSearchPhotoQueryModel.w_();
                int u_ = fb4aGraphSearchPhotoQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("filtered_query");
                    FilteredQueryParser.m8498a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(Fb4aGraphSearchPhotoQueryModel.class, new Serializer());
            }
        }

        public Fb4aGraphSearchPhotoQueryModel() {
            super(1);
        }

        @Nullable
        public final FilteredQueryModel m8490a() {
            this.f7929d = (FilteredQueryModel) super.a(this.f7929d, 0, FilteredQueryModel.class);
            return this.f7929d;
        }

        public final int jK_() {
            return -466486798;
        }

        public final GraphQLVisitableModel m8489a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m8490a() != null) {
                FilteredQueryModel filteredQueryModel = (FilteredQueryModel) graphQLModelMutatingVisitor.b(m8490a());
                if (m8490a() != filteredQueryModel) {
                    graphQLVisitableModel = (Fb4aGraphSearchPhotoQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7929d = filteredQueryModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m8488a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m8490a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1809968480)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: niem_network_settings_click */
    public final class Fb4aGraphSearchPhotoResultsConnectionFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<PandoraMediaModel> f7930d;
        @Nullable
        private DefaultPageInfoTailFieldsModel f7931e;

        /* compiled from: niem_network_settings_click */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(Fb4aGraphSearchPhotoResultsConnectionFragmentModel.class, new Deserializer());
            }

            public Object m8491a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(Fb4aGraphSearchPhotoResultsConnectionFragmentParser.m8500a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fb4aGraphSearchPhotoResultsConnectionFragmentModel = new Fb4aGraphSearchPhotoResultsConnectionFragmentModel();
                ((BaseModel) fb4aGraphSearchPhotoResultsConnectionFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fb4aGraphSearchPhotoResultsConnectionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fb4aGraphSearchPhotoResultsConnectionFragmentModel).a();
                }
                return fb4aGraphSearchPhotoResultsConnectionFragmentModel;
            }
        }

        /* compiled from: niem_network_settings_click */
        public class Serializer extends JsonSerializer<Fb4aGraphSearchPhotoResultsConnectionFragmentModel> {
            public final void m8492a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                Fb4aGraphSearchPhotoResultsConnectionFragmentModel fb4aGraphSearchPhotoResultsConnectionFragmentModel = (Fb4aGraphSearchPhotoResultsConnectionFragmentModel) obj;
                if (fb4aGraphSearchPhotoResultsConnectionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fb4aGraphSearchPhotoResultsConnectionFragmentModel.m8493a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fb4aGraphSearchPhotoResultsConnectionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                Fb4aGraphSearchPhotoResultsConnectionFragmentParser.m8501a(fb4aGraphSearchPhotoResultsConnectionFragmentModel.w_(), fb4aGraphSearchPhotoResultsConnectionFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(Fb4aGraphSearchPhotoResultsConnectionFragmentModel.class, new Serializer());
            }
        }

        public Fb4aGraphSearchPhotoResultsConnectionFragmentModel() {
            super(2);
        }

        @Nonnull
        public final ImmutableList<PandoraMediaModel> m8495a() {
            this.f7930d = super.a(this.f7930d, 0, PandoraMediaModel.class);
            return (ImmutableList) this.f7930d;
        }

        @Nullable
        public final DefaultPageInfoTailFieldsModel m8496j() {
            this.f7931e = (DefaultPageInfoTailFieldsModel) super.a(this.f7931e, 1, DefaultPageInfoTailFieldsModel.class);
            return this.f7931e;
        }

        public final int jK_() {
            return 1580207518;
        }

        public final GraphQLVisitableModel m8494a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            DefaultPageInfoTailFieldsModel defaultPageInfoTailFieldsModel;
            h();
            if (m8495a() != null) {
                Builder a = ModelHelper.a(m8495a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    Fb4aGraphSearchPhotoResultsConnectionFragmentModel fb4aGraphSearchPhotoResultsConnectionFragmentModel = (Fb4aGraphSearchPhotoResultsConnectionFragmentModel) ModelHelper.a(null, this);
                    fb4aGraphSearchPhotoResultsConnectionFragmentModel.f7930d = a.b();
                    graphQLVisitableModel = fb4aGraphSearchPhotoResultsConnectionFragmentModel;
                    if (m8496j() != null) {
                        defaultPageInfoTailFieldsModel = (DefaultPageInfoTailFieldsModel) graphQLModelMutatingVisitor.b(m8496j());
                        if (m8496j() != defaultPageInfoTailFieldsModel) {
                            graphQLVisitableModel = (Fb4aGraphSearchPhotoResultsConnectionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f7931e = defaultPageInfoTailFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m8496j() != null) {
                defaultPageInfoTailFieldsModel = (DefaultPageInfoTailFieldsModel) graphQLModelMutatingVisitor.b(m8496j());
                if (m8496j() != defaultPageInfoTailFieldsModel) {
                    graphQLVisitableModel = (Fb4aGraphSearchPhotoResultsConnectionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f7931e = defaultPageInfoTailFieldsModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m8493a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m8495a());
            int a2 = ModelHelper.a(flatBufferBuilder, m8496j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
