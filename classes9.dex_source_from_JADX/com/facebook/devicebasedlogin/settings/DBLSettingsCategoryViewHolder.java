package com.facebook.devicebasedlogin.settings;

import android.view.View;
import com.facebook.resources.ui.FbTextView;

/* compiled from: The number of components does not match the size of the color list */
public class DBLSettingsCategoryViewHolder extends DBLSettingsViewHolder {
    FbTextView f24194l;

    public DBLSettingsCategoryViewHolder(View view) {
        super(view);
        this.f24194l = (FbTextView) view.findViewById(2131560921);
    }

    public final void mo1135a(DBLSettingsItem dBLSettingsItem) {
        this.f24194l.setText(dBLSettingsItem.f24195a);
    }
}
