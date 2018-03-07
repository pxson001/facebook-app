package com.facebook.orca.threadview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.attachments.AttachmentDataFactory;
import com.facebook.messaging.attachments.OtherAttachmentData;
import com.facebook.messaging.attachments.OtherAttachmentDataBuilder;
import com.facebook.messaging.model.attachment.Attachment;
import com.facebook.messaging.model.messages.Message;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: media_sent */
public class ThreadViewOtherAttachmentsView extends LinearLayout {
    @Inject
    public AttachmentDataFactory f7964a;
    private Message f7965b;
    private ImmutableList<OtherAttachmentData> f7966c;
    private int f7967d;
    public boolean f7968e;

    private static <T extends View> void m7896a(Class<T> cls, T t) {
        m7897a((Object) t, t.getContext());
    }

    private static void m7897a(Object obj, Context context) {
        ((ThreadViewOtherAttachmentsView) obj).f7964a = AttachmentDataFactory.a(FbInjector.get(context));
    }

    public ThreadViewOtherAttachmentsView(Context context) {
        this(context, null);
    }

    public ThreadViewOtherAttachmentsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7896a(ThreadViewOtherAttachmentsView.class, (View) this);
        setOrientation(1);
    }

    public Message getMessage() {
        return this.f7965b;
    }

    public void setMessage(Message message) {
        ImmutableList b;
        this.f7965b = message;
        AttachmentDataFactory attachmentDataFactory = this.f7964a;
        Builder builder = ImmutableList.builder();
        ImmutableList immutableList = message.i;
        int size = immutableList.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            Attachment attachment = (Attachment) immutableList.get(i);
            if (attachmentDataFactory.f.e(attachment)) {
                OtherAttachmentDataBuilder newBuilder = OtherAttachmentData.newBuilder();
                newBuilder.a = attachment.e;
                newBuilder = newBuilder;
                newBuilder.b = attachment.d;
                newBuilder = newBuilder;
                newBuilder.d = attachment.b;
                newBuilder = newBuilder.a(attachment.f);
                newBuilder.e = attachment.a;
                builder.c(newBuilder.g());
                obj2 = 1;
            } else {
                obj2 = obj;
            }
            i++;
            obj = obj2;
        }
        if (obj != null) {
            b = builder.b();
        } else {
            ImmutableList a = message.a();
            int size2 = a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                MediaResource mediaResource = (MediaResource) a.get(i2);
                if (mediaResource.d == Type.OTHER) {
                    OtherAttachmentDataBuilder newBuilder2 = OtherAttachmentData.newBuilder();
                    newBuilder2.a = mediaResource.c.getLastPathSegment();
                    newBuilder2 = newBuilder2;
                    newBuilder2.b = mediaResource.o;
                    newBuilder2 = newBuilder2;
                    newBuilder2.c = mediaResource;
                    OtherAttachmentDataBuilder a2 = newBuilder2.a((int) mediaResource.p);
                    a2.d = message.a;
                    builder.c(a2.g());
                }
            }
            b = builder.b();
        }
        this.f7966c = b;
        m7893a();
    }

    public void setShowForMeUser(boolean z) {
        this.f7968e = z;
    }

    private void m7893a() {
        while (this.f7967d < this.f7966c.size()) {
            addView(new ThreadViewOtherAttachmentView(getContext()), this.f7967d);
            this.f7967d++;
        }
        int i = 0;
        while (i < this.f7967d && i < this.f7966c.size()) {
            m7894a(i);
            i++;
        }
        for (int i2 = i; i2 < this.f7967d; i2++) {
            ((ThreadViewOtherAttachmentView) getChildAt(i2)).setVisibility(8);
        }
    }

    private void m7894a(int i) {
        ThreadViewOtherAttachmentView threadViewOtherAttachmentView = (ThreadViewOtherAttachmentView) getChildAt(i);
        threadViewOtherAttachmentView.setAttachmentInfo((OtherAttachmentData) this.f7966c.get(i));
        threadViewOtherAttachmentView.setShowForMeUser(this.f7968e);
    }

    public final void m7898a(final MessageItemView messageItemView) {
        if (messageItemView != null) {
            int i = 0;
            while (i < this.f7967d && i < this.f7966c.size()) {
                ThreadViewOtherAttachmentView threadViewOtherAttachmentView = (ThreadViewOtherAttachmentView) getChildAt(i);
                final OtherAttachmentData otherAttachmentData = (OtherAttachmentData) this.f7966c.get(i);
                threadViewOtherAttachmentView.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ ThreadViewOtherAttachmentsView f7961c;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 1742449753);
                        MessageItemView messageItemView = messageItemView;
                        OtherAttachmentData otherAttachmentData = otherAttachmentData;
                        if (messageItemView.bg != null) {
                            messageItemView.bg.mo277a(otherAttachmentData);
                        }
                        Logger.a(2, EntryType.UI_INPUT_END, -662413614, a);
                    }
                });
                threadViewOtherAttachmentView.setOnLongClickListener(new OnLongClickListener(this) {
                    final /* synthetic */ ThreadViewOtherAttachmentsView f7963b;

                    public boolean onLongClick(View view) {
                        messageItemView.m6758a(null);
                        return true;
                    }
                });
                i++;
            }
        }
    }

    private void m7895a(AttachmentDataFactory attachmentDataFactory) {
        this.f7964a = attachmentDataFactory;
    }
}
