package com.facebook.notifications.preferences;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: negative_feedback_location */
public class InlineNotificationNuxWebpagePreference extends Preference {
    public static final Uri f8436b = Uri.parse("https://our.intern.facebook.com/intern/nux/detail?nux_id=4127");
    @Inject
    public SecureContextHelper f8437a;

    /* compiled from: negative_feedback_location */
    public class C06831 implements OnPreferenceClickListener {
        final /* synthetic */ InlineNotificationNuxWebpagePreference f8435a;

        public C06831(InlineNotificationNuxWebpagePreference inlineNotificationNuxWebpagePreference) {
            this.f8435a = inlineNotificationNuxWebpagePreference;
        }

        public boolean onPreferenceClick(Preference preference) {
            InlineNotificationNuxWebpagePreference inlineNotificationNuxWebpagePreference = this.f8435a;
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(InlineNotificationNuxWebpagePreference.f8436b);
            inlineNotificationNuxWebpagePreference.f8437a.b(intent, inlineNotificationNuxWebpagePreference.getContext());
            return true;
        }
    }

    public static void m10015a(Object obj, Context context) {
        ((InlineNotificationNuxWebpagePreference) obj).f8437a = (SecureContextHelper) DefaultSecureContextHelper.a(FbInjector.get(context));
    }

    public InlineNotificationNuxWebpagePreference(Context context) {
        super(context);
        Class cls = InlineNotificationNuxWebpagePreference.class;
        m10015a(this, getContext());
    }
}
