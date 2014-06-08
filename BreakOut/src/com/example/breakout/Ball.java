package com.example.breakout;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

public class Ball{
	private int stagewidth;
	private int stageheight;
	private Bar bar;
	private int		bx = 200;
	private int		by = 200;
	private static int speed = 5;
	private	int 		dx = speed;
	private	int 		dy = speed;
	private static int margin = 20;
	private Block block;

	
	public Ball(int width, int height, Bar b){
		stagewidth = width;
		stageheight = height;
		bar = b;
	}
	
	public void draw(Canvas c, Paint p){
		p.setColor(Color.RED);
		c.drawCircle(bx, by, 20, p);

		/* 左端、右端、上端、下端に来たときの処理 */
		/* 左端に来たら反転 */
		 if (bx < 0 + margin ) {
	            dx *= -1;
	        }
	        /* 右端に来たら反転 */
	        if (bx > stagewidth - margin) {
	            dx *= -1;
	        }
	        /* 上端に来たら反転 */
	        if (by < 0 + margin) {
	            dy *= -1;
	        }		
	        /* 右端に来たら反転 */
	        if (by  > stageheight - margin) {
	            dy *= -1;
	        }                
	        bx = bx + dx;
	        by = by + dy; 
	        
	        //barとの接触判定
	        if (by >= stageheight - 220 && by <= stageheight - 180){
	        	if (bx > bar.getRectx() - 45 && bx < bar.getRectx() + 45)
	        		dy = -1 * speed;
	        	if (bx <= bar.getRectx() - 45 && bx >= bar.getRectx() - 55){
	        		dy = -1 * speed;
	        		dx = -1 * speed;
	        	}
	        	if(bx >= bar.getRectx() + 45 && bx <= bar.getRectx() + 55){
	        		dy = -1 * speed;
	        		dx = speed;
	        	}
	        }
	}
	
	public void setBlock(Block b){
		block = b;
		if(block.crashOrnot(bx, by)) dy *= -1;
	}
	
	public void changeSpeed(int s){
		speed = s;
		if (dx > 0) dx = speed;
		else dx = -1 * speed;
		if (dy > 0) dy = speed;
		else dy = -1 * speed;
		bx = bx + dx;
	    by = by + dy;
	}
}
