package com.facebook.groups.feed.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.locale.Locales;
import com.facebook.common.util.ContextUtils;
import com.facebook.composer.gating.ComposerGatekeepers;
import com.facebook.debug.log.BLog;
import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.runtime.base.DraculaRuntime;
import com.facebook.feed.util.composer.sprout.InlineComposerSproutFragment;
import com.facebook.feed.util.composer.sprout.SproutAnalyticsLogger.SproutSource;
import com.facebook.feed.util.composer.sprout.SproutSpec;
import com.facebook.feed.util.composer.sprout.SproutSpec.Builder;
import com.facebook.feed.util.composer.sprout.header.GroupsInlineComposerSproutHeaderControllerProvider;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.groupcommerce.util.GroupCommerceComposerHelper;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.groups.protocol.GroupInformationInterfaceFactory;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: TimelineFragment */
public class GroupsComposerSproutLauncher {
    public static final ImmutableList<Fab> f22096a = ImmutableList.of(Fab.POST, Fab.SELL, Fab.MORE);
    public static final ImmutableList<Fab> f22097b = ImmutableList.of(Fab.SELL, Fab.POST, Fab.MORE);
    public static final ImmutableList<Fab> f22098c = ImmutableList.of(Fab.ALBUM, Fab.EVENT, Fab.CHAT);
    private static final String f22099d = GroupsComposerSproutLauncher.class.getSimpleName();
    public final Locales f22100e;
    public final ComposerLauncher f22101f;
    public final Resources f22102g;
    private final FragmentManager f22103h;
    public final Activity f22104i;
    private final SproutSource f22105j;
    private final GroupsInlineComposerSproutHeaderControllerProvider f22106k;
    public final FetchGroupInformationModel f22107l;
    public final GatekeeperStoreImpl f22108m;
    public final GroupsInlineComposerActionOptionController f22109n;
    private final String f22110o = SafeUUIDGenerator.a().toString();
    public String f22111p;

    /* compiled from: TimelineFragment */
    class C31711 implements Runnable {
        final /* synthetic */ GroupsComposerSproutLauncher f22090a;

        C31711(GroupsComposerSproutLauncher groupsComposerSproutLauncher) {
            this.f22090a = groupsComposerSproutLauncher;
        }

        public void run() {
            ComposerLauncher composerLauncher = this.f22090a.f22101f;
            GroupsComposerSproutLauncher groupsComposerSproutLauncher = this.f22090a;
            composerLauncher.a(null, GroupCommerceComposerHelper.a(GroupInformationInterfaceFactory.a(groupsComposerSproutLauncher.f22107l), groupsComposerSproutLauncher.f22108m.a(ComposerGatekeepers.f), groupsComposerSproutLauncher.f22100e).a(), 1756, (Activity) ContextUtils.a(this.f22090a.f22104i, Activity.class));
        }
    }

    /* compiled from: TimelineFragment */
    class C31722 implements Runnable {
        final /* synthetic */ GroupsComposerSproutLauncher f22091a;

        C31722(GroupsComposerSproutLauncher groupsComposerSproutLauncher) {
            this.f22091a = groupsComposerSproutLauncher;
        }

        public void run() {
            this.f22091a.f22101f.a(null, GroupCommerceComposerHelper.a(GroupInformationInterfaceFactory.a(this.f22091a.f22107l), this.f22091a.f22100e).a(), 1756, (Activity) ContextUtils.a(this.f22091a.f22104i, Activity.class));
        }
    }

    /* compiled from: TimelineFragment */
    public class C31733 implements Runnable {
        final /* synthetic */ GroupsComposerSproutLauncher f22092a;

        public C31733(GroupsComposerSproutLauncher groupsComposerSproutLauncher) {
            this.f22092a = groupsComposerSproutLauncher;
        }

        public void run() {
            this.f22092a.m23219b(this.f22092a.f22111p, 2131238047, 0);
        }
    }

    /* compiled from: TimelineFragment */
    public class C31744 implements Runnable {
        final /* synthetic */ GroupsComposerSproutLauncher f22093a;

        public C31744(GroupsComposerSproutLauncher groupsComposerSproutLauncher) {
            this.f22093a = groupsComposerSproutLauncher;
        }

        public void run() {
            GroupsInlineComposerActionOptionController groupsInlineComposerActionOptionController = this.f22093a.f22109n;
            GroupsInlineComposerActionOptionController.m23346a(this.f22093a.f22107l.gW_(), (Activity) ContextUtils.a(this.f22093a.f22104i, Activity.class));
        }
    }

    /* compiled from: TimelineFragment */
    public class C31755 implements Runnable {
        final /* synthetic */ GroupsComposerSproutLauncher f22094a;

        public C31755(GroupsComposerSproutLauncher groupsComposerSproutLauncher) {
            this.f22094a = groupsComposerSproutLauncher;
        }

        public void run() {
            String str;
            DraculaReturnValue b = this.f22094a.f22107l.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            b = this.f22094a.f22107l.b();
            MutableFlatBuffer mutableFlatBuffer2 = b.a;
            int i3 = b.b;
            i2 = b.c;
            b = this.f22094a.f22107l.b();
            MutableFlatBuffer mutableFlatBuffer3 = b.a;
            int i4 = b.b;
            i2 = b.c;
            if (DraculaRuntime.a(mutableFlatBuffer3, mutableFlatBuffer3.g(i4, 14), null, 0)) {
                str = null;
            } else {
                DraculaReturnValue b2 = this.f22094a.f22107l.b();
                MutableFlatBuffer mutableFlatBuffer4 = b2.a;
                int i5 = b2.b;
                int i6 = b2.c;
                str = mutableFlatBuffer4.k(mutableFlatBuffer4.g(i5, 14), 1);
            }
            GroupsInlineComposerActionOptionController groupsInlineComposerActionOptionController = this.f22094a.f22109n;
            GroupsInlineComposerActionOptionController.m23348a(this.f22094a.f22107l.gW_(), mutableFlatBuffer.k(i, 13), (GraphQLGroupVisibility) mutableFlatBuffer2.f(i3, 17, GraphQLGroupVisibility.class), str, this.f22094a.f22104i);
        }
    }

    /* compiled from: TimelineFragment */
    public class C31766 implements Runnable {
        final /* synthetic */ GroupsComposerSproutLauncher f22095a;

        public C31766(GroupsComposerSproutLauncher groupsComposerSproutLauncher) {
            this.f22095a = groupsComposerSproutLauncher;
        }

        public void run() {
            GroupsInlineComposerActionOptionController groupsInlineComposerActionOptionController = this.f22095a.f22109n;
            GroupsInlineComposerActionOptionController.m23347a(this.f22095a.f22107l.gW_(), this.f22095a.f22104i);
        }
    }

    /* compiled from: TimelineFragment */
    public enum Fab {
        POST {
            final SproutSpec getSpec(GroupsComposerSproutLauncher groupsComposerSproutLauncher, String str) {
                return GroupsComposerSproutLauncher.m23215c(groupsComposerSproutLauncher, str);
            }
        },
        SELL {
            final SproutSpec getSpec(GroupsComposerSproutLauncher groupsComposerSproutLauncher, String str) {
                return GroupsComposerSproutLauncher.m23217d(groupsComposerSproutLauncher, str);
            }
        },
        MORE {
            final SproutSpec getSpec(GroupsComposerSproutLauncher groupsComposerSproutLauncher, String str) {
                Builder a = SproutSpec.a(2131363540, 2130839668, groupsComposerSproutLauncher.f22102g.getString(2131237982), "more", new C31733(groupsComposerSproutLauncher));
                a.i = true;
                return a.a();
            }
        },
        ALBUM {
            final SproutSpec getSpec(GroupsComposerSproutLauncher groupsComposerSproutLauncher, String str) {
                return SproutSpec.a(2131363541, 2130840020, groupsComposerSproutLauncher.f22102g.getString(2131238062), "album", new C31744(groupsComposerSproutLauncher)).a();
            }
        },
        EVENT {
            final SproutSpec getSpec(GroupsComposerSproutLauncher groupsComposerSproutLauncher, String str) {
                Builder a = SproutSpec.a(2131363542, 2130839847, groupsComposerSproutLauncher.f22102g.getString(2131238059), "event", new C31755(groupsComposerSproutLauncher));
                a.i = true;
                return a.a();
            }
        },
        CHAT {
            final SproutSpec getSpec(GroupsComposerSproutLauncher groupsComposerSproutLauncher, String str) {
                Builder a = SproutSpec.a(2131363543, 2130839686, groupsComposerSproutLauncher.f22102g.getString(2131238060), "chat", new C31766(groupsComposerSproutLauncher));
                a.i = true;
                return a.a();
            }
        };

        public abstract SproutSpec getSpec(GroupsComposerSproutLauncher groupsComposerSproutLauncher, String str);

        public static Fab fromString(String str) {
            for (Fab fab : values()) {
                if (fab.name().equalsIgnoreCase(str)) {
                    return fab;
                }
            }
            return null;
        }
    }

    @Inject
    public GroupsComposerSproutLauncher(Resources resources, GroupsInlineComposerSproutHeaderControllerProvider groupsInlineComposerSproutHeaderControllerProvider, ComposerLauncher composerLauncher, Locales locales, GatekeeperStoreImpl gatekeeperStoreImpl, GroupsInlineComposerActionOptionController groupsInlineComposerActionOptionController, @Assisted SproutSource sproutSource, @Assisted FragmentManager fragmentManager, @Assisted Activity activity, @Assisted FetchGroupInformationModel fetchGroupInformationModel) {
        this.f22102g = resources;
        this.f22106k = groupsInlineComposerSproutHeaderControllerProvider;
        this.f22105j = sproutSource;
        this.f22100e = locales;
        this.f22108m = gatekeeperStoreImpl;
        this.f22109n = groupsInlineComposerActionOptionController;
        this.f22101f = composerLauncher;
        this.f22103h = fragmentManager;
        this.f22104i = activity;
        this.f22107l = fetchGroupInformationModel;
    }

    public final void m23218a(String str, int i, int i2) {
        ImmutableList immutableList;
        this.f22111p = str;
        String str2 = this.f22110o;
        ImmutableList.Builder builder = ImmutableList.builder();
        if (GroupCommerceComposerHelper.a(GroupInformationInterfaceFactory.a(this.f22107l))) {
            immutableList = f22097b;
        } else {
            immutableList = f22096a;
        }
        ImmutableList immutableList2 = immutableList;
        int size = immutableList2.size();
        for (int i3 = 0; i3 < size; i3++) {
            builder.c(((Fab) immutableList2.get(i3)).getSpec(this, str2));
        }
        m23213a(str, i, i2, builder.b());
    }

    public final void m23219b(String str, int i, int i2) {
        String str2 = this.f22110o;
        ImmutableList.Builder builder = ImmutableList.builder();
        int size = f22098c.size();
        for (int i3 = 0; i3 < size; i3++) {
            builder.c(((Fab) f22098c.get(i3)).getSpec(this, str2));
        }
        m23213a(str, i, i2, builder.b());
    }

    private void m23213a(String str, int i, int i2, ImmutableList<SproutSpec> immutableList) {
        try {
            InlineComposerSproutFragment.a(this.f22105j, this.f22110o, GroupCommerceComposerHelper.a(GroupInformationInterfaceFactory.a(this.f22107l)) ? m23216c() : m23214b(), i2, immutableList, this.f22106k.a(str, this.f22102g.getString(i))).a(this.f22103h, null);
        } catch (Throwable e) {
            BLog.b(f22099d, e, "Show called after saveInstanceState", new Object[0]);
        }
    }

    public static SproutSpec m23215c(GroupsComposerSproutLauncher groupsComposerSproutLauncher, String str) {
        return SproutSpec.a(2131363535, 2130839837, groupsComposerSproutLauncher.f22102g.getString(2131238052), "post", groupsComposerSproutLauncher.m23214b()).a();
    }

    private Runnable m23214b() {
        return new C31711(this);
    }

    public static SproutSpec m23217d(GroupsComposerSproutLauncher groupsComposerSproutLauncher, String str) {
        return SproutSpec.a(2131363539, 2130840055, groupsComposerSproutLauncher.f22102g.getString(2131238063), "sell", groupsComposerSproutLauncher.m23216c()).a();
    }

    private Runnable m23216c() {
        return new C31722(this);
    }
}
