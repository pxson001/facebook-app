package com.facebook.video.player;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: composer_friend_tag_remove */
public class VideoCallToActionEndScreenOnInlinePlayer extends CustomRelativeLayout {
    private static final CallerContext f19213a = CallerContext.a(VideoCallToActionEndScreenOnInlinePlayer.class, "video_cover");
    private View f19214b;
    public View f19215c;
    private TextView f19216d;
    private TextView f19217e;
    private FbDraweeView f19218f;
    private TextView f19219g;
    private ImageView f19220h;

    public VideoCallToActionEndScreenOnInlinePlayer(Context context) {
        this(context, null, 0);
    }

    public VideoCallToActionEndScreenOnInlinePlayer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoCallToActionEndScreenOnInlinePlayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setContentView(2130907670);
        this.f19214b = a(2131568327);
        this.f19215c = a(2131568330);
        this.f19216d = (TextView) a(2131568332);
        this.f19217e = (TextView) a(2131568333);
        this.f19218f = (FbDraweeView) a(2131568331);
        this.f19219g = (TextView) a(2131568329);
        this.f19220h = (ImageView) a(2131568328);
        m28010c();
        this.f19216d.setBackgroundResource(0);
        this.f19216d.setPadding(0, 0, 0, 0);
        TrackingNodes.a(this.f19215c, TrackingNode.GENERIC_CALL_TO_ACTION_BUTTON);
    }

    protected final void m28012a(int i, String str) {
        this.f19215c.setTag(i, str);
    }

    protected void setVideoReplayListener(@Nullable OnClickListener onClickListener) {
        this.f19214b.setOnClickListener(onClickListener);
    }

    protected final View m28011a() {
        return this.f19215c;
    }

    protected void setCallToActionIcon(String str) {
        if (Strings.isNullOrEmpty(str)) {
            this.f19218f.a(null, f19213a);
        } else {
            this.f19218f.a(Uri.parse(str), f19213a);
        }
    }

    protected final void m28013a(String str, String str2, String str3) {
        this.f19216d.setText(str);
        this.f19217e.setText(m28007a(str2));
        setCallToActionIcon(str3);
    }

    protected final void m28014b() {
        setBackgroundResource(2131362635);
    }

    private void m28010c() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131428308);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(2131428311);
        setReplayLabelTextSize(dimensionPixelSize);
        setCTATitleTextSize(dimensionPixelSize);
        setCTASourceTextSize(getResources().getDimensionPixelSize(2131428309));
        m28008a(dimensionPixelSize2, dimensionPixelSize2);
        m28009b(dimensionPixelSize2, dimensionPixelSize2);
        setCTAContainerTopMargin(getResources().getDimensionPixelSize(2131428307));
        setCTASourceTextTopMargin(getResources().getDimensionPixelSize(2131428310));
    }

    private void m28008a(int i, int i2) {
        this.f19220h.getLayoutParams().height = i;
        this.f19220h.getLayoutParams().width = i2;
    }

    private void m28009b(int i, int i2) {
        this.f19218f.getLayoutParams().height = i;
        this.f19218f.getLayoutParams().width = i2;
    }

    private void setCTAContainerTopMargin(int i) {
        LayoutParams layoutParams = (LayoutParams) this.f19215c.getLayoutParams();
        layoutParams.setMargins(0, i, 0, 0);
        this.f19215c.setLayoutParams(layoutParams);
    }

    private void setReplayLabelTextSize(int i) {
        this.f19219g.setTextSize(0, (float) i);
    }

    private void setCTATitleTextSize(int i) {
        this.f19216d.setTextSize(0, (float) i);
    }

    private void setCTASourceTextSize(int i) {
        this.f19217e.setTextSize(0, (float) i);
    }

    private void setCTASourceTextTopMargin(int i) {
        LayoutParams layoutParams = (LayoutParams) this.f19217e.getLayoutParams();
        layoutParams.setMargins(0, i, 0, 0);
        this.f19217e.setLayoutParams(layoutParams);
    }

    private String m28007a(String str) {
        if (Strings.isNullOrEmpty(str) || str.length() <= 25) {
            return str;
        }
        return str.substring(0, 25).trim() + getResources().getString(2131230738);
    }
}
