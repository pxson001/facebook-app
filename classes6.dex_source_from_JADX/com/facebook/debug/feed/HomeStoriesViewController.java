package com.facebook.debug.feed;

import android.app.Activity;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler.StorySeenStats;
import com.facebook.api.feedtype.FeedType;
import java.util.Timer;
import java.util.TimerTask;
import javax.inject.Inject;

/* compiled from: onlyme-fb4atux */
public class HomeStoriesViewController {
    public final DbFeedHomeStoriesHandler f8666a;
    public Timer f8667b;
    public HomeStoriesView f8668c;
    public boolean f8669d = false;

    /* compiled from: onlyme-fb4atux */
    class C05701 extends TimerTask {
        final /* synthetic */ HomeStoriesViewController f8659a;

        C05701(HomeStoriesViewController homeStoriesViewController) {
            this.f8659a = homeStoriesViewController;
        }

        public void run() {
            StorySeenStats h = this.f8659a.f8666a.h(FeedType.b);
            this.f8659a.m12466a(h.b, h.a, this.f8659a.f8666a.d(FeedType.b), h.c, h.d);
        }
    }

    @Inject
    public HomeStoriesViewController(DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler) {
        this.f8666a = dbFeedHomeStoriesHandler;
    }

    private void m12468c() {
        this.f8667b = new Timer();
        this.f8667b.scheduleAtFixedRate(new C05701(this), 0, 1000);
    }

    private void m12466a(int i, int i2, int i3, int i4, int i5) {
        final int i6 = i;
        final int i7 = i2;
        final int i8 = i3;
        final int i9 = i4;
        final int i10 = i5;
        this.f8668c.post(new Runnable(this) {
            final /* synthetic */ HomeStoriesViewController f8665f;

            public void run() {
                this.f8665f.f8668c.m12465a(i6, i7, i8, i9, i10);
            }
        });
    }

    public final void m12469a(Activity activity) {
        if (this.f8668c == null) {
            this.f8668c = new HomeStoriesView(activity);
            activity.getWindow().addContentView(this.f8668c, new LayoutParams(700, 30, 3));
            m12468c();
            this.f8669d = true;
        }
    }

    public final void m12470b() {
        if (!this.f8669d) {
            this.f8669d = true;
            m12468c();
        }
    }
}
