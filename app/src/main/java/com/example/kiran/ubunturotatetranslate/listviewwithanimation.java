package com.example.kiran.ubunturotatetranslate;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kiran on 27-11-2015.
 */
public class listviewwithanimation extends Activity
{
    private ListView listView;
    private DisplayMetrics displayMetrics;
    private int mode=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewwithanimation);
        displayMetrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        listView=(ListView)findViewById(R.id.LView_with_animation);
        /*Set the size of the faded edge used to indicate that more content in this view is available.*/
        ArrayList<String> Listviewdata=new ArrayList<String>();
        for(int i=0;i<300;i++)
        {
            Listviewdata.add("item "+i);
        }
        MainAdapter a=new MainAdapter(this,Listviewdata,displayMetrics);
        listView.setAdapter(a);
//        listView.setFadingEdgeLength(100);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean result=super.onCreateOptionsMenu(menu);
        menu.add(Menu.NONE,1,0,"TranslateAnimatin1");
        menu.add(Menu.NONE,2,0,"TranslateAnimatin2");
        menu.add(Menu.NONE,3,0,"scaleAnimatin");
        menu.add(Menu.NONE,4,0,"fadeAnimatin");
        menu.add(Menu.NONE,5,0,"hyperspacein");
        menu.add(Menu.NONE,6,0,"hypperspaceout");
        menu.add(Menu.NONE,7,0,"WaveScale");
        menu.add(Menu.NONE,8,0,"pushleftin");
        menu.add(Menu.NONE,9,0,"pushleftout");
        menu.add(Menu.NONE,10,0,"pushupin");
        menu.add(Menu.NONE,11,0,"pushupout");
        menu.add(Menu.NONE,12,0,"shake");
        return(result);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mode=item.getItemId();
        return super.onOptionsItemSelected(item);
    }
    public class MainAdapter extends BaseAdapter
    {
        private Context context;
        private ArrayList<String> string=new ArrayList<String>();
        private DisplayMetrics displayMetrics;
        class Holder
        {
             TextView textView;
        }
        public MainAdapter(Context context,ArrayList<String> arrayList,DisplayMetrics displayMetrics)
        {
            this.context=context;
            this.string=arrayList;
            this.displayMetrics=displayMetrics;

        }

        @Override
        public int getCount() {
            return string.size();
        }

        @Override
        public Object getItem(int position) {
            return string.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
             Holder holder;
            if(convertView==null)
            {
                convertView=LayoutInflater.from(context).inflate(R.layout.custom, parent, false);
//                convertView.setBackgroundColor(0xFF202020);
                holder=new Holder();
                holder.textView=(TextView)convertView.findViewById(R.id.tv_lanimation);
                convertView.setTag(holder);
            }/*if*/
            else
            {
                holder=(Holder)convertView.getTag();
            }
            holder.textView.setText(string.get(position));
            Animation animation=null;
            switch (mode)
            {
                case 1:
                { animation=new TranslateAnimation(displayMetrics.widthPixels/2,0,0,0);}
                    break;
                case 2:
                    animation=new TranslateAnimation(0,0,displayMetrics.heightPixels,0);
                    break;
                case 3:
                    animation=new ScaleAnimation((float)1.0,(float)1.0,(float)0.0,(float)1.0);
                    break;
                case 4:
                    animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
                    break;
                case 5:
                    animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.hyperspaceout);
                    break;
                case 6:
                    animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.wavescale);
                    break;
                case 7:
                    animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.pushleftin);
                    break;
                case 8:
                    animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.pushleftout);
                    break;
                case 9:
                    animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.pushupin);
                    break;
                case 10:
                    animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.pushupout);
                    break;
                case 11:
                    animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.shape);
                    break;
            }/*switch*/
            animation.setDuration(500);
            convertView.startAnimation(animation);
            return convertView;
        }
    }
}
