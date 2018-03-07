package com.facebook.securitycheckup;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.fbui.glyph.GlyphButton;
import com.facebook.graphql.calls.SecurityCheckupLoggingInputData.Event;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.securitycheckup.api.SecurityCheckupQueryModels.SecurityCheckupQueryModel.SecurityCheckupModel;
import com.facebook.securitycheckup.items.DividerItemDecoration;
import com.facebook.securitycheckup.items.SecurityCheckupAdapter;
import com.facebook.securitycheckup.items.SecurityCheckupAdapterProvider;
import com.facebook.securitycheckup.items.SecurityCheckupConclusionViewHolder;
import com.facebook.securitycheckup.items.SecurityCheckupConclusionViewHolderProvider;
import com.facebook.securitycheckup.items.SecurityCheckupExpandableViewHolder;
import com.facebook.securitycheckup.items.SecurityCheckupExpandableViewHolderProvider;
import com.facebook.securitycheckup.items.SecurityCheckupItem;
import com.facebook.securitycheckup.items.SecurityCheckupItem.ItemType;
import com.facebook.securitycheckup.items.SecurityCheckupLayoutManager;
import com.facebook.securitycheckup.items.SecurityCheckupViewHolder;
import com.facebook.securitycheckup.utils.ViewUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: inbox_item_states */
public class SecurityCheckupScrollingController {
    public BetterRecyclerView f9702a;
    public Context f9703b;
    public SecurityCheckupLayoutManager f9704c;
    public SecurityCheckupAdapter f9705d;
    public ScrollingState f9706e;
    public GlyphButton f9707f;
    public SecurityCheckupModel f9708g;
    public int f9709h;
    public int f9710i;
    private SecurityCheckupAdapterProvider f9711j;
    public SecurityCheckupLogger f9712k;

    /* compiled from: inbox_item_states */
    class C14431 implements OnClickListener {
        final /* synthetic */ SecurityCheckupScrollingController f9688a;

        C14431(SecurityCheckupScrollingController securityCheckupScrollingController) {
            this.f9688a = securityCheckupScrollingController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -791586990);
            if (this.f9688a.f9706e == ScrollingState.EXPAND_COMPLETED) {
                this.f9688a.m9931c();
            } else {
                this.f9688a.f9712k.m9903a(Event.FINISHED_CLICK_CLOSE);
                ((FbFragmentActivity) this.f9688a.f9703b).onBackPressed();
            }
            LogUtils.a(1391114787, a);
        }
    }

    /* compiled from: inbox_item_states */
    public enum ScrollingState {
        EXPAND_STARTED,
        EXPAND_COMPLETED,
        COLLAPSE_STARTED,
        COLLAPSE_COMPLETED,
        SCROLLING
    }

    /* compiled from: inbox_item_states */
    public class SecurityCheckupItemStateChangeListener {
        public final /* synthetic */ SecurityCheckupScrollingController f9693a;

        public SecurityCheckupItemStateChangeListener(SecurityCheckupScrollingController securityCheckupScrollingController) {
            this.f9693a = securityCheckupScrollingController;
        }

        public final void m9916a(int i) {
            this.f9693a.f9706e = ScrollingState.EXPAND_STARTED;
            SecurityCheckupScrollingController securityCheckupScrollingController = this.f9693a;
            securityCheckupScrollingController.f9704c.f9863t = -1;
            securityCheckupScrollingController.f9704c.f9864u = 100;
            securityCheckupScrollingController.f9702a.b(i);
            this.f9693a.f9704c.m10041c();
        }

        public final void m9917a(int i, boolean z) {
            this.f9693a.f9710i = this.f9693a.f9709h;
            this.f9693a.f9709h = -1;
            this.f9693a.f9706e = ScrollingState.COLLAPSE_STARTED;
            this.f9693a.f9704c.f9856c = false;
            this.f9693a.f9704c.m10041c();
            if (z) {
                SecurityCheckupScrollingController securityCheckupScrollingController = this.f9693a;
                int i2 = i - 1;
                securityCheckupScrollingController.f9704c.f9863t = -1;
                securityCheckupScrollingController.f9704c.f9864u = 100;
                securityCheckupScrollingController.f9702a.b(i2);
            }
            SecurityCheckupAdapter securityCheckupAdapter = this.f9693a.f9705d;
            if (securityCheckupAdapter.f9794d != -1) {
                SecurityCheckupViewHolder securityCheckupViewHolder;
                if (securityCheckupAdapter.f9793c.indexOfKey(securityCheckupAdapter.f9794d - 1) >= 0) {
                    securityCheckupViewHolder = (SecurityCheckupViewHolder) securityCheckupAdapter.f9793c.get(securityCheckupAdapter.f9794d - 1);
                    if (securityCheckupViewHolder instanceof SecurityCheckupExpandableViewHolder) {
                        ((SecurityCheckupExpandableViewHolder) securityCheckupViewHolder).m10030c(8);
                    }
                }
                if (securityCheckupAdapter.f9793c.indexOfKey(securityCheckupAdapter.f9794d + 1) >= 0) {
                    securityCheckupViewHolder = (SecurityCheckupViewHolder) securityCheckupAdapter.f9793c.get(securityCheckupAdapter.f9794d + 1);
                    if (securityCheckupViewHolder instanceof SecurityCheckupExpandableViewHolder) {
                        ((SecurityCheckupExpandableViewHolder) securityCheckupViewHolder).m10030c(8);
                    }
                }
                securityCheckupAdapter.f9794d = -1;
            }
            SecurityCheckupScrollingController.m9925b(this.f9693a, 2130837997, 1, 0);
            this.f9693a.f9707f.setContentDescription(this.f9693a.f9703b.getResources().getString(2131241625));
        }
    }

    /* compiled from: inbox_item_states */
    public class SecurityCheckupScrollingListener extends OnScrollListener {
        int f9694a;
        int f9695b;
        public final /* synthetic */ SecurityCheckupScrollingController f9696c;
        public int f9697d = -1;
        public int f9698e = -1;
        public SecurityCheckupExpandableViewHolder f9699f;
        public SecurityCheckupExpandableViewHolder f9700g;

        public SecurityCheckupScrollingListener(SecurityCheckupScrollingController securityCheckupScrollingController) {
            this.f9696c = securityCheckupScrollingController;
        }

        public final void m9920a(RecyclerView recyclerView, int i) {
            if (this.f9696c.f9706e == ScrollingState.EXPAND_STARTED || this.f9696c.f9706e == ScrollingState.COLLAPSE_STARTED) {
                this.f9697d = -1;
                this.f9698e = -1;
                this.f9699f = null;
                this.f9700g = null;
                return;
            }
            if (i == 0) {
                SecurityCheckupViewHolder a;
                int m = this.f9696c.f9704c.m();
                int o = this.f9696c.f9704c.o();
                int i2 = this.f9697d;
                int i3 = this.f9698e;
                if (m >= 0 && m < this.f9696c.f9705d.aZ_() - 1) {
                    if (!(this.f9699f == null || this.f9697d == m || this.f9697d == o)) {
                        this.f9699f.m10032x();
                    }
                    a = SecurityCheckupScrollingController.m9924a(this.f9696c, m);
                    if ((a instanceof SecurityCheckupExpandableViewHolder) && this.f9697d != m) {
                        this.f9699f = (SecurityCheckupExpandableViewHolder) a;
                        this.f9697d = m;
                        if (this.f9697d != i3) {
                            this.f9699f.m10031w();
                        }
                    }
                }
                if (o != m && o > 0 && o < this.f9696c.f9705d.aZ_() - 1) {
                    a = SecurityCheckupScrollingController.m9924a(this.f9696c, o);
                    if ((a instanceof SecurityCheckupExpandableViewHolder) && this.f9698e != o) {
                        if (!(this.f9700g == null || this.f9698e == m)) {
                            this.f9700g.m10032x();
                        }
                        this.f9700g = (SecurityCheckupExpandableViewHolder) a;
                        this.f9698e = o;
                        if (this.f9698e != i2) {
                            this.f9700g.m10031w();
                        }
                    }
                }
            }
            if (this.f9696c.f9706e == ScrollingState.EXPAND_COMPLETED && i == 0) {
                m9918b();
            } else {
                m9919c();
            }
        }

        private void m9918b() {
            SecurityCheckupScrollingController securityCheckupScrollingController = this.f9696c;
            int i = this.f9696c.f9709h;
            securityCheckupScrollingController.f9704c.f9863t = -1;
            securityCheckupScrollingController.f9704c.f9864u = 100;
            securityCheckupScrollingController.f9702a.b(i);
        }

        private void m9919c() {
            int n = this.f9696c.f9704c.n();
            View c = this.f9696c.f9704c.c(n);
            if (c != null) {
                int top = c.getTop();
                if (n == this.f9696c.f9705d.aZ_() - 1) {
                    SecurityCheckupScrollingController securityCheckupScrollingController;
                    int i;
                    if (this.f9695b < n || (this.f9695b == n && this.f9694a > top)) {
                        if (((double) top) >= ((double) this.f9696c.f9703b.getResources().getDisplayMetrics().heightPixels) * 0.8d) {
                            securityCheckupScrollingController = this.f9696c;
                            i = n - 1;
                            securityCheckupScrollingController.f9704c.f9863t = 1;
                            securityCheckupScrollingController.f9704c.f9864u = 200;
                            securityCheckupScrollingController.f9702a.b(i);
                        } else if (this.f9696c.f9706e == ScrollingState.SCROLLING || this.f9696c.f9710i == 3) {
                            securityCheckupScrollingController = this.f9696c;
                            securityCheckupScrollingController.f9704c.f9863t = -1;
                            securityCheckupScrollingController.f9704c.f9864u = 100;
                            securityCheckupScrollingController.f9702a.b(n);
                        } else {
                            securityCheckupScrollingController = this.f9696c;
                            i = n - 1;
                            securityCheckupScrollingController.f9704c.f9863t = 1;
                            securityCheckupScrollingController.f9704c.f9864u = 100;
                            securityCheckupScrollingController.f9702a.b(i);
                        }
                    }
                    if (this.f9695b > n || (this.f9695b == n && this.f9694a < top)) {
                        if (((double) top) > ((double) this.f9696c.f9703b.getResources().getDisplayMetrics().heightPixels) * 0.2d) {
                            securityCheckupScrollingController = this.f9696c;
                            i = n - 2;
                            securityCheckupScrollingController.f9704c.f9863t = 1;
                            securityCheckupScrollingController.f9704c.f9864u = 100;
                            securityCheckupScrollingController.f9702a.b(i);
                        } else {
                            securityCheckupScrollingController = this.f9696c;
                            i = this.f9696c.f9705d.aZ_() - 1;
                            securityCheckupScrollingController.f9704c.f9863t = -1;
                            securityCheckupScrollingController.f9704c.f9864u = 200;
                            securityCheckupScrollingController.f9702a.b(i);
                        }
                    }
                }
                this.f9695b = n;
                this.f9694a = top;
                if (this.f9696c.f9706e == ScrollingState.COLLAPSE_COMPLETED) {
                    this.f9696c.f9706e = ScrollingState.SCROLLING;
                }
            }
        }
    }

    /* compiled from: inbox_item_states */
    public class SecurityCheckupScrollingStateChangeListener {
        final /* synthetic */ SecurityCheckupScrollingController f9701a;

        public SecurityCheckupScrollingStateChangeListener(SecurityCheckupScrollingController securityCheckupScrollingController) {
            this.f9701a = securityCheckupScrollingController;
        }

        public final void m9921a(int i, double d) {
            if (d == 0.9d) {
                SecurityCheckupViewHolder a = SecurityCheckupScrollingController.m9924a(this.f9701a, this.f9701a.f9709h);
                SecurityCheckupViewHolder a2 = SecurityCheckupScrollingController.m9924a(this.f9701a, i);
                if (a2 instanceof SecurityCheckupExpandableViewHolder) {
                    ((SecurityCheckupExpandableViewHolder) a2).m10033y();
                }
                if (a instanceof SecurityCheckupExpandableViewHolder) {
                    ((SecurityCheckupExpandableViewHolder) a).m10029b(false);
                }
            }
        }

        public final void m9922b(int i, double d) {
            SecurityCheckupViewHolder a;
            if (d == 0.05d && i == this.f9701a.f9705d.aZ_() - 2) {
                SecurityCheckupScrollingController securityCheckupScrollingController = this.f9701a;
                Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(20);
                alphaAnimation.setInterpolator(new AccelerateInterpolator());
                alphaAnimation.setAnimationListener(new AnimationListener(securityCheckupScrollingController, 0, 2131361957, 0) {
                    final /* synthetic */ SecurityCheckupScrollingController f9692d;

                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        switch (r8) {
                            case 0:
                                this.f9692d.f9707f.setGlyphColor(this.f9692d.f9703b.getResources().getColor(r7));
                                return;
                            case 1:
                                this.f9692d.f9707f.setImageDrawable(this.f9692d.f9703b.getResources().getDrawable(r7));
                                int a = ViewUtil.m10068a(this.f9692d.f9703b.getResources().getDisplayMetrics(), r9);
                                this.f9692d.f9707f.setPadding(a, a, a, a);
                                return;
                            default:
                                return;
                        }
                    }

                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                Animation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setDuration(20);
                alphaAnimation2.setStartOffset(20);
                alphaAnimation2.setInterpolator(new DecelerateInterpolator());
                Animation animationSet = new AnimationSet(false);
                animationSet.addAnimation(alphaAnimation2);
                animationSet.addAnimation(alphaAnimation);
                securityCheckupScrollingController.f9707f.startAnimation(animationSet);
                a = SecurityCheckupScrollingController.m9924a(this.f9701a, this.f9701a.f9705d.aZ_() - 1);
                if (a instanceof SecurityCheckupConclusionViewHolder) {
                    ((SecurityCheckupConclusionViewHolder) a).m10021x();
                }
            }
            if (d == 0.1d) {
                SecurityCheckupViewHolder a2 = SecurityCheckupScrollingController.m9924a(this.f9701a, this.f9701a.f9709h);
                a = SecurityCheckupScrollingController.m9924a(this.f9701a, i);
                if (a instanceof SecurityCheckupExpandableViewHolder) {
                    ((SecurityCheckupExpandableViewHolder) a).m10033y();
                }
                if (a2 instanceof SecurityCheckupExpandableViewHolder) {
                    ((SecurityCheckupExpandableViewHolder) a2).m10029b(false);
                }
            }
        }

        public final void m9923c(int i, double d) {
            if (d == 0.05d && i == this.f9701a.f9705d.aZ_() - 2) {
                SecurityCheckupScrollingController securityCheckupScrollingController = this.f9701a;
                Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(20);
                alphaAnimation.setInterpolator(new AccelerateInterpolator());
                alphaAnimation.setAnimationListener(/* anonymous class already generated */);
                Animation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setDuration(20);
                alphaAnimation2.setStartOffset(20);
                alphaAnimation2.setInterpolator(new DecelerateInterpolator());
                Animation animationSet = new AnimationSet(false);
                animationSet.addAnimation(alphaAnimation2);
                animationSet.addAnimation(alphaAnimation);
                securityCheckupScrollingController.f9707f.startAnimation(animationSet);
                SecurityCheckupViewHolder a = SecurityCheckupScrollingController.m9924a(this.f9701a, this.f9701a.f9705d.aZ_() - 1);
                if (a instanceof SecurityCheckupConclusionViewHolder) {
                    this.f9701a.f9712k.m9903a(Event.FINALE_SHOWN);
                    ((SecurityCheckupConclusionViewHolder) a).m10020w();
                }
            }
        }
    }

    static /* synthetic */ void m9925b(SecurityCheckupScrollingController securityCheckupScrollingController, final int i, final int i2, final int i3) {
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(20);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setAnimationListener(/* anonymous class already generated */);
        Animation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation2.setDuration(20);
        alphaAnimation2.setStartOffset(20);
        alphaAnimation2.setInterpolator(new DecelerateInterpolator());
        Animation animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation2);
        animationSet.addAnimation(alphaAnimation);
        securityCheckupScrollingController.f9707f.startAnimation(animationSet);
    }

    @Inject
    public SecurityCheckupScrollingController(@Assisted Context context, @Assisted SecurityCheckupModel securityCheckupModel, @Assisted BetterRecyclerView betterRecyclerView, @Assisted GlyphButton glyphButton, SecurityCheckupAdapterProvider securityCheckupAdapterProvider, SecurityCheckupLogger securityCheckupLogger) {
        this.f9703b = context;
        this.f9702a = betterRecyclerView;
        this.f9707f = glyphButton;
        this.f9708g = securityCheckupModel;
        this.f9711j = securityCheckupAdapterProvider;
        this.f9712k = securityCheckupLogger;
    }

    public final void m9930a() {
        SecurityCheckupAdapterProvider securityCheckupAdapterProvider = this.f9711j;
        this.f9705d = new SecurityCheckupAdapter(m9926d(), (SecurityCheckupExpandableViewHolderProvider) securityCheckupAdapterProvider.getOnDemandAssistedProviderForStaticDi(SecurityCheckupExpandableViewHolderProvider.class), (SecurityCheckupConclusionViewHolderProvider) securityCheckupAdapterProvider.getOnDemandAssistedProviderForStaticDi(SecurityCheckupConclusionViewHolderProvider.class));
        this.f9705d.f9792b = new SecurityCheckupItemStateChangeListener(this);
        this.f9706e = ScrollingState.SCROLLING;
        this.f9704c = new SecurityCheckupLayoutManager(this.f9703b, 1, false);
        this.f9704c.f9858e = new SecurityCheckupScrollingStateChangeListener(this);
        this.f9702a.setLayoutManager(this.f9704c);
        this.f9702a.setAdapter(this.f9705d);
        this.f9702a.a(new DividerItemDecoration(this.f9703b));
        this.f9702a.setItemAnimator(new DefaultItemAnimator());
        this.f9702a.setOnScrollListener(new SecurityCheckupScrollingListener(this));
        this.f9707f.setOnClickListener(new C14431(this));
    }

    public final void m9931c() {
        if (this.f9709h != -1) {
            SecurityCheckupViewHolder a = m9924a(this, this.f9709h);
            if (a instanceof SecurityCheckupExpandableViewHolder) {
                ((SecurityCheckupExpandableViewHolder) a).m10029b(true);
            }
        }
    }

    public static SecurityCheckupViewHolder m9924a(SecurityCheckupScrollingController securityCheckupScrollingController, int i) {
        View c = securityCheckupScrollingController.f9704c.c(i);
        if (c == null) {
            return null;
        }
        return (SecurityCheckupViewHolder) c.getTag();
    }

    private List<SecurityCheckupItem> m9926d() {
        List<SecurityCheckupItem> arrayList = new ArrayList();
        SecurityCheckupItem securityCheckupItem = new SecurityCheckupItem(this.f9703b.getResources().getString(2131241579), this.f9703b.getResources().getString(2131241580), "", ItemType.INTRO, this.f9708g);
        securityCheckupItem.f9846e = false;
        arrayList.add(securityCheckupItem);
        arrayList.add(m9927f());
        arrayList.add(m9928g());
        securityCheckupItem = new SecurityCheckupItem(this.f9703b.getResources().getString(2131241591), this.f9703b.getResources().getString(2131241592), this.f9703b.getResources().getString(2131241593), ItemType.PASSWORD, this.f9708g);
        securityCheckupItem.f9846e = true;
        arrayList.add(securityCheckupItem);
        securityCheckupItem = new SecurityCheckupItem(this.f9703b.getResources().getString(2131241594), this.f9703b.getResources().getString(2131241595), this.f9703b.getResources().getString(2131241596), ItemType.CONCLUSION, this.f9708g);
        securityCheckupItem.f9846e = true;
        arrayList.add(securityCheckupItem);
        return arrayList;
    }

    private SecurityCheckupItem m9927f() {
        int size;
        if (this.f9708g != null) {
            size = this.f9708g.m9979j().size();
        } else {
            size = 0;
        }
        SecurityCheckupItem securityCheckupItem = new SecurityCheckupItem(this.f9703b.getResources().getString(2131241581), size == 0 ? this.f9703b.getResources().getString(2131241624) : this.f9703b.getResources().getString(2131241582, new Object[]{Integer.valueOf(size)}), this.f9703b.getResources().getString(size == 0 ? 2131241585 : 2131241584), ItemType.UNUSED_SESSIONS, this.f9708g);
        securityCheckupItem.f9846e = true;
        if (size == 0) {
            securityCheckupItem.f9848g = true;
        }
        return securityCheckupItem;
    }

    private SecurityCheckupItem m9928g() {
        SecurityCheckupItem securityCheckupItem = new SecurityCheckupItem(this.f9703b.getResources().getString(2131241586), this.f9703b.getResources().getString(m9929h() ? 2131241588 : 2131241587), this.f9703b.getResources().getString(m9929h() ? 2131241590 : 2131241589), ItemType.LOGIN_ALERTS, this.f9708g);
        securityCheckupItem.f9846e = true;
        return securityCheckupItem;
    }

    private boolean m9929h() {
        return (this.f9708g == null || this.f9708g.m9978a() == null || (!this.f9708g.m9978a().m9971j() && !this.f9708g.m9978a().m9972k() && !this.f9708g.m9978a().m9973l())) ? false : true;
    }
}
