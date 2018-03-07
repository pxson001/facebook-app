package com.facebook.events.sync;

import com.facebook.events.common.EventsDateUtil;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventCommonFragment;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import java.util.Date;

/* compiled from: fb4a-AuthTokenDebugLogger */
public class FacebookCalendarEvent {
    private Date f7225a;
    private Date f7226b;
    public String f7227c;
    public String f7228d;
    public String f7229e;
    public String f7230f;
    public int f7231g = -1;
    public String f7232h;
    public boolean f7233i;

    public FacebookCalendarEvent(EventCommonFragment eventCommonFragment) {
        this.f7225a = EventsDateUtil.b(eventCommonFragment.dN_());
        this.f7226b = new Date(EventsDateUtil.a(eventCommonFragment.b()) ? eventCommonFragment.b() * 1000 : eventCommonFragment.dN_() * 1000);
        this.f7227c = eventCommonFragment.dM_();
        if (eventCommonFragment.d() == null || eventCommonFragment.d().c() == null) {
            this.f7228d = "";
        } else {
            this.f7228d = eventCommonFragment.d().c().a();
        }
        this.f7230f = eventCommonFragment.z().a();
        this.f7229e = eventCommonFragment.dL_();
        this.f7232h = eventCommonFragment.x();
        this.f7233i = eventCommonFragment.g();
        if (eventCommonFragment.o() == GraphQLEventGuestStatus.GOING) {
            this.f7231g = 1;
        } else if (eventCommonFragment.o() == GraphQLEventGuestStatus.MAYBE) {
            this.f7231g = 0;
        }
    }

    public final Date m8452b() {
        return (Date) this.f7225a.clone();
    }

    public final Date m8453d() {
        return (Date) this.f7226b.clone();
    }
}
