package com.facebook.feedplugins.profile.calltoaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.profilevideo.logging.ProfileVideoEvent;
import com.facebook.timeline.profilevideo.logging.ProfileVideoSessionTracker;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: SOLID */
public class ProfileCallToActionHelper {

    /* compiled from: SOLID */
    final class C20491 implements OnClickListener {
        final /* synthetic */ CreateProfileVideoCallToActionPartDefinition$1 f23742a;
        final /* synthetic */ Provider f23743b;
        final /* synthetic */ UriIntentMapper f23744c;
        final /* synthetic */ Bundle f23745d;
        final /* synthetic */ SecureContextHelper f23746e;

        C20491(CreateProfileVideoCallToActionPartDefinition$1 createProfileVideoCallToActionPartDefinition$1, Provider provider, UriIntentMapper uriIntentMapper, Bundle bundle, SecureContextHelper secureContextHelper) {
            this.f23742a = createProfileVideoCallToActionPartDefinition$1;
            this.f23743b = provider;
            this.f23744c = uriIntentMapper;
            this.f23745d = bundle;
            this.f23746e = secureContextHelper;
        }

        public final void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -142150492);
            if (this.f23742a != null) {
                CreateProfileVideoCallToActionPartDefinition$1 createProfileVideoCallToActionPartDefinition$1 = this.f23742a;
                ((ProfileVideoSessionTracker) createProfileVideoCallToActionPartDefinition$1.f23741b.f.get()).b(ProfileVideoEvent.CALL_TO_ACTION_BUTTON_CLICKED, createProfileVideoCallToActionPartDefinition$1.f23740a.r() == null ? "" : createProfileVideoCallToActionPartDefinition$1.f23740a.r().b());
            }
            Intent a2 = this.f23744c.a(view.getContext(), StringFormatUtil.a(FBLinks.aX, new Object[]{this.f23743b.get()}));
            if (a2 != null) {
                a2.putExtras(this.f23745d);
                this.f23746e.a(a2, view.getContext());
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1984877714, a);
        }
    }

    public static OnClickListener m25913a(Bundle bundle, Provider<String> provider, UriIntentMapper uriIntentMapper, SecureContextHelper secureContextHelper, @Nullable Logger logger) {
        return new C20491(logger, provider, uriIntentMapper, bundle, secureContextHelper);
    }
}
