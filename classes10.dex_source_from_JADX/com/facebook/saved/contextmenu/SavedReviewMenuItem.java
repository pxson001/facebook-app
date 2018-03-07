package com.facebook.saved.contextmenu;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.facebook.analytics.CurationMechanism;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.saved.contextmenu.interfaces.ReviewableItemWrapper;
import com.facebook.saved.contextmenu.interfaces.SavedContextMenuItem;
import com.facebook.saved.launcher.SavedReviewComposerLauncherWithResult;
import com.facebook.saved.launcher.SavedReviewComposerLauncherWithResult.C13972;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: is_sms_enabled */
public class SavedReviewMenuItem implements SavedContextMenuItem<ReviewableItemWrapper> {
    private final Resources f8981a;
    private final SavedReviewComposerLauncherWithResult f8982b;

    public final boolean mo411a(Object obj, Fragment fragment) {
        ReviewableItemWrapper reviewableItemWrapper = (ReviewableItemWrapper) obj;
        SavedReviewComposerLauncherWithResult savedReviewComposerLauncherWithResult = this.f8982b;
        FragmentActivity o = fragment.o();
        if (reviewableItemWrapper.mo427d()) {
            savedReviewComposerLauncherWithResult.f9206f.a(reviewableItemWrapper.mo424a(), new C13972(savedReviewComposerLauncherWithResult, ProgressDialog.a(o, null, savedReviewComposerLauncherWithResult.f9202b.getString(2131235352), true, false), reviewableItemWrapper, o));
        } else {
            SavedReviewComposerLauncherWithResult.m9219a(savedReviewComposerLauncherWithResult, reviewableItemWrapper, o, null);
        }
        return true;
    }

    public final boolean mo413b(Object obj) {
        return ((ReviewableItemWrapper) obj).mo426c();
    }

    @Inject
    public SavedReviewMenuItem(Resources resources, SavedReviewComposerLauncherWithResult savedReviewComposerLauncherWithResult) {
        this.f8981a = resources;
        this.f8982b = savedReviewComposerLauncherWithResult;
    }

    public final Class<ReviewableItemWrapper> mo409a() {
        return ReviewableItemWrapper.class;
    }

    public final String mo412b() {
        return this.f8981a.getString(2131238187);
    }

    @Nonnull
    public final CurationMechanism mo414c() {
        return CurationMechanism.REVIEW_BUTTON;
    }

    public final String mo410a(Object obj) {
        return this.f8981a.getString(2131238189);
    }

    public final int mo415d() {
        return 2130843245;
    }
}
