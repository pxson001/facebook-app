package com.facebook.search.protocol.feedstory;

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
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.protocol.feedstory.FetchGraphSearchQueryFiltersGraphQLParsers.GraphSearchFilterValueFragmentParser;
import com.facebook.search.protocol.feedstory.FetchGraphSearchQueryFiltersGraphQLParsers.GraphSearchFilterValueFragmentParser.ValueObjectParser;
import com.facebook.search.protocol.feedstory.FetchGraphSearchQueryFiltersGraphQLParsers.GraphSearchFilterValueFragmentParser.ValueObjectParser.ProfilePictureParser;
import com.facebook.search.protocol.feedstory.FetchGraphSearchQueryFiltersGraphQLParsers.GraphSearchQueryFilterFieldsParser;
import com.facebook.search.protocol.feedstory.FetchGraphSearchQueryFiltersGraphQLParsers.GraphSearchQueryFilterFieldsParser.CustomValueParser;
import com.facebook.search.protocol.feedstory.FetchGraphSearchQueryFiltersGraphQLParsers.GraphSearchQueryFilterFieldsParser.FilterValuesParser;
import com.facebook.search.protocol.feedstory.FetchGraphSearchQueryFiltersGraphQLParsers.GraphSearchQueryMainFilterFragmentParser;
import com.facebook.search.protocol.feedstory.FetchGraphSearchQueryFiltersGraphQLParsers.GraphSearchQueryNeedleFiltersParser;
import com.facebook.search.protocol.feedstory.FetchGraphSearchQueryFiltersGraphQLParsers.GraphSearchQueryTopFiltersParser;
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

/* compiled from: nearby_places_entry */
public class FetchGraphSearchQueryFiltersGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2121604261)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: nearby_places_entry */
    public final class GraphSearchFilterValueFragmentModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f8210d;
        @Nullable
        private String f8211e;
        @Nullable
        private String f8212f;
        @Nullable
        private ValueObjectModel f8213g;

        /* compiled from: nearby_places_entry */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GraphSearchFilterValueFragmentModel.class, new Deserializer());
            }

            public Object m9183a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GraphSearchFilterValueFragmentParser.m9246a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object graphSearchFilterValueFragmentModel = new GraphSearchFilterValueFragmentModel();
                ((BaseModel) graphSearchFilterValueFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (graphSearchFilterValueFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) graphSearchFilterValueFragmentModel).a();
                }
                return graphSearchFilterValueFragmentModel;
            }
        }

        /* compiled from: nearby_places_entry */
        public class Serializer extends JsonSerializer<GraphSearchFilterValueFragmentModel> {
            public final void m9184a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GraphSearchFilterValueFragmentModel graphSearchFilterValueFragmentModel = (GraphSearchFilterValueFragmentModel) obj;
                if (graphSearchFilterValueFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(graphSearchFilterValueFragmentModel.m9201a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    graphSearchFilterValueFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GraphSearchFilterValueFragmentParser.m9247b(graphSearchFilterValueFragmentModel.w_(), graphSearchFilterValueFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(GraphSearchFilterValueFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 950949368)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: nearby_places_entry */
        public final class ValueObjectModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f8208d;
            @Nullable
            private ProfilePictureModel f8209e;

            /* compiled from: nearby_places_entry */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ValueObjectModel.class, new Deserializer());
                }

                public Object m9185a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ValueObjectParser.m9244a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object valueObjectModel = new ValueObjectModel();
                    ((BaseModel) valueObjectModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (valueObjectModel instanceof Postprocessable) {
                        return ((Postprocessable) valueObjectModel).a();
                    }
                    return valueObjectModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: nearby_places_entry */
            public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f8207d;

                /* compiled from: nearby_places_entry */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                    }

                    public Object m9186a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ProfilePictureParser.m9242a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object profilePictureModel = new ProfilePictureModel();
                        ((BaseModel) profilePictureModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (profilePictureModel instanceof Postprocessable) {
                            return ((Postprocessable) profilePictureModel).a();
                        }
                        return profilePictureModel;
                    }
                }

                /* compiled from: nearby_places_entry */
                public class Serializer extends JsonSerializer<ProfilePictureModel> {
                    public final void m9187a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                        if (profilePictureModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(profilePictureModel.m9189a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ProfilePictureParser.m9243a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                    }
                }

                public ProfilePictureModel() {
                    super(1);
                }

                @Nullable
                private String m9188a() {
                    this.f8207d = super.a(this.f8207d, 0);
                    return this.f8207d;
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m9190a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m9189a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m9188a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: nearby_places_entry */
            public class Serializer extends JsonSerializer<ValueObjectModel> {
                public final void m9191a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ValueObjectModel valueObjectModel = (ValueObjectModel) obj;
                    if (valueObjectModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(valueObjectModel.m9194a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        valueObjectModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ValueObjectParser.m9245a(valueObjectModel.w_(), valueObjectModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ValueObjectModel.class, new Serializer());
                }
            }

            public ValueObjectModel() {
                super(2);
            }

            public final void m9196a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m9197a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m9192a() {
                if (this.b != null && this.f8208d == null) {
                    this.f8208d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f8208d;
            }

            @Nullable
            private ProfilePictureModel m9193j() {
                this.f8209e = (ProfilePictureModel) super.a(this.f8209e, 1, ProfilePictureModel.class);
                return this.f8209e;
            }

            public final int jK_() {
                return 2433570;
            }

            public final GraphQLVisitableModel m9195a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m9193j() != null) {
                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m9193j());
                    if (m9193j() != profilePictureModel) {
                        graphQLVisitableModel = (ValueObjectModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8209e = profilePictureModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m9194a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m9192a());
                int a2 = ModelHelper.a(flatBufferBuilder, m9193j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        public GraphSearchFilterValueFragmentModel() {
            super(4);
        }

        @Nullable
        private String m9198a() {
            this.f8211e = super.a(this.f8211e, 1);
            return this.f8211e;
        }

        @Nullable
        private String m9199j() {
            this.f8212f = super.a(this.f8212f, 2);
            return this.f8212f;
        }

        @Nullable
        private ValueObjectModel m9200k() {
            this.f8213g = (ValueObjectModel) super.a(this.f8213g, 3, ValueObjectModel.class);
            return this.f8213g;
        }

        public final int jK_() {
            return -2134006905;
        }

        public final GraphQLVisitableModel m9202a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9200k() != null) {
                ValueObjectModel valueObjectModel = (ValueObjectModel) graphQLModelMutatingVisitor.b(m9200k());
                if (m9200k() != valueObjectModel) {
                    graphQLVisitableModel = (GraphSearchFilterValueFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8213g = valueObjectModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9201a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m9198a());
            int b2 = flatBufferBuilder.b(m9199j());
            int a = ModelHelper.a(flatBufferBuilder, m9200k());
            flatBufferBuilder.c(4);
            flatBufferBuilder.a(0, this.f8210d);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m9203a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f8210d = mutableFlatBuffer.a(i, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -179838738)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: nearby_places_entry */
    public final class GraphSearchQueryFilterFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private GraphSearchFilterValueFragmentModel f8217d;
        @Nullable
        private CustomValueModel f8218e;
        @Nullable
        private FilterValuesModel f8219f;
        @Nullable
        private String f8220g;
        @Nullable
        private String f8221h;
        @Nullable
        private String f8222i;
        @Nullable
        private String f8223j;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1443934386)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: nearby_places_entry */
        public final class CustomValueModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f8214d;
            private int f8215e;

            /* compiled from: nearby_places_entry */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CustomValueModel.class, new Deserializer());
                }

                public Object m9204a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CustomValueParser.m9248a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object customValueModel = new CustomValueModel();
                    ((BaseModel) customValueModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (customValueModel instanceof Postprocessable) {
                        return ((Postprocessable) customValueModel).a();
                    }
                    return customValueModel;
                }
            }

            /* compiled from: nearby_places_entry */
            public class Serializer extends JsonSerializer<CustomValueModel> {
                public final void m9205a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CustomValueModel customValueModel = (CustomValueModel) obj;
                    if (customValueModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(customValueModel.m9207a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        customValueModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CustomValueParser.m9249a(customValueModel.w_(), customValueModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(CustomValueModel.class, new Serializer());
                }
            }

            public CustomValueModel() {
                super(2);
            }

            @Nullable
            private GraphQLObjectType m9206a() {
                if (this.b != null && this.f8214d == null) {
                    this.f8214d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f8214d;
            }

            public final int jK_() {
                return -287687146;
            }

            public final GraphQLVisitableModel m9208a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m9207a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m9206a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f8215e, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m9209a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f8215e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        /* compiled from: nearby_places_entry */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GraphSearchQueryFilterFieldsModel.class, new Deserializer());
            }

            public Object m9210a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GraphSearchQueryFilterFieldsParser.m9252a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object graphSearchQueryFilterFieldsModel = new GraphSearchQueryFilterFieldsModel();
                ((BaseModel) graphSearchQueryFilterFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (graphSearchQueryFilterFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) graphSearchQueryFilterFieldsModel).a();
                }
                return graphSearchQueryFilterFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1428518041)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: nearby_places_entry */
        public final class FilterValuesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<GraphSearchFilterValueFragmentModel> f8216d;

            /* compiled from: nearby_places_entry */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FilterValuesModel.class, new Deserializer());
                }

                public Object m9211a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FilterValuesParser.m9250a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object filterValuesModel = new FilterValuesModel();
                    ((BaseModel) filterValuesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (filterValuesModel instanceof Postprocessable) {
                        return ((Postprocessable) filterValuesModel).a();
                    }
                    return filterValuesModel;
                }
            }

            /* compiled from: nearby_places_entry */
            public class Serializer extends JsonSerializer<FilterValuesModel> {
                public final void m9212a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FilterValuesModel filterValuesModel = (FilterValuesModel) obj;
                    if (filterValuesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(filterValuesModel.m9214a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        filterValuesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FilterValuesParser.m9251a(filterValuesModel.w_(), filterValuesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FilterValuesModel.class, new Serializer());
                }
            }

            public FilterValuesModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<GraphSearchFilterValueFragmentModel> m9213a() {
                this.f8216d = super.a(this.f8216d, 0, GraphSearchFilterValueFragmentModel.class);
                return (ImmutableList) this.f8216d;
            }

            public final int jK_() {
                return 1130322378;
            }

            public final GraphQLVisitableModel m9215a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m9213a() != null) {
                    Builder a = ModelHelper.a(m9213a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (FilterValuesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8216d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m9214a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m9213a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: nearby_places_entry */
        public class Serializer extends JsonSerializer<GraphSearchQueryFilterFieldsModel> {
            public final void m9216a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GraphSearchQueryFilterFieldsModel graphSearchQueryFilterFieldsModel = (GraphSearchQueryFilterFieldsModel) obj;
                if (graphSearchQueryFilterFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(graphSearchQueryFilterFieldsModel.m9224a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    graphSearchQueryFilterFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GraphSearchQueryFilterFieldsParser.m9253a(graphSearchQueryFilterFieldsModel.w_(), graphSearchQueryFilterFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(GraphSearchQueryFilterFieldsModel.class, new Serializer());
            }
        }

        public GraphSearchQueryFilterFieldsModel() {
            super(7);
        }

        @Nullable
        private GraphSearchFilterValueFragmentModel m9217j() {
            this.f8217d = (GraphSearchFilterValueFragmentModel) super.a(this.f8217d, 0, GraphSearchFilterValueFragmentModel.class);
            return this.f8217d;
        }

        @Nullable
        private CustomValueModel m9218k() {
            this.f8218e = (CustomValueModel) super.a(this.f8218e, 1, CustomValueModel.class);
            return this.f8218e;
        }

        @Nullable
        private FilterValuesModel m9219l() {
            this.f8219f = (FilterValuesModel) super.a(this.f8219f, 2, FilterValuesModel.class);
            return this.f8219f;
        }

        @Nullable
        private String m9220m() {
            this.f8220g = super.a(this.f8220g, 3);
            return this.f8220g;
        }

        @Nullable
        private String m9221n() {
            this.f8221h = super.a(this.f8221h, 4);
            return this.f8221h;
        }

        @Nullable
        private String m9222o() {
            this.f8222i = super.a(this.f8222i, 5);
            return this.f8222i;
        }

        @Nullable
        private String m9223p() {
            this.f8223j = super.a(this.f8223j, 6);
            return this.f8223j;
        }

        @Nullable
        public final String m9226a() {
            return m9221n();
        }

        public final int jK_() {
            return -1440418806;
        }

        public final GraphQLVisitableModel m9225a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9217j() != null) {
                GraphSearchFilterValueFragmentModel graphSearchFilterValueFragmentModel = (GraphSearchFilterValueFragmentModel) graphQLModelMutatingVisitor.b(m9217j());
                if (m9217j() != graphSearchFilterValueFragmentModel) {
                    graphQLVisitableModel = (GraphSearchQueryFilterFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8217d = graphSearchFilterValueFragmentModel;
                }
            }
            if (m9218k() != null) {
                CustomValueModel customValueModel = (CustomValueModel) graphQLModelMutatingVisitor.b(m9218k());
                if (m9218k() != customValueModel) {
                    graphQLVisitableModel = (GraphSearchQueryFilterFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8218e = customValueModel;
                }
            }
            if (m9219l() != null) {
                FilterValuesModel filterValuesModel = (FilterValuesModel) graphQLModelMutatingVisitor.b(m9219l());
                if (m9219l() != filterValuesModel) {
                    graphQLVisitableModel = (GraphSearchQueryFilterFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8219f = filterValuesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9224a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9217j());
            int a2 = ModelHelper.a(flatBufferBuilder, m9218k());
            int a3 = ModelHelper.a(flatBufferBuilder, m9219l());
            int b = flatBufferBuilder.b(m9220m());
            int b2 = flatBufferBuilder.b(m9221n());
            int b3 = flatBufferBuilder.b(m9222o());
            int b4 = flatBufferBuilder.b(m9223p());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, b3);
            flatBufferBuilder.b(6, b4);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 31420665)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: nearby_places_entry */
    public final class GraphSearchQueryMainFilterFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphSearchQueryFilterFieldsModel f8224d;

        /* compiled from: nearby_places_entry */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GraphSearchQueryMainFilterFragmentModel.class, new Deserializer());
            }

            public Object m9227a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GraphSearchQueryMainFilterFragmentParser.m9256b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object graphSearchQueryMainFilterFragmentModel = new GraphSearchQueryMainFilterFragmentModel();
                ((BaseModel) graphSearchQueryMainFilterFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (graphSearchQueryMainFilterFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) graphSearchQueryMainFilterFragmentModel).a();
                }
                return graphSearchQueryMainFilterFragmentModel;
            }
        }

        /* compiled from: nearby_places_entry */
        public class Serializer extends JsonSerializer<GraphSearchQueryMainFilterFragmentModel> {
            public final void m9228a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GraphSearchQueryMainFilterFragmentModel graphSearchQueryMainFilterFragmentModel = (GraphSearchQueryMainFilterFragmentModel) obj;
                if (graphSearchQueryMainFilterFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(graphSearchQueryMainFilterFragmentModel.m9230a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    graphSearchQueryMainFilterFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GraphSearchQueryMainFilterFragmentParser.m9257b(graphSearchQueryMainFilterFragmentModel.w_(), graphSearchQueryMainFilterFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(GraphSearchQueryMainFilterFragmentModel.class, new Serializer());
            }
        }

        public GraphSearchQueryMainFilterFragmentModel() {
            super(1);
        }

        @Nullable
        private GraphSearchQueryFilterFieldsModel m9229a() {
            this.f8224d = (GraphSearchQueryFilterFieldsModel) super.a(this.f8224d, 0, GraphSearchQueryFilterFieldsModel.class);
            return this.f8224d;
        }

        public final int jK_() {
            return -2147350379;
        }

        public final GraphQLVisitableModel m9231a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9229a() != null) {
                GraphSearchQueryFilterFieldsModel graphSearchQueryFilterFieldsModel = (GraphSearchQueryFilterFieldsModel) graphQLModelMutatingVisitor.b(m9229a());
                if (m9229a() != graphSearchQueryFilterFieldsModel) {
                    graphQLVisitableModel = (GraphSearchQueryMainFilterFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8224d = graphSearchQueryFilterFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9230a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9229a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 182331282)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: nearby_places_entry */
    public final class GraphSearchQueryNeedleFiltersModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<GraphSearchQueryMainFilterFragmentModel> f8225d;

        /* compiled from: nearby_places_entry */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GraphSearchQueryNeedleFiltersModel.class, new Deserializer());
            }

            public Object m9232a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GraphSearchQueryNeedleFiltersParser.m9258a(jsonParser);
                Object graphSearchQueryNeedleFiltersModel = new GraphSearchQueryNeedleFiltersModel();
                ((BaseModel) graphSearchQueryNeedleFiltersModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (graphSearchQueryNeedleFiltersModel instanceof Postprocessable) {
                    return ((Postprocessable) graphSearchQueryNeedleFiltersModel).a();
                }
                return graphSearchQueryNeedleFiltersModel;
            }
        }

        /* compiled from: nearby_places_entry */
        public class Serializer extends JsonSerializer<GraphSearchQueryNeedleFiltersModel> {
            public final void m9233a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GraphSearchQueryNeedleFiltersModel graphSearchQueryNeedleFiltersModel = (GraphSearchQueryNeedleFiltersModel) obj;
                if (graphSearchQueryNeedleFiltersModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(graphSearchQueryNeedleFiltersModel.m9235a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    graphSearchQueryNeedleFiltersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = graphSearchQueryNeedleFiltersModel.w_();
                int u_ = graphSearchQueryNeedleFiltersModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("needle_filters");
                    GraphSearchQueryMainFilterFragmentParser.m9255a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GraphSearchQueryNeedleFiltersModel.class, new Serializer());
            }
        }

        public GraphSearchQueryNeedleFiltersModel() {
            super(1);
        }

        @Nonnull
        private ImmutableList<GraphSearchQueryMainFilterFragmentModel> m9234a() {
            this.f8225d = super.a(this.f8225d, 0, GraphSearchQueryMainFilterFragmentModel.class);
            return (ImmutableList) this.f8225d;
        }

        public final int jK_() {
            return -466486798;
        }

        public final GraphQLVisitableModel m9236a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9234a() != null) {
                Builder a = ModelHelper.a(m9234a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (GraphSearchQueryNeedleFiltersModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8225d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9235a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9234a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1668585843)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: nearby_places_entry */
    public final class GraphSearchQueryTopFiltersModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<GraphSearchQueryMainFilterFragmentModel> f8226d;

        /* compiled from: nearby_places_entry */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GraphSearchQueryTopFiltersModel.class, new Deserializer());
            }

            public Object m9237a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GraphSearchQueryTopFiltersParser.m9259a(jsonParser);
                Object graphSearchQueryTopFiltersModel = new GraphSearchQueryTopFiltersModel();
                ((BaseModel) graphSearchQueryTopFiltersModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (graphSearchQueryTopFiltersModel instanceof Postprocessable) {
                    return ((Postprocessable) graphSearchQueryTopFiltersModel).a();
                }
                return graphSearchQueryTopFiltersModel;
            }
        }

        /* compiled from: nearby_places_entry */
        public class Serializer extends JsonSerializer<GraphSearchQueryTopFiltersModel> {
            public final void m9238a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GraphSearchQueryTopFiltersModel graphSearchQueryTopFiltersModel = (GraphSearchQueryTopFiltersModel) obj;
                if (graphSearchQueryTopFiltersModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(graphSearchQueryTopFiltersModel.m9240a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    graphSearchQueryTopFiltersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = graphSearchQueryTopFiltersModel.w_();
                int u_ = graphSearchQueryTopFiltersModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("top_filters");
                    GraphSearchQueryMainFilterFragmentParser.m9255a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GraphSearchQueryTopFiltersModel.class, new Serializer());
            }
        }

        public GraphSearchQueryTopFiltersModel() {
            super(1);
        }

        @Nonnull
        private ImmutableList<GraphSearchQueryMainFilterFragmentModel> m9239a() {
            this.f8226d = super.a(this.f8226d, 0, GraphSearchQueryMainFilterFragmentModel.class);
            return (ImmutableList) this.f8226d;
        }

        public final int jK_() {
            return -466486798;
        }

        public final GraphQLVisitableModel m9241a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9239a() != null) {
                Builder a = ModelHelper.a(m9239a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (GraphSearchQueryTopFiltersModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8226d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9240a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9239a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
