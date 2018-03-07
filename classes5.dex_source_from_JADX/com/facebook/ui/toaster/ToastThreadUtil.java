package com.facebook.ui.toaster;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;

/* compiled from: comment_sticker_keyboard_opened */
public class ToastThreadUtil {
    public final Context f5512a;
    private final Handler f5513b;

    public static ToastThreadUtil m10356b(InjectorLike injectorLike) {
        return new ToastThreadUtil((Context) injectorLike.getInstance(Context.class), Handler_ForUiThreadMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public ToastThreadUtil(Context context, Handler handler) {
        this.f5512a = context;
        this.f5513b = handler;
    }

    public final void m10357a(String str) {
        m10358a(str, 0);
    }

    public final void m10358a(final String str, final int i) {
        HandlerDetour.a(this.f5513b, new Runnable(this) {
            final /* synthetic */ ToastThreadUtil f5511c;

            public void run() {
                Toast.makeText(this.f5511c.f5512a, str, i).show();
            }
        }, 1591369479);
    }

    public static ToastThreadUtil m10355a(InjectorLike injectorLike) {
        return m10356b(injectorLike);
    }
}
