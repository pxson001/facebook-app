package com.facebook.friendsnearby.model;

import com.facebook.widget.listview.ExpandableSectionedListSection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.List;

/* compiled from: a required field in section result is null */
public abstract class FriendsNearbySection extends ExpandableSectionedListSection<FriendsNearbyRow> {
    public static final FriendsNearbySection f20519c = new C29271(null);
    public String f20520b;

    /* compiled from: a required field in section result is null */
    final class C29271 extends FriendsNearbySection {
        C29271(String str) {
            super(str);
        }

        public final String mo922g() {
            throw new UnsupportedOperationException();
        }

        public final void mo921a(ImmutableList<FriendsNearbyRow> immutableList) {
            throw new UnsupportedOperationException();
        }

        protected final List<FriendsNearbyRow> m20961d() {
            throw new UnsupportedOperationException();
        }

        public final List<FriendsNearbyRow> m20962e() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: a required field in section result is null */
    final class C29282 extends FriendsNearbySection {
        final /* synthetic */ String f20551a;

        C29282(String str, String str2) {
            this.f20551a = str2;
            super(str);
        }

        protected final List<FriendsNearbyRow> m20965d() {
            return RegularImmutableList.a;
        }

        public final List<FriendsNearbyRow> m20966e() {
            return RegularImmutableList.a;
        }

        public final String mo922g() {
            return this.f20551a;
        }

        public final void mo921a(ImmutableList<FriendsNearbyRow> immutableList) {
        }
    }

    public abstract void mo921a(ImmutableList<FriendsNearbyRow> immutableList);

    public abstract String mo922g();

    public FriendsNearbySection(String str) {
        super(str);
    }

    public static FriendsNearbySection m20919b(String str) {
        return new C29282("", str);
    }
}
