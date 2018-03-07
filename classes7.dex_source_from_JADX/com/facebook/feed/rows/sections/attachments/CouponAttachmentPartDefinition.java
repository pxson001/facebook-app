package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachment;
import com.facebook.attachments.angora.AngoraAttachmentView;
import com.facebook.attachments.angora.AttachmentHasLargeImage;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AttachmentLabelPartDefinition.Props;
import com.facebook.feed.rows.sections.attachments.calltoaction.ActionButtonPartDefinition;
import com.facebook.feed.rows.sections.attachments.linkshare.AngoraAttachmentBackgroundPartDefinition;
import com.facebook.fig.attachment.FIGAttachmentView;
import com.facebook.fig.attachment.qe.ExperimentsForFIGAttachmentModule;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ZoomableViewPager */
public class CouponAttachmentPartDefinition<E extends HasInvalidate & HasPersistentState & HasPositionInformation & HasPrefetcher, V extends View & AngoraAttachment & AttachmentHasLargeImage> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, V> {
    @VisibleForTesting
    static final AtomicReference<ViewType> f20555a = new AtomicReference();
    private static final CallerContext f20556b = CallerContext.b(CouponAttachmentPartDefinition.class, "newsfeed_angora_attachment_view", "native_newsfeed");
    private static CouponAttachmentPartDefinition f20557j;
    private static final Object f20558k = new Object();
    private final AngoraClearPartDefinition<AngoraAttachmentView> f20559c;
    private final AttachmentLabelPartDefinition<V> f20560d;
    private final ActionButtonPartDefinition<E, AngoraAttachmentView> f20561e;
    private final AttachmentLinkPartDefinition<E> f20562f;
    private final AngoraAttachmentBackgroundPartDefinition f20563g;
    private final LargeImagePartDefinition<V> f20564h;
    private final QeAccessor f20565i;

    private static CouponAttachmentPartDefinition m23615b(InjectorLike injectorLike) {
        return new CouponAttachmentPartDefinition(AngoraClearPartDefinition.a(injectorLike), AttachmentLabelPartDefinition.a(injectorLike), ActionButtonPartDefinition.a(injectorLike), AttachmentLinkPartDefinition.a(injectorLike), AngoraAttachmentBackgroundPartDefinition.a(injectorLike), LargeImagePartDefinition.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m23617a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLImage graphQLImage;
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        subParts.a(this.f20560d, new Props(graphQLStoryAttachment.A(), graphQLStoryAttachment.n().a()));
        subParts.a(this.f20561e, feedProps);
        subParts.a(this.f20563g, feedProps);
        subParts.a(this.f20562f, new AttachmentLinkPartDefinition.Props(feedProps));
        if (graphQLStoryAttachment == null || graphQLStoryAttachment.r() == null || graphQLStoryAttachment.r().S() == null) {
            graphQLImage = null;
        } else {
            graphQLImage = graphQLStoryAttachment.r().S();
        }
        GraphQLImage graphQLImage2 = graphQLImage;
        if (graphQLImage2 != null) {
            subParts.a(this.f20564h, new LargeImagePartDefinition.Props(graphQLImage2, f20556b, 3.4f));
        }
        subParts.a(this.f20559c, null);
        return null;
    }

    public static CouponAttachmentPartDefinition m23614a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CouponAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20558k) {
                CouponAttachmentPartDefinition couponAttachmentPartDefinition;
                if (a2 != null) {
                    couponAttachmentPartDefinition = (CouponAttachmentPartDefinition) a2.a(f20558k);
                } else {
                    couponAttachmentPartDefinition = f20557j;
                }
                if (couponAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23615b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20558k, b3);
                        } else {
                            f20557j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = couponAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public CouponAttachmentPartDefinition(AngoraClearPartDefinition angoraClearPartDefinition, AttachmentLabelPartDefinition attachmentLabelPartDefinition, ActionButtonPartDefinition actionButtonPartDefinition, AttachmentLinkPartDefinition attachmentLinkPartDefinition, AngoraAttachmentBackgroundPartDefinition angoraAttachmentBackgroundPartDefinition, LargeImagePartDefinition largeImagePartDefinition, QeAccessor qeAccessor) {
        this.f20559c = angoraClearPartDefinition;
        this.f20560d = attachmentLabelPartDefinition;
        this.f20561e = actionButtonPartDefinition;
        this.f20562f = attachmentLinkPartDefinition;
        this.f20563g = angoraAttachmentBackgroundPartDefinition;
        this.f20564h = largeImagePartDefinition;
        this.f20565i = qeAccessor;
    }

    public final ViewType m23616a() {
        if (f20555a.get() == null) {
            f20555a.set(this.f20565i.a(ExperimentsForFIGAttachmentModule.a, false) ? FIGAttachmentView.h : AngoraAttachmentView.a);
        }
        return (ViewType) f20555a.get();
    }

    public final boolean m23618a(Object obj) {
        return true;
    }
}
