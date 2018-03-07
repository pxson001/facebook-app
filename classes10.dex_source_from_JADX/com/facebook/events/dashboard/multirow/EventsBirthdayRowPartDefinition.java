package com.facebook.events.dashboard.multirow;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.View;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.events.dashboard.EventsBirthdayRow;
import com.facebook.events.dashboard.EventsDiscoveryDashboardBirthdaysRowModel;
import com.facebook.events.dashboard.multirow.environment.HasEventDashboardFragment;
import com.facebook.events.dateformatter.EventsBirthdayTimeFormatUtil;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil;
import com.facebook.events.graphql.EventsGraphQLModels.EventUserWithBirthdayFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventUserWithBirthdayFragmentModel.BirthdateModel;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
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
import com.google.common.base.Preconditions;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.inject.Inject;

@ContextScoped
/* compiled from: com.facebook.sdk.WebDialogTheme */
public class EventsBirthdayRowPartDefinition extends MultiRowSinglePartDefinition<EventsDiscoveryDashboardBirthdaysRowModel, State, HasEventDashboardFragment, EventsBirthdayRow> {
    public static final ViewType f17034b = new C23921();
    private static EventsBirthdayRowPartDefinition f17035c;
    private static final Object f17036d = new Object();
    EventsDashboardTimeFormatUtil f17037a;

    /* compiled from: com.facebook.sdk.WebDialogTheme */
    final class C23921 extends ViewType {
        C23921() {
        }

        public final View m17338a(Context context) {
            return new EventsBirthdayRow(context);
        }
    }

    /* compiled from: com.facebook.sdk.WebDialogTheme */
    public class State {
        final /* synthetic */ EventsBirthdayRowPartDefinition f17025a;
        public String f17026b;
        public String f17027c = "";
        public String f17028d = "";
        public String f17029e;
        public StringBuilder f17030f;
        public boolean f17031g;
        public boolean f17032h;
        public boolean f17033i;

        public State(EventsBirthdayRowPartDefinition eventsBirthdayRowPartDefinition, EventUserWithBirthdayFragmentModel eventUserWithBirthdayFragmentModel, FbFragment fbFragment, boolean z) {
            this.f17025a = eventsBirthdayRowPartDefinition;
            this.f17026b = eventUserWithBirthdayFragmentModel.n();
            this.f17030f = new StringBuilder();
            DefaultImageFieldsModel p = eventUserWithBirthdayFragmentModel.p();
            this.f17029e = p == null ? null : p.b();
            this.f17033i = eventUserWithBirthdayFragmentModel.l();
            Date date = new Date();
            BirthdateModel j = eventUserWithBirthdayFragmentModel.j();
            if (j != null) {
                Calendar a = EventsBirthdayTimeFormatUtil.a(date, TimeZone.getDefault(), j.a(), j.b());
                Calendar calendar = (Calendar) a.clone();
                calendar.roll(1, -1);
                this.f17031g = DateUtils.isToday(a.getTimeInMillis());
                Calendar instance = Calendar.getInstance();
                instance.set(j.c(), j.b() - 1, j.a());
                this.f17032h = EventsBirthdayTimeFormatUtil.a(Calendar.getInstance(), instance);
                if (!this.f17032h) {
                    calendar = a;
                }
                if (z) {
                    this.f17027c = eventsBirthdayRowPartDefinition.f17037a.a(calendar.getTime(), date);
                } else {
                    this.f17027c = eventsBirthdayRowPartDefinition.f17037a.b(calendar.getTime());
                }
                if (j.c() > 0) {
                    int c = calendar.get(1) - j.c();
                    int i = this.f17032h ? 2131689677 : this.f17031g ? 2131689675 : 2131689676;
                    this.f17028d = fbFragment.jW_().getQuantityString(i, c, new Object[]{Integer.valueOf(c)});
                }
            }
        }
    }

    private static EventsBirthdayRowPartDefinition m17340b(InjectorLike injectorLike) {
        return new EventsBirthdayRowPartDefinition(EventsDashboardTimeFormatUtil.a(injectorLike));
    }

    public final Object m17342a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return new State(this, ((EventsDiscoveryDashboardBirthdaysRowModel) obj).f16768b, ((HasEventDashboardFragment) anyEnvironment).mo796u(), true);
    }

    public final /* bridge */ /* synthetic */ void m17343a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        boolean z;
        int a = Logger.a(8, EntryType.MARK_PUSH, 1513999214);
        EventsDiscoveryDashboardBirthdaysRowModel eventsDiscoveryDashboardBirthdaysRowModel = (EventsDiscoveryDashboardBirthdaysRowModel) obj;
        State state = (State) obj2;
        HasEventDashboardFragment hasEventDashboardFragment = (HasEventDashboardFragment) anyEnvironment;
        EventsBirthdayRow eventsBirthdayRow = (EventsBirthdayRow) view;
        Preconditions.checkNotNull(state);
        eventsBirthdayRow.m16939a(eventsDiscoveryDashboardBirthdaysRowModel.f16768b, hasEventDashboardFragment.mo796u(), eventsDiscoveryDashboardBirthdaysRowModel.f16767a, state.f17032h, state.f17031g);
        eventsBirthdayRow.m16941a(state.f17026b, state.f17027c, state.f17028d, state.f17029e, state.f17030f);
        if (state.f17033i || eventsDiscoveryDashboardBirthdaysRowModel.f16769c) {
            z = true;
        } else {
            z = false;
        }
        eventsBirthdayRow.setComposeViews(z);
        Logger.a(8, EntryType.MARK_POP, 1597038521, a);
    }

    @Inject
    public EventsBirthdayRowPartDefinition(EventsDashboardTimeFormatUtil eventsDashboardTimeFormatUtil) {
        this.f17037a = eventsDashboardTimeFormatUtil;
    }

    public static EventsBirthdayRowPartDefinition m17339a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EventsBirthdayRowPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f17036d) {
                EventsBirthdayRowPartDefinition eventsBirthdayRowPartDefinition;
                if (a2 != null) {
                    eventsBirthdayRowPartDefinition = (EventsBirthdayRowPartDefinition) a2.a(f17036d);
                } else {
                    eventsBirthdayRowPartDefinition = f17035c;
                }
                if (eventsBirthdayRowPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m17340b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f17036d, b3);
                        } else {
                            f17035c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = eventsBirthdayRowPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m17344a(Object obj) {
        return true;
    }

    public final ViewType<EventsBirthdayRow> m17341a() {
        return f17034b;
    }
}
