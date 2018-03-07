package com.facebook.groups.feed.ui.contextual;

import android.view.View;
import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.runtime.base.DraculaRuntime;
import com.facebook.dracula.runtime.guava.DraculaImmutableList.0.Dracula;
import com.facebook.dracula.runtime.iterator.DraculaFlatList;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.groupcommerce.util.GroupCommerceComposerHelper;
import com.facebook.groups.feed.data.ViewerStatusCache;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.groups.feed.ui.GroupsPlutoniumHeaderAdapterRows;
import com.facebook.groups.feed.ui.contextual.GroupsContextItemPresenter.GroupsContextItemData;
import com.facebook.groups.feed.ui.contextual.GroupsContextItemPresenter.GroupsContextItemType;
import com.facebook.groups.protocol.GroupInformationInterfaceFactory;
import com.facebook.groups.staticadapter.StaticAdapter.AbstractSection;
import com.facebook.groups.staticadapter.StaticAdapter.Section;
import com.facebook.uicontrib.contextitem.PlutoniumContextualItemView;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: ThreadViewLoader.loadThread */
public class GroupsContextItemsHelper {
    public final ViewerStatusCache f22418a;
    public FetchGroupInformationModel f22419b;
    public final Provider<GroupsContextItemPresenter> f22420c;
    public final List<GroupsContextItemType> f22421d = new ArrayList();

    @Inject
    public GroupsContextItemsHelper(Provider<GroupsContextItemPresenter> provider, ViewerStatusCache viewerStatusCache) {
        this.f22420c = provider;
        this.f22418a = viewerStatusCache;
    }

    public final List<Section<PlutoniumContextualItemView>> m23500a(FetchGroupInformationModel fetchGroupInformationModel) {
        this.f22419b = fetchGroupInformationModel;
        this.f22421d.clear();
        m23494b();
        List<Section<PlutoniumContextualItemView>> arrayList = new ArrayList();
        for (int i = 0; i < this.f22421d.size(); i++) {
            boolean z;
            if (i == this.f22421d.size() - 1) {
                z = true;
            } else {
                z = false;
            }
            final Boolean valueOf = Boolean.valueOf(z);
            arrayList.add(new AbstractSection<PlutoniumContextualItemView>(this, GroupsPlutoniumHeaderAdapterRows.f22373b) {
                final /* synthetic */ GroupsContextItemsHelper f22417c;

                public final void mo11a(View view) {
                    ((GroupsContextItemPresenter) this.f22417c.f22420c.get()).m23491a((PlutoniumContextualItemView) view, new GroupsContextItemData(this.f22417c.f22419b, (GroupsContextItemType) this.f22417c.f22421d.get(i), valueOf.booleanValue()));
                }
            });
        }
        return arrayList;
    }

    private void m23494b() {
        Object obj;
        Object obj2 = null;
        if (this.f22418a == null || this.f22419b == null || !this.f22418a.b(this.f22419b.gW_())) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            DraculaReturnValue b;
            MutableFlatBuffer mutableFlatBuffer;
            int i;
            int i2;
            if (this.f22419b != null) {
                DraculaReturnValue b2 = this.f22419b.b();
                MutableFlatBuffer mutableFlatBuffer2 = b2.a;
                int i3 = b2.b;
                int i4 = b2.c;
                if (mutableFlatBuffer2.j(i3, 5) > 0) {
                    obj2 = 1;
                }
            }
            if (obj2 != null) {
                this.f22421d.add(GroupsContextItemType.FRIENDS_IN_GROUP);
            }
            this.f22421d.add(GroupsContextItemType.PRIVACY);
            int i5 = 0;
            if (this.f22419b != null) {
                b = this.f22419b.b();
                mutableFlatBuffer = b.a;
                i = b.b;
                i2 = b.c;
                i2 = !DraculaRuntime.a(mutableFlatBuffer, i, null, 0) ? 1 : 0;
            } else {
                i2 = 0;
            }
            if (i2 != 0) {
                b = this.f22419b.b();
                mutableFlatBuffer = b.a;
                i = b.b;
                i2 = b.c;
                if (!(mutableFlatBuffer.k(i, 2) == null && (this.f22419b.x() == null || this.f22419b.x().j() == null))) {
                    i5 = 1;
                }
            }
            if (i5 != 0) {
                this.f22421d.add(GroupsContextItemType.ABOUT);
            }
        } else {
            if (m23495d()) {
                this.f22421d.add(GroupsContextItemType.UPCOMING_EVENT);
            }
            if (m23496f()) {
                this.f22421d.add(GroupsContextItemType.REPORTED_POST);
            }
            if (m23497g()) {
                this.f22421d.add(GroupsContextItemType.MEMBER_REQUESTS);
            }
            if (m23498h()) {
                this.f22421d.add(GroupsContextItemType.PENDING_POST);
            }
            if (m23499i()) {
                this.f22421d.add(GroupsContextItemType.YOUR_SALE_POSTS);
            }
        }
        if (this.f22419b == null || this.f22419b.s() == null || this.f22419b.s().a() <= 0) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            this.f22421d.add(GroupsContextItemType.PINNED_POST);
        }
    }

    private boolean m23495d() {
        boolean z;
        if (this.f22419b != null) {
            DraculaReturnValue b = this.f22419b.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            z = !DraculaRuntime.a(mutableFlatBuffer, i, null, 0);
        } else {
            z = false;
        }
        if (z) {
            b = this.f22419b.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            z = !DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(i, 3), null, 0);
        } else {
            z = false;
        }
        if (z) {
            b = this.f22419b.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            DraculaFlatList a = DraculaFlatList.a(mutableFlatBuffer, mutableFlatBuffer.g(i, 3), 0, -1165862818);
            z = (a != null ? Dracula.a(a) : Dracula.h()) != null;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        b = this.f22419b.b();
        mutableFlatBuffer = b.a;
        i = b.b;
        i2 = b.c;
        a = DraculaFlatList.a(mutableFlatBuffer, mutableFlatBuffer.g(i, 3), 0, -1165862818);
        return !(a != null ? Dracula.a(a) : Dracula.h()).a();
    }

    private boolean m23496f() {
        boolean z;
        if (this.f22419b != null) {
            DraculaReturnValue b = this.f22419b.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            z = !DraculaRuntime.a(mutableFlatBuffer, i, null, 0);
        } else {
            z = false;
        }
        if (z) {
            b = this.f22419b.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            z = !DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(i, 9), null, 0);
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        b = this.f22419b.b();
        mutableFlatBuffer = b.a;
        i = b.b;
        i2 = b.c;
        return mutableFlatBuffer.j(mutableFlatBuffer.g(i, 9), 0) > 0;
    }

    private boolean m23497g() {
        boolean z;
        if (this.f22419b != null) {
            DraculaReturnValue b = this.f22419b.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            z = !DraculaRuntime.a(mutableFlatBuffer, i, null, 0);
        } else {
            z = false;
        }
        if (z) {
            b = this.f22419b.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            z = !DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(i, 7), null, 0);
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        b = this.f22419b.b();
        mutableFlatBuffer = b.a;
        i = b.b;
        i2 = b.c;
        return mutableFlatBuffer.j(mutableFlatBuffer.g(i, 7), 0) > 0;
    }

    private boolean m23498h() {
        boolean z;
        if (this.f22419b != null) {
            DraculaReturnValue b = this.f22419b.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            z = !DraculaRuntime.a(mutableFlatBuffer, i, null, 0);
        } else {
            z = false;
        }
        if (z) {
            b = this.f22419b.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            z = !DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(i, 8), null, 0);
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        b = this.f22419b.b();
        mutableFlatBuffer = b.a;
        i = b.b;
        i2 = b.c;
        return mutableFlatBuffer.j(mutableFlatBuffer.g(i, 8), 0) > 0;
    }

    private boolean m23499i() {
        boolean z;
        if (this.f22419b != null) {
            DraculaReturnValue b = this.f22419b.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            z = !DraculaRuntime.a(mutableFlatBuffer, i, null, 0);
        } else {
            z = false;
        }
        if (!z || GroupCommerceComposerHelper.a(GroupInformationInterfaceFactory.a(this.f22419b))) {
            z = false;
        } else {
            b = this.f22419b.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            z = !DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(i, 6), null, 0);
        }
        if (!z) {
            return false;
        }
        b = this.f22419b.b();
        mutableFlatBuffer = b.a;
        i = b.b;
        i2 = b.c;
        return mutableFlatBuffer.j(mutableFlatBuffer.g(i, 6), 0) > 0;
    }
}
