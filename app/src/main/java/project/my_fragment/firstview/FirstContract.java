package project.my_fragment.firstview;

/**
 * Created by jaedeok on 2017-11-08.
 */

public interface FirstContract {

    public interface IView{
        void refresh();
    }

    public interface  IPresenter{
        void loadPhotos(int page);


    }
}
