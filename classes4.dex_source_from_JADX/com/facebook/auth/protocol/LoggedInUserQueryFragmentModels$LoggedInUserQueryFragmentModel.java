package com.facebook.auth.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGender;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models$DefaultNameFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels$DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 103441533)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: snippet_sender */
public final class LoggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    @Nullable
    private List<AllPhonesModel> f1966d;
    @Nullable
    private List<String> f1967e;
    @Nullable
    private GraphQLGender f1968f;
    @Nullable
    private String f1969g;
    private boolean f1970h;
    private boolean f1971i;
    private boolean f1972j;
    private boolean f1973k;
    private boolean f1974l;
    @Nullable
    private MessagingGeoModel f1975m;
    @Nullable
    private String f1976n;
    private boolean f1977o;
    @Nullable
    private CommonGraphQLModels$DefaultImageFieldsModel f1978p;
    @Nullable
    private CommonGraphQLModels$DefaultImageFieldsModel f1979q;
    @Nullable
    private CommonGraphQLModels$DefaultImageFieldsModel f1980r;
    @Nullable
    private CommonGraphQL2Models$DefaultNameFieldsModel f1981s;
    @Nullable
    private String f1982t;

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1013602304)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: snippet_sender */
    public final class AllPhonesModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f1990d;
        @Nullable
        private PhoneNumberModel f1991e;

        public AllPhonesModel() {
            super(2);
        }

        public final boolean m2087a() {
            a(0, 0);
            return this.f1990d;
        }

        @Nullable
        public final PhoneNumberModel m2088j() {
            this.f1991e = (PhoneNumberModel) super.a(this.f1991e, 1, PhoneNumberModel.class);
            return this.f1991e;
        }

        public final int jK_() {
            return 77090126;
        }

        public final GraphQLVisitableModel m2085a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2088j() != null) {
                PhoneNumberModel phoneNumberModel = (PhoneNumberModel) graphQLModelMutatingVisitor.b(m2088j());
                if (m2088j() != phoneNumberModel) {
                    graphQLVisitableModel = (AllPhonesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1991e = phoneNumberModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2084a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2088j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f1990d);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m2086a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1990d = mutableFlatBuffer.a(i, 0);
        }
    }

    public LoggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel() {
        super(17);
    }

    public final void m2056a(String str, ConsistencyTuple consistencyTuple) {
        if ("username".equals(str)) {
            consistencyTuple.a = m2072x();
            consistencyTuple.b = u_();
            consistencyTuple.c = 16;
            return;
        }
        consistencyTuple.a();
    }

    public final void m2057a(String str, Object obj, boolean z) {
        if ("username".equals(str)) {
            m2049a((String) obj);
        }
    }

    @Nonnull
    public final ImmutableList<AllPhonesModel> m2058j() {
        this.f1966d = super.a(this.f1966d, 0, AllPhonesModel.class);
        return (ImmutableList) this.f1966d;
    }

    @Nonnull
    public final ImmutableList<String> m2059k() {
        this.f1967e = super.a(this.f1967e, 1);
        return (ImmutableList) this.f1967e;
    }

    @Nullable
    public final GraphQLGender m2060l() {
        this.f1968f = (GraphQLGender) super.b(this.f1968f, 2, GraphQLGender.class, GraphQLGender.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f1968f;
    }

    @Nullable
    public final String m2061m() {
        this.f1969g = super.a(this.f1969g, 3);
        return this.f1969g;
    }

    public final boolean m2062n() {
        a(0, 4);
        return this.f1970h;
    }

    public final boolean m2063o() {
        a(0, 5);
        return this.f1971i;
    }

    public final boolean m2064p() {
        a(0, 6);
        return this.f1972j;
    }

    public final boolean m2065q() {
        a(0, 7);
        return this.f1973k;
    }

    public final boolean m2066r() {
        a(1, 0);
        return this.f1974l;
    }

    @Nullable
    private MessagingGeoModel m2050y() {
        this.f1975m = (MessagingGeoModel) super.a(this.f1975m, 9, MessagingGeoModel.class);
        return this.f1975m;
    }

    @Nullable
    private String m2051z() {
        this.f1976n = super.a(this.f1976n, 10);
        return this.f1976n;
    }

    public final boolean m2067s() {
        a(1, 3);
        return this.f1977o;
    }

    @Nullable
    public final CommonGraphQLModels$DefaultImageFieldsModel m2068t() {
        this.f1978p = (CommonGraphQLModels$DefaultImageFieldsModel) super.a(this.f1978p, 12, CommonGraphQLModels$DefaultImageFieldsModel.class);
        return this.f1978p;
    }

    @Nullable
    public final CommonGraphQLModels$DefaultImageFieldsModel m2069u() {
        this.f1979q = (CommonGraphQLModels$DefaultImageFieldsModel) super.a(this.f1979q, 13, CommonGraphQLModels$DefaultImageFieldsModel.class);
        return this.f1979q;
    }

    @Nullable
    public final CommonGraphQLModels$DefaultImageFieldsModel m2070v() {
        this.f1980r = (CommonGraphQLModels$DefaultImageFieldsModel) super.a(this.f1980r, 14, CommonGraphQLModels$DefaultImageFieldsModel.class);
        return this.f1980r;
    }

    @Nullable
    public final CommonGraphQL2Models$DefaultNameFieldsModel m2071w() {
        this.f1981s = (CommonGraphQL2Models$DefaultNameFieldsModel) super.a(this.f1981s, 15, CommonGraphQL2Models$DefaultNameFieldsModel.class);
        return this.f1981s;
    }

    @Nullable
    public final String m2072x() {
        this.f1982t = super.a(this.f1982t, 16);
        return this.f1982t;
    }

    private void m2049a(@Nullable String str) {
        this.f1982t = str;
        if (this.b != null && this.b.d) {
            this.b.a(this.c, 16, str);
        }
    }

    @Nullable
    public final String m2054a() {
        return m2061m();
    }

    public final int jK_() {
        return 2645995;
    }

    public final GraphQLVisitableModel m2053a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        MessagingGeoModel messagingGeoModel;
        CommonGraphQLModels$DefaultImageFieldsModel commonGraphQLModels$DefaultImageFieldsModel;
        CommonGraphQL2Models$DefaultNameFieldsModel commonGraphQL2Models$DefaultNameFieldsModel;
        h();
        if (m2058j() != null) {
            Builder a = ModelHelper.a(m2058j(), graphQLModelMutatingVisitor);
            if (a != null) {
                LoggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel loggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel = (LoggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel) ModelHelper.a(null, this);
                loggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel.f1966d = a.b();
                graphQLVisitableModel = loggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel;
                if (m2050y() != null) {
                    messagingGeoModel = (MessagingGeoModel) graphQLModelMutatingVisitor.b(m2050y());
                    if (m2050y() != messagingGeoModel) {
                        graphQLVisitableModel = (LoggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1975m = messagingGeoModel;
                    }
                }
                if (m2068t() != null) {
                    commonGraphQLModels$DefaultImageFieldsModel = (CommonGraphQLModels$DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m2068t());
                    if (m2068t() != commonGraphQLModels$DefaultImageFieldsModel) {
                        graphQLVisitableModel = (LoggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1978p = commonGraphQLModels$DefaultImageFieldsModel;
                    }
                }
                if (m2069u() != null) {
                    commonGraphQLModels$DefaultImageFieldsModel = (CommonGraphQLModels$DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m2069u());
                    if (m2069u() != commonGraphQLModels$DefaultImageFieldsModel) {
                        graphQLVisitableModel = (LoggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1979q = commonGraphQLModels$DefaultImageFieldsModel;
                    }
                }
                if (m2070v() != null) {
                    commonGraphQLModels$DefaultImageFieldsModel = (CommonGraphQLModels$DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m2070v());
                    if (m2070v() != commonGraphQLModels$DefaultImageFieldsModel) {
                        graphQLVisitableModel = (LoggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1980r = commonGraphQLModels$DefaultImageFieldsModel;
                    }
                }
                if (m2071w() != null) {
                    commonGraphQL2Models$DefaultNameFieldsModel = (CommonGraphQL2Models$DefaultNameFieldsModel) graphQLModelMutatingVisitor.b(m2071w());
                    if (m2071w() != commonGraphQL2Models$DefaultNameFieldsModel) {
                        graphQLVisitableModel = (LoggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1981s = commonGraphQL2Models$DefaultNameFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m2050y() != null) {
            messagingGeoModel = (MessagingGeoModel) graphQLModelMutatingVisitor.b(m2050y());
            if (m2050y() != messagingGeoModel) {
                graphQLVisitableModel = (LoggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f1975m = messagingGeoModel;
            }
        }
        if (m2068t() != null) {
            commonGraphQLModels$DefaultImageFieldsModel = (CommonGraphQLModels$DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m2068t());
            if (m2068t() != commonGraphQLModels$DefaultImageFieldsModel) {
                graphQLVisitableModel = (LoggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f1978p = commonGraphQLModels$DefaultImageFieldsModel;
            }
        }
        if (m2069u() != null) {
            commonGraphQLModels$DefaultImageFieldsModel = (CommonGraphQLModels$DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m2069u());
            if (m2069u() != commonGraphQLModels$DefaultImageFieldsModel) {
                graphQLVisitableModel = (LoggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f1979q = commonGraphQLModels$DefaultImageFieldsModel;
            }
        }
        if (m2070v() != null) {
            commonGraphQLModels$DefaultImageFieldsModel = (CommonGraphQLModels$DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m2070v());
            if (m2070v() != commonGraphQLModels$DefaultImageFieldsModel) {
                graphQLVisitableModel = (LoggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f1980r = commonGraphQLModels$DefaultImageFieldsModel;
            }
        }
        if (m2071w() != null) {
            commonGraphQL2Models$DefaultNameFieldsModel = (CommonGraphQL2Models$DefaultNameFieldsModel) graphQLModelMutatingVisitor.b(m2071w());
            if (m2071w() != commonGraphQL2Models$DefaultNameFieldsModel) {
                graphQLVisitableModel = (LoggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f1981s = commonGraphQL2Models$DefaultNameFieldsModel;
            }
        }
        i();
        if (graphQLVisitableModel != null) {
        }
    }

    public final int m2052a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m2058j());
        int c = flatBufferBuilder.c(m2059k());
        int a2 = flatBufferBuilder.a(m2060l());
        int b = flatBufferBuilder.b(m2061m());
        int a3 = ModelHelper.a(flatBufferBuilder, m2050y());
        int b2 = flatBufferBuilder.b(m2051z());
        int a4 = ModelHelper.a(flatBufferBuilder, m2068t());
        int a5 = ModelHelper.a(flatBufferBuilder, m2069u());
        int a6 = ModelHelper.a(flatBufferBuilder, m2070v());
        int a7 = ModelHelper.a(flatBufferBuilder, m2071w());
        int b3 = flatBufferBuilder.b(m2072x());
        flatBufferBuilder.c(17);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, c);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, b);
        flatBufferBuilder.a(4, this.f1970h);
        flatBufferBuilder.a(5, this.f1971i);
        flatBufferBuilder.a(6, this.f1972j);
        flatBufferBuilder.a(7, this.f1973k);
        flatBufferBuilder.a(8, this.f1974l);
        flatBufferBuilder.b(9, a3);
        flatBufferBuilder.b(10, b2);
        flatBufferBuilder.a(11, this.f1977o);
        flatBufferBuilder.b(12, a4);
        flatBufferBuilder.b(13, a5);
        flatBufferBuilder.b(14, a6);
        flatBufferBuilder.b(15, a7);
        flatBufferBuilder.b(16, b3);
        i();
        return flatBufferBuilder.d();
    }

    public final void m2055a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f1970h = mutableFlatBuffer.a(i, 4);
        this.f1971i = mutableFlatBuffer.a(i, 5);
        this.f1972j = mutableFlatBuffer.a(i, 6);
        this.f1973k = mutableFlatBuffer.a(i, 7);
        this.f1974l = mutableFlatBuffer.a(i, 8);
        this.f1977o = mutableFlatBuffer.a(i, 11);
    }
}
