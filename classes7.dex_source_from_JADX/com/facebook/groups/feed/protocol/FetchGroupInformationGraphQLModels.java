package com.facebook.groups.feed.protocol;

import com.facebook.annotationprocessors.transformer.api.Clone;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.dracula.api.DraculaHelper;
import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.api.FlatImplementation;
import com.facebook.dracula.api.FlatTuple;
import com.facebook.dracula.api.FlatWrapper;
import com.facebook.dracula.runtime.base.DraculaRuntime;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.graphql.enums.GraphQLAYMTNativeAction;
import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.graphql.enums.GraphQLGroupContentRestrictionReason;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupPostStatus;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLInterfaces.GroupPinnedPost;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLInterfaces.GroupSuggestionTips;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLInterfaces.GroupViewerInviteInformation;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLParsers.FetchGroupInformationParser;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLParsers.GroupHeaderInformationParser;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLParsers.GroupHeaderInformationParser.AdminAwareGroupParser;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLParsers.GroupHeaderInformationParser.GroupConfigsParser;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLParsers.GroupHeaderInformationParser.GroupConfigsParser.NodesParser;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLParsers.GroupPinnedPostParser;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLParsers.GroupPinnedPostParser.GroupPinnedStoriesParser;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLParsers.GroupSuggestionTipsParser;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLParsers.GroupSuggestionTipsParser.TipsChannelParser;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLParsers.GroupSuggestionTipsParser.TipsChannelParser.TipsParser;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLParsers.GroupSuggestionTipsParser.TipsChannelParser.TipsParser.ImageParser;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLParsers.GroupViewerInviteInformationParser;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLParsers.GroupViewerInviteInformationParser.ViewerInviteToGroupParser;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLParsers.GroupViewerInviteInformationParser.ViewerInviteToGroupParser.InviterParser;
import com.facebook.groups.grouppurposes.protocol.GroupPurposesInformationGraphQLModels.GroupPurposesInformationModel.GroupPurposesModel;
import com.facebook.groups.grouppurposes.protocol.GroupPurposesInformationGraphQLModels.GroupPurposesInformationModel.SuggestedPurposeModel;
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

/* compiled from: range1 */
public class FetchGroupInformationGraphQLModels {

    @FlatImplementation
    /* compiled from: range1 */
    public class DraculaImplementation {
        static void m6289a(MutableFlatBuffer mutableFlatBuffer, int i, int i2, GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            int l;
            switch (i2) {
                case -2017261931:
                case -1936855173:
                case -1165862818:
                case -1109949110:
                case -1075882755:
                case -768532715:
                case -583113886:
                case -543760752:
                case -340643170:
                case 1047719484:
                    return;
                case -1760113995:
                    l = mutableFlatBuffer.l(i, 2);
                    if (l != 0) {
                        m6291b(mutableFlatBuffer, l, 1047719484, graphQLModelMutatingVisitor);
                        return;
                    }
                    return;
                case -1627021799:
                    l = mutableFlatBuffer.l(i, 2);
                    if (l != 0) {
                        m6291b(mutableFlatBuffer, l, -583113886, graphQLModelMutatingVisitor);
                        return;
                    }
                    return;
                case -1509501023:
                    l = mutableFlatBuffer.l(i, 1);
                    if (l != 0) {
                        m6292c(mutableFlatBuffer, l, -1760113995, graphQLModelMutatingVisitor);
                        return;
                    }
                    return;
                case -694926303:
                    l = mutableFlatBuffer.l(i, 0);
                    if (l != 0) {
                        m6291b(mutableFlatBuffer, l, -1627021799, graphQLModelMutatingVisitor);
                        return;
                    }
                    return;
                case 291056794:
                    l = mutableFlatBuffer.l(i, 0);
                    if (l != 0) {
                        m6291b(mutableFlatBuffer, l, -768532715, graphQLModelMutatingVisitor);
                    }
                    l = mutableFlatBuffer.l(i, 1);
                    if (l != 0) {
                        m6291b(mutableFlatBuffer, l, -694926303, graphQLModelMutatingVisitor);
                    }
                    l = mutableFlatBuffer.l(i, 3);
                    if (l != 0) {
                        m6291b(mutableFlatBuffer, l, 462410863, graphQLModelMutatingVisitor);
                    }
                    l = mutableFlatBuffer.l(i, 4);
                    if (l != 0) {
                        m6291b(mutableFlatBuffer, l, -1509501023, graphQLModelMutatingVisitor);
                    }
                    l = mutableFlatBuffer.l(i, 6);
                    if (l != 0) {
                        m6291b(mutableFlatBuffer, l, -2017261931, graphQLModelMutatingVisitor);
                    }
                    l = mutableFlatBuffer.l(i, 7);
                    if (l != 0) {
                        m6291b(mutableFlatBuffer, l, -1075882755, graphQLModelMutatingVisitor);
                    }
                    l = mutableFlatBuffer.l(i, 8);
                    if (l != 0) {
                        m6291b(mutableFlatBuffer, l, -543760752, graphQLModelMutatingVisitor);
                    }
                    l = mutableFlatBuffer.l(i, 9);
                    if (l != 0) {
                        m6291b(mutableFlatBuffer, l, -340643170, graphQLModelMutatingVisitor);
                    }
                    l = mutableFlatBuffer.l(i, 14);
                    if (l != 0) {
                        m6291b(mutableFlatBuffer, l, -1109949110, graphQLModelMutatingVisitor);
                    }
                    l = mutableFlatBuffer.l(i, 18);
                    if (l != 0) {
                        m6291b(mutableFlatBuffer, l, -1936855173, graphQLModelMutatingVisitor);
                        return;
                    }
                    return;
                case 462410863:
                    l = mutableFlatBuffer.l(i, 0);
                    if (l != 0) {
                        m6292c(mutableFlatBuffer, l, -1165862818, graphQLModelMutatingVisitor);
                        return;
                    }
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        private static void m6291b(MutableFlatBuffer mutableFlatBuffer, int i, int i2, GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            if (i != 0) {
                DraculaWrapper draculaWrapper = new DraculaWrapper(mutableFlatBuffer, i, i2);
                if (((DraculaWrapper) graphQLModelMutatingVisitor.b(draculaWrapper)) != draculaWrapper) {
                    throw new UnsupportedOperationException();
                }
            }
        }

        private static void m6292c(MutableFlatBuffer mutableFlatBuffer, int i, int i2, GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            int d = mutableFlatBuffer.d(i);
            for (int i3 = 0; i3 < d; i3++) {
                m6291b(mutableFlatBuffer, mutableFlatBuffer.m(i, i3), i2, graphQLModelMutatingVisitor);
            }
        }

        public static int m6288a(MutableFlatBuffer mutableFlatBuffer, int i, int i2, FlatBufferBuilder flatBufferBuilder) {
            if (i == 0) {
                return 0;
            }
            int a;
            int a2;
            int a3;
            int b;
            switch (i2) {
                case -2017261931:
                    a = mutableFlatBuffer.a(i, 0, 0);
                    a2 = mutableFlatBuffer.a(i, 1, 0);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, a, 0);
                    flatBufferBuilder.a(1, a2, 0);
                    return flatBufferBuilder.d();
                case -1936855173:
                    a = flatBufferBuilder.b(mutableFlatBuffer.c(i, 0));
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    return flatBufferBuilder.d();
                case -1760113995:
                    boolean a4 = mutableFlatBuffer.a(i, 0);
                    a2 = flatBufferBuilder.b(mutableFlatBuffer.c(i, 1));
                    a3 = m6288a(mutableFlatBuffer, mutableFlatBuffer.l(i, 2), 1047719484, flatBufferBuilder);
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.a(0, a4);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.b(2, a3);
                    return flatBufferBuilder.d();
                case -1627021799:
                    a = flatBufferBuilder.b(mutableFlatBuffer.c(i, 0));
                    a2 = flatBufferBuilder.b(mutableFlatBuffer.c(i, 1));
                    a3 = m6288a(mutableFlatBuffer, mutableFlatBuffer.l(i, 2), -583113886, flatBufferBuilder);
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.b(2, a3);
                    return flatBufferBuilder.d();
                case -1509501023:
                    a = mutableFlatBuffer.a(i, 0, 0);
                    a2 = m6290b(mutableFlatBuffer, mutableFlatBuffer.l(i, 1), -1760113995, flatBufferBuilder);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, a, 0);
                    flatBufferBuilder.b(1, a2);
                    return flatBufferBuilder.d();
                case -1165862818:
                    a = flatBufferBuilder.b(mutableFlatBuffer.c(i, 0));
                    a2 = flatBufferBuilder.b(mutableFlatBuffer.c(i, 1));
                    a3 = flatBufferBuilder.b(mutableFlatBuffer.c(i, 2));
                    b = flatBufferBuilder.b(mutableFlatBuffer.c(i, 3));
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.b(2, a3);
                    flatBufferBuilder.b(3, b);
                    return flatBufferBuilder.d();
                case -1109949110:
                    a = flatBufferBuilder.b(mutableFlatBuffer.c(i, 0));
                    a2 = flatBufferBuilder.b(mutableFlatBuffer.c(i, 1));
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    return flatBufferBuilder.d();
                case -1075882755:
                    a = mutableFlatBuffer.a(i, 0, 0);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, a, 0);
                    return flatBufferBuilder.d();
                case -768532715:
                    a = flatBufferBuilder.b(mutableFlatBuffer.c(i, 0));
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    return flatBufferBuilder.d();
                case -694926303:
                    a = m6288a(mutableFlatBuffer, mutableFlatBuffer.l(i, 0), -1627021799, flatBufferBuilder);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    return flatBufferBuilder.d();
                case -583113886:
                    a = flatBufferBuilder.b(mutableFlatBuffer.c(i, 0));
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    return flatBufferBuilder.d();
                case -543760752:
                    a = mutableFlatBuffer.a(i, 0, 0);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, a, 0);
                    return flatBufferBuilder.d();
                case -340643170:
                    a = mutableFlatBuffer.a(i, 0, 0);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, a, 0);
                    return flatBufferBuilder.d();
                case 291056794:
                    a = m6288a(mutableFlatBuffer, mutableFlatBuffer.l(i, 0), -768532715, flatBufferBuilder);
                    a2 = m6288a(mutableFlatBuffer, mutableFlatBuffer.l(i, 1), -694926303, flatBufferBuilder);
                    a3 = flatBufferBuilder.b(mutableFlatBuffer.c(i, 2));
                    b = m6288a(mutableFlatBuffer, mutableFlatBuffer.l(i, 3), 462410863, flatBufferBuilder);
                    int a5 = m6288a(mutableFlatBuffer, mutableFlatBuffer.l(i, 4), -1509501023, flatBufferBuilder);
                    int a6 = mutableFlatBuffer.a(i, 5, 0);
                    int a7 = m6288a(mutableFlatBuffer, mutableFlatBuffer.l(i, 6), -2017261931, flatBufferBuilder);
                    int a8 = m6288a(mutableFlatBuffer, mutableFlatBuffer.l(i, 7), -1075882755, flatBufferBuilder);
                    int a9 = m6288a(mutableFlatBuffer, mutableFlatBuffer.l(i, 8), -543760752, flatBufferBuilder);
                    int a10 = m6288a(mutableFlatBuffer, mutableFlatBuffer.l(i, 9), -340643170, flatBufferBuilder);
                    boolean a11 = mutableFlatBuffer.a(i, 10);
                    int b2 = flatBufferBuilder.b(mutableFlatBuffer.c(i, 11));
                    boolean a12 = mutableFlatBuffer.a(i, 12);
                    int b3 = flatBufferBuilder.b(mutableFlatBuffer.c(i, 13));
                    int a13 = m6288a(mutableFlatBuffer, mutableFlatBuffer.l(i, 14), -1109949110, flatBufferBuilder);
                    int b4 = flatBufferBuilder.b(mutableFlatBuffer.c(i, 15));
                    int d = flatBufferBuilder.d(ImmutableListHelper.a(mutableFlatBuffer.c(i, 16, GraphQLGroupContentRestrictionReason.class)));
                    int a14 = flatBufferBuilder.a(GraphQLGroupVisibility.fromString(mutableFlatBuffer.b(i, 17)));
                    int a15 = m6288a(mutableFlatBuffer, mutableFlatBuffer.l(i, 18), -1936855173, flatBufferBuilder);
                    flatBufferBuilder.c(19);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.b(2, a3);
                    flatBufferBuilder.b(3, b);
                    flatBufferBuilder.b(4, a5);
                    flatBufferBuilder.a(5, a6, 0);
                    flatBufferBuilder.b(6, a7);
                    flatBufferBuilder.b(7, a8);
                    flatBufferBuilder.b(8, a9);
                    flatBufferBuilder.b(9, a10);
                    flatBufferBuilder.a(10, a11);
                    flatBufferBuilder.b(11, b2);
                    flatBufferBuilder.a(12, a12);
                    flatBufferBuilder.b(13, b3);
                    flatBufferBuilder.b(14, a13);
                    flatBufferBuilder.b(15, b4);
                    flatBufferBuilder.b(16, d);
                    flatBufferBuilder.b(17, a14);
                    flatBufferBuilder.b(18, a15);
                    return flatBufferBuilder.d();
                case 462410863:
                    a = m6290b(mutableFlatBuffer, mutableFlatBuffer.l(i, 0), -1165862818, flatBufferBuilder);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    return flatBufferBuilder.d();
                case 1047719484:
                    a = flatBufferBuilder.b(mutableFlatBuffer.c(i, 0));
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    return flatBufferBuilder.d();
                default:
                    throw new IllegalArgumentException();
            }
        }

        private static int m6290b(MutableFlatBuffer mutableFlatBuffer, int i, int i2, FlatBufferBuilder flatBufferBuilder) {
            int c = mutableFlatBuffer.c(i);
            int[] iArr = c == 0 ? null : new int[c];
            for (int i3 = 0; i3 < c; i3++) {
                iArr[i3] = m6288a(mutableFlatBuffer, mutableFlatBuffer.m(i, i3), i2, flatBufferBuilder);
            }
            return flatBufferBuilder.a(iArr, true);
        }
    }

    @FlatWrapper(implementation = DraculaImplementation.class)
    /* compiled from: range1 */
    public class DraculaWrapper extends FlatTuple implements MutableFlattenable, GraphQLVisitableModel, Cloneable {
        public DraculaWrapper(MutableFlatBuffer mutableFlatBuffer, int i, int i2) {
            super(mutableFlatBuffer, i, i2);
        }

        public static DraculaWrapper m6293a(MutableFlatBuffer mutableFlatBuffer, int i, int i2) {
            return new DraculaWrapper(mutableFlatBuffer, i, i2);
        }

        public Object clone() {
            MutableFlatBuffer mutableFlatBuffer = this.a;
            int i = this.b;
            int i2 = this.c;
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(100);
            int a = DraculaImplementation.m6288a(mutableFlatBuffer, i, i2, flatBufferBuilder);
            flatBufferBuilder.d(a);
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new DraculaWrapper(new MutableFlatBuffer(wrap, null, null, false, null), a, i2);
        }

        public final int jK_() {
            return this.c;
        }

        public final GraphQLVisitableModel m6295a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DraculaImplementation.m6289a(this.a, this.b, this.c, graphQLModelMutatingVisitor);
            return this;
        }

        @Nullable
        public final MutableFlatBuffer w_() {
            return this.a;
        }

        public final int u_() {
            return this.b;
        }

        public final int A_() {
            return this.c;
        }

        public final int m6294a(FlatBufferBuilder flatBufferBuilder) {
            return DraculaImplementation.m6288a(this.a, this.b, this.c, flatBufferBuilder);
        }

        public final void m6296a(MutableFlatBuffer mutableFlatBuffer, int i) {
            throw new UnsupportedOperationException();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 642273895)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: range1 */
    public final class FetchGroupInformationModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, FetchGroupInformationGraphQLInterfaces$FetchGroupInformation$ {
        @Nullable
        private MutableFlatBuffer f5542d;
        @Nullable
        private int f5543e;
        @Nullable
        private int f5544f;
        private boolean f5545g;
        @Nullable
        private GroupConfigsModel f5546h;
        @Nullable
        private GroupPinnedStoriesModel f5547i;
        @Nullable
        private GroupPurposesModel f5548j;
        @Nullable
        private GroupSellConfigModel f5549k;
        @Nullable
        private String f5550l;
        private boolean f5551m;
        @Nullable
        private GraphQLSubscribeStatus f5552n;
        @Nullable
        private SuggestedPurposeModel f5553o;
        @Nullable
        private TipsChannelModel f5554p;
        @Nullable
        private GraphQLGroupAdminType f5555q;
        @Nullable
        private ViewerInviteToGroupModel f5556r;
        @Nullable
        private GraphQLGroupJoinState f5557s;
        @Nullable
        private GraphQLGroupPostStatus f5558t;

        /* compiled from: range1 */
        public final class Builder {
            @Clone(from = "adminAwareGroup", processor = "com.facebook.dracula.transformer.Transformer")
            @Nullable
            public MutableFlatBuffer f5525a;
            @Clone(from = "adminAwareGroup", processor = "com.facebook.dracula.transformer.Transformer")
            @Nullable
            public int f5526b;
            @Clone(from = "adminAwareGroup", processor = "com.facebook.dracula.transformer.Transformer")
            @Nullable
            public int f5527c;
            public boolean f5528d;
            @Nullable
            public GroupConfigsModel f5529e;
            @Nullable
            public GroupPinnedStoriesModel f5530f;
            @Nullable
            public GroupPurposesModel f5531g;
            @Nullable
            public GroupSellConfigModel f5532h;
            @Nullable
            public String f5533i;
            public boolean f5534j;
            @Nullable
            public GraphQLSubscribeStatus f5535k;
            @Nullable
            public SuggestedPurposeModel f5536l;
            @Nullable
            public TipsChannelModel f5537m;
            @Nullable
            public GraphQLGroupAdminType f5538n;
            @Nullable
            public ViewerInviteToGroupModel f5539o;
            @Nullable
            public GraphQLGroupJoinState f5540p;
            @Nullable
            public GraphQLGroupPostStatus f5541q;

            public static Builder m6297a(FetchGroupInformationModel fetchGroupInformationModel) {
                Builder builder = new Builder();
                DraculaReturnValue b = fetchGroupInformationModel.mo289b();
                MutableFlatBuffer mutableFlatBuffer = b.a;
                int i = b.b;
                int i2 = b.c;
                builder.f5525a = mutableFlatBuffer;
                builder.f5526b = i;
                builder.f5527c = i2;
                builder.f5528d = fetchGroupInformationModel.mo290c();
                builder.f5529e = fetchGroupInformationModel.m6324r();
                builder.f5530f = fetchGroupInformationModel.m6325s();
                builder.f5531g = fetchGroupInformationModel.m6326t();
                builder.f5532h = fetchGroupInformationModel.m6327u();
                builder.f5533i = fetchGroupInformationModel.gW_();
                builder.f5534j = fetchGroupInformationModel.mo296j();
                builder.f5535k = fetchGroupInformationModel.mo297k();
                builder.f5536l = fetchGroupInformationModel.m6328v();
                builder.f5537m = fetchGroupInformationModel.m6329w();
                builder.f5538n = fetchGroupInformationModel.mo287n();
                builder.f5539o = fetchGroupInformationModel.m6330x();
                builder.f5540p = fetchGroupInformationModel.mo288p();
                builder.f5541q = fetchGroupInformationModel.mo301q();
                return builder;
            }

            @Clone(from = "adminAwareGroup", processor = "com.facebook.dracula.transformer.Transformer")
            public final Builder m6298a(@Nullable MutableFlatBuffer mutableFlatBuffer, @Nullable int i, @Nullable int i2) {
                this.f5525a = mutableFlatBuffer;
                this.f5526b = i;
                this.f5527c = i2;
                return this;
            }

            public final Builder m6299a(@Nullable String str) {
                this.f5533i = str;
                return this;
            }

            public final FetchGroupInformationModel m6300a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, DraculaWrapper.m6293a(this.f5525a, this.f5526b, this.f5527c));
                int a2 = ModelHelper.a(flatBufferBuilder, this.f5529e);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f5530f);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f5531g);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f5532h);
                int b = flatBufferBuilder.b(this.f5533i);
                int a6 = flatBufferBuilder.a(this.f5535k);
                int a7 = ModelHelper.a(flatBufferBuilder, this.f5536l);
                int a8 = ModelHelper.a(flatBufferBuilder, this.f5537m);
                int a9 = flatBufferBuilder.a(this.f5538n);
                int a10 = ModelHelper.a(flatBufferBuilder, this.f5539o);
                int a11 = flatBufferBuilder.a(this.f5540p);
                int a12 = flatBufferBuilder.a(this.f5541q);
                flatBufferBuilder.c(15);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f5528d);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, a3);
                flatBufferBuilder.b(4, a4);
                flatBufferBuilder.b(5, a5);
                flatBufferBuilder.b(6, b);
                flatBufferBuilder.a(7, this.f5534j);
                flatBufferBuilder.b(8, a6);
                flatBufferBuilder.b(9, a7);
                flatBufferBuilder.b(10, a8);
                flatBufferBuilder.b(11, a9);
                flatBufferBuilder.b(12, a10);
                flatBufferBuilder.b(13, a11);
                flatBufferBuilder.b(14, a12);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new FetchGroupInformationModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: range1 */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchGroupInformationModel.class, new Deserializer());
            }

            public Object m6301a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FetchGroupInformationParser.m6442a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fetchGroupInformationModel = new FetchGroupInformationModel();
                ((BaseModel) fetchGroupInformationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fetchGroupInformationModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchGroupInformationModel).a();
                }
                return fetchGroupInformationModel;
            }
        }

        /* compiled from: range1 */
        public class Serializer extends JsonSerializer<FetchGroupInformationModel> {
            public final void m6302a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FetchGroupInformationModel fetchGroupInformationModel = (FetchGroupInformationModel) obj;
                if (fetchGroupInformationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchGroupInformationModel.m6306a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchGroupInformationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FetchGroupInformationParser.m6443a(fetchGroupInformationModel.w_(), fetchGroupInformationModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FetchGroupInformationModel.class, new Serializer());
            }
        }

        @Clone(from = "getGroupConfigs", processor = "com.facebook.dracula.transformer.Transformer")
        @Nullable
        public final /* synthetic */ GroupConfigsModel mo291d() {
            return m6324r();
        }

        @Nullable
        public final /* synthetic */ GroupPurposesModel mo292g() {
            return m6326t();
        }

        @Nullable
        public final /* synthetic */ GroupSellConfigModel gX_() {
            return m6327u();
        }

        @Nullable
        public final /* synthetic */ GroupPinnedStoriesModel gY_() {
            return m6325s();
        }

        @Nullable
        public final /* synthetic */ SuggestedPurposeModel mo298l() {
            return m6328v();
        }

        @Nullable
        public final /* synthetic */ TipsChannelModel mo299m() {
            return m6329w();
        }

        @Nullable
        public final /* synthetic */ ViewerInviteToGroupModel mo300o() {
            return m6330x();
        }

        public FetchGroupInformationModel() {
            super(15);
        }

        public FetchGroupInformationModel(MutableFlatBuffer mutableFlatBuffer) {
            super(15);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m6310a(String str, ConsistencyTuple consistencyTuple) {
            if ("subscribe_status".equals(str)) {
                consistencyTuple.a = mo297k();
                consistencyTuple.b = u_();
                consistencyTuple.c = 8;
            } else if ("viewer_join_state".equals(str)) {
                consistencyTuple.a = mo288p();
                consistencyTuple.b = u_();
                consistencyTuple.c = 13;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m6311a(String str, Object obj, boolean z) {
            if ("subscribe_status".equals(str)) {
                m6305a((GraphQLSubscribeStatus) obj);
            } else if ("viewer_join_state".equals(str)) {
                m6304a((GraphQLGroupJoinState) obj);
            }
        }

        @Clone(from = "getAdminAwareGroup", processor = "com.facebook.dracula.transformer.Transformer")
        @Nullable
        public final DraculaReturnValue mo289b() {
            DraculaReturnValue a = DraculaHelper.a(this.f5542d, this.f5543e, this.f5544f, w_(), u_(), 0, 291056794);
            MutableFlatBuffer mutableFlatBuffer = a.a;
            int i = a.b;
            int i2 = a.c;
            this.f5542d = mutableFlatBuffer;
            this.f5543e = i;
            this.f5544f = i2;
            return DraculaReturnValue.a(this.f5542d, this.f5543e, this.f5544f);
        }

        public final boolean mo290c() {
            a(0, 1);
            return this.f5545g;
        }

        @Clone(from = "getGroupConfigs", processor = "com.facebook.dracula.transformer.Transformer")
        @Nullable
        public final GroupConfigsModel m6324r() {
            this.f5546h = (GroupConfigsModel) super.a(this.f5546h, 2, GroupConfigsModel.class);
            return this.f5546h;
        }

        @Nullable
        public final GroupPinnedStoriesModel m6325s() {
            this.f5547i = (GroupPinnedStoriesModel) super.a(this.f5547i, 3, GroupPinnedStoriesModel.class);
            return this.f5547i;
        }

        @Nullable
        public final GroupPurposesModel m6326t() {
            this.f5548j = (GroupPurposesModel) super.a(this.f5548j, 4, GroupPurposesModel.class);
            return this.f5548j;
        }

        @Nullable
        public final GroupSellConfigModel m6327u() {
            this.f5549k = (GroupSellConfigModel) super.a(this.f5549k, 5, GroupSellConfigModel.class);
            return this.f5549k;
        }

        @Nullable
        public final String gW_() {
            this.f5550l = super.a(this.f5550l, 6);
            return this.f5550l;
        }

        public final boolean mo296j() {
            a(0, 7);
            return this.f5551m;
        }

        @Nullable
        public final GraphQLSubscribeStatus mo297k() {
            this.f5552n = (GraphQLSubscribeStatus) super.b(this.f5552n, 8, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5552n;
        }

        private void m6305a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
            this.f5552n = graphQLSubscribeStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 8, graphQLSubscribeStatus != null ? graphQLSubscribeStatus.name() : null);
            }
        }

        @Nullable
        public final SuggestedPurposeModel m6328v() {
            this.f5553o = (SuggestedPurposeModel) super.a(this.f5553o, 9, SuggestedPurposeModel.class);
            return this.f5553o;
        }

        @Nullable
        public final TipsChannelModel m6329w() {
            this.f5554p = (TipsChannelModel) super.a(this.f5554p, 10, TipsChannelModel.class);
            return this.f5554p;
        }

        @Nullable
        public final GraphQLGroupAdminType mo287n() {
            this.f5555q = (GraphQLGroupAdminType) super.b(this.f5555q, 11, GraphQLGroupAdminType.class, GraphQLGroupAdminType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5555q;
        }

        @Nullable
        public final ViewerInviteToGroupModel m6330x() {
            this.f5556r = (ViewerInviteToGroupModel) super.a(this.f5556r, 12, ViewerInviteToGroupModel.class);
            return this.f5556r;
        }

        @Nullable
        public final GraphQLGroupJoinState mo288p() {
            this.f5557s = (GraphQLGroupJoinState) super.b(this.f5557s, 13, GraphQLGroupJoinState.class, GraphQLGroupJoinState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5557s;
        }

        private void m6304a(GraphQLGroupJoinState graphQLGroupJoinState) {
            this.f5557s = graphQLGroupJoinState;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 13, graphQLGroupJoinState != null ? graphQLGroupJoinState.name() : null);
            }
        }

        @Nullable
        public final GraphQLGroupPostStatus mo301q() {
            this.f5558t = (GraphQLGroupPostStatus) super.b(this.f5558t, 14, GraphQLGroupPostStatus.class, GraphQLGroupPostStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5558t;
        }

        @Clone(from = "fromInterface", processor = "com.facebook.dracula.transformer.Transformer")
        public static FetchGroupInformationModel m6303a(FetchGroupInformationGraphQLInterfaces$FetchGroupInformation$ fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$) {
            if (fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$ == null) {
                return null;
            }
            if (fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$ instanceof FetchGroupInformationModel) {
                return (FetchGroupInformationModel) fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$;
            }
            Builder builder = new Builder();
            DraculaReturnValue b = fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.mo289b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            builder.f5525a = mutableFlatBuffer;
            builder.f5526b = i;
            builder.f5527c = i2;
            builder.f5528d = fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.mo290c();
            builder.f5529e = GroupConfigsModel.m6341a(fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.mo291d());
            builder.f5530f = GroupPinnedStoriesModel.m6366a(fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.gY_());
            builder.f5531g = GroupPurposesModel.m7014a(fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.mo292g());
            builder.f5532h = GroupSellConfigModel.m6150a(fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.gX_());
            builder.f5533i = fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.gW_();
            builder.f5534j = fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.mo296j();
            builder.f5535k = fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.mo297k();
            builder.f5536l = SuggestedPurposeModel.m7021a(fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.mo298l());
            builder.f5537m = TipsChannelModel.m6405a(fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.mo299m());
            builder.f5538n = fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.mo287n();
            builder.f5539o = ViewerInviteToGroupModel.m6430a(fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.mo300o());
            builder.f5540p = fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.mo288p();
            builder.f5541q = fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.mo301q();
            return builder.m6300a();
        }

        @Nullable
        public final String m6308a() {
            return gW_();
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m6307a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            DraculaReturnValue b = mo289b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            if (!DraculaRuntime.a(mutableFlatBuffer, i, null, 0)) {
                b = mo289b();
                FlatTuple flatTuple = (FlatTuple) graphQLModelMutatingVisitor.b(DraculaWrapper.m6293a(b.a, b.b, b.c));
                mutableFlatBuffer = flatTuple.a;
                i = flatTuple.b;
                int i3 = flatTuple.c;
                b = mo289b();
                MutableFlatBuffer mutableFlatBuffer2 = b.a;
                int i4 = b.b;
                i2 = b.c;
                if (!DraculaRuntime.a(mutableFlatBuffer2, i4, mutableFlatBuffer, i)) {
                    FetchGroupInformationModel fetchGroupInformationModel = (FetchGroupInformationModel) ModelHelper.a(null, this);
                    fetchGroupInformationModel.f5542d = mutableFlatBuffer;
                    fetchGroupInformationModel.f5543e = i;
                    fetchGroupInformationModel.f5544f = i3;
                    graphQLVisitableModel = fetchGroupInformationModel;
                }
            }
            if (m6324r() != null) {
                GroupConfigsModel groupConfigsModel = (GroupConfigsModel) graphQLModelMutatingVisitor.b(m6324r());
                if (m6324r() != groupConfigsModel) {
                    graphQLVisitableModel = (FetchGroupInformationModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5546h = groupConfigsModel;
                }
            }
            if (m6325s() != null) {
                GroupPinnedStoriesModel groupPinnedStoriesModel = (GroupPinnedStoriesModel) graphQLModelMutatingVisitor.b(m6325s());
                if (m6325s() != groupPinnedStoriesModel) {
                    graphQLVisitableModel = (FetchGroupInformationModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5547i = groupPinnedStoriesModel;
                }
            }
            if (m6326t() != null) {
                GroupPurposesModel groupPurposesModel = (GroupPurposesModel) graphQLModelMutatingVisitor.b(m6326t());
                if (m6326t() != groupPurposesModel) {
                    graphQLVisitableModel = (FetchGroupInformationModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5548j = groupPurposesModel;
                }
            }
            if (m6327u() != null) {
                GroupSellConfigModel groupSellConfigModel = (GroupSellConfigModel) graphQLModelMutatingVisitor.b(m6327u());
                if (m6327u() != groupSellConfigModel) {
                    graphQLVisitableModel = (FetchGroupInformationModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5549k = groupSellConfigModel;
                }
            }
            if (m6328v() != null) {
                SuggestedPurposeModel suggestedPurposeModel = (SuggestedPurposeModel) graphQLModelMutatingVisitor.b(m6328v());
                if (m6328v() != suggestedPurposeModel) {
                    graphQLVisitableModel = (FetchGroupInformationModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5553o = suggestedPurposeModel;
                }
            }
            if (m6329w() != null) {
                TipsChannelModel tipsChannelModel = (TipsChannelModel) graphQLModelMutatingVisitor.b(m6329w());
                if (m6329w() != tipsChannelModel) {
                    graphQLVisitableModel = (FetchGroupInformationModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5554p = tipsChannelModel;
                }
            }
            if (m6330x() != null) {
                ViewerInviteToGroupModel viewerInviteToGroupModel = (ViewerInviteToGroupModel) graphQLModelMutatingVisitor.b(m6330x());
                if (m6330x() != viewerInviteToGroupModel) {
                    graphQLVisitableModel = (FetchGroupInformationModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5556r = viewerInviteToGroupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6306a(FlatBufferBuilder flatBufferBuilder) {
            h();
            DraculaReturnValue b = mo289b();
            int a = ModelHelper.a(flatBufferBuilder, DraculaWrapper.m6293a(b.a, b.b, b.c));
            int a2 = ModelHelper.a(flatBufferBuilder, m6324r());
            int a3 = ModelHelper.a(flatBufferBuilder, m6325s());
            int a4 = ModelHelper.a(flatBufferBuilder, m6326t());
            int a5 = ModelHelper.a(flatBufferBuilder, m6327u());
            int b2 = flatBufferBuilder.b(gW_());
            int a6 = flatBufferBuilder.a(mo297k());
            int a7 = ModelHelper.a(flatBufferBuilder, m6328v());
            int a8 = ModelHelper.a(flatBufferBuilder, m6329w());
            int a9 = flatBufferBuilder.a(mo287n());
            int a10 = ModelHelper.a(flatBufferBuilder, m6330x());
            int a11 = flatBufferBuilder.a(mo288p());
            int a12 = flatBufferBuilder.a(mo301q());
            flatBufferBuilder.c(15);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f5545g);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, b2);
            flatBufferBuilder.a(7, this.f5551m);
            flatBufferBuilder.b(8, a6);
            flatBufferBuilder.b(9, a7);
            flatBufferBuilder.b(10, a8);
            flatBufferBuilder.b(11, a9);
            flatBufferBuilder.b(12, a10);
            flatBufferBuilder.b(13, a11);
            flatBufferBuilder.b(14, a12);
            i();
            return flatBufferBuilder.d();
        }

        public final void m6309a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f5545g = mutableFlatBuffer.a(i, 1);
            this.f5551m = mutableFlatBuffer.a(i, 7);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1398545333)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: range1 */
    public final class GroupHeaderInformationModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, FetchGroupInformationGraphQLInterfaces$GroupHeaderInformation$ {
        @Nullable
        private MutableFlatBuffer f5563d;
        @Nullable
        private int f5564e;
        @Nullable
        private int f5565f;
        @Nullable
        private GroupConfigsModel f5566g;
        @Nullable
        private String f5567h;

        /* compiled from: range1 */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupHeaderInformationModel.class, new Deserializer());
            }

            public Object m6331a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupHeaderInformationParser.m6468a(jsonParser);
                Object groupHeaderInformationModel = new GroupHeaderInformationModel();
                ((BaseModel) groupHeaderInformationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupHeaderInformationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupHeaderInformationModel).a();
                }
                return groupHeaderInformationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1295419258)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: range1 */
        public final class GroupConfigsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f5562d;

            /* compiled from: range1 */
            public final class Builder {
                @Nullable
                public ImmutableList<NodesModel> f5559a;
            }

            /* compiled from: range1 */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupConfigsModel.class, new Deserializer());
                }

                public Object m6332a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupConfigsParser.m6466a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupConfigsModel = new GroupConfigsModel();
                    ((BaseModel) groupConfigsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupConfigsModel instanceof Postprocessable) {
                        return ((Postprocessable) groupConfigsModel).a();
                    }
                    return groupConfigsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -652403208)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: range1 */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                private boolean f5561d;

                /* compiled from: range1 */
                public final class Builder {
                    public boolean f5560a;
                }

                /* compiled from: range1 */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m6333a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m6465b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                /* compiled from: range1 */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m6334a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m6336a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m6464a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(1);
                }

                public NodesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final boolean m6339a() {
                    a(0, 0);
                    return this.f5561d;
                }

                @Clone(from = "fromInterface", processor = "com.facebook.dracula.transformer.Transformer")
                public static NodesModel m6335a(NodesModel nodesModel) {
                    if (nodesModel == null) {
                        return null;
                    }
                    if (nodesModel instanceof NodesModel) {
                        return nodesModel;
                    }
                    Builder builder = new Builder();
                    builder.f5560a = nodesModel.m6339a();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, builder.f5560a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new NodesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return -1563253546;
                }

                public final GraphQLVisitableModel m6337a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m6336a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f5561d);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m6338a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f5561d = mutableFlatBuffer.a(i, 0);
                }
            }

            /* compiled from: range1 */
            public class Serializer extends JsonSerializer<GroupConfigsModel> {
                public final void m6340a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupConfigsModel groupConfigsModel = (GroupConfigsModel) obj;
                    if (groupConfigsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupConfigsModel.m6342a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupConfigsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupConfigsParser.m6467a(groupConfigsModel.w_(), groupConfigsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupConfigsModel.class, new Serializer());
                }
            }

            public GroupConfigsModel() {
                super(1);
            }

            public GroupConfigsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nonnull
            @Clone(from = "getNodes", processor = "com.facebook.dracula.transformer.Transformer")
            public final ImmutableList<NodesModel> m6344a() {
                this.f5562d = super.a(this.f5562d, 0, NodesModel.class);
                return (ImmutableList) this.f5562d;
            }

            @Clone(from = "fromInterface", processor = "com.facebook.dracula.transformer.Transformer")
            public static GroupConfigsModel m6341a(GroupConfigsModel groupConfigsModel) {
                if (groupConfigsModel == null) {
                    return null;
                }
                if (groupConfigsModel instanceof GroupConfigsModel) {
                    return groupConfigsModel;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < groupConfigsModel.m6344a().size(); i++) {
                    builder2.c(NodesModel.m6335a((NodesModel) groupConfigsModel.m6344a().get(i)));
                }
                builder.f5559a = builder2.b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f5559a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new GroupConfigsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 1737120378;
            }

            public final GraphQLVisitableModel m6343a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6344a() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m6344a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (GroupConfigsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5562d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6342a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6344a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: range1 */
        public class Serializer extends JsonSerializer<GroupHeaderInformationModel> {
            public final void m6345a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupHeaderInformationModel groupHeaderInformationModel = (GroupHeaderInformationModel) obj;
                if (groupHeaderInformationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupHeaderInformationModel.m6349a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupHeaderInformationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupHeaderInformationModel.w_();
                int u_ = groupHeaderInformationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("admin_aware_group");
                    AdminAwareGroupParser.m6463a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("group_configs");
                    GroupConfigsParser.m6467a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupHeaderInformationModel.class, new Serializer());
            }
        }

        public GroupHeaderInformationModel() {
            super(3);
        }

        public final void m6352a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m6353a(String str, Object obj, boolean z) {
        }

        @Clone(from = "getAdminAwareGroup", processor = "com.facebook.dracula.transformer.Transformer")
        @Nullable
        private DraculaReturnValue m6346j() {
            DraculaReturnValue a = DraculaHelper.a(this.f5563d, this.f5564e, this.f5565f, w_(), u_(), 0, 291056794);
            MutableFlatBuffer mutableFlatBuffer = a.a;
            int i = a.b;
            int i2 = a.c;
            this.f5563d = mutableFlatBuffer;
            this.f5564e = i;
            this.f5565f = i2;
            return DraculaReturnValue.a(this.f5563d, this.f5564e, this.f5565f);
        }

        @Clone(from = "getGroupConfigs", processor = "com.facebook.dracula.transformer.Transformer")
        @Nullable
        private GroupConfigsModel m6347k() {
            this.f5566g = (GroupConfigsModel) super.a(this.f5566g, 1, GroupConfigsModel.class);
            return this.f5566g;
        }

        @Nullable
        private String m6348l() {
            this.f5567h = super.a(this.f5567h, 2);
            return this.f5567h;
        }

        @Nullable
        public final String m6351a() {
            return m6348l();
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m6350a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            DraculaReturnValue j = m6346j();
            MutableFlatBuffer mutableFlatBuffer = j.a;
            int i = j.b;
            int i2 = j.c;
            if (!DraculaRuntime.a(mutableFlatBuffer, i, null, 0)) {
                j = m6346j();
                FlatTuple flatTuple = (FlatTuple) graphQLModelMutatingVisitor.b(DraculaWrapper.m6293a(j.a, j.b, j.c));
                mutableFlatBuffer = flatTuple.a;
                i = flatTuple.b;
                int i3 = flatTuple.c;
                j = m6346j();
                MutableFlatBuffer mutableFlatBuffer2 = j.a;
                int i4 = j.b;
                i2 = j.c;
                if (!DraculaRuntime.a(mutableFlatBuffer2, i4, mutableFlatBuffer, i)) {
                    GroupHeaderInformationModel groupHeaderInformationModel = (GroupHeaderInformationModel) ModelHelper.a(null, this);
                    groupHeaderInformationModel.f5563d = mutableFlatBuffer;
                    groupHeaderInformationModel.f5564e = i;
                    groupHeaderInformationModel.f5565f = i3;
                    graphQLVisitableModel = groupHeaderInformationModel;
                }
            }
            if (m6347k() != null) {
                GroupConfigsModel groupConfigsModel = (GroupConfigsModel) graphQLModelMutatingVisitor.b(m6347k());
                if (m6347k() != groupConfigsModel) {
                    graphQLVisitableModel = (GroupHeaderInformationModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5566g = groupConfigsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6349a(FlatBufferBuilder flatBufferBuilder) {
            h();
            DraculaReturnValue j = m6346j();
            int a = ModelHelper.a(flatBufferBuilder, DraculaWrapper.m6293a(j.a, j.b, j.c));
            int a2 = ModelHelper.a(flatBufferBuilder, m6347k());
            int b = flatBufferBuilder.b(m6348l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 857966944)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: range1 */
    public final class GroupPinnedPostModel extends BaseModel implements GraphQLVisitableConsistentModel, GroupPinnedPost {
        @Nullable
        private GroupPinnedStoriesModel f5574d;

        /* compiled from: range1 */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupPinnedPostModel.class, new Deserializer());
            }

            public Object m6354a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupPinnedPostParser.m6473a(jsonParser);
                Object groupPinnedPostModel = new GroupPinnedPostModel();
                ((BaseModel) groupPinnedPostModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupPinnedPostModel instanceof Postprocessable) {
                    return ((Postprocessable) groupPinnedPostModel).a();
                }
                return groupPinnedPostModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1499630666)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: range1 */
        public final class GroupPinnedStoriesModel extends BaseModel implements GraphQLVisitableModel {
            private int f5572d;
            @Nullable
            private List<NodesModel> f5573e;

            /* compiled from: range1 */
            public final class Builder {
                public int f5568a;
                @Nullable
                public ImmutableList<NodesModel> f5569b;
            }

            /* compiled from: range1 */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupPinnedStoriesModel.class, new Deserializer());
                }

                public Object m6355a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupPinnedStoriesParser.m6471a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupPinnedStoriesModel = new GroupPinnedStoriesModel();
                    ((BaseModel) groupPinnedStoriesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupPinnedStoriesModel instanceof Postprocessable) {
                        return ((Postprocessable) groupPinnedStoriesModel).a();
                    }
                    return groupPinnedStoriesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1801334754)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: range1 */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f5571d;

                /* compiled from: range1 */
                public final class Builder {
                    @Nullable
                    public String f5570a;
                }

                /* compiled from: range1 */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m6356a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(GroupPinnedStoriesParser.NodesParser.m6470b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                /* compiled from: range1 */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m6357a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m6359a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        GroupPinnedStoriesParser.NodesParser.m6469a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(1);
                }

                public NodesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final void m6362a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m6363a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final String m6364b() {
                    this.f5571d = super.a(this.f5571d, 0);
                    return this.f5571d;
                }

                public static NodesModel m6358a(NodesModel nodesModel) {
                    if (nodesModel == null) {
                        return null;
                    }
                    if (nodesModel instanceof NodesModel) {
                        return nodesModel;
                    }
                    Builder builder = new Builder();
                    builder.f5570a = nodesModel.m6364b();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f5570a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new NodesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                @Nullable
                public final String m6361a() {
                    return m6364b();
                }

                public final int jK_() {
                    return 80218325;
                }

                public final GraphQLVisitableModel m6360a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m6359a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m6364b());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: range1 */
            public class Serializer extends JsonSerializer<GroupPinnedStoriesModel> {
                public final void m6365a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupPinnedStoriesModel groupPinnedStoriesModel = (GroupPinnedStoriesModel) obj;
                    if (groupPinnedStoriesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupPinnedStoriesModel.m6368a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupPinnedStoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupPinnedStoriesParser.m6472a(groupPinnedStoriesModel.w_(), groupPinnedStoriesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupPinnedStoriesModel.class, new Serializer());
                }
            }

            public GroupPinnedStoriesModel() {
                super(2);
            }

            public GroupPinnedStoriesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m6367a() {
                a(0, 0);
                return this.f5572d;
            }

            @Nonnull
            public final ImmutableList<NodesModel> m6371b() {
                this.f5573e = super.a(this.f5573e, 1, NodesModel.class);
                return (ImmutableList) this.f5573e;
            }

            public static GroupPinnedStoriesModel m6366a(GroupPinnedStoriesModel groupPinnedStoriesModel) {
                if (groupPinnedStoriesModel == null) {
                    return null;
                }
                if (groupPinnedStoriesModel instanceof GroupPinnedStoriesModel) {
                    return groupPinnedStoriesModel;
                }
                Builder builder = new Builder();
                builder.f5568a = groupPinnedStoriesModel.m6367a();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < groupPinnedStoriesModel.m6371b().size(); i++) {
                    builder2.c(NodesModel.m6358a((NodesModel) groupPinnedStoriesModel.m6371b().get(i)));
                }
                builder.f5569b = builder2.b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f5569b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, builder.f5568a, 0);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new GroupPinnedStoriesModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -216392390;
            }

            public final GraphQLVisitableModel m6369a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6371b() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m6371b(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (GroupPinnedStoriesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5573e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6368a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6371b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f5572d, 0);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m6370a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f5572d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: range1 */
        public class Serializer extends JsonSerializer<GroupPinnedPostModel> {
            public final void m6372a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupPinnedPostModel groupPinnedPostModel = (GroupPinnedPostModel) obj;
                if (groupPinnedPostModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupPinnedPostModel.m6374a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupPinnedPostModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupPinnedPostModel.w_();
                int u_ = groupPinnedPostModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group_pinned_stories");
                    GroupPinnedStoriesParser.m6472a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupPinnedPostModel.class, new Serializer());
            }
        }

        public GroupPinnedPostModel() {
            super(1);
        }

        public final void m6376a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m6377a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GroupPinnedStoriesModel m6373a() {
            this.f5574d = (GroupPinnedStoriesModel) super.a(this.f5574d, 0, GroupPinnedStoriesModel.class);
            return this.f5574d;
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m6375a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6373a() != null) {
                GroupPinnedStoriesModel groupPinnedStoriesModel = (GroupPinnedStoriesModel) graphQLModelMutatingVisitor.b(m6373a());
                if (m6373a() != groupPinnedStoriesModel) {
                    graphQLVisitableModel = (GroupPinnedPostModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5574d = groupPinnedStoriesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6374a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6373a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 181773767)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: range1 */
    public final class GroupSuggestionTipsModel extends BaseModel implements GraphQLVisitableConsistentModel, GroupSuggestionTips {
        @Nullable
        private TipsChannelModel f5603d;

        /* compiled from: range1 */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupSuggestionTipsModel.class, new Deserializer());
            }

            public Object m6378a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupSuggestionTipsParser.m6480a(jsonParser);
                Object groupSuggestionTipsModel = new GroupSuggestionTipsModel();
                ((BaseModel) groupSuggestionTipsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupSuggestionTipsModel instanceof Postprocessable) {
                    return ((Postprocessable) groupSuggestionTipsModel).a();
                }
                return groupSuggestionTipsModel;
            }
        }

        /* compiled from: range1 */
        public class Serializer extends JsonSerializer<GroupSuggestionTipsModel> {
            public final void m6379a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupSuggestionTipsModel groupSuggestionTipsModel = (GroupSuggestionTipsModel) obj;
                if (groupSuggestionTipsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupSuggestionTipsModel.m6412a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupSuggestionTipsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupSuggestionTipsModel.w_();
                int u_ = groupSuggestionTipsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("tips_channel");
                    TipsChannelParser.m6479a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupSuggestionTipsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2031347688)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: range1 */
        public final class TipsChannelModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f5601d;
            @Nullable
            private List<TipsModel> f5602e;

            /* compiled from: range1 */
            public final class Builder {
                @Nullable
                public String f5575a;
                @Nullable
                public ImmutableList<TipsModel> f5576b;
            }

            /* compiled from: range1 */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TipsChannelModel.class, new Deserializer());
                }

                public Object m6380a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TipsChannelParser.m6478a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object tipsChannelModel = new TipsChannelModel();
                    ((BaseModel) tipsChannelModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (tipsChannelModel instanceof Postprocessable) {
                        return ((Postprocessable) tipsChannelModel).a();
                    }
                    return tipsChannelModel;
                }
            }

            /* compiled from: range1 */
            public class Serializer extends JsonSerializer<TipsChannelModel> {
                public final void m6381a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TipsChannelModel tipsChannelModel = (TipsChannelModel) obj;
                    if (tipsChannelModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(tipsChannelModel.m6406a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        tipsChannelModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TipsChannelParser.m6479a(tipsChannelModel.w_(), tipsChannelModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TipsChannelModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1867834111)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: range1 */
            public final class TipsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private String f5590d;
                @Nullable
                private String f5591e;
                @Nullable
                private String f5592f;
                @Nullable
                private String f5593g;
                @Nullable
                private ImageModel f5594h;
                @Nullable
                private String f5595i;
                private boolean f5596j;
                @Nullable
                private GraphQLAYMTNativeAction f5597k;
                @Nullable
                private String f5598l;
                @Nullable
                private String f5599m;
                @Nullable
                private String f5600n;

                /* compiled from: range1 */
                public final class Builder {
                    @Nullable
                    public String f5577a;
                    @Nullable
                    public String f5578b;
                    @Nullable
                    public String f5579c;
                    @Nullable
                    public String f5580d;
                    @Nullable
                    public ImageModel f5581e;
                    @Nullable
                    public String f5582f;
                    public boolean f5583g;
                    @Nullable
                    public GraphQLAYMTNativeAction f5584h;
                    @Nullable
                    public String f5585i;
                    @Nullable
                    public String f5586j;
                    @Nullable
                    public String f5587k;

                    public final TipsModel m6382a() {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int b = flatBufferBuilder.b(this.f5577a);
                        int b2 = flatBufferBuilder.b(this.f5578b);
                        int b3 = flatBufferBuilder.b(this.f5579c);
                        int b4 = flatBufferBuilder.b(this.f5580d);
                        int a = ModelHelper.a(flatBufferBuilder, this.f5581e);
                        int b5 = flatBufferBuilder.b(this.f5582f);
                        int a2 = flatBufferBuilder.a(this.f5584h);
                        int b6 = flatBufferBuilder.b(this.f5585i);
                        int b7 = flatBufferBuilder.b(this.f5586j);
                        int b8 = flatBufferBuilder.b(this.f5587k);
                        flatBufferBuilder.c(11);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, b2);
                        flatBufferBuilder.b(2, b3);
                        flatBufferBuilder.b(3, b4);
                        flatBufferBuilder.b(4, a);
                        flatBufferBuilder.b(5, b5);
                        flatBufferBuilder.a(6, this.f5583g);
                        flatBufferBuilder.b(7, a2);
                        flatBufferBuilder.b(8, b6);
                        flatBufferBuilder.b(9, b7);
                        flatBufferBuilder.b(10, b8);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new TipsModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }
                }

                /* compiled from: range1 */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TipsModel.class, new Deserializer());
                    }

                    public Object m6383a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(TipsParser.m6476b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object tipsModel = new TipsModel();
                        ((BaseModel) tipsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (tipsModel instanceof Postprocessable) {
                            return ((Postprocessable) tipsModel).a();
                        }
                        return tipsModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: range1 */
                public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f5589d;

                    /* compiled from: range1 */
                    public final class Builder {
                        @Nullable
                        public String f5588a;
                    }

                    /* compiled from: range1 */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                        }

                        public Object m6384a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ImageParser.m6474a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object imageModel = new ImageModel();
                            ((BaseModel) imageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (imageModel instanceof Postprocessable) {
                                return ((Postprocessable) imageModel).a();
                            }
                            return imageModel;
                        }
                    }

                    /* compiled from: range1 */
                    public class Serializer extends JsonSerializer<ImageModel> {
                        public final void m6385a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ImageModel imageModel = (ImageModel) obj;
                            if (imageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(imageModel.m6387a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ImageParser.m6475a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ImageModel.class, new Serializer());
                        }
                    }

                    public ImageModel() {
                        super(1);
                    }

                    public ImageModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(1);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    @Nullable
                    public final String m6389a() {
                        this.f5589d = super.a(this.f5589d, 0);
                        return this.f5589d;
                    }

                    public static ImageModel m6386a(ImageModel imageModel) {
                        if (imageModel == null) {
                            return null;
                        }
                        if (imageModel instanceof ImageModel) {
                            return imageModel;
                        }
                        Builder builder = new Builder();
                        builder.f5588a = imageModel.m6389a();
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int b = flatBufferBuilder.b(builder.f5588a);
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new ImageModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m6388a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m6387a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m6389a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: range1 */
                public class Serializer extends JsonSerializer<TipsModel> {
                    public final void m6390a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TipsModel tipsModel = (TipsModel) obj;
                        if (tipsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(tipsModel.m6392a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            tipsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        TipsParser.m6477b(tipsModel.w_(), tipsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(TipsModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ ImageModel m6399g() {
                    return m6404n();
                }

                public TipsModel() {
                    super(11);
                }

                public TipsModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(11);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final String m6396b() {
                    this.f5590d = super.a(this.f5590d, 0);
                    return this.f5590d;
                }

                @Nullable
                public final String m6397c() {
                    this.f5591e = super.a(this.f5591e, 1);
                    return this.f5591e;
                }

                @Nullable
                public final String m6398d() {
                    this.f5592f = super.a(this.f5592f, 2);
                    return this.f5592f;
                }

                @Nullable
                public final String gZ_() {
                    this.f5593g = super.a(this.f5593g, 3);
                    return this.f5593g;
                }

                @Nullable
                public final ImageModel m6404n() {
                    this.f5594h = (ImageModel) super.a(this.f5594h, 4, ImageModel.class);
                    return this.f5594h;
                }

                @Nullable
                public final String ha_() {
                    this.f5595i = super.a(this.f5595i, 5);
                    return this.f5595i;
                }

                public final boolean hb_() {
                    a(0, 6);
                    return this.f5596j;
                }

                @Nullable
                public final GraphQLAYMTNativeAction m6400j() {
                    this.f5597k = (GraphQLAYMTNativeAction) super.b(this.f5597k, 7, GraphQLAYMTNativeAction.class, GraphQLAYMTNativeAction.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f5597k;
                }

                @Nullable
                public final String m6401k() {
                    this.f5598l = super.a(this.f5598l, 8);
                    return this.f5598l;
                }

                @Nullable
                public final String m6402l() {
                    this.f5599m = super.a(this.f5599m, 9);
                    return this.f5599m;
                }

                @Nullable
                public final String m6403m() {
                    this.f5600n = super.a(this.f5600n, 10);
                    return this.f5600n;
                }

                public static TipsModel m6391a(TipsModel tipsModel) {
                    if (tipsModel == null) {
                        return null;
                    }
                    if (tipsModel instanceof TipsModel) {
                        return tipsModel;
                    }
                    Builder builder = new Builder();
                    builder.f5577a = tipsModel.m6396b();
                    builder.f5578b = tipsModel.m6397c();
                    builder.f5579c = tipsModel.m6398d();
                    builder.f5580d = tipsModel.gZ_();
                    builder.f5581e = ImageModel.m6386a(tipsModel.m6399g());
                    builder.f5582f = tipsModel.ha_();
                    builder.f5583g = tipsModel.hb_();
                    builder.f5584h = tipsModel.m6400j();
                    builder.f5585i = tipsModel.m6401k();
                    builder.f5586j = tipsModel.m6402l();
                    builder.f5587k = tipsModel.m6403m();
                    return builder.m6382a();
                }

                @Nullable
                public final String m6394a() {
                    return gZ_();
                }

                public final int jK_() {
                    return 179889212;
                }

                public final GraphQLVisitableModel m6393a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m6404n() != null) {
                        ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m6404n());
                        if (m6404n() != imageModel) {
                            graphQLVisitableModel = (TipsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f5594h = imageModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m6392a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m6396b());
                    int b2 = flatBufferBuilder.b(m6397c());
                    int b3 = flatBufferBuilder.b(m6398d());
                    int b4 = flatBufferBuilder.b(gZ_());
                    int a = ModelHelper.a(flatBufferBuilder, m6404n());
                    int b5 = flatBufferBuilder.b(ha_());
                    int a2 = flatBufferBuilder.a(m6400j());
                    int b6 = flatBufferBuilder.b(m6401k());
                    int b7 = flatBufferBuilder.b(m6402l());
                    int b8 = flatBufferBuilder.b(m6403m());
                    flatBufferBuilder.c(11);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    flatBufferBuilder.b(2, b3);
                    flatBufferBuilder.b(3, b4);
                    flatBufferBuilder.b(4, a);
                    flatBufferBuilder.b(5, b5);
                    flatBufferBuilder.a(6, this.f5596j);
                    flatBufferBuilder.b(7, a2);
                    flatBufferBuilder.b(8, b6);
                    flatBufferBuilder.b(9, b7);
                    flatBufferBuilder.b(10, b8);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m6395a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f5596j = mutableFlatBuffer.a(i, 6);
                }
            }

            public TipsChannelModel() {
                super(2);
            }

            public TipsChannelModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m6409b() {
                this.f5601d = super.a(this.f5601d, 0);
                return this.f5601d;
            }

            @Nonnull
            public final ImmutableList<TipsModel> m6410c() {
                this.f5602e = super.a(this.f5602e, 1, TipsModel.class);
                return (ImmutableList) this.f5602e;
            }

            public static TipsChannelModel m6405a(TipsChannelModel tipsChannelModel) {
                if (tipsChannelModel == null) {
                    return null;
                }
                if (tipsChannelModel instanceof TipsChannelModel) {
                    return tipsChannelModel;
                }
                Builder builder = new Builder();
                builder.f5575a = tipsChannelModel.m6409b();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < tipsChannelModel.m6410c().size(); i++) {
                    builder2.c(TipsModel.m6391a((TipsModel) tipsChannelModel.m6410c().get(i)));
                }
                builder.f5576b = builder2.b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f5575a);
                int a = ModelHelper.a(flatBufferBuilder, builder.f5576b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new TipsChannelModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m6408a() {
                return m6409b();
            }

            public final int jK_() {
                return -111810524;
            }

            public final GraphQLVisitableModel m6407a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6410c() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m6410c(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (TipsChannelModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5602e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6406a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m6409b());
                int a = ModelHelper.a(flatBufferBuilder, m6410c());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public GroupSuggestionTipsModel() {
            super(1);
        }

        public final void m6414a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m6415a(String str, Object obj, boolean z) {
        }

        @Nullable
        private TipsChannelModel m6411a() {
            this.f5603d = (TipsChannelModel) super.a(this.f5603d, 0, TipsChannelModel.class);
            return this.f5603d;
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m6413a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6411a() != null) {
                TipsChannelModel tipsChannelModel = (TipsChannelModel) graphQLModelMutatingVisitor.b(m6411a());
                if (m6411a() != tipsChannelModel) {
                    graphQLVisitableModel = (GroupSuggestionTipsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5603d = tipsChannelModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6412a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6411a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 778047470)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: range1 */
    public final class GroupViewerInviteInformationModel extends BaseModel implements GraphQLVisitableConsistentModel, GroupViewerInviteInformation {
        @Nullable
        private ViewerInviteToGroupModel f5612d;

        /* compiled from: range1 */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupViewerInviteInformationModel.class, new Deserializer());
            }

            public Object m6416a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupViewerInviteInformationParser.m6485a(jsonParser);
                Object groupViewerInviteInformationModel = new GroupViewerInviteInformationModel();
                ((BaseModel) groupViewerInviteInformationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupViewerInviteInformationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupViewerInviteInformationModel).a();
                }
                return groupViewerInviteInformationModel;
            }
        }

        /* compiled from: range1 */
        public class Serializer extends JsonSerializer<GroupViewerInviteInformationModel> {
            public final void m6417a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupViewerInviteInformationModel groupViewerInviteInformationModel = (GroupViewerInviteInformationModel) obj;
                if (groupViewerInviteInformationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupViewerInviteInformationModel.m6438a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupViewerInviteInformationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupViewerInviteInformationModel.w_();
                int u_ = groupViewerInviteInformationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("viewer_invite_to_group");
                    ViewerInviteToGroupParser.m6484a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupViewerInviteInformationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1164528577)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: range1 */
        public final class ViewerInviteToGroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f5610d;
            @Nullable
            private InviterModel f5611e;

            /* compiled from: range1 */
            public final class Builder {
                @Nullable
                public String f5604a;
                @Nullable
                public InviterModel f5605b;
            }

            /* compiled from: range1 */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerInviteToGroupModel.class, new Deserializer());
                }

                public Object m6418a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewerInviteToGroupParser.m6483a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object viewerInviteToGroupModel = new ViewerInviteToGroupModel();
                    ((BaseModel) viewerInviteToGroupModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (viewerInviteToGroupModel instanceof Postprocessable) {
                        return ((Postprocessable) viewerInviteToGroupModel).a();
                    }
                    return viewerInviteToGroupModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1185712657)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: range1 */
            public final class InviterModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f5608d;
                @Nullable
                private String f5609e;

                /* compiled from: range1 */
                public final class Builder {
                    @Nullable
                    public String f5606a;
                    @Nullable
                    public String f5607b;
                }

                /* compiled from: range1 */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(InviterModel.class, new Deserializer());
                    }

                    public Object m6419a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(InviterParser.m6481a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object inviterModel = new InviterModel();
                        ((BaseModel) inviterModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (inviterModel instanceof Postprocessable) {
                            return ((Postprocessable) inviterModel).a();
                        }
                        return inviterModel;
                    }
                }

                /* compiled from: range1 */
                public class Serializer extends JsonSerializer<InviterModel> {
                    public final void m6420a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        InviterModel inviterModel = (InviterModel) obj;
                        if (inviterModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(inviterModel.m6422a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            inviterModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        InviterParser.m6482a(inviterModel.w_(), inviterModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(InviterModel.class, new Serializer());
                    }
                }

                public InviterModel() {
                    super(2);
                }

                public InviterModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(2);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final void m6425a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m6426a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final String m6427b() {
                    this.f5608d = super.a(this.f5608d, 0);
                    return this.f5608d;
                }

                @Nullable
                public final String m6428c() {
                    this.f5609e = super.a(this.f5609e, 1);
                    return this.f5609e;
                }

                public static InviterModel m6421a(InviterModel inviterModel) {
                    if (inviterModel == null) {
                        return null;
                    }
                    if (inviterModel instanceof InviterModel) {
                        return inviterModel;
                    }
                    Builder builder = new Builder();
                    builder.f5606a = inviterModel.m6427b();
                    builder.f5607b = inviterModel.m6428c();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f5606a);
                    int b2 = flatBufferBuilder.b(builder.f5607b);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new InviterModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                @Nullable
                public final String m6424a() {
                    return m6427b();
                }

                public final int jK_() {
                    return 2645995;
                }

                public final GraphQLVisitableModel m6423a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m6422a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m6427b());
                    int b2 = flatBufferBuilder.b(m6428c());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: range1 */
            public class Serializer extends JsonSerializer<ViewerInviteToGroupModel> {
                public final void m6429a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerInviteToGroupModel viewerInviteToGroupModel = (ViewerInviteToGroupModel) obj;
                    if (viewerInviteToGroupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerInviteToGroupModel.m6431a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerInviteToGroupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ViewerInviteToGroupParser.m6484a(viewerInviteToGroupModel.w_(), viewerInviteToGroupModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ViewerInviteToGroupModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ InviterModel m6435c() {
                return m6436j();
            }

            public ViewerInviteToGroupModel() {
                super(2);
            }

            public ViewerInviteToGroupModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m6434b() {
                this.f5610d = super.a(this.f5610d, 0);
                return this.f5610d;
            }

            @Nullable
            public final InviterModel m6436j() {
                this.f5611e = (InviterModel) super.a(this.f5611e, 1, InviterModel.class);
                return this.f5611e;
            }

            public static ViewerInviteToGroupModel m6430a(ViewerInviteToGroupModel viewerInviteToGroupModel) {
                if (viewerInviteToGroupModel == null) {
                    return null;
                }
                if (viewerInviteToGroupModel instanceof ViewerInviteToGroupModel) {
                    return viewerInviteToGroupModel;
                }
                Builder builder = new Builder();
                builder.f5604a = viewerInviteToGroupModel.m6434b();
                builder.f5605b = InviterModel.m6421a(viewerInviteToGroupModel.m6435c());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f5604a);
                int a = ModelHelper.a(flatBufferBuilder, builder.f5605b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ViewerInviteToGroupModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m6433a() {
                return m6434b();
            }

            public final int jK_() {
                return 1476491891;
            }

            public final GraphQLVisitableModel m6432a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6436j() != null) {
                    InviterModel inviterModel = (InviterModel) graphQLModelMutatingVisitor.b(m6436j());
                    if (m6436j() != inviterModel) {
                        graphQLVisitableModel = (ViewerInviteToGroupModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5611e = inviterModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6431a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m6434b());
                int a = ModelHelper.a(flatBufferBuilder, m6436j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public GroupViewerInviteInformationModel() {
            super(1);
        }

        public final void m6440a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m6441a(String str, Object obj, boolean z) {
        }

        @Nullable
        private ViewerInviteToGroupModel m6437a() {
            this.f5612d = (ViewerInviteToGroupModel) super.a(this.f5612d, 0, ViewerInviteToGroupModel.class);
            return this.f5612d;
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m6439a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6437a() != null) {
                ViewerInviteToGroupModel viewerInviteToGroupModel = (ViewerInviteToGroupModel) graphQLModelMutatingVisitor.b(m6437a());
                if (m6437a() != viewerInviteToGroupModel) {
                    graphQLVisitableModel = (GroupViewerInviteInformationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5612d = viewerInviteToGroupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6438a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6437a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
