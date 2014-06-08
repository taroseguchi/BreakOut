package com.example.breakout;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

public class Bar {
	private int rectx = 400;
	private int length = 100;
	private int stagewidth;
	private int stageheight;

	public Bar(int width, int height){
		stagewidth = width;
		stageheight = height;
	}
	
	public void draw(Canvas c, Paint p){
		p.setColor(Color.BLACK);
		c.drawRect(rectx - length / 2, stageheight - 200, rectx + length / 2, stageheight - 180, p);
	}
	
	//クリックされた位置を取得
	public void setRectx(int x){rectx = x;};
	
	public int getRectx(){return rectx;};
}
