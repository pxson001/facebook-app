package com.facebook.fbreact.views.fbperflogger;

import android.content.Context;
import android.view.Choreographer.FrameCallback;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.facebook.fbreact.fb4a.Fb4aReactPerfFlagListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ReactChoreographer;
import com.facebook.react.uimanager.ReactChoreographer.CallbackType;
import javax.annotation.Nullable;

/* compiled from: erphoto */
public class FbReactPerfLoggerFlag extends View {
    public final Fb4aReactPerfFlagListener f7475a;
    @Nullable
    public String f7476b;
    @Nullable
    public ReadableMap f7477c;

    public FbReactPerfLoggerFlag(Context context, Fb4aReactPerfFlagListener fb4aReactPerfFlagListener) {
        super(context);
        this.f7475a = fb4aReactPerfFlagListener;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 480051831);
        super.onAttachedToWindow();
        final ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        viewTreeObserver.addOnPreDrawListener(new OnPreDrawListener(this) {
            final /* synthetic */ FbReactPerfLoggerFlag f7474b;

            /* compiled from: erphoto */
            class C09441 implements FrameCallback {
                final /* synthetic */ C09451 f7472a;

                C09441(C09451 c09451) {
                    this.f7472a = c09451;
                }

                public void doFrame(long j) {
                    if (this.f7472a.f7474b.f7475a != null) {
                        Fb4aReactPerfFlagListener fb4aReactPerfFlagListener = this.f7472a.f7474b.f7475a;
                        String str = this.f7472a.f7474b.f7476b;
                        if ("EventsDashboardFragment".equals(str)) {
                            fb4aReactPerfFlagListener.f7317a.m8502c();
                        } else if ("2097168".equals(str)) {
                            fb4aReactPerfFlagListener.f7318b.b(2097168, (short) 2);
                        }
                    }
                }
            }

            public boolean onPreDraw() {
                viewTreeObserver.removeOnPreDrawListener(this);
                ReactChoreographer.a().a(CallbackType.PERF_MARKERS, new C09441(this));
                return true;
            }
        });
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2101450219, a);
    }
}
