package com.facebook.attachments.angora.actionbutton;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.angora.AttachmentHasButton;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentView;
import com.facebook.fbui.widget.text.GlyphWithTextView;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.util.MessengerAppUtils;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: using  */
public class MessagePageActionButton<E extends AnyEnvironment> implements AngoraActionButton<E> {
    private static MessagePageActionButton f847f;
    private static final Object f848g = new Object();
    private final MessengerAppUtils f849a;
    public final String f850b;
    private final SinglePartDefinition f851c = new MessagePageActionButtonPartDefinition(this);
    public final MessagePageClickListenerFactory f852d;
    private final ActionButtonComponent f853e;

    /* compiled from: using  */
    class MessagePageActionButtonPartDefinition<V extends View & AttachmentHasButton> extends BaseSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, V> {
        final /* synthetic */ MessagePageActionButton f844a;

        public MessagePageActionButtonPartDefinition(MessagePageActionButton messagePageActionButton) {
            this.f844a = messagePageActionButton;
        }

        public final Object m846a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
            return new State(this.f844a.f852d.m859a((FeedProps) obj), MessagePageActionButton.m852c(this.f844a));
        }

        public final /* bridge */ /* synthetic */ void m847a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
            int a = Logger.a(8, EntryType.MARK_PUSH, 2005722829);
            m845a((State) obj2, view);
            Logger.a(8, EntryType.MARK_POP, 1686159312, a);
        }

        private void m845a(State state, V v) {
            GenericActionButtonView actionButton = ((AttachmentHasButton) v).getActionButton();
            actionButton.setVisibility(0);
            actionButton.g = true;
            actionButton.setButtonBackgroundResource(2130840230);
            GlyphWithTextView glyphWithTextView = actionButton.a;
            glyphWithTextView.setContentDescription(this.f844a.f850b);
            glyphWithTextView.setCompoundDrawablePadding(0);
            glyphWithTextView.setOnClickListener(state.f845a);
            glyphWithTextView.setImageResource(state.f846b);
        }

        public final void m848b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
            if (((AttachmentHasButton) view).getActionButton() != null) {
                ((AttachmentHasButton) view).getActionButton().a();
            }
        }
    }

    /* compiled from: using  */
    public class State {
        public final OnClickListener f845a;
        public final int f846b;

        public State(OnClickListener onClickListener, int i) {
            this.f845a = onClickListener;
            this.f846b = i;
        }
    }

    private static MessagePageActionButton m851b(InjectorLike injectorLike) {
        return new MessagePageActionButton((Context) injectorLike.getInstance(Context.class), MessengerAppUtils.a(injectorLike), MessagePageClickListenerFactory.m856a(injectorLike), ActionButtonComponent.a(injectorLike));
    }

    @Inject
    public MessagePageActionButton(Context context, MessengerAppUtils messengerAppUtils, MessagePageClickListenerFactory messagePageClickListenerFactory, ActionButtonComponent actionButtonComponent) {
        this.f849a = messengerAppUtils;
        this.f850b = context.getResources().getString(2131233502);
        this.f852d = messagePageClickListenerFactory;
        this.f853e = actionButtonComponent;
    }

    public static MessagePageActionButton m849a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MessagePageActionButton b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f848g) {
                MessagePageActionButton messagePageActionButton;
                if (a2 != null) {
                    messagePageActionButton = (MessagePageActionButton) a2.a(f848g);
                } else {
                    messagePageActionButton = f847f;
                }
                if (messagePageActionButton == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m851b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f848g, b3);
                        } else {
                            f847f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = messagePageActionButton;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final <V extends View & AttachmentHasButton> SinglePartDefinition<FeedProps<GraphQLStoryAttachment>, ?, E, V> m854a() {
        return this.f851c;
    }

    public final Component m853a(ComponentContext componentContext, E e, FeedProps<GraphQLStoryAttachment> feedProps) {
        return this.f853e.a(componentContext).m732a(true).m737j(m852c(this)).m738k(2130840230).m735b(this.f850b).m730a(this.f852d.m859a((FeedProps) feedProps)).d();
    }

    public final SinglePartDefinition<FeedProps<GraphQLStoryAttachment>, ?, E, ComponentView> m855b() {
        return null;
    }

    public static boolean m850a(MessengerAppUtils messengerAppUtils) {
        return messengerAppUtils.a("16.0") && messengerAppUtils.d();
    }

    public static int m852c(MessagePageActionButton messagePageActionButton) {
        return m850a(messagePageActionButton.f849a) ? 2130838327 : 2130838326;
    }
}
