package com.facebook.katana;

import android.content.Context;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.devicebasedlogin.settings.DBLLoggedInAccountSettingsController;
import com.facebook.devicebasedlogin.settings.DBLSettingsItem;
import com.facebook.inject.AbstractAssistedProvider;
import java.util.List;

/* compiled from: SELL */
public class DBLSettingsAdapterProvider extends AbstractAssistedProvider<DBLSettingsAdapter> {
    public final DBLSettingsAdapter m25462a(List<DBLSettingsItem> list, Context context) {
        return new DBLSettingsAdapter(list, context, DBLLoggedInAccountSettingsController.a(this), (SecureContextHelper) DefaultSecureContextHelper.a(this));
    }
}
