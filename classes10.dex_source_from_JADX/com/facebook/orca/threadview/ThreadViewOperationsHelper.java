package com.facebook.orca.threadview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.orca.FbandroidMessagingIntentUris;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.messages.ipc.MessagingIntentUris;
import com.facebook.messaging.chatheads.intents.ChatHeadsOpenHelper;
import com.facebook.messaging.dialog.MenuDialogFragment;
import com.facebook.messaging.dialog.MenuDialogFragment.Listener;
import com.facebook.messaging.dialog.MenuDialogItemBuilder;
import com.facebook.messaging.dialog.MenuDialogParamsBuilder;
import com.facebook.messaging.groups.threadactions.GroupThreadActionHandler;
import com.facebook.messaging.media.mediapicker.dialog.PickMediaSource;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.mutators.DeleteThreadDialogFragment;
import com.facebook.messaging.mutators.DeleteThreadDialogParams.Builder;
import com.facebook.messaging.threadview.iconpicker.ThreadIconPickerActivity;
import com.facebook.orca.contactcard.ThreadMembersDialogFragment;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: media_tray_nux_clicked */
public class ThreadViewOperationsHelper {
    public final Context f7920a;
    public final GroupThreadMembersActions f7921b;
    public final SecureContextHelper f7922c;
    public final ChatHeadsOpenHelper f7923d;
    private final ViewerContext f7924e;
    private final MessagingIntentUris f7925f;
    public final UriIntentMapper f7926g;
    public final Lazy<GroupThreadActionHandler> f7927h;

    public static ThreadViewOperationsHelper m7876b(InjectorLike injectorLike) {
        return new ThreadViewOperationsHelper((Context) injectorLike.getInstance(Context.class), GroupThreadMembersActions.m6571b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), ChatHeadsOpenHelper.a(injectorLike), ViewerContextMethodAutoProvider.b(injectorLike), (MessagingIntentUris) FbandroidMessagingIntentUris.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), IdBasedLazy.a(injectorLike, 7872));
    }

    public final void m7879b(FragmentManager fragmentManager, ThreadSummary threadSummary) {
        ThreadMembersDialogFragment threadMembersDialogFragment = new ThreadMembersDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("thread_summary", threadSummary);
        threadMembersDialogFragment.g(bundle);
        threadMembersDialogFragment.a(fragmentManager, "viewPeopleDialog");
    }

    public static void m7877c(FragmentManager fragmentManager, ThreadKey threadKey) {
        ThreadNameSettingDialogFragment threadNameSettingDialogFragment = new ThreadNameSettingDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("thread_key", threadKey);
        threadNameSettingDialogFragment.g(bundle);
        threadNameSettingDialogFragment.a(fragmentManager, "threadNameDialog");
    }

    @Inject
    public ThreadViewOperationsHelper(Context context, GroupThreadMembersActions groupThreadMembersActions, SecureContextHelper secureContextHelper, ChatHeadsOpenHelper chatHeadsOpenHelper, ViewerContext viewerContext, MessagingIntentUris messagingIntentUris, UriIntentMapper uriIntentMapper, Lazy<GroupThreadActionHandler> lazy) {
        this.f7920a = context;
        this.f7921b = groupThreadMembersActions;
        this.f7922c = secureContextHelper;
        this.f7923d = chatHeadsOpenHelper;
        this.f7924e = viewerContext;
        this.f7925f = messagingIntentUris;
        this.f7926g = uriIntentMapper;
        this.f7927h = lazy;
    }

    public static void m7875a(FragmentManager fragmentManager, ThreadKey threadKey) {
        Builder builder = new Builder();
        builder.f3320a = ImmutableList.of(threadKey);
        DeleteThreadDialogFragment.m3235a(builder.m3239a()).a(fragmentManager, "deleteThreadDialog");
    }

    public final void m7878a(ThreadSummary threadSummary, PickMediaSource pickMediaSource) {
        Intent intent = new Intent(this.f7920a, ThreadIconPickerActivity.class);
        intent.putExtra("threadKey", threadSummary.a);
        intent.putExtra("mediaSource", pickMediaSource);
        this.f7922c.a(intent, this.f7920a);
    }

    public static void m7874a(FragmentManager fragmentManager, Listener listener) {
        MenuDialogParamsBuilder menuDialogParamsBuilder = new MenuDialogParamsBuilder();
        menuDialogParamsBuilder.a = 2131231043;
        MenuDialogItemBuilder menuDialogItemBuilder = new MenuDialogItemBuilder();
        menuDialogItemBuilder.a = 2131558467;
        menuDialogItemBuilder = menuDialogItemBuilder;
        menuDialogItemBuilder.b = 2131231364;
        menuDialogItemBuilder = menuDialogItemBuilder;
        menuDialogItemBuilder.d = "name_thread";
        MenuDialogParamsBuilder a = menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
        MenuDialogItemBuilder menuDialogItemBuilder2 = new MenuDialogItemBuilder();
        menuDialogItemBuilder2.a = 2131558468;
        menuDialogItemBuilder2 = menuDialogItemBuilder2;
        menuDialogItemBuilder2.b = 2131231365;
        menuDialogItemBuilder2 = menuDialogItemBuilder2;
        menuDialogItemBuilder2.d = "set_photo";
        a = a.a(menuDialogItemBuilder2.f());
        menuDialogItemBuilder2 = new MenuDialogItemBuilder();
        menuDialogItemBuilder2.a = 2131558469;
        menuDialogItemBuilder2 = menuDialogItemBuilder2;
        menuDialogItemBuilder2.b = 2131231367;
        menuDialogItemBuilder2 = menuDialogItemBuilder2;
        menuDialogItemBuilder2.d = "add_people";
        a = a.a(menuDialogItemBuilder2.f());
        menuDialogItemBuilder2 = new MenuDialogItemBuilder();
        menuDialogItemBuilder2.a = 2131558470;
        menuDialogItemBuilder2 = menuDialogItemBuilder2;
        menuDialogItemBuilder2.b = 2131231370;
        menuDialogItemBuilder2 = menuDialogItemBuilder2;
        menuDialogItemBuilder2.d = "remove_people";
        a = a.a(menuDialogItemBuilder2.f());
        menuDialogItemBuilder2 = new MenuDialogItemBuilder();
        menuDialogItemBuilder2.a = 2131558471;
        menuDialogItemBuilder2 = menuDialogItemBuilder2;
        menuDialogItemBuilder2.b = 2131231371;
        menuDialogItemBuilder2 = menuDialogItemBuilder2;
        menuDialogItemBuilder2.d = "view_people";
        a = a.a(menuDialogItemBuilder2.f());
        menuDialogItemBuilder2 = new MenuDialogItemBuilder();
        menuDialogItemBuilder2.a = 2131558472;
        menuDialogItemBuilder2 = menuDialogItemBuilder2;
        menuDialogItemBuilder2.b = 2131231366;
        menuDialogItemBuilder2 = menuDialogItemBuilder2;
        menuDialogItemBuilder2.d = "leave_conversation";
        a.a(menuDialogItemBuilder2.f());
        MenuDialogFragment a2 = MenuDialogFragment.a(menuDialogParamsBuilder.e());
        a2.an = listener;
        a2.a(fragmentManager, "thread_menu_dialog");
    }
}
