package com.facebook.messaging.inbox2.items;

import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel.MessengerInboxUnitItemsModel;
import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractStreamingHashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Murmur3_128HashFunction;
import javax.annotation.Nullable;

/* compiled from: mReferenceNo1 */
public abstract class InboxUnitItem implements InboxItem {
    protected static final AbstractStreamingHashFunction f11297a = new Murmur3_128HashFunction(InboxUnitItem.class.hashCode());
    public static int f11298b = 0;
    public static int f11299c = 1;
    public final NodesModel f11300d;
    @Nullable
    public final MessengerInboxUnitItemsModel f11301e;
    @Nullable
    private final SpecialItemType f11302f;
    public int f11303g;
    private volatile long f11304h;
    private volatile String f11305i;
    @Nullable
    private String f11306j;

    /* compiled from: mReferenceNo1 */
    public enum SpecialItemType {
        SECTION_HEADER("h"),
        MORE_FOOTER("m");
        
        public final String analyticsString;

        private SpecialItemType(String str) {
            this.analyticsString = str;
        }
    }

    protected InboxUnitItem(NodesModel nodesModel) {
        this(nodesModel, null, null);
    }

    protected InboxUnitItem(NodesModel nodesModel, MessengerInboxUnitItemsModel messengerInboxUnitItemsModel) {
        this(nodesModel, messengerInboxUnitItemsModel, null);
    }

    protected InboxUnitItem(NodesModel nodesModel, SpecialItemType specialItemType) {
        this(nodesModel, null, specialItemType);
        Preconditions.checkNotNull(specialItemType);
    }

    private InboxUnitItem(NodesModel nodesModel, @Nullable MessengerInboxUnitItemsModel messengerInboxUnitItemsModel, SpecialItemType specialItemType) {
        this.f11303g = -1;
        Preconditions.checkNotNull(nodesModel);
        this.f11300d = nodesModel;
        this.f11301e = messengerInboxUnitItemsModel;
        this.f11302f = specialItemType;
    }

    public final void m11898a(int i) {
        Preconditions.checkState(this.f11303g == -1);
        this.f11303g = i;
    }

    public final String m11900g() {
        if (this.f11306j == null) {
            this.f11306j = Long.toString(mo432c());
        }
        return this.f11306j;
    }

    public final long mo432c() {
        if (this.f11304h == 0) {
            this.f11304h = m11901h();
        }
        return this.f11304h;
    }

    protected long m11901h() {
        Hasher a = f11297a.a();
        if (this.f11301e != null) {
            a.a(this.f11301e.m11759j(), Charsets.UTF_8);
        } else {
            a.a(this.f11300d.m11779j(), Charsets.UTF_8);
            if (this.f11302f != null) {
                a.a(this.f11302f.analyticsString, Charsets.UTF_8);
            }
        }
        return a.a().c();
    }

    public final String me_() {
        if (this.f11305i == null) {
            this.f11305i = m11902j();
        }
        return this.f11305i;
    }

    protected String m11902j() {
        if (this.f11301e != null) {
            return this.f11301e.m11759j();
        }
        if (this.f11302f != null) {
            return this.f11300d.m11779j() + ":" + this.f11302f.analyticsString;
        }
        return this.f11300d.m11779j();
    }

    public final int m11903k() {
        if (this.f11301e == null) {
            return f11298b;
        }
        int i = f11298b;
        if (this.f11301e.m11762m() > 0) {
            return i | f11299c;
        }
        return i;
    }

    public String m11904l() {
        return null;
    }
}
