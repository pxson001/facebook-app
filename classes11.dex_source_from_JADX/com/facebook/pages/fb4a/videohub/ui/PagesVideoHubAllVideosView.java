package com.facebook.pages.fb4a.videohub.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.fbui.widget.text.BadgeTextView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.logging.analytics.TapEvent;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

/* compiled from: privacy_review_write_retry */
public class PagesVideoHubAllVideosView extends CustomFrameLayout {
    @Inject
    public PagesAnalytics f3122a;
    @Inject
    public FbUriIntentHandler f3123b;
    public BadgeTextView f3124c;

    /* compiled from: privacy_review_write_retry */
    public class C04261 implements OnClickListener {
        final /* synthetic */ long f3120a;
        final /* synthetic */ PagesVideoHubAllVideosView f3121b;

        public C04261(PagesVideoHubAllVideosView pagesVideoHubAllVideosView, long j) {
            this.f3121b = pagesVideoHubAllVideosView;
            this.f3120a = j;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1909280107);
            PagesVideoHubAllVideosView pagesVideoHubAllVideosView = this.f3121b;
            long j = this.f3120a;
            pagesVideoHubAllVideosView.f3122a.a(TapEvent.EVENT_TAPPED_VIDEO_HUB_ALL_VIDEOS, j);
            pagesVideoHubAllVideosView.f3123b.a(pagesVideoHubAllVideosView.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.aw, Long.valueOf(j), "VideoHubFragment"));
            Logger.a(2, EntryType.UI_INPUT_END, -1467358225, a);
        }
    }

    public static void m4217a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PagesVideoHubAllVideosView pagesVideoHubAllVideosView = (PagesVideoHubAllVideosView) obj;
        PagesAnalytics a = PagesAnalytics.a(fbInjector);
        FbUriIntentHandler a2 = FbUriIntentHandler.a(fbInjector);
        pagesVideoHubAllVideosView.f3122a = a;
        pagesVideoHubAllVideosView.f3123b = a2;
    }

    public PagesVideoHubAllVideosView(Context context, int i) {
        this(context, null, i);
    }

    private PagesVideoHubAllVideosView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = PagesVideoHubAllVideosView.class;
        m4217a(this, getContext());
        setContentView(2130907685);
        this.f3124c = (BadgeTextView) findViewById(2131568347);
    }
}
