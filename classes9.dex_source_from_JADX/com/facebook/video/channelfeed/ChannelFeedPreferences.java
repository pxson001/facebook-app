package com.facebook.video.channelfeed;

import android.content.Context;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.util.Base64;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.video.channelfeed.activity.ChannelFeedActivity;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: sync_seq_id */
public class ChannelFeedPreferences extends PreferenceCategory {
    @Inject
    public SecureContextHelper f2373a;
    @Inject
    @LoggedInUserId
    public Provider<String> f2374b;

    /* compiled from: sync_seq_id */
    class LiveVideoChannelPreferenceClickListener implements OnPreferenceClickListener {
        final /* synthetic */ ChannelFeedPreferences f2372a;

        public LiveVideoChannelPreferenceClickListener(ChannelFeedPreferences channelFeedPreferences) {
            this.f2372a = channelFeedPreferences;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f2372a.f2373a.a(ChannelFeedActivity.m2593a(this.f2372a.getContext(), Base64.encodeToString(("videoChannel:1624138887857048:" + ((String) this.f2372a.f2374b.get())).getBytes(), 0), true), this.f2372a.getContext());
            return true;
        }
    }

    public static void m2327a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ChannelFeedPreferences channelFeedPreferences = (ChannelFeedPreferences) obj;
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        Provider a = IdBasedProvider.a(fbInjector, 4442);
        channelFeedPreferences.f2373a = secureContextHelper;
        channelFeedPreferences.f2374b = a;
    }

    public ChannelFeedPreferences(Context context) {
        this(context, null);
    }

    private ChannelFeedPreferences(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private ChannelFeedPreferences(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = ChannelFeedPreferences.class;
        m2327a(this, context);
    }

    protected void onAttachedToHierarchy(PreferenceManager preferenceManager) {
        super.onAttachedToHierarchy(preferenceManager);
        setTitle("Video Channel Feed");
        Preference preference = new Preference(getContext());
        preference.setTitle("Live Video Channel");
        preference.setOnPreferenceClickListener(new LiveVideoChannelPreferenceClickListener(this));
        addPreference(preference);
    }
}
