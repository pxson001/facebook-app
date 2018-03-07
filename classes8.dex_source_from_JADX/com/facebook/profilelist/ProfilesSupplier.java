package com.facebook.profilelist;

import com.facebook.ipc.model.FacebookProfile;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* compiled from: render_time */
public interface ProfilesSupplier {
    ListenableFuture<List<FacebookProfile>> mo213a(Optional<String> optional);

    boolean mo214a();
}
