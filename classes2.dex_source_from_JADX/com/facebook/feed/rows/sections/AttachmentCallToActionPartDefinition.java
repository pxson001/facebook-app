package com.facebook.feed.rows.sections;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionPartDefinition;
import com.facebook.feedplugins.creativeediting.FrameCallToActionPartDefinition;
import com.facebook.feedplugins.facecast.CreateLiveVideoCallToActionPartDefinition;
import com.facebook.feedplugins.groups.calltoaction.GroupMemberWelcomeCallToActionPartDefinition;
import com.facebook.feedplugins.mlecalltoaction.GroupsMLEOverlayCallToActionPartDefinition;
import com.facebook.feedplugins.momentscalltoaction.MomentsCallToActionPartDefinition;
import com.facebook.feedplugins.profile.calltoaction.CreateProfilePictureCallToActionPartDefinition;
import com.facebook.feedplugins.profile.calltoaction.CreateProfileVideoCallToActionPartDefinition;
import com.facebook.feedplugins.profile.calltoaction.ProfileGenericCallToActionPartDefinition;
import com.facebook.feedplugins.profile.calltoaction.ProfilePictureOverlayCallToActionPartDefinition;
import com.facebook.feedplugins.sell.ForSaleItemMessageSellerCallToActionPartDefinition;
import com.facebook.feedplugins.treehousepromotcalltoaction.TreehousePromotCallToActionPartDefinition;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import javax.inject.Inject;

@ContextScoped
/* compiled from: inf_hscroll_fetch_result */
public class AttachmentCallToActionPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static AttachmentCallToActionPartDefinition f20174l;
    private static final Object f20175m = new Object();
    private final Lazy<ProfilePictureOverlayCallToActionPartDefinition<FeedEnvironment>> f20176a;
    private final Lazy<CreateProfilePictureCallToActionPartDefinition<FeedEnvironment>> f20177b;
    private final Lazy<CreateProfileVideoCallToActionPartDefinition<FeedEnvironment>> f20178c;
    private final Lazy<CreateLiveVideoCallToActionPartDefinition<FeedEnvironment>> f20179d;
    private final Lazy<ForSaleItemMessageSellerCallToActionPartDefinition<FeedEnvironment>> f20180e;
    private final Lazy<MomentsCallToActionPartDefinition<FeedEnvironment>> f20181f;
    private final Lazy<GroupMemberWelcomeCallToActionPartDefinition<FeedEnvironment>> f20182g;
    private final Lazy<GroupsMLEOverlayCallToActionPartDefinition<FeedEnvironment>> f20183h;
    private final Lazy<ProfileGenericCallToActionPartDefinition<FeedEnvironment>> f20184i;
    private final Lazy<TreehousePromotCallToActionPartDefinition<FeedEnvironment>> f20185j;
    private final Lazy<FrameCallToActionPartDefinition<FeedEnvironment>> f20186k;

    private static AttachmentCallToActionPartDefinition m27849b(InjectorLike injectorLike) {
        return new AttachmentCallToActionPartDefinition(IdBasedLazy.m1808a(injectorLike, 1960), IdBasedLazy.m1808a(injectorLike, 1957), IdBasedLazy.m1808a(injectorLike, 1958), IdBasedLazy.m1808a(injectorLike, 6216), IdBasedLazy.m1808a(injectorLike, 6550), IdBasedLazy.m1808a(injectorLike, 6376), IdBasedLazy.m1808a(injectorLike, 6340), IdBasedLazy.m1808a(injectorLike, 6373), IdBasedLazy.m1808a(injectorLike, 1959), IdBasedLazy.m1808a(injectorLike, 6620), IdBasedLazy.m1808a(injectorLike, 1838));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        boolean ar;
        obj = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) obj.f13444a;
        baseMultiRowSubParts.m19112a((MultiRowPartWithIsNeeded) this.f20176a.get(), obj);
        baseMultiRowSubParts.m19112a((MultiRowPartWithIsNeeded) this.f20182g.get(), obj);
        baseMultiRowSubParts.m19112a((MultiRowPartWithIsNeeded) this.f20183h.get(), obj);
        baseMultiRowSubParts.m19112a((MultiRowPartWithIsNeeded) this.f20177b.get(), obj);
        baseMultiRowSubParts.m19112a((MultiRowPartWithIsNeeded) this.f20178c.get(), obj);
        baseMultiRowSubParts.m19112a((MultiRowPartWithIsNeeded) this.f20184i.get(), obj);
        baseMultiRowSubParts.m19112a((MultiRowPartWithIsNeeded) this.f20179d.get(), obj);
        baseMultiRowSubParts.m19112a((MultiRowPartWithIsNeeded) this.f20180e.get(), obj);
        if (MomentsCallToActionPartDefinition.c(graphQLStory)) {
            ar = ActionLinkHelper.m22935a(StoryAttachmentHelper.m28042o(graphQLStory)).ar();
        } else {
            ar = false;
        }
        if (ar) {
            baseMultiRowSubParts.m19112a((MultiRowPartWithIsNeeded) this.f20181f.get(), obj);
        }
        baseMultiRowSubParts.m19112a((MultiRowPartWithIsNeeded) this.f20185j.get(), obj);
        baseMultiRowSubParts.m19112a((MultiRowPartWithIsNeeded) this.f20186k.get(), obj);
        return null;
    }

    public final boolean mo2536a(Object obj) {
        return ActionLinkCallToActionPartDefinition.m28863b((GraphQLStory) ((FeedProps) obj).f13444a);
    }

    public static AttachmentCallToActionPartDefinition m27848a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AttachmentCallToActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20175m) {
                AttachmentCallToActionPartDefinition attachmentCallToActionPartDefinition;
                if (a2 != null) {
                    attachmentCallToActionPartDefinition = (AttachmentCallToActionPartDefinition) a2.mo818a(f20175m);
                } else {
                    attachmentCallToActionPartDefinition = f20174l;
                }
                if (attachmentCallToActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27849b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20175m, b3);
                        } else {
                            f20174l = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = attachmentCallToActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public AttachmentCallToActionPartDefinition(Lazy<ProfilePictureOverlayCallToActionPartDefinition> lazy, Lazy<CreateProfilePictureCallToActionPartDefinition> lazy2, Lazy<CreateProfileVideoCallToActionPartDefinition> lazy3, Lazy<CreateLiveVideoCallToActionPartDefinition> lazy4, Lazy<ForSaleItemMessageSellerCallToActionPartDefinition> lazy5, Lazy<MomentsCallToActionPartDefinition> lazy6, Lazy<GroupMemberWelcomeCallToActionPartDefinition> lazy7, Lazy<GroupsMLEOverlayCallToActionPartDefinition> lazy8, Lazy<ProfileGenericCallToActionPartDefinition> lazy9, Lazy<TreehousePromotCallToActionPartDefinition> lazy10, Lazy<FrameCallToActionPartDefinition> lazy11) {
        this.f20176a = lazy;
        this.f20177b = lazy2;
        this.f20178c = lazy3;
        this.f20179d = lazy4;
        this.f20180e = lazy5;
        this.f20181f = lazy6;
        this.f20182g = lazy7;
        this.f20183h = lazy8;
        this.f20184i = lazy9;
        this.f20185j = lazy10;
        this.f20186k = lazy11;
    }
}
