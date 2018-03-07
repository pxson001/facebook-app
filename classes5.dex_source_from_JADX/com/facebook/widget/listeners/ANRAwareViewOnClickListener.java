package com.facebook.widget.listeners;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: com.facebook.workdev */
public abstract class ANRAwareViewOnClickListener implements OnClickListener {
    private final long f5821a = 500;
    private long f5822b = 0;

    public abstract void m10568a();

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1601665960);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f5822b > this.f5821a) {
            m10568a();
        }
        this.f5822b = currentTimeMillis;
        Logger.a(2, EntryType.UI_INPUT_END, -1799554170, a);
    }
}
