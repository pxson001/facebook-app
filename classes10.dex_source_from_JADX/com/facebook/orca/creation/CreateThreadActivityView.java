package com.facebook.orca.creation;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.ui.keyboard.SoftInputDetector;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.analytics.navigation.MessagingAnalyticsLogger;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.OverlayLayout;
import javax.inject.Inject;

/* compiled from: null ViewerContextUser found when opening recipient picker dialog from group thread */
public class CreateThreadActivityView extends OverlayLayout {
    private MessagingAnalyticsLogger f6157a;
    private SoftInputDetector f6158b;

    private static <T extends View> void m5895a(Class<T> cls, T t) {
        m5896a((Object) t, t.getContext());
    }

    private static void m5896a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((CreateThreadActivityView) obj).m5894a(MessagingAnalyticsLogger.b(fbInjector), SoftInputDetector.a(fbInjector));
    }

    public CreateThreadActivityView(Context context) {
        super(context);
        m5893a();
    }

    public CreateThreadActivityView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5893a();
    }

    private void m5893a() {
        m5895a(CreateThreadActivityView.class, (View) this);
    }

    @Inject
    private void m5894a(MessagingAnalyticsLogger messagingAnalyticsLogger, SoftInputDetector softInputDetector) {
        this.f6157a = messagingAnalyticsLogger;
        this.f6158b = softInputDetector;
    }

    protected void onMeasure(int i, int i2) {
        this.f6158b.a(this, i2);
        super.onMeasure(i, i2);
    }

    protected void dispatchDraw(Canvas canvas) {
        TracerDetour.a("CreateThreadActivityView.dispatchDraw", -1356599138);
        try {
            super.dispatchDraw(canvas);
            this.f6157a.c("create_thread");
        } finally {
            TracerDetour.a(113471789);
        }
    }
}
