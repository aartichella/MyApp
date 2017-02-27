package com.example.aartichella.myapp;

import android.app.Activity;
import android.os.Bundle;

import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Button;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

    //global variables
    static int [][] myArr= new int [12][12];
    GridView gridView;
    Button button1;
    Button button2;
    int size=12;

    //main function
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (int h = 0; h < 12; h++) {
            for (int w = 0; w < 12; w++) {
                myArr[h][w] = 0;
            }
        }
        loadCleanActivity();
    }
    public void loadCleanActivity(){
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView1);
        gridView.setAdapter(new GridtAdapter(this, myArr));
        //new grid for new state
        for (int h = 0; h < 12; h++) {
            for (int w = 0; w < 12; w++) {
                if(myArr[h][w]==0)
                {}
                else if (myArr[h][w]==1)
                    ;
            }
        }

        //toggle
        gridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String t = String.valueOf(position);

                int row = position / 12;
                int col = position % 12;

                if (myArr[row][col] == 0) {
                    ImageView imageView = (ImageView) v.findViewById(R.id.grid_item_image);
                    imageView.setImageResource(R.drawable.red);
                    myArr[row][col] = 1;
                }
                else if (myArr[row][col] == 1){
                    ImageView imageView = (ImageView) v.findViewById(R.id.grid_item_image);
                    imageView.setImageResource(R.drawable.ash);
                    myArr[row][col] = 0;
                }
            }
        });
    }

    //onclick RESET function
    public void onClickBtn(View v){
        for (int h = 0; h < 12; h++) {
            for (int w = 0; w < 12; w++) {
                myArr[h][w] = 0;
            }
        }
        loadCleanActivity();
    }

    //onclick NEXT GENERATION function
    public void onClickBtn1(View v)
    {   button1 = (Button) findViewById(R.id.button1);
        int [][]result= new int [12][12];

        for(int i=0; i<size; i++)
            for(int j=0; j<size; j++)
                result[i][j]=0;

        for (int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                int alive=myArr[i][j];

                int neighbor=livingNeighbor(i,j);

                if((alive==1) && (neighbor<2)){
                    result[i][j]=0;
                }
                else if((alive==1) && (neighbor>3)){
                    result[i][j]=0;
                }
                else if((alive==1) && (neighbor==3 || neighbor==2)){
                    result[i][j]=1;
                }
                else if((alive==0) && (neighbor==3)){
                    result[i][j]=1;
                }
                else
                    result[i][j]=0;
            }
        }
        //copy grid
        for(int i=0; i<size; i++)
            for(int j=0; j<size; j++)
                myArr[i][j]=result[i][j];

        //display the grid based on new array

        loadCleanActivity();

    }
    public int livingNeighbor(int row, int col)
    {   int count=0;

                //left
                if(row!=0)
                    if(myArr[row-1][col]==1)
                        count++;

                //right
                if(row !=size-1)
                    if(myArr[row+1][col]==1)
                        count++;

                //top
                if(col !=0)
                    if(myArr[row][col-1]==1)
                        count++;

                //t right
                if(row !=size-1 && col!=0)
                    if(myArr[row+1][col-1]==1)
                        count++;

                //t left
                if(row !=0 && col!=0)
                    if(myArr[row-1][col-1]==1)
                        count++;

                //bottom
                if(col!=size-1)
                    if(myArr[row][col+1]==1)
                        count++;

                //b right
                if(row !=size-1 && col!=size-1)
                    if(myArr[row+1][col+1]==1)
                        count++;

                //b left
                if(row !=0 && col!=size-1)
                    if(myArr[row-1][col+1]==1)
                        count++;

        return count;
    }
}

