package com.facebook.groups.memberlist;

/* compiled from: extra_show_attribution */
public interface GroupMemberListItem {

    /* compiled from: extra_show_attribution */
    public enum GroupMemberItemViewType {
        GroupMemberRow,
        Header,
        LoadingBar,
        SeeMoreBar;
        
        private static final GroupMemberItemViewType[] values = null;

        static {
            values = values();
        }

        public static GroupMemberItemViewType fromOrdinal(int i) {
            return values[i];
        }
    }

    GroupMemberItemViewType mo872a();
}
