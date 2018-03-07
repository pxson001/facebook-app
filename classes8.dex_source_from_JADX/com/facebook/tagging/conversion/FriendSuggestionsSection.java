package com.facebook.tagging.conversion;

import com.facebook.widget.listview.ExpandableSectionedListSection;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import java.util.List;

/* compiled from: max_count */
public class FriendSuggestionsSection extends ExpandableSectionedListSection<SimpleUserToken> {
    private final List<SimpleUserToken> f9108a;
    private final List<SimpleUserToken> f9109b;

    public FriendSuggestionsSection(String str, List<SimpleUserToken> list, List<SimpleUserToken> list2) {
        super(str);
        this.f9108a = list;
        this.f9109b = list2;
        a(false);
    }

    public final List<SimpleUserToken> m10882e() {
        return this.f9108a;
    }

    protected final List<SimpleUserToken> m10881d() {
        return this.f9109b;
    }
}
