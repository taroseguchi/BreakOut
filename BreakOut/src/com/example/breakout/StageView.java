package com.example.breakout;


import java.util.ArrayList;
import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class StageView extends View { 
	private	Paint p = new Paint();
	public static int drawcount = 0;
	private int w;
	private int h;
	Ball ball;
	Bar bar;
	Item item = new Item();
	ArrayList<Block> blocklist = new ArrayList<Block>();
	
	public StageView(Context context, int width, int height){
		super(context);
		bar = new Bar(width, height);
		ball = new Ball(width, height, bar);
		w = width;
		h = height;
		//ブロック配置
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < i; j++){
				Block blk = new Block(width / 2  - 30 + j * 61 + i * (-30) , 200 + i * 40 + 1);
				blocklist.add(blk);
			}
		}
	}
	
	@Override
	public void onDraw(Canvas c){
		drawcount++;
		c.drawColor(Color.WHITE);
		bar.draw(c, p);
		item.draw(c, p);
		if (item.getY() >= h - 220 && item.getY() <= h - 180){
        	if (item.getX() >= bar.getRectx() - 45 && item.getX() <= bar.getRectx() + 45){
        		item.vanishch();
        		ball.changeSpeed(20);
        	}
		}
		 for (Block b:blocklist){
			 b.draw(c, p);
			 if (b.crashcount >= 3){
				 b.vanishch();
			 }
			 ball.setBlock(b);
		 }
		ball.draw(c, p);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		bar.setRectx((int)event.getX());
		return true;
	}
}
