package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.enums.GraphQLSubstoriesGroupingReason;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: WORK_MANAGER_GROUP */
public class GraphQLPeopleYouMayInviteFeedUnit$Builder extends Builder {
    @Nullable
    public String f12439A;
    @Nullable
    public GraphQLStoryHeader f12440B;
    public ImmutableList<GraphQLSubstoriesGroupingReason> f12441C;
    @Nullable
    public GraphQLTextWithEntities f12442D;
    @Nullable
    public GraphQLTextWithEntities f12443E;
    @Nullable
    public String f12444F;
    @Nullable
    public String f12445G;
    @Nullable
    PropertyBag f12446H = null;
    public ImmutableList<GraphQLStoryActionLink> f12447d;
    public ImmutableList<GraphQLActor> f12448e;
    @Nullable
    public GraphQLPeopleYouMayInviteFeedUnitContactsConnection f12449f;
    @Nullable
    public GraphQLImage f12450g;
    public ImmutableList<GraphQLStoryAttachment> f12451h;
    @Nullable
    public String f12452i;
    public long f12453j;
    @Nullable
    public String f12454k;
    @Nullable
    public GraphQLFeedback f12455l;
    @Nullable
    public GraphQLFeedbackContext f12456m;
    public long f12457n;
    @Nullable
    public String f12458o;
    @Nullable
    public String f12459p;
    @Nullable
    public String f12460q;
    @Nullable
    public String f12461r;
    public int f12462s;
    @Nullable
    public GraphQLTextWithEntities f12463t;
    public ImmutableList<GraphQLStoryAttachment> f12464u;
    @Nullable
    public GraphQLNegativeFeedbackActionsConnection f12465v;
    @Nullable
    public GraphQLTextWithEntities f12466w;
    @Nullable
    public GraphQLPrivacyScope f12467x;
    public GraphQLStorySeenState f12468y = GraphQLStorySeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLEntity f12469z;

    public GraphQLPeopleYouMayInviteFeedUnit$Builder() {
        Preconditions.checkState(this instanceof GraphQLPeopleYouMayInviteFeedUnit$Builder);
    }

    public static GraphQLPeopleYouMayInviteFeedUnit$Builder m20642a(GraphQLPeopleYouMayInviteFeedUnit graphQLPeopleYouMayInviteFeedUnit) {
        GraphQLPeopleYouMayInviteFeedUnit$Builder graphQLPeopleYouMayInviteFeedUnit$Builder = new GraphQLPeopleYouMayInviteFeedUnit$Builder();
        graphQLPeopleYouMayInviteFeedUnit.h();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12447d = graphQLPeopleYouMayInviteFeedUnit.s();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12448e = graphQLPeopleYouMayInviteFeedUnit.t();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12449f = graphQLPeopleYouMayInviteFeedUnit.u();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12450g = graphQLPeopleYouMayInviteFeedUnit.x();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12451h = graphQLPeopleYouMayInviteFeedUnit.z();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12452i = graphQLPeopleYouMayInviteFeedUnit.g();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12453j = graphQLPeopleYouMayInviteFeedUnit.A();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12454k = graphQLPeopleYouMayInviteFeedUnit.S_();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12455l = graphQLPeopleYouMayInviteFeedUnit.B();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12456m = graphQLPeopleYouMayInviteFeedUnit.C();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12457n = graphQLPeopleYouMayInviteFeedUnit.T_();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12458o = graphQLPeopleYouMayInviteFeedUnit.y();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12459p = graphQLPeopleYouMayInviteFeedUnit.D();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12460q = graphQLPeopleYouMayInviteFeedUnit.R();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12461r = graphQLPeopleYouMayInviteFeedUnit.S();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12462s = graphQLPeopleYouMayInviteFeedUnit.T();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12463t = graphQLPeopleYouMayInviteFeedUnit.E();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12464u = graphQLPeopleYouMayInviteFeedUnit.F();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12465v = graphQLPeopleYouMayInviteFeedUnit.G();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12466w = graphQLPeopleYouMayInviteFeedUnit.H();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12467x = graphQLPeopleYouMayInviteFeedUnit.I();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12468y = graphQLPeopleYouMayInviteFeedUnit.J();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12469z = graphQLPeopleYouMayInviteFeedUnit.K();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12439A = graphQLPeopleYouMayInviteFeedUnit.L();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12440B = graphQLPeopleYouMayInviteFeedUnit.M();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12441C = graphQLPeopleYouMayInviteFeedUnit.N();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12442D = graphQLPeopleYouMayInviteFeedUnit.O();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12443E = graphQLPeopleYouMayInviteFeedUnit.P();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12444F = graphQLPeopleYouMayInviteFeedUnit.k();
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12445G = graphQLPeopleYouMayInviteFeedUnit.Q();
        Builder.a(graphQLPeopleYouMayInviteFeedUnit$Builder, graphQLPeopleYouMayInviteFeedUnit);
        graphQLPeopleYouMayInviteFeedUnit$Builder.f12446H = (PropertyBag) graphQLPeopleYouMayInviteFeedUnit.U_().clone();
        return graphQLPeopleYouMayInviteFeedUnit$Builder;
    }

    public final GraphQLPeopleYouMayInviteFeedUnit m20643a() {
        return new GraphQLPeopleYouMayInviteFeedUnit(this);
    }
}
