package com.facebook.events.notificationsettings.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.events.notificationsettings.protocol.EventsNotificationSettingsMutationsParsers.EventUpdateNotificationSubscriptionLevelMutationParser.EventParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLEventNotificationSubscriptionLevel;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: cardProps */
public class EventsNotificationSettingsMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 42678343)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: cardProps */
    public final class EventUpdateNotificationSubscriptionLevelMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f17832d;
        @Nullable
        private EventModel f17833e;

        /* compiled from: cardProps */
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
                r0 = com.facebook.events.notificationsettings.protocol.EventsNotificationSettingsMutationsModels.EventUpdateNotificationSubscriptionLevelMutationModel.class;
                r1 = new com.facebook.events.notificationsettings.protocol.EventsNotificationSettingsMutationsModels$EventUpdateNotificationSubscriptionLevelMutationModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.notificationsettings.protocol.EventsNotificationSettingsMutationsModels.EventUpdateNotificationSubscriptionLevelMutationModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m18197a(com.fasterxml.jackson.core.JsonParser r6, com.fasterxml.jackson.databind.DeserializationContext r7) {
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
                r5 = this;
                r2 = com.facebook.events.notificationsettings.protocol.EventsNotificationSettingsMutationsParsers.EventUpdateNotificationSubscriptionLevelMutationParser.m18215a(r6);
                r1 = new com.facebook.events.notificationsettings.protocol.EventsNotificationSettingsMutationsModels$EventUpdateNotificationSubscriptionLevelMutationModel;
                r1.<init>();
                r4 = r2.a;
                r0 = r4;
                r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                r0 = r1;
                r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                r0.a(r2, r3, r6);
                r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                if (r0 == 0) goto L_0x0020;
            L_0x001a:
                r1 = (com.facebook.common.json.Postprocessable) r1;
                r1 = r1.a();
            L_0x0020:
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.notificationsettings.protocol.EventsNotificationSettingsMutationsModels.EventUpdateNotificationSubscriptionLevelMutationModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1728029281)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: cardProps */
        public final class EventModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f17830d;
            @Nullable
            private GraphQLEventNotificationSubscriptionLevel f17831e;

            /* compiled from: cardProps */
            public final class Builder {
                @Nullable
                public String f17828a;
                @Nullable
                public GraphQLEventNotificationSubscriptionLevel f17829b;
            }

            /* compiled from: cardProps */
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
                    r0 = com.facebook.events.notificationsettings.protocol.EventsNotificationSettingsMutationsModels.EventUpdateNotificationSubscriptionLevelMutationModel.EventModel.class;
                    r1 = new com.facebook.events.notificationsettings.protocol.EventsNotificationSettingsMutationsModels$EventUpdateNotificationSubscriptionLevelMutationModel$EventModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.notificationsettings.protocol.EventsNotificationSettingsMutationsModels.EventUpdateNotificationSubscriptionLevelMutationModel.EventModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m18198a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                    r5 = com.facebook.events.notificationsettings.protocol.EventsNotificationSettingsMutationsParsers.EventUpdateNotificationSubscriptionLevelMutationParser.EventParser.m18213a(r11, r4);
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
                    r1 = new com.facebook.events.notificationsettings.protocol.EventsNotificationSettingsMutationsModels$EventUpdateNotificationSubscriptionLevelMutationModel$EventModel;
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.notificationsettings.protocol.EventsNotificationSettingsMutationsModels.EventUpdateNotificationSubscriptionLevelMutationModel.EventModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            /* compiled from: cardProps */
            public class Serializer extends JsonSerializer<EventModel> {
                public final void m18199a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventModel eventModel = (EventModel) r8;
                    if (eventModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventModel.m18203a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EventParser.m18214a(eventModel.w_(), eventModel.u_(), r9);
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
                    r0 = com.facebook.events.notificationsettings.protocol.EventsNotificationSettingsMutationsModels.EventUpdateNotificationSubscriptionLevelMutationModel.EventModel.class;
                    r1 = new com.facebook.events.notificationsettings.protocol.EventsNotificationSettingsMutationsModels$EventUpdateNotificationSubscriptionLevelMutationModel$EventModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.notificationsettings.protocol.EventsNotificationSettingsMutationsModels.EventUpdateNotificationSubscriptionLevelMutationModel.EventModel.Serializer.<clinit>():void");
                }
            }

            public EventModel() {
                super(2);
            }

            public EventModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(r3, FlatBuffer.a(r3.a));
            }

            public final void m18206a(String str, ConsistencyTuple consistencyTuple) {
                if ("viewer_notification_subscription_level".equals(r2)) {
                    r3.a = m18202k();
                    r3.b = u_();
                    r3.c = 1;
                    return;
                }
                r3.a();
            }

            public final void m18207a(String str, Object obj, boolean z) {
                if ("viewer_notification_subscription_level".equals(r2)) {
                    m18200a((GraphQLEventNotificationSubscriptionLevel) r3);
                }
            }

            @Nullable
            private String m18201j() {
                this.f17830d = super.a(this.f17830d, 0);
                return this.f17830d;
            }

            @Nullable
            private GraphQLEventNotificationSubscriptionLevel m18202k() {
                this.f17831e = (GraphQLEventNotificationSubscriptionLevel) super.b(this.f17831e, 1, GraphQLEventNotificationSubscriptionLevel.class, GraphQLEventNotificationSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f17831e;
            }

            private void m18200a(GraphQLEventNotificationSubscriptionLevel graphQLEventNotificationSubscriptionLevel) {
                this.f17831e = r6;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, r6 != null ? r6.name() : null);
                }
            }

            @Nullable
            public final String m18205a() {
                return m18201j();
            }

            public final int jK_() {
                return 67338874;
            }

            public final GraphQLVisitableModel m18204a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m18203a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = r4.b(m18201j());
                int a = r4.a(m18202k());
                r4.c(2);
                r4.b(0, b);
                r4.b(1, a);
                i();
                return r4.d();
            }
        }

        /* compiled from: cardProps */
        public class Serializer extends JsonSerializer<EventUpdateNotificationSubscriptionLevelMutationModel> {
            public final void m18208a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                EventUpdateNotificationSubscriptionLevelMutationModel eventUpdateNotificationSubscriptionLevelMutationModel = (EventUpdateNotificationSubscriptionLevelMutationModel) r9;
                if (eventUpdateNotificationSubscriptionLevelMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(eventUpdateNotificationSubscriptionLevelMutationModel.m18211a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    eventUpdateNotificationSubscriptionLevelMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = eventUpdateNotificationSubscriptionLevelMutationModel.w_();
                int u_ = eventUpdateNotificationSubscriptionLevelMutationModel.u_();
                r10.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    r10.a("client_mutation_id");
                    r10.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    r10.a("event");
                    EventParser.m18214a(mutableFlatBuffer, g, r10);
                }
                r10.g();
            }

            static {
                FbSerializerProvider.a(EventUpdateNotificationSubscriptionLevelMutationModel.class, new Serializer());
            }
        }

        public EventUpdateNotificationSubscriptionLevelMutationModel() {
            super(2);
        }

        @Nullable
        private String m18209a() {
            this.f17832d = super.a(this.f17832d, 0);
            return this.f17832d;
        }

        @Nullable
        private EventModel m18210j() {
            this.f17833e = (EventModel) super.a(this.f17833e, 1, EventModel.class);
            return this.f17833e;
        }

        public final int jK_() {
            return 941398836;
        }

        public final GraphQLVisitableModel m18212a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18210j() != null) {
                EventModel eventModel = (EventModel) r4.b(m18210j());
                if (m18210j() != eventModel) {
                    graphQLVisitableModel = (EventUpdateNotificationSubscriptionLevelMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17833e = eventModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18211a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = r4.b(m18209a());
            int a = ModelHelper.a(r4, m18210j());
            r4.c(2);
            r4.b(0, b);
            r4.b(1, a);
            i();
            return r4.d();
        }
    }
}
