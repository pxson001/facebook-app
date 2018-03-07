package com.facebook.common.errorreporting;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map.Entry;

/* compiled from: status_type */
public class StackTraceDumper {
    private StackTraceDumper() {
    }

    public static void m3647a(OutputStream outputStream) {
        PrintWriter printWriter = new PrintWriter(outputStream);
        for (Entry entry : Thread.getAllStackTraces().entrySet()) {
            printWriter.print(entry.getKey());
            printWriter.print(" ");
            printWriter.print(((Thread) entry.getKey()).getState());
            printWriter.println(":");
            for (Object println : (StackTraceElement[]) entry.getValue()) {
                printWriter.println(println);
            }
            printWriter.println();
        }
        printWriter.flush();
    }
}
