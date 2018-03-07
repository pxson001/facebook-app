package com.facebook.groups.feed.ui.contextual;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.SizeUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.runtime.base.DraculaRuntime;
import com.facebook.dracula.runtime.guava.DraculaImmutableList.0;
import com.facebook.dracula.runtime.iterator.DraculaFlatList;
import com.facebook.dracula.runtime.jdk.DraculaAbstractCollection.0.Dracula;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.groups.abtest.ExperimentsForGroupsExperimentationModule;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.groups.feed.ui.GroupsFeedIntentBuilder;
import com.facebook.groups.info.GroupInfoIntentBuilder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.Liveness;
import com.facebook.uicontrib.contextitem.ContextualItemPresenter;
import com.facebook.uicontrib.contextitem.PlutoniumContextualItemView;
import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ThreadViewLoader.startLoadThreadView */
public class GroupsContextItemPresenter implements ContextualItemPresenter<GroupsContextItemData> {
    private static GroupsContextItemPresenter f22410d;
    private static final Object f22411e = new Object();
    private SecureContextHelper f22412a;
    private GroupsFeedIntentBuilder f22413b;
    private GroupInfoIntentBuilder f22414c;

    /* compiled from: ThreadViewLoader.startLoadThreadView */
    public /* synthetic */ class C32581 {
        static final /* synthetic */ int[] f22406b = new int[GraphQLGroupVisibility.values().length];

        static {
            try {
                f22406b[GraphQLGroupVisibility.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22406b[GraphQLGroupVisibility.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f22406b[GraphQLGroupVisibility.SECRET.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            f22405a = new int[GroupsContextItemType.values().length];
            try {
                f22405a[GroupsContextItemType.PINNED_POST.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f22405a[GroupsContextItemType.FRIENDS_IN_GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f22405a[GroupsContextItemType.PRIVACY.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f22405a[GroupsContextItemType.ABOUT.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f22405a[GroupsContextItemType.UPCOMING_EVENT.ordinal()] = 5;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f22405a[GroupsContextItemType.PENDING_POST.ordinal()] = 6;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f22405a[GroupsContextItemType.YOUR_SALE_POSTS.ordinal()] = 7;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f22405a[GroupsContextItemType.MEMBER_REQUESTS.ordinal()] = 8;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f22405a[GroupsContextItemType.REPORTED_POST.ordinal()] = 9;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    /* compiled from: ThreadViewLoader.startLoadThreadView */
    public class GroupsContextItemData {
        public final FetchGroupInformationModel f22407a;
        public final GroupsContextItemType f22408b;
        public final boolean f22409c;

        public GroupsContextItemData(FetchGroupInformationModel fetchGroupInformationModel, GroupsContextItemType groupsContextItemType, boolean z) {
            this.f22407a = fetchGroupInformationModel;
            this.f22408b = groupsContextItemType;
            this.f22409c = z;
        }
    }

    /* compiled from: ThreadViewLoader.startLoadThreadView */
    public enum GroupsContextItemType {
        FRIENDS_IN_GROUP,
        ABOUT,
        PRIVACY,
        UPCOMING_EVENT,
        YOUR_SALE_POSTS,
        MEMBER_REQUESTS,
        PENDING_POST,
        REPORTED_POST,
        PINNED_POST
    }

    private static GroupsContextItemPresenter m23479b(InjectorLike injectorLike) {
        return new GroupsContextItemPresenter((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), GroupsFeedIntentBuilder.m23295a(injectorLike), GroupInfoIntentBuilder.m23667b(injectorLike));
    }

    public static GroupsContextItemPresenter m23478a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupsContextItemPresenter b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22411e) {
                GroupsContextItemPresenter groupsContextItemPresenter;
                if (a2 != null) {
                    groupsContextItemPresenter = (GroupsContextItemPresenter) a2.a(f22411e);
                } else {
                    groupsContextItemPresenter = f22410d;
                }
                if (groupsContextItemPresenter == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23479b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22411e, b3);
                        } else {
                            f22410d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupsContextItemPresenter;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public GroupsContextItemPresenter(SecureContextHelper secureContextHelper, GroupsFeedIntentBuilder groupsFeedIntentBuilder, GroupInfoIntentBuilder groupInfoIntentBuilder) {
        this.f22412a = secureContextHelper;
        this.f22413b = groupsFeedIntentBuilder;
        this.f22414c = groupInfoIntentBuilder;
    }

    public final boolean m23491a(PlutoniumContextualItemView plutoniumContextualItemView, GroupsContextItemData groupsContextItemData) {
        switch (groupsContextItemData.f22408b) {
            case PINNED_POST:
                return m23487i(plutoniumContextualItemView, groupsContextItemData);
            case FRIENDS_IN_GROUP:
                return m23488j(plutoniumContextualItemView, groupsContextItemData);
            case PRIVACY:
                return m23485g(plutoniumContextualItemView, groupsContextItemData);
            case ABOUT:
                return m23486h(plutoniumContextualItemView, groupsContextItemData);
            case UPCOMING_EVENT:
                return m23484f(plutoniumContextualItemView, groupsContextItemData);
            case PENDING_POST:
                return m23482d(plutoniumContextualItemView, groupsContextItemData);
            case YOUR_SALE_POSTS:
                return m23483e(plutoniumContextualItemView, groupsContextItemData);
            case MEMBER_REQUESTS:
                return m23481c(plutoniumContextualItemView, groupsContextItemData);
            case REPORTED_POST:
                return m23480b(plutoniumContextualItemView, groupsContextItemData);
            default:
                return false;
        }
    }

    private boolean m23480b(PlutoniumContextualItemView plutoniumContextualItemView, GroupsContextItemData groupsContextItemData) {
        boolean z;
        if (groupsContextItemData.f22407a != null) {
            DraculaReturnValue b = groupsContextItemData.f22407a.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            z = !DraculaRuntime.a(mutableFlatBuffer, i, null, 0);
        } else {
            z = false;
        }
        if (z) {
            b = groupsContextItemData.f22407a.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            z = !DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(i, 9), null, 0);
        } else {
            z = false;
        }
        if (z) {
            b = groupsContextItemData.f22407a.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            z = mutableFlatBuffer.j(mutableFlatBuffer.g(i, 9), 0) > 0;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        Resources resources = plutoniumContextualItemView.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(2131430084);
        i = resources.getDimensionPixelSize(2131427497);
        plutoniumContextualItemView.setMinimumHeight((i * 2) + dimensionPixelSize);
        plutoniumContextualItemView.a(dimensionPixelSize, i, i, 2130840627, "group_feed");
        plutoniumContextualItemView.a(resources.getString(2131237952), 2, SizeUtil.c(resources, 2131427402));
        b = groupsContextItemData.f22407a.b();
        mutableFlatBuffer = b.a;
        i = b.b;
        i2 = b.c;
        plutoniumContextualItemView.a(Integer.valueOf(mutableFlatBuffer.j(mutableFlatBuffer.g(i, 9), 0)));
        plutoniumContextualItemView.a(null, 3, SizeUtil.c(resources, 2131427400));
        m23489k(plutoniumContextualItemView, groupsContextItemData);
        return true;
    }

    private boolean m23481c(PlutoniumContextualItemView plutoniumContextualItemView, GroupsContextItemData groupsContextItemData) {
        boolean z;
        if (groupsContextItemData.f22407a != null) {
            DraculaReturnValue b = groupsContextItemData.f22407a.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            z = !DraculaRuntime.a(mutableFlatBuffer, i, null, 0);
        } else {
            z = false;
        }
        if (z) {
            b = groupsContextItemData.f22407a.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            z = !DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(i, 7), null, 0);
        } else {
            z = false;
        }
        if (z) {
            b = groupsContextItemData.f22407a.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            z = mutableFlatBuffer.j(mutableFlatBuffer.g(i, 7), 0) > 0;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        Resources resources = plutoniumContextualItemView.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(2131430084);
        i = resources.getDimensionPixelSize(2131427497);
        plutoniumContextualItemView.setMinimumHeight((i * 2) + dimensionPixelSize);
        plutoniumContextualItemView.a(dimensionPixelSize, i, i, 2130840627, "group_admin_cog_icon");
        plutoniumContextualItemView.a(resources.getString(2131237945), 2, SizeUtil.c(resources, 2131427402));
        b = groupsContextItemData.f22407a.b();
        mutableFlatBuffer = b.a;
        i = b.b;
        i2 = b.c;
        plutoniumContextualItemView.a(Integer.valueOf(mutableFlatBuffer.j(mutableFlatBuffer.g(i, 7), 0)));
        plutoniumContextualItemView.a(null, 3, SizeUtil.c(resources, 2131427400));
        m23489k(plutoniumContextualItemView, groupsContextItemData);
        return true;
    }

    private void m23489k(PlutoniumContextualItemView plutoniumContextualItemView, GroupsContextItemData groupsContextItemData) {
        boolean z;
        plutoniumContextualItemView.c = this;
        if (!groupsContextItemData.f22409c) {
            plutoniumContextualItemView.n = true;
            plutoniumContextualItemView.m = plutoniumContextualItemView.getResources().getDimensionPixelSize(2131430083);
        }
        switch (groupsContextItemData.f22408b) {
            case PINNED_POST:
            case FRIENDS_IN_GROUP:
            case ABOUT:
            case UPCOMING_EVENT:
            case PENDING_POST:
            case YOUR_SALE_POSTS:
            case MEMBER_REQUESTS:
            case REPORTED_POST:
                z = true;
                break;
            default:
                z = false;
                break;
        }
        plutoniumContextualItemView.a(z, groupsContextItemData);
    }

    private boolean m23482d(PlutoniumContextualItemView plutoniumContextualItemView, GroupsContextItemData groupsContextItemData) {
        boolean z;
        if (groupsContextItemData.f22407a != null) {
            DraculaReturnValue b = groupsContextItemData.f22407a.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            z = !DraculaRuntime.a(mutableFlatBuffer, i, null, 0);
        } else {
            z = false;
        }
        if (z) {
            b = groupsContextItemData.f22407a.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            z = !DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(i, 8), null, 0);
        } else {
            z = false;
        }
        if (z) {
            b = groupsContextItemData.f22407a.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            z = mutableFlatBuffer.j(mutableFlatBuffer.g(i, 8), 0) > 0;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        Resources resources = plutoniumContextualItemView.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(2131430084);
        i = resources.getDimensionPixelSize(2131427497);
        plutoniumContextualItemView.setMinimumHeight((i * 2) + dimensionPixelSize);
        plutoniumContextualItemView.a(dimensionPixelSize, i, i, 2130840627, "group_feed");
        plutoniumContextualItemView.a(resources.getString(2131237946), 2, SizeUtil.c(resources, 2131427402));
        b = groupsContextItemData.f22407a.b();
        mutableFlatBuffer = b.a;
        i = b.b;
        i2 = b.c;
        plutoniumContextualItemView.a(Integer.valueOf(mutableFlatBuffer.j(mutableFlatBuffer.g(i, 8), 0)));
        plutoniumContextualItemView.a(null, 3, SizeUtil.c(resources, 2131427400));
        m23489k(plutoniumContextualItemView, groupsContextItemData);
        return true;
    }

    private boolean m23483e(PlutoniumContextualItemView plutoniumContextualItemView, GroupsContextItemData groupsContextItemData) {
        boolean z;
        if (groupsContextItemData.f22407a != null) {
            DraculaReturnValue b = groupsContextItemData.f22407a.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            z = !DraculaRuntime.a(mutableFlatBuffer, i, null, 0);
        } else {
            z = false;
        }
        if (z) {
            b = groupsContextItemData.f22407a.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            z = !DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(i, 6), null, 0);
        } else {
            z = false;
        }
        if (z) {
            b = groupsContextItemData.f22407a.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            z = mutableFlatBuffer.j(mutableFlatBuffer.g(i, 6), 0) > 0;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        Resources resources = plutoniumContextualItemView.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(2131430084);
        i = resources.getDimensionPixelSize(2131427497);
        plutoniumContextualItemView.setMinimumHeight((i * 2) + dimensionPixelSize);
        plutoniumContextualItemView.a(dimensionPixelSize, i, i, 2130840750, "group_feed");
        plutoniumContextualItemView.a(resources.getString(2131237947), 2, SizeUtil.c(resources, 2131427402));
        b = groupsContextItemData.f22407a.b();
        mutableFlatBuffer = b.a;
        i = b.b;
        i2 = b.c;
        plutoniumContextualItemView.a(Integer.valueOf(mutableFlatBuffer.j(mutableFlatBuffer.g(i, 6), 0)));
        plutoniumContextualItemView.a(null, 3, SizeUtil.c(resources, 2131427400));
        m23489k(plutoniumContextualItemView, groupsContextItemData);
        return true;
    }

    private boolean m23484f(PlutoniumContextualItemView plutoniumContextualItemView, GroupsContextItemData groupsContextItemData) {
        boolean z;
        DraculaFlatList a;
        if (groupsContextItemData.f22407a != null) {
            DraculaReturnValue b = groupsContextItemData.f22407a.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            z = !DraculaRuntime.a(mutableFlatBuffer, i, null, 0);
        } else {
            z = false;
        }
        if (z) {
            b = groupsContextItemData.f22407a.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            z = !DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(i, 3), null, 0);
        } else {
            z = false;
        }
        if (z) {
            Dracula a2;
            b = groupsContextItemData.f22407a.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            a = DraculaFlatList.a(mutableFlatBuffer, mutableFlatBuffer.g(i, 3), 0, -1165862818);
            if (a != null) {
                a2 = 0.Dracula.a(a);
            } else {
                a2 = 0.Dracula.h();
            }
            z = !a2.a();
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        Resources resources = plutoniumContextualItemView.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(2131430084);
        i = resources.getDimensionPixelSize(2131427497);
        plutoniumContextualItemView.setMinimumHeight((i * 2) + dimensionPixelSize);
        plutoniumContextualItemView.a(dimensionPixelSize, i, i, 2130840628, "group_feed");
        b = groupsContextItemData.f22407a.b();
        mutableFlatBuffer = b.a;
        i = b.b;
        i2 = b.c;
        a = DraculaFlatList.a(mutableFlatBuffer, mutableFlatBuffer.g(i, 3), 0, -1165862818);
        b = (a != null ? 0.Dracula.a(a) : 0.Dracula.h()).a(0);
        mutableFlatBuffer = b.a;
        i = b.b;
        i2 = b.c;
        plutoniumContextualItemView.a(mutableFlatBuffer.k(i, 1), 2, SizeUtil.c(resources, 2131427402));
        plutoniumContextualItemView.a(mutableFlatBuffer.k(i, 2), 3, SizeUtil.c(resources, 2131427400));
        plutoniumContextualItemView.a(null);
        m23489k(plutoniumContextualItemView, groupsContextItemData);
        return true;
    }

    private boolean m23485g(PlutoniumContextualItemView plutoniumContextualItemView, GroupsContextItemData groupsContextItemData) {
        MutableFlatBuffer mutableFlatBuffer;
        int i;
        int i2;
        boolean z;
        if (groupsContextItemData.f22407a != null) {
            DraculaReturnValue b = groupsContextItemData.f22407a.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            if (DraculaRuntime.a(mutableFlatBuffer, i, null, 0)) {
                z = false;
            } else {
                i2 = 1;
            }
        } else {
            z = false;
        }
        if (i2 != 0) {
            b = groupsContextItemData.f22407a.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            if (mutableFlatBuffer.f(i, 17, GraphQLGroupVisibility.class) != null) {
                i2 = 1;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (i2 == 0) {
            return false;
        }
        String string;
        Resources resources = plutoniumContextualItemView.getResources();
        b = groupsContextItemData.f22407a.b();
        mutableFlatBuffer = b.a;
        i = b.b;
        i2 = b.c;
        String string2;
        Object obj;
        switch (C32581.f22406b[((GraphQLGroupVisibility) mutableFlatBuffer.f(i, 17, GraphQLGroupVisibility.class)).ordinal()]) {
            case 1:
                b = groupsContextItemData.f22407a.b();
                mutableFlatBuffer = b.a;
                i = b.b;
                i2 = b.c;
                if (!DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(i, 14), null, 0)) {
                    b = groupsContextItemData.f22407a.b();
                    mutableFlatBuffer = b.a;
                    i = b.b;
                    i2 = b.c;
                    if (mutableFlatBuffer.k(mutableFlatBuffer.g(i, 14), 1) == null) {
                        string2 = resources.getString(2131237963);
                        string = resources.getString(2131237968);
                        obj = string2;
                        break;
                    }
                    b = groupsContextItemData.f22407a.b();
                    mutableFlatBuffer = b.a;
                    i = b.b;
                    i2 = b.c;
                    string2 = resources.getString(2131237964, new Object[]{mutableFlatBuffer.k(mutableFlatBuffer.g(i, 14), 1)});
                    b = groupsContextItemData.f22407a.b();
                    MutableFlatBuffer mutableFlatBuffer2 = b.a;
                    int i3 = b.b;
                    i2 = b.c;
                    string = resources.getString(2131237969, new Object[]{mutableFlatBuffer2.k(mutableFlatBuffer2.g(i3, 14), 1)});
                    obj = string2;
                    break;
                }
                string2 = resources.getString(2131237962);
                string = resources.getString(2131237968);
                obj = string2;
                break;
            case 2:
                string2 = resources.getString(2131237961);
                string = resources.getString(2131237967);
                obj = string2;
                break;
            case 3:
                string2 = resources.getString(2131237965);
                string = resources.getString(2131237966);
                obj = string2;
                break;
            default:
                string = null;
                CharSequence charSequence = null;
                break;
        }
        if (charSequence == null || string == null) {
            return false;
        }
        int dimensionPixelSize = resources.getDimensionPixelSize(2131430084);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(2131427497);
        plutoniumContextualItemView.setMinimumHeight((dimensionPixelSize2 * 2) + dimensionPixelSize);
        plutoniumContextualItemView.a(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2, 2130840632, "group_feed");
        plutoniumContextualItemView.a(charSequence, 2, SizeUtil.c(resources, 2131427402));
        plutoniumContextualItemView.a(string, 3, SizeUtil.c(resources, 2131427400));
        plutoniumContextualItemView.a(null);
        m23489k(plutoniumContextualItemView, groupsContextItemData);
        return true;
    }

    private boolean m23486h(PlutoniumContextualItemView plutoniumContextualItemView, GroupsContextItemData groupsContextItemData) {
        boolean z;
        boolean z2;
        if (groupsContextItemData.f22407a != null) {
            DraculaReturnValue b = groupsContextItemData.f22407a.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            z = !Strings.isNullOrEmpty(mutableFlatBuffer.k(i, 2));
        } else {
            z = false;
        }
        if (groupsContextItemData.f22407a == null || groupsContextItemData.f22407a.x() == null || groupsContextItemData.f22407a.x().j() == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z && !z2) {
            return false;
        }
        CharSequence k;
        Resources resources = plutoniumContextualItemView.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(2131430084);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(2131427497);
        plutoniumContextualItemView.setMinimumHeight((dimensionPixelSize2 * 2) + dimensionPixelSize);
        if (z) {
            b = groupsContextItemData.f22407a.b();
            MutableFlatBuffer mutableFlatBuffer2 = b.a;
            int i3 = b.b;
            i2 = b.c;
            k = mutableFlatBuffer2.k(i3, 2);
        } else if (z2) {
            Object string = resources.getString(2131237948);
        } else {
            k = null;
        }
        plutoniumContextualItemView.a(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2, 2130840630, "group_feed");
        plutoniumContextualItemView.a(k, 2, SizeUtil.c(resources, 2131427402));
        plutoniumContextualItemView.a(null, 3, SizeUtil.c(resources, 2131427400));
        plutoniumContextualItemView.a(null);
        m23489k(plutoniumContextualItemView, groupsContextItemData);
        return true;
    }

    private boolean m23487i(PlutoniumContextualItemView plutoniumContextualItemView, GroupsContextItemData groupsContextItemData) {
        if (groupsContextItemData.f22407a == null || groupsContextItemData.f22407a.s() == null || groupsContextItemData.f22407a.s().a() <= 0) {
            return false;
        }
        Resources resources = plutoniumContextualItemView.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(2131430084);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(2131427497);
        plutoniumContextualItemView.setMinimumHeight((dimensionPixelSize2 * 2) + dimensionPixelSize);
        plutoniumContextualItemView.a(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2, 2130840631, "group_feed");
        plutoniumContextualItemView.a(resources.getString(2131237959), 2, SizeUtil.c(resources, 2131427402));
        plutoniumContextualItemView.a(null, 3, SizeUtil.c(resources, 2131427400));
        plutoniumContextualItemView.a(null);
        m23489k(plutoniumContextualItemView, groupsContextItemData);
        return true;
    }

    private boolean m23488j(PlutoniumContextualItemView plutoniumContextualItemView, GroupsContextItemData groupsContextItemData) {
        Object obj;
        if (groupsContextItemData.f22407a != null) {
            DraculaReturnValue b = groupsContextItemData.f22407a.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            obj = !DraculaRuntime.a(mutableFlatBuffer, i, null, 0) ? 1 : null;
        } else {
            obj = null;
        }
        if (obj != null) {
            b = groupsContextItemData.f22407a.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            obj = !DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(i, 4), null, 0) ? 1 : null;
        } else {
            obj = null;
        }
        if (obj != null) {
            b = groupsContextItemData.f22407a.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            obj = mutableFlatBuffer.j(i, 5) > 0 ? 1 : null;
        } else {
            obj = null;
        }
        if (obj == null) {
            return false;
        }
        List arrayList = new ArrayList();
        int i3 = 0;
        b = groupsContextItemData.f22407a.b();
        mutableFlatBuffer = b.a;
        i = b.b;
        i2 = b.c;
        DraculaFlatList a = DraculaFlatList.a(mutableFlatBuffer, mutableFlatBuffer.g(i, 4), 1, -1760113995);
        Dracula a2 = a != null ? 0.Dracula.a(a) : 0.Dracula.h();
        int c = a2.c();
        i = 0;
        while (i < c) {
            DraculaReturnValue a3 = a2.a(i);
            MutableFlatBuffer mutableFlatBuffer2 = a3.a;
            int i4 = a3.b;
            int i5 = a3.c;
            if (mutableFlatBuffer2.h(i4, 0) && mutableFlatBuffer2.k(i4, 1) != null) {
                if (i3 > 3) {
                    break;
                }
                arrayList.add(mutableFlatBuffer2.k(i4, 1));
                i5 = i3 + 1;
            } else {
                i5 = i3;
            }
            i++;
            i3 = i5;
        }
        if (i3 == 0) {
            return false;
        }
        String k;
        b = groupsContextItemData.f22407a.b();
        mutableFlatBuffer = b.a;
        c = b.b;
        i2 = b.c;
        a = DraculaFlatList.a(mutableFlatBuffer, mutableFlatBuffer.g(c, 4), 1, -1760113995);
        a2 = a != null ? 0.Dracula.a(a) : 0.Dracula.h();
        int c2 = a2.c();
        for (c = 0; c < c2; c++) {
            a3 = a2.a(c);
            MutableFlatBuffer mutableFlatBuffer3 = a3.a;
            int i6 = a3.b;
            i5 = a3.c;
            Object obj2 = mutableFlatBuffer3.h(i6, 0) ? !DraculaRuntime.a(mutableFlatBuffer3, mutableFlatBuffer3.g(i6, 2), null, 0) ? 1 : null : null;
            obj2 = obj2 != null ? mutableFlatBuffer3.k(mutableFlatBuffer3.g(i6, 2), 0) != null ? 1 : null : null;
            if (obj2 != null) {
                k = mutableFlatBuffer3.k(mutableFlatBuffer3.g(i6, 2), 0);
                break;
            }
        }
        k = null;
        Resources resources = plutoniumContextualItemView.getResources();
        i5 = resources.getDimensionPixelSize(2131430084);
        i = resources.getDimensionPixelSize(2131427497);
        plutoniumContextualItemView.setMinimumHeight((i * 2) + i5);
        if (k != null) {
            plutoniumContextualItemView.a(i5, 0, 0, Uri.parse(k), "group_feed");
        } else {
            plutoniumContextualItemView.a(i5, i, i, 2130840629, "group_feed");
        }
        CharSequence charSequence = "";
        if (i3 > 3) {
            b = groupsContextItemData.f22407a.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            charSequence = resources.getString(2131237956, new Object[]{arrayList.get(0), arrayList.get(1), Integer.valueOf(mutableFlatBuffer.j(i, 5) - 2)});
        } else if (i3 == 3) {
            charSequence = resources.getString(2131237955, new Object[]{arrayList.get(0), arrayList.get(1), Integer.valueOf(1)});
        } else if (i3 == 2) {
            charSequence = resources.getString(2131237954, new Object[]{arrayList.get(0), arrayList.get(1)});
        } else if (i3 == 1) {
            charSequence = resources.getString(2131237953, new Object[]{arrayList.get(0)});
        }
        plutoniumContextualItemView.a(charSequence, 2, SizeUtil.c(resources, 2131427402));
        plutoniumContextualItemView.a(null, 3, SizeUtil.c(resources, 2131427400));
        plutoniumContextualItemView.a(null);
        m23489k(plutoniumContextualItemView, groupsContextItemData);
        return true;
    }

    public final void m23490a(PlutoniumContextualItemView plutoniumContextualItemView) {
    }

    public final void m23492b(PlutoniumContextualItemView plutoniumContextualItemView) {
        int i = 1;
        Object tag = plutoniumContextualItemView.getTag();
        if (tag instanceof GroupsContextItemData) {
            GroupsContextItemData groupsContextItemData = (GroupsContextItemData) tag;
            String formatStrLocaleSafe;
            Intent intent;
            switch (groupsContextItemData.f22408b) {
                case PINNED_POST:
                    this.f22412a.a(this.f22413b.m23297a(groupsContextItemData.f22407a), plutoniumContextualItemView.getContext());
                    return;
                case FRIENDS_IN_GROUP:
                    formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("https://m.facebook.com/groups/%s?view=members", groupsContextItemData.f22407a.gW_());
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, Uri.encode(formatStrLocaleSafe))));
                    this.f22412a.a(intent, plutoniumContextualItemView.getContext());
                    return;
                case ABOUT:
                    this.f22412a.a(this.f22414c.m23672b(groupsContextItemData.f22407a), plutoniumContextualItemView.getContext());
                    return;
                case UPCOMING_EVENT:
                    DraculaReturnValue b;
                    MutableFlatBuffer mutableFlatBuffer;
                    int i2;
                    int i3;
                    DraculaFlatList a;
                    if (groupsContextItemData.f22407a != null) {
                        b = groupsContextItemData.f22407a.b();
                        mutableFlatBuffer = b.a;
                        i2 = b.b;
                        i3 = b.c;
                        i3 = !DraculaRuntime.a(mutableFlatBuffer, i2, null, 0) ? 1 : 0;
                    } else {
                        i3 = 0;
                    }
                    if (i3 != 0) {
                        b = groupsContextItemData.f22407a.b();
                        mutableFlatBuffer = b.a;
                        i2 = b.b;
                        i3 = b.c;
                        i3 = !DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(i2, 3), null, 0) ? 1 : 0;
                    } else {
                        i3 = 0;
                    }
                    if (i3 != 0) {
                        b = groupsContextItemData.f22407a.b();
                        mutableFlatBuffer = b.a;
                        i2 = b.b;
                        i3 = b.c;
                        a = DraculaFlatList.a(mutableFlatBuffer, mutableFlatBuffer.g(i2, 3), 0, -1165862818);
                        i3 = !(a != null ? 0.Dracula.a(a) : 0.Dracula.h()).a() ? 1 : 0;
                    } else {
                        i3 = 0;
                    }
                    if (i3 != 0) {
                        b = groupsContextItemData.f22407a.b();
                        mutableFlatBuffer = b.a;
                        i2 = b.b;
                        i3 = b.c;
                        a = DraculaFlatList.a(mutableFlatBuffer, mutableFlatBuffer.g(i2, 3), 0, -1165862818);
                        b = (a != null ? 0.Dracula.a(a) : 0.Dracula.h()).a(0);
                        mutableFlatBuffer = b.a;
                        i2 = b.b;
                        i3 = b.c;
                        i3 = !DraculaRuntime.a(mutableFlatBuffer, i2, null, 0) ? 1 : 0;
                    } else {
                        i3 = 0;
                    }
                    if (i3 != 0) {
                        0.Dracula a2;
                        b = groupsContextItemData.f22407a.b();
                        mutableFlatBuffer = b.a;
                        i2 = b.b;
                        i3 = b.c;
                        a = DraculaFlatList.a(mutableFlatBuffer, mutableFlatBuffer.g(i2, 3), 0, -1165862818);
                        if (a != null) {
                            a2 = 0.Dracula.a(a);
                        } else {
                            a2 = 0.Dracula.h();
                        }
                        b = a2.a(0);
                        mutableFlatBuffer = b.a;
                        i2 = b.b;
                        i3 = b.c;
                        if (mutableFlatBuffer.k(i2, 3) == null) {
                            i = 0;
                        }
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        intent = new Intent("android.intent.action.VIEW");
                        DraculaReturnValue b2 = groupsContextItemData.f22407a.b();
                        MutableFlatBuffer mutableFlatBuffer2 = b2.a;
                        int i4 = b2.b;
                        int i5 = b2.c;
                        DraculaFlatList a3 = DraculaFlatList.a(mutableFlatBuffer2, mutableFlatBuffer2.g(i4, 3), 0, -1165862818);
                        b2 = (a3 != null ? 0.Dracula.a(a3) : 0.Dracula.h()).a(0);
                        mutableFlatBuffer2 = b2.a;
                        int i6 = b2.b;
                        i5 = b2.c;
                        intent.setData(Uri.parse(StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, Uri.encode(mutableFlatBuffer2.k(i6, 3)))));
                        this.f22412a.a(intent, plutoniumContextualItemView.getContext());
                        return;
                    }
                    return;
                case PENDING_POST:
                    this.f22412a.a(this.f22413b.m23301e(groupsContextItemData.f22407a), plutoniumContextualItemView.getContext());
                    return;
                case YOUR_SALE_POSTS:
                    this.f22412a.a(this.f22413b.m23298b(groupsContextItemData.f22407a), plutoniumContextualItemView.getContext());
                    return;
                case MEMBER_REQUESTS:
                    this.f22412a.a(this.f22413b.m23300d(groupsContextItemData.f22407a), plutoniumContextualItemView.getContext());
                    return;
                case REPORTED_POST:
                    Intent component;
                    SecureContextHelper secureContextHelper = this.f22412a;
                    GroupInfoIntentBuilder groupInfoIntentBuilder = this.f22414c;
                    formatStrLocaleSafe = groupsContextItemData.f22407a.gW_();
                    String str = "https://m.facebook.com/groups/%s/madminpanel/reported/";
                    if (groupInfoIntentBuilder.f22712b.a(Liveness.Live, ExperimentsForGroupsExperimentationModule.a, false) && ((Boolean) groupInfoIntentBuilder.f22711a.get()).booleanValue()) {
                        component = new Intent().setComponent((ComponentName) groupInfoIntentBuilder.f22714d.get());
                        component.putExtra("group_feed_id", formatStrLocaleSafe);
                        component.putExtra("target_fragment", ContentFragmentType.GROUP_REACT_REPORTED_POSTS_FRAGMENT.ordinal());
                    } else {
                        String formatStrLocaleSafe2 = StringFormatUtil.formatStrLocaleSafe(str, formatStrLocaleSafe);
                        component = new Intent("android.intent.action.VIEW");
                        component.setData(Uri.parse(StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, Uri.encode(formatStrLocaleSafe2))));
                    }
                    secureContextHelper.a(component, plutoniumContextualItemView.getContext());
                    return;
                default:
                    return;
            }
        }
    }
}
