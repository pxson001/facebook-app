package com.facebook.dialtone.prefs;

import android.content.Context;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.widget.Toast;
import com.facebook.common.shortcuts.InstallShortcutHelper;
import com.facebook.common.shortcuts.InstallShortcutHelper.IconStyle;
import com.facebook.inject.FbInjector;

/* compiled from: \+| */
public class CreateDialtoneShortcutPreference extends Preference {
    public final InstallShortcutHelper f11856a;
    public final Context f11857b;

    /* compiled from: \+| */
    class C11121 implements OnPreferenceClickListener {
        final /* synthetic */ CreateDialtoneShortcutPreference f11855a;

        C11121(CreateDialtoneShortcutPreference createDialtoneShortcutPreference) {
            this.f11855a = createDialtoneShortcutPreference;
        }

        public boolean onPreferenceClick(Preference preference) {
            CreateDialtoneShortcutPreference createDialtoneShortcutPreference = this.f11855a;
            Bundle bundle = new Bundle();
            bundle.putString("ref", "shortcut_open");
            createDialtoneShortcutPreference.f11856a.m19114a("dialtone://start", null, "Dialtone", null, IconStyle.DEFAULT, -1, false, false, bundle);
            Toast.makeText(createDialtoneShortcutPreference.f11857b, 2131232620, 0).show();
            return true;
        }
    }

    public CreateDialtoneShortcutPreference(Context context) {
        super(context);
        this.f11857b = context;
        this.f11856a = InstallShortcutHelper.m19109b(FbInjector.get(context));
        setOnPreferenceClickListener(new C11121(this));
        setTitle(2131232619);
    }
}
