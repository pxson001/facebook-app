package com.facebook.appinvites.data;

import com.google.common.collect.Lists;
import java.util.ArrayList;

/* compiled from: editcoverphoto_decodeimage */
public class AppInvitesBlockedListData {
    public final ArrayList<AppInvitesBlockedListDataEntry> f14563a = Lists.a();

    /* compiled from: editcoverphoto_decodeimage */
    public class AppInvitesBlockedListDataEntry {
        public final String f14559a;
        public final String f14560b;
        public final String f14561c;
        public boolean f14562d;

        public AppInvitesBlockedListDataEntry(String str, String str2, String str3, boolean z) {
            this.f14559a = str;
            this.f14560b = str2;
            this.f14561c = str3;
            this.f14562d = z;
        }
    }

    public final void m14738a(AppInvitesBlockedListDataEntry appInvitesBlockedListDataEntry) {
        this.f14563a.add(appInvitesBlockedListDataEntry);
    }
}
