package com.facebook.messaging.momentsinvite.model;

import com.facebook.messaging.graphql.threads.StoryAttachmentTargetInterfaces.MomentsAppInvitationActionLinkFragment;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: unsubscribe ignored as client has been closed */
public class MomentsInviteXMAModelBuilder {
    @Nullable
    public String f2412a;
    @Nullable
    public String f2413b;
    public List<String> f2414c = Collections.emptyList();
    @Nullable
    public String f2415d;
    @Nullable
    public String f2416e;
    @Nullable
    public String f2417f;
    public ImmutableList<? extends MomentsAppInvitationActionLinkFragment> f2418g = RegularImmutableList.a;
    public ImmutableList<? extends MomentsAppInvitationActionLinkFragment> f2419h = RegularImmutableList.a;

    public static MomentsInviteXMAModelBuilder newBuilder() {
        return new MomentsInviteXMAModelBuilder();
    }

    public final MomentsInviteXMAModelBuilder m3633a(List<String> list) {
        this.f2414c = (List) Preconditions.checkNotNull(list);
        return this;
    }

    public final MomentsInviteXMAModelBuilder m3632a(ImmutableList<? extends MomentsAppInvitationActionLinkFragment> immutableList) {
        this.f2418g = (ImmutableList) Preconditions.checkNotNull(immutableList);
        return this;
    }

    public final MomentsInviteXMAModelBuilder m3634b(ImmutableList<? extends MomentsAppInvitationActionLinkFragment> immutableList) {
        this.f2419h = (ImmutableList) Preconditions.checkNotNull(immutableList);
        return this;
    }

    public final MomentsInviteXMAModel m3635i() {
        return new MomentsInviteXMAModel(this);
    }
}
