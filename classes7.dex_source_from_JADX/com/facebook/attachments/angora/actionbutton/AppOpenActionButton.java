package com.facebook.attachments.angora.actionbutton;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.angora.AttachmentHasButton;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentView;
import com.facebook.components.reference.DrawableReference;
import com.facebook.components.reference.Reference;
import com.facebook.directinstall.util.DirectInstallButtonHelper;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.fbui.widget.text.GlyphWithTextView;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLCallToActionStyle;
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
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: video upload error */
public class AppOpenActionButton<E extends AnyEnvironment> implements AngoraActionButton<E> {
    private static AppOpenActionButton f693f;
    private static final Object f694g = new Object();
    private final Context f695a;
    public final DefaultFeedUnitRenderer f696b;
    private final DirectInstallButtonHelper f697c;
    private final SinglePartDefinition f698d = new AddOpenActionButtonPartDefinition(this);
    private final ActionButtonComponent f699e;

    /* compiled from: video upload error */
    class AddOpenActionButtonPartDefinition<V extends View & AttachmentHasButton> extends BaseSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, V> {
        final /* synthetic */ AppOpenActionButton f688a;

        public AddOpenActionButtonPartDefinition(AppOpenActionButton appOpenActionButton) {
            this.f688a = appOpenActionButton;
        }

        public final Object m754a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
            FeedProps feedProps = (FeedProps) obj;
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
            GraphQLStoryActionLink a = ActionLinkHelper.a(graphQLStoryAttachment, -508788748);
            if (AppOpenActionButton.m761b(a)) {
                return new State(AppOpenActionButton.m759a(this.f688a, graphQLStoryAttachment, a), this.f688a.f696b.a(feedProps, a), AppOpenActionButton.m758a(this.f688a, graphQLStoryAttachment), true);
            }
            return new State(null, null, null, false);
        }

        public final /* bridge */ /* synthetic */ void m755a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
            int a = Logger.a(8, EntryType.MARK_PUSH, -1589705300);
            m753a((State) obj2, view);
            Logger.a(8, EntryType.MARK_POP, 479647416, a);
        }

        private static void m753a(State state, V v) {
            GenericActionButtonView actionButton = ((AttachmentHasButton) v).getActionButton();
            if (state.f689a) {
                actionButton.setVisibility(0);
                actionButton.g = false;
                GlyphWithTextView glyphWithTextView = actionButton.a;
                glyphWithTextView.setText(state.f690b);
                glyphWithTextView.setBackgroundResource(2130839739);
                glyphWithTextView.setOnClickListener(state.f691c);
                if (state.f692d != null) {
                    glyphWithTextView.setCompoundDrawables(null, null, state.f692d, null);
                    return;
                }
                return;
            }
            actionButton.setVisibility(8);
        }

        public final void m756b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
            if (((AttachmentHasButton) view).getActionButton() != null) {
                ((AttachmentHasButton) view).getActionButton().a();
            }
        }
    }

    /* compiled from: video upload error */
    public class State {
        public boolean f689a;
        public final String f690b;
        public final OnClickListener f691c;
        public final AutoRotateDrawable f692d;

        public State(String str, OnClickListener onClickListener, AutoRotateDrawable autoRotateDrawable, boolean z) {
            this.f690b = str;
            this.f691c = onClickListener;
            this.f692d = autoRotateDrawable;
            this.f689a = z;
        }
    }

    private static AppOpenActionButton m760b(InjectorLike injectorLike) {
        return new AppOpenActionButton((Context) injectorLike.getInstance(Context.class), DefaultFeedUnitRenderer.a(injectorLike), DirectInstallButtonHelper.b(injectorLike), ActionButtonComponent.a(injectorLike));
    }

    public static AppOpenActionButton m757a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AppOpenActionButton b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f694g) {
                AppOpenActionButton appOpenActionButton;
                if (a2 != null) {
                    appOpenActionButton = (AppOpenActionButton) a2.a(f694g);
                } else {
                    appOpenActionButton = f693f;
                }
                if (appOpenActionButton == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m760b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f694g, b3);
                        } else {
                            f693f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = appOpenActionButton;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public AppOpenActionButton(Context context, DefaultFeedUnitRenderer defaultFeedUnitRenderer, DirectInstallButtonHelper directInstallButtonHelper, ActionButtonComponent actionButtonComponent) {
        this.f695a = context;
        this.f696b = defaultFeedUnitRenderer;
        this.f697c = directInstallButtonHelper;
        this.f699e = actionButtonComponent;
    }

    public final <V extends View & AttachmentHasButton> SinglePartDefinition<FeedProps<GraphQLStoryAttachment>, ?, E, V> m763a() {
        return this.f698d;
    }

    public final Component m762a(ComponentContext componentContext, E e, FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        GraphQLStoryActionLink a = ActionLinkHelper.a(graphQLStoryAttachment, -508788748);
        if (!m761b(a)) {
            return null;
        }
        Reference reference;
        AutoRotateDrawable a2 = m758a(this, graphQLStoryAttachment);
        ActionButtonComponent$Builder a3 = this.f699e.a(componentContext).m731a(m759a(this, graphQLStoryAttachment, a));
        if (a2 == null) {
            reference = null;
        } else {
            reference = DrawableReference.b().a(a2).b();
        }
        a3.f643a.f648b = reference;
        return a3.m730a(this.f696b.a(feedProps, a)).d();
    }

    public final SinglePartDefinition<FeedProps<GraphQLStoryAttachment>, ?, E, ComponentView> m764b() {
        return null;
    }

    public static boolean m761b(GraphQLStoryActionLink graphQLStoryActionLink) {
        return (graphQLStoryActionLink == null || Strings.isNullOrEmpty(graphQLStoryActionLink.aB()) || (graphQLStoryActionLink.T() != GraphQLCallToActionStyle.BUTTON_WITH_TEXT_ONLY && graphQLStoryActionLink.T() != GraphQLCallToActionStyle.VIDEO_DR_STYLE)) ? false : true;
    }

    public static String m759a(AppOpenActionButton appOpenActionButton, GraphQLStoryAttachment graphQLStoryAttachment, GraphQLStoryActionLink graphQLStoryActionLink) {
        String a = appOpenActionButton.f697c.a(graphQLStoryAttachment);
        return a == null ? graphQLStoryActionLink.aB() : a;
    }

    @Nullable
    public static AutoRotateDrawable m758a(AppOpenActionButton appOpenActionButton, GraphQLStoryAttachment graphQLStoryAttachment) {
        if (!DirectInstallButtonHelper.b(graphQLStoryAttachment)) {
            return null;
        }
        int a = SizeUtil.a(appOpenActionButton.f695a, 20.0f);
        AutoRotateDrawable autoRotateDrawable = new AutoRotateDrawable(appOpenActionButton.f695a.getResources().getDrawable(2130840061), 800);
        autoRotateDrawable.setBounds(0, 0, a, a);
        return autoRotateDrawable;
    }
}
