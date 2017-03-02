import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
		System.out.print("\nPb2: ");
		pb2(u);
		System.out.println("\nPb3:");
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
		System.out.println("Neasociativitate adunare: ");
		System.out.println("(1 + u) + u = " + (1d + u) + u);
		System.out.println("1 + (u + u) = " + 1d + (u + u));
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
		double time1, time2, time3, time4, time5, time6;
		double timeSim1, timeSim2, timeSim3, timeSim4, timeSim5, timeSim6;

		time1 = time2 = time3 = time4 = time5 = time6 = timeSim1 = timeSim2 = timeSim3 = timeSim4 = timeSim5 = timeSim6 = 0;

		double startTime, endTime;

		m1 = m2 = m3 = m4 = m5 = m6 = 0;
		List<Double> rezultateP1 = new ArrayList<>();
		List<Double> rezultateP2 = new ArrayList<>();
		List<Double> rezultateP3 = new ArrayList<>();
		List<Double> rezultateP4 = new ArrayList<>();
		List<Double> rezultateP5 = new ArrayList<>();
		List<Double> rezultateP6 = new ArrayList<>();
		List<Double> rezultateP1opt = new ArrayList<>();
		List<Double> rezultateP2opt = new ArrayList<>();
		List<Double> rezultateP3opt = new ArrayList<>();
		List<Double> rezultateP4opt = new ArrayList<>();
		List<Double> rezultateP5opt = new ArrayList<>();
		List<Double> rezultateP6opt = new ArrayList<>();
		List<Double> sinX = new ArrayList<>();
		for (int i = 0; i < 10000; ++i) {
			x = Math.random() * (Math.PI);
			x -= Math.PI / 2d;
			sinX.add(Math.sin(x));

			// calcul polinoame
			startTime = System.currentTimeMillis();
			rezultateP1.add(x - C1 * Math.pow(x, 3) + C2 * Math.pow(x, 5));
			endTime = System.currentTimeMillis();
			time1 += endTime - startTime;

			startTime = System.currentTimeMillis();
			rezultateP2.add(x - C1 * Math.pow(x, 3) + C2 * Math.pow(x, 5) - C3 * Math.pow(x, 7));
			endTime = System.currentTimeMillis();
			time2 += endTime - startTime;

			startTime = System.currentTimeMillis();
			rezultateP3.add(x - C1 * Math.pow(x, 3) + C2 * Math.pow(x, 5) - C3 * Math.pow(x, 7) + C4 * Math.pow(x, 9));
			endTime = System.currentTimeMillis();
			time3 += endTime - startTime;

			startTime = System.currentTimeMillis();
			rezultateP4.add(x - 0.166d * Math.pow(x, 3) + 0.00833d * Math.pow(x, 5) - C3 * Math.pow(x, 7)
					+ C4 * Math.pow(x, 9));
			endTime = System.currentTimeMillis();
			time4 += endTime - startTime;

			startTime = System.currentTimeMillis();
			rezultateP5.add(x - C1 * Math.pow(x, 3) + C2 * Math.pow(x, 5) - C3 * Math.pow(x, 7) + C4 * Math.pow(x, 9)
					- C5 * Math.pow(x, 11));
			endTime = System.currentTimeMillis();
			time5 += endTime - startTime;

			startTime = System.currentTimeMillis();
			rezultateP6.add(x - C1 * Math.pow(x, 3) + C2 * Math.pow(x, 5) - C3 * Math.pow(x, 7) + C4 * Math.pow(x, 9)
					- C5 * Math.pow(x, 11) + C6 * Math.pow(x, 13));
			endTime = System.currentTimeMillis();
			time6 += endTime - startTime;

			// calcul polinoame simplificate
			Double y = Math.pow(x, 2);

			startTime = System.currentTimeMillis();
			rezultateP1opt.add(x * (1 + y * (-C1 + C2 * y)));
			endTime = System.currentTimeMillis();
			timeSim1 += endTime - startTime;

			startTime = System.currentTimeMillis();
			rezultateP2opt.add(x * (1 + y * (-C1 + y * (C2 - C3 * y))));
			endTime = System.currentTimeMillis();
			timeSim2 += endTime - startTime;

			startTime = System.currentTimeMillis();
			rezultateP3opt.add(x * (1 + y * (-C1 + y * (C2 + y * (-C3 + C4 * y)))));
			endTime = System.currentTimeMillis();
			timeSim3 += endTime - startTime;

			startTime = System.currentTimeMillis();
			rezultateP4opt.add(x * (1 + y * (-0.166d + y * (0.00833d + y * (-C3 + C4 * y)))));
			endTime = System.currentTimeMillis();
			timeSim4 += endTime - startTime;

			startTime = System.currentTimeMillis();
			rezultateP5opt.add(x * (1 + y * (-C1 + y * (C2 + y * (-C3 + y * (C4 - C5 * y))))));
			endTime = System.currentTimeMillis();
			timeSim5 += endTime - startTime;

			startTime = System.currentTimeMillis();
			rezultateP6opt.add(x * (1 + y * (-C1 + y * (C2 + y * (-C3 + y * (C4 + y * (-C5 + C6 * y)))))));
			endTime = System.currentTimeMillis();
			timeSim6 += endTime - startTime;

		}
		Double mo1, mo2, mo3, mo4, mo5, mo6;
		mo1 = mo2 = mo3 = mo4 = mo5 = mo6 = 0d;

		for (int i = 0; i < 10000; ++i) {
			m1 += Math.abs(rezultateP1.get(i) - sinX.get(i));
			m2 += Math.abs(rezultateP2.get(i) - sinX.get(i));
			m3 += Math.abs(rezultateP3.get(i) - sinX.get(i));
			m4 += Math.abs(rezultateP4.get(i) - sinX.get(i));
			m5 += Math.abs(rezultateP5.get(i) - sinX.get(i));
			m6 += Math.abs(rezultateP6.get(i) - sinX.get(i));

			mo1 += Math.abs(rezultateP1opt.get(i) - sinX.get(i));
			mo2 += Math.abs(rezultateP2opt.get(i) - sinX.get(i));
			mo3 += Math.abs(rezultateP3opt.get(i) - sinX.get(i));
			mo4 += Math.abs(rezultateP4opt.get(i) - sinX.get(i));
			mo5 += Math.abs(rezultateP5opt.get(i) - sinX.get(i));
			mo6 += Math.abs(rezultateP6opt.get(i) - sinX.get(i));
		}

		Map<String, Double> erori = new LinkedHashMap<>();
		erori.put("P1", m1);
		erori.put("P2", m2);
		erori.put("P3", m3);
		erori.put("P4", m4);
		erori.put("P5", m5);
		erori.put("P6", m6);

		erori = MapUtil.sortByValue(erori);
		
		System.out.println("Eroare cumulata rez P1 = " + m1 + " |---| Eroare cumulata rez P1 simplificat = " + mo1
				+ "\n\tSimplificat e mai bun = " + (mo1 < m1));
		System.out.println("Eroare cumulata rez P2 = " + m2 + " |---| Eroare cumulata rez P2 simplificat = " + mo2
				+ "\n\tSimplificat e mai bun = " + (mo2 < m2));
		System.out.println("Eroare cumulata rez P3 = " + m3 + " |---| Eroare cumulata rez P3 simplificat = " + mo3
				+ "\n\tSimplificat e mai bun = " + (mo3 < m3));
		System.out.println("Eroare cumulata rez P4 = " + m4 + " |---| Eroare cumulata rez P4 simplificat = " + mo4
				+ "\n\tSimplificat e mai bun = " + (mo4 < m4));
		System.out.println("Eroare cumulata rez P5 = " + m5 + " |---| Eroare cumulata rez P5 simplificat = " + mo5
				+ "\n\tSimplificat e mai bun = " + (mo5 < m5));
		System.out.println("Eroare cumulata rez P6 = " + m6 + " |---| Eroare cumulata rez P6 simplificat = " + mo6
				+ "\n\tSimplificat e mai bun = " + (mo6 < m6));
		
		System.out.println("\nTimp executie P1 = " + time1 + " |---| Timp executie P1 simplificat = " + timeSim1);
		System.out.println("Timp executie P2 = " + time2 + " |---| Timp executie P2 simplificat = " + timeSim2);
		System.out.println("Timp executie P3 = " + time3 + " |---| Timp executie P3 simplificat = " + timeSim3);
		System.out.println("Timp executie P4 = " + time4 + " |---| Timp executie P4 simplificat = " + timeSim4);
		System.out.println("Timp executie P5 = " + time5 + " |---| Timp executie P5 simplificat = " + timeSim5);
		System.out.println("Timp executie P6 = " + time6 + " |---| Timp executie P6 simplificat = " + timeSim6);
		System.out.println("Timp total = " + (time1 + time2 + time3 + time4 + time5 + time6));
		System.out.println("Timp total polinoame simplificate = " + (timeSim1 + timeSim2 + timeSim3 + timeSim4 + timeSim5 + timeSim6) + '\n');

		for (Map.Entry<String, Double> entry : erori.entrySet()){
		    System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		
	}
}
