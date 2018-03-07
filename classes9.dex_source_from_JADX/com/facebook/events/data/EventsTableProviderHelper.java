package com.facebook.events.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.common.util.CollectionUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.debug.log.BLog;
import com.facebook.events.data.EventsCommonContract.EventsCommonTable.Columns;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonTextWithEntitiesModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonTextWithEntitiesModel.Builder;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonTextWithEntitiesModel.RangesModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonTextWithEntitiesModel.RangesModel.EntityModel;
import com.facebook.events.model.Event;
import com.facebook.events.model.EventUser;
import com.facebook.events.model.EventViewerCapability;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesEntityFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields.Ranges;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.RegularImmutableList;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.TimeZone;

/* compiled from: TelephonyManager.getMobileDataEnabled failed */
public class EventsTableProviderHelper {
    public static final Class<EventsTableProviderHelper> f24375a = EventsTableProviderHelper.class;
    private static final Splitter f24376b = Splitter.on("\t");

    public static ContentValues m26222a(Event event) {
        SqlColumn sqlColumn;
        String str;
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.f24274b.d, event.a);
        contentValues.put(Columns.f24275c.d, event.b);
        DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields = event.c;
        if (defaultTextWithEntitiesLongFields == null) {
            contentValues.putNull(Columns.f24276d.d);
        } else {
            contentValues.put(Columns.f24276d.d, defaultTextWithEntitiesLongFields.a());
            ImmutableList b = defaultTextWithEntitiesLongFields.b();
            if (!b.isEmpty()) {
                String str2 = Columns.f24277e.d;
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < b.size(); i++) {
                    String str3;
                    if (i != 0) {
                        stringBuilder.append("\t");
                    }
                    Ranges ranges = (Ranges) b.get(i);
                    DefaultTextWithEntitiesEntityFields a = ranges.a();
                    StringBuilder append = stringBuilder.append(a.d()).append("\t").append(Strings.nullToEmpty(a.C_())).append("\t").append(Strings.nullToEmpty(a.g())).append("\t");
                    if (a.b() == null) {
                        str3 = null;
                    } else {
                        str3 = a.b().e();
                    }
                    StringBuilder append2 = append.append(Strings.nullToEmpty(str3)).append("\t").append(Strings.nullToEmpty(a.D_())).append("\t").append(ranges.b()).append("\t").append(ranges.c());
                }
                contentValues.put(str2, stringBuilder.toString());
                if (event.d == null) {
                    contentValues.put(Columns.f24278f.d, event.d.name());
                } else {
                    contentValues.putNull(Columns.f24278f.d);
                }
                if (event.e == null) {
                    contentValues.put(Columns.f24279g.d, event.e.name());
                } else {
                    contentValues.putNull(Columns.f24279g.d);
                }
                if (event.g == null) {
                    contentValues.put(Columns.f24280h.d, event.g.name());
                } else {
                    contentValues.putNull(Columns.f24280h.d);
                }
                if (event.f == null) {
                    contentValues.put(Columns.f24281i.d, event.f.name());
                } else {
                    contentValues.putNull(Columns.f24281i.d);
                }
                sqlColumn = Columns.f24282j;
                if (event.l != null) {
                    str = null;
                } else {
                    str = event.l.toString();
                }
                m26225a(contentValues, sqlColumn, str);
                if (event.m == null) {
                    contentValues.put(Columns.f24283k.d, event.m.toString());
                } else {
                    contentValues.putNull(Columns.f24283k.d);
                }
                contentValues.put(Columns.f24284l.d, Boolean.valueOf(event.h));
                contentValues.put(Columns.f24285m.d, Boolean.valueOf(event.i));
                contentValues.put(Columns.f24286n.d, Boolean.valueOf(event.j));
                contentValues.put(Columns.f24287o.d, Boolean.valueOf(event.k));
                m26225a(contentValues, Columns.f24288p, event.q);
                m26225a(contentValues, Columns.f24289q, event.r);
                m26225a(contentValues, Columns.f24290r, event.s);
                m26225a(contentValues, Columns.f24291s, event.t);
                m26225a(contentValues, Columns.f24292t, event.u);
                m26225a(contentValues, Columns.f24293u, event.v);
                m26225a(contentValues, Columns.f24294v, event.w);
                contentValues.put(Columns.f24295w.d, Boolean.valueOf(event.x));
                contentValues.put(Columns.f24296x.d, Boolean.valueOf(event.y));
                contentValues.put(Columns.f24297y.d, Long.valueOf(event.z));
                contentValues.put(Columns.f24298z.d, Boolean.valueOf(event.A));
                if (event.D() == null) {
                    contentValues.put(Columns.f24247A.d, event.D().name());
                } else {
                    contentValues.putNull(Columns.f24247A.d);
                }
                if (event.C == null) {
                    contentValues.put(Columns.f24248B.d, event.C.name());
                } else {
                    contentValues.putNull(Columns.f24248B.d);
                }
                contentValues.put(Columns.f24249C.d, Boolean.valueOf(event.D));
                m26225a(contentValues, Columns.f24250D, event.E);
                m26225a(contentValues, Columns.f24251E, event.F);
                contentValues.put(Columns.f24252F.d, Boolean.valueOf(event.G));
                contentValues.put(Columns.f24253G.d, Boolean.valueOf(event.a(EventViewerCapability.ADMIN)));
                if (event.J() != null) {
                    contentValues.put(Columns.f24254H.d, Long.valueOf(event.K()));
                }
                if (event.L() == null) {
                    contentValues.put(Columns.f24255I.d, Long.valueOf(event.M()));
                } else {
                    contentValues.putNull(Columns.f24255I.d);
                }
                if (event.L != null) {
                    contentValues.put(Columns.f24256J.d, event.L.getID());
                }
                contentValues.put(Columns.f24257K.d, Boolean.valueOf(event.M));
                if (event.Q == null) {
                    contentValues.put(Columns.f24258L.d, event.Q);
                } else {
                    contentValues.putNull(Columns.f24258L.d);
                }
                if (event.P()) {
                    contentValues.putNull(Columns.f24259M.d);
                    contentValues.putNull(Columns.f24260N.d);
                } else {
                    contentValues.put(Columns.f24259M.d, Double.valueOf(event.Q()));
                    contentValues.put(Columns.f24260N.d, Double.valueOf(event.R()));
                }
                if (event.R == null) {
                    contentValues.put(Columns.f24263Q.d, event.R.getID());
                } else {
                    contentValues.putNull(Columns.f24263Q.d);
                }
                contentValues.put(Columns.f24261O.d, Long.valueOf(event.O));
                if (event.S != 0) {
                    contentValues.putNull(Columns.f24264R.d);
                } else {
                    contentValues.put(Columns.f24264R.d, new GraphQLObjectType(event.S).e());
                }
                if (event.P == null) {
                    contentValues.put(Columns.f24262P.d, event.P);
                } else {
                    contentValues.putNull(Columns.f24262P.d);
                }
                contentValues.put(Columns.f24265S.d, event.U.toString());
                contentValues.put(Columns.f24266T.d, event.V);
                if (event.W == null) {
                    contentValues.put(Columns.f24267U.d, event.W.toString());
                } else {
                    contentValues.putNull(Columns.f24267U.d);
                }
                if (event.X == null) {
                    contentValues.put(Columns.f24268V.d, event.X.toString());
                } else {
                    contentValues.putNull(Columns.f24268V.d);
                }
                if (event.Y != null) {
                    contentValues.put(Columns.f24269W.d, event.Y.toString());
                }
                contentValues.put(Columns.f24270X.d, Long.valueOf(EventViewerCapability.serializeCapabilities(event.ae())));
                if (Strings.isNullOrEmpty(event.n)) {
                    contentValues.put(Columns.f24271Y.d, event.n);
                } else {
                    contentValues.putNull(Columns.f24271Y.d);
                }
                contentValues.put(Columns.f24272Z.d, Integer.valueOf(event.o));
                if (CollectionUtil.b(event.p)) {
                    contentValues.put(Columns.aa.d, StringUtil.b(",", new Object[]{event.p}));
                }
                if (Strings.isNullOrEmpty(event.ac)) {
                    contentValues.put(Columns.ab.d, event.ac);
                } else {
                    contentValues.putNull(Columns.ab.d);
                }
                contentValues.put(Columns.ac.d, Integer.valueOf(event.ad));
                if (Strings.isNullOrEmpty(event.ae)) {
                    contentValues.put(Columns.ad.d, event.ae);
                } else {
                    contentValues.putNull(Columns.ad.d);
                }
                contentValues.put(Columns.ae.d, Integer.valueOf(event.af));
                if (Strings.isNullOrEmpty(event.ag)) {
                    contentValues.put(Columns.af.d, event.ag);
                } else {
                    contentValues.putNull(Columns.af.d);
                }
                contentValues.put(Columns.ag.d, Integer.valueOf(event.ah));
                if (event.ai != null) {
                    contentValues.putNull(Columns.ah.d);
                    contentValues.putNull(Columns.ai.d);
                    contentValues.putNull(Columns.aj.d);
                } else {
                    EventUser eventUser = event.ai;
                    contentValues.put(Columns.ah.d, eventUser.c);
                    contentValues.put(Columns.ai.d, eventUser.h.name());
                    contentValues.put(Columns.aj.d, eventUser.b);
                }
                return contentValues;
            }
        }
        contentValues.putNull(Columns.f24277e.d);
        if (event.d == null) {
            contentValues.putNull(Columns.f24278f.d);
        } else {
            contentValues.put(Columns.f24278f.d, event.d.name());
        }
        if (event.e == null) {
            contentValues.putNull(Columns.f24279g.d);
        } else {
            contentValues.put(Columns.f24279g.d, event.e.name());
        }
        if (event.g == null) {
            contentValues.putNull(Columns.f24280h.d);
        } else {
            contentValues.put(Columns.f24280h.d, event.g.name());
        }
        if (event.f == null) {
            contentValues.putNull(Columns.f24281i.d);
        } else {
            contentValues.put(Columns.f24281i.d, event.f.name());
        }
        sqlColumn = Columns.f24282j;
        if (event.l != null) {
            str = event.l.toString();
        } else {
            str = null;
        }
        m26225a(contentValues, sqlColumn, str);
        if (event.m == null) {
            contentValues.putNull(Columns.f24283k.d);
        } else {
            contentValues.put(Columns.f24283k.d, event.m.toString());
        }
        contentValues.put(Columns.f24284l.d, Boolean.valueOf(event.h));
        contentValues.put(Columns.f24285m.d, Boolean.valueOf(event.i));
        contentValues.put(Columns.f24286n.d, Boolean.valueOf(event.j));
        contentValues.put(Columns.f24287o.d, Boolean.valueOf(event.k));
        m26225a(contentValues, Columns.f24288p, event.q);
        m26225a(contentValues, Columns.f24289q, event.r);
        m26225a(contentValues, Columns.f24290r, event.s);
        m26225a(contentValues, Columns.f24291s, event.t);
        m26225a(contentValues, Columns.f24292t, event.u);
        m26225a(contentValues, Columns.f24293u, event.v);
        m26225a(contentValues, Columns.f24294v, event.w);
        contentValues.put(Columns.f24295w.d, Boolean.valueOf(event.x));
        contentValues.put(Columns.f24296x.d, Boolean.valueOf(event.y));
        contentValues.put(Columns.f24297y.d, Long.valueOf(event.z));
        contentValues.put(Columns.f24298z.d, Boolean.valueOf(event.A));
        if (event.D() == null) {
            contentValues.putNull(Columns.f24247A.d);
        } else {
            contentValues.put(Columns.f24247A.d, event.D().name());
        }
        if (event.C == null) {
            contentValues.putNull(Columns.f24248B.d);
        } else {
            contentValues.put(Columns.f24248B.d, event.C.name());
        }
        contentValues.put(Columns.f24249C.d, Boolean.valueOf(event.D));
        m26225a(contentValues, Columns.f24250D, event.E);
        m26225a(contentValues, Columns.f24251E, event.F);
        contentValues.put(Columns.f24252F.d, Boolean.valueOf(event.G));
        contentValues.put(Columns.f24253G.d, Boolean.valueOf(event.a(EventViewerCapability.ADMIN)));
        if (event.J() != null) {
            contentValues.put(Columns.f24254H.d, Long.valueOf(event.K()));
        }
        if (event.L() == null) {
            contentValues.putNull(Columns.f24255I.d);
        } else {
            contentValues.put(Columns.f24255I.d, Long.valueOf(event.M()));
        }
        if (event.L != null) {
            contentValues.put(Columns.f24256J.d, event.L.getID());
        }
        contentValues.put(Columns.f24257K.d, Boolean.valueOf(event.M));
        if (event.Q == null) {
            contentValues.putNull(Columns.f24258L.d);
        } else {
            contentValues.put(Columns.f24258L.d, event.Q);
        }
        if (event.P()) {
            contentValues.putNull(Columns.f24259M.d);
            contentValues.putNull(Columns.f24260N.d);
        } else {
            contentValues.put(Columns.f24259M.d, Double.valueOf(event.Q()));
            contentValues.put(Columns.f24260N.d, Double.valueOf(event.R()));
        }
        if (event.R == null) {
            contentValues.putNull(Columns.f24263Q.d);
        } else {
            contentValues.put(Columns.f24263Q.d, event.R.getID());
        }
        contentValues.put(Columns.f24261O.d, Long.valueOf(event.O));
        if (event.S != 0) {
            contentValues.put(Columns.f24264R.d, new GraphQLObjectType(event.S).e());
        } else {
            contentValues.putNull(Columns.f24264R.d);
        }
        if (event.P == null) {
            contentValues.putNull(Columns.f24262P.d);
        } else {
            contentValues.put(Columns.f24262P.d, event.P);
        }
        contentValues.put(Columns.f24265S.d, event.U.toString());
        contentValues.put(Columns.f24266T.d, event.V);
        if (event.W == null) {
            contentValues.putNull(Columns.f24267U.d);
        } else {
            contentValues.put(Columns.f24267U.d, event.W.toString());
        }
        if (event.X == null) {
            contentValues.putNull(Columns.f24268V.d);
        } else {
            contentValues.put(Columns.f24268V.d, event.X.toString());
        }
        if (event.Y != null) {
            contentValues.put(Columns.f24269W.d, event.Y.toString());
        }
        contentValues.put(Columns.f24270X.d, Long.valueOf(EventViewerCapability.serializeCapabilities(event.ae())));
        if (Strings.isNullOrEmpty(event.n)) {
            contentValues.put(Columns.f24271Y.d, event.n);
        } else {
            contentValues.putNull(Columns.f24271Y.d);
        }
        contentValues.put(Columns.f24272Z.d, Integer.valueOf(event.o));
        if (CollectionUtil.b(event.p)) {
            contentValues.put(Columns.aa.d, StringUtil.b(",", new Object[]{event.p}));
        }
        if (Strings.isNullOrEmpty(event.ac)) {
            contentValues.put(Columns.ab.d, event.ac);
        } else {
            contentValues.putNull(Columns.ab.d);
        }
        contentValues.put(Columns.ac.d, Integer.valueOf(event.ad));
        if (Strings.isNullOrEmpty(event.ae)) {
            contentValues.put(Columns.ad.d, event.ae);
        } else {
            contentValues.putNull(Columns.ad.d);
        }
        contentValues.put(Columns.ae.d, Integer.valueOf(event.af));
        if (Strings.isNullOrEmpty(event.ag)) {
            contentValues.put(Columns.af.d, event.ag);
        } else {
            contentValues.putNull(Columns.af.d);
        }
        contentValues.put(Columns.ag.d, Integer.valueOf(event.ah));
        if (event.ai != null) {
            EventUser eventUser2 = event.ai;
            contentValues.put(Columns.ah.d, eventUser2.c);
            contentValues.put(Columns.ai.d, eventUser2.h.name());
            contentValues.put(Columns.aj.d, eventUser2.b);
        } else {
            contentValues.putNull(Columns.ah.d);
            contentValues.putNull(Columns.ai.d);
            contentValues.putNull(Columns.aj.d);
        }
        return contentValues;
    }

    private static void m26225a(ContentValues contentValues, SqlColumn sqlColumn, String str) {
        if (StringUtil.a(str)) {
            contentValues.putNull(sqlColumn.d);
        } else {
            contentValues.put(sqlColumn.d, str);
        }
    }

    public static EventCommonTextWithEntitiesModel m26223a(Cursor cursor, int i, int i2) {
        Builder builder = new Builder();
        builder.b = m26228i(cursor, i);
        String i3 = m26228i(cursor, i2);
        if (i3 != null) {
            builder.a = m26224a(i3);
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = ModelHelper.a(flatBufferBuilder, builder.a);
        int b = flatBufferBuilder.b(builder.b);
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new EventCommonTextWithEntitiesModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    public static String m26228i(Cursor cursor, int i) {
        return i < 0 ? null : cursor.getString(i);
    }

    public static int m26227b(Cursor cursor, int i, int i2) {
        return i < 0 ? i2 : cursor.getInt(i);
    }

    public static long m26221a(Cursor cursor, int i, long j) {
        return (i < 0 || cursor.isNull(i)) ? j : cursor.getLong(i);
    }

    public static Long m26233o(Cursor cursor, int i) {
        Long l = null;
        if (i >= 0) {
            try {
                if (!cursor.isNull(i)) {
                    l = Long.valueOf(cursor.getLong(i));
                }
            } catch (Exception e) {
            }
        }
        return l;
    }

    public static boolean m26226a(Cursor cursor, int i, boolean z) {
        if (i < 0) {
            return z;
        }
        return cursor.getInt(i) != 0;
    }

    public static double m26220a(Cursor cursor, int i, double d) {
        return (i < 0 || cursor.isNull(i)) ? d : cursor.getDouble(i);
    }

    public static Date m26229j(Cursor cursor, int i) {
        if (i < 0) {
            return null;
        }
        try {
            if (cursor.isNull(i)) {
                return null;
            }
            return new Date(cursor.getLong(i));
        } catch (Exception e) {
            return null;
        }
    }

    public static TimeZone m26230k(Cursor cursor, int i) {
        String i2 = m26228i(cursor, i);
        return i2 == null ? null : TimeZone.getTimeZone(i2);
    }

    public static Uri m26231l(Cursor cursor, int i) {
        String i2 = m26228i(cursor, i);
        if (i2 == null) {
            return null;
        }
        return Uri.parse(i2);
    }

    public static ImmutableList<String> m26232m(Cursor cursor, int i) {
        String i2 = m26228i(cursor, i);
        return Strings.isNullOrEmpty(i2) ? RegularImmutableList.a : ImmutableList.copyOf(StringUtil.a(i2, ','));
    }

    private static ImmutableList<RangesModel> m26224a(String str) {
        Throwable e;
        String[] strArr = (String[]) Iterables.a(f24376b.split(str), String.class);
        if (strArr.length % 7 != 0) {
            BLog.a(f24375a, "Serialized entities have in appropriate number of values.");
            return ImmutableList.of();
        }
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int i = 0;
        while (i < strArr.length) {
            int i2 = i + 1;
            String str2 = strArr[i];
            i = i2 + 1;
            String str3 = strArr[i2];
            i2 = i + 1;
            String emptyToNull = Strings.emptyToNull(strArr[i]);
            i = i2 + 1;
            GraphQLObjectType graphQLObjectType = new GraphQLObjectType(strArr[i2]);
            int i3 = i + 1;
            String emptyToNull2 = Strings.emptyToNull(strArr[i]);
            i2 = i3 + 1;
            try {
                i3 = Integer.parseInt(strArr[i3]);
                i = i2 + 1;
                try {
                    builder.c(new RangesModel.Builder().a(new EntityModel.Builder().a(str2).b(str3).c(emptyToNull).a(graphQLObjectType).d(emptyToNull2).a()).b(Integer.parseInt(strArr[i2])).a(i3).a());
                } catch (NumberFormatException e2) {
                    e = e2;
                    BLog.a(f24375a, e, "Was not able to parse entity in text (%s).", new Object[]{str2});
                }
            } catch (Throwable e3) {
                Throwable th = e3;
                i = i2;
                e = th;
                BLog.a(f24375a, e, "Was not able to parse entity in text (%s).", new Object[]{str2});
            }
        }
        return builder.b();
    }
}
