public class PrintLine {

	public static void setValue(boolean[][] cellAuto) {
		for (int i = 1; i < 32; i++) {
			for (int j = 0; j < 64; j++) {
				if (j == 0) {
					if (cellAuto[i - 1][j + 1] == true) {
						cellAuto[i][j] = true;
					}
				} 	
				else if (j < 63) {
					if ((cellAuto[i - 1][j - 1] == true)
							&& (cellAuto[i - 1][j + 1] == false)
							|| (cellAuto[i - 1][j - 1] == false && (cellAuto[i - 1][j + 1] == true))) {
						if (cellAuto[i - 1][j - 1] == true
								|| cellAuto[i - 1][j + 1] == true) {
							cellAuto[i][j] = true;
						}
					}
				} else if (j == 63) {
					if (cellAuto[i - 1][j - 1] == true) {
						cellAuto[i][j] = true;
					}
				}
			}
		}

	}

	public static void print(boolean[][] cellAuto) {
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < 64; j++) {
				if (cellAuto[i][j]) {
					System.out.print("*");
				} else {
					System.out.print("-");
				}
				if (j == 63) {
					System.out.println();
				}
			}
		}
	}
	
	public static void main(String args[]) {
		boolean[][] cellAuto = new boolean[32][64];
		cellAuto[0][31] = true;
		setValue(cellAuto);
		print(cellAuto);
	}	
}
