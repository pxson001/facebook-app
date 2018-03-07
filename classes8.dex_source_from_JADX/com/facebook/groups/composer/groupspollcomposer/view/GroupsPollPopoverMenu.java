package com.facebook.groups.composer.groupspollcomposer.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.groups.composer.groupspollcomposer.view.GroupsPollComposerFooterView.C00624;
import com.facebook.groups.composer.groupspollcomposer.view.GroupsPollSettingPopoverItemView.C00651;

/* compiled from: view_comment_tap */
public class GroupsPollPopoverMenu extends PopoverMenu {
    private C00624 f490c;

    public GroupsPollPopoverMenu(Context context, C00624 c00624) {
        super(context);
        this.f490c = c00624;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        GroupsPollSettingPopoverItemView groupsPollSettingPopoverItemView = new GroupsPollSettingPopoverItemView(viewGroup.getContext());
        MenuItem item = getItem(i);
        C00624 c00624 = this.f490c;
        groupsPollSettingPopoverItemView.f494h.setChecked(item.isChecked());
        groupsPollSettingPopoverItemView.f494h.setText(item.getTitle());
        if (VERSION.SDK_INT < 17) {
            groupsPollSettingPopoverItemView.f494h.setGravity(19);
        } else {
            groupsPollSettingPopoverItemView.f494h.setTextAlignment(5);
        }
        groupsPollSettingPopoverItemView.f494h.setOnCheckedChangeListener(new C00651(groupsPollSettingPopoverItemView, c00624, item));
        return groupsPollSettingPopoverItemView;
    }
}
