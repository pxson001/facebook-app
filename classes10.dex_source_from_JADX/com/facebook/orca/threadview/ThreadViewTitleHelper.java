package com.facebook.orca.threadview;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.common.util.ContextUtils;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.threadview.title.ThreadTitleHeader;
import com.facebook.messaging.threadview.title.ThreadTitleView;
import com.facebook.messaging.ui.name.MessengerThreadNameViewData;
import com.facebook.messaging.ui.name.MessengerThreadNameViewDataFactory;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.titlebar.FbTitleBar;
import javax.inject.Inject;

/* compiled from: mediaSource */
public class ThreadViewTitleHelper {
    private final Context f8028a;
    private final MessengerThreadNameViewDataFactory f8029b;
    private ThreadTitleView f8030c;
    private ThreadTitleHeader f8031d;
    public FbTitleBar f8032e;
    private int f8033f;

    public static ThreadViewTitleHelper m7934b(InjectorLike injectorLike) {
        return new ThreadViewTitleHelper((Context) injectorLike.getInstance(Context.class), MessengerThreadNameViewDataFactory.a(injectorLike));
    }

    @Inject
    public ThreadViewTitleHelper(Context context, MessengerThreadNameViewDataFactory messengerThreadNameViewDataFactory) {
        this.f8028a = context;
        this.f8029b = messengerThreadNameViewDataFactory;
    }

    public final void m7938a(FbTitleBar fbTitleBar) {
        m7933a(fbTitleBar, ContextUtils.b(this.f8028a, 2130773057, 2131625124));
    }

    public static ThreadViewTitleHelper m7931a(InjectorLike injectorLike) {
        return m7934b(injectorLike);
    }

    private void m7933a(FbTitleBar fbTitleBar, int i) {
        TracerDetour.a("TVTH.init", 1778292499);
        try {
            if (this.f8033f != i) {
                this.f8033f = i;
                Context contextThemeWrapper = new ContextThemeWrapper(this.f8028a, this.f8033f);
                this.f8032e = fbTitleBar;
                if (fbTitleBar.a()) {
                    this.f8030c = new ThreadTitleView(contextThemeWrapper);
                    fbTitleBar.setCustomTitleView(this.f8030c);
                } else {
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    this.f8031d = new ThreadTitleHeader(contextThemeWrapper);
                    this.f8031d.setLayoutParams(layoutParams);
                    View view = (View) fbTitleBar;
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    int a = m7930a(viewGroup, view);
                    m7932a(viewGroup, a);
                    viewGroup.addView(this.f8031d, a);
                }
                TracerDetour.a(-760362643);
            }
        } finally {
            TracerDetour.a(1336396024);
        }
    }

    public final void m7935a(int i) {
        if (!(this.f8032e == null || this.f8032e.a())) {
            View view = (View) this.f8032e;
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            m7932a(viewGroup, m7930a(viewGroup, view));
        }
        m7933a(this.f8032e, i);
    }

    public static void m7932a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildCount() > i && (viewGroup.getChildAt(i) instanceof ThreadTitleHeader)) {
            viewGroup.removeViewAt(i);
        }
    }

    public static int m7930a(ViewGroup viewGroup, View view) {
        return viewGroup.indexOfChild(view) + 1;
    }

    public final void m7936a(ThreadSummary threadSummary) {
        m7937a(this.f8029b.a(threadSummary));
    }

    public final void m7937a(MessengerThreadNameViewData messengerThreadNameViewData) {
        if (this.f8030c != null) {
            this.f8030c.setThreadNameViewData(messengerThreadNameViewData);
        } else if (this.f8031d != null) {
            this.f8031d.setThreadNameViewData(messengerThreadNameViewData);
        }
    }

    public final void m7939a(boolean z) {
        if (this.f8032e != null && this.f8032e.a()) {
            this.f8030c.m4364a(z);
        }
    }
}
