package com.facebook.timeline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import com.facebook.widget.LazyView;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: extra_invite_configuration_bundle */
public class TimelineErrorViewBinder {
    public final ProfileControllerDelegate f12749a;

    public static TimelineErrorViewBinder m12695a(InjectorLike injectorLike) {
        return new TimelineErrorViewBinder(ProfileControllerDelegate.m10751a(injectorLike));
    }

    @Inject
    public TimelineErrorViewBinder(ProfileControllerDelegate profileControllerDelegate) {
        this.f12749a = profileControllerDelegate;
    }

    public static LazyView<View> m12696a(View view) {
        ViewStub viewStub = (ViewStub) view.findViewById(2131560575);
        Preconditions.checkNotNull(viewStub, "Unable to find error view or error view stub");
        return new LazyView(viewStub);
    }

    public final void m12699a(@Nullable final LazyView<View> lazyView, int i, boolean z) {
        if (lazyView != null) {
            View findViewById;
            if (lazyView.b()) {
                findViewById = lazyView.a().findViewById(2131561897);
            } else {
                View findViewById2 = lazyView.a().findViewById(2131561897);
                findViewById2.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ TimelineErrorViewBinder f12748b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -1140870864);
                        lazyView.c();
                        this.f12748b.f12749a.mo470e();
                        Logger.a(2, EntryType.UI_INPUT_END, -366846299, a);
                    }
                });
                findViewById = findViewById2;
            }
            View findViewById3 = lazyView.a().findViewById(2131561900);
            ((TextView) lazyView.a().findViewById(2131561899)).setText(i);
            if (z) {
                findViewById.setClickable(true);
                findViewById3.setVisibility(0);
            } else {
                findViewById.setClickable(false);
                findViewById3.setVisibility(8);
            }
            lazyView.a().setVisibility(0);
        }
    }

    public static boolean m12697a(@Nullable LazyView<View> lazyView) {
        return lazyView != null && lazyView.b() && lazyView.a().getVisibility() == 0;
    }

    public static void m12698b(@Nullable LazyView<View> lazyView) {
        if (lazyView != null) {
            lazyView.c();
        }
    }
}
