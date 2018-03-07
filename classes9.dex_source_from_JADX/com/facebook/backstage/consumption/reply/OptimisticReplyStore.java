package com.facebook.backstage.consumption.reply;

import com.facebook.backstage.data.BackstageProfile.Reply;
import com.facebook.backstage.data.ReplyThreadSummary;
import com.facebook.backstage.data.UploadShot;
import com.facebook.backstage.util.EmojiReplyUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: ride_estimate_information */
public class OptimisticReplyStore {
    private static final String f4942a = OptimisticReplyStore.class.getSimpleName();
    public final HashMap<String, HashSet<String>> f4943b = new HashMap();
    public final HashMap<String, ReplyPair> f4944c = new HashMap();
    private final Object f4945d = new Object();

    /* compiled from: ride_estimate_information */
    public class ReplyPair {
        public UploadShot f4940a;
        public String f4941b;

        public ReplyPair(UploadShot uploadShot, String str) {
            this.f4940a = uploadShot;
            this.f4941b = str;
        }
    }

    public final void m4794a(String str, String str2, UploadShot uploadShot) {
        synchronized (this.f4945d) {
            if (!this.f4943b.containsKey(str)) {
                this.f4943b.put(str, new HashSet());
            }
            ((HashSet) this.f4943b.get(str)).add(str2);
            this.f4944c.put(str2, new ReplyPair(uploadShot, str));
        }
    }

    public final void m4793a(String str, String str2) {
        synchronized (this.f4945d) {
            ReplyPair replyPair = (ReplyPair) this.f4944c.get(str);
            ((HashSet) this.f4943b.get(replyPair.f4941b)).remove(str);
            this.f4944c.remove(str);
            ((HashSet) this.f4943b.get(replyPair.f4941b)).add(str2);
            this.f4944c.put(str2, replyPair);
        }
    }

    public final boolean m4795a(String str) {
        boolean containsKey;
        synchronized (this.f4945d) {
            containsKey = this.f4944c.containsKey(str);
        }
        return containsKey;
    }

    public final void m4796b(String str) {
        synchronized (this.f4945d) {
            ReplyPair replyPair = (ReplyPair) this.f4944c.get(str);
            this.f4944c.remove(str);
            ((HashSet) this.f4943b.get(replyPair.f4941b)).remove(str);
            if (((HashSet) this.f4943b.get(replyPair.f4941b)).isEmpty()) {
                this.f4943b.remove(replyPair.f4941b);
            }
        }
    }

    public final ImmutableList<Reply> m4797c(String str) {
        Builder builder = new Builder();
        synchronized (this.f4945d) {
            if (this.f4943b.get(str) == null) {
                ImmutableList<Reply> b = builder.b();
                return b;
            }
            Iterator it = ((HashSet) this.f4943b.get(str)).iterator();
            while (it.hasNext()) {
                builder.c(m4792a(((ReplyPair) this.f4944c.get((String) it.next())).f4940a));
            }
            return builder.b();
        }
    }

    public final ReplyThreadSummary m4798d(String str) {
        UploadShot uploadShot = null;
        Date date = new Date(0);
        if (this.f4943b.containsKey(str)) {
            Iterator it = ((HashSet) this.f4943b.get(str)).iterator();
            while (it.hasNext()) {
                Date date2;
                UploadShot uploadShot2;
                ReplyPair replyPair = (ReplyPair) this.f4944c.get((String) it.next());
                if (replyPair.f4940a.f5151g.after(date)) {
                    date2 = replyPair.f4940a.f5151g;
                    uploadShot2 = replyPair.f4940a;
                } else {
                    uploadShot2 = uploadShot;
                    date2 = date;
                }
                date = date2;
                uploadShot = uploadShot2;
            }
            uploadShot = m4792a(uploadShot);
        }
        UploadShot uploadShot3 = uploadShot;
        if (uploadShot3 == null) {
            return null;
        }
        return new ReplyThreadSummary(str, "", uploadShot3.mo171f(), uploadShot3.m4712j(), null, EmojiReplyUtil.m5771a(uploadShot3.mo173h()) ? uploadShot3.mo173h() : null);
    }

    public final void m4799e(String str) {
        synchronized (this.f4945d) {
            Iterator it = ((HashSet) this.f4943b.get(str)).iterator();
            while (it.hasNext()) {
                this.f4944c.remove((String) it.next());
            }
            this.f4943b.remove(str);
        }
    }

    public static Reply m4792a(UploadShot uploadShot) {
        return new Reply(uploadShot.f5146b, uploadShot.mo171f(), uploadShot.mo174i(), uploadShot.mo173h(), null, uploadShot.f5151g, 1.0f);
    }
}
