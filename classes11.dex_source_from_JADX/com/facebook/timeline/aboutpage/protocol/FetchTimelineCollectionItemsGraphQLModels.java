package com.facebook.timeline.aboutpage.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLTimelineAppCollectionStyle;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.CollectionItemConnectionWithFieldsModel;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.CollectionsEligibleSuggestionsFieldsModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLInterfaces.CollectionWithItemsAndSuggestions;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLParsers.CollectionWithItemsAndSuggestionsParser;
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

/* compiled from: MUSICIAN */
public class FetchTimelineCollectionItemsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1572361726)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MUSICIAN */
    public final class CollectionWithItemsAndSuggestionsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, CollectionWithItemsAndSuggestions {
        @Nullable
        private String f13454d;
        @Nullable
        private CollectionsEligibleSuggestionsFieldsModel f13455e;
        @Nullable
        private String f13456f;
        @Nullable
        private CollectionItemConnectionWithFieldsModel f13457g;
        @Nullable
        private String f13458h;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f13459i;
        @Nullable
        private List<GraphQLTimelineAppCollectionStyle> f13460j;
        private boolean f13461k;
        @Nullable
        private String f13462l;
        @Nullable
        private String f13463m;

        /* compiled from: MUSICIAN */
        public final class Builder {
            @Nullable
            public String f13444a;
            @Nullable
            public CollectionsEligibleSuggestionsFieldsModel f13445b;
            @Nullable
            public String f13446c;
            @Nullable
            public CollectionItemConnectionWithFieldsModel f13447d;
            @Nullable
            public String f13448e;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f13449f;
            @Nullable
            public ImmutableList<GraphQLTimelineAppCollectionStyle> f13450g;
            public boolean f13451h;
            @Nullable
            public String f13452i;
            @Nullable
            public String f13453j;

            public final CollectionWithItemsAndSuggestionsModel m14670a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f13444a);
                int a = ModelHelper.a(flatBufferBuilder, this.f13445b);
                int b2 = flatBufferBuilder.b(this.f13446c);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f13447d);
                int b3 = flatBufferBuilder.b(this.f13448e);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f13449f);
                int d = flatBufferBuilder.d(this.f13450g);
                int b4 = flatBufferBuilder.b(this.f13452i);
                int b5 = flatBufferBuilder.b(this.f13453j);
                flatBufferBuilder.c(10);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, b3);
                flatBufferBuilder.b(5, a3);
                flatBufferBuilder.b(6, d);
                flatBufferBuilder.a(7, this.f13451h);
                flatBufferBuilder.b(8, b4);
                flatBufferBuilder.b(9, b5);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new CollectionWithItemsAndSuggestionsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: MUSICIAN */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CollectionWithItemsAndSuggestionsModel.class, new Deserializer());
            }

            public Object m14671a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CollectionWithItemsAndSuggestionsParser.m14691b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object collectionWithItemsAndSuggestionsModel = new CollectionWithItemsAndSuggestionsModel();
                ((BaseModel) collectionWithItemsAndSuggestionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (collectionWithItemsAndSuggestionsModel instanceof Postprocessable) {
                    return ((Postprocessable) collectionWithItemsAndSuggestionsModel).a();
                }
                return collectionWithItemsAndSuggestionsModel;
            }
        }

        /* compiled from: MUSICIAN */
        public class Serializer extends JsonSerializer<CollectionWithItemsAndSuggestionsModel> {
            public final void m14672a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CollectionWithItemsAndSuggestionsModel collectionWithItemsAndSuggestionsModel = (CollectionWithItemsAndSuggestionsModel) obj;
                if (collectionWithItemsAndSuggestionsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(collectionWithItemsAndSuggestionsModel.m14676a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    collectionWithItemsAndSuggestionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CollectionWithItemsAndSuggestionsParser.m14692b(collectionWithItemsAndSuggestionsModel.w_(), collectionWithItemsAndSuggestionsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CollectionWithItemsAndSuggestionsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ CollectionItemConnectionWithFieldsModel nU_() {
            return m14684k();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields mo403p() {
            return m14675m();
        }

        @Nullable
        public final /* synthetic */ CollectionsEligibleSuggestionsFieldsModel mo404q() {
            return m14674l();
        }

        public CollectionWithItemsAndSuggestionsModel() {
            super(10);
        }

        public CollectionWithItemsAndSuggestionsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(10);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String mo397b() {
            this.f13454d = super.a(this.f13454d, 0);
            return this.f13454d;
        }

        @Nullable
        private CollectionsEligibleSuggestionsFieldsModel m14674l() {
            this.f13455e = (CollectionsEligibleSuggestionsFieldsModel) super.a(this.f13455e, 1, CollectionsEligibleSuggestionsFieldsModel.class);
            return this.f13455e;
        }

        @Nullable
        public final String mo395c() {
            this.f13456f = super.a(this.f13456f, 2);
            return this.f13456f;
        }

        @Nullable
        public final CollectionItemConnectionWithFieldsModel m14684k() {
            this.f13457g = (CollectionItemConnectionWithFieldsModel) super.a(this.f13457g, 3, CollectionItemConnectionWithFieldsModel.class);
            return this.f13457g;
        }

        @Nullable
        public final String nS_() {
            this.f13458h = super.a(this.f13458h, 4);
            return this.f13458h;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m14675m() {
            this.f13459i = (DefaultTextWithEntitiesFieldsModel) super.a(this.f13459i, 5, DefaultTextWithEntitiesFieldsModel.class);
            return this.f13459i;
        }

        @Nonnull
        public final ImmutableList<GraphQLTimelineAppCollectionStyle> mo396d() {
            this.f13460j = super.c(this.f13460j, 6, GraphQLTimelineAppCollectionStyle.class);
            return (ImmutableList) this.f13460j;
        }

        public final boolean mo399n() {
            a(0, 7);
            return this.f13461k;
        }

        @Nullable
        public final String mo398j() {
            this.f13462l = super.a(this.f13462l, 8);
            return this.f13462l;
        }

        @Nullable
        public final String mo402o() {
            this.f13463m = super.a(this.f13463m, 9);
            return this.f13463m;
        }

        public static CollectionWithItemsAndSuggestionsModel m14673a(CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions) {
            if (collectionWithItemsAndSuggestions == null) {
                return null;
            }
            if (collectionWithItemsAndSuggestions instanceof CollectionWithItemsAndSuggestionsModel) {
                return (CollectionWithItemsAndSuggestionsModel) collectionWithItemsAndSuggestions;
            }
            Builder builder = new Builder();
            builder.f13444a = collectionWithItemsAndSuggestions.mo397b();
            builder.f13445b = CollectionsEligibleSuggestionsFieldsModel.m14405a(collectionWithItemsAndSuggestions.mo404q());
            builder.f13446c = collectionWithItemsAndSuggestions.mo395c();
            builder.f13447d = CollectionItemConnectionWithFieldsModel.m14341a(collectionWithItemsAndSuggestions.nU_());
            builder.f13448e = collectionWithItemsAndSuggestions.nS_();
            builder.f13449f = DefaultTextWithEntitiesFieldsModel.a(collectionWithItemsAndSuggestions.mo403p());
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < collectionWithItemsAndSuggestions.mo396d().size(); i++) {
                builder2.c(collectionWithItemsAndSuggestions.mo396d().get(i));
            }
            builder.f13450g = builder2.b();
            builder.f13451h = collectionWithItemsAndSuggestions.mo399n();
            builder.f13452i = collectionWithItemsAndSuggestions.mo398j();
            builder.f13453j = collectionWithItemsAndSuggestions.mo402o();
            return builder.m14670a();
        }

        @Nullable
        public final String m14678a() {
            return mo395c();
        }

        public final int jK_() {
            return -1476137794;
        }

        public final GraphQLVisitableModel m14677a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14674l() != null) {
                CollectionsEligibleSuggestionsFieldsModel collectionsEligibleSuggestionsFieldsModel = (CollectionsEligibleSuggestionsFieldsModel) graphQLModelMutatingVisitor.b(m14674l());
                if (m14674l() != collectionsEligibleSuggestionsFieldsModel) {
                    graphQLVisitableModel = (CollectionWithItemsAndSuggestionsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13455e = collectionsEligibleSuggestionsFieldsModel;
                }
            }
            if (m14684k() != null) {
                CollectionItemConnectionWithFieldsModel collectionItemConnectionWithFieldsModel = (CollectionItemConnectionWithFieldsModel) graphQLModelMutatingVisitor.b(m14684k());
                if (m14684k() != collectionItemConnectionWithFieldsModel) {
                    graphQLVisitableModel = (CollectionWithItemsAndSuggestionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13457g = collectionItemConnectionWithFieldsModel;
                }
            }
            if (m14675m() != null) {
                DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m14675m());
                if (m14675m() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (CollectionWithItemsAndSuggestionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13459i = defaultTextWithEntitiesFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14676a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(mo397b());
            int a = ModelHelper.a(flatBufferBuilder, m14674l());
            int b2 = flatBufferBuilder.b(mo395c());
            int a2 = ModelHelper.a(flatBufferBuilder, m14684k());
            int b3 = flatBufferBuilder.b(nS_());
            int a3 = ModelHelper.a(flatBufferBuilder, m14675m());
            int d = flatBufferBuilder.d(mo396d());
            int b4 = flatBufferBuilder.b(mo398j());
            int b5 = flatBufferBuilder.b(mo402o());
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.b(5, a3);
            flatBufferBuilder.b(6, d);
            flatBufferBuilder.a(7, this.f13461k);
            flatBufferBuilder.b(8, b4);
            flatBufferBuilder.b(9, b5);
            i();
            return flatBufferBuilder.d();
        }

        public final void m14679a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f13461k = mutableFlatBuffer.a(i, 7);
        }
    }
}
