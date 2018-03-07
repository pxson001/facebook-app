package com.facebook.messaging.montage.inboxcomposer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.v4.content.ContextCompat;
import android.support.v7.internal.widget.ViewStubCompat;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.util.ContextUtils;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.montage.MontageTileView;
import com.facebook.orca.threadlist.ThreadListAdapter.C09919;
import com.facebook.orca.threadlist.ThreadListFragment;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.ViewStubHolder;
import com.google.common.base.Preconditions;

/* compiled from: save_location */
public class MontageComposerHeaderView extends CustomRelativeLayout {
    public static final String f3285a = MontageComposerHeaderView.class.getSimpleName();
    public GlyphView f3286b;
    public ViewStubHolder<MontageTileView> f3287c;
    public MontageInboxComposerSeenHeadsView f3288d;
    public FbTextView f3289e;
    public FbTextView f3290f;
    public Paint f3291g = new Paint(5);
    public C09919 f3292h;
    public OnClickListener f3293i;

    /* compiled from: save_location */
    public class C05281 implements OnClickListener {
        final /* synthetic */ MontageComposerHeaderView f3283a;

        public C05281(MontageComposerHeaderView montageComposerHeaderView) {
            this.f3283a = montageComposerHeaderView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1353215707);
            if (this.f3283a.f3292h != null) {
                C09919 c09919 = this.f3283a.f3292h;
                if (c09919.f6563a.f6573j != null) {
                    ThreadListFragment.aT(c09919.f6563a.f6573j.f6606a);
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, -437170628, a);
        }
    }

    /* compiled from: save_location */
    public class C05292 implements OnClickListener {
        final /* synthetic */ MontageComposerHeaderView f3284a;

        public C05292(MontageComposerHeaderView montageComposerHeaderView) {
            this.f3284a = montageComposerHeaderView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1580550500);
            ThreadKey threadKey = (ThreadKey) Preconditions.checkNotNull(view.getTag());
            if (this.f3284a.f3292h != null) {
                C09919 c09919 = this.f3284a.f3292h;
                if (c09919.f6563a.f6573j != null) {
                    c09919.f6563a.f6573j.m6288a(threadKey);
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1675235335, a);
        }
    }

    public MontageComposerHeaderView(Context context) {
        super(context, null, 2130773031);
        setWillNotDraw(false);
        setContentView(2130905334);
        setMinimumHeight(ContextUtils.e(context, 2130773035, 0));
        this.f3291g.setColor(ContextCompat.b(context, 2131362321));
        this.f3291g.setStyle(Style.STROKE);
        this.f3291g.setStrokeWidth((float) getResources().getDimensionPixelSize(2131427382));
        this.f3286b = (GlyphView) a(2131558415);
        this.f3287c = ViewStubHolder.a((ViewStubCompat) a(2131563978));
        this.f3288d = (MontageInboxComposerSeenHeadsView) a(2131563977);
        this.f3289e = (FbTextView) a(2131559636);
        this.f3290f = (FbTextView) a(2131562884);
        this.f3286b.setOnClickListener(new C05281(this));
        this.f3289e.setText("Montage");
        this.f3290f.setText("What's up?");
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float height = ((float) canvas.getHeight()) - this.f3291g.getStrokeWidth();
        canvas.drawLine(0.0f, height, (float) canvas.getWidth(), height, this.f3291g);
    }
}
