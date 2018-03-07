package com.facebook.react.uimanager;

import android.content.res.Resources;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnDismissListener;
import android.widget.PopupMenu.OnMenuItemClickListener;
import com.facebook.react.animation.AnimationRegistry;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.layoutanimation.LayoutAnimationController;
import com.facebook.react.uimanager.layoutanimation.LayoutAnimationListener;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: friend_finder_invitable_contacts_fetch_failed */
public class NativeViewHierarchyManager {
    public final AnimationRegistry f11737a = new AnimationRegistry();
    private final SparseArray<View> f11738b;
    private final SparseArray<ViewManager> f11739c;
    private final SparseBooleanArray f11740d;
    private final ViewManagerRegistry f11741e;
    private final JSResponderHandler f11742f = new JSResponderHandler();
    private final RootViewManager f11743g = new RootViewManager();
    private final LayoutAnimationController f11744h = new LayoutAnimationController();
    public boolean f11745i;

    /* compiled from: friend_finder_invitable_contacts_fetch_failed */
    class PopupMenuCallbackHandler implements OnDismissListener, OnMenuItemClickListener {
        final Callback f11735a;
        boolean f11736b;

        public PopupMenuCallbackHandler(Callback callback) {
            this.f11736b = false;
            this.f11735a = callback;
        }

        public void onDismiss(PopupMenu popupMenu) {
            if (!this.f11736b) {
                this.f11735a.mo642a("dismissed");
                this.f11736b = true;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            if (this.f11736b) {
                return false;
            }
            this.f11735a.mo642a("itemSelected", Integer.valueOf(menuItem.getOrder()));
            this.f11736b = true;
            return true;
        }
    }

    public NativeViewHierarchyManager(ViewManagerRegistry viewManagerRegistry) {
        this.f11741e = viewManagerRegistry;
        this.f11738b = new SparseArray();
        this.f11739c = new SparseArray();
        this.f11740d = new SparseBooleanArray();
    }

    protected final View m13867a(int i) {
        View view = (View) this.f11738b.get(i);
        if (view != null) {
            return view;
        }
        throw new IllegalViewOperationException("Trying to resolve view with tag " + i + " which doesn't exist");
    }

    protected final ViewManager m13884b(int i) {
        ViewManager viewManager = (ViewManager) this.f11739c.get(i);
        if (viewManager != null) {
            return viewManager;
        }
        throw new IllegalViewOperationException("ViewManager for tag " + i + " could not be found");
    }

    public final AnimationRegistry m13868a() {
        return this.f11737a;
    }

    public final void m13883a(boolean z) {
        this.f11745i = z;
    }

    public final void m13875a(int i, ReactStylesDiffMap reactStylesDiffMap) {
        UiThreadUtil.m13554b();
        m13884b(i).m13792a(m13867a(i), reactStylesDiffMap);
    }

    public final void m13877a(int i, Object obj) {
        UiThreadUtil.m13554b();
        m13884b(i).mo740a(m13867a(i), obj);
    }

    public final void m13870a(int i, int i2, int i3, int i4, int i5, int i6) {
        UiThreadUtil.m13554b();
        SystraceMessage.a(33554432, "NativeViewHierarchyManager_updateLayout").a("parentTag", i).a("tag", i2).a();
        try {
            View a = m13867a(i2);
            a.measure(MeasureSpec.makeMeasureSpec(i5, 1073741824), MeasureSpec.makeMeasureSpec(i6, 1073741824));
            if (this.f11740d.get(i)) {
                m13863a(a, i3, i4, i5, i6);
            } else {
                ViewManager viewManager = (ViewManager) this.f11739c.get(i);
                if (viewManager instanceof ViewGroupManager) {
                    ViewGroupManager viewGroupManager = (ViewGroupManager) viewManager;
                    if (!(viewGroupManager == null || viewGroupManager.m13961e())) {
                        m13863a(a, i3, i4, i5, i6);
                    }
                } else {
                    throw new IllegalViewOperationException("Trying to use view with tag " + i2 + " as a parent, but its Manager doesn't extends ViewGroupManager");
                }
            }
            Systrace.a(33554432);
        } catch (Throwable th) {
            Systrace.a(33554432);
        }
    }

    private void m13863a(View view, int i, int i2, int i3, int i4) {
        if (this.f11745i && this.f11744h.m14192a(view)) {
            this.f11744h.m14189a(view, i, i2, i3, i4);
        } else {
            view.layout(i, i2, i + i3, i2 + i4);
        }
    }

    public final void m13882a(ThemedReactContext themedReactContext, int i, String str, @Nullable ReactStylesDiffMap reactStylesDiffMap) {
        UiThreadUtil.m13554b();
        SystraceMessage.a(33554432, "NativeViewHierarchyManager_createView").a("tag", i).a("className", str).a();
        try {
            ViewManager a = this.f11741e.m14101a(str);
            View a2 = a.m13788a(themedReactContext, this.f11742f);
            this.f11738b.put(i, a2);
            this.f11739c.put(i, a);
            a2.setId(i);
            if (reactStylesDiffMap != null) {
                a.m13792a(a2, reactStylesDiffMap);
            }
            Systrace.a(33554432);
        } catch (Throwable th) {
            Systrace.a(33554432);
        }
    }

    private static String m13862a(ViewGroup viewGroup, ViewGroupManager viewGroupManager, @Nullable int[] iArr, @Nullable ViewAtIndex[] viewAtIndexArr, @Nullable int[] iArr2) {
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("View tag:" + viewGroup.getId() + "\n");
        stringBuilder.append("  children(" + viewGroupManager.mo763a(viewGroup) + "): [\n");
        for (i = 0; i < viewGroupManager.mo763a(viewGroup); i += 16) {
            int i2 = 0;
            while (i + i2 < viewGroupManager.mo763a(viewGroup) && i2 < 16) {
                stringBuilder.append(viewGroupManager.mo764a(viewGroup, i + i2).getId() + ",");
                i2++;
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append(" ],\n");
        if (iArr != null) {
            stringBuilder.append("  indicesToRemove(" + iArr.length + "): [\n");
            for (i = 0; i < iArr.length; i += 16) {
                i2 = 0;
                while (i + i2 < iArr.length && i2 < 16) {
                    stringBuilder.append(iArr[i + i2] + ",");
                    i2++;
                }
                stringBuilder.append("\n");
            }
            stringBuilder.append(" ],\n");
        }
        if (viewAtIndexArr != null) {
            stringBuilder.append("  viewsToAdd(" + viewAtIndexArr.length + "): [\n");
            for (i = 0; i < viewAtIndexArr.length; i += 16) {
                i2 = 0;
                while (i + i2 < viewAtIndexArr.length && i2 < 16) {
                    stringBuilder.append("[" + viewAtIndexArr[i + i2].f11861c + "," + viewAtIndexArr[i + i2].f11860b + "],");
                    i2++;
                }
                stringBuilder.append("\n");
            }
            stringBuilder.append(" ],\n");
        }
        if (iArr2 != null) {
            stringBuilder.append("  tagsToDelete(" + iArr2.length + "): [\n");
            for (i = 0; i < iArr2.length; i += 16) {
                i2 = 0;
                while (i + i2 < iArr2.length && i2 < 16) {
                    stringBuilder.append(iArr2[i + i2] + ",");
                    i2++;
                }
                stringBuilder.append("\n");
            }
            stringBuilder.append(" ]\n");
        }
        return stringBuilder.toString();
    }

    public final void m13879a(int i, @Nullable int[] iArr, @Nullable ViewAtIndex[] viewAtIndexArr, @Nullable int[] iArr2) {
        int i2 = 0;
        final ViewGroup viewGroup = (ViewGroup) this.f11738b.get(i);
        final ViewGroupManager viewGroupManager = (ViewGroupManager) m13884b(i);
        if (viewGroup == null) {
            throw new IllegalViewOperationException("Trying to manageChildren view with tag " + i + " which doesn't exist\n detail: " + m13862a(viewGroup, viewGroupManager, iArr, viewAtIndexArr, iArr2));
        }
        View view;
        int a = viewGroupManager.mo763a(viewGroup);
        if (iArr != null) {
            int length = iArr.length - 1;
            while (length >= 0) {
                int i3 = iArr[length];
                if (i3 < 0) {
                    throw new IllegalViewOperationException("Trying to remove a negative view index:" + i3 + " view tag: " + i + "\n detail: " + m13862a(viewGroup, viewGroupManager, iArr, viewAtIndexArr, iArr2));
                } else if (i3 >= viewGroupManager.mo763a(viewGroup)) {
                    throw new IllegalViewOperationException("Trying to remove a view index above child count " + i3 + " view tag: " + i + "\n detail: " + m13862a(viewGroup, viewGroupManager, iArr, viewAtIndexArr, iArr2));
                } else if (i3 >= a) {
                    throw new IllegalViewOperationException("Trying to remove an out of order view index:" + i3 + " view tag: " + i + "\n detail: " + m13862a(viewGroup, viewGroupManager, iArr, viewAtIndexArr, iArr2));
                } else {
                    View childAt = viewGroup.getChildAt(i3);
                    if (!this.f11744h.m14192a(childAt) || !m13864a(iArr2, childAt.getId())) {
                        viewGroupManager.mo768b(viewGroup, i3);
                    }
                    length--;
                    a = i3;
                }
            }
        }
        if (viewAtIndexArr != null) {
            for (ViewAtIndex viewAtIndex : viewAtIndexArr) {
                view = (View) this.f11738b.get(viewAtIndex.f11860b);
                if (view == null) {
                    throw new IllegalViewOperationException("Trying to add unknown view tag: " + viewAtIndex.f11860b + "\n detail: " + m13862a(viewGroup, viewGroupManager, iArr, viewAtIndexArr, iArr2));
                }
                viewGroupManager.mo766a(viewGroup, view, viewAtIndex.f11861c);
            }
        }
        if (iArr2 != null) {
            while (i2 < iArr2.length) {
                a = iArr2[i2];
                view = (View) this.f11738b.get(a);
                if (view == null) {
                    throw new IllegalViewOperationException("Trying to destroy unknown view tag: " + a + "\n detail: " + m13862a(viewGroup, viewGroupManager, iArr, viewAtIndexArr, iArr2));
                }
                if (this.f11744h.m14192a(view)) {
                    this.f11744h.m14190a(view, new LayoutAnimationListener(this) {
                        final /* synthetic */ NativeViewHierarchyManager f11734d;

                        public final void mo735a() {
                            viewGroupManager.m13954a(viewGroup, view);
                            this.f11734d.m13880a(view);
                        }
                    });
                } else {
                    m13880a(view);
                }
                i2++;
            }
        }
    }

    private static boolean m13864a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public void m13876a(int i, SizeMonitoringFrameLayout sizeMonitoringFrameLayout, ThemedReactContext themedReactContext) {
        m13873a(i, (ViewGroup) sizeMonitoringFrameLayout);
    }

    protected final void m13873a(int i, ViewGroup viewGroup) {
        UiThreadUtil.m13554b();
        if (viewGroup.getId() != -1) {
            throw new IllegalViewOperationException("Trying to add a root view with an explicit id already set. React Native uses the id field to track react tags and will overwrite this field. If that is fine, explicitly overwrite the id field to View.NO_ID before calling addMeasuredRootView.");
        }
        this.f11738b.put(i, viewGroup);
        this.f11739c.put(i, this.f11743g);
        this.f11740d.put(i, true);
        viewGroup.setId(i);
    }

    protected void m13880a(View view) {
        UiThreadUtil.m13554b();
        if (!this.f11740d.get(view.getId())) {
            m13884b(view.getId()).m13790a(view);
        }
        ViewManager viewManager = (ViewManager) this.f11739c.get(view.getId());
        if ((view instanceof ViewGroup) && (viewManager instanceof ViewGroupManager)) {
            ViewGroup viewGroup = (ViewGroup) view;
            ViewGroupManager viewGroupManager = (ViewGroupManager) viewManager;
            for (int a = viewGroupManager.mo763a(viewGroup) - 1; a >= 0; a--) {
                View a2 = viewGroupManager.mo764a(viewGroup, a);
                if (this.f11738b.get(a2.getId()) != null) {
                    m13880a(a2);
                }
            }
            viewGroupManager.mo767b(viewGroup);
        }
        this.f11738b.remove(view.getId());
        this.f11739c.remove(view.getId());
    }

    public final void m13888c(int i) {
        UiThreadUtil.m13554b();
        if (!this.f11740d.get(i)) {
            SoftAssertions.m13550a("View with tag " + i + " is not registered as a root view");
        }
        m13880a((View) this.f11738b.get(i));
        this.f11740d.delete(i);
    }

    public final void m13878a(int i, int[] iArr) {
        UiThreadUtil.m13554b();
        View view = (View) this.f11738b.get(i);
        if (view == null) {
            throw new NoSuchNativeViewException("No native view for " + i + " currently exists");
        }
        View view2 = (View) RootViewUtil.m13964a(view);
        if (view2 == null) {
            throw new NoSuchNativeViewException("Native view " + i + " is no longer on screen");
        }
        view2.getLocationInWindow(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        view.getLocationInWindow(iArr);
        iArr[0] = iArr[0] - i2;
        iArr[1] = iArr[1] - i3;
        iArr[2] = view.getWidth();
        iArr[3] = view.getHeight();
    }

    public final void m13886b(int i, int[] iArr) {
        UiThreadUtil.m13554b();
        View view = (View) this.f11738b.get(i);
        if (view == null) {
            throw new NoSuchNativeViewException("No native view for " + i + " currently exists");
        }
        view.getLocationOnScreen(iArr);
        Resources resources = view.getContext().getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            iArr[1] = iArr[1] - ((int) resources.getDimension(identifier));
        }
        iArr[2] = view.getWidth();
        iArr[3] = view.getHeight();
    }

    public final int m13866a(int i, float f, float f2) {
        View view = (View) this.f11738b.get(i);
        if (view != null) {
            return TouchTargetHelper.m13979a(f, f2, (ViewGroup) view);
        }
        throw new JSApplicationIllegalArgumentException("Could not find view with tag " + i);
    }

    public final void m13872a(int i, int i2, boolean z) {
        if (z) {
            View view = (View) this.f11738b.get(i);
            if (i2 == i || !(view instanceof ViewParent)) {
                if (this.f11740d.get(i)) {
                    SoftAssertions.m13550a("Cannot block native responder on " + i + " that is a root view");
                }
                this.f11742f.m13783a(i2, view.getParent());
                return;
            }
            this.f11742f.m13783a(i2, (ViewParent) view);
            return;
        }
        this.f11742f.m13783a(i2, null);
    }

    public final void m13885b() {
        this.f11742f.m13782a();
    }

    final void m13881a(ReadableMap readableMap) {
        this.f11744h.m14191a(readableMap);
    }

    final void m13887c() {
        this.f11744h.m14188a();
    }

    public final void m13871a(int i, int i2, @Nullable ReadableArray readableArray) {
        UiThreadUtil.m13554b();
        View view = (View) this.f11738b.get(i);
        if (view == null) {
            throw new IllegalViewOperationException("Trying to send command to a non-existing view with tag " + i);
        }
        m13884b(i).mo765a(view, i2, readableArray);
    }

    public final void m13874a(int i, ReadableArray readableArray, Callback callback) {
        UiThreadUtil.m13554b();
        View view = (View) this.f11738b.get(i);
        if (view == null) {
            throw new JSApplicationIllegalArgumentException("Could not find view with tag " + i);
        }
        PopupMenu popupMenu = new PopupMenu(m13865d(i), view);
        Menu menu = popupMenu.getMenu();
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            menu.add(0, 0, i2, readableArray.getString(i2));
        }
        Object popupMenuCallbackHandler = new PopupMenuCallbackHandler(callback);
        popupMenu.setOnMenuItemClickListener(popupMenuCallbackHandler);
        popupMenu.setOnDismissListener(popupMenuCallbackHandler);
        popupMenu.show();
    }

    private ThemedReactContext m13865d(int i) {
        View view = (View) this.f11738b.get(i);
        if (view != null) {
            return (ThemedReactContext) view.getContext();
        }
        throw new JSApplicationIllegalArgumentException("Could not find view with tag " + i);
    }

    public final void m13869a(int i, int i2) {
        View view = (View) this.f11738b.get(i);
        if (view == null) {
            throw new JSApplicationIllegalArgumentException("Could not find view with tag " + i);
        }
        view.sendAccessibilityEvent(i2);
    }
}
