package com.facebook.feedplugins.attachments.linkshare.follow;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.api.ufiservices.common.GraphQLActorCacheImpl;
import com.facebook.api.ufiservices.common.TogglePageLikeParams;
import com.facebook.api.ufiservices.common.TogglePageLikeParams.Builder;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.controller.mutation.util.ModernFeedbackGraphQLGenerator;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.attachments.linkshare.follow.BaseFollowShareAttachmentPartDefinition.FollowShareButtonState;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLActorCache;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.pages.common.constants.PagesAsyncTaskType;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TItem;I)V */
public class FollowPageShareAttachmentPartDefinition<E extends FeedEnvironment> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, FollowShareAttachmentPersistentState, E, FollowShareAttachmentView> {
    private static FollowPageShareAttachmentPartDefinition f22595g;
    private static final Object f22596h = new Object();
    private final BaseFollowShareAttachmentPartDefinition f22597a;
    private final ClickListenerPartDefinition f22598b;
    public final GraphQLActorCacheImpl f22599c;
    public final TasksManager f22600d;
    public final Lazy<ModernFeedbackGraphQLGenerator> f22601e;
    private final BackgroundPartDefinition f22602f;

    private static FollowPageShareAttachmentPartDefinition m25271b(InjectorLike injectorLike) {
        return new FollowPageShareAttachmentPartDefinition(BaseFollowShareAttachmentPartDefinition.m25264a(injectorLike), ClickListenerPartDefinition.a(injectorLike), GraphQLActorCacheImpl.a(injectorLike), TasksManager.b(injectorLike), IdBasedLazy.a(injectorLike, 997), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m25273a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        FeedEnvironment feedEnvironment = (FeedEnvironment) anyEnvironment;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        subParts.a(this.f22602f, new StylingData(AttachmentProps.e(feedProps), PaddingStyle.m, 2130840174, -1));
        subParts.a(this.f22597a, graphQLStoryAttachment);
        GraphQLStoryActionLink a = ActionLinkHelper.a(graphQLStoryAttachment);
        FollowShareAttachmentPersistentState followShareAttachmentPersistentState = (FollowShareAttachmentPersistentState) feedEnvironment.a(new FollowShareAttachmentKey(feedProps), AttachmentProps.c(feedProps));
        if (followShareAttachmentPersistentState.a == null) {
            followShareAttachmentPersistentState.a(a.ah());
        }
        subParts.a(2131562110, this.f22598b, m25269a(feedProps, followShareAttachmentPersistentState, feedEnvironment));
        return followShareAttachmentPersistentState;
    }

    public final /* bridge */ /* synthetic */ void m25274a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -281653068);
        ((FollowShareAttachmentView) view).setButtonState(((FollowShareAttachmentPersistentState) obj2).a);
        Logger.a(8, EntryType.MARK_POP, 60796003, a);
    }

    public final boolean m25275a(Object obj) {
        return ActionLinkHelper.a((GraphQLStoryAttachment) ((FeedProps) obj).a).ah().j().g() == 2479791;
    }

    public static FollowPageShareAttachmentPartDefinition m25270a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FollowPageShareAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22596h) {
                FollowPageShareAttachmentPartDefinition followPageShareAttachmentPartDefinition;
                if (a2 != null) {
                    followPageShareAttachmentPartDefinition = (FollowPageShareAttachmentPartDefinition) a2.a(f22596h);
                } else {
                    followPageShareAttachmentPartDefinition = f22595g;
                }
                if (followPageShareAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25271b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22596h, b3);
                        } else {
                            f22595g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = followPageShareAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public FollowPageShareAttachmentPartDefinition(BaseFollowShareAttachmentPartDefinition baseFollowShareAttachmentPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, GraphQLActorCache graphQLActorCache, TasksManager tasksManager, Lazy<ModernFeedbackGraphQLGenerator> lazy, BackgroundPartDefinition backgroundPartDefinition) {
        this.f22597a = baseFollowShareAttachmentPartDefinition;
        this.f22598b = clickListenerPartDefinition;
        this.f22599c = graphQLActorCache;
        this.f22600d = tasksManager;
        this.f22601e = lazy;
        this.f22602f = backgroundPartDefinition;
    }

    public final ViewType m25272a() {
        return FollowShareAttachmentView.f22603b;
    }

    private OnClickListener m25269a(FeedProps<GraphQLStoryAttachment> feedProps, FollowShareAttachmentPersistentState followShareAttachmentPersistentState, E e) {
        final GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        final FeedProps<GraphQLStoryAttachment> feedProps2 = feedProps;
        final FollowShareAttachmentPersistentState followShareAttachmentPersistentState2 = followShareAttachmentPersistentState;
        final E e2 = e;
        return new OnClickListener(this) {
            final /* synthetic */ FollowPageShareAttachmentPartDefinition f22594e;

            /* compiled from: TItem;I)V */
            class C19672 extends AbstractDisposableFutureCallback<OperationResult> {
                final /* synthetic */ C19681 f22589a;

                C19672(C19681 c19681) {
                    this.f22589a = c19681;
                }

                public final void m25267a(Object obj) {
                    e2.a(new FeedProps[]{feedProps2});
                }

                protected final void m25268a(Throwable th) {
                    followShareAttachmentPersistentState2.a = FollowShareButtonState.CANNOT_SUBSCRIBE;
                    e2.a(new FeedProps[]{feedProps2});
                }
            }

            public void onClick(View view) {
                FollowShareButtonState followShareButtonState;
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1697350875);
                AttachmentProps.c(feedProps2);
                boolean z = !ActionLinkHelper.a(graphQLStoryAttachment).ah().A();
                FollowShareAttachmentPersistentState followShareAttachmentPersistentState = followShareAttachmentPersistentState2;
                if (z) {
                    followShareButtonState = FollowShareButtonState.LIKED_PAGE;
                } else {
                    followShareButtonState = FollowShareButtonState.LIKE_PAGE;
                }
                followShareAttachmentPersistentState.a = followShareButtonState;
                Builder a2 = TogglePageLikeParams.a();
                a2.a = ActionLinkHelper.a(graphQLStoryAttachment).ah().b();
                a2 = a2;
                a2.b = z;
                Builder builder = a2;
                builder.c = this.f22594e.f22599c.a();
                builder = builder;
                builder.e = "feed_share_link";
                final TogglePageLikeParams a3 = builder.a();
                this.f22594e.f22600d.a(PagesAsyncTaskType.LIKE, new Callable<ListenableFuture<OperationResult>>(this) {
                    final /* synthetic */ C19681 f22588b;

                    public Object call() {
                        return ((ModernFeedbackGraphQLGenerator) this.f22588b.f22594e.f22601e.get()).a(a3);
                    }
                }, new C19672(this));
                LogUtils.a(-127173198, a);
            }
        };
    }
}
