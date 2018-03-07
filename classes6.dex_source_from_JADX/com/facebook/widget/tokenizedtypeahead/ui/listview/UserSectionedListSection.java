package com.facebook.widget.tokenizedtypeahead.ui.listview;

import com.facebook.widget.listview.SectionedListSection;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Nonnull;

/* compiled from: com.facebook.platform.protocol.CALL_ID */
public class UserSectionedListSection implements SectionedListSection<SimpleUserToken> {
    public final HashMap<String, SimpleUserToken> f20156a;
    private final List<SimpleUserToken> f20157b;
    private final String f20158c;

    public UserSectionedListSection() {
        this(null, RegularImmutableList.a);
    }

    public UserSectionedListSection(String str, ImmutableList<SimpleUserToken> immutableList) {
        this.f20156a = Maps.c();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            SimpleUserToken simpleUserToken = (SimpleUserToken) immutableList.get(i);
            this.f20156a.put(simpleUserToken.f20125g.b(), simpleUserToken);
        }
        this.f20158c = str;
        this.f20157b = immutableList;
    }

    public final String mo432a() {
        return this.f20158c;
    }

    @Nonnull
    public final List<SimpleUserToken> mo434b() {
        return ImmutableList.copyOf(this.f20157b);
    }

    public final boolean mo435c() {
        return false;
    }

    public final void mo433a(boolean z) {
    }

    public final boolean mo436f() {
        return false;
    }
}
