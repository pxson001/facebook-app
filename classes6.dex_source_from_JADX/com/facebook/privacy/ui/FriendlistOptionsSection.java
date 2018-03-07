package com.facebook.privacy.ui;

import com.facebook.widget.listview.ExpandableSectionedListSection;
import com.facebook.widget.tokenizedtypeahead.model.SimpleFriendlistToken;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: father */
public class FriendlistOptionsSection extends ExpandableSectionedListSection<SimpleFriendlistToken> {
    public final List<SimpleFriendlistToken> f15301a;
    private final List<SimpleFriendlistToken> f15302b;

    public FriendlistOptionsSection(List<SimpleFriendlistToken> list, List<SimpleFriendlistToken> list2) {
        super(null);
        this.f15301a = Lists.a(list);
        this.f15302b = Lists.a(list2);
    }

    public final List<SimpleFriendlistToken> mo1212e() {
        return this.f15301a;
    }

    protected final List<SimpleFriendlistToken> mo1211d() {
        return this.f15302b;
    }
}
