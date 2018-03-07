package com.facebook.messaging.util.launchtimeline;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentManager;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.graphql.contactprofiletype.ContactProfileType;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.IntentResolver;
import com.facebook.content.SecureContextHelper;
import com.facebook.http.fburl.FbSiteUrlConfig;
import com.facebook.inject.InjectorLike;
import com.facebook.iorg.common.upsell.ui.FbZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController.Listener;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: chat_colors_picker */
public class LaunchTimelineHelper {
    public SecureContextHelper f18343a;
    private final ZeroDialogController f18344b;
    public final Context f18345c;
    public final Boolean f18346d;
    public final FbSiteUrlConfig f18347e;

    /* compiled from: chat_colors_picker */
    class C21221 implements Listener {
        final /* synthetic */ LaunchTimelineHelper f18340a;

        C21221(LaunchTimelineHelper launchTimelineHelper) {
            this.f18340a = launchTimelineHelper;
        }

        public final void m18335a(Object obj) {
            Builder buildUpon;
            Intent intent;
            LaunchTimelineHelper launchTimelineHelper = this.f18340a;
            ParsedUserData parsedUserData = (ParsedUserData) obj;
            String str = parsedUserData.f18341a;
            if (parsedUserData.f18342b) {
                buildUpon = Uri.parse(FBLinks.a("page/") + str).buildUpon();
            } else {
                buildUpon = Uri.parse(FBLinks.a("profile/") + str).buildUpon();
            }
            Intent intent2 = new Intent("android.intent.action.VIEW", buildUpon.build());
            boolean a = IntentResolver.a(launchTimelineHelper.f18345c, intent2);
            if (a) {
                intent = intent2;
            } else {
                String c;
                StringBuilder stringBuilder = new StringBuilder("http://");
                if (launchTimelineHelper.f18346d.booleanValue()) {
                    c = launchTimelineHelper.f18347e.m7834c();
                } else {
                    c = launchTimelineHelper.f18347e.m7833a();
                }
                Builder buildUpon2 = Uri.parse(stringBuilder.append(c).append("/profile.php").toString()).buildUpon();
                buildUpon2.appendQueryParameter("id", str);
                intent = new Intent("android.intent.action.VIEW", buildUpon2.build());
            }
            if (a) {
                launchTimelineHelper.f18343a.a(intent, launchTimelineHelper.f18345c);
            } else {
                launchTimelineHelper.f18343a.b(intent, launchTimelineHelper.f18345c);
            }
        }

        public final void m18334a() {
        }
    }

    /* compiled from: chat_colors_picker */
    public class ParsedUserData implements Parcelable {
        public static final Creator<ParsedUserData> CREATOR = new C21231();
        public final String f18341a;
        public final boolean f18342b;

        /* compiled from: chat_colors_picker */
        final class C21231 implements Creator<ParsedUserData> {
            C21231() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new ParsedUserData(parcel);
            }

            public final Object[] newArray(int i) {
                return new ParsedUserData[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f18341a);
            parcel.writeInt(this.f18342b ? 1 : 0);
        }

        public ParsedUserData(String str, boolean z) {
            this.f18341a = str;
            this.f18342b = z;
        }

        public ParsedUserData(Parcel parcel) {
            boolean z = true;
            this.f18341a = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f18342b = z;
        }
    }

    public static LaunchTimelineHelper m18337b(InjectorLike injectorLike) {
        return new LaunchTimelineHelper((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (ZeroDialogController) FbZeroDialogController.b(injectorLike), (Context) injectorLike.getInstance(Context.class), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), FbSiteUrlConfig.m7831a(injectorLike));
    }

    @Inject
    public LaunchTimelineHelper(SecureContextHelper secureContextHelper, ZeroDialogController zeroDialogController, Context context, Boolean bool, FbSiteUrlConfig fbSiteUrlConfig) {
        this.f18343a = secureContextHelper;
        this.f18344b = zeroDialogController;
        this.f18345c = context;
        this.f18346d = bool;
        this.f18347e = fbSiteUrlConfig;
        this.f18344b.a(ZeroFeatureKey.VIEW_TIMELINE_INTERSTITIAL, this.f18345c.getResources().getString(2131232924), new C21221(this));
    }

    public final void m18340a(UserKey userKey, FragmentManager fragmentManager) {
        boolean z;
        Preconditions.checkNotNull(userKey);
        if (userKey.a() == Type.FACEBOOK) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        m18336a(new ParsedUserData(userKey.b(), false), fragmentManager);
    }

    public final void m18339a(User user, FragmentManager fragmentManager) {
        boolean z;
        Preconditions.checkNotNull(user);
        Preconditions.checkNotNull(user.T);
        if (user.T.a() == Type.FACEBOOK) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        m18336a(new ParsedUserData(user.T.b(), user.T()), fragmentManager);
    }

    public final void m18338a(Contact contact, FragmentManager fragmentManager) {
        Preconditions.checkNotNull(contact);
        m18336a(new ParsedUserData(contact.c(), contact.A() == ContactProfileType.PAGE), fragmentManager);
    }

    private void m18336a(ParsedUserData parsedUserData, FragmentManager fragmentManager) {
        this.f18344b.a(ZeroFeatureKey.VIEW_TIMELINE_INTERSTITIAL, fragmentManager, parsedUserData);
    }
}
