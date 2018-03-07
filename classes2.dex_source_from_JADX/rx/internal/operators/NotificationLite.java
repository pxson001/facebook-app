package rx.internal.operators;

import java.io.Serializable;
import rx.Observer;

/* compiled from: rs */
public final class NotificationLite<T> {
    public static final NotificationLite f6497a = new NotificationLite();
    public static final Object f6498b = new C02911();
    private static final Object f6499c = new C02922();

    /* compiled from: rs */
    final class C02911 implements Serializable {
        C02911() {
        }

        public final String toString() {
            return "Notification=>Completed";
        }
    }

    /* compiled from: rs */
    final class C02922 implements Serializable {
        C02922() {
        }

        public final String toString() {
            return "Notification=>NULL";
        }
    }

    /* compiled from: rs */
    public class OnErrorSentinel implements Serializable {
        public final Throwable f15582e;

        public OnErrorSentinel(Throwable th) {
            this.f15582e = th;
        }

        public String toString() {
            return "Notification=>Error:" + this.f15582e;
        }
    }

    private NotificationLite() {
    }

    public static <T> NotificationLite<T> m11270a() {
        return f6497a;
    }

    public static Object m11268a(T t) {
        if (t == null) {
            return f6499c;
        }
        return t;
    }

    public static Object m11269a(Throwable th) {
        return new OnErrorSentinel(th);
    }

    public static boolean m11271a(Observer<? super T> observer, Object obj) {
        if (obj == f6498b) {
            observer.N_();
            return true;
        } else if (obj == f6499c) {
            observer.mo1598a(null);
            return false;
        } else if (obj == null) {
            throw new IllegalArgumentException("The lite notification can not be null");
        } else if (obj.getClass() == OnErrorSentinel.class) {
            observer.mo1599a(((OnErrorSentinel) obj).f15582e);
            return true;
        } else {
            observer.mo1598a(obj);
            return false;
        }
    }

    public static boolean m11272b(Object obj) {
        return obj == f6498b;
    }

    public static T m11273d(Object obj) {
        return obj == f6499c ? null : obj;
    }
}
