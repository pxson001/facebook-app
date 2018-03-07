package com.facebook.attachments.angora;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.attachments.angora.actionbutton.GenericActionButtonView;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: feed_delete_story */
public abstract class GenericAttachmentView extends CustomLinearLayout implements AngoraAttachment {
    private static final String f11894a = GenericAttachmentView.class.getSimpleName();
    private final FbDraweeView f11895b = ((FbDraweeView) a(2131559570));
    private final TextView f11896c = ((TextView) a(2131559571));
    @Inject
    public AnalyticsTagger f11897d;
    private final TextView f11898e = ((TextView) a(2131559572));
    public final GenericActionButtonView f11899f = ((GenericActionButtonView) a(2131559573));
    private final ImageBlockLayout f11900g = ((ImageBlockLayout) a(2131559575));

    public static void m12498a(Object obj, Context context) {
        ((GenericAttachmentView) obj).f11897d = AnalyticsTagger.a(FbInjector.get(context));
    }

    public GenericAttachmentView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        setContentView(i2);
        setOrientation(1);
        Class cls = GenericAttachmentView.class;
        m12498a((Object) this, getContext());
        this.f11897d.a(this, "newsfeed_angora_attachment_view", getClass());
        TrackingNodes.a(this, TrackingNode.ATTACHMENT);
        TrackingNodes.a(this.f11896c, TrackingNode.TITLE);
        TrackingNodes.a(this.f11898e, TrackingNode.SOCIAL_CONTEXT);
    }

    public void setSideImageController(@Nullable DraweeController draweeController) {
        FbDraweeView fbDraweeView = this.f11895b;
        fbDraweeView.setVisibility(draweeController != null ? 0 : 8);
        fbDraweeView.setController(draweeController);
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        m12497a(this.f11896c, charSequence);
    }

    public void setContextText(@Nullable CharSequence charSequence) {
        m12497a(this.f11898e, charSequence);
    }

    public void setActionButtonOnClickListener(OnClickListener onClickListener) {
        this.f11899f.setOnClickListener(onClickListener);
    }

    public GenericActionButtonView getActionButton() {
        return this.f11899f;
    }

    public void mo341a() {
        this.f11899f.m14490a();
    }

    public static void m12497a(TextView textView, @Nullable CharSequence charSequence) {
        textView.setVisibility(!TextUtils.isEmpty(charSequence) ? 0 : 8);
        textView.setText(charSequence);
    }
}
