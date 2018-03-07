package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import com.facebook.content.event.FbEvent;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.resources.ui.FbTextView;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPCommercialBreakStateChangeEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import javax.annotation.Nullable;

@DoNotStrip
/* compiled from: plan_user_invited */
public class CommercialBreakVideoPlugin extends StubbableRichVideoPlayerPlugin {
    public View f4632b;
    public ProgressBar f4633c;
    public FbTextView f4634d;
    @Nullable
    public CommercialBreakCountdownTimer f4635l;

    /* compiled from: plan_user_invited */
    class CommercialBreakStateChangeEventSubscriber extends RichVideoPlayerEventSubscriber<RVPCommercialBreakStateChangeEvent> {
        final /* synthetic */ CommercialBreakVideoPlugin f4636a;

        public CommercialBreakStateChangeEventSubscriber(CommercialBreakVideoPlugin commercialBreakVideoPlugin) {
            this.f4636a = commercialBreakVideoPlugin;
        }

        public final void m5122b(FbEvent fbEvent) {
            RVPCommercialBreakStateChangeEvent rVPCommercialBreakStateChangeEvent = (RVPCommercialBreakStateChangeEvent) fbEvent;
            StubbableRichVideoPlayerPlugin stubbableRichVideoPlayerPlugin;
            switch (1.a[rVPCommercialBreakStateChangeEvent.a.ordinal()]) {
                case 1:
                    stubbableRichVideoPlayerPlugin = this.f4636a;
                    if (stubbableRichVideoPlayerPlugin.m14963d()) {
                        stubbableRichVideoPlayerPlugin.f4632b.setVisibility(8);
                        if (stubbableRichVideoPlayerPlugin.f4635l != null) {
                            stubbableRichVideoPlayerPlugin.f4635l.cancel();
                        }
                    }
                    return;
                case 5:
                    stubbableRichVideoPlayerPlugin = this.f4636a;
                    long j = rVPCommercialBreakStateChangeEvent.c.a;
                    if (stubbableRichVideoPlayerPlugin.m14963d()) {
                        stubbableRichVideoPlayerPlugin.f4633c.setMax((int) j);
                        stubbableRichVideoPlayerPlugin.f4632b.setVisibility(0);
                        stubbableRichVideoPlayerPlugin.f4635l = new CommercialBreakCountdownTimer(stubbableRichVideoPlayerPlugin, j);
                        stubbableRichVideoPlayerPlugin.f4635l.start();
                    }
                    return;
                default:
                    return;
            }
        }

        public final Class<RVPCommercialBreakStateChangeEvent> m5121a() {
            return RVPCommercialBreakStateChangeEvent.class;
        }
    }

    @DoNotStrip
    public CommercialBreakVideoPlugin(Context context) {
        this(context, null);
    }

    private CommercialBreakVideoPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private CommercialBreakVideoPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14094f.add(new CommercialBreakStateChangeEventSubscriber(this));
    }

    protected final void mo378c() {
        if (this.f4635l != null) {
            this.f4635l.cancel();
            this.f4635l = null;
        }
    }

    protected final boolean mo377a(RichVideoPlayerParams richVideoPlayerParams) {
        return true;
    }

    protected int getStubLayout() {
        return 2130903649;
    }

    protected int getLayoutToInflate() {
        return 2130903647;
    }

    protected void setupPlugin(RichVideoPlayerParams richVideoPlayerParams) {
    }

    protected void setupViews(View view) {
        this.f4632b = view.findViewById(2131559223);
        this.f4633c = (ProgressBar) view.findViewById(2131559418);
        this.f4634d = (FbTextView) view.findViewById(2131560482);
    }
}
