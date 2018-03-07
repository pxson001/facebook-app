package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.events.widget.eventcard.EventActionButtonState;
import com.facebook.events.widget.eventcard.EventActionButtonStateSelectorProvider;
import com.facebook.events.widget.eventcard.EventActionButtonView;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.ui.EventAttachmentView;
import com.facebook.graphql.model.GraphQLNode;
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
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: order_url */
public class EventActionButtonPartDefinition extends BaseSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, EventActionButtonState, AnyEnvironment, EventAttachmentView> {
    private static EventActionButtonPartDefinition f5968c;
    private static final Object f5969d = new Object();
    private final EventAttachmentActionListenerProvider f5970a;
    private final EventActionButtonStateSelectorProvider f5971b;

    private static EventActionButtonPartDefinition m6423b(InjectorLike injectorLike) {
        return new EventActionButtonPartDefinition((EventAttachmentActionListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EventAttachmentActionListenerProvider.class), (EventActionButtonStateSelectorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EventActionButtonStateSelectorProvider.class));
    }

    public final Object m6424a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        GraphQLNode z = graphQLStoryAttachment.z();
        if (AttachmentProps.c(feedProps) == null || graphQLStoryAttachment.z() == null || !z.aC()) {
            return null;
        }
        return this.f5971b.m6427a(this.f5970a.m6426a(feedProps)).m6525a(z.bn(), z.je(), z.jq());
    }

    public final /* bridge */ /* synthetic */ void m6425a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1576842295);
        EventActionButtonState eventActionButtonState = (EventActionButtonState) obj2;
        EventActionButtonView eventActionButtonView = ((EventAttachmentView) view).f5988g;
        if (eventActionButtonState == null) {
            eventActionButtonView.m6494a();
        } else {
            eventActionButtonView.setVisibility(0);
            eventActionButtonView.m6495a(eventActionButtonState);
        }
        Logger.a(8, EntryType.MARK_POP, -386167111, a);
    }

    @Inject
    public EventActionButtonPartDefinition(EventAttachmentActionListenerProvider eventAttachmentActionListenerProvider, EventActionButtonStateSelectorProvider eventActionButtonStateSelectorProvider) {
        this.f5970a = eventAttachmentActionListenerProvider;
        this.f5971b = eventActionButtonStateSelectorProvider;
    }

    public static EventActionButtonPartDefinition m6422a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EventActionButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5969d) {
                EventActionButtonPartDefinition eventActionButtonPartDefinition;
                if (a2 != null) {
                    eventActionButtonPartDefinition = (EventActionButtonPartDefinition) a2.a(f5969d);
                } else {
                    eventActionButtonPartDefinition = f5968c;
                }
                if (eventActionButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6423b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5969d, b3);
                        } else {
                            f5968c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = eventActionButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
