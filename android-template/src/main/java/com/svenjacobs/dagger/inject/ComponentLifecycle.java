package com.svenjacobs.dagger.inject;

import android.support.annotation.NonNull;

/**
 * Interface for classes that create a Dagger component.
 */
public interface ComponentLifecycle<C> {

    /**
     * Is called after the component has been created.
     * <p/>
     * Must be implemented to call the injection on the object, e.g. {@code
     * component.inject(this)}.
     * <p/>
     * Configuration of injected objects should take place in {@link #onPostComponentCreated()}
     *
     * @see #onPostComponentCreated()
     */
    void onComponentCreated(@NonNull final C component);

    /**
     * Will be called after {@link #onComponentCreated(Object)}.
     * <p/>
     * This method shall be overridden/implemented when dependencies need to be configured after
     * injection took place. This is especially useful for (abstract) base classes where the actual
     * injection doesn't take place.
     *
     * @see #onComponentCreated(Object)
     */
    void onPostComponentCreated();
}
