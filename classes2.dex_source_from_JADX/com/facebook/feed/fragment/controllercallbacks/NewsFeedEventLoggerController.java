package com.facebook.feed.fragment.controllercallbacks;

import android.support.v4.app.Fragment;
import android.view.View;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.FragmentCreateDestroyCallbacks;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.controllercallbacks.fragment.ViewCreatedDestroyedCallbacks;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger.Event;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;

/* compiled from: place_review_img_height */
public class NewsFeedEventLoggerController extends BaseController implements FragmentCreateDestroyCallbacks, ResumePauseCallbacks, ViewCreatedDestroyedCallbacks {
    public final NewsFeedEventLogger f9799a;
    public Fragment f9800b;

    public static NewsFeedEventLoggerController m14823a(InjectorLike injectorLike) {
        return new NewsFeedEventLoggerController(NewsFeedEventLogger.m4405a(injectorLike));
    }

    @Inject
    public NewsFeedEventLoggerController(NewsFeedEventLogger newsFeedEventLogger) {
        this.f9799a = newsFeedEventLogger;
    }

    public final void mo1949b() {
        this.f9799a.m4409a(this.f9800b, Event.FRAGMENT_DESTROYED);
        this.f9800b = null;
    }

    public final void mo1264c() {
        this.f9799a.m4409a(this.f9800b, Event.FRAGMENT_RESUMED);
    }

    public final void mo1265d() {
    }

    public final void mo1886a(View view) {
        this.f9799a.m4409a(this.f9800b, Event.VIEW_CREATED);
    }

    public final void kG_() {
        this.f9799a.m4409a(this.f9800b, Event.VIEW_DESTROYED);
    }
}
