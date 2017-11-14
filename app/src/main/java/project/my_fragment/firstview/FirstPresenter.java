package project.my_fragment.firstview;

import android.util.Log;
import android.view.View;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import project.my_fragment.data.Photo;
import project.my_fragment.data.Photos;
import project.my_fragment.data.RecentPhoto;
import project.my_fragment.firstview.adapter.FirstAdapter;
import project.my_fragment.firstview.adapter.FirstDataModel;
import project.my_fragment.network.NetworkClient;
import project.my_fragment.network.NetworkService;
import retrofit2.Retrofit;

import java.util.List;

/**
 * Created by jaedeok on 2017-11-08.
 */

public class FirstPresenter implements FirstContract.IPresenter {

    private FirstContract.IView mView;
    private NetworkClient mNetworkClient;
    private Retrofit mRetrofit;
    private FirstDataModel mFirstDataModel;
    private FirstAdapter mAdapter;


    public FirstPresenter(FirstContract.IView view, FirstAdapter adapter) {
        this.mView = view;
        this.mAdapter = adapter;

    }

    @Override
    public void loadPhotos(int page) {
        Log.d("loadPhotos","success");

        mNetworkClient = new NetworkClient();
        mRetrofit = mNetworkClient.getRetrofit();
        mRetrofit.create(NetworkService.class).getInterestingness(1)
                .subscribeOn(Schedulers.io())
                .map(RecentPhoto::getPhotos)
                .filter(photos -> photos.getPhoto() !=null && !photos.getPhoto().isEmpty())
                .flatMap(photos -> Observable.fromIterable(photos.getPhoto()))
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(this::getData, this::getError, mView::refresh);

    }


    private void getData(Photo photo) {
        mAdapter.add(photo);

    }

    private void getError(Throwable throwable) {
        Log.d("instauser3", throwable+"");
    }


}
