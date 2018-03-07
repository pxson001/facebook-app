package com.facebook.orca.compose;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.orca.compose.TwoLineComposerView.AnonymousClass16;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.widget.OverlayLayout;
import com.facebook.widget.OverlayLayout.LayoutParams;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.inject.Inject;

/* compiled from: open_group_info */
public class NuxBubbleController {
    private final LayoutInflater f5557a;
    private final ExecutorService f5558b;
    private final SpringSystem f5559c;
    private final int f5560d;
    public final OverlayLayout f5561e;
    public View f5562f;
    private Spring f5563g;
    public AnonymousClass16 f5564h;
    public Future<?> f5565i;

    /* compiled from: open_group_info */
    class C07891 implements OnClickListener {
        final /* synthetic */ NuxBubbleController f5553a;

        C07891(NuxBubbleController nuxBubbleController) {
            this.f5553a = nuxBubbleController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 387655626);
            this.f5553a.m5153b();
            Logger.a(2, EntryType.UI_INPUT_END, -1427651704, a);
        }
    }

    /* compiled from: open_group_info */
    class C07902 implements Callable<Object> {
        final /* synthetic */ NuxBubbleController f5554a;

        C07902(NuxBubbleController nuxBubbleController) {
            this.f5554a = nuxBubbleController;
        }

        public Object call() {
            this.f5554a.f5561e.removeView(this.f5554a.f5562f);
            this.f5554a.f5565i = null;
            return null;
        }
    }

    /* compiled from: open_group_info */
    class NuxBubbleSpringListener extends SimpleSpringListener {
        final /* synthetic */ NuxBubbleController f5555a;
        private boolean f5556b;

        public NuxBubbleSpringListener(NuxBubbleController nuxBubbleController) {
            this.f5555a = nuxBubbleController;
        }

        public final void m5150a(Spring spring) {
            float f;
            int width;
            float d = (float) spring.d();
            float max = Math.max(0.0f, Math.min(d, 1.0f));
            int height = this.f5555a.f5562f.getHeight();
            if (this.f5556b && spring.i == 1.0d) {
                f = 1.0f;
            } else {
                f = max * max;
                boolean z = this.f5556b;
                this.f5556b = d >= 1.0f;
                if (!(z || !this.f5556b || this.f5555a.f5564h == null)) {
                    this.f5555a.f5564h.m5204a();
                }
            }
            float f2 = 0.9f + (0.1f * d);
            LayoutParams layoutParams = (LayoutParams) this.f5555a.f5562f.getLayoutParams();
            int i = -layoutParams.e;
            if ((layoutParams.d & 4) != 0) {
                width = this.f5555a.f5562f.getWidth() + i;
            } else {
                width = i;
            }
            this.f5555a.f5562f.setAlpha(f);
            this.f5555a.f5562f.setPivotX((float) width);
            this.f5555a.f5562f.setPivotY((float) height);
            this.f5555a.f5562f.setScaleX(f2);
            this.f5555a.f5562f.setScaleY(f2);
            this.f5555a.f5562f.setTranslationY(((1.0f - d) * ((float) height)) * 0.3f);
        }

        public final void m5151b(Spring spring) {
            if (this.f5555a.f5564h != null && spring.i == 1.0d) {
                this.f5555a.f5564h.m5206b();
            }
        }
    }

    @Inject
    public NuxBubbleController(LayoutInflater layoutInflater, ExecutorService executorService, SpringSystem springSystem, @Assisted OverlayLayout overlayLayout, @Assisted Integer num) {
        this.f5557a = layoutInflater;
        this.f5558b = executorService;
        this.f5559c = springSystem;
        this.f5561e = overlayLayout;
        this.f5560d = num.intValue();
    }

    public final void m5152a() {
        if (this.f5565i != null) {
            this.f5565i.cancel(false);
            this.f5565i = null;
        }
        if (this.f5562f == null) {
            this.f5562f = this.f5557a.inflate(this.f5560d, this.f5561e, false);
            if (this.f5564h != null) {
                this.f5564h.m5205a(this.f5562f);
            }
            this.f5562f.setOnClickListener(new C07891(this));
        }
        if (this.f5562f.getParent() == null) {
            this.f5561e.addView(this.f5562f);
        }
        if (this.f5563g == null) {
            this.f5563g = this.f5559c.a().a(SpringConfig.a(5.0d, 4.0d)).a(new NuxBubbleSpringListener(this));
        }
        this.f5563g.b(1.0d);
    }

    public final void m5153b() {
        if (this.f5563g != null) {
            this.f5563g.a();
            this.f5563g = null;
        }
        if (this.f5562f != null && this.f5562f.getParent() != null && this.f5565i == null) {
            this.f5565i = ExecutorDetour.a(this.f5558b, new C07902(this), 685384253);
        }
    }
}
