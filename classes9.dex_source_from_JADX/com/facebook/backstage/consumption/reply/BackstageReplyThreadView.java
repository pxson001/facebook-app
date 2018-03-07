package com.facebook.backstage.consumption.reply;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger.Event;
import com.facebook.backstage.camera.CameraHolder;
import com.facebook.backstage.consumption.camera.CameraFlowLauncher;
import com.facebook.backstage.data.ReplyThreadSummary;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: ride_provider_loaded */
public class BackstageReplyThreadView extends LinearLayout {
    @Inject
    BackstageReplyThreadViewControllerProvider f4916a;
    @Inject
    BackstageAnalyticsLogger f4917b;
    private final BackstageReplyThreadViewController f4918c;

    private static <T extends View> void m4768a(Class<T> cls, T t) {
        m4769a((Object) t, t.getContext());
    }

    private static void m4769a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((BackstageReplyThreadView) obj).m4767a((BackstageReplyThreadViewControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(BackstageReplyThreadViewControllerProvider.class), BackstageAnalyticsLogger.m4259a(injectorLike));
    }

    public BackstageReplyThreadView(Context context) {
        this(context, null);
    }

    public BackstageReplyThreadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BackstageReplyThreadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4768a(BackstageReplyThreadView.class, (View) this);
        View.inflate(context, 2130903367, this);
        this.f4918c = this.f4916a.m4780a(this);
    }

    public final void m4770a(CameraHolder cameraHolder, CameraFlowLauncher cameraFlowLauncher) {
        this.f4918c.m4777a(cameraHolder, cameraFlowLauncher);
    }

    public final void m4771a(ReplyThreadSummary replyThreadSummary) {
        this.f4918c.m4778a(replyThreadSummary);
        this.f4917b.m4264a(Event.OPEN_REPLY_THREAD);
    }

    public final boolean m4772a() {
        return this.f4918c.m4779b();
    }

    private void m4767a(BackstageReplyThreadViewControllerProvider backstageReplyThreadViewControllerProvider, BackstageAnalyticsLogger backstageAnalyticsLogger) {
        this.f4916a = backstageReplyThreadViewControllerProvider;
        this.f4917b = backstageAnalyticsLogger;
    }
}
