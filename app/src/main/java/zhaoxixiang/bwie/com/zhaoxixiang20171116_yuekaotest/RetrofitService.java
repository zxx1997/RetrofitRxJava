package zhaoxixiang.bwie.com.zhaoxixiang20171116_yuekaotest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by admin on 2017/11/21/021.
 */

public interface RetrofitService {
    @GET("columns/getVideoList.do")
    Observable<Bean> getSearch(@Query("catalogId") String id);
}
