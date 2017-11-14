package project.my_fragment.firstview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import project.my_fragment.R;
import project.my_fragment.data.Photo;


/**
 * Created by jaedeok on 2017-11-12.
 */

public class FirstAdapter extends RecyclerView.Adapter<FirstAdapter.FirstViewHolder> implements FirstAdapterView, FirstDataModel {

    private Context mContext;
    private List<Photo> mPhotoList;

    public FirstAdapter(Context context) {
        mContext = context;
        mPhotoList = new ArrayList<>();
        Log.d("aa","bb");

    }

    @Override
    public FirstViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("aa1","bb");
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_recycler, parent, false);
        return new FirstViewHolder(itemView);
    }


    @Override
    public int getItemCount() {
        Log.d("aa4",getSize()+"");
        return getSize();
    }

    @Override
    public void onBindViewHolder(FirstViewHolder holder, int position) {
        Log.d("aa2",position+"");
        Photo photo = getPhoto(position);
        String farmId = String.valueOf(photo.getFarm());
        String serverId = photo.getServer();
        String id = photo.getId();
        String secret = photo.getSecret();

        Glide.with(mContext)
                .load(String.format("https://farm%s.staticflickr.com/%s/%s_%s.jpg", farmId, serverId, id, secret))
                .into(holder.imageView);
        holder.textView.setText(photo.getTitle());
    }



    @Override
    public void refresh() {
        notifyDataSetChanged();
    }

    @Override
    public void add(Photo photo) {
        mPhotoList.add(photo);
        Log.d("getsize",""+getSize());
    }

    @Override
    public Photo remove(int position) {
        return null;
    }

    @Override
    public Photo getPhoto(int position) {
        return mPhotoList.get(position);
    }

    @Override
    public int getSize() {
        return mPhotoList.size();
    }

    class FirstViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;
        public FirstViewHolder(View itemView) {
            super(itemView);
             textView = (TextView)itemView.findViewById(R.id.text);
             imageView = (ImageView)itemView.findViewById(R.id.imageView);

        }
    }

}
