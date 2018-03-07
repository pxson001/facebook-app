package com.facebook.feedplugins.attachments.linkshare.follow;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.attachments.linkshare.follow.BaseFollowShareAttachmentPartDefinition.FollowShareButtonState;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.calls.ActorSubscribeInputData;
import com.facebook.graphql.calls.ActorUnsubscribeInputData.SubscribeLocation;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TITLE_LENGTH */
public class FollowUserShareAttachmentPartDefinition<E extends FeedEnvironment> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, FollowShareAttachmentPersistentState, E, FollowShareAttachmentView> {
    private static FollowUserShareAttachmentPartDefinition f22610d;
    private static final Object f22611e = new Object();
    private final BaseFollowShareAttachmentPartDefinition f22612a;
    private final ClickListenerPartDefinition f22613b;
    private final BackgroundPartDefinition f22614c;

    private static FollowUserShareAttachmentPartDefinition m25279b(InjectorLike injectorLike) {
        return new FollowUserShareAttachmentPartDefinition(BaseFollowShareAttachmentPartDefinition.m25264a(injectorLike), ClickListenerPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m25281a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final FeedProps feedProps = (FeedProps) obj;
        final FeedEnvironment feedEnvironment = (FeedEnvironment) anyEnvironment;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        subParts.a(this.f22614c, new StylingData(AttachmentProps.e(feedProps), PaddingStyle.m, 2130840174, -1));
        subParts.a(this.f22612a, graphQLStoryAttachment);
        GraphQLStoryActionLink a = ActionLinkHelper.a(graphQLStoryAttachment);
        final FollowShareAttachmentPersistentState followShareAttachmentPersistentState = (FollowShareAttachmentPersistentState) feedEnvironment.a(new FollowShareAttachmentKey(feedProps), AttachmentProps.c(feedProps));
        if (followShareAttachmentPersistentState.a == null) {
            followShareAttachmentPersistentState.a(a.ah());
        }
        subParts.a(2131562110, this.f22613b, new OnClickListener(this) {
            final /* synthetic */ FollowUserShareAttachmentPartDefinition f22609d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 211995365);
                GraphQLProfile ah = ActionLinkHelper.a((GraphQLStoryAttachment) feedProps.a).ah();
                if (ah.ar() == GraphQLSubscribeStatus.IS_SUBSCRIBED || followShareAttachmentPersistentState.a == FollowShareButtonState.FOLLOWING_USER) {
                    feedEnvironment.b(ah.b(), String.valueOf(SubscribeLocation.FEED_SHARE_LINK));
                    followShareAttachmentPersistentState.a = FollowShareButtonState.FOLLOW_USER;
                    feedEnvironment.a(new FeedProps[]{feedProps});
                } else {
                    feedEnvironment.a(ah.b(), String.valueOf(ActorSubscribeInputData.SubscribeLocation.FEED_SHARE_LINK));
                    followShareAttachmentPersistentState.a = FollowShareButtonState.FOLLOWING_USER;
                    feedEnvironment.a(new FeedProps[]{feedProps});
                }
                LogUtils.a(438208816, a);
            }
        });
        return followShareAttachmentPersistentState;
    }

    public final /* bridge */ /* synthetic */ void m25282a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -313926982);
        FollowShareAttachmentPersistentState followShareAttachmentPersistentState = (FollowShareAttachmentPersistentState) obj2;
        FollowShareAttachmentView followShareAttachmentView = (FollowShareAttachmentView) view;
        Flattenable flattenable = ((FeedProps) obj).a;
        followShareAttachmentView.setButtonState(followShareAttachmentPersistentState.a);
        Logger.a(8, EntryType.MARK_POP, 749103260, a);
    }

    public final boolean m25283a(Object obj) {
        return ActionLinkHelper.a((GraphQLStoryAttachment) ((FeedProps) obj).a).ah().j().g() == 2645995;
    }

    @Inject
    public FollowUserShareAttachmentPartDefinition(BaseFollowShareAttachmentPartDefinition baseFollowShareAttachmentPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f22612a = baseFollowShareAttachmentPartDefinition;
        this.f22613b = clickListenerPartDefinition;
        this.f22614c = backgroundPartDefinition;
    }

    public final ViewType m25280a() {
        return FollowShareAttachmentView.f22603b;
    }

    public static FollowUserShareAttachmentPartDefinition m25278a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FollowUserShareAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22611e) {
                FollowUserShareAttachmentPartDefinition followUserShareAttachmentPartDefinition;
                if (a2 != null) {
                    followUserShareAttachmentPartDefinition = (FollowUserShareAttachmentPartDefinition) a2.a(f22611e);
                } else {
                    followUserShareAttachmentPartDefinition = f22610d;
                }
                if (followUserShareAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25279b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22611e, b3);
                        } else {
                            f22610d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = followUserShareAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
