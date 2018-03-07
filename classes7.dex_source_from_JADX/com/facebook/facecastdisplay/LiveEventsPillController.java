package com.facebook.facecastdisplay;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.facebook.facecastdisplay.LiveEventModel.LiveEventType;
import com.facebook.feedback.ui.AbstractPillController;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;
import com.facebook.widget.LazyView;
import com.facebook.widget.LazyView.OnInflateRunner;
import javax.inject.Inject;

/* compiled from: story_ids */
public class LiveEventsPillController extends AbstractPillController {
    private final LazyView<LiveEventsPill> f2963a;

    /* compiled from: story_ids */
    public interface LiveEventsPillControllerListener {
        void mo142a();
    }

    @Inject
    public LiveEventsPillController(@Assisted ViewStub viewStub, @Assisted final LiveEventsPillControllerListener liveEventsPillControllerListener, SpringSystem springSystem, ViewHelperViewAnimatorFactory viewHelperViewAnimatorFactory) {
        super(springSystem, viewHelperViewAnimatorFactory);
        this.f2963a = new LazyView(viewStub, new OnInflateRunner<LiveEventsPill>(this) {
            final /* synthetic */ LiveEventsPillController f2954b;

            /* compiled from: story_ids */
            class C02661 implements OnClickListener {
                final /* synthetic */ C02671 f2952a;

                C02661(C02671 c02671) {
                    this.f2952a = c02671;
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1865461409);
                    liveEventsPillControllerListener.mo142a();
                    Logger.a(2, EntryType.UI_INPUT_END, 623668942, a);
                }
            }

            public final void m3230a(View view) {
                ((LiveEventsPill) view).setOnClickListener(new C02661(this));
            }
        });
    }

    public final void m3244a(LiveEventModel liveEventModel) {
        if (liveEventModel.mo118a() == LiveEventType.LIVE_COMMENT_EVENT) {
            ((LiveEventsPill) this.f2963a.a()).setPillText("\"" + ((LiveCommentEventModel) liveEventModel).f2849a);
            mo230a();
        }
    }

    public final void mo131h() {
        m3238b();
    }

    protected final LazyView<LiveEventsPill> mo130g() {
        return this.f2963a;
    }
}
