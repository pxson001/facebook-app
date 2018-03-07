package rx.exceptions;

/* compiled from: bounds */
public final class OnErrorThrowable extends RuntimeException {
    private final boolean hasValue;
    private final Object value;

    /* compiled from: bounds */
    public class OnNextValue extends RuntimeException {
        public final Object value;

        public OnNextValue(Object obj) {
            super("OnError while emitting onNext value: " + m13876a(obj));
            this.value = obj;
        }

        private static String m13876a(Object obj) {
            if (obj == null) {
                return "null";
            }
            if (obj.getClass().isPrimitive()) {
                return obj.toString();
            }
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj instanceof Enum) {
                return ((Enum) obj).name();
            }
            return obj.getClass().getName() + ".class";
        }
    }

    public static Throwable m13877a(Throwable th, Object obj) {
        Throwable c = Exceptions.m13875c(th);
        if (!(c != null && (c instanceof OnNextValue) && ((OnNextValue) c).value == obj)) {
            Exceptions.m13873a(th, new OnNextValue(obj));
        }
        return th;
    }
}
