package com.facebook.facecast.plugin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: broadcast_invite_friend_dialog */
public class FacecastAspectRatioButtonPlugin extends FacecastBasePlugin {
    public final GlyphView f18207c;

    /* compiled from: broadcast_invite_friend_dialog */
    public class C15311 implements OnClickListener {
        final /* synthetic */ FacecastAspectRatioButtonClickListener f18205a;
        final /* synthetic */ FacecastAspectRatioButtonPlugin f18206b;

        public C15311(FacecastAspectRatioButtonPlugin facecastAspectRatioButtonPlugin, FacecastAspectRatioButtonClickListener facecastAspectRatioButtonClickListener) {
            this.f18206b = facecastAspectRatioButtonPlugin;
            this.f18205a = facecastAspectRatioButtonClickListener;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -78366682);
            this.f18205a.mo1429b();
            Logger.a(2, EntryType.UI_INPUT_END, -26347179, a);
        }
    }

    /* compiled from: broadcast_invite_friend_dialog */
    public interface FacecastAspectRatioButtonClickListener {
        void mo1429b();
    }

    public FacecastAspectRatioButtonPlugin(Context context) {
        this(context, null);
    }

    private FacecastAspectRatioButtonPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastAspectRatioButtonPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130904187);
        this.f18207c = (GlyphView) a(2131561595);
    }
}
