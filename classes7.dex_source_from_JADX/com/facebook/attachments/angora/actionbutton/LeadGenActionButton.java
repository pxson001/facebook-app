package com.facebook.attachments.angora.actionbutton;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.angora.AttachmentHasButton;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentView;
import com.facebook.fbui.widget.text.GlyphWithTextView;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLLeadGenDeepLinkUserStatus;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.leadgen.LeadGenActionLinkOnClickListenerProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@ContextScoped
/* compiled from: variables */
public class LeadGenActionButton<E extends HasInvalidate> implements AngoraActionButton<E> {
    private static LeadGenActionButton f815g;
    private static final Object f816h = new Object();
    private final SinglePartDefinition f817a = new LeadGenActionButtonPartDefinition(this);
    public final LeadGenActionLinkOnClickListenerProvider f818b;
    public final Context f819c;
    private final ActionButtonComponent f820d;
    private int f821e;
    private int f822f;

    /* compiled from: variables */
    class LeadGenActionButtonPartDefinition<V extends View & AttachmentHasButton> extends BaseSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, V> {
        final /* synthetic */ LeadGenActionButton f809a;

        public LeadGenActionButtonPartDefinition(LeadGenActionButton leadGenActionButton) {
            this.f809a = leadGenActionButton;
        }

        public final Object m827a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
            FeedProps feedProps = (FeedProps) obj;
            HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
            boolean z = false;
            GraphQLStoryActionLink b = LeadGenActionButton.m834b(feedProps);
            if (StringUtil.a(b.aB())) {
                return new State(false, null, 0, 0, null);
            }
            GraphQLLeadGenDeepLinkUserStatus O = b.O();
            if (O != null && O.j()) {
                z = true;
            }
            String aB = b.aB();
            int a = LeadGenActionButton.m830a(this.f809a, z);
            LeadGenActionButton leadGenActionButton = this.f809a;
            return new State(true, aB, a, LeadGenActionButton.m832b(z), this.f809a.f818b.a(feedProps, this.f809a.f819c, hasInvalidate));
        }

        public final /* bridge */ /* synthetic */ void m828a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
            int a = Logger.a(8, EntryType.MARK_PUSH, -661475499);
            m826a((State) obj2, view);
            Logger.a(8, EntryType.MARK_POP, -363864766, a);
        }

        private static void m826a(State state, V v) {
            GenericActionButtonView actionButton = ((AttachmentHasButton) v).getActionButton();
            if (state.f810a) {
                actionButton.setVisibility(0);
                actionButton.g = false;
                GlyphWithTextView glyphWithTextView = actionButton.a;
                if (state.f813d == 0) {
                    glyphWithTextView.setCompoundDrawablePadding(0);
                } else {
                    glyphWithTextView.setImageResource(state.f813d);
                }
                glyphWithTextView.setTextColor(state.f812c);
                glyphWithTextView.setText(state.f811b);
                glyphWithTextView.setBackgroundResource(2130839739);
                glyphWithTextView.setOnClickListener(state.f814e);
                return;
            }
            actionButton.setVisibility(8);
        }

        public final void m829b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
            if (((AttachmentHasButton) view).getActionButton() != null) {
                ((AttachmentHasButton) view).getActionButton().a();
            }
        }
    }

    /* compiled from: variables */
    public class State {
        public final boolean f810a;
        public final String f811b;
        public final int f812c;
        public final int f813d;
        public final OnClickListener f814e;

        public State(boolean z, String str, int i, int i2, OnClickListener onClickListener) {
            this.f810a = z;
            this.f811b = str;
            this.f812c = i;
            this.f813d = i2;
            this.f814e = onClickListener;
        }
    }

    private static LeadGenActionButton m833b(InjectorLike injectorLike) {
        return new LeadGenActionButton((Context) injectorLike.getInstance(Context.class), (LeadGenActionLinkOnClickListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LeadGenActionLinkOnClickListenerProvider.class), ActionButtonComponent.a(injectorLike));
    }

    public final Component m835a(ComponentContext componentContext, AnyEnvironment anyEnvironment, FeedProps feedProps) {
        HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        GraphQLStoryActionLink b = m834b(feedProps);
        if (StringUtil.a(b.aB())) {
            return null;
        }
        GraphQLLeadGenDeepLinkUserStatus O = b.O();
        boolean z = O != null && O.j();
        ActionButtonComponent$Builder a = this.f820d.a(componentContext).m732a(false).m731a(b.aB());
        a.f643a.f649c = m830a(this, z);
        return a.m737j(m832b(z)).m730a(this.f818b.a(feedProps, this.f819c, hasInvalidate)).d();
    }

    public static LeadGenActionButton m831a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LeadGenActionButton b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f816h) {
                LeadGenActionButton leadGenActionButton;
                if (a2 != null) {
                    leadGenActionButton = (LeadGenActionButton) a2.a(f816h);
                } else {
                    leadGenActionButton = f815g;
                }
                if (leadGenActionButton == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m833b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f816h, b3);
                        } else {
                            f815g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = leadGenActionButton;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public LeadGenActionButton(Context context, LeadGenActionLinkOnClickListenerProvider leadGenActionLinkOnClickListenerProvider, ActionButtonComponent actionButtonComponent) {
        this.f819c = context;
        this.f818b = leadGenActionLinkOnClickListenerProvider;
        this.f820d = actionButtonComponent;
        Resources resources = context.getResources();
        this.f821e = resources.getColor(2131361859);
        this.f822f = resources.getColor(2131362052);
    }

    public final <V extends View & AttachmentHasButton> SinglePartDefinition<FeedProps<GraphQLStoryAttachment>, ?, E, V> m836a() {
        return this.f817a;
    }

    public static GraphQLStoryActionLink m834b(FeedProps<GraphQLStoryAttachment> feedProps) {
        return (GraphQLStoryActionLink) Preconditions.checkNotNull(ActionLinkHelper.a((GraphQLStoryAttachment) feedProps.a, 1185006756));
    }

    public final SinglePartDefinition<FeedProps<GraphQLStoryAttachment>, ?, E, ComponentView> m837b() {
        return null;
    }

    public static int m830a(LeadGenActionButton leadGenActionButton, boolean z) {
        return z ? leadGenActionButton.f821e : leadGenActionButton.f822f;
    }

    public static int m832b(boolean z) {
        return z ? 2130838052 : 0;
    }
}
