package com.facebook.friendsharing.souvenirs.prompt;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import com.facebook.feed.inlinecomposer.v2attachment.V2Attachment;
import com.facebook.feed.inlinecomposer.v2attachment.V2PromptUtil;
import com.facebook.friendsharing.souvenirs.prompt.model.SouvenirPromptObject;
import com.facebook.ipc.productionprompts.ui.v2.PromptViewBindingObject;
import com.facebook.productionprompts.model.PromptDisplayReason;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;

@VisibleForTesting
/* compiled from: RESHARE_BUTTON_EXPERIMENT_CLICKED */
public class SouvenirPromptViewController$SouvenirPromptViewBindingObject implements PromptViewBindingObject {
    final SouvenirPromptAttachment f24098a;
    final Uri f24099b;
    final String f24100c;
    final SpannableStringBuilder f24101d;
    final /* synthetic */ SouvenirPromptViewController f24102e;

    SouvenirPromptViewController$SouvenirPromptViewBindingObject(SouvenirPromptViewController souvenirPromptViewController, SouvenirPromptObject souvenirPromptObject) {
        this.f24102e = souvenirPromptViewController;
        this.f24098a = new SouvenirPromptAttachment(souvenirPromptViewController.d);
        this.f24099b = souvenirPromptObject.m26256e();
        this.f24100c = souvenirPromptViewController.b.a(souvenirPromptObject);
        this.f24101d = souvenirPromptViewController.b.a(souvenirPromptViewController.d.getResources(), souvenirPromptViewController.a.getString(2131238467));
    }

    public final String m26223a() {
        return null;
    }

    public final String m26224b() {
        return this.f24102e.a.getString(2131238466);
    }

    @Nullable
    public final Integer m26225c() {
        return Integer.valueOf(this.f24102e.a.getColor(2131361956));
    }

    @Nullable
    public final Drawable m26226d() {
        return this.f24102e.d.getResources().getDrawable(2130842739);
    }

    public final Drawable m26227e() {
        return null;
    }

    @Nullable
    public final Uri m26228f() {
        return V2PromptUtil.a(2130843427);
    }

    @Nullable
    public final V2Attachment m26229g() {
        return this.f24098a;
    }

    @Nullable
    public final PromptDisplayReason m26230h() {
        return null;
    }
}
