package com.facebook.platform.composer.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.annotation.Nullable;

/* compiled from: result is null */
public class PlatformComposerTitleBarView extends LinearLayout {
    public OnClickListener f4451a;
    public OnClickListener f4452b;
    public OnClickListener f4453c;
    private View f4454d;
    private View f4455e;
    private TextView f4456f;
    private TextView f4457g;
    private TextView f4458h;
    private TextView f4459i;

    /* compiled from: result is null */
    class C05811 implements OnClickListener {
        final /* synthetic */ PlatformComposerTitleBarView f4448a;

        C05811(PlatformComposerTitleBarView platformComposerTitleBarView) {
            this.f4448a = platformComposerTitleBarView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1176633453);
            if (this.f4448a.f4451a != null) {
                this.f4448a.f4451a.onClick(view);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1324053108, a);
        }
    }

    /* compiled from: result is null */
    class C05822 implements OnClickListener {
        final /* synthetic */ PlatformComposerTitleBarView f4449a;

        C05822(PlatformComposerTitleBarView platformComposerTitleBarView) {
            this.f4449a = platformComposerTitleBarView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -997736468);
            if (this.f4449a.f4452b != null) {
                this.f4449a.f4452b.onClick(view);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -980965105, a);
        }
    }

    /* compiled from: result is null */
    class C05833 implements OnClickListener {
        final /* synthetic */ PlatformComposerTitleBarView f4450a;

        C05833(PlatformComposerTitleBarView platformComposerTitleBarView) {
            this.f4450a = platformComposerTitleBarView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1746793994);
            if (this.f4450a.f4453c != null) {
                this.f4450a.f4453c.onClick(view);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -446580706, a);
        }
    }

    public PlatformComposerTitleBarView(Context context) {
        super(context);
    }

    public PlatformComposerTitleBarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 288663556);
        super.onFinishInflate();
        View findViewById = findViewById(2131559455);
        if (findViewById != null) {
            findViewById.setOnClickListener(new C05811(this));
        }
        findViewById = findViewById(2131566139);
        if (findViewById != null) {
            findViewById.setOnClickListener(new C05822(this));
        }
        this.f4456f = (TextView) findViewById(2131566144);
        this.f4457g = (TextView) findViewById(2131566140);
        this.f4458h = (TextView) findViewById(2131566145);
        this.f4459i = (TextView) findViewById(2131563174);
        this.f4455e = findViewById(2131566137);
        this.f4454d = findViewById(2131566138);
        if (this.f4454d != null) {
            this.f4454d.setOnClickListener(new C05833(this));
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -339775250, a);
    }

    public void setOnBackClickListener(OnClickListener onClickListener) {
        this.f4451a = onClickListener;
    }

    public void setOnTitleBarClickListener(OnClickListener onClickListener) {
        this.f4452b = onClickListener;
    }

    public void setOnToolbarButtonClickListener(OnClickListener onClickListener) {
        this.f4453c = onClickListener;
    }

    public void setPostButtonEnabled(boolean z) {
        if (this.f4454d != null) {
            this.f4454d.setEnabled(z);
        }
    }

    public void setShowPostButton(boolean z) {
        if (this.f4455e != null) {
            this.f4455e.setVisibility(z ? 0 : 8);
        }
    }

    public void setTitle(String str) {
        if (this.f4457g != null) {
            this.f4457g.setText(str);
        }
    }

    public void setTitlePrefix(String str) {
        if (this.f4456f != null) {
            this.f4456f.setText(str);
        }
    }

    public void setSubtitle(String str) {
        if (this.f4459i != null) {
            this.f4459i.setText(str);
        }
    }

    public void setSubtitlePrefix(String str) {
        if (this.f4458h != null) {
            this.f4458h.setText(str);
        }
    }
}
