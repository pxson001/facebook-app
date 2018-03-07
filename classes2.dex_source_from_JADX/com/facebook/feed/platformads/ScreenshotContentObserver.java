package com.facebook.feed.platformads;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore.Images.Media;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.feed.fragment.controllercallbacks.NewsFeedScreenshotController.ScreenshotListener;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.inject.Assisted;
import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: messenger_custom_nicknames_thread_details */
public class ScreenshotContentObserver extends ContentObserver {
    private static final Class f14079a = ScreenshotContentObserver.class;
    private static final String f14080b = (Media.EXTERNAL_CONTENT_URI.toString() + File.separator + "[0-9]+");
    private static final String[] f14081c = new String[]{"_display_name"};
    private final Clock f14082d;
    private final Context f14083e;
    private final FeedEventBus f14084f;
    @Nullable
    public ScreenshotListener f14085g;

    @Inject
    public ScreenshotContentObserver(Clock clock, @Assisted Context context, Handler handler, FeedEventBus feedEventBus) {
        super(handler);
        this.f14082d = clock;
        this.f14083e = context;
        this.f14084f = feedEventBus;
    }

    public boolean deliverSelfNotifications() {
        return false;
    }

    public void onChange(boolean z) {
        super.onChange(z);
        onChange(z, null);
    }

    public void onChange(boolean z, Uri uri) {
        Cursor query;
        Throwable th;
        if (uri != null && uri != Uri.EMPTY && uri.toString().matches(f14080b)) {
            long toSeconds = TimeUnit.MILLISECONDS.toSeconds(this.f14082d.mo211a());
            try {
                Uri uri2 = uri;
                query = this.f14083e.getContentResolver().query(uri2, f14081c, StringFormatUtil.a("%s > %s AND %s < %s AND %s LIKE %s", new Object[]{"date_added", Long.valueOf(toSeconds - 10), "date_added", Long.valueOf(toSeconds + 10), "_display_name", "'%screenshot%'"}), null, "date_added DESC LIMIT 1");
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            if (this.f14085g != null) {
                                this.f14085g.m14930a();
                            }
                            if (query != null) {
                                query.close();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th3) {
                th = th3;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        }
    }
}
