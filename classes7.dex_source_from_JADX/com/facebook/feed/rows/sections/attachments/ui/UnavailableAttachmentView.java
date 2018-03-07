package com.facebook.feed.rows.sections.attachments.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.facebook.attachments.angora.AttachmentHasClear;
import com.facebook.attachments.angora.AttachmentHasLabel;
import com.facebook.multirow.api.ViewType;
import com.facebook.resources.ui.EllipsizingTextView;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: Upsell API Success */
public class UnavailableAttachmentView extends CustomLinearLayout implements AttachmentHasClear, AttachmentHasLabel {
    public static final ViewType f21108a = new C17911();
    private final TextView f21109b = ((TextView) a(2131559571));
    private final EllipsizingTextView f21110c = ((EllipsizingTextView) a(2131559572));

    /* compiled from: Upsell API Success */
    final class C17911 extends ViewType {
        C17911() {
        }

        public final View m23978a(Context context) {
            return new UnavailableAttachmentView(context);
        }
    }

    public UnavailableAttachmentView(Context context) {
        super(context);
        setContentView(2130907600);
        setOrientation(1);
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        m23979a(this.f21109b, charSequence);
    }

    public void setContextText(@Nullable CharSequence charSequence) {
        m23979a(this.f21110c, charSequence);
    }

    private static void m23979a(TextView textView, @Nullable CharSequence charSequence) {
        textView.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
        textView.setText(charSequence);
    }

    public final void m23980a() {
    }
}
