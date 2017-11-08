package project.my_fragment.seccondview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import project.my_fragment.R;
/**
 * Created by jaedeok on 2017-11-08.
 */

public class SeccondFragment extends Fragment implements SeccondContract.IView {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_seccond,container,false);
    }
}
