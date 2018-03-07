package com.facebook.groups.composer.groupspollcomposer.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.AbsListView.LayoutParams;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.groups.composer.groupspollcomposer.view.GroupsPollComposerFooterView.C00624;
import com.facebook.widget.SwitchCompat;

/* compiled from: view_app_tap */
public class GroupsPollSettingPopoverItemView extends ImageBlockLayout {
    public SwitchCompat f494h = ((SwitchCompat) getView(2131562712));

    /* compiled from: view_app_tap */
    public class C00651 implements OnCheckedChangeListener {
        final /* synthetic */ C00624 f491a;
        final /* synthetic */ MenuItem f492b;
        final /* synthetic */ GroupsPollSettingPopoverItemView f493c;

        public C00651(GroupsPollSettingPopoverItemView groupsPollSettingPopoverItemView, C00624 c00624, MenuItem menuItem) {
            this.f493c = groupsPollSettingPopoverItemView;
            this.f491a = c00624;
            this.f492b = menuItem;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.f491a.m472a(this.f492b, z);
        }
    }

    public GroupsPollSettingPopoverItemView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(2130904686, this);
        setLayoutParams(new LayoutParams(-1, -1));
    }
}
