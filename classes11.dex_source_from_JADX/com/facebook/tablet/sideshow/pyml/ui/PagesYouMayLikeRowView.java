package com.facebook.tablet.sideshow.pyml.ui;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.glyph.GlyphButton;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tablet.sideshow.pyml.events.SideshowPageLikeEvents.PageLikeClickedEvent;
import com.facebook.tablet.sideshow.pyml.model.PagesYouMayLikeRow;
import com.facebook.widget.text.BetterTextView;

/* compiled from: on body */
public class PagesYouMayLikeRowView extends ContentView {
    private PagesYouMayLikeRow f4853h;
    public GlyphButton f4854i;
    public BetterTextView f4855j;
    public FeedEventBus f4856k;

    /* compiled from: on body */
    public class C06561 implements OnClickListener {
        final /* synthetic */ PagesYouMayLikeRowView f4852a;

        public C06561(PagesYouMayLikeRowView pagesYouMayLikeRowView) {
            this.f4852a = pagesYouMayLikeRowView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1023457785);
            this.f4852a.m6062f();
            Logger.a(2, EntryType.UI_INPUT_END, 1274434582, a);
        }
    }

    public PagesYouMayLikeRowView(Context context) {
        super(context);
        setContentView(2130907401);
        setMaxLinesFromThumbnailSize(false);
        if (getBackground() == null) {
            setBackgroundResource(2130839797);
        }
        this.f4854i = (GlyphButton) findViewById(2131567862);
        this.f4854i.setOnClickListener(new C06561(this));
        this.f4855j = (BetterTextView) findViewById(2131567861);
        this.f4854i.setImageResource(2130839953);
        setShowAuxView(true);
    }

    public final void m6061a(PagesYouMayLikeRow pagesYouMayLikeRow) {
        this.f4853h = pagesYouMayLikeRow;
        m6060h();
    }

    private void m6060h() {
        if (this.f4853h.f4845e != null) {
            setThumbnailUri(Uri.parse(this.f4853h.f4845e));
        }
        setTitleText(this.f4853h.f4842b);
        setSubtitleText(this.f4853h.f4844d);
        setPageLiked(this.f4853h.f4846f);
    }

    private void setPageLiked(boolean z) {
        if (z) {
            this.f4854i.setSelected(true);
            setMetaText(getResources().getString(2131241717));
            this.f4855j.setTextColor(getResources().getColor(2131361917));
            return;
        }
        this.f4854i.setSelected(false);
        int i = this.f4853h.f4847g;
        setMetaText(getResources().getQuantityString(2131689803, i, new Object[]{Integer.valueOf(i)}));
        this.f4855j.setTextColor(getResources().getColor(2131361937));
    }

    public final void m6062f() {
        setPageLiked(!this.f4854i.isSelected());
        if (this.f4856k != null) {
            this.f4856k.a(new PageLikeClickedEvent(this.f4853h.f4841a, this.f4853h.f4846f, "sideshow"));
        }
    }
}
