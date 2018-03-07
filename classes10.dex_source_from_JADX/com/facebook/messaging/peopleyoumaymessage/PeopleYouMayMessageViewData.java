package com.facebook.messaging.peopleyoumaymessage;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: removeMemberOperation */
public class PeopleYouMayMessageViewData {
    public final ImmutableList<PersonYouMayMessage> f3497a;
    public final boolean f3498b;
    public final String f3499c;
    public final String f3500d;

    public PeopleYouMayMessageViewData(ImmutableList<PersonYouMayMessage> immutableList, boolean z, String str, String str2) {
        this.f3497a = (ImmutableList) Preconditions.checkNotNull(immutableList);
        this.f3498b = z;
        this.f3499c = str;
        this.f3500d = str2;
    }
}
