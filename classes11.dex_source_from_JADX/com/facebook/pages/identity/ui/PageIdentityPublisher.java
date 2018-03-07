package com.facebook.pages.identity.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.util.ContextUtils;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.launch.ComposerIntentLauncher;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.intent_builder.DefaultPageSurfaceIntentBuilder;
import com.facebook.pages.common.logging.analytics.ActionEvent;
import com.facebook.pages.common.logging.analytics.PageAnalyticsEvent;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.identity.intent.impl.FbAndroidPageSurfaceIntentBuilder;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

/* compiled from: page_identity_like_fail */
public class PageIdentityPublisher extends CustomFrameLayout {
    @Inject
    public ComposerIntentLauncher f4251a;
    @Inject
    public ComposerLauncher f4252b;
    @Inject
    public DefaultPageSurfaceIntentBuilder f4253c;
    @Inject
    public PagesAnalytics f4254d;
    public long f4255e;
    public String f4256f;

    private static <T extends View> void m5226a(Class<T> cls, T t) {
        m5227a((Object) t, t.getContext());
    }

    private static void m5227a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PageIdentityPublisher pageIdentityPublisher = (PageIdentityPublisher) obj;
        ComposerIntentLauncher b = ComposerIntentLauncher.b(fbInjector);
        ComposerLauncher composerLauncher = (ComposerLauncher) ComposerLauncherImpl.a(fbInjector);
        DefaultPageSurfaceIntentBuilder defaultPageSurfaceIntentBuilder = (DefaultPageSurfaceIntentBuilder) FbAndroidPageSurfaceIntentBuilder.m5074b(fbInjector);
        PagesAnalytics a = PagesAnalytics.a(fbInjector);
        pageIdentityPublisher.f4251a = b;
        pageIdentityPublisher.f4252b = composerLauncher;
        pageIdentityPublisher.f4253c = defaultPageSurfaceIntentBuilder;
        pageIdentityPublisher.f4254d = a;
    }

    public PageIdentityPublisher(Context context) {
        super(context);
        m5224a();
    }

    public PageIdentityPublisher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5224a();
    }

    public PageIdentityPublisher(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5224a();
    }

    private void m5224a() {
        m5226a(PageIdentityPublisher.class, (View) this);
        setContentView(2130906034);
    }

    public final void m5229a(long j, String str, String str2, boolean z, String str3) {
        final long j2;
        final String str4;
        final String str5;
        this.f4255e = j;
        this.f4256f = str3;
        if (z) {
            j2 = j;
            str4 = str;
            str5 = str2;
            m5225a(findViewById(2131565528), new Runnable(this) {
                final /* synthetic */ PageIdentityPublisher f4242d;

                public void run() {
                    this.f4242d.f4251a.a(this.f4242d.f4253c.a(j2, str4, str5), 1756, (Activity) ContextUtils.a(this.f4242d.getContext(), Activity.class));
                }
            }, ActionEvent.EVENT_NON_ADMIN_SHARE_PHOTO);
        } else {
            findViewById(2131565528).setVisibility(8);
        }
        j2 = j;
        str4 = str;
        str5 = str2;
        final boolean z2 = z;
        m5225a(findViewById(2131565527), new Runnable(this) {
            final /* synthetic */ PageIdentityPublisher f4247e;

            public void run() {
                this.f4247e.f4252b.a(null, this.f4247e.f4253c.a(j2, str4, str5, z2).a(), 1756, (Activity) ContextUtils.a(this.f4247e.getContext(), Activity.class));
            }
        }, ActionEvent.EVENT_NON_ADMIN_WRITE_POST);
    }

    private void m5225a(View view, final Runnable runnable, final PageAnalyticsEvent pageAnalyticsEvent) {
        view.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PageIdentityPublisher f4250c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 634783012);
                this.f4250c.f4254d.a(this.f4250c.f4256f, pageAnalyticsEvent, this.f4250c.f4255e);
                runnable.run();
                Logger.a(2, EntryType.UI_INPUT_END, 376324070, a);
            }
        });
    }
}
