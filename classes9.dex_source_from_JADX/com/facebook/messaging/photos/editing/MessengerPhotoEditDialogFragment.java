package com.facebook.messaging.photos.editing;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.tempfile.TempFileManager.Privacy;
import com.facebook.common.ui.util.ViewOrientationLockHelper;
import com.facebook.common.ui.util.ViewOrientationLockHelperProvider;
import com.facebook.debug.log.BLog;
import com.facebook.drawingview.DrawingView;
import com.facebook.drawingview.DrawingView.DrawingListener;
import com.facebook.drawingview.DrawingView.OnDrawingClearedListener;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.TooManyBitmapsException;
import com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException;
import com.facebook.imagepipeline.module.PlatformBitmapFactoryMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.doodle.CaptionEditorView;
import com.facebook.messaging.doodle.ColourIndicator;
import com.facebook.messaging.doodle.ColourPicker;
import com.facebook.messaging.doodle.ColourPicker.OnColourPickerInteractionListener;
import com.facebook.messaging.fullscreendialog.FullScreenDialogFragment;
import com.facebook.messaging.fullscreendialog.FullScreenDialogParams;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.photos.editing.abtest.ExperimentsForPhotoEditingModule;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.ultralight.Inject;
import com.google.common.base.Preconditions;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;

/* compiled from: mBookmarksGroups */
public class MessengerPhotoEditDialogFragment extends FullScreenDialogFragment {
    private static final Class<?> am = MessengerPhotoEditDialogFragment.class;
    public CaptionEditorView aA;
    public View aB;
    private ViewOrientationLockHelper aC;
    private ValueAnimator aD;
    @Nullable
    public PhotoEditingController aE;
    public PhotoEditingConfig aF;
    public View aG;
    public View aH;
    public ImageButton aI;
    public ImageButton aJ;
    public ImageButton aK;
    public View aL;
    public View aM;
    public View aN;
    public ColourIndicator aO;
    public ColourPicker aP;
    private Bitmap aQ;
    public View aR;
    public View aS;
    public boolean aT;
    @Inject
    public AnalyticsLogger an;
    @Inject
    public PhotoEditingControllerProvider ao;
    @Inject
    public PlatformBitmapFactory ap;
    @Inject
    private QeAccessor aq;
    @Inject
    private TempFileManager ar;
    @Inject
    private Toaster as;
    @Inject
    private ViewOrientationLockHelperProvider at;
    public ThreadKey au;
    private Uri av;
    private MediaResource aw;
    public Listener ax;
    public ImageView ay;
    public DrawingView az;

    /* compiled from: mBookmarksGroups */
    public interface Listener {
        void mo456a();

        void mo457a(MediaResource mediaResource);

        void mo458b(MediaResource mediaResource);
    }

    /* compiled from: mBookmarksGroups */
    class C18801 implements OnKeyListener {
        final /* synthetic */ MessengerPhotoEditDialogFragment f16060a;

        C18801(MessengerPhotoEditDialogFragment messengerPhotoEditDialogFragment) {
            this.f16060a = messengerPhotoEditDialogFragment;
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 1 || i != 4) {
                return false;
            }
            if (this.f16060a.aF.f16071b && this.f16060a.aE != null && this.f16060a.aE.m16255c()) {
                this.f16060a.aE.m16253a();
                return true;
            } else if (!MessengerPhotoEditDialogFragment.ay(this.f16060a)) {
                return false;
            } else {
                MessengerPhotoEditDialogFragment.az(this.f16060a);
                return true;
            }
        }
    }

    /* compiled from: mBookmarksGroups */
    public class C18812 implements com.facebook.messaging.photos.editing.PhotoEditingController.Listener {
        final /* synthetic */ MessengerPhotoEditDialogFragment f16061a;

        public C18812(MessengerPhotoEditDialogFragment messengerPhotoEditDialogFragment) {
            this.f16061a = messengerPhotoEditDialogFragment;
        }

        public final void mo442a() {
            MessengerPhotoEditDialogFragment messengerPhotoEditDialogFragment = this.f16061a;
            if (messengerPhotoEditDialogFragment.aE != null) {
                if (messengerPhotoEditDialogFragment.aE.f16093n || messengerPhotoEditDialogFragment.aE.f16092m) {
                    messengerPhotoEditDialogFragment.aM.setVisibility(8);
                } else {
                    messengerPhotoEditDialogFragment.aM.setVisibility(0);
                }
            }
            if (messengerPhotoEditDialogFragment.aE != null) {
                if (messengerPhotoEditDialogFragment.aE.f16093n || messengerPhotoEditDialogFragment.aE.f16092m) {
                    messengerPhotoEditDialogFragment.aK.setVisibility(8);
                } else {
                    messengerPhotoEditDialogFragment.aK.setVisibility(0);
                }
            }
            if (messengerPhotoEditDialogFragment.aE != null) {
                if (messengerPhotoEditDialogFragment.aE.f16093n || messengerPhotoEditDialogFragment.aE.f16092m) {
                    messengerPhotoEditDialogFragment.aN.setVisibility(8);
                } else {
                    messengerPhotoEditDialogFragment.aN.setVisibility(0);
                }
            }
        }

        public final void mo443b() {
            this.f16061a.aS.requestFocus();
        }
    }

    /* compiled from: mBookmarksGroups */
    public class C18823 implements OnTouchListener {
        final /* synthetic */ MessengerPhotoEditDialogFragment f16062a;

        public C18823(MessengerPhotoEditDialogFragment messengerPhotoEditDialogFragment) {
            this.f16062a = messengerPhotoEditDialogFragment;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == 1) {
                this.f16062a.aA.g();
            }
            return true;
        }
    }

    /* compiled from: mBookmarksGroups */
    public class C18834 implements OnClickListener {
        final /* synthetic */ MessengerPhotoEditDialogFragment f16063a;

        public C18834(MessengerPhotoEditDialogFragment messengerPhotoEditDialogFragment) {
            this.f16063a = messengerPhotoEditDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1216242047);
            MessengerPhotoEditDialogFragment.aA(this.f16063a);
            Logger.a(2, EntryType.UI_INPUT_END, -935906352, a);
        }
    }

    /* compiled from: mBookmarksGroups */
    public class C18845 implements OnClickListener {
        final /* synthetic */ MessengerPhotoEditDialogFragment f16064a;

        public C18845(MessengerPhotoEditDialogFragment messengerPhotoEditDialogFragment) {
            this.f16064a = messengerPhotoEditDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 356517900);
            if (MessengerPhotoEditDialogFragment.ay(this.f16064a)) {
                MessengerPhotoEditDialogFragment.az(this.f16064a);
            } else {
                this.f16064a.a();
            }
            LogUtils.a(1656498583, a);
        }
    }

    /* compiled from: mBookmarksGroups */
    public class C18856 implements OnFocusChangeListener {
        final /* synthetic */ MessengerPhotoEditDialogFragment f16065a;

        public C18856(MessengerPhotoEditDialogFragment messengerPhotoEditDialogFragment) {
            this.f16065a = messengerPhotoEditDialogFragment;
        }

        public void onFocusChange(View view, boolean z) {
            if (this.f16065a.aA.a()) {
                MessengerPhotoEditDialogFragment.m16214a(this.f16065a, 1, this.f16065a.aH);
                this.f16065a.aH.setVisibility(8);
            } else {
                MessengerPhotoEditDialogFragment.m16214a(this.f16065a, 0, this.f16065a.aH);
                this.f16065a.aH.setVisibility(0);
            }
            this.f16065a.aH.invalidate();
        }
    }

    /* compiled from: mBookmarksGroups */
    public class C18867 implements DrawingListener {
        final /* synthetic */ MessengerPhotoEditDialogFragment f16066a;

        public C18867(MessengerPhotoEditDialogFragment messengerPhotoEditDialogFragment) {
            this.f16066a = messengerPhotoEditDialogFragment;
        }

        public final void m16207a() {
            MessengerPhotoEditDialogFragment.m16214a(this.f16066a, 1, this.f16066a.aR);
        }

        public final void m16208b() {
            this.f16066a.aL.setVisibility(0);
            MessengerPhotoEditDialogFragment.m16214a(this.f16066a, 0, this.f16066a.aR);
        }
    }

    /* compiled from: mBookmarksGroups */
    public class C18878 implements OnDrawingClearedListener {
        final /* synthetic */ MessengerPhotoEditDialogFragment f16067a;

        public C18878(MessengerPhotoEditDialogFragment messengerPhotoEditDialogFragment) {
            this.f16067a = messengerPhotoEditDialogFragment;
        }

        public final void m16209a() {
            this.f16067a.aL.setVisibility(8);
        }
    }

    /* compiled from: mBookmarksGroups */
    public class C18889 implements OnClickListener {
        final /* synthetic */ MessengerPhotoEditDialogFragment f16068a;

        public C18889(MessengerPhotoEditDialogFragment messengerPhotoEditDialogFragment) {
            this.f16068a = messengerPhotoEditDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -885422115);
            this.f16068a.az.b();
            this.f16068a.az.invalidate();
            Logger.a(2, EntryType.UI_INPUT_END, 1739034412, a);
        }
    }

    public static void m16215a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((MessengerPhotoEditDialogFragment) obj).m16213a(AnalyticsLoggerMethodAutoProvider.a(fbInjector), (PhotoEditingControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PhotoEditingControllerProvider.class), PlatformBitmapFactoryMethodAutoProvider.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), TempFileManager.a(fbInjector), Toaster.b(fbInjector), (ViewOrientationLockHelperProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ViewOrientationLockHelperProvider.class));
    }

    private void m16213a(AnalyticsLogger analyticsLogger, PhotoEditingControllerProvider photoEditingControllerProvider, PlatformBitmapFactory platformBitmapFactory, QeAccessor qeAccessor, TempFileManager tempFileManager, Toaster toaster, ViewOrientationLockHelperProvider viewOrientationLockHelperProvider) {
        this.an = analyticsLogger;
        this.ao = photoEditingControllerProvider;
        this.ap = platformBitmapFactory;
        this.aq = qeAccessor;
        this.ar = tempFileManager;
        this.as = toaster;
        this.at = viewOrientationLockHelperProvider;
    }

    public static MessengerPhotoEditDialogFragment m16212a(MediaResource mediaResource, FullScreenDialogParams fullScreenDialogParams, boolean z) {
        MessengerPhotoEditDialogFragment messengerPhotoEditDialogFragment = new MessengerPhotoEditDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("arg_media_resource", mediaResource);
        bundle.putBoolean("arg_send_edited_media", z);
        fullScreenDialogParams.a(bundle);
        messengerPhotoEditDialogFragment.g(bundle);
        return messengerPhotoEditDialogFragment;
    }

    public final void m16220a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1035240870);
        super.a(bundle);
        Class cls = MessengerPhotoEditDialogFragment.class;
        m16215a((Object) this, getContext());
        this.aF = new PhotoEditingConfig(this.aq.a(ExperimentsForPhotoEditingModule.f16300c, false), this.aq.a(ExperimentsForPhotoEditingModule.f16299b, false), this.aq.a(ExperimentsForPhotoEditingModule.f16298a, false), this.s.getBoolean("arg_send_edited_media", false));
        this.aT = this.aF.m16227b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1348740136, a);
    }

    public final Dialog m16222c(Bundle bundle) {
        Dialog c = super.c(bundle);
        c.setOnKeyListener(new C18801(this));
        return c;
    }

    public final View m16218a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1469579659);
        if (this.aT) {
            this.aS = layoutInflater.inflate(2130905817, viewGroup, false);
            this.f.getWindow().setSoftInputMode(48);
            View view = this.aS;
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1710944902, a);
            return view;
        }
        view = layoutInflater.inflate(2130906191, viewGroup, false);
        LogUtils.f(1572579069, a);
        return view;
    }

    public final void m16221a(View view, Bundle bundle) {
        super.a(view, bundle);
        if (this.aT) {
            this.aE = this.ao.m16266a(this.aF, (ViewGroup) this.aS, (LayerGroupLayout) this.aS.findViewById(2131564008), (PhotoEditingControlsLayout) this.aS.findViewById(2131565045), (TextStylesLayout) view.findViewById(2131565047), (ImageWithTextView) view.findViewById(2131565046));
            this.aE.m16257h();
            this.aE.m16256d();
            this.aE.f16091l = new C18812(this);
            return;
        }
        view.setOnTouchListener(new C18823(this));
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 219984112);
        super.mi_();
        this.aC = this.at.a(this.T);
        this.aC.a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1246897876, a);
    }

    public final void m16223d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1537364778);
        super.d(bundle);
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            this.aw = (MediaResource) bundle2.getParcelable("arg_media_resource");
        }
        Preconditions.checkNotNull(this.aw);
        this.av = this.aw.c;
        this.ay = (ImageView) e(2131565043);
        this.aQ = aC();
        this.ay.setImageBitmap(this.aQ);
        if (this.aT) {
            this.aK = (ImageButton) e(2131562049);
            if (this.aF.f16073d) {
                this.aK.setImageDrawable(ContextCompat.a(getContext(), 2130838035));
            }
            this.aK.setOnClickListener(new C18834(this));
            this.aM = e(2131560414);
            this.aM.setOnClickListener(new C18845(this));
            this.aN = e(2131565044);
            this.aN.getBackground().mutate().setAlpha(100);
        } else {
            this.aB = e(2131565888);
            this.aR = e(2131565890);
            this.aG = e(2131565891);
            this.aH = e(2131565894);
            this.aA = (CaptionEditorView) e(2131565889);
            this.aA.setOnFocusChangeListener(new C18856(this));
            this.az = (DrawingView) e(2131560061);
            this.az.d = new C18867(this);
            this.az.n = new C18878(this);
            this.aL = e(2131565895);
            this.aL.setOnClickListener(new C18889(this));
            this.aK = (ImageButton) e(2131565897);
            if (this.aF.f16073d) {
                this.aK.setImageDrawable(ContextCompat.a(getContext(), 2130838035));
            }
            this.aK.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ MessengerPhotoEditDialogFragment f16048a;

                {
                    this.f16048a = r1;
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1773016821);
                    MessengerPhotoEditDialogFragment.aA(this.f16048a);
                    Logger.a(2, EntryType.UI_INPUT_END, -1485157793, a);
                }
            });
            this.aM = e(2131565896);
            this.aM.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ MessengerPhotoEditDialogFragment f16049a;

                {
                    this.f16049a = r1;
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -679684004);
                    if (MessengerPhotoEditDialogFragment.ay(this.f16049a)) {
                        MessengerPhotoEditDialogFragment.az(this.f16049a);
                    } else {
                        this.f16049a.a();
                    }
                    LogUtils.a(-416984821, a);
                }
            });
            this.aO = (ColourIndicator) e(2131561074);
            this.aP = (ColourPicker) e(2131561075);
            this.aP.c = new OnColourPickerInteractionListener(this) {
                final /* synthetic */ MessengerPhotoEditDialogFragment f16050a;

                {
                    this.f16050a = r1;
                }

                public final void m16204a(int i, float f, float f2, float f3) {
                    this.f16050a.aO.a(i, f, f2, f3);
                    this.f16050a.az.setStrokeWidth(f3);
                    this.f16050a.az.setColour(i);
                }

                public final void m16203a(int i) {
                    this.f16050a.aO.setColour(i);
                    this.f16050a.aO.a();
                    this.f16050a.az.setColour(i);
                }
            };
            this.aI = (ImageButton) e(2131565892);
            this.aI.setSelected(true);
            this.aI.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ MessengerPhotoEditDialogFragment f16051a;

                {
                    this.f16051a = r1;
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 502838171);
                    if (!this.f16051a.aI.isSelected()) {
                        if (!this.f16051a.aT) {
                            MessengerPhotoEditDialogFragment.ax(this.f16051a);
                        }
                        this.f16051a.az.setEnabled(true);
                        if (this.f16051a.az.c()) {
                            this.f16051a.aL.setVisibility(0);
                        }
                        this.f16051a.aI.setSelected(true);
                        this.f16051a.aP.setVisibility(0);
                        this.f16051a.aO.setVisibility(0);
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, -105242314, a);
                }
            });
            this.aJ = (ImageButton) e(2131565893);
            this.aJ.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ MessengerPhotoEditDialogFragment f16052a;

                {
                    this.f16052a = r1;
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1965098581);
                    MessengerPhotoEditDialogFragment messengerPhotoEditDialogFragment = this.f16052a;
                    if (!messengerPhotoEditDialogFragment.aJ.isSelected()) {
                        if (!messengerPhotoEditDialogFragment.aT) {
                            MessengerPhotoEditDialogFragment.ax(messengerPhotoEditDialogFragment);
                        }
                        messengerPhotoEditDialogFragment.aA.setEnabled(true);
                        messengerPhotoEditDialogFragment.aJ.setSelected(true);
                        messengerPhotoEditDialogFragment.aA.b();
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, -2099899831, a);
                }
            });
        }
        LogUtils.f(-263013633, a);
    }

    public static void m16214a(MessengerPhotoEditDialogFragment messengerPhotoEditDialogFragment, int i, final View view) {
        float f = i == 0 ? 1.0f : 0.0f;
        if (messengerPhotoEditDialogFragment.aD != null) {
            messengerPhotoEditDialogFragment.aD.cancel();
        }
        messengerPhotoEditDialogFragment.aD = ValueAnimator.ofFloat(new float[]{view.getAlpha(), f});
        messengerPhotoEditDialogFragment.aD.addUpdateListener(new AnimatorUpdateListener(messengerPhotoEditDialogFragment) {
            final /* synthetic */ MessengerPhotoEditDialogFragment f16054b;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (i == 1) {
            messengerPhotoEditDialogFragment.aD.setStartDelay(200);
        }
        view.setEnabled(i == 0);
        messengerPhotoEditDialogFragment.aD.start();
    }

    public static void ax(MessengerPhotoEditDialogFragment messengerPhotoEditDialogFragment) {
        messengerPhotoEditDialogFragment.aA.setEnabled(false);
        messengerPhotoEditDialogFragment.az.setEnabled(false);
        messengerPhotoEditDialogFragment.aJ.setSelected(false);
        messengerPhotoEditDialogFragment.aI.setSelected(false);
        messengerPhotoEditDialogFragment.aL.setVisibility(8);
        messengerPhotoEditDialogFragment.aP.setVisibility(8);
        messengerPhotoEditDialogFragment.aO.setVisibility(8);
    }

    public static boolean ay(MessengerPhotoEditDialogFragment messengerPhotoEditDialogFragment) {
        if (!messengerPhotoEditDialogFragment.aT || messengerPhotoEditDialogFragment.aE == null) {
            return messengerPhotoEditDialogFragment.aA.f() || messengerPhotoEditDialogFragment.az.c();
        } else {
            return messengerPhotoEditDialogFragment.aE.m16254b();
        }
    }

    public static void az(MessengerPhotoEditDialogFragment messengerPhotoEditDialogFragment) {
        final HoneyClientEvent honeyClientEvent = new HoneyClientEvent("back_button_dialog_photo_edit_shown");
        final Dialog dialog = messengerPhotoEditDialogFragment.f;
        if (!messengerPhotoEditDialogFragment.aT) {
            honeyClientEvent.a("has_caption", messengerPhotoEditDialogFragment.aA.f());
            honeyClientEvent.a("has_drawing", messengerPhotoEditDialogFragment.az.c());
        }
        new FbAlertDialogBuilder(dialog.getContext()).a(2131232207).b(2131232208).b(2131232209, new DialogInterface.OnClickListener(messengerPhotoEditDialogFragment) {
            final /* synthetic */ MessengerPhotoEditDialogFragment f16059b;

            public void onClick(DialogInterface dialogInterface, int i) {
                honeyClientEvent.a("discarded_changes", false);
                this.f16059b.an.c(honeyClientEvent);
                dialogInterface.dismiss();
            }
        }).a(2131232210, new DialogInterface.OnClickListener(messengerPhotoEditDialogFragment) {
            final /* synthetic */ MessengerPhotoEditDialogFragment f16057c;

            public void onClick(DialogInterface dialogInterface, int i) {
                honeyClientEvent.a("discarded_changes", true);
                this.f16057c.an.c(honeyClientEvent);
                if (this.f16057c.aT && this.f16057c.aE != null) {
                    this.f16057c.aE.m16265t();
                }
                dialogInterface.dismiss();
                dialog.dismiss();
            }
        }).b();
    }

    public static void aA(MessengerPhotoEditDialogFragment messengerPhotoEditDialogFragment) {
        if (messengerPhotoEditDialogFragment.ax != null) {
            if (!messengerPhotoEditDialogFragment.aT) {
                ax(messengerPhotoEditDialogFragment);
            }
            CloseableReference closeableReference = null;
            try {
                closeableReference = messengerPhotoEditDialogFragment.aB();
                messengerPhotoEditDialogFragment.av = messengerPhotoEditDialogFragment.m16211a(messengerPhotoEditDialogFragment.m16210a(closeableReference));
                if (messengerPhotoEditDialogFragment.aw != null) {
                    MediaResourceBuilder b = MediaResource.a().a(messengerPhotoEditDialogFragment.aw).a(messengerPhotoEditDialogFragment.av).b(true);
                    if (!messengerPhotoEditDialogFragment.aT) {
                        b.a("has_caption", String.valueOf(messengerPhotoEditDialogFragment.aA.f())).a("has_drawing", String.valueOf(messengerPhotoEditDialogFragment.az.c()));
                    }
                    MediaResource C = b.C();
                    if (messengerPhotoEditDialogFragment.aF.f16073d) {
                        messengerPhotoEditDialogFragment.ax.mo458b(C);
                    } else {
                        messengerPhotoEditDialogFragment.ax.mo457a(C);
                    }
                    HoneyClientEventFast a = messengerPhotoEditDialogFragment.an.a("send_from_photo_edit_clicked", true);
                    if (a.a() && !messengerPhotoEditDialogFragment.aT) {
                        a.a("has_caption", messengerPhotoEditDialogFragment.aA.f());
                        a.a("has_drawing", messengerPhotoEditDialogFragment.az.c());
                        a.b();
                    }
                }
                if (messengerPhotoEditDialogFragment.aT && messengerPhotoEditDialogFragment.aE != null) {
                    messengerPhotoEditDialogFragment.aE.m16265t();
                }
                messengerPhotoEditDialogFragment.b();
            } catch (Throwable e) {
                messengerPhotoEditDialogFragment.as.b(new ToastBuilder(2131230758));
                BLog.b(am, "Saving the bitmap failed, could not generate Uri.", e);
            } catch (Throwable e2) {
                messengerPhotoEditDialogFragment.as.b(new ToastBuilder(2131230758));
                BLog.b(am, "Not enough memory to create new bitmap.", e2);
            } catch (PoolSizeViolationException e3) {
                messengerPhotoEditDialogFragment.as.b(new ToastBuilder(2131230758));
                BLog.b(am, "Too much memory being used by other bitmaps to create new bitmap.", e3);
            } catch (TooManyBitmapsException e4) {
                messengerPhotoEditDialogFragment.as.b(new ToastBuilder(2131230758));
                BLog.b(am, "Too much memory being used by other bitmaps to create new bitmap.", e4);
            } finally {
                CloseableReference.c(closeableReference);
            }
        }
    }

    private CloseableReference<Bitmap> aB() {
        if (!this.aT) {
            return this.ap.a(this.aB.getWidth(), this.aB.getHeight());
        }
        float[] fArr = new float[9];
        this.ay.getImageMatrix().getValues(fArr);
        return this.ap.a((int) (((float) this.aQ.getWidth()) * fArr[0]), (int) (fArr[4] * ((float) this.aQ.getHeight())));
    }

    private Bitmap m16210a(CloseableReference<Bitmap> closeableReference) {
        Bitmap bitmap;
        if (this.aT) {
            CloseableReference a = this.ap.a(this.ay.getWidth(), this.ay.getHeight());
            bitmap = (Bitmap) a.a();
            this.ay.draw(new Canvas(bitmap));
            float[] fArr = new float[9];
            this.ay.getImageMatrix().getValues(fArr);
            int i = (int) fArr[2];
            int i2 = (int) fArr[5];
            Bitmap bitmap2 = (Bitmap) closeableReference.a();
            Canvas canvas = new Canvas(bitmap2);
            Rect rect = new Rect(i, i2, bitmap2.getWidth() + i, bitmap2.getHeight() + i2);
            Rect rect2 = new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
            if (this.aT && this.aE != null) {
                bitmap = this.aE.m16251a(bitmap);
            }
            canvas.drawBitmap(bitmap, rect, rect2, null);
            CloseableReference.c(a);
            return bitmap2;
        }
        bitmap = (Bitmap) closeableReference.a();
        this.aB.draw(new Canvas(bitmap));
        return bitmap;
    }

    private Bitmap aC() {
        try {
            return new BitmapUtils().a(getContext(), this.av, true);
        } catch (Throwable e) {
            BLog.b(am, "Could not scale image down.", e);
            return null;
        }
    }

    private Uri m16211a(Bitmap bitmap) {
        Uri fromFile = Uri.fromFile(this.ar.a("orca-image-", ".jpg", Privacy.REQUIRE_PRIVATE));
        OutputStream fileOutputStream = new FileOutputStream(fromFile.getPath());
        try {
            bitmap.compress(CompressFormat.JPEG, 85, fileOutputStream);
            return fromFile;
        } finally {
            fileOutputStream.close();
        }
    }

    public final void m16219a() {
        super.a();
        this.aK.setOnClickListener(null);
        if (this.aA != null) {
            this.aA.e();
        }
        this.ax.mo456a();
        this.aC.b();
        aE();
    }

    public final void m16216G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1698300644);
        super.G();
        if (this.aA != null && this.aA.isEnabled()) {
            this.aA.requestFocus();
        }
        if (!new File(this.av.getPath()).exists()) {
            a();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1389857270, a);
    }

    public final void m16217I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -777823724);
        super.I();
        this.aK.setOnClickListener(null);
        if (this.aA != null) {
            this.aA.e();
        }
        this.aC.b();
        aE();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -561774951, a);
    }

    private void aE() {
        if (this.aQ != null) {
            this.ay.setImageDrawable(null);
            this.aQ.recycle();
            this.aQ = null;
        }
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 559873820);
        this.ax.mo456a();
        this.aC.b();
        super.mj_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1049963852, a);
    }
}
