package com.facebook.bookmark.db;

/* compiled from: register_response_payload */
class BookmarkDatabaseCleaner$1 implements Runnable {
    final /* synthetic */ BookmarkDatabaseCleaner f5632a;

    BookmarkDatabaseCleaner$1(BookmarkDatabaseCleaner bookmarkDatabaseCleaner) {
        this.f5632a = bookmarkDatabaseCleaner;
    }

    public void run() {
        this.f5632a.clearUserData();
    }
}
