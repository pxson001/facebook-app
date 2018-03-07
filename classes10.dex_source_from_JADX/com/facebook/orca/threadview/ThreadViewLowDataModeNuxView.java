package com.facebook.orca.threadview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.text.BetterTextView;

/* compiled from: messenger_thread */
public class ThreadViewLowDataModeNuxView extends SegmentedLinearLayout {
    public BetterTextView f7646a;
    private BetterTextView f7647b;
    public Listener f7648c;

    /* compiled from: messenger_thread */
    public interface Listener {
        void mo254a();
    }

    /* compiled from: messenger_thread */
    class C11531 implements OnClickListener {
        final /* synthetic */ ThreadViewLowDataModeNuxView f7645a;

        C11531(ThreadViewLowDataModeNuxView threadViewLowDataModeNuxView) {
            this.f7645a = threadViewLowDataModeNuxView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -103974938);
            if (this.f7645a.f7648c != null) {
                this.f7645a.f7648c.mo254a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1462456922, a);
        }
    }

    public ThreadViewLowDataModeNuxView(Context context) {
        super(context);
        m7356a();
    }

    public ThreadViewLowDataModeNuxView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7356a();
    }

    public BetterTextView getTitleView() {
        return this.f7646a;
    }

    public void setListener(Listener listener) {
        this.f7648c = listener;
    }

    private void m7356a() {
        setContentView(2130907389);
        this.f7646a = (BetterTextView) a(2131567848);
        this.f7647b = (BetterTextView) a(2131567849);
        setOnClickListener(null);
        a(2131567850).setOnClickListener(new C11531(this));
    }
}
