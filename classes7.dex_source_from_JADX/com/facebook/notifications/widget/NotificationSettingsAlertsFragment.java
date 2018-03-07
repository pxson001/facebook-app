package com.facebook.notifications.widget;

import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings.System;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.base.fragment.FbFragment;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fig.listitem.FigListItem;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: methodID */
public class NotificationSettingsAlertsFragment extends FbFragment {
    private static final Uri f9019c = System.DEFAULT_RINGTONE_URI;
    @Inject
    public FbSharedPreferences f9020a;
    @Inject
    public SecureContextHelper f9021b;
    public FigListItem f9022d;
    private FigListItem f9023e;
    public FigListItem f9024f;

    /* compiled from: methodID */
    class C07171 implements OnClickListener {
        final /* synthetic */ NotificationSettingsAlertsFragment f9016a;

        C07171(NotificationSettingsAlertsFragment notificationSettingsAlertsFragment) {
            this.f9016a = notificationSettingsAlertsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1927675162);
            NotificationSettingsAlertsFragment.ar(this.f9016a);
            Logger.a(2, EntryType.UI_INPUT_END, -1280460937, a);
        }
    }

    /* compiled from: methodID */
    public class C07182 implements OnClickListener {
        final /* synthetic */ NotificationSettingsAlertsFragment f9017a;

        public C07182(NotificationSettingsAlertsFragment notificationSettingsAlertsFragment) {
            this.f9017a = notificationSettingsAlertsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -816543638);
            boolean z = !NotificationSettingsAlertsFragment.au(this.f9017a);
            NotificationSettingsAlertsFragment notificationSettingsAlertsFragment = this.f9017a;
            notificationSettingsAlertsFragment.f9020a.edit().putBoolean(NotificationsPreferenceConstants.k, z).commit();
            notificationSettingsAlertsFragment.f9024f.setActionState(z);
            LogUtils.a(-1380129232, a);
        }
    }

    /* compiled from: methodID */
    public class C07193 implements OnClickListener {
        final /* synthetic */ NotificationSettingsAlertsFragment f9018a;

        public C07193(NotificationSettingsAlertsFragment notificationSettingsAlertsFragment) {
            this.f9018a = notificationSettingsAlertsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1230247119);
            boolean z = !NotificationSettingsAlertsFragment.av(this.f9018a);
            NotificationSettingsAlertsFragment notificationSettingsAlertsFragment = this.f9018a;
            notificationSettingsAlertsFragment.f9020a.edit().putBoolean(NotificationsPreferenceConstants.l, z).commit();
            notificationSettingsAlertsFragment.f9022d.setActionState(z);
            LogUtils.a(1109282374, a);
        }
    }

    public static void m10859a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        NotificationSettingsAlertsFragment notificationSettingsAlertsFragment = (NotificationSettingsAlertsFragment) obj;
        FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        notificationSettingsAlertsFragment.f9020a = fbSharedPreferences;
        notificationSettingsAlertsFragment.f9021b = secureContextHelper;
    }

    public final void m10863c(Bundle bundle) {
        super.c(bundle);
        Class cls = NotificationSettingsAlertsFragment.class;
        m10859a(this, getContext());
    }

    public final View m10861a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1573268425);
        LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(2130905475, viewGroup, false);
        this.f9023e = (FigListItem) linearLayout.findViewById(2131564266);
        this.f9024f = (FigListItem) linearLayout.findViewById(2131564267);
        this.f9022d = (FigListItem) linearLayout.findViewById(2131564268);
        m10860b();
        this.f9024f.setActionState(au(this));
        OnClickListener c07182 = new C07182(this);
        this.f9024f.setOnClickListener(c07182);
        this.f9024f.setActionOnClickListener(c07182);
        this.f9022d.setActionState(av(this));
        c07182 = new C07193(this);
        this.f9022d.setOnClickListener(c07182);
        this.f9022d.setActionOnClickListener(c07182);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1809104285, a);
        return linearLayout;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1810181713);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131233697);
            hasTitleBar.c(true);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -817612090, a);
    }

    public final void m10862a(int i, int i2, Intent intent) {
        if (i == 1688 && i2 == -1) {
            Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
            this.f9020a.edit().a(NotificationsPreferenceConstants.m, uri == null ? null : uri.toString()).commit();
            as();
        }
    }

    private void m10860b() {
        as();
        this.f9023e.setOnClickListener(new C07171(this));
    }

    public static void ar(NotificationSettingsAlertsFragment notificationSettingsAlertsFragment) {
        Intent intent = new Intent("android.intent.action.RINGTONE_PICKER");
        intent.putExtra("android.intent.extra.ringtone.TITLE", notificationSettingsAlertsFragment.getContext().getResources().getString(2131233703));
        intent.putExtra("android.intent.extra.ringtone.SHOW_SILENT", true);
        intent.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", true);
        intent.putExtra("android.intent.extra.ringtone.EXISTING_URI", notificationSettingsAlertsFragment.at());
        intent.putExtra("android.intent.extra.ringtone.TYPE", 2);
        notificationSettingsAlertsFragment.f9021b.b(intent, 1688, notificationSettingsAlertsFragment);
    }

    private void as() {
        if (this.f9023e != null) {
            CharSequence string;
            Uri at = at();
            if (at == null) {
                string = getContext().getResources().getString(2131233700);
            } else if (at.equals(f9019c)) {
                string = getContext().getResources().getString(2131233699);
            } else {
                string = RingtoneManager.getRingtone(getContext(), at).getTitle(getContext());
            }
            this.f9023e.setActionText(string);
        }
    }

    @Nullable
    private Uri at() {
        String a = this.f9020a.a(NotificationsPreferenceConstants.m, null);
        if (Strings.isNullOrEmpty(a)) {
            return null;
        }
        return Uri.parse(a);
    }

    public static boolean au(NotificationSettingsAlertsFragment notificationSettingsAlertsFragment) {
        return notificationSettingsAlertsFragment.f9020a.a(NotificationsPreferenceConstants.k, true);
    }

    public static boolean av(NotificationSettingsAlertsFragment notificationSettingsAlertsFragment) {
        return notificationSettingsAlertsFragment.f9020a.a(NotificationsPreferenceConstants.l, true);
    }
}
