package com.facebook.search.quickpromotion;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Point;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.facebook.fig.bottomsheet.FigBottomSheetAdapter;
import com.facebook.fig.button.FigButton;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.search.logging.SearchAwarenessLogger;
import com.facebook.search.prefs.SearchAwarenessPrefKeys;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.google.common.base.Preconditions;
import javax.inject.Singleton;

@Singleton
/* compiled from: TEXT_BULLETED_LIST */
public class SearchAwarenessOptOutController {
    private static volatile SearchAwarenessOptOutController f22405j;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<SearchAwarenessLogger> f22406a = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FbSharedPreferences> f22407b = UltralightRuntime.b;
    public final Context f22408c;
    public final WindowManager f22409d;
    public FigButton f22410e;
    public FigButton f22411f;
    public AwarenessType f22412g;
    public BottomSheetDialog f22413h;
    public boolean f22414i;

    /* compiled from: TEXT_BULLETED_LIST */
    class C23831 implements OnDismissListener {
        final /* synthetic */ SearchAwarenessOptOutController f22400a;

        C23831(SearchAwarenessOptOutController searchAwarenessOptOutController) {
            this.f22400a = searchAwarenessOptOutController;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            SearchAwarenessOptOutController.m25891a(this.f22400a, this.f22400a.f22412g, Action.OTHER_DISMISS_ACTION);
        }
    }

    /* compiled from: TEXT_BULLETED_LIST */
    enum Action {
        PRIMARY_ACTION("primary_action"),
        SECONDARY_ACTION("secondary_action"),
        OTHER_DISMISS_ACTION("other_dismiss_action");
        
        private final String value;

        private Action(String str) {
            this.value = str;
        }

        public final String toString() {
            return this.value;
        }
    }

    /* compiled from: TEXT_BULLETED_LIST */
    public interface OnActionClickListener {
        void mo1239a();

        void mo1240b();
    }

    public static com.facebook.search.quickpromotion.SearchAwarenessOptOutController m25890a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f22405j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.quickpromotion.SearchAwarenessOptOutController.class;
        monitor-enter(r1);
        r0 = f22405j;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m25892b(r0);	 Catch:{ all -> 0x0035 }
        f22405j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f22405j;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.quickpromotion.SearchAwarenessOptOutController.a(com.facebook.inject.InjectorLike):com.facebook.search.quickpromotion.SearchAwarenessOptOutController");
    }

    private static SearchAwarenessOptOutController m25892b(InjectorLike injectorLike) {
        SearchAwarenessOptOutController searchAwarenessOptOutController = new SearchAwarenessOptOutController((Context) injectorLike.getInstance(Context.class));
        com.facebook.inject.Lazy a = IdBasedLazy.a(injectorLike, 3376);
        com.facebook.inject.Lazy b = IdBasedSingletonScopeProvider.b(injectorLike, 3078);
        searchAwarenessOptOutController.f22406a = a;
        searchAwarenessOptOutController.f22407b = b;
        return searchAwarenessOptOutController;
    }

    @Inject
    private SearchAwarenessOptOutController(Context context) {
        this.f22408c = context;
        this.f22409d = (WindowManager) this.f22408c.getSystemService("window");
        this.f22412g = AwarenessType.UNSET;
        this.f22414i = false;
    }

    public final void m25893a(AwarenessType awarenessType, final OnActionClickListener onActionClickListener, @Nullable IBinder iBinder) {
        Preconditions.checkArgument(awarenessType != AwarenessType.UNSET);
        this.f22413h = new BottomSheetDialog(this.f22408c);
        BottomSheetDialog bottomSheetDialog = this.f22413h;
        View inflate = LayoutInflater.from(this.f22408c).inflate(2130903325, null, false);
        Display defaultDisplay = this.f22409d.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        inflate.measure(MeasureSpec.makeMeasureSpec(point.x, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        this.f22410e = (FigButton) inflate.findViewById(2131559759);
        this.f22410e.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SearchAwarenessOptOutController f22402b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1715738938);
                onActionClickListener.mo1239a();
                this.f22402b.f22413h.dismiss();
                SearchAwarenessOptOutController.m25891a(this.f22402b, this.f22402b.f22412g, Action.PRIMARY_ACTION);
                this.f22402b.f22412g = AwarenessType.UNSET;
                Logger.a(2, EntryType.UI_INPUT_END, 736499372, a);
            }
        });
        this.f22411f = (FigButton) inflate.findViewById(2131559758);
        this.f22411f.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SearchAwarenessOptOutController f22404b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1498013612);
                onActionClickListener.mo1240b();
                ((FbSharedPreferences) this.f22404b.f22407b.get()).edit().putBoolean(SearchAwarenessPrefKeys.c(this.f22404b.f22412g.name()), true).commit();
                SearchAwarenessOptOutController.m25891a(this.f22404b, this.f22404b.f22412g, Action.SECONDARY_ACTION);
                this.f22404b.f22413h.dismiss();
                this.f22404b.f22412g = AwarenessType.UNSET;
                Logger.a(2, EntryType.UI_INPUT_END, 431683949, a);
            }
        });
        FigBottomSheetAdapter figBottomSheetAdapter = new FigBottomSheetAdapter(this.f22408c);
        figBottomSheetAdapter.a(inflate, (float) inflate.getMeasuredHeight());
        bottomSheetDialog.a(figBottomSheetAdapter);
        this.f22413h.setOnDismissListener(new C23831(this));
        if (iBinder != null) {
            LayoutParams layoutParams = new LayoutParams();
            layoutParams.token = iBinder;
            layoutParams.type = 1000;
            layoutParams.format = -3;
            this.f22413h.getWindow().setAttributes(layoutParams);
        }
        this.f22412g = awarenessType;
        AwarenessType awarenessType2 = this.f22412g;
        this.f22414i = true;
        ((SearchAwarenessLogger) this.f22406a.get()).a(awarenessType2.name());
        this.f22413h.show();
    }

    public final boolean m25894a(AwarenessType awarenessType) {
        return ((FbSharedPreferences) this.f22407b.get()).a(SearchAwarenessPrefKeys.c(awarenessType.name()), false);
    }

    public static void m25891a(SearchAwarenessOptOutController searchAwarenessOptOutController, AwarenessType awarenessType, Action action) {
        if (searchAwarenessOptOutController.f22414i) {
            ((SearchAwarenessLogger) searchAwarenessOptOutController.f22406a.get()).a(awarenessType.name(), action.toString());
        }
        searchAwarenessOptOutController.f22414i = false;
    }
}
