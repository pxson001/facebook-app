package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompatBase.Action.Factory;
import android.support.v4.app.NotificationCompatJellybean.Builder;
import android.support.v4.app.RemoteInputCompatBase.RemoteInput;
import com.facebook.hiddenmethods.support.v4.NotificationHiddenMethods;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: welcome_note_photo */
public class NotificationCompat {
    public static final NotificationCompatImpl f171a;

    /* compiled from: welcome_note_photo */
    public class Action extends android.support.v4.app.NotificationCompatBase.Action {
        public static final Factory f144d = new C00111();
        public int f145a;
        public CharSequence f146b;
        public PendingIntent f147c;
        private final Bundle f148e;
        private final RemoteInput[] f149f;

        /* compiled from: welcome_note_photo */
        final class C00111 implements Factory {
            C00111() {
            }
        }

        /* compiled from: welcome_note_photo */
        public final class Builder {
            private final int f135a;
            private final CharSequence f136b;
            private final PendingIntent f137c;
            public final Bundle f138d;
            private ArrayList<RemoteInput> f139e;

            public Builder(int i, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i, charSequence, pendingIntent, new Bundle());
            }

            private Builder(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
                this.f135a = i;
                this.f136b = Builder.f(charSequence);
                this.f137c = pendingIntent;
                this.f138d = bundle;
            }

            public final Builder m125a(RemoteInput remoteInput) {
                if (this.f139e == null) {
                    this.f139e = new ArrayList();
                }
                this.f139e.add(remoteInput);
                return this;
            }

            public final Action m126b() {
                return new Action(this.f135a, this.f136b, this.f137c, this.f138d, this.f139e != null ? (RemoteInput[]) this.f139e.toArray(new RemoteInput[this.f139e.size()]) : null);
            }
        }

        /* compiled from: welcome_note_photo */
        public interface Extender {
            Builder mo22a(Builder builder);
        }

        /* compiled from: welcome_note_photo */
        public final class WearableExtender implements Extender {
            public int f140a = 1;
            private CharSequence f141b;
            private CharSequence f142c;
            private CharSequence f143d;

            public final Builder mo22a(Builder builder) {
                Bundle bundle = new Bundle();
                if (this.f140a != 1) {
                    bundle.putInt("flags", this.f140a);
                }
                if (this.f141b != null) {
                    bundle.putCharSequence("inProgressLabel", this.f141b);
                }
                if (this.f142c != null) {
                    bundle.putCharSequence("confirmLabel", this.f142c);
                }
                if (this.f143d != null) {
                    bundle.putCharSequence("cancelLabel", this.f143d);
                }
                builder.f138d.putBundle("android.wearable.EXTENSIONS", bundle);
                return builder;
            }

            public final Object clone() {
                WearableExtender wearableExtender = new WearableExtender();
                wearableExtender.f140a = this.f140a;
                wearableExtender.f141b = this.f141b;
                wearableExtender.f142c = this.f142c;
                wearableExtender.f143d = this.f143d;
                return wearableExtender;
            }

            public final WearableExtender m129a(boolean z) {
                if (z) {
                    this.f140a |= 1;
                } else {
                    this.f140a &= 1 ^ -1;
                }
                return this;
            }
        }

        public Action(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i, charSequence, pendingIntent, new Bundle(), null);
        }

        private Action(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr) {
            this.f145a = i;
            this.f146b = Builder.f(charSequence);
            this.f147c = pendingIntent;
            if (bundle == null) {
                bundle = new Bundle();
            }
            this.f148e = bundle;
            this.f149f = remoteInputArr;
        }

        protected final int mo23a() {
            return this.f145a;
        }

        protected final CharSequence mo24b() {
            return this.f146b;
        }

        protected final PendingIntent mo25c() {
            return this.f147c;
        }

        public final Bundle mo26d() {
            return this.f148e;
        }

        public final RemoteInput[] mo27e() {
            return this.f149f;
        }
    }

    /* compiled from: welcome_note_photo */
    public abstract class Style {
        Builder f150d;
        public CharSequence f151e;
        public CharSequence f152f;
        public boolean f153g = false;

        public final void m140a(Builder builder) {
            if (this.f150d != builder) {
                this.f150d = builder;
                if (this.f150d != null) {
                    this.f150d.a(this);
                }
            }
        }
    }

    /* compiled from: welcome_note_photo */
    public class BigPictureStyle extends Style {
        public Bitmap f154a;
        Bitmap f155b;
        boolean f156c;

        public final BigPictureStyle m142a(CharSequence charSequence) {
            this.f = Builder.f(charSequence);
            this.g = true;
            return this;
        }

        public final BigPictureStyle m141a(Bitmap bitmap) {
            this.f154a = bitmap;
            return this;
        }
    }

    /* compiled from: welcome_note_photo */
    public class BigTextStyle extends Style {
        CharSequence f157a;

        public BigTextStyle(Builder builder) {
            m140a(builder);
        }

        public final BigTextStyle m143a(CharSequence charSequence) {
            this.e = Builder.f(charSequence);
            return this;
        }

        public final BigTextStyle m144b(CharSequence charSequence) {
            this.f157a = Builder.f(charSequence);
            return this;
        }
    }

    /* compiled from: welcome_note_photo */
    public interface Extender {
        Builder mo31a(Builder builder);
    }

    /* compiled from: welcome_note_photo */
    public class InboxStyle extends Style {
        public ArrayList<CharSequence> f158a = new ArrayList();
    }

    /* compiled from: welcome_note_photo */
    public interface NotificationCompatImpl {
        Notification mo28a(Builder builder);

        Bundle mo29a(Notification notification);

        ArrayList<Parcelable> mo30a(Action[] actionArr);
    }

    /* compiled from: welcome_note_photo */
    class NotificationCompatImplBase implements NotificationCompatImpl {
        NotificationCompatImplBase() {
        }

        public Notification mo28a(Builder builder) {
            Notification notification = builder.B;
            NotificationHiddenMethods.m9855a(notification, builder.a, builder.b, builder.c, builder.d);
            if (builder.j > 0) {
                notification.flags |= 128;
            }
            return notification;
        }

        public Bundle mo29a(Notification notification) {
            return null;
        }

        public ArrayList<Parcelable> mo30a(Action[] actionArr) {
            return null;
        }
    }

    /* compiled from: welcome_note_photo */
    class NotificationCompatImplJellybean extends NotificationCompatImplBase {
        public ArrayList<Parcelable> mo30a(Action[] actionArr) {
            ArrayList<Parcelable> arrayList;
            if (actionArr == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(actionArr.length);
                for (android.support.v4.app.NotificationCompatBase.Action action : actionArr) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("icon", action.mo23a());
                    bundle.putCharSequence("title", action.mo24b());
                    bundle.putParcelable("actionIntent", action.mo25c());
                    bundle.putBundle("extras", action.mo26d());
                    bundle.putParcelableArray("remoteInputs", RemoteInputCompatJellybean.m213a(action.mo27e()));
                    arrayList.add(bundle);
                }
            }
            return arrayList;
        }

        NotificationCompatImplJellybean() {
        }

        public Notification mo28a(Builder builder) {
            NotificationBuilderWithBuilderAccessor builder2 = new Builder(builder.a, builder.B, builder.b, builder.c, builder.h, builder.f, builder.i, builder.d, builder.e, builder.g, builder.o, builder.p, builder.q, builder.l, builder.j, builder.n, builder.v, builder.x, builder.r, builder.s, builder.t);
            NotificationCompat.m170b((NotificationBuilderWithActions) builder2, builder.u);
            NotificationCompat.m171b(builder2, builder.m);
            return builder2.m184b();
        }

        public Bundle mo29a(Notification notification) {
            return NotificationCompatJellybean.m186a(notification);
        }
    }

    /* compiled from: welcome_note_photo */
    class NotificationCompatImplKitKat extends NotificationCompatImplJellybean {
        public final Bundle mo29a(Notification notification) {
            return notification.extras;
        }

        NotificationCompatImplKitKat() {
        }

        public Notification mo28a(Builder builder) {
            NotificationBuilderWithBuilderAccessor builder2 = new NotificationCompatKitKat.Builder(builder.a, builder.B, builder.b, builder.c, builder.h, builder.f, builder.i, builder.d, builder.e, builder.g, builder.o, builder.p, builder.q, builder.k, builder.l, builder.j, builder.n, builder.v, builder.C, builder.x, builder.r, builder.s, builder.t);
            NotificationCompat.m170b((NotificationBuilderWithActions) builder2, builder.u);
            NotificationCompat.m171b(builder2, builder.m);
            return builder2.m191b();
        }
    }

    /* compiled from: welcome_note_photo */
    class NotificationCompatImplApi20 extends NotificationCompatImplKitKat {
        public final ArrayList<Parcelable> mo30a(Action[] actionArr) {
            ArrayList<Parcelable> arrayList;
            if (actionArr == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(actionArr.length);
                for (android.support.v4.app.NotificationCompatBase.Action action : actionArr) {
                    android.app.Notification.Action.Builder addExtras = new android.app.Notification.Action.Builder(action.mo23a(), action.mo24b(), action.mo25c()).addExtras(action.mo26d());
                    RemoteInput[] e = action.mo27e();
                    if (e != null) {
                        for (android.app.RemoteInput addRemoteInput : RemoteInputCompatApi20.m212a(e)) {
                            addExtras.addRemoteInput(addRemoteInput);
                        }
                    }
                    arrayList.add(addExtras.build());
                }
            }
            return arrayList;
        }

        NotificationCompatImplApi20() {
        }

        public Notification mo28a(Builder builder) {
            NotificationBuilderWithBuilderAccessor builder2 = new NotificationCompatApi20.Builder(builder.a, builder.B, builder.b, builder.c, builder.h, builder.f, builder.i, builder.d, builder.e, builder.g, builder.o, builder.p, builder.q, builder.k, builder.l, builder.j, builder.n, builder.v, builder.C, builder.x, builder.r, builder.s, builder.t);
            NotificationCompat.m170b((NotificationBuilderWithActions) builder2, builder.u);
            NotificationCompat.m171b(builder2, builder.m);
            return builder2.m174b();
        }
    }

    /* compiled from: welcome_note_photo */
    class NotificationCompatImplApi21 extends NotificationCompatImplApi20 {
        NotificationCompatImplApi21() {
        }

        public final Notification mo28a(Builder builder) {
            NotificationBuilderWithBuilderAccessor builder2 = new NotificationCompatApi21.Builder(builder.a, builder.B, builder.b, builder.c, builder.h, builder.f, builder.i, builder.d, builder.e, builder.g, builder.o, builder.p, builder.q, builder.k, builder.l, builder.j, builder.n, builder.v, builder.w, builder.C, builder.x, builder.y, builder.z, builder.A, builder.r, builder.s, builder.t);
            NotificationCompat.m170b((NotificationBuilderWithActions) builder2, builder.u);
            NotificationCompat.m171b(builder2, builder.m);
            return builder2.m178b();
        }
    }

    /* compiled from: welcome_note_photo */
    class NotificationCompatImplGingerbread extends NotificationCompatImplBase {
        NotificationCompatImplGingerbread() {
        }

        public final Notification mo28a(Builder builder) {
            Notification notification = builder.B;
            NotificationHiddenMethods.m9855a(notification, builder.a, builder.b, builder.c, builder.d);
            notification = NotificationCompatGingerbread.m179a(notification, builder.a, builder.b, builder.c, builder.d, builder.e);
            if (builder.j > 0) {
                notification.flags |= 128;
            }
            return notification;
        }
    }

    /* compiled from: welcome_note_photo */
    class NotificationCompatImplHoneycomb extends NotificationCompatImplBase {
        NotificationCompatImplHoneycomb() {
        }

        public final Notification mo28a(Builder builder) {
            return NotificationCompatHoneycomb.m180a(builder.a, builder.B, builder.b, builder.c, builder.h, builder.f, builder.i, builder.d, builder.e, builder.g);
        }
    }

    /* compiled from: welcome_note_photo */
    class NotificationCompatImplIceCreamSandwich extends NotificationCompatImplBase {
        NotificationCompatImplIceCreamSandwich() {
        }

        public final Notification mo28a(Builder builder) {
            return NotificationCompatIceCreamSandwich.m181a(builder.a, builder.B, builder.b, builder.c, builder.h, builder.f, builder.i, builder.d, builder.e, builder.g, builder.o, builder.p, builder.q);
        }
    }

    /* compiled from: welcome_note_photo */
    public final class WearableExtender implements Extender {
        private ArrayList<Action> f159a = new ArrayList();
        private int f160b = 1;
        private PendingIntent f161c;
        private ArrayList<Notification> f162d = new ArrayList();
        public Bitmap f163e;
        private int f164f;
        private int f165g = 8388613;
        private int f166h = -1;
        private int f167i = 0;
        private int f168j;
        private int f169k = 80;
        private int f170l;

        public final Builder mo31a(Builder builder) {
            Bundle bundle = new Bundle();
            if (!this.f159a.isEmpty()) {
                bundle.putParcelableArrayList("actions", NotificationCompat.f171a.mo30a((Action[]) this.f159a.toArray(new Action[this.f159a.size()])));
            }
            if (this.f160b != 1) {
                bundle.putInt("flags", this.f160b);
            }
            if (this.f161c != null) {
                bundle.putParcelable("displayIntent", this.f161c);
            }
            if (!this.f162d.isEmpty()) {
                bundle.putParcelableArray("pages", (Parcelable[]) this.f162d.toArray(new Notification[this.f162d.size()]));
            }
            if (this.f163e != null) {
                bundle.putParcelable("background", this.f163e);
            }
            if (this.f164f != 0) {
                bundle.putInt("contentIcon", this.f164f);
            }
            if (this.f165g != 8388613) {
                bundle.putInt("contentIconGravity", this.f165g);
            }
            if (this.f166h != -1) {
                bundle.putInt("contentActionIndex", this.f166h);
            }
            if (this.f167i != 0) {
                bundle.putInt("customSizePreset", this.f167i);
            }
            if (this.f168j != 0) {
                bundle.putInt("customContentHeight", this.f168j);
            }
            if (this.f169k != 80) {
                bundle.putInt("gravity", this.f169k);
            }
            if (this.f170l != 0) {
                bundle.putInt("hintScreenTimeout", this.f170l);
            }
            if (builder.x == null) {
                builder.x = new Bundle();
            }
            builder.x.putBundle("android.wearable.EXTENSIONS", bundle);
            return builder;
        }

        public final Object clone() {
            WearableExtender wearableExtender = new WearableExtender();
            wearableExtender.f159a = new ArrayList(this.f159a);
            wearableExtender.f160b = this.f160b;
            wearableExtender.f161c = this.f161c;
            wearableExtender.f162d = new ArrayList(this.f162d);
            wearableExtender.f163e = this.f163e;
            wearableExtender.f164f = this.f164f;
            wearableExtender.f165g = this.f165g;
            wearableExtender.f166h = this.f166h;
            wearableExtender.f167i = this.f167i;
            wearableExtender.f168j = this.f168j;
            wearableExtender.f169k = this.f169k;
            wearableExtender.f170l = this.f170l;
            return wearableExtender;
        }

        public final WearableExtender m166a(Action action) {
            this.f159a.add(action);
            return this;
        }

        public final WearableExtender m165a(Notification notification) {
            this.f162d.add(notification);
            return this;
        }

        public final WearableExtender m167a(boolean z) {
            m163a(8, z);
            return this;
        }

        public final WearableExtender m168b(boolean z) {
            m163a(1, z);
            return this;
        }

        public final WearableExtender m169c(boolean z) {
            m163a(4, z);
            return this;
        }

        private void m163a(int i, boolean z) {
            if (z) {
                this.f160b |= i;
            } else {
                this.f160b &= i ^ -1;
            }
        }
    }

    public static void m170b(NotificationBuilderWithActions notificationBuilderWithActions, ArrayList<Action> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            notificationBuilderWithActions.mo33a((Action) it.next());
        }
    }

    public static void m171b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, Style style) {
        if (style == null) {
            return;
        }
        CharSequence charSequence;
        boolean z;
        CharSequence charSequence2;
        if (style instanceof BigTextStyle) {
            BigTextStyle bigTextStyle = (BigTextStyle) style;
            charSequence = bigTextStyle.f151e;
            z = bigTextStyle.f153g;
            charSequence2 = bigTextStyle.f152f;
            android.app.Notification.BigTextStyle bigText = new android.app.Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.mo32a()).setBigContentTitle(charSequence).bigText(bigTextStyle.f157a);
            if (z) {
                bigText.setSummaryText(charSequence2);
            }
        } else if (style instanceof InboxStyle) {
            InboxStyle inboxStyle = (InboxStyle) style;
            charSequence = inboxStyle.f151e;
            z = inboxStyle.f153g;
            charSequence2 = inboxStyle.f152f;
            ArrayList arrayList = inboxStyle.f158a;
            android.app.Notification.InboxStyle bigContentTitle = new android.app.Notification.InboxStyle(notificationBuilderWithBuilderAccessor.mo32a()).setBigContentTitle(charSequence);
            if (z) {
                bigContentTitle.setSummaryText(charSequence2);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                bigContentTitle.addLine((CharSequence) it.next());
            }
        } else if (style instanceof BigPictureStyle) {
            BigPictureStyle bigPictureStyle = (BigPictureStyle) style;
            NotificationCompatJellybean.m188a(notificationBuilderWithBuilderAccessor, bigPictureStyle.f151e, bigPictureStyle.f153g, bigPictureStyle.f152f, bigPictureStyle.f154a, bigPictureStyle.f155b, bigPictureStyle.f156c);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f171a = new NotificationCompatImplApi21();
        } else if (VERSION.SDK_INT >= 20) {
            f171a = new NotificationCompatImplApi20();
        } else if (VERSION.SDK_INT >= 19) {
            f171a = new NotificationCompatImplKitKat();
        } else if (VERSION.SDK_INT >= 16) {
            f171a = new NotificationCompatImplJellybean();
        } else if (VERSION.SDK_INT >= 14) {
            f171a = new NotificationCompatImplIceCreamSandwich();
        } else if (VERSION.SDK_INT >= 11) {
            f171a = new NotificationCompatImplHoneycomb();
        } else if (VERSION.SDK_INT >= 9) {
            f171a = new NotificationCompatImplGingerbread();
        } else {
            f171a = new NotificationCompatImplBase();
        }
    }
}
