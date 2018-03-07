package com.facebook.orca.compose;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.NavigationLogger;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.orca.compose.ComposeFragmentAttachmentSection.Listener;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Provider;

/* compiled from: open_keyboard */
public class NeueComposeFragmentAttachmentSection extends CustomLinearLayout implements ComposeFragmentAttachmentSection {
    public Listener f5544a;
    private final NavigationLogger f5545b;
    private final Provider<Boolean> f5546c;
    private final View f5547d;
    private final FbTextView f5548e;
    private final View f5549f;
    private boolean f5550g;
    private boolean f5551h;
    private boolean f5552i;

    /* compiled from: open_keyboard */
    class C07861 implements OnClickListener {
        final /* synthetic */ NeueComposeFragmentAttachmentSection f5541a;

        C07861(NeueComposeFragmentAttachmentSection neueComposeFragmentAttachmentSection) {
            this.f5541a = neueComposeFragmentAttachmentSection;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1761790965);
            this.f5541a.m5145a("take_photo");
            if (this.f5541a.f5544a != null) {
                this.f5541a.f5544a.mo231b();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 69019520, a);
        }
    }

    /* compiled from: open_keyboard */
    class C07872 implements OnClickListener {
        final /* synthetic */ NeueComposeFragmentAttachmentSection f5542a;

        C07872(NeueComposeFragmentAttachmentSection neueComposeFragmentAttachmentSection) {
            this.f5542a = neueComposeFragmentAttachmentSection;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1493824201);
            this.f5542a.m5145a("choose_photo");
            if (this.f5542a.f5544a != null) {
                this.f5542a.f5544a.mo230a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1890467700, a);
        }
    }

    /* compiled from: open_keyboard */
    class C07883 implements OnClickListener {
        final /* synthetic */ NeueComposeFragmentAttachmentSection f5543a;

        C07883(NeueComposeFragmentAttachmentSection neueComposeFragmentAttachmentSection) {
            this.f5543a = neueComposeFragmentAttachmentSection;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -556418994);
            this.f5543a.m5145a("record_audio");
            if (this.f5543a.f5544a != null) {
                this.f5543a.f5544a.mo232c();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1363601407, a);
        }
    }

    public NeueComposeFragmentAttachmentSection(Context context) {
        this(context, null);
    }

    public NeueComposeFragmentAttachmentSection(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5545b = NavigationLogger.a(FbInjector.get(context));
        this.f5546c = IdBasedProvider.a(FbInjector.get(context), 4099);
        setContentView(2130905425);
        this.f5547d = a(2131559368);
        this.f5548e = (FbTextView) a(2131564195);
        this.f5549f = a(2131564197);
        this.f5548e.setText(((Boolean) this.f5546c.get()).booleanValue() ? 2131231160 : 2131230973);
        this.f5547d.setOnClickListener(new C07861(this));
        this.f5548e.setOnClickListener(new C07872(this));
        this.f5549f.setOnClickListener(new C07883(this));
    }

    public final void mo163a() {
        if (!this.f5551h) {
            this.f5551h = true;
            this.f5548e.setVisibility(0);
        }
    }

    public final void mo164b() {
        if (!this.f5550g) {
            this.f5550g = true;
            this.f5547d.setVisibility(0);
        }
    }

    public final void mo165c() {
        if (!this.f5552i) {
            this.f5552i = true;
            this.f5549f.setVisibility(0);
        }
    }

    public final void mo166d() {
        if (this.f5552i) {
            this.f5552i = false;
            this.f5549f.setVisibility(4);
        }
    }

    public void setListener(Listener listener) {
        this.f5544a = listener;
    }

    private void m5145a(String str) {
        this.f5545b.a("attachment_popup", "button", str, null);
    }
}
