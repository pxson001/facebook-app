package rx.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* compiled from: br_rs */
public final class CompositeException extends RuntimeException {
    private Throwable cause;
    public final List<Throwable> exceptions;
    private final String message;

    /* compiled from: br_rs */
    final class CompositeExceptionCausalChain extends RuntimeException {
        static String f7697a = "Chain of Causes for CompositeException In Order Received =>";

        CompositeExceptionCausalChain() {
        }

        public final String getMessage() {
            return f7697a;
        }
    }

    /* compiled from: br_rs */
    abstract class PrintStreamOrWriter {
        abstract Object mo1021a();

        abstract void mo1022a(Object obj);
    }

    /* compiled from: br_rs */
    class WrappedPrintStream extends PrintStreamOrWriter {
        private final PrintStream f7698a;

        WrappedPrintStream(PrintStream printStream) {
            this.f7698a = printStream;
        }

        final Object mo1021a() {
            return this.f7698a;
        }

        final void mo1022a(Object obj) {
            this.f7698a.println(obj);
        }
    }

    /* compiled from: br_rs */
    class WrappedPrintWriter extends PrintStreamOrWriter {
        private final PrintWriter f7699a;

        WrappedPrintWriter(PrintWriter printWriter) {
            this.f7699a = printWriter;
        }

        final Object mo1021a() {
            return this.f7699a;
        }

        final void mo1022a(Object obj) {
            this.f7699a.println(obj);
        }
    }

    public CompositeException(Collection<? extends Throwable> collection) {
        this.cause = null;
        Collection linkedHashSet = new LinkedHashSet();
        List arrayList = new ArrayList();
        for (Throwable th : collection) {
            if (th instanceof CompositeException) {
                linkedHashSet.addAll(((CompositeException) th).exceptions);
            } else {
                linkedHashSet.add(th);
            }
        }
        arrayList.addAll(linkedHashSet);
        this.exceptions = Collections.unmodifiableList(arrayList);
        this.message = this.exceptions.size() + " exceptions occurred. ";
    }

    public CompositeException(Collection<? extends Throwable> collection, byte b) {
        this(collection);
    }

    public final String getMessage() {
        return this.message;
    }

    public final synchronized Throwable getCause() {
        if (this.cause == null) {
            Throwable compositeExceptionCausalChain = new CompositeExceptionCausalChain();
            Set hashSet = new HashSet();
            Throwable th = compositeExceptionCausalChain;
            for (Throwable th2 : this.exceptions) {
                if (!hashSet.contains(th2)) {
                    hashSet.add(th2);
                    Throwable th3 = th2;
                    for (Throwable th22 : m13869a(th22)) {
                        if (hashSet.contains(th22)) {
                            th3 = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        } else {
                            hashSet.add(th22);
                        }
                    }
                    try {
                        th.initCause(th3);
                    } catch (Throwable th4) {
                    }
                    th = th.getCause();
                }
            }
            this.cause = compositeExceptionCausalChain;
        }
        return this.cause;
    }

    public final void printStackTrace() {
        printStackTrace(System.err);
    }

    public final void printStackTrace(PrintStream printStream) {
        m13871a(new WrappedPrintStream(printStream));
    }

    public final void printStackTrace(PrintWriter printWriter) {
        m13871a(new WrappedPrintWriter(printWriter));
    }

    private void m13871a(PrintStreamOrWriter printStreamOrWriter) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this).append("\n");
        for (Object append : getStackTrace()) {
            stringBuilder.append("\tat ").append(append).append("\n");
        }
        int i = 1;
        for (Throwable th : this.exceptions) {
            stringBuilder.append("  ComposedException ").append(i).append(" :\n");
            m13870a(stringBuilder, th, "\t");
            i++;
        }
        synchronized (printStreamOrWriter.mo1021a()) {
            printStreamOrWriter.mo1022a(stringBuilder.toString());
        }
    }

    private void m13870a(StringBuilder stringBuilder, Throwable th, String str) {
        stringBuilder.append(str).append(th).append("\n");
        for (Object append : th.getStackTrace()) {
            stringBuilder.append("\t\tat ").append(append).append("\n");
        }
        if (th.getCause() != null) {
            stringBuilder.append("\tCaused by: ");
            m13870a(stringBuilder, th.getCause(), "");
        }
    }

    private static List<Throwable> m13869a(Throwable th) {
        List<Throwable> arrayList = new ArrayList();
        Throwable cause = th.getCause();
        if (cause == null) {
            return arrayList;
        }
        while (true) {
            arrayList.add(cause);
            if (cause.getCause() == null) {
                return arrayList;
            }
            cause = cause.getCause();
        }
    }
}
