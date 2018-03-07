package com.facebook.facecast.plugin.commercialbreak;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.facebook.facecast.plugin.FacecastBasePlugin;
import com.facebook.facecast.plugin.FacecastRecordingAggregatePlugin.CommercialBreakController;
import com.facebook.facecast.plugin.commercialbreak.CommercialBreakBroadcastStateManager.CommercialBreakBroadcastState;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: birthday_post_cta */
public class FacecastCommercialBreakPromptPlugin extends FacecastBasePlugin {
    @Inject
    public CommercialBreakBroadcastStateManager f18591c;
    public final LinearLayout f18592d;
    @Nullable
    public CommercialBreakController f18593e;

    /* compiled from: birthday_post_cta */
    class C15991 implements OnClickListener {
        final /* synthetic */ FacecastCommercialBreakPromptPlugin f18589a;

        C15991(FacecastCommercialBreakPromptPlugin facecastCommercialBreakPromptPlugin) {
            this.f18589a = facecastCommercialBreakPromptPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -89240157);
            if (this.f18589a.f18593e != null) {
                this.f18589a.f18593e.m22118c();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -350848874, a);
        }
    }

    /* compiled from: birthday_post_cta */
    class C16002 implements OnClickListener {
        final /* synthetic */ FacecastCommercialBreakPromptPlugin f18590a;

        C16002(FacecastCommercialBreakPromptPlugin facecastCommercialBreakPromptPlugin) {
            this.f18590a = facecastCommercialBreakPromptPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1704313143);
            if (this.f18590a.f18593e != null) {
                CommercialBreakController commercialBreakController = this.f18590a.f18593e;
                commercialBreakController.f18475a.f18483f.m22185a(CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_PRE_COUNTDOWN);
                commercialBreakController.f18475a.f18486i.m22194d();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -54944025, a);
        }
    }

    public static void m22205a(Object obj, Context context) {
        ((FacecastCommercialBreakPromptPlugin) obj).f18591c = CommercialBreakBroadcastStateManager.m22183a(FbInjector.get(context));
    }

    public FacecastCommercialBreakPromptPlugin(Context context) {
        this(context, null);
    }

    private FacecastCommercialBreakPromptPlugin(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastCommercialBreakPromptPlugin(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = FacecastCommercialBreakPromptPlugin.class;
        m22205a(this, getContext());
        setContentView(2130904190);
        this.f18592d = (LinearLayout) a(2131561610);
        FbButton fbButton = (FbButton) a(2131561616);
        ((FbButton) a(2131561615)).setOnClickListener(new C15991(this));
        fbButton.setOnClickListener(new C16002(this));
    }

    public final boolean mo1409a() {
        if (this.f18591c.f18570b != CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_PROMPT || this.f18593e == null) {
            return false;
        }
        this.f18593e.m22118c();
        return true;
    }
}
