package com.facebook.backstage.camera;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.backstage.camera.LiveStatusPoller.LiveStatusListener;
import com.facebook.backstage.data.LiveStatus;
import com.facebook.backstage.util.LocaleTimeUtil;
import com.facebook.debug.log.BLog;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomRelativeLayout;
import javax.annotation.Nullable;

/* compiled from: search?config={%s} */
public class LiveStatusView extends CustomRelativeLayout implements LiveStatusListener {
    private static final String f4423a = LiveStatusView.class.getSimpleName();
    private FbTextView f4424b;
    private FbTextView f4425c;
    private FbTextView f4426d;
    private LiveStatus f4427e;
    private int f4428f;

    private void m4418b(LiveStatus liveStatus) {
        long j = liveStatus.f5124d;
        if (j >= 0 && this.f4427e.f5124d != j) {
            setElapsedTime(liveStatus.f5124d);
        }
        if (this.f4427e.f5122b != liveStatus.f5122b) {
            setViewerCount(liveStatus.f5122b);
        }
        if (!m4417a(this.f4427e.f5123c, liveStatus.f5123c)) {
            setLocation(liveStatus.f5123c);
        }
    }

    public LiveStatusView(Context context) {
        super(context);
        this.f4427e = new LiveStatus();
    }

    public LiveStatusView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4427e = new LiveStatus();
        View.inflate(context, 2130904538, this);
        this.f4424b = (FbTextView) findViewById(2131562394);
        this.f4425c = (FbTextView) findViewById(2131562395);
        this.f4426d = (FbTextView) findViewById(2131562396);
        this.f4428f = 2000000000;
    }

    public void setElapsedTime(long j) {
        this.f4424b.setText(LocaleTimeUtil.m5778a(j));
    }

    public void setLocation(String str) {
        this.f4425c.setText(str);
    }

    public void setViewerCount(long j) {
        if (j == 0) {
            this.f4426d.setText(2131239945);
            return;
        }
        this.f4426d.setText(getResources().getQuantityString(2131689752, j > ((long) this.f4428f) ? this.f4428f : (int) j, new Object[]{Long.valueOf(j)}));
    }

    public void setMaxViewerCountToDisplay(int i) {
        this.f4428f = i;
    }

    public final void mo150a(@Nullable LiveStatus liveStatus) {
        if (liveStatus == null) {
            BLog.a(f4423a, "Live status updates is null, skip");
            return;
        }
        m4418b(liveStatus);
        this.f4427e = liveStatus;
    }

    private static boolean m4417a(String str, String str2) {
        return (str == null && str2 == null) || (str != null && str.equals(str2));
    }
}
