package com.facebook.multiprocess.peer;

import android.os.Bundle;
import android.os.Messenger;
import com.facebook.common.process.ProcessName;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: time_last_media_prompt_dismissed */
public class PeerInfo {
    @Nullable
    public Messenger f2899a;
    public final int f2900b;
    public final ProcessName f2901c;

    protected PeerInfo(@Nullable Messenger messenger, int i, ProcessName processName) {
        Preconditions.checkNotNull(processName);
        this.f2899a = messenger;
        this.f2900b = i;
        this.f2901c = processName;
    }

    public String toString() {
        return Objects.toStringHelper((Object) this).add("messenger: ", this.f2899a).add("pid: ", this.f2900b).add("process name:", this.f2901c).toString();
    }

    public int hashCode() {
        return this.f2900b;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof PeerInfo) && this.f2900b == ((PeerInfo) obj).f2900b) {
            return true;
        }
        return false;
    }

    public static PeerInfo m4894a(Bundle bundle) {
        Messenger messenger = (Messenger) bundle.getParcelable("key_messenger");
        Preconditions.checkNotNull(messenger, "The messenger is not in the bundle passed in");
        int i = bundle.getInt("key_pid", -1);
        if (i == -1) {
            throw new IllegalArgumentException("The pid is not in the bundle passed in");
        }
        String string = bundle.getString("key_process_name");
        Preconditions.checkNotNull(string, "The process name is not in the bundle passed in");
        return new PeerInfo(messenger, i, ProcessName.a(string));
    }

    public final Bundle m4895a() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_messenger", this.f2899a);
        bundle.putInt("key_pid", this.f2900b);
        bundle.putString("key_process_name", this.f2901c.b);
        return bundle;
    }
}
