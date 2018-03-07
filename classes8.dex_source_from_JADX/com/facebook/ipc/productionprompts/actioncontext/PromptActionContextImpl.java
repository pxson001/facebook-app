package com.facebook.ipc.productionprompts.actioncontext;

import android.net.Uri;
import com.facebook.feed.photoreminder.model.MediaModel.MediaType;
import com.facebook.ipc.productionprompts.actionhandler.PromptActionContext;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.annotation.Nullable;

/* compiled from: unknown color for text view  */
public class PromptActionContextImpl implements PromptActionContext {
    public final String f1156a;
    public final Action f1157b;
    public final int f1158c;
    public final MediaType f1159d;
    public final Uri f1160e;
    @Nullable
    private final String f1161f;
    @Nullable
    public final String f1162g;
    @Nullable
    public final Uri f1163h;
    public final int f1164i;
    public Optional<String> f1165j;

    @VisibleForTesting
    /* compiled from: unknown color for text view  */
    public enum Action {
        PHOTO_REMINDER_TAP_ON_MEDIA,
        PHOTO_REMINDER_TAP_ON_MORE,
        DEFAULT_TAP_ON_PROMPT,
        TAP_ON_V1_PROMPT_SECONDARY_ACTION
    }

    /* compiled from: unknown color for text view  */
    public class Builder {
        public String f1146a = null;
        public Action f1147b = null;
        public int f1148c = -1;
        public MediaType f1149d = null;
        public Uri f1150e = null;
        private Optional<String> f1151f = Absent.INSTANCE;
        @Nullable
        public String f1152g;
        @Nullable
        public String f1153h;
        @Nullable
        public Uri f1154i;
        public int f1155j = -1;

        public final Builder m1384b(String str) {
            this.f1151f = Optional.of(str);
            return this;
        }

        public final PromptActionContextImpl m1383a() {
            return new PromptActionContextImpl(this.f1146a, this.f1147b, this.f1148c, this.f1149d, this.f1150e, this.f1151f, this.f1152g, this.f1153h, this.f1154i, this.f1155j);
        }
    }

    private PromptActionContextImpl(String str, Action action, int i, MediaType mediaType, Uri uri, Optional<String> optional, String str2, String str3, Uri uri2, int i2) {
        this.f1156a = str;
        this.f1157b = action;
        this.f1158c = i;
        this.f1159d = mediaType;
        this.f1160e = uri;
        this.f1165j = optional;
        this.f1161f = str2;
        this.f1162g = str3;
        this.f1163h = uri2;
        this.f1164i = i2;
    }

    public final Optional<String> m1385a() {
        return this.f1165j;
    }

    public final String m1387b() {
        return this.f1156a;
    }

    public final void m1386a(String str) {
        this.f1165j = Optional.of(str);
    }

    public final boolean m1388e() {
        return Action.TAP_ON_V1_PROMPT_SECONDARY_ACTION.equals(this.f1157b);
    }

    @Nullable
    public final String m1389i() {
        return this.f1161f;
    }
}
