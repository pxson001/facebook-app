package com.facebook.compost.controller;

import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: comment/{%s}?feedback={%s} */
public class CompostAttachment {
    @Nullable
    public final ComposerShareParams f17377a;
    @Nullable
    public final ImmutableList<ComposerAttachment> f17378b;

    /* compiled from: comment/{%s}?feedback={%s} */
    public class Builder {
        @Nullable
        public ComposerShareParams f17375a;
        @Nullable
        public ImmutableList<ComposerAttachment> f17376b;

        public final CompostAttachment m21267a() {
            return new CompostAttachment(this);
        }
    }

    public CompostAttachment(Builder builder) {
        this.f17377a = builder.f17375a;
        this.f17378b = builder.f17376b;
        boolean z = this.f17377a == null || this.f17378b == null;
        Preconditions.checkState(z, "Attachments are mutually exclusive.");
    }
}
