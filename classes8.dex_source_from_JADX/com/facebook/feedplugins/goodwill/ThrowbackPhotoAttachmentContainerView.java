package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.attachments.photos.ui.PhotoAttachmentContainerView;
import com.facebook.common.util.SizeUtil;
import com.facebook.multirow.api.ViewType;

/* compiled from: goodwill_campaign_post_submitted */
public class ThrowbackPhotoAttachmentContainerView extends PhotoAttachmentContainerView {
    public static final ViewType f12449b = new C13081();
    public TextView f12450c;
    public LinearLayout f12451d = new LinearLayout(getContext());

    /* compiled from: goodwill_campaign_post_submitted */
    final class C13081 extends ViewType {
        C13081() {
        }

        public final View m14346a(Context context) {
            return new ThrowbackPhotoAttachmentContainerView(context);
        }
    }

    public ThrowbackPhotoAttachmentContainerView(Context context) {
        super(context);
        View photoAttachmentView = getPhotoAttachmentView();
        photoAttachmentView.setBackgroundResource(0);
        photoAttachmentView.setPadding(0, 0, 0, 0);
        this.f12451d.setBackgroundResource(2130843606);
        photoAttachmentView = new ImageView(getContext());
        photoAttachmentView.setPadding(getResources().getDimensionPixelSize(2131432765), getResources().getDimensionPixelSize(2131432770), 0, getResources().getDimensionPixelSize(2131432770));
        photoAttachmentView.setImageResource(2130843600);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        this.f12451d.addView(photoAttachmentView, layoutParams);
        this.f12450c = new TextView(getContext());
        this.f12450c.setTextSize((float) SizeUtil.c(getResources(), 2131427400));
        this.f12450c.setPadding(getResources().getDimensionPixelSize(2131432765), getResources().getDimensionPixelSize(2131432765), getResources().getDimensionPixelSize(2131432771), getResources().getDimensionPixelSize(2131432765));
        this.f12450c.setTextColor(getResources().getColor(2131361920));
        this.f12450c.setGravity(16);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.weight = 1.0f;
        layoutParams2.gravity = 16;
        this.f12451d.addView(this.f12450c, layoutParams2);
        layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(6, 2131565875);
        layoutParams2.addRule(7, 2131565875);
        layoutParams2.setMargins(0, getResources().getDimensionPixelSize(2131432766), getResources().getDimensionPixelSize(2131432766), 0);
        addView(this.f12451d, layoutParams2);
    }
}
