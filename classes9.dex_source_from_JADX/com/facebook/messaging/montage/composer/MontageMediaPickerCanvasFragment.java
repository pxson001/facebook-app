package com.facebook.messaging.montage.composer;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.internal.widget.ViewStubCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.facebook.common.loader.AbstractFbLoaderCallback;
import com.facebook.common.util.CollectionUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.media.loader.LocalMediaLoader;
import com.facebook.messaging.media.loader.LocalMediaLoaderParams;
import com.facebook.messaging.permissions.PermissionRequestIconView;
import com.facebook.runtimepermissions.AbstractRuntimePermissionsListener;
import com.facebook.runtimepermissions.ActivitylessRuntimePermissionsManager;
import com.facebook.runtimepermissions.ActivitylessRuntimePermissionsManagerProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.recyclerview.GridSpacingItemDecoration;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: is_new_sign_up_logged */
public class MontageMediaPickerCanvasFragment extends AbstractMontageCanvasFragment implements MontageComposerCanvas {
    public static final String[] f12538h = new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
    @Inject
    public LocalMediaLoader f12539a;
    public MontageComposerController al;
    public MontageMediaPickerAdapter am;
    @Inject
    public ActivitylessRuntimePermissionsManagerProvider f12540b;
    public ProgressBar f12541c;
    public RecyclerView f12542d;
    public ViewStubHolder<View> f12543e;
    public ViewStubHolder<View> f12544f;
    public ViewStubHolder<PermissionRequestIconView> f12545g;
    public ActivitylessRuntimePermissionsManager f12546i;

    /* compiled from: is_new_sign_up_logged */
    public class C13941 {
        public final /* synthetic */ MontageMediaPickerCanvasFragment f12533a;

        C13941(MontageMediaPickerCanvasFragment montageMediaPickerCanvasFragment) {
            this.f12533a = montageMediaPickerCanvasFragment;
        }
    }

    /* compiled from: is_new_sign_up_logged */
    public class C13952 implements OnClickListener {
        final /* synthetic */ MontageMediaPickerCanvasFragment f12534a;

        public C13952(MontageMediaPickerCanvasFragment montageMediaPickerCanvasFragment) {
            this.f12534a = montageMediaPickerCanvasFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1893900351);
            MontageMediaPickerCanvasFragment montageMediaPickerCanvasFragment = this.f12534a;
            montageMediaPickerCanvasFragment.f12546i.m19955a(MontageMediaPickerCanvasFragment.f12538h, new C13963(montageMediaPickerCanvasFragment));
            Logger.a(2, EntryType.UI_INPUT_END, 1130438152, a);
        }
    }

    /* compiled from: is_new_sign_up_logged */
    public class C13963 extends AbstractRuntimePermissionsListener {
        final /* synthetic */ MontageMediaPickerCanvasFragment f12535a;

        public C13963(MontageMediaPickerCanvasFragment montageMediaPickerCanvasFragment) {
            this.f12535a = montageMediaPickerCanvasFragment;
        }

        public final void m13001a() {
            MontageMediaPickerCanvasFragment.ar(this.f12535a);
        }
    }

    /* compiled from: is_new_sign_up_logged */
    class MediaLoaderCallback extends AbstractFbLoaderCallback<LocalMediaLoaderParams, ImmutableList<MediaResource>, Throwable> {
        final /* synthetic */ MontageMediaPickerCanvasFragment f12537a;

        public MediaLoaderCallback(MontageMediaPickerCanvasFragment montageMediaPickerCanvasFragment) {
            this.f12537a = montageMediaPickerCanvasFragment;
        }

        public final void m13002b(Object obj, Object obj2) {
            ImmutableList<MediaResource> immutableList = (ImmutableList) obj2;
            MontageMediaPickerCanvasFragment montageMediaPickerCanvasFragment = this.f12537a;
            if (CollectionUtil.a(immutableList)) {
                montageMediaPickerCanvasFragment.m13008a(ViewState.EMPTY);
                return;
            }
            montageMediaPickerCanvasFragment.m13008a(ViewState.CONTENT);
            MontageMediaPickerAdapter montageMediaPickerAdapter = montageMediaPickerCanvasFragment.am;
            montageMediaPickerAdapter.f12530a.clear();
            List list = montageMediaPickerAdapter.f12530a;
            Ordering a = Ordering.a(MediaResource.a);
            List arrayList = new ArrayList(immutableList.size());
            for (MediaResource mediaResource : immutableList) {
                if (Type.VIDEO.equals(mediaResource.d) || Type.PHOTO.equals(mediaResource.d)) {
                    arrayList.add(mediaResource);
                }
            }
            list.addAll(a.d(arrayList));
            montageMediaPickerAdapter.notifyDataSetChanged();
        }

        public final void m13003c(Object obj, Object obj2) {
            this.f12537a.m13008a(ViewState.ERROR);
        }
    }

    /* compiled from: is_new_sign_up_logged */
    public enum ViewState {
        LOADING,
        EMPTY,
        ERROR,
        CONTENT,
        REQUEST_PERMISSION
    }

    public static void m13004a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        MontageMediaPickerCanvasFragment montageMediaPickerCanvasFragment = (MontageMediaPickerCanvasFragment) obj;
        LocalMediaLoader b = LocalMediaLoader.m12315b(injectorLike);
        ActivitylessRuntimePermissionsManagerProvider activitylessRuntimePermissionsManagerProvider = (ActivitylessRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivitylessRuntimePermissionsManagerProvider.class);
        montageMediaPickerCanvasFragment.f12539a = b;
        montageMediaPickerCanvasFragment.f12540b = activitylessRuntimePermissionsManagerProvider;
    }

    public final void m13009c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = MontageMediaPickerCanvasFragment.class;
        m13004a((Object) this, getContext());
        this.f12546i = this.f12540b.m19957a(this);
    }

    public final View m13005a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1979778350);
        View inflate = layoutInflater.inflate(2130905325, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -624841414, a);
        return inflate;
    }

    public final void mo476a(View view, @Nullable Bundle bundle) {
        super.mo476a(view, bundle);
        this.f12541c = (ProgressBar) e(2131563968);
        this.f12542d = (RecyclerView) e(2131563724);
        this.f12543e = ViewStubHolder.a((ViewStubCompat) e(2131563970));
        this.f12544f = ViewStubHolder.a((ViewStubCompat) e(2131560575));
        this.f12545g = ViewStubHolder.a((ViewStubCompat) e(2131563969));
        this.am = new MontageMediaPickerAdapter();
        this.am.f12532c = new C13941(this);
        this.f12542d.setAdapter(this.am);
        this.f12542d.a(new GridSpacingItemDecoration(jW_().getDimensionPixelSize(2131433687)));
    }

    public final boolean lV_() {
        return false;
    }

    protected final void mo475a(View view, int i, int i2, int i3, int i4) {
        this.f12542d.setPadding(i, i2, i3, i4);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 177589706);
        super.mi_();
        if (this.f12546i.m19956a(f12538h)) {
            ar(this);
        } else {
            m13008a(ViewState.REQUEST_PERMISSION);
        }
        LogUtils.f(-1324448533, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1725253760);
        this.f12539a.a(null);
        this.f12539a.a();
        super.mj_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1003644237, a);
    }

    public final void m13008a(ViewState viewState) {
        this.f12543e.e();
        this.f12544f.e();
        this.f12541c.setVisibility(8);
        this.f12542d.setVisibility(8);
        this.f12545g.e();
        switch (viewState) {
            case LOADING:
                this.f12541c.setVisibility(0);
                return;
            case EMPTY:
                this.f12543e.f();
                return;
            case ERROR:
                this.f12544f.f();
                return;
            case CONTENT:
                this.f12542d.setVisibility(0);
                return;
            case REQUEST_PERMISSION:
                this.f12545g.f();
                ((PermissionRequestIconView) this.f12545g.a()).setButtonListener(new C13952(this));
                return;
            default:
                return;
        }
    }

    public static void ar(MontageMediaPickerCanvasFragment montageMediaPickerCanvasFragment) {
        montageMediaPickerCanvasFragment.m13008a(ViewState.LOADING);
        montageMediaPickerCanvasFragment.f12539a.a(new MediaLoaderCallback(montageMediaPickerCanvasFragment));
        montageMediaPickerCanvasFragment.f12539a.a(new LocalMediaLoaderParams(true));
    }
}
