package com.facebook.search.protocol.nullstate;

import com.facebook.common.json.FbJsonDeserializer;
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
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: friendable_contacts_count */
public class FetchNullStateModulesGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 512095967)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: friendable_contacts_count */
    public final class NullStateModuleQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ProviderModel f11406d;

        /* compiled from: friendable_contacts_count */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NullStateModuleQueryModel.class, new Deserializer());
            }

            public Object m12137a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchNullStateModulesGraphQLParsers$NullStateModuleQueryParser.m12142a(jsonParser);
                Object nullStateModuleQueryModel = new NullStateModuleQueryModel();
                ((BaseModel) nullStateModuleQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (nullStateModuleQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) nullStateModuleQueryModel).a();
                }
                return nullStateModuleQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -364429316)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: friendable_contacts_count */
        public final class ProviderModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ModulesModel> f11770d;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 2129350421)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: friendable_contacts_count */
            public final class ModulesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f11771d;
                private int f11772e;
                private int f11773f;
                @Nullable
                private String f11774g;
                @Nullable
                private String f11775h;
                @Nullable
                private List<SuggestionsModel> f11776i;
                @Nullable
                private String f11777j;
                private boolean f11778k;

                public ModulesModel() {
                    super(8);
                }

                @Nullable
                public final String m12352a() {
                    this.f11771d = super.a(this.f11771d, 0);
                    return this.f11771d;
                }

                public final int m12354j() {
                    a(0, 2);
                    return this.f11773f;
                }

                @Nullable
                public final String m12355k() {
                    this.f11774g = super.a(this.f11774g, 3);
                    return this.f11774g;
                }

                @Nullable
                public final String m12356l() {
                    this.f11775h = super.a(this.f11775h, 4);
                    return this.f11775h;
                }

                @Nonnull
                public final ImmutableList<SuggestionsModel> m12357m() {
                    this.f11776i = super.a(this.f11776i, 5, SuggestionsModel.class);
                    return (ImmutableList) this.f11776i;
                }

                @Nullable
                public final String m12358n() {
                    this.f11777j = super.a(this.f11777j, 6);
                    return this.f11777j;
                }

                public final boolean m12359o() {
                    a(0, 7);
                    return this.f11778k;
                }

                public final int jK_() {
                    return -693513472;
                }

                public final GraphQLVisitableModel m12351a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m12357m() != null) {
                        Builder a = ModelHelper.a(m12357m(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (ModulesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f11776i = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m12350a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m12352a());
                    int b2 = flatBufferBuilder.b(m12355k());
                    int b3 = flatBufferBuilder.b(m12356l());
                    int a = ModelHelper.a(flatBufferBuilder, m12357m());
                    int b4 = flatBufferBuilder.b(m12358n());
                    flatBufferBuilder.c(8);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.a(1, this.f11772e, 0);
                    flatBufferBuilder.a(2, this.f11773f, 0);
                    flatBufferBuilder.b(3, b2);
                    flatBufferBuilder.b(4, b3);
                    flatBufferBuilder.b(5, a);
                    flatBufferBuilder.b(6, b4);
                    flatBufferBuilder.a(7, this.f11778k);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m12353a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f11772e = mutableFlatBuffer.a(i, 1, 0);
                    this.f11773f = mutableFlatBuffer.a(i, 2, 0);
                    this.f11778k = mutableFlatBuffer.a(i, 7);
                }
            }

            public ProviderModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<ModulesModel> m12349a() {
                this.f11770d = super.a(this.f11770d, 0, ModulesModel.class);
                return (ImmutableList) this.f11770d;
            }

            public final int jK_() {
                return -1129751163;
            }

            public final GraphQLVisitableModel m12348a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m12349a() != null) {
                    Builder a = ModelHelper.a(m12349a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ProviderModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11770d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m12347a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m12349a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public NullStateModuleQueryModel() {
            super(1);
        }

        @Nullable
        public final ProviderModel m11808a() {
            this.f11406d = (ProviderModel) super.a(this.f11406d, 0, ProviderModel.class);
            return this.f11406d;
        }

        public final int jK_() {
            return -817911948;
        }

        public final GraphQLVisitableModel m11807a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11808a() != null) {
                ProviderModel providerModel = (ProviderModel) graphQLModelMutatingVisitor.b(m11808a());
                if (m11808a() != providerModel) {
                    graphQLVisitableModel = (NullStateModuleQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11406d = providerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11806a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11808a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
