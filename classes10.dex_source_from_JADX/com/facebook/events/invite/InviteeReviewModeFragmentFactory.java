package com.facebook.events.invite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: changed */
public class InviteeReviewModeFragmentFactory implements IFragmentFactory {
    public final Fragment m18102a(Intent intent) {
        Bundle extras = intent.getExtras();
        InviteeReviewModeFragment inviteeReviewModeFragment = new InviteeReviewModeFragment();
        inviteeReviewModeFragment.g(extras);
        return inviteeReviewModeFragment;
    }
}
