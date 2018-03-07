package com.facebook.groups.widget.actionbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import com.facebook.fbui.widget.inlineactionbar.InlineActionBar;
import com.facebook.fbui.widget.inlineactionbar.InlineActionBar.InlineActionBarMenuHandler;
import com.facebook.messaging.appspecific.AppGlyphResolver;
import com.google.common.collect.ImmutableList;

/* compiled from: ThreadViewMessagesFragment.onMessageSent */
public class GroupsActionBar extends InlineActionBar {
    private final int f23200a = 3;
    private final InlineActionBarMenuHandler f23201b = new C33491(this);
    public Listener f23202c;

    /* compiled from: ThreadViewMessagesFragment.onMessageSent */
    public interface Listener {
        void mo987a(GroupsActionBarItems groupsActionBarItems);
    }

    /* compiled from: ThreadViewMessagesFragment.onMessageSent */
    class C33491 implements InlineActionBarMenuHandler {
        final /* synthetic */ GroupsActionBar f23199a;

        C33491(GroupsActionBar groupsActionBar) {
            this.f23199a = groupsActionBar;
        }

        public final boolean m24556a(MenuItem menuItem) {
            if (!menuItem.isEnabled()) {
                return true;
            }
            if (this.f23199a.f23202c == null) {
                return false;
            }
            this.f23199a.f23202c.mo987a(GroupsActionBarItems.values()[menuItem.getItemId()]);
            return true;
        }
    }

    /* compiled from: ThreadViewMessagesFragment.onMessageSent */
    public enum GroupsActionBarItems {
        CREATE_GROUP(2131238029, 2130840035, 0, true, false, false),
        JOIN(2131238024, 2130840642, 2, true, true, false),
        REQUESTED(2131238025, 2130840642, 2, true, true, true),
        JOINED(2131238026, 2130840642, 2, true, true, true),
        INFO(2131238030, 2130839943, 0, true, false, false),
        INFO_ICON(2131238028, 2130839943, 2, true, false, false),
        ADD_MEMBERS(2131238027, 2130839877, 2, true, false, false),
        SEARCH(2131238033, 2130839976, 2, true, false, false),
        SHARE(2131238034, 2130840097, 2, true, false, false),
        SHARE_MAYBE(2131238034, 2130840097, 1, true, false, false),
        CREATE_SHORTCUT(2131238032, 2130840114, 0, true, false, false),
        CREATE_GROUP_CHAT(2131237822, AppGlyphResolver.a(), 0, true, false, false),
        CREATE_GROUP_EVENT(2131237823, 2130839846, 0, true, false, false),
        VIEW_PHOTOS(2131238031, 2130840019, 0, true, false, false),
        EDIT_NOTIFICATION_SETTING(2131238043, 0, 0, true, false, false),
        REPORT_GROUP(2131238035, 2130840081, 0, true, false, false),
        FAVORITE_GROUP(2131238036, 0, 0, true, false, false),
        UNFAVORITE_GROUP(2131238037, 0, 0, true, false, false);
        
        public final boolean checkable;
        public final boolean checked;
        public final boolean enabled;
        public final int iconMediumResId;
        public final int labelResId;
        public final int showAsAction;

        private GroupsActionBarItems(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
            this.labelResId = i;
            this.iconMediumResId = i2;
            this.showAsAction = i3;
            this.enabled = z;
            this.checked = z3;
            this.checkable = z2;
        }
    }

    public GroupsActionBar(Context context) {
        super(context);
        m24558a();
    }

    public GroupsActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24558a();
    }

    public GroupsActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24558a();
    }

    private void m24558a() {
        setMaxNumOfVisibleButtons(3);
        this.b = this.f23201b;
        a(false, true, 0);
    }

    public void setListener(Listener listener) {
        this.f23202c = listener;
    }

    public void setItems(ImmutableList<GroupsActionBarItems> immutableList) {
        b();
        clear();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            GroupsActionBarItems groupsActionBarItems = (GroupsActionBarItems) immutableList.get(i);
            a(0, groupsActionBarItems.ordinal(), 0, groupsActionBarItems.labelResId).setShowAsActionFlags(groupsActionBarItems.showAsAction).setIcon(groupsActionBarItems.iconMediumResId).setEnabled(groupsActionBarItems.enabled).setCheckable(groupsActionBarItems.checkable).setChecked(groupsActionBarItems.checked);
        }
        d();
    }
}
