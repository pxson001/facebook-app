package com.facebook.securitycheckup.inner;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.calls.EndSessionsInputData;
import com.facebook.graphql.calls.EndSessionsInputData.SecurityCheckupSource;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.SecurityCheckupLoggingInputData.Event;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.securitycheckup.SecurityCheckupLogger;
import com.facebook.securitycheckup.SecurityCheckupState;
import com.facebook.securitycheckup.api.EndSessionsMutation.EndSessionsMutationString;
import com.facebook.securitycheckup.api.SecurityCheckupQueryModels.SecurityCheckupQueryModel.SecurityCheckupModel;
import com.facebook.securitycheckup.api.SecurityCheckupQueryModels.SecurityCheckupUnusedUserSessionsFragmentModel;
import com.facebook.securitycheckup.items.DividerItemDecoration;
import com.facebook.securitycheckup.items.SecurityCheckupItem.ItemType;
import com.facebook.securitycheckup.utils.HelpPageUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.compat.fbrelativelayout.FbRelativeLayout;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;

/* compiled from: immersive_activity_create */
public class SecurityCheckupInnerController {
    public SecurityCheckupInnerItem f9751a;
    public SecurityCheckupInnerItem f9752b;
    public SecurityCheckupInnerItem f9753c;
    public BetterRecyclerView f9754d;
    private LinearLayoutManager f9755e;
    public FbButton f9756f;
    public FbButton f9757g;
    public FbButton f9758h;
    public Context f9759i;
    public SecurityCheckupModel f9760j;
    public ItemType f9761k;
    public FbRelativeLayout f9762l;
    public ImageView f9763m;
    private ImageView f9764n;
    public ImageView f9765o;
    public FbTextView f9766p;
    public InertCheckBox f9767q;
    public boolean f9768r;
    public SecurityCheckupInnerAdapter f9769s;
    public Lazy<GraphQLQueryExecutor> f9770t;
    public HelpPageUtil f9771u;
    public SecurityCheckupState f9772v;
    private Runnable f9773w;
    public SecurityCheckupLogger f9774x;

    /* compiled from: immersive_activity_create */
    class C14451 implements OnClickListener {
        final /* synthetic */ SecurityCheckupInnerController f9741a;

        C14451(SecurityCheckupInnerController securityCheckupInnerController) {
            this.f9741a = securityCheckupInnerController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -30047461);
            ((Activity) this.f9741a.f9759i).onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -662941781, a);
        }
    }

    /* compiled from: immersive_activity_create */
    class C14472 implements OnClickListener {
        final /* synthetic */ SecurityCheckupInnerController f9743a;

        /* compiled from: immersive_activity_create */
        class C14461 implements Runnable {
            final /* synthetic */ C14472 f9742a;

            C14461(C14472 c14472) {
                this.f9742a = c14472;
            }

            public void run() {
                ((Activity) this.f9742a.f9743a.f9759i).onBackPressed();
            }
        }

        C14472(SecurityCheckupInnerController securityCheckupInnerController) {
            this.f9743a = securityCheckupInnerController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 246668278);
            this.f9743a.f9756f.setEnabled(false);
            SecurityCheckupInnerController.m10008j(this.f9743a);
            SecurityCheckupInnerController securityCheckupInnerController = this.f9743a;
            securityCheckupInnerController.f9766p.setText(securityCheckupInnerController.f9759i.getResources().getString(2131241607, new Object[]{Integer.valueOf(securityCheckupInnerController.f9769s.aZ_())}));
            securityCheckupInnerController.f9756f.setText(securityCheckupInnerController.f9759i.getString(2131241604));
            if (this.f9743a.f9768r) {
                this.f9743a.f9767q.setChecked(false);
                HandlerDetour.b(new Handler(), new C14461(this), 700, -444864052);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1645368352, a);
        }
    }

    /* compiled from: immersive_activity_create */
    class C14483 implements OnClickListener {
        final /* synthetic */ SecurityCheckupInnerController f9744a;

        C14483(SecurityCheckupInnerController securityCheckupInnerController) {
            this.f9744a = securityCheckupInnerController;
        }

        public void onClick(View view) {
            boolean z;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -40107449);
            SecurityCheckupInnerController securityCheckupInnerController = this.f9744a;
            if (this.f9744a.f9768r) {
                z = false;
            } else {
                z = true;
            }
            securityCheckupInnerController.f9768r = z;
            this.f9744a.f9767q.setChecked(this.f9744a.f9768r);
            for (int i = 0; i < this.f9744a.f9769s.aZ_(); i++) {
                this.f9744a.f9769s.m10003e(i).f9779e = this.f9744a.f9768r;
            }
            if (this.f9744a.f9768r) {
                this.f9744a.f9756f.setEnabled(true);
                this.f9744a.f9756f.setText(this.f9744a.f9759i.getString(2131241603));
            } else {
                this.f9744a.f9756f.setEnabled(false);
                this.f9744a.f9756f.setText(this.f9744a.f9759i.getString(2131241604));
            }
            this.f9744a.f9769s.notifyDataSetChanged();
            LogUtils.a(-394422243, a);
        }
    }

    /* compiled from: immersive_activity_create */
    public class C14504 implements OnClickListener {
        final /* synthetic */ SecurityCheckupInnerController f9746a;

        /* compiled from: immersive_activity_create */
        class C14491 implements Runnable {
            final /* synthetic */ C14504 f9745a;

            C14491(C14504 c14504) {
                this.f9745a = c14504;
            }

            public void run() {
                ((Activity) this.f9745a.f9746a.f9759i).onBackPressed();
            }
        }

        public C14504(SecurityCheckupInnerController securityCheckupInnerController) {
            this.f9746a = securityCheckupInnerController;
        }

        public void onClick(View view) {
            boolean z;
            int a = Logger.a(2, EntryType.UI_INPUT_START, 797806272);
            this.f9746a.f9774x.m9903a(Event.LA_TURN_OFF);
            SecurityCheckupState securityCheckupState = this.f9746a.f9772v;
            boolean z2 = false;
            if (securityCheckupState.f9716b == null || !securityCheckupState.f9716b.f9779e) {
                z = false;
            } else {
                z = true;
            }
            securityCheckupState.f9719e = z;
            if (securityCheckupState.f9717c == null || !securityCheckupState.f9717c.f9779e) {
                z = false;
            } else {
                z = true;
            }
            securityCheckupState.f9720f = z;
            if (securityCheckupState.f9718d != null && securityCheckupState.f9718d.f9779e) {
                z2 = true;
            }
            securityCheckupState.f9721g = z2;
            securityCheckupState.f9722h = true;
            for (int i = 0; i < this.f9746a.f9769s.aZ_(); i++) {
                this.f9746a.f9769s.m10003e(i).f9779e = false;
            }
            this.f9746a.f9769s.notifyDataSetChanged();
            this.f9746a.f9757g.setVisibility(8);
            this.f9746a.f9756f.setVisibility(0);
            HandlerDetour.b(new Handler(), new C14491(this), 700, -1652354570);
            LogUtils.a(-1569940435, a);
        }
    }

    /* compiled from: immersive_activity_create */
    public class C14515 implements OnClickListener {
        final /* synthetic */ SecurityCheckupInnerController f9747a;

        public C14515(SecurityCheckupInnerController securityCheckupInnerController) {
            this.f9747a = securityCheckupInnerController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1963001658);
            this.f9747a.f9751a.f9779e = true;
            this.f9747a.f9769s.notifyDataSetChanged();
            this.f9747a.f9757g.setVisibility(0);
            this.f9747a.f9756f.setVisibility(8);
            Logger.a(2, EntryType.UI_INPUT_END, -23552229, a);
        }
    }

    /* compiled from: immersive_activity_create */
    public class C14526 implements OnClickListener {
        final /* synthetic */ SecurityCheckupInnerController f9748a;

        public C14526(SecurityCheckupInnerController securityCheckupInnerController) {
            this.f9748a = securityCheckupInnerController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1644055994);
            this.f9748a.f9774x.m9903a(Event.LA_LEARN_MORE);
            this.f9748a.f9771u.m10067a("/help/162968940433354");
            Logger.a(2, EntryType.UI_INPUT_END, -1169938963, a);
        }
    }

    /* compiled from: immersive_activity_create */
    public /* synthetic */ class C14537 {
        public static final /* synthetic */ int[] f9749a = new int[ItemType.values().length];

        static {
            try {
                f9749a[ItemType.UNUSED_SESSIONS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9749a[ItemType.LOGIN_ALERTS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f9749a[ItemType.PASSWORD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: immersive_activity_create */
    public class SecurityCheckupInnerItemSelectionStateListener {
        public final /* synthetic */ SecurityCheckupInnerController f9750a;

        public SecurityCheckupInnerItemSelectionStateListener(SecurityCheckupInnerController securityCheckupInnerController) {
            this.f9750a = securityCheckupInnerController;
        }

        public final void m10004b() {
            switch (C14537.f9749a[this.f9750a.f9761k.ordinal()]) {
                case 1:
                    if (this.f9750a.f9768r) {
                        this.f9750a.f9768r = false;
                        this.f9750a.f9767q.setChecked(false);
                    }
                    int d = this.f9750a.f9769s.m10002d();
                    if (d == 0) {
                        this.f9750a.f9756f.setEnabled(false);
                        this.f9750a.f9756f.setText(this.f9750a.f9759i.getString(2131241604));
                        return;
                    } else if (d == 1) {
                        this.f9750a.f9756f.setText(this.f9750a.f9759i.getString(2131241604));
                        return;
                    } else {
                        this.f9750a.f9756f.setText(this.f9750a.f9759i.getString(2131241606, new Object[]{Integer.valueOf(d)}));
                        return;
                    }
                case 2:
                    if (this.f9750a.f9769s.m10002d() == 0) {
                        this.f9750a.f9756f.setVisibility(0);
                        this.f9750a.f9757g.setVisibility(4);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Inject
    public SecurityCheckupInnerController(@Assisted View view, @Assisted Context context, @Assisted ItemType itemType, @Assisted SecurityCheckupModel securityCheckupModel, @Assisted Runnable runnable, Lazy<GraphQLQueryExecutor> lazy, HelpPageUtil helpPageUtil, SecurityCheckupState securityCheckupState, SecurityCheckupLogger securityCheckupLogger) {
        this.f9754d = (BetterRecyclerView) view.findViewById(2131567340);
        this.f9756f = (FbButton) view.findViewById(2131567344);
        this.f9757g = (FbButton) view.findViewById(2131567343);
        this.f9758h = (FbButton) view.findViewById(2131567345);
        this.f9762l = (FbRelativeLayout) view.findViewById(2131567335);
        this.f9763m = (ImageView) view.findViewById(2131567334);
        this.f9764n = (ImageView) view.findViewById(2131567339);
        this.f9766p = (FbTextView) view.findViewById(2131567336);
        this.f9767q = (InertCheckBox) view.findViewById(2131567338);
        this.f9765o = (ImageView) view.findViewById(2131567342);
        this.f9759i = context;
        this.f9761k = itemType;
        this.f9760j = securityCheckupModel;
        this.f9770t = lazy;
        this.f9771u = helpPageUtil;
        this.f9772v = securityCheckupState;
        this.f9773w = runnable;
        this.f9774x = securityCheckupLogger;
    }

    public final void m10009a() {
        this.f9755e = new LinearLayoutManager(this.f9759i);
        this.f9754d.setLayoutManager(this.f9755e);
        switch (C14537.f9749a[this.f9761k.ordinal()]) {
            case 1:
                m10006d();
                break;
            case 2:
                List list;
                boolean z = false;
                if (this.f9760j.m9978a() == null) {
                    list = null;
                } else {
                    SecurityCheckupState securityCheckupState = this.f9772v;
                    List arrayList = new ArrayList();
                    if (securityCheckupState.f9716b != null) {
                        arrayList.add(securityCheckupState.f9716b);
                    }
                    if (securityCheckupState.f9717c != null) {
                        arrayList.add(securityCheckupState.f9717c);
                    }
                    if (securityCheckupState.f9718d != null) {
                        arrayList.add(securityCheckupState.f9718d);
                    }
                    list = arrayList;
                    if (list.size() > 0) {
                        if (!this.f9772v.m9934i()) {
                            SecurityCheckupState securityCheckupState2 = this.f9772v;
                            if (securityCheckupState2.f9722h) {
                                if (securityCheckupState2.f9716b != null) {
                                    securityCheckupState2.f9716b.f9779e = securityCheckupState2.f9719e;
                                }
                                if (securityCheckupState2.f9717c != null) {
                                    securityCheckupState2.f9717c.f9779e = securityCheckupState2.f9720f;
                                }
                                if (securityCheckupState2.f9718d != null) {
                                    securityCheckupState2.f9718d.f9779e = securityCheckupState2.f9721g;
                                }
                                securityCheckupState2.f9722h = false;
                            } else {
                                securityCheckupState2.f9716b.f9779e = true;
                            }
                        }
                        this.f9751a = this.f9772v.f9716b;
                        this.f9752b = this.f9772v.f9717c;
                        this.f9753c = this.f9772v.f9718d;
                    } else {
                        Object obj;
                        this.f9751a = SecurityCheckupInnerItem.m10011a(2130841123, this.f9759i.getResources().getString(2131241599), "");
                        this.f9751a.f9779e = this.f9760j.m9978a().m9972k();
                        list.add(this.f9751a);
                        boolean z2 = !StringUtil.a(this.f9760j.m9978a().m9969a());
                        if (z2) {
                            this.f9752b = SecurityCheckupInnerItem.m10011a(2130841122, this.f9759i.getResources().getString(2131241600), this.f9760j.m9978a().m9969a());
                            this.f9752b.f9779e = this.f9760j.m9978a().m9971j();
                            list.add(this.f9752b);
                        }
                        if (!StringUtil.a(this.f9760j.m9978a().m9974m())) {
                            z = true;
                        }
                        if (z && (!z2 || this.f9760j.m9978a().m9973l())) {
                            this.f9753c = SecurityCheckupInnerItem.m10011a(2130841124, this.f9759i.getResources().getString(2131241601), this.f9760j.m9978a().m9974m());
                            this.f9753c.f9779e = this.f9760j.m9978a().m9973l();
                            list.add(this.f9753c);
                        }
                        if (this.f9760j == null || this.f9760j.m9978a() == null || !(this.f9760j.m9978a().m9971j() || this.f9760j.m9978a().m9972k() || this.f9760j.m9978a().m9973l())) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        if (obj == null) {
                            this.f9751a.f9779e = true;
                        }
                        this.f9772v.f9716b = this.f9751a;
                        this.f9772v.f9717c = this.f9752b;
                        this.f9772v.f9718d = this.f9753c;
                    }
                }
                this.f9769s = new SecurityCheckupInnerAdapter(list);
                this.f9769s.f9740b = new SecurityCheckupInnerItemSelectionStateListener(this);
                this.f9757g.setText(this.f9759i.getResources().getString(2131241598));
                this.f9757g.setOnClickListener(new C14504(this));
                this.f9756f.setText(this.f9759i.getResources().getString(2131241597));
                this.f9756f.setOnClickListener(new C14515(this));
                this.f9758h.setText(this.f9759i.getResources().getString(2131241602));
                this.f9758h.setOnClickListener(new C14526(this));
                this.f9754d.setAdapter(this.f9769s);
                this.f9754d.a(new DividerItemDecoration(this.f9759i));
                this.f9762l.setVisibility(8);
                this.f9763m.setVisibility(8);
                this.f9765o.setVisibility(8);
                break;
        }
        this.f9754d.requestFocus();
    }

    private void m10006d() {
        this.f9769s = new SecurityCheckupInnerAdapter(m10007h());
        this.f9769s.f9740b = new SecurityCheckupInnerItemSelectionStateListener(this);
        this.f9758h.setVisibility(8);
        this.f9757g.setText(this.f9759i.getString(2131241605));
        this.f9757g.setOnClickListener(new C14451(this));
        if (this.f9769s.aZ_() > 0) {
            this.f9756f.setText(this.f9759i.getString(this.f9769s.aZ_() == 1 ? 2131241604 : 2131241603));
            this.f9756f.setOnClickListener(new C14472(this));
            this.f9757g.setVisibility(8);
            this.f9756f.setVisibility(0);
            this.f9766p.setText(this.f9759i.getResources().getString(2131241607, new Object[]{Integer.valueOf(this.f9769s.aZ_())}));
            this.f9768r = true;
            this.f9767q.setChecked(this.f9769s.aZ_() > 0);
            this.f9762l.setOnClickListener(new C14483(this));
            this.f9754d.setAdapter(this.f9769s);
            this.f9754d.a(new DividerItemDecoration(this.f9759i));
            return;
        }
        this.f9763m.setVisibility(8);
        this.f9764n.setVisibility(8);
        this.f9762l.setVisibility(8);
        this.f9757g.setVisibility(0);
        this.f9756f.setVisibility(8);
    }

    private List<SecurityCheckupInnerItem> m10007h() {
        if (this.f9772v.f9715a != null) {
            for (SecurityCheckupInnerItem securityCheckupInnerItem : this.f9772v.f9715a) {
                securityCheckupInnerItem.f9779e = true;
            }
            return this.f9772v.f9715a;
        }
        List<SecurityCheckupInnerItem> arrayList = new ArrayList();
        ImmutableList j = this.f9760j.m9979j();
        int size = j.size();
        for (int i = 0; i < size; i++) {
            int i2;
            SecurityCheckupInnerItem securityCheckupInnerItem2;
            SecurityCheckupUnusedUserSessionsFragmentModel securityCheckupUnusedUserSessionsFragmentModel = (SecurityCheckupUnusedUserSessionsFragmentModel) j.get(i);
            if (securityCheckupUnusedUserSessionsFragmentModel.m9988a().equals("desktop")) {
                i2 = 2130839826;
            } else if (securityCheckupUnusedUserSessionsFragmentModel.m9988a().equals("app")) {
                i2 = 2130839693;
            } else if (securityCheckupUnusedUserSessionsFragmentModel.m9988a().equals("tablet")) {
                i2 = 2130840121;
            } else {
                i2 = -1;
            }
            SecurityCheckupInnerItem a;
            if (i2 != -1) {
                a = SecurityCheckupInnerItem.m10011a(i2, securityCheckupUnusedUserSessionsFragmentModel.m9991k().a(), m10005a((long) securityCheckupUnusedUserSessionsFragmentModel.m9990j()));
                a.f9780f = securityCheckupUnusedUserSessionsFragmentModel.m9992l();
                securityCheckupInnerItem2 = a;
            } else {
                a = SecurityCheckupInnerItem.m10012a(Uri.parse(securityCheckupUnusedUserSessionsFragmentModel.m9988a()), securityCheckupUnusedUserSessionsFragmentModel.m9991k().a(), m10005a((long) securityCheckupUnusedUserSessionsFragmentModel.m9990j()));
                a.f9780f = securityCheckupUnusedUserSessionsFragmentModel.m9992l();
                securityCheckupInnerItem2 = a;
            }
            securityCheckupInnerItem2.f9779e = true;
            arrayList.add(securityCheckupInnerItem2);
        }
        this.f9772v.f9715a = arrayList;
        return arrayList;
    }

    private String m10005a(long j) {
        int max = Math.max(1, ((int) ((System.currentTimeMillis() / 1000) - j)) / 2592000);
        return this.f9759i.getResources().getQuantityString(2131689801, max, new Object[]{Integer.valueOf(max)});
    }

    public static void m10008j(SecurityCheckupInnerController securityCheckupInnerController) {
        List arrayList = new ArrayList();
        for (int aZ_ = securityCheckupInnerController.f9769s.aZ_() - 1; aZ_ >= 0; aZ_--) {
            SecurityCheckupInnerItem e = securityCheckupInnerController.f9769s.m10003e(aZ_);
            if (e.f9779e) {
                arrayList.addAll(Arrays.asList(e.f9780f.split(",")));
                SecurityCheckupInnerAdapter securityCheckupInnerAdapter = securityCheckupInnerController.f9769s;
                securityCheckupInnerAdapter.f9739a.remove(aZ_);
                securityCheckupInnerAdapter.l_(aZ_);
            }
        }
        if (!arrayList.isEmpty()) {
            securityCheckupInnerController.f9773w.run();
        }
        EndSessionsInputData endSessionsInputData = new EndSessionsInputData();
        endSessionsInputData.a("session_ids", arrayList);
        GraphQlCallInput graphQlCallInput = endSessionsInputData;
        graphQlCallInput.a("security_checkup_source", SecurityCheckupSource.FB4A_MEGAPHONE);
        graphQlCallInput = graphQlCallInput;
        GraphQlQueryString endSessionsMutationString = new EndSessionsMutationString();
        endSessionsMutationString.a("input", graphQlCallInput);
        ((GraphQLQueryExecutor) securityCheckupInnerController.f9770t.get()).a(GraphQLRequest.a(endSessionsMutationString));
    }
}
