
package com.kotlintut.prathamesh.fragcom;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BlankFragment extends Fragment {

    EditText et;
    Button btn;
    MessageReader mr;

    public BlankFragment() {
    }

    public interface MessageReader
    {
        public void message(String m);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_blank,container,false);
        et=v.findViewById(R.id.ed_frag);
        btn=v.findViewById(R.id.btn_frag);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg=et.getText().toString();
                mr.message(msg);
                Toast.makeText(container.getContext(), "dfdfd", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity a=(Activity) context;
        try{

            mr=(MessageReader) a;
        }catch (ClassCastException e)
        {
            throw new ClassCastException(a.toString()+"this is the error!!!!");
        }
    }
}
