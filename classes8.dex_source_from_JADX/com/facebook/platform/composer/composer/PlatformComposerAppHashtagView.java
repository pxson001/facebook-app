package com.facebook.platform.composer.composer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: right_of */
public class PlatformComposerAppHashtagView extends CustomLinearLayout {
    private FbTextView f3977a;
    private GlyphView f3978b;
    public Listener f3979c;

    /* compiled from: right_of */
    class C05021 implements OnClickListener {
        final /* synthetic */ PlatformComposerAppHashtagView f3976a;

        C05021(PlatformComposerAppHashtagView platformComposerAppHashtagView) {
            this.f3976a = platformComposerAppHashtagView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -664593597);
            if (this.f3976a.f3979c != null) {
                this.f3976a.f3979c.mo196a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1367175192, a);
        }
    }

    /* compiled from: right_of */
    public interface Listener {
        void mo196a();
    }

    public PlatformComposerAppHashtagView(Context context) {
        super(context);
        m3947a();
    }

    public PlatformComposerAppHashtagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3947a();
    }

    private void m3947a() {
        setContentView(2130906297);
        this.f3977a = (FbTextView) a(2131566091);
        this.f3978b = (GlyphView) a(2131566092);
        this.f3978b.setOnClickListener(new C05021(this));
    }

    public void setListener(Listener listener) {
        this.f3979c = listener;
    }

    public void setAppProvidedHashtag(String str) {
        FbTextView fbTextView = this.f3977a;
        if (str == null) {
            str = "";
        }
        fbTextView.setText(str);
    }
}
