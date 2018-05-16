package com.priyankaj.doctorsapp;

/**
 * Base View interface to be extended by all Views of the app
 */

public interface BaseView<T> {

    void setPresenter(T presenter);


}
