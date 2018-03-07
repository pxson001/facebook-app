package com.facebook.bookmark.service.handler;

import android.content.ContentProviderOperation;
import android.content.Intent;
import com.facebook.bookmark.db.BookmarkDatabaseHelper;
import com.facebook.bookmark.ipc.BookmarkContract;
import com.facebook.bookmark.ipc.BookmarkContract$BookmarkGroupOrderTable;
import com.facebook.bookmark.ipc.BookmarkContract$BookmarkSyncStatusTable;
import com.facebook.bookmark.ipc.BookmarkContract$BookmarksTable;
import com.facebook.bookmark.ipc.BookmarkContract$BookmarksTable.Columns;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.bookmark.service.BroadcastSender;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler.Filter;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.google.common.collect.Lists;
import java.util.ArrayList;

/* compiled from: recent_all_transactions */
public class BookmarkSetFavoritesDBHandler implements Filter {
    private final BroadcastSender f5690a;
    private final BookmarkDatabaseHelper f5691b;

    public BookmarkSetFavoritesDBHandler(BroadcastSender broadcastSender, BookmarkDatabaseHelper bookmarkDatabaseHelper) {
        this.f5690a = broadcastSender;
        this.f5691b = bookmarkDatabaseHelper;
    }

    private void m5913a(BookmarksGroup bookmarksGroup) {
        Intent intent = new Intent(BookmarkContract.c);
        intent.setType("vnd.android.cursor.item/vnd.facebook.katana.favorites");
        intent.putExtra("bookmark_new_favorites", bookmarksGroup);
        this.f5690a.m5909a(intent);
    }

    public final OperationResult m5914a(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        BookmarksGroup bookmarksGroup = (BookmarksGroup) operationParams.c.getParcelable("newFavoriteBookmarksGroup");
        OperationResult a = blueServiceHandler.a(operationParams);
        BookmarkDatabaseHelper bookmarkDatabaseHelper = this.f5691b;
        ArrayList a2 = Lists.a();
        a2.add(ContentProviderOperation.newDelete(BookmarkContract$BookmarksTable.f5666a).withSelection(Columns.f5663j.d + "=?", new String[]{"pinned"}).build());
        int i = 0;
        for (Bookmark bookmark : bookmarksGroup.m5883e()) {
            int i2 = i + 1;
            a2.add(ContentProviderOperation.newInsert(BookmarkContract$BookmarksTable.f5666a).withValues(BookmarkDatabaseHelper.m5833a(bookmark, bookmarksGroup, true, i)).build());
            i = i2;
        }
        a2.add(ContentProviderOperation.newUpdate(BookmarkContract$BookmarkGroupOrderTable.f5650a).withValue(BookmarkContract$BookmarkGroupOrderTable.Columns.f5649e.d, Integer.valueOf(bookmarksGroup.m5877b())).withValue(BookmarkContract$BookmarkGroupOrderTable.Columns.f5648d.d, Integer.valueOf(bookmarksGroup.m5873a())).withSelection(BookmarkContract$BookmarkGroupOrderTable.Columns.f5645a.d + "=?", new String[]{String.valueOf(bookmarksGroup.id)}).build());
        a2.add(ContentProviderOperation.newUpdate(BookmarkContract$BookmarkSyncStatusTable.f5653a).withValue(BookmarkContract$BookmarkSyncStatusTable.Columns.f5652b.d, Long.valueOf(System.currentTimeMillis())).build());
        bookmarkDatabaseHelper.f5636a.applyBatch(BookmarkContract.a, a2);
        m5913a(bookmarksGroup);
        return a;
    }
}
