package com.facebook.bookmark.ui.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.bookmark.client.BookmarkClient;
import com.facebook.bookmark.event.BookmarkAnalyticHelper;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.ui.event.BookmarkEvent;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.base.Strings;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: received_page_responsiveness_value */
public class BookmarkAnalytics {
    private static final PrefKey f5729a = ((PrefKey) SharedPrefKeys.a.a("bookmarks/impression"));
    private final Set<String> f5730b = new HashSet();
    private final AnalyticsLogger f5731c;
    private final BookmarkAnalyticHelper f5732d;
    private final FbSharedPreferences f5733e;
    private final Clock f5734f;

    public static BookmarkAnalytics m5960b(InjectorLike injectorLike) {
        return new BookmarkAnalytics(AnalyticsLoggerMethodAutoProvider.a(injectorLike), new BookmarkAnalyticHelper(BookmarkClient.m5806a(injectorLike)), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BookmarkAnalytics(AnalyticsLogger analyticsLogger, BookmarkAnalyticHelper bookmarkAnalyticHelper, FbSharedPreferences fbSharedPreferences, Clock clock) {
        this.f5731c = analyticsLogger;
        this.f5732d = bookmarkAnalyticHelper;
        this.f5733e = fbSharedPreferences;
        this.f5734f = clock;
    }

    public final void m5963a(List<Bookmark> list) {
        if (this.f5734f.a() - this.f5733e.a(f5729a, 0) >= 43200000) {
            this.f5731c.a(new BookmarkImpressionEvent(this.f5732d, list));
        }
    }

    public final void m5961a(Bookmark bookmark) {
        if (bookmark != null) {
            this.f5731c.a(new BookmarkClickEvent(this.f5732d, bookmark));
            if (!Strings.isNullOrEmpty(bookmark.clientToken)) {
                this.f5731c.d(new BookmarkAdClickEvent(bookmark));
            }
        }
    }

    public final void m5962a(BookmarkEvent bookmarkEvent, String str) {
        Bookmark bookmark = bookmarkEvent.f5737b;
        this.f5731c.a(new OpenApplicationEvent(str, String.valueOf(bookmark != null ? Long.valueOf(bookmark.id) : bookmarkEvent.f5739d), bookmark != null ? bookmark.name : bookmarkEvent.f5739d));
    }
}
