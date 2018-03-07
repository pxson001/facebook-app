package com.facebook.messaging.composer.triggers;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: messenger_inbox_item_logging_data */
public class MentionsSearchResultItemView extends CustomLinearLayout {
    private static final CallerContext f9903a = CallerContext.a(MentionsSearchResultItemView.class);
    public FbDraweeView f9904b = ((FbDraweeView) a(2131563805));
    public FbTextView f9905c = ((FbTextView) a(2131563806));
    public FbTextView f9906d = ((FbTextView) a(2131563807));

    public MentionsSearchResultItemView(Context context) {
        super(context);
        setOrientation(0);
        setMinimumHeight(getResources().getDimensionPixelSize(2131433766));
        setBackgroundResource(2130842164);
        setContentView(2130905216);
    }

    public void setTitle(String str) {
        this.f9905c.setText(str);
    }

    public void setSubtitle(@Nullable String str) {
        if (str == null) {
            this.f9906d.setVisibility(8);
            return;
        }
        this.f9906d.setText(str);
        this.f9906d.setVisibility(0);
    }

    public void setImage(@Nullable String str) {
        m10461a(str, false);
    }

    public final void m10461a(String str, boolean z) {
        if (str == null) {
            this.f9904b.setVisibility(8);
            return;
        }
        ((GenericDraweeHierarchy) this.f9904b.getHierarchy()).c.b = z;
        this.f9904b.a(Uri.parse(str), f9903a);
        this.f9904b.setVisibility(0);
    }
}
