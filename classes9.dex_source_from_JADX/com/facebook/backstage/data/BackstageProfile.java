package com.facebook.backstage.data;

import android.net.Uri;
import android.support.annotation.Nullable;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.Date;

/* compiled from: result_group */
public class BackstageProfile {
    public final String f5112a;
    private final BackstageUser f5113b;
    public final boolean f5114c;
    public final boolean f5115d;
    public final Date f5116e;
    public final ImmutableList<BackstageStory> f5117f;
    public int f5118g;

    /* compiled from: result_group */
    public class BackstageStory extends DefaultMediaItemImpl {
        public final String f5104b;
        public ImmutableList<SeenByUser> f5105c;
        public boolean f5106d;
        public boolean f5107e;

        public BackstageStory(String str, String str2, String str3, String str4, TimezoneDate timezoneDate, boolean z, ImmutableList<SeenByUser> immutableList) {
            super(str2, str4, str3, timezoneDate);
            this.f5104b = str;
            this.f5105c = immutableList;
            this.f5106d = z;
        }

        public final void m4893b() {
            this.f5107e = true;
        }

        public final ImmutableList<SeenByUser> m4894e() {
            return this.f5105c;
        }

        public final void m4892a(SeenByUser seenByUser) {
            this.f5105c = ImmutableList.builder().c(seenByUser).b();
        }
    }

    /* compiled from: result_group */
    public class Reply extends DefaultMediaItemImpl {
        public final String f5108b;
        public final String f5109c;
        public final float f5110d;

        public Reply(String str, String str2, String str3, String str4, String str5, TimezoneDate timezoneDate, float f) {
            super(str2, str3, str4, timezoneDate);
            this.f5108b = str;
            this.f5109c = str5;
            this.f5110d = f;
        }
    }

    /* compiled from: result_group */
    public class SeenByUser extends BackstageUser {
        public String f5111a;

        public SeenByUser(BackstageUser backstageUser) {
            super(backstageUser.f5100a, backstageUser.f5101b, backstageUser.f5102c);
        }

        public SeenByUser(BackstageUser backstageUser, String str) {
            super(backstageUser.f5100a, backstageUser.f5101b, backstageUser.f5102c);
            this.f5111a = str;
        }

        public SeenByUser(String str, @Nullable Uri uri, @Nullable Uri uri2) {
            super(str, uri, uri2);
        }

        public final void m4895a(String str) {
            this.f5111a = str;
        }

        public final boolean m4896b() {
            return !Strings.isNullOrEmpty(this.f5111a);
        }
    }

    public BackstageProfile(String str, Uri uri, Uri uri2, String str2, int i, boolean z, boolean z2, Date date, ImmutableList<BackstageStory> immutableList) {
        this.f5112a = str;
        this.f5113b = new BackstageUser(str2, uri, uri2);
        this.f5118g = i;
        this.f5114c = z;
        this.f5115d = z2;
        this.f5116e = date;
        this.f5117f = immutableList;
    }

    public BackstageProfile(BackstageProfile backstageProfile, int i, boolean z, ImmutableList<BackstageStory> immutableList) {
        this.f5112a = backstageProfile.f5112a;
        this.f5113b = new BackstageUser(backstageProfile.m4899d(), backstageProfile.m4900k(), backstageProfile.m4898c());
        this.f5118g = i;
        this.f5114c = z;
        this.f5115d = backstageProfile.f5115d;
        this.f5116e = backstageProfile.f5116e;
        this.f5117f = immutableList;
    }

    public final Uri m4897b() {
        if (this.f5114c) {
            return Uri.parse(((BackstageStory) this.f5117f.get(this.f5118g)).mo171f());
        }
        if (this.f5117f.isEmpty()) {
            return null;
        }
        return Uri.parse(((BackstageStory) this.f5117f.get(0)).mo171f());
    }

    public final Uri m4898c() {
        return this.f5113b.f5102c;
    }

    public final String m4899d() {
        return this.f5113b.f5100a;
    }

    public final Uri m4900k() {
        return this.f5113b.f5101b;
    }
}
