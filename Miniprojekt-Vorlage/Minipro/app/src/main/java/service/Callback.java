package service;

/**
 * Created by ben_d on 16.10.2017.
 */

public interface Callback<T> {
    void onCompletion(T input);
    void onError(String message);
}
