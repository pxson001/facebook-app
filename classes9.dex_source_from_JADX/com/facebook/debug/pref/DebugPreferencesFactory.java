package com.facebook.debug.pref;

import android.content.Context;
import android.content.res.Resources;
import android.os.Debug;
import android.os.Environment;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.widget.Toast;
import com.facebook.common.stringformat.StringFormatUtil;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: pinFbId */
public class DebugPreferencesFactory {

    /* compiled from: pinFbId */
    public final class C06771 implements OnPreferenceClickListener {
        public final boolean onPreferenceClick(Preference preference) {
            throw new Error("User triggered crash from Intern settings");
        }
    }

    /* compiled from: pinFbId */
    public final class C06782 implements OnPreferenceClickListener {
        public final boolean onPreferenceClick(Preference preference) {
            throw new OutOfMemoryError("User triggered OOM crash from Intern settings");
        }
    }

    /* compiled from: pinFbId */
    public final class C06793 implements OnPreferenceClickListener {
        public final boolean onPreferenceClick(Preference preference) {
            while (true) {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    /* compiled from: pinFbId */
    public final class C06804 implements OnPreferenceClickListener {
        public final boolean onPreferenceClick(Preference preference) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
            }
            return true;
        }
    }

    /* compiled from: pinFbId */
    final class C06815 implements OnPreferenceClickListener {
        final /* synthetic */ String f6587a;
        final /* synthetic */ Resources f6588b;
        final /* synthetic */ Context f6589c;

        C06815(String str, Resources resources, Context context) {
            this.f6587a = str;
            this.f6588b = resources;
            this.f6589c = context;
        }

        public final boolean onPreferenceClick(Preference preference) {
            String file = new File(this.f6587a, new SimpleDateFormat("'dump-'yyyyMMddHHmmss'.hprof'", Locale.US).format(new Date())).toString();
            try {
                Debug.dumpHprofData(file);
                Toast.makeText(this.f6589c, StringFormatUtil.formatStrLocaleSafe(this.f6588b.getString(2131239998), file), 1).show();
            } catch (IOException e) {
                Toast.makeText(this.f6589c, e.getMessage(), 1).show();
            }
            return true;
        }
    }

    public static Preference m6905b(Context context) {
        String path = Environment.getExternalStorageDirectory().getPath();
        Resources resources = context.getResources();
        Preference preference = new Preference(context);
        preference.setTitle(2131239996);
        preference.setSummary(StringFormatUtil.formatStrLocaleSafe(resources.getString(2131239997), path));
        preference.setOnPreferenceClickListener(new C06815(path, resources, context));
        return preference;
    }
}
