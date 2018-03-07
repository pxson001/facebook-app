package com.facebook.messaging.service.model;

import com.facebook.fbservice.results.DataFetchDisposition;
import com.facebook.messaging.model.folders.FolderCounts;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.threads.NotificationSetting;
import com.facebook.messaging.model.threads.ThreadsCollection;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: copy_attachment */
public class FetchThreadListResultBuilder {
    public DataFetchDisposition f17143a;
    public FolderName f17144b;
    public ThreadsCollection f17145c = ThreadsCollection.b;
    public List<User> f17146d = RegularImmutableList.a;
    public List<String> f17147e = RegularImmutableList.a;
    public List<String> f17148f = RegularImmutableList.a;
    public FolderCounts f17149g = FolderCounts.a;
    public NotificationSetting f17150h;
    public boolean f17151i;
    public long f17152j = -1;
    public long f17153k = -1;
    public long f17154l = -1;

    FetchThreadListResultBuilder() {
    }

    public final FetchThreadListResultBuilder m17124a(FetchThreadListResult fetchThreadListResult) {
        this.f17143a = fetchThreadListResult.f17131a;
        this.f17144b = fetchThreadListResult.f17132b;
        this.f17145c = fetchThreadListResult.f17133c;
        this.f17146d = fetchThreadListResult.f17134d;
        this.f17147e = fetchThreadListResult.f17135e;
        this.f17148f = fetchThreadListResult.f17136f;
        this.f17149g = fetchThreadListResult.f17137g;
        this.f17150h = fetchThreadListResult.f17138h;
        this.f17151i = fetchThreadListResult.f17139i;
        this.f17152j = fetchThreadListResult.f17142l;
        this.f17153k = fetchThreadListResult.f17140j;
        return this;
    }

    public final FetchThreadListResultBuilder m17119a(DataFetchDisposition dataFetchDisposition) {
        this.f17143a = dataFetchDisposition;
        return this;
    }

    public final FetchThreadListResultBuilder m17121a(FolderName folderName) {
        this.f17144b = folderName;
        return this;
    }

    public final FetchThreadListResultBuilder m17123a(ThreadsCollection threadsCollection) {
        this.f17145c = threadsCollection;
        return this;
    }

    public final FetchThreadListResultBuilder m17125a(ImmutableList<User> immutableList) {
        this.f17146d = immutableList;
        return this;
    }

    public final FetchThreadListResultBuilder m17120a(FolderCounts folderCounts) {
        this.f17149g = folderCounts;
        return this;
    }

    public final FetchThreadListResultBuilder m17122a(NotificationSetting notificationSetting) {
        this.f17150h = notificationSetting;
        return this;
    }

    public final FetchThreadListResultBuilder m17126a(boolean z) {
        this.f17151i = z;
        return this;
    }

    public final FetchThreadListResultBuilder m17118a(long j) {
        this.f17152j = j;
        return this;
    }

    public final FetchThreadListResultBuilder m17127b(long j) {
        this.f17153k = j;
        return this;
    }

    public final FetchThreadListResultBuilder m17128c(long j) {
        this.f17154l = j;
        return this;
    }

    public final FetchThreadListResult m17129m() {
        return new FetchThreadListResult(this);
    }
}
