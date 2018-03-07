package com.facebook.events.data;

import android.database.Cursor;
import com.facebook.common.util.StringUtil;
import com.facebook.events.data.EventsCommonContract.EventsCommonTable.Columns;
import com.facebook.events.model.Event;
import com.facebook.events.model.Event.Builder;
import com.facebook.events.model.EventType;
import com.facebook.events.model.EventUser;
import com.facebook.events.model.EventUser.EventUserType;
import com.facebook.events.model.EventViewerCapability;
import com.facebook.events.model.PrivacyKind;
import com.facebook.events.model.PrivacyType;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventActionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.inject.InjectorLike;

/* compiled from: TexFromCam Render */
public class EventsDAO {
    private int f24310A;
    private int f24311B;
    private int f24312C;
    private int f24313D;
    private int f24314E;
    private int f24315F;
    private int f24316G;
    private int f24317H;
    private int f24318I;
    private int f24319J;
    private int f24320K;
    private int f24321L;
    private int f24322M;
    private int f24323N;
    private int f24324O;
    private int f24325P;
    private int f24326Q;
    private int f24327R;
    private int f24328S;
    private int f24329T;
    private int f24330U;
    private int f24331V;
    private int f24332W;
    private int f24333X;
    private int f24334Y;
    private int f24335Z;
    private int f24336a;
    private int aa;
    private int ab;
    private int ac;
    private int ad;
    private int ae;
    private int af;
    private int ag;
    private int ah;
    private Cursor ai;
    private int f24337b;
    private int f24338c;
    private int f24339d;
    private int f24340e;
    private int f24341f;
    private int f24342g;
    private int f24343h;
    private int f24344i;
    private int f24345j;
    private int f24346k;
    private int f24347l;
    private int f24348m;
    private int f24349n;
    private int f24350o;
    private int f24351p;
    private int f24352q;
    private int f24353r;
    private int f24354s;
    private int f24355t;
    private int f24356u;
    private int f24357v;
    private int f24358w;
    private int f24359x;
    private int f24360y;
    private int f24361z;

    public static EventsDAO m26207a(InjectorLike injectorLike) {
        return new EventsDAO();
    }

    public EventsDAO(Cursor cursor) {
        m26210a(cursor);
    }

    public final void m26210a(Cursor cursor) {
        this.ai = cursor;
        if (cursor != null) {
            this.f24336a = cursor.getColumnIndex(Columns.f24274b.d);
            this.f24337b = cursor.getColumnIndex(Columns.f24275c.d);
            this.f24338c = cursor.getColumnIndex(Columns.f24276d.d);
            this.f24339d = cursor.getColumnIndex(Columns.f24277e.d);
            this.f24340e = cursor.getColumnIndex(Columns.f24278f.d);
            this.f24341f = cursor.getColumnIndex(Columns.f24279g.d);
            this.f24342g = cursor.getColumnIndex(Columns.f24280h.d);
            this.f24343h = cursor.getColumnIndex(Columns.f24281i.d);
            this.f24344i = cursor.getColumnIndex(Columns.f24287o.d);
            this.f24345j = cursor.getColumnIndex(Columns.f24282j.d);
            this.f24346k = cursor.getColumnIndex(Columns.f24283k.d);
            this.f24347l = cursor.getColumnIndex(Columns.f24284l.d);
            this.f24348m = cursor.getColumnIndex(Columns.f24285m.d);
            this.f24349n = cursor.getColumnIndex(Columns.f24286n.d);
            this.f24350o = cursor.getColumnIndex(Columns.f24288p.d);
            this.f24351p = cursor.getColumnIndex(Columns.f24289q.d);
            this.f24352q = cursor.getColumnIndex(Columns.f24290r.d);
            this.f24353r = cursor.getColumnIndex(Columns.f24291s.d);
            this.f24354s = cursor.getColumnIndex(Columns.f24292t.d);
            this.f24355t = cursor.getColumnIndex(Columns.f24293u.d);
            this.f24356u = cursor.getColumnIndex(Columns.f24294v.d);
            this.f24359x = cursor.getColumnIndex(Columns.f24295w.d);
            this.f24357v = cursor.getColumnIndex(Columns.f24296x.d);
            this.f24358w = cursor.getColumnIndex(Columns.f24297y.d);
            this.f24360y = cursor.getColumnIndex(Columns.f24298z.d);
            this.f24361z = cursor.getColumnIndex(Columns.f24247A.d);
            this.f24310A = cursor.getColumnIndex(Columns.f24248B.d);
            this.f24311B = cursor.getColumnIndex(Columns.f24249C.d);
            this.f24312C = cursor.getColumnIndex(Columns.f24250D.d);
            this.f24313D = cursor.getColumnIndex(Columns.f24251E.d);
            this.f24314E = cursor.getColumnIndex(Columns.f24252F.d);
            this.f24315F = cursor.getColumnIndex(Columns.f24254H.d);
            this.f24316G = cursor.getColumnIndex(Columns.f24255I.d);
            this.f24317H = cursor.getColumnIndex(Columns.f24256J.d);
            this.f24318I = cursor.getColumnIndex(Columns.f24257K.d);
            this.f24319J = cursor.getColumnIndex(Columns.f24258L.d);
            this.f24320K = cursor.getColumnIndex(Columns.f24259M.d);
            this.f24321L = cursor.getColumnIndex(Columns.f24260N.d);
            this.f24322M = cursor.getColumnIndex(Columns.f24261O.d);
            this.f24323N = cursor.getColumnIndex(Columns.f24262P.d);
            this.f24324O = cursor.getColumnIndex(Columns.f24264R.d);
            this.f24325P = cursor.getColumnIndex(Columns.f24263Q.d);
            this.f24326Q = cursor.getColumnIndex(Columns.f24265S.d);
            this.f24327R = cursor.getColumnIndex(Columns.f24266T.d);
            this.f24328S = cursor.getColumnIndex(Columns.f24267U.d);
            this.f24329T = cursor.getColumnIndex(Columns.f24268V.d);
            this.f24330U = cursor.getColumnIndex(Columns.f24269W.d);
            this.f24331V = cursor.getColumnIndex(Columns.f24270X.d);
            this.f24332W = cursor.getColumnIndex(Columns.f24271Y.d);
            this.f24333X = cursor.getColumnIndex(Columns.f24272Z.d);
            this.f24334Y = cursor.getColumnIndex(Columns.aa.d);
            this.f24335Z = cursor.getColumnIndex(Columns.ab.d);
            this.aa = cursor.getColumnIndex(Columns.ac.d);
            this.ab = cursor.getColumnIndex(Columns.ad.d);
            this.ac = cursor.getColumnIndex(Columns.ae.d);
            this.ad = cursor.getColumnIndex(Columns.af.d);
            this.ae = cursor.getColumnIndex(Columns.ag.d);
            this.af = cursor.getColumnIndex(Columns.aj.d);
            this.ag = cursor.getColumnIndex(Columns.ah.d);
            this.ah = cursor.getColumnIndex(Columns.ai.d);
        }
    }

    public final boolean m26212a(int i) {
        return this.ai.moveToPosition(i);
    }

    public final boolean m26211a() {
        return this.ai.moveToFirst();
    }

    public final int m26213b() {
        return this.ai == null ? 0 : this.ai.getCount();
    }

    public final long m26214c() {
        return EventsTableProviderHelper.m26221a(this.ai, this.f24315F, 0);
    }

    public final Event m26215d() {
        return m26208b(this.ai);
    }

    private Event m26208b(Cursor cursor) {
        GraphQLEventPrivacyType fromString;
        EventType valueOf;
        PrivacyKind valueOf2;
        PrivacyType valueOf3;
        boolean z = true;
        Builder builder = new Builder();
        builder.a = EventsTableProviderHelper.m26228i(cursor, this.f24336a);
        builder.b = EventsTableProviderHelper.m26228i(cursor, this.f24337b);
        builder.c = EventsTableProviderHelper.m26223a(cursor, this.f24338c, this.f24339d);
        String i = EventsTableProviderHelper.m26228i(cursor, this.f24340e);
        if (i != null) {
            fromString = GraphQLEventPrivacyType.fromString(i);
        } else {
            fromString = null;
        }
        builder.d = fromString;
        i = EventsTableProviderHelper.m26228i(cursor, this.f24341f);
        if (i != null) {
            valueOf = EventType.valueOf(i);
        } else {
            valueOf = null;
        }
        builder.e = valueOf;
        i = EventsTableProviderHelper.m26228i(cursor, this.f24342g);
        if (i != null) {
            valueOf2 = PrivacyKind.valueOf(i);
        } else {
            valueOf2 = null;
        }
        builder.f = valueOf2;
        i = EventsTableProviderHelper.m26228i(cursor, this.f24343h);
        if (i != null) {
            valueOf3 = PrivacyType.valueOf(i);
        } else {
            valueOf3 = null;
        }
        builder.g = valueOf3;
        builder.l = GraphQLConnectionStyle.fromString(EventsTableProviderHelper.m26228i(cursor, this.f24345j));
        builder.m = GraphQLEventActionStyle.fromString(EventsTableProviderHelper.m26228i(cursor, this.f24346k));
        builder.h = EventsTableProviderHelper.m26226a(cursor, this.f24347l, false);
        builder.i = EventsTableProviderHelper.m26226a(cursor, this.f24348m, false);
        builder.j = EventsTableProviderHelper.m26226a(cursor, this.f24349n, false);
        builder.k = EventsTableProviderHelper.m26226a(cursor, this.f24344i, false);
        builder.q = EventsTableProviderHelper.m26228i(cursor, this.f24350o);
        builder.r = EventsTableProviderHelper.m26228i(cursor, this.f24351p);
        builder.s = EventsTableProviderHelper.m26228i(cursor, this.f24352q);
        builder.t = EventsTableProviderHelper.m26228i(cursor, this.f24353r);
        builder.u = EventsTableProviderHelper.m26228i(cursor, this.f24354s);
        builder.v = EventsTableProviderHelper.m26228i(cursor, this.f24355t);
        builder.w = EventsTableProviderHelper.m26228i(cursor, this.f24356u);
        builder.x = EventsTableProviderHelper.m26226a(cursor, this.f24359x, false);
        builder.y = EventsTableProviderHelper.m26226a(cursor, this.f24357v, false);
        builder.z = EventsTableProviderHelper.m26221a(cursor, this.f24358w, -1);
        GraphQLEventGuestStatus fromString2 = GraphQLEventGuestStatus.fromString(EventsTableProviderHelper.m26228i(cursor, this.f24361z));
        builder.A = EventsTableProviderHelper.m26226a(cursor, this.f24360y, true);
        builder.B = fromString2;
        builder.C = GraphQLEventWatchStatus.fromString(EventsTableProviderHelper.m26228i(cursor, this.f24310A));
        builder.D = EventsTableProviderHelper.m26226a(cursor, this.f24311B, false);
        builder.E = EventsTableProviderHelper.m26228i(cursor, this.f24312C);
        builder.F = EventsTableProviderHelper.m26228i(cursor, this.f24313D);
        int i2 = this.f24314E;
        if (fromString2 != GraphQLEventGuestStatus.INVITED) {
            z = false;
        }
        builder.G = EventsTableProviderHelper.m26226a(cursor, i2, z);
        builder.H = EventsTableProviderHelper.m26229j(cursor, this.f24315F);
        builder.I = EventsTableProviderHelper.m26229j(cursor, this.f24316G);
        builder.J = EventsTableProviderHelper.m26230k(cursor, this.f24317H);
        builder.K = EventsTableProviderHelper.m26226a(cursor, this.f24318I, false);
        builder.O = EventsTableProviderHelper.m26228i(cursor, this.f24319J);
        double a = EventsTableProviderHelper.m26220a(cursor, this.f24320K, Double.NaN);
        double a2 = EventsTableProviderHelper.m26220a(cursor, this.f24321L, Double.NaN);
        builder.M = EventsTableProviderHelper.m26221a(cursor, this.f24322M, -1);
        builder.N = EventsTableProviderHelper.m26228i(cursor, this.f24323N);
        Object i3 = EventsTableProviderHelper.m26228i(cursor, this.f24324O);
        if (!StringUtil.a(i3)) {
            builder.Q = new GraphQLObjectType(i3).g();
        }
        if (!(Double.isNaN(a2) || Double.isNaN(a))) {
            builder.a(a, a2);
        }
        builder.P = EventsTableProviderHelper.m26230k(cursor, this.f24325P);
        builder.S = EventsTableProviderHelper.m26231l(cursor, this.f24326Q);
        builder.T = EventsTableProviderHelper.m26228i(cursor, this.f24327R);
        builder.U = EventsTableProviderHelper.m26231l(cursor, this.f24328S);
        builder.V = EventsTableProviderHelper.m26231l(cursor, this.f24329T);
        builder.W = EventsTableProviderHelper.m26231l(cursor, this.f24330U);
        Long o = EventsTableProviderHelper.m26233o(cursor, this.f24331V);
        if (o == null) {
            o = Long.valueOf(0);
        }
        builder.a(EventViewerCapability.deserializeCapabilities(o.longValue()));
        builder.n = EventsTableProviderHelper.m26228i(cursor, this.f24332W);
        builder.o = EventsTableProviderHelper.m26227b(cursor, this.f24333X, 0);
        builder.p = EventsTableProviderHelper.m26232m(cursor, this.f24334Y);
        builder.aa = EventsTableProviderHelper.m26228i(cursor, this.f24335Z);
        builder.ab = EventsTableProviderHelper.m26227b(cursor, this.aa, 0);
        builder.ac = EventsTableProviderHelper.m26228i(cursor, this.ab);
        builder.ad = EventsTableProviderHelper.m26227b(cursor, this.ac, 0);
        builder.ae = EventsTableProviderHelper.m26228i(cursor, this.ad);
        builder.af = EventsTableProviderHelper.m26227b(cursor, this.ae, 0);
        builder.ag = m26209e();
        return builder.b();
    }

    private EventUser m26209e() {
        Object i = EventsTableProviderHelper.m26228i(this.ai, this.af);
        if (StringUtil.a(i)) {
            return null;
        }
        String i2 = EventsTableProviderHelper.m26228i(this.ai, this.ag);
        GraphQLFriendshipStatus fromString = GraphQLFriendshipStatus.fromString(EventsTableProviderHelper.m26228i(this.ai, this.ah));
        EventUser.Builder builder = new EventUser.Builder();
        builder.c = i;
        EventUser.Builder builder2 = builder;
        builder2.b = i2;
        builder2 = builder2;
        builder2.h = fromString;
        builder2 = builder2;
        builder2.a = EventUserType.USER;
        return builder2.a();
    }
}
