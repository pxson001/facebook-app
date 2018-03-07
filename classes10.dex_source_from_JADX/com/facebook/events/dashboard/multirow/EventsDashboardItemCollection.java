package com.facebook.events.dashboard.multirow;

import android.content.Context;
import android.text.format.DateUtils;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.common.time.Clock;
import com.facebook.events.dashboard.DashboardFilterType;
import com.facebook.events.dashboard.EventsDiscoveryDashboardBirthdaysRowModel;
import com.facebook.events.dashboard.EventsDiscoveryDashboardPromptRowModel;
import com.facebook.events.dateformatter.EventsBirthdayTimeFormatUtil;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil.CalendarBucket;
import com.facebook.events.dateformatter.TimeRange;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.events.graphql.EventsGraphQLModels.EventUserWithBirthdayFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventUserWithBirthdayFragmentModel.BirthdateModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPromptsModel.EventPromptsModel.NodesModel;
import com.facebook.events.model.Event;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import javax.inject.Inject;

/* compiled from: com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN */
public class EventsDashboardItemCollection implements ListItemCollection<Object> {
    public static final Object f17052a = new Object();
    public static final Object f17053b = new Object();
    public static final Object f17054c = new Object();
    public List<Event> f17055d = new ArrayList(0);
    public List<Event> f17056e = new ArrayList(0);
    public List<EventsDiscoveryDashboardBirthdaysRowModel> f17057f = new ArrayList();
    public final HashMap<DashboardFilterType, NodesModel> f17058g = new HashMap();
    public List<EventsDashboardItem<?>> f17059h = new ArrayList();
    public HashMap<String, Integer> f17060i = new HashMap();
    public HashMap<String, Integer> f17061j = new HashMap();
    public List<ReactionUnitFragment> f17062k = new ArrayList();
    private final HashMap<String, Integer> f17063l = new HashMap();
    public final HashMap<DashboardFilterType, List<EventsDashboardItem<?>>> f17064m = new HashMap();
    public DashboardFilterType f17065n;
    public boolean f17066o;
    public boolean f17067p;
    private boolean f17068q;
    private Clock f17069r;
    public Context f17070s;
    public EventsDashboardTimeFormatUtil f17071t;
    private final boolean f17072u;

    /* compiled from: com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN */
    public /* synthetic */ class C23941 {
        public static final /* synthetic */ int[] f17051a = new int[CalendarBucket.values().length];

        static {
            try {
                f17051a[CalendarBucket.PAST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17051a[CalendarBucket.YESTERDAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f17051a[CalendarBucket.TODAY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f17051a[CalendarBucket.TOMORROW.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f17051a[CalendarBucket.THIS_WEEK.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f17051a[CalendarBucket.NEXT_WEEK.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f17051a[CalendarBucket.FUTURE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    @Inject
    public EventsDashboardItemCollection(@Assisted Boolean bool, @Assisted DashboardFilterType dashboardFilterType, Clock clock, Context context, EventsDashboardTimeFormatUtil eventsDashboardTimeFormatUtil, QeAccessor qeAccessor) {
        this.f17068q = bool.booleanValue();
        this.f17065n = dashboardFilterType;
        this.f17069r = clock;
        this.f17070s = context;
        this.f17071t = eventsDashboardTimeFormatUtil;
        this.f17072u = qeAccessor.a(ExperimentsForEventsGatingModule.q, true);
    }

    public final int m17365a() {
        return this.f17059h.size();
    }

    public final Object m17366a(int i) {
        return i < this.f17059h.size() ? (EventsDashboardItem) this.f17059h.get(i) : null;
    }

    public final void m17370a(ImmutableList<Event> immutableList) {
        this.f17055d = new ArrayList(immutableList);
        m17361c();
    }

    public final void m17368a(Event event) {
        if (event != null) {
            for (Event event2 : this.f17055d) {
                if (event2.K() > event.K() && this.f17060i.containsKey(event2.a)) {
                    this.f17055d.add(((Integer) this.f17060i.get(event2.a)).intValue(), event);
                    m17361c();
                    return;
                }
            }
            this.f17055d.add(event);
            m17361c();
        }
    }

    public final void m17372a(List<Event> list) {
        this.f17055d.addAll(list);
        m17361c();
    }

    public final void m17375b(List<ReactionUnitFragment> list) {
        this.f17062k = list;
        for (int i = 0; i < this.f17062k.size(); i++) {
            this.f17063l.put(((ReactionUnitFragment) list.get(i)).d(), Integer.valueOf(i));
        }
        m17361c();
    }

    public final void m17369a(ReactionUnitFragment reactionUnitFragment) {
        if (this.f17063l.get(reactionUnitFragment.d()) != null) {
            this.f17062k.set(((Integer) this.f17063l.get(reactionUnitFragment.d())).intValue(), reactionUnitFragment);
            m17361c();
        }
    }

    public final void m17376b(List<EventUserWithBirthdayFragmentModel> list, String str) {
        if (list != null) {
            if (this.f17057f == null) {
                this.f17057f = new ArrayList();
            }
            for (int i = 0; i < list.size(); i++) {
                this.f17057f.add(new EventsDiscoveryDashboardBirthdaysRowModel(str, (EventUserWithBirthdayFragmentModel) list.get(i), false));
                this.f17061j.put(((EventUserWithBirthdayFragmentModel) list.get(i)).m(), Integer.valueOf(i));
            }
        }
        m17361c();
    }

    public final void m17373a(boolean z) {
        if (this.f17067p != z) {
            this.f17067p = z;
            m17361c();
        }
    }

    public final void m17371a(String str, Event event) {
        if (event != null && str != null && this.f17060i.containsKey(str)) {
            this.f17055d.set(((Integer) this.f17060i.get(str)).intValue(), event);
            Collections.sort(this.f17055d);
            m17361c();
        }
    }

    public final void m17374b(String str) {
        if (this.f17060i.containsKey(str)) {
            this.f17055d.remove(((Integer) this.f17060i.get(str)).intValue());
            m17361c();
        }
    }

    public final boolean m17377b(boolean z) {
        if (z == this.f17066o) {
            return false;
        }
        this.f17066o = z;
        m17361c();
        return true;
    }

    public final void m17367a(DashboardFilterType dashboardFilterType, NodesModel nodesModel) {
        if (dashboardFilterType != null && nodesModel != null) {
            this.f17058g.put(dashboardFilterType, nodesModel);
            m17361c();
        }
    }

    public final void m17378d(String str) {
        if (!Strings.isNullOrEmpty(str)) {
            for (DashboardFilterType dashboardFilterType : this.f17058g.keySet()) {
                NodesModel nodesModel = (NodesModel) this.f17058g.get(dashboardFilterType);
                if (nodesModel != null && str.equals(nodesModel.k())) {
                    this.f17058g.remove(dashboardFilterType);
                    m17361c();
                    return;
                }
            }
        }
    }

    private void m17361c() {
        this.f17059h.clear();
        this.f17060i.clear();
        if (this.f17065n == DashboardFilterType.BIRTHDAYS) {
            m17363e();
        } else {
            m17364f();
            if (this.f17068q && this.f17065n == DashboardFilterType.UPCOMING) {
                if (!this.f17067p && this.f17055d.size() > 3) {
                    this.f17059h.add(EventsDashboardItem.m17358a(EventsDashboardPartDefinitionKey.f17083e, f17053b));
                }
                if (this.f17067p && this.f17055d.size() > 12) {
                    this.f17059h.add(EventsDashboardItem.m17358a(EventsDashboardPartDefinitionKey.f17084f, f17054c));
                }
                for (int i = 0; i < this.f17062k.size(); i++) {
                    this.f17059h.add(EventsDashboardItem.m17358a(EventsDashboardPartDefinitionKey.f17085g, this.f17062k.get(i)));
                }
            }
        }
        if (this.f17066o) {
            this.f17059h.add(EventsDashboardItem.m17358a(EventsDashboardPartDefinitionKey.f17081c, f17052a));
        }
        this.f17064m.put(this.f17065n, this.f17065n == DashboardFilterType.UPCOMING ? new ArrayList(this.f17059h) : new ArrayList(this.f17059h.subList(0, Math.min(this.f17059h.size(), 12))));
        if (this.f17065n == DashboardFilterType.UPCOMING) {
            this.f17056e = new ArrayList(this.f17055d);
        }
    }

    private void m17360b(int i) {
        if (this.f17055d != null && !this.f17055d.isEmpty()) {
            Object obj = null;
            long a = this.f17069r.a();
            TimeRange a2 = TimeRange.a(a);
            TimeRange b = TimeRange.b(a);
            int i2 = 0;
            while (i2 < i) {
                Object obj2;
                Event event = (Event) this.f17055d.get(i2);
                this.f17060i.put(event.a, Integer.valueOf(i2));
                if (this.f17065n == DashboardFilterType.UPCOMING) {
                    this.f17059h.add(EventsDashboardItem.m17358a(EventsDashboardPartDefinitionKey.f17080b, this.f17055d.get(i2)));
                    obj2 = obj;
                } else {
                    long K = event.K();
                    Date J = event.J();
                    boolean c = a2.c(K);
                    boolean c2 = b.c(K);
                    String f = this.f17065n == DashboardFilterType.PAST ? c2 ? this.f17071t.f(J) : this.f17071t.g(J) : m17359a(this.f17071t.a(K, a), J, c, c2);
                    if (f.equals(obj)) {
                        this.f17059h.add(EventsDashboardItem.m17358a(EventsDashboardPartDefinitionKey.f17080b, this.f17055d.get(i2)));
                        obj2 = obj;
                    } else {
                        this.f17059h.add(EventsDashboardItem.m17358a(EventsDashboardPartDefinitionKey.f17079a, f));
                        this.f17059h.add(EventsDashboardItem.m17358a(EventsDashboardPartDefinitionKey.f17080b, event));
                        String str = f;
                    }
                }
                i2++;
                obj = obj2;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m17359a(com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil.CalendarBucket r6, java.util.Date r7, boolean r8, boolean r9) {
        /*
        r5 = this;
        r0 = r5.f17055d;
        r0 = r0.size();
        r1 = 3;
        if (r0 > r1) goto L_0x0023;
    L_0x0009:
        r2 = com.facebook.events.dashboard.multirow.EventsDashboardItemCollection.C23941.f17051a;
        r3 = r6.ordinal();
        r2 = r2[r3];
        switch(r2) {
            case 1: goto L_0x0038;
            case 2: goto L_0x0038;
            case 3: goto L_0x0038;
            case 4: goto L_0x0038;
            case 5: goto L_0x0038;
            case 6: goto L_0x0046;
            default: goto L_0x0014;
        };
    L_0x0014:
        r2 = r5.f17070s;
        r2 = r2.getResources();
        r3 = 2131237143; // 0x7f081917 float:1.8090528E38 double:1.0529710555E-314;
        r2 = r2.getString(r3);
    L_0x0021:
        r0 = r2;
    L_0x0022:
        return r0;
    L_0x0023:
        r2 = com.facebook.events.dashboard.multirow.EventsDashboardItemCollection.C23941.f17051a;
        r3 = r6.ordinal();
        r2 = r2[r3];
        switch(r2) {
            case 1: goto L_0x0056;
            case 2: goto L_0x0056;
            case 3: goto L_0x0056;
            case 4: goto L_0x005c;
            case 5: goto L_0x0062;
            case 6: goto L_0x0069;
            case 7: goto L_0x0077;
            default: goto L_0x002e;
        };
    L_0x002e:
        if (r9 == 0) goto L_0x0080;
    L_0x0030:
        r2 = r5.f17071t;
        r2 = r2.f(r7);
    L_0x0036:
        r0 = r2;
        goto L_0x0022;
    L_0x0038:
        r2 = r5.f17070s;
        r2 = r2.getResources();
        r3 = 2131237141; // 0x7f081915 float:1.8090524E38 double:1.0529710545E-314;
        r2 = r2.getString(r3);
        goto L_0x0021;
    L_0x0046:
        r2 = r5.f17070s;
        r2 = r2.getResources();
        r3 = 2131237142; // 0x7f081916 float:1.8090526E38 double:1.052971055E-314;
        r2 = r2.getString(r3);
        goto L_0x0021;
    L_0x0056:
        r2 = r5.f17071t;
        r4 = r2.p;
        r2 = r4;
        goto L_0x0036;
    L_0x005c:
        r2 = r5.f17071t;
        r4 = r2.q;
        r2 = r4;
        goto L_0x0036;
    L_0x0062:
        r2 = r5.f17071t;
        r2 = r2.e(r7);
        goto L_0x0036;
    L_0x0069:
        r2 = r5.f17070s;
        r2 = r2.getResources();
        r3 = 2131237142; // 0x7f081916 float:1.8090526E38 double:1.052971055E-314;
        r2 = r2.getString(r3);
        goto L_0x0036;
    L_0x0077:
        if (r8 == 0) goto L_0x002e;
    L_0x0079:
        r2 = r5.f17071t;
        r2 = r2.h(r7);
        goto L_0x0036;
    L_0x0080:
        r2 = r5.f17071t;
        r2 = r2.g(r7);
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.dashboard.multirow.EventsDashboardItemCollection.a(com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil$CalendarBucket, java.util.Date, boolean, boolean):java.lang.String");
    }

    private void m17362c(boolean z) {
        NodesModel nodesModel = (NodesModel) this.f17058g.get(this.f17065n);
        if (nodesModel != null) {
            this.f17059h.add(EventsDashboardItem.m17358a(EventsDashboardPartDefinitionKey.f17087i, new EventsDiscoveryDashboardPromptRowModel(nodesModel, z)));
        }
    }

    private void m17363e() {
        boolean z;
        boolean z2 = false;
        if (this.f17072u) {
            m17362c(false);
            z = true;
        } else {
            z = false;
        }
        Calendar instance = Calendar.getInstance();
        instance.set(10, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        boolean z3 = z;
        for (EventsDiscoveryDashboardBirthdaysRowModel eventsDiscoveryDashboardBirthdaysRowModel : this.f17057f) {
            EventUserWithBirthdayFragmentModel eventUserWithBirthdayFragmentModel = eventsDiscoveryDashboardBirthdaysRowModel.f16768b;
            if (z3 || eventUserWithBirthdayFragmentModel == null || eventUserWithBirthdayFragmentModel.j() == null) {
                this.f17059h.add(EventsDashboardItem.m17358a(EventsDashboardPartDefinitionKey.f17086h, eventsDiscoveryDashboardBirthdaysRowModel));
            } else {
                Object obj;
                BirthdateModel j = eventUserWithBirthdayFragmentModel.j();
                Calendar a = EventsBirthdayTimeFormatUtil.a(instance.getTime(), TimeZone.getDefault(), j.a(), j.b());
                Calendar calendar = (Calendar) instance.clone();
                calendar.set(j.c(), j.b() - 1, j.a());
                if (DateUtils.isToday(a.getTimeInMillis()) || EventsBirthdayTimeFormatUtil.a(instance, calendar, 2)) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    this.f17059h.add(EventsDashboardItem.m17358a(EventsDashboardPartDefinitionKey.f17086h, eventsDiscoveryDashboardBirthdaysRowModel));
                    z2 = true;
                } else {
                    m17362c(z2);
                    this.f17059h.add(EventsDashboardItem.m17358a(EventsDashboardPartDefinitionKey.f17086h, eventsDiscoveryDashboardBirthdaysRowModel));
                    z3 = true;
                }
            }
        }
    }

    private void m17364f() {
        int size = this.f17055d == null ? 0 : this.f17055d.size();
        if (this.f17065n == DashboardFilterType.UPCOMING && this.f17068q) {
            size = Math.min(size, this.f17067p ? 12 : 3);
        }
        if (this.f17055d == null || this.f17055d.isEmpty()) {
            this.f17059h.add(EventsDashboardItem.m17358a(EventsDashboardPartDefinitionKey.f17082d, this.f17065n));
        } else {
            m17360b(size);
        }
    }
}
