package com.facebook.messaging.composershortcuts;

import android.content.Context;
import android.content.Intent;
import android.support.v7.internal.widget.ViewUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.composershortcuts.ComposerButton.ComposerButtonStateObserver;
import com.facebook.orca.compose.TwoLineComposerView.13;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.CustomViewGroup;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.Collections;
import javax.inject.Inject;

/* compiled from: message_text_linkified */
public class OverflowComposerShortcutsContainer extends CustomViewGroup implements ComposerShortcutsContainer {
    private static final Class<?> f10146d = OverflowComposerShortcutsContainer.class;
    @Inject
    public ComposerShortcutsContainerLogic f10147a;
    @Inject
    @LocalBroadcast
    public BaseFbBroadcastManager f10148b;
    @Inject
    public DefaultComposerShortcutsContainerMeasurer f10149c;
    private SelfRegistrableReceiverImpl f10150e;
    private ImmutableList<ComposerShortcutItem> f10151f;
    private boolean f10152g;

    /* compiled from: message_text_linkified */
    class C11721 implements ActionReceiver {
        final /* synthetic */ OverflowComposerShortcutsContainer f10145a;

        C11721(OverflowComposerShortcutsContainer overflowComposerShortcutsContainer) {
            this.f10145a = overflowComposerShortcutsContainer;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1476069991);
            OverflowComposerShortcutsContainer.m10612b(this.f10145a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1223133472, a);
        }
    }

    private static <T extends View> void m10610a(Class<T> cls, T t) {
        m10611a((Object) t, t.getContext());
    }

    private static void m10611a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        OverflowComposerShortcutsContainer overflowComposerShortcutsContainer = (OverflowComposerShortcutsContainer) obj;
        ComposerShortcutsContainerLogic composerShortcutsContainerLogic = new ComposerShortcutsContainerLogic((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), BuiltinComposerShortcuts.m10488a(injectorLike), ComposerShortcutsAnalyticsLogger.m10529a(injectorLike), ComposerShortcutsManagerMethodAutoProvider.m10561b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), OverflowComposerShortcutsAdapter.m10602b(injectorLike), IdBasedProvider.a(injectorLike, 4049), IdBasedProvider.a(injectorLike, 11752));
        BaseFbBroadcastManager baseFbBroadcastManager = (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike);
        DefaultComposerShortcutsContainerMeasurer b = DefaultComposerShortcutsContainerMeasurer.m10571b(injectorLike);
        overflowComposerShortcutsContainer.f10147a = composerShortcutsContainerLogic;
        overflowComposerShortcutsContainer.f10148b = baseFbBroadcastManager;
        overflowComposerShortcutsContainer.f10149c = b;
    }

    public OverflowComposerShortcutsContainer(Context context) {
        super(context);
        m10608a();
    }

    public OverflowComposerShortcutsContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10608a();
    }

    public OverflowComposerShortcutsContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10608a();
    }

    private void m10608a() {
        m10610a(OverflowComposerShortcutsContainer.class, (View) this);
        this.f10151f = RegularImmutableList.a;
        this.f10147a.m10545a((View) this);
        this.f10150e = this.f10148b.a().a(MessengerComposerShortcutsManager.f10069a, new C11721(this)).a();
    }

    public void setLikeIconIdOverride(int i) {
        this.f10147a.m10549b(i);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -32818809);
        super.onAttachedToWindow();
        this.f10150e.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -818013450, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1903652910);
        super.onDetachedFromWindow();
        this.f10150e.c();
        this.f10147a.m10555g();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1642906665, a);
    }

    public static void m10612b(OverflowComposerShortcutsContainer overflowComposerShortcutsContainer) {
        overflowComposerShortcutsContainer.f10147a.m10553d();
        overflowComposerShortcutsContainer.requestLayout();
    }

    @VisibleForTesting
    ImmutableList<ComposerShortcutItem> getOverflowItems() {
        return ImmutableList.copyOf(this.f10151f);
    }

    protected void onMeasure(int i, int i2) {
        int childCount;
        for (childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            ComposerShortcutsContainerLogic composerShortcutsContainerLogic = this.f10147a;
            ComposerButton composerButton = (ComposerButton) childAt;
            String composerShortcutId = composerButton.getComposerShortcutId();
            composerShortcutsContainerLogic.f10034k.put(composerShortcutId, composerButton);
            composerShortcutsContainerLogic.f10035l.remove(composerShortcutId);
        }
        removeAllViewsInLayout();
        int resolveSize = View.resolveSize(Math.max(getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i);
        ComposerShortcutsContainerMeasurer$Result a = this.f10149c.m10574a(this.f10147a.f10037n, this.f10147a.f10039p, Collections.unmodifiableMap(this.f10147a.f10040q), this.f10152g, this.f10147a.f10038o, resolveSize);
        this.f10151f = ImmutableList.copyOf(a.f10051c);
        for (ComposerShortcutItem composerShortcutItem : a.f10049a) {
            addViewInLayout(composerShortcutItem.f9973b.equals("overflow") ? this.f10147a.m10544a(this.f10151f) : this.f10147a.m10548b(composerShortcutItem.f9973b), getChildCount(), getButtonLayoutParams());
        }
        int childCount2 = getChildCount();
        int i3 = resolveSize / childCount2;
        int i4 = 0;
        for (childCount = 0; childCount < childCount2; childCount++) {
            View childAt2 = getChildAt(childCount);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childAt2.getLayoutParams();
            childAt2.measure(MeasureSpec.makeMeasureSpec(Math.max(0, (i3 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin), 1073741824), ViewGroup.getChildMeasureSpec(i2, ((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin, marginLayoutParams.height));
            i4 = Math.max(i4, childAt2.getMeasuredHeight());
        }
        setMeasuredDimension(resolveSize, View.resolveSize(Math.max(i4, getSuggestedMinimumHeight()), i2));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getWidth();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getHeight();
        getPaddingBottom();
        if (ViewUtils.a(this)) {
            i5 = -1;
            i6 = childCount - 1;
        } else {
            i5 = 1;
            i6 = 0;
        }
        int i7 = paddingLeft;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt((i5 * i8) + i6);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childAt.getLayoutParams();
            i7 += marginLayoutParams.leftMargin;
            int measuredWidth = childAt.getMeasuredWidth();
            layoutChild(i7, i7 + measuredWidth, paddingTop, paddingTop + childAt.getMeasuredHeight(), childAt);
            i7 += marginLayoutParams.rightMargin + measuredWidth;
        }
    }

    public void setListener(13 13) {
        this.f10147a.f10046w = 13;
    }

    public ComposerShortcutsContainerLogic getComposerShortcutsContainerLogic() {
        return this.f10147a;
    }

    public void setComposerButtonStateObserver(ComposerButtonStateObserver composerButtonStateObserver) {
        this.f10147a.f10043t = composerButtonStateObserver;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ComposerButton) {
                ((ComposerButton) childAt).f9954l = composerButtonStateObserver;
            }
        }
    }

    public final int mo409a(String str, boolean z) {
        if ("overflow".equals(str)) {
            return this.f10147a.m10554e();
        }
        int i;
        if (z) {
            int size = this.f10151f.size();
            for (int i2 = 0; i2 < size; i2++) {
                ComposerShortcutItem composerShortcutItem = (ComposerShortcutItem) this.f10151f.get(i2);
                if (composerShortcutItem.f9973b != null && composerShortcutItem.f9973b.equals(str)) {
                    return this.f10147a.m10554e();
                }
            }
        }
        ComposerShortcutsContainerLogic composerShortcutsContainerLogic = this.f10147a;
        int size2 = composerShortcutsContainerLogic.f10037n.size();
        for (int i3 = 0; i3 < size2; i3++) {
            ComposerShortcutItem composerShortcutItem2 = (ComposerShortcutItem) composerShortcutsContainerLogic.f10037n.get(i3);
            if (composerShortcutItem2.f9973b != null && composerShortcutItem2.f9973b.equals(str)) {
                i = composerShortcutItem2.f9974c;
                break;
            }
        }
        i = -1;
        return i;
    }

    public void setNonBuiltInShortcutsHidden(boolean z) {
        if (this.f10152g != z) {
            this.f10152g = z;
            requestLayout();
        }
    }

    private MarginLayoutParams getButtonLayoutParams() {
        return new MarginLayoutParams(0, getResources().getDimensionPixelSize(2131427826));
    }
}
