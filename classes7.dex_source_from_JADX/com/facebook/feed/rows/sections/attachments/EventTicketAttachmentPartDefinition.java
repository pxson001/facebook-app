package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.events.common.EventsDateUtil;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil;
import com.facebook.events.widget.eventcard.EventAttachmentUtil;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition.Props;
import com.facebook.feed.rows.sections.attachments.linkshare.AngoraAttachmentBackgroundPartDefinition;
import com.facebook.feed.rows.sections.attachments.ui.EventTicketAttachmentView;
import com.facebook.feed.ui.attachments.angora.LegacyAngoraAttachmentUtil;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLEvent;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.links.AttachmentLinkLauncher;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextOrHiddenPartDefinition;
import com.facebook.resources.ui.FbButton;
import com.google.common.collect.ImmutableList;
import java.util.Date;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ZeroUpsellReco */
public class EventTicketAttachmentPartDefinition<E extends HasInvalidate & HasPersistentState & HasPositionInformation & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Boolean, E, EventTicketAttachmentView> {
    private static final CallerContext f20575a = CallerContext.b(EventTicketAttachmentPartDefinition.class, "newsfeed_angora_attachment_view", "native_newsfeed");
    private static EventTicketAttachmentPartDefinition f20576l;
    private static final Object f20577m = new Object();
    private final LegacyAngoraAttachmentUtil f20578b;
    private final EventsDashboardTimeFormatUtil f20579c;
    public final Context f20580d;
    public final AnalyticsLogger f20581e;
    public final AttachmentLinkLauncher f20582f;
    private final AttachmentLinkPartDefinition<E> f20583g;
    private final AngoraAttachmentBackgroundPartDefinition f20584h;
    private final LargeImagePartDefinition<EventTicketAttachmentView> f20585i;
    private final TextOrHiddenPartDefinition f20586j;
    private final ClickListenerPartDefinition f20587k;

    private static EventTicketAttachmentPartDefinition m23625b(InjectorLike injectorLike) {
        return new EventTicketAttachmentPartDefinition(LegacyAngoraAttachmentUtil.a(injectorLike), EventsDashboardTimeFormatUtil.a(injectorLike), (Context) injectorLike.getInstance(Context.class), AnalyticsLoggerMethodAutoProvider.a(injectorLike), AttachmentLinkLauncher.a(injectorLike), AttachmentLinkPartDefinition.a(injectorLike), AngoraAttachmentBackgroundPartDefinition.a(injectorLike), LargeImagePartDefinition.a(injectorLike), TextOrHiddenPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike));
    }

    public final Object m23628a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        String str;
        C17691 c17691;
        boolean z;
        final FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        subParts.a(this.f20584h, feedProps);
        subParts.a(this.f20583g, new Props(feedProps));
        GraphQLImage a = m23624a(graphQLStoryAttachment);
        if (a != null && this.f20578b.a(a, 1.9318181f)) {
            subParts.a(this.f20585i, new LargeImagePartDefinition.Props(a, f20575a, 1.9318181f));
        }
        subParts.a(2131561433, this.f20586j, graphQLStoryAttachment.A());
        subParts.a(2131561434, this.f20586j, m23626b(graphQLStoryAttachment));
        subParts.a(2131561435, this.f20586j, graphQLStoryAttachment.n() != null ? graphQLStoryAttachment.n().a() : null);
        GraphQLStoryAttachment graphQLStoryAttachment2 = (GraphQLStoryAttachment) feedProps.a;
        if (feedProps.c() == null || ActionLinkHelper.a(graphQLStoryAttachment2) == null || StringUtil.a(ActionLinkHelper.a(graphQLStoryAttachment2).aE())) {
            str = null;
        } else {
            str = ActionLinkHelper.a(graphQLStoryAttachment2).aE();
        }
        final String str2 = str;
        ClickListenerPartDefinition clickListenerPartDefinition = this.f20587k;
        if (str2 == null) {
            c17691 = null;
        } else {
            c17691 = new OnClickListener(this) {
                final /* synthetic */ EventTicketAttachmentPartDefinition f20574c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1538357324);
                    HoneyClientEvent honeyClientEvent = new HoneyClientEvent("open_link");
                    honeyClientEvent.a("tracking", TrackableFeedProps.a(feedProps));
                    if (!TrackingNodes.a(honeyClientEvent)) {
                        TrackingNodes.a(honeyClientEvent, view);
                    }
                    this.f20574c.f20581e.a(honeyClientEvent);
                    this.f20574c.f20582f.a(this.f20574c.f20580d, str2, null, null);
                    Logger.a(2, EntryType.UI_INPUT_END, 1011385284, a);
                }
            };
        }
        subParts.a(2131561436, clickListenerPartDefinition, c17691);
        if (str2 != null) {
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public final /* bridge */ /* synthetic */ void m23629a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int i;
        int a = Logger.a(8, EntryType.MARK_PUSH, -477402293);
        Boolean bool = (Boolean) obj2;
        FbButton fbButton = ((EventTicketAttachmentView) view).f21059d;
        if (bool.booleanValue()) {
            i = 0;
        } else {
            i = 8;
        }
        fbButton.setVisibility(i);
        Logger.a(8, EntryType.MARK_POP, -1164056386, a);
    }

    public static EventTicketAttachmentPartDefinition m23623a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EventTicketAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20577m) {
                EventTicketAttachmentPartDefinition eventTicketAttachmentPartDefinition;
                if (a2 != null) {
                    eventTicketAttachmentPartDefinition = (EventTicketAttachmentPartDefinition) a2.a(f20577m);
                } else {
                    eventTicketAttachmentPartDefinition = f20576l;
                }
                if (eventTicketAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23625b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20577m, b3);
                        } else {
                            f20576l = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = eventTicketAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public EventTicketAttachmentPartDefinition(LegacyAngoraAttachmentUtil legacyAngoraAttachmentUtil, EventsDashboardTimeFormatUtil eventsDashboardTimeFormatUtil, Context context, AnalyticsLogger analyticsLogger, AttachmentLinkLauncher attachmentLinkLauncher, AttachmentLinkPartDefinition attachmentLinkPartDefinition, AngoraAttachmentBackgroundPartDefinition angoraAttachmentBackgroundPartDefinition, LargeImagePartDefinition largeImagePartDefinition, TextOrHiddenPartDefinition textOrHiddenPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition) {
        this.f20578b = legacyAngoraAttachmentUtil;
        this.f20579c = eventsDashboardTimeFormatUtil;
        this.f20580d = context;
        this.f20581e = analyticsLogger;
        this.f20582f = attachmentLinkLauncher;
        this.f20583g = attachmentLinkPartDefinition;
        this.f20584h = angoraAttachmentBackgroundPartDefinition;
        this.f20585i = largeImagePartDefinition;
        this.f20586j = textOrHiddenPartDefinition;
        this.f20587k = clickListenerPartDefinition;
    }

    public final ViewType m23627a() {
        return EventTicketAttachmentView.f21056a;
    }

    public final boolean m23630a(Object obj) {
        return true;
    }

    private GraphQLImage m23624a(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment.r() != null && GraphQLStoryAttachmentUtil.n(graphQLStoryAttachment) != null && this.f20578b.a(GraphQLStoryAttachmentUtil.n(graphQLStoryAttachment), 1.9318181f)) {
            return GraphQLStoryAttachmentUtil.n(graphQLStoryAttachment);
        }
        ImmutableList j = graphQLStoryAttachment.j();
        int size = j.size();
        for (int i = 0; i < size; i++) {
            GraphQLStoryActionLink graphQLStoryActionLink = (GraphQLStoryActionLink) j.get(i);
            if (!(graphQLStoryActionLink == null || graphQLStoryActionLink.a() == null || graphQLStoryActionLink.a().g() != -1610739178)) {
                GraphQLEvent A = graphQLStoryActionLink.A();
                if (!(A == null || A.C() == null || A.C().j() == null || A.C().j().L() == null || !this.f20578b.a(A.C().j().L(), 1.9318181f))) {
                    return A.C().j().L();
                }
            }
        }
        return null;
    }

    @Nullable
    private CharSequence m23626b(GraphQLStoryAttachment graphQLStoryAttachment) {
        CharSequence charSequence;
        ImmutableList j = graphQLStoryAttachment.j();
        int size = j.size();
        int i = 0;
        CharSequence charSequence2 = null;
        Date date = null;
        while (i < size) {
            Date c;
            String a;
            Object obj;
            GraphQLStoryActionLink graphQLStoryActionLink = (GraphQLStoryActionLink) j.get(i);
            if (!(graphQLStoryActionLink == null || graphQLStoryActionLink.a() == null || graphQLStoryActionLink.a().g() != -1610739178)) {
                GraphQLEvent A = graphQLStoryActionLink.A();
                if (A != null) {
                    c = EventsDateUtil.c(A.bi());
                    a = EventAttachmentUtil.a(A.W());
                    i++;
                    date = c;
                    obj = a;
                }
            }
            charSequence = charSequence2;
            c = date;
            i++;
            date = c;
            obj = a;
        }
        charSequence = date != null ? this.f20579c.i(date) : null;
        if (!TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(charSequence2)) {
            return this.f20580d.getResources().getString(2131235686, new Object[]{charSequence, charSequence2});
        } else if (!TextUtils.isEmpty(charSequence)) {
            return charSequence;
        } else {
            if (TextUtils.isEmpty(charSequence2)) {
                return null;
            }
            return charSequence2;
        }
    }
}
