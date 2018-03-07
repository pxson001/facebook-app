package com.facebook.events.socialcontext;

import android.content.Context;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.events.connectionqe.EventsConnectionExperimentController;
import com.facebook.events.model.Event;
import com.facebook.events.model.EventUser;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventActionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLEvent;
import com.facebook.graphql.model.GraphQLEventMaybesConnection;
import com.facebook.graphql.model.GraphQLEventMaybesEdge;
import com.facebook.graphql.model.GraphQLEventMembersConnection;
import com.facebook.graphql.model.GraphQLEventMembersEdge;
import com.facebook.graphql.model.GraphQLEventWatchersConnection;
import com.facebook.graphql.model.GraphQLEventWatchersEdge;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: header_elements */
public class EventSocialContextFormatter {
    public final Context f11480a;
    private final ViewerContextManager f11481b;
    private boolean f11482c = true;
    public boolean f11483d;

    public static EventSocialContextFormatter m13402b(InjectorLike injectorLike) {
        return new EventSocialContextFormatter(ViewerContextManagerProvider.b(injectorLike), EventsConnectionExperimentController.a(injectorLike), (Context) injectorLike.getInstance(Context.class), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public EventSocialContextFormatter(ViewerContextManager viewerContextManager, EventsConnectionExperimentController eventsConnectionExperimentController, Context context, Boolean bool) {
        this.f11480a = context;
        this.f11483d = bool.booleanValue();
        this.f11481b = viewerContextManager;
    }

    public final String m13407a(Event event) {
        if (event.y) {
            return m13406a();
        }
        if (event.as()) {
            return null;
        }
        if (m13404b(event.u) || event.D() == GraphQLEventGuestStatus.HOST) {
            return this.f11480a.getString(2131239394);
        }
        String an = event.an();
        if (!Strings.isNullOrEmpty(an)) {
            return m13409a(an, event.m, event.l);
        }
        CharSequence a = m13398a(event.ad, event.ac);
        if (this.f11482c && Event.a(event)) {
            if (!StringUtil.a(a)) {
                return a;
            }
            a = m13405c(event.ah, event.ag);
            if (!StringUtil.a(a)) {
                return a;
            }
        } else if (!StringUtil.a(a)) {
            return a;
        } else {
            a = m13403b(event.af, event.ae);
            if (!StringUtil.a(a)) {
                return a;
            }
        }
        if (this.f11482c && Event.a(event)) {
            if (event.C != null) {
                a = m13400a(event.C);
                if (!StringUtil.a(a)) {
                    return a;
                }
            }
        } else if (event.b()) {
            a = m13399a(event.D());
            if (!StringUtil.a(a)) {
                return a;
            }
        }
        if (!Strings.isNullOrEmpty(event.t)) {
            return m13401a(event.t);
        }
        if (event.D) {
            return this.f11480a.getString(2131239399);
        }
        if (!StringUtil.a(event.am)) {
            return this.f11480a.getString(2131239393, new Object[]{event.am});
        } else if (StringUtil.a(event.ak)) {
            return null;
        } else {
            return event.ak;
        }
    }

    public final String m13408a(GraphQLEvent graphQLEvent) {
        if (graphQLEvent.ax()) {
            return m13406a();
        }
        if (Event.a(graphQLEvent.av(), graphQLEvent.bi() * 1000, graphQLEvent.G() * 1000)) {
            return null;
        }
        String H;
        GraphQLActor O = graphQLEvent.O();
        if (O != null) {
            H = O.H();
        } else {
            H = null;
        }
        if (m13404b(H) || graphQLEvent.bt() == GraphQLEventGuestStatus.HOST) {
            return this.f11480a.getString(2131239394);
        }
        CharSequence charSequence;
        if (!(graphQLEvent.bv() == null || graphQLEvent.bv().isEmpty())) {
            H = ((GraphQLActor) graphQLEvent.bv().get(0)).aa();
            if (!Strings.isNullOrEmpty(H)) {
                return m13409a(H, graphQLEvent.j(), graphQLEvent.A());
            }
        }
        GraphQLEventMembersConnection am = graphQLEvent.am();
        if (am == null || am.m() <= 0 || am.j().isEmpty()) {
            charSequence = null;
        } else {
            charSequence = m13398a(am.m(), ((GraphQLEventMembersEdge) am.j().get(0)).a().aa());
        }
        if (this.f11482c && graphQLEvent.A() == GraphQLConnectionStyle.INTERESTED) {
            if (!StringUtil.a(charSequence)) {
                return charSequence;
            }
            GraphQLEventWatchersConnection ao = graphQLEvent.ao();
            if (!(ao == null || ao.m() <= 0 || ao.j().isEmpty())) {
                charSequence = m13405c(ao.m(), ((GraphQLEventWatchersEdge) ao.j().get(0)).a().aa());
                if (!StringUtil.a(charSequence)) {
                    return charSequence;
                }
            }
        } else if (!StringUtil.a(charSequence)) {
            return charSequence;
        } else {
            GraphQLEventMaybesConnection ak = graphQLEvent.ak();
            if (!(ak == null || ak.l() <= 0 || ak.j().isEmpty())) {
                charSequence = m13403b(ak.l(), ((GraphQLEventMaybesEdge) ak.j().get(0)).a().aa());
                if (!StringUtil.a(charSequence)) {
                    return charSequence;
                }
            }
        }
        if (this.f11482c && graphQLEvent.A() == GraphQLConnectionStyle.INTERESTED) {
            if (graphQLEvent.bA() != null) {
                charSequence = m13400a(graphQLEvent.bA());
                if (!StringUtil.a(charSequence)) {
                    return charSequence;
                }
            }
        } else if (graphQLEvent.bt() != null) {
            charSequence = m13399a(graphQLEvent.bt());
            if (!StringUtil.a(charSequence)) {
                return charSequence;
            }
        }
        if (graphQLEvent.aM() != null) {
            H = graphQLEvent.aM().P();
        } else {
            H = null;
        }
        if (!Strings.isNullOrEmpty(H)) {
            return m13401a(H);
        }
        if (graphQLEvent.bx() == GraphQLSavedState.SAVED) {
            return this.f11480a.getString(2131239399);
        }
        GraphQLTextWithEntities bg = graphQLEvent.bg();
        if (bg != null) {
            charSequence = bg.a();
        } else {
            charSequence = null;
        }
        if (!StringUtil.a(charSequence)) {
            return graphQLEvent.bg().toString();
        }
        am = graphQLEvent.V();
        if (am == null || am.a() <= 0) {
            return null;
        }
        charSequence = this.f11480a.getResources().getQuantityString(2131689736, am.a(), new Object[]{Integer.valueOf(am.a())});
        if (StringUtil.a(charSequence)) {
            return null;
        }
        return charSequence;
    }

    public final String m13410b(Event event) {
        if (event.x) {
            return this.f11480a.getString(2131239411);
        }
        if (this.f11482c && event.G) {
            EventUser eventUser = event.ai;
            if (!(eventUser == null || Strings.isNullOrEmpty(eventUser.c))) {
                GraphQLEventActionStyle graphQLEventActionStyle = event.m;
                Context context;
                int i;
                if (graphQLEventActionStyle == GraphQLEventActionStyle.SEND || graphQLEventActionStyle == GraphQLEventActionStyle.SHARE) {
                    context = this.f11480a;
                    if (event.l == GraphQLConnectionStyle.INTERESTED) {
                        i = 2131239401;
                    } else {
                        i = 2131239400;
                    }
                    return context.getString(i, new Object[]{eventUser.c});
                }
                context = this.f11480a;
                if (event.l == GraphQLConnectionStyle.INTERESTED) {
                    int i2;
                    if (this.f11483d) {
                        i2 = 2131239404;
                    } else {
                        i2 = 2131239403;
                    }
                    i = i2;
                } else {
                    i = 2131239402;
                }
                return context.getString(i, new Object[]{eventUser.c});
            }
        }
        return m13407a(event);
    }

    public final String m13409a(String str, @Nullable GraphQLEventActionStyle graphQLEventActionStyle, GraphQLConnectionStyle graphQLConnectionStyle) {
        if ((graphQLEventActionStyle == GraphQLEventActionStyle.SEND || graphQLEventActionStyle == GraphQLEventActionStyle.SHARE) && graphQLConnectionStyle == GraphQLConnectionStyle.INTERESTED) {
            return this.f11480a.getString(2131239401, new Object[]{str});
        }
        return this.f11480a.getString(2131239400, new Object[]{str});
    }

    public final String m13406a() {
        return this.f11480a.getString(2131239410);
    }

    private String m13400a(GraphQLEventWatchStatus graphQLEventWatchStatus) {
        if (graphQLEventWatchStatus == GraphQLEventWatchStatus.GOING) {
            return this.f11480a.getString(2131239396);
        }
        if (graphQLEventWatchStatus == GraphQLEventWatchStatus.WATCHED) {
            return this.f11480a.getString(2131239397);
        }
        return null;
    }

    private String m13399a(GraphQLEventGuestStatus graphQLEventGuestStatus) {
        if (graphQLEventGuestStatus == GraphQLEventGuestStatus.GOING) {
            return this.f11480a.getString(2131239396);
        }
        if (graphQLEventGuestStatus == GraphQLEventGuestStatus.MAYBE) {
            return this.f11480a.getString(2131239395);
        }
        return null;
    }

    private String m13398a(int i, String str) {
        if (i <= 0) {
            return null;
        }
        if (i == 1) {
            return this.f11480a.getResources().getString(2131239405, new Object[]{str});
        }
        int i2 = i - 1;
        return this.f11480a.getResources().getQuantityString(2131689732, i2, new Object[]{str, Integer.valueOf(i2)});
    }

    private String m13403b(int i, String str) {
        if (i <= 0) {
            return null;
        }
        if (i == 1) {
            return this.f11480a.getResources().getString(2131239408, new Object[]{str});
        }
        int i2 = i - 1;
        return this.f11480a.getResources().getQuantityString(2131689735, i2, new Object[]{str, Integer.valueOf(i2)});
    }

    private String m13405c(int i, String str) {
        String str2;
        if (i <= 0) {
            str2 = null;
        } else if (i == 1) {
            str2 = this.f11480a.getResources().getString(2131239406, new Object[]{str});
        } else {
            int i2 = i - 1;
            str2 = this.f11480a.getResources().getQuantityString(2131689733, i2, new Object[]{str, Integer.valueOf(i2)});
        }
        String str3 = str2;
        if (StringUtil.a(str3)) {
            return null;
        }
        return str3;
    }

    private String m13401a(String str) {
        return this.f11480a.getString(2131239409, new Object[]{str});
    }

    private boolean m13404b(String str) {
        String str2 = this.f11481b.d().mUserId;
        return !StringUtil.a(str2) && Objects.equal(str2, str);
    }
}
