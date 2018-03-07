package com.facebook.groups.docsandfiles;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.groups.docsandfiles.fragment.GroupDocsAndFilesFragment;

/* compiled from: UserBadging */
public class GroupsFileFragmentFactory implements IFragmentFactory {
    public final Fragment m22310a(Intent intent) {
        GroupDocsAndFilesFragment groupDocsAndFilesFragment = new GroupDocsAndFilesFragment();
        groupDocsAndFilesFragment.g(intent.getExtras());
        return groupDocsAndFilesFragment;
    }
}
