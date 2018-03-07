package com.facebook.backstage.consumption;

import com.facebook.backstage.data.BackstageProfile;
import com.facebook.backstage.data.BackstageProfile.BackstageStory;
import com.facebook.backstage.data.BackstageProfile.SeenByUser;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* compiled from: rtc_video_copresence_nux_chat_head */
public class HaveRepliedOptimisticStore {
    public final Set<String> f4601a = new HashSet();
    public final Set<String> f4602b = new HashSet();
    public final HashMap<String, SeenByUser> f4603c = new HashMap();

    HaveRepliedOptimisticStore() {
    }

    final void m4532a(Builder<BackstageProfile> builder) {
        ImmutableList b = builder.b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            BackstageProfile backstageProfile = (BackstageProfile) b.get(i);
            if (this.f4601a.contains(backstageProfile.f5112a)) {
                ImmutableList immutableList = backstageProfile.f5117f;
                int size2 = immutableList.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    BackstageStory backstageStory = (BackstageStory) immutableList.get(i2);
                    if (this.f4602b.contains(backstageStory.f5104b)) {
                        if (backstageStory.f5106d) {
                            this.f4601a.remove(backstageProfile.f5112a);
                            this.f4602b.remove(backstageStory.f5104b);
                        } else {
                            backstageStory.f5106d = true;
                            SeenByUser seenByUser = (SeenByUser) this.f4603c.get(backstageStory.f5104b);
                            if (seenByUser != null) {
                                backstageStory.m4892a(seenByUser);
                            }
                        }
                    }
                }
            }
        }
    }
}
