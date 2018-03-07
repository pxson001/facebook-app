package com.facebook.pages.identity.cards.photos;

import android.content.Context;
import android.widget.LinearLayout;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.RecyclableView;

/* compiled from: notif_option_sets */
public class PageIdentityPhotoGalleryItemView extends CustomRelativeLayout implements RecyclableView {
    public FbDraweeView f6902a;
    public LinearLayout f6903b;
    public FbTextView f6904c;
    public FbTextView f6905d;
    public FbDraweeView f6906e;
    public boolean f6907f = false;

    public PageIdentityPhotoGalleryItemView(Context context) {
        super(context);
        setContentView(2130906027);
        setBackgroundResource(2130840254);
        this.f6902a = (FbDraweeView) m14861a(2131565512);
        ((GenericDraweeHierarchy) this.f6902a.getHierarchy()).b(2131362786);
        this.f6903b = (LinearLayout) m14861a(2131565513);
        this.f6904c = (FbTextView) m14861a(2131565514);
        this.f6905d = (FbTextView) m14861a(2131565515);
        this.f6906e = (FbDraweeView) m14861a(2131565516);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1787767344);
        super.onAttachedToWindow();
        this.f6907f = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 458471919, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 559647033);
        super.onDetachedFromWindow();
        this.f6907f = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -61759337, a);
    }

    public final boolean mo569a() {
        return this.f6907f;
    }
}
