package com.facebook.groups.feed.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.runtime.base.DraculaRuntime;
import com.facebook.fbui.widget.megaphone.Megaphone;
import com.facebook.fbui.widget.megaphone.Megaphone.OnDismissListener;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.DraculaImplementation;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel.Builder;
import com.facebook.groups.feed.ui.GroupsFeedFragment.AnonymousClass15;
import com.facebook.groups.mutations.GroupsClient;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TimelineFragment.onFragmentCreate.getDataFetcher */
public class GroupMallNotifMegaphoneController implements GroupMallMegaphoneController {
    private final Resources f22032a;
    public final AnonymousClass15 f22033b;
    public final SecureContextHelper f22034c;
    private final GroupsClient f22035d;
    private final ExecutorService f22036e;
    public FetchGroupInformationModel f22037f;

    /* compiled from: TimelineFragment.onFragmentCreate.getDataFetcher */
    class C31561 implements OnClickListener {
        final /* synthetic */ GroupMallNotifMegaphoneController f22028a;

        C31561(GroupMallNotifMegaphoneController groupMallNotifMegaphoneController) {
            this.f22028a = groupMallNotifMegaphoneController;
        }

        public void onClick(View view) {
            int i;
            int i2 = 1;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -511902823);
            if (this.f22028a.f22037f != null) {
                DraculaReturnValue b = this.f22028a.f22037f.b();
                MutableFlatBuffer mutableFlatBuffer = b.a;
                int i3 = b.b;
                i = b.c;
                i = !DraculaRuntime.a(mutableFlatBuffer, i3, null, 0) ? 1 : 0;
            } else {
                i = 0;
            }
            if (i != 0) {
                b = this.f22028a.f22037f.b();
                mutableFlatBuffer = b.a;
                i3 = b.b;
                i = b.c;
                if (mutableFlatBuffer.k(i3, 11) == null) {
                    i2 = 0;
                }
            } else {
                i2 = 0;
            }
            if (i2 != 0) {
                String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("https://m.facebook.com/group/settings/?group_id=%s", this.f22028a.f22037f.gW_());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, Uri.encode(formatStrLocaleSafe))));
                this.f22028a.f22034c.a(intent, view.getContext());
            }
            GroupMallNotifMegaphoneController.m23171j(this.f22028a);
            LogUtils.a(-4184753, a);
        }
    }

    /* compiled from: TimelineFragment.onFragmentCreate.getDataFetcher */
    class C31572 implements OnDismissListener {
        final /* synthetic */ GroupMallNotifMegaphoneController f22029a;

        C31572(GroupMallNotifMegaphoneController groupMallNotifMegaphoneController) {
            this.f22029a = groupMallNotifMegaphoneController;
        }

        public final void m23170a(Megaphone megaphone) {
            GroupMallNotifMegaphoneController.m23171j(this.f22029a);
        }
    }

    @Inject
    public GroupMallNotifMegaphoneController(Resources resources, @Assisted AnonymousClass15 anonymousClass15, SecureContextHelper secureContextHelper, GroupsClient groupsClient, ExecutorService executorService) {
        this.f22032a = resources;
        this.f22033b = anonymousClass15;
        this.f22034c = secureContextHelper;
        this.f22035d = groupsClient;
        this.f22036e = executorService;
    }

    public final String mo977a() {
        return this.f22032a.getString(2131238007);
    }

    public final String mo978b() {
        return this.f22032a.getString(2131238008);
    }

    public final String mo980d() {
        return this.f22032a.getString(2131238009);
    }

    @Nullable
    public final String mo979c() {
        return null;
    }

    @Nullable
    public final Uri mo981e() {
        return null;
    }

    public final OnClickListener mo982f() {
        return new C31561(this);
    }

    @Nullable
    public final OnClickListener mo983g() {
        return null;
    }

    @Nullable
    public final OnDismissListener mo984h() {
        return new C31572(this);
    }

    public final void mo985i() {
    }

    public static void m23171j(GroupMallNotifMegaphoneController groupMallNotifMegaphoneController) {
        String gW_ = groupMallNotifMegaphoneController.f22037f.gW_();
        Builder a = Builder.a(groupMallNotifMegaphoneController.f22037f);
        a.j = false;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(1024);
        int a2 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int a3 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int b = flatBufferBuilder.b(null);
        int a4 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int a5 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int a6 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int a7 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int a8 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int a9 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int b2 = flatBufferBuilder.b(gW_);
        int b3 = flatBufferBuilder.b(null);
        int a10 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int b4 = flatBufferBuilder.b(null);
        int e = flatBufferBuilder.e(null);
        int a11 = flatBufferBuilder.a(null);
        int a12 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        flatBufferBuilder.c(19);
        flatBufferBuilder.b(0, a2);
        flatBufferBuilder.b(1, a3);
        flatBufferBuilder.b(2, b);
        flatBufferBuilder.b(3, a4);
        flatBufferBuilder.b(4, a5);
        flatBufferBuilder.a(5, 0, 0);
        flatBufferBuilder.b(6, a6);
        flatBufferBuilder.b(7, a7);
        flatBufferBuilder.b(8, a8);
        flatBufferBuilder.b(9, a9);
        flatBufferBuilder.a(10, false);
        flatBufferBuilder.b(11, b2);
        flatBufferBuilder.a(12, false);
        flatBufferBuilder.b(13, b3);
        flatBufferBuilder.b(14, a10);
        flatBufferBuilder.b(15, b4);
        flatBufferBuilder.b(16, e);
        flatBufferBuilder.b(17, a11);
        flatBufferBuilder.b(18, a12);
        DraculaReturnValue a13 = DraculaReturnValue.a(flatBufferBuilder, 291056794);
        a.a(a13.a, a13.b, a13.c);
        final FetchGroupInformationModel a14 = a.a();
        groupMallNotifMegaphoneController.f22033b.m23231a(groupMallNotifMegaphoneController.f22037f, a14);
        Futures.a(groupMallNotifMegaphoneController.f22035d.a(groupMallNotifMegaphoneController.f22037f.gW_(), groupMallNotifMegaphoneController.f22037f), new FutureCallback<Void>(groupMallNotifMegaphoneController) {
            final /* synthetic */ GroupMallNotifMegaphoneController f22031b;

            public void onSuccess(@Nullable Object obj) {
                this.f22031b.f22033b.m23232a(true);
            }

            public void onFailure(Throwable th) {
                this.f22031b.f22033b.m23231a(a14, this.f22031b.f22037f);
                this.f22031b.f22033b.m23232a(true);
            }
        }, groupMallNotifMegaphoneController.f22036e);
    }
}
