package com.facebook.caspian.ui.standardheader;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.video.player.plugins.ICoverView;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.LazyView;
import javax.inject.Inject;

/* compiled from: criteria */
public class StandardProfileImageFrame extends CustomFrameLayout implements ICoverView {
    @Inject
    public Lazy<ProfileVideoIconBinder> f16580a;
    public StandardProfileImageView f16581b;
    public LazyView<ProfileVideoView> f16582c;
    public LazyView<FbDraweeView> f16583d;
    public ViewStub f16584e;

    private static <T extends View> void m20635a(Class<T> cls, T t) {
        m20636a((Object) t, t.getContext());
    }

    private static void m20636a(Object obj, Context context) {
        ((StandardProfileImageFrame) obj).f16580a = IdBasedLazy.a(FbInjector.get(context), 5034);
    }

    public StandardProfileImageFrame(Context context) {
        super(context);
    }

    private void m20634a(Lazy<ProfileVideoIconBinder> lazy) {
        this.f16580a = lazy;
    }

    public StandardProfileImageFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public StandardProfileImageFrame(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1924359985);
        super.onFinishInflate();
        m20635a(StandardProfileImageFrame.class, (View) this);
        this.f16581b = (StandardProfileImageView) c(2131567621);
        this.f16582c = new LazyView((ViewStub) c(2131566409));
        this.f16583d = new LazyView((ViewStub) c(2131566417));
        this.f16584e = (ViewStub) c(2131566342);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1706752105, a);
    }

    public final void m20637a() {
        if (this.f16581b != null) {
            this.f16581b.setVisibility(8);
            this.f16581b.setEnableDarkOverlay(false);
        }
        if (this.f16583d != null) {
            this.f16583d.c();
        }
    }

    public final void m20638b() {
        if (this.f16581b != null) {
            this.f16581b.setVisibility(0);
            this.f16581b.setEnableDarkOverlay(true);
        }
        if (this.f16583d != null) {
            ((ProfileVideoIconBinder) this.f16580a.get()).m20599a(this.f16583d, 2);
        }
    }

    public final void m20639c() {
        if (this.f16581b != null) {
            this.f16581b.setVisibility(0);
            this.f16581b.setEnableDarkOverlay(false);
        }
        if (this.f16583d != null) {
            ((ProfileVideoIconBinder) this.f16580a.get()).m20599a(this.f16583d, 0);
        }
    }

    public StandardProfileImageView getStandardProfileImageView() {
        return this.f16581b;
    }

    public LazyView<FbDraweeView> getLazyProfileVideoIcon() {
        return this.f16583d;
    }

    public LazyView<ProfileVideoView> getLazyProfileVideoView() {
        return this.f16582c;
    }

    public ViewStub getProfileEditIconViewStub() {
        return this.f16584e;
    }
}
