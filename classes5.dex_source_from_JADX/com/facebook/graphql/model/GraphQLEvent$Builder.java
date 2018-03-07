package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLBoostedPostStatus;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventActionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventNotificationSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.facebook.graphql.enums.GraphQLEventType;
import com.facebook.graphql.enums.GraphQLEventVisibility;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: install_messenger_not_now_button */
public class GraphQLEvent$Builder extends Builder {
    public long f3555A;
    public long f3556B;
    @Nullable
    public GraphQLEventCategoryData f3557C;
    @Nullable
    public GraphQLImage f3558D;
    @Nullable
    public String f3559E;
    @Nullable
    public String f3560F;
    @Nullable
    public String f3561G;
    @Nullable
    public GraphQLEventCategoryData f3562H;
    @Nullable
    public GraphQLFocusedPhoto f3563I;
    @Nullable
    public GraphQLActor f3564J;
    @Nullable
    public GraphQLEventDeclinesConnection f3565K;
    @Nullable
    public GraphQLTextWithEntities f3566L;
    @Nullable
    public GraphQLEventHostsConnection f3567M;
    @Nullable
    public GraphQLEventInviteesConnection f3568N;
    public GraphQLEventPrivacyType f3569O = GraphQLEventPrivacyType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLEventMaybesConnection f3570P;
    @Nullable
    public GraphQLEventMembersConnection f3571Q;
    @Nullable
    public GraphQLPlace f3572R;
    public GraphQLEventPrivacyType f3573S = GraphQLEventPrivacyType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public GraphQLBoostedPostStatus f3574T = GraphQLBoostedPostStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLEventTicketProvider f3575U;
    @Nullable
    public String f3576V;
    public GraphQLEventType f3577W = GraphQLEventType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public int f3578X;
    public int f3579Y;
    @Nullable
    public GraphQLEventViewerCapability f3580Z;
    @Nullable
    public GraphQLGeoRectangle aA;
    public int aB;
    @Nullable
    public String aC;
    public ImmutableList<String> aD;
    @Nullable
    public GraphQLStoryAttachment aE;
    @Nullable
    public GraphQLEventDeclinesConnection aF;
    @Nullable
    public GraphQLEventInviteesConnection aG;
    @Nullable
    public GraphQLEventMaybesConnection aH;
    @Nullable
    public GraphQLEventMembersConnection aI;
    @Nullable
    public GraphQLEventWatchersConnection aJ;
    @Nullable
    public GraphQLGroup aK;
    public int aL;
    @Nullable
    public GraphQLImage aM;
    @Nullable
    public String aN;
    public GraphQLPlaceType aO = GraphQLPlaceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public boolean aP;
    @Nullable
    public GraphQLPrivacyScope aQ;
    @Nullable
    public GraphQLPrivacyScope aR;
    @Nullable
    public GraphQLImage aS;
    @Nullable
    public GraphQLImage aT;
    @Nullable
    public GraphQLImage aU;
    @Nullable
    public GraphQLImage aV;
    @Nullable
    public GraphQLImage aW;
    @Nullable
    public GraphQLPhoto aX;
    @Nullable
    public GraphQLImage aY;
    @Nullable
    public GraphQLImage aZ;
    public GraphQLEventVisibility aa = GraphQLEventVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLEventWatchersConnection ab;
    @Nullable
    public GraphQLImage ac;
    @Nullable
    public GraphQLEventDeclinesConnection ad;
    @Nullable
    public GraphQLEventInviteesConnection ae;
    @Nullable
    public GraphQLEventInviteesConnection af;
    @Nullable
    public GraphQLEventMaybesConnection ag;
    @Nullable
    public GraphQLEventMaybesConnection ah;
    @Nullable
    public GraphQLEventMembersConnection ai;
    @Nullable
    public GraphQLEventMembersConnection aj;
    @Nullable
    public GraphQLEventWatchersConnection ak;
    @Nullable
    public GraphQLEventWatchersConnection al;
    @Nullable
    public GraphQLEventMembersConnection am;
    @Nullable
    public GraphQLEventWatchersConnection an;
    @Nullable
    public GraphQLEventInviteesConnection ao;
    @Nullable
    public String ap;
    @Nullable
    public GraphQLImage aq;
    @Nullable
    public GraphQLInlineActivitiesConnection ar;
    public boolean as;
    public boolean at;
    public boolean au;
    public boolean av;
    public boolean aw;
    public boolean ax;
    @Nullable
    public String ay;
    @Nullable
    public GraphQLLocation az;
    @Nullable
    public GraphQLImage ba;
    @Nullable
    public GraphQLImage bb;
    public boolean bc;
    @Nullable
    public GraphQLTimelineAppCollection bd;
    public long be;
    @Nullable
    public GraphQLTextWithEntities bf;
    @Nullable
    public String bg;
    public long bh;
    @Nullable
    public GraphQLStreamingImage bi;
    @Nullable
    public GraphQLTextWithEntities bj;
    public boolean bk;
    @Nullable
    public GraphQLImage bl;
    @Nullable
    public GraphQLEventTimeRange bm;
    @Nullable
    public String bn;
    @Nullable
    public String bo;
    public int bp;
    @Nullable
    public String bq;
    @Nullable
    public String br;
    public GraphQLEventGuestStatus bs = GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public boolean bt;
    public ImmutableList<GraphQLActor> bu;
    public GraphQLEventNotificationSubscriptionLevel bv = GraphQLEventNotificationSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public GraphQLSavedState bw = GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public ImmutableList<GraphQLTimelineAppCollection> bx;
    public ImmutableList<GraphQLTimelineAppCollection> by;
    public GraphQLEventWatchStatus bz = GraphQLEventWatchStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public GraphQLEventActionStyle f3581d = GraphQLEventActionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLAlbum f3582e;
    @Nullable
    public GraphQLEventDeclinesConnection f3583f;
    @Nullable
    public GraphQLEventMaybesConnection f3584g;
    @Nullable
    public GraphQLEventMembersConnection f3585h;
    @Nullable
    public GraphQLInlineActivity f3586i;
    @Nullable
    public GraphQLFocusedPhoto f3587j;
    @Nullable
    public GraphQLStory f3588k;
    public boolean f3589l;
    public boolean f3590m;
    public boolean f3591n;
    public boolean f3592o;
    public boolean f3593p;
    public boolean f3594q;
    public boolean f3595r;
    public boolean f3596s;
    public boolean f3597t;
    @Nullable
    public GraphQLImage f3598u;
    public GraphQLConnectionStyle f3599v = GraphQLConnectionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public String f3600w;
    @Nullable
    public GraphQLFocusedPhoto f3601x;
    @Nullable
    public GraphQLGroup f3602y;
    @Nullable
    public GraphQLStory f3603z;

    public GraphQLEvent$Builder() {
        Preconditions.checkState(this instanceof GraphQLEvent$Builder);
    }
}
