package com.mateusfreira;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class DrawView extends View implements OnTouchListener {
	private static final String TAG = "DrawView";

	List<Point> points = new ArrayList<Point>();
	List<Integer> spases = new ArrayList<Integer>();
	Paint paint = new Paint();

	public DrawView(Context context) {
		super(context);
		setFocusable(true);
		setFocusableInTouchMode(true);

		this.setOnTouchListener(this);

		paint.setColor(Color.WHITE);
		paint.setAntiAlias(true);
	}

	@Override
	public void onDraw(Canvas canvas) {
		Point previous = null;
		int i = 0;
		for (Point point : points) {

			if (previous != null && !spases.contains(i)) {
				canvas.drawLine(previous.x, previous.y, point.x, point.y, paint);
			} else {
				canvas.drawCircle(point.x, point.y, 1, paint);
			}
			previous = point;
			i++;
		}
	}

	public boolean onTouch(View view, MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_UP) {
			spases.add(points.size());
		} else {
			Point point = new Point();
			point.x = event.getX();
			point.y = event.getY();
			points.add(point);
			invalidate();
		}
		return true;
	}

	public void clear() {
		points = new ArrayList<Point>();
		invalidate();
	}
}

class Point {
	float x, y;

	@Override
	public String toString() {
		return x + ", " + y;
	}
}