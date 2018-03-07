package com.facebook.bookmark.service.handler;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.bookmark.db.BookmarkDatabaseHelper;
import com.facebook.bookmark.ipc.BookmarkContract;
import com.facebook.bookmark.ipc.BookmarkContract$BookmarksTable.Columns;
import com.facebook.bookmark.service.BroadcastSender;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;

/* compiled from: recent_all_includes_oldest_transaction */
public class BookmarkUpdateUnreadCountDBHandler implements BlueServiceHandler {
    public final BroadcastSender f5692a;
    private final BookmarkDatabaseHelper f5693b;

    public BookmarkUpdateUnreadCountDBHandler(BroadcastSender broadcastSender, BookmarkDatabaseHelper bookmarkDatabaseHelper) {
        this.f5692a = broadcastSender;
        this.f5693b = bookmarkDatabaseHelper;
    }

    public final OperationResult m5915a(OperationParams operationParams) {
        Bundle bundle = operationParams.c;
        long j = bundle.getLong(Columns.f5655b.d);
        int i = bundle.getInt(Columns.f5660g.d);
        if (!this.f5693b.m5844a(j, i)) {
            return OperationResult.a(ErrorCode.OTHER, "Fail to update unread count for bookmark " + j);
        }
        Intent intent = new Intent(BookmarkContract.c);
        intent.setType("vnd.android.cursor.item/vnd.facebook.katana.bookmark_unread_count");
        intent.putExtra("bookmark_fbid", j);
        intent.putExtra("bookmark_unread_count", i);
        this.f5692a.m5909a(intent);
        return OperationResult.a;
    }
}
