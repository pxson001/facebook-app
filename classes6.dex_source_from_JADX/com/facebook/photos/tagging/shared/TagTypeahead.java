package com.facebook.photos.tagging.shared;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.Filter.FilterListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.PhotoFlowLogger;
import com.facebook.photos.galleryutil.GlobalOnLayoutHelper;
import com.facebook.photos.galleryutil.PhotosKeyboard;
import com.facebook.photos.galleryutil.VisibilityAnimator;
import com.facebook.photos.tagging.shared.TagTypeaheadAdapter.TagTypeaheadAdapterCallback;
import com.facebook.tagging.data.TagTypeaheadDataSource;
import com.facebook.tagging.model.SetTagSuggestionsCallback;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.animations.ViewAnimator.Listener;
import com.facebook.ui.animations.ViewAnimator.SimpleListener;
import com.facebook.ui.animations.ViewAnimatorFactory;
import com.facebook.ui.animations.ViewHelperViewAnimator;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.User;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: has_message */
public class TagTypeahead extends CustomFrameLayout implements SetTagSuggestionsCallback {
    public TagSuggestionsAdapter f13320A;
    private Handler f13321B;
    private DelayedLocalSuggestionsRunnable f13322C;
    private final SelfRegistrableReceiverImpl f13323D;
    public boolean f13324E;
    private TypeaheadTextWatcher f13325F;
    private final Listener f13326G;
    private final Listener f13327H;
    @Inject
    @LoggedInUser
    volatile Provider<User> f13328a;
    @Inject
    public DefaultPhotoFlowLogger f13329b;
    @Inject
    private DefaultAndroidThreadUtil f13330c;
    @Inject
    private FamilyTagTypeaheadUtil f13331d;
    @Inject
    @LocalBroadcast
    private BaseFbBroadcastManager f13332e;
    @Inject
    private ViewHelperViewAnimatorFactory f13333f;
    public List<TaggingProfile> f13334g;
    public BubbleLayout f13335h;
    private LinearLayout f13336i;
    public EditText f13337j;
    private ProgressBar f13338k;
    private View f13339l;
    private ListView f13340m;
    public ViewHelperViewAnimator f13341n;
    public VisibilityAnimator f13342o;
    private VisibilityAnimator f13343p;
    public TagTypeaheadAdapter f13344q;
    public TagTypeaheadListener f13345r;
    private GestureDetector f13346s;
    public boolean f13347t;
    public boolean f13348u;
    public String f13349v;
    public Editable f13350w;
    public boolean f13351x;
    private boolean f13352y;
    public boolean f13353z;

    /* compiled from: has_message */
    class C08551 implements ActionReceiver {
        final /* synthetic */ TagTypeahead f13307a;

        C08551(TagTypeahead tagTypeahead) {
            this.f13307a = tagTypeahead;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 425491656);
            if (this.f13307a.f13350w != null && this.f13307a.f13350w.length() > 0) {
                this.f13307a.m21007a(this.f13307a.f13350w);
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -805269121, a);
        }
    }

    /* compiled from: has_message */
    class C08562 implements Runnable {
        final /* synthetic */ TagTypeahead f13308a;

        C08562(TagTypeahead tagTypeahead) {
            this.f13308a = tagTypeahead;
        }

        public void run() {
            int min = (int) Math.min(((float) this.f13308a.getWidth()) - (2.0f * this.f13308a.getResources().getDimension(2131430300)), this.f13308a.getResources().getDimension(2131430301));
            this.f13308a.f13324E = true;
            this.f13308a.f13335h.setMaxWidth(min);
        }
    }

    /* compiled from: has_message */
    class C08573 implements FilterListener {
        final /* synthetic */ TagTypeahead f13309a;

        C08573(TagTypeahead tagTypeahead) {
            this.f13309a = tagTypeahead;
        }

        public void onFilterComplete(int i) {
            if (this.f13309a.f13347t) {
                TagTypeahead.m20997l(this.f13309a);
            }
        }
    }

    /* compiled from: has_message */
    class C08584 implements OnFocusChangeListener {
        final /* synthetic */ TagTypeahead f13310a;

        C08584(TagTypeahead tagTypeahead) {
            this.f13310a = tagTypeahead;
        }

        public void onFocusChange(View view, boolean z) {
            this.f13310a.f13337j.setHintTextColor(this.f13310a.getResources().getColor(z ? 2131363085 : 2131363084));
        }
    }

    /* compiled from: has_message */
    class C08606 implements Listener {
        final /* synthetic */ TagTypeahead f13314a;

        C08606(TagTypeahead tagTypeahead) {
            this.f13314a = tagTypeahead;
        }

        public final void m20963a() {
            this.f13314a.f13341n;
        }

        public final void m20964b() {
            this.f13314a.f13341n.a(null);
            this.f13314a.f13342o.m20367c();
            this.f13314a.f13347t = true;
            if (this.f13314a.f13353z && this.f13314a.f13349v.isEmpty()) {
                this.f13314a.f13349v;
                this.f13314a.f13353z = false;
            }
        }
    }

    /* compiled from: has_message */
    class C08617 extends SimpleListener {
        final /* synthetic */ TagTypeahead f13315a;

        C08617(TagTypeahead tagTypeahead) {
            this.f13315a = tagTypeahead;
        }

        public final void m20965b() {
            this.f13315a.f13341n.a(null);
            this.f13315a.f13342o;
        }
    }

    /* compiled from: has_message */
    class DelayedLocalSuggestionsRunnable implements Runnable {
        final /* synthetic */ TagTypeahead f13316a;

        public DelayedLocalSuggestionsRunnable(TagTypeahead tagTypeahead) {
            this.f13316a = tagTypeahead;
        }

        public void run() {
            if (!this.f13316a.f13351x) {
                if (this.f13316a.f13334g != null && !this.f13316a.f13334g.isEmpty()) {
                    this.f13316a.setTagSuggestions(this.f13316a.f13334g);
                } else if (this.f13316a.f13320A != null) {
                    this.f13316a.setTagSuggestions(this.f13316a.f13320A.m20966a());
                }
            }
        }
    }

    /* compiled from: has_message */
    class GestureListener extends SimpleOnGestureListener {
        final /* synthetic */ TagTypeahead f13317a;

        public GestureListener(TagTypeahead tagTypeahead) {
            this.f13317a = tagTypeahead;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            this.f13317a.f13345r.m20967a();
            return super.onSingleTapUp(motionEvent);
        }
    }

    /* compiled from: has_message */
    public interface TagSuggestionsAdapter {
        List<TaggingProfile> m20966a();
    }

    /* compiled from: has_message */
    public interface TagTypeaheadListener {
        void m20967a();

        void m20968a(TaggingProfile taggingProfile, int i, String str);

        void m20969b();
    }

    /* compiled from: has_message */
    class TypeaheadItemClickListener implements OnItemClickListener {
        final /* synthetic */ TagTypeahead f13318a;

        public TypeaheadItemClickListener(TagTypeahead tagTypeahead) {
            this.f13318a = tagTypeahead;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i >= 0) {
                TaggingProfile taggingProfile = (TaggingProfile) this.f13318a.f13344q.getItem(i);
                if (!this.f13318a.f13351x) {
                    i = -1;
                }
                Log.d("TagTypeahead", "User selected position in tag suggestions=" + i);
                this.f13318a.f13345r.m20968a(taggingProfile, i, this.f13318a.f13349v);
            }
        }
    }

    /* compiled from: has_message */
    class TypeaheadTextWatcher implements TextWatcher {
        final /* synthetic */ TagTypeahead f13319a;

        public TypeaheadTextWatcher(TagTypeahead tagTypeahead) {
            this.f13319a = tagTypeahead;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.f13319a.f13329b.f12582C = editable.length();
            if (!this.f13319a.f13348u) {
                this.f13319a.f13345r.m20969b();
                this.f13319a.f13348u = true;
            }
            if (this.f13319a.f13344q.m21037d()) {
                this.f13319a.m20995k();
            }
            this.f13319a.m21007a(editable);
        }
    }

    private static <T extends View> void m20973a(Class<T> cls, T t) {
        m20974a((Object) t, t.getContext());
    }

    private static void m20974a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((TagTypeahead) obj).m20975a(IdBasedProvider.a(injectorLike, 3595), DefaultPhotoFlowLogger.m19829b(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), FamilyTagTypeaheadUtil.m20957a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), ViewHelperViewAnimatorFactory.a(injectorLike));
    }

    public TagTypeahead(Context context) {
        this(context, null);
    }

    public TagTypeahead(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13328a = UltralightRuntime.a;
        this.f13350w = null;
        this.f13326G = new C08606(this);
        this.f13327H = new C08617(this);
        m20973a(TagTypeahead.class, (View) this);
        setContentView(2130907366);
        this.f13335h = (BubbleLayout) c(2131567815);
        this.f13336i = (LinearLayout) c(2131567816);
        this.f13337j = (EditText) c(2131567817);
        this.f13338k = (ProgressBar) c(2131567818);
        this.f13339l = c(2131567819);
        this.f13340m = (ListView) c(2131567820);
        this.f13323D = this.f13332e.a().a("com.facebook.contacts.ACTION_CONTACT_SYNC_PROGRESS", new C08551(this)).a();
        this.f13321B = new Handler();
        this.f13341n = this.f13333f.a(this.f13335h);
        this.f13341n.a(300);
        ViewHelperViewAnimator viewHelperViewAnimator = this.f13341n;
        TimeInterpolator decelerateInterpolator = new DecelerateInterpolator();
        View view = (View) viewHelperViewAnimator.a.get();
        if (view != null) {
            view.animate().setInterpolator(decelerateInterpolator);
        }
        this.f13342o = new VisibilityAnimator(this.f13336i, 150, this.f13333f);
        this.f13343p = new VisibilityAnimator(this.f13338k, 150, this.f13333f);
        setVisibility(4);
        this.f13337j.setHint(2131235662);
        this.f13339l.setVisibility(8);
        this.f13346s = new GestureDetector(getContext(), new GestureListener(this));
        this.f13349v = "";
        this.f13353z = false;
        this.f13348u = false;
        GlobalOnLayoutHelper.m20350b((View) this, new C08562(this));
    }

    public void setDefaultTagSuggestions(List<TaggingProfile> list) {
        this.f13334g = list;
        m20983e();
    }

    private void m20972a(TagTypeaheadDataSource tagTypeaheadDataSource, OnItemClickListener onItemClickListener) {
        this.f13344q = new TagTypeaheadAdapter(getContext(), tagTypeaheadDataSource, this.f13330c);
        this.f13344q.f13366h = new C08573(this);
        this.f13340m.setAdapter(this.f13344q);
        this.f13340m.setOnItemClickListener(onItemClickListener);
    }

    public final void m21009a(TagTypeaheadDataSource tagTypeaheadDataSource) {
        m20972a(tagTypeaheadDataSource, new TypeaheadItemClickListener(this));
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -561296307);
        super.onAttachedToWindow();
        this.f13325F = new TypeaheadTextWatcher(this);
        this.f13337j.addTextChangedListener(this.f13325F);
        this.f13337j.setOnFocusChangeListener(new C08584(this));
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -289760401, a);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1984690908);
        if (this.f13347t) {
            this.f13346s.onTouchEvent(motionEvent);
            Logger.a(2, EntryType.UI_INPUT_END, 776598536, a);
            return true;
        }
        LogUtils.a(372357237, a);
        return false;
    }

    public final boolean m21012a() {
        return this.f13347t;
    }

    public final void m21006a(PointF pointF, final float f) {
        if (this.f13324E) {
            final PointF pointF2 = new PointF(pointF.x, pointF.y);
            GlobalOnLayoutHelper.m20352c(this.f13335h, new Runnable(this) {
                final /* synthetic */ TagTypeahead f13313c;

                public void run() {
                    this.f13313c.f13324E = false;
                    this.f13313c.m21006a(pointF2, f);
                }
            });
            return;
        }
        this.f13335h.m20944a((pointF.x - ((float) ((getWidth() - this.f13335h.getWidth()) / 2))) / ((float) this.f13335h.getWidth()), f);
    }

    private List<TaggingProfile> m20971a(@Nullable List<TaggingProfile> list) {
        List<TaggingProfile> a = Lists.a();
        String str = ((User) this.f13328a.get()).a;
        Collection a2 = this.f13331d.m20961a();
        if (list == null || list.isEmpty()) {
            a.addAll(a2);
        } else if (list.size() == 1) {
            return list;
        } else {
            if (list.get(0) == null || str == null || !Long.toString(((TaggingProfile) list.get(0)).f17539b).equals(str)) {
                a.addAll(a2);
                a.addAll(list);
            } else {
                a.add(list.get(0));
                a.addAll(a2);
                if (list.size() > 1) {
                    a.addAll(list.subList(1, list.size()));
                }
            }
        }
        return a;
    }

    public final void m21011a(boolean z, TagTypeaheadAdapterCallback tagTypeaheadAdapterCallback, List<TaggingProfile> list, PointF pointF, PointF pointF2, boolean z2) {
        this.f13323D.b();
        this.f13348u = false;
        pointF.x -= (float) (this.f13335h.getWidth() / 2);
        pointF2.x = (float) ((getWidth() / 2) - (this.f13335h.getWidth() / 2));
        this.f13344q.f13361c = tagTypeaheadAdapterCallback;
        this.f13344q.m21035b();
        boolean z3 = (list == null || list.isEmpty()) ? false : true;
        this.f13351x = z3;
        this.f13344q.f13362d = m20971a((List) list);
        this.f13344q.m21031a();
        if (this.f13351x) {
            this.f13343p.m20366b(false);
            this.f13339l.setVisibility(0);
        } else {
            this.f13343p.m20363a(false);
            this.f13339l.setVisibility(8);
        }
        this.f13340m.setSelection(0);
        if (this.f13347t) {
            m20993j();
            if (z2) {
                PhotosKeyboard.m20355a(getContext(), this.f13337j);
            }
        } else {
            this.f13335h.setMaxHeight((int) Math.min(((float) getHeight()) - pointF2.y, getResources().getDimension(2131430302)));
            if (z) {
                this.f13341n.a(0.0f, 0.0f);
                this.f13341n.a(0.0f);
                this.f13341n.c(0.0f);
                this.f13341n.e(0.0f);
                this.f13341n.g(pointF.x);
                this.f13341n.i(pointF.y);
                this.f13342o.m20366b(false);
                this.f13341n.a(this.f13326G);
                this.f13341n.b(1.0f);
                this.f13341n.d(1.0f);
                this.f13341n.f(1.0f);
                this.f13341n.h(pointF2.x);
                this.f13341n.j(pointF2.y);
            } else {
                this.f13341n.g(pointF2.x);
                this.f13341n.i(pointF2.y);
                this.f13341n;
                this.f13347t = true;
            }
        }
        m20983e();
    }

    private void m20983e() {
        if (!this.f13351x && this.f13344q != null) {
            m20989h();
            this.f13322C = new DelayedLocalSuggestionsRunnable(this);
            HandlerDetour.b(this.f13321B, this.f13322C, 5000, -1681255538);
        }
    }

    public static void m20986f(TagTypeahead tagTypeahead) {
        tagTypeahead.setVisibility(0);
        tagTypeahead.f13337j.requestFocus();
    }

    public final void m21013b() {
        this.f13344q.clear();
        m20995k();
    }

    public final void m21010a(boolean z, PointF pointF) {
        this.f13323D.c();
        m20989h();
        PhotosKeyboard.m20355a(getContext(), this.f13337j);
        this.f13344q.m21036c();
        if (z) {
            pointF.x -= (float) (this.f13335h.getWidth() / 2);
            this.f13341n.a(this.f13327H);
            this.f13341n.b(0.0f);
            this.f13341n.d(0.0f);
            this.f13341n.f(0.0f);
            this.f13341n.h(pointF.x);
            this.f13341n.j(pointF.y);
        } else {
            this.f13342o;
        }
        this.f13348u = false;
        this.f13347t = false;
    }

    public static void m20988g(TagTypeahead tagTypeahead) {
        tagTypeahead.setVisibility(4);
        tagTypeahead.m20993j();
    }

    public void setTagSuggestions(List<TaggingProfile> list) {
        if (!this.f13351x || !this.f13347t) {
            this.f13344q.f13362d = m20971a((List) list);
            this.f13351x = true;
            if (!this.f13347t) {
                this.f13353z = true;
            } else if (this.f13349v.length() == 0) {
                this.f13349v;
            }
        }
    }

    public void setTagSuggestionsAdapter(TagSuggestionsAdapter tagSuggestionsAdapter) {
        this.f13320A = tagSuggestionsAdapter;
    }

    private void m20989h() {
        if (this.f13322C != null) {
            HandlerDetour.a(this.f13321B, this.f13322C);
            this.f13322C = null;
        }
    }

    public static void m20992i(TagTypeahead tagTypeahead) {
        tagTypeahead.f13344q.m21031a();
        m20997l(tagTypeahead);
    }

    public final void m21008a(TagTypeaheadListener tagTypeaheadListener) {
        this.f13345r = tagTypeaheadListener;
    }

    private void m20993j() {
        this.f13352y = true;
        this.f13337j.setText("");
        this.f13352y = false;
    }

    private void m20995k() {
        this.f13343p.m20367c();
        this.f13339l.setVisibility(8);
    }

    public static void m20997l(TagTypeahead tagTypeahead) {
        tagTypeahead.f13343p.m20368d();
        tagTypeahead.f13339l.setVisibility(0);
    }

    public final void m21007a(Editable editable) {
        if (!this.f13352y) {
            if (editable.length() > 0) {
                if (this.f13349v.length() == 0) {
                    m21013b();
                }
                this.f13344q.getFilter().filter(editable);
            } else if (this.f13351x) {
                this.f13344q.m21031a();
                m20997l(this);
            } else {
                m21013b();
            }
        }
        this.f13350w = editable;
        this.f13349v = editable.toString();
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1903444384);
        this.f13337j.removeTextChangedListener(this.f13325F);
        this.f13325F = null;
        this.f13337j.setOnFocusChangeListener(null);
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1609830610, a);
    }

    private void m20975a(Provider<User> provider, PhotoFlowLogger photoFlowLogger, AndroidThreadUtil androidThreadUtil, FamilyTagTypeaheadUtil familyTagTypeaheadUtil, FbBroadcastManager fbBroadcastManager, ViewAnimatorFactory viewAnimatorFactory) {
        this.f13328a = provider;
        this.f13329b = photoFlowLogger;
        this.f13330c = androidThreadUtil;
        this.f13331d = familyTagTypeaheadUtil;
        this.f13332e = fbBroadcastManager;
        this.f13333f = viewAnimatorFactory;
    }
}
