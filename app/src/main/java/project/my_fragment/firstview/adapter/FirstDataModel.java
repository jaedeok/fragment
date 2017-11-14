package project.my_fragment.firstview.adapter;

import java.util.List;

import project.my_fragment.data.Photo;
import project.my_fragment.data.Photos;
import project.my_fragment.data.RecentPhoto;

/**
 * Created by jaedeok on 2017-11-12.
 */

public interface FirstDataModel {
    void add(Photo photo);
    Photo remove(int position);
    Photo getPhoto(int position);
    int getSize();


}
