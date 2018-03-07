package com.facebook.goodwill.feed.rows;

import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.attachments.photos.ui.PhotoAttachmentView;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import javax.inject.Inject;

/* compiled from: fb4a_draft_dialog_save_clicked */
public class ThrowbackPhotoAttachmentItemView extends PagerItemWrapperLayout implements RecyclableView {
    @Inject
    public GlyphColorizer f13745a;
    public boolean f13746b;
    private PhotoAttachmentView f13747c;
    private ImageWithTextView f13748d;

    public static void m15421a(Object obj, Context context) {
        ((ThrowbackPhotoAttachmentItemView) obj).f13745a = GlyphColorizer.a(FbInjector.get(context));
    }

    public ThrowbackPhotoAttachmentItemView(Context context) {
        this(context, 2130907416);
    }

    private ThrowbackPhotoAttachmentItemView(Context context, int i) {
        super(context);
        Class cls = ThrowbackPhotoAttachmentItemView.class;
        m15421a(this, getContext());
        setContentView(i);
        this.f13747c = (PhotoAttachmentView) c(2131567888);
        this.f13748d = (ImageWithTextView) c(2131562068);
        this.f13748d.setImageDrawable(this.f13745a.a(2130840097, -7235677));
    }

    public void setShareOnClickListener(OnClickListener onClickListener) {
        this.f13748d.setOnClickListener(onClickListener);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 951376008);
        super.onAttachedToWindow();
        this.f13746b = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -787107721, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1489246875);
        super.onDetachedFromWindow();
        this.f13746b = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -896840006, a);
    }

    public final boolean m15422a() {
        return this.f13746b;
    }

    public ImageView getPhotoView() {
        return this.f13747c;
    }
}
