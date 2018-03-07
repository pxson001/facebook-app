package com.facebook.events.sideshow;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.device.ScreenUtil;
import com.facebook.events.sideshow.BirthdayCardController.CardListener;
import com.facebook.events.sideshow.graphql.SideshowEventsAndBirthdaysQueryModels.SideshowEventsBirthdaysQueryModel.BirthdayFriendsModel.BirthdayPersonModel;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.ui.dialogs.FbDialogFragment.FbDialog;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@TargetApi(11)
/* compiled from: TYPE_SINT32 */
public class BirthdayCardsDialogFragment extends FbDialogFragment implements CardListener {
    @Inject
    ScreenUtil am;
    @Inject
    FbSharedPreferences an;
    private final List<BirthdayPersonModel> ao = new ArrayList();
    public RecyclerView ap;
    private LinearLayoutManager aq;
    public BirthdayCardController ar;
    public int as = Integer.MAX_VALUE;

    /* compiled from: TYPE_SINT32 */
    class C29292 extends OnScrollListener {
        final /* synthetic */ BirthdayCardsDialogFragment f24424a;

        C29292(BirthdayCardsDialogFragment birthdayCardsDialogFragment) {
            this.f24424a = birthdayCardsDialogFragment;
        }

        public final void m26269a(RecyclerView recyclerView, int i) {
            if (i == 0) {
                this.f24424a.aq();
                this.f24424a.ap.setOnScrollListener(null);
            }
        }
    }

    private static <T extends InjectableComponentWithContext> void m26273a(Class<T> cls, T t) {
        m26274a((Object) t, t.getContext());
    }

    private static void m26274a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((BirthdayCardsDialogFragment) obj).m26272a(ScreenUtil.a(fbInjector), (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector));
    }

    private void m26272a(ScreenUtil screenUtil, FbSharedPreferences fbSharedPreferences) {
        this.am = screenUtil;
        this.an = fbSharedPreferences;
    }

    public final void m26279a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -815281263);
        super.a(bundle);
        a(1, 2131626502);
        for (BirthdayPersonModel add : FlatBufferModelHelper.b(this.s, "birthday_cards_fragment_arg")) {
            this.ao.add(add);
        }
        m26273a(BirthdayCardsDialogFragment.class, (InjectableComponentWithContext) this);
        LogUtils.f(-1793260299, a);
    }

    public final View m26278a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2105044001);
        View inflate = layoutInflater.inflate(2130907092, viewGroup);
        this.aq = new LinearLayoutManager(layoutInflater.getContext());
        this.aq.b(0);
        this.ap = (RecyclerView) inflate.findViewById(2131567437);
        this.ar = new BirthdayCardController(this.ao, this.ap, this.an);
        this.ar.m26263a((CardListener) this);
        this.ap.setLayoutManager(this.aq);
        this.ap.setAdapter(new BirthdayCardAdapter(this.ao, this.ar, this.am));
        aq();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1160389980, a);
        return inflate;
    }

    public final void m26277G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 924736540);
        super.G();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1999651135, a);
    }

    public final void mo1137a(final BirthdayCard birthdayCard, int i) {
        ar();
        final int x = (int) birthdayCard.getX();
        this.ap.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ BirthdayCardsDialogFragment f24423c;

            public final void m26268a(RecyclerView recyclerView, int i) {
                if (i == 0 && this.f24423c.as == Integer.MAX_VALUE) {
                    int x = (int) birthdayCard.getX();
                    this.f24423c.as = x - x;
                    this.f24423c.ap.setOnScrollListener(null);
                }
            }
        });
        this.ap.b(i);
    }

    public final void mA_() {
        if (this.as != Integer.MAX_VALUE) {
            this.ap.setOnScrollListener(new C29292(this));
            this.ap.a(this.as, 0);
            this.as = Integer.MAX_VALUE;
            return;
        }
        aq();
    }

    private void ar() {
        int c = (this.am.c() - jW_().getDimensionPixelOffset(2131433973)) / 2;
        this.ap.setPadding(c, 0, c, 0);
    }

    public final Dialog m26281c(Bundle bundle) {
        return new FbDialog(this, getContext(), d()) {
            final /* synthetic */ BirthdayCardsDialogFragment f24425b;

            public void onBackPressed() {
                if (!this.f24425b.ar.m26267c()) {
                    super.onBackPressed();
                }
            }
        };
    }

    public final void aq() {
        Resources jW_ = jW_();
        int max = Math.max((this.am.c() - (this.ao.size() * jW_.getDimensionPixelOffset(2131433973))) / 2, jW_.getDimensionPixelOffset(2131433975));
        this.ap.setPadding(max, 0, max, 0);
    }
}
