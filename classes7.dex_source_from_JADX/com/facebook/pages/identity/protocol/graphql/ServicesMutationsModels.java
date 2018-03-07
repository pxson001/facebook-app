package com.facebook.pages.identity.protocol.graphql;

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
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.identity.protocol.graphql.ServicesMutationsParsers.PageServicesCardDeleteMutationParser;
import com.facebook.pages.identity.protocol.graphql.ServicesMutationsParsers.PageServicesCardDeleteMutationParser.PageParser;
import com.facebook.pages.identity.protocol.graphql.ServicesMutationsParsers.PageServicesCardDeleteMutationParser.PageParser.ServicesCardParser;
import com.facebook.pages.identity.protocol.graphql.ServicesMutationsParsers.ServicesSectionUpdateMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: me() */
public class ServicesMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 798904017)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: me() */
    public final class PageServicesCardDeleteMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PageModel f9195d;

        /* compiled from: me() */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageServicesCardDeleteMutationModel.class, new Deserializer());
            }

            public Object m11197a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageServicesCardDeleteMutationParser.m11230a(jsonParser);
                Object pageServicesCardDeleteMutationModel = new PageServicesCardDeleteMutationModel();
                ((BaseModel) pageServicesCardDeleteMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageServicesCardDeleteMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) pageServicesCardDeleteMutationModel).a();
                }
                return pageServicesCardDeleteMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 910549882)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: me() */
        public final class PageModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private ServicesCardModel f9194d;

            /* compiled from: me() */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                }

                public Object m11198a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageParser.m11228a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageModel = new PageModel();
                    ((BaseModel) pageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageModel instanceof Postprocessable) {
                        return ((Postprocessable) pageModel).a();
                    }
                    return pageModel;
                }
            }

            /* compiled from: me() */
            public class Serializer extends JsonSerializer<PageModel> {
                public final void m11199a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageModel pageModel = (PageModel) obj;
                    if (pageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageModel.m11207a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageParser.m11229a(pageModel.w_(), pageModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PageModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1801334754)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: me() */
            public final class ServicesCardModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private String f9193d;

                /* compiled from: me() */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ServicesCardModel.class, new Deserializer());
                    }

                    public Object m11200a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ServicesCardParser.m11226a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object servicesCardModel = new ServicesCardModel();
                        ((BaseModel) servicesCardModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (servicesCardModel instanceof Postprocessable) {
                            return ((Postprocessable) servicesCardModel).a();
                        }
                        return servicesCardModel;
                    }
                }

                /* compiled from: me() */
                public class Serializer extends JsonSerializer<ServicesCardModel> {
                    public final void m11201a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ServicesCardModel servicesCardModel = (ServicesCardModel) obj;
                        if (servicesCardModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(servicesCardModel.m11203a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            servicesCardModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ServicesCardParser.m11227a(servicesCardModel.w_(), servicesCardModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ServicesCardModel.class, new Serializer());
                    }
                }

                public ServicesCardModel() {
                    super(1);
                }

                @Nullable
                private String m11202j() {
                    this.f9193d = super.a(this.f9193d, 0);
                    return this.f9193d;
                }

                @Nullable
                public final String m11205a() {
                    return m11202j();
                }

                public final int jK_() {
                    return -1544864547;
                }

                public final GraphQLVisitableModel m11204a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m11203a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m11202j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public PageModel() {
                super(1);
            }

            public final void m11209a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m11210a(String str, Object obj, boolean z) {
            }

            @Nullable
            private ServicesCardModel m11206a() {
                this.f9194d = (ServicesCardModel) super.a(this.f9194d, 0, ServicesCardModel.class);
                return this.f9194d;
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m11208a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11206a() != null) {
                    ServicesCardModel servicesCardModel = (ServicesCardModel) graphQLModelMutatingVisitor.b(m11206a());
                    if (m11206a() != servicesCardModel) {
                        graphQLVisitableModel = (PageModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9194d = servicesCardModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11207a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11206a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: me() */
        public class Serializer extends JsonSerializer<PageServicesCardDeleteMutationModel> {
            public final void m11211a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageServicesCardDeleteMutationModel pageServicesCardDeleteMutationModel = (PageServicesCardDeleteMutationModel) obj;
                if (pageServicesCardDeleteMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageServicesCardDeleteMutationModel.m11213a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageServicesCardDeleteMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageServicesCardDeleteMutationModel.w_();
                int u_ = pageServicesCardDeleteMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("page");
                    PageParser.m11229a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageServicesCardDeleteMutationModel.class, new Serializer());
            }
        }

        public PageServicesCardDeleteMutationModel() {
            super(1);
        }

        @Nullable
        private PageModel m11212a() {
            this.f9195d = (PageModel) super.a(this.f9195d, 0, PageModel.class);
            return this.f9195d;
        }

        public final int jK_() {
            return 1469169669;
        }

        public final GraphQLVisitableModel m11214a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11212a() != null) {
                PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m11212a());
                if (m11212a() != pageModel) {
                    graphQLVisitableModel = (PageServicesCardDeleteMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9195d = pageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11213a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11212a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 445578263)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: me() */
    public final class ServicesSectionUpdateMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ServicesCardModel f9198d;

        /* compiled from: me() */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ServicesSectionUpdateMutationModel.class, new Deserializer());
            }

            public Object m11215a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ServicesSectionUpdateMutationParser.m11233a(jsonParser);
                Object servicesSectionUpdateMutationModel = new ServicesSectionUpdateMutationModel();
                ((BaseModel) servicesSectionUpdateMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (servicesSectionUpdateMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) servicesSectionUpdateMutationModel).a();
                }
                return servicesSectionUpdateMutationModel;
            }
        }

        /* compiled from: me() */
        public class Serializer extends JsonSerializer<ServicesSectionUpdateMutationModel> {
            public final void m11216a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ServicesSectionUpdateMutationModel servicesSectionUpdateMutationModel = (ServicesSectionUpdateMutationModel) obj;
                if (servicesSectionUpdateMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(servicesSectionUpdateMutationModel.m11223a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    servicesSectionUpdateMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = servicesSectionUpdateMutationModel.w_();
                int u_ = servicesSectionUpdateMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("services_card");
                    ServicesSectionUpdateMutationParser.ServicesCardParser.m11232a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ServicesSectionUpdateMutationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1018562653)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: me() */
        public final class ServicesCardModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f9196d;
            @Nullable
            private String f9197e;

            /* compiled from: me() */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ServicesCardModel.class, new Deserializer());
                }

                public Object m11217a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ServicesSectionUpdateMutationParser.ServicesCardParser.m11231a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object servicesCardModel = new ServicesCardModel();
                    ((BaseModel) servicesCardModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (servicesCardModel instanceof Postprocessable) {
                        return ((Postprocessable) servicesCardModel).a();
                    }
                    return servicesCardModel;
                }
            }

            /* compiled from: me() */
            public class Serializer extends JsonSerializer<ServicesCardModel> {
                public final void m11218a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ServicesCardModel servicesCardModel = (ServicesCardModel) obj;
                    if (servicesCardModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(servicesCardModel.m11220a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        servicesCardModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ServicesSectionUpdateMutationParser.ServicesCardParser.m11232a(servicesCardModel.w_(), servicesCardModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ServicesCardModel.class, new Serializer());
                }
            }

            public ServicesCardModel() {
                super(2);
            }

            @Nullable
            public final String m11222a() {
                this.f9196d = super.a(this.f9196d, 0);
                return this.f9196d;
            }

            @Nullable
            private String m11219j() {
                this.f9197e = super.a(this.f9197e, 1);
                return this.f9197e;
            }

            public final int jK_() {
                return -1544864547;
            }

            public final GraphQLVisitableModel m11221a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m11220a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m11222a());
                int b2 = flatBufferBuilder.b(m11219j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        public ServicesSectionUpdateMutationModel() {
            super(1);
        }

        @Nullable
        public final ServicesCardModel m11225a() {
            this.f9198d = (ServicesCardModel) super.a(this.f9198d, 0, ServicesCardModel.class);
            return this.f9198d;
        }

        public final int jK_() {
            return 1010631925;
        }

        public final GraphQLVisitableModel m11224a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11225a() != null) {
                ServicesCardModel servicesCardModel = (ServicesCardModel) graphQLModelMutatingVisitor.b(m11225a());
                if (m11225a() != servicesCardModel) {
                    graphQLVisitableModel = (ServicesSectionUpdateMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9198d = servicesCardModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11223a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11225a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
