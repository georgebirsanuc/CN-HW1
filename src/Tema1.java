import java.util.ArrayList;
import java.util.List;

import sun.dc.pr.Rasterizer;

public class Tema1 {

	static final double C1 = 0.16666666666666666666666666666667;
	static final double C2 = 0.00833333333333333333333333333333;
	static final double C3 = 1.984126984126984126984126984127 * Math.pow(10, -4);
	static final double C4 = 2.7557319223985890652557319223986 * Math.pow(10, -6);
	static final double C5 = 2.5052108385441718775052108385442 * Math.pow(10, -8);
	static final double C6 = 1.6059043836821614599392377170155 * Math.pow(10, -10);

	public static void main(String[] args) {
		double u = pb1();
		System.out.println("Pb1: u = " + u);
		System.out.print("Pb2: ");
		pb2(u);
		pb3();
	}

	static double pb1() {
		double u, p = -1;

		do {
			u = Math.pow(10, p);
			p--;
		} while (1d + u != 1d);

		return u;
	}

	static void pb2(double u) {
		// System.out.println((1d + u) + u);
		// System.out.println(1d + (u + u));
		double x, y, z, p1, p2;
		do {
			x = Math.random();
			y = Math.random();
			z = Math.random();
			p1 = (x * y) * z;
			p2 = x * (y * z);
		} while (p1 == p2);

		System.out.println("x = " + x + " y = " + y + " z = " + z);
		System.out.println("Prod1 = " + p1 + " Prod2 = " + p2);
	}

	static void pb3() {
		// (Math.random() * (upper - lower)) + lower;
		double x, m1, m2, m3, m4, m5, m6;
		m1 = m2 = m3 = m4 = m5 = m6 = 0;
		List<Double> rezultateP1 = new ArrayList<>();
		List<Double> rezultateP2 = new ArrayList<>();
		List<Double> rezultateP3 = new ArrayList<>();
		List<Double> rezultateP4 = new ArrayList<>();
		List<Double> rezultateP5 = new ArrayList<>();
		List<Double> rezultateP6 = new ArrayList<>();
		List<Double> sinX = new ArrayList<>();
		for (int i = 0; i < 10000; ++i) {
			x = Math.random() * (Math.PI);
			x -= Math.PI / 2d;
			sinX.add(Math.sin(x));
			rezultateP1.add(x - C1 * Math.pow(x, 3) + C2 * Math.pow(x, 5));
			rezultateP2.add(x - C1 * Math.pow(x, 3) + C2 * Math.pow(x, 5) + C3 * Math.pow(x, 7));
			rezultateP3.add(x - C1 * Math.pow(x, 3) + C2 * Math.pow(x, 5) + C3 * Math.pow(x, 7) + C4 * Math.pow(x, 9));
			rezultateP4.add(x - 0.166d * Math.pow(x, 3) + 0.00833d * Math.pow(x, 5) + C3 * Math.pow(x, 7)
					+ C4 * Math.pow(x, 9));
			rezultateP5.add(x - C1 * Math.pow(x, 3) + C2 * Math.pow(x, 5) + C3 * Math.pow(x, 7) + C4 * Math.pow(x, 9)
					+ C5 * Math.pow(x, 11));
			rezultateP6.add(x - C1 * Math.pow(x, 3) + C2 * Math.pow(x, 5) + C3 * Math.pow(x, 7) + C4 * Math.pow(x, 9)
					+ C5 * Math.pow(x, 11) + C6 * Math.pow(x, 13));
		}
		for (int i = 0; i < 10000; ++i){
			m1 += Math.abs(rezultateP1.get(i) - sinX.get(i));
			m2 += Math.abs(rezultateP2.get(i) - sinX.get(i));
			m3 += Math.abs(rezultateP3.get(i) - sinX.get(i));
			m4 += Math.abs(rezultateP4.get(i) - sinX.get(i));
			m5 += Math.abs(rezultateP5.get(i) - sinX.get(i));
			m6 += Math.abs(rezultateP6.get(i) - sinX.get(i));
		}
		m1 /= 10000;
		m2 /= 10000;
		m3 /= 10000;
		m4 /= 10000;
		m5 /= 10000;
		m6 /= 10000;
		System.out.println("Media rez P1 = " + m1);
		System.out.println("Media rez P2 = " + m2);
		System.out.println("Media rez P3 = " + m3);
		System.out.println("Media rez P4 = " + m4);
		System.out.println("Media rez P5 = " + m5);
		System.out.println("Media rez P6 = " + m6);
	}
}
