package com.facebook.timeline.aboutpage.views;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLInterfaces.SavableTimelineAppCollection;
import com.facebook.attachments.angora.CollectionUpdateRequestListener;
import com.facebook.attachments.angora.CollectionUpdateResultListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.executor.LegacyConsistencyBridge;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.story.UpdateTimelineAppCollectionParams.Action;
import com.facebook.story.UpdateTimelineAppCollectionParams.Builder;
import com.facebook.timeline.aboutpage.model.TimelineAppCollectionItemNode;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionItemContainingMutationFieldsModel;
import com.facebook.ui.dialogs.ActionSheetDialogBuilder;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.touch.TouchDelegateUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: Ljava/lang/Runnable; */
public class TimelineCollectionPlusButtonView extends CustomFrameLayout implements CollectionUpdateResultListener {
    private final ImageButton f13939a;
    private final ImageView f13940b;
    private TimelineAppCollectionItemNode f13941c;
    private CollectionUpdateRequestListener f13942d;
    private CurationSurface f13943e;
    public AbstractFbErrorReporter f13944f;
    public LegacyConsistencyBridge f13945g;
    public AlertDialog f13946h;
    private final Drawable f13947i;
    private final Drawable f13948j;
    private final String f13949k;
    private final String f13950l;
    private final String f13951m;
    private final int f13952n;
    private final int f13953o;

    /* compiled from: Ljava/lang/Runnable; */
    class C16241 implements OnClickListener {
        final /* synthetic */ TimelineCollectionPlusButtonView f13933a;

        C16241(TimelineCollectionPlusButtonView timelineCollectionPlusButtonView) {
            this.f13933a = timelineCollectionPlusButtonView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 919969439);
            TimelineCollectionPlusButtonView.m15068j(this.f13933a);
            Logger.a(2, EntryType.UI_INPUT_END, -1008796014, a);
        }
    }

    /* compiled from: Ljava/lang/Runnable; */
    class C16263 implements DialogInterface.OnClickListener {
        final /* synthetic */ TimelineCollectionPlusButtonView f13938a;

        C16263(TimelineCollectionPlusButtonView timelineCollectionPlusButtonView) {
            this.f13938a = timelineCollectionPlusButtonView;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
            this.f13938a.f13946h = null;
        }
    }

    private static <T extends View> void m15058a(Class<T> cls, T t) {
        m15059a((Object) t, t.getContext());
    }

    private static void m15059a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        TimelineCollectionPlusButtonView timelineCollectionPlusButtonView = (TimelineCollectionPlusButtonView) obj;
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        LegacyConsistencyBridge b = LegacyConsistencyBridge.b(fbInjector);
        timelineCollectionPlusButtonView.f13944f = abstractFbErrorReporter;
        timelineCollectionPlusButtonView.f13945g = b;
    }

    public TimelineCollectionPlusButtonView(Context context) {
        this(context, null);
    }

    public TimelineCollectionPlusButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130907437);
        m15058a(TimelineCollectionPlusButtonView.class, (View) this);
        this.f13939a = (ImageButton) c(2131567920);
        this.f13940b = (ImageView) c(2131567921);
        Resources resources = context.getResources();
        this.f13947i = resources.getDrawable(2130840163);
        this.f13948j = resources.getDrawable(2130840160);
        this.f13949k = resources.getString(2131233592);
        this.f13950l = resources.getString(2131233593);
        this.f13951m = resources.getString(2131233563);
        this.f13952n = resources.getDimensionPixelSize(2131428983);
        this.f13953o = resources.getDimensionPixelSize(2131428982);
        TrackingNodes.a(this, TrackingNode.COLLECTION_ADD_BUTTON);
    }

    public final void m15072a(TimelineAppCollectionItemNode timelineAppCollectionItemNode, CollectionUpdateRequestListener collectionUpdateRequestListener, CurationSurface curationSurface) {
        if (!(this.f13946h == null || this.f13941c == timelineAppCollectionItemNode)) {
            this.f13946h.cancel();
        }
        this.f13941c = timelineAppCollectionItemNode;
        this.f13942d = collectionUpdateRequestListener;
        this.f13943e = curationSurface;
        m15065g();
        if (this.f13939a.getVisibility() == 0) {
            this.f13939a.setOnClickListener(new C16241(this));
        } else {
            this.f13939a.setOnClickListener(null);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m15066h();
    }

    private boolean m15062b() {
        if (this.f13941c == null || this.f13941c.m13937c()) {
            return false;
        }
        return m15063e();
    }

    private boolean m15063e() {
        if (this.f13941c == null || this.f13941c.m13936b() == null) {
            return false;
        }
        return true;
    }

    private boolean m15064f() {
        if (this.f13941c == null) {
            return false;
        }
        ImmutableList immutableList = this.f13941c.f13162m;
        if (immutableList == null || immutableList.isEmpty()) {
            return false;
        }
        int size = immutableList.size();
        int i = 0;
        while (i < size) {
            SavableTimelineAppCollection savableTimelineAppCollection = (SavableTimelineAppCollection) immutableList.get(i);
            if (StringUtil.a(savableTimelineAppCollection.b())) {
                this.f13944f.a("TimelineCollectionPlusButton", "Tried to render plus button for collection with no id");
                return false;
            } else if (savableTimelineAppCollection.d() == null) {
                this.f13944f.a("TimelineCollectionPlusButton", StringFormatUtil.formatStrLocaleSafe("Tried to render plus button for collection %s with no default privacy", savableTimelineAppCollection.b()));
                return false;
            } else {
                i++;
            }
        }
        return true;
    }

    private void m15065g() {
        if (m15064f()) {
            setVisibility(0);
            if (m15062b()) {
                this.f13940b.setVisibility(0);
                this.f13939a.setVisibility(8);
                m15066h();
                return;
            }
            m15067i();
            this.f13939a.setContentDescription(m15063e() ? this.f13950l : this.f13949k);
            this.f13939a.setVisibility(0);
            this.f13940b.setVisibility(8);
            m15066h();
            return;
        }
        setVisibility(8);
    }

    private void m15066h() {
        this.f13939a.setPadding(0, 0, 0, 0);
        if (getVisibility() == 0 && this.f13939a.getVisibility() == 0) {
            setTouchDelegate(TouchDelegateUtils.a(this.f13939a, this.f13952n));
        } else {
            setTouchDelegate(null);
        }
    }

    private void m15067i() {
        this.f13939a.setBackgroundResource(2130840164);
        this.f13939a.setImageDrawable(m15063e() ? this.f13948j : this.f13947i);
        LayoutParams layoutParams = this.f13939a.getLayoutParams();
        layoutParams.height = this.f13953o;
        layoutParams.width = this.f13953o;
        this.f13939a.setLayoutParams(layoutParams);
    }

    public static void m15068j(TimelineCollectionPlusButtonView timelineCollectionPlusButtonView) {
        final String str = timelineCollectionPlusButtonView.f13941c.f13150a;
        final String str2 = timelineCollectionPlusButtonView.f13941c.f13151b;
        if (!StringUtil.a(str2)) {
            final ImmutableList immutableList = timelineCollectionPlusButtonView.f13941c.f13162m;
            if (timelineCollectionPlusButtonView.m15063e()) {
                timelineCollectionPlusButtonView.m15060a(str, str2);
            } else if (immutableList != null) {
                ActionSheetDialogBuilder actionSheetDialogBuilder = new ActionSheetDialogBuilder(timelineCollectionPlusButtonView.getContext());
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    actionSheetDialogBuilder.a(((SavableTimelineAppCollection) immutableList.get(i)).c(), new DialogInterface.OnClickListener(timelineCollectionPlusButtonView) {
                        final /* synthetic */ TimelineCollectionPlusButtonView f13937d;

                        public void onClick(DialogInterface dialogInterface, int i) {
                            SavableTimelineAppCollection savableTimelineAppCollection = null;
                            dialogInterface.dismiss();
                            this.f13937d.f13946h = null;
                            if (i < immutableList.size()) {
                                savableTimelineAppCollection = (SavableTimelineAppCollection) immutableList.get(i);
                            }
                            if (savableTimelineAppCollection == null) {
                                this.f13937d.f13944f.b("TimelineCollectionPlusButton", "Could not add item to collection as no valid collection was found");
                            } else {
                                this.f13937d.m15055a(savableTimelineAppCollection, str, str2);
                            }
                        }
                    });
                }
                actionSheetDialogBuilder.a(timelineCollectionPlusButtonView.f13951m, new C16263(timelineCollectionPlusButtonView));
                timelineCollectionPlusButtonView.f13946h = actionSheetDialogBuilder.show();
            }
        }
    }

    private void m15055a(SavableTimelineAppCollection savableTimelineAppCollection, String str, String str2) {
        Object c = savableTimelineAppCollection.d() != null ? savableTimelineAppCollection.d().c() : null;
        if (StringUtil.a(c)) {
            this.f13944f.b("TimelineCollectionPlusButton", "Could not add item to collection as collection does not support newItemDefaultPrivacy.");
            return;
        }
        this.f13941c.m13932a(savableTimelineAppCollection);
        Action action = Action.ADD;
        m15065g();
        this.f13939a.setEnabled(false);
        Builder builder = new Builder();
        builder.a = savableTimelineAppCollection.b();
        builder = builder;
        builder.b = str2;
        builder = builder;
        builder.g = c;
        Builder builder2 = builder;
        builder2.j = false;
        builder2 = builder2;
        builder2.d = this.f13943e;
        builder2 = builder2;
        builder2.e = CurationMechanism.ADD_BUTTON;
        ListenableFuture a = this.f13942d.a(this, savableTimelineAppCollection, builder2.a());
        AppCollectionItemContainingMutationFieldsModel.Builder builder3 = new AppCollectionItemContainingMutationFieldsModel.Builder();
        builder3.f13240a = str;
        builder3 = builder3;
        builder3.f13241b = savableTimelineAppCollection.b();
        this.f13945g.a(a, builder3.m14214a());
    }

    private void m15060a(String str, String str2) {
        SavableTimelineAppCollection b = this.f13941c.m13936b();
        if (b != null) {
            this.f13941c.m13932a(null);
            Action action = Action.REMOVE;
            m15065g();
            this.f13939a.setEnabled(false);
            Builder builder = new Builder();
            builder.a = b.b();
            builder = builder;
            builder.b = str2;
            builder = builder;
            builder.j = false;
            builder = builder;
            builder.d = this.f13943e;
            builder = builder;
            builder.e = CurationMechanism.ADD_BUTTON;
            ListenableFuture b2 = this.f13942d.b(this, b, builder.a());
            AppCollectionItemContainingMutationFieldsModel.Builder builder2 = new AppCollectionItemContainingMutationFieldsModel.Builder();
            builder2.f13240a = str;
            builder2 = builder2;
            builder2.f13241b = "";
            this.f13945g.a(b2, builder2.m14214a());
        }
    }

    private void m15069k() {
        m15065g();
    }

    public final void m15070a() {
        this.f13939a.setEnabled(true);
    }

    public final void m15071a(SavableTimelineAppCollection savableTimelineAppCollection, Action action) {
        Action action2;
        if (action == Action.ADD) {
            this.f13941c.m13932a(null);
            action2 = Action.REMOVE;
            m15065g();
        } else if (action == Action.REMOVE) {
            this.f13941c.m13932a(savableTimelineAppCollection);
            action2 = Action.ADD;
            m15065g();
        }
        this.f13939a.setEnabled(true);
    }
}
