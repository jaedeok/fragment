package project.my_fragment.firstview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import project.my_fragment.R;
import project.my_fragment.firstview.adapter.FirstAdapter;
import project.my_fragment.data.Photo;
import project.my_fragment.firstview.adapter.FirstAdapterView;

/**
 * Created by jaedeok on 2017-11-08.
 */

public class FirstFragment extends Fragment implements FirstContract.IView {

   private RecyclerView mRecyclerView;
   private FirstContract.IPresenter mPresenter;
   private FirstAdapterView mAdapterView;
   private FirstAdapter mAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_first,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView = (RecyclerView)getView().findViewById(R.id.main_recycler);

        mAdapter = new FirstAdapter(getContext());
        mPresenter = new FirstPresenter(this, mAdapter);


        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
        mPresenter.loadPhotos(1);


    }

    @Override
    public void refresh() {
        Log.d("refresh","success");
        mAdapter.refresh();
    }
}
