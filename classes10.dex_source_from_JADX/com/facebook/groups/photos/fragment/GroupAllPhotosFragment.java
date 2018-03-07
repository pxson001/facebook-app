package com.facebook.groups.photos.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.groups.photos.loader.GroupMediaFetchPhotosFutureGenerator;
import com.facebook.groups.photos.view.GroupPhotosDefaultViewFactory;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.pandora.common.futures.photocollage.PandoraPhotoCollageFetchPhotosFutureGenerator;
import com.facebook.photos.pandora.ui.PandoraPhotoCollageFragment;
import com.facebook.photos.photoset.launcher.PhotoSetConsumptionGalleryPhotoLauncher;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TOXICLE_PRIVATE_MAYBE_SELECTED_WITH_CHEVRON */
public class GroupAllPhotosFragment extends PandoraPhotoCollageFragment {
    @Inject
    public GroupMediaFetchPhotosFutureGenerator f23017a;
    @Inject
    public GroupPhotosDefaultViewFactory ar;
    @Inject
    public Lazy<PhotoSetConsumptionGalleryPhotoLauncher> as;
    private C33221 at;

    /* compiled from: TOXICLE_PRIVATE_MAYBE_SELECTED_WITH_CHEVRON */
    public class C33221 {
        public final /* synthetic */ GroupAllPhotosFragment f23016a;

        C33221(GroupAllPhotosFragment groupAllPhotosFragment) {
            this.f23016a = groupAllPhotosFragment;
        }
    }

    public static void m24233a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        GroupAllPhotosFragment groupAllPhotosFragment = (GroupAllPhotosFragment) obj;
        GroupMediaFetchPhotosFutureGenerator a = GroupMediaFetchPhotosFutureGenerator.m24260a(fbInjector);
        GroupPhotosDefaultViewFactory b = GroupPhotosDefaultViewFactory.m24419b(fbInjector);
        Lazy a2 = IdBasedLazy.a(fbInjector, 9409);
        groupAllPhotosFragment.f23017a = a;
        groupAllPhotosFragment.ar = b;
        groupAllPhotosFragment.as = a2;
    }

    public final void m24238c(Bundle bundle) {
        super.c(bundle);
        Class cls = GroupAllPhotosFragment.class;
        m24233a((Object) this, getContext());
    }

    public final View m24234a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1414732961);
        this.at = new C33221(this);
        this.f23017a.f23054e = this.at;
        View a2 = super.a(layoutInflater, viewGroup, bundle);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2129017323, a);
        return a2;
    }

    protected final PandoraPhotoCollageFetchPhotosFutureGenerator m24237b() {
        return this.f23017a;
    }

    protected final void m24235a(String str, @Nullable Uri uri) {
        ((PhotoSetConsumptionGalleryPhotoLauncher) this.as.get()).a(ao(), str, uri, this.an.i.d(), this.f23017a.f23050a);
    }

    protected final TextView m24236b(Context context) {
        LayoutInflater from = LayoutInflater.from(context);
        GroupPhotosDefaultViewFactory groupPhotosDefaultViewFactory = this.ar;
        BetterTextView betterTextView = (BetterTextView) from.inflate(2130904734, null, false);
        betterTextView.setText(this.ar.f23108a.getString(2131242207));
        return betterTextView;
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1922921686);
        super.mY_();
        GroupMediaFetchPhotosFutureGenerator groupMediaFetchPhotosFutureGenerator = this.f23017a;
        C33221 c33221 = this.at;
        if (groupMediaFetchPhotosFutureGenerator.f23054e != null && groupMediaFetchPhotosFutureGenerator.f23054e.equals(c33221)) {
            groupMediaFetchPhotosFutureGenerator.f23054e = null;
        }
        this.at = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1024751935, a);
    }
}
