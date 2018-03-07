package com.facebook.video.server;

import android.content.Context;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.widget.Toast;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.inject.FbInjector;
import com.facebook.ui.media.cache.PartialFileStorage;
import javax.inject.Inject;

/* compiled from: com.here.app.maps */
public class VideoServerPreferences extends PreferenceCategory {
    @Inject
    @VideoCache
    public PartialFileStorage f19576a;

    public static void m28283a(Object obj, Context context) {
        ((VideoServerPreferences) obj).f19576a = PartialFileStorage_VideoCacheMethodAutoProvider.a(FbInjector.get(context));
    }

    public VideoServerPreferences(Context context) {
        super(context);
        Class cls = VideoServerPreferences.class;
        m28283a(this, getContext());
    }

    protected void onAttachedToHierarchy(PreferenceManager preferenceManager) {
        super.onAttachedToHierarchy(preferenceManager);
        final Context context = getContext();
        setTitle("Video Server");
        Preference preference = new Preference(context);
        preference.setTitle("Clear Video Cache");
        preference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ VideoServerPreferences f19575b;

            public boolean onPreferenceClick(Preference preference) {
                if (this.f19575b.f19576a instanceof DiskTrimmable) {
                    ((DiskTrimmable) this.f19575b.f19576a).b();
                    Toast.makeText(context, "Video cache cleared", 1).show();
                } else {
                    Toast.makeText(context, "Video cache unable to be cleared", 1).show();
                }
                return true;
            }
        });
        addPreference(preference);
    }
}
