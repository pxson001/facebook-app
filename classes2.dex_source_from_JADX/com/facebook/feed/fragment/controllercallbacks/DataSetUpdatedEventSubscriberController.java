package com.facebook.feed.fragment.controllercallbacks;

import com.facebook.content.event.FbEvent;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.feed.rows.controllercallbacks.AdapterCreatedCallback;
import com.facebook.feed.util.event.DataSetEvents$DataSetUpdatedEventSubscriber;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.listview.ScrollingViewProxy;
import javax.inject.Inject;

/* compiled from: platform_get_app_call_for_pending_upload_params */
public class DataSetUpdatedEventSubscriberController extends BaseController implements AdapterCreatedCallback {
    private final DataSetEvents$DataSetUpdatedEventSubscriber f9709a = new C04111(this);
    private final FeedEventBus f9710b;
    public HasInvalidate f9711c;

    /* compiled from: platform_get_app_call_for_pending_upload_params */
    class C04111 extends DataSetEvents$DataSetUpdatedEventSubscriber {
        final /* synthetic */ DataSetUpdatedEventSubscriberController f9712a;

        C04111(DataSetUpdatedEventSubscriberController dataSetUpdatedEventSubscriberController) {
            this.f9712a = dataSetUpdatedEventSubscriberController;
        }

        public final void mo650b(FbEvent fbEvent) {
            this.f9712a.f9711c.hL_();
        }
    }

    public static DataSetUpdatedEventSubscriberController m14721a(InjectorLike injectorLike) {
        return new DataSetUpdatedEventSubscriberController(FeedEventBus.m4573a(injectorLike));
    }

    @Inject
    public DataSetUpdatedEventSubscriberController(FeedEventBus feedEventBus) {
        this.f9710b = feedEventBus;
    }

    public final void mo1889a(HasMultiRow hasMultiRow, ScrollingViewProxy scrollingViewProxy, FeedEnvironment feedEnvironment) {
        this.f9711c = feedEnvironment;
        this.f9710b.m4568a(this.f9709a);
    }

    public final void kF_() {
        this.f9711c = null;
        this.f9710b.m4569b(this.f9709a);
    }
}
