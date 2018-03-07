package com.facebook.feed.photoreminder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.feed.inlinecomposer.v2attachment.V2Attachment;
import com.facebook.feed.inlinecomposer.v2attachment.V2PromptUtil;
import com.facebook.feed.photoreminder.abtest.ExperimentsForPhotoReminderAbTestModule;
import com.facebook.feed.photoreminder.model.MediaReminderModel;
import com.facebook.ipc.productionprompts.ui.v2.PromptViewBindingObject;
import com.facebook.productionprompts.model.PromptDisplayReason;
import javax.annotation.Nullable;

/* compiled from: admin_panel_write_post */
public class MediaReminderUtil$V2PhotoReminderPrompt implements PromptViewBindingObject {
    final /* synthetic */ MediaReminderUtil f19695a;
    public final PhotoReminderV2View f19696b;
    public MediaReminderModel f19697c;

    public MediaReminderUtil$V2PhotoReminderPrompt(MediaReminderUtil mediaReminderUtil, Context context) {
        this.f19695a = mediaReminderUtil;
        this.f19696b = new PhotoReminderV2View(context);
    }

    public final String m22964a() {
        if (this.f19697c.l) {
            return this.f19695a.m.a(ExperimentsForPhotoReminderAbTestModule.t, this.f19695a.i.getString(2131235715));
        }
        if (this.f19697c.g == 0) {
            return this.f19695a.i.getString(2131235714);
        }
        if (this.f19697c.f == 0) {
            return this.f19695a.i.getString(2131235716);
        }
        return this.f19695a.i.getString(2131235717);
    }

    public final String m22965b() {
        return this.f19695a.i.getString(2131235718);
    }

    public final Integer m22966c() {
        return Integer.valueOf(this.f19695a.i.getResources().getColor(2131361936));
    }

    public final Drawable m22967d() {
        return this.f19695a.i.getResources().getDrawable(2130842739);
    }

    public final Drawable m22968e() {
        return null;
    }

    public final Uri m22969f() {
        V2PromptUtil v2PromptUtil = this.f19695a.n;
        return V2PromptUtil.a(2130842625);
    }

    public final V2Attachment m22970g() {
        return this.f19696b;
    }

    @Nullable
    public final PromptDisplayReason m22971h() {
        return null;
    }
}
