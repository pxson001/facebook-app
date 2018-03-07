package com.facebook.search.bootstrap.common.protocol;

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
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapEntitiesGraphQLInterfaces.AddEntityFragment;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapEntitiesGraphQLParsers.AddEntityFragmentParser;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapEntitiesGraphQLParsers.AddEntityFragmentParser.SearchableParser;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapEntitiesGraphQLParsers.AddEntityFragmentParser.SearchableParser.ContactParser;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapEntitiesGraphQLParsers.BootstrapEntitiesDeltaEdgeFragmentParser;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapEntitiesGraphQLParsers.BootstrapEntitiesDeltaEdgeFragmentParser.EdgesParser;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapEntitiesGraphQLParsers.BootstrapEntitiesDeltaEdgeFragmentParser.EdgesParser.NodeParser;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapEntitiesGraphQLParsers.BootstrapEntitiesEdgeFragmentParser;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapEntitiesGraphQLParsers.BootstrapEntitiesSnippetFragmentParser;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapEntitiesGraphQLParsers.FetchBootstrapEntitiesParser;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapEntitiesGraphQLParsers.FetchBootstrapSnippetsParser;
import com.facebook.search.graphql.SearchEntityInterfaces.SearchEntityFragment;
import com.facebook.search.graphql.SearchEntityModels.PhoneticNameModel;
import com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel;
import com.facebook.search.graphql.SearchEntityModels.StructuredGrammarCostModel;
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

/* compiled from: extra_edit_gallery_launch_settings */
public class FetchBootstrapEntitiesGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 796145266)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_edit_gallery_launch_settings */
    public final class AddEntityFragmentModel extends BaseModel implements GraphQLVisitableModel, AddEntityFragment {
        @Nullable
        private String f15596d;
        @Nullable
        private SearchableModel f15597e;
        @Nullable
        private List<StructuredGrammarCostModel> f15598f;
        @Nullable
        private String f15599g;

        /* compiled from: extra_edit_gallery_launch_settings */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AddEntityFragmentModel.class, new Deserializer());
            }

            public Object m23197a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AddEntityFragmentParser.m23288a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object addEntityFragmentModel = new AddEntityFragmentModel();
                ((BaseModel) addEntityFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (addEntityFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) addEntityFragmentModel).a();
                }
                return addEntityFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1539793112)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: extra_edit_gallery_launch_settings */
        public final class SearchableModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, SearchEntityFragment {
            @Nullable
            private GraphQLObjectType f15585d;
            @Nullable
            private ContactModel f15586e;
            private boolean f15587f;
            @Nullable
            private GroupIconModel f15588g;
            @Nullable
            private String f15589h;
            private boolean f15590i;
            private boolean f15591j;
            @Nullable
            private String f15592k;
            @Nullable
            private List<String> f15593l;
            @Nullable
            private DefaultImageFieldsModel f15594m;
            @Nullable
            private GraphQLSavedState f15595n;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 506609914)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: extra_edit_gallery_launch_settings */
            public final class ContactModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private PhoneticNameModel f15584d;

                /* compiled from: extra_edit_gallery_launch_settings */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ContactModel.class, new Deserializer());
                    }

                    public Object m23198a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ContactParser.m23284a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object contactModel = new ContactModel();
                        ((BaseModel) contactModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (contactModel instanceof Postprocessable) {
                            return ((Postprocessable) contactModel).a();
                        }
                        return contactModel;
                    }
                }

                /* compiled from: extra_edit_gallery_launch_settings */
                public class Serializer extends JsonSerializer<ContactModel> {
                    public final void m23199a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ContactModel contactModel = (ContactModel) obj;
                        if (contactModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(contactModel.m23201a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            contactModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ContactParser.m23285a(contactModel.w_(), contactModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(ContactModel.class, new Serializer());
                    }
                }

                public ContactModel() {
                    super(1);
                }

                @Nullable
                private PhoneticNameModel m23200a() {
                    this.f15584d = (PhoneticNameModel) super.a(this.f15584d, 0, PhoneticNameModel.class);
                    return this.f15584d;
                }

                public final int jK_() {
                    return -1678787584;
                }

                public final GraphQLVisitableModel m23202a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m23200a() != null) {
                        PhoneticNameModel phoneticNameModel = (PhoneticNameModel) graphQLModelMutatingVisitor.b(m23200a());
                        if (m23200a() != phoneticNameModel) {
                            graphQLVisitableModel = (ContactModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f15584d = phoneticNameModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m23201a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m23200a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: extra_edit_gallery_launch_settings */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SearchableModel.class, new Deserializer());
                }

                public Object m23203a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SearchableParser.m23286a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object searchableModel = new SearchableModel();
                    ((BaseModel) searchableModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (searchableModel instanceof Postprocessable) {
                        return ((Postprocessable) searchableModel).a();
                    }
                    return searchableModel;
                }
            }

            /* compiled from: extra_edit_gallery_launch_settings */
            public class Serializer extends JsonSerializer<SearchableModel> {
                public final void m23204a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SearchableModel searchableModel = (SearchableModel) obj;
                    if (searchableModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(searchableModel.m23209a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        searchableModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SearchableParser.m23287a(searchableModel.w_(), searchableModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SearchableModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ GroupIconModel m23215d() {
                return m23206m();
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields m23218k() {
                return m23207n();
            }

            public SearchableModel() {
                super(11);
            }

            @Nullable
            public final GraphQLObjectType m23213b() {
                if (this.b != null && this.f15585d == null) {
                    this.f15585d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f15585d;
            }

            @Nullable
            private ContactModel m23205l() {
                this.f15586e = (ContactModel) super.a(this.f15586e, 1, ContactModel.class);
                return this.f15586e;
            }

            public final boolean m23214c() {
                a(0, 2);
                return this.f15587f;
            }

            @Nullable
            private GroupIconModel m23206m() {
                this.f15588g = (GroupIconModel) super.a(this.f15588g, 3, GroupIconModel.class);
                return this.f15588g;
            }

            @Nullable
            public final String cD_() {
                this.f15589h = super.a(this.f15589h, 4);
                return this.f15589h;
            }

            public final boolean m23216g() {
                a(0, 5);
                return this.f15590i;
            }

            public final boolean cE_() {
                a(0, 6);
                return this.f15591j;
            }

            @Nullable
            public final String cF_() {
                this.f15592k = super.a(this.f15592k, 7);
                return this.f15592k;
            }

            @Nonnull
            public final ImmutableList<String> m23217j() {
                this.f15593l = super.a(this.f15593l, 8);
                return (ImmutableList) this.f15593l;
            }

            @Nullable
            private DefaultImageFieldsModel m23207n() {
                this.f15594m = (DefaultImageFieldsModel) super.a(this.f15594m, 9, DefaultImageFieldsModel.class);
                return this.f15594m;
            }

            @Nullable
            private GraphQLSavedState m23208o() {
                this.f15595n = (GraphQLSavedState) super.b(this.f15595n, 10, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f15595n;
            }

            @Nullable
            public final String m23211a() {
                return cD_();
            }

            public final int jK_() {
                return 1283375906;
            }

            public final GraphQLVisitableModel m23210a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m23205l() != null) {
                    ContactModel contactModel = (ContactModel) graphQLModelMutatingVisitor.b(m23205l());
                    if (m23205l() != contactModel) {
                        graphQLVisitableModel = (SearchableModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f15586e = contactModel;
                    }
                }
                if (m23206m() != null) {
                    GroupIconModel groupIconModel = (GroupIconModel) graphQLModelMutatingVisitor.b(m23206m());
                    if (m23206m() != groupIconModel) {
                        graphQLVisitableModel = (SearchableModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f15588g = groupIconModel;
                    }
                }
                if (m23207n() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m23207n());
                    if (m23207n() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (SearchableModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f15594m = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m23209a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m23213b());
                int a2 = ModelHelper.a(flatBufferBuilder, m23205l());
                int a3 = ModelHelper.a(flatBufferBuilder, m23206m());
                int b = flatBufferBuilder.b(cD_());
                int b2 = flatBufferBuilder.b(cF_());
                int c = flatBufferBuilder.c(m23217j());
                int a4 = ModelHelper.a(flatBufferBuilder, m23207n());
                int a5 = flatBufferBuilder.a(m23208o());
                flatBufferBuilder.c(11);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.a(2, this.f15587f);
                flatBufferBuilder.b(3, a3);
                flatBufferBuilder.b(4, b);
                flatBufferBuilder.a(5, this.f15590i);
                flatBufferBuilder.a(6, this.f15591j);
                flatBufferBuilder.b(7, b2);
                flatBufferBuilder.b(8, c);
                flatBufferBuilder.b(9, a4);
                flatBufferBuilder.b(10, a5);
                i();
                return flatBufferBuilder.d();
            }

            public final void m23212a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f15587f = mutableFlatBuffer.a(i, 2);
                this.f15590i = mutableFlatBuffer.a(i, 5);
                this.f15591j = mutableFlatBuffer.a(i, 6);
            }
        }

        /* compiled from: extra_edit_gallery_launch_settings */
        public class Serializer extends JsonSerializer<AddEntityFragmentModel> {
            public final void m23219a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AddEntityFragmentModel addEntityFragmentModel = (AddEntityFragmentModel) obj;
                if (addEntityFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(addEntityFragmentModel.m23221a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    addEntityFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AddEntityFragmentParser.m23289a(addEntityFragmentModel.w_(), addEntityFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(AddEntityFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ SearchableModel mo1230b() {
            return m23220j();
        }

        public AddEntityFragmentModel() {
            super(4);
        }

        @Nullable
        public final String mo1229a() {
            this.f15596d = super.a(this.f15596d, 0);
            return this.f15596d;
        }

        @Nullable
        private SearchableModel m23220j() {
            this.f15597e = (SearchableModel) super.a(this.f15597e, 1, SearchableModel.class);
            return this.f15597e;
        }

        @Nonnull
        public final ImmutableList<StructuredGrammarCostModel> mo1231c() {
            this.f15598f = super.a(this.f15598f, 2, StructuredGrammarCostModel.class);
            return (ImmutableList) this.f15598f;
        }

        @Nullable
        public final String mo1232d() {
            this.f15599g = super.a(this.f15599g, 3);
            return this.f15599g;
        }

        public final int jK_() {
            return -1371131893;
        }

        public final GraphQLVisitableModel m23222a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23220j() != null) {
                SearchableModel searchableModel = (SearchableModel) graphQLModelMutatingVisitor.b(m23220j());
                if (m23220j() != searchableModel) {
                    graphQLVisitableModel = (AddEntityFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15597e = searchableModel;
                }
            }
            if (mo1231c() != null) {
                Builder a = ModelHelper.a(mo1231c(), graphQLModelMutatingVisitor);
                if (a != null) {
                    AddEntityFragmentModel addEntityFragmentModel = (AddEntityFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    addEntityFragmentModel.f15598f = a.b();
                    graphQLVisitableModel = addEntityFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23221a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(mo1229a());
            int a = ModelHelper.a(flatBufferBuilder, m23220j());
            int a2 = ModelHelper.a(flatBufferBuilder, mo1231c());
            int b2 = flatBufferBuilder.b(mo1232d());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -388417898)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_edit_gallery_launch_settings */
    public final class BootstrapEntitiesDeltaEdgeFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<EdgesModel> f15607d;
        private boolean f15608e;
        private int f15609f;

        /* compiled from: extra_edit_gallery_launch_settings */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BootstrapEntitiesDeltaEdgeFragmentModel.class, new Deserializer());
            }

            public Object m23227a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(BootstrapEntitiesDeltaEdgeFragmentParser.m23295a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object bootstrapEntitiesDeltaEdgeFragmentModel = new BootstrapEntitiesDeltaEdgeFragmentModel();
                ((BaseModel) bootstrapEntitiesDeltaEdgeFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (bootstrapEntitiesDeltaEdgeFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) bootstrapEntitiesDeltaEdgeFragmentModel).a();
                }
                return bootstrapEntitiesDeltaEdgeFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 100757060)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: extra_edit_gallery_launch_settings */
        public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private NodeModel f15606d;

            /* compiled from: extra_edit_gallery_launch_settings */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                }

                public Object m23228a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EdgesParser.m23293b(jsonParser, flatBufferBuilder));
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

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -130252860)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: extra_edit_gallery_launch_settings */
            public final class NodeModel extends BaseModel implements GraphQLVisitableModel, AddEntityFragment {
                @Nullable
                private GraphQLObjectType f15600d;
                @Nullable
                private String f15601e;
                @Nullable
                private SearchableModel f15602f;
                @Nullable
                private List<StructuredGrammarCostModel> f15603g;
                @Nullable
                private String f15604h;
                @Nullable
                private String f15605i;

                /* compiled from: extra_edit_gallery_launch_settings */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                    }

                    public Object m23229a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodeParser.m23290a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodeModel = new NodeModel();
                        ((BaseModel) nodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodeModel instanceof Postprocessable) {
                            return ((Postprocessable) nodeModel).a();
                        }
                        return nodeModel;
                    }
                }

                /* compiled from: extra_edit_gallery_launch_settings */
                public class Serializer extends JsonSerializer<NodeModel> {
                    public final void m23230a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodeModel nodeModel = (NodeModel) obj;
                        if (nodeModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodeModel.m23232a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodeParser.m23291a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodeModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ SearchableModel mo1230b() {
                    return m23238j();
                }

                public NodeModel() {
                    super(6);
                }

                @Nullable
                private GraphQLObjectType m23231l() {
                    if (this.b != null && this.f15600d == null) {
                        this.f15600d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f15600d;
                }

                @Nullable
                public final String mo1229a() {
                    this.f15601e = super.a(this.f15601e, 1);
                    return this.f15601e;
                }

                @Nullable
                public final SearchableModel m23238j() {
                    this.f15602f = (SearchableModel) super.a(this.f15602f, 2, SearchableModel.class);
                    return this.f15602f;
                }

                @Nonnull
                public final ImmutableList<StructuredGrammarCostModel> mo1231c() {
                    this.f15603g = super.a(this.f15603g, 3, StructuredGrammarCostModel.class);
                    return (ImmutableList) this.f15603g;
                }

                @Nullable
                public final String mo1232d() {
                    this.f15604h = super.a(this.f15604h, 4);
                    return this.f15604h;
                }

                @Nullable
                public final String m23239k() {
                    this.f15605i = super.a(this.f15605i, 5);
                    return this.f15605i;
                }

                public final int jK_() {
                    return 1288366701;
                }

                public final GraphQLVisitableModel m23233a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m23238j() != null) {
                        SearchableModel searchableModel = (SearchableModel) graphQLModelMutatingVisitor.b(m23238j());
                        if (m23238j() != searchableModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f15602f = searchableModel;
                        }
                    }
                    if (mo1231c() != null) {
                        Builder a = ModelHelper.a(mo1231c(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            NodeModel nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            nodeModel.f15603g = a.b();
                            graphQLVisitableModel = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m23232a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m23231l());
                    int b = flatBufferBuilder.b(mo1229a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m23238j());
                    int a3 = ModelHelper.a(flatBufferBuilder, mo1231c());
                    int b2 = flatBufferBuilder.b(mo1232d());
                    int b3 = flatBufferBuilder.b(m23239k());
                    flatBufferBuilder.c(6);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, a2);
                    flatBufferBuilder.b(3, a3);
                    flatBufferBuilder.b(4, b2);
                    flatBufferBuilder.b(5, b3);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: extra_edit_gallery_launch_settings */
            public class Serializer extends JsonSerializer<EdgesModel> {
                public final void m23240a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EdgesModel edgesModel = (EdgesModel) obj;
                    if (edgesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(edgesModel.m23241a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EdgesParser.m23294b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EdgesModel.class, new Serializer());
                }
            }

            public EdgesModel() {
                super(1);
            }

            @Nullable
            public final NodeModel m23243a() {
                this.f15606d = (NodeModel) super.a(this.f15606d, 0, NodeModel.class);
                return this.f15606d;
            }

            public final int jK_() {
                return -1918185299;
            }

            public final GraphQLVisitableModel m23242a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m23243a() != null) {
                    NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m23243a());
                    if (m23243a() != nodeModel) {
                        graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f15606d = nodeModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m23241a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m23243a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: extra_edit_gallery_launch_settings */
        public class Serializer extends JsonSerializer<BootstrapEntitiesDeltaEdgeFragmentModel> {
            public final void m23244a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                BootstrapEntitiesDeltaEdgeFragmentModel bootstrapEntitiesDeltaEdgeFragmentModel = (BootstrapEntitiesDeltaEdgeFragmentModel) obj;
                if (bootstrapEntitiesDeltaEdgeFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(bootstrapEntitiesDeltaEdgeFragmentModel.m23245a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    bootstrapEntitiesDeltaEdgeFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                BootstrapEntitiesDeltaEdgeFragmentParser.m23296a(bootstrapEntitiesDeltaEdgeFragmentModel.w_(), bootstrapEntitiesDeltaEdgeFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(BootstrapEntitiesDeltaEdgeFragmentModel.class, new Serializer());
            }
        }

        public BootstrapEntitiesDeltaEdgeFragmentModel() {
            super(3);
        }

        @Nonnull
        public final ImmutableList<EdgesModel> m23247a() {
            this.f15607d = super.a(this.f15607d, 0, EdgesModel.class);
            return (ImmutableList) this.f15607d;
        }

        public final boolean m23249j() {
            a(0, 1);
            return this.f15608e;
        }

        public final int m23250k() {
            a(0, 2);
            return this.f15609f;
        }

        public final int jK_() {
            return -779751986;
        }

        public final GraphQLVisitableModel m23246a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23247a() != null) {
                Builder a = ModelHelper.a(m23247a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (BootstrapEntitiesDeltaEdgeFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15607d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23245a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23247a());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f15608e);
            flatBufferBuilder.a(2, this.f15609f, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m23248a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f15608e = mutableFlatBuffer.a(i, 1);
            this.f15609f = mutableFlatBuffer.a(i, 2, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1610478126)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_edit_gallery_launch_settings */
    public final class BootstrapEntitiesEdgeFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<EdgesModel> f15611d;
        private boolean f15612e;
        private int f15613f;

        /* compiled from: extra_edit_gallery_launch_settings */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BootstrapEntitiesEdgeFragmentModel.class, new Deserializer());
            }

            public Object m23251a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(BootstrapEntitiesEdgeFragmentParser.m23300a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object bootstrapEntitiesEdgeFragmentModel = new BootstrapEntitiesEdgeFragmentModel();
                ((BaseModel) bootstrapEntitiesEdgeFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (bootstrapEntitiesEdgeFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) bootstrapEntitiesEdgeFragmentModel).a();
                }
                return bootstrapEntitiesEdgeFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 924267413)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: extra_edit_gallery_launch_settings */
        public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private AddEntityFragmentModel f15610d;

            /* compiled from: extra_edit_gallery_launch_settings */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                }

                public Object m23252a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BootstrapEntitiesEdgeFragmentParser.EdgesParser.m23298b(jsonParser, flatBufferBuilder));
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

            /* compiled from: extra_edit_gallery_launch_settings */
            public class Serializer extends JsonSerializer<EdgesModel> {
                public final void m23253a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EdgesModel edgesModel = (EdgesModel) obj;
                    if (edgesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(edgesModel.m23254a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BootstrapEntitiesEdgeFragmentParser.EdgesParser.m23299b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EdgesModel.class, new Serializer());
                }
            }

            public EdgesModel() {
                super(1);
            }

            @Nullable
            public final AddEntityFragmentModel m23256a() {
                this.f15610d = (AddEntityFragmentModel) super.a(this.f15610d, 0, AddEntityFragmentModel.class);
                return this.f15610d;
            }

            public final int jK_() {
                return 1330810789;
            }

            public final GraphQLVisitableModel m23255a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m23256a() != null) {
                    AddEntityFragmentModel addEntityFragmentModel = (AddEntityFragmentModel) graphQLModelMutatingVisitor.b(m23256a());
                    if (m23256a() != addEntityFragmentModel) {
                        graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f15610d = addEntityFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m23254a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m23256a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: extra_edit_gallery_launch_settings */
        public class Serializer extends JsonSerializer<BootstrapEntitiesEdgeFragmentModel> {
            public final void m23257a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                BootstrapEntitiesEdgeFragmentModel bootstrapEntitiesEdgeFragmentModel = (BootstrapEntitiesEdgeFragmentModel) obj;
                if (bootstrapEntitiesEdgeFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(bootstrapEntitiesEdgeFragmentModel.m23258a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    bootstrapEntitiesEdgeFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                BootstrapEntitiesEdgeFragmentParser.m23301a(bootstrapEntitiesEdgeFragmentModel.w_(), bootstrapEntitiesEdgeFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(BootstrapEntitiesEdgeFragmentModel.class, new Serializer());
            }
        }

        public BootstrapEntitiesEdgeFragmentModel() {
            super(3);
        }

        @Nonnull
        public final ImmutableList<EdgesModel> m23260a() {
            this.f15611d = super.a(this.f15611d, 0, EdgesModel.class);
            return (ImmutableList) this.f15611d;
        }

        public final int m23262j() {
            a(0, 2);
            return this.f15613f;
        }

        public final int jK_() {
            return -1729064250;
        }

        public final GraphQLVisitableModel m23259a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23260a() != null) {
                Builder a = ModelHelper.a(m23260a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (BootstrapEntitiesEdgeFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15611d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23258a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23260a());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f15612e);
            flatBufferBuilder.a(2, this.f15613f, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m23261a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f15612e = mutableFlatBuffer.a(i, 1);
            this.f15613f = mutableFlatBuffer.a(i, 2, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 877423075)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_edit_gallery_launch_settings */
    public final class BootstrapEntitiesSnippetFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<EdgesModel> f15615d;

        /* compiled from: extra_edit_gallery_launch_settings */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BootstrapEntitiesSnippetFragmentModel.class, new Deserializer());
            }

            public Object m23263a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(BootstrapEntitiesSnippetFragmentParser.m23304a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object bootstrapEntitiesSnippetFragmentModel = new BootstrapEntitiesSnippetFragmentModel();
                ((BaseModel) bootstrapEntitiesSnippetFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (bootstrapEntitiesSnippetFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) bootstrapEntitiesSnippetFragmentModel).a();
                }
                return bootstrapEntitiesSnippetFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 924267413)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: extra_edit_gallery_launch_settings */
        public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private AddEntityFragmentModel f15614d;

            /* compiled from: extra_edit_gallery_launch_settings */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                }

                public Object m23264a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BootstrapEntitiesSnippetFragmentParser.EdgesParser.m23302b(jsonParser, flatBufferBuilder));
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

            /* compiled from: extra_edit_gallery_launch_settings */
            public class Serializer extends JsonSerializer<EdgesModel> {
                public final void m23265a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EdgesModel edgesModel = (EdgesModel) obj;
                    if (edgesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(edgesModel.m23266a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BootstrapEntitiesSnippetFragmentParser.EdgesParser.m23303b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EdgesModel.class, new Serializer());
                }
            }

            public EdgesModel() {
                super(1);
            }

            @Nullable
            public final AddEntityFragmentModel m23268a() {
                this.f15614d = (AddEntityFragmentModel) super.a(this.f15614d, 0, AddEntityFragmentModel.class);
                return this.f15614d;
            }

            public final int jK_() {
                return -121837759;
            }

            public final GraphQLVisitableModel m23267a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m23268a() != null) {
                    AddEntityFragmentModel addEntityFragmentModel = (AddEntityFragmentModel) graphQLModelMutatingVisitor.b(m23268a());
                    if (m23268a() != addEntityFragmentModel) {
                        graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f15614d = addEntityFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m23266a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m23268a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: extra_edit_gallery_launch_settings */
        public class Serializer extends JsonSerializer<BootstrapEntitiesSnippetFragmentModel> {
            public final void m23269a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                BootstrapEntitiesSnippetFragmentModel bootstrapEntitiesSnippetFragmentModel = (BootstrapEntitiesSnippetFragmentModel) obj;
                if (bootstrapEntitiesSnippetFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(bootstrapEntitiesSnippetFragmentModel.m23270a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    bootstrapEntitiesSnippetFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                BootstrapEntitiesSnippetFragmentParser.m23305a(bootstrapEntitiesSnippetFragmentModel.w_(), bootstrapEntitiesSnippetFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(BootstrapEntitiesSnippetFragmentModel.class, new Serializer());
            }
        }

        public BootstrapEntitiesSnippetFragmentModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<EdgesModel> m23272a() {
            this.f15615d = super.a(this.f15615d, 0, EdgesModel.class);
            return (ImmutableList) this.f15615d;
        }

        public final int jK_() {
            return -2058762910;
        }

        public final GraphQLVisitableModel m23271a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23272a() != null) {
                Builder a = ModelHelper.a(m23272a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (BootstrapEntitiesSnippetFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15615d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23270a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23272a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1054804250)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_edit_gallery_launch_settings */
    public final class FetchBootstrapEntitiesModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private BootstrapEntitiesEdgeFragmentModel f15616d;
        @Nullable
        private BootstrapEntitiesDeltaEdgeFragmentModel f15617e;

        /* compiled from: extra_edit_gallery_launch_settings */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchBootstrapEntitiesModel.class, new Deserializer());
            }

            public Object m23273a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchBootstrapEntitiesParser.m23306a(jsonParser);
                Object fetchBootstrapEntitiesModel = new FetchBootstrapEntitiesModel();
                ((BaseModel) fetchBootstrapEntitiesModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchBootstrapEntitiesModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchBootstrapEntitiesModel).a();
                }
                return fetchBootstrapEntitiesModel;
            }
        }

        /* compiled from: extra_edit_gallery_launch_settings */
        public class Serializer extends JsonSerializer<FetchBootstrapEntitiesModel> {
            public final void m23274a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchBootstrapEntitiesModel fetchBootstrapEntitiesModel = (FetchBootstrapEntitiesModel) obj;
                if (fetchBootstrapEntitiesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchBootstrapEntitiesModel.m23275a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchBootstrapEntitiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchBootstrapEntitiesModel.w_();
                int u_ = fetchBootstrapEntitiesModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("bootstrap_entities");
                    BootstrapEntitiesEdgeFragmentParser.m23301a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("bootstrap_entities_delta");
                    BootstrapEntitiesDeltaEdgeFragmentParser.m23296a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchBootstrapEntitiesModel.class, new Serializer());
            }
        }

        public FetchBootstrapEntitiesModel() {
            super(2);
        }

        @Nullable
        public final BootstrapEntitiesEdgeFragmentModel m23277a() {
            this.f15616d = (BootstrapEntitiesEdgeFragmentModel) super.a(this.f15616d, 0, BootstrapEntitiesEdgeFragmentModel.class);
            return this.f15616d;
        }

        @Nullable
        public final BootstrapEntitiesDeltaEdgeFragmentModel m23278j() {
            this.f15617e = (BootstrapEntitiesDeltaEdgeFragmentModel) super.a(this.f15617e, 1, BootstrapEntitiesDeltaEdgeFragmentModel.class);
            return this.f15617e;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m23276a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23277a() != null) {
                BootstrapEntitiesEdgeFragmentModel bootstrapEntitiesEdgeFragmentModel = (BootstrapEntitiesEdgeFragmentModel) graphQLModelMutatingVisitor.b(m23277a());
                if (m23277a() != bootstrapEntitiesEdgeFragmentModel) {
                    graphQLVisitableModel = (FetchBootstrapEntitiesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15616d = bootstrapEntitiesEdgeFragmentModel;
                }
            }
            if (m23278j() != null) {
                BootstrapEntitiesDeltaEdgeFragmentModel bootstrapEntitiesDeltaEdgeFragmentModel = (BootstrapEntitiesDeltaEdgeFragmentModel) graphQLModelMutatingVisitor.b(m23278j());
                if (m23278j() != bootstrapEntitiesDeltaEdgeFragmentModel) {
                    graphQLVisitableModel = (FetchBootstrapEntitiesModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15617e = bootstrapEntitiesDeltaEdgeFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23275a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23277a());
            int a2 = ModelHelper.a(flatBufferBuilder, m23278j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1540462952)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_edit_gallery_launch_settings */
    public final class FetchBootstrapSnippetsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private BootstrapEntitiesSnippetFragmentModel f15618d;

        /* compiled from: extra_edit_gallery_launch_settings */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchBootstrapSnippetsModel.class, new Deserializer());
            }

            public Object m23279a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchBootstrapSnippetsParser.m23307a(jsonParser);
                Object fetchBootstrapSnippetsModel = new FetchBootstrapSnippetsModel();
                ((BaseModel) fetchBootstrapSnippetsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchBootstrapSnippetsModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchBootstrapSnippetsModel).a();
                }
                return fetchBootstrapSnippetsModel;
            }
        }

        /* compiled from: extra_edit_gallery_launch_settings */
        public class Serializer extends JsonSerializer<FetchBootstrapSnippetsModel> {
            public final void m23280a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchBootstrapSnippetsModel fetchBootstrapSnippetsModel = (FetchBootstrapSnippetsModel) obj;
                if (fetchBootstrapSnippetsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchBootstrapSnippetsModel.m23281a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchBootstrapSnippetsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchBootstrapSnippetsModel.w_();
                int u_ = fetchBootstrapSnippetsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("bootstrap_snippets");
                    BootstrapEntitiesSnippetFragmentParser.m23305a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchBootstrapSnippetsModel.class, new Serializer());
            }
        }

        public FetchBootstrapSnippetsModel() {
            super(1);
        }

        @Nullable
        public final BootstrapEntitiesSnippetFragmentModel m23283a() {
            this.f15618d = (BootstrapEntitiesSnippetFragmentModel) super.a(this.f15618d, 0, BootstrapEntitiesSnippetFragmentModel.class);
            return this.f15618d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m23282a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23283a() != null) {
                BootstrapEntitiesSnippetFragmentModel bootstrapEntitiesSnippetFragmentModel = (BootstrapEntitiesSnippetFragmentModel) graphQLModelMutatingVisitor.b(m23283a());
                if (m23283a() != bootstrapEntitiesSnippetFragmentModel) {
                    graphQLVisitableModel = (FetchBootstrapSnippetsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15618d = bootstrapEntitiesSnippetFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23281a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23283a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
