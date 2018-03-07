package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoResolution;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.environment.AnyPlayerEnvironment;
import com.facebook.video.player.events.RVPRequestSetResolutionEvent;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.List;

/* compiled from: composer_attach_movie_cancel */
public abstract class SeekBarBaseHDPlugin<E extends AnyPlayerEnvironment> extends SeekBarBasePlugin<E> {
    private final View f19345l;
    private final boolean f19346m;
    public final FbTextView f19347n;
    public final int f19348o;
    public final int f19349p;
    public boolean f19350q;

    /* compiled from: composer_attach_movie_cancel */
    final class ResolutionToggleClickListener implements OnClickListener {
        final /* synthetic */ SeekBarBaseHDPlugin f19371a;

        public ResolutionToggleClickListener(SeekBarBaseHDPlugin seekBarBaseHDPlugin) {
            this.f19371a = seekBarBaseHDPlugin;
        }

        public final void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 958529795);
            Preconditions.checkNotNull(this.f19371a.h);
            this.f19371a.g.a(new RVPRequestSetResolutionEvent(EventTriggerType.BY_USER, this.f19371a.f19350q ? VideoResolution.STANDARD_DEFINITION : VideoResolution.HIGH_DEFINITION));
            boolean z = this.f19371a.h.e() == VideoResolution.HIGH_DEFINITION;
            if (this.f19371a.f19350q != z) {
                if (!(this.f19371a.f19333a.e == null || this.f19371a.f19333a.b == null)) {
                    if (z) {
                        this.f19371a.f19335d.a(this.f19371a.f19333a.b, this.f19371a.f19333a.e, this.f19371a.h.f(), this.f19371a.f19333a.f);
                    } else {
                        this.f19371a.f19335d.b(this.f19371a.f19333a.b, this.f19371a.f19333a.e, this.f19371a.h.f(), this.f19371a.f19333a.f);
                    }
                }
                this.f19371a.f19350q = z;
                this.f19371a.f19347n.setTextColor(this.f19371a.f19350q ? this.f19371a.f19348o : this.f19371a.f19349p);
            }
            LogUtils.a(-958168112, a);
        }
    }

    public SeekBarBaseHDPlugin(Context context) {
        this(context, null);
    }

    public SeekBarBaseHDPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SeekBarBaseHDPlugin(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        super(context, attributeSet, i);
        this.f19350q = false;
        this.f19345l = a(2131559223);
        this.f19347n = (FbTextView) a(2131561905);
        if (getResources().getDisplayMetrics().densityDpi >= 240) {
            z = true;
        } else {
            z = false;
        }
        this.f19346m = z;
        this.f19348o = getResources().getColor(2131361867);
        this.f19349p = getResources().getColor(2131362630);
    }

    protected void mo1488a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        super.mo1488a(richVideoPlayerParams, z);
        if (z) {
            setupHdToggle(richVideoPlayerParams.a.a);
            setSeekBarVisibility(0);
        }
    }

    protected void mo1489c() {
        super.mo1489c();
        this.f19347n.setVisibility(0);
        this.f19347n.setOnClickListener(null);
    }

    protected int getActiveThumbResource() {
        return 0;
    }

    protected void setSeekBarVisibility(int i) {
        this.f19345l.setVisibility(i);
    }

    private void setupHdToggle(List<VideoDataSource> list) {
        if (m28119a((List) list)) {
            this.f19347n.setOnClickListener(new ResolutionToggleClickListener(this));
            m28120p();
            return;
        }
        this.f19347n.setVisibility(8);
    }

    private void m28120p() {
        this.f19350q = this.h.e() == VideoResolution.HIGH_DEFINITION;
        this.f19347n.setTextColor(this.f19350q ? this.f19348o : this.f19349p);
    }

    @VisibleForTesting
    private boolean m28119a(List<VideoDataSource> list) {
        if (this.f19346m) {
            Object obj = null;
            for (int i = 0; i < list.size(); i++) {
                if (((VideoDataSource) list.get(i)).c != null) {
                    obj = 1;
                    break;
                }
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    protected final void mo1487a(VideoResolution videoResolution) {
        m28120p();
    }
}
