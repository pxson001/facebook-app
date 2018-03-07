package com.facebook.search.results.protocol.entity;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.results.protocol.entity.SearchResultsEventInterfaces.SearchResultsEvent;
import com.facebook.search.results.protocol.entity.SearchResultsEventParsers.SearchResultsEventParser;
import com.facebook.search.results.protocol.entity.SearchResultsEventParsers.SearchResultsEventParser.EventPlaceParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: min_line_height */
public class SearchResultsEventModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -868816471)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: min_line_height */
    public final class SearchResultsEventModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, SearchResultsEvent {
        private boolean f8595d;
        @Nullable
        private EventPlaceModel f8596e;
        @Nullable
        private String f8597f;
        @Nullable
        private String f8598g;
        @Nullable
        private DefaultImageFieldsModel f8599h;
        @Nullable
        private String f8600i;
        @Nullable
        private GraphQLEventGuestStatus f8601j;

        /* compiled from: min_line_height */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchResultsEventModel.class, new Deserializer());
            }

            public Object m9885a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SearchResultsEventParser.m9913a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object searchResultsEventModel = new SearchResultsEventModel();
                ((BaseModel) searchResultsEventModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (searchResultsEventModel instanceof Postprocessable) {
                    return ((Postprocessable) searchResultsEventModel).a();
                }
                return searchResultsEventModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -341630258)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: min_line_height */
        public final class EventPlaceModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f8593d;
            @Nullable
            private String f8594e;

            /* compiled from: min_line_height */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f8591a;
                @Nullable
                public String f8592b;
            }

            /* compiled from: min_line_height */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventPlaceModel.class, new Deserializer());
                }

                public Object m9886a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EventPlaceParser.m9911a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object eventPlaceModel = new EventPlaceModel();
                    ((BaseModel) eventPlaceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (eventPlaceModel instanceof Postprocessable) {
                        return ((Postprocessable) eventPlaceModel).a();
                    }
                    return eventPlaceModel;
                }
            }

            /* compiled from: min_line_height */
            public class Serializer extends JsonSerializer<EventPlaceModel> {
                public final void m9887a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventPlaceModel eventPlaceModel = (EventPlaceModel) obj;
                    if (eventPlaceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventPlaceModel.m9890a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventPlaceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EventPlaceParser.m9912a(eventPlaceModel.w_(), eventPlaceModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(EventPlaceModel.class, new Serializer());
                }
            }

            public EventPlaceModel() {
                super(2);
            }

            public EventPlaceModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m9893a(String str, ConsistencyTuple consistencyTuple) {
                if ("name".equals(str)) {
                    consistencyTuple.a = m9895b();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m9894a(String str, Object obj, boolean z) {
                if ("name".equals(str)) {
                    m9889a((String) obj);
                }
            }

            @Nullable
            public final GraphQLObjectType m9891a() {
                if (this.b != null && this.f8593d == null) {
                    this.f8593d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f8593d;
            }

            @Nullable
            public final String m9895b() {
                this.f8594e = super.a(this.f8594e, 1);
                return this.f8594e;
            }

            private void m9889a(@Nullable String str) {
                this.f8594e = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, str);
                }
            }

            public static EventPlaceModel m9888a(EventPlaceModel eventPlaceModel) {
                if (eventPlaceModel == null) {
                    return null;
                }
                if (eventPlaceModel instanceof EventPlaceModel) {
                    return eventPlaceModel;
                }
                Builder builder = new Builder();
                builder.f8591a = eventPlaceModel.m9891a();
                builder.f8592b = eventPlaceModel.m9895b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f8591a);
                int b = flatBufferBuilder.b(builder.f8592b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new EventPlaceModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 77195495;
            }

            public final GraphQLVisitableModel m9892a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m9890a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m9891a());
                int b = flatBufferBuilder.b(m9895b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: min_line_height */
        public class Serializer extends JsonSerializer<SearchResultsEventModel> {
            public final void m9896a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SearchResultsEventModel searchResultsEventModel = (SearchResultsEventModel) obj;
                if (searchResultsEventModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchResultsEventModel.m9905a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchResultsEventModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SearchResultsEventParser.m9914a(searchResultsEventModel.w_(), searchResultsEventModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SearchResultsEventModel.class, new Serializer());
            }
        }

        public SearchResultsEventModel() {
            super(7);
        }

        public final void m9909a(String str, ConsistencyTuple consistencyTuple) {
            if ("name".equals(str)) {
                consistencyTuple.a = m9901l();
                consistencyTuple.b = u_();
                consistencyTuple.c = 3;
            } else if ("viewer_guest_status".equals(str)) {
                consistencyTuple.a = m9904o();
                consistencyTuple.b = u_();
                consistencyTuple.c = 6;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m9910a(String str, Object obj, boolean z) {
            if ("name".equals(str)) {
                m9898a((String) obj);
            } else if ("viewer_guest_status".equals(str)) {
                m9897a((GraphQLEventGuestStatus) obj);
            }
        }

        @Nullable
        private EventPlaceModel m9899j() {
            this.f8596e = (EventPlaceModel) super.a(this.f8596e, 1, EventPlaceModel.class);
            return this.f8596e;
        }

        @Nullable
        private String m9900k() {
            this.f8597f = super.a(this.f8597f, 2);
            return this.f8597f;
        }

        @Nullable
        private String m9901l() {
            this.f8598g = super.a(this.f8598g, 3);
            return this.f8598g;
        }

        private void m9898a(@Nullable String str) {
            this.f8598g = str;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 3, str);
            }
        }

        @Nullable
        private DefaultImageFieldsModel m9902m() {
            this.f8599h = (DefaultImageFieldsModel) super.a(this.f8599h, 4, DefaultImageFieldsModel.class);
            return this.f8599h;
        }

        @Nullable
        private String m9903n() {
            this.f8600i = super.a(this.f8600i, 5);
            return this.f8600i;
        }

        @Nullable
        private GraphQLEventGuestStatus m9904o() {
            this.f8601j = (GraphQLEventGuestStatus) super.b(this.f8601j, 6, GraphQLEventGuestStatus.class, GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f8601j;
        }

        private void m9897a(GraphQLEventGuestStatus graphQLEventGuestStatus) {
            this.f8601j = graphQLEventGuestStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 6, graphQLEventGuestStatus != null ? graphQLEventGuestStatus.name() : null);
            }
        }

        @Nullable
        public final String m9907a() {
            return m9900k();
        }

        public final int jK_() {
            return 67338874;
        }

        public final GraphQLVisitableModel m9906a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9899j() != null) {
                EventPlaceModel eventPlaceModel = (EventPlaceModel) graphQLModelMutatingVisitor.b(m9899j());
                if (m9899j() != eventPlaceModel) {
                    graphQLVisitableModel = (SearchResultsEventModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8596e = eventPlaceModel;
                }
            }
            if (m9902m() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m9902m());
                if (m9902m() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (SearchResultsEventModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8599h = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9905a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9899j());
            int b = flatBufferBuilder.b(m9900k());
            int b2 = flatBufferBuilder.b(m9901l());
            int a2 = ModelHelper.a(flatBufferBuilder, m9902m());
            int b3 = flatBufferBuilder.b(m9903n());
            int a3 = flatBufferBuilder.a(m9904o());
            flatBufferBuilder.c(7);
            flatBufferBuilder.a(0, this.f8595d);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, a2);
            flatBufferBuilder.b(5, b3);
            flatBufferBuilder.b(6, a3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m9908a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f8595d = mutableFlatBuffer.a(i, 0);
        }
    }
}
