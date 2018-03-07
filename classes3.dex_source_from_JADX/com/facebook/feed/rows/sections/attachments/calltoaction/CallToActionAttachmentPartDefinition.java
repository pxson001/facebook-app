package com.facebook.feed.rows.sections.attachments.calltoaction;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachment;
import com.facebook.attachments.angora.AttachmentHasButton;
import com.facebook.attachments.angora.AttachmentHasRating;
import com.facebook.attachments.angora.AttachmentHasSubcontext;
import com.facebook.attachments.utils.CallToActionUtil;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.directinstall.util.DirectInstallButtonHelper;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AngoraClearPartDefinition;
import com.facebook.feed.rows.sections.attachments.calltoaction.CallToActionAttachmentBasePartDefinition.Props;
import com.facebook.feed.rows.sections.attachments.calltoaction.ui.CallToActionAttachmentView;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.ui.attachments.angora.LegacyAngoraAttachmentUtil;
import com.facebook.feedplugins.links.AttachmentCallToActionButtonLinkPartDefinition;
import com.facebook.feedplugins.links.AttachmentLinkClickEventFactory.LinkClickType;
import com.facebook.feedplugins.links.AttachmentLinkClickEventFactoryProvider;
import com.facebook.feedplugins.links.DefaultLinkedViewAdapter;
import com.facebook.feedplugins.links.LinkedViewAdapter;
import com.facebook.fig.attachment.FIGAttachmentView;
import com.facebook.fig.attachment.qe.ExperimentsForFIGAttachmentModule;
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
/* compiled from: _PHOTOS_FEED */
public class CallToActionAttachmentPartDefinition<E extends HasInvalidate & HasPersistentState & HasPositionInformation, V extends View & AngoraAttachment & AttachmentHasSubcontext & AttachmentHasRating> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, V> {
    @VisibleForTesting
    static final AtomicReference<ViewType> f286a = new AtomicReference();
    private static CallToActionAttachmentPartDefinition f287m;
    private static final Object f288n = new Object();
    private final LegacyAngoraAttachmentUtil f289b;
    private final AngoraClearPartDefinition<V> f290c;
    private final BackgroundPartDefinition f291d;
    private final AttachmentCallToActionButtonLinkPartDefinition<E> f292e;
    private final DefaultLinkedViewAdapter f293f;
    private final CallToActionAttachmentLinkedViewAdapter f294g = new CallToActionAttachmentLinkedViewAdapter(this);
    private final DirectInstallButtonHelper f295h;
    private final CallToActionAttachmentBasePartDefinition f296i;
    private final DefaultPaddingStyleResolver f297j;
    private final AttachmentLinkClickEventFactoryProvider f298k;
    private final QeAccessor f299l;

    /* compiled from: _PHOTOS_FEED */
    class CallToActionAttachmentLinkedViewAdapter implements LinkedViewAdapter<V> {
        final /* synthetic */ CallToActionAttachmentPartDefinition f300a;

        public CallToActionAttachmentLinkedViewAdapter(CallToActionAttachmentPartDefinition callToActionAttachmentPartDefinition) {
            this.f300a = callToActionAttachmentPartDefinition;
        }

        public final View m268a(V v) {
            return ((AttachmentHasButton) v).getActionButton();
        }
    }

    private static CallToActionAttachmentPartDefinition m264b(InjectorLike injectorLike) {
        return new CallToActionAttachmentPartDefinition(LegacyAngoraAttachmentUtil.a(injectorLike), BackgroundPartDefinition.a(injectorLike), AngoraClearPartDefinition.a(injectorLike), DefaultLinkedViewAdapter.a(injectorLike), DirectInstallButtonHelper.b(injectorLike), AttachmentCallToActionButtonLinkPartDefinition.a(injectorLike), CallToActionAttachmentBasePartDefinition.a(injectorLike), DefaultPaddingStyleResolver.a(injectorLike), (AttachmentLinkClickEventFactoryProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AttachmentLinkClickEventFactoryProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m266a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f296i, new Props(feedProps, this.f289b, this.f295h));
        subParts.a(this.f292e, new AttachmentCallToActionButtonLinkPartDefinition.Props(feedProps, this.f293f, this.f298k.a(LinkClickType.ATTACHMENT)));
        subParts.a(this.f292e, new AttachmentCallToActionButtonLinkPartDefinition.Props(feedProps, this.f294g, this.f298k.a(LinkClickType.CTA_BUTTON)));
        subParts.a(this.f291d, new StylingData(AttachmentProps.e(feedProps), this.f297j.h(), 2130840313, -1));
        subParts.a(this.f290c, null);
        return null;
    }

    public final boolean m267a(Object obj) {
        return CallToActionUtil.g((GraphQLStoryAttachment) ((FeedProps) obj).a);
    }

    public static CallToActionAttachmentPartDefinition m263a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CallToActionAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f288n) {
                CallToActionAttachmentPartDefinition callToActionAttachmentPartDefinition;
                if (a2 != null) {
                    callToActionAttachmentPartDefinition = (CallToActionAttachmentPartDefinition) a2.a(f288n);
                } else {
                    callToActionAttachmentPartDefinition = f287m;
                }
                if (callToActionAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m264b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f288n, b3);
                        } else {
                            f287m = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = callToActionAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public CallToActionAttachmentPartDefinition(LegacyAngoraAttachmentUtil legacyAngoraAttachmentUtil, BackgroundPartDefinition backgroundPartDefinition, AngoraClearPartDefinition angoraClearPartDefinition, DefaultLinkedViewAdapter defaultLinkedViewAdapter, DirectInstallButtonHelper directInstallButtonHelper, AttachmentCallToActionButtonLinkPartDefinition attachmentCallToActionButtonLinkPartDefinition, CallToActionAttachmentBasePartDefinition callToActionAttachmentBasePartDefinition, DefaultPaddingStyleResolver defaultPaddingStyleResolver, AttachmentLinkClickEventFactoryProvider attachmentLinkClickEventFactoryProvider, QeAccessor qeAccessor) {
        this.f289b = legacyAngoraAttachmentUtil;
        this.f291d = backgroundPartDefinition;
        this.f290c = angoraClearPartDefinition;
        this.f293f = defaultLinkedViewAdapter;
        this.f292e = attachmentCallToActionButtonLinkPartDefinition;
        this.f297j = defaultPaddingStyleResolver;
        this.f295h = directInstallButtonHelper;
        this.f296i = callToActionAttachmentBasePartDefinition;
        this.f298k = attachmentLinkClickEventFactoryProvider;
        this.f299l = qeAccessor;
    }

    public final ViewType<V> m265a() {
        if (f286a.get() == null) {
            f286a.set(this.f299l.a(ExperimentsForFIGAttachmentModule.a, false) ? FIGAttachmentView.h : CallToActionAttachmentView.a);
        }
        return (ViewType) f286a.get();
    }
}
