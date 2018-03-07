package com.facebook.messaging.tincan.messenger;

import android.annotation.SuppressLint;
import android.content.Context;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.attachments.EncryptedFileAttachmentUtils;
import com.facebook.messaging.model.attachment.Attachment;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.tincan.database.TincanDbMessagesFetcher;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: client_create_click */
public class AttachmentFileDeleter {
    public final Context f17975a;
    private final TincanDbMessagesFetcher f17976b;

    /* compiled from: client_create_click */
    class C21051 implements Function<Message, Void> {
        final /* synthetic */ AttachmentFileDeleter f17974a;

        C21051(AttachmentFileDeleter attachmentFileDeleter) {
            this.f17974a = attachmentFileDeleter;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            Message message = (Message) obj;
            AttachmentFileDeleter attachmentFileDeleter = this.f17974a;
            ImmutableList immutableList = message.i;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                EncryptedFileAttachmentUtils.m8022a(attachmentFileDeleter.f17975a, ((Attachment) immutableList.get(i)).c).delete();
            }
            return null;
        }
    }

    public static AttachmentFileDeleter m17968a(InjectorLike injectorLike) {
        return new AttachmentFileDeleter((Context) injectorLike.getInstance(Context.class, ForAppContext.class), TincanDbMessagesFetcher.a(injectorLike));
    }

    @Inject
    public AttachmentFileDeleter(@ForAppContext Context context, TincanDbMessagesFetcher tincanDbMessagesFetcher) {
        this.f17975a = context;
        this.f17976b = tincanDbMessagesFetcher;
    }

    @SuppressLint({"NewApi"})
    public final void m17969a(ThreadKey threadKey) {
        this.f17976b.a(threadKey, new C21051(this));
    }
}
