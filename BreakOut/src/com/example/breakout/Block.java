package com.example.breakout;


import java.util.Random;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;


public class Block{
	private int blx;
	private int bly;
	private Random rnd = new Random();
	int crashcount = rnd.nextInt(3);
	private boolean vanish = false;
	
	public Block(int x, int y){
		blx = x;
		bly = y;
	}

	public void draw(Canvas c, Paint p){
		if (crashcount == 0)p.setColor(Color.BLACK);
		if (crashcount == 1)p.setColor(Color.GRAY);
		if (crashcount == 2)p.setColor(Color.YELLOW);
		if (vanish) p.setColor(Color.WHITE);
		//ブロックの縦40, 横60
		c.drawRect(blx, bly, blx + 60, bly + 40, p);
	}


	public boolean crashOrnot(int bx, int by){
		
		if ((bx >= blx && bx <= blx + 60) && (by >= bly && by <= bly + 40) && !vanish){
			crashcount++;
			return true;
		}else
			return false;
		
//		if ((bx >= blx && bx <= blx + 60) && (by + 20 == bly || by + 20 == bly + 40) && !vanish){//上下からブロックにぶつかる
//			crashcount++;
//			return 1;
//		}else if ((by >= blx && by <= blx + 40) && (bx + 20 == blx || bx + 20 == blx + 60) && !vanish){//左右からブロックにぶつかる
//			crashcount++;
//			return 2;
//		}else return 0;
	}

	public void vanishch(){
		vanish = true;
	}

}
