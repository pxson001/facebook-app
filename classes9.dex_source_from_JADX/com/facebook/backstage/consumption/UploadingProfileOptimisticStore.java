package com.facebook.backstage.consumption;

import com.facebook.backstage.consumption.ProfilesDataProvider.C04541;
import com.facebook.backstage.data.BackstageProfile;
import com.facebook.backstage.data.BackstageProfile.BackstageStory;
import com.facebook.backstage.data.OptimisticMediaItemStoreHelper;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: rtc_instant_button_nux */
public class UploadingProfileOptimisticStore {
    public final OptimisticMediaItemStoreHelper<BackstageStory> f4654a = new OptimisticMediaItemStoreHelper();
    public final C04541 f4655b;

    UploadingProfileOptimisticStore(C04541 c04541) {
        this.f4655b = c04541;
    }

    final List<BackstageStory> m4566a(BackstageProfile backstageProfile) {
        ImmutableList immutableList = backstageProfile.f5117f;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            this.f4654a.m4916a(((BackstageStory) immutableList.get(i)).f5104b);
        }
        List<BackstageStory> arrayList = new ArrayList(this.f4654a.m4913a().size() + backstageProfile.f5117f.size());
        arrayList.addAll(backstageProfile.f5117f);
        arrayList.addAll(this.f4654a.m4913a());
        return arrayList;
    }
}
