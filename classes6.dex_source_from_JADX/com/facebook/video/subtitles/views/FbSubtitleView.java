package com.facebook.video.subtitles.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.FbInjector;
import com.facebook.video.subtitles.controller.SubtitleAdapterFactory;
import com.facebook.video.subtitles.controller.SubtitleListener;
import com.facebook.video.subtitles.controller.SubtitleMediaTimeProvider;
import com.facebook.video.subtitles.controller.SubtitleText;
import com.facebook.video.subtitles.controller.Subtitles;
import com.facebook.video.subtitles.controller.compat.CustomSubtitleAdapter;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Preconditions;

/* compiled from: com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener */
public class FbSubtitleView extends CustomLinearLayout {
    public DefaultAndroidThreadUtil f19674a;
    public SubtitleAdapterFactory f19675b;
    public TextView f19676c;
    private Subtitles f19677d;
    public CustomSubtitleAdapter f19678e;
    private FbSubtitleListener f19679f;
    private SubtitleMediaTimeProvider f19680g;
    public int f19681h;
    public boolean f19682i;

    /* compiled from: com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener */
    class C14651 implements Runnable {
        final /* synthetic */ FbSubtitleView f19667a;

        C14651(FbSubtitleView fbSubtitleView) {
            this.f19667a = fbSubtitleView;
        }

        public void run() {
            this.f19667a.f19676c.setVisibility(0);
        }
    }

    /* compiled from: com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener */
    class C14662 implements Runnable {
        final /* synthetic */ FbSubtitleView f19668a;

        C14662(FbSubtitleView fbSubtitleView) {
            this.f19668a = fbSubtitleView;
        }

        public void run() {
            this.f19668a.f19676c.setVisibility(4);
        }
    }

    /* compiled from: com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener */
    class C14673 implements Runnable {
        final /* synthetic */ FbSubtitleView f19669a;

        C14673(FbSubtitleView fbSubtitleView) {
            this.f19669a = fbSubtitleView;
        }

        public void run() {
            this.f19669a.f19676c.setText("");
        }
    }

    /* compiled from: com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener */
    class C14695 implements Runnable {
        final /* synthetic */ FbSubtitleView f19672a;

        C14695(FbSubtitleView fbSubtitleView) {
            this.f19672a = fbSubtitleView;
        }

        public void run() {
            this.f19672a.f19681h = this.f19672a.f19681h - 1;
            if (this.f19672a.f19681h <= 0) {
                this.f19672a.f19676c.setText("");
            }
        }
    }

    /* compiled from: com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener */
    class FbSubtitleListener implements SubtitleListener, SubtitleMediaTimeProvider {
        private final FbSubtitleView f19673a;

        public FbSubtitleListener(FbSubtitleView fbSubtitleView) {
            Preconditions.checkArgument(fbSubtitleView != null);
            this.f19673a = fbSubtitleView;
        }

        public final void m28385a(SubtitleText subtitleText) {
            if (subtitleText != null) {
                this.f19673a.m28398a(subtitleText);
            }
        }

        public final int m28384a() {
            return this.f19673a.getMediaTimeMs();
        }
    }

    private static <T extends View> void m28389a(Class<T> cls, T t) {
        m28390a((Object) t, t.getContext());
    }

    private static void m28390a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        FbSubtitleView fbSubtitleView = (FbSubtitleView) obj;
        DefaultAndroidThreadUtil b = DefaultAndroidThreadUtil.b(fbInjector);
        SubtitleAdapterFactory a = SubtitleAdapterFactory.a(fbInjector);
        fbSubtitleView.f19674a = b;
        fbSubtitleView.f19675b = a;
    }

    public FbSubtitleView(Context context) {
        this(context, null, 0);
    }

    public FbSubtitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FbSubtitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f19679f = new FbSubtitleListener(this);
        this.f19681h = 0;
        this.f19682i = false;
        setContentView(2130907294);
        m28389a(FbSubtitleView.class, (View) this);
        this.f19676c = (TextView) a(2131567740);
        this.f19678e = this.f19675b.a();
        this.f19678e.h = this.f19679f;
        this.f19678e.a = this.f19679f;
    }

    public final void m28397a(SubtitleMediaTimeProvider subtitleMediaTimeProvider, Subtitles subtitles) {
        this.f19680g = subtitleMediaTimeProvider;
        this.f19677d = subtitles;
        this.f19678e.a(this.f19677d);
        m28395h();
        this.f19682i = true;
    }

    public final void m28396a() {
        if (this.f19674a.c()) {
            this.f19676c.setVisibility(0);
        } else {
            this.f19674a.b(new C14651(this));
        }
    }

    public final void m28399b() {
        if (this.f19674a.c()) {
            this.f19676c.setVisibility(4);
        } else {
            this.f19674a.b(new C14662(this));
        }
    }

    public final void m28400c() {
        Preconditions.checkArgument(this.f19682i);
        this.f19678e.b();
    }

    public final void m28402d() {
        Preconditions.checkArgument(this.f19682i);
        this.f19678e.c();
    }

    public final void m28401c(int i) {
        Preconditions.checkArgument(this.f19682i);
        this.f19678e.a(i);
    }

    public final void m28404f() {
        m28403e();
        m28395h();
        this.f19682i = false;
    }

    private boolean m28394g() {
        return this.f19682i;
    }

    public final void m28403e() {
        if (this.f19682i) {
            this.f19678e.d();
        }
    }

    private void m28395h() {
        this.f19674a.b(new C14673(this));
    }

    public int getMediaTimeMs() {
        if (this.f19680g != null) {
            return this.f19680g.a();
        }
        return 0;
    }

    public final void m28398a(final SubtitleText subtitleText) {
        this.f19674a.b(new Runnable(this) {
            final /* synthetic */ FbSubtitleView f19671b;

            public void run() {
                this.f19671b.f19681h = this.f19671b.f19681h + 1;
                this.f19671b.f19676c.setText(subtitleText.f19660b);
                this.f19671b.m28387a(subtitleText.f19661c);
            }
        });
    }

    private void m28387a(long j) {
        this.f19674a.a(new C14695(this), j);
    }
}
