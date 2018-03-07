package com.facebook.growth.contactimporter;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.facebook.common.executors.FbAsyncTask;
import com.facebook.common.locale.Locales;
import com.facebook.growth.logging.FriendFinderAnalyticsLogger;
import com.facebook.growth.logging.FriendFinderAnalyticsLogger.ApiType;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.facebook.ipc.model.FacebookPhonebookContact;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.SectionedListAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableScheduledFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* compiled from: paymentTransactionQueryType */
public abstract class BaseInvitesAdapter extends SectionedListAdapter {
    protected List<? extends FacebookPhonebookContact> f7087c;
    protected List<FirstLetterFriendSection> f7088d = new ArrayList();
    protected final Context f7089e;
    public final CIFlow f7090f;
    protected final SendInviteClient f7091g;
    protected final SendInviteLogger f7092h;
    public final FriendFinderAnalyticsLogger f7093i;
    protected final Map<Long, FacebookPhonebookContact> f7094j;
    protected final long f7095k;
    protected final LayoutInflater f7096l;
    public final Set<Long> f7097m = new HashSet();
    public final Hashtable<Long, ListenableFuture<?>> f7098n = new Hashtable();
    protected boolean f7099o;
    protected FbAsyncTask<List<? extends FacebookPhonebookContact>, Void, List<? extends FacebookPhonebookContact>> f7100p;
    public ListeningScheduledExecutorService f7101q;
    public Locales f7102r;

    /* compiled from: paymentTransactionQueryType */
    public class FirstLetterFriendSection {
        protected final String f7082a;
        public final int f7083b;
        public final int f7084c;

        public FirstLetterFriendSection(String str, int i, int i2) {
            this.f7082a = str;
            this.f7083b = i;
            this.f7084c = i2;
        }

        public String toString() {
            return this.f7082a;
        }
    }

    /* compiled from: paymentTransactionQueryType */
    public class SortAndRefreshTask extends FbAsyncTask<List<? extends FacebookPhonebookContact>, Void, List<? extends FacebookPhonebookContact>> {
        public final /* synthetic */ BaseInvitesAdapter f7086a;

        /* compiled from: paymentTransactionQueryType */
        class C07501 implements Comparator<FacebookPhonebookContact> {
            final /* synthetic */ SortAndRefreshTask f7085a;

            C07501(SortAndRefreshTask sortAndRefreshTask) {
                this.f7085a = sortAndRefreshTask;
            }

            public int compare(Object obj, Object obj2) {
                return ((FacebookPhonebookContact) obj).name.toLowerCase(this.f7085a.f7086a.f7102r.a()).compareTo(((FacebookPhonebookContact) obj2).name.toLowerCase(this.f7085a.f7086a.f7102r.a()));
            }
        }

        public SortAndRefreshTask(BaseInvitesAdapter baseInvitesAdapter) {
            this.f7086a = baseInvitesAdapter;
        }

        protected final Object m7359a(Object[] objArr) {
            List[] listArr = (List[]) objArr;
            Comparator c07501 = new C07501(this);
            List arrayList = new ArrayList(listArr[0]);
            Collections.sort(arrayList, c07501);
            return arrayList;
        }

        protected void onPostExecute(Object obj) {
            List list;
            List<FacebookPhonebookContact> list2 = (List) obj;
            List arrayList = new ArrayList();
            if (list2.isEmpty()) {
                list = arrayList;
            } else {
                int i = 0;
                int i2 = -1;
                String str = "";
                int i3 = -1;
                for (FacebookPhonebookContact facebookPhonebookContact : list2) {
                    i3++;
                    String toUpperCase = facebookPhonebookContact.name.substring(0, 1).toUpperCase(this.f7086a.f7102r.a());
                    if (str.equals(toUpperCase)) {
                        i++;
                    } else {
                        if (i2 >= 0) {
                            arrayList.add(new FirstLetterFriendSection(str, i2, i));
                        }
                        i = 1;
                        i2 = i3;
                        str = toUpperCase;
                    }
                }
                arrayList.add(new FirstLetterFriendSection(str, i2, i));
                list = arrayList;
            }
            List list3 = list;
            this.f7086a.f7087c = new ArrayList(list2);
            this.f7086a.f7088d = list3;
            this.f7086a.f7097m.clear();
            AdapterDetour.a(this.f7086a, 73734554);
        }
    }

    protected abstract long mo276a(FacebookPhonebookContact facebookPhonebookContact);

    protected abstract void mo279a(View view);

    protected abstract String mo280d();

    protected abstract String mo281h();

    protected BaseInvitesAdapter(Context context, CIFlow cIFlow, SendInviteClient sendInviteClient, SendInviteLogger sendInviteLogger, FriendFinderAnalyticsLogger friendFinderAnalyticsLogger, Map<Long, FacebookPhonebookContact> map, long j, ListeningScheduledExecutorService listeningScheduledExecutorService, Locales locales) {
        this.f7089e = context;
        this.f7090f = cIFlow;
        this.f7091g = sendInviteClient;
        this.f7092h = sendInviteLogger;
        this.f7093i = friendFinderAnalyticsLogger;
        this.f7094j = map;
        this.f7095k = j;
        this.f7096l = LayoutInflater.from(context);
        this.f7087c = new ArrayList(map.values());
        this.f7099o = true;
        this.f7101q = listeningScheduledExecutorService;
        this.f7102r = locales;
        m7378e();
    }

    public int getViewTypeCount() {
        return 2;
    }

    public int m7362a(int i) {
        return 0;
    }

    public int m7375c(int i, int i2) {
        return 1;
    }

    public Object m7366a(int i, int i2) {
        return this.f7087c.get(m7376d(i, i2));
    }

    public int m7373c() {
        return this.f7088d.size();
    }

    public int m7374c(int i) {
        return ((FirstLetterFriendSection) this.f7088d.get(i)).f7084c;
    }

    public Object m7369b(int i) {
        return this.f7088d.get(i);
    }

    public View mo278a(int i, View view, ViewGroup viewGroup) {
        View inflate;
        if (view == null) {
            inflate = this.f7096l.inflate(2130904588, viewGroup, false);
        } else {
            inflate = view;
        }
        ((TextView) inflate).setText(((FirstLetterFriendSection) this.f7088d.get(i)).toString());
        return inflate;
    }

    public View mo277a(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        FacebookPhonebookContact facebookPhonebookContact = (FacebookPhonebookContact) m7366a(i, i2);
        if (view == null) {
            view = this.f7096l.inflate(2130906426, viewGroup, false);
        }
        mo279a(view);
        final int d = m7376d(i, i2);
        ((TextView) view.findViewById(2131566124)).setText(m7361a(facebookPhonebookContact.name));
        TextView textView = (TextView) view.findViewById(2131566334);
        textView.setText(m7360a(facebookPhonebookContact, d, view), BufferType.SPANNABLE);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        Button button = (Button) view.findViewById(2131566335);
        button.setText(mo280d());
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BaseInvitesAdapter f7076c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1595862367);
                this.f7076c.m7370b(d, view);
                Logger.a(2, EntryType.UI_INPUT_END, -545436473, a);
            }
        });
        if (!this.f7099o) {
            button.setVisibility(0);
        } else if (this.f7097m.contains(Long.valueOf(mo276a(facebookPhonebookContact)))) {
            button.setVisibility(8);
        } else {
            button.setVisibility(0);
        }
        button.setEnabled(this.f7099o);
        return view;
    }

    public boolean m7372b(int i, int i2) {
        return true;
    }

    public boolean m7371b() {
        return this.f7087c.isEmpty();
    }

    private static String m7361a(String str) {
        int indexOf = str.indexOf(64);
        if (indexOf > 0) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    public void m7378e() {
        this.f7100p = new SortAndRefreshTask(this);
        this.f7100p.a(this.f7089e, new List[]{this.f7087c});
    }

    public void m7367a(int i, View view) {
        FacebookPhonebookContact facebookPhonebookContact = (FacebookPhonebookContact) this.f7087c.get(i);
        long a = mo276a(facebookPhonebookContact);
        if (this.f7097m.contains(Long.valueOf(a))) {
            this.f7097m.remove(Long.valueOf(a));
            if (this.f7098n.containsKey(Long.valueOf(a))) {
                ListenableFuture listenableFuture = (ListenableFuture) this.f7098n.get(Long.valueOf(a));
                if (listenableFuture != null) {
                    listenableFuture.cancel(true);
                }
                this.f7098n.remove(Long.valueOf(a));
            }
            ((TextView) view.findViewById(2131566334)).setText(m7360a(facebookPhonebookContact, i, view));
            view.findViewById(2131566335).setVisibility(0);
            this.f7093i.b(this.f7090f.value, ApiType.FRIEND_FINDER_API);
        }
    }

    public void m7370b(int i, View view) {
        FacebookPhonebookContact facebookPhonebookContact = (FacebookPhonebookContact) this.f7087c.get(i);
        final long a = mo276a(facebookPhonebookContact);
        this.f7097m.add(Long.valueOf(a));
        ListenableScheduledFuture a2 = this.f7101q.a(new Runnable(this) {
            final /* synthetic */ BaseInvitesAdapter f7078b;

            public void run() {
                if (this.f7078b.f7098n.containsKey(Long.valueOf(a))) {
                    this.f7078b.f7098n.remove(Long.valueOf(a));
                }
                AdapterDetour.a(this.f7078b, -645340381);
                if (this.f7078b.f7097m.contains(Long.valueOf(a))) {
                    List arrayList = new ArrayList(1);
                    arrayList.add(((FacebookPhonebookContact) this.f7078b.f7094j.get(Long.valueOf(a))).a());
                    this.f7078b.f7091g.m7394a(arrayList, false, false, StepInviteActivity.f7118p);
                    this.f7078b.f7092h.m7397a(1, this.f7078b.f7087c.size(), "invite_button", this.f7078b.f7095k);
                }
            }
        }, 4, TimeUnit.SECONDS);
        this.f7093i.a(this.f7090f.value, ApiType.FRIEND_FINDER_API);
        this.f7098n.put(Long.valueOf(a), a2);
        ((TextView) view.findViewById(2131566334)).setText(m7360a(facebookPhonebookContact, i, view));
        view.findViewById(2131566335).setVisibility(8);
    }

    private Spanned m7360a(FacebookPhonebookContact facebookPhonebookContact, final int i, final View view) {
        String a = facebookPhonebookContact.a();
        if (!this.f7097m.contains(Long.valueOf(mo276a(facebookPhonebookContact)))) {
            return new SpannableString(a);
        }
        Spanned spannableString = new SpannableString(mo281h() + " ");
        Spannable spannableString2 = new SpannableString(this.f7089e.getString(2131230753));
        spannableString2.setSpan(new ClickableSpan(this) {
            final /* synthetic */ BaseInvitesAdapter f7081c;

            public void onClick(View view) {
                this.f7081c.m7367a(i, view);
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
                textPaint.setColor(this.f7081c.f7089e.getResources().getColor(2131361916));
            }
        }, 0, spannableString2.length(), 33);
        if (this.f7098n.containsKey(Long.valueOf(mo276a(facebookPhonebookContact)))) {
            return spannableString2;
        }
        return spannableString;
    }

    public int m7376d(int i, int i2) {
        return ((FirstLetterFriendSection) m7369b(i)).f7083b + i2;
    }
}
