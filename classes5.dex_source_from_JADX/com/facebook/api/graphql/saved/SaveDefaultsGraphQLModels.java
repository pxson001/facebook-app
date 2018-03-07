package com.facebook.api.graphql.saved;

import com.facebook.api.graphql.saved.SaveDefaultsGraphQLInterfaces.NewItemDefaultPrivacy;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLInterfaces.SavableTimelineAppCollection;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLParsers.DefaultSavableObjectExtraFieldsParser;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLParsers.NewItemDefaultPrivacyParser;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLParsers.SavableTimelineAppCollectionExtraFieldsParser;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLParsers.SavableTimelineAppCollectionExtraFieldsParser.AddItemActionInfoParser;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLParsers.SavableTimelineAppCollectionExtraFieldsParser.AddedItemStateInfoParser;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLParsers.SavableTimelineAppCollectionExtraFieldsParser.SavedDashboardSectionParser;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLParsers.SavableTimelineAppCollectionParser;
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
import com.facebook.graphql.enums.GraphQLSavedDashboardSectionType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesWithAggregatedRangesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesWithAggregatedRangesFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: task can not be null */
public class SaveDefaultsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1066817402)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: task can not be null */
    public final class DefaultSavableObjectExtraFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f2127d;
        @Nullable
        private String f2128e;
        @Nullable
        private SavableTimelineAppCollectionExtraFieldsModel f2129f;
        @Nullable
        private GraphQLSavedState f2130g;

        /* compiled from: task can not be null */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f2123a;
            @Nullable
            public String f2124b;
            @Nullable
            public SavableTimelineAppCollectionExtraFieldsModel f2125c;
            @Nullable
            public GraphQLSavedState f2126d;
        }

        /* compiled from: task can not be null */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DefaultSavableObjectExtraFieldsModel.class, new Deserializer());
            }

            public Object m2880a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(DefaultSavableObjectExtraFieldsParser.m2942a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object defaultSavableObjectExtraFieldsModel = new DefaultSavableObjectExtraFieldsModel();
                ((BaseModel) defaultSavableObjectExtraFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (defaultSavableObjectExtraFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) defaultSavableObjectExtraFieldsModel).a();
                }
                return defaultSavableObjectExtraFieldsModel;
            }
        }

        /* compiled from: task can not be null */
        public class Serializer extends JsonSerializer<DefaultSavableObjectExtraFieldsModel> {
            public final void m2881a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                DefaultSavableObjectExtraFieldsModel defaultSavableObjectExtraFieldsModel = (DefaultSavableObjectExtraFieldsModel) obj;
                if (defaultSavableObjectExtraFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(defaultSavableObjectExtraFieldsModel.m2887a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    defaultSavableObjectExtraFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                DefaultSavableObjectExtraFieldsParser.m2943a(defaultSavableObjectExtraFieldsModel.w_(), defaultSavableObjectExtraFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(DefaultSavableObjectExtraFieldsModel.class, new Serializer());
            }
        }

        public DefaultSavableObjectExtraFieldsModel() {
            super(4);
        }

        public DefaultSavableObjectExtraFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m2890a(String str, ConsistencyTuple consistencyTuple) {
            if ("viewer_saved_state".equals(str)) {
                consistencyTuple.a = m2886m();
                consistencyTuple.b = u_();
                consistencyTuple.c = 3;
                return;
            }
            consistencyTuple.a();
        }

        public final void m2891a(String str, Object obj, boolean z) {
            if ("viewer_saved_state".equals(str)) {
                m2882a((GraphQLSavedState) obj);
            }
        }

        @Nullable
        private GraphQLObjectType m2883j() {
            if (this.b != null && this.f2127d == null) {
                this.f2127d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f2127d;
        }

        @Nullable
        private String m2884k() {
            this.f2128e = super.a(this.f2128e, 1);
            return this.f2128e;
        }

        @Nullable
        private SavableTimelineAppCollectionExtraFieldsModel m2885l() {
            this.f2129f = (SavableTimelineAppCollectionExtraFieldsModel) super.a(this.f2129f, 2, SavableTimelineAppCollectionExtraFieldsModel.class);
            return this.f2129f;
        }

        @Nullable
        private GraphQLSavedState m2886m() {
            this.f2130g = (GraphQLSavedState) super.b(this.f2130g, 3, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f2130g;
        }

        private void m2882a(GraphQLSavedState graphQLSavedState) {
            this.f2130g = graphQLSavedState;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 3, graphQLSavedState != null ? graphQLSavedState.name() : null);
            }
        }

        @Nullable
        public final String m2889a() {
            return m2884k();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m2888a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2885l() != null) {
                SavableTimelineAppCollectionExtraFieldsModel savableTimelineAppCollectionExtraFieldsModel = (SavableTimelineAppCollectionExtraFieldsModel) graphQLModelMutatingVisitor.b(m2885l());
                if (m2885l() != savableTimelineAppCollectionExtraFieldsModel) {
                    graphQLVisitableModel = (DefaultSavableObjectExtraFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2129f = savableTimelineAppCollectionExtraFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2887a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2883j());
            int b = flatBufferBuilder.b(m2884k());
            int a2 = ModelHelper.a(flatBufferBuilder, m2885l());
            int a3 = flatBufferBuilder.a(m2886m());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1879097205)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: task can not be null */
    public final class NewItemDefaultPrivacyModel extends BaseModel implements NewItemDefaultPrivacy, GraphQLVisitableModel {
        @Nullable
        private String f2133d;
        @Nullable
        private String f2134e;

        /* compiled from: task can not be null */
        public final class Builder {
            @Nullable
            public String f2131a;
            @Nullable
            public String f2132b;
        }

        /* compiled from: task can not be null */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NewItemDefaultPrivacyModel.class, new Deserializer());
            }

            public Object m2892a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(NewItemDefaultPrivacyParser.m2944a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object newItemDefaultPrivacyModel = new NewItemDefaultPrivacyModel();
                ((BaseModel) newItemDefaultPrivacyModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (newItemDefaultPrivacyModel instanceof Postprocessable) {
                    return ((Postprocessable) newItemDefaultPrivacyModel).a();
                }
                return newItemDefaultPrivacyModel;
            }
        }

        /* compiled from: task can not be null */
        public class Serializer extends JsonSerializer<NewItemDefaultPrivacyModel> {
            public final void m2893a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                NewItemDefaultPrivacyModel newItemDefaultPrivacyModel = (NewItemDefaultPrivacyModel) obj;
                if (newItemDefaultPrivacyModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(newItemDefaultPrivacyModel.m2895a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    newItemDefaultPrivacyModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                NewItemDefaultPrivacyParser.m2945a(newItemDefaultPrivacyModel.w_(), newItemDefaultPrivacyModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(NewItemDefaultPrivacyModel.class, new Serializer());
            }
        }

        public NewItemDefaultPrivacyModel() {
            super(2);
        }

        public NewItemDefaultPrivacyModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m2897c() {
            this.f2133d = super.a(this.f2133d, 0);
            return this.f2133d;
        }

        @Nullable
        public final String m2898k() {
            this.f2134e = super.a(this.f2134e, 1);
            return this.f2134e;
        }

        public static NewItemDefaultPrivacyModel m2894a(NewItemDefaultPrivacy newItemDefaultPrivacy) {
            if (newItemDefaultPrivacy == null) {
                return null;
            }
            if (newItemDefaultPrivacy instanceof NewItemDefaultPrivacyModel) {
                return (NewItemDefaultPrivacyModel) newItemDefaultPrivacy;
            }
            Builder builder = new Builder();
            builder.f2131a = newItemDefaultPrivacy.c();
            builder.f2132b = newItemDefaultPrivacy.k();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f2131a);
            int b2 = flatBufferBuilder.b(builder.f2132b);
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new NewItemDefaultPrivacyModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return -1984364035;
        }

        public final GraphQLVisitableModel m2896a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m2895a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2897c());
            int b2 = flatBufferBuilder.b(m2898k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -805129198)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: task can not be null */
    public final class SavableTimelineAppCollectionExtraFieldsModel extends BaseModel implements SavableTimelineAppCollection, GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private AddItemActionInfoModel f2140d;
        @Nullable
        private AddedItemStateInfoModel f2141e;
        @Nullable
        private String f2142f;
        @Nullable
        private String f2143g;
        @Nullable
        private String f2144h;
        @Nullable
        private NewItemDefaultPrivacyModel f2145i;
        @Nullable
        private SavedDashboardSectionModel f2146j;
        @Nullable
        private String f2147k;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -546403759)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: task can not be null */
        public final class AddItemActionInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f2135d;
            @Nullable
            private DefaultTextWithEntitiesWithAggregatedRangesFieldsModel f2136e;

            /* compiled from: task can not be null */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AddItemActionInfoModel.class, new Deserializer());
                }

                public Object m2899a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AddItemActionInfoParser.m2946a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object addItemActionInfoModel = new AddItemActionInfoModel();
                    ((BaseModel) addItemActionInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (addItemActionInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) addItemActionInfoModel).a();
                    }
                    return addItemActionInfoModel;
                }
            }

            /* compiled from: task can not be null */
            public class Serializer extends JsonSerializer<AddItemActionInfoModel> {
                public final void m2900a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AddItemActionInfoModel addItemActionInfoModel = (AddItemActionInfoModel) obj;
                    if (addItemActionInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(addItemActionInfoModel.m2902a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        addItemActionInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AddItemActionInfoParser.m2947a(addItemActionInfoModel.w_(), addItemActionInfoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AddItemActionInfoModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DefaultTextWithEntitiesWithAggregatedRangesFields m2905b() {
                return m2901j();
            }

            public AddItemActionInfoModel() {
                super(2);
            }

            @Nullable
            public final String m2904a() {
                this.f2135d = super.a(this.f2135d, 0);
                return this.f2135d;
            }

            @Nullable
            private DefaultTextWithEntitiesWithAggregatedRangesFieldsModel m2901j() {
                this.f2136e = (DefaultTextWithEntitiesWithAggregatedRangesFieldsModel) super.a(this.f2136e, 1, DefaultTextWithEntitiesWithAggregatedRangesFieldsModel.class);
                return this.f2136e;
            }

            public final int jK_() {
                return 1295346699;
            }

            public final GraphQLVisitableModel m2903a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2901j() != null) {
                    DefaultTextWithEntitiesWithAggregatedRangesFieldsModel defaultTextWithEntitiesWithAggregatedRangesFieldsModel = (DefaultTextWithEntitiesWithAggregatedRangesFieldsModel) graphQLModelMutatingVisitor.b(m2901j());
                    if (m2901j() != defaultTextWithEntitiesWithAggregatedRangesFieldsModel) {
                        graphQLVisitableModel = (AddItemActionInfoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2136e = defaultTextWithEntitiesWithAggregatedRangesFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2902a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2904a());
                int a = ModelHelper.a(flatBufferBuilder, m2901j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -546403759)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: task can not be null */
        public final class AddedItemStateInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f2137d;
            @Nullable
            private DefaultTextWithEntitiesWithAggregatedRangesFieldsModel f2138e;

            /* compiled from: task can not be null */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AddedItemStateInfoModel.class, new Deserializer());
                }

                public Object m2906a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AddedItemStateInfoParser.m2948a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object addedItemStateInfoModel = new AddedItemStateInfoModel();
                    ((BaseModel) addedItemStateInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (addedItemStateInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) addedItemStateInfoModel).a();
                    }
                    return addedItemStateInfoModel;
                }
            }

            /* compiled from: task can not be null */
            public class Serializer extends JsonSerializer<AddedItemStateInfoModel> {
                public final void m2907a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AddedItemStateInfoModel addedItemStateInfoModel = (AddedItemStateInfoModel) obj;
                    if (addedItemStateInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(addedItemStateInfoModel.m2909a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        addedItemStateInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AddedItemStateInfoParser.m2949a(addedItemStateInfoModel.w_(), addedItemStateInfoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AddedItemStateInfoModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DefaultTextWithEntitiesWithAggregatedRangesFields m2912b() {
                return m2908j();
            }

            public AddedItemStateInfoModel() {
                super(2);
            }

            @Nullable
            public final String m2911a() {
                this.f2137d = super.a(this.f2137d, 0);
                return this.f2137d;
            }

            @Nullable
            private DefaultTextWithEntitiesWithAggregatedRangesFieldsModel m2908j() {
                this.f2138e = (DefaultTextWithEntitiesWithAggregatedRangesFieldsModel) super.a(this.f2138e, 1, DefaultTextWithEntitiesWithAggregatedRangesFieldsModel.class);
                return this.f2138e;
            }

            public final int jK_() {
                return 1295346699;
            }

            public final GraphQLVisitableModel m2910a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2908j() != null) {
                    DefaultTextWithEntitiesWithAggregatedRangesFieldsModel defaultTextWithEntitiesWithAggregatedRangesFieldsModel = (DefaultTextWithEntitiesWithAggregatedRangesFieldsModel) graphQLModelMutatingVisitor.b(m2908j());
                    if (m2908j() != defaultTextWithEntitiesWithAggregatedRangesFieldsModel) {
                        graphQLVisitableModel = (AddedItemStateInfoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2138e = defaultTextWithEntitiesWithAggregatedRangesFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2909a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2911a());
                int a = ModelHelper.a(flatBufferBuilder, m2908j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: task can not be null */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SavableTimelineAppCollectionExtraFieldsModel.class, new Deserializer());
            }

            public Object m2913a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SavableTimelineAppCollectionExtraFieldsParser.m2952a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object savableTimelineAppCollectionExtraFieldsModel = new SavableTimelineAppCollectionExtraFieldsModel();
                ((BaseModel) savableTimelineAppCollectionExtraFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (savableTimelineAppCollectionExtraFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) savableTimelineAppCollectionExtraFieldsModel).a();
                }
                return savableTimelineAppCollectionExtraFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1007128525)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: task can not be null */
        public final class SavedDashboardSectionModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLSavedDashboardSectionType f2139d;

            /* compiled from: task can not be null */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SavedDashboardSectionModel.class, new Deserializer());
                }

                public Object m2914a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SavedDashboardSectionParser.m2950a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object savedDashboardSectionModel = new SavedDashboardSectionModel();
                    ((BaseModel) savedDashboardSectionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (savedDashboardSectionModel instanceof Postprocessable) {
                        return ((Postprocessable) savedDashboardSectionModel).a();
                    }
                    return savedDashboardSectionModel;
                }
            }

            /* compiled from: task can not be null */
            public class Serializer extends JsonSerializer<SavedDashboardSectionModel> {
                public final void m2915a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SavedDashboardSectionModel savedDashboardSectionModel = (SavedDashboardSectionModel) obj;
                    if (savedDashboardSectionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(savedDashboardSectionModel.m2916a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        savedDashboardSectionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SavedDashboardSectionParser.m2951a(savedDashboardSectionModel.w_(), savedDashboardSectionModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SavedDashboardSectionModel.class, new Serializer());
                }
            }

            public SavedDashboardSectionModel() {
                super(1);
            }

            @Nullable
            public final GraphQLSavedDashboardSectionType m2917a() {
                this.f2139d = (GraphQLSavedDashboardSectionType) super.b(this.f2139d, 0, GraphQLSavedDashboardSectionType.class, GraphQLSavedDashboardSectionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f2139d;
            }

            public final int jK_() {
                return -1926237640;
            }

            public final GraphQLVisitableModel m2918a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2916a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(m2917a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: task can not be null */
        public class Serializer extends JsonSerializer<SavableTimelineAppCollectionExtraFieldsModel> {
            public final void m2919a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SavableTimelineAppCollectionExtraFieldsModel savableTimelineAppCollectionExtraFieldsModel = (SavableTimelineAppCollectionExtraFieldsModel) obj;
                if (savableTimelineAppCollectionExtraFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(savableTimelineAppCollectionExtraFieldsModel.m2923a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    savableTimelineAppCollectionExtraFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SavableTimelineAppCollectionExtraFieldsParser.m2953a(savableTimelineAppCollectionExtraFieldsModel.w_(), savableTimelineAppCollectionExtraFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SavableTimelineAppCollectionExtraFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ SavedDashboardSectionModel I_() {
            return m2922n();
        }

        @Nullable
        public final /* synthetic */ AddItemActionInfoModel J_() {
            return m2920l();
        }

        @Nullable
        public final /* synthetic */ NewItemDefaultPrivacy m2928d() {
            return m2931k();
        }

        @Nullable
        public final /* synthetic */ AddedItemStateInfoModel m2929g() {
            return m2921m();
        }

        public SavableTimelineAppCollectionExtraFieldsModel() {
            super(8);
        }

        @Nullable
        private AddItemActionInfoModel m2920l() {
            this.f2140d = (AddItemActionInfoModel) super.a(this.f2140d, 0, AddItemActionInfoModel.class);
            return this.f2140d;
        }

        @Nullable
        private AddedItemStateInfoModel m2921m() {
            this.f2141e = (AddedItemStateInfoModel) super.a(this.f2141e, 1, AddedItemStateInfoModel.class);
            return this.f2141e;
        }

        @Nullable
        public final String H_() {
            this.f2142f = super.a(this.f2142f, 2);
            return this.f2142f;
        }

        @Nullable
        public final String m2926b() {
            this.f2143g = super.a(this.f2143g, 3);
            return this.f2143g;
        }

        @Nullable
        public final String m2927c() {
            this.f2144h = super.a(this.f2144h, 4);
            return this.f2144h;
        }

        @Nullable
        public final NewItemDefaultPrivacyModel m2931k() {
            this.f2145i = (NewItemDefaultPrivacyModel) super.a(this.f2145i, 5, NewItemDefaultPrivacyModel.class);
            return this.f2145i;
        }

        @Nullable
        private SavedDashboardSectionModel m2922n() {
            this.f2146j = (SavedDashboardSectionModel) super.a(this.f2146j, 6, SavedDashboardSectionModel.class);
            return this.f2146j;
        }

        @Nullable
        public final String m2930j() {
            this.f2147k = super.a(this.f2147k, 7);
            return this.f2147k;
        }

        @Nullable
        public final String m2925a() {
            return m2926b();
        }

        public final int jK_() {
            return -1476137794;
        }

        public final GraphQLVisitableModel m2924a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2920l() != null) {
                AddItemActionInfoModel addItemActionInfoModel = (AddItemActionInfoModel) graphQLModelMutatingVisitor.b(m2920l());
                if (m2920l() != addItemActionInfoModel) {
                    graphQLVisitableModel = (SavableTimelineAppCollectionExtraFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2140d = addItemActionInfoModel;
                }
            }
            if (m2921m() != null) {
                AddedItemStateInfoModel addedItemStateInfoModel = (AddedItemStateInfoModel) graphQLModelMutatingVisitor.b(m2921m());
                if (m2921m() != addedItemStateInfoModel) {
                    graphQLVisitableModel = (SavableTimelineAppCollectionExtraFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2141e = addedItemStateInfoModel;
                }
            }
            if (m2931k() != null) {
                NewItemDefaultPrivacyModel newItemDefaultPrivacyModel = (NewItemDefaultPrivacyModel) graphQLModelMutatingVisitor.b(m2931k());
                if (m2931k() != newItemDefaultPrivacyModel) {
                    graphQLVisitableModel = (SavableTimelineAppCollectionExtraFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2145i = newItemDefaultPrivacyModel;
                }
            }
            if (m2922n() != null) {
                SavedDashboardSectionModel savedDashboardSectionModel = (SavedDashboardSectionModel) graphQLModelMutatingVisitor.b(m2922n());
                if (m2922n() != savedDashboardSectionModel) {
                    graphQLVisitableModel = (SavableTimelineAppCollectionExtraFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2146j = savedDashboardSectionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2923a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2920l());
            int a2 = ModelHelper.a(flatBufferBuilder, m2921m());
            int b = flatBufferBuilder.b(H_());
            int b2 = flatBufferBuilder.b(m2926b());
            int b3 = flatBufferBuilder.b(m2927c());
            int a3 = ModelHelper.a(flatBufferBuilder, m2931k());
            int a4 = ModelHelper.a(flatBufferBuilder, m2922n());
            int b4 = flatBufferBuilder.b(m2930j());
            flatBufferBuilder.c(8);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.b(5, a3);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.b(7, b4);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 344173403)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: task can not be null */
    public final class SavableTimelineAppCollectionModel extends BaseModel implements SavableTimelineAppCollection, GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f2151d;
        @Nullable
        private String f2152e;
        @Nullable
        private NewItemDefaultPrivacyModel f2153f;

        /* compiled from: task can not be null */
        public final class Builder {
            @Nullable
            public String f2148a;
            @Nullable
            public String f2149b;
            @Nullable
            public NewItemDefaultPrivacyModel f2150c;
        }

        /* compiled from: task can not be null */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SavableTimelineAppCollectionModel.class, new Deserializer());
            }

            public Object m2932a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SavableTimelineAppCollectionParser.m2954a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object savableTimelineAppCollectionModel = new SavableTimelineAppCollectionModel();
                ((BaseModel) savableTimelineAppCollectionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (savableTimelineAppCollectionModel instanceof Postprocessable) {
                    return ((Postprocessable) savableTimelineAppCollectionModel).a();
                }
                return savableTimelineAppCollectionModel;
            }
        }

        /* compiled from: task can not be null */
        public class Serializer extends JsonSerializer<SavableTimelineAppCollectionModel> {
            public final void m2933a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SavableTimelineAppCollectionModel savableTimelineAppCollectionModel = (SavableTimelineAppCollectionModel) obj;
                if (savableTimelineAppCollectionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(savableTimelineAppCollectionModel.m2936a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    savableTimelineAppCollectionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SavableTimelineAppCollectionParser.m2957b(savableTimelineAppCollectionModel.w_(), savableTimelineAppCollectionModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SavableTimelineAppCollectionModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ NewItemDefaultPrivacy m2941d() {
            return m2935j();
        }

        public SavableTimelineAppCollectionModel() {
            super(3);
        }

        public SavableTimelineAppCollectionModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m2939b() {
            this.f2151d = super.a(this.f2151d, 0);
            return this.f2151d;
        }

        @Nullable
        public final String m2940c() {
            this.f2152e = super.a(this.f2152e, 1);
            return this.f2152e;
        }

        @Nullable
        private NewItemDefaultPrivacyModel m2935j() {
            this.f2153f = (NewItemDefaultPrivacyModel) super.a(this.f2153f, 2, NewItemDefaultPrivacyModel.class);
            return this.f2153f;
        }

        public static SavableTimelineAppCollectionModel m2934a(SavableTimelineAppCollection savableTimelineAppCollection) {
            if (savableTimelineAppCollection == null) {
                return null;
            }
            if (savableTimelineAppCollection instanceof SavableTimelineAppCollectionModel) {
                return (SavableTimelineAppCollectionModel) savableTimelineAppCollection;
            }
            Builder builder = new Builder();
            builder.f2148a = savableTimelineAppCollection.b();
            builder.f2149b = savableTimelineAppCollection.c();
            builder.f2150c = NewItemDefaultPrivacyModel.m2894a(savableTimelineAppCollection.d());
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f2148a);
            int b2 = flatBufferBuilder.b(builder.f2149b);
            int a = ModelHelper.a(flatBufferBuilder, builder.f2150c);
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new SavableTimelineAppCollectionModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        @Nullable
        public final String m2938a() {
            return m2939b();
        }

        public final int jK_() {
            return -1476137794;
        }

        public final GraphQLVisitableModel m2937a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2935j() != null) {
                NewItemDefaultPrivacyModel newItemDefaultPrivacyModel = (NewItemDefaultPrivacyModel) graphQLModelMutatingVisitor.b(m2935j());
                if (m2935j() != newItemDefaultPrivacyModel) {
                    graphQLVisitableModel = (SavableTimelineAppCollectionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2153f = newItemDefaultPrivacyModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2936a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2939b());
            int b2 = flatBufferBuilder.b(m2940c());
            int a = ModelHelper.a(flatBufferBuilder, m2935j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
