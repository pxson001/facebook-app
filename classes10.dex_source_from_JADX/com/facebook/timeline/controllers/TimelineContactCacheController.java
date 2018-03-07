package com.facebook.timeline.controllers;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.contacts.graphql.Contact;
import com.facebook.inject.Lazy;
import com.facebook.timeline.BaseTimelineFragment;
import com.facebook.timeline.TimelineFragment;
import com.facebook.timeline.datafetcher.FetchContactCacheTask;
import com.facebook.timeline.datafetcher.FetchContactCacheTaskProvider;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: group_is_viewer_admin */
public class TimelineContactCacheController {
    public final Lazy<FbErrorReporter> f10351a;
    public final DefaultAndroidThreadUtil f10352b;
    public final FetchContactCacheTaskProvider f10353c;

    @Inject
    public TimelineContactCacheController(AndroidThreadUtil androidThreadUtil, Lazy<FbErrorReporter> lazy, FetchContactCacheTaskProvider fetchContactCacheTaskProvider) {
        this.f10352b = androidThreadUtil;
        this.f10351a = lazy;
        this.f10353c = fetchContactCacheTaskProvider;
    }

    public final void m10480a(@Nullable FetchContactCacheTask fetchContactCacheTask, final TimelineFragment timelineFragment) {
        if (fetchContactCacheTask != null) {
            Futures.a(fetchContactCacheTask.f10402c, new AbstractDisposableFutureCallback<Contact>(this) {
                final /* synthetic */ TimelineContactCacheController f10350b;

                protected final void m10478a(Object obj) {
                    Contact contact = (Contact) obj;
                    BaseTimelineFragment baseTimelineFragment = timelineFragment;
                    if (contact != null && baseTimelineFragment.cg != null && baseTimelineFragment.cg.j()) {
                        baseTimelineFragment.cg.a(contact);
                        baseTimelineFragment.aC();
                    }
                }

                protected final void m10479a(Throwable th) {
                    ((AbstractFbErrorReporter) this.f10350b.f10351a.get()).b("contact_cache_fetch_contact", th);
                }
            }, MoreExecutors.b());
        }
    }
}
