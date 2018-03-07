package com.facebook.feedplugins.instantarticles;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachment;
import com.facebook.attachments.angora.AttachmentHasPlayIcon;
import com.facebook.attachments.angora.actionbutton.GenericActionButtonView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.text.GlyphWithTextView;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AttachmentLabelPartDefinition;
import com.facebook.feed.rows.sections.attachments.AttachmentLabelPartDefinition.Props;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition;
import com.facebook.feed.rows.sections.attachments.linkshare.BaseShareAttachmentPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feed.ui.attachments.angora.LegacyAngoraAttachmentUtil;
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
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.richdocument.abtest.ExperimentsForRichDocumentAbtestModule;
import javax.inject.Inject;

@ContextScoped
/* compiled from: coordinate */
public class InstantArticleAttachmentLabelPartDefinition<E extends HasInvalidate & HasImageLoadListener & HasPersistentState & HasPositionInformation & HasPrefetcher, V extends View & AngoraAttachment & AttachmentHasPlayIcon> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, AngoraInstantArticleAttachmentLabelView> {
    private static InstantArticleAttachmentLabelPartDefinition f7968f;
    private static final Object f7969g = new Object();
    private final AttachmentLinkPartDefinition f7970a;
    private final BackgroundPartDefinition f7971b;
    private final AttachmentLabelPartDefinition<V> f7972c;
    private final LegacyAngoraAttachmentUtil f7973d;
    public final boolean f7974e;

    private static InstantArticleAttachmentLabelPartDefinition m9045b(InjectorLike injectorLike) {
        return new InstantArticleAttachmentLabelPartDefinition(AttachmentLinkPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike), AttachmentLabelPartDefinition.a(injectorLike), LegacyAngoraAttachmentUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m9047a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        subParts.a(this.f7972c, new Props(BaseShareAttachmentPartDefinition.a(this.f7973d, graphQLStoryAttachment), LegacyAngoraAttachmentUtil.b(graphQLStoryAttachment)));
        subParts.a(this.f7970a, new AttachmentLinkPartDefinition.Props(feedProps));
        float a = PaddingStyle.h.s.d.a(1);
        Builder f = Builder.f();
        f.b = 0.0f;
        f = f;
        f.c = 0.0f;
        f = f;
        f.e = 0.0f;
        f = f;
        f.d = a;
        subParts.a(this.f7971b, new StylingData(AttachmentProps.e(feedProps), f.i(), -1, -1));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m9048a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1237369500);
        AngoraInstantArticleAttachmentLabelView angoraInstantArticleAttachmentLabelView = (AngoraInstantArticleAttachmentLabelView) view;
        if (this.f7974e) {
            GenericActionButtonView actionButton = angoraInstantArticleAttachmentLabelView.getActionButton();
            if (actionButton != null) {
                actionButton.setVisibility(0);
                GlyphWithTextView glyphWithTextView = actionButton.a;
                glyphWithTextView.setText(angoraInstantArticleAttachmentLabelView.getContext().getResources().getString(2131235559));
                glyphWithTextView.setBackgroundResource(2130839739);
                actionButton.g = false;
                glyphWithTextView.setCompoundDrawablePadding(0);
                glyphWithTextView.setFocusable(false);
                glyphWithTextView.setClickable(false);
            }
        }
        Logger.a(8, EntryType.MARK_POP, -92080379, a);
    }

    public final void m9050b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        GenericActionButtonView actionButton = ((AngoraInstantArticleAttachmentLabelView) view).getActionButton();
        if (actionButton != null) {
            actionButton.a();
        }
    }

    @Inject
    public InstantArticleAttachmentLabelPartDefinition(AttachmentLinkPartDefinition attachmentLinkPartDefinition, BackgroundPartDefinition backgroundPartDefinition, AttachmentLabelPartDefinition attachmentLabelPartDefinition, LegacyAngoraAttachmentUtil legacyAngoraAttachmentUtil, QeAccessor qeAccessor) {
        this.f7970a = attachmentLinkPartDefinition;
        this.f7971b = backgroundPartDefinition;
        this.f7972c = attachmentLabelPartDefinition;
        this.f7973d = legacyAngoraAttachmentUtil;
        this.f7974e = qeAccessor.a(ExperimentsForRichDocumentAbtestModule.e, true);
    }

    public static InstantArticleAttachmentLabelPartDefinition m9044a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstantArticleAttachmentLabelPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7969g) {
                InstantArticleAttachmentLabelPartDefinition instantArticleAttachmentLabelPartDefinition;
                if (a2 != null) {
                    instantArticleAttachmentLabelPartDefinition = (InstantArticleAttachmentLabelPartDefinition) a2.a(f7969g);
                } else {
                    instantArticleAttachmentLabelPartDefinition = f7968f;
                }
                if (instantArticleAttachmentLabelPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9045b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7969g, b3);
                        } else {
                            f7968f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = instantArticleAttachmentLabelPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m9049a(Object obj) {
        return true;
    }

    public final ViewType m9046a() {
        return AngoraInstantArticleAttachmentLabelView.f7967a;
    }
}
