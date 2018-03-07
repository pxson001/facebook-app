package com.facebook.messaging.photoreminders.inboxheader;

import android.net.Uri;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: registration_step_submit */
public class PhotoRemindersInboxData {
    public final int f3566a;
    public final ImmutableList<Uri> f3567b;
    public final long f3568c;
    public final ImmutableList<String> f3569d;

    public PhotoRemindersInboxData(int i, ImmutableList<Uri> immutableList, long j, ImmutableList<String> immutableList2) {
        this.f3566a = i;
        this.f3567b = immutableList;
        this.f3568c = j;
        this.f3569d = immutableList2;
    }
}
