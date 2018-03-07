package com.facebook.bookmark.service.handler;

import com.facebook.bookmark.FetchBookmarksResult;
import com.facebook.bookmark.db.BookmarkDatabaseHelper;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler.Filter;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: recent_incoming_includes_oldest_transaction */
public class BookmarkLoadFromDBServiceHandler implements Filter {
    private final BookmarkDatabaseHelper f5683a;
    private final int f5684b;

    public BookmarkLoadFromDBServiceHandler(BookmarkDatabaseHelper bookmarkDatabaseHelper, int i) {
        this.f5683a = (BookmarkDatabaseHelper) Preconditions.checkNotNull(bookmarkDatabaseHelper);
        if (i <= 0) {
            throw new IllegalArgumentException("ExpireTime should be positive");
        }
        this.f5684b = i;
    }

    public final OperationResult m5911a(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        OperationResult a;
        DataFreshnessResult dataFreshnessResult;
        long b = this.f5683a.m5845b();
        if (((long) this.f5684b) + b < System.currentTimeMillis()) {
            try {
                a = blueServiceHandler.a(operationParams);
                if (a.b()) {
                    a.m().putInt("bookmarks_expire_time", this.f5684b);
                    return a;
                }
            } catch (Throwable e) {
                BLog.b(BookmarkLoadFromDBServiceHandler.class, "Fail to fetch bookmarks from server while data in db was expired.", e);
            }
            dataFreshnessResult = DataFreshnessResult.FROM_CACHE_STALE;
        } else {
            dataFreshnessResult = DataFreshnessResult.FROM_CACHE_UP_TO_DATE;
        }
        a = OperationResult.a(new FetchBookmarksResult(dataFreshnessResult, b, ImmutableList.copyOf(this.f5683a.m5846c())));
        a.m().putInt("bookmarks_expire_time", this.f5684b);
        return a;
    }
}
