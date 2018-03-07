package com.facebook.qrcode.handler;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.entitycards.intent.EntityCardsLauncher;
import com.facebook.friends.constants.FriendRequestMakeRef;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Absent;
import com.google.common.collect.ImmutableList;
import java.util.TimerTask;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: like_sticker_fullscreen */
public class Fb4aQRCodeHandler {
    public Context f8664a;
    public EntityCardsLauncher f8665b;
    public FbUriIntentHandler f8666c;

    /* compiled from: like_sticker_fullscreen */
    class SuccessfulScanTimerTask extends TimerTask {
        final /* synthetic */ Fb4aQRCodeHandler f8661a;
        private long f8662b;
        private String f8663c;

        public SuccessfulScanTimerTask(Fb4aQRCodeHandler fb4aQRCodeHandler, String str) {
            this.f8661a = fb4aQRCodeHandler;
            this.f8663c = str;
        }

        public SuccessfulScanTimerTask(Fb4aQRCodeHandler fb4aQRCodeHandler, long j) {
            this.f8661a = fb4aQRCodeHandler;
            this.f8662b = j;
        }

        public void run() {
            Fb4aQRCodeHandler fb4aQRCodeHandler;
            if (!StringUtil.a(this.f8663c)) {
                fb4aQRCodeHandler = this.f8661a;
                String str = this.f8663c;
                Bundle bundle = new Bundle();
                bundle.putSerializable("timeline_friend_request_ref", FriendRequestMakeRef.QR_CODE);
                fb4aQRCodeHandler.f8666c.a(fb4aQRCodeHandler.f8664a, str, bundle);
            } else if (this.f8661a.f8665b.a("qr_code")) {
                Fb4aQRCodeHandler.m8683a(this.f8661a, this.f8662b);
            } else {
                fb4aQRCodeHandler = this.f8661a;
                String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, Long.valueOf(this.f8662b));
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("timeline_friend_request_ref", FriendRequestMakeRef.QR_CODE);
                fb4aQRCodeHandler.f8666c.a(fb4aQRCodeHandler.f8664a, formatStrLocaleSafe, bundle2);
            }
        }
    }

    public static Fb4aQRCodeHandler m8682a(InjectorLike injectorLike) {
        return new Fb4aQRCodeHandler((Context) injectorLike.getInstance(Context.class), EntityCardsLauncher.a(injectorLike), FbUriIntentHandler.a(injectorLike));
    }

    @Inject
    public Fb4aQRCodeHandler(Context context, EntityCardsLauncher entityCardsLauncher, FbUriIntentHandler fbUriIntentHandler) {
        this.f8664a = context;
        this.f8665b = entityCardsLauncher;
        this.f8666c = fbUriIntentHandler;
    }

    @Nullable
    public final TimerTask m8684a(String str) {
        Uri parse = Uri.parse(str);
        if (!FacebookUriUtil.c(parse)) {
            return null;
        }
        boolean contains = parse.getPath().contains("/qr");
        Object obj = !parse.getQueryParameters("id").isEmpty() ? 1 : null;
        if (!contains || obj == null) {
            return new SuccessfulScanTimerTask(this, str);
        }
        try {
            return new SuccessfulScanTimerTask(this, Long.parseLong(parse.getQueryParameter("id")));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static void m8683a(Fb4aQRCodeHandler fb4aQRCodeHandler, long j) {
        Bundle bundle = new Bundle();
        bundle.putString("extra_friending_location_name", FriendingLocation.QR_CODE.name());
        bundle.putString("extra_friend_request_make_ref", FriendRequestMakeRef.QR_CODE.name());
        String valueOf = String.valueOf(j);
        Activity activity = (Activity) ContextUtils.a(fb4aQRCodeHandler.f8664a, Activity.class);
        if (activity != null) {
            fb4aQRCodeHandler.f8665b.a(activity, "qr_code", Absent.INSTANCE, ImmutableList.of(valueOf), valueOf, null, bundle);
        }
    }
}
