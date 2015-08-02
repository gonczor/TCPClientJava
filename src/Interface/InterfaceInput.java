package Interface;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InterfaceInput {

    private BufferedReader bufferedReader;

    public InterfaceInput(){

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }


    public String getOrder(){


        return "";
    }

}
