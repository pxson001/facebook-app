package com.facebook.orca.threadview;

import android.content.Context;
import android.content.res.Resources;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.attachments.OtherAttachmentData;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.CustomUrlLikeSpan;

/* compiled from: media_tray */
public class ThreadViewOtherAttachmentView extends CustomFrameLayout {
    public Resources f7954a;
    private final ImageView f7955b;
    private final TextView f7956c;
    private OtherAttachmentData f7957d;
    private boolean f7958e;

    public static void m7892a(Object obj, Context context) {
        ((ThreadViewOtherAttachmentView) obj).f7954a = ResourcesMethodAutoProvider.a(FbInjector.get(context));
    }

    public ThreadViewOtherAttachmentView(Context context) {
        this(context, null);
    }

    private ThreadViewOtherAttachmentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private ThreadViewOtherAttachmentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = ThreadViewOtherAttachmentView.class;
        m7892a(this, getContext());
        setContentView(2130905893);
        this.f7955b = (ImageView) c(2131565213);
        this.f7956c = (TextView) c(2131565234);
    }

    public void setAttachmentInfo(OtherAttachmentData otherAttachmentData) {
        this.f7957d = otherAttachmentData;
        m7891a();
    }

    public void setShowForMeUser(boolean z) {
        this.f7958e = z;
        m7891a();
    }

    private void m7891a() {
        if (this.f7957d == null) {
            this.f7955b.setImageDrawable(null);
            this.f7956c.setText("");
            return;
        }
        CharSequence b = new StyledStringBuilder(this.f7954a).a("%s").a("%s", this.f7957d.a, new CustomUrlLikeSpan(), 33).b();
        b.setSpan(new ForegroundColorSpan(this.f7954a.getColor(this.f7958e ? 2131362308 : 2131361848)), 0, b.length(), 17);
        this.f7956c.setText(b);
    }
}
