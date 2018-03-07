package com.facebook.composer.facecast.feedattachment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass11;
import com.facebook.composer.activity.TransactionImpl;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.facecast.feedattachment.FacecastComposerAttachmentView.Listener;
import com.facebook.composer.facecast.feedattachment.FacecastComposerStateController.FacecastComposerState;
import com.facebook.composer.facecast.feedattachment.FacecastComposerStateController.FacecastComposerStateChangedListener;
import com.facebook.facecast.FacecastStateManager;
import com.facebook.facecast.plugin.FacecastComposerPreviewPlugin;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachment.Builder;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerMutator;
import com.facebook.ipc.composer.dataaccessor.ComposerTransaction;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerFacecastInfo;
import com.facebook.ipc.composer.model.ComposerFacecastInfo.ProvidesFacecastInfo;
import com.facebook.ipc.composer.model.ComposerFacecastInfo.SetsFacecastInfo;
import com.facebook.runtimepermissions.AbstractRuntimePermissionsListener;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.video.videostreaming.LiveStreamer;
import com.facebook.video.videostreaming.protocol.VideoBroadcastInitResponse;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: guest_list_tab_load_failure */
public class FacecastComposerAttachmentController<DataProvider extends ProvidesTargetData & ProvidesFacecastInfo, Transaction extends ComposerTransaction & SetsFacecastInfo<Transaction>> implements Listener, FacecastComposerStateChangedListener {
    public static final ComposerEventOriginator f6383a = ComposerEventOriginator.a(FacecastComposerAttachmentController.class);
    private static final ImmutableList<GraphQLStoryAttachmentStyle> f6384b = ImmutableList.of(GraphQLStoryAttachmentStyle.FALLBACK);
    public static final String[] f6385c = new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    public final WeakReference<DataProvider> f6386d;
    public final ComposerMutator<Transaction> f6387e;
    private final InputMethodManager f6388f;
    public final Context f6389g;
    private final FacecastComposerStateControllerProvider f6390h;
    public FacecastComposerAttachmentView f6391i;
    private FacecastStateManager f6392j;
    public FacecastComposerPreviewPlugin f6393k;
    private ListenableFuture<GraphQLStoryAttachment> f6394l;
    @Nullable
    public AlertDialog f6395m;
    private View f6396n;
    public FacecastComposerStateController f6397o;
    public ActivityRuntimePermissionsManager f6398p;
    private AnonymousClass11 f6399q;
    private String f6400r;
    private String f6401s;

    /* compiled from: guest_list_tab_load_failure */
    public class C08021 extends AbstractRuntimePermissionsListener {
        final /* synthetic */ FacecastComposerAttachmentController f6380a;
        final /* synthetic */ FacecastComposerAttachmentController f6381b;

        public C08021(FacecastComposerAttachmentController facecastComposerAttachmentController, FacecastComposerAttachmentController facecastComposerAttachmentController2) {
            this.f6381b = facecastComposerAttachmentController;
            this.f6380a = facecastComposerAttachmentController2;
        }

        public final void m7808a() {
            FacecastComposerAttachmentController.m7825q(this.f6381b);
            FacecastComposerAttachmentController.m7827v(this.f6381b);
            if (!this.f6381b.f6397o.m7856b()) {
                this.f6381b.f6397o.f6430i = this.f6380a;
                this.f6381b.f6397o.f6431j = this.f6380a;
                this.f6381b.f6397o.m7857c();
            }
            this.f6381b.f6391i.setState(FacecastComposerState.LOADING);
        }
    }

    /* compiled from: guest_list_tab_load_failure */
    public class C08032 implements OnDismissListener {
        final /* synthetic */ FacecastComposerAttachmentController f6382a;

        public C08032(FacecastComposerAttachmentController facecastComposerAttachmentController) {
            this.f6382a = facecastComposerAttachmentController;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            FacecastComposerAttachmentController.m7823a(this.f6382a, false);
            this.f6382a.m7840h();
        }
    }

    public final Optional<GraphQLStoryAttachment> m7831a(Throwable th) {
        return Absent.INSTANCE;
    }

    @Inject
    public FacecastComposerAttachmentController(FacecastStateManager facecastStateManager, Context context, FacecastComposerStateControllerProvider facecastComposerStateControllerProvider, InputMethodManager inputMethodManager, @Assisted DataProvider dataProvider, @Assisted ComposerMutator<Transaction> composerMutator, @Assisted ActivityRuntimePermissionsManager activityRuntimePermissionsManager, @Assisted FacecastAttachmentVisibilityListener facecastAttachmentVisibilityListener) {
        this.f6392j = facecastStateManager;
        this.f6389g = context;
        this.f6386d = new WeakReference(Preconditions.checkNotNull(dataProvider));
        this.f6387e = composerMutator;
        this.f6388f = inputMethodManager;
        this.f6398p = activityRuntimePermissionsManager;
        this.f6399q = facecastAttachmentVisibilityListener;
        this.f6390h = facecastComposerStateControllerProvider;
    }

    public final List<GraphQLStoryAttachmentStyle> m7835c() {
        return f6384b;
    }

    public final View m7830a(GraphQLStoryAttachment graphQLStoryAttachment, ViewGroup viewGroup) {
        boolean z;
        if (this.f6391i == null) {
            m7824p();
        }
        this.f6391i.setState(this.f6397o.f6425d);
        if (this.f6397o.f6425d == FacecastComposerState.READY) {
            z = true;
        } else {
            z = false;
        }
        m7823a(this, z);
        return this.f6391i;
    }

    public final ListenableFuture<GraphQLStoryAttachment> m7836d() {
        if (this.f6394l == null) {
            Builder builder = new Builder();
            builder.q = f6384b;
            this.f6394l = Futures.a(builder.a());
        }
        return this.f6394l;
    }

    public final boolean m7837e() {
        ComposerFacecastInfo e = ((ComposerDataProviderImpl) ((ProvidesTargetData) Preconditions.checkNotNull(this.f6386d.get()))).m7429e();
        return (e == null || e.facecastCameraIndex == -1) ? false : true;
    }

    public final boolean m7838f() {
        return false;
    }

    public final View m7829a(Context context, ViewGroup viewGroup) {
        if (this.f6396n == null) {
            this.f6396n = new View(this.f6389g);
        }
        return this.f6396n;
    }

    public final String m7839g() {
        if (this.f6397o == null) {
            return "facecast_attachment:";
        }
        return "facecast_attachment:" + this.f6397o.f6425d;
    }

    public final void m7840h() {
        TransactionImpl a = this.f6387e.m7626a(f6383a);
        ComposerFacecastInfo.Builder builder = new ComposerFacecastInfo.Builder(((ComposerDataProviderImpl) ((ProvidesTargetData) Preconditions.checkNotNull(this.f6386d.get()))).m7429e());
        builder.a = -1;
        ((TransactionImpl) a.m7684a(builder.a())).m7689a();
        this.f6397o.m7858d();
        this.f6391i.m7848a();
    }

    public final void m7841i() {
    }

    public final View m7842j() {
        if (this.f6391i == null) {
            m7824p();
        }
        return this.f6391i.f6410d;
    }

    public final boolean m7843k() {
        return true;
    }

    public final void m7833b() {
        m7826u();
    }

    public final void m7834b(int i) {
        boolean z;
        ComposerFacecastInfo e = ((ComposerDataProviderImpl) ((ProvidesTargetData) Preconditions.checkNotNull(this.f6386d.get()))).m7429e();
        boolean z2 = (e == null || e.facecastCameraIndex == -1) ? false : true;
        if (e == null || !e.shouldRefetchBroadcastId) {
            z = false;
        } else {
            z = true;
        }
        AnonymousClass11 anonymousClass11 = this.f6399q;
        if (i == 0) {
            anonymousClass11.f6039a.o().setRequestedOrientation(1);
        } else {
            anonymousClass11.f6039a.o().setRequestedOrientation(-1);
        }
        if (i == 0) {
            m7826u();
            if (this.f6397o.f6425d == FacecastComposerState.CAMERA_PERMISSION_DENIED) {
                m7828w();
                return;
            }
            if (!this.f6393k.c) {
                this.f6391i.m7849a(this.f6393k, this.f6392j);
            }
            m7827v(this);
            if (z) {
                this.f6391i.setState(FacecastComposerState.LOADING);
                m7823a(this, false);
            }
            if (!this.f6397o.m7856b()) {
                this.f6397o.f6430i = this;
                this.f6397o.f6431j = this;
                this.f6397o.m7857c();
            }
        } else if (this.f6397o.f6425d != FacecastComposerState.CAMERA_PERMISSION_DENIED) {
            int i2;
            FacecastComposerPreviewPlugin facecastComposerPreviewPlugin = this.f6393k;
            if (facecastComposerPreviewPlugin.j()) {
                facecastComposerPreviewPlugin.k.a(1, null);
            }
            TransactionImpl a = this.f6387e.m7626a(f6383a);
            ComposerFacecastInfo.Builder builder = new ComposerFacecastInfo.Builder(((ComposerDataProviderImpl) ((ProvidesTargetData) Preconditions.checkNotNull(this.f6386d.get()))).m7429e());
            if (this.f6393k != null) {
                int e2;
                FacecastComposerPreviewPlugin facecastComposerPreviewPlugin2 = this.f6393k;
                if (facecastComposerPreviewPlugin2.j() && facecastComposerPreviewPlugin2.k.d()) {
                    e2 = facecastComposerPreviewPlugin2.k.e();
                } else {
                    e2 = 0;
                }
                i2 = e2;
            } else {
                i2 = 0;
            }
            builder.b = i2;
            ((TransactionImpl) a.m7684a(builder.a())).m7689a();
            if (!z2) {
                this.f6397o.m7858d();
                this.f6391i.m7848a();
                this.f6393k.c();
                m7823a(this, false);
                this.f6397o.f6430i = null;
                this.f6397o.f6431j = null;
            }
        }
    }

    public final void m7844m() {
        this.f6391i.setState(FacecastComposerState.LOADING);
        this.f6397o.m7857c();
    }

    public final void m7845n() {
        m7826u();
    }

    public final void m7832a(VideoBroadcastInitResponse videoBroadcastInitResponse) {
        TransactionImpl a = this.f6387e.m7626a(f6383a);
        ComposerFacecastInfo.Builder builder = new ComposerFacecastInfo.Builder(((ComposerDataProviderImpl) ((ProvidesTargetData) Preconditions.checkNotNull(this.f6386d.get()))).m7429e());
        builder.d = videoBroadcastInitResponse;
        ((TransactionImpl) a.m7684a(builder.a())).m7689a();
    }

    public final void m7846o() {
        ProvidesTargetData providesTargetData = (ProvidesTargetData) Preconditions.checkNotNull(this.f6386d.get());
        if (providesTargetData != null && ((ComposerDataProviderImpl) providesTargetData).m7429e().shouldRefetchBroadcastId) {
            TransactionImpl a = this.f6387e.m7626a(f6383a);
            ComposerFacecastInfo.Builder builder = new ComposerFacecastInfo.Builder(((ComposerDataProviderImpl) providesTargetData).m7429e());
            builder.e = false;
            ((TransactionImpl) a.m7684a(builder.a())).m7689a();
            this.f6397o.f6430i = this;
            this.f6397o.f6431j = this;
            this.f6397o.m7857c();
        }
    }

    private void m7824p() {
        ProvidesTargetData providesTargetData = (ProvidesTargetData) Preconditions.checkNotNull(this.f6386d.get());
        if (this.f6397o == null) {
            FacecastComposerState facecastComposerState;
            FacecastComposerStateControllerProvider facecastComposerStateControllerProvider = this.f6390h;
            ComposerTargetData s = providesTargetData.s();
            if (this.f6398p.a(f6385c)) {
                facecastComposerState = FacecastComposerState.LOADING;
            } else {
                facecastComposerState = FacecastComposerState.CAMERA_PERMISSION_DENIED;
            }
            this.f6397o = new FacecastComposerStateController(LiveStreamer.a(facecastComposerStateControllerProvider), Handler_ForUiThreadMethodAutoProvider.b(facecastComposerStateControllerProvider), s, facecastComposerState);
        }
        this.f6391i = new FacecastComposerAttachmentView(this.f6389g);
        this.f6391i.f6408b = this;
        m7828w();
        this.f6397o.f6430i = this;
        this.f6391i.m7850a(this.f6401s, this.f6400r);
        if (this.f6397o.f6425d != FacecastComposerState.CAMERA_PERMISSION_DENIED) {
            m7825q(this);
        }
    }

    public static void m7825q(FacecastComposerAttachmentController facecastComposerAttachmentController) {
        ProvidesTargetData providesTargetData = (ProvidesTargetData) Preconditions.checkNotNull(facecastComposerAttachmentController.f6386d.get());
        facecastComposerAttachmentController.f6393k = new FacecastComposerPreviewPlugin(facecastComposerAttachmentController.f6389g);
        facecastComposerAttachmentController.f6393k.l = facecastComposerAttachmentController;
        if (!(providesTargetData == null || ((ComposerDataProviderImpl) providesTargetData).m7429e().facecastCameraIndex == -1)) {
            facecastComposerAttachmentController.f6393k.m = ((ComposerDataProviderImpl) providesTargetData).m7429e().facecastCameraIndex;
        }
        facecastComposerAttachmentController.f6391i.m7849a(facecastComposerAttachmentController.f6393k, facecastComposerAttachmentController.f6392j);
    }

    public static void m7823a(FacecastComposerAttachmentController facecastComposerAttachmentController, boolean z) {
        TransactionImpl a = facecastComposerAttachmentController.f6387e.m7626a(f6383a);
        ComposerFacecastInfo.Builder builder = new ComposerFacecastInfo.Builder(((ComposerDataProviderImpl) ((ProvidesTargetData) Preconditions.checkNotNull(facecastComposerAttachmentController.f6386d.get()))).m7429e());
        builder.c = z;
        ((TransactionImpl) a.m7684a(builder.a())).m7689a();
    }

    private void m7826u() {
        this.f6388f.hideSoftInputFromWindow(this.f6391i.getWindowToken(), 0);
    }

    public static void m7827v(FacecastComposerAttachmentController facecastComposerAttachmentController) {
        if (!facecastComposerAttachmentController.f6393k.j()) {
            Object obj;
            FacecastComposerPreviewPlugin facecastComposerPreviewPlugin = facecastComposerAttachmentController.f6393k;
            if (!facecastComposerPreviewPlugin.j()) {
                facecastComposerPreviewPlugin.k.a(2, Integer.valueOf(FacecastComposerPreviewPlugin.getCurrentRotation(facecastComposerPreviewPlugin)));
            }
            facecastComposerPreviewPlugin = facecastComposerAttachmentController.f6393k;
            if (facecastComposerPreviewPlugin.h.l != null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                facecastComposerPreviewPlugin.h.a(facecastComposerPreviewPlugin.g, null, 1.0f);
                facecastComposerPreviewPlugin.h.a(facecastComposerPreviewPlugin.d.getLooper());
            }
        }
    }

    private void m7828w() {
        int i = 2;
        int i2 = 1;
        int i3 = 0;
        String[] stringArray = this.f6389g.getResources().getStringArray(2131755096);
        String[] stringArray2 = this.f6389g.getResources().getStringArray(2131755095);
        boolean a = this.f6398p.a(new String[]{"android.permission.CAMERA"});
        boolean a2 = this.f6398p.a(new String[]{"android.permission.RECORD_AUDIO"});
        boolean a3 = this.f6398p.a(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"});
        if (a) {
            i2 = 0;
        }
        if (a2) {
            i = 0;
        }
        i |= i2;
        if (!a3) {
            i3 = 4;
        }
        i3 |= i;
        if (i3 != 0 && i3 <= stringArray.length) {
            this.f6400r = stringArray[i3 - 1];
            this.f6401s = stringArray2[i3 - 1];
        }
    }
}
