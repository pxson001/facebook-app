package com.facebook.katana.ringtone;

import android.content.Context;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.common.init.INeedInit;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.app.module.MainProcessModule;
import com.facebook.katana.provider.legacykeyvalue.UserValuesManager;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import java.io.IOException;
import javax.inject.Inject;

/* compiled from: mUri */
public class RingtoneRegister implements INeedInit {
    private Context f8456a;
    private FbSharedPreferences f8457b;
    private RingtoneUtils f8458c;

    public static RingtoneRegister m8704b(InjectorLike injectorLike) {
        return new RingtoneRegister((Context) injectorLike.getInstance(Context.class, ForAppContext.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), MainProcessModule.a((Context) injectorLike.getInstance(Context.class, ForAppContext.class), MoreFileUtils.a(injectorLike)));
    }

    @Inject
    public RingtoneRegister(@ForAppContext Context context, FbSharedPreferences fbSharedPreferences, RingtoneUtils ringtoneUtils) {
        this.f8456a = context;
        this.f8457b = fbSharedPreferences;
        this.f8458c = ringtoneUtils;
    }

    public void init() {
        if (!UserValuesManager.m11491a(this.f8456a)) {
            try {
                String a = this.f8458c.m8708a();
                if (a != null) {
                    Editor edit = this.f8457b.edit();
                    edit.a(NotificationsPreferenceConstants.f7736m, a);
                    edit.commit();
                    UserValuesManager.m11490a(this.f8456a, true);
                }
            } catch (IOException e) {
            }
        }
    }
}
