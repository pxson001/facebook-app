package com.facebook.groups.memberlist;

import android.content.Context;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.widget.compositeadapter.CompositeAdapter.Controller;
import com.facebook.widget.compositeadapter.CompositeAdapter.Model;
import com.facebook.widget.compositeadapter.stickyheader.StickyHeaderCompositeAdapter.StickyHeaderRenderer;
import com.facebook.widget.itemslist.StickyHeaderSectionIndexer;

/* compiled from: extra_query_title */
public class GroupMemberListWithStickyHeaderAdapterProvider extends AbstractAssistedProvider<GroupMemberListWithStickyHeaderAdapter> {
    public final GroupMemberListWithStickyHeaderAdapter m15902a(Model model, StickyHeaderSectionIndexer stickyHeaderSectionIndexer, StickyHeaderRenderer stickyHeaderRenderer, GroupMemberListInfoManager groupMemberListInfoManager, Controller controller) {
        return new GroupMemberListWithStickyHeaderAdapter(model, stickyHeaderSectionIndexer, stickyHeaderRenderer, groupMemberListInfoManager, controller, (Context) getInstance(Context.class));
    }
}
