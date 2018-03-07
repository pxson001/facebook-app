package com.facebook.messaging.groups.namingbar;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.banner.AbstractBannerNotification;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.groups.namingbar.GroupNamingBarView.Listener;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.service.model.ModifyThreadParams;
import com.facebook.messaging.service.model.ModifyThreadParamsBuilder;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: show called with null window token -- ignoring */
public class GroupNamingBarBanner extends AbstractBannerNotification {
    private final LayoutInflater f2482a;
    public final DefaultBlueServiceOperationFactory f2483b;
    public final Context f2484c;
    @Nullable
    public ThreadKey f2485d;

    /* compiled from: show called with null window token -- ignoring */
    class C04101 implements Listener {
        final /* synthetic */ GroupNamingBarBanner f2480a;

        C04101(GroupNamingBarBanner groupNamingBarBanner) {
            this.f2480a = groupNamingBarBanner;
        }

        public final void mo63a(String str) {
            GroupNamingBarBanner groupNamingBarBanner = this.f2480a;
            ModifyThreadParamsBuilder modifyThreadParamsBuilder = new ModifyThreadParamsBuilder();
            modifyThreadParamsBuilder.a = groupNamingBarBanner.f2485d;
            ModifyThreadParams q = modifyThreadParamsBuilder.b(str).q();
            Bundle bundle = new Bundle();
            bundle.putParcelable("modifyThreadParams", q);
            Futures.a(BlueServiceOperationFactoryDetour.a(groupNamingBarBanner.f2483b, "modify_thread", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(GroupNamingBarBanner.class), -2020944691).a(), new C04112(groupNamingBarBanner));
            groupNamingBarBanner.a.b(groupNamingBarBanner);
        }
    }

    /* compiled from: show called with null window token -- ignoring */
    public class C04112 implements FutureCallback<OperationResult> {
        final /* synthetic */ GroupNamingBarBanner f2481a;

        public C04112(GroupNamingBarBanner groupNamingBarBanner) {
            this.f2481a = groupNamingBarBanner;
        }

        public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
        }

        public void onFailure(Throwable th) {
            Toast.makeText(this.f2481a.f2484c, 2131241299, 0).show();
        }
    }

    public static GroupNamingBarBanner m2497a(InjectorLike injectorLike) {
        return new GroupNamingBarBanner(LayoutInflaterMethodAutoProvider.b(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public GroupNamingBarBanner(LayoutInflater layoutInflater, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, Context context) {
        super(null);
        this.f2482a = layoutInflater;
        this.f2483b = defaultBlueServiceOperationFactory;
        this.f2484c = context;
    }

    public final View m2498a(ViewGroup viewGroup) {
        GroupNamingBarView groupNamingBarView = (GroupNamingBarView) this.f2482a.inflate(2130904680, viewGroup, false);
        groupNamingBarView.m2501a();
        groupNamingBarView.f2488b = new C04101(this);
        return groupNamingBarView;
    }
}
