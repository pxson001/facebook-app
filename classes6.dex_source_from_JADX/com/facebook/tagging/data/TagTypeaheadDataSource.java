package com.facebook.tagging.data;

import com.facebook.tagging.model.TaggingProfile;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.List;

/* compiled from: has_good_friends */
public abstract class TagTypeaheadDataSource {

    /* compiled from: has_good_friends */
    public interface SourceResultsListener {
        void mo1121a(CharSequence charSequence, List<TaggingProfile> list);
    }

    /* compiled from: has_good_friends */
    public enum TagTypeaheadDataType {
        COWORKERS,
        OPEN_GROUP_MEMBERS,
        PUBLIC_GROUP_MEMBERS,
        CLOSE_GROUP_MEMBERS,
        SECRET_GROUP_MEMBERS,
        FRIENDS,
        COMMENT_AUTHORS,
        NOT_NOTIFIED_OTHERS,
        NOT_NOTIFIED_AND_UNSEEN_OTHERS,
        OTHERS,
        GOOD_FRIENDS;

        public final int getCustomizedNameResourceId() {
            switch (this) {
                case COWORKERS:
                    return 2131234458;
                case OPEN_GROUP_MEMBERS:
                    return 2131234465;
                case PUBLIC_GROUP_MEMBERS:
                    return 2131234464;
                case SECRET_GROUP_MEMBERS:
                    return 2131234463;
                case CLOSE_GROUP_MEMBERS:
                    return 2131234462;
                case FRIENDS:
                    return 2131234459;
                case COMMENT_AUTHORS:
                    return 2131234460;
                case NOT_NOTIFIED_OTHERS:
                    return 2131234467;
                case NOT_NOTIFIED_AND_UNSEEN_OTHERS:
                    return 2131234466;
                case GOOD_FRIENDS:
                    return 2131234459;
                default:
                    return 2131234461;
            }
        }

        public final boolean isGroupTagTypeaheadDataType() {
            switch (this) {
                case OPEN_GROUP_MEMBERS:
                case PUBLIC_GROUP_MEMBERS:
                case SECRET_GROUP_MEMBERS:
                case CLOSE_GROUP_MEMBERS:
                    return true;
                default:
                    return false;
            }
        }
    }

    public abstract String mo1316b();

    public List<TaggingProfile> mo1318a(CharSequence charSequence, boolean z, boolean z2, boolean z3, boolean z4) {
        return RegularImmutableList.a;
    }

    public void mo1314a(CharSequence charSequence, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, SourceResultsListener sourceResultsListener) {
    }

    public boolean mo1315a() {
        return false;
    }

    public ImmutableList<String> mo1319d() {
        Builder builder = new Builder();
        builder.c(TagTypeaheadDataType.OTHERS.toString());
        return builder.b();
    }

    public String mo1317c() {
        return "";
    }

    public String mo1322e() {
        return null;
    }
}
