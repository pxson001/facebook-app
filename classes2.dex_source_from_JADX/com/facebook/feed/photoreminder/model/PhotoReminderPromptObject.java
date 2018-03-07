package com.facebook.feed.photoreminder.model;

import com.facebook.productionprompts.model.PromptObject;
import com.facebook.productionprompts.model.PromptObject.PromptSurface;
import com.google.common.base.Objects;

/* compiled from: network_info_egress_avg */
public class PhotoReminderPromptObject implements PromptObject {
    public final MediaReminderModel f12633a;

    public PhotoReminderPromptObject(MediaReminderModel mediaReminderModel) {
        this.f12633a = mediaReminderModel;
    }

    public final String mo2493b() {
        return this.f12633a.m25075b();
    }

    public final String mo2494c() {
        return this.f12633a.m25076c();
    }

    public final PromptSurface mo2495d() {
        return PromptSurface.INLINE_COMPOSER;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhotoReminderPromptObject)) {
            return false;
        }
        return Objects.equal(this.f12633a, ((PhotoReminderPromptObject) obj).f12633a);
    }

    public int hashCode() {
        return this.f12633a.hashCode();
    }
}
