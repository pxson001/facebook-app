package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import com.facebook.feed.rows.sections.attachments.MinutiaeAttachmentTextPartDefinition.Props;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ufiservices.util.LinkifyUtil;

/* compiled from: ZI */
public class MinutiaeAttachmentHeaderTextPersistentSpannableInputProvider extends AbstractAssistedProvider<MinutiaeAttachmentHeaderTextPersistentSpannableInput> {
    public final MinutiaeAttachmentHeaderTextPersistentSpannableInput m23698a(Props props) {
        return new MinutiaeAttachmentHeaderTextPersistentSpannableInput(props, (Context) getInstance(Context.class), LinkifyUtil.a(this), IdBasedSingletonScopeProvider.a(this, 616));
    }
}
