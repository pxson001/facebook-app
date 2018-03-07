package com.facebook.groups.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.common.locale.Locales;
import com.facebook.common.util.ContextUtils;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.gating.ComposerGatekeepers;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.runtime.base.DraculaRuntime;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.fbui.widget.text.GlyphWithTextView;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.groupcommerce.util.GroupCommerceComposerHelper;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.groups.protocol.GroupInformationInterfaceFactory;
import com.facebook.groups.staticadapter.StaticAdapter.Bindable;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.appspecific.AppGlyphResolver;
import javax.inject.Inject;

/* compiled from: TimelineFragment.onFetchHeaderSucceeded */
public class GroupsButtonSellComposer extends SegmentedLinearLayout implements Bindable<FetchGroupInformationModel> {
    @Inject
    public ComposerLauncher f22077a;
    @Inject
    public GatekeeperStoreImpl f22078b;
    @Inject
    GroupsInlineComposerActionOptionController f22079c;
    @Inject
    public Locales f22080d;
    @Inject
    @IsWorkBuild
    public Boolean f22081e;
    public FetchGroupInformationModel f22082f;
    private boolean f22083g;
    public GlyphWithTextView f22084h;
    public GlyphWithTextView f22085i;
    public GlyphWithTextView f22086j;
    public final OnClickListener f22087k;
    public final OnClickListener f22088l;
    public final OnClickListener f22089m;

    /* compiled from: TimelineFragment.onFetchHeaderSucceeded */
    class C31651 implements OnClickListener {
        final /* synthetic */ GroupsButtonSellComposer f22071a;

        C31651(GroupsButtonSellComposer groupsButtonSellComposer) {
            this.f22071a = groupsButtonSellComposer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1628528512);
            GroupsButtonSellComposer groupsButtonSellComposer = this.f22071a;
            groupsButtonSellComposer.f22077a.a(null, GroupCommerceComposerHelper.a(GroupInformationInterfaceFactory.a(groupsButtonSellComposer.f22082f), groupsButtonSellComposer.f22078b.a(ComposerGatekeepers.f), groupsButtonSellComposer.f22080d).a(), 1756, (Activity) ContextUtils.a(groupsButtonSellComposer.getContext(), Activity.class));
            Logger.a(2, EntryType.UI_INPUT_END, 654890764, a);
        }
    }

    /* compiled from: TimelineFragment.onFetchHeaderSucceeded */
    class C31662 implements OnClickListener {
        final /* synthetic */ GroupsButtonSellComposer f22072a;

        C31662(GroupsButtonSellComposer groupsButtonSellComposer) {
            this.f22072a = groupsButtonSellComposer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1266975275);
            GroupsButtonSellComposer groupsButtonSellComposer = this.f22072a;
            groupsButtonSellComposer.f22077a.a(null, GroupCommerceComposerHelper.a(GroupInformationInterfaceFactory.a(groupsButtonSellComposer.f22082f), groupsButtonSellComposer.f22080d).a(), 1756, (Activity) ContextUtils.a(groupsButtonSellComposer.getContext(), Activity.class));
            Logger.a(2, EntryType.UI_INPUT_END, -566139731, a);
        }
    }

    /* compiled from: TimelineFragment.onFetchHeaderSucceeded */
    class C31673 implements OnClickListener {
        final /* synthetic */ GroupsButtonSellComposer f22073a;

        C31673(GroupsButtonSellComposer groupsButtonSellComposer) {
            this.f22073a = groupsButtonSellComposer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -329499085);
            GroupsButtonSellComposer groupsButtonSellComposer = this.f22073a;
            PopoverMenuWindow popoverMenuWindow = new PopoverMenuWindow(view.getContext());
            PopoverMenu c = popoverMenuWindow.c();
            MenuItemImpl a2 = c.a(2131238062);
            a2.setIcon(2130840019);
            a2.setOnMenuItemClickListener(new C31684(groupsButtonSellComposer));
            if (!groupsButtonSellComposer.f22081e.booleanValue()) {
                a2 = c.a(2131238059);
                a2.setIcon(2130839846);
                a2.setOnMenuItemClickListener(new C31695(groupsButtonSellComposer));
            }
            MenuItemImpl a3 = c.a(2131238060);
            a3.setIcon(AppGlyphResolver.a());
            a3.setOnMenuItemClickListener(new C31706(groupsButtonSellComposer));
            popoverMenuWindow.c(view);
            popoverMenuWindow.d();
            Logger.a(2, EntryType.UI_INPUT_END, -975035708, a);
        }
    }

    /* compiled from: TimelineFragment.onFetchHeaderSucceeded */
    public class C31684 implements OnMenuItemClickListener {
        final /* synthetic */ GroupsButtonSellComposer f22074a;

        public C31684(GroupsButtonSellComposer groupsButtonSellComposer) {
            this.f22074a = groupsButtonSellComposer;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            GroupsInlineComposerActionOptionController.m23346a(this.f22074a.f22082f.gW_(), (Activity) ContextUtils.a(this.f22074a.getContext(), Activity.class));
            return true;
        }
    }

    /* compiled from: TimelineFragment.onFetchHeaderSucceeded */
    public class C31695 implements OnMenuItemClickListener {
        final /* synthetic */ GroupsButtonSellComposer f22075a;

        public C31695(GroupsButtonSellComposer groupsButtonSellComposer) {
            this.f22075a = groupsButtonSellComposer;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            String str;
            DraculaReturnValue b = this.f22075a.f22082f.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            b = this.f22075a.f22082f.b();
            MutableFlatBuffer mutableFlatBuffer2 = b.a;
            int i3 = b.b;
            i2 = b.c;
            b = this.f22075a.f22082f.b();
            MutableFlatBuffer mutableFlatBuffer3 = b.a;
            int i4 = b.b;
            i2 = b.c;
            if (DraculaRuntime.a(mutableFlatBuffer3, mutableFlatBuffer3.g(i4, 14), null, 0)) {
                str = null;
            } else {
                DraculaReturnValue b2 = this.f22075a.f22082f.b();
                MutableFlatBuffer mutableFlatBuffer4 = b2.a;
                int i5 = b2.b;
                int i6 = b2.c;
                str = mutableFlatBuffer4.k(mutableFlatBuffer4.g(i5, 14), 1);
            }
            GroupsInlineComposerActionOptionController.m23348a(this.f22075a.f22082f.gW_(), mutableFlatBuffer.k(i, 13), (GraphQLGroupVisibility) mutableFlatBuffer2.f(i3, 17, GraphQLGroupVisibility.class), str, this.f22075a.getContext());
            return true;
        }
    }

    /* compiled from: TimelineFragment.onFetchHeaderSucceeded */
    public class C31706 implements OnMenuItemClickListener {
        final /* synthetic */ GroupsButtonSellComposer f22076a;

        public C31706(GroupsButtonSellComposer groupsButtonSellComposer) {
            this.f22076a = groupsButtonSellComposer;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            GroupsInlineComposerActionOptionController.m23347a(this.f22076a.f22082f.gW_(), this.f22076a.getContext());
            return true;
        }
    }

    public static void m23211a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GroupsButtonSellComposer) obj).m23210a((ComposerLauncher) ComposerLauncherImpl.a(fbInjector), GatekeeperStoreImplMethodAutoProvider.a(fbInjector), GroupsInlineComposerActionOptionController.m23349b(fbInjector), Locales.a(fbInjector), Boolean_IsWorkBuildMethodAutoProvider.a(fbInjector));
    }

    public final void mo758a(Object obj) {
        this.f22082f = (FetchGroupInformationModel) obj;
        if (!this.f22083g) {
            this.f22084h.setOnClickListener(this.f22088l);
            this.f22085i.setOnClickListener(this.f22087k);
            this.f22086j.setOnClickListener(this.f22089m);
            this.f22083g = true;
        }
    }

    public GroupsButtonSellComposer(Context context) {
        this(context, null);
    }

    private GroupsButtonSellComposer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22087k = new C31651(this);
        this.f22088l = new C31662(this);
        this.f22089m = new C31673(this);
        Class cls = GroupsButtonSellComposer.class;
        m23211a(this, getContext());
        setContentView(2130904704);
        setOrientation(1);
        this.f22084h = (GlyphWithTextView) a(2131562753);
        this.f22085i = (GlyphWithTextView) a(2131562754);
        this.f22086j = (GlyphWithTextView) a(2131562755);
    }

    private void m23210a(ComposerLauncher composerLauncher, GatekeeperStoreImpl gatekeeperStoreImpl, GroupsInlineComposerActionOptionController groupsInlineComposerActionOptionController, Locales locales, Boolean bool) {
        this.f22077a = composerLauncher;
        this.f22078b = gatekeeperStoreImpl;
        this.f22079c = groupsInlineComposerActionOptionController;
        this.f22080d = locales;
        this.f22081e = bool;
    }
}
