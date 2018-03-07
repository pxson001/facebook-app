package com.facebook.bookmark;

import android.content.Context;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import com.facebook.bookmark.BookmarkManager.BookmarkCallback;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.fbservice.results.DataFreshnessResult;

/* compiled from: remain_attempts_count */
public class BookmarkLoaderCallbacks implements LoaderCallbacks<Void> {
    private final Context f5593a;
    private final BookmarkManager f5594b;
    private final boolean f5595c;
    private final BookmarkCallback f5596d;

    /* compiled from: remain_attempts_count */
    /* synthetic */ class C05911 {
        static final /* synthetic */ int[] f5588a = new int[DataFreshnessResult.values().length];

        static {
            try {
                f5588a[DataFreshnessResult.NO_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5588a[DataFreshnessResult.FROM_CACHE_STALE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5588a[DataFreshnessResult.FROM_CACHE_UP_TO_DATE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: remain_attempts_count */
    public class BookmarkLoader extends Loader<Void> implements BookmarkCallback {
        private boolean f5589a = false;
        private final BookmarkManager f5590b;
        private final boolean f5591c;
        private final BookmarkCallback f5592d;

        public BookmarkLoader(Context context, BookmarkManager bookmarkManager, boolean z, BookmarkCallback bookmarkCallback) {
            super(context);
            this.f5590b = bookmarkManager;
            this.f5591c = z;
            this.f5592d = bookmarkCallback;
        }

        protected final void m5793g() {
            super.g();
            if (!this.f5589a) {
                this.f5590b.mo217a((BookmarkCallback) this);
                this.f5589a = true;
            }
            boolean t = t();
            FetchBookmarksResult e = this.f5590b.mo222e();
            switch (C05911.f5588a[e.freshness.ordinal()]) {
                case 1:
                    this.f5590b.mo220c();
                    return;
                case 2:
                    if (this.f5591c && t) {
                        this.f5592d.mo211a(e, true);
                    }
                    this.f5590b.mo215a();
                    return;
                case 3:
                    if (t) {
                        this.f5592d.mo211a(e, true);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        protected final void m5794i() {
            super.i();
            this.f5590b.mo219b(this);
            this.f5589a = false;
        }

        public final void mo211a(FetchBookmarksResult fetchBookmarksResult, boolean z) {
            if (this.p) {
                this.f5592d.mo211a(fetchBookmarksResult, z);
            } else {
                w();
            }
        }

        public final void mo212a(Bookmark bookmark) {
            if (this.p) {
                this.f5592d.mo212a(bookmark);
            } else {
                w();
            }
        }

        public final void mo213a(BookmarksGroup bookmarksGroup) {
            if (this.p) {
                this.f5592d.mo213a(bookmarksGroup);
            } else {
                w();
            }
        }
    }

    public final /* bridge */ /* synthetic */ void m5795a(Loader loader, Object obj) {
    }

    public BookmarkLoaderCallbacks(Context context, BookmarkManager bookmarkManager, boolean z, BookmarkCallback bookmarkCallback) {
        this.f5593a = context;
        this.f5594b = bookmarkManager;
        this.f5595c = z;
        this.f5596d = bookmarkCallback;
    }

    public final Loader n_(int i) {
        return new BookmarkLoader(this.f5593a, this.f5594b, this.f5595c, this.f5596d);
    }

    public final void gA_() {
    }
}
