package com.facebook.feed.rows.sections.attachments.calltoaction;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachment;
import com.facebook.attachments.angora.AttachmentHasClear;
import com.facebook.attachments.angora.AttachmentHasLabel;
import com.facebook.attachments.angora.AttachmentHasRating;
import com.facebook.attachments.angora.AttachmentHasSubcontext;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.calltoaction.ui.LeadGenCallToActionAttachmentView;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.ui.attachments.angora.LegacyAngoraAttachmentUtil;
import com.facebook.fig.attachment.FIGAttachmentView;
import com.facebook.fig.attachment.qe.ExperimentsForFIGAttachmentModule;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.leadgen.LeadGenActionLinkOnClickListenerProvider;
import com.facebook.leadgen.LeadGenUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: _PHOTOS_PRIVACY_FEED */
public class LeadGenCallToActionAttachmentPartDefinition<E extends HasInvalidate & HasPositionInformation, V extends View & AngoraAttachment & AttachmentHasSubcontext & AttachmentHasRating> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, V> {
    @VisibleForTesting
    static final AtomicReference<ViewType> f275a = new AtomicReference();
    private static LeadGenCallToActionAttachmentPartDefinition f276j;
    private static final Object f277k = new Object();
    private final BackgroundPartDefinition f278b;
    private final DefaultPaddingStyleResolver f279c;
    private final ClickListenerPartDefinition f280d;
    private final LeadGenUtil f281e;
    private final LegacyAngoraAttachmentUtil f282f;
    private final LeadGenActionLinkOnClickListenerProvider f283g;
    private final ActionButtonPartDefinition<E, V> f284h;
    private final QeAccessor f285i;

    private static LeadGenCallToActionAttachmentPartDefinition m257b(InjectorLike injectorLike) {
        return new LeadGenCallToActionAttachmentPartDefinition(BackgroundPartDefinition.a(injectorLike), DefaultPaddingStyleResolver.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), LeadGenUtil.a(injectorLike), LegacyAngoraAttachmentUtil.a(injectorLike), (LeadGenActionLinkOnClickListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LeadGenActionLinkOnClickListenerProvider.class), ActionButtonPartDefinition.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m259a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        State state = new State(this.f282f.a(graphQLStoryAttachment), LegacyAngoraAttachmentUtil.b(graphQLStoryAttachment));
        subParts.a(this.f280d, this.f283g.a(feedProps, null, hasInvalidate));
        subParts.a(this.f278b, new StylingData(AttachmentProps.e(feedProps), this.f279c.h(), 2130840313, -1));
        subParts.a(this.f284h, feedProps);
        return state;
    }

    public final /* bridge */ /* synthetic */ void m260a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -150539765);
        m256a((State) obj2, view);
        Logger.a(8, EntryType.MARK_POP, 728092757, a);
    }

    public final boolean m261a(Object obj) {
        return LeadGenUtil.a((GraphQLStoryAttachment) ((FeedProps) obj).a) != null;
    }

    public static LeadGenCallToActionAttachmentPartDefinition m255a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LeadGenCallToActionAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f277k) {
                LeadGenCallToActionAttachmentPartDefinition leadGenCallToActionAttachmentPartDefinition;
                if (a2 != null) {
                    leadGenCallToActionAttachmentPartDefinition = (LeadGenCallToActionAttachmentPartDefinition) a2.a(f277k);
                } else {
                    leadGenCallToActionAttachmentPartDefinition = f276j;
                }
                if (leadGenCallToActionAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m257b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f277k, b3);
                        } else {
                            f276j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = leadGenCallToActionAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public LeadGenCallToActionAttachmentPartDefinition(BackgroundPartDefinition backgroundPartDefinition, DefaultPaddingStyleResolver defaultPaddingStyleResolver, ClickListenerPartDefinition clickListenerPartDefinition, LeadGenUtil leadGenUtil, LegacyAngoraAttachmentUtil legacyAngoraAttachmentUtil, LeadGenActionLinkOnClickListenerProvider leadGenActionLinkOnClickListenerProvider, ActionButtonPartDefinition actionButtonPartDefinition, QeAccessor qeAccessor) {
        this.f278b = backgroundPartDefinition;
        this.f279c = defaultPaddingStyleResolver;
        this.f280d = clickListenerPartDefinition;
        this.f281e = leadGenUtil;
        this.f282f = legacyAngoraAttachmentUtil;
        this.f283g = leadGenActionLinkOnClickListenerProvider;
        this.f284h = actionButtonPartDefinition;
        this.f285i = qeAccessor;
    }

    public final ViewType<V> m258a() {
        if (f275a.get() == null) {
            f275a.set(this.f285i.a(ExperimentsForFIGAttachmentModule.a, false) ? FIGAttachmentView.h : LeadGenCallToActionAttachmentView.a);
        }
        return (ViewType) f275a.get();
    }

    private static void m256a(State state, V v) {
        ((AttachmentHasLabel) v).setTitle(state.a);
        ((AttachmentHasLabel) v).setContextText(state.b);
        ((AttachmentHasSubcontext) v).setSubcontextText(null);
        ((AttachmentHasRating) v).setShowRating(false);
        ((AttachmentHasRating) v).setRating(0.0f);
        ((AttachmentHasRating) v).setNumberOfStars(0);
    }

    public final void m262b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((AttachmentHasClear) view).a();
    }
}
