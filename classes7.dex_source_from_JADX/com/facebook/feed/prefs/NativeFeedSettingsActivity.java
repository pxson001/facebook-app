package com.facebook.feed.prefs;

import android.content.Context;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceScreen;
import com.facebook.base.activity.FbPreferenceActivity;
import com.facebook.common.util.TriState;
import com.facebook.debug.feed.DebugFeedConfig;
import com.facebook.debug.log.BLog;
import com.facebook.debug.pref.DebugLoggingPrefKeys;
import com.facebook.feed.prefs.keys.FeedPrefKeys;
import com.facebook.feed.ui.DebugScissorsEvent;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.inject.FbInjector;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;
import com.facebook.widget.prefs.OrcaCheckBoxPreference;
import com.facebook.widget.prefs.OrcaListPreference;
import com.facebook.widget.viewdiagnostics.ViewDiagnostics;
import com.facebook.widget.viewdiagnostics.ViewDiagnosticsPreferenceKeys;
import javax.inject.Inject;

/* compiled from: admin_click_admin_feed */
public class NativeFeedSettingsActivity extends FbPreferenceActivity {
    public FeedEventBus f19824a;
    public DebugFeedConfig f19825b;

    /* compiled from: admin_click_admin_feed */
    class C17201 implements OnPreferenceChangeListener {
        final /* synthetic */ NativeFeedSettingsActivity f19821a;

        C17201(NativeFeedSettingsActivity nativeFeedSettingsActivity) {
            this.f19821a = nativeFeedSettingsActivity;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            ViewDiagnostics.a = TriState.valueOf(((Boolean) obj).booleanValue());
            return true;
        }
    }

    /* compiled from: admin_click_admin_feed */
    class C17212 implements OnPreferenceChangeListener {
        final /* synthetic */ NativeFeedSettingsActivity f19822a;

        C17212(NativeFeedSettingsActivity nativeFeedSettingsActivity) {
            this.f19822a = nativeFeedSettingsActivity;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            int i;
            if ("all".equals(obj)) {
                i = Integer.MAX_VALUE;
            } else {
                i = Integer.parseInt(obj.toString());
            }
            this.f19822a.f19824a.a(new DebugScissorsEvent(i));
            BLog.b(getClass().getSimpleName(), "Cache: cleared " + i + "stories");
            return false;
        }
    }

    /* compiled from: admin_click_admin_feed */
    class C17223 implements OnPreferenceChangeListener {
        final /* synthetic */ NativeFeedSettingsActivity f19823a;

        C17223(NativeFeedSettingsActivity nativeFeedSettingsActivity) {
            this.f19823a = nativeFeedSettingsActivity;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            this.f19823a.f19825b.b = ((Boolean) obj).booleanValue();
            return true;
        }
    }

    private static <T extends Context> void m23087a(Class<T> cls, T t) {
        m23088a((Object) t, (Context) t);
    }

    public static void m23088a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((NativeFeedSettingsActivity) obj).m23086a(FeedEventBus.a(fbInjector), DebugFeedConfig.a(fbInjector));
    }

    @Inject
    private void m23086a(FeedEventBus feedEventBus, DebugFeedConfig debugFeedConfig) {
        this.f19824a = feedEventBus;
        this.f19825b = debugFeedConfig;
    }

    public final void m23090c(Bundle bundle) {
        super.c(bundle);
        setTitle("Native Feed - internal");
        Class cls = NativeFeedSettingsActivity.class;
        m23088a((Object) this, (Context) this);
        PreferenceScreen createPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
        setPreferenceScreen(createPreferenceScreen);
        OrcaCheckBoxPreference orcaCheckBoxPreference = new OrcaCheckBoxPreference(this);
        orcaCheckBoxPreference.a(FeedPrefKeys.b);
        orcaCheckBoxPreference.setTitle("Override comment flyout with permalink view");
        orcaCheckBoxPreference.setSummary("Launch permalink view instead of opening comment flyout");
        orcaCheckBoxPreference.setDefaultValue(Boolean.valueOf(false));
        createPreferenceScreen.addPreference(orcaCheckBoxPreference);
        orcaCheckBoxPreference = new OrcaCheckBoxPreference(this);
        orcaCheckBoxPreference.a(FeedPrefKeys.j);
        orcaCheckBoxPreference.setTitle("Report Spam from Feed");
        orcaCheckBoxPreference.setSummary("Display the spam reporting option in the story menu");
        orcaCheckBoxPreference.setDefaultValue(Boolean.valueOf(true));
        createPreferenceScreen.addPreference(orcaCheckBoxPreference);
        orcaCheckBoxPreference = new OrcaCheckBoxPreference(this);
        orcaCheckBoxPreference.a(ViewDiagnosticsPreferenceKeys.b);
        orcaCheckBoxPreference.setTitle("Show Render Measurement");
        orcaCheckBoxPreference.setSummary("Enable/Disable feed inline render measurement");
        orcaCheckBoxPreference.setDefaultValue(Boolean.valueOf(false));
        createPreferenceScreen.addPreference(orcaCheckBoxPreference);
        orcaCheckBoxPreference.setOnPreferenceChangeListener(new C17201(this));
        CheckBoxOrSwitchPreference checkBoxOrSwitchPreference = new CheckBoxOrSwitchPreference(this);
        checkBoxOrSwitchPreference.setKey(DebugLoggingPrefKeys.j.a());
        checkBoxOrSwitchPreference.setTitle("Components Conversion Overlay");
        checkBoxOrSwitchPreference.setSummary("Requires app restart to take effect");
        createPreferenceScreen.addPreference(checkBoxOrSwitchPreference);
        OrcaListPreference orcaListPreference = new OrcaListPreference(this);
        orcaListPreference.setSummary("Clear stories from cache to see the scissors gap");
        orcaListPreference.setTitle("Clear stories from cache");
        orcaListPreference.setDialogTitle("Clear top stories");
        orcaListPreference.a(FeedPrefKeys.f);
        orcaListPreference.setEntries(new String[]{"at least 10", "at least 15", "at least 20", "everything"});
        orcaListPreference.setEntryValues(new String[]{"10", "15", "20", "all"});
        orcaListPreference.setDefaultValue("15");
        orcaListPreference.setOnPreferenceChangeListener(new C17212(this));
        createPreferenceScreen.addPreference(orcaListPreference);
        orcaCheckBoxPreference = new OrcaCheckBoxPreference(this);
        orcaCheckBoxPreference.a(FeedPrefKeys.n);
        orcaCheckBoxPreference.setTitle("Enable Story Privacy Editing");
        orcaCheckBoxPreference.setSummary("Allow users to change the audience of their own stories from the story action menu");
        orcaCheckBoxPreference.setDefaultValue(Boolean.valueOf(true));
        createPreferenceScreen.addPreference(orcaCheckBoxPreference);
        orcaCheckBoxPreference = new OrcaCheckBoxPreference(this);
        orcaCheckBoxPreference.a(FeedPrefKeys.o);
        orcaCheckBoxPreference.setTitle("Enable demo ad invalidation");
        orcaCheckBoxPreference.setSummary("Allow demo ads to participate in ad invalidation checks");
        orcaCheckBoxPreference.setDefaultValue(Boolean.valueOf(false));
        createPreferenceScreen.addPreference(orcaCheckBoxPreference);
        orcaCheckBoxPreference = new OrcaCheckBoxPreference(this);
        orcaCheckBoxPreference.a(FeedPrefKeys.s);
        orcaCheckBoxPreference.setTitle("Enable debug feed");
        orcaCheckBoxPreference.setSummary("Enables fetching newsfeed story for debug feed enpoint");
        orcaCheckBoxPreference.setDefaultValue(Boolean.valueOf(false));
        orcaCheckBoxPreference.setOnPreferenceChangeListener(new C17223(this));
        createPreferenceScreen.addPreference(orcaCheckBoxPreference);
        createPreferenceScreen.addPreference(new ClientSideInjectHelperPreference(this));
        orcaCheckBoxPreference = new OrcaCheckBoxPreference(this);
        orcaCheckBoxPreference.a(FeedPrefKeys.t);
        orcaCheckBoxPreference.setTitle("Visual Feedback for impression logging");
        orcaCheckBoxPreference.setSummary("If enabled, a toast is shown for every impression log event");
        orcaCheckBoxPreference.setDefaultValue(Boolean.valueOf(false));
        createPreferenceScreen.addPreference(orcaCheckBoxPreference);
        orcaCheckBoxPreference = new OrcaCheckBoxPreference(this);
        orcaCheckBoxPreference.a(FeedPrefKeys.g);
        orcaCheckBoxPreference.setTitle("Always do fresh fetch on cold start");
        orcaCheckBoxPreference.setSummary("Always go to the network for new stories on cold start");
        orcaCheckBoxPreference.setDefaultValue(Boolean.valueOf(false));
        createPreferenceScreen.addPreference(orcaCheckBoxPreference);
        orcaCheckBoxPreference = new OrcaCheckBoxPreference(this);
        orcaCheckBoxPreference.a(FeedPrefKeys.h);
        orcaCheckBoxPreference.setTitle("Visual Feedback for topics prediction");
        orcaCheckBoxPreference.setSummary("If enabled, a toast is shown when for every topics prediction event in the composer");
        orcaCheckBoxPreference.setDefaultValue(Boolean.valueOf(false));
        createPreferenceScreen.addPreference(orcaCheckBoxPreference);
        orcaCheckBoxPreference = new OrcaCheckBoxPreference(this);
        orcaCheckBoxPreference.a(FeedPrefKeys.i);
        orcaCheckBoxPreference.setTitle("Visual Feedback for the VPVD logging");
        orcaCheckBoxPreference.setSummary("If enabled, a toast is shown for every viewport visualization duration event. (Restart)");
        orcaCheckBoxPreference.setDefaultValue(Boolean.valueOf(false));
        createPreferenceScreen.addPreference(orcaCheckBoxPreference);
        orcaCheckBoxPreference = new OrcaCheckBoxPreference(this);
        orcaCheckBoxPreference.a(FeedPrefKeys.z);
        orcaCheckBoxPreference.setTitle("Enable Debug Inline Survey");
        orcaCheckBoxPreference.setSummary("If enabled, inline survey will be attached to all stories");
        orcaCheckBoxPreference.setDefaultValue(Boolean.valueOf(false));
        createPreferenceScreen.addPreference(orcaCheckBoxPreference);
    }
}
