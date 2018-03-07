package com.facebook.contacts.ccu;

import com.facebook.contacts.ccu.graphql.ContactsUploadSessionCreateAndMaybeFirstBatchUploadMutationModels.ContactUploadSessionCreateAndMaybeBatchUploadMutationFieldsModel.ContactUploadSessionModel.SettingModel;

/* compiled from: invite_uri */
public class ContactsUploadSettings {
    public static final ContactsUploadSettings f10180a = new ContactsUploadSettings(100, FieldSetting.MINIMAL, 1, 10000, 3, 10, 10, 86400000);
    public final int f10181b;
    public final FieldSetting f10182c;
    public final int f10183d;
    public final int f10184e;
    public final int f10185f;
    public final int f10186g;
    public final int f10187h;
    public final long f10188i;

    /* compiled from: invite_uri */
    public enum FieldSetting {
        MINIMAL,
        EXTENDED
    }

    private ContactsUploadSettings(int i, FieldSetting fieldSetting, int i2, int i3, int i4, int i5, int i6, long j) {
        this.f10181b = i;
        this.f10182c = fieldSetting;
        this.f10183d = i2;
        this.f10184e = i3;
        this.f10185f = i4;
        this.f10186g = i5;
        this.f10187h = i6;
        this.f10188i = j;
    }

    public static ContactsUploadSettings m10648a(SettingModel settingModel) {
        return new ContactsUploadSettings(settingModel.a(), settingModel.j() == null ? FieldSetting.MINIMAL : FieldSetting.valueOf(settingModel.j().toString()), settingModel.k(), settingModel.l(), settingModel.o(), settingModel.m(), settingModel.n(), (long) settingModel.p());
    }
}
