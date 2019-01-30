package dave.com.fragtofrag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment_A.FragmentAListner,Fragment_B.FragmentBListner {
private Fragment_A fragment_a;
private Fragment_B fragment_b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment_a=new Fragment_A();
        fragment_b=new Fragment_B();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_a,fragment_a)
                .replace(R.id.container_b,fragment_b)
                .commit();

    }

    @Override
    public void onInputASent(CharSequence input) {
         fragment_b.UpdateEditText(input);
    }

    @Override
    public void onInputBSent(CharSequence input) {
        fragment_a.UpdateEditText(input);

    }
}
