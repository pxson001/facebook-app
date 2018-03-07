package com.facebook.timeline.widget.actionbar.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeInterfaces.ComposerTargetDataPrivacyScopeFields;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeModels.ComposerTargetDataPrivacyScopeFieldsModel;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeParsers.ComposerTargetDataPrivacyScopeFieldsParser;
import com.facebook.timeline.widget.actionbar.protocol.TimelineHeaderActionFieldsGraphQLInterfaces.TimelineHeaderActionFields;
import com.facebook.timeline.widget.actionbar.protocol.TimelineHeaderActionFieldsGraphQLParsers.TimelineHeaderActionFieldsParser;
import com.facebook.timeline.widget.actionbar.protocol.TimelineHeaderActionFieldsGraphQLParsers.TimelineHeaderActionFieldsParser.FriendsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: dataSourceNPE */
public class TimelineHeaderActionFieldsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1978017828)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: dataSourceNPE */
    public final class TimelineHeaderActionFieldsModel extends BaseModel implements GraphQLVisitableConsistentModel, TimelineHeaderActionFields {
        private boolean f17911d;
        private boolean f17912e;
        private boolean f17913f;
        private boolean f17914g;
        private boolean f17915h;
        private boolean f17916i;
        @Nullable
        private FriendsModel f17917j;
        @Nullable
        private GraphQLFriendshipStatus f17918k;
        private boolean f17919l;
        @Nullable
        private ComposerTargetDataPrivacyScopeFieldsModel f17920m;
        @Nullable
        private GraphQLSecondarySubscribeStatus f17921n;
        @Nullable
        private GraphQLSubscribeStatus f17922o;

        /* compiled from: dataSourceNPE */
        public final class Builder {
            public boolean f17898a;
            public boolean f17899b;
            public boolean f17900c;
            public boolean f17901d;
            public boolean f17902e;
            public boolean f17903f;
            @Nullable
            public FriendsModel f17904g;
            @Nullable
            public GraphQLFriendshipStatus f17905h;
            public boolean f17906i;
            @Nullable
            public ComposerTargetDataPrivacyScopeFieldsModel f17907j;
            @Nullable
            public GraphQLSecondarySubscribeStatus f17908k;
            @Nullable
            public GraphQLSubscribeStatus f17909l;

            public final TimelineHeaderActionFieldsModel m26427a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f17904g);
                int a2 = flatBufferBuilder.a(this.f17905h);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f17907j);
                int a4 = flatBufferBuilder.a(this.f17908k);
                int a5 = flatBufferBuilder.a(this.f17909l);
                flatBufferBuilder.c(12);
                flatBufferBuilder.a(0, this.f17898a);
                flatBufferBuilder.a(1, this.f17899b);
                flatBufferBuilder.a(2, this.f17900c);
                flatBufferBuilder.a(3, this.f17901d);
                flatBufferBuilder.a(4, this.f17902e);
                flatBufferBuilder.a(5, this.f17903f);
                flatBufferBuilder.b(6, a);
                flatBufferBuilder.b(7, a2);
                flatBufferBuilder.a(8, this.f17906i);
                flatBufferBuilder.b(9, a3);
                flatBufferBuilder.b(10, a4);
                flatBufferBuilder.b(11, a5);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new TimelineHeaderActionFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: dataSourceNPE */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineHeaderActionFieldsModel.class, new Deserializer());
            }

            public Object m26428a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TimelineHeaderActionFieldsParser.m26460a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object timelineHeaderActionFieldsModel = new TimelineHeaderActionFieldsModel();
                ((BaseModel) timelineHeaderActionFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (timelineHeaderActionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineHeaderActionFieldsModel).a();
                }
                return timelineHeaderActionFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: dataSourceNPE */
        public final class FriendsModel extends BaseModel implements GraphQLVisitableModel {
            private int f17910d;

            /* compiled from: dataSourceNPE */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendsModel.class, new Deserializer());
                }

                public Object m26429a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FriendsParser.m26458a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object friendsModel = new FriendsModel();
                    ((BaseModel) friendsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (friendsModel instanceof Postprocessable) {
                        return ((Postprocessable) friendsModel).a();
                    }
                    return friendsModel;
                }
            }

            /* compiled from: dataSourceNPE */
            public class Serializer extends JsonSerializer<FriendsModel> {
                public final void m26430a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendsModel friendsModel = (FriendsModel) obj;
                    if (friendsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendsModel.m26432a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FriendsParser.m26459a(friendsModel.w_(), friendsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(FriendsModel.class, new Serializer());
                }
            }

            public FriendsModel() {
                super(1);
            }

            public final int m26431a() {
                a(0, 0);
                return this.f17910d;
            }

            public final int jK_() {
                return 569028147;
            }

            public final GraphQLVisitableModel m26433a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m26432a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f17910d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m26434a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f17910d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: dataSourceNPE */
        public class Serializer extends JsonSerializer<TimelineHeaderActionFieldsModel> {
            public final void m26435a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TimelineHeaderActionFieldsModel timelineHeaderActionFieldsModel = (TimelineHeaderActionFieldsModel) obj;
                if (timelineHeaderActionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineHeaderActionFieldsModel.m26442a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineHeaderActionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = timelineHeaderActionFieldsModel.w_();
                int u_ = timelineHeaderActionFieldsModel.u_();
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(u_, 0);
                if (a) {
                    jsonGenerator.a("can_viewer_act_as_memorial_contact");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(u_, 1);
                if (a) {
                    jsonGenerator.a("can_viewer_block");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(u_, 2);
                if (a) {
                    jsonGenerator.a("can_viewer_message");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(u_, 3);
                if (a) {
                    jsonGenerator.a("can_viewer_poke");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(u_, 4);
                if (a) {
                    jsonGenerator.a("can_viewer_post");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(u_, 5);
                if (a) {
                    jsonGenerator.a("can_viewer_report");
                    jsonGenerator.a(a);
                }
                int g = mutableFlatBuffer.g(u_, 6);
                if (g != 0) {
                    jsonGenerator.a("friends");
                    FriendsParser.m26459a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 7) != 0) {
                    jsonGenerator.a("friendship_status");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 7));
                }
                a = mutableFlatBuffer.a(u_, 8);
                if (a) {
                    jsonGenerator.a("is_followed_by_everyone");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(u_, 9);
                if (g != 0) {
                    jsonGenerator.a("posted_item_privacy_scope");
                    ComposerTargetDataPrivacyScopeFieldsParser.m18319a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 10) != 0) {
                    jsonGenerator.a("secondary_subscribe_status");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 10));
                }
                if (mutableFlatBuffer.g(u_, 11) != 0) {
                    jsonGenerator.a("subscribe_status");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 11));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TimelineHeaderActionFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ FriendsModel dq_() {
            return m26444a();
        }

        @Nullable
        public final /* synthetic */ ComposerTargetDataPrivacyScopeFields mo1339l() {
            return m26457o();
        }

        public TimelineHeaderActionFieldsModel() {
            super(12);
        }

        public TimelineHeaderActionFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(12);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m26446a(String str, ConsistencyTuple consistencyTuple) {
            if ("can_viewer_message".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(mo1332d());
                consistencyTuple.b = u_();
                consistencyTuple.c = 2;
            } else if ("can_viewer_poke".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(do_());
                consistencyTuple.b = u_();
                consistencyTuple.c = 3;
            } else if ("can_viewer_post".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(mo1336g());
                consistencyTuple.b = u_();
                consistencyTuple.c = 4;
            } else if ("friendship_status".equals(str)) {
                consistencyTuple.a = mo1337j();
                consistencyTuple.b = u_();
                consistencyTuple.c = 7;
            } else if ("secondary_subscribe_status".equals(str)) {
                consistencyTuple.a = mo1340m();
                consistencyTuple.b = u_();
                consistencyTuple.c = 10;
            } else if ("subscribe_status".equals(str)) {
                consistencyTuple.a = mo1341n();
                consistencyTuple.b = u_();
                consistencyTuple.c = 11;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m26447a(String str, Object obj, boolean z) {
            if ("can_viewer_message".equals(str)) {
                m26439a(((Boolean) obj).booleanValue());
            } else if ("can_viewer_poke".equals(str)) {
                m26440b(((Boolean) obj).booleanValue());
            } else if ("can_viewer_post".equals(str)) {
                m26441c(((Boolean) obj).booleanValue());
            } else if ("friendship_status".equals(str)) {
                m26436a((GraphQLFriendshipStatus) obj);
            } else if ("secondary_subscribe_status".equals(str)) {
                m26437a((GraphQLSecondarySubscribeStatus) obj);
            } else if ("subscribe_status".equals(str)) {
                m26438a((GraphQLSubscribeStatus) obj);
            }
        }

        public final boolean mo1330b() {
            a(0, 0);
            return this.f17911d;
        }

        public final boolean mo1331c() {
            a(0, 1);
            return this.f17912e;
        }

        public final boolean mo1332d() {
            a(0, 2);
            return this.f17913f;
        }

        private void m26439a(boolean z) {
            this.f17913f = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 2, z);
            }
        }

        public final boolean do_() {
            a(0, 3);
            return this.f17914g;
        }

        private void m26440b(boolean z) {
            this.f17914g = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 3, z);
            }
        }

        public final boolean mo1336g() {
            a(0, 4);
            return this.f17915h;
        }

        private void m26441c(boolean z) {
            this.f17915h = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 4, z);
            }
        }

        public final boolean dp_() {
            a(0, 5);
            return this.f17916i;
        }

        @Nullable
        public final FriendsModel m26444a() {
            this.f17917j = (FriendsModel) super.a(this.f17917j, 6, FriendsModel.class);
            return this.f17917j;
        }

        @Nullable
        public final GraphQLFriendshipStatus mo1337j() {
            this.f17918k = (GraphQLFriendshipStatus) super.b(this.f17918k, 7, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17918k;
        }

        private void m26436a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
            this.f17918k = graphQLFriendshipStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 7, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
            }
        }

        public final boolean mo1338k() {
            a(1, 0);
            return this.f17919l;
        }

        @Nullable
        public final ComposerTargetDataPrivacyScopeFieldsModel m26457o() {
            this.f17920m = (ComposerTargetDataPrivacyScopeFieldsModel) super.a(this.f17920m, 9, ComposerTargetDataPrivacyScopeFieldsModel.class);
            return this.f17920m;
        }

        @Nullable
        public final GraphQLSecondarySubscribeStatus mo1340m() {
            this.f17921n = (GraphQLSecondarySubscribeStatus) super.b(this.f17921n, 10, GraphQLSecondarySubscribeStatus.class, GraphQLSecondarySubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17921n;
        }

        private void m26437a(GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus) {
            this.f17921n = graphQLSecondarySubscribeStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 10, graphQLSecondarySubscribeStatus != null ? graphQLSecondarySubscribeStatus.name() : null);
            }
        }

        @Nullable
        public final GraphQLSubscribeStatus mo1341n() {
            this.f17922o = (GraphQLSubscribeStatus) super.b(this.f17922o, 11, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17922o;
        }

        private void m26438a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
            this.f17922o = graphQLSubscribeStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 11, graphQLSubscribeStatus != null ? graphQLSubscribeStatus.name() : null);
            }
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m26443a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26444a() != null) {
                FriendsModel friendsModel = (FriendsModel) graphQLModelMutatingVisitor.b(m26444a());
                if (m26444a() != friendsModel) {
                    graphQLVisitableModel = (TimelineHeaderActionFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17917j = friendsModel;
                }
            }
            if (m26457o() != null) {
                ComposerTargetDataPrivacyScopeFieldsModel composerTargetDataPrivacyScopeFieldsModel = (ComposerTargetDataPrivacyScopeFieldsModel) graphQLModelMutatingVisitor.b(m26457o());
                if (m26457o() != composerTargetDataPrivacyScopeFieldsModel) {
                    graphQLVisitableModel = (TimelineHeaderActionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17920m = composerTargetDataPrivacyScopeFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26442a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26444a());
            int a2 = flatBufferBuilder.a(mo1337j());
            int a3 = ModelHelper.a(flatBufferBuilder, m26457o());
            int a4 = flatBufferBuilder.a(mo1340m());
            int a5 = flatBufferBuilder.a(mo1341n());
            flatBufferBuilder.c(12);
            flatBufferBuilder.a(0, this.f17911d);
            flatBufferBuilder.a(1, this.f17912e);
            flatBufferBuilder.a(2, this.f17913f);
            flatBufferBuilder.a(3, this.f17914g);
            flatBufferBuilder.a(4, this.f17915h);
            flatBufferBuilder.a(5, this.f17916i);
            flatBufferBuilder.b(6, a);
            flatBufferBuilder.b(7, a2);
            flatBufferBuilder.a(8, this.f17919l);
            flatBufferBuilder.b(9, a3);
            flatBufferBuilder.b(10, a4);
            flatBufferBuilder.b(11, a5);
            i();
            return flatBufferBuilder.d();
        }

        public final void m26445a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f17911d = mutableFlatBuffer.a(i, 0);
            this.f17912e = mutableFlatBuffer.a(i, 1);
            this.f17913f = mutableFlatBuffer.a(i, 2);
            this.f17914g = mutableFlatBuffer.a(i, 3);
            this.f17915h = mutableFlatBuffer.a(i, 4);
            this.f17916i = mutableFlatBuffer.a(i, 5);
            this.f17919l = mutableFlatBuffer.a(i, 8);
        }
    }
}
