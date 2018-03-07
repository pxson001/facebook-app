package com.facebook.messaging.business.attachments.views;

import android.content.Context;
import android.support.v7.internal.widget.ViewStubCompat;
import android.util.AttributeSet;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachment;
import com.facebook.messaging.business.common.calltoaction.CallToActionContainerView;
import com.facebook.messaging.xma.ui.XMARelativeLayout;
import com.facebook.orca.threadview.MessageXMACallbackHelper.1;
import com.facebook.widget.ViewStubHolder;
import javax.annotation.Nullable;

/* compiled from: object_address_type */
public class PlatformGenericAttachmentView extends XMARelativeLayout {
    @Nullable
    private PlatformGenericAttachment f8362b;
    private final ViewStubHolder<CallToActionContainerView> f8363c;
    public final ViewStubHolder<PlatformGenericAttachmentItemView> f8364d;

    public PlatformGenericAttachmentView(Context context) {
        this(context, null);
    }

    private PlatformGenericAttachmentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private PlatformGenericAttachmentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905609);
        this.f8363c = ViewStubHolder.a((ViewStubCompat) a(2131564593));
        this.f8364d = ViewStubHolder.a((ViewStubCompat) a(2131564594));
    }

    public void setModel(@Nullable PlatformGenericAttachment platformGenericAttachment) {
        this.f8362b = platformGenericAttachment;
        this.f8363c.e();
        this.f8364d.e();
        if (this.f8362b == null) {
            return;
        }
        if (this.f8362b.e != null) {
            this.f8364d.f();
            ((PlatformGenericAttachmentItemView) this.f8364d.a()).m8646a(this.f8362b.e, this.f8362b.d, this.f8362b.c);
        } else if (!this.f8362b.d.isEmpty()) {
            this.f8363c.f();
            ((CallToActionContainerView) this.f8363c.a()).m8932a(this.f8362b.d, null, this.f8362b.a);
        }
    }

    public final void m8648a(@Nullable 1 1) {
        if (this.f8364d.d()) {
            ((PlatformGenericAttachmentItemView) this.f8364d.a()).setXMACallback(1);
        } else if (this.f8363c.d()) {
            ((CallToActionContainerView) this.f8363c.a()).setXMACallback(1);
        }
    }
}
