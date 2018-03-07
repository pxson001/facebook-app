package com.facebook.attachments.angora.actionbutton;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.angora.AttachmentHasButton;
import com.facebook.attachments.angora.actionbutton.ctamessagesend.CtaMessageSendActionLinkHandlerProvider;
import com.facebook.attachments.angora.actionbutton.ctamessagesend.CtaMessageSendActionLinkOnClickListener;
import com.facebook.attachments.angora.actionbutton.ctamessagesend.CtaMessageSendActionLinkOnClickListenerProvider;
import com.facebook.attachments.angora.actionbutton.ctamessagesend.CtaMessageSendLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentView;
import com.facebook.fbui.widget.text.GlyphWithTextView;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLCallToActionStyle;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.graphql.model.ActionLinkHelper;
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
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: destination */
public class LinkOpenActionButton<E extends AnyEnvironment> implements AngoraActionButton<E> {
    private static LinkOpenActionButton f13969f;
    private static final Object f13970g = new Object();
    public final DefaultFeedUnitRenderer f13971a;
    private final SinglePartDefinition f13972b = new LinkOpenActionButtonPartDefinition(this);
    private final ActionButtonComponent f13973c;
    public final CtaMessageSendActionLinkOnClickListenerProvider f13974d;
    public final QeAccessor f13975e;

    /* compiled from: destination */
    class LinkOpenActionButtonPartDefinition<V extends View & AttachmentHasButton> extends BaseSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, V> {
        final /* synthetic */ LinkOpenActionButton f13976a;

        public LinkOpenActionButtonPartDefinition(LinkOpenActionButton linkOpenActionButton) {
            this.f13976a = linkOpenActionButton;
        }

        public final Object m14758a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
            OnClickListener ctaMessageSendActionLinkOnClickListener;
            FeedProps feedProps = (FeedProps) obj;
            GraphQLStoryActionLink a = ActionLinkHelper.a((GraphQLStoryAttachment) feedProps.a, -508788748);
            LinkOpenActionButton linkOpenActionButton = this.f13976a;
            boolean a2 = LinkOpenActionButton.m14752a(a);
            String aB = a2 ? a.aB() : null;
            if (this.f13976a.f13975e.a(ExperimentsForAttachmentsAngoraModule.f13977a, false) && a != null && a.W() == GraphQLCallToActionType.MESSAGE_PAGE) {
                CtaMessageSendActionLinkOnClickListenerProvider ctaMessageSendActionLinkOnClickListenerProvider = this.f13976a.f13974d;
                ctaMessageSendActionLinkOnClickListener = new CtaMessageSendActionLinkOnClickListener(feedProps, (CtaMessageSendActionLinkHandlerProvider) ctaMessageSendActionLinkOnClickListenerProvider.getOnDemandAssistedProviderForStaticDi(CtaMessageSendActionLinkHandlerProvider.class), CtaMessageSendLogger.a(ctaMessageSendActionLinkOnClickListenerProvider), (AbstractFbErrorReporter) FbErrorReporterImpl.a(ctaMessageSendActionLinkOnClickListenerProvider));
            } else {
                ctaMessageSendActionLinkOnClickListener = this.f13976a.f13971a.a(feedProps, a);
            }
            return new State(a2, aB, ctaMessageSendActionLinkOnClickListener);
        }

        public final /* bridge */ /* synthetic */ void m14759a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
            int a = Logger.a(8, EntryType.MARK_PUSH, 1760823676);
            m14757a((State) obj2, view);
            Logger.a(8, EntryType.MARK_POP, -468832490, a);
        }

        private static void m14757a(State state, V v) {
            GenericActionButtonView actionButton = ((AttachmentHasButton) v).getActionButton();
            if (state.f13986a) {
                GlyphWithTextView glyphWithTextView = ((AttachmentHasButton) v).getActionButton().f13757a;
                actionButton.setVisibility(0);
                actionButton.f13763g = false;
                glyphWithTextView.setCompoundDrawablePadding(0);
                glyphWithTextView.setText(state.f13987b);
                glyphWithTextView.setBackgroundResource(2130839739);
                glyphWithTextView.setOnClickListener(state.f13988c);
                return;
            }
            actionButton.setVisibility(8);
        }

        public final void m14760b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
            if (((AttachmentHasButton) view).getActionButton() != null) {
                ((AttachmentHasButton) view).getActionButton().m14490a();
            }
        }
    }

    /* compiled from: destination */
    public class State {
        public final boolean f13986a;
        public final String f13987b;
        public final OnClickListener f13988c;

        public State(boolean z, String str, OnClickListener onClickListener) {
            this.f13986a = z;
            this.f13987b = str;
            this.f13988c = onClickListener;
        }
    }

    private static LinkOpenActionButton m14753b(InjectorLike injectorLike) {
        return new LinkOpenActionButton(DefaultFeedUnitRenderer.a(injectorLike), ActionButtonComponent.m7576a(injectorLike), (CtaMessageSendActionLinkOnClickListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CtaMessageSendActionLinkOnClickListenerProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public static LinkOpenActionButton m14751a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LinkOpenActionButton b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13970g) {
                LinkOpenActionButton linkOpenActionButton;
                if (a2 != null) {
                    linkOpenActionButton = (LinkOpenActionButton) a2.a(f13970g);
                } else {
                    linkOpenActionButton = f13969f;
                }
                if (linkOpenActionButton == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14753b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13970g, b3);
                        } else {
                            f13969f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = linkOpenActionButton;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public LinkOpenActionButton(DefaultFeedUnitRenderer defaultFeedUnitRenderer, ActionButtonComponent actionButtonComponent, CtaMessageSendActionLinkOnClickListenerProvider ctaMessageSendActionLinkOnClickListenerProvider, QeAccessor qeAccessor) {
        this.f13971a = defaultFeedUnitRenderer;
        this.f13973c = actionButtonComponent;
        this.f13974d = ctaMessageSendActionLinkOnClickListenerProvider;
        this.f13975e = qeAccessor;
    }

    public final <V extends View & AttachmentHasButton> SinglePartDefinition<FeedProps<GraphQLStoryAttachment>, ?, E, V> m14755a() {
        return this.f13972b;
    }

    public final Component m14754a(ComponentContext componentContext, E e, FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStoryActionLink a = ActionLinkHelper.a((GraphQLStoryAttachment) feedProps.a, -508788748);
        return this.f13973c.m7579a(componentContext).a(m14752a(a) ? a.aB() : null).a(this.f13971a.a(feedProps, a)).d();
    }

    public final SinglePartDefinition<FeedProps<GraphQLStoryAttachment>, ?, E, ComponentView> m14756b() {
        return null;
    }

    public static boolean m14752a(GraphQLStoryActionLink graphQLStoryActionLink) {
        return (graphQLStoryActionLink == null || Strings.isNullOrEmpty(graphQLStoryActionLink.aB()) || (graphQLStoryActionLink.T() != GraphQLCallToActionStyle.BUTTON_WITH_TEXT_ONLY && graphQLStoryActionLink.T() != GraphQLCallToActionStyle.VIDEO_DR_STYLE)) ? false : true;
    }
}
