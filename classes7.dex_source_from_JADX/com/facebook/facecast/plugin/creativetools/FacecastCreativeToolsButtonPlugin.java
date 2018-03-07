package com.facebook.facecast.plugin.creativetools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.facecast.plugin.FacecastBasePlugin;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: boosted_component_status */
public class FacecastCreativeToolsButtonPlugin extends FacecastBasePlugin {
    public final GlyphView f18734c;
    public boolean f18735d;

    /* compiled from: boosted_component_status */
    public interface CreativeToolsButtonClickListener {
        void mo1426a(boolean z);
    }

    /* compiled from: boosted_component_status */
    public class C16191 implements OnClickListener {
        final /* synthetic */ CreativeToolsButtonClickListener f18732a;
        final /* synthetic */ FacecastCreativeToolsButtonPlugin f18733b;

        public C16191(FacecastCreativeToolsButtonPlugin facecastCreativeToolsButtonPlugin, CreativeToolsButtonClickListener creativeToolsButtonClickListener) {
            this.f18733b = facecastCreativeToolsButtonPlugin;
            this.f18732a = creativeToolsButtonClickListener;
        }

        public void onClick(View view) {
            boolean z;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -437128056);
            FacecastCreativeToolsButtonPlugin facecastCreativeToolsButtonPlugin = this.f18733b;
            if (this.f18733b.f18735d) {
                z = false;
            } else {
                z = true;
            }
            facecastCreativeToolsButtonPlugin.f18735d = z;
            FacecastCreativeToolsButtonPlugin.m22289k(this.f18733b);
            this.f18732a.mo1426a(this.f18733b.f18735d);
            LogUtils.a(617064625, a);
        }
    }

    public FacecastCreativeToolsButtonPlugin(Context context) {
        this(context, null);
    }

    private FacecastCreativeToolsButtonPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastCreativeToolsButtonPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130904195);
        this.f18734c = (GlyphView) a(2131561621);
        m22289k(this);
    }

    public static void m22289k(FacecastCreativeToolsButtonPlugin facecastCreativeToolsButtonPlugin) {
        facecastCreativeToolsButtonPlugin.f18734c.setSelected(facecastCreativeToolsButtonPlugin.f18735d);
        facecastCreativeToolsButtonPlugin.f18734c.setImageResource(facecastCreativeToolsButtonPlugin.f18735d ? 2130839815 : 2130839975);
    }

    public void setButtonEnabled(boolean z) {
        this.f18734c.setEnabled(z);
    }
}
