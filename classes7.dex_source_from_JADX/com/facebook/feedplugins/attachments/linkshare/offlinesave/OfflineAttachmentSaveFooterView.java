package com.facebook.feedplugins.attachments.linkshare.offlinesave;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import com.facebook.multirow.api.ViewType;
import com.facebook.resources.ui.FbButton;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: TINCAN */
public class OfflineAttachmentSaveFooterView extends CustomLinearLayout {
    public static final ViewType f22620a = new C19711();
    public ViewStub f22621b = ((ViewStub) a(2131564379));
    public LinearLayout f22622c;
    public FbButton f22623d;
    private OnClickListener f22624e;

    /* compiled from: TINCAN */
    final class C19711 extends ViewType {
        C19711() {
        }

        public final View m25284a(Context context) {
            return new OfflineAttachmentSaveFooterView(context);
        }
    }

    public OfflineAttachmentSaveFooterView(Context context) {
        super(context);
        setContentView(2130905533);
    }

    public final void m25286a() {
        if (this.f22622c == null) {
            this.f22622c = (LinearLayout) this.f22621b.inflate();
            this.f22623d = (FbButton) a(2131564380);
            m25285b();
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f22624e = onClickListener;
        m25285b();
    }

    private void m25285b() {
        if (this.f22622c != null) {
            this.f22622c.setOnClickListener(this.f22624e);
        }
        if (this.f22623d != null) {
            this.f22623d.setOnClickListener(this.f22624e);
        }
    }
}
