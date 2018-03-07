package com.facebook.bookmark;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.bookmark.iface.BookmarkSyncListener;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.OperationResult;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: reloadGroups() not supported yet */
public interface BookmarkManager extends IHaveUserData, BookmarkSyncListener {

    /* compiled from: reloadGroups() not supported yet */
    public interface BookmarkCallback {
        void mo211a(FetchBookmarksResult fetchBookmarksResult, boolean z);

        void mo212a(Bookmark bookmark);

        void mo213a(BookmarksGroup bookmarksGroup);
    }

    ListenableFuture<Collection<Bookmark>> mo214a(String str);

    void mo215a();

    void mo216a(long j, int i);

    void mo217a(BookmarkCallback bookmarkCallback);

    List<BookmarksGroup> mo218b();

    void mo219b(BookmarkCallback bookmarkCallback);

    @Nullable
    ListenableFuture<OperationResult> mo220c();

    DataFreshnessResult mo221d();

    FetchBookmarksResult mo222e();

    void mo223f();
}
