package com.facebook.bookmark.service.handler;

import android.content.Intent;
import android.os.Parcelable;
import com.facebook.bookmark.FetchBookmarksResult;
import com.facebook.bookmark.db.BookmarkDatabaseHelper;
import com.facebook.bookmark.ipc.BookmarkContract;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.bookmark.service.BroadcastSender;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler.Filter;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: recent_emoji */
public class BookmarkSaveToDBServiceHandler implements Filter {
    public final BroadcastSender f5686a;
    private final BookmarkDatabaseHelper f5687b;
    private String f5688c = null;
    private final ObjectMapper f5689d;

    /* compiled from: recent_emoji */
    class C06051 extends TypeReference<List<BookmarksGroup>> {
        final /* synthetic */ BookmarkSaveToDBServiceHandler f5685b;

        C06051(BookmarkSaveToDBServiceHandler bookmarkSaveToDBServiceHandler) {
            this.f5685b = bookmarkSaveToDBServiceHandler;
        }
    }

    public BookmarkSaveToDBServiceHandler(BroadcastSender broadcastSender, BookmarkDatabaseHelper bookmarkDatabaseHelper, ObjectMapper objectMapper) {
        this.f5686a = broadcastSender;
        this.f5687b = bookmarkDatabaseHelper;
        this.f5689d = objectMapper;
    }

    public final OperationResult m5912a(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        OperationResult a = blueServiceHandler.a(operationParams);
        if (!a.b) {
            return a;
        }
        Parcelable fetchBookmarksResult;
        String str = a.c;
        long a2 = this.f5687b.m5841a();
        long currentTimeMillis = System.currentTimeMillis();
        if (a2 > 0 || !str.equals(this.f5688c)) {
            this.f5688c = str;
            List<BookmarksGroup> list = (List) this.f5689d.a(this.f5688c, new C06051(this));
            if (BuildConstants.j) {
                for (BookmarksGroup d : list) {
                    for (Bookmark bookmark : d.m5882d()) {
                        if (bookmark.url.startsWith("fb://")) {
                            bookmark.url = bookmark.url.replaceFirst("fb://", FBLinks.b);
                        }
                    }
                }
            }
            this.f5687b.m5843a((List) list, currentTimeMillis);
            fetchBookmarksResult = new FetchBookmarksResult(DataFreshnessResult.FROM_SERVER, currentTimeMillis, ImmutableList.copyOf(list));
        } else {
            fetchBookmarksResult = new FetchBookmarksResult(DataFreshnessResult.FROM_SERVER, currentTimeMillis, null);
        }
        Intent intent = new Intent(BookmarkContract.c);
        intent.setType("vnd.android.cursor.item/vnd.facebook.katana.bookmark");
        intent.putExtra("bookmark_groups", fetchBookmarksResult);
        this.f5686a.m5909a(intent);
        return OperationResult.a(fetchBookmarksResult);
    }
}
