package com.facebook.facecast.plugin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.facecast.FacecastFacepileView;
import com.facebook.facecast.FacecastStateManager;
import com.facebook.facecast.FacecastStateManager.FacecastBroadcastState;
import com.facebook.facecast.plugin.FacecastViewerFacepileController.ViewersDownloadedListener;
import com.facebook.facecast.protocol.FacecastNetworker;
import com.facebook.facecastdisplay.LiveEventAuthor;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.user.tiles.UserTileView;
import com.facebook.widget.text.BetterTextView;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: c3dd0c69136e578332a0662c045a38d9 */
public abstract class FacecastEndScreenBasePlugin extends FacecastBasePlugin {
    private static final String f18297g = FacecastEndScreenBasePlugin.class.getName();
    @Inject
    public FacecastAvatarHelper f18298c;
    @Inject
    public FacecastNetworker f18299d;
    @Inject
    public AbstractFbErrorReporter f18300e;
    @Inject
    public FacecastViewerFacepileControllerProvider f18301f;
    private final BetterTextView f18302h;
    private final FbButton f18303i = ((FbButton) a(2131561653));
    private final LinearLayout f18304j;
    private final UserTileView f18305k;
    private final BetterTextView f18306l;
    private final View f18307m;
    private final ViewStub f18308n;
    @Nullable
    private FacecastFacepileView f18309o;
    private final BetterTextView f18310p;
    @Nullable
    private FacecastViewerFacepileController f18311q;
    @Nullable
    public DoneButtonClickedListener f18312r;
    @Nullable
    private String f18313s;
    @Nullable
    private String f18314t;
    private long f18315u;
    private long f18316v;
    private int f18317w;

    /* compiled from: c3dd0c69136e578332a0662c045a38d9 */
    public interface DoneButtonClickedListener {
        void mo1394q();
    }

    /* compiled from: c3dd0c69136e578332a0662c045a38d9 */
    class C15511 implements OnClickListener {
        final /* synthetic */ FacecastEndScreenBasePlugin f18295a;

        C15511(FacecastEndScreenBasePlugin facecastEndScreenBasePlugin) {
            this.f18295a = facecastEndScreenBasePlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 923274149);
            this.f18295a.mo1441h();
            Logger.a(2, EntryType.UI_INPUT_END, 551759486, a);
        }
    }

    /* compiled from: c3dd0c69136e578332a0662c045a38d9 */
    class C15522 implements ViewersDownloadedListener {
        final /* synthetic */ FacecastEndScreenBasePlugin f18296a;

        C15522(FacecastEndScreenBasePlugin facecastEndScreenBasePlugin) {
            this.f18296a = facecastEndScreenBasePlugin;
        }

        public final void mo1416a(@Nullable List<LiveEventAuthor> list, int i) {
            FacecastEndScreenBasePlugin.m22027a(this.f18296a, list, i);
        }
    }

    public static void m22028a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        FacecastEndScreenBasePlugin facecastEndScreenBasePlugin = (FacecastEndScreenBasePlugin) obj;
        FacecastAvatarHelper b = FacecastAvatarHelper.m21967b(injectorLike);
        FacecastNetworker b2 = FacecastNetworker.m22307b(injectorLike);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike);
        FacecastViewerFacepileControllerProvider facecastViewerFacepileControllerProvider = (FacecastViewerFacepileControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FacecastViewerFacepileControllerProvider.class);
        facecastEndScreenBasePlugin.f18298c = b;
        facecastEndScreenBasePlugin.f18299d = b2;
        facecastEndScreenBasePlugin.f18300e = abstractFbErrorReporter;
        facecastEndScreenBasePlugin.f18301f = facecastViewerFacepileControllerProvider;
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    public FacecastEndScreenBasePlugin(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = FacecastEndScreenBasePlugin.class;
        m22028a((Object) this, getContext());
        setContentView(2130904206);
        this.f18303i.setOnClickListener(new C15511(this));
        this.f18304j = (LinearLayout) a(2131561652);
        this.f18305k = (UserTileView) a(2131561647);
        this.f18302h = (BetterTextView) a(2131561646);
        this.f18306l = (BetterTextView) a(2131561648);
        this.f18307m = a(2131561649);
        this.f18308n = (ViewStub) a(2131561650);
        this.f18310p = (BetterTextView) a(2131561651);
    }

    public void mo1440a(long j, long j2, String str, String str2, ComposerTargetData composerTargetData, int i) {
        CharSequence a = FacecastEndScreenUiUtil.m22037a(getResources(), j2, composerTargetData);
        if (a == null) {
            this.f18300e.a(f18297g + "_setBroadcastData", "Unsupported type " + composerTargetData.targetType + " for " + composerTargetData.targetId + " is called.");
        }
        this.f18306l.setText(a);
        this.f18305k.setParams(this.f18298c.m21968a(composerTargetData, getResources().getDimensionPixelSize(2131432313)));
        this.f18315u = j;
        this.f18316v = j2;
        this.f18313s = str;
        this.f18314t = str2;
        this.f18317w = i;
        this.f18311q = this.f18301f.m22181a(this.f18314t, this.f18315u, new C15522(this), getContext());
    }

    protected final void hE_() {
        super.hE_();
        if (this.f18166b.f18049c == FacecastBroadcastState.FACECAST_BROADCAST_STATE_COPYRIGHT_VIOLATION) {
            mo1417g();
            return;
        }
        if (this.f18311q != null) {
            this.f18311q.m22179a();
        }
        if (this.f18313s != null) {
            this.f18299d.m22308a(this.f18313s, this.f18317w, this.f18316v / 1000);
        }
    }

    protected final void mo1408a(ViewGroup viewGroup, FacecastStateManager facecastStateManager) {
        super.mo1408a(viewGroup, facecastStateManager);
        if (this.f18311q != null) {
            this.f18311q.m22180b();
        }
    }

    protected void mo1417g() {
        this.f18302h.setText(2131238247);
        this.f18306l.setText(2131238248);
        this.f18305k.setVisibility(8);
        m22029j();
    }

    public static void m22027a(@Nullable FacecastEndScreenBasePlugin facecastEndScreenBasePlugin, List list, int i) {
        if (list == null || list.isEmpty()) {
            facecastEndScreenBasePlugin.f18308n.setVisibility(8);
            facecastEndScreenBasePlugin.f18307m.setVisibility(8);
            facecastEndScreenBasePlugin.f18310p.setVisibility(8);
        } else {
            if (facecastEndScreenBasePlugin.f18309o == null) {
                facecastEndScreenBasePlugin.f18309o = (FacecastFacepileView) facecastEndScreenBasePlugin.f18308n.inflate();
            }
            List arrayList = new ArrayList();
            for (LiveEventAuthor liveEventAuthor : list) {
                arrayList.add(liveEventAuthor.f2903b);
            }
            facecastEndScreenBasePlugin.f18309o.setFBIDs(arrayList);
            if (facecastEndScreenBasePlugin.f18311q != null) {
                facecastEndScreenBasePlugin.f18310p.setText(facecastEndScreenBasePlugin.f18311q.m22178a(list, i));
                facecastEndScreenBasePlugin.f18310p.setVisibility(0);
            }
            facecastEndScreenBasePlugin.f18309o.setVisibility(0);
            facecastEndScreenBasePlugin.f18307m.setVisibility(0);
        }
        facecastEndScreenBasePlugin.m22029j();
    }

    private void m22029j() {
        this.f18304j.setVisibility(0);
        this.f18304j.getChildAt(0).setVisibility(0);
        this.f18304j.setAlpha(0.0f);
        this.f18304j.setTranslationY((float) getResources().getDimensionPixelOffset(2131432329));
        this.f18304j.animate().alpha(1.0f).translationY(0.0f).setInterpolator(new AccelerateDecelerateInterpolator());
    }

    public void mo1441h() {
        if (this.f18312r != null) {
            this.f18312r.mo1394q();
        }
    }

    public final void m22034i() {
        this.f18299d.m22309b(this.f18313s);
    }
}
