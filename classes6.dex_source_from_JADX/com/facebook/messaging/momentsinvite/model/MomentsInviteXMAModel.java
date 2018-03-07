package com.facebook.messaging.momentsinvite.model;

import com.facebook.messaging.graphql.threads.StoryAttachmentTargetInterfaces.MomentsAppInvitationActionLinkFragment;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: unsubscribee */
public class MomentsInviteXMAModel {
    @Nullable
    public final String f2404a;
    @Nullable
    public final String f2405b;
    public final ImmutableList<String> f2406c;
    @Nullable
    public final String f2407d;
    @Nullable
    public final String f2408e;
    @Nullable
    public final String f2409f;
    public final ImmutableList<? extends MomentsAppInvitationActionLinkFragment> f2410g;
    public final ImmutableList<? extends MomentsAppInvitationActionLinkFragment> f2411h;

    MomentsInviteXMAModel(MomentsInviteXMAModelBuilder momentsInviteXMAModelBuilder) {
        this.f2404a = momentsInviteXMAModelBuilder.f2412a;
        this.f2405b = momentsInviteXMAModelBuilder.f2413b;
        this.f2406c = ImmutableList.copyOf((Collection) Preconditions.checkNotNull(momentsInviteXMAModelBuilder.f2414c));
        this.f2407d = momentsInviteXMAModelBuilder.f2415d;
        this.f2409f = momentsInviteXMAModelBuilder.f2417f;
        this.f2408e = momentsInviteXMAModelBuilder.f2416e;
        this.f2410g = momentsInviteXMAModelBuilder.f2418g;
        this.f2411h = momentsInviteXMAModelBuilder.f2419h;
    }
}
