package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.events.common.EventsDateUtil;
import com.facebook.events.widget.eventcard.EventAttachmentUtil;
import com.facebook.events.widget.eventcard.EventsCardView;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.LargeImagePartDefinition.Props;
import com.facebook.feed.rows.sections.attachments.linkshare.AngoraAttachmentBackgroundPartDefinition;
import com.facebook.feed.rows.sections.attachments.ui.EventAttachmentView;
import com.facebook.feed.ui.attachments.angora.LegacyAngoraAttachmentUtil;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.graphql.model.GraphQLEvent;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.NodeHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.PartWithIsNeeded;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextOrHiddenPartDefinition;
import java.util.Date;
import javax.inject.Inject;

@ContextScoped
/* compiled from: org.hibernate.proxy. */
public class EventAttachmentPartDefinition<E extends HasInvalidate & HasPersistentState & HasPositionInformation & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, EventAttachmentView> implements PartWithIsNeeded<FeedProps<GraphQLStoryAttachment>> {
    private static final CallerContext f5958a = CallerContext.b(EventAttachmentPartDefinition.class, "newsfeed_angora_attachment_view", "native_newsfeed");
    private static EventAttachmentPartDefinition f5959i;
    private static final Object f5960j = new Object();
    private final Context f5961b;
    private final LegacyAngoraAttachmentUtil f5962c;
    private final EventActionButtonPartDefinition f5963d;
    private final AttachmentLinkPartDefinition<E> f5964e;
    private final AngoraAttachmentBackgroundPartDefinition f5965f;
    private final LargeImagePartDefinition<EventAttachmentView> f5966g;
    private final TextOrHiddenPartDefinition f5967h;

    /* compiled from: org.hibernate.proxy. */
    public class State {
        public final Date f6049a;
        public final CharSequence f6050b;
        public final boolean f6051c;

        public State(Date date, CharSequence charSequence, boolean z) {
            this.f6049a = date;
            this.f6050b = charSequence;
            this.f6051c = z;
        }
    }

    private static EventAttachmentPartDefinition m6416b(InjectorLike injectorLike) {
        return new EventAttachmentPartDefinition((Context) injectorLike.getInstance(Context.class), LegacyAngoraAttachmentUtil.a(injectorLike), EventActionButtonPartDefinition.m6422a(injectorLike), AttachmentLinkPartDefinition.a(injectorLike), AngoraAttachmentBackgroundPartDefinition.a(injectorLike), LargeImagePartDefinition.m6428a(injectorLike), TextOrHiddenPartDefinition.a(injectorLike));
    }

    public final Object m6418a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        boolean z;
        GraphQLImage n;
        Date c;
        FeedProps feedProps = (FeedProps) obj;
        GraphQLPlace graphQLPlace = null;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        subParts.a(this.f5963d, feedProps);
        if (FeedStoryUtil.e(AttachmentProps.a(feedProps))) {
            z = false;
        } else {
            z = true;
        }
        boolean z2 = z;
        if (z2) {
            subParts.a(this.f5965f, feedProps);
        }
        subParts.a(this.f5964e, new AttachmentLinkPartDefinition$Props(feedProps));
        if (graphQLStoryAttachment.r() != null && GraphQLStoryAttachmentUtil.n(graphQLStoryAttachment) != null) {
            n = GraphQLStoryAttachmentUtil.n(graphQLStoryAttachment);
        } else if (graphQLStoryAttachment.z() == null || !NodeHelper.m6531b(graphQLStoryAttachment.z())) {
            n = null;
        } else {
            n = NodeHelper.m6530a(graphQLStoryAttachment.z());
        }
        subParts.a(this.f5966g, new Props(n, f5958a, 1.9318181f));
        String A = graphQLStoryAttachment.A();
        CharSequence a = graphQLStoryAttachment.n() != null ? graphQLStoryAttachment.n().a() : null;
        if (!(graphQLStoryAttachment.j() == null || graphQLStoryAttachment.j().isEmpty())) {
            GraphQLStoryActionLink graphQLStoryActionLink = (GraphQLStoryActionLink) graphQLStoryAttachment.j().get(0);
            if (!(graphQLStoryActionLink == null || graphQLStoryActionLink.a() == null || graphQLStoryActionLink.a().g() != 1511838959)) {
                GraphQLEvent A2 = graphQLStoryActionLink.A();
                if (A2 != null) {
                    c = EventsDateUtil.m6501c(A2.bi());
                    graphQLPlace = A2.W();
                    subParts.a(2131561226, this.f5967h, A);
                    subParts.a(2131561227, this.f5967h, EventsCardView.m6439a(this.f5961b, EventAttachmentUtil.m6503a(graphQLPlace), EventAttachmentUtil.m6504b(graphQLPlace)));
                    return new State(c, a, z2);
                }
            }
        }
        c = null;
        subParts.a(2131561226, this.f5967h, A);
        subParts.a(2131561227, this.f5967h, EventsCardView.m6439a(this.f5961b, EventAttachmentUtil.m6503a(graphQLPlace), EventAttachmentUtil.m6504b(graphQLPlace)));
        return new State(c, a, z2);
    }

    public final /* bridge */ /* synthetic */ void m6419a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1212487757);
        State state = (State) obj2;
        EventAttachmentView eventAttachmentView = (EventAttachmentView) view;
        eventAttachmentView.m6449d();
        eventAttachmentView.m6450e();
        eventAttachmentView.f5990i = true;
        eventAttachmentView.setCalendarFormatStartDate(state.f6049a);
        eventAttachmentView.setSocialContextText(state.f6050b);
        if (state.f6051c) {
            eventAttachmentView.mo543a();
        }
        Logger.a(8, EntryType.MARK_POP, -41003030, a);
    }

    public final void m6421b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((EventAttachmentView) view).m6447b();
    }

    public static EventAttachmentPartDefinition m6415a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EventAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5960j) {
                EventAttachmentPartDefinition eventAttachmentPartDefinition;
                if (a2 != null) {
                    eventAttachmentPartDefinition = (EventAttachmentPartDefinition) a2.a(f5960j);
                } else {
                    eventAttachmentPartDefinition = f5959i;
                }
                if (eventAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6416b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5960j, b3);
                        } else {
                            f5959i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = eventAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public EventAttachmentPartDefinition(Context context, LegacyAngoraAttachmentUtil legacyAngoraAttachmentUtil, EventActionButtonPartDefinition eventActionButtonPartDefinition, AttachmentLinkPartDefinition attachmentLinkPartDefinition, AngoraAttachmentBackgroundPartDefinition angoraAttachmentBackgroundPartDefinition, LargeImagePartDefinition largeImagePartDefinition, TextOrHiddenPartDefinition textOrHiddenPartDefinition) {
        this.f5961b = context;
        this.f5962c = legacyAngoraAttachmentUtil;
        this.f5963d = eventActionButtonPartDefinition;
        this.f5964e = attachmentLinkPartDefinition;
        this.f5965f = angoraAttachmentBackgroundPartDefinition;
        this.f5966g = largeImagePartDefinition;
        this.f5967h = textOrHiddenPartDefinition;
    }

    public final ViewType m6417a() {
        return EventAttachmentView.f5979a;
    }

    public final boolean m6420a(Object obj) {
        return true;
    }
}
