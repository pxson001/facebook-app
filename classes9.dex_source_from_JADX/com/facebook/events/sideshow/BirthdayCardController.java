package com.facebook.events.sideshow;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.PopupWindow;
import com.facebook.common.collect.ReentrantCallback;
import com.facebook.composer.publish.ComposerPublishService;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.composer.publish.common.PublishPostParams.Builder;
import com.facebook.events.sideshow.graphql.SideshowEventsAndBirthdaysQueryModels.SideshowEventsBirthdaysQueryModel.BirthdayFriendsModel.BirthdayPersonModel;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;

/* compiled from: TYPE_SINT64 */
public class BirthdayCardController {
    private static final PrefKey f24410a = ((PrefKey) ((PrefKey) ((PrefKey) SharedPrefKeys.h.a("events/")).a("sideshow/")).a("birthdays/"));
    private int f24411b;
    private BirthdayCard f24412c;
    private AnimatedBirthdayCard f24413d;
    private PopupWindow f24414e;
    private View f24415f;
    private List<BirthdayPersonModel> f24416g;
    private FbSharedPreferences f24417h;
    private Context f24418i;
    private HashMap<Integer, List<String>> f24419j = null;
    private final ReentrantCallback<CardListener> f24420k = new ReentrantCallback();

    /* compiled from: TYPE_SINT64 */
    public interface CardListener {
        void mo1137a(BirthdayCard birthdayCard, int i);

        void mA_();
    }

    public BirthdayCardController(List<BirthdayPersonModel> list, View view, FbSharedPreferences fbSharedPreferences) {
        this.f24418i = view.getContext();
        this.f24415f = view;
        this.f24416g = list;
        this.f24417h = fbSharedPreferences;
    }

    private boolean m26258d() {
        return this.f24413d != null;
    }

    public final void m26262a(int i, BirthdayCard birthdayCard) {
        if (!m26258d()) {
            birthdayCard.m26249b();
            int[] iArr = new int[2];
            birthdayCard.findViewById(2131559580).getLocationOnScreen(iArr);
            m26256a((BirthdayPersonModel) this.f24416g.get(i), iArr[1], iArr[0]);
            Iterator it = this.f24420k.iterator();
            while (it.hasNext()) {
                ((CardListener) it.next()).mo1137a(birthdayCard, i);
            }
            this.f24411b = i;
            this.f24412c = birthdayCard;
        }
    }

    public final void m26261a() {
        if (m26258d()) {
            Iterator it = this.f24420k.iterator();
            while (it.hasNext()) {
                ((CardListener) it.next()).mA_();
            }
        }
    }

    public final void m26266b() {
        if (m26258d()) {
            this.f24414e.dismiss();
            this.f24414e = null;
            this.f24413d = null;
            this.f24412c.m26248a(m26265a(((BirthdayPersonModel) this.f24416g.get(this.f24411b)).m26326k()));
            this.f24412c = null;
        }
    }

    private void m26256a(BirthdayPersonModel birthdayPersonModel, int i, int i2) {
        this.f24413d = new AnimatedBirthdayCard(this.f24415f.getContext(), i, i2);
        this.f24414e = new PopupWindow(this.f24413d, -1, -1, true);
        this.f24414e.setFocusable(true);
        this.f24413d.m26239a(this, birthdayPersonModel);
        this.f24414e.showAtLocation(this.f24415f, 0, 0, 0);
        this.f24413d.f24383c.a(2, 250);
    }

    public final void m26264a(String str, String str2) {
        long parseLong = Long.parseLong(str);
        Builder builder = new Builder();
        builder.b = parseLong;
        builder.c = str2;
        PublishPostParams a = builder.a();
        Intent intent = new Intent();
        intent.putExtra("publishPostParams", a);
        this.f24418i.startService(ComposerPublishService.a(this.f24418i, intent));
        m26257b(str);
    }

    private void m26259e() {
        if (this.f24419j == null) {
            this.f24419j = new HashMap();
            SortedMap e = this.f24417h.e(f24410a);
            Editor editor = null;
            int f = m26260f();
            for (Entry entry : e.entrySet()) {
                int parseInt = Integer.parseInt(((PrefKey) entry.getKey()).b(f24410a));
                if (f - parseInt > 7) {
                    Editor edit;
                    if (editor == null) {
                        edit = this.f24417h.edit();
                    } else {
                        edit = editor;
                    }
                    edit.a((PrefKey) entry.getKey());
                    editor = edit;
                } else {
                    this.f24419j.put(Integer.valueOf(parseInt), new ArrayList(Splitter.on(",").splitToList((String) entry.getValue())));
                }
            }
        }
    }

    private void m26257b(String str) {
        m26259e();
        int f = m26260f();
        if (!this.f24419j.containsKey(Integer.valueOf(f))) {
            this.f24419j.put(Integer.valueOf(f), new ArrayList());
        }
        List list = (List) this.f24419j.get(Integer.valueOf(f));
        if (!list.contains(str)) {
            list.add(str);
            PrefKey prefKey = (PrefKey) f24410a.a(String.valueOf(f));
            Editor edit = this.f24417h.edit();
            edit.a(prefKey, Joiner.on(",").join(list));
            edit.commit();
        }
    }

    public final boolean m26265a(String str) {
        m26259e();
        for (Entry value : this.f24419j.entrySet()) {
            for (String equals : (List) value.getValue()) {
                if (equals.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int m26260f() {
        Calendar.getInstance();
        return (int) Math.round(((double) (new GregorianCalendar().getTimeInMillis() - new GregorianCalendar(2000, 1, 1).getTimeInMillis())) / 8.64E7d);
    }

    public final void m26263a(CardListener cardListener) {
        this.f24420k.a(cardListener);
    }

    public final boolean m26267c() {
        if (!m26258d()) {
            return false;
        }
        this.f24413d.m26240b();
        return true;
    }
}
