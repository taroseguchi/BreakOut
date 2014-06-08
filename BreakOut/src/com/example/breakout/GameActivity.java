package com.example.breakout;

import java.util.Timer;
import java.util.TimerTask;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class GameActivity extends ActionBarActivity {
		View view;
		// ハンドラを作成
		private Handler handler = new Handler();
		// ビューの再描画間隔(ミリ秒)
		private final static long INTERVAL_TIME = 10;
		
    	@Override
    	protected void onCreate(Bundle savedInstanceState) {
    		super.onCreate(savedInstanceState);
    		WindowManager wm = (WindowManager)getSystemService(WINDOW_SERVICE);
  // ディスプレイのインスタンス生成
    		Display disp = wm.getDefaultDisplay();
    		Point size = new Point();
    		disp.getSize(size);
    		view = new StageView(this, size.x, size.y);
    		setContentView(view);

    		// ビュー再描画タイマー
    		// タイマーを作成
    		Timer timer = new Timer(false);
    		// 「INTERVAL_TIME」ミリ秒おきにタスク(TimerTask)を実行
    	    timer.schedule(new TimerTask(){
    	    	public void run(){
    	    		handler.post(new Runnable(){
    	    			public void run(){
    	    				// ビューを再描画
    	    				view.invalidate();
    	    			}});
    	    	}
    	    }, 0, INTERVAL_TIME);
    	}
}

//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.container, new PlaceholderFragment())
//                    .commit();
//        }
    


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.game, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    /**
//     * A placeholder fragment containing a simple view.
//     */
//    public static class PlaceholderFragment extends Fragment {
//
//        public PlaceholderFragment() {
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.fragment_game, container, false);
//            return rootView;
//        }
//    }
//
//}
