package com.facebook.groups.memberrequests;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: TVMF-resetfragmentandlistadapter */
public class GroupsMemberRequestsFragmentFactory implements IFragmentFactory {
    public final Fragment m24010a(Intent intent) {
        MemberRequestsFragment memberRequestsFragment = new MemberRequestsFragment();
        memberRequestsFragment.g(intent.getExtras());
        return memberRequestsFragment;
    }
}
