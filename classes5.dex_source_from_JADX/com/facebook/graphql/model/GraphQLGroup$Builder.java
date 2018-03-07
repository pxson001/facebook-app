package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.graphql.enums.GraphQLGroupCategory;
import com.facebook.graphql.enums.GraphQLGroupContentRestrictionReason;
import com.facebook.graphql.enums.GraphQLGroupJoinApprovalSetting;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupPostPermissionSetting;
import com.facebook.graphql.enums.GraphQLGroupPostStatus;
import com.facebook.graphql.enums.GraphQLGroupPushSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupRequestToJoinSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.enums.GraphQLLeavingGroupScenario;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: friends_invited */
public class GraphQLGroup$Builder extends Builder {
    @Nullable
    public GraphQLImage f4139A;
    public ImmutableList<GraphQLPage> f4140B;
    public boolean f4141C;
    public boolean f4142D;
    @Nullable
    public String f4143E;
    @Nullable
    public GraphQLImage f4144F;
    @Nullable
    public GraphQLInlineActivitiesConnection f4145G;
    public boolean f4146H;
    public boolean f4147I;
    public boolean f4148J;
    public GraphQLGroupJoinApprovalSetting f4149K = GraphQLGroupJoinApprovalSetting.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public long f4150L;
    @Nullable
    public String f4151M;
    public ImmutableList<String> f4152N;
    @Nullable
    public GraphQLGroup f4153O;
    @Nullable
    public GraphQLFocusedPhoto f4154P;
    public GraphQLGroupPostPermissionSetting f4155Q = GraphQLGroupPostPermissionSetting.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLPrivacyScope f4156R;
    public GraphQLGroupVisibility f4157S = GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public int f4158T;
    @Nullable
    public GraphQLImage f4159U;
    @Nullable
    public GraphQLImage f4160V;
    @Nullable
    public GraphQLImage f4161W;
    @Nullable
    public GraphQLImage f4162X;
    @Nullable
    public GraphQLImage f4163Y;
    @Nullable
    public GraphQLPhoto f4164Z;
    public boolean aA;
    public int aB;
    public int aC;
    @Nullable
    public GraphQLTextWithEntities aD;
    @Nullable
    public GraphQLTextWithEntities aE;
    public GraphQLGroupAdminType aF = GraphQLGroupAdminType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public ImmutableList<GraphQLGroupContentRestrictionReason> aG;
    public GraphQLGroupJoinState aH = GraphQLGroupJoinState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public long aI;
    public GraphQLLeavingGroupScenario aJ = GraphQLLeavingGroupScenario.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public GraphQLGroupPostStatus aK = GraphQLGroupPostStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public GraphQLGroupPushSubscriptionLevel aL = GraphQLGroupPushSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public GraphQLGroupRequestToJoinSubscriptionLevel aM = GraphQLGroupRequestToJoinSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public GraphQLGroupSubscriptionLevel aN = GraphQLGroupSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public GraphQLGroupVisibility aO = GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLTextWithEntities aP;
    @Nullable
    public GraphQLImage aQ;
    @Nullable
    public GraphQLImage aa;
    @Nullable
    public GraphQLImage ab;
    @Nullable
    public GraphQLImage ac;
    @Nullable
    public GraphQLImage ad;
    public boolean ae;
    public boolean af;
    public boolean ag;
    public boolean ah;
    @Nullable
    public GraphQLFocusedPhoto ai;
    public boolean aj;
    @Nullable
    public GraphQLTextWithEntities ak;
    @Nullable
    public GraphQLStreamingImage al;
    public GraphQLSubscribeStatus am = GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLImage an;
    @Nullable
    public GraphQLAYMTChannel ao;
    @Nullable
    public GraphQLGroupMembersConnection ap;
    @Nullable
    public GraphQLFocusedPhoto aq;
    public int ar;
    @Nullable
    public String as;
    @Nullable
    public String at;
    public boolean au;
    public boolean av;
    @Nullable
    public GraphQLProfile aw;
    public boolean ax;
    public boolean ay;
    public boolean az;
    @Nullable
    public GraphQLGroup f4165d;
    @Nullable
    public GraphQLFocusedPhoto f4166e;
    @Nullable
    public GraphQLImage f4167f;
    public boolean f4168g;
    public boolean f4169h;
    public boolean f4170i;
    public boolean f4171j;
    public boolean f4172k;
    public GraphQLGroupCategory f4173l = GraphQLGroupCategory.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLFocusedPhoto f4174m;
    @Nullable
    public String f4175n;
    @Nullable
    public String f4176o;
    public long f4177p;
    @Nullable
    public GraphQLImage f4178q;
    @Nullable
    public String f4179r;
    @Nullable
    public GraphQLFocusedPhoto f4180s;
    @Nullable
    public GraphQLGroupConfigurationsConnection f4181t;
    @Nullable
    public GraphQLFocusedPhoto f4182u;
    @Nullable
    public GraphQLImage f4183v;
    @Nullable
    public GraphQLMediaSet f4184w;
    @Nullable
    public GraphQLGroupMembersConnection f4185x;
    public int f4186y;
    @Nullable
    public GraphQLGroupOwnerAuthoredStoriesConnection f4187z;

    public GraphQLGroup$Builder() {
        Preconditions.checkState(this instanceof GraphQLGroup$Builder);
    }
}
