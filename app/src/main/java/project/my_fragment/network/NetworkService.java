package project.my_fragment.network;

import io.reactivex.Observable;
import project.my_fragment.data.RecentPhoto;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jaedeok on 2017-11-14.
 */

public interface NetworkService  {

    @GET("?format=json&nojsoncallback=1&method=flickr.interestingness.getList&api_key=" + "flickr_api_key")//flickr 가입하고 api키 받아야함
    Observable<RecentPhoto> getInterestingness(@Query("page") int page);

}
