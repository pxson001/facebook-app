package com.facebook.events.eventsdiscovery.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLParsers.FetchEventDiscoveryCategoryListParser;
import com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLParsers.FetchEventDiscoveryCategoryListParser.EventCategoryListParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
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

/* compiled from: com.facebook.contacts.ACTION_CONTACT_SYNC_PROGRESS */
public class EventsDiscoveryGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 111910815)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: com.facebook.contacts.ACTION_CONTACT_SYNC_PROGRESS */
    public final class FetchEventDiscoveryCategoryListModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<EventCategoryListModel> f17330d;

        /* compiled from: com.facebook.contacts.ACTION_CONTACT_SYNC_PROGRESS */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchEventDiscoveryCategoryListModel.class, new Deserializer());
            }

            public Object m17622a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FetchEventDiscoveryCategoryListParser.m17654a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fetchEventDiscoveryCategoryListModel = new FetchEventDiscoveryCategoryListModel();
                ((BaseModel) fetchEventDiscoveryCategoryListModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fetchEventDiscoveryCategoryListModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchEventDiscoveryCategoryListModel).a();
                }
                return fetchEventDiscoveryCategoryListModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 210198489)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: com.facebook.contacts.ACTION_CONTACT_SYNC_PROGRESS */
        public final class EventCategoryListModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f17327d;
            @Nullable
            private String f17328e;
            @Nullable
            private String f17329f;

            /* compiled from: com.facebook.contacts.ACTION_CONTACT_SYNC_PROGRESS */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventCategoryListModel.class, new Deserializer());
                }

                public Object m17623a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EventCategoryListParser.m17653b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object eventCategoryListModel = new EventCategoryListModel();
                    ((BaseModel) eventCategoryListModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (eventCategoryListModel instanceof Postprocessable) {
                        return ((Postprocessable) eventCategoryListModel).a();
                    }
                    return eventCategoryListModel;
                }
            }

            /* compiled from: com.facebook.contacts.ACTION_CONTACT_SYNC_PROGRESS */
            public class Serializer extends JsonSerializer<EventCategoryListModel> {
                public final void m17624a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventCategoryListModel eventCategoryListModel = (EventCategoryListModel) obj;
                    if (eventCategoryListModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventCategoryListModel.m17626a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventCategoryListModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EventCategoryListParser.m17652a(eventCategoryListModel.w_(), eventCategoryListModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(EventCategoryListModel.class, new Serializer());
                }
            }

            public EventCategoryListModel() {
                super(3);
            }

            @Nullable
            public final String m17628a() {
                this.f17327d = super.a(this.f17327d, 0);
                return this.f17327d;
            }

            @Nullable
            public final String m17629j() {
                this.f17328e = super.a(this.f17328e, 1);
                return this.f17328e;
            }

            @Nullable
            private String m17625k() {
                this.f17329f = super.a(this.f17329f, 2);
                return this.f17329f;
            }

            public final int jK_() {
                return -1231781438;
            }

            public final GraphQLVisitableModel m17627a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17626a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17628a());
                int b2 = flatBufferBuilder.b(m17629j());
                int b3 = flatBufferBuilder.b(m17625k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, b3);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: com.facebook.contacts.ACTION_CONTACT_SYNC_PROGRESS */
        public class Serializer extends JsonSerializer<FetchEventDiscoveryCategoryListModel> {
            public final void m17630a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchEventDiscoveryCategoryListModel fetchEventDiscoveryCategoryListModel = (FetchEventDiscoveryCategoryListModel) obj;
                if (fetchEventDiscoveryCategoryListModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchEventDiscoveryCategoryListModel.m17631a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchEventDiscoveryCategoryListModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchEventDiscoveryCategoryListModel.w_();
                int u_ = fetchEventDiscoveryCategoryListModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("event_category_list");
                    jsonGenerator.d();
                    for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                        EventCategoryListParser.m17652a(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchEventDiscoveryCategoryListModel.class, new Serializer());
            }
        }

        public FetchEventDiscoveryCategoryListModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<EventCategoryListModel> m17633a() {
            this.f17330d = super.a(this.f17330d, 0, EventCategoryListModel.class);
            return (ImmutableList) this.f17330d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m17632a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17633a() != null) {
                Builder a = ModelHelper.a(m17633a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (FetchEventDiscoveryCategoryListModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17330d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17631a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17633a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1713789830)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: com.facebook.contacts.ACTION_CONTACT_SYNC_PROGRESS */
    public final class FetchEventsDiscoveryFiltersModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<EventDiscoverSuggestionFiltersModel> f17337d;

        /* compiled from: com.facebook.contacts.ACTION_CONTACT_SYNC_PROGRESS */
        public class Deserializer extends FbJsonDeserializer {
            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.class;
                r1 = new com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels$FetchEventsDiscoveryFiltersModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m17634a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r10 = this;
                r8 = 1;
                r6 = 0;
                r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r4.<init>(r5);
                r5 = com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLParsers.FetchEventsDiscoveryFiltersParser.m17659a(r11, r4);
                r4.d(r5);
                r4 = r4.e();
                r5 = java.nio.ByteBuffer.wrap(r4);
                r4 = 0;
                r5.position(r4);
                r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r7 = r6;
                r9 = r6;
                r4.<init>(r5, r6, r7, r8, r9);
                r5 = 4;
                r6 = java.lang.Boolean.valueOf(r8);
                r4.a(r5, r6);
                r2 = r4;
                r1 = new com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels$FetchEventsDiscoveryFiltersModel;
                r1.<init>();
                r4 = r2.a;
                r0 = r4;
                r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                r0 = r1;
                r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                r0.a(r2, r3, r11);
                r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                if (r0 == 0) goto L_0x0048;
            L_0x0042:
                r1 = (com.facebook.common.json.Postprocessable) r1;
                r1 = r1.a();
            L_0x0048:
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 484687478)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: com.facebook.contacts.ACTION_CONTACT_SYNC_PROGRESS */
        public final class EventDiscoverSuggestionFiltersModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<FilterItemsModel> f17335d;
            @Nullable
            private String f17336e;

            /* compiled from: com.facebook.contacts.ACTION_CONTACT_SYNC_PROGRESS */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.class;
                    r1 = new com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels$FetchEventsDiscoveryFiltersModel$EventDiscoverSuggestionFiltersModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m17635a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLParsers.FetchEventsDiscoveryFiltersParser.EventDiscoverSuggestionFiltersParser.m17657b(r11, r4);
                    r4.d(r5);
                    r4 = r4.e();
                    r5 = java.nio.ByteBuffer.wrap(r4);
                    r4 = 0;
                    r5.position(r4);
                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r7 = r6;
                    r9 = r6;
                    r4.<init>(r5, r6, r7, r8, r9);
                    r5 = 4;
                    r6 = java.lang.Boolean.valueOf(r8);
                    r4.a(r5, r6);
                    r2 = r4;
                    r1 = new com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels$FetchEventsDiscoveryFiltersModel$EventDiscoverSuggestionFiltersModel;
                    r1.<init>();
                    r4 = r2.a;
                    r0 = r4;
                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r0 = r1;
                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                    r0.a(r2, r3, r11);
                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                    if (r0 == 0) goto L_0x0048;
                L_0x0042:
                    r1 = (com.facebook.common.json.Postprocessable) r1;
                    r1 = r1.a();
                L_0x0048:
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 241522191)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: com.facebook.contacts.ACTION_CONTACT_SYNC_PROGRESS */
            public final class FilterItemsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f17333d;
                @Nullable
                private String f17334e;

                /* compiled from: com.facebook.contacts.ACTION_CONTACT_SYNC_PROGRESS */
                public final class Builder {
                    @Nullable
                    public String f17331a;
                    @Nullable
                    public String f17332b;

                    public final com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.FilterItemsModel m17636a() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r7 = this;
                        r4 = 1;
                        r6 = 0;
                        r2 = 0;
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r7.f17331a;
                        r1 = r0.b(r1);
                        r3 = r7.f17332b;
                        r3 = r0.b(r3);
                        r5 = 2;
                        r0.c(r5);
                        r0.b(r6, r1);
                        r0.b(r4, r3);
                        r1 = r0.d();
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r1.position(r6);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r3 = r2;
                        r5 = r2;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r1 = new com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels$FetchEventsDiscoveryFiltersModel$EventDiscoverSuggestionFiltersModel$FilterItemsModel;
                        r1.<init>(r0);
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.FilterItemsModel.Builder.a():com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels$FetchEventsDiscoveryFiltersModel$EventDiscoverSuggestionFiltersModel$FilterItemsModel");
                    }
                }

                /* compiled from: com.facebook.contacts.ACTION_CONTACT_SYNC_PROGRESS */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.FilterItemsModel.class;
                        r1 = new com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels$FetchEventsDiscoveryFiltersModel$EventDiscoverSuggestionFiltersModel$FilterItemsModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.FilterItemsModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m17637a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r10 = this;
                        r8 = 1;
                        r6 = 0;
                        r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r4.<init>(r5);
                        r5 = com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLParsers.FetchEventsDiscoveryFiltersParser.EventDiscoverSuggestionFiltersParser.FilterItemsParser.m17656b(r11, r4);
                        r4.d(r5);
                        r4 = r4.e();
                        r5 = java.nio.ByteBuffer.wrap(r4);
                        r4 = 0;
                        r5.position(r4);
                        r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r7 = r6;
                        r9 = r6;
                        r4.<init>(r5, r6, r7, r8, r9);
                        r5 = 4;
                        r6 = java.lang.Boolean.valueOf(r8);
                        r4.a(r5, r6);
                        r2 = r4;
                        r1 = new com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels$FetchEventsDiscoveryFiltersModel$EventDiscoverSuggestionFiltersModel$FilterItemsModel;
                        r1.<init>();
                        r4 = r2.a;
                        r0 = r4;
                        r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                        r0 = r1;
                        r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                        r0.a(r2, r3, r11);
                        r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                        if (r0 == 0) goto L_0x0048;
                    L_0x0042:
                        r1 = (com.facebook.common.json.Postprocessable) r1;
                        r1 = r1.a();
                    L_0x0048:
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.FilterItemsModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: com.facebook.contacts.ACTION_CONTACT_SYNC_PROGRESS */
                public class Serializer extends JsonSerializer<FilterItemsModel> {
                    public final void m17638a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r7 = this;
                        r8 = (com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.FilterItemsModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m17639a(r0);
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r0 = 0;
                        r1.position(r0);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r4 = 1;
                        r3 = r2;
                        r5 = r2;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r6 = r0.a;
                        r1 = r6;
                        r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                        r8.a(r0, r1);
                    L_0x0035:
                        r0 = r8.w_();
                        r1 = r8.u_();
                        com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLParsers.FetchEventsDiscoveryFiltersParser.EventDiscoverSuggestionFiltersParser.FilterItemsParser.m17655a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.FilterItemsModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.FilterItemsModel.class;
                        r1 = new com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels$FetchEventsDiscoveryFiltersModel$EventDiscoverSuggestionFiltersModel$FilterItemsModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.FilterItemsModel.Serializer.<clinit>():void");
                    }
                }

                public FilterItemsModel() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 2;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.FilterItemsModel.<init>():void");
                }

                public FilterItemsModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = 2;
                    r2.<init>(r0);
                    r1 = r3.a;
                    r0 = r1;
                    r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r2.a(r3, r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.FilterItemsModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
                }

                @javax.annotation.Nullable
                public final java.lang.String m17641a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f17333d;
                    r1 = 0;
                    r0 = super.a(r0, r1);
                    r2.f17333d = r0;
                    r0 = r2.f17333d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.FilterItemsModel.a():java.lang.String");
                }

                @javax.annotation.Nullable
                public final java.lang.String m17642j() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f17334e;
                    r1 = 1;
                    r0 = super.a(r0, r1);
                    r2.f17334e = r0;
                    r0 = r2.f17334e;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.FilterItemsModel.j():java.lang.String");
                }

                public final int jK_() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 492783858; // 0x1d5f48f2 float:2.9551516E-21 double:2.43467575E-315;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.FilterItemsModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m17640a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r0.h();
                    r0.i();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.FilterItemsModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m17639a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r3.h();
                    r0 = r3.m17641a();
                    r0 = r4.b(r0);
                    r1 = r3.m17642j();
                    r1 = r4.b(r1);
                    r2 = 2;
                    r4.c(r2);
                    r2 = 0;
                    r4.b(r2, r0);
                    r0 = 1;
                    r4.b(r0, r1);
                    r3.i();
                    r0 = r4.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.FilterItemsModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: com.facebook.contacts.ACTION_CONTACT_SYNC_PROGRESS */
            public class Serializer extends JsonSerializer<EventDiscoverSuggestionFiltersModel> {
                public final void m17643a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r7 = this;
                    r8 = (com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m17644a(r0);
                    r0.d(r1);
                    r0 = r0.e();
                    r1 = java.nio.ByteBuffer.wrap(r0);
                    r0 = 0;
                    r1.position(r0);
                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r4 = 1;
                    r3 = r2;
                    r5 = r2;
                    r0.<init>(r1, r2, r3, r4, r5);
                    r6 = r0.a;
                    r1 = r6;
                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                    r8.a(r0, r1);
                L_0x0035:
                    r0 = r8.w_();
                    r1 = r8.u_();
                    com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLParsers.FetchEventsDiscoveryFiltersParser.EventDiscoverSuggestionFiltersParser.m17658b(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.class;
                    r1 = new com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels$FetchEventsDiscoveryFiltersModel$EventDiscoverSuggestionFiltersModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.Serializer.<clinit>():void");
                }
            }

            public EventDiscoverSuggestionFiltersModel() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 2;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.<init>():void");
            }

            @javax.annotation.Nonnull
            public final com.google.common.collect.ImmutableList<com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.FilterItemsModel> m17646a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f17335d;
                r1 = 0;
                r2 = com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.FilterItemsModel.class;
                r0 = super.a(r0, r1, r2);
                r3.f17335d = r0;
                r0 = r3.f17335d;
                r0 = (com.google.common.collect.ImmutableList) r0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.a():com.google.common.collect.ImmutableList<com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels$FetchEventsDiscoveryFiltersModel$EventDiscoverSuggestionFiltersModel$FilterItemsModel>");
            }

            @javax.annotation.Nullable
            public final java.lang.String m17647j() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = r2.f17336e;
                r1 = 1;
                r0 = super.a(r0, r1);
                r2.f17336e = r0;
                r0 = r2.f17336e;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.j():java.lang.String");
            }

            public final int jK_() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = -1934290625; // 0xffffffff8cb5113f float:-2.7897845E-31 double:NaN;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m17645a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = 0;
                r2.h();
                r1 = r2.m17646a();
                if (r1 == 0) goto L_0x0020;
            L_0x000a:
                r1 = r2.m17646a();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                if (r1 == 0) goto L_0x0020;
            L_0x0014:
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
                r0 = (com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel) r0;
                r1 = r1.b();
                r0.f17335d = r1;
            L_0x0020:
                r2.i();
                if (r0 != 0) goto L_0x0026;
            L_0x0025:
                return r2;
            L_0x0026:
                r2 = r0;
                goto L_0x0025;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m17644a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r3.h();
                r0 = r3.m17646a();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r0);
                r1 = r3.m17647j();
                r1 = r4.b(r1);
                r2 = 2;
                r4.c(r2);
                r2 = 0;
                r4.b(r2, r0);
                r0 = 1;
                r4.b(r0, r1);
                r3.i();
                r0 = r4.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        /* compiled from: com.facebook.contacts.ACTION_CONTACT_SYNC_PROGRESS */
        public class Serializer extends JsonSerializer<FetchEventsDiscoveryFiltersModel> {
            public final void m17648a(java.lang.Object r11, com.fasterxml.jackson.core.JsonGenerator r12, com.fasterxml.jackson.databind.SerializerProvider r13) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r10 = this;
                r11 = (com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel) r11;
                r2 = 0;
                r0 = r11.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r11.m17649a(r0);
                r0.d(r1);
                r0 = r0.e();
                r1 = java.nio.ByteBuffer.wrap(r0);
                r0 = 0;
                r1.position(r0);
                r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r4 = 1;
                r3 = r2;
                r5 = r2;
                r0.<init>(r1, r2, r3, r4, r5);
                r6 = r0.a;
                r1 = r6;
                r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                r11.a(r0, r1);
            L_0x0035:
                r0 = r11.w_();
                r1 = r11.u_();
                r12.f();
                r6 = 0;
                r6 = r0.g(r1, r6);
                if (r6 == 0) goto L_0x0063;
            L_0x0047:
                r7 = "event_discover_suggestion_filters";
                r12.a(r7);
                r12.d();
                r8 = 0;
            L_0x0050:
                r9 = r0.c(r6);
                if (r8 >= r9) goto L_0x0060;
            L_0x0056:
                r9 = r0.m(r6, r8);
                com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLParsers.FetchEventsDiscoveryFiltersParser.EventDiscoverSuggestionFiltersParser.m17658b(r0, r9, r12, r13);
                r8 = r8 + 1;
                goto L_0x0050;
            L_0x0060:
                r12.e();
            L_0x0063:
                r12.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
            }

            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.class;
                r1 = new com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels$FetchEventsDiscoveryFiltersModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.Serializer.<clinit>():void");
            }
        }

        public FetchEventsDiscoveryFiltersModel() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = 1;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.<init>():void");
        }

        @javax.annotation.Nonnull
        public final com.google.common.collect.ImmutableList<com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel> m17651a() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f17337d;
            r1 = 0;
            r2 = com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.EventDiscoverSuggestionFiltersModel.class;
            r0 = super.a(r0, r1, r2);
            r3.f17337d = r0;
            r0 = r3.f17337d;
            r0 = (com.google.common.collect.ImmutableList) r0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.a():com.google.common.collect.ImmutableList<com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels$FetchEventsDiscoveryFiltersModel$EventDiscoverSuggestionFiltersModel>");
        }

        public final int jK_() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = -1732764110; // 0xffffffff98b81e32 float:-4.7593375E-24 double:NaN;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m17650a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = 0;
            r2.h();
            r1 = r2.m17651a();
            if (r1 == 0) goto L_0x0020;
        L_0x000a:
            r1 = r2.m17651a();
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            if (r1 == 0) goto L_0x0020;
        L_0x0014:
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
            r0 = (com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel) r0;
            r1 = r1.b();
            r0.f17337d = r1;
        L_0x0020:
            r2.i();
            if (r0 != 0) goto L_0x0026;
        L_0x0025:
            return r2;
        L_0x0026:
            r2 = r0;
            goto L_0x0025;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m17649a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r2.h();
            r0 = r2.m17651a();
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
            r1 = 1;
            r3.c(r1);
            r1 = 0;
            r3.b(r1, r0);
            r2.i();
            r0 = r3.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventsDiscoveryFiltersModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }
}
