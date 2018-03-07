package com.facebook.messaging.events.banner;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.internal.view.ContextThemeWrapper;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.events.banner.EventReminderSettingsActivity.C03992.C03981;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.uicontrib.datetimepicker.DateTimePickerDialog;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.util.Calendar;
import javax.annotation.Nullable;

/* compiled from: ssl */
public class EventReminderEditTimeDialogFragment extends FbDialogFragment {
    @Inject
    public Clock am;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<EventReminderMutator> an = UltralightRuntime.b;
    public String ao;
    public long ap;
    public Calendar aq;
    public String ar;
    public String as;
    public C03981 at;
    public String au;

    /* compiled from: ssl */
    public class C03821 {
        public final /* synthetic */ EventReminderEditTimeDialogFragment f2294a;

        C03821(EventReminderEditTimeDialogFragment eventReminderEditTimeDialogFragment) {
            this.f2294a = eventReminderEditTimeDialogFragment;
        }
    }

    public static void m2160a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        EventReminderEditTimeDialogFragment eventReminderEditTimeDialogFragment = (EventReminderEditTimeDialogFragment) obj;
        Clock clock = (Clock) SystemClockMethodAutoProvider.a(fbInjector);
        com.facebook.inject.Lazy a = IdBasedLazy.a(fbInjector, 7852);
        eventReminderEditTimeDialogFragment.am = clock;
        eventReminderEditTimeDialogFragment.an = a;
    }

    public static EventReminderEditTimeDialogFragment m2159a(String str, long j, String str2, String str3) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(str));
        Preconditions.checkNotNull(str2);
        Preconditions.checkNotNull(str3);
        Bundle bundle = new Bundle();
        bundle.putString("thread_event_reminder_id", str);
        bundle.putLong("thread_event_reminder_time", j);
        bundle.putString("source_surface", str2);
        bundle.putString("source_module", str3);
        EventReminderEditTimeDialogFragment eventReminderEditTimeDialogFragment = new EventReminderEditTimeDialogFragment();
        eventReminderEditTimeDialogFragment.g(bundle);
        return eventReminderEditTimeDialogFragment;
    }

    public final void m2161a(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 52577803);
        super.a(bundle);
        Class cls = EventReminderEditTimeDialogFragment.class;
        m2160a(this, getContext());
        Bundle bundle2 = this.s;
        this.ao = bundle2.getString("thread_event_reminder_id");
        this.au = bundle2.getString("thread_id");
        this.ar = bundle2.getString("source_surface");
        this.as = bundle2.getString("source_module");
        this.aq = Calendar.getInstance();
        if (Strings.isNullOrEmpty(this.ao)) {
            this.aq.roll(10, 1);
            this.aq.set(12, 0);
            this.aq.set(13, 0);
            this.aq.set(14, 0);
        } else {
            this.ap = bundle2.getLong("thread_event_reminder_time");
            this.aq.setTimeInMillis(this.ap);
        }
        LogUtils.f(1759068169, a);
    }

    public final Dialog m2162c(Bundle bundle) {
        return new DateTimePickerDialog(new ContextThemeWrapper(getContext(), 2131625101), this.aq, new C03821(this));
    }
}
