package com.facebook.messaging.media.mediatray;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.i18n.I18nJoiner;
import com.facebook.common.time.Clock;
import com.facebook.content.SecureContextHelper;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messages.ipc.MessagingIntentUris;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.cache.ThreadRecipientUtil;
import com.facebook.messaging.media.mediatray.MediaTrayAdapter.PhotoRemindersNuxListener;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.photoreminders.ExperimentsForMessagingPhotoRemindersModule;
import com.facebook.messaging.photoreminders.PhotoRemindersGatingUtil;
import com.facebook.messaging.photoreminders.PhotoRemindersLogger;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.user.model.User;
import com.facebook.user.module.UserNameUtil;
import com.facebook.user.tiles.UserTileViewParams;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: seconds_since_cold_start */
public class PhotoRemindersNuxController {
    public final Clock f3148a;
    public final FbSharedPreferences f3149b;
    private final GatekeeperStoreImpl f3150c;
    private final LayoutInflater f3151d;
    public final PhotoRemindersGatingUtil f3152e;
    public final PhotoRemindersLogger f3153f;
    private final PhotoRemindersNuxViewHolderProvider f3154g;
    public final QeAccessor f3155h;
    public final SecureContextHelper f3156i;
    private final CloseListener f3157j = new CloseListener(this);
    private final OptInListener f3158k = new OptInListener(this);
    @Nullable
    public PhotoRemindersNuxListener f3159l;

    /* compiled from: seconds_since_cold_start */
    class CloseListener implements OnClickListener {
        final /* synthetic */ PhotoRemindersNuxController f3146a;

        public CloseListener(PhotoRemindersNuxController photoRemindersNuxController) {
            this.f3146a = photoRemindersNuxController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -775447502);
            PhotoRemindersLogger photoRemindersLogger = this.f3146a.f3153f;
            int d = PhotoRemindersNuxController.m3117d(this.f3146a);
            ThreadKey j = PhotoRemindersNuxController.m3121j(this.f3146a);
            Integer.valueOf(d);
            HoneyClientEvent a2 = PhotoRemindersLogger.a("media_tray_nux_dismissed").a("num_exposures", d);
            if (j != null) {
                a2.a(PhotoRemindersLogger.a(j), j.i());
            }
            photoRemindersLogger.b.a(a2);
            PhotoRemindersNuxController photoRemindersNuxController = this.f3146a;
            photoRemindersNuxController.f3149b.edit().a(MessagingPrefKeys.aO, photoRemindersNuxController.f3148a.a()).commit();
            PhotoRemindersNuxController.m3118f(this.f3146a);
            if (this.f3146a.f3159l != null) {
                this.f3146a.f3159l.m3004a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1632052506, a);
        }
    }

    /* compiled from: seconds_since_cold_start */
    class OptInListener implements OnClickListener {
        final /* synthetic */ PhotoRemindersNuxController f3147a;

        public OptInListener(PhotoRemindersNuxController photoRemindersNuxController) {
            this.f3147a = photoRemindersNuxController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 163251243);
            PhotoRemindersLogger photoRemindersLogger = this.f3147a.f3153f;
            int d = PhotoRemindersNuxController.m3117d(this.f3147a);
            ThreadKey j = PhotoRemindersNuxController.m3121j(this.f3147a);
            Integer.valueOf(d);
            HoneyClientEvent a2 = PhotoRemindersLogger.a("media_tray_nux_clicked").a("num_exposures", d);
            if (j != null) {
                a2.a(PhotoRemindersLogger.a(j), j.i());
            }
            photoRemindersLogger.b.a(a2);
            this.f3147a.f3152e.b(true);
            this.f3147a.f3156i.a(new Intent(MessagingIntentUris.a, Uri.parse(MessengerLinks.H)), view.getContext());
            if (this.f3147a.f3159l != null) {
                this.f3147a.f3159l.m3004a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1569471528, a);
        }
    }

    @Inject
    public PhotoRemindersNuxController(Clock clock, FbSharedPreferences fbSharedPreferences, GatekeeperStoreImpl gatekeeperStoreImpl, LayoutInflater layoutInflater, PhotoRemindersGatingUtil photoRemindersGatingUtil, PhotoRemindersLogger photoRemindersLogger, PhotoRemindersNuxViewHolderProvider photoRemindersNuxViewHolderProvider, QeAccessor qeAccessor, SecureContextHelper secureContextHelper) {
        this.f3148a = clock;
        this.f3149b = fbSharedPreferences;
        this.f3150c = gatekeeperStoreImpl;
        this.f3151d = layoutInflater;
        this.f3152e = photoRemindersGatingUtil;
        this.f3153f = photoRemindersLogger;
        this.f3154g = photoRemindersNuxViewHolderProvider;
        this.f3155h = qeAccessor;
        this.f3156i = secureContextHelper;
    }

    public final PhotoRemindersNuxViewHolder m3122a(ViewGroup viewGroup) {
        View inflate = this.f3151d.inflate(2130906211, viewGroup, false);
        PhotoRemindersNuxViewHolderProvider photoRemindersNuxViewHolderProvider = this.f3154g;
        PhotoRemindersNuxViewHolder photoRemindersNuxViewHolder = new PhotoRemindersNuxViewHolder(new PhotoRemindersNuxExperimentAccessor(I18nJoiner.b(photoRemindersNuxViewHolderProvider), (QeAccessor) QeInternalImplMethodAutoProvider.a(photoRemindersNuxViewHolderProvider), ResourcesMethodAutoProvider.a(photoRemindersNuxViewHolderProvider), UserNameUtil.a(photoRemindersNuxViewHolderProvider)), ThreadRecipientUtil.b(photoRemindersNuxViewHolderProvider), inflate);
        m3119g();
        this.f3153f.a(m3117d(this), m3121j(this));
        return photoRemindersNuxViewHolder;
    }

    public final void m3123a(PhotoRemindersNuxViewHolder photoRemindersNuxViewHolder) {
        photoRemindersNuxViewHolder.f3166n.setOnClickListener(this.f3157j);
        photoRemindersNuxViewHolder.f3168p.setOnClickListener(this.f3158k);
        ImmutableList b = photoRemindersNuxViewHolder.f3165m.b(m3121j(this));
        photoRemindersNuxViewHolder.f3167o.setText(photoRemindersNuxViewHolder.f3164l.m3125a(b));
        if (b.size() == 1) {
            photoRemindersNuxViewHolder.f3172t.setVisibility(0);
            photoRemindersNuxViewHolder.f3172t.setParams(UserTileViewParams.a((User) b.get(0)));
        } else {
            photoRemindersNuxViewHolder.f3172t.setVisibility(8);
        }
        if (b.size() > 1) {
            photoRemindersNuxViewHolder.f3169q.setVisibility(0);
            photoRemindersNuxViewHolder.f3169q.setParams(UserTileViewParams.a((User) b.get(0)));
            photoRemindersNuxViewHolder.f3170r.setVisibility(0);
            photoRemindersNuxViewHolder.f3170r.setParams(UserTileViewParams.a((User) b.get(1)));
        } else {
            photoRemindersNuxViewHolder.f3169q.setVisibility(8);
            photoRemindersNuxViewHolder.f3170r.setVisibility(8);
        }
        if (b.size() > 2) {
            photoRemindersNuxViewHolder.f3171s.setVisibility(0);
            photoRemindersNuxViewHolder.f3171s.setParams(UserTileViewParams.a((User) b.get(2)));
            return;
        }
        photoRemindersNuxViewHolder.f3171s.setVisibility(8);
    }

    public final boolean m3124a() {
        if (!this.f3150c.a(911, false) || !this.f3152e.b() || this.f3152e.d() || !this.f3152e.f() || !this.f3152e.g()) {
            return false;
        }
        if ((this.f3148a.a() > this.f3155h.a(ExperimentsForMessagingPhotoRemindersModule.f3514i, 604800000) + this.f3149b.a(MessagingPrefKeys.aO, 0) ? 1 : null) == null || m3120i()) {
            return false;
        }
        return true;
    }

    private int m3116c() {
        return this.f3149b.a(MessagingPrefKeys.aM, 0);
    }

    public static int m3117d(PhotoRemindersNuxController photoRemindersNuxController) {
        return photoRemindersNuxController.f3149b.a(MessagingPrefKeys.aN, 0);
    }

    public static void m3118f(PhotoRemindersNuxController photoRemindersNuxController) {
        photoRemindersNuxController.f3149b.edit().a(MessagingPrefKeys.aM, photoRemindersNuxController.m3116c() + 1).commit();
    }

    private void m3119g() {
        this.f3149b.edit().a(MessagingPrefKeys.aN, m3117d(this) + 1).commit();
    }

    private boolean m3120i() {
        return ((long) m3116c()) >= ((long) this.f3155h.a(ExperimentsForMessagingPhotoRemindersModule.f3510e, 3));
    }

    @Nullable
    public static ThreadKey m3121j(PhotoRemindersNuxController photoRemindersNuxController) {
        return photoRemindersNuxController.f3159l != null ? photoRemindersNuxController.f3159l.f3034a.f3040f.mo105a() : null;
    }
}
