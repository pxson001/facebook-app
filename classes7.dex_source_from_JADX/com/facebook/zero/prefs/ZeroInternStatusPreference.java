package com.facebook.zero.prefs;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.zero.activity.ZeroInternStatusActivity;
import javax.inject.Provider;

/* compiled from: z-m-graph.facebook.com */
public class ZeroInternStatusPreference extends Preference {
    private final Provider<Boolean> f163a;
    public final SelfRegistrableReceiverImpl f164b;

    /* compiled from: z-m-graph.facebook.com */
    class C00291 implements ActionReceiver {
        final /* synthetic */ ZeroInternStatusPreference f161a;

        C00291(ZeroInternStatusPreference zeroInternStatusPreference) {
            this.f161a = zeroInternStatusPreference;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -2144333452);
            ZeroInternStatusPreference.m125d(this.f161a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1116668599, a);
        }
    }

    /* compiled from: z-m-graph.facebook.com */
    class C00302 implements OnPreferenceClickListener {
        final /* synthetic */ ZeroInternStatusPreference f162a;

        C00302(ZeroInternStatusPreference zeroInternStatusPreference) {
            this.f162a = zeroInternStatusPreference;
        }

        public boolean onPreferenceClick(Preference preference) {
            ZeroInternStatusPreference zeroInternStatusPreference = this.f162a;
            zeroInternStatusPreference.getContext().startActivity(new Intent(zeroInternStatusPreference.getContext(), ZeroInternStatusActivity.class));
            return true;
        }
    }

    public ZeroInternStatusPreference(Context context) {
        super(context);
        FbInjector fbInjector = FbInjector.get(context);
        this.f163a = IdBasedProvider.a(fbInjector, 4034);
        this.f164b = ((BaseFbBroadcastManager) LocalFbBroadcastManager.a(fbInjector)).a().a("com.facebook.zero.ZERO_RATING_STATE_CHANGED", new C00291(this)).a();
        setOnPreferenceClickListener(new C00302(this));
        setTitle(2131232990);
        m126e();
    }

    public static void m125d(ZeroInternStatusPreference zeroInternStatusPreference) {
        zeroInternStatusPreference.m126e();
        ((PreferenceActivity) zeroInternStatusPreference.getContext()).getListView().invalidate();
    }

    private void m126e() {
        if (((Boolean) this.f163a.get()).booleanValue()) {
            setSummary(getContext().getString(2131232970));
        } else {
            setSummary(getContext().getString(2131232971));
        }
    }
}
