package com.facebook.messaging.events.banner;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.events.banner.EventReminderSettingsActivity.C03971.C03961;
import com.facebook.resources.ui.FbEditText;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: speed_meters_per_sec */
public class EventReminderEditTitleDialogFragment extends FbDialogFragment {
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<EventReminderMutator> am = UltralightRuntime.b;
    public String an;
    public String ao;
    public String ap;
    public String aq;
    public String ar;
    @Nullable
    public C03961 as;

    /* compiled from: speed_meters_per_sec */
    public class C03831 implements OnClickListener {
        final /* synthetic */ EventReminderEditTitleDialogFragment f2295a;

        public C03831(EventReminderEditTitleDialogFragment eventReminderEditTitleDialogFragment) {
            this.f2295a = eventReminderEditTitleDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public static void m2164a(Object obj, Context context) {
        ((EventReminderEditTitleDialogFragment) obj).am = IdBasedLazy.a(FbInjector.get(context), 7852);
    }

    public static EventReminderEditTitleDialogFragment m2163a(String str, String str2, String str3, String str4) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str3);
        Preconditions.checkNotNull(str4);
        Bundle bundle = new Bundle();
        bundle.putString("thread_event_reminder_id", str);
        bundle.putString("thread_event_reminder_title", str2);
        bundle.putString("source_surface", str3);
        bundle.putString("source_module", str4);
        EventReminderEditTitleDialogFragment eventReminderEditTitleDialogFragment = new EventReminderEditTitleDialogFragment();
        eventReminderEditTitleDialogFragment.g(bundle);
        return eventReminderEditTitleDialogFragment;
    }

    public final void m2165a(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1763387670);
        super.a(bundle);
        Class cls = EventReminderEditTitleDialogFragment.class;
        m2164a(this, getContext());
        Bundle bundle2 = this.s;
        this.an = bundle2.getString("thread_event_reminder_id");
        this.ao = bundle2.getString("thread_event_reminder_title");
        this.aq = bundle2.getString("source_surface");
        this.ar = bundle2.getString("source_module");
        this.ap = this.ao;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1253251138, a);
    }

    public final Dialog m2166c(Bundle bundle) {
        int dimensionPixelSize = jW_().getDimensionPixelSize(2131433826);
        FbEditText fbEditText = new FbEditText(getContext());
        if (!Strings.isNullOrEmpty(this.ap)) {
            fbEditText.setText(this.ap);
            fbEditText.setSelection(this.ap.length());
        }
        final View view = fbEditText;
        Builder a = new Builder(getContext()).a(jW_().getString(2131241212)).a(view, dimensionPixelSize, 0, dimensionPixelSize, 0);
        a.a(jW_().getString(2131241219), new OnClickListener(this) {
            final /* synthetic */ EventReminderEditTitleDialogFragment f2297b;

            public void onClick(DialogInterface dialogInterface, int i) {
                Object obj;
                this.f2297b.ap = view.getText().toString();
                if (this.f2297b.as != null) {
                    C03961 c03961 = this.f2297b.as;
                    CharSequence charSequence = this.f2297b.ap;
                    c03961.f2345a.f2346a.f2359H = charSequence;
                    if (Strings.isNullOrEmpty(charSequence)) {
                        c03961.f2345a.f2346a.f2353B.setPlaceholderText(c03961.f2345a.f2346a.getResources().getString(2131241211));
                    } else {
                        c03961.f2345a.f2346a.f2353B.setText(charSequence);
                    }
                }
                if (this.f2297b.ao == null) {
                    obj = "";
                } else {
                    obj = this.f2297b.ao;
                }
                if (!this.f2297b.ap.equals(obj)) {
                    ((EventReminderMutator) this.f2297b.am.get()).m2190a(this.f2297b.an, this.f2297b.ap, this.f2297b.aq, this.f2297b.ar);
                }
            }
        }).b(jW_().getString(2131241220), new C03831(this));
        return a.a();
    }
}
