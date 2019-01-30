package dave.com.fragtofrag;

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

public class Fragment_A extends Fragment {
    FragmentAListner listner;
    private EditText edit_text;
    private Button button;

    public interface FragmentAListner{
        void onInputASent(CharSequence input);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_a,container,false);
        edit_text=(EditText)v.findViewById(R.id.edit_text);
        button=(Button)v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              CharSequence input=edit_text.getText();
              listner.onInputASent(input);
            }
        });
        return v;
    }

    public void UpdateEditText(CharSequence text){
        edit_text.setText(text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentAListner){
            listner=(FragmentAListner)context;
        }
        else{
            throw new RuntimeException(context.toString()
            +"Must Implement FragmentAListner");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listner=null;
    }
}
