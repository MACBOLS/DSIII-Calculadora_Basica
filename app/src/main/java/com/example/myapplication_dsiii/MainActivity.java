package com.example.myapplication_dsiii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView Screen;
private Button Ac, Power,Back, Div, Mul, Min, Add, Point, Ans, Equal, Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine;
private String input, Answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Screen=findViewById(R.id.screen);
        Ac=findViewById(R.id.ac);
        Power=findViewById(R.id.power);
        Back=findViewById(R.id.back);
        Div=findViewById(R.id.div);
        Mul=findViewById(R.id.mul);
        Min=findViewById(R.id.min);
        Add=findViewById(R.id.add);
        Point=findViewById(R.id.point);
        Ans=findViewById(R.id.ans);
        Equal=findViewById(R.id.equal);
        Zero=findViewById(R.id.zero);
        One=findViewById(R.id.one);
        Two=findViewById(R.id.two);
        Three=findViewById(R.id.three);
        Four=findViewById(R.id.four);
        Five=findViewById(R.id.five);
        Six=findViewById(R.id.six);
        Seven=findViewById(R.id.seven);
        Eight=findViewById(R.id.eight);
        Nine=findViewById(R.id.nine);

    }
    public void ButtonClick(View view){
        Button button = (Button) view;
        String data=button.getText().toString();
        switch(data){
            case "AC":
                Solve();
                input="";
                break;
            case"Ans":
                Solve();
                input+=Answer;
                break;
            case"x":
                Solve();
                input+="*";
                break;
            case "^":
                Solve();
                input+="^";
                break;
            case"=":
                Solve();
                Answer=input;
                break;
            case "←":
                String newText=input.substring(0, input.length()-1);
                input=newText;
                break;
            default:
                if(input==null){
                    input="";
                }
                if(data.equals("+") || data.equals("-") || data.equals("/")){
                    Solve();
                }
                input+=data;
        }
        Screen.setText(input);
    }
    private void Solve(){
        if(input.split("\\*").length==2){
            String number[]=input.split("\\*");
            try {
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input += mul;
            }
            catch (Exception e){
                //atrapando error

            }
        }

        else if(input.split("/").length==2){
            String number[]=input.split("/");
            try {
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = div + "";
            }
            catch (Exception e){
                //atrapando error

            }
        }

        else if(input.split("\\^").length==2){
            String number[]=input.split("\\^");
            try {
                double pow = Math.pow(Double.parseDouble(number[0]),Double.parseDouble(number[1]));
                input = pow + "";
            }
            catch (Exception e){
                //atrapando error

            }
        }

        else if(input.split("\\+").length==2){
            String number[]=input.split("\\+");
            try {
                double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = sum + "";
            }
            catch (Exception e){
                //atrapando error

            }
        }

        else if(input.split("-").length>1){
            String number[]=input.split("-");
            //resta de numeros negativos
            if(number[0]==""&& number.length==2){
                number[0]=0+"";
            }
            try {
                double sub=0;
                if(number.length==2){
                    sub = Double.parseDouble(number[0]) - Double.parseDouble((number[1]));
                }
                else if (number.length==3){
                    sub = -Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
                }
                input = sub+"";
            }
            catch (Exception e){
                //atrapando error

            }
        }
        //para remover el ultimo numero de los integer, como 9.8
        String n[]=input.split("\\.");
        if(n.length>1){
            if(n[1].equals("0")){
                input=n[0];
            }
        }
        Screen.setText(input);
    }
}