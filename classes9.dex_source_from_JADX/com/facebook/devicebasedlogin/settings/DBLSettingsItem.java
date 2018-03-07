package com.facebook.devicebasedlogin.settings;

/* compiled from: The file is not present! */
public class DBLSettingsItem {
    public final String f24195a;
    public final String f24196b;
    public final String f24197c;
    public final boolean f24198d;
    public final SettingCategory f24199e;
    public final ItemViewType f24200f;
    public final String f24201g;

    /* compiled from: The file is not present! */
    public enum ItemViewType {
        CATEGORY,
        PREFERENCE
    }

    /* compiled from: The file is not present! */
    public enum SettingCategory {
        ADD_PASSCODE,
        CHANGE_PASSCODE,
        REMOVE_PASSCODE,
        REMOVE_ACCOUNT,
        REMEMBER_PASSWORD,
        USE_PASSCODE,
        USE_PASSWORD,
        RESET_SETTINGS,
        OTHER_SESSION
    }

    public DBLSettingsItem(String str, String str2, String str3, boolean z, SettingCategory settingCategory, ItemViewType itemViewType, String str4) {
        this.f24195a = str;
        this.f24196b = str2;
        this.f24197c = str3;
        this.f24198d = z;
        this.f24199e = settingCategory;
        this.f24200f = itemViewType;
        this.f24201g = str4;
    }
}
