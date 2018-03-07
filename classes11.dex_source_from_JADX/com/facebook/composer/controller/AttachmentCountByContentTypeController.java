package com.facebook.composer.controller;

import com.facebook.composer.attachments.AttachmentUtils;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.model.ComposerContentType;
import com.facebook.ipc.composer.model.ComposerContentType.ProvidesContentType;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: inline_privacy_survey_data_provider */
public class AttachmentCountByContentTypeController<DataProvider extends ProvidesAttachments & ProvidesContentType> {
    private final WeakReference<DataProvider> f6236a;

    @Inject
    public AttachmentCountByContentTypeController(@Assisted DataProvider dataProvider) {
        this.f6236a = new WeakReference(Preconditions.checkNotNull(dataProvider));
    }

    public final ImmutableMap<String, Integer> m7708a() {
        int i = 0;
        ProvidesAttachments providesAttachments = (ProvidesAttachments) Preconditions.checkNotNull(this.f6236a.get());
        ComposerContentType c = ((ProvidesContentType) providesAttachments).c();
        int i2;
        if (c == ComposerContentType.MULTIMEDIA || c == ComposerContentType.MULTIPLE_PHOTOS || c == ComposerContentType.SINGLE_PHOTO || c == ComposerContentType.VIDEO) {
            ImmutableList m = providesAttachments.m();
            int size = m.size();
            int i3 = 0;
            int i4 = 0;
            while (i3 < size) {
                if (AttachmentUtils.a((ComposerAttachment) m.get(i3))) {
                    i2 = i4 + 1;
                    i4 = i;
                } else {
                    int i5 = i4;
                    i4 = i + 1;
                    i2 = i5;
                }
                i3++;
                i = i4;
                i4 = i2;
            }
            Builder builder = ImmutableMap.builder();
            if (i > 0) {
                builder.b("PHOTO", Integer.valueOf(i));
            }
            if (i4 > 0) {
                builder.b("VIDEO", Integer.valueOf(i4));
            }
            return builder.b();
        }
        i2 = providesAttachments.m().size();
        if (c == ComposerContentType.STICKER) {
            i2++;
        }
        return ImmutableBiMap.b(c.toString(), Integer.valueOf(i2));
    }
}
