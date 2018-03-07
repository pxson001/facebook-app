package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition.Props;
import com.facebook.feed.rows.sections.attachments.ui.TeamsSportsAttachmentView;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLSportsDataMatchData;
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
import com.facebook.multirow.parts.TextPartDefinition;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: WindowManager is null! */
public class SportsMatchScorePartDefinition<E extends HasInvalidate & HasPersistentState & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, TeamsSportsAttachmentView> {
    public static final ViewType f20805a = new C17771();
    private static final CallerContext f20806b = CallerContext.a(SportsMatchScorePartDefinition.class, "newsfeed_angora_attachment_view");
    private static SportsMatchScorePartDefinition f20807h;
    private static final Object f20808i = new Object();
    private final BackgroundPartDefinition f20809c;
    private final DefaultPaddingStyleResolver f20810d;
    private final TextPartDefinition f20811e;
    private final TeamScoreLogoPartDefinition f20812f;
    private final AttachmentLinkPartDefinition<E> f20813g;

    /* compiled from: WindowManager is null! */
    final class C17771 extends ViewType {
        C17771() {
        }

        public final View m23764a(Context context) {
            return new TeamsSportsAttachmentView(context);
        }
    }

    /* compiled from: WindowManager is null! */
    public class TeamData {
        public final String f20801a;
        public final String f20802b;
        public final int f20803c;
        public final CallerContext f20804d;

        public TeamData(String str, String str2, int i, CallerContext callerContext) {
            this.f20801a = str;
            this.f20802b = str2;
            this.f20803c = i;
            this.f20804d = callerContext;
        }
    }

    private static SportsMatchScorePartDefinition m23767b(InjectorLike injectorLike) {
        return new SportsMatchScorePartDefinition(BackgroundPartDefinition.a(injectorLike), DefaultPaddingStyleResolver.a(injectorLike), TextPartDefinition.a(injectorLike), TeamScoreLogoPartDefinition.m23777a(injectorLike), AttachmentLinkPartDefinition.a(injectorLike));
    }

    public final Object m23769a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        Builder a = Builder.a();
        a.b = -this.f20810d.d();
        a = a;
        a.c = -this.f20810d.e();
        subParts.a(this.f20809c, new StylingData(AttachmentProps.e(feedProps), a.i(), 2130843438, -1));
        GraphQLSportsDataMatchData hI = graphQLStoryAttachment.z().hI();
        TeamData teamData = new TeamData(hI.k().aG(), m23766a(hI.k()), hI.p(), f20806b);
        TeamData teamData2 = new TeamData(hI.u().aG(), m23766a(hI.u()), hI.z(), f20806b);
        subParts.a(2131564243, this.f20811e, teamData.f20801a);
        subParts.a(2131564248, this.f20811e, teamData2.f20801a);
        subParts.a(2131563416, this.f20811e, hI.H());
        subParts.a(2131567573, this.f20812f, teamData);
        subParts.a(2131567575, this.f20812f, teamData2);
        subParts.a(this.f20813g, new Props(feedProps));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m23770a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 2071469506);
        TeamsSportsAttachmentView teamsSportsAttachmentView = (TeamsSportsAttachmentView) view;
        CharSequence q = ((GraphQLStoryAttachment) ((FeedProps) obj).a).z().hI().q();
        if (q == null || q.equals("")) {
            teamsSportsAttachmentView.f21103a.setVisibility(8);
        } else {
            teamsSportsAttachmentView.f21103a.setText(q);
        }
        Logger.a(8, EntryType.MARK_POP, -1613234965, a);
    }

    public final boolean m23771a(Object obj) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((FeedProps) obj).a;
        return (graphQLStoryAttachment.z() == null || graphQLStoryAttachment.z().hI() == null || graphQLStoryAttachment.z().hI().k() == null || graphQLStoryAttachment.z().hI().u() == null) ? false : true;
    }

    public static SportsMatchScorePartDefinition m23765a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SportsMatchScorePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20808i) {
                SportsMatchScorePartDefinition sportsMatchScorePartDefinition;
                if (a2 != null) {
                    sportsMatchScorePartDefinition = (SportsMatchScorePartDefinition) a2.a(f20808i);
                } else {
                    sportsMatchScorePartDefinition = f20807h;
                }
                if (sportsMatchScorePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23767b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20808i, b3);
                        } else {
                            f20807h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = sportsMatchScorePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SportsMatchScorePartDefinition(BackgroundPartDefinition backgroundPartDefinition, DefaultPaddingStyleResolver defaultPaddingStyleResolver, TextPartDefinition textPartDefinition, TeamScoreLogoPartDefinition teamScoreLogoPartDefinition, AttachmentLinkPartDefinition attachmentLinkPartDefinition) {
        this.f20809c = backgroundPartDefinition;
        this.f20810d = defaultPaddingStyleResolver;
        this.f20811e = textPartDefinition;
        this.f20812f = teamScoreLogoPartDefinition;
        this.f20813g = attachmentLinkPartDefinition;
    }

    public final ViewType<TeamsSportsAttachmentView> m23768a() {
        return f20805a;
    }

    @Nullable
    private static String m23766a(GraphQLPage graphQLPage) {
        return (graphQLPage == null || graphQLPage.bs() == null) ? null : graphQLPage.bs().b();
    }
}
