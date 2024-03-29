package com.svenjacobs.dagger.inject;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

/**
 * Generic base class for injectable fragments.
 * <p/>
 * {@link #onComponentCreated(Object)} will be called in {@link #onAttach(Activity)}.
 *
 * @see ComponentLifecycle
 */
public abstract class AbstractInjectableFragment<C> extends Fragment
        implements HasComponent<C>, ComponentLifecycle<C> {

    private C mComponent;

    @NonNull
    @Override
    public C getComponent() {
        return mComponent;
    }

    @Override
    public void onAttach(final Activity activity) {
        super.onAttach(activity);

        mComponent = createComponent();

        if (mComponent == null) {
            throw new NullPointerException("Component must not be null");
        }

        onComponentCreated(mComponent);
        onPostComponentCreated();
    }

    @Override
    public void onComponentCreated(@NonNull final C component) {
    }

    @Override
    public void onPostComponentCreated() {
    }

    /**
     * Creates component instance.
     */
    protected abstract C createComponent();
}
