package com.facebook.contacts.graphql;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.contacts.graphql.ContactGraphQLParsers$ContactParser.NameEntriesParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 183156039)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: requires_approval */
public final class ContactGraphQLModels$ContactModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
    private long f3599d;
    @Nullable
    private ContactGraphQLModels$SquareImageModel f3600e;
    @Nullable
    private String f3601f;
    @Nullable
    private ContactGraphQLModels$SquareImageModel f3602g;
    @Nullable
    private String f3603h;
    @Nullable
    private List<ImportedPhoneEntriesModel> f3604i;
    private boolean f3605j;
    @Nullable
    private List<NameEntriesModel> f3606k;
    @Nullable
    private ContactGraphQLModels$ContactNameModel f3607l;
    @Nullable
    private RepresentedProfileModel f3608m;
    @Nullable
    private ContactGraphQLModels$SquareImageModel f3609n;
    @Nullable
    private ContactGraphQLModels$ContactNameModel f3610o;

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1111858431)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: requires_approval */
    public final class NameEntriesModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PrimaryFieldModel f3668d;

        /* compiled from: requires_approval */
        public class Serializer extends JsonSerializer<NameEntriesModel> {
            public final void m4179a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                NameEntriesModel nameEntriesModel = (NameEntriesModel) obj;
                if (nameEntriesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(nameEntriesModel.m4100a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    nameEntriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                NameEntriesParser.m3987b(nameEntriesModel.w_(), nameEntriesModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.m277a(NameEntriesModel.class, new Serializer());
            }
        }

        public NameEntriesModel() {
            super(1);
        }

        public NameEntriesModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final PrimaryFieldModel m4101a() {
            this.f3668d = (PrimaryFieldModel) super.a(this.f3668d, 0, PrimaryFieldModel.class);
            return this.f3668d;
        }

        public final int jK_() {
            return 1418058834;
        }

        public final GraphQLVisitableModel m4102a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m4101a() != null) {
                PrimaryFieldModel primaryFieldModel = (PrimaryFieldModel) graphQLModelMutatingVisitor.b(m4101a());
                if (m4101a() != primaryFieldModel) {
                    graphQLVisitableModel = (NameEntriesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3668d = primaryFieldModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m4100a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m4101a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1554727701)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: requires_approval */
    public final class RepresentedProfileModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f3669d;
        @Nullable
        private BirthdateModel f3670e;
        private boolean f3671f;
        private boolean f3672g;
        private double f3673h;
        @Nullable
        private ContactGraphQLModels$CoverPhotoModel f3674i;
        @Nullable
        private CurrentCityModel f3675j;
        @Nullable
        private GraphQLFriendshipStatus f3676k;
        @Nullable
        private String f3677l;
        private boolean f3678m;
        private boolean f3679n;
        private boolean f3680o;
        private boolean f3681p;
        private boolean f3682q;
        private long f3683r;
        private double f3684s;
        @Nullable
        private String f3685t;
        @Nullable
        private List<String> f3686u;
        @Nullable
        private GraphQLSubscribeStatus f3687v;
        private double f3688w;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 504831797)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: requires_approval */
        public final class BirthdateModel extends BaseModel implements GraphQLVisitableModel {
            private int f3690d;
            private int f3691e;

            public BirthdateModel() {
                super(2);
            }

            public final int m4135a() {
                a(0, 0);
                return this.f3690d;
            }

            public final int m4139b() {
                a(0, 1);
                return this.f3691e;
            }

            public final int jK_() {
                return 2122702;
            }

            public final GraphQLVisitableModel m4137a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m4136a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f3690d, 0);
                flatBufferBuilder.a(1, this.f3691e, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m4138a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f3690d = mutableFlatBuffer.a(i, 0, 0);
                this.f3691e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 273304230)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: requires_approval */
        public final class CurrentCityModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private String f3692d;

            public CurrentCityModel() {
                super(1);
            }

            public final void m4143a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m4144a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m4142a() {
                this.f3692d = super.a(this.f3692d, 0);
                return this.f3692d;
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m4141a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m4140a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m4142a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ BirthdateModel m4116c() {
            return m4106w();
        }

        @Nullable
        public final /* synthetic */ CurrentCityModel cB_() {
            return m4108y();
        }

        @Nullable
        public final /* synthetic */ ContactGraphQLModels$CoverPhotoModel cC_() {
            return m4107x();
        }

        public RepresentedProfileModel() {
            super(20);
        }

        public final void m4113a(String str, ConsistencyTuple consistencyTuple) {
            if ("can_viewer_message".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(cA_());
                consistencyTuple.b = u_();
                consistencyTuple.c = 3;
            } else if ("friendship_status".equals(str)) {
                consistencyTuple.a = m4119j();
                consistencyTuple.b = u_();
                consistencyTuple.c = 7;
            } else if ("subscribe_status".equals(str)) {
                consistencyTuple.a = m4130u();
                consistencyTuple.b = u_();
                consistencyTuple.c = 18;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m4114a(String str, Object obj, boolean z) {
            if ("can_viewer_message".equals(str)) {
                m4105a(((Boolean) obj).booleanValue());
            } else if ("friendship_status".equals(str)) {
                m4103a((GraphQLFriendshipStatus) obj);
            } else if ("subscribe_status".equals(str)) {
                m4104a((GraphQLSubscribeStatus) obj);
            }
        }

        @Nullable
        public final GraphQLObjectType m4115b() {
            if (this.b != null && this.f3669d == null) {
                this.f3669d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f3669d;
        }

        @Nullable
        private BirthdateModel m4106w() {
            this.f3670e = (BirthdateModel) super.a(this.f3670e, 1, BirthdateModel.class);
            return this.f3670e;
        }

        public final boolean m4117d() {
            a(0, 2);
            return this.f3671f;
        }

        public final boolean cA_() {
            a(0, 3);
            return this.f3672g;
        }

        private void m4105a(boolean z) {
            this.f3672g = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 3, z);
            }
        }

        public final double m4118g() {
            a(0, 4);
            return this.f3673h;
        }

        @Nullable
        private ContactGraphQLModels$CoverPhotoModel m4107x() {
            this.f3674i = (ContactGraphQLModels$CoverPhotoModel) super.a(this.f3674i, 5, ContactGraphQLModels$CoverPhotoModel.class);
            return this.f3674i;
        }

        @Nullable
        private CurrentCityModel m4108y() {
            this.f3675j = (CurrentCityModel) super.a(this.f3675j, 6, CurrentCityModel.class);
            return this.f3675j;
        }

        @Nullable
        public final GraphQLFriendshipStatus m4119j() {
            this.f3676k = (GraphQLFriendshipStatus) super.b(this.f3676k, 7, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f3676k;
        }

        private void m4103a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
            this.f3676k = graphQLFriendshipStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 7, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
            }
        }

        @Nullable
        public final String m4120k() {
            this.f3677l = super.a(this.f3677l, 8);
            return this.f3677l;
        }

        public final boolean m4121l() {
            a(1, 1);
            return this.f3678m;
        }

        public final boolean m4122m() {
            a(1, 2);
            return this.f3679n;
        }

        public final boolean m4123n() {
            a(1, 3);
            return this.f3680o;
        }

        public final boolean m4124o() {
            a(1, 4);
            return this.f3681p;
        }

        public final boolean m4125p() {
            a(1, 5);
            return this.f3682q;
        }

        public final long m4126q() {
            a(1, 6);
            return this.f3683r;
        }

        public final double m4127r() {
            a(1, 7);
            return this.f3684s;
        }

        @Nullable
        public final String m4128s() {
            this.f3685t = super.a(this.f3685t, 16);
            return this.f3685t;
        }

        @Nonnull
        public final ImmutableList<String> m4129t() {
            this.f3686u = super.a(this.f3686u, 17);
            return (ImmutableList) this.f3686u;
        }

        @Nullable
        public final GraphQLSubscribeStatus m4130u() {
            this.f3687v = (GraphQLSubscribeStatus) super.b(this.f3687v, 18, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f3687v;
        }

        private void m4104a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
            this.f3687v = graphQLSubscribeStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 18, graphQLSubscribeStatus != null ? graphQLSubscribeStatus.name() : null);
            }
        }

        public final double m4131v() {
            a(2, 3);
            return this.f3688w;
        }

        @Nullable
        public final String m4111a() {
            return m4120k();
        }

        public final int jK_() {
            return 63093205;
        }

        public final GraphQLVisitableModel m4110a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m4106w() != null) {
                BirthdateModel birthdateModel = (BirthdateModel) graphQLModelMutatingVisitor.b(m4106w());
                if (m4106w() != birthdateModel) {
                    graphQLVisitableModel = (RepresentedProfileModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3670e = birthdateModel;
                }
            }
            if (m4107x() != null) {
                ContactGraphQLModels$CoverPhotoModel contactGraphQLModels$CoverPhotoModel = (ContactGraphQLModels$CoverPhotoModel) graphQLModelMutatingVisitor.b(m4107x());
                if (m4107x() != contactGraphQLModels$CoverPhotoModel) {
                    graphQLVisitableModel = (RepresentedProfileModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3674i = contactGraphQLModels$CoverPhotoModel;
                }
            }
            if (m4108y() != null) {
                CurrentCityModel currentCityModel = (CurrentCityModel) graphQLModelMutatingVisitor.b(m4108y());
                if (m4108y() != currentCityModel) {
                    graphQLVisitableModel = (RepresentedProfileModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3675j = currentCityModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m4109a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m4115b());
            int a2 = ModelHelper.a(flatBufferBuilder, m4106w());
            int a3 = ModelHelper.a(flatBufferBuilder, m4107x());
            int a4 = ModelHelper.a(flatBufferBuilder, m4108y());
            int a5 = flatBufferBuilder.a(m4119j());
            int b = flatBufferBuilder.b(m4120k());
            int b2 = flatBufferBuilder.b(m4128s());
            int c = flatBufferBuilder.c(m4129t());
            int a6 = flatBufferBuilder.a(m4130u());
            flatBufferBuilder.c(20);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.a(2, this.f3671f);
            flatBufferBuilder.a(3, this.f3672g);
            flatBufferBuilder.a(4, this.f3673h, 0.0d);
            flatBufferBuilder.b(5, a3);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.b(7, a5);
            flatBufferBuilder.b(8, b);
            flatBufferBuilder.a(9, this.f3678m);
            flatBufferBuilder.a(10, this.f3679n);
            flatBufferBuilder.a(11, this.f3680o);
            flatBufferBuilder.a(12, this.f3681p);
            flatBufferBuilder.a(13, this.f3682q);
            flatBufferBuilder.a(14, this.f3683r, 0);
            flatBufferBuilder.a(15, this.f3684s, 0.0d);
            flatBufferBuilder.b(16, b2);
            flatBufferBuilder.b(17, c);
            flatBufferBuilder.b(18, a6);
            flatBufferBuilder.a(19, this.f3688w, 0.0d);
            i();
            return flatBufferBuilder.d();
        }

        public final void m4112a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f3671f = mutableFlatBuffer.a(i, 2);
            this.f3672g = mutableFlatBuffer.a(i, 3);
            this.f3673h = mutableFlatBuffer.a(i, 4, 0.0d);
            this.f3678m = mutableFlatBuffer.a(i, 9);
            this.f3679n = mutableFlatBuffer.a(i, 10);
            this.f3680o = mutableFlatBuffer.a(i, 11);
            this.f3681p = mutableFlatBuffer.a(i, 12);
            this.f3682q = mutableFlatBuffer.a(i, 13);
            this.f3683r = mutableFlatBuffer.a(i, 14, 0);
            this.f3684s = mutableFlatBuffer.a(i, 15, 0.0d);
            this.f3688w = mutableFlatBuffer.a(i, 19, 0.0d);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 597120380)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: requires_approval */
    public final class ImportedPhoneEntriesModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f3693d;
        @Nullable
        private PrimaryFieldModel f3694e;

        @Nullable
        public final /* synthetic */ PrimaryFieldModel m4150b() {
            return m4145j();
        }

        public ImportedPhoneEntriesModel() {
            super(2);
        }

        public final boolean m4149a() {
            a(0, 0);
            return this.f3693d;
        }

        @Nullable
        private PrimaryFieldModel m4145j() {
            this.f3694e = (PrimaryFieldModel) super.a(this.f3694e, 1, PrimaryFieldModel.class);
            return this.f3694e;
        }

        public final int jK_() {
            return 1418058834;
        }

        public final GraphQLVisitableModel m4147a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m4145j() != null) {
                PrimaryFieldModel primaryFieldModel = (PrimaryFieldModel) graphQLModelMutatingVisitor.b(m4145j());
                if (m4145j() != primaryFieldModel) {
                    graphQLVisitableModel = (ImportedPhoneEntriesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3694e = primaryFieldModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m4146a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m4145j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f3693d);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m4148a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f3693d = mutableFlatBuffer.a(i, 0);
        }
    }

    @Nullable
    public final /* synthetic */ ContactGraphQLModels$SquareImageModel m4029c() {
        return m4018o();
    }

    @Nullable
    public final /* synthetic */ ContactGraphQLModels$SquareImageModel cz_() {
        return m4019p();
    }

    @Nullable
    public final /* synthetic */ ContactGraphQLModels$ContactNameModel m4033k() {
        return m4020q();
    }

    @Nullable
    public final /* synthetic */ RepresentedProfileModel m4034l() {
        return m4021r();
    }

    @Nullable
    public final /* synthetic */ ContactGraphQLModels$SquareImageModel m4035m() {
        return m4022s();
    }

    @Nullable
    public final /* synthetic */ ContactGraphQLModels$ContactNameModel m4036n() {
        return m4023t();
    }

    public ContactGraphQLModels$ContactModel() {
        super(12);
    }

    public final long m4028b() {
        a(0, 0);
        return this.f3599d;
    }

    @Nullable
    private ContactGraphQLModels$SquareImageModel m4018o() {
        this.f3600e = (ContactGraphQLModels$SquareImageModel) super.a(this.f3600e, 1, ContactGraphQLModels$SquareImageModel.class);
        return this.f3600e;
    }

    @Nullable
    public final String m4030d() {
        this.f3601f = super.a(this.f3601f, 2);
        return this.f3601f;
    }

    @Nullable
    private ContactGraphQLModels$SquareImageModel m4019p() {
        this.f3602g = (ContactGraphQLModels$SquareImageModel) super.a(this.f3602g, 3, ContactGraphQLModels$SquareImageModel.class);
        return this.f3602g;
    }

    @Nullable
    public final String m4031g() {
        this.f3603h = super.a(this.f3603h, 4);
        return this.f3603h;
    }

    @Nonnull
    public final ImmutableList<ImportedPhoneEntriesModel> cx_() {
        this.f3604i = super.a(this.f3604i, 5, ImportedPhoneEntriesModel.class);
        return (ImmutableList) this.f3604i;
    }

    public final boolean cy_() {
        a(0, 6);
        return this.f3605j;
    }

    @Nonnull
    public final ImmutableList<NameEntriesModel> m4032j() {
        this.f3606k = super.a(this.f3606k, 7, NameEntriesModel.class);
        return (ImmutableList) this.f3606k;
    }

    @Nullable
    private ContactGraphQLModels$ContactNameModel m4020q() {
        this.f3607l = (ContactGraphQLModels$ContactNameModel) super.a(this.f3607l, 8, ContactGraphQLModels$ContactNameModel.class);
        return this.f3607l;
    }

    @Nullable
    private RepresentedProfileModel m4021r() {
        this.f3608m = (RepresentedProfileModel) super.a(this.f3608m, 9, RepresentedProfileModel.class);
        return this.f3608m;
    }

    @Nullable
    private ContactGraphQLModels$SquareImageModel m4022s() {
        this.f3609n = (ContactGraphQLModels$SquareImageModel) super.a(this.f3609n, 10, ContactGraphQLModels$SquareImageModel.class);
        return this.f3609n;
    }

    @Nullable
    private ContactGraphQLModels$ContactNameModel m4023t() {
        this.f3610o = (ContactGraphQLModels$ContactNameModel) super.a(this.f3610o, 11, ContactGraphQLModels$ContactNameModel.class);
        return this.f3610o;
    }

    @Nullable
    public final String m4026a() {
        return m4031g();
    }

    public final int jK_() {
        return -1678787584;
    }

    public final GraphQLVisitableModel m4025a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        ContactGraphQLModels$SquareImageModel contactGraphQLModels$SquareImageModel;
        Builder a;
        ContactGraphQLModels$ContactNameModel contactGraphQLModels$ContactNameModel;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m4018o() != null) {
            contactGraphQLModels$SquareImageModel = (ContactGraphQLModels$SquareImageModel) graphQLModelMutatingVisitor.b(m4018o());
            if (m4018o() != contactGraphQLModels$SquareImageModel) {
                graphQLVisitableModel = (ContactGraphQLModels$ContactModel) ModelHelper.a(null, this);
                graphQLVisitableModel.f3600e = contactGraphQLModels$SquareImageModel;
            }
        }
        if (m4019p() != null) {
            contactGraphQLModels$SquareImageModel = (ContactGraphQLModels$SquareImageModel) graphQLModelMutatingVisitor.b(m4019p());
            if (m4019p() != contactGraphQLModels$SquareImageModel) {
                graphQLVisitableModel = (ContactGraphQLModels$ContactModel) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3602g = contactGraphQLModels$SquareImageModel;
            }
        }
        if (cx_() != null) {
            a = ModelHelper.a(cx_(), graphQLModelMutatingVisitor);
            if (a != null) {
                ContactGraphQLModels$ContactModel contactGraphQLModels$ContactModel = (ContactGraphQLModels$ContactModel) ModelHelper.a(graphQLVisitableModel, this);
                contactGraphQLModels$ContactModel.f3604i = a.b();
                graphQLVisitableModel = contactGraphQLModels$ContactModel;
            }
        }
        if (m4032j() != null) {
            a = ModelHelper.a(m4032j(), graphQLModelMutatingVisitor);
            if (a != null) {
                contactGraphQLModels$ContactModel = (ContactGraphQLModels$ContactModel) ModelHelper.a(graphQLVisitableModel, this);
                contactGraphQLModels$ContactModel.f3606k = a.b();
                graphQLVisitableModel = contactGraphQLModels$ContactModel;
            }
        }
        if (m4020q() != null) {
            contactGraphQLModels$ContactNameModel = (ContactGraphQLModels$ContactNameModel) graphQLModelMutatingVisitor.b(m4020q());
            if (m4020q() != contactGraphQLModels$ContactNameModel) {
                graphQLVisitableModel = (ContactGraphQLModels$ContactModel) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3607l = contactGraphQLModels$ContactNameModel;
            }
        }
        if (m4021r() != null) {
            RepresentedProfileModel representedProfileModel = (RepresentedProfileModel) graphQLModelMutatingVisitor.b(m4021r());
            if (m4021r() != representedProfileModel) {
                graphQLVisitableModel = (ContactGraphQLModels$ContactModel) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3608m = representedProfileModel;
            }
        }
        if (m4022s() != null) {
            contactGraphQLModels$SquareImageModel = (ContactGraphQLModels$SquareImageModel) graphQLModelMutatingVisitor.b(m4022s());
            if (m4022s() != contactGraphQLModels$SquareImageModel) {
                graphQLVisitableModel = (ContactGraphQLModels$ContactModel) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3609n = contactGraphQLModels$SquareImageModel;
            }
        }
        if (m4023t() != null) {
            contactGraphQLModels$ContactNameModel = (ContactGraphQLModels$ContactNameModel) graphQLModelMutatingVisitor.b(m4023t());
            if (m4023t() != contactGraphQLModels$ContactNameModel) {
                graphQLVisitableModel = (ContactGraphQLModels$ContactModel) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3610o = contactGraphQLModels$ContactNameModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m4024a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m4018o());
        int b = flatBufferBuilder.b(m4030d());
        int a2 = ModelHelper.a(flatBufferBuilder, m4019p());
        int b2 = flatBufferBuilder.b(m4031g());
        int a3 = ModelHelper.a(flatBufferBuilder, cx_());
        int a4 = ModelHelper.a(flatBufferBuilder, m4032j());
        int a5 = ModelHelper.a(flatBufferBuilder, m4020q());
        int a6 = ModelHelper.a(flatBufferBuilder, m4021r());
        int a7 = ModelHelper.a(flatBufferBuilder, m4022s());
        int a8 = ModelHelper.a(flatBufferBuilder, m4023t());
        flatBufferBuilder.c(12);
        flatBufferBuilder.a(0, this.f3599d, 0);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, b);
        flatBufferBuilder.b(3, a2);
        flatBufferBuilder.b(4, b2);
        flatBufferBuilder.b(5, a3);
        flatBufferBuilder.a(6, this.f3605j);
        flatBufferBuilder.b(7, a4);
        flatBufferBuilder.b(8, a5);
        flatBufferBuilder.b(9, a6);
        flatBufferBuilder.b(10, a7);
        flatBufferBuilder.b(11, a8);
        i();
        return flatBufferBuilder.d();
    }

    public final void m4027a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3599d = mutableFlatBuffer.a(i, 0, 0);
        this.f3605j = mutableFlatBuffer.a(i, 6);
    }
}
