package com.facebook.common.errorreporting.memory;

import com.facebook.feed.fragment.FeedFragmentClassInstancesToLog;
import com.facebook.feed.util.FeedClassInstancesToLog;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.katana.util.FbFragmentClassInstancesToLog;
import com.facebook.orca.threadlist.ThreadListClassInstancesToLog;
import com.facebook.orca.threadview.ThreadViewClassInstancesToLog;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.timeline.TimelineClassInstancesToLog;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$ClassInstancesToLog implements MultiBindIndexedProvider<ClassInstancesToLog>, Provider<Set<ClassInstancesToLog>> {
    private final InjectorLike f2236a;

    public STATICDI_MULTIBIND_PROVIDER$ClassInstancesToLog(InjectorLike injectorLike) {
        this.f2236a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f2236a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 7;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new AndroidClassInstancesToLog();
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return new FeedFragmentClassInstancesToLog();
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return new FeedClassInstancesToLog();
            case 3:
                return new FbFragmentClassInstancesToLog();
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return new ThreadListClassInstancesToLog();
            case 5:
                return new ThreadViewClassInstancesToLog();
            case 6:
                return new TimelineClassInstancesToLog();
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
