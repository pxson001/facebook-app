package com.facebook.attribution;

import android.content.Context;
import com.google.common.io.Closeables;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;

/* compiled from: marketplace_search */
public class AttributionStateSerializer {
    public static AttributionState m21435a(Context context) {
        Throwable th;
        Reader reader = null;
        try {
            Reader bufferedReader = new BufferedReader(new FileReader(new File(context.getFilesDir(), "attribution_state.txt")));
            try {
                AttributionState attributionState = new AttributionState(bufferedReader.readLine(), Long.parseLong(bufferedReader.readLine()), Long.parseLong(bufferedReader.readLine()), Boolean.parseBoolean(bufferedReader.readLine()), bufferedReader.readLine(), null);
                Closeables.m21583a(bufferedReader);
                return attributionState;
            } catch (Throwable th2) {
                th = th2;
                reader = bufferedReader;
                Closeables.m21583a(reader);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            Closeables.m21583a(reader);
            throw th;
        }
    }

    public static void m21436a(Context context, AttributionState attributionState) {
        Closeable bufferedWriter;
        Throwable th;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(new File(context.getFilesDir(), "attribution_state.txt")));
            try {
                bufferedWriter.write(attributionState.f14987a);
                bufferedWriter.newLine();
                bufferedWriter.write(Long.toString(attributionState.f14988b));
                bufferedWriter.newLine();
                bufferedWriter.write(Long.toString(attributionState.f14989c));
                bufferedWriter.newLine();
                bufferedWriter.write(Boolean.toString(attributionState.f14990d));
                bufferedWriter.newLine();
                bufferedWriter.write(attributionState.f14991e);
                Closeables.m21581a(bufferedWriter, false);
            } catch (Throwable th2) {
                th = th2;
                Closeables.m21581a(bufferedWriter, true);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter = null;
            Closeables.m21581a(bufferedWriter, true);
            throw th;
        }
    }
}
