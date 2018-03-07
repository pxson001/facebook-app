package com.facebook.tagging.conversion;

import com.facebook.widget.listview.ExpandableSectionedListSection;
import com.facebook.widget.tokenizedtypeahead.model.GroupTagToken;
import java.util.List;

/* compiled from: max_color */
public class GroupSuggestionsSection extends ExpandableSectionedListSection<GroupTagToken> {
    private final List<GroupTagToken> f9110a;

    public GroupSuggestionsSection(String str, List<GroupTagToken> list) {
        super(str);
        this.f9110a = list;
    }

    public final List<GroupTagToken> m10884e() {
        return this.f9110a;
    }

    protected final List<GroupTagToken> m10883d() {
        return this.f9110a;
    }
}
