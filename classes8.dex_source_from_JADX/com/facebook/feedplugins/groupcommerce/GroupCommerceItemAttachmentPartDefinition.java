package com.facebook.feedplugins.groupcommerce;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.analytics.StoryRenderContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.traversal.GroupPartHolder;
import com.facebook.feed.ui.FeedStoryMessageFlyoutClickWithPositionListener;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.ui.clickwithpositionlistener.ClickWithPositionListenerBinder;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: geo_score */
public class GroupCommerceItemAttachmentPartDefinition<E extends HasPositionInformation & HasFeedListType & HasPersistentState> extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, ClickWithPositionListenerBinder, E> {
    private static final Class f12719a = GroupCommerceItemAttachmentPartDefinition.class;
    private static GroupCommerceItemAttachmentPartDefinition f12720g;
    private static final Object f12721h = new Object();
    private final AbstractFbErrorReporter f12722b;
    private final Provider<FeedStoryMessageFlyoutClickWithPositionListener> f12723c;
    private final GroupCommerceItemAttachmentTitlePartDefinition f12724d;
    private final GroupCommerceItemAttachmentPriceAndPickupPartDefinition f12725e;
    private final GroupCommerceItemAttachmentDescriptionPartDefinition f12726f;

    /* compiled from: geo_score */
    public enum ItemStatus {
        AVAILABLE,
        SOLD,
        EXPIRED
    }

    private static GroupCommerceItemAttachmentPartDefinition m14522b(InjectorLike injectorLike) {
        return new GroupCommerceItemAttachmentPartDefinition(GroupCommerceItemAttachmentTitlePartDefinition.m14538a(injectorLike), GroupCommerceItemAttachmentPriceAndPickupPartDefinition.m14528a(injectorLike), GroupCommerceItemAttachmentDescriptionPartDefinition.m14515a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 1733));
    }

    public final Object m14523a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f12724d, feedProps);
        baseMultiRowSubParts.a(this.f12725e, feedProps);
        baseMultiRowSubParts.a(this.f12726f, feedProps);
        FeedStoryMessageFlyoutClickWithPositionListener feedStoryMessageFlyoutClickWithPositionListener = (FeedStoryMessageFlyoutClickWithPositionListener) this.f12723c.get();
        feedStoryMessageFlyoutClickWithPositionListener.a(AttachmentProps.e(feedProps), StoryRenderContext.GROUP);
        return new ClickWithPositionListenerBinder(feedStoryMessageFlyoutClickWithPositionListener);
    }

    public final void m14524a(Object obj, Object obj2, AnyEnvironment anyEnvironment, GroupPartHolder groupPartHolder) {
        ClickWithPositionListenerBinder clickWithPositionListenerBinder = (ClickWithPositionListenerBinder) obj2;
        if (clickWithPositionListenerBinder != null) {
            clickWithPositionListenerBinder.a(groupPartHolder.a());
        }
    }

    public final boolean m14525a(Object obj) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((FeedProps) obj).a;
        boolean z = (graphQLStoryAttachment == null || graphQLStoryAttachment.z() == null || graphQLStoryAttachment.z().j() == null || graphQLStoryAttachment.z().j().g() != 638661096) ? false : true;
        if (!z) {
            this.f12722b.a(f12719a.getName(), "Corrupt story: GraphQL missing attachment target.");
        }
        return z;
    }

    public final void m14526b(Object obj, Object obj2, AnyEnvironment anyEnvironment, GroupPartHolder groupPartHolder) {
        if (((ClickWithPositionListenerBinder) obj2) != null) {
            ClickWithPositionListenerBinder.b(groupPartHolder.a());
        }
    }

    @Inject
    public GroupCommerceItemAttachmentPartDefinition(GroupCommerceItemAttachmentTitlePartDefinition groupCommerceItemAttachmentTitlePartDefinition, GroupCommerceItemAttachmentPriceAndPickupPartDefinition groupCommerceItemAttachmentPriceAndPickupPartDefinition, GroupCommerceItemAttachmentDescriptionPartDefinition groupCommerceItemAttachmentDescriptionPartDefinition, FbErrorReporter fbErrorReporter, Provider<FeedStoryMessageFlyoutClickWithPositionListener> provider) {
        this.f12724d = groupCommerceItemAttachmentTitlePartDefinition;
        this.f12725e = groupCommerceItemAttachmentPriceAndPickupPartDefinition;
        this.f12726f = groupCommerceItemAttachmentDescriptionPartDefinition;
        this.f12722b = fbErrorReporter;
        this.f12723c = provider;
    }

    public static GroupCommerceItemAttachmentPartDefinition m14521a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupCommerceItemAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12721h) {
                GroupCommerceItemAttachmentPartDefinition groupCommerceItemAttachmentPartDefinition;
                if (a2 != null) {
                    groupCommerceItemAttachmentPartDefinition = (GroupCommerceItemAttachmentPartDefinition) a2.a(f12721h);
                } else {
                    groupCommerceItemAttachmentPartDefinition = f12720g;
                }
                if (groupCommerceItemAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14522b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12721h, b3);
                        } else {
                            f12720g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupCommerceItemAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static ItemStatus m14520a(GraphQLNode graphQLNode) {
        if (graphQLNode.dV()) {
            return ItemStatus.SOLD;
        }
        if (graphQLNode.dM()) {
            return ItemStatus.EXPIRED;
        }
        return ItemStatus.AVAILABLE;
    }
}
