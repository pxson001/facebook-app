package com.facebook.attachments.angora.actionbutton;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.angora.AttachmentHasButton;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentView;
import com.facebook.fbui.widget.text.GlyphWithTextView;
import com.facebook.feed.rows.abtest.ExperimentsForMultipleRowsStoriesAbtestModule;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.share.ShareLauncher;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.graphql.model.StorySharingHelper;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: net_sid */
public class ShareActionButton<E extends AnyEnvironment> implements AngoraActionButton<E> {
    private static ShareActionButton f7243f;
    private static final Object f7244g = new Object();
    public final AbstractFbErrorReporter f7245a;
    public final ShareLauncher f7246b;
    private final QeAccessor f7247c;
    private final ActionButtonComponent f7248d;
    private final SinglePartDefinition f7249e = new ShareActionButtonPartDefinition(this);

    /* compiled from: net_sid */
    class ShareActionButtonPartDefinition<V extends View & AttachmentHasButton> extends BaseSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, OnClickListener, E, V> {
        final /* synthetic */ ShareActionButton f7258a;

        public ShareActionButtonPartDefinition(ShareActionButton shareActionButton) {
            this.f7258a = shareActionButton;
        }

        public final Object m7586a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
            FeedProps e = AttachmentProps.e((FeedProps) obj);
            if (e != null) {
                return new OnShareClickListener(this.f7258a, ShareActionButton.m7571c(e));
            }
            this.f7258a.f7245a.b(ShareActionButton.class.getSimpleName(), "attachment.getParentStory() is null");
            return null;
        }

        public final /* bridge */ /* synthetic */ void m7587a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
            int a = Logger.a(8, EntryType.MARK_PUSH, -1309088660);
            m7585a((OnClickListener) obj2, view);
            Logger.a(8, EntryType.MARK_POP, 217891948, a);
        }

        private static void m7585a(OnClickListener onClickListener, V v) {
            GenericActionButtonView actionButton = ((AttachmentHasButton) v).getActionButton();
            GlyphWithTextView glyphWithTextView = ((AttachmentHasButton) v).getActionButton().f13757a;
            actionButton.setVisibility(0);
            actionButton.f13763g = false;
            glyphWithTextView.setCompoundDrawablePadding(0);
            glyphWithTextView.setText(2131233280);
            glyphWithTextView.setBackgroundResource(2130839739);
            glyphWithTextView.setOnClickListener(onClickListener);
        }

        public final void m7588b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
            if (((AttachmentHasButton) view).getActionButton() != null) {
                ((AttachmentHasButton) view).getActionButton().m14490a();
            }
        }
    }

    private static ShareActionButton m7570b(InjectorLike injectorLike) {
        return new ShareActionButton(ShareLauncher.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ActionButtonComponent.m7576a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ShareActionButton(ShareLauncher shareLauncher, AbstractFbErrorReporter abstractFbErrorReporter, ActionButtonComponent actionButtonComponent, QeAccessor qeAccessor) {
        this.f7246b = shareLauncher;
        this.f7245a = abstractFbErrorReporter;
        this.f7248d = actionButtonComponent;
        this.f7247c = qeAccessor;
    }

    public final boolean m7574a(FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStory c = AttachmentProps.c(feedProps);
        return c != null && StoryHierarchyHelper.d(c) && StoryHierarchyHelper.a(c).j().size() > 0 && StorySharingHelper.b((GraphQLStory) StoryHierarchyHelper.a(c).j().get(0)) && this.f7247c.a(ExperimentsForMultipleRowsStoriesAbtestModule.c, false);
    }

    public static ShareActionButton m7569a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ShareActionButton b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7244g) {
                ShareActionButton shareActionButton;
                if (a2 != null) {
                    shareActionButton = (ShareActionButton) a2.a(f7244g);
                } else {
                    shareActionButton = f7243f;
                }
                if (shareActionButton == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7570b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7244g, b3);
                        } else {
                            f7243f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = shareActionButton;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final <V extends View & AttachmentHasButton> SinglePartDefinition<FeedProps<GraphQLStoryAttachment>, ?, E, V> m7573a() {
        return this.f7249e;
    }

    public final Component m7572a(ComponentContext componentContext, E e, FeedProps<GraphQLStoryAttachment> feedProps) {
        FeedProps e2 = AttachmentProps.e(feedProps);
        if (e2 != null) {
            return this.f7248d.m7579a(componentContext).a(componentContext.getResources().getText(2131233280)).a(new OnShareClickListener(this, m7571c(e2))).d();
        }
        this.f7245a.b(ShareActionButton.class.getSimpleName(), "attachment.getParentStory() is null");
        return null;
    }

    public final SinglePartDefinition<FeedProps<GraphQLStoryAttachment>, ?, E, ComponentView> m7575b() {
        return null;
    }

    public static FeedProps<GraphQLStory> m7571c(FeedProps<GraphQLStory> feedProps) {
        return feedProps.a((GraphQLStory) StoryHierarchyHelper.a((GraphQLStory) feedProps.a).j().get(0));
    }
}
