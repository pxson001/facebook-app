package com.facebook.video.followvideos;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: doSomeWork */
public class VideoHomeToggleButton extends CustomLinearLayout {
    private boolean f15695a;
    private String f15696b;
    private String f15697c;
    private SubscribeStateChangedListener f15698d;
    private final TextView f15699e;
    private final GlyphView f15700f;

    /* compiled from: doSomeWork */
    public interface SubscribeStateChangedListener {
        void mo1205a(boolean z);
    }

    /* compiled from: doSomeWork */
    class C12041 implements OnClickListener {
        final /* synthetic */ VideoHomeToggleButton f15694a;

        C12041(VideoHomeToggleButton videoHomeToggleButton) {
            this.f15694a = videoHomeToggleButton;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1070156653);
            VideoHomeToggleButton.m19640c(this.f15694a);
            Logger.a(2, EntryType.UI_INPUT_END, 44389662, a);
        }
    }

    public VideoHomeToggleButton(Context context) {
        this(context, null);
    }

    public VideoHomeToggleButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoHomeToggleButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130907680);
        if (getBackground() == null) {
            setBackgroundResource(2130843896);
        }
        this.f15699e = (TextView) a(2131558966);
        this.f15700f = (GlyphView) a(2131558934);
        setOnClickListener(new C12041(this));
    }

    public final void m19643a(boolean z, String str, String str2, SubscribeStateChangedListener subscribeStateChangedListener) {
        this.f15696b = str;
        this.f15697c = str2;
        if (z != this.f15695a) {
            this.f15695a = z;
        }
        m19639b();
        this.f15698d = subscribeStateChangedListener;
    }

    public final void m19642a(boolean z) {
        this.f15695a = z;
        m19639b();
    }

    private void m19639b() {
        CharSequence charSequence = this.f15695a ? this.f15696b : this.f15697c;
        if (charSequence != null) {
            this.f15699e.setText(charSequence);
        }
        this.f15700f.setVisibility(this.f15695a ? 0 : 8);
    }

    public static void m19640c(VideoHomeToggleButton videoHomeToggleButton) {
        videoHomeToggleButton.f15695a = !videoHomeToggleButton.f15695a;
        videoHomeToggleButton.m19639b();
        if (videoHomeToggleButton.f15698d != null) {
            videoHomeToggleButton.f15698d.mo1205a(videoHomeToggleButton.f15695a);
        }
    }

    public final void m19641a() {
        this.f15699e.setTextColor(getResources().getColor(2131362106));
        this.f15700f.setGlyphColor(getResources().getColor(2131362106));
        setBackgroundResource(2130843897);
    }
}
